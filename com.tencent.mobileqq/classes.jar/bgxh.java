import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.AECamera.View.AECameraGLSurfaceView;
import dov.com.qq.im.AECamera.panel.material.AEMaterialPanel;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;

@TargetApi(17)
public class bgxh
{
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bhgy jdField_a_of_type_Bhgy = new bgxj(this);
  public AppInterface a;
  private final AECameraGLSurfaceView jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView;
  public AEMaterialPanel a;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private wvz jdField_a_of_type_Wvz;
  private View b;
  private View c;
  private View d;
  
  public bgxh(AppInterface paramAppInterface, View paramView, bhdp parambhdp)
  {
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298277));
    this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131306378));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131301077));
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131299259);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131309608);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131296631);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131300808));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(parambhdp);
  }
  
  private void a(bhdp parambhdp)
  {
    ((bhdg)bhur.a(parambhdp).a(bhdg.class)).a.a(parambhdp, new bgxi(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.i();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.a() == paramInt) {
      return;
    }
    if (GLVideoClipUtil.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
      }
      paramInt = 0;
    }
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setBeautyLevel(paramInt);
  }
  
  public void a(bgya parambgya)
  {
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    if (this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setMaterialMetaData(parambgya);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    float f = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() + this.c.getHeight();
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      wqa.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.c }).a(new float[] { 0.0F, f }).a(paramInt).b();
      if ((this.d != null) && (this.d.getVisibility() == 0))
      {
        localObject = new int[2];
        this.d.getLocationOnScreen((int[])localObject);
        i = this.jdField_a_of_type_AndroidViewView.getHeight();
        j = localObject[1];
        k = vms.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
        wqa.a(new View[] { this.d }).a(new float[] { 0.0F, i - j + k }).a(paramInt).b();
      }
    }
    for (Object localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
    {
      ((ScaleAnimation)localObject).setDuration(paramInt);
      ((ScaleAnimation)localObject).setFillAfter(true);
      this.b.startAnimation((Animation)localObject);
      return;
      wqa.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.c }).a(new float[] { f, 0.0F }).a(paramInt).b();
      if ((this.d != null) && (this.d.getVisibility() == 0))
      {
        localObject = new int[2];
        this.d.getLocationOnScreen((int[])localObject);
        i = this.jdField_a_of_type_AndroidViewView.getHeight();
        j = localObject[1];
        k = vms.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
        wqa.a(new View[] { this.d }).a(new float[] { i - j + k, 0.0F }).a(paramInt).b();
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
      e();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (bgxx.a() == null) {
      return;
    }
    a(bgxx.a());
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setSharpFaceLevel(paramInt);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView != null) && (this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.b());
  }
  
  public void c()
  {
    bjac.a().a(0);
    ((bhgs)bhfm.a(5)).a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel != null) || (this.jdField_a_of_type_Wvz != null))
    {
      if (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel != null) {
        bool2 = false | this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.a();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_Wvz != null) {
        bool1 = bool2 | this.jdField_a_of_type_Wvz.b();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.b();
    }
    if (this.jdField_a_of_type_Wvz != null) {
      this.jdField_a_of_type_Wvz.c();
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bhgy);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.a(true);
    }
    if (this.jdField_a_of_type_Wvz != null) {
      this.jdField_a_of_type_Wvz.d();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131303838);
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
  
  public void g()
  {
    if (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.c();
    }
    if (this.jdField_a_of_type_Wvz != null) {
      this.jdField_a_of_type_Wvz.e();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Wvz != null) {
      this.jdField_a_of_type_Wvz.f();
    }
    bjac.a().a(0);
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
  }
  
  public void i()
  {
    e();
    if (this.jdField_a_of_type_Wvz != null) {
      this.jdField_a_of_type_Wvz.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgxh
 * JD-Core Version:    0.7.0.1
 */