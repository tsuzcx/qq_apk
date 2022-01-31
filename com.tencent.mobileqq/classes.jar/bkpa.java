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
public class bkpa
{
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bktt jdField_a_of_type_Bktt;
  private blnr jdField_a_of_type_Blnr = new bkpc(this);
  private final AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  public AEMaterialPanel a;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public bkpa(View paramView, bkis parambkis)
  {
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363888));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372393));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131362188);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366524));
    a(parambkis);
  }
  
  private void a(bkis parambkis)
  {
    ((bklp)bklq.a(parambkis).a(bklp.class)).a.a(parambkis, new bkpb(this));
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
  
  public void a(bkvu parambkvu)
  {
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterialMetaData(parambkvu);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.b == null) || (this.d == null)) {
      return;
    }
    float f2 = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() + this.d.getHeight();
    if ((this.c == null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363882);
    }
    float f1 = f2;
    if (this.c != null)
    {
      f1 = f2;
      if (this.c.getVisibility() == 0) {
        f1 = f2 + (this.c.getHeight() + bnoa.a(8.0F));
      }
    }
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      ytv.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { 0.0F, f1 }).a(paramInt).b();
      if ((this.e != null) && (this.e.getVisibility() == 0))
      {
        localObject = new int[2];
        this.e.getLocationOnScreen((int[])localObject);
        i = this.jdField_a_of_type_AndroidViewView.getHeight();
        j = localObject[1];
        k = xod.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
        ytv.a(new View[] { this.e }).a(new float[] { 0.0F, i - j + k }).a(paramInt).b();
      }
    }
    for (Object localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
    {
      ((ScaleAnimation)localObject).setDuration(paramInt);
      ((ScaleAnimation)localObject).setFillAfter(true);
      this.b.startAnimation((Animation)localObject);
      return;
      ytv.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { f1, 0.0F }).a(paramInt).b();
      if ((this.e != null) && (this.e.getVisibility() == 0))
      {
        localObject = new int[2];
        this.e.getLocationOnScreen((int[])localObject);
        i = this.jdField_a_of_type_AndroidViewView.getHeight();
        j = localObject[1];
        k = xod.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
        ytv.a(new View[] { this.e }).a(new float[] { i - j + k, 0.0F }).a(paramInt).b();
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
    a(bkvr.a());
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131366807));
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131364906);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363882);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131375844);
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) || (this.jdField_a_of_type_Bktt != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
        bool2 = false | this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_Bktt != null) {
        bool1 = bool2 | this.jdField_a_of_type_Bktt.b();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    bncp.a().a(0);
    ((blnl)blmf.a(5)).a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.b();
    }
    if (this.jdField_a_of_type_Bktt != null) {
      this.jdField_a_of_type_Bktt.c();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(true);
    }
    if (this.jdField_a_of_type_Bktt != null) {
      this.jdField_a_of_type_Bktt.d();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131369774);
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
    if (this.jdField_a_of_type_Bktt != null) {
      this.jdField_a_of_type_Bktt.e();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bktt != null) {
      this.jdField_a_of_type_Bktt.f();
    }
    bncp.a().a(0);
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
  }
  
  public void j()
  {
    f();
    if (this.jdField_a_of_type_Bktt != null) {
      this.jdField_a_of_type_Bktt.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpa
 * JD-Core Version:    0.7.0.1
 */