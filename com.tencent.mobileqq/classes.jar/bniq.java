import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.1;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.13;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.14;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.2;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.3;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

public class bniq
  extends bnva
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 20000;
  private static int jdField_b_of_type_Int = 4000;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bndy jdField_a_of_type_Bndy;
  private bnnb jdField_a_of_type_Bnnb;
  private bnqx jdField_a_of_type_Bnqx;
  private bnuy jdField_a_of_type_Bnuy;
  private bnuz jdField_a_of_type_Bnuz;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private CountDownView jdField_a_of_type_DovComQqImCaptureViewCountDownView;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = bnzc.a();
  private boolean d;
  
  public bniq(Activity paramActivity, View paramView, bnvb parambnvb)
  {
    super(paramActivity, paramView, parambnvb);
    this.jdField_a_of_type_Bndy = ((bndy)parambnvb.a(65537, new Object[0]));
    if (bnqb.f(paramActivity.getIntent()))
    {
      bnyp.a().a("app_alg_aio_camera_type_id", "", 4);
      jdField_a_of_type_Int = 20000;
    }
  }
  
  private void a(@NonNull bnzg parambnzg)
  {
    if (!this.d) {}
    do
    {
      return;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.a(true, parambnzg);
      }
    } while (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton == null);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambnzg.o, parambnzg.n);
  }
  
  private void a(String paramString)
  {
    bnzb.a("VideoStoryPiecesPart", "[GifAuthor]---showGifAuthor: author=" + paramString);
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377959)).inflate());
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131689716, new Object[] { paramString }));
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!bnqb.e(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bnqb.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bnqb.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bnqb.i(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bnqb.j(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!bnqb.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bnqb.i(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private void d()
  {
    String str;
    if (this.d)
    {
      str = this.jdField_a_of_type_Bndy.a().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("http"))) {
        break label143;
      }
    }
    label143:
    while (TextUtils.isEmpty(localUnsupportedEncodingException)) {
      try
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_Bndy.a(), QQBrowserActivity.class);
        localIntent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
        localIntent.putExtra("loc_play_show_material_id", str);
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bnqb.x.a());
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", bnqb.C.a());
        this.jdField_a_of_type_Bndy.a().startActivityForResult(localIntent, 1025);
        this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_AndroidViewView.post(new VideoStoryPiecesPart.1(this, localUnsupportedEncodingException));
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Bnuz.a().getValue();
    if ((localBoolean != null) && (!localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_Bnuz.b().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_Bnuz.c().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    int i = bnqb.a(this.jdField_a_of_type_AndroidAppActivity.getIntent());
    if ((bnqb.e(i)) || (bnqb.h(i)) || (bnqb.c(i)) || (bnqb.b(i))) {
      return false;
    }
    if (bnyp.a().a("sp_key_ae_comics_gif_tips", false, 0))
    {
      bnzb.b("VideoStoryPiecesPart", "[ComicsTips]--has shown");
      return false;
    }
    return true;
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367085);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366786);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364093));
    if (((Long)aavz.a().a("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout = ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364143));
    this.jdField_a_of_type_Boolean = ((String)aavz.a().a("enable_click_take_picture", "1")).equals("1");
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("input_full_screen_mode", false);
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      if ((!bnqb.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bnqb.i(this.jdField_a_of_type_AndroidAppActivity.getIntent()))) {
        break label205;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setFunctionFlag(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("ability_flag", 2));
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setMaxDuration(jdField_a_of_type_Int);
      return;
      label205:
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setFunctionFlag(2);
    }
    AEPituCameraCaptureButtonLayout localAEPituCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 3)
    {
      localAEPituCameraCaptureButtonLayout.setFunctionFlag(i);
      break;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370243));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.2(this));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363938));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373004));
      if (!c()) {
        break;
      }
      if (!this.d) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.post(new VideoStoryPiecesPart.3(this));
      }
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setPartManager(this.jdField_a_of_type_Bnvb);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setAECaptureController(this.jdField_a_of_type_Bndy.a());
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
    }
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView = ((CountDownView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362229)).inflate().findViewById(2131362230));
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.setCountDownListener(new bniv(this));
  }
  
  private void l()
  {
    this.jdField_a_of_type_Bnqx = ((bnqx)bner.a(this.jdField_a_of_type_Bndy).get(bnqx.class));
    this.jdField_a_of_type_Bnuy = ((bnuy)bner.a(this.jdField_a_of_type_Bndy).get(bnuy.class));
    this.jdField_a_of_type_Bnuz = ((bnuz)bner.a(this.jdField_a_of_type_Bndy).get(bnuz.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)bner.a(this.jdField_a_of_type_Bndy).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_Bnqx.c().observe(this.jdField_a_of_type_Bndy, new bniw(this));
    this.jdField_a_of_type_Bnuy.a.observe(this.jdField_a_of_type_Bndy, new bnix(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_Bndy, new bniy(this));
    if (this.d) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bndy, new bnja(this));
    }
    this.jdField_a_of_type_Bnuz.a().observe(this.jdField_a_of_type_Bndy, new bnjb(this));
    this.jdField_a_of_type_Bnuz.b().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_Bnuz.c().postValue(Boolean.valueOf(false));
    ((bneq)bner.a(this.jdField_a_of_type_Bndy).get(bneq.class)).a.observe(this.jdField_a_of_type_Bndy, new bnir(this));
    this.jdField_a_of_type_Bnuz.b().observe(this.jdField_a_of_type_Bndy, new bnis(this));
    this.jdField_a_of_type_Bnuz.c().observe(this.jdField_a_of_type_Bndy, new bnit(this));
  }
  
  private void m()
  {
    if (d()) {
      n();
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = new BubbleTextView(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(zlx.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), zlx.a(this.jdField_a_of_type_AndroidAppActivity, 11.0F), zlx.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), zlx.a(this.jdField_a_of_type_AndroidAppActivity, 11.0F));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(Color.parseColor("#03081A"));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = zlx.a(this.jdField_a_of_type_AndroidAppActivity, 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131689678));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376636);
      if (localRelativeLayout != null)
      {
        ViewParent localViewParent = localRelativeLayout.getParent();
        if ((localViewParent instanceof RelativeLayout))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, 2131376636);
          localLayoutParams.bottomMargin = zlx.a(this.jdField_a_of_type_AndroidAppActivity, -8.0F);
          ((RelativeLayout)localViewParent).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView, ((RelativeLayout)localViewParent).indexOfChild(localRelativeLayout), localLayoutParams);
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(new VideoStoryPiecesPart.13(this), 200L);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      p();
      bnzb.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
      return;
    }
    Object localObject = (Boolean)this.jdField_a_of_type_Bnuz.a().getValue();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      p();
      bnzb.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
      return;
    }
    localObject = (bnpk)this.jdField_a_of_type_Bnqx.c().getValue();
    if ((localObject == null) || (((bnpk)localObject).a == null))
    {
      p();
      bnzb.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
      return;
    }
    localObject = (String)((bnpk)localObject).a.additionalFields.get("gif_sponsor_name");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      p();
      bnzb.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
      return;
    }
    a((String)localObject);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void q()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.14(this), 64, null, true);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Bnnb != null)
    {
      this.jdField_a_of_type_Bnnb.b();
      this.jdField_a_of_type_Bnuz.c().postValue(Boolean.valueOf(true));
    }
  }
  
  private void s()
  {
    int i = zlx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new bniu(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  protected int a()
  {
    int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296272);
    int k = this.jdField_a_of_type_AndroidViewView.getHeight() - bnlc.jdField_a_of_type_Int - zlx.b(this.jdField_a_of_type_AndroidAppActivity) - j;
    int m = zlx.a(this.jdField_a_of_type_AndroidAppActivity, 128.0F);
    int i = 0;
    if (k >= m * 1.5D) {
      i = (k - m) / 3 + j;
    }
    return i;
  }
  
  protected void a()
  {
    this.d = bnqb.j(this.jdField_a_of_type_AndroidAppActivity.getIntent());
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377952);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    e();
    f();
    l();
    d();
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
        this.jdField_a_of_type_Bnuz.b().postValue(Boolean.valueOf(true));
      }
      for (;;)
      {
        aaxb.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
        return;
        if ((paramVarArgs[0] instanceof bnpf))
        {
          paramVarArgs = (bnpf)paramVarArgs[0];
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(paramVarArgs.b, paramVarArgs.a, true);
          this.jdField_a_of_type_Bnuz.b().postValue(Boolean.valueOf(true));
        }
      }
      r();
      return;
      s();
      return;
    } while (this.jdField_a_of_type_Bnnb == null);
    this.jdField_a_of_type_Bnnb.h();
  }
  
  public void b()
  {
    super.b();
    q();
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Bndy.u();
      aaxb.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
      bnyh.a().D();
      continue;
      if (this.d)
      {
        if (!bnyz.a(paramView))
        {
          Intent localIntent = new Intent();
          localIntent.setAction("ae_editor_bottom_tab_show_hide");
          localIntent.putExtra("is_show", false);
          this.jdField_a_of_type_Bndy.a().sendBroadcast(localIntent);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Bnvb != null) {
          this.jdField_a_of_type_Bnvb.a(131076, new Object[0]);
        }
        aaxb.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
        bnyh.a().G();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bniq
 * JD-Core Version:    0.7.0.1
 */