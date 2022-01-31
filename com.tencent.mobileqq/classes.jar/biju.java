import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;

@TargetApi(17)
public class biju
{
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bioi jdField_a_of_type_Bioi;
  private bjbq jdField_a_of_type_Bjbq = new bijw(this);
  private final AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  public AEMaterialPanel a;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public biju(View paramView, bigf parambigf)
  {
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363833));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372075));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131362172);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366418));
    a(parambigf);
  }
  
  private void a(bigf parambigf)
  {
    ((biiw)biix.a(parambigf).a(biiw.class)).a.a(parambigf, new bijv(this));
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
  
  public void a(biqn parambiqn)
  {
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterialMetaData(parambiqn);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.b == null) || (this.d == null)) {
      return;
    }
    float f2 = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() + this.d.getHeight();
    if ((this.c == null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363827);
    }
    float f1 = f2;
    if (this.c != null)
    {
      f1 = f2;
      if (this.c.getVisibility() == 0) {
        f1 = f2 + (this.c.getHeight() + blbz.a(8.0F));
      }
    }
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      xff.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { 0.0F, f1 }).a(paramInt).b();
      if ((this.e != null) && (this.e.getVisibility() == 0))
      {
        localObject = new int[2];
        this.e.getLocationOnScreen((int[])localObject);
        i = this.jdField_a_of_type_AndroidViewView.getHeight();
        j = localObject[1];
        k = vzo.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
        xff.a(new View[] { this.e }).a(new float[] { 0.0F, i - j + k }).a(paramInt).b();
      }
    }
    for (Object localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
    {
      ((ScaleAnimation)localObject).setDuration(paramInt);
      ((ScaleAnimation)localObject).setFillAfter(true);
      this.b.startAnimation((Animation)localObject);
      return;
      xff.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { f1, 0.0F }).a(paramInt).b();
      if ((this.e != null) && (this.e.getVisibility() == 0))
      {
        localObject = new int[2];
        this.e.getLocationOnScreen((int[])localObject);
        i = this.jdField_a_of_type_AndroidViewView.getHeight();
        j = localObject[1];
        k = vzo.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
        xff.a(new View[] { this.e }).a(new float[] { i - j + k, 0.0F }).a(paramInt).b();
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
    a(biqk.a());
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131366688));
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131364822);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363827);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131375357);
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) || (this.jdField_a_of_type_Bioi != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
        bool2 = false | this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_Bioi != null) {
        bool1 = bool2 | this.jdField_a_of_type_Bioi.b();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    bkqo.a().a(0);
    ((bjbk)bjae.a(5)).a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.b();
    }
    if (this.jdField_a_of_type_Bioi != null) {
      this.jdField_a_of_type_Bioi.c();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(true);
    }
    if (this.jdField_a_of_type_Bioi != null) {
      this.jdField_a_of_type_Bioi.d();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131369513);
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
    if (this.jdField_a_of_type_Bioi != null) {
      this.jdField_a_of_type_Bioi.e();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bioi != null) {
      this.jdField_a_of_type_Bioi.f();
    }
    bkqo.a().a(0);
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
  }
  
  public void j()
  {
    f();
    if (this.jdField_a_of_type_Bioi != null) {
      this.jdField_a_of_type_Bioi.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biju
 * JD-Core Version:    0.7.0.1
 */