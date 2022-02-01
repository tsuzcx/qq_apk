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
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.16;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.3;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.4;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
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
import mqq.os.MqqHandler;

public class bloe
  extends bmar
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 20000;
  private static int jdField_b_of_type_Int = 4000;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bljy jdField_a_of_type_Bljy;
  private blst jdField_a_of_type_Blst;
  private blwr jdField_a_of_type_Blwr;
  private bmap jdField_a_of_type_Bmap;
  private bmaq jdField_a_of_type_Bmaq;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
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
  private AECompoundButton jdField_c_of_type_DovComQqImAeViewAECompoundButton;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = bmby.a();
  private boolean d;
  private boolean e;
  
  public bloe(Activity paramActivity, View paramView, bmas parambmas)
  {
    super(paramActivity, paramView, parambmas);
    this.jdField_a_of_type_Bljy = ((bljy)parambmas.a(65537, new Object[0]));
    if (blvr.f(paramActivity.getIntent()))
    {
      bmbk.a().a("app_alg_aio_camera_type_id", "", 4);
      jdField_a_of_type_Int = 20000;
    }
    this.jdField_c_of_type_Int = blvr.a(this.mActivity.getIntent());
  }
  
  public static bmcd a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
      return bmcd.a;
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
    {
      int i = bmbw.a();
      if (i == 2) {
        return bmcd.c;
      }
      if (i == 1) {
        return bmcd.d;
      }
      return bmcd.b;
    }
    return bmcd.b;
  }
  
  private void a(@NonNull bmcd parambmcd)
  {
    if (!this.d) {}
    do
    {
      return;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a(true, parambmcd);
      }
    } while (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton == null);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambmcd.q, parambmcd.p);
  }
  
  private void a(String paramString)
  {
    bmbx.a("VideoStoryPiecesPart", "[GifAuthor]---showGifAuthor: author=" + paramString);
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewStub)this.mRootView.findViewById(2131377885)).inflate());
      this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getY() - UIUtils.dip2px(this.mActivity, 24.0F));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.mActivity.getString(2131689731, new Object[] { paramString }));
  }
  
  private boolean a()
  {
    return (blvr.d(this.jdField_c_of_type_Int)) || (blvr.c(this.jdField_c_of_type_Int)) || (blvr.b(this.jdField_c_of_type_Int)) || (blvr.e(this.jdField_c_of_type_Int));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((c()) && (paramBoolean)) {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    }
    for (;;)
    {
      c(paramBoolean);
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    }
  }
  
  private boolean b()
  {
    return (this.mActivity != null) && (!blvr.e(this.mActivity.getIntent())) && (!blvr.f(this.mActivity.getIntent())) && (!blvr.h(this.mActivity.getIntent())) && (!blvr.i(this.mActivity.getIntent())) && (!blvr.j(this.mActivity.getIntent())) && (this.jdField_a_of_type_Bljy.b().b());
  }
  
  private void c()
  {
    String str;
    if (this.d)
    {
      str = this.jdField_a_of_type_Bljy.a().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("http"))) {}
    }
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Bljy.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
      localIntent.putExtra("loc_play_show_material_id", str);
      localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", blvr.x.a());
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", blvr.I.a());
      this.jdField_a_of_type_Bljy.a().startActivityForResult(localIntent, 1025);
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
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      blvb localblvb = bluy.a();
      if ((localblvb != null) && (localblvb.jdField_a_of_type_Boolean) && (paramBoolean)) {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(4);
  }
  
  private boolean c()
  {
    return (this.mActivity != null) && (!blvr.h(this.mActivity.getIntent())) && (!blvr.i(this.mActivity.getIntent())) && (this.jdField_a_of_type_Bljy.b().e());
  }
  
  private void d()
  {
    if (this.mRootView == null) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mRootView.findViewById(2131379426));
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (!this.e) || (!this.jdField_a_of_type_Bmap.b())) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Bmaq.a().getValue();
    if ((localBoolean != null) && (!localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_Bmaq.b().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_Bmaq.c().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    int i = blvr.a(this.mActivity.getIntent());
    if ((blvr.e(i)) || (blvr.h(i)) || (blvr.c(i)) || (blvr.b(i))) {
      return false;
    }
    if (bmbk.a().a("sp_key_ae_comics_gif_tips", false, 0))
    {
      bmbx.b("VideoStoryPiecesPart", "[ComicsTips]--has shown");
      return false;
    }
    return true;
  }
  
  private void e()
  {
    h();
    f();
  }
  
  private void e(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new VideoStoryPiecesPart.16(this, paramBoolean));
  }
  
  private void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.mRootView.findViewById(2131369049));
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
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131377893);
    if (localViewStub != null) {
      localViewStub.setOnInflateListener(new blof(this));
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new blol(this));
    }
  }
  
  private void h()
  {
    i();
    if (this.e)
    {
      if (this.d)
      {
        this.jdField_b_of_type_JavaLangString = bmbk.a().a("circle_camera_ad_icon_url", "", 4);
        this.jdField_c_of_type_JavaLangString = bmbk.a().a("circle_camera_ad_schema", "", 4);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaLangString = bmbk.a().a("camera_ad_icon_url", "", 4);
    this.jdField_c_of_type_JavaLangString = bmbk.a().a("camera_ad_schema", "", 4);
  }
  
  private void i()
  {
    if (this.d)
    {
      this.e = bmbk.a().a("circle_camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = bmbk.a().a("circle_camera_ad_type", "", 4);
      bmbx.b("VideoStoryPiecesPart", "isPresent: " + this.e + " type: " + this.jdField_a_of_type_JavaLangString);
      if (("h5".equals(this.jdField_a_of_type_JavaLangString)) || ("widget".equals(this.jdField_a_of_type_JavaLangString))) {
        break label145;
      }
      this.e = false;
    }
    label145:
    while (!a())
    {
      return;
      this.e = bmbk.a().a("camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = bmbk.a().a("camera_ad_type", "", 4);
      break;
    }
    this.e = "h5".equals(this.jdField_a_of_type_JavaLangString);
  }
  
  private void j()
  {
    bmbx.b("VideoStoryPiecesPart", "content entry present.");
    if ((this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable() != null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if ((this.jdField_b_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      try
      {
        bmbx.b("VideoStoryPiecesPart", "in url drawable set：" + this.jdField_b_of_type_JavaLangString);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mActivity.getResources().getDrawable(2131167276);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mActivity.getResources().getDrawable(2131167276);
        localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Exception localException)
      {
        bmbx.d("VideoStoryPiecesPart", "url error url: " + this.jdField_b_of_type_JavaLangString);
        return;
      }
    }
    bmbx.b("VideoStoryPiecesPart", "iconUrl is empty.");
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 0)) {
      bmbc.a().S();
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131367152);
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2131366861);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364156));
    if (((Long)VSConfigManager.getInstance().getValue("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton = ((AbsAECaptureButton)this.mRootView.findViewById(2131364205));
    this.jdField_a_of_type_Boolean = ((String)VSConfigManager.getInstance().getValue("enable_click_take_picture", "1")).equals("1");
    this.jdField_b_of_type_Boolean = this.mActivity.getIntent().getBooleanExtra("input_full_screen_mode", false);
    b();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setMaxDuration(a(AECaptureMode.NORMAL));
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.mRootView.findViewById(2131370312));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.3(this));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2131363987));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.mRootView.findViewById(2131373087));
      if (!c()) {
        break label241;
      }
      if (this.d) {
        break label213;
      }
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.post(new VideoStoryPiecesPart.4(this));
      label128:
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setPartManager(this.mPartManager);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setCaptureController(this.jdField_a_of_type_Bljy.a());
    }
    for (;;)
    {
      if (this.d)
      {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2131363819));
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
      }
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
      break;
      label213:
      this.jdField_c_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2131369054));
      this.jdField_c_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
      break label128;
      label241:
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView = ((CountDownView)((ViewStub)this.mRootView.findViewById(2131362238)).inflate().findViewById(2131362239));
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.setCountDownListener(new blom(this));
  }
  
  private void o()
  {
    this.jdField_a_of_type_Blwr = ((blwr)blks.a(this.jdField_a_of_type_Bljy).get(blwr.class));
    this.jdField_a_of_type_Bmap = ((bmap)blks.a(this.jdField_a_of_type_Bljy).get(bmap.class));
    this.jdField_a_of_type_Bmaq = ((bmaq)blks.a(this.jdField_a_of_type_Bljy).get(bmaq.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)blks.a(this.jdField_a_of_type_Bljy).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_Blwr.b().observe(this.jdField_a_of_type_Bljy, new blon(this));
    this.jdField_a_of_type_Bmap.a.observe(this.jdField_a_of_type_Bljy, new bloo(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_Bljy, new blop(this));
    if (this.d) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bljy, new blor(this));
    }
    this.jdField_a_of_type_Bmaq.a().observe(this.jdField_a_of_type_Bljy, new blog(this));
    this.jdField_a_of_type_Bmaq.b().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_Bmaq.c().postValue(Boolean.valueOf(false));
    ((blkr)blks.a(this.jdField_a_of_type_Bljy).get(blkr.class)).a.observe(this.jdField_a_of_type_Bljy, new bloh(this));
    this.jdField_a_of_type_Bmaq.b().observe(this.jdField_a_of_type_Bljy, new bloi(this));
    this.jdField_a_of_type_Bmaq.c().observe(this.jdField_a_of_type_Bljy, new bloj(this));
  }
  
  private void p()
  {
    if (d()) {
      q();
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
  }
  
  private void q()
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
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(this.mActivity.getString(2131689682));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.mRootView.findViewById(2131376539);
      if (localRelativeLayout != null)
      {
        ViewParent localViewParent = localRelativeLayout.getParent();
        if ((localViewParent instanceof RelativeLayout))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, 2131376539);
          localLayoutParams.bottomMargin = UIUtils.dip2px(this.mActivity, -8.0F);
          ((RelativeLayout)localViewParent).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView, ((RelativeLayout)localViewParent).indexOfChild(localRelativeLayout), localLayoutParams);
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(new VideoStoryPiecesPart.14(this), 200L);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      s();
      bmbx.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
      return;
    }
    Object localObject = (Boolean)this.jdField_a_of_type_Bmaq.a().getValue();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      s();
      bmbx.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
      return;
    }
    localObject = (blvd)this.jdField_a_of_type_Blwr.b().getValue();
    if ((localObject == null) || (((blvd)localObject).a == null))
    {
      s();
      bmbx.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
      return;
    }
    localObject = (String)((blvd)localObject).a.additionalFields.get("gif_sponsor_name");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      s();
      bmbx.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
      return;
    }
    a((String)localObject);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void t()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.15(this), 64, null, true);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Blst != null)
    {
      this.jdField_a_of_type_Blst.b();
      this.jdField_a_of_type_Bmaq.c().postValue(Boolean.valueOf(true));
    }
  }
  
  private void v()
  {
    int i = UIUtils.dip2px(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new blok(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  protected int a()
  {
    return this.mActivity.getResources().getDimensionPixelSize(2131296274);
  }
  
  protected int a(AECaptureMode paramAECaptureMode)
  {
    if ((this.jdField_a_of_type_Bljy != null) && (this.jdField_a_of_type_Bljy.b().k() != -1)) {
      return this.jdField_a_of_type_Bljy.b().k();
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
      bmbx.a("VideoStoryPiecesPart", "hide camera content entry.");
      return;
    }
    if (blvr.h(this.jdField_c_of_type_Int))
    {
      j();
      return;
    }
    if (blvr.g(this.jdField_c_of_type_Int))
    {
      k();
      j();
      return;
    }
    if (a())
    {
      if ("h5".equals(bmbk.a().a("camera_ad_type", "", 4)))
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
      if ((!blvr.h(this.mActivity.getIntent())) && (!blvr.i(this.mActivity.getIntent()))) {
        break label74;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 2));
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(this.jdField_a_of_type_Bljy.b().b());
      return;
      label74:
      if (blvr.j(this.mActivity.getIntent()))
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
    this.d = blvr.j(this.mActivity.getIntent());
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131377878);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    l();
    m();
    o();
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
    t();
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
        bmbc.a().U();
        Object localObject = bluy.a();
        if (localObject != null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("sourcetype", String.valueOf(20));
          localHashMap.put("filterid", ((blvb)localObject).jdField_a_of_type_JavaLangString);
          localHashMap.put("filtername", ((blvb)localObject).i);
          localHashMap.put("ext1from", "3");
          vgn.a(paramView.getContext(), "openpolymerize", localHashMap);
          continue;
          if (this.mPartManager != null)
          {
            this.mPartManager.a(786433, new Object[0]);
            continue;
            this.jdField_a_of_type_Bljy.M();
            zxp.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
            bmbc.a().H();
            continue;
            if (this.d)
            {
              if (!bmbv.a(paramView))
              {
                localObject = new Intent();
                ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
                ((Intent)localObject).putExtra("is_show", false);
                this.jdField_a_of_type_Bljy.a().sendBroadcast((Intent)localObject);
              }
            }
            else
            {
              if (this.mPartManager != null) {
                this.mPartManager.a(131076, new Object[0]);
              }
              zxp.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
              bmbc.a().K();
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
    case 327690: 
    case 327691: 
    case 327692: 
    case 327693: 
    case 327694: 
    case 327695: 
    default: 
    case 327687: 
    case 327688: 
    case 327683: 
    case 327684: 
    case 327686: 
    case 327685: 
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
            break label147;
          }
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(null, null, false);
          this.jdField_a_of_type_Bmaq.b().postValue(Boolean.valueOf(true));
        }
        for (;;)
        {
          zxp.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
          return;
          if ((paramVarArgs[0] instanceof blvb))
          {
            paramVarArgs = (blvb)paramVarArgs[0];
            this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
            this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(paramVarArgs.jdField_b_of_type_JavaLangString, paramVarArgs.jdField_a_of_type_JavaLangString, true);
            this.jdField_a_of_type_Bmaq.b().postValue(Boolean.valueOf(true));
          }
        }
        u();
        return;
        v();
        return;
      } while (this.jdField_a_of_type_Blst == null);
      this.jdField_a_of_type_Blst.h();
      return;
    case 327696: 
      label147:
      e(true);
      return;
    }
    e(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bloe
 * JD-Core Version:    0.7.0.1
 */