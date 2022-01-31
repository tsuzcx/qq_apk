import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.1;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.2;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class bikc
  extends biwa
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 20000;
  private static int jdField_b_of_type_Int = 4000;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private biim jdField_a_of_type_Biim;
  private bioi jdField_a_of_type_Bioi;
  private bioy jdField_a_of_type_Bioy;
  private biry jdField_a_of_type_Biry;
  private bivx jdField_a_of_type_Bivx;
  private bivy jdField_a_of_type_Bivy;
  private bivz jdField_a_of_type_Bivz;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private CountDownView jdField_a_of_type_DovComQqImCaptureViewCountDownView;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  
  public bikc(Activity paramActivity, View paramView, biwb parambiwb)
  {
    super(paramActivity, paramView, parambiwb);
    this.jdField_a_of_type_Biim = ((biim)parambiwb.a(65537, new Object[0]));
    if (birc.f(paramActivity.getIntent()))
    {
      bizj.a().a("app_alg_aio_camera_type_id", "", 4);
      jdField_a_of_type_Int = 20000;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!birc.e(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!birc.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!birc.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!birc.h(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!birc.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!birc.h(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366409);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363833));
    if (((Long)xfr.a().a("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363297));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363295));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout = ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363881));
    this.jdField_a_of_type_Boolean = ((String)xfr.a().a("enable_click_take_picture", "1")).equals("1");
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      if ((birc.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (birc.h(this.jdField_a_of_type_AndroidAppActivity.getIntent()))) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setFunctionFlag(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("ability_flag", 2));
      }
    }
    else
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setMaxDuration(jdField_a_of_type_Int);
      e();
      return;
    }
    AEPituCameraCaptureButtonLayout localAEPituCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 3)
    {
      localAEPituCameraCaptureButtonLayout.setFunctionFlag(i);
      break;
    }
  }
  
  private void e()
  {
    if (axli.c(this.jdField_a_of_type_AndroidAppActivity) / axli.e(this.jdField_a_of_type_AndroidAppActivity) >= 2.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      bkur.c(this.jdField_a_of_type_AndroidAppActivity);
    }
    if ((Build.MODEL.contains("Pixel 2")) && (Build.VERSION.SDK_INT >= 16))
    {
      View localView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFB);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369526));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.1(this));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363675));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372075));
      if (!c()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.post(new VideoStoryPiecesPart.2(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setPartManager(this.jdField_a_of_type_Biwb);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setAECaptureController(this.jdField_a_of_type_Biim.a());
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView = ((CountDownView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362152)).inflate().findViewById(2131362153));
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.setCountDownListener(new bike(this));
  }
  
  private void l()
  {
    this.jdField_a_of_type_Biry = ((biry)biix.a(this.jdField_a_of_type_Biim).a(biry.class));
    this.jdField_a_of_type_Biry.c().a(this.jdField_a_of_type_Biim, new bikf(this));
    this.jdField_a_of_type_Bivy = ((bivy)biix.a(this.jdField_a_of_type_Biim).a(bivy.class));
    this.jdField_a_of_type_Bivy.a().a(this.jdField_a_of_type_Biim, new bikg(this));
    this.jdField_a_of_type_Bioy = ((bioy)biix.a(this.jdField_a_of_type_Biim).a(bioy.class));
    this.jdField_a_of_type_Bioy.a().a(this.jdField_a_of_type_Biim, new bikh(this));
    this.jdField_a_of_type_Bivz = ((bivz)biix.a(this.jdField_a_of_type_Biim).a(bivz.class));
    this.jdField_a_of_type_Bivz.a().a(this.jdField_a_of_type_Biim, new bikj(this));
    this.jdField_a_of_type_Bivz.b().a(Boolean.valueOf(false));
    this.jdField_a_of_type_Bivz.c().a(Boolean.valueOf(false));
    ((biiw)biix.a(this.jdField_a_of_type_Biim).a(biiw.class)).a.a(this.jdField_a_of_type_Biim, new bikk(this));
  }
  
  private void m()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.9(this), 64, null, true);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Bioi != null)
    {
      this.jdField_a_of_type_Bioi.b();
      this.jdField_a_of_type_Bivz.c().a(Boolean.valueOf(true));
    }
  }
  
  private void o()
  {
    int i = vzo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new bikd(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  protected void a()
  {
    d();
    f();
    l();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    e();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramInt1 == 10023) || (paramInt1 == 10006)) && (paramInt2 == -1))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel == null) {
        break label51;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
      label51:
      if (QLog.isColorLevel()) {
        QLog.d("VideoStoryPiecesPart", 2, "onActivityResult() mPtvContainerView null!!!");
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    label97:
    do
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label97;
        }
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(null, null, false);
        this.jdField_a_of_type_Bivz.b().a(Boolean.valueOf(true));
      }
      for (;;)
      {
        xhe.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
        return;
        if ((paramVarArgs[0] instanceof biqn))
        {
          paramVarArgs = (biqn)paramVarArgs[0];
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(paramVarArgs.b, paramVarArgs.a, true);
          this.jdField_a_of_type_Bivz.b().a(Boolean.valueOf(true));
        }
      }
      n();
      return;
      o();
      return;
    } while (this.jdField_a_of_type_Bioi == null);
    this.jdField_a_of_type_Bioi.h();
  }
  
  public void b()
  {
    super.b();
    m();
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369526: 
      this.jdField_a_of_type_Biim.v();
      xhe.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
      bizc.a().k();
      return;
    }
    if (this.jdField_a_of_type_Biwb != null) {
      this.jdField_a_of_type_Biwb.a(131076, new Object[0]);
    }
    xhe.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
    bizc.a().n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bikc
 * JD-Core Version:    0.7.0.1
 */