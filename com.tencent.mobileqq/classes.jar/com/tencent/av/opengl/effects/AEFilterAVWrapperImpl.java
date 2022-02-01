package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.api.IAEMaterialManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.utils.AEFilterLogger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.light.utils.LightLogUtil;

public class AEFilterAVWrapperImpl
  implements AEFilterAVWrapper
{
  private static final Map<AEResInfo, String> jdField_a_of_type_JavaUtilMap = ;
  private volatile int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
  private PendantItem jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
  private AEFilterAVWrapperImpl.MyLightAssetListener jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapperImpl$MyLightAssetListener = null;
  private AEFilterAVWrapperImpl.MyTipsListener jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapperImpl$MyTipsListener = null;
  private final BeautyConfig jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig = new BeautyConfig();
  private ExtraTextureRender jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender = null;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
  private final List<BeautyConfig.Beauty> jdField_a_of_type_JavaUtilList = new ArrayList(11);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private final BeautyConfig jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig = new BeautyConfig();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  
  public AEFilterAVWrapperImpl(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AEFilterAVWrapperImpl, mode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapperImpl$MyTipsListener = new AEFilterAVWrapperImpl.MyTipsListener(this);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapperImpl$MyLightAssetListener = new AEFilterAVWrapperImpl.MyLightAssetListener();
    this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.c();
    this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.c();
    a(1);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    GLTexture localGLTexture1 = GLTexture.a(-1, paramInt1);
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender == null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender = new ExtraTextureRender();
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a(2);
    GLTexture localGLTexture2 = this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a(localGLTexture1, paramInt2, paramInt3);
    if (localGLTexture2 != null) {
      paramInt1 = localGLTexture2.jdField_b_of_type_Int;
    }
    if ((localGLTexture2 != localGLTexture1) && (localGLTexture2 != null)) {
      localGLTexture2.a();
    }
    localGLTexture1.a();
    return paramInt1;
  }
  
  private long a(AEResInfo paramAEResInfo)
  {
    int i = paramAEResInfo.index;
    if (paramAEResInfo == AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR) {
      i = AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY.index;
    } else if (paramAEResInfo == AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY) {
      i = AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR.index;
    }
    if (i > 1) {
      return 1 << i - 2;
    }
    return 0L;
  }
  
  private PTFaceAttr a()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      return localAEFilterManager.getFaceAttr();
    }
    return null;
  }
  
  private String a(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc == null) {
      return null;
    }
    Object localObject1 = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
    if (!TextUtils.isEmpty(paramFilterDesc.resRootPath)) {
      localObject1 = paramFilterDesc.resRootPath;
    }
    Object localObject2 = paramFilterDesc.getResFold((String)localObject1);
    QQPtColorFilterInfo localQQPtColorFilterInfo = QQPtColorFilter.getColorFilterInfo((String)localObject2);
    localObject1 = localObject2;
    if (localQQPtColorFilterInfo != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(localQQPtColorFilterInfo.getColorPng());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getLutPath, name[");
      ((StringBuilder)localObject2).append(paramFilterDesc.name);
      ((StringBuilder)localObject2).append("], out[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("AEFilterAVWrapperImpl", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private static Map<AEResInfo, String> a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("assets");
    ((StringBuilder)localObject1).append(File.separator);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("models");
    ((StringBuilder)localObject1).append(File.separator);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = AEResInfo.LIGHT_RES_BUNDLE_HAND;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightHandModel.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_GENDER;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightGenderModel.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_CAT;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightCatModel.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_DEPTH;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightDepthModel.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightSegmentHair.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightSegmentSky.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_ACE3D;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("ace3d");
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_3DMM;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("AEKit3DMM.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightSegmentHead.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_SCENE;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightSceneClassify.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int >= 1) {
      return;
    }
    boolean bool = AEFilterSupport.a(paramInt);
    if ((bool) && (this.jdField_a_of_type_Int < 1))
    {
      this.jdField_a_of_type_Int = 1;
      LightLogUtil.initLogger(new AEFilterLogger());
      LightLogUtil.setMinPriority(6);
    }
    if ((paramInt != 0) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepare ret[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], state[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("], flag[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
    }
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateMaterial]:");
    localStringBuilder.append(paramVideoMaterial.getDataPath());
    QLog.d("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
    if (((IAEMaterialManager)QRoute.api(IAEMaterialManager.class)).isSpecialTemplate(paramVideoMaterial))
    {
      QLog.d("PreCheckAERes", 2, "[setMaterial] set special template");
      if (((IAEResUtil)QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.LIGHT_RES_BASE_PACKAGE))
      {
        QLog.d("PreCheckAERes", 2, "[setMaterial] version check success");
        if (FeatureManager.ensureMaterialSoLoaded(paramVideoMaterial))
        {
          QLog.d("PreCheckAERes", 2, "[setMaterial] so load success。");
          this.jdField_a_of_type_Long = ((IAEResUtil)QRoute.api(IAEResUtil.class)).checkBundleStatus(paramVideoMaterial);
          if (this.jdField_a_of_type_Long != 0L)
          {
            paramVideoMaterial = new StringBuilder();
            paramVideoMaterial.append("[setMaterial] bundleStatus not ready, go fetch bundles ... ");
            paramVideoMaterial.append(this.jdField_a_of_type_Long);
            QLog.d("PreCheckAERes", 2, paramVideoMaterial.toString());
            ((IAEResUtil)QRoute.api(IAEResUtil.class)).fetchBundles(BaseApplication.getContext(), this.jdField_a_of_type_Long);
            return;
          }
          QLog.d("PreCheckAERes", 2, "[setMaterial] bundleStatus ready, apply material...");
          return;
        }
        QLog.e("PreCheckAERes", 2, "[setMaterial] so load failed");
        return;
      }
      QLog.e("PreCheckAERes", 2, "[setMaterial] version check failed");
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_e_of_type_Int == 1) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_Boolean != paramBoolean1)
    {
      this.jdField_b_of_type_Boolean = paramBoolean1;
      ((AEFilterManager)localObject).switchAbilityInLightNode("beauty.enable", paramBoolean1);
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBeautyFilter, isBeautyActive[");
        localStringBuilder.append(paramBoolean1);
        localStringBuilder.append("]");
        QLog.i("AEFilterAVWrapperImpl", 4, localStringBuilder.toString());
      }
    }
    if (this.jdField_c_of_type_Boolean != paramBoolean2)
    {
      this.jdField_c_of_type_Boolean = paramBoolean2;
      ((AEFilterManager)localObject).switchAbilityInLightNode("transform.enable", paramBoolean2);
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBeautyFilter, isTransformActive[");
        localStringBuilder.append(paramBoolean2);
        localStringBuilder.append("]");
        QLog.i("AEFilterAVWrapperImpl", 4, localStringBuilder.toString());
      }
    }
    if ((!paramBoolean1) && (!paramBoolean2) && (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem == null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) && (!this.jdField_a_of_type_Boolean)) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    if (this.jdField_d_of_type_Boolean != paramBoolean1)
    {
      this.jdField_d_of_type_Boolean = paramBoolean1;
      ((AEFilterManager)localObject).switchAbilityInLightNode("ai.face.enable", this.jdField_d_of_type_Boolean);
      ((AEFilterManager)localObject).setOverallSmooth(this.jdField_d_of_type_Boolean ^ true);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateBeautyFilter, enableFaceDetect[");
        ((StringBuilder)localObject).append(paramBoolean1);
        ((StringBuilder)localObject).append("]");
        QLog.i("AEFilterAVWrapperImpl", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    return (this.jdField_a_of_type_Long & paramLong) == paramLong;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int >= 2) {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_Int < 3)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager("defaultBeautyV5.json", false);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightNodeTipsListener(this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapperImpl$MyTipsListener);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightNodeLightAssetListener(this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapperImpl$MyLightAssetListener);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setOverallSmooth(this.jdField_d_of_type_Boolean ^ true);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("denoise.enable", false);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("beauty.enable", this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("transform.enable", this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("ai.face.enable", this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("beauty.faceFeature.enable", false);
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!FileUtils.fileExists((String)localObject)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initAEFilterInGL, fail path[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("]");
        QLog.i("AEFilterAVWrapperImpl", 1, localStringBuilder.toString());
      }
      else
      {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL((String)localObject);
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      f();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setForceFaceDetect(this.jdField_a_of_type_Boolean);
      boolean bool = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited();
      if (bool)
      {
        this.jdField_a_of_type_Int = 2;
        int i = this.jdField_e_of_type_Int;
        if ((i != 0) && (i == 1))
        {
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("smooth.enable", true);
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("denoise.enable", false);
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("beauty.enable", false);
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("transform.enable", false);
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("ai.face.enable", false);
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("sticker.enable", false);
        }
      }
      else
      {
        this.jdField_a_of_type_Int = 3;
      }
      RenderUtils.a(bool);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initAEFilterInGL, state[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("]");
      QLog.i("AEFilterAVWrapperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void e()
  {
    Object localObject1 = jdField_a_of_type_JavaUtilMap;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AEResInfo)((Iterator)localObject1).next();
        long l = a((AEResInfo)localObject2);
        if ((a(l)) && (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist((AEResInfo)localObject2)) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[injectBundlePathsToLight] agentType:");
          localStringBuilder.append(((AEResInfo)localObject2).agentType);
          localStringBuilder.append(" | dir:");
          localStringBuilder.append(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir((AEResInfo)localObject2));
          QLog.d("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightBundle(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir((AEResInfo)localObject2), ((AEResInfo)localObject2).agentType);
          this.jdField_a_of_type_Long &= (0xFFFFFFFF ^ l);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[injectBundlePathsToLight] curResBundleStatus:");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append("mNeedLoadAllBundleStatus:");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
          QLog.d("AEFilterAVWrapperImpl", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  private void f()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      AEResInfo localAEResInfo = (AEResInfo)localIterator.next();
      if ((((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(localAEResInfo)) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[prepareBundleToLight] agentType:");
        localStringBuilder.append(localAEResInfo.agentType);
        localStringBuilder.append(" | dir:");
        localStringBuilder.append(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir(localAEResInfo));
        QLog.d("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightBundle(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir(localAEResInfo), localAEResInfo.agentType);
      }
    }
  }
  
  private void g()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig;
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    boolean bool1 = false;
    ((BeautyConfig)localObject1).a(0, (List)localObject2);
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool2 = false;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BeautyConfig.Beauty)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        int i = ((BeautyConfig.Beauty)localObject2).jdField_a_of_type_Int;
        if (i != 1)
        {
          String str;
          if (i != 2)
          {
            if (i == 3)
            {
              str = BeautyConfig.a(((BeautyConfig.Beauty)localObject2).jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE.value);
              if (((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int != this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str))
              {
                localAEFilterManager.setBeautyOrTransformLevel(((BeautyConfig.Beauty)localObject2).jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE, ((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int);
                this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str, ((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int);
              }
              if (((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int != ((BeautyConfig.Beauty)localObject2).jdField_c_of_type_Int) {
                bool2 = true;
              }
            }
          }
          else
          {
            str = BeautyConfig.a(((BeautyConfig.Beauty)localObject2).jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE.value);
            if (((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int != this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str))
            {
              localAEFilterManager.setBeautyOrTransformLevel(((BeautyConfig.Beauty)localObject2).jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE, ((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int);
              this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str, ((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int);
            }
            if (((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int != ((BeautyConfig.Beauty)localObject2).jdField_c_of_type_Int) {
              bool1 = true;
            }
          }
        }
        else if (((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int != this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a("BEAUTY_SKIN"))
        {
          localAEFilterManager.setSmoothSharpenStrength(0.0F);
          localAEFilterManager.setSmoothLevel(((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int);
          this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a("BEAUTY_SKIN", ((BeautyConfig.Beauty)localObject2).jdField_d_of_type_Int);
        }
      }
    }
    a(bool1, bool2);
    localObject1 = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
    if ((localObject1 != null) && (PendantItem.isBeautyMakeup(((PendantItem)localObject1).getCategory())))
    {
      if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam instanceof Integer)) {
        this.jdField_d_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam).intValue();
      }
      localAEFilterManager.setCosmeticsAlpha(this.jdField_d_of_type_Int);
    }
    h();
  }
  
  private void h()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if ((this.jdField_e_of_type_Boolean) && (localAEFilterManager != null) && (PtuResChecker.a().a(AEResInfo.LIGHT_RES_BUNDLE_HAND.index)))
    {
      this.jdField_e_of_type_Boolean = false;
      try
      {
        AEResInfo localAEResInfo = AEResInfo.LIGHT_RES_BUNDLE_HAND;
        localAEFilterManager.setLightBundle(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir(localAEResInfo), localAEResInfo.agentType);
      }
      catch (Throwable localThrowable)
      {
        QLog.i("AEFilterAVWrapperImpl", 1, "updateParam", localThrowable);
      }
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterAVWrapperImpl", 2, "updateParam, has load hand bundle.");
      }
    }
    if ((this.jdField_a_of_type_Long > 0L) && (localAEFilterManager != null)) {
      e();
    }
  }
  
  private void i()
  {
    ExtraTextureRender localExtraTextureRender = this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender;
    if (localExtraTextureRender != null)
    {
      localExtraTextureRender.a();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender = null;
    }
  }
  
  public int a(int paramInt, boolean paramBoolean1, FaceData paramFaceData, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      a(0);
      return paramInt;
    }
    if (this.jdField_a_of_type_Int < 2) {
      d();
    }
    if (this.jdField_a_of_type_Int >= 3) {
      return paramInt;
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return paramInt;
    }
    int j = a(paramInt, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    g();
    int i = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(j, paramBoolean1, System.currentTimeMillis() * 1000000L);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.notifyDetectFaceAttr();
    if (paramFaceData != null) {
      paramFaceData.a(a(), paramBoolean2);
    }
    if (i == j)
    {
      i = paramInt;
      if (QLog.isDevelopLevel())
      {
        QLog.i("AEFilterAVWrapperImpl", 4, "drawFrameInGL, AEFilterManager do nothing.");
        return paramInt;
      }
    }
    return i;
  }
  
  public void a()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateMaterialGL(null);
    }
    localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateLutGL(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "uninitInGL");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "initInGL");
    }
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearState, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("AEFilterAVWrapperImpl", 1, localStringBuilder.toString());
    TipsInfo.a().a(paramLong);
  }
  
  public void a(PendantItem paramPendantItem, VideoMaterial paramVideoMaterial)
  {
    if ((!RenderUtils.a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramPendantItem)) || (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != paramVideoMaterial))
    {
      boolean bool2 = false;
      boolean bool1;
      if ((paramPendantItem != null) && (paramPendantItem.hasGesture())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setPendant, pendantItem[");
        ((StringBuilder)localObject).append(paramPendantItem);
        ((StringBuilder)localObject).append("], isPendantHasGesture[");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append("]");
        QLog.d("AEFilterAVWrapperImpl", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
      if ((localObject != null) && (!((AEFilterManager)localObject).isInited()))
      {
        QLog.i("AEFilterAVWrapperImpl", 1, "initAEDetector failed!");
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = paramPendantItem;
        this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
        paramPendantItem = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
        if (paramPendantItem != null) {
          a(paramPendantItem);
        }
        paramPendantItem = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
        if (paramPendantItem != null) {
          paramPendantItem.updateMaterialGL(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
        }
        if (bool1)
        {
          if (!PtuResChecker.a().a(AEResInfo.LIGHT_RES_BUNDLE_HAND.index)) {
            bool1 = PtuResChecker.a().a(null, AEResInfo.LIGHT_RES_BUNDLE_HAND.index);
          } else {
            bool1 = true;
          }
          if (!bool1) {
            bool2 = true;
          }
          this.jdField_e_of_type_Boolean = bool2;
          TipsInfo.a().a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getGestureType());
          if (QLog.isColorLevel())
          {
            paramPendantItem = new StringBuilder();
            paramPendantItem.append("setPendant, need gesture bundle. isNeedLoad[");
            paramPendantItem.append(this.jdField_e_of_type_Boolean);
            paramPendantItem.append("]");
            QLog.i("AEFilterAVWrapperImpl", 2, paramPendantItem.toString());
          }
        }
        else
        {
          this.jdField_e_of_type_Boolean = false;
          TipsInfo.a().b();
        }
      }
    }
    paramPendantItem = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
    if ((paramPendantItem != null) && (PendantItem.isBeautyMakeup(paramPendantItem.getCategory())) && ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam instanceof Integer))) {
      this.jdField_d_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam).intValue();
    }
  }
  
  public void a(FaceData paramFaceData)
  {
    if (a()) {
      return;
    }
    boolean bool = false;
    PendantItem localPendantItem = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
    if (localPendantItem != null) {
      bool = localPendantItem.hasFace();
    }
    if ((paramFaceData != null) && (paramFaceData.jdField_a_of_type_Int > 0))
    {
      TipsInfo.a().d();
      return;
    }
    if ((this.jdField_a_of_type_Boolean) || (bool)) {
      TipsInfo.a().c();
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    if (!RenderUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramFilterDesc))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      String str = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && ((TextUtils.isEmpty(str)) || (FileUtils.fileExists(str))))
      {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(str);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setFilterDesc, fail path[");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        QLog.i("AEFilterAVWrapperImpl", 1, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setFilterDesc, name[");
        if (paramFilterDesc == null) {
          paramFilterDesc = "null";
        } else {
          paramFilterDesc = paramFilterDesc.name;
        }
        localStringBuilder.append(paramFilterDesc);
        localStringBuilder.append("], path[");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        QLog.i("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_Boolean != paramBoolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNeedFaceData, needDetectFace[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("AEFilterAVWrapperImpl", 4, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localObject != null) {
      ((AEFilterManager)localObject).setForceFaceDetect(this.jdField_a_of_type_Boolean);
    }
  }
  
  public boolean a()
  {
    PendantItem localPendantItem = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
    return (localPendantItem != null) && (localPendantItem.hasGesture());
  }
  
  public boolean a(BeautyConfig paramBeautyConfig)
  {
    if (paramBeautyConfig == null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.c();
    } else {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(paramBeautyConfig);
    }
    return this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.b();
  }
  
  public void b()
  {
    i();
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.setLightNodeTipsListener(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightNodeLightAssetListener(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.destroy();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
    }
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "destroyInGL");
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((this.jdField_b_of_type_Int == paramInt1) && (this.jdField_c_of_type_Int == paramInt2)) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateWidthHeight, width[");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("], height[");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("]");
        QLog.i("AEFilterAVWrapperImpl", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt2;
      Object localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
      if (localObject != null) {
        ((AEFilterManager)localObject).updateWidthHeight(paramInt1, paramInt2);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c() {}
  
  public void c(int paramInt1, int paramInt2) {}
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterAVWrapperImpl
 * JD-Core Version:    0.7.0.1
 */