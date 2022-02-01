package com.tencent.aelight.camera.ae.camera.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEBaseCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit.ViewStubHoldersViewModel;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterDataManager;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterDataManager.SelectFilter;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanel;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboObeserver;
import com.tencent.aelight.camera.api.IAEFilterManagerHolder;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import mqq.os.MqqHandler;

@TargetApi(17)
public class AECaptureController
  implements ICaptureController
{
  public View a;
  public AEMaterialPanel b;
  public volatile boolean c = true;
  private final AECameraGLSurfaceView d;
  private AEWaterMarkPanel e;
  private AEARCakePanel f;
  private BeautyAndFilterPanel g;
  private View h;
  private ViewGroup i;
  private View j;
  private View k;
  private View l;
  private View m;
  private VideoFilterViewPager n;
  private boolean o = true;
  private AEBaseCameraUnit p;
  private CaptureComboObeserver q = new AECaptureController.3(this);
  
  public AECaptureController(View paramView, AEBaseCameraUnit paramAEBaseCameraUnit)
  {
    if (paramView != null)
    {
      this.a = paramView;
      this.p = paramAEBaseCameraUnit;
      this.d = ((AECameraGLSurfaceView)this.a.findViewById(2063990947));
      this.b = ((AEMaterialPanel)this.a.findViewById(2063991338));
      this.e = ((AEWaterMarkPanel)this.a.findViewById(2063991339));
      this.f = ((AEARCakePanel)this.a.findViewById(2063991337));
      this.l = this.a.findViewById(2063990838);
      this.m = this.a.findViewById(2063990839);
      this.n = ((VideoFilterViewPager)this.a.findViewById(2063991103));
      m();
      return;
    }
    throw new IllegalStateException("rootView is null");
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AECaptureController.1(this, paramBoolean));
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    boolean bool;
    if (paramAEMaterialMetaData != null)
    {
      String str = AEBaseReportParam.a().f();
      if ((str != null) && (str.equalsIgnoreCase(paramAEMaterialMetaData.m))) {
        bool = false;
      } else {
        bool = true;
      }
      AEBaseReportParam.a().f(paramAEMaterialMetaData.m);
      AEBaseReportParam.a().c(paramAEMaterialMetaData.M);
      if (paramAEMaterialMetaData.M != 0) {
        a(true);
      } else {
        a(false);
      }
    }
    else
    {
      bool = "none".equalsIgnoreCase(AEBaseReportParam.a().f()) ^ true;
      AEBaseReportParam.a().f("none");
      AEBaseReportParam.a().c(0);
      a(false);
    }
    if (bool) {
      AEBaseDataReporter.a().X();
    }
  }
  
  private void m()
  {
    ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this.p).get(AEPituCameraUnit.ViewStubHoldersViewModel.class)).a.observe(this.p, new AECaptureController.2(this));
  }
  
  public void a()
  {
    AEQLog.b("CaptureController", "applyVideoMaterialAgain");
    if (((AEPituCameraUnit)this.p).aA())
    {
      localObject = AEARCakeMaterialManager.a().c();
      AEQLog.b("CaptureController", "applyVideoMaterialAgain from arcake : ");
      if (localObject == null)
      {
        a(null);
        AEQLog.b("CaptureController", "applyVideoMaterialAgain giftMaterial is null ");
        return;
      }
      a(((AEGiftMaterial)localObject).c());
      return;
    }
    if (AEMaterialManager.o() != null)
    {
      a(AEMaterialManager.o());
      return;
    }
    Object localObject = this.p;
    if ((localObject instanceof AEFlashShowCameraUnit))
    {
      a(AEFlashShowMaterialManager.k());
      return;
    }
    if (((localObject instanceof AEPituCameraUnit)) && (((AEPituCameraUnit)localObject).Z()))
    {
      localObject = this.d;
      if (localObject != null) {
        ((AECameraGLSurfaceView)localObject).setMaterial(AEGifMaterialManager.a().c());
      }
    }
    a(AEMaterialManager.n());
  }
  
  public void a(int paramInt)
  {
    if (this.d.getSmoothLevel() == paramInt) {
      return;
    }
    if (GLVideoClipUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
      }
      paramInt = 0;
    }
    this.d.setBeautyLevel(paramInt);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("material id : ");
    Object localObject;
    if (paramAEMaterialMetaData == null) {
      localObject = "null";
    } else {
      localObject = paramAEMaterialMetaData.m;
    }
    localStringBuilder.append((String)localObject);
    AEQLog.b("CaptureController", localStringBuilder.toString());
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    if (this.d != null)
    {
      localObject = this.p.s();
      if ((!k()) && (paramAEMaterialMetaData != null))
      {
        localObject = ((Activity)localObject).getIntent();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("camera^");
        localStringBuilder.append(paramAEMaterialMetaData.m);
        ((Intent)localObject).putExtra("widgetinfo", localStringBuilder.toString());
        ((Intent)localObject).putExtra("material_id", paramAEMaterialMetaData.m);
        ((Intent)localObject).putExtra("material_topic", paramAEMaterialMetaData.N);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("selectSpecificMaterial---塞拍同款名 takeSameName=");
        localStringBuilder.append(paramAEMaterialMetaData.H);
        AEQLog.b("CaptureController", localStringBuilder.toString());
        ((Intent)localObject).putExtra("key_camera_material_name", paramAEMaterialMetaData.H);
        ((Intent)localObject).putExtra("ae_editor_is_show_take_same", paramAEMaterialMetaData.M);
      }
      else if (!k())
      {
        localObject = ((Activity)localObject).getIntent();
        if (localObject != null)
        {
          ((Intent)localObject).removeExtra("widgetinfo");
          ((Intent)localObject).removeExtra("material_id");
          ((Intent)localObject).removeExtra("material_topic");
          ((Intent)localObject).removeExtra("key_camera_material_name");
          ((Intent)localObject).removeExtra("ae_editor_is_show_take_same");
          ((Intent)localObject).removeExtra("KEY_SEND_ARK_MSG_ID");
        }
      }
      this.d.setMaterialMetaData(paramAEMaterialMetaData);
    }
    b(paramAEMaterialMetaData);
  }
  
  public void a(@Nullable String paramString)
  {
    this.d.setCustomMaterial(paramString);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.i != null)
    {
      if (this.h == null) {
        return;
      }
      if ((this.k == null) && (!((AEPituCameraUnit)this.p).aA())) {
        return;
      }
      int i2 = this.i.getHeight();
      Object localObject = this.k;
      int i1;
      if (localObject != null) {
        i1 = ((View)localObject).getHeight();
      } else {
        i1 = 0;
      }
      float f2 = i2 + i1;
      localObject = this.i.getLayoutParams();
      float f1 = f2;
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        f1 = f2 + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
      }
      long l1;
      int i3;
      if (paramBoolean)
      {
        localObject = ViewAnimator.a(new View[] { this.i, this.k }).b(new float[] { 0.0F, f1 });
        l1 = paramInt;
        ((AnimationBuilder)localObject).a(l1).d();
        localObject = this.l;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          localObject = this.m;
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            localObject = new int[2];
            this.l.getLocationOnScreen((int[])localObject);
            i1 = this.a.getHeight();
            i2 = localObject[1];
            i3 = UIUtils.a(this.a.getContext(), 100.0F);
            ViewAnimator.a(new View[] { this.l, this.m }).b(new float[] { 0.0F, i1 - i2 + i3 }).a(l1).d();
          }
        }
        localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);
      }
      else
      {
        localObject = ViewAnimator.a(new View[] { this.i, this.k }).b(new float[] { f1, 0.0F });
        l1 = paramInt;
        ((AnimationBuilder)localObject).a(l1).d();
        localObject = this.l;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          localObject = this.m;
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            localObject = new int[2];
            this.l.getLocationOnScreen((int[])localObject);
            i1 = this.a.getHeight();
            i2 = localObject[1];
            i3 = UIUtils.a(this.a.getContext(), 100.0F);
            ViewAnimator.a(new View[] { this.l, this.m }).b(new float[] { i1 - i2 + i3, 0.0F }).a(l1).d();
          }
        }
        localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F);
      }
      ((ScaleAnimation)localObject).setDuration(paramInt);
      ((ScaleAnimation)localObject).setFillAfter(true);
      this.h.startAnimation((Animation)localObject);
    }
  }
  
  public void b()
  {
    this.i = ((ViewGroup)this.a.findViewById(2063991110));
    this.h = this.a.findViewById(2063990988);
    this.k = this.a.findViewById(2063991385);
  }
  
  public void b(int paramInt)
  {
    this.d.setSharpFaceLevel(paramInt);
  }
  
  public void c()
  {
    VideoFilterTools.a().d(0);
    Object localObject = (CaptureComboManager)QIMManager.a(5);
    if (this.o) {
      localObject.o[0].a((Activity)this.a.getContext());
    }
    localObject = ((AEFlashShowFilterDataManager)AEQIMManager.a(4)).a();
    if ((localObject != null) && (!"".equals(((AEFlashShowFilterDataManager.SelectFilter)localObject).a())) && (!((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).isAEFilterManagerEmpty()))
    {
      ((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).setIsAfterUpdateMaterial(false);
      ((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).updateLutGL(((AEFlashShowFilterDataManager.SelectFilter)localObject).b());
    }
  }
  
  public void d()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((AEMaterialPanel)localObject).b();
    }
    localObject = this.f;
    if (localObject != null) {
      ((AEARCakePanel)localObject).d();
    }
    localObject = this.e;
    if (localObject != null) {
      ((AEWaterMarkPanel)localObject).c();
    }
    localObject = this.g;
    if (localObject != null) {
      ((BeautyAndFilterPanel)localObject).h();
    }
  }
  
  public void e()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((AEARCakePanel)localObject).a(true);
    }
    localObject = this.b;
    if (localObject != null) {
      ((AEMaterialPanel)localObject).a(true);
    }
    localObject = this.g;
    if (localObject != null) {
      ((BeautyAndFilterPanel)localObject).b();
    }
    localObject = this.e;
    if (localObject != null) {
      ((AEWaterMarkPanel)localObject).a(true);
    }
    localObject = this.i;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(0);
    }
  }
  
  public void f()
  {
    Object localObject = this.a.findViewById(2063991248);
    if ((localObject != null) && ((localObject instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout)localObject;
      if ((localObject != null) && (((RelativeLayout)localObject).isShown()))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        localObject = this.n;
        if (localObject != null) {
          ((VideoFilterViewPager)localObject).e();
        }
      }
    }
  }
  
  public void g()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((AEMaterialPanel)localObject).d();
    }
    localObject = this.g;
    if (localObject != null) {
      ((BeautyAndFilterPanel)localObject).f();
    }
    localObject = this.e;
    if (localObject != null) {
      ((AEWaterMarkPanel)localObject).d();
    }
    this.o = this.c;
  }
  
  public void h()
  {
    BeautyAndFilterPanel localBeautyAndFilterPanel = this.g;
    if (localBeautyAndFilterPanel != null) {
      localBeautyAndFilterPanel.e();
    }
    VideoFilterTools.a().d(0);
    NativeGifImage.resumeAll();
    if (URLDrawable.depImp.mLog != null) {
      ApngImage.playByTag(13);
    }
  }
  
  public void i()
  {
    e();
    Object localObject = (CaptureComboManager)QIMManager.a(5);
    if ((this.a != null) && (localObject != null))
    {
      VideoFilterTools.a().b(null, (Activity)this.a.getContext(), 0);
      ((CaptureComboManager)localObject).a((Activity)this.a.getContext());
      VideoFilterTools.a().a(null, 0);
    }
    localObject = this.g;
    if (localObject != null) {
      ((BeautyAndFilterPanel)localObject).g();
    }
  }
  
  public boolean j()
  {
    if (k()) {
      return true;
    }
    if (l())
    {
      e();
      return true;
    }
    return false;
  }
  
  public boolean k()
  {
    AECameraGLSurfaceView localAECameraGLSurfaceView = this.d;
    return (localAECameraGLSurfaceView != null) && (localAECameraGLSurfaceView.isRecording());
  }
  
  public boolean l()
  {
    Object localObject = this.b;
    boolean bool2 = false;
    if (localObject != null) {
      bool2 = false | ((AEMaterialPanel)localObject).c();
    }
    localObject = this.g;
    boolean bool1 = bool2;
    if (localObject != null) {
      bool1 = bool2 | ((BeautyAndFilterPanel)localObject).ao_();
    }
    localObject = this.f;
    bool2 = bool1;
    if (localObject != null) {
      bool2 = bool1 | ((AEARCakePanel)localObject).a();
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.AECaptureController
 * JD-Core Version:    0.7.0.1
 */