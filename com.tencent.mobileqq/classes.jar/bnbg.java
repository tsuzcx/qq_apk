import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.AECaptureController.1;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import mqq.os.MqqHandler;

@TargetApi(17)
public class bnbg
  implements bnbo
{
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bmvf jdField_a_of_type_Bmvf;
  private bngm jdField_a_of_type_Bngm;
  private bohp jdField_a_of_type_Bohp = new bnbi(this);
  private final AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  public AEMaterialPanel a;
  private AEWaterMarkPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  public volatile boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public bnbg(View paramView, bmvf parambmvf)
  {
    this.jdField_a_of_type_Boolean = true;
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bmvf = parambmvf;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364231));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373297));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel = ((AEWaterMarkPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373298));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131362277);
    this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131362278);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366988));
    j();
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AECaptureController.1(this, paramBoolean));
  }
  
  private void b(bnke parambnke)
  {
    int i = 1;
    if (parambnke != null)
    {
      String str = bnqq.a().a();
      if ((str == null) || (!str.equalsIgnoreCase(parambnke.a))) {
        break label120;
      }
    }
    label120:
    for (i = 0;; i = 1)
    {
      bnqq.a().c(parambnke.a);
      bnqq.a().b(parambnke.f);
      if (parambnke.f != 0) {
        a(true);
      }
      for (;;)
      {
        if (i != 0) {
          bnqm.a().T();
        }
        return;
        a(false);
        continue;
        if ("none".equalsIgnoreCase(bnqq.a().a())) {
          i = 0;
        }
        bnqq.a().c("none");
        bnqq.a().b(0);
        a(false);
      }
    }
  }
  
  private void j()
  {
    ((bmxy)bmxz.a(this.jdField_a_of_type_Bmvf).get(bmxy.class)).a.observe(this.jdField_a_of_type_Bmvf, new bnbh(this));
  }
  
  public void a()
  {
    bnrh.b("CaptureController", "applyVideoMaterialAgain");
    if (bnkb.b() != null)
    {
      a(bnkb.b());
      return;
    }
    a(bnkb.a());
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getSmoothLevel() == paramInt) {
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
  
  public void a(bnke parambnke)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("material id : ");
    Object localObject;
    if (parambnke == null)
    {
      localObject = "null";
      bnrh.b("CaptureController", (String)localObject);
      if (VideoPrefsUtil.getDefaultPrefs() != null) {
        VideoPrefsUtil.setMaterialMute(false);
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null)
      {
        localObject = this.jdField_a_of_type_Bmvf.a();
        if ((b()) || (parambnke == null)) {
          break label191;
        }
        localObject = ((Activity)localObject).getIntent();
        ((Intent)localObject).putExtra("widgetinfo", "camera^" + parambnke.a);
        ((Intent)localObject).putExtra("material_id", parambnke.a);
        bnrh.b("CaptureController", "selectSpecificMaterial---塞拍同款名 takeSameName=" + parambnke.i);
        ((Intent)localObject).putExtra("key_camera_material_name", parambnke.i);
        ((Intent)localObject).putExtra("ae_editor_is_show_take_same", parambnke.f);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterialMetaData(parambnke);
      b(parambnke);
      return;
      localObject = parambnke.a;
      break;
      label191:
      if (!b())
      {
        localObject = ((Activity)localObject).getIntent();
        if (localObject != null)
        {
          ((Intent)localObject).removeExtra("widgetinfo");
          ((Intent)localObject).removeExtra("material_id");
          ((Intent)localObject).removeExtra("key_camera_material_name");
          ((Intent)localObject).removeExtra("ae_editor_is_show_take_same");
        }
      }
    }
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
        aalp.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { 0.0F, f1 }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0) && (this.f != null) && (this.f.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          aalp.a(new View[] { this.e, this.f }).a(new float[] { 0.0F, i - j + k }).a(paramInt).b();
        }
      }
      for (localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
      {
        ((ScaleAnimation)localObject).setDuration(paramInt);
        ((ScaleAnimation)localObject).setFillAfter(true);
        this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
        return;
        aalp.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { f1, 0.0F }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0) && (this.f != null) && (this.f.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          aalp.a(new View[] { this.e, this.f }).a(new float[] { i - j + k, 0.0F }).a(paramInt).b();
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
      e();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131367270));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365303);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131376798);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setSharpFaceLevel(paramInt);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) && (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.isRecording());
  }
  
  public void c()
  {
    bpjt.a().a(0);
    bohj localbohj = (bohj)bogd.a(5);
    if (this.jdField_b_of_type_Boolean) {
      localbohj.a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
    }
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) || (this.jdField_a_of_type_Bngm != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
        bool2 = false | this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_Bngm != null) {
        bool1 = bool2 | this.jdField_a_of_type_Bngm.b();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.b();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.b();
    }
    if (this.jdField_a_of_type_Bngm != null) {
      this.jdField_a_of_type_Bngm.c();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(true);
    }
    if (this.jdField_a_of_type_Bngm != null) {
      this.jdField_a_of_type_Bngm.d();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a(true);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131370478);
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
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.c();
    }
    if (this.jdField_a_of_type_Bngm != null) {
      this.jdField_a_of_type_Bngm.e();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.c();
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bngm != null) {
      this.jdField_a_of_type_Bngm.f();
    }
    bpjt.a().a(0);
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
  }
  
  public void i()
  {
    e();
    if (this.jdField_a_of_type_Bngm != null) {
      this.jdField_a_of_type_Bngm.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbg
 * JD-Core Version:    0.7.0.1
 */