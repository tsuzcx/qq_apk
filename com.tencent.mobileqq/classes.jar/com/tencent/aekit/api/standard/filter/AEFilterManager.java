package com.tencent.aekit.api.standard.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.hardware.SensorEvent;
import android.media.AudioTrack;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.ARDetect.ARDetectDataManager;
import com.tencent.aekit.openrender.AEFilterChain;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.IAEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.camerasdk.avreport.PreviewPerformanceInfo;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.filter.aifilter.AIImageFilterResult;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import com.tencent.ttpic.model.ArFrameInfo;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.AdjustRealConfig.TYPE;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.ICMShowHandle;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.listener.LightNodeAppliedListener;
import com.tencent.ttpic.openapi.listener.MaterialLoadFinishListener;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.plugin.AICtrl;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
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
import org.json.JSONObject;
import org.light.AudioOutput;
import org.light.CameraConfig.ImageOrigin;
import org.light.CameraController.CameraViewType;
import org.light.CameraController.CmShowCallback;
import org.light.CameraController.DisplayType;
import org.light.CameraController.MorphType;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.bean.WMElement;
import org.light.callback.ExternalRenderCallback;
import org.light.listener.IOnClickWatermarkListener;
import org.light.listener.LightAssetListener;
import org.light.listener.WatermarkDelegate;

