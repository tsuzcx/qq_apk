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
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboObeserver;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import mqq.os.MqqHandler;

@TargetApi(17)
public class AECaptureController
  implements ICaptureController
{
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AEBaseCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEBaseCameraUnit;
  private final AECameraGLSurfaceView jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView;
  private AEARCakePanel jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel;
  public AEMaterialPanel a;
  private AEWaterMarkPanel jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel;
  private BeautyAndFilterPanelViewStubHolder jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
  private VideoFilterViewPager jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager;
  private CaptureComboObeserver jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboObeserver = new AECaptureController.3(this);
  public volatile boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public AECaptureController(View paramView, AEBaseCameraUnit paramAEBaseCameraUnit)
  {
    this.jdField_a_of_type_Boolean = true;
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_ComTencentAelightCameraAeAEBaseCameraUnit = paramAEBaseCameraUnit;
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122016));
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2064122519));
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel = ((AEWaterMarkPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2064122520));
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel = ((AEARCakePanel)this.jdField_a_of_type_AndroidViewView.findViewById(2064122518));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2064121904);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2064121905);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2064122221));
      j();
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
      String str = AEBaseReportParam.a().a();
      if ((str != null) && (str.equalsIgnoreCase(paramAEMaterialMetaData.k))) {
        bool = false;
      } else {
        bool = true;
      }
      AEBaseReportParam.a().e(paramAEMaterialMetaData.k);
      AEBaseReportParam.a().b(paramAEMaterialMetaData.g);
      if (paramAEMaterialMetaData.g != 0) {
        a(true);
      } else {
        a(false);
      }
    }
    else
    {
      bool = "none".equalsIgnoreCase(AEBaseReportParam.a().a()) ^ true;
      AEBaseReportParam.a().e("none");
      AEBaseReportParam.a().b(0);
      a(false);
    }
    if (bool) {
      AEBaseDataReporter.a().W();
    }
  }
  
  private void j()
  {
    ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEBaseCameraUnit).get(AEPituCameraUnit.ViewStubHoldersViewModel.class)).a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEBaseCameraUnit, new AECaptureController.2(this));
  }
  
  public void a()
  {
    AEQLog.b("CaptureController", "applyVideoMaterialAgain");
    if (((AEPituCameraUnit)this.jdField_a_of_type_ComTencentAelightCameraAeAEBaseCameraUnit).m())
    {
      localObject = AEARCakeMaterialManager.a().a();
      AEQLog.b("CaptureController", "applyVideoMaterialAgain from arcake : ");
      if (localObject == null)
      {
        a(null);
        AEQLog.b("CaptureController", "applyVideoMaterialAgain giftMaterial is null ");
        return;
      }
      a(((AEGiftMaterial)localObject).a());
      return;
    }
    if (AEMaterialManager.b() != null)
    {
      a(AEMaterialManager.b());
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAEBaseCameraUnit;
    if (((localObject instanceof AEPituCameraUnit)) && (((AEPituCameraUnit)localObject).f()))
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView;
      if (localObject != null) {
        ((AECameraGLSurfaceView)localObject).setMaterial(AEGifMaterialManager.a().a());
      }
    }
    a(AEMaterialManager.a());
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getSmoothLevel() == paramInt) {
      return;
    }
    if (GLVideoClipUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
      }
      paramInt = 0;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setBeautyLevel(paramInt);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("material id : ");
    Object localObject;
    if (paramAEMaterialMetaData == null) {
      localObject = "null";
    } else {
      localObject = paramAEMaterialMetaData.k;
    }
    localStringBuilder.append((String)localObject);
    AEQLog.b("CaptureController", localStringBuilder.toString());
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAEBaseCameraUnit.a();
      if ((!b()) && (paramAEMaterialMetaData != null))
      {
        localObject = ((Activity)localObject).getIntent();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("camera^");
        localStringBuilder.append(paramAEMaterialMetaData.k);
        ((Intent)localObject).putExtra("widgetinfo", localStringBuilder.toString());
        ((Intent)localObject).putExtra("material_id", paramAEMaterialMetaData.k);
        ((Intent)localObject).putExtra("material_topic", paramAEMaterialMetaData.v);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("selectSpecificMaterial---塞拍同款名 takeSameName=");
        localStringBuilder.append(paramAEMaterialMetaData.s);
        AEQLog.b("CaptureController", localStringBuilder.toString());
        ((Intent)localObject).putExtra("key_camera_material_name", paramAEMaterialMetaData.s);
        ((Intent)localObject).putExtra("ae_editor_is_show_take_same", paramAEMaterialMetaData.g);
      }
      else if (!b())
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
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setMaterialMetaData(paramAEMaterialMetaData);
    }
    b(paramAEMaterialMetaData);
  }
  
  public void a(@Nullable String paramString)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setCustomMaterial(paramString);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (this.jdField_b_of_type_AndroidViewView == null) {
        return;
      }
      if ((this.d == null) && (!((AEPituCameraUnit)this.jdField_a_of_type_ComTencentAelightCameraAeAEBaseCameraUnit).m())) {
        return;
      }
      int j = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
      Object localObject = this.d;
      int i;
      if (localObject != null) {
        i = ((View)localObject).getHeight();
      } else {
        i = 0;
      }
      float f2 = j + i;
      localObject = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      float f1 = f2;
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        f1 = f2 + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
      }
      long l;
      int k;
      if (paramBoolean)
      {
        localObject = ViewAnimator.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { 0.0F, f1 });
        l = paramInt;
        ((AnimationBuilder)localObject).a(l).b();
        localObject = this.e;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          localObject = this.f;
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            localObject = new int[2];
            this.e.getLocationOnScreen((int[])localObject);
            i = this.jdField_a_of_type_AndroidViewView.getHeight();
            j = localObject[1];
            k = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
            ViewAnimator.a(new View[] { this.e, this.f }).a(new float[] { 0.0F, i - j + k }).a(l).b();
          }
        }
        localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);
      }
      else
      {
        localObject = ViewAnimator.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { f1, 0.0F });
        l = paramInt;
        ((AnimationBuilder)localObject).a(l).b();
        localObject = this.e;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          localObject = this.f;
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            localObject = new int[2];
            this.e.getLocationOnScreen((int[])localObject);
            i = this.jdField_a_of_type_AndroidViewView.getHeight();
            j = localObject[1];
            k = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
            ViewAnimator.a(new View[] { this.e, this.f }).a(new float[] { i - j + k, 0.0F }).a(l).b();
          }
        }
        localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F);
      }
      ((ScaleAnimation)localObject).setDuration(paramInt);
      ((ScaleAnimation)localObject).setFillAfter(true);
      this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    }
  }
  
  public boolean a()
  {
    if (b()) {
      return true;
    }
    if (c())
    {
      e();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2064122228));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2064122074);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2064122567);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setSharpFaceLevel(paramInt);
  }
  
  public boolean b()
  {
    AECameraGLSurfaceView localAECameraGLSurfaceView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView;
    return (localAECameraGLSurfaceView != null) && (localAECameraGLSurfaceView.isRecording());
  }
  
  public void c()
  {
    VideoFilterTools.a().a(0);
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    if (this.jdField_b_of_type_Boolean) {
      localCaptureComboManager.a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
    }
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
    boolean bool2 = false;
    if (localObject != null) {
      bool2 = false | ((AEMaterialPanel)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
    boolean bool1 = bool2;
    if (localObject != null) {
      bool1 = bool2 | ((BeautyAndFilterPanelViewStubHolder)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel;
    bool2 = bool1;
    if (localObject != null) {
      bool2 = bool1 | ((AEARCakePanel)localObject).b();
    }
    return bool2;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
    if (localObject != null) {
      ((AEMaterialPanel)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel;
    if (localObject != null) {
      ((AEARCakePanel)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel;
    if (localObject != null) {
      ((AEWaterMarkPanel)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
    if (localObject != null) {
      ((BeautyAndFilterPanelViewStubHolder)localObject).c();
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel;
    if (localObject != null) {
      ((AEARCakePanel)localObject).a(true);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
    if (localObject != null) {
      ((AEMaterialPanel)localObject).a(true);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
    if (localObject != null) {
      ((BeautyAndFilterPanelViewStubHolder)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel;
    if (localObject != null) {
      ((AEWaterMarkPanel)localObject).a(true);
    }
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(0);
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2064122374);
    if ((localObject != null) && ((localObject instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout)localObject;
      if ((localObject != null) && (((RelativeLayout)localObject).isShown()))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager;
        if (localObject != null) {
          ((VideoFilterViewPager)localObject).d();
        }
      }
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
    if (localObject != null) {
      ((AEMaterialPanel)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
    if (localObject != null) {
      ((BeautyAndFilterPanelViewStubHolder)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel;
    if (localObject != null) {
      ((AEWaterMarkPanel)localObject).c();
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
  }
  
  public void h()
  {
    BeautyAndFilterPanelViewStubHolder localBeautyAndFilterPanelViewStubHolder = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
    if (localBeautyAndFilterPanelViewStubHolder != null) {
      localBeautyAndFilterPanelViewStubHolder.f();
    }
    VideoFilterTools.a().a(0);
    NativeGifImage.resumeAll();
    if (URLDrawable.depImp.mLog != null) {
      ApngImage.playByTag(13);
    }
  }
  
  public void i()
  {
    e();
    BeautyAndFilterPanelViewStubHolder localBeautyAndFilterPanelViewStubHolder = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
    if (localBeautyAndFilterPanelViewStubHolder != null) {
      localBeautyAndFilterPanelViewStubHolder.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.AECaptureController
 * JD-Core Version:    0.7.0.1
 */