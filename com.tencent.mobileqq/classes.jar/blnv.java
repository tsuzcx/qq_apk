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
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import mqq.os.MqqHandler;

@TargetApi(17)
public class blnv
  implements blod
{
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private blio jdField_a_of_type_Blio;
  private blst jdField_a_of_type_Blst;
  private bmrx jdField_a_of_type_Bmrx = new blnx(this);
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
  
  public blnv(View paramView, blio paramblio)
  {
    this.jdField_a_of_type_Boolean = true;
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Blio = paramblio;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364156));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373087));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131362272);
    this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131362273);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366870));
    j();
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AECaptureController.1(this, paramBoolean));
  }
  
  private void b(blvb paramblvb)
  {
    int i = 1;
    if (paramblvb != null)
    {
      String str = bmbg.a().a();
      if ((str == null) || (!str.equalsIgnoreCase(paramblvb.a))) {
        break label120;
      }
    }
    label120:
    for (i = 0;; i = 1)
    {
      bmbg.a().c(paramblvb.a);
      bmbg.a().b(paramblvb.f);
      if (paramblvb.f != 0) {
        a(true);
      }
      for (;;)
      {
        if (i != 0) {
          bmbc.a().T();
        }
        return;
        a(false);
        continue;
        if ("none".equalsIgnoreCase(bmbg.a().a())) {
          i = 0;
        }
        bmbg.a().c("none");
        bmbg.a().b(0);
        a(false);
      }
    }
  }
  
  private void j()
  {
    ((blkr)blks.a(this.jdField_a_of_type_Blio).get(blkr.class)).a.observe(this.jdField_a_of_type_Blio, new blnw(this));
  }
  
  public void a()
  {
    a(bluy.a());
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
  
  public void a(blvb paramblvb)
  {
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    Object localObject;
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null)
    {
      localObject = this.jdField_a_of_type_Blio.a();
      if ((b()) || (paramblvb == null)) {
        break label146;
      }
      localObject = ((Activity)localObject).getIntent();
      ((Intent)localObject).putExtra("widgetinfo", "camera^" + paramblvb.a);
      ((Intent)localObject).putExtra("material_id", paramblvb.a);
      bmbx.b("CaptureController", "selectSpecificMaterial---塞拍同款名 takeSameName=" + paramblvb.i);
      ((Intent)localObject).putExtra("key_camera_material_name", paramblvb.i);
      ((Intent)localObject).putExtra("ae_editor_is_show_take_same", paramblvb.f);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterialMetaData(paramblvb);
      b(paramblvb);
      return;
      label146:
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
        zwd.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { 0.0F, f1 }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0) && (this.f != null) && (this.f.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          zwd.a(new View[] { this.e, this.f }).a(new float[] { 0.0F, i - j + k }).a(paramInt).b();
        }
      }
      for (localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
      {
        ((ScaleAnimation)localObject).setDuration(paramInt);
        ((ScaleAnimation)localObject).setFillAfter(true);
        this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
        return;
        zwd.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { f1, 0.0F }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0) && (this.f != null) && (this.f.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          zwd.a(new View[] { this.e, this.f }).a(new float[] { i - j + k, 0.0F }).a(paramInt).b();
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131367152));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365212);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131376539);
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
    bnub.a().a(0);
    bmrr localbmrr = (bmrr)bmql.a(5);
    if (this.jdField_b_of_type_Boolean) {
      localbmrr.a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
    }
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) || (this.jdField_a_of_type_Blst != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
        bool2 = false | this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_Blst != null) {
        bool1 = bool2 | this.jdField_a_of_type_Blst.b();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.b();
    }
    if (this.jdField_a_of_type_Blst != null) {
      this.jdField_a_of_type_Blst.c();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(true);
    }
    if (this.jdField_a_of_type_Blst != null) {
      this.jdField_a_of_type_Blst.d();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131370299);
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
    if (this.jdField_a_of_type_Blst != null) {
      this.jdField_a_of_type_Blst.e();
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Blst != null) {
      this.jdField_a_of_type_Blst.f();
    }
    bnub.a().a(0);
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
  }
  
  public void i()
  {
    e();
    if (this.jdField_a_of_type_Blst != null) {
      this.jdField_a_of_type_Blst.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnv
 * JD-Core Version:    0.7.0.1
 */