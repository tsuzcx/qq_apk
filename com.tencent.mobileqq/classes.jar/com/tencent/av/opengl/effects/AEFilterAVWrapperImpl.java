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
import org.light.bean.LightAIData;
import org.light.bean.LightAIDataWrapper;
import org.light.utils.LightLogUtil;

public class AEFilterAVWrapperImpl
  implements AEFilterAVWrapper
{
  private static final Map<AEResInfo, String> w = ;
  private volatile int a;
  private int b = 0;
  private int c = 0;
  private AEFilterManager d = null;
  private final BeautyConfig e = new BeautyConfig();
  private final BeautyConfig f = new BeautyConfig();
  private final List<BeautyConfig.Beauty> g = new ArrayList(11);
  private FilterDesc h = null;
  private PendantItem i = null;
  private VideoMaterial j = null;
  private boolean k = false;
  private int l = 0;
  private int m = 0;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private long r = 0L;
  private ExtraTextureRender s = null;
  private AEFilterAVWrapperImpl.MyTipsListener t = null;
  private AEFilterAVWrapperImpl.MyLightAssetListener u = null;
  private AEFilterAVWrapperImpl.MyInnerEffectListener v = null;
  
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
    this.a = 0;
    this.m = paramInt;
    if (this.m == 1)
    {
      this.p = false;
      this.o = false;
      this.n = false;
    }
    this.t = new AEFilterAVWrapperImpl.MyTipsListener(this);
    this.u = new AEFilterAVWrapperImpl.MyLightAssetListener();
    this.v = new AEFilterAVWrapperImpl.MyInnerEffectListener();
    this.e.e();
    this.f.e();
    a(1);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    GLTexture localGLTexture1 = GLTexture.a(-1, paramInt1);
    if (this.s == null) {
      this.s = new ExtraTextureRender();
    }
    this.s.a(2);
    GLTexture localGLTexture2 = this.s.a(localGLTexture1, paramInt2, paramInt3);
    if (localGLTexture2 != null) {
      paramInt1 = localGLTexture2.b;
    }
    if ((localGLTexture2 != localGLTexture1) && (localGLTexture2 != null)) {
      localGLTexture2.a();
    }
    localGLTexture1.a();
    return paramInt1;
  }
  
  private long a(AEResInfo paramAEResInfo)
  {
    int i1 = paramAEResInfo.index;
    if (paramAEResInfo == AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR) {
      i1 = AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY.index;
    } else if (paramAEResInfo == AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY) {
      i1 = AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR.index;
    }
    if (i1 > 1) {
      return 1 << i1 - 2;
    }
    return 0L;
  }
  
  private void a(int paramInt)
  {
    if (this.a >= 1) {
      return;
    }
    boolean bool = AEFilterSupport.a(paramInt);
    if ((bool) && (this.a < 1))
    {
      this.a = 1;
      LightLogUtil.initLogger(new AEFilterLogger());
      LightLogUtil.setMinPriority(6);
    }
    if ((paramInt != 0) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepare ret[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], state[");
      localStringBuilder.append(this.a);
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
          this.r = ((IAEResUtil)QRoute.api(IAEResUtil.class)).checkBundleStatus(paramVideoMaterial);
          if (this.r != 0L)
          {
            paramVideoMaterial = new StringBuilder();
            paramVideoMaterial.append("[setMaterial] bundleStatus not ready, go fetch bundles ... ");
            paramVideoMaterial.append(this.r);
            QLog.d("PreCheckAERes", 2, paramVideoMaterial.toString());
            ((IAEResUtil)QRoute.api(IAEResUtil.class)).fetchBundles(BaseApplication.getContext(), this.r);
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
    if (this.m == 1) {
      return;
    }
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (this.n != paramBoolean1)
    {
      this.n = paramBoolean1;
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
    if (this.o != paramBoolean2)
    {
      this.o = paramBoolean2;
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
    if ((!paramBoolean1) && (!paramBoolean2) && (this.i == null) && (this.h == null) && (this.j == null) && (!this.k)) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    if (this.p != paramBoolean1)
    {
      this.p = paramBoolean1;
      ((AEFilterManager)localObject).switchAbilityInLightNode("ai.face.enable", this.p);
      ((AEFilterManager)localObject).setOverallSmooth(this.p ^ true);
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
  
  private String b(FilterDesc paramFilterDesc)
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
  
  private boolean b(long paramLong)
  {
    return (this.r & paramLong) == paramLong;
  }
  
  private void g()
  {
    if (this.a >= 2) {
      return;
    }
    Object localObject;
    if (this.a < 3)
    {
      this.d = new AEFilterManager("defaultBeautyV5.json", true, null);
      this.d.setLightNodeTipsListener(this.t);
      this.d.setLightNodeLightAssetListener(this.u);
      this.d.setStickerInnerLutFilterListener(this.v);
      this.d.initInGL(this.b, this.c);
      this.d.setOverallSmooth(this.p ^ true);
      this.d.switchAbilityInLightNode("denoise.enable", false);
      this.d.switchAbilityInLightNode("beauty.enable", this.n);
      this.d.switchAbilityInLightNode("transform.enable", this.o);
      this.d.switchAbilityInLightNode("ai.face.enable", this.p);
      this.d.switchAbilityInLightNode("beauty.faceFeature.enable", false);
      localObject = b(this.h);
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
        this.d.updateLutGL((String)localObject);
      }
      this.d.updateMaterialGL(this.j);
      j();
      this.d.setForceFaceDetect(this.k);
      boolean bool = this.d.isInited();
      if (bool)
      {
        this.a = 2;
        int i1 = this.m;
        if ((i1 != 0) && (i1 == 1))
        {
          this.d.switchAbilityInLightNode("smooth.enable", true);
          this.d.switchAbilityInLightNode("denoise.enable", false);
          this.d.switchAbilityInLightNode("beauty.enable", false);
          this.d.switchAbilityInLightNode("transform.enable", false);
          this.d.switchAbilityInLightNode("ai.face.enable", false);
          this.d.switchAbilityInLightNode("sticker.enable", false);
        }
      }
      else
      {
        this.a = 3;
      }
      RenderUtils.a(bool);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initAEFilterInGL, state[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("]");
      QLog.i("AEFilterAVWrapperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h()
  {
    if (this.a >= 2) {
      return;
    }
    if (this.a < 3)
    {
      this.d = new AEFilterManager("defaultBeautyEmpty.json", true, p());
      this.d.setLightNodeTipsListener(this.t);
      this.d.setLightNodeLightAssetListener(this.u);
      this.d.setStickerInnerLutFilterListener(this.v);
      this.d.initInGL(this.b, this.c);
      this.d.setOverallSmooth(false);
      b(false);
      this.d.updateMaterialGL(this.j);
      j();
      this.d.setForceFaceDetect(this.k);
      boolean bool = this.d.isInited();
      if (bool) {
        this.a = 2;
      } else {
        this.a = 3;
      }
      RenderUtils.a(bool);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAEFilterInGL, state[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.i("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
    }
  }
  
  private void i()
  {
    Object localObject1 = w;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AEResInfo)((Iterator)localObject1).next();
        long l1 = a((AEResInfo)localObject2);
        if ((b(l1)) && (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist((AEResInfo)localObject2)) && (this.d != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[injectBundlePathsToLight] agentType:");
          localStringBuilder.append(((AEResInfo)localObject2).agentType);
          localStringBuilder.append(" | dir:");
          localStringBuilder.append(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir((AEResInfo)localObject2));
          QLog.d("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
          this.d.setLightBundle(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir((AEResInfo)localObject2), ((AEResInfo)localObject2).agentType);
          this.r &= (0xFFFFFFFF ^ l1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[injectBundlePathsToLight] curResBundleStatus:");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append("mNeedLoadAllBundleStatus:");
          ((StringBuilder)localObject2).append(this.r);
          QLog.d("AEFilterAVWrapperImpl", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  private void j()
  {
    Iterator localIterator = w.keySet().iterator();
    while (localIterator.hasNext())
    {
      AEResInfo localAEResInfo = (AEResInfo)localIterator.next();
      if ((((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(localAEResInfo)) && (this.d != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[prepareBundleToLight] agentType:");
        localStringBuilder.append(localAEResInfo.agentType);
        localStringBuilder.append(" | dir:");
        localStringBuilder.append(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir(localAEResInfo));
        QLog.d("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
        this.d.setLightBundle(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir(localAEResInfo), localAEResInfo.agentType);
      }
    }
  }
  
  private static Map<AEResInfo, String> k()
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
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_BODY;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightBodyModel.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_EMOTION;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightEmotionModel.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private void l()
  {
    AEFilterManager localAEFilterManager = this.d;
    if (localAEFilterManager == null) {
      return;
    }
    this.g.clear();
    Object localObject1 = this.e;
    Object localObject2 = this.g;
    boolean bool1 = false;
    ((BeautyConfig)localObject1).a(0, (List)localObject2);
    localObject1 = this.g.iterator();
    boolean bool2 = false;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BeautyConfig.Beauty)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        int i1 = ((BeautyConfig.Beauty)localObject2).a;
        if (i1 != 1)
        {
          String str;
          if (i1 != 2)
          {
            if (i1 == 3)
            {
              str = BeautyConfig.a(((BeautyConfig.Beauty)localObject2).b.value);
              if (((BeautyConfig.Beauty)localObject2).e != this.f.b(str))
              {
                localAEFilterManager.setBeautyOrTransformLevel(((BeautyConfig.Beauty)localObject2).b, ((BeautyConfig.Beauty)localObject2).e);
                this.f.a(str, ((BeautyConfig.Beauty)localObject2).e);
              }
              if (((BeautyConfig.Beauty)localObject2).e != ((BeautyConfig.Beauty)localObject2).d) {
                bool2 = true;
              }
            }
          }
          else
          {
            str = BeautyConfig.a(((BeautyConfig.Beauty)localObject2).b.value);
            if (((BeautyConfig.Beauty)localObject2).e != this.f.b(str))
            {
              localAEFilterManager.setBeautyOrTransformLevel(((BeautyConfig.Beauty)localObject2).b, ((BeautyConfig.Beauty)localObject2).e);
              this.f.a(str, ((BeautyConfig.Beauty)localObject2).e);
            }
            if (((BeautyConfig.Beauty)localObject2).e != ((BeautyConfig.Beauty)localObject2).d) {
              bool1 = true;
            }
          }
        }
        else if (((BeautyConfig.Beauty)localObject2).e != this.f.b("BEAUTY_SKIN"))
        {
          localAEFilterManager.setSmoothSharpenStrength(0.0F);
          localAEFilterManager.setSmoothLevel(((BeautyConfig.Beauty)localObject2).e);
          this.f.a("BEAUTY_SKIN", ((BeautyConfig.Beauty)localObject2).e);
        }
      }
    }
    a(bool1, bool2);
    localObject1 = this.i;
    if ((localObject1 != null) && (PendantItem.isBeautyMakeup(((PendantItem)localObject1).getCategory())))
    {
      if ((this.i.extraParam instanceof Integer)) {
        this.l = ((Integer)this.i.extraParam).intValue();
      }
      localAEFilterManager.setCosmeticsAlpha(this.l);
    }
    n();
  }
  
  private PTFaceAttr m()
  {
    AEFilterManager localAEFilterManager = this.d;
    if (localAEFilterManager != null) {
      return localAEFilterManager.getFaceAttr();
    }
    return null;
  }
  
  private void n()
  {
    AEFilterManager localAEFilterManager = this.d;
    if ((this.q) && (localAEFilterManager != null) && (PtuResChecker.a().a(AEResInfo.LIGHT_RES_BUNDLE_HAND.index)))
    {
      this.q = false;
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
    if ((this.r > 0L) && (localAEFilterManager != null)) {
      i();
    }
  }
  
  private void o()
  {
    ExtraTextureRender localExtraTextureRender = this.s;
    if (localExtraTextureRender != null)
    {
      localExtraTextureRender.b();
      this.s = null;
    }
  }
  
  private Map<String, String> p()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ai.face.ignore", "FACE_AGENT");
    localHashMap.put("ai.hand.ignore", "HAND_AGENT");
    localHashMap.put("ai.segmentation.ignore", "BG_SEG_AGENT");
    localHashMap.put("ai.3dmm.ignore", "k3D_MM_AGENT");
    localHashMap.put("ai.body.ignore", "BODY_AGENT");
    localHashMap.put("ai.emotion.ignore", "EMOTION_AGENT");
    return localHashMap;
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (this.a < 1)
    {
      a(0);
      return paramInt;
    }
    if (this.a < 2) {
      h();
    }
    if (this.a >= 3) {
      return paramInt;
    }
    if (this.d == null) {
      return paramInt;
    }
    if (this.r > 0L) {
      i();
    }
    return this.d.drawFrame(paramInt, paramBoolean, System.currentTimeMillis() * 1000000L);
  }
  
  public int a(int paramInt, boolean paramBoolean1, FaceData paramFaceData, boolean paramBoolean2)
  {
    if (this.a < 1)
    {
      a(0);
      return paramInt;
    }
    if (this.a < 2) {
      g();
    }
    if (this.a >= 3) {
      return paramInt;
    }
    if (this.d == null) {
      return paramInt;
    }
    int i2 = a(paramInt, this.b, this.c);
    l();
    int i1 = this.d.drawFrame(i2, paramBoolean1, System.currentTimeMillis() * 1000000L);
    this.d.notifyDetectFaceAttr();
    if (paramFaceData != null) {
      paramFaceData.a(m(), paramBoolean2);
    }
    if (i1 == i2)
    {
      i1 = paramInt;
      if (QLog.isDevelopLevel())
      {
        QLog.i("AEFilterAVWrapperImpl", 4, "drawFrameInGL, AEFilterManager do nothing.");
        return paramInt;
      }
    }
    return i1;
  }
  
  public void a()
  {
    AEFilterManager localAEFilterManager = this.d;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateMaterialGL(null);
    }
    localAEFilterManager = this.d;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateLutGL(null);
    }
    this.h = null;
    this.i = null;
    this.j = null;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "uninitInGL");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
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
    if ((!RenderUtils.a(this.i, paramPendantItem)) || (this.j != paramVideoMaterial))
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
      Object localObject = this.d;
      if ((localObject != null) && (!((AEFilterManager)localObject).isInited()))
      {
        QLog.i("AEFilterAVWrapperImpl", 1, "initAEDetector failed!");
      }
      else
      {
        this.i = paramPendantItem;
        this.j = paramVideoMaterial;
        paramPendantItem = this.j;
        if (paramPendantItem != null) {
          a(paramPendantItem);
        }
        paramPendantItem = this.d;
        if (paramPendantItem != null) {
          paramPendantItem.updateMaterialGL(this.j);
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
          this.q = bool2;
          TipsInfo.a().a(this.i.getGestureType());
          if (QLog.isColorLevel())
          {
            paramPendantItem = new StringBuilder();
            paramPendantItem.append("setPendant, need gesture bundle. isNeedLoad[");
            paramPendantItem.append(this.q);
            paramPendantItem.append("]");
            QLog.i("AEFilterAVWrapperImpl", 2, paramPendantItem.toString());
          }
        }
        else
        {
          this.q = false;
          TipsInfo.a().d();
        }
      }
    }
    paramPendantItem = this.i;
    if ((paramPendantItem != null) && (PendantItem.isBeautyMakeup(paramPendantItem.getCategory())) && ((this.i.extraParam instanceof Integer))) {
      this.l = ((Integer)this.i.extraParam).intValue();
    }
  }
  
  public void a(FaceData paramFaceData)
  {
    if (c()) {
      return;
    }
    boolean bool = false;
    PendantItem localPendantItem = this.i;
    if (localPendantItem != null) {
      bool = localPendantItem.hasFace();
    }
    if ((paramFaceData != null) && (paramFaceData.c > 0))
    {
      TipsInfo.a().f();
      return;
    }
    if ((this.k) || (bool)) {
      TipsInfo.a().e();
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    if (!RenderUtils.a(this.h, paramFilterDesc))
    {
      this.h = paramFilterDesc;
      String str = b(this.h);
      StringBuilder localStringBuilder;
      if ((this.d != null) && ((TextUtils.isEmpty(str)) || (FileUtils.fileExists(str))))
      {
        this.d.updateLutGL(str);
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
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPresetData ");
    localStringBuilder.append(paramString);
    QLog.d("AEFilterAVWrapperImpl", 1, localStringBuilder.toString());
    if (this.d != null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramString = "{\"bgSrc\":\"resetBg\"}";
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("{\"bgSrc\":\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"}");
        paramString = localStringBuilder.toString();
      }
      this.d.setPresetData("event.script.switchBg", paramString);
    }
  }
  
  public void a(LightAIDataWrapper paramLightAIDataWrapper)
  {
    AEFilterManager localAEFilterManager = this.d;
    if (localAEFilterManager != null) {
      localAEFilterManager.setLightAIDataWrapper(paramLightAIDataWrapper);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) && (this.k != paramBoolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNeedFaceData, needDetectFace[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("AEFilterAVWrapperImpl", 4, ((StringBuilder)localObject).toString());
    }
    this.k = paramBoolean;
    Object localObject = this.d;
    if (localObject != null) {
      ((AEFilterManager)localObject).setForceFaceDetect(this.k);
    }
  }
  
  public boolean a(BeautyConfig paramBeautyConfig)
  {
    if (paramBeautyConfig == null) {
      this.e.e();
    } else {
      this.e.a(paramBeautyConfig);
    }
    return this.e.f();
  }
  
  public LightAIData b(String paramString)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((AEFilterManager)localObject).getLightAIDataWrapper(new String[] { paramString }, 4);
      if (localObject != null) {
        return ((LightAIDataWrapper)localObject).getAIData(paramString);
      }
    }
    return null;
  }
  
  public void b()
  {
    o();
    AEFilterManager localAEFilterManager = this.d;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.setLightNodeTipsListener(null);
      this.d.setLightNodeLightAssetListener(null);
      this.d.updateLutGL(null);
      this.d.updateMaterialGL(null);
      this.d.destroy();
      this.d = null;
    }
    this.a = 4;
    this.h = null;
    this.j = null;
    this.i = null;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "destroyInGL");
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((this.b == paramInt1) && (this.c == paramInt2)) {
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
      this.b = paramInt1;
      this.c = paramInt2;
      Object localObject = this.d;
      if (localObject != null) {
        ((AEFilterManager)localObject).updateWidthHeight(paramInt1, paramInt2);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    AEFilterManager localAEFilterManager = this.d;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.switchAIAbility("ai.face.ignore", "FACE_AGENT");
      this.d.switchAIAbility("ai.hand.ignore", "HAND_AGENT");
      this.d.switchAIAbility("ai.segmentation.ignore", "BG_SEG_AGENT");
      this.d.switchAIAbility("ai.3dmm.ignore", "k3D_MM_AGENT");
      this.d.switchAIAbility("ai.body.ignore", "BODY_AGENT");
      this.d.switchAIAbility("ai.emotion.ignore", "EMOTION_AGENT");
    }
  }
  
  public void c(int paramInt1, int paramInt2) {}
  
  public boolean c()
  {
    PendantItem localPendantItem = this.i;
    return (localPendantItem != null) && (localPendantItem.hasGesture());
  }
  
  public void d() {}
  
  public boolean e()
  {
    return this.k;
  }
  
  public boolean f()
  {
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterAVWrapperImpl
 * JD-Core Version:    0.7.0.1
 */