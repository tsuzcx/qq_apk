package com.tencent.aekit.api.standard.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.ai.AEDetector;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.api.supplement.filter.AEDenoiseFilter;
import com.tencent.aekit.api.supplement.filter.AESegmentForQQ;
import com.tencent.aekit.openrender.AEFilterChain;
import com.tencent.aekit.openrender.PTDebugConfig;
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
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.FaceColorCombineFilter;
import com.tencent.ttpic.openapi.filter.FaceFeatureParam;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.plugin.AICtrl;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.ttpicmodule.PTSegmenter;
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
import com.tencent.vbox.encode.VboxEncoder;
import com.tencent.vbox.util.VideoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AEFilterManager
{
  private static final String DEFAULT_COPY_ASSETS_DIR = Environment.getExternalStorageDirectory().getPath() + File.separator + "Tencent" + File.separator + "aekit";
  private static final String DEFAULT_VIDEO_DIR = "Tencent" + File.separator + "aekit";
  private static final SizeI NET_SIZE = new SizeI(320, 320);
  public static final String SET_AEPROFILER_OBJ = "SET_AEPROFILER_OBJ";
  public static final String SET_ENABLE_ASYNC_INIT_FILTERS = "SET_ENABLE_ASYNC_INIT_FILTERS";
  public static final String SET_ENDURANCE_TIME = "SET_ENDURANCE_TIME";
  public static final String SET_FILTERS_INITED_FIRST_FRAME = "SET_FILTERS_INITED_FIRST_FRAME";
  public static final String SET_FILTERS_INIT_PRIORITY = "SET_FILTERS_INIT_PRIORITY";
  private static final String TAG = AEFilterManager.class.getSimpleName();
  private static final String TEST_PIC = "sample_input_16_9_1080.jpg";
  private int FACE_DETECT_WIDTH = 180;
  private final boolean NOT_NEED_TRANSFORM;
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
  private int cosmeticsAlpha;
  private int decodeTexture;
  private int encodeTexture;
  private int exposureValue = 50;
  private boolean filterInSmooth = false;
  private boolean forceFaceDetect = false;
  private volatile boolean hasApplyPTFaceTransform = false;
  private int height;
  private ArrayList<RedPacketPosition> hotAreaPositions;
  private boolean isAfterUpdateMaterial;
  private boolean isClearMaskImgs;
  private boolean isLowLightEnv = false;
  private boolean isNeedPictureTest;
  private boolean isNeedSkipFrame;
  private boolean isNeedVideoTest;
  private boolean isVeryLowEndDevice = false;
  private float lookupLevel = 1.0F;
  private AEDetector mAEDetector;
  private AEFilterChain mAEFilterChain;
  private IAEProfiler mAEProfiler;
  private AESegmentForQQ mAESegment;
  private AIBeautyParamsJsonBean mAIBeautyParamsJsonBean;
  private boolean mAIBeautyValid;
  private AIAttr mAiAttr = null;
  private AICtrl mAiCtrl = new AICtrl();
  private AIParam mAiParam = new AIParam();
  private boolean mAsyncInitFilters;
  private String mCurVideoName;
  private AEDenoiseFilter mDenoiseFilter;
  private volatile boolean mDestroyed;
  private HashMap<AEDetectorType, Boolean> mDetectorMap = new HashMap();
  private boolean mEnableComparison = false;
  private FaceColorCombineFilter mFaceColorCombineFilter;
  private double mFaceDetectScale = 0.16666667163372D;
  private AEFaceLine mFaceLine;
  private Map<Integer, Boolean> mFilterEnableMap = new HashMap();
  private List<Integer> mFilterOrderList = new ArrayList();
  private int mFrameIndex;
  private List<Long> mFrameStamps;
  private volatile boolean mHasSubmitCreatePTFaceTransform = false;
  private String mInputVideo;
  private boolean mIsInitTestVideo;
  private boolean mIsInited = false;
  private float mLightSensorBrightness = 10.0F;
  private boolean mLogFlag = false;
  private String mLutPath;
  private boolean mNeedAgeDetect = false;
  private boolean mNeedBodyDetect = false;
  private boolean mNeedGenderDetect = false;
  private String mOutputVideo;
  private AEFilterGallery mPTEffectFilter;
  private AEFaceBeauty mPTFaceBeauty;
  private volatile AEFaceTransform mPTFaceTransform;
  private AELight mPTLight;
  private AESmooth mPTSmooth;
  private AESmoothPrev3 mPTSmoothPrev3;
  private AESticker mPTSticker;
  private float mPhoneRoll;
  private Bitmap mTestBmp;
  private Set<String> mTestVideoSet;
  private VboxDecoder mVideoDecoder;
  private VboxEncoder mVideoEncoder;
  private VideoMaterial mVideoMaterial;
  private boolean mVideoTestSwitch;
  private double mViewAspectRatio;
  private boolean needFaceDetect = false;
  private int outputTexture;
  private int phoneRotation;
  private boolean pointUpdate = false;
  private float[] rotationMatrix;
  private float[] segBgColor;
  private float[] segStrokeColor;
  private float segStrokeGapInPixel;
  private float segStrokeWidthInPixel;
  private int smoothLevel;
  private int smoothSharpenHeight;
  private float smoothSharpenStrength;
  private int smoothSharpenWidth;
  private AEFilterManager.StickerInnerEffectFilterListener stickerInnerLutFilterListener = null;
  private boolean stickerPause;
  private boolean stickerReset;
  private boolean stickerResume;
  private int[] testBmpTexture;
  private int[] testVideoTexture;
  private int[] textures = new int[1];
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
      this.isNeedVideoTest = false;
      this.testVideoTexture = new int[2];
      this.mTestVideoSet = new HashSet();
      this.mIsInitTestVideo = false;
      this.mVideoTestSwitch = false;
      this.mFrameStamps = new ArrayList();
      this.mFrameIndex = 0;
      this.beginVideoCodeProgress = false;
      this.isNeedSkipFrame = false;
      this.isClearMaskImgs = false;
      this.isAfterUpdateMaterial = false;
      this.mAEProfiler = AEProfiler.getInstance();
      this.hotAreaPositions = new ArrayList();
      this.mAsyncInitFilters = false;
      this.mDestroyed = false;
      this.smoothLevel = 0;
      this.smoothSharpenStrength = 1.2F;
      this.beautyColorTone = 50;
      this.cosmeticsAlpha = 100;
      this.segStrokeColor = new float[] { 1.0F, 1.0F, 1.0F, 1.0F };
      this.segBgColor = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      this.rotationMatrix = new float[16];
      disableAllFilters();
      setDefaultOrder();
      VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
      this.mAEFilterChain = new AEFilterChain();
      this.mAEDetector = new AEDetector();
      if (!FeatureManager.Features.MASK_IMAGES.isFunctionReady())
      {
        FeatureManager.Features.MASK_IMAGES.init();
        this.isClearMaskImgs = true;
      }
      return;
    }
  }
  
  private void chainFilters()
  {
    if (this.mAEProfiler != null) {
      this.mAEProfiler.startByTag("IAEProfiler-chainFilters");
    }
    this.mAEFilterChain.clearFilterList();
    Iterator localIterator = this.mFilterOrderList.iterator();
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
            if ((this.mPTSticker != null) && (this.mVideoMaterial != null))
            {
              this.mAEFilterChain.add(this.mPTSticker.getBeforeTransFilter());
              this.mPTSticker.updateCosAlpha(this.cosmeticsAlpha);
            }
            break;
          case 103: 
            if ((this.mPTSticker != null) && (this.mVideoMaterial != null))
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
            if ((this.mPTFaceTransform != null) && (this.hasApplyPTFaceTransform) && (!this.NOT_NEED_TRANSFORM)) {
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
              break label589;
            }
            PTFaceAttr localPTFaceAttr = (PTFaceAttr)this.mAiAttr.getRealtimeData(AEDetectorType.FACE.value);
            if (localPTFaceAttr == null) {
              break label589;
            }
            if (localPTFaceAttr.getFaceCount() > 0) {
              bool = true;
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      LogUtils.d(TAG, "[chainFilters] is SEGMENT, hasFace = " + bool);
      if ((this.mAESegment == null) || (!bool) || (!AIManager.getDetectorSet().contains(PTSegmenter.class))) {
        break;
      }
      this.mAEFilterChain.add(this.mAESegment);
      LogUtils.d(TAG, "[chainFilters] is SEGMENT, add AESegmentForQQ");
      break;
      bool = false;
      continue;
      if (this.mFaceLine == null) {
        break;
      }
      this.mAEFilterChain.add(this.mFaceLine);
      break;
      if (this.mAEProfiler != null) {
        this.mAEProfiler.endByTag("IAEProfiler-chainFilters");
      }
      return;
      label589:
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
  
  private void clearHotAreaBeforeProcess()
  {
    if (this.hotAreaPositions != null) {
      this.hotAreaPositions.clear();
    }
  }
  
  private void clearSharedResources()
  {
    GamePlaySDK.getInstance().clear();
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
    if (this.mAEProfiler != null) {
      this.mAEProfiler.startByTag("IAEProfiler-configFilters");
    }
    PTFaceAttr localPTFaceAttr2 = (PTFaceAttr)this.mAiAttr.getRealtimeData(AEDetectorType.FACE.value);
    if ((localPTFaceAttr2 != null) && (localPTFaceAttr2.getHistogram() != null)) {
      updateBeautyNormalFactor(((Integer)localPTFaceAttr2.getHistogram().first).intValue());
    }
    PTFaceAttr localPTFaceAttr1;
    int i;
    label129:
    Object localObject;
    if ((this.mPTSticker != null) && (this.mPTSticker.getFreezeFaceInfo() != null))
    {
      localPTFaceAttr1 = this.mPTSticker.getFreezeFaceInfo();
      if (this.mPTSticker != null) {
        this.mPTSticker.setHotAreaPositions(this.hotAreaPositions);
      }
      Iterator localIterator = this.mFilterEnableMap.entrySet().iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label1632;
      }
      localObject = (Map.Entry)localIterator.next();
      if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue()) {
        switch (((Integer)((Map.Entry)localObject).getKey()).intValue())
        {
        }
      }
    }
    for (;;)
    {
      break label129;
      localPTFaceAttr1 = localPTFaceAttr2;
      break;
      if (this.mPTSmooth != null)
      {
        this.mPTSmooth.setIsVeryLowEndDevice(this.isVeryLowEndDevice);
        this.mPTSmooth.setSmoothLevel(this.smoothLevel);
        this.mPTSmooth.setSharpenSize(this.smoothSharpenWidth, this.smoothSharpenHeight);
        this.mPTSmooth.setSharpenStrength(this.smoothSharpenStrength);
        this.mPTSmooth.setFaceAttr(localPTFaceAttr2);
        this.mPTSmooth.setExposureValue(this.exposureValue);
        if ((this.filterInSmooth) && (!TextUtils.isEmpty(this.mLutPath)))
        {
          this.mPTSmooth.setLookUpPath(this.mLutPath);
          this.mPTSmooth.setLookUpIntensity(this.lookupLevel);
        }
        else
        {
          this.mPTSmooth.setLookUpPath("");
          this.mPTSmooth.setLookUpIntensity(0.0F);
          continue;
          if (this.mPTSmoothPrev3 != null)
          {
            this.mPTSmoothPrev3.setSharpenFactor(0.0F);
            this.mPTSmoothPrev3.enableDenoise(true);
            this.mPTSmoothPrev3.setSmoothLevel(this.smoothLevel);
            this.mPTSmoothPrev3.setSharpenSize(this.smoothSharpenWidth, this.smoothSharpenHeight);
            this.mPTSmoothPrev3.setFaceStatus(localPTFaceAttr2, (int)(this.width * this.mFaceDetectScale), (int)(this.height * this.mFaceDetectScale), this.phoneRotation);
            continue;
            if ((this.mPTSticker != null) && (i == 0))
            {
              this.mPTSticker.setAIAttr(this.mAiAttr);
              this.mPTSticker.updateVideoSize(this.width, this.height, this.mFaceDetectScale);
              this.mPTSticker.setFaceAttr(localPTFaceAttr2);
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
                i = 1;
                break;
                this.mPTSticker.setSegAttr(null);
              }
              if (this.mPTFaceBeauty != null)
              {
                localObject = this.mPTFaceBeauty;
                if (!this.closeAIBeautyConfig) {}
                for (boolean bool = true;; bool = false)
                {
                  ((AEFaceBeauty)localObject).setLoadSo(bool);
                  this.mPTFaceBeauty.setVideoSize(this.width, this.height, this.mFaceDetectScale);
                  this.mPTFaceBeauty.setFaceAttr(localPTFaceAttr1);
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
                    break label908;
                  }
                  this.mPTFaceBeauty.setLipsLut(this.mVideoMaterial.getDataPath() + File.separator + this.mVideoMaterial.getLipsLutPath());
                  break;
                }
                label908:
                this.mPTFaceBeauty.setLipsLut("");
                continue;
                if ((this.mPTEffectFilter != null) && (!TextUtils.isEmpty(this.mLutPath)))
                {
                  this.mPTEffectFilter.updateLut(this.mLutPath);
                  continue;
                  if (this.mPTLight != null)
                  {
                    if ((localPTFaceAttr2 != null) && (localPTFaceAttr2.getHistogram() != null)) {
                      this.mPTLight.setHistogram((int[])localPTFaceAttr2.getHistogram().second);
                    }
                    this.mPTLight.setmLightSensorBrightness(this.mLightSensorBrightness);
                    this.mPTLight.setIsVeryLowEndDevice(this.isVeryLowEndDevice);
                    this.mPTLight.setSize(this.width, this.height);
                    this.isLowLightEnv = this.mPTLight.isLowLightEnv();
                    continue;
                    if ((this.mPTFaceTransform != null) && (this.hasApplyPTFaceTransform))
                    {
                      if (this.closeAIBeautyConfig)
                      {
                        this.mPTFaceTransform.closeAIBeautyConfig();
                        label1069:
                        localObject = this.mPTFaceTransform;
                        if (this.closeAIBeautyConfig) {
                          break label1415;
                        }
                        bool = true;
                        label1084:
                        ((AEFaceTransform)localObject).setAgeDetectOn(bool);
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
                          break label1420;
                        }
                        this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.BASIC3, this.transBasic3);
                      }
                      for (;;)
                      {
                        this.mPTFaceTransform.setPointUpdate(this.pointUpdate);
                        if (isDetectorOn(AEDetectorType.HAIR_SEGMENT)) {
                          this.mPTFaceTransform.setAiAttr(this.mAiAttr);
                        }
                        this.mPTFaceTransform.setFaceStatus(localPTFaceAttr1.getAllFacePoints(), localPTFaceAttr1.getAllFaceAngles(), localPTFaceAttr1.getFaceStatusList(), this.mFaceDetectScale, this.phoneRotation);
                        break;
                        if (this.mAIBeautyParamsJsonBean == null) {
                          break label1069;
                        }
                        this.mPTFaceTransform.updateAgeSexBeautyConfig(this.mAIBeautyParamsJsonBean);
                        break label1069;
                        label1415:
                        bool = false;
                        break label1084;
                        label1420:
                        this.mPTFaceTransform.setFaceTransformLevel(BeautyRealConfig.TYPE.BASIC4, this.transBasic4);
                      }
                      if (this.mFaceColorCombineFilter != null) {
                        if (localPTFaceAttr1.getCurve() != null)
                        {
                          this.mFaceColorCombineFilter.updateCurve(localPTFaceAttr1.getCurve(), false);
                          this.mFaceColorCombineFilter.enableBrightness(1);
                        }
                        else
                        {
                          this.mFaceColorCombineFilter.enableBrightness(0);
                          continue;
                          if (this.mDenoiseFilter != null)
                          {
                            this.mDenoiseFilter.setLowLightEnv(isLowLightEnv());
                            this.mDenoiseFilter.setVeryLowEndDevice(this.isVeryLowEndDevice);
                            continue;
                            if (this.mAESegment != null)
                            {
                              this.mAESegment.setSegAttr((PTSegAttr)this.mAiAttr.getRealtimeData(AEDetectorType.SEGMENT.value));
                              this.mAESegment.setStrokeWidthInPixel(this.segStrokeWidthInPixel);
                              this.mAESegment.setStrokeGapInPixel(this.segStrokeGapInPixel);
                              this.mAESegment.setStrokeColor(this.segStrokeColor);
                              this.mAESegment.setBgColor(this.segBgColor);
                              continue;
                              if (this.mFaceLine != null)
                              {
                                this.mFaceLine.updateVideoSize(this.width, this.height, this.mFaceDetectScale);
                                this.mFaceLine.setmFaceAttr(localPTFaceAttr2);
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
    label1632:
    if (this.mAEProfiler != null) {
      this.mAEProfiler.endByTag("IAEProfiler-configFilters");
    }
  }
  
  private Bitmap decodeBitmap(String paramString)
  {
    if ((AEModule.getContext() == null) || (paramString == null)) {
      return null;
    }
    paramString = DEFAULT_COPY_ASSETS_DIR + File.separator + paramString;
    return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 1);
  }
  
  private int decodeVideoFrame(int paramInt)
  {
    if (this.beginVideoCodeProgress)
    {
      if (this.mVideoDecoder.getNextFrameTexture() < 0)
      {
        stopVideoTest();
        this.isNeedSkipFrame = true;
      }
      paramInt = this.decodeTexture;
    }
    return paramInt;
  }
  
  private int detectFrame(int paramInt, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
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
    this.mAiParam.setModuleParam(AEDetectorType.EMOTION.value, "scale", Float.valueOf((float)this.mFaceDetectScale));
    this.mAiParam.setSurfaceTime(paramLong);
    AIInput localAIInput = new AIInput();
    localAIInput.setInputTexture(paramInt);
    this.mDetectorMap.clear();
    this.needFaceDetect = true;
    Object localObject = this.mDetectorMap;
    AEDetectorType localAEDetectorType = AEDetectorType.HAND;
    if (((this.mPTSticker != null) && (this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.GESTURE_STICKER))) || (PTDebugConfig.ENABLE_HAND_LINE))
    {
      paramBoolean = true;
      ((HashMap)localObject).put(localAEDetectorType, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.HAND)) {
        this.mAiParam.setModuleParam(AEDetectorType.HAND.value, "needDetectHandBone", Boolean.valueOf(this.mPTSticker.needDetectGestureBonePoint()));
      }
      localObject = this.mDetectorMap;
      localAEDetectorType = AEDetectorType.SEGMENT;
      if (((this.mPTSticker == null) || (!this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.SEGMENT_STICKER))) && (!PTDebugConfig.ENABLE_SEGMENT) && ((!this.mFilterOrderList.contains(Integer.valueOf(111))) || (!((Boolean)this.mFilterEnableMap.get(Integer.valueOf(111))).booleanValue()))) {
        break label955;
      }
      paramBoolean = true;
      label382:
      ((HashMap)localObject).put(localAEDetectorType, Boolean.valueOf(paramBoolean));
      localObject = this.mDetectorMap;
      localAEDetectorType = AEDetectorType.EMOTION;
      if ((this.mPTSticker == null) || (!this.mPTSticker.needDetectEmotion())) {
        break label960;
      }
      paramBoolean = true;
      label424:
      ((HashMap)localObject).put(localAEDetectorType, Boolean.valueOf(paramBoolean));
      localObject = this.mDetectorMap;
      localAEDetectorType = AEDetectorType.BODY;
      if ((!this.mNeedBodyDetect) && (!PTDebugConfig.ENABLE_BODY_BEAUTY) && ((this.mPTSticker == null) || (!this.mPTSticker.needDetectBody()))) {
        break label965;
      }
      paramBoolean = true;
      label479:
      ((HashMap)localObject).put(localAEDetectorType, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.BODY)) {
        this.mAiParam.setModuleParam(AEDetectorType.BODY.value, "scale", Float.valueOf((float)this.mFaceDetectScale));
      }
      localObject = this.mDetectorMap;
      localAEDetectorType = AEDetectorType.HAIR_SEGMENT;
      if (((this.mPTSticker == null) || (!VideoMaterialUtil.isHairSegMaterial(this.mVideoMaterial))) && (!PTDebugConfig.ENABLE_HAIRSEG)) {
        break label970;
      }
      paramBoolean = true;
      label561:
      ((HashMap)localObject).put(localAEDetectorType, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.HAIR_SEGMENT))
      {
        localObject = PTHairSegmenter.HAIR_SEGMENT.getCurrentSize();
        this.mAiParam.setModuleParam(AEDetectorType.HAIR_SEGMENT.value, "bytesDataSizeWidth", Integer.valueOf(((SizeI)localObject).width));
        this.mAiParam.setModuleParam(AEDetectorType.HAIR_SEGMENT.value, "bytesDataSizeHeight", Integer.valueOf(((SizeI)localObject).height));
      }
      localObject = this.mDetectorMap;
      localAEDetectorType = AEDetectorType.SKY_SEGMENT;
      if (((this.mPTSticker == null) || (!this.mPTSticker.checkStickerType(AESticker.STICKER_TYPE.SEGMENT_SKY_STICKER))) && (!PTDebugConfig.ENABLE_SKYSEG)) {
        break label975;
      }
      paramBoolean = true;
      label678:
      ((HashMap)localObject).put(localAEDetectorType, Boolean.valueOf(paramBoolean));
      if (isDetectorOn(AEDetectorType.SKY_SEGMENT))
      {
        localObject = PTSkySegmenter.SKY_SEGMENT.getCurrentSize();
        this.mAiParam.setModuleParam(AEDetectorType.SKY_SEGMENT.value, "bytesDataSizeWidth", Integer.valueOf(((SizeI)localObject).width));
        this.mAiParam.setModuleParam(AEDetectorType.SKY_SEGMENT.value, "bytesDataSizeHeight", Integer.valueOf(((SizeI)localObject).height));
        this.mAiParam.setRotationMatrix(this.rotationMatrix);
      }
      if ((this.mPTSticker == null) || (!this.mPTSticker.is3DCosMaterial())) {
        break label980;
      }
    }
    label955:
    label960:
    label965:
    label970:
    label975:
    label980:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mAiParam.setModuleParam(AEDetectorType.FACE.value, "FaceKit", Boolean.valueOf(paramBoolean));
      if (!this.mNeedGenderDetect)
      {
        paramBoolean = bool;
        if (this.mPTSticker == null) {}
      }
      else
      {
        paramBoolean = true;
      }
      this.mAiParam.setModuleParam(AEDetectorType.FACE.value, "enableGenderDetect", Boolean.valueOf(paramBoolean));
      this.mAiParam.setModuleParam(AEDetectorType.FACE.value, "enableAgeDetect", Boolean.valueOf(this.mNeedAgeDetect));
      ensureDetectorReady(this.mDetectorMap);
      toggleDetectors(this.mDetectorMap);
      this.mAiCtrl.switchModule(AEDetectorType.FACE.value, this.needFaceDetect);
      this.mAiAttr = this.mAEDetector.detectFrame(localAIInput, this.mAiParam, this.mAiCtrl);
      if (this.mAEProfiler != null) {
        this.mAEProfiler.endByTag("IAEProfiler-detectFrame");
      }
      return this.mAiAttr.getOutTexture();
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label382;
      paramBoolean = false;
      break label424;
      paramBoolean = false;
      break label479;
      paramBoolean = false;
      break label561;
      paramBoolean = false;
      break label678;
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
  
  private void encodeVideoFrame(int paramInt)
  {
    if ((paramInt == -1) || (!this.beginVideoCodeProgress)) {}
    do
    {
      do
      {
        return;
        if (this.isNeedSkipFrame)
        {
          this.isNeedSkipFrame = false;
          return;
        }
      } while ((this.mFrameStamps == null) || (this.mFrameIndex >= this.mFrameStamps.size()));
      if (this.mFrameIndex < 0)
      {
        this.mFrameIndex += 1;
        return;
      }
      this.mVideoEncoder.writeFrame(paramInt, ((Long)this.mFrameStamps.get(this.mFrameIndex)).longValue());
    } while (this.mFrameIndex >= this.mFrameStamps.size() - 1);
    this.mFrameIndex += 1;
  }
  
  private void endSaveVideoTolocal()
  {
    if ((this.mTestVideoSet != null) && (this.mTestVideoSet.size() > 0)) {
      this.mTestVideoSet.remove(this.mCurVideoName);
    }
    if ((this.mTestVideoSet != null) && (this.mTestVideoSet.size() > 0))
    {
      Log.e(TAG, "videoName:" + this.mCurVideoName + "encode complete!");
      startTestVideoIfNeed(true);
      return;
    }
    Log.e(TAG, "All Video encode complete!");
  }
  
  private void ensureCreateAndApplyPTFaceTransform()
  {
    if (this.mAsyncInitFilters)
    {
      if (this.mPTFaceTransform == null) {
        if (!this.mHasSubmitCreatePTFaceTransform)
        {
          this.mHasSubmitCreatePTFaceTransform = true;
          LogUtils.i(TAG, "submit create faceTransform action");
          new Thread(new AEFilterManager.1(this), "initFilters-faceTransform").start();
        }
      }
      while (this.hasApplyPTFaceTransform) {
        return;
      }
      this.mPTFaceTransform.apply();
      this.hasApplyPTFaceTransform = true;
      LogUtils.i(TAG, "apply faceTransform done");
      return;
    }
    if (this.mPTFaceTransform == null) {
      this.mPTFaceTransform = new AEFaceTransform();
    }
    this.mPTFaceTransform.apply();
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
  
  private void initFilters()
  {
    if ((this.mFilterEnableMap == null) || (this.mFilterEnableMap.isEmpty())) {
      LogUtils.w(TAG, "[initFilters] warning, filters is empty!");
    }
    long l1;
    label341:
    label383:
    do
    {
      return;
      l1 = 0L;
      if (!this.mLogFlag)
      {
        long l2 = SystemClock.uptimeMillis();
        l1 = l2;
        if (this.mAEProfiler != null)
        {
          this.mAEProfiler.startByTag("IAEProfiler-initFilters");
          l1 = l2;
        }
      }
      Iterator localIterator = this.mFilterEnableMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Boolean)localEntry.getValue()).booleanValue()) {
          switch (((Integer)localEntry.getKey()).intValue())
          {
          case 109: 
          case 112: 
          default: 
            break;
          case 101: 
            if (this.mPTSmooth == null) {
              this.mPTSmooth = new AESmooth();
            }
            this.mPTSmooth.apply();
            break;
          case 102: 
          case 103: 
            if ((this.mPTSticker == null) && (this.mVideoMaterial != null))
            {
              this.mPTSticker = new AESticker(this.mVideoMaterial, this.mAEDetector.getFaceDetector().getFaceDetector());
              if ((this.mPTSticker.isExcludeOuterEffectFilterMaterial()) && (this.stickerInnerLutFilterListener != null)) {
                this.stickerInnerLutFilterListener.notifyEnableStickerInnerEffectFilter(true);
              }
              if (this.mPTSticker.isUseMesh()) {
                switchFilterOn(105, false);
              }
              if ((!this.mPTSticker.isCosFunMaterial()) && (!this.mPTSticker.isMultiViewMaterial())) {
                break label383;
              }
              bool = true;
              this.pointUpdate = bool;
              if (this.mPTSticker.isExcludeOuterEffectFilterMaterial()) {
                break label389;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              setFilterInSmooth(bool);
              if (this.mPTSticker == null) {
                break;
              }
              this.mPTSticker.apply();
              break;
              bool = false;
              break label341;
            }
          case 110: 
            if (this.mPTSmoothPrev3 == null) {
              this.mPTSmoothPrev3 = new AESmoothPrev3();
            }
            this.mPTSmoothPrev3.apply();
            break;
          case 104: 
            if (this.mPTFaceBeauty == null) {
              this.mPTFaceBeauty = new AEFaceBeauty();
            }
            this.mPTFaceBeauty.apply();
            break;
          case 106: 
            if (this.mPTEffectFilter == null) {
              this.mPTEffectFilter = new AEFilterGallery();
            }
            this.mPTEffectFilter.apply();
            break;
          case 113: 
            if (this.mPTLight == null) {
              this.mPTLight = new AELight();
            }
            this.mPTLight.apply();
            break;
          case 105: 
            ensureCreateAndApplyPTFaceTransform();
            break;
          case 107: 
            if (this.mFaceColorCombineFilter == null) {
              this.mFaceColorCombineFilter = new FaceColorCombineFilter();
            }
            this.mFaceColorCombineFilter.ApplyGLSLFilter();
            break;
          case 108: 
            if (this.mDenoiseFilter == null) {
              this.mDenoiseFilter = new AEDenoiseFilter();
            }
            this.mDenoiseFilter.apply();
            break;
          case 111: 
            if (this.mAESegment == null) {
              this.mAESegment = new AESegmentForQQ();
            }
            this.mAESegment.apply();
            break;
          case 114: 
            if (this.mFaceLine == null) {
              this.mFaceLine = new AEFaceLine();
            }
            this.mFaceLine.apply();
          }
        }
      }
    } while (this.mLogFlag);
    label389:
    this.mLogFlag = true;
    if (this.mAEProfiler != null) {
      this.mAEProfiler.endByTag("IAEProfiler-initFilters");
    }
    LogUtils.i("CameraLaunchPerf", "initFilters cost duration=" + (SystemClock.uptimeMillis() - l1));
  }
  
  private void initVideoSet()
  {
    File[] arrayOfFile = Environment.getExternalStoragePublicDirectory(DEFAULT_VIDEO_DIR + File.separator + "inputVideo").listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfFile[i];
        if ((!((File)localObject).isDirectory()) && (((File)localObject).getName().endsWith(".mp4")))
        {
          localObject = ((File)localObject).getName();
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(".")).toString();
          this.mTestVideoSet.add(localObject);
        }
        i += 1;
      }
    }
    this.mIsInitTestVideo = true;
  }
  
  private void initVideoTest()
  {
    Log.e(TAG, "initVideoTest !");
    this.mFrameStamps = VideoUtil.getFramestamps(this.mInputVideo);
    if (this.mFrameStamps != null) {
      Collections.sort(this.mFrameStamps);
    }
    this.mVideoDecoder = VboxFactory.createDecoder(this.mInputVideo, 2);
    this.mVideoDecoder.setTexture(this.decodeTexture);
    this.mVideoEncoder = VboxFactory.createEncoder(this.mOutputVideo, this.width, this.height, 2);
    this.mFrameIndex = -1;
    this.beginVideoCodeProgress = true;
  }
  
  private boolean isLowLightEnv()
  {
    return this.isLowLightEnv;
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
    } while (this.mAESegment == null);
    Log.e("AEFilterManager", "AESegmentForQQ === " + this.mAESegment.printParamInfo());
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
  
  private void startTestVideoIfNeed(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.beginVideoCodeProgress)) {}
    do
    {
      do
      {
        return;
        if (!this.mIsInitTestVideo) {
          initVideoSet();
        }
      } while ((this.mTestVideoSet == null) || (this.mTestVideoSet.size() <= 0));
      this.mCurVideoName = ((String)this.mTestVideoSet.iterator().next());
      this.mInputVideo = (Environment.getExternalStoragePublicDirectory(new StringBuilder().append(DEFAULT_VIDEO_DIR).append(File.separator).append("inputVideo").toString()) + File.separator + this.mCurVideoName + ".mp4");
      this.mOutputVideo = (Environment.getExternalStoragePublicDirectory(new StringBuilder().append(DEFAULT_VIDEO_DIR).append(File.separator).append("outputVideo").toString()) + File.separator + this.mCurVideoName + ".mp4");
      Log.e(TAG, "videoName:" + this.mCurVideoName + "encode start!");
    } while (this.beginVideoCodeProgress);
    initVideoTest();
  }
  
  private void stopVideoTest()
  {
    Log.e(TAG, "stopVideoTest");
    if (this.mVideoDecoder != null) {
      this.mVideoDecoder.releaseDecoder();
    }
    if (this.mVideoEncoder != null) {
      this.mVideoEncoder.release();
    }
    this.beginVideoCodeProgress = false;
    endSaveVideoTolocal();
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
  
  public boolean canUseLargeImage()
  {
    return (this.mVideoMaterial == null) || ((!this.mVideoMaterial.isSegmentRequired()) && (!VideoMaterialUtil.isAudio2textMaterial(this.mVideoMaterial)) && (!VideoMaterialUtil.isAnimojiMaterial(this.mVideoMaterial)) && (!VideoMaterialUtil.isFilamentMaterial(this.mVideoMaterial)) && (!VideoMaterialUtil.isFilamentAnimojiMaterial(this.mVideoMaterial)) && (!VideoMaterialUtil.is3DMaterial(this.mVideoMaterial)));
  }
  
  public void constructFilters()
  {
    if ((this.mFilterEnableMap == null) || (this.mFilterEnableMap.isEmpty())) {
      LogUtils.w(TAG, "[initFilters] warning, filters is empty!");
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
          default: 
            break;
          case 102: 
          case 103: 
            if ((this.mPTSticker == null) && (this.mVideoMaterial != null))
            {
              this.mPTSticker = new AESticker(this.mVideoMaterial, this.mAEDetector.getFaceDetector().getFaceDetector());
              if ((this.mPTSticker.isExcludeOuterEffectFilterMaterial()) && (this.stickerInnerLutFilterListener != null)) {
                this.stickerInnerLutFilterListener.notifyEnableStickerInnerEffectFilter(true);
              }
              if ((this.mPTSticker.isCosFunMaterial()) || (this.mPTSticker.isMultiViewMaterial()))
              {
                bool = true;
                this.pointUpdate = bool;
                if (this.mPTSticker.isExcludeOuterEffectFilterMaterial()) {
                  break label277;
                }
              }
              for (boolean bool = true;; bool = false)
              {
                setFilterInSmooth(bool);
                break;
                bool = false;
                break label247;
              }
            }
            break;
          case 110: 
            if (this.mPTSmoothPrev3 == null) {
              this.mPTSmoothPrev3 = new AESmoothPrev3();
            }
            break;
          case 104: 
            if (this.mPTFaceBeauty == null) {
              this.mPTFaceBeauty = new AEFaceBeauty();
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
            label247:
            if (this.mFaceLine == null) {
              this.mFaceLine = new AEFaceLine();
            }
            label277:
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
      this.mFilterEnableMap.put(Integer.valueOf(k), Boolean.valueOf(true));
      this.mFilterOrderList.add(Integer.valueOf(k));
      i += 1;
    }
  }
  
  public void defineFiltersWithDefaultOrder(int... paramVarArgs)
  {
    disableAllFilters();
    setDefaultOrder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      int k = paramVarArgs[i];
      this.mFilterEnableMap.put(Integer.valueOf(k), Boolean.valueOf(true));
      i += 1;
    }
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
    if (this.isNeedVideoTest) {
      GLES20.glDeleteTextures(this.testVideoTexture.length, this.testVideoTexture, 0);
    }
    this.mIsInited = false;
    this.mDestroyed = true;
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
    boolean bool2 = false;
    int i = changeTextureIfNeed(this.isNeedPictureTest, paramInt);
    boolean bool1;
    if ((this.isNeedVideoTest) && (this.mVideoTestSwitch))
    {
      bool1 = true;
      startTestVideoIfNeed(bool1);
      if (!this.isNeedVideoTest) {
        break label265;
      }
    }
    label265:
    for (paramInt = decodeVideoFrame(paramInt);; paramInt = i)
    {
      if (this.mAEProfiler != null) {
        this.mAEProfiler.startByTag("IAEProfiler-drawFrame");
      }
      long l = PreviewPerformanceInfo.getMicTime().longValue();
      initFilters();
      paramInt = detectFrame(paramInt, paramBoolean, paramLong);
      if (this.mEnableComparison)
      {
        return paramInt;
        bool1 = false;
        break;
      }
      configFilters();
      chainFilters();
      if (!this.isNeedPictureTest)
      {
        paramBoolean = bool2;
        if (!this.isNeedVideoTest) {}
      }
      else
      {
        paramBoolean = true;
      }
      printFilterParamIfNeed(paramBoolean);
      clearHotAreaBeforeProcess();
      this.mAEFilterChain.process(paramInt, this.outputTexture, this.width, this.height);
      GLES20.glDisable(2929);
      if (this.isNeedVideoTest) {
        encodeVideoFrame(this.outputTexture);
      }
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
    return this.mAEDetector.getAIAttr();
  }
  
  public String getActionTips()
  {
    String str2 = "";
    String str1 = str2;
    if (this.mPTSticker != null)
    {
      str1 = str2;
      if (this.mPTSticker.getVideoMateral() != null) {
        str1 = this.mPTSticker.getVideoMateral().getTipsText();
      }
    }
    return str1;
  }
  
  public String getActionTipsIcon()
  {
    if ((this.mPTSticker != null) && (this.mPTSticker.getVideoMateral() != null)) {
      return this.mPTSticker.getVideoMateral().getTipsIcon();
    }
    return null;
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    if ((getAEDetector() == null) || (getAEDetector().getFaceDetector() == null)) {
      return null;
    }
    return getAEDetector().getFaceDetector().getFaceDetector();
  }
  
  public ArrayList<RedPacketPosition> getHotAreaPositions()
  {
    return this.hotAreaPositions;
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
      if (this.isNeedVideoTest)
      {
        GLES20.glGenTextures(this.testVideoTexture.length, this.testVideoTexture, 0);
        this.decodeTexture = this.testVideoTexture[0];
        this.encodeTexture = this.testVideoTexture[1];
      }
      this.outputTexture = this.textures[0];
      this.mAEFilterChain.init();
      if (this.mAEDetector.init() != 0) {
        break label153;
      }
    }
    label153:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mIsInited = bool1;
      return;
      bool1 = false;
      break;
    }
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
  
  public void setAIBeautyParamsJsonBean(AIBeautyParamsJsonBean paramAIBeautyParamsJsonBean)
  {
    this.closeAIBeautyConfig = false;
    this.mAIBeautyParamsJsonBean = paramAIBeautyParamsJsonBean;
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
    switch (AEFilterManager.2.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.smoothLevel = ((int)(paramInt * 0.6D));
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
    }
    this.transBasic3 = paramInt;
  }
  
  public void setCloseAIBeautyConfig(boolean paramBoolean)
  {
    this.closeAIBeautyConfig = paramBoolean;
  }
  
  public void setCosmeticsAlpha(int paramInt)
  {
    this.cosmeticsAlpha = paramInt;
  }
  
  public void setExposureValue(int paramInt)
  {
    this.exposureValue = paramInt;
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
  
  public void setIsAfterUpdateMaterial(boolean paramBoolean)
  {
    this.isAfterUpdateMaterial = paramBoolean;
  }
  
  public void setLookupLevel(float paramFloat)
  {
    this.lookupLevel = paramFloat;
  }
  
  public void setNeedPictureTest(boolean paramBoolean)
  {
    this.isNeedPictureTest = paramBoolean;
  }
  
  public void setNeedVideoTest(boolean paramBoolean)
  {
    this.isNeedVideoTest = paramBoolean;
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
        return;
        if (!paramString.equals("SET_AEPROFILER_OBJ")) {
          break;
        }
        i = 0;
        break;
        if (!paramString.equals("SET_ENABLE_ASYNC_INIT_FILTERS")) {
          break;
        }
        i = 1;
        break;
      } while ((paramObject == null) || (!(paramObject instanceof IAEProfiler)));
      this.mAEProfiler = ((IAEProfiler)paramObject);
      return;
    } while (!(paramObject instanceof Boolean));
    this.mAsyncInitFilters = ((Boolean)paramObject).booleanValue();
    LogUtils.i(TAG, "AEFilterManager--setParam asyncInitFilters: " + this.mAsyncInitFilters);
  }
  
  public void setPhoneRoll(float paramFloat)
  {
    this.mPhoneRoll = paramFloat;
  }
  
  public void setRotationMatrix(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.rotationMatrix, 0, 16);
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
    this.smoothLevel = paramInt;
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
  
  public void setVideoTestSwitch(boolean paramBoolean)
  {
    this.mVideoTestSwitch = paramBoolean;
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
      if ((bool) && (this.stickerInnerLutFilterListener != null)) {
        this.stickerInnerLutFilterListener.notifyEnableStickerInnerEffectFilter(false);
      }
    }
    this.mVideoMaterial = paramVideoMaterial;
    if (this.mVideoMaterial != null)
    {
      PreviewPerformanceInfo.getInstance().setStickerID(this.mVideoMaterial.getId());
      if (this.mPTFaceBeauty != null)
      {
        this.mPTFaceBeauty.setFaceFeatureParam(new FaceFeatureParam(0.8F));
        if (this.mPTFaceBeauty != null) {
          this.mPTFaceBeauty.setLipsLutAlpha(100);
        }
        if (VideoMaterialUtil.hasValidFaceOffItem(this.mVideoMaterial)) {
          break label196;
        }
        if (i == 0)
        {
          this.mPTFaceBeauty.setFaceFeatureNormalAlpha(0.0F);
          this.mPTFaceBeauty.setFaceFeatureMultiplyAlpha(0.0F);
          this.mPTFaceBeauty.setFaceFeatureSoftlightAlpha(0.0F);
        }
        this.mPTFaceBeauty.setShowFaceFeatureFilter(false);
      }
    }
    for (;;)
    {
      if (this.mAEProfiler != null) {
        this.mAEProfiler.reset();
      }
      return;
      label196:
      i = 0;
      break;
      if (this.mPTFaceBeauty != null) {
        this.mPTFaceBeauty.setShowFaceFeatureFilter(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager
 * JD-Core Version:    0.7.0.1
 */