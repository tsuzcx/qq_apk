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
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
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
import org.light.DeviceCameraConfig;
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
  private int cosmeticsAlpha = 50;
  private boolean cosmeticsAlphaUpdated = false;
  private String customMaterialPath;
  private boolean customMaterialUpdated = true;
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
  private boolean flipBeforeRenderUpdated = false;
  private boolean forceFaceDetect = true;
  private float glowAlpha;
  private volatile boolean hasApplyPTFaceTransform = false;
  private int height;
  private int hightLightLevel = 0;
  boolean isAIPreload = false;
  private boolean isAfterUpdateMaterial = false;
  private boolean isLowLightEnv = false;
  private boolean isNeedPictureTest = false;
  private boolean isNeedSkipFrame = false;
  private boolean isOverallSmooth = false;
  boolean isPicNeedFlipBeforeRender = false;
  private boolean isVeryLowEndDevice = false;
  private CameraConfig.ImageOrigin lightInputOriention = CameraConfig.ImageOrigin.BottomLeft;
  private LightNodeAppliedListener lightNodeAppliedListener;
  private int lightnessLevel = 0;
  private int longLeg;
  private float lookupLevel = 100.0F;
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
    this("defaultBeautyV6.json", false);
  }
  
  public AEFilterManager(String paramString, boolean paramBoolean)
  {
    this.smoothVersion = paramString;
    this.isAIPreload = paramBoolean;
    setDefaultOrder();
    this.mAEFilterChain = new AEFilterChain();
    initAudioTrack();
  }
  
  private void chainFilters()
  {
    Object localObject1 = this.mAEProfiler;
    if (localObject1 != null) {
      ((IAEProfiler)localObject1).startByTag("IAEProfiler-chainFilters");
    }
    this.mAEFilterChain.clearFilterList();
    localObject1 = this.mFilterOrderList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Integer)((Iterator)localObject1).next()).intValue();
      if (((Boolean)this.mFilterNodeEnableMap.get(Integer.valueOf(i))).booleanValue())
      {
        Object localObject2;
        if (i != 100)
        {
          if (i != 200)
          {
            if (i == 300)
            {
              localObject2 = this.mGlow;
              if (localObject2 != null) {
                this.mAEFilterChain.add((AEChainI)localObject2);
              }
            }
          }
          else
          {
            localObject2 = this.mAdjust;
            if (localObject2 != null) {
              this.mAEFilterChain.add((AEChainI)localObject2);
            }
          }
        }
        else
        {
          localObject2 = this.mLightNode;
          if (localObject2 != null) {
            this.mAEFilterChain.add((AEChainI)localObject2);
          }
        }
      }
    }
    localObject1 = this.mAEProfiler;
    if (localObject1 != null) {
      ((IAEProfiler)localObject1).endByTag("IAEProfiler-chainFilters");
    }
  }
  
  private int changeTextureIfNeed(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      return paramInt;
    }
    if (this.mTestBmp == null) {
      this.mTestBmp = decodeBitmap("sample_input_16_9_1080.jpg");
    }
    int j = getBmpToTextue(this.mTestBmp);
    int i = j;
    if (j == -1) {
      i = paramInt;
    }
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
    Object localObject1 = this.mAEProfiler;
    if (localObject1 != null)
    {
      ((IAEProfiler)localObject1).startByTag("IAEProfiler-configFilters");
      this.mAEProfiler.startByTag("IAEProfiler-waitFaceTime");
    }
    localObject1 = this.mAEProfiler;
    if (localObject1 != null) {
      ((IAEProfiler)localObject1).endByTag("IAEProfiler-waitFaceTime");
    }
    Iterator localIterator = this.mFilterNodeEnableMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue())
      {
        localObject1 = AEProfiler.getInstance();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("IAEProfiler-configFilters-");
        ((StringBuilder)localObject2).append(localEntry.getKey());
        ((AEProfiler)localObject1).start(((StringBuilder)localObject2).toString(), true);
        int i = ((Integer)localEntry.getKey()).intValue();
        if (i != 100)
        {
          if (i != 200)
          {
            if (i != 300) {
              break label1839;
            }
          }
          else
          {
            localObject1 = this.mAdjust;
            if (localObject1 != null)
            {
              ((AEAdjust)localObject1).setAlpha(this.adjustAlpha);
              localObject1 = this.adjustParams;
              if (localObject1 != null)
              {
                this.mAdjust.setAdjustParams((HashMap)localObject1);
              }
              else
              {
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
          localObject1 = this.mGlow;
          if (localObject1 != null) {
            ((AEGlow)localObject1).setAlpha(this.glowAlpha);
          }
        }
        else if (this.mLightNode != null)
        {
          if ((this.mAutoTest) && (this.mAutoTestSourceType == 0)) {
            continue;
          }
          localObject1 = this.mLightNode;
          if ((this.mAutoTest) && (this.mAutoTestSourceType > 1)) {
            bool = true;
          } else {
            bool = false;
          }
          ((LightNode)localObject1).setAutoTest(bool);
          if (this.mAutoTest)
          {
            localObject1 = this.mLightNode;
            i = this.mFrameIndex;
            this.mFrameIndex = (i + 1);
            ((LightNode)localObject1).setFrameIndex(i);
          }
          localObject1 = this.mVideoMaterial;
          if (localObject1 != null) {
            this.mLightNode.updateAsset(((VideoMaterial)localObject1).getLightAsset());
          }
          localObject1 = this.configData;
          if (localObject1 == null) {
            this.configData = new HashMap();
          } else {
            ((Map)localObject1).clear();
          }
          boolean bool = this.smoothUpdated;
          localObject1 = "";
          Object localObject3;
          if (bool)
          {
            this.configData.put("smooth.smooth", formatDecimalValue(this.smoothLevel));
            this.configData.put("smooth.overallSmooth", formatBooleanValue(this.isOverallSmooth));
            this.configData.put("smooth.isVeryLowEndDevice", formatBooleanValue(this.isVeryLowEndDevice));
            localObject2 = this.configData;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(this.smoothSharpenStrength);
            ((Map)localObject2).put("smooth.sharpen", ((StringBuilder)localObject3).toString());
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
            localObject2 = this.configData;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(this.beautyNormalAlpha);
            ((Map)localObject2).put("beauty.faceFeature", ((StringBuilder)localObject3).toString());
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
            localObject2 = this.selectedBasicTransType;
            if (localObject2 != null) {
              this.configData.put(localObject2, formatDecimalValue(this.selectedBasicTransValue));
            }
            this.configData.put("stretch.shortFace", formatDecimalValue(this.transFaceShorten));
            this.configData.put("stretch.thinNose", formatDecimalValue(this.transNose));
            this.beautyUpdated = false;
          }
          if ((this.isAfterUpdateMaterial) || (this.lutUpdated))
          {
            i = this.useLutType;
            if (i == 1001)
            {
              switchAbilityInLightNode("basicLUT.enable", true);
              switchAbilityInLightNode("materialLUT.enable", false);
            }
            else if (i == 1000)
            {
              switchAbilityInLightNode("basicLUT.enable", false);
              switchAbilityInLightNode("materialLUT.enable", true);
            }
            if (this.isAfterUpdateMaterial)
            {
              if (this.useMeshType == 2000)
              {
                switchAbilityInLightNode("basicMesh.enable", false);
                switchAbilityInLightNode("materialMesh.enable", true);
              }
              else
              {
                switchAbilityInLightNode("basicMesh.enable", true);
                switchAbilityInLightNode("materialMesh.enable", false);
              }
              localObject2 = this.mVideoMaterial;
              if ((localObject2 != null) && (((VideoMaterial)localObject2).getLightAsset() != null)) {
                switchAbilityInLightNode("beauty.faceFeature.enable", this.mVideoMaterial.getLightAsset().hasMakeup() ^ true);
              }
              this.isAfterUpdateMaterial = false;
            }
            if (this.lutUpdated)
            {
              localObject3 = this.configData;
              localObject2 = this.mLutPath;
              if (localObject2 != null) {
                localObject1 = localObject2;
              }
              ((Map)localObject3).put("lut.src", localObject1);
              this.configData.put("lut.intensity", formatDecimalValue((int)this.lookupLevel));
              this.lutUpdated = false;
            }
          }
          if (this.customMaterialUpdated)
          {
            this.mLightNode.setCustomMaterial(this.customMaterialPath);
            this.customMaterialUpdated = false;
          }
          localObject1 = this.filterInLightNodeMap;
          if ((localObject1 != null) && (((HashMap)localObject1).size() > 0))
          {
            this.configData.putAll(this.filterInLightNodeMap);
            this.filterInLightNodeMap.clear();
          }
          if (this.extraConfigUpdated)
          {
            this.configData.putAll(this.extraConfigData);
            this.extraConfigData.clear();
            this.extraConfigUpdated = false;
          }
          if (this.configData.size() > 0) {
            this.mLightNode.updateCameraConfigData(this.configData);
          }
          if (this.previewSizeUpdated)
          {
            this.mLightNode.updatePreviewSize(this.width, this.height);
            LogUtils.d("AEFilterManager", "[configFilters] 渲染尺寸更新");
            this.previewSizeUpdated = false;
          }
          if (this.flipBeforeRenderUpdated)
          {
            this.flipBeforeRenderUpdated = false;
            this.mLightNode.setPicNeedFlip(this.isPicNeedFlipBeforeRender);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[configFilters] flip before render update: ");
            ((StringBuilder)localObject1).append(this.isPicNeedFlipBeforeRender);
            LogUtils.d("AEFilterManager", ((StringBuilder)localObject1).toString());
          }
          if (this.externalRenderUpdated)
          {
            localObject1 = this.externalRenderCallback;
            if (localObject1 != null) {
              this.mLightNode.setExternalRenderCallback((ExternalRenderCallback)localObject1);
            }
            LogUtils.d("AEFilterManager", "[configFilters] 外挂滤镜更新");
            this.externalRenderUpdated = false;
          }
          if (this.syncModeUpdated)
          {
            this.syncModeUpdated = false;
            this.mLightNode.setSyncMode(this.syncMode);
          }
          if (this.faceDataUpdated)
          {
            this.faceDataUpdated = false;
            this.mLightNode.setPtFaceAttr(this.ptFaceAttr);
          }
          if (this.cosmeticsAlphaUpdated)
          {
            this.cosmeticsAlphaUpdated = false;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("cosmeticsAlpha: ");
            ((StringBuilder)localObject1).append(this.cosmeticsAlpha);
            LogUtils.d("AEFilterManager", ((StringBuilder)localObject1).toString());
            this.mLightNode.setPresetData("makeup.strength", formatDecimalValue(this.cosmeticsAlpha));
          }
        }
        label1839:
        localObject1 = AEProfiler.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("IAEProfiler-configFilters-");
        ((StringBuilder)localObject2).append(localEntry.getKey());
        ((AEProfiler)localObject1).end(((StringBuilder)localObject2).toString(), true);
      }
    }
    localObject1 = this.mAEProfiler;
    if (localObject1 != null) {
      ((IAEProfiler)localObject1).endByTag("IAEProfiler-configFilters");
    }
  }
  
  private Vector copyArry2Vector(Object paramObject, Vector<Integer> paramVector)
  {
    if (paramObject == null)
    {
      if (paramVector != null) {
        paramVector.clear();
      }
      return paramVector;
    }
    if (!(paramObject instanceof int[])) {
      return paramVector;
    }
    Object localObject = paramVector;
    if (paramVector == null) {
      localObject = new Vector();
    }
    ((Vector)localObject).clear();
    paramObject = (int[])paramObject;
    int j = paramObject.length;
    int i = 0;
    while (i < j)
    {
      int k = paramObject[i];
      if (!((Vector)localObject).contains(Integer.valueOf(k))) {
        ((Vector)localObject).add(Integer.valueOf(k));
      }
      i += 1;
    }
    return localObject;
  }
  
  private Bitmap decodeBitmap(String paramString)
  {
    if (AEModule.getContext() != null)
    {
      if (paramString == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AEModule.getContext().getExternalFilesDir(null).getPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 1);
    }
    return null;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("inputVideo");
    return localStringBuilder.toString();
  }
  
  private String getOutputVideoPath()
  {
    String str = AEModule.getResouceRoot();
    if (str == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("outputVideo");
    return localStringBuilder.toString();
  }
  
  private void initAudioTrack()
  {
    this.audioTrack = new ReportAudioTrack(3, 44100, 12, 2, AudioTrack.getMinBufferSize(44100, 12, 2) * 2, 1);
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
    Object localObject1 = this.mFilterNodeEnableMap;
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      long l1 = 0L;
      if (!this.mLogFlag)
      {
        long l2 = SystemClock.uptimeMillis();
        localObject1 = this.mAEProfiler;
        l1 = l2;
        if (localObject1 != null)
        {
          ((IAEProfiler)localObject1).startByTag("IAEProfiler-initFilters");
          l1 = l2;
        }
      }
      System.currentTimeMillis();
      localObject1 = this.mFilterNodeEnableMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
        {
          int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
          if (i != 100)
          {
            if (i != 200)
            {
              if (i == 300)
              {
                if (this.mGlow == null) {
                  this.mGlow = new AEGlow();
                }
                this.mGlow.applyFilterChain(false, this.width, this.height);
              }
            }
            else
            {
              if (this.mAdjust == null) {
                this.mAdjust = new AEAdjust();
              }
              this.mAdjust.apply();
            }
          }
          else
          {
            if (this.mLightNode == null)
            {
              localObject2 = this.mAutoTestSmoothVersion;
              if (localObject2 != null) {
                this.mLightNode = new LightNode((String)localObject2, this.isAIPreload);
              } else {
                this.mLightNode = new LightNode(this.smoothVersion, this.isAIPreload);
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[BeautyVersion] ver:");
              ((StringBuilder)localObject2).append(this.smoothVersion);
              LogUtils.d("testSmoothVersion", ((StringBuilder)localObject2).toString());
              this.mLightNode.setApplyListener(new AEFilterManager.2(this));
            }
            initBundlePathsForLightNode();
            initListenersForLightNode();
            this.mLightNode.initPreviewSize(this.width, this.height);
            this.mLightNode.setInputOrigin(this.lightInputOriention);
            this.mLightNode.apply();
            this.mIsInited = true;
          }
        }
      }
      if (!this.mLogFlag)
      {
        this.mLogFlag = true;
        localObject1 = this.mAEProfiler;
        if (localObject1 != null) {
          ((IAEProfiler)localObject1).endByTag("IAEProfiler-initFilters");
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initFilters cost duration=");
        ((StringBuilder)localObject1).append(SystemClock.uptimeMillis() - l1);
        LogUtils.i("CameraLaunchPerf", ((StringBuilder)localObject1).toString());
      }
      return;
    }
    LogUtils.w("AEFilterManager", "[initFilters] warning, filters is empty!");
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
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getLightAsset() != null))
    {
      String[] arrayOfString = this.deviceSupportAbility;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((paramVideoMaterial.getLightAsset().needRenderAbility(str)) && (!LightEngine.isDeviceAbilitySupported(str)))
        {
          paramVideoMaterial = new StringBuilder();
          paramVideoMaterial.append("can not support ability ");
          paramVideoMaterial.append(str);
          LogUtils.e("AEFilterManager", paramVideoMaterial.toString());
          return false;
        }
        i += 1;
      }
      return true;
    }
    LogUtils.e("AEFilterManager", "can not support because videoMaterial is null or lightAsset is null!");
    return false;
  }
  
  private String mapWeatherCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 9: 
      return "大风";
    case 8: 
      return "沙尘暴";
    case 7: 
      return "雷阵雨";
    case 6: 
      return "雨加雪";
    case 5: 
      return "雾";
    case 4: 
      return "雪";
    case 3: 
      return "雨";
    case 2: 
      return "阴";
    case 1: 
      return "多云";
    }
    return "晴";
  }
  
  private List<Bitmap> pickUpFrame(String paramString)
  {
    new ArrayList();
    int[] arrayOfInt = new int[10];
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
    int i = 0;
    int k;
    for (int j = 0; i < d; j = k)
    {
      int m = 0;
      for (;;)
      {
        k = j;
        if (m >= ((List)localObject1).size()) {
          break;
        }
        if (((Long)((List)localObject1).get(m)).longValue() > i * l)
        {
          arrayOfInt[j] = m;
          k = j + 1;
          break;
        }
        m += 1;
      }
      i += 1;
    }
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
  
  private Bitmap pickUpFrameFirst(String paramString, int paramInt)
  {
    new ArrayList();
    Object localObject = VideoUtil.getFramestamps(paramString);
    if (localObject != null) {
      Collections.sort((List)localObject);
    }
    long l1 = ((Long)Collections.max((Collection)localObject)).longValue();
    long l2 = paramInt;
    if (l1 < l2) {
      return null;
    }
    paramInt = 0;
    while (paramInt < ((List)localObject).size())
    {
      if (((Long)((List)localObject).get(paramInt)).longValue() > l2) {
        break label96;
      }
      paramInt += 1;
    }
    paramInt = 0;
    label96:
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    int i = localObject[0];
    paramString = VboxFactory.createDecoder(paramString, 2);
    paramString.setTexture(i);
    paramString.getFrameTexture(paramInt);
    Bitmap localBitmap = RendererUtils.saveTexture(i, paramString.getWidth(), paramString.getHeight());
    if (paramString != null) {
      paramString.releaseDecoder();
    }
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    return localBitmap;
  }
  
  private void printFilterParamIfNeed(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if (this.mGlow != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AEGlow === ");
      localStringBuilder.append(this.mGlow.printParamInfo());
      Log.e("AEFilterManager", localStringBuilder.toString());
    }
  }
  
  private void setDefaultOrder()
  {
    this.mFilterOrderList.clear();
    List localList = this.mFilterOrderList;
    Integer localInteger = Integer.valueOf(100);
    localList.add(localInteger);
    this.mFilterNodeEnableMap.put(localInteger, Boolean.valueOf(true));
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
    Object localObject = this.mLightNode;
    if ((localObject != null) && (((LightNode)localObject).isApplied()) && (this.mLightNode.getAsset() != null) && (this.mLightNode.getAsset().stickerNeedMaskRecordTouchPoint()) && (paramInt > 0) && (paramPointF != null))
    {
      float f = this.width / paramInt;
      paramPointF.x *= f;
      paramPointF.y *= f;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{\n\"x\":\"");
      ((StringBuilder)localObject).append(String.valueOf(paramPointF.x));
      ((StringBuilder)localObject).append("\",\n\"y\":\"");
      ((StringBuilder)localObject).append(String.valueOf(paramPointF.y));
      ((StringBuilder)localObject).append("\"\n}");
      paramPointF = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addMaskTouchPoint: jsonStr=");
      ((StringBuilder)localObject).append(paramPointF);
      Log.d("AEFilterManager", ((StringBuilder)localObject).toString());
      this.mLightNode.setPresetData("event.paintPoint", paramPointF);
    }
  }
  
  public boolean canUseLargeImage()
  {
    VideoMaterial localVideoMaterial = this.mVideoMaterial;
    return (localVideoMaterial == null) || ((!localVideoMaterial.needBodySegment()) && (!this.mVideoMaterial.isSticker3DMaterial()) && (!this.mVideoMaterial.isFace3DMaterial()));
  }
  
  public void cmShowSetKapuAnimation(String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.cmShowSetKapuAnimation(paramString, paramCmShowCallback);
    }
  }
  
  public void cmShowSetKapuCameraViewType(CameraController.CameraViewType paramCameraViewType)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.cmShowSetKapuCameraViewType(paramCameraViewType);
    }
  }
  
  public void cmShowSetKapuDisplayType(CameraController.DisplayType paramDisplayType)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.cmShowSetKapuDisplayType(paramDisplayType);
    }
  }
  
  public void cmShowSetKapuModel(HashMap<String, String> paramHashMap, String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.cmShowSetKapuModel(paramHashMap, paramString, paramCmShowCallback);
    }
  }
  
  public void cmShowUpdateKapuMorph(CameraController.MorphType paramMorphType)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.cmShowUpdateKapuMorph(paramMorphType);
    }
  }
  
  public void cmShowUpdateTouchRotate(float[] paramArrayOfFloat)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.cmShowUpdateTouchRotate(paramArrayOfFloat);
    }
  }
  
  public void cmShowUpdateTouchScale(float paramFloat)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.cmShowUpdateTouchScale(paramFloat);
    }
  }
  
  public void cmShowUpdateViewParams(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.cmShowUpdateViewParams(paramArrayOfFloat1, paramArrayOfFloat2, paramFloat);
    }
  }
  
  public boolean currentMaterialIsCyberpunk()
  {
    LightNode localLightNode = this.mLightNode;
    return (localLightNode != null) && (localLightNode.isApplied()) && (this.mLightNode.currentMaterialIsCyberpunk());
  }
  
  public boolean currentMaterialNeedGravityInfo()
  {
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.getAsset() != null)) {
      return this.mLightNode.getAsset().needGravityInfo();
    }
    return false;
  }
  
  public boolean currentMaterialNeedTouchTriggerEvent()
  {
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.getAsset() != null)) {
      return this.mLightNode.getAsset().stickerNeedTouchTriggerEvent();
    }
    return false;
  }
  
  public boolean currentMaterialNeedVoiceDecibel()
  {
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.getAsset() != null)) {
      return this.mLightNode.getAsset().needVoiceDecibel();
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
    Object localObject = this.mPhotoAIFilter;
    if (localObject != null) {
      ((PhotoAIFilter)localObject).clear();
    }
    localObject = this.mAIFilterList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AEChainI localAEChainI = (AEChainI)((Iterator)localObject).next();
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
    localObject = this.mAdjust;
    if (localObject != null) {
      ((AEAdjust)localObject).clear();
    }
    localObject = this.mGlow;
    if (localObject != null) {
      ((AEGlow)localObject).clear();
    }
    localObject = this.mLightNode;
    if (localObject != null) {
      ((LightNode)localObject).clear();
    }
    localObject = this.mAEFilterChain;
    if (localObject != null) {
      ((AEFilterChain)localObject).destroy();
    }
    localObject = this.writePCMThread;
    if (localObject != null)
    {
      ((Thread)localObject).interrupt();
      this.writePCMThread = null;
    }
    localObject = this.audioTrack;
    if (localObject != null)
    {
      ((AudioTrack)localObject).release();
      this.audioTrack = null;
    }
    localObject = this.audioReader;
    if (localObject != null)
    {
      ((AudioOutput)localObject).release();
      this.audioReader = null;
    }
    clearSharedResources();
    localObject = this.textures;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    if (this.isNeedPictureTest)
    {
      localObject = this.testBmpTexture;
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    }
    this.mIsInited = false;
    this.mDestroyed = true;
    this.needUpdateAIFilter = true;
    mAIFilterConfigList = null;
  }
  
  public void destroyAudio()
  {
    Object localObject = this.audioTrack;
    if (localObject != null)
    {
      ((AudioTrack)localObject).release();
      this.audioTrack = null;
    }
    localObject = this.audioReader;
    if (localObject != null)
    {
      ((AudioOutput)localObject).release();
      this.audioReader = null;
    }
  }
  
  public int drawFrame(int paramInt, boolean paramBoolean, long paramLong)
  {
    paramInt = changeTextureIfNeed(this.isNeedPictureTest, paramInt);
    Object localObject = this.mAEProfiler;
    if (localObject != null) {
      ((IAEProfiler)localObject).startByTag("IAEProfiler-drawFrame");
    }
    long l = PreviewPerformanceInfo.getMicTime().longValue();
    initLightFilter();
    localObject = this.mLightNode;
    if (localObject != null) {
      ((LightNode)localObject).updateCameraTextureTimestamp(paramLong);
    }
    this.mAEFilterChain.process(paramInt, this.outputTexture, this.width, this.height);
    localObject = this.mAEProfiler;
    if (localObject != null)
    {
      ((IAEProfiler)localObject).endByTag("IAEProfiler-drawFrame");
      this.mAEProfiler.print();
    }
    paramLong = PreviewPerformanceInfo.getMicTime().longValue();
    PreviewPerformanceInfo.getInstance().updateInfo(paramLong - l);
    localObject = this.mAEProfiler;
    if (localObject != null)
    {
      ((IAEProfiler)localObject).endByTag("IAEProfiler-calFps");
      this.mAEProfiler.startByTag("IAEProfiler-calFps");
    }
    return this.outputTexture;
  }
  
  public void endMaskTouchPoint(PointF paramPointF, int paramInt)
  {
    Object localObject = this.mLightNode;
    if ((localObject != null) && (((LightNode)localObject).isApplied()) && (this.mLightNode.getAsset() != null) && (this.mLightNode.getAsset().stickerNeedMaskRecordTouchPoint()) && (paramInt > 0) && (paramPointF != null))
    {
      float f = this.width / paramInt;
      paramPointF.x *= f;
      paramPointF.y *= f;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{\n\"x\":\"");
      ((StringBuilder)localObject).append(String.valueOf(paramPointF.x));
      ((StringBuilder)localObject).append("\",\n\"y\":\"");
      ((StringBuilder)localObject).append(String.valueOf(paramPointF.y));
      ((StringBuilder)localObject).append("\"\n}");
      paramPointF = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addMaskTouchPoint: jsonStr=");
      ((StringBuilder)localObject).append(paramPointF);
      Log.d("AEFilterManager", ((StringBuilder)localObject).toString());
      this.mLightNode.setPresetData("event.paintPoint.end", paramPointF);
    }
  }
  
  public void freeCache()
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.freeCache();
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
  
  public String getLutPath()
  {
    return this.mLutPath;
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
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.isApplied())) {
      return true;
    }
    if (this.smoothLevel > 0) {
      return true;
    }
    if (this.transBasic4 > 0) {
      return true;
    }
    return TextUtils.isEmpty(this.mLutPath) ^ true;
  }
  
  public void initInGL(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.isVeryLowEndDevice = (DeviceUtils.hasDeviceLow(AEModule.getContext()) ^ true);
    int[] arrayOfInt = this.textures;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    if (this.isNeedPictureTest)
    {
      arrayOfInt = this.testBmpTexture;
      GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    this.outputTexture = this.textures[0];
    this.mAEFilterChain.init();
  }
  
  public void initLightFilter()
  {
    initFilters();
    updateTips();
    configFilters();
    chainFilters();
  }
  
  public boolean isInited()
  {
    return FeatureManager.Features.LIGHT_SDK.isFunctionReady();
  }
  
  public boolean needMaskRecordTouchPoint()
  {
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.getAsset() != null)) {
      return this.mLightNode.getAsset().stickerNeedMaskRecordTouchPoint();
    }
    return false;
  }
  
  public PTFaceAttr notifyDetectFaceAttr()
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode == null)
    {
      this.faceAttrInLight = null;
      return null;
    }
    this.faceAttrInLight = localLightNode.getPtFaceAttr();
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
    AIParam localAIParam = this.mAiParam;
    if ((localAIParam != null) && (paramFloat > 0.0F)) {
      localAIParam.setModuleParam(paramString, "scale", Float.valueOf(paramFloat));
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
    case 8: 
      this.fadeLevel = paramInt;
      return;
    case 7: 
      this.colorTemperature = paramInt;
      return;
    case 6: 
      this.saturationLevel = paramInt;
      return;
    case 5: 
      this.sharpLevel = paramInt;
      return;
    case 4: 
      this.compareLevel = paramInt;
      return;
    case 3: 
      this.shadowLevel = paramInt;
      return;
    case 2: 
      this.hightLightLevel = paramInt;
      return;
    }
    this.lightnessLevel = paramInt;
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
    AIParam localAIParam = this.mAiParam;
    if ((localAIParam != null) && (paramArrayOfFloat != null)) {
      localAIParam.setModuleParam(AEDetectorType.AR_DETECT.value, "ARRotate", paramArrayOfFloat);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setBeautyOrTransformLevel] type:");
    localStringBuilder.append(paramTYPE);
    localStringBuilder.append(" leval:");
    localStringBuilder.append(paramInt);
    LogUtils.d("AEFilterManager", localStringBuilder.toString());
    switch (AEFilterManager.5.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    default: 
      break;
    case 33: 
      this.thinBody = paramInt;
      break;
    case 32: 
      this.thinShoulder = paramInt;
      break;
    case 31: 
      this.slimWaist = paramInt;
      break;
    case 30: 
      this.longLeg = paramInt;
      break;
    case 29: 
      this.transBasic8 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic8";
      this.selectedBasicTransValue = paramInt;
      break;
    case 28: 
      this.transBasic7 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic7";
      this.selectedBasicTransValue = paramInt;
      break;
    case 27: 
      this.transBasic6 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic6";
      this.selectedBasicTransValue = paramInt;
      break;
    case 26: 
      this.transBasic5 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic5";
      this.selectedBasicTransValue = paramInt;
      break;
    case 25: 
      this.transBasic4 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic4";
      this.selectedBasicTransValue = paramInt;
      break;
    case 24: 
      this.transBasic3 = paramInt;
      this.selectedBasicTransType = "liquefaction.basic3";
      this.selectedBasicTransValue = paramInt;
      break;
    case 23: 
      this.transFaceShorten = paramInt;
      break;
    case 22: 
      this.transCheekboneThin = paramInt;
      break;
    case 21: 
      this.transNose = paramInt;
      break;
    case 20: 
      this.transLipsWidth = paramInt;
      break;
    case 19: 
      this.transLipsThickness = paramInt;
      break;
    case 18: 
      this.transNosePosition = paramInt;
      break;
    case 17: 
      this.transNoseWing = paramInt;
      break;
    case 16: 
      this.transFaceV = paramInt;
      break;
    case 15: 
      this.transFaceThin = paramInt;
      break;
    case 14: 
      this.transChin = paramInt;
      break;
    case 13: 
      this.transMouthShape = paramInt;
      break;
    case 12: 
      this.transEyeAngle = paramInt;
      break;
    case 11: 
      this.transEyeDistance = paramInt;
      break;
    case 10: 
      this.transEye = paramInt;
      break;
    case 9: 
      this.transForehead = paramInt;
      break;
    case 8: 
      this.beautyContrastRatio = paramInt;
      break;
    case 7: 
      this.beautySkinColor = (paramInt * 2 - 100);
      break;
    case 6: 
      this.beautyRemoveWrinkles2 = paramInt;
      break;
    case 5: 
      this.beautyRemoveWrinkles = paramInt;
      break;
    case 4: 
      this.beautyRemovePounch = paramInt;
      break;
    case 3: 
      this.beautyToothWhiten = paramInt;
      break;
    case 2: 
      this.beautyEyeLighten = paramInt;
      break;
    case 1: 
      setSmoothLevel(paramInt);
      this.beautySkinLevel = paramInt;
    }
    this.beautyUpdated = true;
  }
  
  public void setCamera2Timestamp(long paramLong)
  {
    AIParam localAIParam = this.mAiParam;
    if (localAIParam != null) {
      localAIParam.setModuleParam(AEDetectorType.AR_DETECT.value, "camera2Timestamp", Long.valueOf(paramLong));
    }
  }
  
  public void setCloseAIBeautyConfig(boolean paramBoolean)
  {
    this.closeAIBeautyConfig = paramBoolean;
  }
  
  public void setCosmeticsAlpha(int paramInt)
  {
    this.cosmeticsAlpha = paramInt;
    this.cosmeticsAlphaUpdated = true;
  }
  
  public void setCurLabel(String paramString)
  {
    curLabel = paramString;
    updateAIFilter();
  }
  
  public void setCustomMaterial(String paramString)
  {
    this.customMaterialPath = paramString;
    this.customMaterialUpdated = true;
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
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        this.mLightNode.setLightBundle(paramString1, paramString2);
        return;
      }
      LogUtils.e("AEFilterManager", "[setLightBundle] error, nothing can set to light sdk!");
      return;
    }
    LogUtils.e("AEFilterManager", "[setLightBundle] error, bundle  assetDir is null can not set bundle!");
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
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.isApplied()) && (this.mLightNode.getAsset() != null)) {
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
  
  public void setPhoneRoll(float paramFloat)
  {
    this.mPhoneRoll = paramFloat;
  }
  
  public void setPicNeedFlipBeforeRender(boolean paramBoolean)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.setPicNeedFlip(paramBoolean);
    }
    this.isPicNeedFlipBeforeRender = paramBoolean;
    this.flipBeforeRenderUpdated = true;
  }
  
  public void setPtFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.ptFaceAttr = paramPTFaceAttr;
    this.faceDataUpdated = true;
    LightNode localLightNode = this.mLightNode;
    if (localLightNode == null) {
      return;
    }
    localLightNode.setPtFaceAttr(paramPTFaceAttr);
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
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.isApplied()))
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
    Object localObject = this.writePCMThread;
    if (localObject != null)
    {
      ((Thread)localObject).interrupt();
      this.writePCMThread = null;
    }
    if (this.audioReader != null) {
      this.audioReader = null;
    }
    localObject = this.audioTrack;
    if ((localObject != null) && (((AudioTrack)localObject).getState() == 1)) {
      this.audioTrack.stop();
    }
    localObject = this.mLightNode;
    if (localObject != null) {
      ((LightNode)localObject).onPause();
    }
  }
  
  public void setStickerResume(boolean paramBoolean)
  {
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.isApplied()))
    {
      this.audioReader = this.mLightNode.getAudioReader();
      initAudioTrack();
      initWritePCMThread();
      this.mLightNode.onResume();
    }
  }
  
  public void setSyncMode(boolean paramBoolean)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.setSyncMode(paramBoolean);
    }
    this.syncMode = paramBoolean;
    this.syncModeUpdated = true;
  }
  
  public void setTapEvent(int paramInt)
  {
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.getAsset() != null)) {
      this.mLightNode.updateCameraConfigData("event.touchPoint", String.valueOf(paramInt));
    }
  }
  
  public void setTouchScale(float paramFloat)
  {
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.getAsset() != null)) {
      this.mLightNode.updateCameraConfigData("touch.scale", String.valueOf(paramFloat));
    }
  }
  
  public void setTouchTriggerEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject = this.mLightNode;
    if ((localObject != null) && (((LightNode)localObject).isApplied()) && (this.mLightNode.getAsset() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{\"x\":");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append(",\"y\":");
      ((StringBuilder)localObject).append(paramFloat2);
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTouchTriggerEvent: jsonStr=");
      localStringBuilder.append((String)localObject);
      Log.d("AEFilterManager", localStringBuilder.toString());
      this.mLightNode.setPresetData("event.touchPoint", (String)localObject);
    }
  }
  
  public void stickerReset(boolean paramBoolean)
  {
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.isApplied())) {
      this.mLightNode.resetAsset();
    }
  }
  
  public void supportMultiThreads(boolean paramBoolean)
  {
    com.tencent.ttpic.openapi.filter.GaussianMaskFilter.reuseFilter = paramBoolean ^ true;
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
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
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
    LightNode localLightNode = this.mLightNode;
    if ((localLightNode != null) && (localLightNode.isApplied())) {
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
  
  public void updateDeviceCameraConfig(DeviceCameraConfig paramDeviceCameraConfig)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.updateDeviceCameraConfig(paramDeviceCameraConfig);
    }
  }
  
  public void updateLutGL(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateLutGL] lut = ");
    localStringBuilder.append(paramString);
    LogUtils.d("AEFilterManager", localStringBuilder.toString());
    this.mLutPath = paramString;
    this.lutUpdated = true;
    paramString = this.mLightNode;
    if ((paramString != null) && (paramString.getAsset() != null))
    {
      this.useLutType = 1001;
      paramString = this.stickerInnerLutFilterListener;
      if (paramString != null) {
        paramString.notifyEnableLutType(this.useLutType);
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
      paramVideoMaterial = this.stickerInnerLutFilterListener;
      if (paramVideoMaterial != null) {
        paramVideoMaterial.onDeviceNotSupportMaterial();
      }
      LogUtils.e("AEFilterManager", "can not support material");
      return;
    }
    this.mVideoMaterial = localVideoMaterial;
    int i;
    if (this.mVideoMaterial.getLightAsset().hasMesh()) {
      i = 2000;
    } else {
      i = 2001;
    }
    this.useMeshType = i;
    paramVideoMaterial = this.stickerInnerLutFilterListener;
    if (paramVideoMaterial != null) {
      paramVideoMaterial.notifyEnableMeshType(this.useMeshType);
    }
    if (this.mVideoMaterial.getLightAsset().hasLut()) {
      i = 1000;
    } else {
      i = 1001;
    }
    this.useLutType = i;
    paramVideoMaterial = this.stickerInnerLutFilterListener;
    if (paramVideoMaterial != null) {
      paramVideoMaterial.notifyEnableLutType(this.useLutType);
    }
    PreviewPerformanceInfo.getInstance().setStickerID(this.mVideoMaterial.getId());
    this.filterConfigMap.clear();
    paramVideoMaterial = this.mAEProfiler;
    if (paramVideoMaterial != null) {
      paramVideoMaterial.reset();
    }
  }
  
  public void updatePhoneRotation(int paramInt)
  {
    this.phoneRotation = paramInt;
  }
  
  public void updateTouchEvent(int paramInt1, long paramLong1, long paramLong2, ArrayList<PointF> paramArrayList, int paramInt2, int paramInt3)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.updateTouchEvent(paramInt1, paramLong1, paramLong2, paramArrayList, paramInt2, paramInt3);
    }
  }
  
  public void updateVoiceDecibel(float paramFloat)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.updateVoiceDecibel(paramFloat);
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWatermarkDict: ");
      localStringBuilder.append(paramMap);
      LogUtils.i("AEFilterManager", localStringBuilder.toString());
      this.mLightNode.updateCameraConfigData("watermark_dict", paramMap);
    }
  }
  
  public List<WMElement> wmGetEditableWMElements()
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode == null) {
      return Collections.emptyList();
    }
    return localLightNode.getEditableWMElement();
  }
  
  public void wmSetLocation(String paramString)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.updateCameraConfigData("[location]", paramString);
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
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.updateCameraConfigData("[temperature]", paramString);
    }
  }
  
  public void wmSetWeatherCode(int paramInt)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.updateCameraConfigData("[weatherType]", String.valueOf(paramInt));
    }
  }
  
  public void wmSetWeatherStr(String paramString)
  {
    LightNode localLightNode = this.mLightNode;
    if (localLightNode != null) {
      localLightNode.updateCameraConfigData("[weather]", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager
 * JD-Core Version:    0.7.0.1
 */