public class AEFilterManager
  implements IWatermarkHandle, ICMShowHandle
{
  private static final int MAX_RENDER_LENGTH_FOR_STROKE = 1080;
  private static final int MIN_RENDER_LENGTH_FOR_STROKE = 640;
  private static final SizeI NET_SIZE = new SizeI(320, 320);
  public static final String SET_TEMP_FACEATTR = "SET_TEMP_FACEATTR";
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
  private float adjustAlpha = 1.0F;
  private HashMap<String, String> adjustParams;
  boolean assetListenerUpdated = false;
  private AudioOutput audioReader;
  private AudioTrack audioTrack;
  private int beautyContrastRatio;
  private int beautyEyeLighten;
  private float beautyNormalAlpha;
  private int beautyRemovePounch;
  private int beautyRemoveWrinkles;
  private int beautyRemoveWrinkles2;
  private int beautySkinColor = 50;
  private int beautySkinLevel;
  private int beautyToothWhiten;
  private boolean beautyUpdated = true;
  private boolean beginVideoCodeProgress = false;
  private HashMap<String, String> bundlePathMap = new HashMap();
  private boolean closeAIBeautyConfig = false;
  private int colorTemperature = 0;
  private int compareLevel = 0;
  private Map<String, String> configData;
  private int cosmeticsAlpha = 100;
  private int decodeTexture;
  private BeautyRealConfig.TYPE defaultTransBasicType = BeautyRealConfig.TYPE.BASIC4;
  private String[] deviceSupportAbility = { "ai.segment", "ai.segmentHair", "ai.face3d", "3d.kapu", "ai.catFace", "ai.body", "ai.gender", "ai.expression" };
  private int encodeTexture;
  ExternalRenderCallback externalRenderCallback;
  private boolean externalRenderUpdated = true;
  private Map<String, String> extraConfigData = new HashMap();
  private boolean extraConfigUpdated = false;
  private PTFaceAttr faceAttrInLight;
  private boolean faceDataUpdated = false;
  private int fadeLevel = 0;
  private HashMap<Integer, Boolean> filterConfigMap = new HashMap();
  private HashMap<String, String> filterInLightNodeMap;
  private boolean filterInLightUpdated = true;
  private boolean filterInSmooth = false;
  private boolean forceFaceDetect = true;
  private float glowAlpha;
  private volatile boolean hasApplyPTFaceTransform = false;
  private int height;
  private int hightLightLevel = 0;
  private boolean isAfterUpdateMaterial = false;
  private boolean isLowLightEnv = false;
  private boolean isNeedPictureTest = false;
  private boolean isNeedSkipFrame = false;
  private boolean isOverallSmooth = false;
  private boolean isVeryLowEndDevice = false;
  private CameraConfig.ImageOrigin lightInputOriention = CameraConfig.ImageOrigin.BottomLeft;
  private LightNodeAppliedListener lightNodeAppliedListener;
  private int lightnessLevel = 0;
  private int longLeg;
  private float lookupLevel = 1.0F;
  private boolean lutUpdated = true;
  private AEFilterChain mAEFilterChain;
  private IAEProfiler mAEProfiler = AEProfiler.getInstance();
  private AIBeautyParamsJsonBean mAIBeautyParamsJsonBean = null;
  private boolean mAIBeautyValid = true;
  private List<AEChainI> mAIFilterList;
  private AEAdjust mAdjust;
  private AIAttr mAiAttr = null;
  private AICtrl mAiCtrl = new AICtrl();
  private AIParam mAiParam = new AIParam();
  private boolean mAsyncInitFilters = false;
  private boolean mAutoTest = false;
  private String mAutoTestSmoothVersion;
  private int mAutoTestSourceType = 0;
  private volatile boolean mDestroyed = false;
  private Map<Integer, Boolean> mFilterNodeEnableMap = new LinkedHashMap();
  private List<Integer> mFilterOrderList = new ArrayList();
  private int mFrameIndex = 0;
  private AEGlow mGlow;
  private volatile boolean mHasSubmitCreatePTFaceTransform = false;
  private boolean mIsInited = false;
  private LightAssetListener mLightAssetListener;
  private LightNode mLightNode;
  private boolean mLogFlag = false;
  private String mLutPath;
  private float mPhoneRoll;
  private PhotoAIFilter mPhotoAIFilter;
  private Bitmap mPickUpBitmap;
  private List<Bitmap> mPickUpBitmapList = new ArrayList();
  private Bitmap mTestBmp = null;
  private LightNode.ILightNodeTipsListener mTipsListener;
  private VideoMaterial mVideoMaterial;
  private double mViewAspectRatio;
  private IOnClickWatermarkListener mWatermarkClickListener;
  private MaterialLoadFinishListener materialLoadFinishListener;
  private boolean needFaceDetect = false;
  private boolean needUpdateAIFilter = true;
  private int outputTexture;
  private boolean pendingToSetBundles = false;
  private int phoneRotation;
  private boolean previewSizeUpdated = true;
  private PTFaceAttr ptFaceAttr;
  private ImageStatisticsData resultData;
  private float[] rotationMatrix = new float[16];
  private int saturationLevel = 0;
  private int segBgColor = Color.argb(0, 0, 0, 0);
  private int segStrokeColor = Color.argb(255, 255, 255, 255);
  private float segStrokeGapInPixel;
  private float segStrokeWidthInPixel;
  private int segmentFrames = 0;
  private boolean segmentUpdated = true;
  private String selectedBasicTransType;
  private int selectedBasicTransValue;
  private int shadowLevel = 0;
  private int sharpLevel = 0;
  private int slimWaist;
  private List<Bitmap> smartBitmapList = new ArrayList();
  private int smoothLevel = 0;
  private float smoothSharpenStrength = 1.2F;
  private boolean smoothUpdated = true;
  private final String smoothVersion;
  private AEFilterManager.MaterialInnerEffectListener stickerInnerLutFilterListener = null;
  private boolean syncMode = false;
  private boolean syncModeUpdated = false;
  private int[] testBmpTexture = new int[1];
  private int[] textures = new int[1];
  private int thinBody;
  private int thinShoulder;
  boolean tipsListenerUpdated = false;
  private int transBasic3;
  private int transBasic4;
  private int transBasic5;
  private int transBasic6;
  private int transBasic7;
  private int transBasic8;
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
  private int useLutType = 1001;
  private int useMeshType = 2001;
  private int width;
  boolean wmClickListenerUpdated = false;
  private HashMap<String, WatermarkDelegate> wmDelegateMap = new HashMap();
  boolean wmOnlineUsrCountDelegateUpdated = false;
  private Thread writePCMThread;
  
  public AEFilterManager()
  {
    this("defaultBeautyV6.json");
  }
  
  public AEFilterManager(String paramString)
  {
    this.smoothVersion = paramString;
    setDefaultOrder();
    this.mAEFilterChain = new AEFilterChain();
    initAudioTrack();
  }
  
  private void chainFilters()
  {
    if (this.mAEProfiler != null) {
      this.mAEProfiler.startByTag("IAEProfiler-chainFilters");
    }
    this.mAEFilterChain.clearFilterList();
    Iterator localIterator = this.mFilterOrderList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (((Boolean)this.mFilterNodeEnableMap.get(Integer.valueOf(i))).booleanValue()) {
        switch (i)
        {
        default: 
          break;
        case 100: 
          if (this.mLightNode != null) {
            this.mAEFilterChain.add(this.mLightNode);
          }
          break;
        case 200: 
          if (this.mAdjust != null) {
            this.mAEFilterChain.add(this.mAdjust);
          }
          break;
        case 300: 
          if (this.mGlow != null) {
            this.mAEFilterChain.add(this.mGlow);
          }
          break;
        }
      }
    }
    if (this.mAEProfiler != null) {
      this.mAEProfiler.endByTag("IAEProfiler-chainFilters");
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
  
  private void clearSharedResources()
  {
    ShaderManager.getInstance().clear();
    FrameBufferCache.getInstance().destroy();
    RetrieveDataManager.getInstance().clear();
    PreviewPerformanceInfo.getInstance().destroy();
  }
  
  private void configFilters()
  {
    if (this.mAEProfiler != null)
    {
      this.mAEProfiler.startByTag("IAEProfiler-configFilters");
      this.mAEProfiler.startByTag("IAEProfiler-waitFaceTime");
    }
    if (this.mAEProfiler != null) {
      this.mAEProfiler.endByTag("IAEProfiler-waitFaceTime");
    }
    Iterator localIterator = this.mFilterNodeEnableMap.entrySet().iterator();
    label264:
    label1550:
    label1569:
    label1574:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      label1105:
      if (((Boolean)localEntry.getValue()).booleanValue())
      {
        AEProfiler.getInstance().start("IAEProfiler-configFilters-" + localEntry.getKey(), true);
        switch (((Integer)localEntry.getKey()).intValue())
        {
        }
        label337:
        label1752:
        for (;;)
        {
          AEProfiler.getInstance().end("IAEProfiler-configFilters-" + localEntry.getKey(), true);
          break;
          if (this.mLightNode != null)
          {
            if ((this.mAutoTest) && (this.mAutoTestSourceType == 0)) {
              break;
            }
            Object localObject = this.mLightNode;
            boolean bool;
            label1138:
            Map localMap;
            if ((this.mAutoTest) && (this.mAutoTestSourceType > 1))
            {
              bool = true;
              ((LightNode)localObject).setAutoTest(bool);
              if (this.mAutoTest)
              {
                localObject = this.mLightNode;
                int i = this.mFrameIndex;
                this.mFrameIndex = (i + 1);
                ((LightNode)localObject).setFrameIndex(i);
              }
              if (this.mVideoMaterial != null) {
                this.mLightNode.updateAsset(this.mVideoMaterial.getLightAsset());
              }
              if (this.configData != null) {
                break label1509;
              }
              this.configData = new HashMap();
              if (this.smoothUpdated)
              {
                this.configData.put("smooth.smooth", formatDecimalValue(this.smoothLevel));
                this.configData.put("smooth.overallSmooth", formatBooleanValue(this.isOverallSmooth));
                this.configData.put("smooth.isVeryLowEndDevice", formatBooleanValue(this.isVeryLowEndDevice));
                this.configData.put("smooth.sharpen", "" + this.smoothSharpenStrength);
                this.configData.put("smooth.curveAdjustAlpha", formatDecimalValue(0));
                this.configData.put("smooth.facecoloralpha", formatDecimalValue(0));
                this.smoothUpdated = false;
              }
              if (this.beautyUpdated)
              {
                this.configData.put("body.legStretch", formatDecimalValue(this.longLeg));
                this.configData.put("body.thinShoulderStrength", formatDecimalValue(this.slimWaist));
                this.configData.put("body.thinBodyStrength", formatDecimalValue(this.thinBody));
                this.configData.put("body.waistStrength", formatDecimalValue(this.thinShoulder));
                this.configData.put("beauty.faceFeature", "" + this.beautyNormalAlpha);
                this.configData.put("beauty.eyeLighten", formatDecimalValue(this.beautyEyeLighten));
                this.configData.put("beauty.toothWhiten", formatDecimalValue(this.beautyToothWhiten));
                this.configData.put("beauty.removeEyeBags", formatDecimalValue(this.beautyRemovePounch));
                this.configData.put("beauty.removeWrinkle", formatDecimalValue(this.beautyRemoveWrinkles));
                this.configData.put("beauty.removeLawLine", formatDecimalValue(this.beautyRemoveWrinkles2));
                this.configData.put("beauty.skinColor", formatDecimalValue(this.beautySkinColor));
                this.configData.put("beauty.imageContrastAlpha", formatDecimalValue(this.beautyContrastRatio));
                this.configData.put("stretch.forehead", formatDecimalValue(this.transForehead));
                this.configData.put("stretch.enlargeEye", formatDecimalValue(this.transEye));
                this.configData.put("stretch.eyeDistance", formatDecimalValue(this.transEyeDistance));
                this.configData.put("stretch.eyeAngle", formatDecimalValue(this.transEyeAngle));
                this.configData.put("stretch.mouthSize", formatDecimalValue(this.transMouthShape));
                this.configData.put("stretch.chin", formatDecimalValue(this.transChin));
                this.configData.put("stretch.thinFace", formatDecimalValue(this.transFaceThin));
                this.configData.put("stretch.vFace", formatDecimalValue(this.transFaceV));
                this.configData.put("stretch.noseWing", formatDecimalValue(this.transNoseWing));
                this.configData.put("stretch.noseHeight", formatDecimalValue(this.transNosePosition));
                this.configData.put("stretch.mouthHeight", formatDecimalValue(this.transLipsThickness));
                if (this.selectedBasicTransType != null) {
                  this.configData.put(this.selectedBasicTransType, formatDecimalValue(this.selectedBasicTransValue));
                }
                this.configData.put("stretch.shortFace", formatDecimalValue(this.transFaceShorten));
                this.configData.put("stretch.thinNose", formatDecimalValue(this.transNose));
                this.beautyUpdated = false;
              }
              if ((this.isAfterUpdateMaterial) || (this.lutUpdated))
              {
                if (this.useLutType != 1001) {
                  break label1521;
                }
                switchAbilityInLightNode("basicLUT.enable", true);
                switchAbilityInLightNode("materialLUT.enable", false);
                if (this.isAfterUpdateMaterial)
                {
                  if (this.useMeshType != 2000) {
                    break label1550;
                  }
                  switchAbilityInLightNode("basicMesh.enable", false);
                  switchAbilityInLightNode("materialMesh.enable", true);
                  if (this.mVideoMaterial.getLightAsset().hasMakeup()) {
                    break label1569;
                  }
                  bool = true;
                  switchAbilityInLightNode("beauty.faceFeature.enable", bool);
                  this.isAfterUpdateMaterial = false;
                }
                if (this.lutUpdated)
                {
                  localMap = this.configData;
                  if (this.mLutPath != null) {
                    break label1574;
                  }
                }
              }
            }
            for (localObject = "";; localObject = this.mLutPath)
            {
              localMap.put("lut.src", localObject);
              this.configData.put("lut.intensity", formatDecimalValue(100));
              this.lutUpdated = false;
              if ((this.filterInLightNodeMap != null) && (this.filterInLightNodeMap.size() > 0))
              {
                LogUtils.d("AEFilterManager", "[configFilters] 独立开关能力项配置：" + this.filterInLightNodeMap.toString());
                this.configData.putAll(this.filterInLightNodeMap);
                this.filterInLightNodeMap.clear();
              }
              if (this.extraConfigUpdated)
              {
                this.configData.putAll(this.extraConfigData);
                this.extraConfigData.clear();
                this.extraConfigUpdated = false;
              }
              if (this.configData.size() > 0)
              {
                LogUtils.d("AEFilterManager", "[configFilters] 基础美参数设置：" + this.configData.toString());
                this.mLightNode.updateCameraConfigData(this.configData);
              }
              if (this.previewSizeUpdated)
              {
                this.mLightNode.updatePreviewSize(this.width, this.height);
                LogUtils.d("AEFilterManager", "[configFilters] 渲染尺寸更新");
                this.previewSizeUpdated = false;
              }
              if (this.externalRenderUpdated)
              {
                if (this.externalRenderCallback != null) {
                  this.mLightNode.setExternalRenderCallback(this.externalRenderCallback);
                }
                LogUtils.d("AEFilterManager", "[configFilters] 外挂滤镜更新");
                this.externalRenderUpdated = false;
              }
              if (this.syncModeUpdated)
              {
                this.syncModeUpdated = false;
                this.mLightNode.setSyncMode(this.syncMode);
              }
              if (!this.faceDataUpdated) {
                break;
              }
              this.faceDataUpdated = false;
              this.mLightNode.setPtFaceAttr(this.ptFaceAttr);
              break;
              bool = false;
              break label264;
              label1509:
              this.configData.clear();
              break label337;
              label1521:
              if (this.useLutType != 1000) {
                break label1105;
              }
              switchAbilityInLightNode("basicLUT.enable", false);
              switchAbilityInLightNode("materialLUT.enable", true);
              break label1105;
              switchAbilityInLightNode("basicMesh.enable", true);
              switchAbilityInLightNode("materialMesh.enable", false);
              break label1138;
              bool = false;
              break label1153;
            }
            if (this.mAdjust != null)
            {
              this.mAdjust.setAlpha(this.adjustAlpha);
              if (this.adjustParams == null) {
                break label1639;
              }
              this.mAdjust.setAdjustParams(this.adjustParams);
            }
            for (;;)
            {
              if (this.mGlow == null) {
                break label1752;
              }
              this.mGlow.setAlpha(this.glowAlpha);
              break;
              label1639:
              this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.LIGHTNESS, this.lightnessLevel);
              this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.HIGHLIGHT, this.hightLightLevel);
              this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.SHADOW, this.shadowLevel);
              this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.COMPARE, this.compareLevel);
              this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.SHARP, this.sharpLevel);
              this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.SATURATION, this.saturationLevel);
              this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.COLOR_TEMPERATURE, this.colorTemperature);
              this.mAdjust.setAdjustLevel(AdjustRealConfig.TYPE.FADE, this.fadeLevel);
            }
          }
        }
      }
    }
    label1153:
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
  
  private String formatBooleanValue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "true";
    }
    return "false";
  }
  
  private String formatDecimalValue(int paramInt)
  {
    return Float.toString(paramInt / 100.0F);
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
  
  private void initAudioTrack()
  {
    this.audioTrack = new AudioTrack(3, 44100, 12, 2, AudioTrack.getMinBufferSize(44100, 12, 2) * 2, 1);
    this.audioTrack.setStereoVolume(1.0F, 1.0F);
  }
  
  private void initBundlePathsForLightNode()
  {
    if (this.pendingToSetBundles)
    {
      Iterator localIterator = this.bundlePathMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry != null) {
          setLightBundle((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      this.bundlePathMap.clear();
      this.pendingToSetBundles = false;
    }
  }
  
  private void initFilters()
  {
    if ((this.mFilterNodeEnableMap == null) || (this.mFilterNodeEnableMap.isEmpty())) {
      LogUtils.w("AEFilterManager", "[initFilters] warning, filters is empty!");
    }
    long l1;
    label293:
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
      System.currentTimeMillis();
      Iterator localIterator = this.mFilterNodeEnableMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Boolean)localEntry.getValue()).booleanValue()) {
          switch (((Integer)localEntry.getKey()).intValue())
          {
          default: 
            break;
          case 100: 
            if (this.mLightNode == null) {
              if (this.mAutoTestSmoothVersion == null) {
                break label293;
              }
            }
            for (this.mLightNode = new LightNode(this.mAutoTestSmoothVersion);; this.mLightNode = new LightNode(this.smoothVersion))
            {
              LogUtils.d("testSmoothVersion", "[BeautyVersion] ver:" + this.smoothVersion);
              this.mLightNode.setApplyListener(new AEFilterManager.2(this));
              initBundlePathsForLightNode();
              initListenersForLightNode();
              this.mLightNode.initPreviewSize(this.width, this.height);
              this.mLightNode.setInputOrigin(this.lightInputOriention);
              this.mLightNode.apply();
              this.mIsInited = true;
              break;
            }
          case 200: 
            if (this.mAdjust == null) {
              this.mAdjust = new AEAdjust();
            }
            this.mAdjust.apply();
            break;
          case 300: 
            if (this.mGlow == null) {
              this.mGlow = new AEGlow();
            }
            this.mGlow.applyFilterChain(false, this.width, this.height);
          }
        }
      }
    } while (this.mLogFlag);
    this.mLogFlag = true;
    if (this.mAEProfiler != null) {
      this.mAEProfiler.endByTag("IAEProfiler-initFilters");
    }
    LogUtils.i("CameraLaunchPerf", "initFilters cost duration=" + (SystemClock.uptimeMillis() - l1));
  }
  
  private void initListenersForLightNode()
  {
    if (this.tipsListenerUpdated)
    {
      this.mLightNode.setLightNodeTipsListener(new AEFilterManager.3(this));
      this.tipsListenerUpdated = false;
    }
    if (this.wmClickListenerUpdated)
    {
      this.mLightNode.setOnClickWatermarkListener(this.mWatermarkClickListener);
      this.wmClickListenerUpdated = false;
    }
    if (this.wmOnlineUsrCountDelegateUpdated)
    {
      Iterator localIterator = this.wmDelegateMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry != null) {
          this.mLightNode.setGetOnlineUsrCountDelegate((String)localEntry.getKey(), (WatermarkDelegate)localEntry.getValue());
        }
      }
      this.wmOnlineUsrCountDelegateUpdated = false;
    }
    if (this.assetListenerUpdated)
    {
      this.assetListenerUpdated = false;
      this.mLightNode.setLightNodeLightAssetListener(new AEFilterManager.4(this));
    }
  }
  
  private void initWritePCMThread()
  {
    if (this.writePCMThread == null)
    {
      this.writePCMThread = new Thread(new AEFilterManager.1(this));
      this.writePCMThread.start();
    }
  }
  
  private boolean isDeviceSupportMaterial(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getLightAsset() == null))
    {
      LogUtils.e("AEFilterManager", "can not support because videoMaterial is null or lightAsset is null!");
      return false;
    }
    String[] arrayOfString = this.deviceSupportAbility;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if ((paramVideoMaterial.getLightAsset().needRenderAbility(str)) && (!LightEngine.isDeviceAbilitySupported(str)))
      {
        LogUtils.e("AEFilterManager", "can not support ability " + str);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private String mapWeatherCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "晴";
    case 1: 
      return "多云";
    case 2: 
      return "阴";
    case 3: 
      return "雨";
    case 4: 
      return "雪";
    case 5: 
      return "雾";
    case 6: 
      return "雨加雪";
    case 7: 
      return "雷阵雨";
    case 8: 
      return "沙尘暴";
    }
    return "大风";
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
    while (this.mGlow == null) {
      return;
    }
    Log.e("AEFilterManager", "AEGlow === " + this.mGlow.printParamInfo());
  }
  
  private void setDefaultOrder()
  {
    this.mFilterOrderList.clear();
    this.mFilterOrderList.add(Integer.valueOf(100));
    this.mFilterNodeEnableMap.put(Integer.valueOf(100), Boolean.valueOf(true));
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
  
  private void updateAIFilter()
  {
    if (!this.needUpdateAIFilter) {
      this.needUpdateAIFilter = true;
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
  
  private void updateTips() {}
  
  public void addMaskTouchPoint(PointF paramPointF, int paramInt)
  {
    if ((this.mLightNode != null) && (this.mLightNode.isApplied()) && (this.mLightNode.getAsset() != null) && (this.mLightNode.getAsset().stickerNeedMaskRecordTouchPoint()) && (paramInt > 0) && (paramPointF != null))
    {
      float f = this.width / paramInt;
      paramPointF.x *= f;
      paramPointF.y = (f * paramPointF.y);
      paramPointF = "{\n\"x\":\"" + String.valueOf(paramPointF.x) + "\",\n\"y\":\"" + String.valueOf(paramPointF.y) + "\"\n}";
      Log.d("AEFilterManager", "addMaskTouchPoint: jsonStr=" + paramPointF);
      this.mLightNode.setPresetData("event.paintPoint", paramPointF);
    }
  }
  
  public boolean canUseLargeImage()
  {
    return (this.mVideoMaterial == null) || ((!this.mVideoMaterial.needBodySegment()) && (!this.mVideoMaterial.isSticker3DMaterial()) && (!this.mVideoMaterial.isFace3DMaterial()));
  }
  
  public void cmShowSetKapuAnimation(String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    if (this.mLightNode != null) {
      this.mLightNode.cmShowSetKapuAnimation(paramString, paramCmShowCallback);
    }
  }
  
  public void cmShowSetKapuCameraViewType(CameraController.CameraViewType paramCameraViewType)
  {
    if (this.mLightNode != null) {
      this.mLightNode.cmShowSetKapuCameraViewType(paramCameraViewType);
    }
  }
  
  public void cmShowSetKapuDisplayType(CameraController.DisplayType paramDisplayType)
  {
    if (this.mLightNode != null) {
      this.mLightNode.cmShowSetKapuDisplayType(paramDisplayType);
    }
  }
  
  public void cmShowSetKapuModel(HashMap<String, String> paramHashMap, String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    if (this.mLightNode != null) {
      this.mLightNode.cmShowSetKapuModel(paramHashMap, paramString, paramCmShowCallback);
    }
  }
  
  public void cmShowUpdateKapuMorph(CameraController.MorphType paramMorphType)
  {
    if (this.mLightNode != null) {
      this.mLightNode.cmShowUpdateKapuMorph(paramMorphType);
    }
  }
  
  public void cmShowUpdateTouchRotate(float[] paramArrayOfFloat)
  {
    if (this.mLightNode != null) {
      this.mLightNode.cmShowUpdateTouchRotate(paramArrayOfFloat);
    }
  }
  
  public void cmShowUpdateTouchScale(float paramFloat)
  {
    if (this.mLightNode != null) {
      this.mLightNode.cmShowUpdateTouchScale(paramFloat);
    }
  }
  
  public void cmShowUpdateViewParams(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat)
  {
    if (this.mLightNode != null) {
      this.mLightNode.cmShowUpdateViewParams(paramArrayOfFloat1, paramArrayOfFloat2, paramFloat);
    }
  }
  
  public boolean currentMaterialIsCyberpunk()
  {
    return (this.mLightNode != null) && (this.mLightNode.isApplied()) && (this.mLightNode.currentMaterialIsCyberpunk());
  }
  
  public boolean currentMaterialNeedTouchTriggerEvent()
  {
    if ((this.mLightNode != null) && (this.mLightNode.getAsset() != null)) {
      return this.mLightNode.getAsset().stickerNeedTouchTriggerEvent();
    }
    return false;
  }
  
  public void defineFiltersAndOrder(int... paramVarArgs)
  {
    this.mFilterOrderList.clear();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      int k = paramVarArgs[i];
      this.mFilterOrderList.add(Integer.valueOf(k));
      this.mFilterNodeEnableMap.put(Integer.valueOf(k), Boolean.valueOf(true));
      i += 1;
    }
  }
  
  public void destroy()
  {
    PreviewPerformanceInfo.getInstance().report();
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
    if (this.mGlow != null) {
      this.mGlow.clear();
    }
    if (this.mLightNode != null) {
      this.mLightNode.clear();
    }
    if (this.mAEFilterChain != null) {
      this.mAEFilterChain.destroy();
    }
    if (this.writePCMThread != null)
    {
      this.writePCMThread.interrupt();
      this.writePCMThread = null;
    }
    if (this.audioTrack != null)
    {
      this.audioTrack.release();
      this.audioTrack = null;
    }
    if (this.audioReader != null)
    {
      this.audioReader.release();
      this.audioReader = null;
    }
    clearSharedResources();
    GLES20.glDeleteTextures(this.textures.length, this.textures, 0);
    if (this.isNeedPictureTest) {
      GLES20.glDeleteTextures(this.testBmpTexture.length, this.testBmpTexture, 0);
    }
    this.mIsInited = false;
    this.mDestroyed = true;
    this.needUpdateAIFilter = true;
    mAIFilterConfigList = null;
  }
  
  public void destroyAudio()
  {
    if (this.audioTrack != null)
    {
      this.audioTrack.release();
      this.audioTrack = null;
    }
    if (this.audioReader != null)
    {
      this.audioReader.release();
      this.audioReader = null;
    }
  }
  
  public int drawFrame(int paramInt, boolean paramBoolean, long paramLong)
  {
    paramInt = changeTextureIfNeed(this.isNeedPictureTest, paramInt);
    if (this.mAEProfiler != null) {
      this.mAEProfiler.startByTag("IAEProfiler-drawFrame");
    }
    paramLong = PreviewPerformanceInfo.getMicTime().longValue();
    initFilters();
    updateTips();
    configFilters();
    chainFilters();
    this.mAEFilterChain.process(paramInt, this.outputTexture, this.width, this.height);
    if (this.mAEProfiler != null)
    {
      this.mAEProfiler.endByTag("IAEProfiler-drawFrame");
      this.mAEProfiler.print();
    }
    long l = PreviewPerformanceInfo.getMicTime().longValue();
    PreviewPerformanceInfo.getInstance().updateInfo(l - paramLong);
    if (this.mAEProfiler != null)
    {
      this.mAEProfiler.endByTag("IAEProfiler-calFps");
      this.mAEProfiler.startByTag("IAEProfiler-calFps");
    }
    return this.outputTexture;
  }
  
  public void endMaskTouchPoint(PointF paramPointF, int paramInt)
  {
    if ((this.mLightNode != null) && (this.mLightNode.isApplied()) && (this.mLightNode.getAsset() != null) && (this.mLightNode.getAsset().stickerNeedMaskRecordTouchPoint()) && (paramInt > 0) && (paramPointF != null))
    {
      float f = this.width / paramInt;
      paramPointF.x *= f;
      paramPointF.y = (f * paramPointF.y);
      paramPointF = "{\n\"x\":\"" + String.valueOf(paramPointF.x) + "\",\n\"y\":\"" + String.valueOf(paramPointF.y) + "\"\n}";
      Log.d("AEFilterManager", "addMaskTouchPoint: jsonStr=" + paramPointF);
      this.mLightNode.setPresetData("event.paintPoint.end", paramPointF);
    }
  }
  
  public void freeCache()
  {
    if (this.mLightNode != null) {
      this.mLightNode.freeCache();
    }
  }
  
  public PTFaceAttr getFaceAttr()
  {
    if (this.mLightNode == null) {
      return null;
    }
    return this.faceAttrInLight;
  }
  
  public LightNode getLightNode()
  {
    return this.mLightNode;
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
  
  public boolean hasEffect()
  {
    if ((this.mLightNode != null) && (this.mLightNode.isApplied())) {}
    while ((this.smoothLevel > 0) || (this.transBasic4 > 0) || (!TextUtils.isEmpty(this.mLutPath))) {
      return true;
    }
    return false;
  }
  
  public void initInGL(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    if (!DeviceUtils.hasDeviceLow(AEModule.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      this.isVeryLowEndDevice = bool;
      GLES20.glGenTextures(this.textures.length, this.textures, 0);
      if (this.isNeedPictureTest) {
        GLES20.glGenTextures(this.testBmpTexture.length, this.testBmpTexture, 0);
      }
      this.outputTexture = this.textures[0];
      this.mAEFilterChain.init();
      return;
    }
  }
  
  public boolean isInited()
  {
    return FeatureManager.Features.LIGHT_SDK.isFunctionReady();
  }
  
  public boolean needMaskRecordTouchPoint()
  {
    if ((this.mLightNode != null) && (this.mLightNode.getAsset() != null)) {
      return this.mLightNode.getAsset().stickerNeedMaskRecordTouchPoint();
    }
    return false;
  }
  
  public PTFaceAttr notifyDetectFaceAttr()
  {
    if (this.mLightNode == null)
    {
      this.faceAttrInLight = null;
      return null;
    }
    this.faceAttrInLight = this.mLightNode.getPtFaceAttr();
    return this.faceAttrInLight;
  }
  
  public void onStickerStatusChange(boolean paramBoolean) {}
  
  public void resetAdjustLut()
  {
    updateLutGL(this.mLutPath);
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
  
  public void setAIParam(String paramString1, String paramString2, Object paramObject)
  {
    if ((this.mAiParam != null) && (!TextUtils.isEmpty(paramString2)) && (paramObject != null)) {
      this.mAiParam.setModuleParam(paramString1, paramString2, paramObject);
    }
  }
  
  public void setAIScale(String paramString, float paramFloat)
  {
    if ((this.mAiParam != null) && (paramFloat > 0.0F)) {
      this.mAiParam.setModuleParam(paramString, "scale", Float.valueOf(paramFloat));
    }
  }
  
  public void setAdjustAlpha(float paramFloat)
  {
    this.adjustAlpha = paramFloat;
  }
  
  public void setAdjustLevel(AdjustRealConfig.TYPE paramTYPE, int paramInt)
  {
    switch (AEFilterManager.5.$SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[paramTYPE.ordinal()])
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
  
  public void setAdjustParams(HashMap<String, String> paramHashMap)
  {
    this.adjustParams = paramHashMap;
  }
  
  public void setArFrameInfoInfo(ArFrameInfo paramArFrameInfo)
  {
    ARDetectDataManager.getInstance().updateData(paramArFrameInfo);
  }
  
  public void setArModelRotate(float[] paramArrayOfFloat)
  {
    if ((this.mAiParam != null) && (paramArrayOfFloat != null)) {
      this.mAiParam.setModuleParam(AEDetectorType.AR_DETECT.value, "ARRotate", paramArrayOfFloat);
    }
  }
  
  public void setAutoTest(boolean paramBoolean)
  {
    this.mAutoTest = paramBoolean;
  }
  
  public void setAutoTestSmoothVersion(String paramString)
  {
    this.mAutoTestSmoothVersion = paramString;
  }
  
  public void setAutoTestSource(int paramInt)
  {
    this.mAutoTestSourceType = paramInt;
  }
  
  public void setBeautyNormalAlpha(float paramFloat)
  {
    if (this.beautyNormalAlpha != paramFloat)
    {
      this.beautyNormalAlpha = paramFloat;
      this.beautyUpdated = true;
    }
  }
  
  public void setBeautyOrTransformLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    LogUtils.d("AEFilterManager", "[setBeautyOrTransformLevel] type:" + paramTYPE + " leval:" + paramInt);
    switch (AEFilterManager.5.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    }
    for (;;)
    {
      this.beautyUpdated = true;
      return;
      setSmoothLevel(paramInt);
      this.beautySkinLevel = paramInt;
      continue;
      this.beautyEyeLighten = paramInt;
      continue;
      this.beautyToothWhiten = paramInt;
      continue;
      this.beautyRemovePounch = paramInt;
      continue;
      this.beautyRemoveWrinkles = paramInt;
      continue;
      this.beautyRemoveWrinkles2 = paramInt;
      continue;
      this.beautySkinColor = (paramInt * 2 - 100);
      continue;
      this.beautyContrastRatio = paramInt;
      continue;
      this.transForehead = paramInt;
      continue;
      this.transEye = paramInt;
      continue;
      this.transEyeDistance = paramInt;
      continue;
      this.transEyeAngle = paramInt;
      continue;
      this.transMouthShape = paramInt;
      continue;
      this.transChin = paramInt;
      continue;
      this.transFaceThin = paramInt;
      continue;
      this.transFaceV = paramInt;
      continue;
      this.transNoseWing = paramInt;
      continue;
      this.transNosePosition = paramInt;
      continue;
      this.transLipsThickness = paramInt;
      continue;
      this.transLipsWidth = paramInt;
      continue;
      this.transNose = paramInt;
      continue;
      this.transCheekboneThin = paramInt;
      continue;
      this.transFaceShorten = paramInt;
      continue;
      this.transBasic3 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic3";
      this.selectedBasicTransValue = paramInt;
      continue;
      this.transBasic4 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic4";
      this.selectedBasicTransValue = paramInt;
      continue;
      this.transBasic5 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic5";
      this.selectedBasicTransValue = paramInt;
      continue;
      this.transBasic6 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic6";
      this.selectedBasicTransValue = paramInt;
      continue;
      this.transBasic7 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic7";
      this.selectedBasicTransValue = paramInt;
      continue;
      this.transBasic8 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic8";
      this.selectedBasicTransValue = paramInt;
      continue;
      this.longLeg = paramInt;
      continue;
      this.slimWaist = paramInt;
      continue;
      this.thinShoulder = paramInt;
      continue;
      this.thinBody = paramInt;
    }
  }
  
  public void setCamera2Timestamp(long paramLong)
  {
    if (this.mAiParam != null) {
      this.mAiParam.setModuleParam(AEDetectorType.AR_DETECT.value, "camera2Timestamp", Long.valueOf(paramLong));
    }
  }
  
  public void setCloseAIBeautyConfig(boolean paramBoolean)
  {
    this.closeAIBeautyConfig = paramBoolean;
  }
  
  public void setCosmeticsAlpha(int paramInt)
  {
    this.cosmeticsAlpha = paramInt;
    if (this.mLightNode != null) {
      this.mLightNode.setPresetData("makeup.strength", formatDecimalValue(paramInt));
    }
  }
  
  public void setCurLabel(String paramString)
  {
    curLabel = paramString;
    updateAIFilter();
  }
  
  public void setExternalRenderCallback(ExternalRenderCallback paramExternalRenderCallback)
  {
    this.externalRenderCallback = paramExternalRenderCallback;
    this.externalRenderUpdated = true;
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
  
  public void setInputOriention(CameraConfig.ImageOrigin paramImageOrigin)
  {
    this.lightInputOriention = paramImageOrigin;
  }
  
  public void setIsAfterUpdateMaterial(boolean paramBoolean)
  {
    this.isAfterUpdateMaterial = paramBoolean;
  }
  
  public void setLightBundle(String paramString1, String paramString2)
  {
    if (this.mLightNode == null)
    {
      LogUtils.e("AEFilterManager", "[setLightBundle] error, light node is null pending to set bundle!");
      this.bundlePathMap.put(paramString1, paramString2);
      this.pendingToSetBundles = true;
      return;
    }
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      LogUtils.e("AEFilterManager", "[setLightBundle] error, bundle  assetDir is null can not set bundle!");
      return;
    }
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      LogUtils.e("AEFilterManager", "[setLightBundle] error, nothing can set to light sdk!");
      return;
    }
    this.mLightNode.setLightBundle(paramString1, paramString2);
  }
  
  public void setLightNodeAppliedListener(LightNodeAppliedListener paramLightNodeAppliedListener)
  {
    this.lightNodeAppliedListener = paramLightNodeAppliedListener;
  }
  
  public void setLightNodeLightAssetListener(LightAssetListener paramLightAssetListener)
  {
    this.mLightAssetListener = paramLightAssetListener;
    this.assetListenerUpdated = true;
  }
  
  public void setLightNodePresetData(String paramString1, String paramString2)
  {
    if ((this.mLightNode != null) && (this.mLightNode.isApplied()) && (this.mLightNode.getAsset() != null)) {
      this.mLightNode.setPresetData(paramString1, paramString2);
    }
  }
  
  public void setLightNodeTipsListener(LightNode.ILightNodeTipsListener paramILightNodeTipsListener)
  {
    this.mTipsListener = paramILightNodeTipsListener;
    this.tipsListenerUpdated = true;
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
    this.smoothUpdated = true;
  }
  
  public void setParam(String paramString, Object paramObject)
  {
    paramString.getClass();
  }
  
  public void setPhoneRoll(float paramFloat)
  {
    this.mPhoneRoll = paramFloat;
  }
  
  public void setPtFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.ptFaceAttr = paramPTFaceAttr;
    this.faceDataUpdated = true;
    if (this.mLightNode == null) {
      return;
    }
    this.mLightNode.setPtFaceAttr(paramPTFaceAttr);
  }
  
  public void setRotationMatrix(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.rotationMatrix, 0, 16);
  }
  
  public void setSegBgColor(int paramInt)
  {
    this.segBgColor = paramInt;
    this.segmentUpdated = true;
  }
  
  public void setSegStrokeColor(int paramInt)
  {
    this.segStrokeColor = paramInt;
    this.segmentUpdated = true;
  }
  
  public void setSegStrokeGapInPixel(float paramFloat)
  {
    this.segStrokeGapInPixel = paramFloat;
    this.segmentUpdated = true;
  }
  
  public void setSegStrokeWidthInPixel(float paramFloat)
  {
    this.segStrokeWidthInPixel = paramFloat;
    this.segmentUpdated = true;
  }
  
  public void setSensorEventToLight(SensorEvent paramSensorEvent)
  {
    if ((this.mLightNode != null) && (this.mLightNode.isApplied()))
    {
      LogUtils.d("AEFilterManager", "lightNode applied，setSensorEvent");
      this.mLightNode.setSensorEvent(paramSensorEvent);
      return;
    }
    LogUtils.e("AEFilterManager", "lightNode not applied!");
  }
  
  public void setSmoothLevel(int paramInt)
  {
    this.smoothLevel = paramInt;
    this.smoothUpdated = true;
  }
  
  public void setSmoothSharpenStrength(float paramFloat)
  {
    this.smoothSharpenStrength = paramFloat;
    this.smoothUpdated = true;
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.MaterialInnerEffectListener paramMaterialInnerEffectListener)
  {
    this.stickerInnerLutFilterListener = paramMaterialInnerEffectListener;
  }
  
  public void setStickerPause(boolean paramBoolean)
  {
    if (this.writePCMThread != null)
    {
      this.writePCMThread.interrupt();
      this.writePCMThread = null;
    }
    if (this.audioReader != null) {
      this.audioReader = null;
    }
    if (this.audioTrack != null) {
      this.audioTrack.stop();
    }
    if (this.mLightNode != null) {
      this.mLightNode.onPause();
    }
  }
  
  public void setStickerResume(boolean paramBoolean)
  {
    if ((this.mLightNode != null) && (this.mLightNode.isApplied()))
    {
      this.audioReader = this.mLightNode.getAudioReader();
      initAudioTrack();
      initWritePCMThread();
      this.mLightNode.onResume();
    }
  }
  
  public void setSyncMode(boolean paramBoolean)
  {
    if (this.mLightNode != null) {
      this.mLightNode.setSyncMode(paramBoolean);
    }
    this.syncMode = paramBoolean;
    this.syncModeUpdated = true;
  }
  
  public void setTapEvent(int paramInt)
  {
    if ((this.mLightNode != null) && (this.mLightNode.getAsset() != null)) {
      this.mLightNode.updateCameraConfigData("event.touchPoint", String.valueOf(paramInt));
    }
  }
  
  public void setTouchScale(float paramFloat)
  {
    if ((this.mLightNode != null) && (this.mLightNode.getAsset() != null)) {
      this.mLightNode.updateCameraConfigData("touch.scale", String.valueOf(paramFloat));
    }
  }
  
  public void setTouchTriggerEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((this.mLightNode != null) && (this.mLightNode.isApplied()) && (this.mLightNode.getAsset() != null))
    {
      String str = "{\"x\":" + paramFloat1 + ",\"y\":" + paramFloat2 + "}";
      Log.d("AEFilterManager", "setTouchTriggerEvent: jsonStr=" + str);
      this.mLightNode.setPresetData("event.touchPoint", str);
    }
  }
  
  public void stickerReset(boolean paramBoolean)
  {
    if ((this.mLightNode != null) && (this.mLightNode.isApplied())) {
      this.mLightNode.resetAsset();
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
  
  public void switchAbilityInLightNode(String paramString, boolean paramBoolean)
  {
    if (this.filterInLightNodeMap == null) {
      this.filterInLightNodeMap = new HashMap();
    }
    this.filterInLightNodeMap.put(paramString, formatBooleanValue(paramBoolean));
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
    this.mFilterNodeEnableMap.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
  
  public void switchSegmentFastMode(boolean paramBoolean)
  {
    if ((this.mLightNode != null) && (this.mLightNode.isApplied())) {
      this.mLightNode.switchSegmentFastMode(paramBoolean);
    }
  }
  
  public String toColorString(int paramInt)
  {
    return String.format("#%02x%02x%02x%02x", new Object[] { Integer.valueOf(Color.red(paramInt)), Integer.valueOf(Color.green(paramInt)), Integer.valueOf(Color.blue(paramInt)), Integer.valueOf(Color.alpha(paramInt)) });
  }
  
  public void updateCameraConfigData(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      this.extraConfigData.putAll(paramMap);
      this.extraConfigUpdated = true;
    }
  }
  
  public void updateLutGL(String paramString)
  {
    LogUtils.d("AEFilterManager", "[updateLutGL] lut = " + paramString);
    this.mLutPath = paramString;
    this.lutUpdated = true;
    if ((this.mLightNode != null) && (this.mLightNode.getAsset() != null))
    {
      this.useLutType = 1001;
      if (this.stickerInnerLutFilterListener != null) {
        this.stickerInnerLutFilterListener.notifyEnableLutType(this.useLutType);
      }
    }
  }
  
  public void updateMaterialGL(VideoMaterial paramVideoMaterial)
  {
    this.isAfterUpdateMaterial = true;
    VideoMaterial localVideoMaterial;
    if (paramVideoMaterial != null)
    {
      localVideoMaterial = paramVideoMaterial;
      if (paramVideoMaterial.getLightAsset() != null) {}
    }
    else
    {
      localVideoMaterial = VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath());
    }
    if (!isDeviceSupportMaterial(localVideoMaterial))
    {
      if (this.stickerInnerLutFilterListener != null) {
        this.stickerInnerLutFilterListener.onDeviceNotSupportMaterial();
      }
      LogUtils.e("AEFilterManager", "can not support material");
      return;
    }
    this.mVideoMaterial = localVideoMaterial;
    if (this.mVideoMaterial.getLightAsset().hasMesh())
    {
      i = 2000;
      label80:
      this.useMeshType = i;
      if (this.stickerInnerLutFilterListener != null) {
        this.stickerInnerLutFilterListener.notifyEnableMeshType(this.useMeshType);
      }
      if (!this.mVideoMaterial.getLightAsset().hasLut()) {
        break label191;
      }
    }
    label191:
    for (int i = 1000;; i = 1001)
    {
      this.useLutType = i;
      if (this.stickerInnerLutFilterListener != null) {
        this.stickerInnerLutFilterListener.notifyEnableLutType(this.useLutType);
      }
      PreviewPerformanceInfo.getInstance().setStickerID(this.mVideoMaterial.getId());
      this.filterConfigMap.clear();
      if (this.mAEProfiler == null) {
        break;
      }
      this.mAEProfiler.reset();
      return;
      i = 2001;
      break label80;
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
    this.previewSizeUpdated = true;
  }
  
  public void wmAddInfoDict(Map<String, String> paramMap)
  {
    if (this.mLightNode != null)
    {
      paramMap = new JSONObject(paramMap).toString();
      LogUtils.i("AEFilterManager", "addWatermarkDict: " + paramMap);
      this.mLightNode.updateCameraConfigData("watermark_dict", paramMap);
    }
  }
  
  public List<WMElement> wmGetEditableWMElements()
  {
    if (this.mLightNode == null) {
      return Collections.emptyList();
    }
    return this.mLightNode.getEditableWMElement();
  }
  
  public void wmSetLocation(String paramString)
  {
    if (this.mLightNode != null) {
      this.mLightNode.updateCameraConfigData("[location]", paramString);
    }
  }
  
  public void wmSetOnClickWatermarkListener(IOnClickWatermarkListener paramIOnClickWatermarkListener)
  {
    this.mWatermarkClickListener = paramIOnClickWatermarkListener;
    this.wmClickListenerUpdated = true;
  }
  
  public void wmSetOnlineUsrCountDelegate(String paramString, WatermarkDelegate paramWatermarkDelegate)
  {
    this.wmDelegateMap.put(paramString, paramWatermarkDelegate);
    this.wmOnlineUsrCountDelegateUpdated = true;
  }
  
  public void wmSetTemperature(String paramString)
  {
    if (this.mLightNode != null) {
      this.mLightNode.updateCameraConfigData("[temperature]", paramString);
    }
  }
  
  public void wmSetWeatherCode(int paramInt)
  {
    if (this.mLightNode != null) {
      this.mLightNode.updateCameraConfigData("[weatherType]", String.valueOf(paramInt));
    }
  }
  
  public void wmSetWeatherStr(String paramString)
  {
    if (this.mLightNode != null) {
      this.mLightNode.updateCameraConfigData("[weather]", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager
 * JD-Core Version:    0.7.0.1
 */