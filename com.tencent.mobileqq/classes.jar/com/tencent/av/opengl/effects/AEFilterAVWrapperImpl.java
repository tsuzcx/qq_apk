package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEFilterAVWrapperImpl
  implements AEFilterAVWrapper
{
  private volatile int jdField_a_of_type_Int;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
  private PendantItem jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
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
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "AEFilterAVWrapperImpl, mode[" + paramInt + "]");
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
  
  private PTFaceAttr a()
  {
    PTFaceAttr localPTFaceAttr = null;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      localPTFaceAttr = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getFaceAttr();
    }
    return localPTFaceAttr;
  }
  
  private String a(FilterDesc paramFilterDesc)
  {
    Object localObject2;
    if (paramFilterDesc == null) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject1 = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
      if (!TextUtils.isEmpty(paramFilterDesc.resRootPath)) {
        localObject1 = paramFilterDesc.resRootPath;
      }
      localObject2 = paramFilterDesc.getResFold((String)localObject1);
      QQPtColorFilterInfo localQQPtColorFilterInfo = QQPtColorFilter.getColorFilterInfo((String)localObject2);
      localObject1 = localObject2;
      if (localQQPtColorFilterInfo != null) {
        localObject1 = (String)localObject2 + localQQPtColorFilterInfo.getColorPng();
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.i("AEFilterAVWrapperImpl", 2, "getLutPath, name[" + paramFilterDesc.name + "], out[" + (String)localObject1 + "]");
    return localObject1;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int >= 1) {}
    boolean bool;
    do
    {
      return;
      bool = AEFilterSupport.a(paramInt);
      if ((bool) && (this.jdField_a_of_type_Int < 1)) {
        this.jdField_a_of_type_Int = 1;
      }
    } while ((paramInt == 0) || (!QLog.isColorLevel()));
    QLog.i("AEFilterAVWrapperImpl", 2, "prepare ret[" + bool + "], state[" + this.jdField_a_of_type_Int + "], flag[" + paramInt + "]");
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (this.jdField_e_of_type_Int == 1) {}
    AEFilterManager localAEFilterManager;
    do
    {
      return;
      localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    } while (localAEFilterManager == null);
    if (this.jdField_b_of_type_Boolean != paramBoolean1)
    {
      this.jdField_b_of_type_Boolean = paramBoolean1;
      localAEFilterManager.switchAbilityInLightNode("beauty.enable", paramBoolean1);
      if (QLog.isDevelopLevel()) {
        QLog.i("AEFilterAVWrapperImpl", 4, "updateBeautyFilter, isBeautyActive[" + paramBoolean1 + "]");
      }
    }
    if (this.jdField_c_of_type_Boolean != paramBoolean2)
    {
      this.jdField_c_of_type_Boolean = paramBoolean2;
      localAEFilterManager.switchAbilityInLightNode("transform.enable", paramBoolean2);
      if (QLog.isDevelopLevel()) {
        QLog.i("AEFilterAVWrapperImpl", 4, "updateBeautyFilter, isTransformActive[" + paramBoolean2 + "]");
      }
    }
    if ((paramBoolean1) || (paramBoolean2) || (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) || (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) || (this.jdField_a_of_type_Boolean))
    {
      paramBoolean1 = true;
      label174:
      if (this.jdField_d_of_type_Boolean == paramBoolean1) {
        break label253;
      }
      this.jdField_d_of_type_Boolean = paramBoolean1;
      localAEFilterManager.switchAbilityInLightNode("ai.face.enable", this.jdField_d_of_type_Boolean);
      if (this.jdField_d_of_type_Boolean) {
        break label255;
      }
    }
    label253:
    label255:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      localAEFilterManager.setOverallSmooth(paramBoolean2);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("AEFilterAVWrapperImpl", 4, "updateBeautyFilter, enableFaceDetect[" + paramBoolean1 + "]");
      return;
      paramBoolean1 = false;
      break label174;
      break;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int >= 2) {
      return;
    }
    Object localObject;
    boolean bool;
    if (this.jdField_a_of_type_Int < 3)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager("defaultBeautyV5.json");
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightNodeTipsListener(this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapperImpl$MyTipsListener);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
      if (this.jdField_d_of_type_Boolean) {
        break label255;
      }
      bool = true;
      label70:
      ((AEFilterManager)localObject).setOverallSmooth(bool);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("denoise.enable", false);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("beauty.enable", this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("transform.enable", this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("ai.face.enable", this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyNormalAlpha(0.8F);
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!FileUtils.a((String)localObject))) {
        break label260;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL((String)localObject);
      label164:
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setForceFaceDetect(this.jdField_a_of_type_Boolean);
      bool = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited();
      if (!bool) {
        break label367;
      }
      this.jdField_a_of_type_Int = 2;
      if (this.jdField_e_of_type_Int != 0) {
        break label294;
      }
    }
    for (;;)
    {
      RenderUtils.a(bool);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AEFilterAVWrapperImpl", 2, "initAEFilterInGL, state[" + this.jdField_a_of_type_Int + "]");
      return;
      label255:
      bool = false;
      break label70;
      label260:
      QLog.i("AEFilterAVWrapperImpl", 1, "initAEFilterInGL, fail path[" + (String)localObject + "]");
      break label164;
      label294:
      if (this.jdField_e_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("smooth.enable", true);
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("denoise.enable", false);
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("beauty.enable", false);
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("transform.enable", false);
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("ai.face.enable", false);
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("sticker.enable", false);
        continue;
        label367:
        this.jdField_a_of_type_Int = 3;
      }
    }
  }
  
  private void e()
  {
    boolean bool2 = false;
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(0, this.jdField_a_of_type_JavaUtilList);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      BeautyConfig.Beauty localBeauty = (BeautyConfig.Beauty)localIterator.next();
      if (localBeauty != null)
      {
        label108:
        boolean bool3;
        switch (localBeauty.jdField_a_of_type_Int)
        {
        default: 
          bool3 = bool2;
          bool2 = bool1;
          bool1 = bool3;
        }
        for (;;)
        {
          bool3 = bool2;
          bool2 = bool1;
          bool1 = bool3;
          break;
          if (localBeauty.jdField_d_of_type_Int == this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a("BEAUTY_SKIN")) {
            break label108;
          }
          localAEFilterManager.setSmoothSharpenStrength(0.0F);
          localAEFilterManager.setSmoothLevel(localBeauty.jdField_d_of_type_Int);
          this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a("BEAUTY_SKIN", localBeauty.jdField_d_of_type_Int);
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          continue;
          String str = BeautyConfig.a(localBeauty.jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE.value);
          if (localBeauty.jdField_d_of_type_Int != this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str))
          {
            localAEFilterManager.setBeautyOrTransformLevel(localBeauty.jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE, localBeauty.jdField_d_of_type_Int);
            this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str, localBeauty.jdField_d_of_type_Int);
          }
          if (localBeauty.jdField_d_of_type_Int == localBeauty.jdField_c_of_type_Int) {
            break label108;
          }
          bool1 = bool2;
          bool2 = true;
          continue;
          str = BeautyConfig.a(localBeauty.jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE.value);
          if (localBeauty.jdField_d_of_type_Int != this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str))
          {
            localAEFilterManager.setBeautyOrTransformLevel(localBeauty.jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE, localBeauty.jdField_d_of_type_Int);
            this.jdField_b_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str, localBeauty.jdField_d_of_type_Int);
          }
          if (localBeauty.jdField_d_of_type_Int == localBeauty.jdField_c_of_type_Int) {
            break label108;
          }
          bool3 = true;
          bool2 = bool1;
          bool1 = bool3;
        }
      }
    }
    a(bool1, bool2);
    if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (PendantItem.isBeautyMakeup(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getCategory())))
    {
      if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam instanceof Integer)) {
        this.jdField_d_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam).intValue();
      }
      localAEFilterManager.setCosmeticsAlpha(this.jdField_d_of_type_Int);
    }
    f();
  }
  
  private void f()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if ((this.jdField_e_of_type_Boolean) && (localAEFilterManager != null) && (PtuResChecker.a().a(AEResInfo.d.jdField_a_of_type_Int))) {
      this.jdField_e_of_type_Boolean = false;
    }
    try
    {
      AEResInfo localAEResInfo = AEResInfo.d;
      localAEFilterManager.setLightBundle(AEResUtil.c(localAEResInfo), localAEResInfo.c);
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterAVWrapperImpl", 2, "updateParam, has load hand bundle.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("AEFilterAVWrapperImpl", 1, "updateParam", localThrowable);
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender = null;
    }
  }
  
  public int a(int paramInt, boolean paramBoolean1, FaceData paramFaceData, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Int < 1) {
      a(0);
    }
    int j;
    do
    {
      do
      {
        return paramInt;
        if (this.jdField_a_of_type_Int < 2) {
          d();
        }
      } while ((this.jdField_a_of_type_Int >= 3) || (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null));
      int i = a(paramInt, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      e();
      j = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(i, paramBoolean1, System.currentTimeMillis() * 1000000L);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.notifyDetectFaceAttr();
      if (paramFaceData != null) {
        paramFaceData.a(a(), paramBoolean2);
      }
      if (j != i) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("AEFilterAVWrapperImpl", 4, "drawFrameInGL, AEFilterManager do nothing.");
    return paramInt;
    return j;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(null);
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(null);
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
    QLog.w("AEFilterAVWrapperImpl", 1, "clearState, seq[" + paramLong + "]");
    TipsInfo.a().a(paramLong);
  }
  
  public void a(PendantItem paramPendantItem, VideoMaterial paramVideoMaterial)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!RenderUtils.a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramPendantItem)) || (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != paramVideoMaterial))
    {
      if ((paramPendantItem == null) || (!paramPendantItem.hasGesture())) {
        break label276;
      }
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterAVWrapperImpl", 2, "setPendant, pendantItem[" + paramPendantItem + "], isPendantHasGesture[" + bool1 + "]");
      }
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (!this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited())) {
        break label305;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = paramPendantItem;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
      if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      }
      if (!bool1) {
        break label291;
      }
      if (PtuResChecker.a().a(AEResInfo.d.jdField_a_of_type_Int)) {
        break label281;
      }
      bool1 = PtuResChecker.a().a(null, AEResInfo.d.jdField_a_of_type_Int);
      label160:
      if (bool1) {
        break label286;
      }
      bool1 = bool2;
      label167:
      this.jdField_e_of_type_Boolean = bool1;
      TipsInfo.a().a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getGestureType());
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterAVWrapperImpl", 2, "setPendant, need gesture bundle. isNeedLoad[" + this.jdField_e_of_type_Boolean + "]");
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (PendantItem.isBeautyMakeup(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getCategory())) && ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam instanceof Integer))) {
        this.jdField_d_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam).intValue();
      }
      return;
      label276:
      bool1 = false;
      break;
      label281:
      bool1 = true;
      break label160;
      label286:
      bool1 = false;
      break label167;
      label291:
      this.jdField_e_of_type_Boolean = false;
      TipsInfo.a().b();
      continue;
      label305:
      QLog.i("AEFilterAVWrapperImpl", 1, "initAEDetector failed!");
    }
  }
  
  public void a(FaceData paramFaceData)
  {
    if (a()) {}
    boolean bool;
    do
    {
      return;
      bool = false;
      PendantItem localPendantItem = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
      if (localPendantItem != null) {
        bool = localPendantItem.hasFace();
      }
      if ((paramFaceData != null) && (paramFaceData.jdField_a_of_type_Int > 0))
      {
        TipsInfo.a().d();
        return;
      }
    } while ((!this.jdField_a_of_type_Boolean) && (!bool));
    TipsInfo.a().c();
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    String str;
    StringBuilder localStringBuilder;
    if (!RenderUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramFilterDesc))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      str = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) || ((!TextUtils.isEmpty(str)) && (!FileUtils.a(str)))) {
        break label112;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(str);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("setFilterDesc, name[");
        if (paramFilterDesc != null) {
          break label146;
        }
      }
    }
    label146:
    for (paramFilterDesc = "null";; paramFilterDesc = paramFilterDesc.name)
    {
      QLog.i("AEFilterAVWrapperImpl", 2, paramFilterDesc + "], path[" + str + "]");
      return;
      label112:
      QLog.i("AEFilterAVWrapperImpl", 1, "setFilterDesc, fail path[" + str + "]");
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_Boolean != paramBoolean)) {
      QLog.i("AEFilterAVWrapperImpl", 4, "setNeedFaceData, needDetectFace[" + paramBoolean + "]");
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setForceFaceDetect(this.jdField_a_of_type_Boolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.hasGesture());
  }
  
  public boolean a(BeautyConfig paramBeautyConfig)
  {
    if (paramBeautyConfig == null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.c();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.b();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(paramBeautyConfig);
    }
  }
  
  public void b()
  {
    g();
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightNodeTipsListener(null);
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
    if ((paramInt1 == 0) || (paramInt2 == 0) || ((this.jdField_b_of_type_Int == paramInt1) && (this.jdField_c_of_type_Int == paramInt2))) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("AEFilterAVWrapperImpl", 2, "updateWidthHeight, width[" + paramInt1 + "], height[" + paramInt2 + "]");
      }
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt2;
    } while (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateWidthHeight(paramInt1, paramInt2);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c() {}
  
  public void c(int paramInt1, int paramInt2) {}
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterAVWrapperImpl
 * JD-Core Version:    0.7.0.1
 */