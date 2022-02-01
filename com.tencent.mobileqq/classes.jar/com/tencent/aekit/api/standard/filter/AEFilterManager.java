package com.tencent.aekit.api.standard.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.ARDetect.ARDetectDataManager;
import com.tencent.aekit.api.standard.ai.AEDetector;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.api.supplement.filter.AEDenoiseFilter;
import com.tencent.aekit.api.supplement.filter.AESegmentForQQ;
import com.tencent.aekit.openrender.AEDebugConfig;
import com.tencent.aekit.openrender.AEFilterChain;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.IAEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.camerasdk.avreport.PreviewPerformanceInfo;
import com.tencent.ttpic.audio.AudioDataManager;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.filter.aifilter.AIImageFilterResult;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter.AdjustLutListener;
import com.tencent.ttpic.model.ArFrameInfo;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.offlineset.beans.FilterConfigBean.FilterParam;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.PTGenderAttr;
import com.tencent.ttpic.openapi.PTGenderAttr.GenderInfo;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.AdjustRealConfig.TYPE;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.filter.FaceColorCombineFilter;
import com.tencent.ttpic.openapi.filter.FaceFeatureParam;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.listener.IDetectorSettingListener;
import com.tencent.ttpic.openapi.listener.MaterialLoadFinishListener;
import com.tencent.ttpic.openapi.manager.FaceBeautyManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.plugin.AICtrl;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.HairSegmentInitializer;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.PTHairSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.PTSkySegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.SkySegmentInitializer;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.LIPS_SEG_TPYE;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.vbox.VboxFactory;
import com.tencent.vbox.decode.VboxDecoder;
import com.tencent.vbox.util.VideoUtil;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class AEFilterManager
{
  private static List<Integer> FilterTypeRunWithDetector = new ArrayList();
  private static final int MAX_RENDER_LENGTH_FOR_STROKE = 1080;
  private static final int MIN_RENDER_LENGTH_FOR_STROKE = 640;
  private static final SizeI NET_SIZE = new SizeI(320, 320);
  public static final String SET_AEPROFILER_OBJ = "SET_AEPROFILER_OBJ";
  public static final String SET_ENABLE_ASYNC_INIT_FILTERS = "SET_ENABLE_ASYNC_INIT_FILTERS";
  public static final String SET_ENABLE_SKIP_BEAUTY = "SET_ENABLE_SKIP_BEAUTY";
  public static final String SET_ENDURANCE_TIME = "SET_ENDURANCE_TIME";
  public static final String SET_FILTERS_INITED_FIRST_FRAME = "SET_FILTERS_INITED_FIRST_FRAME";
  public static final String SET_FILTERS_INIT_PRIORITY = "SET_FILTERS_INIT_PRIORITY";
  public static final String SET_INIT_STICKERS = "SET_INIT_STICKERS";
  private static final String TAG = "AEFilterManager";
  private static final String TEST_PIC = "sample_input_16_9_1080.jpg";
  public static int colorfulness;
  public static int contrast;
  public static String curLabel = NewEnhanceCategories.COMMON.serverLabel;
  public static int lightness;
  public static List<AIImageFilterResult> mAIFilterConfigList;
  public static String mVideoFilterName;
  public static int overexposure;
  public static int saturation;
  public static int sharpness;
  public static int temperature;
  public static int underexposure;
  private int FACE_DETECT_WIDTH = 180;
  private Vector<Integer> FILTERS_PRIORITY_ORDER;
  private final boolean NOT_NEED_TRANSFORM;
  private float adjustAlpha;
  private PhotoAIFilter.AdjustLutListener adjustLutListener = null;
  private HashMap<String, String> adjustParams;
  private int beautyColorTone;
  private int beautyContrastRatio;
  private int beautyEyeLighten;
  private float beautyNormalAlpha;
  private int beautyRemovePounch;
  private int beautyRemoveWrinkles;
  private int beautyRemoveWrinkles2;
  private int beautySkinLevel;
  private int beautyToothWhiten;
  private boolean beginVideoCodeProgress;
  private boolean closeAIBeautyConfig;
  private int colorTemperature;
  private int compareLevel;
  private int cosmeticsAlpha;
  private int decodeTexture;
  private int encodeTexture;
  private int exposureValue = 50;
  private String faceBeautyVersion = AEFaceBeauty.class.getName();
  private int fadeLevel;
  private HashMap<Integer, Boolean> filterConfigMap = new HashMap();
  private boolean filterInSmooth = false;
  private boolean forceFaceDetect = true;
  private float glowAlpha;
  private volatile boolean hasApplyPTFaceTransform = false;
  private int height;
  private int hightLightLevel;
  private ArrayList<RedPacketPosition> hotAreaPositions;
  private boolean isAfterUpdateMaterial;
  private boolean isClearMaskImgs;
  private boolean isCyberpunkFaceAttrSet = false;
  private boolean isLowLightEnv = false;
  private boolean isNeedPictureTest;
  private boolean isNeedSkipFrame;
  private boolean isOverallSmooth = false;
  private boolean isVeryLowEndDevice = false;
  private int lightnessLevel;
  private int longLeg;
  private float lookupLevel = 1.0F;
  private AEDetector mAEDetector;
  private AEFilterChain mAEFilterChain;
  private IAEProfiler mAEProfiler;
  private AESegmentForQQ mAESegment;
  private AIBeautyParamsJsonBean mAIBeautyParamsJsonBean;
  private boolean mAIBeautyValid;
  private List<AEChainI> mAIFilterList;
  private AEAdjust mAdjust;
  private AIAttr mAiAttr = null;
  private AICtrl mAiCtrl = new AICtrl();
  private AIParam mAiParam = new AIParam();
  private boolean mAllMustFiltsInited = false;
  private boolean mAsyncInitFilters;
  private int mCameraIndex;
  private AEDenoiseFilter mDenoiseFilter;
  private volatile boolean mDestroyed;
  private IDetectorSettingListener mDetectorDisableListener = new AEFilterManager.1(this);
  private HashMap<AEDetectorType, Boolean> mDetectorMap = new HashMap();
  private List<Integer> mDisableFilters;
  private boolean mEnableComparison = false;
  private HashMap<String, Boolean> mEnableDetectorHM;
  private int mEnduranceTime = -1;
  private FaceColorCombineFilter mFaceColorCombineFilter;
  private double mFaceDetectScale = 0.16666667163372D;
  private AEFaceLine mFaceLine;
  private Map<Integer, Boolean> mFilterEnableMap = new LinkedHashMap();
  private List<Integer> mFilterOrderList = new ArrayList();
  private AEFiltersMustInitedSetting mFiltersMustInitedSetting;
  private int mFrameIndex;
  private AEGlow mGlow;
  private volatile boolean mHasSubmitCreatePTFaceTransform = false;
  private boolean mIsInited = false;
  private float mLightSensorBrightness = 10.0F;
  private boolean mLogFlag = false;
  private String mLutPath;
  private boolean mNeedAgeDetect = false;
  private boolean mNeedBodyDetect = false;
  private boolean mNeedGenderDetect = false;
  private boolean mNeedResetGender = true;
  private AEBodyBeauty mPTBodyBeauty;
  private AEFilterGallery mPTEffectFilter;
  private AEFaceBeautyBase mPTFaceBeauty;
  private volatile AEFaceTransform mPTFaceTransform;
  private AELight mPTLight;
  private AESmooth mPTSmooth;
  private AESmoothPrev3 mPTSmoothPrev3;
  private AESticker mPTSticker;
  private float mPhoneRoll;
  private PhotoAIFilter mPhotoAIFilter;
  private Bitmap mPickUpBitmap;
  private List<Bitmap> mPickUpBitmapList;
  private Bitmap mTestBmp;
  private VideoMaterial mVideoMaterial;
  private double mViewAspectRatio;
  private MaterialLoadFinishListener materialLoadFinishListener;
  private boolean needAIDetect = true;
  private boolean needFaceDetect = false;
  private boolean needUpdateAIFilter;
  private int outputTexture;
  private int phoneRotation;
  private boolean pointUpdate = false;
  private PTFaceAttr ptFaceAttr;
  private ImageStatisticsData resultData;
  private float[] rotationMatrix;
  private int saturationLevel;
  private float[] segBgColor;
  private float[] segStrokeColor;
  private float segStrokeGapInPixel;
  private float segStrokeWidthInPixel;
  private int segmentFrames;
  private int shadowLevel;
  private int sharpLevel;
  private int slimWaist;
  private List<Bitmap> smartBitmapList;
  private int smoothLevel;
  private int smoothSharpenHeight;
  private float smoothSharpenStrength;
  private int smoothSharpenWidth;
  private AEFilterManager.StickerInnerEffectFilterListener stickerInnerLutFilterListener = null;
  private boolean stickerPause;
  private boolean stickerReset;
  private boolean stickerResume;
  private int[] testBmpTexture;
  private int[] textures = new int[1];
  private int thinBody;
  private int thinShoulder;
  private int transBasic3;
  private int transBasic4;
  private int transCheekboneThin;
  private int transChin;
  private int transEye;
  private int transEyeAngle;
  private int transEyeDistance;
  private int transFaceShorten;
  private int transFaceThin;
  private int transFaceV;
  private int transForehead;
  private int transLipsThickness;
  private int transLipsWidth;
  private int transMouthShape;
  private int transNose;
  private int transNosePosition;
  private int transNoseWing;
  private int width;
  
  static
  {
    FilterTypeRunWithDetector.add(Integer.valueOf(101));
    FilterTypeRunWithDetector.add(Integer.valueOf(102));
    FilterTypeRunWithDetector.add(Integer.valueOf(103));
    FilterTypeRunWithDetector.add(Integer.valueOf(104));
    FilterTypeRunWithDetector.add(Integer.valueOf(105));
    FilterTypeRunWithDetector.add(Integer.valueOf(110));
    FilterTypeRunWithDetector.add(Integer.valueOf(111));
    FilterTypeRunWithDetector.add(Integer.valueOf(113));
    FilterTypeRunWithDetector.add(Integer.valueOf(114));
    FilterTypeRunWithDetector.add(Integer.valueOf(115));
    FilterTypeRunWithDetector.add(Integer.valueOf(117));
    FilterTypeRunWithDetector.add(Integer.valueOf(119));
  }
  
  public AEFilterManager()
  {
    if ((Build.MODEL.equals("MI 9")) && (Build.BRAND.equals("Xiaomi"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.NOT_NEED_TRANSFORM = bool;
      this.isNeedPictureTest = false;
      this.testBmpTexture = new int[1];
      this.mTestBmp = null;
      this.closeAIBeautyConfig = false;
      this.mAIBeautyValid = true;
      this.mAIBeautyParamsJsonBean = null;
      this.mPickUpBitmapList = new ArrayList();
      this.smartBitmapList = new ArrayList();
      this.mFrameIndex = 0;
      this.beginVideoCodeProgress = false;
      this.isNeedSkipFrame = false;
      this.isClearMaskImgs = false;
      this.isAfterUpdateMaterial = false;
      this.mAEProfiler = AEProfiler.getInstance();
      this.hotAreaPositions = new ArrayList();
      this.mAsyncInitFilters = false;
      this.mDestroyed = false;
      this.needUpdateAIFilter = true;
      this.segmentFrames = 0;
      this.smoothLevel = 0;
      this.smoothSharpenStrength = 1.2F;
      this.beautyColorTone = 50;
      this.cosmeticsAlpha = 100;
      this.adjustAlpha = 1.0F;
      this.lightnessLevel = 0;
      this.hightLightLevel = 0;
      this.shadowLevel = 0;
      this.compareLevel = 0;
      this.sharpLevel = 0;
      this.saturationLevel = 0;
      this.colorTemperature = 0;
      this.fadeLevel = 0;
      this.segStrokeColor = new float[] { 1.0F, 1.0F, 1.0F, 1.0F };
      this.segBgColor = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      this.rotationMatrix = new float[16];
      disableAllFilters();
      setDefaultOrder();
      VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
      this.mAEFilterChain = new AEFilterChain();
      if (this.needAIDetect) {
        this.mAEDetector = new AEDetector();
      }
      if (!FeatureManager.Features.MASK_IMAGES.isFunctionReady())
      {
        FeatureManager.Features.MASK_IMAGES.init();
        this.isClearMaskImgs = true;
      }
      initDefaultFiltersPriority();
      return;
    }
  }
  
  private int addTypeInOrderArray(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramArrayOfInt == null) {
      return paramInt2;
    }
    if ((this.mFiltersMustInitedSetting != null) && (this.mFiltersMustInitedSetting.isContainType(paramInt1)))
    {
      shiftRightArray(paramArrayOfInt, paramInt2, 1);
      paramArrayOfInt[0] = paramInt1;
    }
    int i;
    for (paramInt1 = paramInt2 + 1;; paramInt1 = i)
    {
      return paramInt1;
      i = paramInt2 + 1;
      paramArrayOfInt[paramInt2] = paramInt1;
    }
  }
  
  private void assembleFilters(List<FilterConfigBean.FilterParam> paramList)
  {
    if ((paramList == null) && (paramList.size() == 0)) {}
    FilterConfigBean.FilterParam localFilterParam;
    String str;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localFilterParam = (FilterConfigBean.FilterParam)paramList.next();
      str = localFilterParam.filterID;
    } while ((localFilterParam == null) || (TextUtils.isEmpty(localFilterParam.filterID)));
    label100:
    int i;
    switch (str.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label102:
        i = -1;
      }
      break;
    }
    while (i != -1)
    {
      if (this.mDisableFilters == null) {
        this.mDisableFilters = new ArrayList();
      }
      if (localFilterParam.disable != 1) {
        break;
      }
      switchFilterOn(i, false);
      this.mDisableFilters.add(Integer.valueOf(i));
      break;
      if (!str.equals("beauty")) {
        break label100;
      }
      i = 0;
      break label102;
      if (!str.equals("mesh")) {
        break label100;
      }
      i = 1;
      break label102;
      if (!str.equals("smooth")) {
        break label100;
      }
      i = 2;
      break label102;
      i = 104;
      continue;
      i = 105;
      continue;
      localFilterParam.strength = Math.min(Math.max(localFilterParam.strength, 0.0F), 1.0F);
      this.smoothLevel = Float.valueOf(localFilterParam.strength * 60.0F).intValue();
      this.filterConfigMap.put(Integer.valueOf(101), Boolean.valueOf(true));
      i = 101;
    }
  }
  
  private void chainFilters()
  {
    if (this.mAEProfiler != null) {
      this.mAEProfiler.startByTag("IAEProfiler-chainFilters");
    }
    this.mAEFilterChain.clearFilterList();
    Iterator localIterator = this.mFilterOrderList.iterator();
    Object localObject;
    boolean bool;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (((Boolean)this.mFilterEnableMap.get(Integer.valueOf(i))).booleanValue()) {
          switch (i)
          {
          case 109: 
          case 112: 
          default: 
            break;
          case 101: 
            if (this.mPTSmooth != null) {
              this.mAEFilterChain.add(this.mPTSmooth);
            }
            break;
          case 102: 
            if ((this.mPTSticker != null) && (this.mVideoMaterial != null) && (this.segmentFrames > 1))
            {
              this.mAEFilterChain.add(this.mPTSticker.getBeforeTransFilter());
              this.mPTSticker.updateCosAlpha(this.cosmeticsAlpha);
              if (this.mPTSticker.isUseStickerPlugin()) {
                this.mPTSticker.setPTFaceTransform(this.mPTFaceTransform);
              }
            }
            break;
          case 103: 
            if ((this.mPTSticker != null) && (this.mVideoMaterial != null) && (!this.mPTSticker.isUseStickerPlugin()) && (this.segmentFrames > 1))
            {
              this.mAEFilterChain.add(this.mPTSticker.getAfterTransFilter());
              this.mPTSticker.updateCosAlpha(this.cosmeticsAlpha);
            }
            break;
          case 104: 
            if (this.mPTFaceBeauty != null) {
              this.mAEFilterChain.add(this.mPTFaceBeauty);
            }
            break;
          case 117: 
            if (this.mPhotoAIFilter != null) {
              this.mAEFilterChain.add(this.mPhotoAIFilter);
            }
            break;
          case 110: 
            if (this.mPTSmoothPrev3 != null) {
              this.mAEFilterChain.add(this.mPTSmoothPrev3);
            }
            break;
          case 106: 
            if ((this.mPTEffectFilter != null) && (this.mLutPath != null)) {
              this.mAEFilterChain.add(this.mPTEffectFilter);
            }
            break;
          case 113: 
            if (this.mPTLight != null) {
              this.mAEFilterChain.add(this.mPTLight);
            }
            break;
          case 105: 
            if ((this.mPTFaceTransform != null) && (this.hasApplyPTFaceTransform) && (!this.NOT_NEED_TRANSFORM) && ((this.mPTSticker == null) || (!this.mPTSticker.isUseStickerPlugin()) || ((this.mPTSticker.isUseStickerPlugin()) && (this.segmentFrames <= 1)))) {
              this.mAEFilterChain.add(this.mPTFaceTransform);
            }
            break;
          case 107: 
            if (this.mFaceColorCombineFilter != null) {
              this.mAEFilterChain.add(this.mFaceColorCombineFilter);
            }
            break;
          case 108: 
            if (this.mDenoiseFilter != null) {
              this.mAEFilterChain.add(this.mDenoiseFilter);
            }
            break;
          case 111: 
            if (this.mAiAttr == null) {
              break label820;
            }
            localObject = (PTFaceAttr)this.mAiAttr.getRealtimeData(AEDetectorType.FACE.value);
            if (localObject == null) {
              break label820;
            }
            if (((PTFaceAttr)localObject).getFaceCount() > 0) {
              bool = true;
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      LogUtils.d("AEFilterManager", "[chainFilters] is SEGMENT, hasFace = " + bool);
      if ((this.mAESegment == null) || (!bool) || (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))) {
        break;
      }
      this.mAEFilterChain.add(this.mAESegment);
      LogUtils.d("AEFilterManager", "[chainFilters] is SEGMENT, add AESegmentForQQ");
      break;
      bool = false;
      continue;
      if (this.mFaceLine == null) {
        break;
      }
      this.mAEFilterChain.add(this.mFaceLine);
      break;
      if (this.mPTBodyBeauty == null) {
        break;
      }
      this.mAEFilterChain.add(this.mPTBodyBeauty);
      break;
      if (this.mAdjust == null) {
        break;
      }
      this.mAEFilterChain.add(this.mAdjust);
      break;
      if (this.mAIFilterList == null) {
        break;
      }
      localObject = this.mAIFilterList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AEChainI localAEChainI = (AEChainI)((Iterator)localObject).next();
        this.mAEFilterChain.add(localAEChainI);
      }
      if (this.mGlow == null) {
        break;
      }
      this.mAEFilterChain.add(this.mGlow);
      break;
      if (this.mAEProfiler != null) {
        this.mAEProfiler.endByTag("IAEProfiler-chainFilters");
      }
      return;
      label820:
      bool = false;
    }
  }
  
  private int changeTextureIfNeed(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {}
    int i;
    do
    {
      return paramInt;
      if (this.mTestBmp == null) {
        this.mTestBmp = decodeBitmap("sample_input_16_9_1080.jpg");
      }
      i = getBmpToTextue(this.mTestBmp);
    } while (i == -1);
    return i;
  }
  
  private int[] checkFilterInitOrder(int... paramVarArgs)
  {
    if ((this.FILTERS_PRIORITY_ORDER == null) || (paramVarArgs == null) || (this.FILTERS_PRIORITY_ORDER.size() == 0)) {
      return paramVarArgs;
    }
    LogUtils.i("AEFilterManager", "checkFilterInitOrder|input lines:" + printLines(paramVarArgs));
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    if (j < paramVarArgs.length)
    {
      if (!this.FILTERS_PRIORITY_ORDER.contains(Integer.valueOf(paramVarArgs[j]))) {
        i = addTypeInOrderArray(paramVarArgs[j], paramVarArgs, i);
      }
      for (;;)
      {
        j += 1;
        break;
        localArrayList.add(Integer.valueOf(paramVarArgs[j]));
      }
    }
    j = 0;
    while (j < localArrayList.size())
    {
      k = j + 1;
      while (k < localArrayList.size())
      {
        if (this.FILTERS_PRIORITY_ORDER.indexOf(localArrayList.get(j)) > this.FILTERS_PRIORITY_ORDER.indexOf(localArrayList.get(k)))
        {
          m = ((Integer)localArrayList.get(j)).intValue();
          localArrayList.set(j, localArrayList.get(k));
          localArrayList.set(k, Integer.valueOf(m));
        }
        k += 1;
      }
      j += 1;
    }
    int m = -1;
    int k = m;
    if (this.mFiltersMustInitedSetting != null)
    {
      k = m;
      if (this.mFiltersMustInitedSetting.mustInitCount() > 0) {
        j = localArrayList.size() - 1;
      }
    }
    for (;;)
    {
      k = m;
      if (j >= 0)
      {
        if (this.mFiltersMustInitedSetting.isContainType(((Integer)localArrayList.get(j)).intValue())) {
          k = j;
        }
      }
      else
      {
        j = i;
        if (k < 0) {
          break label365;
        }
        shiftRightArray(paramVarArgs, i + k, k + 1);
        j = 0;
        while (j <= k)
        {
          paramVarArgs[j] = ((Integer)localArrayList.remove(0)).intValue();
          j += 1;
        }
      }
      j -= 1;
    }
    j = i + k + 1;
    label365:
    i = j;
    j = 0;
    while ((i < paramVarArgs.length) && (j < localArrayList.size()))
    {
      paramVarArgs[i] = ((Integer)localArrayList.get(j)).intValue();
      j += 1;
      i += 1;
    }
    localArrayList.clear();
    if (this.mFiltersMustInitedSetting != null)
    {
      this.mFiltersMustInitedSetting.updateAllFilterInitedValue(paramVarArgs);
      this.mFiltersMustInitedSetting.reset();
    }
    this.mAllMustFiltsInited = false;
    LogUtils.i("AEFilterManager", "checkFilterInitOrder|output lines:" + printLines(paramVarArgs));
    return paramVarArgs;
  }
  
  private boolean checkNotEnduranceTime(long paramLong)
  {
    return (this.mEnduranceTime > 0) && (System.currentTimeMillis() - paramLong > this.mEnduranceTime);
  }
  
  private void clearHotAreaBeforeProcess()
  {
    if (this.hotAreaPositions != null) {
      this.hotAreaPositions.clear();
    }
  }
  
  private void clearSharedResources()
  {
    ShaderManager.getInstance().clear();
    FrameBufferCache.getInstance().destroy();
    RetrieveDataManager.getInstance().clear();
    if (this.isClearMaskImgs)
    {
      FeatureManager.Features.MASK_IMAGES.clear();
      this.isClearMaskImgs = false;
    }
    PreviewPerformanceInfo.getInstance().destroy();
  }
  
  private void configFilters()
  {
    if (this.mAEProfiler != null)
    {
      this.mAEProfiler.startByTag("IAEProfiler-configFilters");
      this.mAEProfiler.startByTag("IAEProfiler-waitFaceTime");
    }
    Object localObject2;
    Object localObject1;
    label124:
    int i;
    label180:
    Map.Entry localEntry;
    int j;
    if (this.mAiAttr == null)
    {
      localObject2 = PTFaceAttr.EmptyFaceAttr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = PTFaceAttr.EmptyFaceAttr;
      }
      if (localObject1 != null) {
        ((PTFaceAttr)localObject1).initTransformFacePoints();
      }
      if ((localObject1 != null) && (((PTFaceAttr)localObject1).getHistogram() != null)) {
        updateBeautyNormalFactor(((Integer)((PTFaceAttr)localObject1).getHistogram().first).intValue());
      }
      if ((this.mPTSticker == null) || (this.mPTSticker.getFreezeFaceInfo() == null)) {
        break label422;
      }
      localObject2 = this.mPTSticker.getFreezeFaceInfo();
      if (this.mPTSticker != null) {
        this.mPTSticker.setHotAreaPositions(this.hotAreaPositions);
      }
      if (this.mAEProfiler != null) {
        this.mAEProfiler.endByTag("IAEProfiler-waitFaceTime");
      }
      Iterator localIterator = this.mFilterEnableMap.entrySet().iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label2193;
      }
      localEntry = (Map.Entry)localIterator.next();
      j = i;
      if (((Boolean)localEntry.getValue()).booleanValue())
      {
        AEProfiler.getInstance().start("IAEProfiler-configFilters-" + localEntry.getKey(), true);
        j = i;
        switch (((Integer)localEntry.getKey()).intValue())
        {
        default: 
          j = i;
        }
      }
    }
    for (;;)
    {
      AEProfiler.getInstance().end("IAEProfiler-configFilters-" + localEntry.getKey(), true);
      i = j;
      break label180;
      localObject2 = (PTFaceAttr)this.mAiAttr.getRealtimeData(AEDetectorType.FACE.value);
      break;
      label422:
      localObject2 = localObject1;
      break label124;
      j = i;
      if (this.mPTSmooth != null)
      {
        this.mPTSmooth.setIsVeryLowEndDevice(this.isVeryLowEndDevice);
        this.mPTSmooth.setSmoothLevel(this.smoothLevel);
        this.mPTSmooth.setSharpenSize(this.smoothSharpenWidth, this.smoothSharpenHeight);
        this.mPTSmooth.setSharpenStrength(this.smoothSharpenStrength);
        this.mPTSmooth.setFaceAttr((PTFaceAttr)localObject1);
        this.mPTSmooth.setExposureValue(this.exposureValue);
        Object localObject3 = this.mPTSmooth;
        if ((!this.needAIDetect) || (this.isOverallSmooth)) {}
        for (boolean bool = true;; bool = false)
        {
          ((AESmooth)localObject3).setOverallSmooth(bool);
          if ((!this.filterInSmooth) || (TextUtils.isEmpty(this.mLutPath))) {
            break label586;
          }
          this.mPTSmooth.setLookUpPath(this.mLutPath);
          this.mPTSmooth.setLookUpIntensity(this.lookupLevel);
          j = i;
          break;
        }
        label586:
        this.mPTSmooth.setLookUpPath("");
        this.mPTSmooth.setLookUpIntensity(0.0F);
        j = i;
        continue;
        j = i;
        if (this.mPTSmoothPrev3 != null)
        {
          this.mPTSmoothPrev3.setSharpenFactor(0.0F);
          this.mPTSmoothPrev3.enableDenoise(true);
          this.mPTSmoothPrev3.setSmoothLevel(this.smoothLevel);
          this.mPTSmoothPrev3.setSharpenSize(this.smoothSharpenWidth, this.smoothSharpenHeight);
          this.mPTSmoothPrev3.setFaceStatus((PTFaceAttr)localObject1, (int)(this.width * this.mFaceDetectScale), (int)(this.height * this.mFaceDetectScale), this.phoneRotation);
          j = i;
          continue;
          j = i;
          if (this.mPTSticker != null)
          {
            j = i;
            if (i == 0)
            {
              this.mPTSticker.setAIAttr(this.mAiAttr);
              this.mPTSticker.updateVideoSize(this.width, this.height, this.mFaceDetectScale);
              this.mPTSticker.setFaceAttr((PTFaceAttr)localObject1);
              this.mPTSticker.setRatio((float)this.mViewAspectRatio);
              if (this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.SEGMENT_STICKER))
              {
                if (this.mAEProfiler != null) {
                  this.mAEProfiler.startByTag("IAEProfiler-waitSegTime");
                }
                this.mPTSticker.setSegAttr((PTSegAttr)this.mAiAttr.getRealtimeData(AEDetectorType.SEGMENT.value));
                if (this.mAEProfiler != null) {
                  this.mAEProfiler.endByTag("IAEProfiler-waitSegTime");
                }
              }
              for (;;)
              {
                AudioDataManager.getInstance().resetPermission();
                j = 1;
                if (this.mPTSticker.isUseStickerPlugin()) {
                  updateFaceTransform((PTFaceAttr)localObject2);
                }
                this.mPTSticker.setCyberpunkFaceAttr(this.ptFaceAttr);
                break;
                this.mPTSticker.setSegAttr(null);
              }
              j = i;
              if (this.mPTFaceBeauty != null)
              {
                localObject3 = this.mPTFaceBeauty;
                if (!this.closeAIBeautyConfig)
                {
                  bool = true;
                  label915:
                  ((AEFaceBeautyBase)localObject3).setLoadSo(bool);
                  this.mPTFaceBeauty.setVideoSize(this.width, this.height, this.mFaceDetectScale);
                  this.mPTFaceBeauty.setFaceAttr((PTFaceAttr)localObject2);
                  this.mPTFaceBeauty.setNormalAlphaFactor(this.beautyNormalAlpha);
                  this.mPTFaceBeauty.setLipsLutAlpha(this.cosmeticsAlpha);
                  this.mPTFaceBeauty.setFaceBeautyLevel(BeautyRealConfig.TYPE.BEAUTY, this.beautySkinLevel);
                  this.mPTFaceBeauty.setFaceBeautyLevel(BeautyRealConfig.TYPE.EYE_LIGHTEN, this.beautyEyeLighten);
                  this.mPTFaceBeauty.setFaceBeautyLevel(BeautyRealConfig.TYPE.TOOTH_WHITEN, this.beautyToothWhiten);
                  this.mPTFaceBeauty.setFaceBeautyLevel(BeautyRealConfig.TYPE.REMOVE_POUNCH, this.beautyRemovePounch);
                  this.mPTFaceBeauty.setFaceBeautyLevel(BeautyRealConfig.TYPE.REMOVE_WRINKLES, this.beautyRemoveWrinkles);
                  this.mPTFaceBeauty.setFaceBeautyLevel(BeautyRealConfig.TYPE.REMOVE_WRINKLES2, this.beautyRemoveWrinkles2);
                  this.mPTFaceBeauty.setFaceBeautyLevel(BeautyRealConfig.TYPE.COLOR_TONE, this.beautyColorTone);
                  this.mPTFaceBeauty.setFaceBeautyLevel(BeautyRealConfig.TYPE.CONTRAST_RATIO, this.beautyContrastRatio);
                  if ((this.mVideoMaterial == null) || (this.mVideoMaterial.getLipsSegType() != VideoMaterialUtil.LIPS_SEG_TPYE.MASK.value)) {
                    break label1218;
                  }
                  this.mPTFaceBeauty.setLipsLut(FileUtils.genSeperateFileDir(this.mVideoMaterial.getDataPath()) + this.mVideoMaterial.getLipsLutPath());
                }
                for (;;)
                {
                  if ((this.mVideoMaterial == null) || (TextUtils.isEmpty(this.mVideoMaterial.getLipsLutStyleMaskPath()))) {
                    break label1231;
                  }
                  this.mPTFaceBeauty.setLipsStyleMaskPath(FileUtils.genSeperateFileDir(this.mVideoMaterial.getDataPath()) + this.mVideoMaterial.getLipsLutStyleMaskPath());
                  j = i;
                  break;
                  bool = false;
                  break label915;
                  label1218:
                  this.mPTFaceBeauty.setLipsLut("");
                }
                label1231:
                this.mPTFaceBeauty.setLipsStyleMaskPath("");
                j = i;
                continue;
                j = i;
                if (this.mPTEffectFilter != null)
                {
                  j = i;
                  if (!TextUtils.isEmpty(this.mLutPath))
                  {
                    this.mPTEffectFilter.updateLut(this.mLutPath);
                    this.mPTEffectFilter.setAdjustParam(1.0F - this.lookupLevel);
                    j = i;
                    continue;
                    j = i;
                    if (this.mPhotoAIFilter != null)
                    {
                      this.mPhotoAIFilter.setFaceAttr((PTFaceAttr)localObject1);
                      j = i;
                      continue;
                      j = i;
                      if (this.mPTLight != null)
                      {
                        if ((localObject1 != null) && (((PTFaceAttr)localObject1).getHistogram() != null)) {
                          this.mPTLight.setHistogram((int[])((PTFaceAttr)localObject1).getHistogram().second);
                        }
                        this.mPTLight.setmLightSensorBrightness(this.mLightSensorBrightness);
                        this.mPTLight.setIsVeryLowEndDevice(this.isVeryLowEndDevice);
                        this.mPTLight.setSize(this.width, this.height);
                        this.isLowLightEnv = this.mPTLight.isLowLightEnv();
                        j = i;
                        continue;
                        updateFaceTransform((PTFaceAttr)localObject2);
                        j = i;
                        continue;
                        j = i;
                        if (this.mFaceColorCombineFilter != null) {
                          if (((PTFaceAttr)localObject2).getCurve() != null)
                          {
                            this.mFaceColorCombineFilter.updateCurve(((PTFaceAttr)localObject2).getCurve(), false);
                            this.mFaceColorCombineFilter.enableBrightness(1);
                            j = i;
                          }
                          else
                          {
                            this.mFaceColorCombineFilter.enableBrightness(0);
                            j = i;
                            continue;
                            j = i;
                            if (this.mDenoiseFilter != null)
                            {
                              this.mDenoiseFilter.setLowLightEnv(isLowLightEnv());
                              this.mDenoiseFilter.setVeryLowEndDevice(this.isVeryLowEndDevice);
                              j = i;
                              continue;
                              j = i;
                              if (this.mAESegment != null)
                              {
                                this.mAESegment.setSegAttr((PTSegAttr)this.mAiAttr.getRealtimeData(AEDetectorType.SEGMENT.value));
                                if (this.mVideoMaterial == null)
                                {
                                  this.mAESegment.setStrokeWidthInPixel(this.segStrokeWidthInPixel);
                                  this.mAESegment.setStrokeGapInPixel(this.segStrokeGapInPixel);
                                  this.mAESegment.setStrokeColor(this.segStrokeColor);
                                  this.mAESegment.setBgColor(this.segBgColor);
                                  j = i;
                                }
                                else
                                {
                                  int k = Math.min(this.width, this.height);
                                  if (k < 640) {
                                    j = 640;
                                  }
                                  for (;;)
                                  {
                                    this.mAESegment.setStrokeWidthInPixel((float)this.mVideoMaterial.getSegmentStrokeWidth() * j);
                                    localObject3 = this.mAESegment;
                                    float f = (float)this.mVideoMaterial.getSegmentStrokeGap();
                                    ((AESegmentForQQ)localObject3).setStrokeGapInPixel(j * f);
                                    this.mAESegment.setStrokeColor(this.mVideoMaterial.getSegmentStrokeColor());
                                    this.mAESegment.setBgColor(this.segBgColor);
                                    j = i;
                                    break;
                                    j = k;
                                    if (k > 1080) {
                                      j = 1080;
                                    }
                                  }
                                  j = i;
                                  if (this.mFaceLine != null)
                                  {
                                    this.mFaceLine.updateVideoSize(this.width, this.height, this.mFaceDetectScale);
                                    this.mFaceLine.setmFaceAttr((PTFaceAttr)localObject1);
                                    j = i;
                                    continue;
                                    j = i;
                                    if (this.mPTBodyBeauty != null)
                                    {
                                      this.mPTBodyBeauty.setBodyBeautyStrength(BeautyRealConfig.TYPE.LONG_LEG, this.longLeg);
                                      this.mPTBodyBeauty.setBodyBeautyStrength(BeautyRealConfig.TYPE.SLIM_WAIST, this.slimWaist);
                                      this.mPTBodyBeauty.setBodyBeautyStrength(BeautyRealConfig.TYPE.THIN_BODY, this.thinBody);
                                      this.mPTBodyBeauty.setBodyBeautyStrength(BeautyRealConfig.TYPE.THIN_SHOULDER, this.thinShoulder);
                                      this.mPTBodyBeauty.updateAIAttr(this.mAiAttr);
                                      j = i;
                                      continue;
                                      label1929:
                                      AIImageFilterResult localAIImageFilterResult;
                                      if (this.mAdjust != null)
                                      {
                                        this.mAdjust.setAlpha(this.adjustAlpha);
                                        if (this.adjustParams != null) {
                                          this.mAdjust.setAdjustParams(this.adjustParams);
                                        }
                                      }
                                      else
                                      {
                                        j = i;
                                        if (this.mAIFilterList == null) {
                                          continue;
                                        }
                                        j = i;
                                        if (mAIFilterConfigList == null) {
                                          continue;
                                        }
                                        j = i;
                                        if (mAIFilterConfigList.size() != this.mAIFilterList.size()) {
                                          continue;
                                        }
                                        localObject3 = mAIFilterConfigList.iterator();
                                        k = 0;
                                        j = i;
                                        if (!((Iterator)localObject3).hasNext()) {
                                          continue;
                                        }
                                        localAIImageFilterResult = (AIImageFilterResult)((Iterator)localObject3).next();
                                        if ((TextUtils.isEmpty(localAIImageFilterResult.lutPath)) || (!"lookup".equals(localAIImageFilterResult.fid))) {
                                          break label2118;
                                        }
                                        updateAIFilterListLut(k, localAIImageFilterResult.lutPath, localAIImageFilterResult.lutStrengt);
                                      }
                                      for (;;)
                                      {
                                        k += 1;
                                        break label1929;
                                        this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.LIGHTNESS, this.lightnessLevel);
                                        this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.HIGHLIGHT, this.hightLightLevel);
                                        this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.SHADOW, this.shadowLevel);
                                        this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.COMPARE, this.compareLevel);
                                        this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.SHARP, this.sharpLevel);
                                        this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.SATURATION, this.saturationLevel);
                                        this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.COLOR_TEMPERATURE, this.colorTemperature);
                                        this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.FADE, this.fadeLevel);
                                        break;
                                        label2118:
                                        if ("adjust".equals(localAIImageFilterResult.fid)) {
                                          updateAIFilterListAdjust(k, localAIImageFilterResult);
                                        } else if ("xuanlan".equals(localAIImageFilterResult.fid)) {
                                          updateAIFilterListXuanlanFilter(k, localAIImageFilterResult);
                                        }
                                      }
                                      j = i;
                                      if (this.mGlow != null)
                                      {
                                        this.mGlow.setAlpha(this.glowAlpha);
                                        j = i;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label2193:
    if (this.mAEProfiler != null) {
      this.mAEProfiler.endByTag("IAEProfiler-configFilters");
    }
  }
  
  private Vector copyArry2Vector(Object paramObject, Vector<Integer> paramVector)
  {
    Object localObject2;
    if (paramObject == null)
    {
      localObject2 = paramVector;
      if (paramVector != null)
      {
        paramVector.clear();
        localObject2 = paramVector;
      }
    }
    do
    {
      return localObject2;
      localObject2 = paramVector;
    } while (!(paramObject instanceof int[]));
    Object localObject1 = paramVector;
    if (paramVector == null) {
      localObject1 = new Vector();
    }
    ((Vector)localObject1).clear();
    paramObject = (int[])paramObject;
    int j = paramObject.length;
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      int k = paramObject[i];
      if (!((Vector)localObject1).contains(Integer.valueOf(k))) {
        ((Vector)localObject1).add(Integer.valueOf(k));
      }
      i += 1;
    }
  }
  
  private Bitmap decodeBitmap(String paramString)
  {
    if ((AEModule.getContext() == null) || (paramString == null)) {
      return null;
    }
    paramString = AEModule.getContext().getExternalFilesDir(null).getPath() + File.separator + paramString;
    return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 1);
  }
  
  private void defineEnableMap(int... paramVarArgs)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramVarArgs = checkFilterInitOrder(paramVarArgs);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashMap.put(Integer.valueOf(paramVarArgs[i]), Boolean.valueOf(true));
      i += 1;
    }
    this.mFilterEnableMap = localLinkedHashMap;
  }
  
  private int detectFrame(int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((!this.needAIDetect) || (this.mAEDetector == null))
    {
      this.mAiAttr = new AIAttr(null);
      return paramInt;
    }
    if (this.mAEProfiler != null) {
      this.mAEProfiler.startByTag("IAEProfiler-detectFrame");
    }
    this.phoneRotation = VideoFilterUtil.get4DirectionAngle(this.mAEDetector.getRotation());
    this.mAiParam.update(this.width, this.height, this.phoneRotation);
    this.mAiParam.setModuleParam(AEDetectorType.FACE.value, "phoneRoll", Float.valueOf(this.mPhoneRoll));
    this.mAiParam.setModuleParam(AEDetectorType.FACE.value, "scale", Float.valueOf((float)this.mFaceDetectScale));
    if (this.mVideoMaterial != null) {
      this.mAiParam.setModuleParam(AEDetectorType.FACE.value, "starParam", this.mVideoMaterial.getStarParam());
    }
    this.mAiParam.setModuleParam(AEDetectorType.HAND.value, "scale", Float.valueOf((float)this.mFaceDetectScale));
    this.mAiParam.setModuleParam(AEDetectorType.GENDER_DETECT.value, "scale", Float.valueOf((float)this.mFaceDetectScale));
    this.mAiParam.setModuleParam(AEDetectorType.EMOTION.value, "scale", Float.valueOf((float)this.mFaceDetectScale));
    this.mAiParam.setSurfaceTime(paramLong);
    Object localObject3 = new AIInput();
    ((AIInput)localObject3).setInputTexture(paramInt);
    this.mDetectorMap.clear();
    this.needFaceDetect = true;
    Object localObject1 = this.mDetectorMap;
    Object localObject2 = AEDetectorType.HAND;
    if ((isCouldDetector(AEDetectorType.HAND.value)) && (((this.mPTSticker != null) && (this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.GESTURE_STICKER))) || (AEDebugConfig.ENABLE_HAND_LINE)))
    {
      paramBoolean = true;
      ((HashMap)localObject1).put(localObject2, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.HAND))
      {
        localObject1 = this.mAiParam;
        localObject2 = AEDetectorType.HAND.value;
        if ((this.mPTSticker == null) || (!this.mPTSticker.needDetectGestureBonePoint())) {
          break label1672;
        }
        paramBoolean = true;
        label372:
        ((AIParam)localObject1).setModuleParam((String)localObject2, "needDetectHandBone", Boolean.valueOf(paramBoolean));
      }
      localObject1 = this.mDetectorMap;
      localObject2 = AEDetectorType.GENDER_DETECT;
      if (((this.mPTSticker == null) || (!this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.GENDER_DETECT_STICKER))) && (!AEDebugConfig.ENABLE_GENDER_DETECT)) {
        break label1677;
      }
      paramBoolean = true;
      label425:
      ((HashMap)localObject1).put(localObject2, Boolean.valueOf(paramBoolean));
      if ((isDetectorOn(AEDetectorType.GENDER_DETECT)) && (this.mAiAttr != null))
      {
        localObject2 = (PTFaceAttr)this.mAiAttr.getFaceAttr();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = PTFaceAttr.EmptyFaceAttr;
        }
        ((PTFaceAttr)localObject1).getFaceInfoList();
        this.mAiParam.setModuleParam(AEDetectorType.GENDER_DETECT.value, "faceInfoList", localObject1);
        this.mAiParam.setModuleParam(AEDetectorType.GENDER_DETECT.value, "resetGender", Boolean.valueOf(this.mNeedResetGender));
        this.mNeedResetGender = false;
      }
      localObject1 = this.mDetectorMap;
      localObject2 = AEDetectorType.SEGMENT;
      if ((!isCouldDetector(AEDetectorType.SEGMENT.value)) || (((this.mPTSticker == null) || (!this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.SEGMENT_STICKER))) && (!AEDebugConfig.ENABLE_SEGMENT) && ((!this.mFilterOrderList.contains(Integer.valueOf(111))) || (!((Boolean)this.mFilterEnableMap.get(Integer.valueOf(111))).booleanValue())))) {
        break label1682;
      }
      paramBoolean = true;
      label624:
      ((HashMap)localObject1).put(localObject2, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.SEGMENT))
      {
        this.mAiParam.setModuleParam(AEDetectorType.SEGMENT.value, "cameraIndex", Integer.valueOf(this.mCameraIndex));
        if (this.segmentFrames < 2) {
          this.segmentFrames += 1;
        }
      }
      localObject1 = this.mDetectorMap;
      localObject2 = AEDetectorType.EMOTION;
      if ((!isCouldDetector(AEDetectorType.EMOTION.value)) || (this.mPTSticker == null) || (!this.mPTSticker.needDetectEmotion())) {
        break label1687;
      }
      paramBoolean = true;
      label730:
      ((HashMap)localObject1).put(localObject2, Boolean.valueOf(paramBoolean));
      localObject1 = this.mDetectorMap;
      localObject2 = AEDetectorType.BODY;
      if ((!isCouldDetector(AEDetectorType.BODY.value)) || ((!this.mNeedBodyDetect) && (!AEDebugConfig.ENABLE_BODY_BEAUTY) && ((this.mPTSticker == null) || (!this.mPTSticker.needDetectBody())) && (this.longLeg <= 0) && (this.slimWaist <= 0) && (this.thinBody <= 0) && (this.thinShoulder <= 0))) {
        break label1692;
      }
      paramBoolean = true;
      label826:
      ((HashMap)localObject1).put(localObject2, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.BODY)) {
        this.mAiParam.setModuleParam(AEDetectorType.BODY.value, "scale", Float.valueOf((float)this.mFaceDetectScale));
      }
      localObject1 = this.mDetectorMap;
      localObject2 = AEDetectorType.HAIR_SEGMENT;
      if ((!isCouldDetector(AEDetectorType.HAIR_SEGMENT.value)) || (((this.mPTSticker == null) || (!VideoMaterialUtil.isHairSegMaterial(this.mVideoMaterial))) && (!AEDebugConfig.ENABLE_HAIRSEG))) {
        break label1697;
      }
      paramBoolean = true;
      label921:
      ((HashMap)localObject1).put(localObject2, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.HAIR_SEGMENT))
      {
        localObject1 = PTHairSegmenter.HAIR_SEGMENT.getCurrentSize();
        this.mAiParam.setModuleParam(AEDetectorType.HAIR_SEGMENT.value, "bytesDataSizeWidth", Integer.valueOf(((SizeI)localObject1).width));
        this.mAiParam.setModuleParam(AEDetectorType.HAIR_SEGMENT.value, "bytesDataSizeHeight", Integer.valueOf(((SizeI)localObject1).height));
      }
      localObject1 = this.mDetectorMap;
      localObject2 = AEDetectorType.SKY_SEGMENT;
      if ((!isCouldDetector(AEDetectorType.SKY_SEGMENT.value)) || (((this.mPTSticker == null) || (!this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.SEGMENT_SKY_STICKER))) && (!AEDebugConfig.ENABLE_SKYSEG))) {
        break label1702;
      }
      paramBoolean = true;
      label1051:
      ((HashMap)localObject1).put(localObject2, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.SKY_SEGMENT))
      {
        localObject1 = PTSkySegmenter.SKY_SEGMENT.getCurrentSize();
        this.mAiParam.setModuleParam(AEDetectorType.SKY_SEGMENT.value, "bytesDataSizeWidth", Integer.valueOf(((SizeI)localObject1).width));
        this.mAiParam.setModuleParam(AEDetectorType.SKY_SEGMENT.value, "bytesDataSizeHeight", Integer.valueOf(((SizeI)localObject1).height));
        this.mAiParam.setRotationMatrix(this.rotationMatrix);
      }
      localObject1 = this.mDetectorMap;
      localObject2 = AEDetectorType.CAT;
      if (((this.mPTSticker == null) || (!this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.CAT_STICKER))) && (!AEDebugConfig.ENABLE_CAT)) {
        break label1707;
      }
      paramBoolean = true;
      label1179:
      ((HashMap)localObject1).put(localObject2, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.CAT)) {
        this.mAiParam.setModuleParam(AEDetectorType.CAT.value, "scale", Float.valueOf((float)this.mFaceDetectScale));
      }
      this.mDetectorMap.put(AEDetectorType.AR_DETECT, Boolean.valueOf(VideoMaterialUtil.isAR3DMaterial(this.mVideoMaterial)));
      if ((this.mPTSticker == null) || ((!this.mPTSticker.is3DCosMaterial()) && (!this.mPTSticker.isKissMaterial()))) {
        break label1712;
      }
      paramBoolean = true;
      label1275:
      this.mAiParam.setModuleParam(AEDetectorType.FACE.value, "FaceKit", Boolean.valueOf(paramBoolean));
      this.mAiParam.setModuleParam(AEDetectorType.FACE.value, "enableGenderDetect", Boolean.valueOf(false));
      this.mAiParam.setModuleParam(AEDetectorType.FACE.value, "enableAgeDetect", Boolean.valueOf(this.mNeedAgeDetect));
      ensureDetectorReady(this.mDetectorMap);
      toggleDetectors(this.mDetectorMap);
      this.mAiCtrl.switchModule(AEDetectorType.FACE.value, this.needFaceDetect);
      this.mAiCtrl.switchModule(AEDetectorType.VOICE_RECOGNIZE.value, true);
      this.mAiAttr = this.mAEDetector.detectFrame((AIInput)localObject3, this.mAiParam, this.mAiCtrl);
      localObject2 = (PTFaceAttr)this.mAiAttr.getFaceAttr();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = PTFaceAttr.EmptyFaceAttr;
      }
      localObject2 = ((PTFaceAttr)localObject1).getFaceInfoList();
      localObject1 = ((PTFaceAttr)localObject1).getFaceStatusList();
      localObject3 = (PTGenderAttr)this.mAiAttr.getAvailableData(AEDetectorType.GENDER_DETECT.value);
      if (localObject3 == null) {
        break label1726;
      }
      localObject3 = ((PTGenderAttr)localObject3).getGenderInfos();
      if ((localObject2 == null) || (localObject3 == null) || (((List)localObject2).size() != ((List)localObject3).size())) {
        break label1726;
      }
      paramInt = 0;
      label1505:
      if (paramInt >= ((List)localObject2).size()) {
        break label1726;
      }
      i = 0;
      label1519:
      if (i >= ((List)localObject3).size()) {
        break label1768;
      }
      if (((FaceInfo)((List)localObject2).get(paramInt)).faceId != ((PTGenderAttr.GenderInfo)((List)localObject3).get(i)).faceId) {
        break label1717;
      }
      ((FaceInfo)((List)localObject2).get(paramInt)).gender = ((PTGenderAttr.GenderInfo)((List)localObject3).get(i)).gender;
      ((FaceStatus)((List)localObject1).get(paramInt)).gender = ((PTGenderAttr.GenderInfo)((List)localObject3).get(i)).gender;
    }
    label1672:
    label1677:
    label1682:
    label1687:
    label1692:
    label1697:
    label1702:
    label1707:
    label1712:
    label1717:
    label1726:
    label1768:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ((FaceInfo)((List)localObject2).get(paramInt)).gender = 0;
        ((FaceStatus)((List)localObject1).get(paramInt)).gender = 0;
      }
      paramInt += 1;
      break label1505;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label372;
      paramBoolean = false;
      break label425;
      paramBoolean = false;
      break label624;
      paramBoolean = false;
      break label730;
      paramBoolean = false;
      break label826;
      paramBoolean = false;
      break label921;
      paramBoolean = false;
      break label1051;
      paramBoolean = false;
      break label1179;
      paramBoolean = false;
      break label1275;
      i += 1;
      break label1519;
      if (this.mAEProfiler != null) {
        this.mAEProfiler.endByTag("IAEProfiler-detectFrame");
      }
      if (this.mEnableDetectorHM != null) {
        this.mEnableDetectorHM.clear();
      }
      return this.mAiAttr.getOutTexture();
    }
  }
  
  private void disableAllFilters()
  {
    int i = 101;
    while (i < 112)
    {
      this.mFilterEnableMap.put(Integer.valueOf(i), Boolean.valueOf(false));
      i += 1;
    }
  }
  
  private void ensureCreateAndApplyPTFaceTransform()
  {
    if (this.mAsyncInitFilters)
    {
      if (this.mPTFaceTransform == null) {
        if (!this.mHasSubmitCreatePTFaceTransform)
        {
          this.mHasSubmitCreatePTFaceTransform = true;
          LogUtils.i("AEFilterManager", "submit create faceTransform action");
          new Thread(new AEFilterManager.2(this), "initFilters-faceTransform").start();
        }
      }
      while (this.hasApplyPTFaceTransform) {
        return;
      }
      this.mPTFaceTransform.apply();
      this.hasApplyPTFaceTransform = true;
      LogUtils.i("AEFilterManager", "apply faceTransform done");
      return;
    }
    if (this.mPTFaceTransform == null) {
      this.mPTFaceTransform = new AEFaceTransform();
    }
    this.mPTFaceTransform.applyChain();
    this.hasApplyPTFaceTransform = true;
  }
  
  private int getBmpToTextue(Bitmap paramBitmap)
  {
    if (!BitmapUtils.isLegal(paramBitmap)) {
      return -1;
    }
    GlUtil.loadTexture(this.testBmpTexture[0], paramBitmap);
    return this.testBmpTexture[0];
  }
  
  private String getInputVideoPath()
  {
    String str = AEModule.getResouceRoot();
    if (str == null) {
      return null;
    }
    return str + File.separator + "inputVideo";
  }
  
  private String getOutputVideoPath()
  {
    String str = AEModule.getResouceRoot();
    if (str == null) {
      return null;
    }
    return str + File.separator + "outputVideo";
  }
  
  private void initDefaultFiltersPriority()
  {
    this.FILTERS_PRIORITY_ORDER = new Vector();
    this.FILTERS_PRIORITY_ORDER.add(Integer.valueOf(101));
    this.FILTERS_PRIORITY_ORDER.add(Integer.valueOf(105));
    this.FILTERS_PRIORITY_ORDER.add(Integer.valueOf(104));
    this.mFiltersMustInitedSetting = new AEFiltersMustInitedSetting(new int[] { 101 });
  }
  
  private void initFilters()
  {
    if ((this.mFilterEnableMap == null) || (this.mFilterEnableMap.isEmpty()))
    {
      LogUtils.w("AEFilterManager", "[initFilters] warning, filters is empty!");
      return;
    }
    long l1 = 0L;
    if (!this.mLogFlag)
    {
      l2 = SystemClock.uptimeMillis();
      l1 = l2;
      if (this.mAEProfiler != null)
      {
        this.mAEProfiler.startByTag("IAEProfiler-initFilters");
        l1 = l2;
      }
    }
    long l2 = System.currentTimeMillis();
    Iterator localIterator1 = this.mFilterEnableMap.entrySet().iterator();
    label88:
    Map.Entry localEntry;
    int i;
    if (localIterator1.hasNext())
    {
      localEntry = (Map.Entry)localIterator1.next();
      if (((Boolean)localEntry.getValue()).booleanValue())
      {
        i = ((Integer)localEntry.getKey()).intValue();
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      if ((!this.mAllMustFiltsInited) && (this.mFiltersMustInitedSetting != null) && (this.mFiltersMustInitedSetting.isContainType(i)))
      {
        LogUtils.i("AEFilterManager", "MUST applied:" + i);
        this.mFiltersMustInitedSetting.appliedType(i);
        this.mAllMustFiltsInited = this.mFiltersMustInitedSetting.isMustFiltersInited();
      }
      if ((!this.mAllMustFiltsInited) || (!checkNotEnduranceTime(l2))) {
        break label88;
      }
      LogUtils.i("AEFilterManager", "初始化超时，下一帧继续，当前初始化到：" + localEntry.getKey());
      if (this.mLogFlag) {
        break;
      }
      this.mLogFlag = true;
      if (this.mAEProfiler != null) {
        this.mAEProfiler.endByTag("IAEProfiler-initFilters");
      }
      LogUtils.i("CameraLaunchPerf", "initFilters cost duration=" + (SystemClock.uptimeMillis() - l1));
      return;
      initStickers();
      continue;
      if (this.mPTSmooth == null) {
        this.mPTSmooth = new AESmooth();
      }
      this.mPTSmooth.applyChain();
      continue;
      if (this.mPTSmoothPrev3 == null) {
        this.mPTSmoothPrev3 = new AESmoothPrev3();
      }
      this.mPTSmoothPrev3.applyChain();
      continue;
      if (this.mPhotoAIFilter == null)
      {
        this.mPhotoAIFilter = new PhotoAIFilter();
        this.mPhotoAIFilter.setAdjustLutListener(this.adjustLutListener);
      }
      this.mPhotoAIFilter.applyChain();
      continue;
      Iterator localIterator2;
      Object localObject;
      if ((this.needUpdateAIFilter) && (mAIFilterConfigList != null))
      {
        if (this.mAIFilterList == null) {
          this.mAIFilterList = new ArrayList();
        }
        this.mAIFilterList.clear();
        localIterator2 = mAIFilterConfigList.iterator();
        while (localIterator2.hasNext())
        {
          localObject = (AIImageFilterResult)localIterator2.next();
          if ((!TextUtils.isEmpty(((AIImageFilterResult)localObject).lutPath)) && ("lookup".equals(((AIImageFilterResult)localObject).fid)))
          {
            localObject = new AEFilterGallery();
            this.mAIFilterList.add(localObject);
          }
          else if ("adjust".equals(((AIImageFilterResult)localObject).fid))
          {
            localObject = new AEAdjust();
            this.mAIFilterList.add(localObject);
          }
          else if ("xuanlan".equals(((AIImageFilterResult)localObject).fid))
          {
            localObject = new AEGlow();
            this.mAIFilterList.add(localObject);
          }
        }
        this.needUpdateAIFilter = false;
      }
      if (this.mAIFilterList != null)
      {
        localIterator2 = this.mAIFilterList.iterator();
        while (localIterator2.hasNext())
        {
          localObject = (AEChainI)localIterator2.next();
          if ((localObject instanceof AEGlow)) {
            ((AEGlow)localObject).applyFilterChain(false, this.width, this.height);
          } else if ((localObject instanceof AEAdjust)) {
            ((AEAdjust)localObject).apply();
          } else {
            ((AEChainI)localObject).applyChain();
          }
        }
        if (this.mPTFaceBeauty == null) {
          this.mPTFaceBeauty = FaceBeautyManager.getFaceBeautyInstance(this.faceBeautyVersion);
        }
        this.mPTFaceBeauty.applyChain();
        continue;
        if (this.mPTEffectFilter == null) {
          this.mPTEffectFilter = new AEFilterGallery();
        }
        this.mPTEffectFilter.applyChain();
        continue;
        if (this.mPTLight == null) {
          this.mPTLight = new AELight();
        }
        this.mPTLight.applyChain();
        continue;
        ensureCreateAndApplyPTFaceTransform();
        continue;
        if (this.mFaceColorCombineFilter == null) {
          this.mFaceColorCombineFilter = new FaceColorCombineFilter();
        }
        this.mFaceColorCombineFilter.applyChain();
        continue;
        if (this.mDenoiseFilter == null) {
          this.mDenoiseFilter = new AEDenoiseFilter();
        }
        this.mDenoiseFilter.applyChain();
        continue;
        if (this.mAESegment == null) {
          this.mAESegment = new AESegmentForQQ();
        }
        this.mAESegment.applyChain();
        continue;
        if (this.mFaceLine == null) {
          this.mFaceLine = new AEFaceLine();
        }
        this.mFaceLine.applyChain();
        continue;
        if (this.mPTBodyBeauty == null) {
          this.mPTBodyBeauty = new AEBodyBeauty();
        }
        this.mPTBodyBeauty.applyChain();
        continue;
        if (this.mAdjust == null) {
          this.mAdjust = new AEAdjust();
        }
        this.mAdjust.apply();
        continue;
        if (this.mGlow == null) {
          this.mGlow = new AEGlow();
        }
        this.mGlow.applyFilterChain(false, this.width, this.height);
      }
    }
  }
  
  private void initStickers()
  {
    boolean bool2 = true;
    VideoPreviewFaceOutlineDetector localVideoPreviewFaceOutlineDetector;
    boolean bool1;
    if ((this.mPTSticker == null) && (this.mVideoMaterial != null))
    {
      VideoMaterial localVideoMaterial = this.mVideoMaterial;
      if (this.mAEDetector.getFaceDetector() == null) {
        break label212;
      }
      localVideoPreviewFaceOutlineDetector = this.mAEDetector.getFaceDetector().getFaceDetector();
      this.mPTSticker = new AESticker(localVideoMaterial, localVideoPreviewFaceOutlineDetector);
      this.mPTSticker.setStickerListener(1, this.materialLoadFinishListener);
      this.mPTSticker.setStickerListener(2, this.mDetectorDisableListener);
      if ((this.mPTSticker.isExcludeOuterEffectFilterMaterial()) && (this.stickerInnerLutFilterListener != null)) {
        this.stickerInnerLutFilterListener.notifyEnableStickerInnerEffectFilter(true);
      }
      if (this.mPTSticker.isUseMesh()) {
        switchFilterOn(105, false);
      }
      if ((!this.mPTSticker.isCosFunMaterial()) && (!this.mPTSticker.isMultiViewMaterial()) && (!this.mVideoMaterial.isNeedReCaculateFace())) {
        break label217;
      }
      bool1 = true;
      label157:
      this.pointUpdate = bool1;
      if (this.mPTSticker.isExcludeOuterEffectFilterMaterial()) {
        break label222;
      }
      bool1 = bool2;
      label174:
      setFilterInSmooth(bool1);
      if (!this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.SEGMENT_STICKER)) {
        break label227;
      }
    }
    label212:
    label217:
    label222:
    label227:
    for (this.segmentFrames = 0;; this.segmentFrames = 2)
    {
      if (this.mPTSticker != null) {
        this.mPTSticker.applyChain();
      }
      return;
      localVideoPreviewFaceOutlineDetector = null;
      break;
      bool1 = false;
      break label157;
      bool1 = false;
      break label174;
    }
  }
  
  private boolean isCouldDetector(String paramString)
  {
    if ((this.mEnableDetectorHM != null) && (this.mEnableDetectorHM.get(paramString) != null)) {
      return ((Boolean)this.mEnableDetectorHM.get(paramString)).booleanValue();
    }
    return true;
  }
  
  private boolean isLowLightEnv()
  {
    return this.isLowLightEnv;
  }
  
  private List<Bitmap> pickUpFrame(String paramString)
  {
    new ArrayList();
    int[] arrayOfInt = new int[10];
    int i = 0;
    Object localObject1 = VideoUtil.getFramestamps(paramString);
    if (localObject1 != null) {
      Collections.sort((List)localObject1);
    }
    Object localObject2 = (Long)Collections.max((Collection)localObject1);
    long l = 3000L;
    if (((Long)localObject2).longValue() > 30000L) {
      l = 6000L;
    }
    double d = Math.min(((Long)localObject2).longValue() / l, 10);
    int j = 0;
    int k;
    if (j < d)
    {
      k = 0;
      label95:
      if (k >= ((List)localObject1).size()) {
        break label275;
      }
      if (((Long)((List)localObject1).get(k)).longValue() > j * l)
      {
        arrayOfInt[i] = k;
        i += 1;
      }
    }
    label275:
    for (;;)
    {
      j += 1;
      break;
      k += 1;
      break label95;
      localObject1 = new ArrayList();
      localObject2 = new int[1];
      GLES20.glGenTextures(localObject2.length, (int[])localObject2, 0);
      j = localObject2[0];
      paramString = VboxFactory.createDecoder(paramString, 2);
      paramString.setTexture(j);
      i = 0;
      while (i < d)
      {
        paramString.getFrameTexture(arrayOfInt[i]);
        ((List)localObject1).add(RendererUtils.saveTexture(j, paramString.getWidth(), paramString.getHeight()));
        i += 1;
      }
      if (paramString != null) {
        paramString.releaseDecoder();
      }
      GLES20.glDeleteTextures(localObject2.length, (int[])localObject2, 0);
      return localObject1;
    }
  }
  
  private Bitmap pickUpFrameFirst(String paramString, int paramInt)
  {
    new ArrayList();
    Object localObject = VideoUtil.getFramestamps(paramString);
    if (localObject != null) {
      Collections.sort((List)localObject);
    }
    if (((Long)Collections.max((Collection)localObject)).longValue() < paramInt) {
      return null;
    }
    int i = 0;
    if (i < ((List)localObject).size()) {
      if (((Long)((List)localObject).get(i)).longValue() <= paramInt) {}
    }
    for (;;)
    {
      localObject = new int[1];
      GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
      paramInt = localObject[0];
      paramString = VboxFactory.createDecoder(paramString, 2);
      paramString.setTexture(paramInt);
      paramString.getFrameTexture(i);
      Bitmap localBitmap = RendererUtils.saveTexture(paramInt, paramString.getWidth(), paramString.getHeight());
      if (paramString != null) {
        paramString.releaseDecoder();
      }
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
      return localBitmap;
      i += 1;
      break;
      i = 0;
    }
  }
  
  private void printFilterParamIfNeed(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    do
    {
      return;
      if (this.mPTSmooth != null) {
        Log.e("AEFilterManager", "AESmooth === " + this.mPTSmooth.printParamInfo());
      }
      if (this.mPTFaceBeauty != null) {
        Log.e("AEFilterManager", "AEFaceBeauty === " + this.mPTFaceBeauty.printParamInfo());
      }
      if (this.mPTLight != null) {
        Log.e("AEFilterManager", "AELight === " + this.mPTLight.printParamInfo());
      }
      if (this.mPTFaceTransform != null) {
        Log.e("AEFilterManager", "AEFaceTransform === " + this.mPTFaceTransform.printParamInfo());
      }
      if (this.mFaceColorCombineFilter != null) {
        Log.e("AEFilterManager", "FaceColorCombineFilter === " + this.mFaceColorCombineFilter.printParamInfo());
      }
      if (this.mDenoiseFilter != null) {
        Log.e("AEFilterManager", "AEDenoiseFilter === " + this.mDenoiseFilter.printParamInfo());
      }
      if (this.mPTSmoothPrev3 != null) {
        Log.e("AEFilterManager", "AESmoothPrev3 === " + this.mPTSmoothPrev3.printParamInfo());
      }
      if (this.mAESegment != null) {
        Log.e("AEFilterManager", "AESegmentForQQ === " + this.mAESegment.printParamInfo());
      }
      if (this.mPTBodyBeauty != null) {
        Log.e("AEFilterManager", "AEBodyBeauty === " + this.mPTBodyBeauty.printParamInfo());
      }
    } while (this.mGlow == null);
    Log.e("AEFilterManager", "AEGlow === " + this.mGlow.printParamInfo());
  }
  
  private String printLines(int[] paramArrayOfInt)
  {
    String str1 = "";
    String str2;
    if (paramArrayOfInt == null)
    {
      str2 = str1;
      return str2;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      str2 = str1;
      if (i >= j) {
        break;
      }
      int k = paramArrayOfInt[i];
      str1 = str1 + "," + k;
      i += 1;
    }
  }
  
  private void setDefaultOrder()
  {
    this.mFilterOrderList.clear();
    this.mFilterOrderList.add(Integer.valueOf(101));
    this.mFilterOrderList.add(Integer.valueOf(102));
    this.mFilterOrderList.add(Integer.valueOf(104));
    this.mFilterOrderList.add(Integer.valueOf(105));
    this.mFilterOrderList.add(Integer.valueOf(103));
    this.mFilterOrderList.add(Integer.valueOf(106));
  }
  
  public static void setVideoAIFilter(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    mVideoFilterName = paramString;
    temperature = paramInt1;
    lightness = paramInt2;
    overexposure = paramInt3;
    underexposure = paramInt4;
    contrast = paramInt5;
    sharpness = paramInt6;
    saturation = paramInt7;
    colorfulness = paramInt8;
  }
  
  private void shiftRightArray(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfInt == null) || (paramInt2 <= 0)) {
      return;
    }
    int i;
    do
    {
      paramArrayOfInt[paramInt1] = paramArrayOfInt[i];
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      i = paramInt1 - paramInt2;
    } while (i >= 0);
  }
  
  private void updateAIFilter()
  {
    if (!this.needUpdateAIFilter) {
      this.needUpdateAIFilter = true;
    }
  }
  
  private void updateAIFilterListAdjust(int paramInt, AIImageFilterResult paramAIImageFilterResult)
  {
    if ((this.mAIFilterList != null) && (mAIFilterConfigList != null) && (paramInt < this.mAIFilterList.size())) {
      ((AEAdjust)this.mAIFilterList.get(paramInt)).setAdjustParams(paramAIImageFilterResult.adjustParam);
    }
  }
  
  private void updateAIFilterListLut(int paramInt, String paramString, float paramFloat)
  {
    if ((this.mAIFilterList != null) && (mAIFilterConfigList != null) && (paramInt < this.mAIFilterList.size()) && (!TextUtils.isEmpty(paramString)))
    {
      AEFilterGallery localAEFilterGallery = (AEFilterGallery)this.mAIFilterList.get(paramInt);
      localAEFilterGallery.updateLut(paramString);
      localAEFilterGallery.setAdjustParam(1.0F - paramFloat);
    }
  }
  
  private void updateAIFilterListXuanlanFilter(int paramInt, AIImageFilterResult paramAIImageFilterResult)
  {
    if ((this.mAIFilterList != null) && (mAIFilterConfigList != null) && (paramInt < this.mAIFilterList.size())) {
      ((AEGlow)this.mAIFilterList.get(paramInt)).setAlpha(paramAIImageFilterResult.lutStrengt);
    }
  }
  
  private void updateAdjustValue(ImageStatisticsData paramImageStatisticsData)
  {
    if (paramImageStatisticsData != null)
    {
      this.lightnessLevel = ((int)paramImageStatisticsData.lightness);
      this.hightLightLevel = ((int)paramImageStatisticsData.overexposure);
      this.shadowLevel = ((int)paramImageStatisticsData.underexposure);
      this.compareLevel = ((int)paramImageStatisticsData.contrast);
      this.sharpLevel = ((int)paramImageStatisticsData.sharpness);
      this.saturationLevel = ((int)paramImageStatisticsData.saturation);
      this.colorTemperature = ((int)paramImageStatisticsData.temperature);
      this.fadeLevel = ((int)paramImageStatisticsData.colorfulness);
    }
  }
  
  private void updateBeautyNormalFactor(int paramInt)
  {
    float f;
    if (paramInt <= 40) {
      f = 0.0F;
    }
    for (;;)
    {
      setBeautyNormalAlpha(f);
      return;
      if (paramInt >= 80) {
        f = 1.0F;
      } else {
        f = (paramInt - 40.0F) / 40.0F;
      }
    }
  }
  
  private void updateTips()
  {
    if ((this.mAEDetector != null) && (this.mAEDetector.getFaceDetector() != null)) {
      AETipsManager.getInstance().setFaceDetector(this.mAEDetector.getFaceDetector().getFaceDetector());
    }
    AETipsManager.getInstance().isBodyDetected(isBodyDetect());
  }
  
  public void addMaskTouchPoint(PointF paramPointF, int paramInt)
  {
    if ((this.mPTSticker != null) && (this.mPTSticker.needMaskRecordTouchPoint()) && (paramInt > 0) && (paramPointF != null))
    {
      float f = this.width / paramInt;
      paramPointF.x *= f;
      paramPointF.y = (f * paramPointF.y);
      this.mPTSticker.addMaskTouchPoint(new PointF(paramPointF.x, paramPointF.y));
    }
  }
  
  public void addTouchPoint(PointF paramPointF, int paramInt)
  {
    if ((this.mPTSticker != null) && (this.mPTSticker.needRecordTouchPoint()) && (paramInt > 0) && (paramPointF != null))
    {
      float f = this.width / paramInt;
      paramPointF.x *= f;
      paramPointF.y = (f * paramPointF.y);
      this.mPTSticker.addTouchPoint(new PointF(paramPointF.x, paramPointF.y));
    }
  }
  
  public void arTracked()
  {
    if (this.mPTSticker != null) {
      this.mPTSticker.arTracked();
    }
  }
  
  public boolean canUseLargeImage()
  {
    return (this.mVideoMaterial == null) || ((!this.mVideoMaterial.isSegmentRequired()) && (!VideoMaterialUtil.isAudio2textMaterial(this.mVideoMaterial)) && (!VideoMaterialUtil.isAnimojiMaterial(this.mVideoMaterial)) && (!VideoMaterialUtil.isFilamentMaterial(this.mVideoMaterial)) && (!VideoMaterialUtil.isFilamentAnimojiMaterial(this.mVideoMaterial)) && (!VideoMaterialUtil.is3DMaterial(this.mVideoMaterial)));
  }
  
  public void constructFilters()
  {
    if ((this.mFilterEnableMap == null) || (this.mFilterEnableMap.isEmpty())) {
      LogUtils.w("AEFilterManager", "[initFilters] warning, filters is empty!");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.mFilterEnableMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Boolean)localEntry.getValue()).booleanValue()) {
          switch (((Integer)localEntry.getKey()).intValue())
          {
          case 109: 
          case 112: 
          case 115: 
          default: 
            break;
          case 102: 
          case 103: 
            if ((this.mPTSticker == null) && (this.mVideoMaterial != null))
            {
              this.mPTSticker = new AESticker(this.mVideoMaterial, this.mAEDetector.getFaceDetector().getFaceDetector());
              this.mPTSticker.setStickerListener(1, this.materialLoadFinishListener);
              this.mPTSticker.setStickerListener(2, this.mDetectorDisableListener);
              if ((this.mPTSticker.isExcludeOuterEffectFilterMaterial()) && (this.stickerInnerLutFilterListener != null)) {
                this.stickerInnerLutFilterListener.notifyEnableStickerInnerEffectFilter(true);
              }
              if ((this.mPTSticker.isCosFunMaterial()) || (this.mPTSticker.isMultiViewMaterial()))
              {
                bool = true;
                this.pointUpdate = bool;
                if (this.mPTSticker.isExcludeOuterEffectFilterMaterial()) {
                  break label327;
                }
              }
              for (boolean bool = true;; bool = false)
              {
                setFilterInSmooth(bool);
                if (!this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.SEGMENT_STICKER)) {
                  break label332;
                }
                this.segmentFrames = 0;
                break;
                bool = false;
                break label279;
              }
              this.segmentFrames = 2;
            }
            break;
          case 110: 
            if (this.mPTSmoothPrev3 == null) {
              this.mPTSmoothPrev3 = new AESmoothPrev3();
            }
            break;
          case 104: 
            if (this.mPTFaceBeauty == null) {
              this.mPTFaceBeauty = FaceBeautyManager.getFaceBeautyInstance(this.faceBeautyVersion);
            }
            break;
          case 106: 
            if (this.mPTEffectFilter == null) {
              this.mPTEffectFilter = new AEFilterGallery();
            }
            break;
          case 113: 
            if (this.mPTLight == null) {
              this.mPTLight = new AELight();
            }
            break;
          case 105: 
            if (this.mPTFaceTransform == null) {
              this.mPTFaceTransform = new AEFaceTransform();
            }
            break;
          case 107: 
            if (this.mFaceColorCombineFilter == null) {
              this.mFaceColorCombineFilter = new FaceColorCombineFilter();
            }
            break;
          case 108: 
            if (this.mDenoiseFilter == null) {
              this.mDenoiseFilter = new AEDenoiseFilter();
            }
            break;
          case 111: 
            if (this.mAESegment == null) {
              this.mAESegment = new AESegmentForQQ();
            }
            break;
          case 114: 
            if (this.mFaceLine == null) {
              this.mFaceLine = new AEFaceLine();
            }
            break;
          case 116: 
            label279:
            label327:
            label332:
            if (this.mAdjust == null) {
              this.mAdjust = new AEAdjust();
            }
            break;
          }
        }
      }
    }
  }
  
  public void defineFiltersAndOrder(int... paramVarArgs)
  {
    disableAllFilters();
    this.mFilterOrderList.clear();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      int k = paramVarArgs[i];
      this.mFilterOrderList.add(Integer.valueOf(k));
      i += 1;
    }
    defineEnableMap(paramVarArgs);
  }
  
  public void defineFiltersWithDefaultOrder(int... paramVarArgs)
  {
    disableAllFilters();
    setDefaultOrder();
    defineEnableMap(paramVarArgs);
  }
  
  public void destroy()
  {
    PreviewPerformanceInfo.getInstance().report();
    if (this.mPTSmooth != null) {
      this.mPTSmooth.clear();
    }
    if (this.mPTSmoothPrev3 != null) {
      this.mPTSmoothPrev3.clear();
    }
    if (this.mPTFaceBeauty != null) {
      this.mPTFaceBeauty.clear();
    }
    if (this.mPhotoAIFilter != null) {
      this.mPhotoAIFilter.clear();
    }
    if (this.mAIFilterList != null)
    {
      Iterator localIterator = this.mAIFilterList.iterator();
      while (localIterator.hasNext())
      {
        AEChainI localAEChainI = (AEChainI)localIterator.next();
        if ((localAEChainI instanceof AEFilterGallery)) {
          ((AEFilterGallery)localAEChainI).clear();
        }
        if ((localAEChainI instanceof AEAdjust)) {
          ((AEAdjust)localAEChainI).clear();
        }
      }
      this.mAIFilterList.clear();
      this.mAIFilterList = null;
    }
    if (this.mAdjust != null) {
      this.mAdjust.clear();
    }
    if (this.mPTEffectFilter != null) {
      this.mPTEffectFilter.clear();
    }
    if (this.mPTLight != null) {
      this.mPTLight.clear();
    }
    if (this.mFaceLine != null) {
      this.mFaceLine.clear();
    }
    if (this.mPTFaceTransform != null)
    {
      this.mPTFaceTransform.clear();
      this.mPTFaceTransform = null;
    }
    if (this.mPTSticker != null)
    {
      this.mPTSticker.destroyAudio();
      this.mPTSticker.clear();
      this.mPTSticker = null;
    }
    if (this.mFaceColorCombineFilter != null) {
      this.mFaceColorCombineFilter.clearGLSLSelf();
    }
    if (this.mDenoiseFilter != null) {
      this.mDenoiseFilter.clear();
    }
    if (this.mAESegment != null) {
      this.mAESegment.clear();
    }
    if (this.mPTBodyBeauty != null) {
      this.mPTBodyBeauty.clear();
    }
    if (this.mAEFilterChain != null) {
      this.mAEFilterChain.destroy();
    }
    if (this.mAEDetector != null) {
      this.mAEDetector.clear();
    }
    clearSharedResources();
    GLES20.glDeleteTextures(this.textures.length, this.textures, 0);
    if (this.isNeedPictureTest) {
      GLES20.glDeleteTextures(this.testBmpTexture.length, this.testBmpTexture, 0);
    }
    this.mAllMustFiltsInited = false;
    this.mIsInited = false;
    this.mDestroyed = true;
    this.needUpdateAIFilter = true;
    mAIFilterConfigList = null;
  }
  
  public void destroyAudio()
  {
    if (this.mPTSticker != null) {
      this.mPTSticker.destroyAudio();
    }
  }
  
  public boolean detectedFace()
  {
    if (this.mAiAttr == null) {
      return false;
    }
    if (((PTFaceAttr)this.mAiAttr.getRealtimeData(AEDetectorType.FACE.value)).getFaceCount() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean detectedGesture()
  {
    if (this.mAiAttr == null) {
      return false;
    }
    if ((PTHandAttr)this.mAiAttr.getAvailableData(AEDetectorType.HAND.value) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int drawFrame(int paramInt, boolean paramBoolean, long paramLong)
  {
    paramInt = changeTextureIfNeed(this.isNeedPictureTest, paramInt);
    if (this.mAEProfiler != null) {
      this.mAEProfiler.startByTag("IAEProfiler-drawFrame");
    }
    long l = PreviewPerformanceInfo.getMicTime().longValue();
    initFilters();
    paramInt = detectFrame(paramInt, paramBoolean, paramLong);
    if (this.mEnableComparison) {
      return paramInt;
    }
    updateTips();
    configFilters();
    chainFilters();
    clearHotAreaBeforeProcess();
    this.mAEFilterChain.process(paramInt, this.outputTexture, this.width, this.height);
    GLES20.glDisable(2929);
    if (this.mAEProfiler != null)
    {
      this.mAEProfiler.endByTag("IAEProfiler-drawFrame");
      this.mAEProfiler.print();
    }
    paramLong = PreviewPerformanceInfo.getMicTime().longValue();
    PreviewPerformanceInfo.getInstance().updateInfo(paramLong - l);
    if (this.mAEProfiler != null)
    {
      this.mAEProfiler.endByTag("IAEProfiler-calFps");
      this.mAEProfiler.startByTag("IAEProfiler-calFps");
    }
    return this.outputTexture;
  }
  
  public void enableAIDetect(boolean paramBoolean)
  {
    if ((!this.needAIDetect) && (paramBoolean))
    {
      if (this.mAEDetector == null) {
        this.mAEDetector = new AEDetector();
      }
      if (this.mAEDetector.init() != 0) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      this.mIsInited = bool;
      this.needAIDetect = paramBoolean;
      return;
    }
  }
  
  public void ensureDetectorReady(Map<AEDetectorType, Boolean> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if ((!AIManager.isDetectorReady((AEDetectorType)localEntry.getKey())) && (((Boolean)localEntry.getValue()).booleanValue())) {
        AIManager.reInstallModule((AEDetectorType)localEntry.getKey());
      }
    }
  }
  
  public AEDetector getAEDetector()
  {
    return this.mAEDetector;
  }
  
  public AIAttr getAIAttr()
  {
    if (this.needAIDetect) {
      return this.mAEDetector.getAIAttr();
    }
    return this.mAiAttr;
  }
  
  public String getFaceBeautyVersion()
  {
    return this.faceBeautyVersion;
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    if ((getAEDetector() == null) || (getAEDetector().getFaceDetector() == null)) {
      return null;
    }
    return getAEDetector().getFaceDetector().getFaceDetector();
  }
  
  public float[] getFilamentAssetPosition()
  {
    if (this.mPTSticker != null) {
      return this.mPTSticker.getFilamentAssetPosition();
    }
    return null;
  }
  
  public ArrayList<RedPacketPosition> getHotAreaPositions()
  {
    return this.hotAreaPositions;
  }
  
  public int getMusicCurrentPosition()
  {
    return TouchTriggerManager.getInstance().getMusicCurrentPosition();
  }
  
  public int getMusicDuration()
  {
    return TouchTriggerManager.getInstance().getMusicDuration();
  }
  
  public long getMusicStartTime()
  {
    return TouchTriggerManager.getInstance().getMusicStartTime();
  }
  
  public VideoMaterial getVideoMaterial()
  {
    return this.mVideoMaterial;
  }
  
  public AESticker getmPTSticker()
  {
    return this.mPTSticker;
  }
  
  public boolean hasEffect()
  {
    if (this.mPTSticker != null) {}
    while ((this.smoothLevel > 0) || (this.transBasic4 > 0) || ((this.mPTEffectFilter != null) && (!TextUtils.isEmpty(this.mLutPath)))) {
      return true;
    }
    return false;
  }
  
  public void initDetector(List<Integer> paramList)
  {
    if ((this.mAEDetector != null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    int i;
    Iterator localIterator;
    do
    {
      paramList = paramList.iterator();
      while (!localIterator.hasNext())
      {
        if (!paramList.hasNext()) {
          break;
        }
        i = ((Integer)paramList.next()).intValue();
        localIterator = FilterTypeRunWithDetector.iterator();
      }
    } while (i != ((Integer)localIterator.next()).intValue());
    this.needAIDetect = true;
    this.mAEDetector = new AEDetector();
    if (this.mAEDetector.init() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsInited = bool;
      return;
    }
    this.mIsInited = true;
    this.needAIDetect = false;
  }
  
  public void initInGL(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    this.width = paramInt1;
    this.height = paramInt2;
    this.smoothSharpenWidth = paramInt1;
    this.smoothSharpenHeight = paramInt2;
    if (!DeviceUtils.hasDeviceLow(AEModule.getContext()))
    {
      bool1 = true;
      this.isVeryLowEndDevice = bool1;
      GLES20.glGenTextures(this.textures.length, this.textures, 0);
      if (this.isNeedPictureTest) {
        GLES20.glGenTextures(this.testBmpTexture.length, this.testBmpTexture, 0);
      }
      this.outputTexture = this.textures[0];
      this.mAEFilterChain.init();
      bool1 = bool2;
      if (this.needAIDetect) {
        if (this.mAEDetector.init() != 0) {
          break label123;
        }
      }
    }
    label123:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mIsInited = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean isBodyDetect()
  {
    if (this.mAiAttr == null) {
      return false;
    }
    if (!isDetectorOn(AEDetectorType.BODY)) {
      return false;
    }
    List localList = (List)this.mAiAttr.getAvailableData(AEDetectorType.BODY.value);
    return (localList != null) && (!localList.isEmpty());
  }
  
  public boolean isDetectorOn(AEDetectorType paramAEDetectorType)
  {
    if (this.mDetectorMap.containsKey(paramAEDetectorType)) {
      return ((Boolean)this.mDetectorMap.get(paramAEDetectorType)).booleanValue();
    }
    return false;
  }
  
  public boolean isInited()
  {
    return this.mIsInited;
  }
  
  public boolean isNeedFaceDetect()
  {
    return (this.needFaceDetect) && (this.mPTSticker != null);
  }
  
  public boolean isNewRedPacketMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.getItemList();
    if (paramVideoMaterial == null) {
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.iterator();
    while (paramVideoMaterial.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)paramVideoMaterial.next();
      if ((localStickerItem != null) && (localStickerItem.hotArea != null) && (localStickerItem.hotArea.length > 0)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isUseFilterConfig(int paramInt)
  {
    boolean bool = false;
    if (this.filterConfigMap.containsKey(Integer.valueOf(paramInt))) {
      bool = ((Boolean)this.filterConfigMap.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return bool;
  }
  
  public boolean needMaskRecordTouchPoint()
  {
    if (this.mPTSticker != null) {
      return this.mPTSticker.needMaskRecordTouchPoint();
    }
    return false;
  }
  
  public boolean needShieldQZWBlackFilter()
  {
    return (this.mPTSticker != null) && (this.mPTSticker.isExcludeOuterEffectFilterMaterial()) && (!this.filterInSmooth);
  }
  
  public void onStickerStatusChange(boolean paramBoolean)
  {
    if (this.mPTSticker != null)
    {
      if (paramBoolean) {
        this.mPTSticker.onStickerPause();
      }
    }
    else {
      return;
    }
    this.mPTSticker.onStickerResume();
  }
  
  public void resetAdjustLut()
  {
    updateLutGL(this.mLutPath);
  }
  
  public void resetGender()
  {
    this.mNeedResetGender = true;
  }
  
  public void setAIBeautyParamsJsonBean(AIBeautyParamsJsonBean paramAIBeautyParamsJsonBean)
  {
    this.closeAIBeautyConfig = false;
    this.mAIBeautyParamsJsonBean = paramAIBeautyParamsJsonBean;
  }
  
  public void setAIFilterConfigList(List<AIImageFilterResult> paramList)
  {
    if (paramList != null)
    {
      mAIFilterConfigList = paramList;
      updateAIFilter();
    }
  }
  
  public void setAdjustAlpha(float paramFloat)
  {
    this.adjustAlpha = paramFloat;
  }
  
  public void setAdjustLevel(AdjustRealConfig.TYPE paramTYPE, int paramInt)
  {
    switch (AEFilterManager.3.$SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[paramTYPE.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.lightnessLevel = paramInt;
      return;
    case 2: 
      this.hightLightLevel = paramInt;
      return;
    case 3: 
      this.shadowLevel = paramInt;
      return;
    case 4: 
      this.compareLevel = paramInt;
      return;
    case 5: 
      this.sharpLevel = paramInt;
      return;
    case 6: 
      this.saturationLevel = paramInt;
      return;
    case 7: 
      this.colorTemperature = paramInt;
      return;
    }
    this.fadeLevel = paramInt;
  }
  
  public void setAdjustLutListener(PhotoAIFilter.AdjustLutListener paramAdjustLutListener)
  {
    if (this.mPhotoAIFilter != null) {
      this.mPhotoAIFilter.setAdjustLutListener(paramAdjustLutListener);
    }
    this.adjustLutListener = paramAdjustLutListener;
  }
  
  public void setAdjustParams(HashMap<String, String> paramHashMap)
  {
    this.adjustParams = paramHashMap;
  }
  
  public void setArFrameInfoInfo(ArFrameInfo paramArFrameInfo)
  {
    ARDetectDataManager.getInstance().updateData(paramArFrameInfo);
  }
  
  public void setBeautyGenderCoefficient(int paramInt1, int paramInt2)
  {
    if (this.mPTSmooth != null) {}
  }
  
  public void setBeautyNormalAlpha(float paramFloat)
  {
    this.beautyNormalAlpha = paramFloat;
  }
  
  public void setBeautyOrTransformLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    switch (AEFilterManager.3.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    default: 
      return;
    case 1: 
      setSmoothLevel((int)(paramInt * 0.6D));
      this.beautySkinLevel = paramInt;
      return;
    case 2: 
      this.beautyEyeLighten = paramInt;
      return;
    case 3: 
      this.beautyToothWhiten = paramInt;
      return;
    case 4: 
      this.beautyRemovePounch = paramInt;
      return;
    case 5: 
      this.beautyRemoveWrinkles = paramInt;
      return;
    case 6: 
      this.beautyRemoveWrinkles2 = paramInt;
      return;
    case 7: 
      this.beautyColorTone = ((paramInt + 100) / 2);
      return;
    case 8: 
      this.beautyContrastRatio = paramInt;
      return;
    case 9: 
      this.transForehead = paramInt;
      return;
    case 10: 
      this.transEye = paramInt;
      return;
    case 11: 
      this.transEyeDistance = paramInt;
      return;
    case 12: 
      this.transEyeAngle = paramInt;
      return;
    case 13: 
      this.transMouthShape = paramInt;
      return;
    case 14: 
      this.transChin = paramInt;
      return;
    case 15: 
      this.transFaceThin = paramInt;
      return;
    case 16: 
      this.transFaceV = paramInt;
      return;
    case 17: 
      this.transNoseWing = paramInt;
      return;
    case 18: 
      this.transNosePosition = paramInt;
      return;
    case 19: 
      this.transLipsThickness = paramInt;
      return;
    case 20: 
      this.transLipsWidth = paramInt;
      return;
    case 21: 
      this.transNose = paramInt;
      return;
    case 22: 
      this.transCheekboneThin = paramInt;
      return;
    case 23: 
      this.transFaceShorten = paramInt;
      return;
    case 24: 
      this.transBasic4 = paramInt;
      return;
    case 25: 
      this.transBasic3 = paramInt;
      return;
    case 26: 
      this.longLeg = paramInt;
      return;
    case 27: 
      this.slimWaist = paramInt;
      return;
    case 28: 
      this.thinShoulder = paramInt;
      return;
    }
    this.thinBody = paramInt;
  }
  
  public void setCameraIndex(int paramInt)
  {
    this.mCameraIndex = paramInt;
  }
  
  public void setCloseAIBeautyConfig(boolean paramBoolean)
  {
    this.closeAIBeautyConfig = paramBoolean;
  }
  
  public void setCosmeticsAlpha(int paramInt)
  {
    this.cosmeticsAlpha = paramInt;
  }
  
  public void setCurLabel(String paramString)
  {
    curLabel = paramString;
    updateAIFilter();
  }
  
  public void setDownEventUnProjectionPoint(ArrayList<float[]> paramArrayList)
  {
    if (this.mPTSticker != null) {
      this.mPTSticker.setDownEventUnProjectionPoint(paramArrayList);
    }
  }
  
  public void setExposureValue(int paramInt)
  {
    this.exposureValue = paramInt;
  }
  
  public void setFaceBeautyVersion(String paramString)
  {
    if ((this.faceBeautyVersion == null) || (!this.faceBeautyVersion.equals(paramString)))
    {
      this.faceBeautyVersion = paramString;
      if (this.mPTFaceBeauty != null) {
        this.mPTFaceBeauty.clear();
      }
      this.mPTFaceBeauty = null;
    }
  }
  
  public void setFaceGenderCoefficient(int paramInt1, int paramInt2)
  {
    if (this.mPTFaceTransform != null) {
      this.mPTFaceTransform.setGenderCoefficient(paramInt1, paramInt2);
    }
  }
  
  public void setFilterInSmooth(boolean paramBoolean)
  {
    this.filterInSmooth = paramBoolean;
  }
  
  public void setForceFaceDetect(boolean paramBoolean)
  {
    this.forceFaceDetect = paramBoolean;
  }
  
  public void setGlowAlpha(float paramFloat)
  {
    this.glowAlpha = paramFloat;
  }
  
  public void setIsAfterUpdateMaterial(boolean paramBoolean)
  {
    this.isAfterUpdateMaterial = paramBoolean;
  }
  
  public void setIsFirstDet(boolean paramBoolean)
  {
    if (this.mAEDetector != null) {
      this.mAEDetector.setIsFirstDet(paramBoolean);
    }
  }
  
  public void setLookupLevel(float paramFloat)
  {
    this.lookupLevel = paramFloat;
  }
  
  public void setNeedPictureTest(boolean paramBoolean)
  {
    this.isNeedPictureTest = paramBoolean;
  }
  
  public void setNeedVideoTesttSwitch(boolean paramBoolean) {}
  
  public void setOnMaterialLoadFinishListener(MaterialLoadFinishListener paramMaterialLoadFinishListener)
  {
    this.materialLoadFinishListener = paramMaterialLoadFinishListener;
  }
  
  public void setOverallSmooth(boolean paramBoolean)
  {
    this.isOverallSmooth = paramBoolean;
  }
  
  public void setPTFaceAttrData(PTFaceAttr paramPTFaceAttr)
  {
    this.ptFaceAttr = paramPTFaceAttr;
  }
  
  public void setParam(String paramString, Object paramObject)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!paramString.equals("SET_AEPROFILER_OBJ")) {
                break;
              }
              i = 0;
              break;
              if (!paramString.equals("SET_ENDURANCE_TIME")) {
                break;
              }
              i = 1;
              break;
              if (!paramString.equals("SET_FILTERS_INIT_PRIORITY")) {
                break;
              }
              i = 2;
              break;
              if (!paramString.equals("SET_FILTERS_INITED_FIRST_FRAME")) {
                break;
              }
              i = 3;
              break;
              if (!paramString.equals("SET_ENABLE_ASYNC_INIT_FILTERS")) {
                break;
              }
              i = 4;
              break;
              if (!paramString.equals("SET_ENABLE_SKIP_BEAUTY")) {
                break;
              }
              i = 5;
              break;
              if (!paramString.equals("SET_INIT_STICKERS")) {
                break;
              }
              i = 6;
              break;
            } while ((paramObject == null) || (!(paramObject instanceof IAEProfiler)));
            this.mAEProfiler = ((IAEProfiler)paramObject);
            return;
          } while ((paramObject == null) || (!(paramObject instanceof Integer)));
          this.mEnduranceTime = ((Integer)paramObject).intValue();
          return;
          this.FILTERS_PRIORITY_ORDER = copyArry2Vector(paramObject, this.FILTERS_PRIORITY_ORDER);
          return;
          if ((paramObject instanceof AEFiltersMustInitedSetting))
          {
            this.mFiltersMustInitedSetting = ((AEFiltersMustInitedSetting)paramObject);
            return;
          }
        } while (paramObject != null);
        this.mFiltersMustInitedSetting = null;
        return;
      } while (!(paramObject instanceof Boolean));
      this.mAsyncInitFilters = ((Boolean)paramObject).booleanValue();
      LogUtils.i("AEFilterManager", "AEFilterManager--setParam asyncInitFilters: " + this.mAsyncInitFilters);
      return;
    } while ((this.mPTFaceBeauty == null) || (!(paramObject instanceof Boolean)));
    this.mPTFaceBeauty.setSkipRenderEnabled(((Boolean)paramObject).booleanValue());
    return;
    initStickers();
  }
  
  public void setPhoneRoll(float paramFloat)
  {
    this.mPhoneRoll = paramFloat;
  }
  
  public void setRotationMatrix(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.rotationMatrix, 0, 16);
  }
  
  public void setScreenMidPoint(float[] paramArrayOfFloat)
  {
    if (this.mPTSticker != null) {
      this.mPTSticker.setScreenMidPoint(paramArrayOfFloat);
    }
  }
  
  public void setSegBgColor(float[] paramArrayOfFloat)
  {
    this.segBgColor = paramArrayOfFloat;
  }
  
  public void setSegStrokeColor(float[] paramArrayOfFloat)
  {
    this.segStrokeColor = paramArrayOfFloat;
  }
  
  public void setSegStrokeGapInPixel(float paramFloat)
  {
    this.segStrokeGapInPixel = paramFloat;
  }
  
  public void setSegStrokeWidthInPixel(float paramFloat)
  {
    this.segStrokeWidthInPixel = paramFloat;
  }
  
  public void setSmoothLevel(int paramInt)
  {
    if (!isUseFilterConfig(101)) {
      this.smoothLevel = paramInt;
    }
  }
  
  public void setSmoothSharpenSize(int paramInt1, int paramInt2)
  {
    this.smoothSharpenWidth = paramInt1;
    this.smoothSharpenHeight = paramInt2;
  }
  
  public void setSmoothSharpenStrength(float paramFloat)
  {
    this.smoothSharpenStrength = paramFloat;
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.stickerInnerLutFilterListener = paramStickerInnerEffectFilterListener;
  }
  
  public void setStickerPause(boolean paramBoolean)
  {
    this.stickerPause = paramBoolean;
    if (this.mPTSticker != null) {
      this.mPTSticker.onPause();
    }
  }
  
  public void setStickerResume(boolean paramBoolean)
  {
    this.stickerResume = paramBoolean;
    if (this.mPTSticker != null) {
      this.mPTSticker.onResume();
    }
  }
  
  public void setTapEvent(int paramInt)
  {
    if ((this.mPTSticker != null) && (this.mPTSticker.needTouchTriggerEvent())) {
      this.mPTSticker.setTouchTriggerEvent(paramInt);
    }
  }
  
  public void setTouchScale(float paramFloat)
  {
    if (this.mPTSticker != null) {
      this.mPTSticker.setTouchScale(paramFloat);
    }
  }
  
  public void setTouchTriggerEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((this.mPTSticker != null) && (this.mPTSticker.needTouchTriggerEvent())) {
      this.mPTSticker.setTouchTriggerEvent(paramInt, paramFloat1, paramFloat2);
    }
  }
  
  public void setUnProjectionHitPoint(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (this.mPTSticker != null) {
      this.mPTSticker.setUnProjectionHitPoint(paramArrayOfFloat, paramBoolean);
    }
  }
  
  public void setmAIBeautyValid(boolean paramBoolean)
  {
    this.mAIBeautyValid = paramBoolean;
  }
  
  public void setmEnableComparison(boolean paramBoolean)
  {
    this.mEnableComparison = paramBoolean;
  }
  
  public void setmNeedAgeDetect(boolean paramBoolean)
  {
    this.mNeedAgeDetect = paramBoolean;
  }
  
  public void setmNeedBodyDetect(boolean paramBoolean)
  {
    this.mNeedBodyDetect = paramBoolean;
  }
  
  public void setmNeedGenderDetect(boolean paramBoolean)
  {
    this.mNeedGenderDetect = paramBoolean;
  }
  
  public void stickerReset(boolean paramBoolean)
  {
    this.stickerReset = paramBoolean;
    if (this.mPTSticker != null) {
      this.mPTSticker.reset();
    }
  }
  
  public void supportMultiThreads(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      com.tencent.ttpic.openapi.filter.GaussianMaskFilter.reuseFilter = paramBoolean;
      return;
    }
  }
  
  public void switchFilterListOn(List<Integer> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switchFilterOn(((Integer)paramList.next()).intValue(), paramBoolean);
      }
    }
  }
  
  public void switchFilterOn(int paramInt, boolean paramBoolean)
  {
    this.mFilterEnableMap.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
  
  public void toggleDetectors(Map<AEDetectorType, Boolean> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.mAiCtrl.switchModule((AEDetectorType)localEntry.getKey(), ((Boolean)localEntry.getValue()).booleanValue());
    }
  }
  
  public void updateDiyCache(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      stickerReset(true);
    }
    if (paramBoolean1)
    {
      VideoMemoryManager.getInstance().setVideoPath(paramString2);
      return;
    }
    VideoMemoryManager.getInstance().updateCache(paramString1, paramString2);
  }
  
  public void updateFaceTransform(PTFaceAttr paramPTFaceAttr)
  {
    boolean bool;
    if ((this.mPTFaceTransform != null) && (this.hasApplyPTFaceTransform))
    {
      if (!this.closeAIBeautyConfig) {
        break label357;
      }
      this.mPTFaceTransform.closeAIBeautyConfig();
      AEFaceTransform localAEFaceTransform = this.mPTFaceTransform;
      if (this.closeAIBeautyConfig) {
        break label378;
      }
      bool = true;
      label42:
      localAEFaceTransform.setAgeDetectOn(bool);
      this.mPTFaceTransform.setAIBeautyValid(this.mAIBeautyValid);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.FOREHEAD, this.transForehead);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.EYE, this.transEye);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.EYE_DISTANCE, this.transEyeDistance);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.EYE_ANGLE, this.transEyeAngle);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.MOUTH_SHAPE, this.transMouthShape);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.CHIN, this.transChin);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.FACE_THIN, this.transFaceThin);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.FACE_V, this.transFaceV);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.NOSE_WING, this.transNoseWing);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.NOSE_POSITION, this.transNosePosition);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.LIPS_THICKNESS, this.transLipsThickness);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.LIPS_WIDTH, this.transLipsWidth);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.NOSE, this.transNose);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.CHEEKBONE_THIN, this.transCheekboneThin);
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.FACE_SHORTEN, this.transFaceShorten);
      if (!AEModule.isEnableDefaultBasic3()) {
        break label383;
      }
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.BASIC3, this.transBasic3);
    }
    for (;;)
    {
      this.mPTFaceTransform.setPointUpdate(this.pointUpdate);
      if (isDetectorOn(AEDetectorType.HAIR_SEGMENT)) {
        this.mPTFaceTransform.setAiAttr(this.mAiAttr);
      }
      this.mPTFaceTransform.setFaceStatus(paramPTFaceAttr.getAllFacePoints(), paramPTFaceAttr.getAllFaceAngles(), paramPTFaceAttr.getFaceStatusList(), this.mFaceDetectScale, this.phoneRotation);
      this.mPTFaceTransform.setFaceAttr(paramPTFaceAttr);
      return;
      label357:
      if (this.mAIBeautyParamsJsonBean == null) {
        break;
      }
      this.mPTFaceTransform.updateAgeSexBeautyConfig(this.mAIBeautyParamsJsonBean);
      break;
      label378:
      bool = false;
      break label42;
      label383:
      this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.BASIC4, this.transBasic4);
    }
  }
  
  public void updateLutGL(String paramString)
  {
    this.mLutPath = paramString;
    if ((this.mPTSticker != null) && (this.mPTSticker.isExcludeOuterEffectFilterMaterial()) && (!this.isAfterUpdateMaterial))
    {
      this.mPTSticker.stopInnerEffectFilter();
      if (this.stickerInnerLutFilterListener != null) {
        this.stickerInnerLutFilterListener.notifyEnableStickerInnerEffectFilter(false);
      }
    }
    for (;;)
    {
      this.isAfterUpdateMaterial = false;
      return;
      if ((this.mPTSticker != null) && (this.mPTSticker.isExcludeOuterEffectFilterMaterial()) && (this.isAfterUpdateMaterial))
      {
        if (this.stickerInnerLutFilterListener != null) {
          this.stickerInnerLutFilterListener.notifyEnableStickerInnerEffectFilter(true);
        }
        setFilterInSmooth(false);
      }
    }
  }
  
  public void updateMaterialGL(VideoMaterial paramVideoMaterial)
  {
    int i = 1;
    this.isAfterUpdateMaterial = true;
    if (this.mPTSticker != null)
    {
      boolean bool = this.mPTSticker.isExcludeOuterEffectFilterMaterial();
      this.mPTSticker.clear();
      this.mPTSticker = null;
      this.cosmeticsAlpha = 100;
      switchFilterOn(105, true);
      if ((this.mDisableFilters != null) && (this.mDisableFilters.size() > 0))
      {
        switchFilterListOn(this.mDisableFilters, true);
        this.mDisableFilters.clear();
      }
      if ((bool) && (this.stickerInnerLutFilterListener != null)) {
        this.stickerInnerLutFilterListener.notifyEnableStickerInnerEffectFilter(false);
      }
    }
    this.mVideoMaterial = paramVideoMaterial;
    AETipsManager.getInstance().setVideoMaterial(this.mVideoMaterial);
    if (this.mVideoMaterial != null)
    {
      PreviewPerformanceInfo.getInstance().setStickerID(this.mVideoMaterial.getId());
      this.filterConfigMap.clear();
      if (this.mVideoMaterial.getFiltersConfig() != null) {
        assembleFilters(this.mVideoMaterial.getFiltersConfig());
      }
      if (this.mPTFaceBeauty != null)
      {
        if (this.mPTFaceBeauty.isValid())
        {
          this.mPTFaceBeauty.setFaceFeatureParam(new FaceFeatureParam(0.8F));
          this.mPTFaceBeauty.setLipsLutAlpha(100);
          if (VideoMaterialUtil.hasValidFaceOffItem(this.mVideoMaterial)) {
            break label313;
          }
          if (i == 0)
          {
            this.mPTFaceBeauty.setFaceFeatureNormalAlpha(0.0F);
            this.mPTFaceBeauty.setFaceFeatureMultiplyAlpha(0.0F);
            this.mPTFaceBeauty.setFaceFeatureSoftlightAlpha(0.0F);
          }
        }
        this.mPTFaceBeauty.setShowFaceFeatureFilter(false);
      }
      else
      {
        if (this.mPTFaceTransform != null) {
          this.mPTFaceTransform.setNeedReCaculateFace(paramVideoMaterial.isNeedReCaculateFace());
        }
        if (this.mPTSmooth != null) {
          this.mPTSmooth.setFilterBlurStrength(this.mVideoMaterial.getFilterBlurStrength());
        }
      }
    }
    for (;;)
    {
      if (this.mAEProfiler != null) {
        this.mAEProfiler.reset();
      }
      return;
      label313:
      i = 0;
      break;
      if (this.mPTFaceBeauty != null) {
        this.mPTFaceBeauty.setShowFaceFeatureFilter(true);
      }
      if (this.mPTFaceTransform != null) {
        this.mPTFaceTransform.setNeedReCaculateFace(false);
      }
    }
  }
  
  public void updatePhoneRotation(int paramInt)
  {
    this.phoneRotation = paramInt;
  }
  
  public void updateWidthHeight(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.mFaceDetectScale = (this.FACE_DETECT_WIDTH / paramInt1);
    this.mViewAspectRatio = (paramInt1 / paramInt2);
    PreviewPerformanceInfo.getInstance().setResolution(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager
 * JD-Core Version:    0.7.0.1
 */