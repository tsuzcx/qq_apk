import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.14;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.15;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.3;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.4;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class bnbp
  extends bnqb
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 20000;
  private static int jdField_b_of_type_Int = 4000;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmxa jdField_a_of_type_Bmxa;
  private bngm jdField_a_of_type_Bngm;
  private bnmb jdField_a_of_type_Bnmb;
  private bnpz jdField_a_of_type_Bnpz;
  private bnqa jdField_a_of_type_Bnqa;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AEWaterMarkPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private CountDownView jdField_a_of_type_DovComQqImCaptureViewCountDownView;
  private AbsAECaptureButton jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AECompoundButton jdField_b_of_type_DovComQqImAeViewAECompoundButton;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = bnri.a();
  private boolean d;
  private boolean e;
  
  public bnbp(Activity paramActivity, View paramView, bnqc parambnqc)
  {
    super(paramActivity, paramView, parambnqc);
    this.jdField_a_of_type_Bmxa = ((bmxa)parambnqc.a(65537, new Object[0]));
    if (bnlb.f(paramActivity.getIntent()))
    {
      bnqu.a().a("app_alg_aio_camera_type_id", "", 4);
      jdField_a_of_type_Int = 20000;
    }
    this.jdField_c_of_type_Int = bnlb.a(this.mActivity.getIntent());
  }
  
  public static bnru a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
      return bnru.a;
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
    {
      int i = bnrg.a();
      if (i == 2) {
        return bnru.c;
      }
      if (i == 1) {
        return bnru.d;
      }
      return bnru.b;
    }
    return bnru.b;
  }
  
  private void a(@NonNull bnru parambnru)
  {
    if (!this.d) {}
    do
    {
      return;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a(true, parambnru);
      }
    } while (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton == null);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambnru.r, parambnru.q);
  }
  
  private void a(String paramString)
  {
    bnrh.a("VideoStoryPiecesPart", "[GifAuthor]---showGifAuthor: author=" + paramString);
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewStub)this.mRootView.findViewById(2131378171)).inflate());
      this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getY() - UIUtils.dip2px(this.mActivity, 24.0F));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.mActivity.getString(2131689739, new Object[] { paramString }));
  }
  
  private boolean a()
  {
    return (bnlb.d(this.jdField_c_of_type_Int)) || (bnlb.c(this.jdField_c_of_type_Int)) || (bnlb.b(this.jdField_c_of_type_Int)) || (bnlb.e(this.jdField_c_of_type_Int));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((c()) && (paramBoolean))
    {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
  }
  
  private boolean b()
  {
    return (this.mActivity != null) && (!bnlb.e(this.mActivity.getIntent())) && (!bnlb.f(this.mActivity.getIntent())) && (!bnlb.h(this.mActivity.getIntent())) && (!bnlb.i(this.mActivity.getIntent())) && (!bnlb.j(this.mActivity.getIntent())) && (this.jdField_a_of_type_Bmxa.b().b());
  }
  
  private void c()
  {
    String str;
    if (this.d)
    {
      str = this.jdField_a_of_type_Bmxa.a().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("http"))) {}
    }
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Bmxa.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
      localIntent.putExtra("loc_play_show_material_id", str);
      localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bnlb.x.a());
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", bnlb.I.a());
      this.jdField_a_of_type_Bmxa.a().startActivityForResult(localIntent, 1025);
      this.mActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (!this.e) || (!this.jdField_a_of_type_Bnpz.b())) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  private boolean c()
  {
    return (this.mActivity != null) && (!bnlb.h(this.mActivity.getIntent())) && (!bnlb.i(this.mActivity.getIntent())) && (this.jdField_a_of_type_Bmxa.b().e());
  }
  
  private void d()
  {
    if (this.mRootView == null) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mRootView.findViewById(2131379731));
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Bnqa.a().getValue();
    if ((localBoolean != null) && (!localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_Bnqa.b().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_Bnqa.c().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    int i = bnlb.a(this.mActivity.getIntent());
    if ((bnlb.e(i)) || (bnlb.h(i)) || (bnlb.c(i)) || (bnlb.b(i))) {
      return false;
    }
    if (bnqu.a().a("sp_key_ae_comics_gif_tips", false, 0))
    {
      bnrh.b("VideoStoryPiecesPart", "[ComicsTips]--has shown");
      return false;
    }
    return true;
  }
  
  private void e()
  {
    h();
    f();
  }
  
  private void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.mRootView.findViewById(2131369212));
      if (this.e)
      {
        g();
        a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void g()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378179);
    if (localViewStub != null) {
      localViewStub.setOnInflateListener(new bnbq(this));
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new bnbw(this));
    }
  }
  
  private void h()
  {
    i();
    if (this.e)
    {
      if (this.d)
      {
        this.jdField_b_of_type_JavaLangString = bnqu.a().a("circle_camera_ad_icon_url", "", 4);
        this.jdField_c_of_type_JavaLangString = bnqu.a().a("circle_camera_ad_schema", "", 4);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaLangString = bnqu.a().a("camera_ad_icon_url", "", 4);
    this.jdField_c_of_type_JavaLangString = bnqu.a().a("camera_ad_schema", "", 4);
  }
  
  private void i()
  {
    if (this.d)
    {
      this.e = bnqu.a().a("circle_camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = bnqu.a().a("circle_camera_ad_type", "", 4);
      bnrh.b("VideoStoryPiecesPart", "isPresent: " + this.e + " type: " + this.jdField_a_of_type_JavaLangString);
      if (("h5".equals(this.jdField_a_of_type_JavaLangString)) || ("widget".equals(this.jdField_a_of_type_JavaLangString))) {
        break label145;
      }
      this.e = false;
    }
    label145:
    while (!a())
    {
      return;
      this.e = bnqu.a().a("camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = bnqu.a().a("camera_ad_type", "", 4);
      break;
    }
    this.e = "h5".equals(this.jdField_a_of_type_JavaLangString);
  }
  
  private void j()
  {
    bnrh.b("VideoStoryPiecesPart", "content entry present.");
    if ((this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable() != null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if ((this.jdField_b_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      try
      {
        bnrh.b("VideoStoryPiecesPart", "in url drawable set：" + this.jdField_b_of_type_JavaLangString);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mActivity.getResources().getDrawable(2131167296);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mActivity.getResources().getDrawable(2131167296);
        localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Exception localException)
      {
        bnrh.d("VideoStoryPiecesPart", "url error url: " + this.jdField_b_of_type_JavaLangString);
        return;
      }
    }
    bnrh.b("VideoStoryPiecesPart", "iconUrl is empty.");
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 0)) {
      bnqm.a().S();
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131367270);
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2131366979);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364231));
    if (((Long)VSConfigManager.getInstance().getValue("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton = ((AbsAECaptureButton)this.mRootView.findViewById(2131364282));
    this.jdField_a_of_type_Boolean = ((String)VSConfigManager.getInstance().getValue("enable_click_take_picture", "1")).equals("1");
    this.jdField_b_of_type_Boolean = this.mActivity.getIntent().getBooleanExtra("input_full_screen_mode", false);
    b();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setMaxDuration(a(AECaptureMode.NORMAL));
  }
  
  private void m()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel = ((AEWaterMarkPanel)this.mRootView.findViewById(2131373298));
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.setCaptureController(this.jdField_a_of_type_Bmxa.a());
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.setPartManager(this.mPartManager);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.mRootView.findViewById(2131370491));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.3(this));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2131364061));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.mRootView.findViewById(2131373297));
      if (!c()) {
        break label209;
      }
      if (this.d) {
        break label181;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.post(new VideoStoryPiecesPart.4(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setPartManager(this.mPartManager);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setCaptureController(this.jdField_a_of_type_Bmxa.a());
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
      break;
      label181:
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2131369217));
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
    }
    label209:
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView = ((CountDownView)((ViewStub)this.mRootView.findViewById(2131362243)).inflate().findViewById(2131362244));
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.setCountDownListener(new bnbx(this));
  }
  
  private void p()
  {
    this.jdField_a_of_type_Bnmb = ((bnmb)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnmb.class));
    this.jdField_a_of_type_Bnpz = ((bnpz)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnpz.class));
    this.jdField_a_of_type_Bnqa = ((bnqa)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnqa.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)bmxz.a(this.jdField_a_of_type_Bmxa).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_Bnmb.b().observe(this.jdField_a_of_type_Bmxa, new bnby(this));
    this.jdField_a_of_type_Bnpz.a.observe(this.jdField_a_of_type_Bmxa, new bnbz(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_Bmxa, new bnca(this));
    if (this.d) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bmxa, new bncc(this));
    }
    this.jdField_a_of_type_Bnqa.a().observe(this.jdField_a_of_type_Bmxa, new bnbr(this));
    this.jdField_a_of_type_Bnqa.b().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_Bnqa.c().postValue(Boolean.valueOf(false));
    ((bmxy)bmxz.a(this.jdField_a_of_type_Bmxa).get(bmxy.class)).a.observe(this.jdField_a_of_type_Bmxa, new bnbs(this));
    this.jdField_a_of_type_Bnqa.b().observe(this.jdField_a_of_type_Bmxa, new bnbt(this));
    this.jdField_a_of_type_Bnqa.c().observe(this.jdField_a_of_type_Bmxa, new bnbu(this));
  }
  
  private void q()
  {
    if (d()) {
      r();
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = new BubbleTextView(this.mActivity);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(UIUtils.dip2px(this.mActivity, 10.0F), UIUtils.dip2px(this.mActivity, 11.0F), UIUtils.dip2px(this.mActivity, 10.0F), UIUtils.dip2px(this.mActivity, 11.0F));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(Color.parseColor("#03081A"));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = UIUtils.dip2px(this.mActivity, 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(this.mActivity.getString(2131689690));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.mRootView.findViewById(2131376798);
      if (localRelativeLayout != null)
      {
        ViewParent localViewParent = localRelativeLayout.getParent();
        if ((localViewParent instanceof RelativeLayout))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, 2131376798);
          localLayoutParams.bottomMargin = UIUtils.dip2px(this.mActivity, -8.0F);
          ((RelativeLayout)localViewParent).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView, ((RelativeLayout)localViewParent).indexOfChild(localRelativeLayout), localLayoutParams);
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(new VideoStoryPiecesPart.14(this), 200L);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      t();
      bnrh.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
      return;
    }
    Object localObject = (Boolean)this.jdField_a_of_type_Bnqa.a().getValue();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      t();
      bnrh.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
      return;
    }
    localObject = (bnkg)this.jdField_a_of_type_Bnmb.b().getValue();
    if ((localObject == null) || (((bnkg)localObject).a == null))
    {
      t();
      bnrh.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
      return;
    }
    localObject = (String)((bnkg)localObject).a.additionalFields.get("gif_sponsor_name");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      t();
      bnrh.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
      return;
    }
    a((String)localObject);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void u()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.15(this), 64, null, true);
  }
  
  private void v()
  {
    bnrh.a("VideoStoryPiecesPart", "watermark openWaterMarkPanel");
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.setVisibility(0);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a();
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Bngm != null)
    {
      this.jdField_a_of_type_Bngm.b();
      this.jdField_a_of_type_Bnqa.c().postValue(Boolean.valueOf(true));
    }
  }
  
  private void x()
  {
    int i = UIUtils.dip2px(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new bnbv(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  protected int a()
  {
    return this.mActivity.getResources().getDimensionPixelSize(2131296274);
  }
  
  protected int a(AECaptureMode paramAECaptureMode)
  {
    if ((this.jdField_a_of_type_Bmxa != null) && (this.jdField_a_of_type_Bmxa.b().k() != -1)) {
      return this.jdField_a_of_type_Bmxa.b().k();
    }
    if (paramAECaptureMode == AECaptureMode.GIF) {
      return jdField_b_of_type_Int;
    }
    return jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {
      f();
    }
    if (!this.e)
    {
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      bnrh.a("VideoStoryPiecesPart", "hide camera content entry.");
      return;
    }
    if (bnlb.h(this.jdField_c_of_type_Int))
    {
      j();
      return;
    }
    if (bnlb.g(this.jdField_c_of_type_Int))
    {
      k();
      j();
      return;
    }
    if (a())
    {
      if ("h5".equals(bnqu.a().a("camera_ad_type", "", 4)))
      {
        k();
        j();
        return;
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      this.e = false;
      return;
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    this.e = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (!this.e)) {
      return;
    }
    if (paramBoolean)
    {
      a();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  protected void b()
  {
    int i = 1;
    if (this.mActivity != null)
    {
      if ((!bnlb.h(this.mActivity.getIntent())) && (!bnlb.i(this.mActivity.getIntent()))) {
        break label74;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 2));
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(this.jdField_a_of_type_Bmxa.b().b());
      return;
      label74:
      if (bnlb.j(this.mActivity.getIntent()))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 1));
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(2);
      }
    }
    AbsAECaptureButton localAbsAECaptureButton = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton;
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localAbsAECaptureButton.setFunctionFlag(i);
      break;
      i = 3;
    }
  }
  
  protected void initView()
  {
    this.d = bnlb.j(this.mActivity.getIntent());
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378164);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    l();
    n();
    m();
    p();
    c();
    e();
    d();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.a();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
      if (this.mActivity != null) {
        this.mActivity.finish();
      }
      return;
      label51:
      if (QLog.isColorLevel()) {
        QLog.d("VideoStoryPiecesPart", 2, "onActivityResult() mPtvContainerView null!!!");
      }
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    u();
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
      if (this.mPartManager != null)
      {
        this.mPartManager.a(786436, new Object[0]);
        continue;
        bnqm.a().U();
        Object localObject = bnkb.a();
        if (localObject != null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("sourcetype", String.valueOf(20));
          localHashMap.put("filterid", ((bnke)localObject).jdField_a_of_type_JavaLangString);
          localHashMap.put("filtername", ((bnke)localObject).i);
          localHashMap.put("ext1from", "3");
          vvh.a(paramView.getContext(), "openpolymerize", localHashMap);
          continue;
          if (this.mPartManager != null)
          {
            this.mPartManager.a(786433, new Object[0]);
            continue;
            this.jdField_a_of_type_Bmxa.V();
            aanb.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
            bnqm.a().H();
            continue;
            if (this.d)
            {
              if (!bnrf.a(paramView))
              {
                localObject = new Intent();
                ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
                ((Intent)localObject).putExtra("is_show", false);
                this.jdField_a_of_type_Bmxa.a().sendBroadcast((Intent)localObject);
              }
            }
            else
            {
              if (this.mPartManager != null) {
                this.mPartManager.a(131076, new Object[0]);
              }
              aanb.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
              bnqm.a().K();
            }
          }
        }
      }
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 327689: 
    case 327690: 
    case 327691: 
    case 327692: 
    case 327693: 
    case 327694: 
    case 327695: 
    case 327696: 
    default: 
    case 327687: 
    case 327688: 
    case 327683: 
    case 327684: 
    case 327686: 
    case 327685: 
      label151:
      do
      {
        return;
        a();
        return;
        i();
        return;
        if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
        {
          if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
            break label151;
          }
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(null, null, false);
          this.jdField_a_of_type_Bnqa.b().postValue(Boolean.valueOf(true));
        }
        for (;;)
        {
          aanb.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
          return;
          if ((paramVarArgs[0] instanceof bnke))
          {
            paramVarArgs = (bnke)paramVarArgs[0];
            this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
            this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(paramVarArgs.jdField_b_of_type_JavaLangString, paramVarArgs.jdField_a_of_type_JavaLangString, true);
            this.jdField_a_of_type_Bnqa.b().postValue(Boolean.valueOf(true));
          }
        }
        w();
        return;
        x();
        return;
      } while (this.jdField_a_of_type_Bngm == null);
      this.jdField_a_of_type_Bngm.h();
      return;
    }
    v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbp
 * JD-Core Version:    0.7.0.1
 */