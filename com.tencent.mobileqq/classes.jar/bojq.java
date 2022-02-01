import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.AECaptureController.1;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import mqq.os.MqqHandler;

@TargetApi(17)
public class bojq
{
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private boom jdField_a_of_type_Boom;
  private bpnc jdField_a_of_type_Bpnc = new bojs(this);
  private final AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  public AEMaterialPanel a;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  public volatile boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public bojq(View paramView, bocu parambocu)
  {
    this.jdField_a_of_type_Boolean = true;
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364134));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373117));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131362269);
    this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131362270);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366846));
    a(parambocu);
  }
  
  private void a(bocu parambocu)
  {
    ((bofy)bofz.a(parambocu).get(bofy.class)).a.observe(parambocu, new bojr(this));
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AECaptureController.1(this, paramBoolean));
  }
  
  private void b(boqu paramboqu)
  {
    int i = 1;
    if (paramboqu != null)
    {
      String str = bozv.a().a();
      if ((str == null) || (!str.equalsIgnoreCase(paramboqu.a))) {
        break label120;
      }
    }
    label120:
    for (i = 0;; i = 1)
    {
      bozv.a().c(paramboqu.a);
      bozv.a().b(paramboqu.f);
      if (paramboqu.f != 0) {
        a(true);
      }
      for (;;)
      {
        if (i != 0) {
          bozr.a().P();
        }
        return;
        a(false);
        continue;
        if ("none".equalsIgnoreCase(bozv.a().a())) {
          i = 0;
        }
        bozv.a().c("none");
        bozv.a().b(0);
        a(false);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.j();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a() == paramInt) {
      return;
    }
    if (GLVideoClipUtil.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
      }
      paramInt = 0;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBeautyLevel(paramInt);
  }
  
  public void a(boqu paramboqu)
  {
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterialMetaData(paramboqu);
    }
    b(paramboqu);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_b_of_type_AndroidViewView == null) || (this.d == null)) {
      return;
    }
    float f1 = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() + this.d.getHeight();
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
      f1 = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + f1;
    }
    for (;;)
    {
      int i;
      int j;
      int k;
      if (paramBoolean)
      {
        aazq.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { 0.0F, f1 }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0) && (this.f != null) && (this.f.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          aazq.a(new View[] { this.e, this.f }).a(new float[] { 0.0F, i - j + k }).a(paramInt).b();
        }
      }
      for (localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
      {
        ((ScaleAnimation)localObject).setDuration(paramInt);
        ((ScaleAnimation)localObject).setFillAfter(true);
        this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
        return;
        aazq.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { f1, 0.0F }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0) && (this.f != null) && (this.f.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          aazq.a(new View[] { this.e, this.f }).a(new float[] { i - j + k, 0.0F }).a(paramInt).b();
        }
      }
    }
  }
  
  public boolean a()
  {
    if (b()) {
      return true;
    }
    if (c())
    {
      f();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    a(boqr.a());
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setSharpFaceLevel(paramInt);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) && (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b());
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131367136));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365187);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131376769);
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) || (this.jdField_a_of_type_Boom != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
        bool2 = false | this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_Boom != null) {
        bool1 = bool2 | this.jdField_a_of_type_Boom.b();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    bqzz.a().a(0);
    bpmw localbpmw = (bpmw)bplq.a(5);
    if (this.jdField_b_of_type_Boolean) {
      localbpmw.a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.b();
    }
    if (this.jdField_a_of_type_Boom != null) {
      this.jdField_a_of_type_Boom.c();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(true);
    }
    if (this.jdField_a_of_type_Boom != null) {
      this.jdField_a_of_type_Boom.d();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131370331);
    if ((localObject != null) && ((localObject instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout)localObject;
      if ((localObject != null) && (((RelativeLayout)localObject).isShown()))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.c();
        }
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.c();
    }
    if (this.jdField_a_of_type_Boom != null) {
      this.jdField_a_of_type_Boom.e();
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boom != null) {
      this.jdField_a_of_type_Boom.f();
    }
    bqzz.a().a(0);
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
  }
  
  public void j()
  {
    f();
    if (this.jdField_a_of_type_Boom != null) {
      this.jdField_a_of_type_Boom.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojq
 * JD-Core Version:    0.7.0.1
 */