import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.1;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.2;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import java.util.Map;

public class bkpi
  extends blbl
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 20000;
  private static int jdField_b_of_type_Int = 4000;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkle jdField_a_of_type_Bkle;
  private bktt jdField_a_of_type_Bktt;
  private bkuj jdField_a_of_type_Bkuj;
  private bkxi jdField_a_of_type_Bkxi;
  private blbj jdField_a_of_type_Blbj;
  private blbk jdField_a_of_type_Blbk;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private CountDownView jdField_a_of_type_DovComQqImCaptureViewCountDownView;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  
  public bkpi(Activity paramActivity, View paramView, blbm paramblbm)
  {
    super(paramActivity, paramView, paramblbm);
    this.jdField_a_of_type_Bkle = ((bkle)paramblbm.a(65537, new Object[0]));
    if (bkwm.f(paramActivity.getIntent()))
    {
      blev.a().a("app_alg_aio_camera_type_id", "", 4);
      jdField_a_of_type_Int = 20000;
    }
  }
  
  private void a(String paramString)
  {
    blfg.a("VideoStoryPiecesPart", "[GifAuthor]---showGifAuthor: author=" + paramString);
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377098)).inflate());
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131689812, new Object[] { paramString }));
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!bkwm.e(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bkwm.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bkwm.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bkwm.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bkwm.i(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!bkwm.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bkwm.h(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366515);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363888));
    if (((Long)yuh.a().a("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363334));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363332));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout = ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363938));
    this.jdField_a_of_type_Boolean = ((String)yuh.a().a("enable_click_take_picture", "1")).equals("1");
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      if ((bkwm.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (bkwm.h(this.jdField_a_of_type_AndroidAppActivity.getIntent()))) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setFunctionFlag(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("ability_flag", 2));
      }
    }
    else
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setMaxDuration(jdField_a_of_type_Int);
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
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369787));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.1(this));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363730));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372393));
      if (!c()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.post(new VideoStoryPiecesPart.2(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setPartManager(this.jdField_a_of_type_Blbm);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setAECaptureController(this.jdField_a_of_type_Bkle.a());
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView = ((CountDownView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362159)).inflate().findViewById(2131362160));
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.setCountDownListener(new bkpk(this));
  }
  
  private void k()
  {
    this.jdField_a_of_type_Bkxi = ((bkxi)bklq.a(this.jdField_a_of_type_Bkle).a(bkxi.class));
    this.jdField_a_of_type_Blbj = ((blbj)bklq.a(this.jdField_a_of_type_Bkle).a(blbj.class));
    this.jdField_a_of_type_Blbk = ((blbk)bklq.a(this.jdField_a_of_type_Bkle).a(blbk.class));
    this.jdField_a_of_type_Bkuj = ((bkuj)bklq.a(this.jdField_a_of_type_Bkle).a(bkuj.class));
    this.jdField_a_of_type_Bkxi.c().a(this.jdField_a_of_type_Bkle, new bkpl(this));
    this.jdField_a_of_type_Blbj.a.a(this.jdField_a_of_type_Bkle, new bkpm(this));
    this.jdField_a_of_type_Bkuj.a().a(this.jdField_a_of_type_Bkle, new bkpn(this));
    this.jdField_a_of_type_Blbk.a().a(this.jdField_a_of_type_Bkle, new bkpp(this));
    this.jdField_a_of_type_Blbk.b().a(Boolean.valueOf(false));
    this.jdField_a_of_type_Blbk.c().a(Boolean.valueOf(false));
    ((bklp)bklq.a(this.jdField_a_of_type_Bkle).a(bklp.class)).a.a(this.jdField_a_of_type_Bkle, new bkpq(this));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      m();
      blfg.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
      return;
    }
    Object localObject = (Boolean)this.jdField_a_of_type_Blbk.a().a();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      m();
      blfg.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
      return;
    }
    localObject = (bkvz)this.jdField_a_of_type_Bkxi.c().a();
    if ((localObject == null) || (((bkvz)localObject).a == null))
    {
      m();
      blfg.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
      return;
    }
    localObject = (String)((bkvz)localObject).a.additionalFields.get("gif_sponsor_name");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      m();
      blfg.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
      return;
    }
    a((String)localObject);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void n()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.9(this), 64, null, true);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Bktt != null)
    {
      this.jdField_a_of_type_Bktt.b();
      this.jdField_a_of_type_Blbk.c().a(Boolean.valueOf(true));
    }
  }
  
  private void p()
  {
    int i = xod.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new bkpj(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  protected void a()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377091);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    d();
    e();
    k();
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
        this.jdField_a_of_type_Blbk.b().a(Boolean.valueOf(true));
      }
      for (;;)
      {
        yvu.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
        return;
        if ((paramVarArgs[0] instanceof bkvu))
        {
          paramVarArgs = (bkvu)paramVarArgs[0];
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(paramVarArgs.b, paramVarArgs.a, true);
          this.jdField_a_of_type_Blbk.b().a(Boolean.valueOf(true));
        }
      }
      o();
      return;
      p();
      return;
    } while (this.jdField_a_of_type_Bktt == null);
    this.jdField_a_of_type_Bktt.h();
  }
  
  public void b()
  {
    super.b();
    n();
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
    }
    do
    {
      return;
      this.jdField_a_of_type_Bkle.v();
      yvu.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
      blen.a().q();
      return;
      if (!bkwm.i(this.jdField_a_of_type_Bkle.a().getIntent())) {
        break;
      }
    } while (blff.a(paramView));
    paramView = new Intent();
    paramView.setAction("ae_editor_bottom_tab_show_hide");
    paramView.putExtra("is_show", false);
    this.jdField_a_of_type_Bkle.a().sendBroadcast(paramView);
    if (this.jdField_a_of_type_Blbm != null) {
      this.jdField_a_of_type_Blbm.a(131076, new Object[0]);
    }
    yvu.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
    blen.a().t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpi
 * JD-Core Version:    0.7.0.1
 */