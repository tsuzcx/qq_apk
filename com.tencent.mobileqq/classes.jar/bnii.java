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
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;

@TargetApi(17)
public class bnii
{
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bnnb jdField_a_of_type_Bnnb;
  private bolh jdField_a_of_type_Bolh = new bnik(this);
  private final AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  public AEMaterialPanel a;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  public volatile boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View d;
  private View e;
  
  public bnii(View paramView, bnbm parambnbm)
  {
    this.jdField_a_of_type_Boolean = true;
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364093));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373004));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131362258);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366795));
    a(parambnbm);
  }
  
  private void a(bnbm parambnbm)
  {
    ((bneq)bner.a(parambnbm).get(bneq.class)).a.observe(parambnbm, new bnij(this));
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
  
  public void a(bnpf parambnpf)
  {
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterialMetaData(parambnpf);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_b_of_type_AndroidViewView == null) || (this.d == null)) {
      return;
    }
    float f1 = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() + this.d.getHeight();
    if ((this.c == null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131364087);
    }
    if ((this.c != null) && (this.c.getVisibility() == 0)) {
      f1 += this.c.getHeight() + bqja.a(8.0F);
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      float f2 = f1;
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        f2 = f1 + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
      }
      int i;
      int j;
      int k;
      if (paramBoolean)
      {
        aavn.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { 0.0F, f2 }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = zlx.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          aavn.a(new View[] { this.e }).a(new float[] { 0.0F, i - j + k }).a(paramInt).b();
        }
      }
      for (localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
      {
        ((ScaleAnimation)localObject).setDuration(paramInt);
        ((ScaleAnimation)localObject).setFillAfter(true);
        this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
        return;
        aavn.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { f2, 0.0F }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = zlx.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          aavn.a(new View[] { this.e }).a(new float[] { i - j + k, 0.0F }).a(paramInt).b();
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
    a(bnpc.a());
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131367085));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365143);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131364087);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131376636);
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) || (this.jdField_a_of_type_Bnnb != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
        bool2 = false | this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_Bnnb != null) {
        bool1 = bool2 | this.jdField_a_of_type_Bnnb.b();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    bpye.a().a(0);
    bolb localbolb = (bolb)bojv.a(5);
    if (this.jdField_b_of_type_Boolean) {
      localbolb.a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.b();
    }
    if (this.jdField_a_of_type_Bnnb != null) {
      this.jdField_a_of_type_Bnnb.c();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(true);
    }
    if (this.jdField_a_of_type_Bnnb != null) {
      this.jdField_a_of_type_Bnnb.d();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131370230);
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
    if (this.jdField_a_of_type_Bnnb != null) {
      this.jdField_a_of_type_Bnnb.e();
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bnnb != null) {
      this.jdField_a_of_type_Bnnb.f();
    }
    bpye.a().a(0);
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
  }
  
  public void j()
  {
    f();
    if (this.jdField_a_of_type_Bnnb != null) {
      this.jdField_a_of_type_Bnnb.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnii
 * JD-Core Version:    0.7.0.1
 */