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
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.14;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.15;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.3;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.4;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;
import dov.com.qq.im.capture.view.CountDownView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class bojy
  extends bowm
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 20000;
  private static int jdField_b_of_type_Int = 4000;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bofh jdField_a_of_type_Bofh;
  private boom jdField_a_of_type_Boom;
  private bosm jdField_a_of_type_Bosm;
  private bowk jdField_a_of_type_Bowk;
  private bowl jdField_a_of_type_Bowl;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout;
  private CountDownView jdField_a_of_type_DovComQqImCaptureViewCountDownView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AECompoundButton jdField_b_of_type_DovComQqImAeViewAECompoundButton;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = bpan.a();
  private boolean d;
  private boolean e;
  
  public bojy(Activity paramActivity, View paramView, bown parambown)
  {
    super(paramActivity, paramView, parambown);
    this.jdField_a_of_type_Bofh = ((bofh)parambown.a(65537, new Object[0]));
    if (born.f(paramActivity.getIntent()))
    {
      bozz.a().a("app_alg_aio_camera_type_id", "", 4);
      jdField_a_of_type_Int = 20000;
    }
    this.jdField_c_of_type_Int = born.a(this.jdField_a_of_type_AndroidAppActivity.getIntent());
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_Boom != null)
    {
      this.jdField_a_of_type_Boom.b();
      this.jdField_a_of_type_Bowl.c().postValue(Boolean.valueOf(true));
    }
  }
  
  private void B()
  {
    int i = zps.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new boke(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  public static bpas a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
      return bpas.a;
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
    {
      int i = bpal.a();
      if (i == 2) {
        return bpas.c;
      }
      if (i == 1) {
        return bpas.d;
      }
      return bpas.b;
    }
    return bpas.b;
  }
  
  private void a(@NonNull bpas parambpas)
  {
    if (!this.d) {}
    do
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout != null) {
        this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.a(true, parambpas);
      }
    } while (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton == null);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambpas.q, parambpas.p);
  }
  
  private void a(String paramString)
  {
    bpam.a("VideoStoryPiecesPart", "[GifAuthor]---showGifAuthor: author=" + paramString);
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378114)).inflate());
      this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getY() - zps.a(this.jdField_a_of_type_AndroidAppActivity, 24.0F));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131689721, new Object[] { paramString }));
  }
  
  private boolean a()
  {
    return (born.d(this.jdField_c_of_type_Int)) || (born.c(this.jdField_c_of_type_Int)) || (born.b(this.jdField_c_of_type_Int)) || (born.e(this.jdField_c_of_type_Int));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((d()) && (paramBoolean))
    {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (!this.e) || (!this.jdField_a_of_type_Bowk.b())) {
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
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!born.e(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!born.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!born.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!born.i(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!born.j(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!born.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!born.i(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private void e()
  {
    String str;
    if (this.d)
    {
      str = this.jdField_a_of_type_Bofh.a().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("http"))) {}
    }
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Bofh.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
      localIntent.putExtra("loc_play_show_material_id", str);
      localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", born.x.a());
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", born.C.a());
      this.jdField_a_of_type_Bofh.a().startActivityForResult(localIntent, 1025);
      this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Bowl.a().getValue();
    if ((localBoolean != null) && (!localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_Bowl.b().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_Bowl.c().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    int i = born.a(this.jdField_a_of_type_AndroidAppActivity.getIntent());
    if ((born.e(i)) || (born.h(i)) || (born.c(i)) || (born.b(i))) {
      return false;
    }
    if (bozz.a().a("sp_key_ae_comics_gif_tips", false, 0))
    {
      bpam.b("VideoStoryPiecesPart", "[ComicsTips]--has shown");
      return false;
    }
    return true;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379644));
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void h()
  {
    k();
    i();
  }
  
  private void i()
  {
    try
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369023));
      if (this.e)
      {
        j();
        b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void j()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378122);
    if (localViewStub != null) {
      localViewStub.setOnInflateListener(new bojz(this));
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new bokf(this));
    }
  }
  
  private void k()
  {
    l();
    if (this.e)
    {
      if (this.d)
      {
        this.jdField_b_of_type_JavaLangString = bozz.a().a("circle_camera_ad_icon_url", "", 4);
        this.jdField_c_of_type_JavaLangString = bozz.a().a("circle_camera_ad_schema", "", 4);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaLangString = bozz.a().a("camera_ad_icon_url", "", 4);
    this.jdField_c_of_type_JavaLangString = bozz.a().a("camera_ad_schema", "", 4);
  }
  
  private void l()
  {
    if (this.d)
    {
      this.e = bozz.a().a("circle_camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = bozz.a().a("circle_camera_ad_type", "", 4);
      bpam.b("VideoStoryPiecesPart", "isPresent: " + this.e + " type: " + this.jdField_a_of_type_JavaLangString);
      if (("h5".equals(this.jdField_a_of_type_JavaLangString)) || ("widget".equals(this.jdField_a_of_type_JavaLangString))) {
        break label146;
      }
      this.e = false;
    }
    label146:
    while (!a())
    {
      return;
      this.e = bozz.a().a("camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = bozz.a().a("camera_ad_type", "", 4);
      break;
    }
    this.e = "h5".equals(this.jdField_a_of_type_JavaLangString);
  }
  
  private void p()
  {
    bpam.b("VideoStoryPiecesPart", "content entry present.");
    if ((this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable() != null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if ((this.jdField_b_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      try
      {
        bpam.b("VideoStoryPiecesPart", "in url drawable set：" + this.jdField_b_of_type_JavaLangString);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2131167247);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2131167247);
        localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Exception localException)
      {
        bpam.d("VideoStoryPiecesPart", "url error url: " + this.jdField_b_of_type_JavaLangString);
        return;
      }
    }
    bpam.b("VideoStoryPiecesPart", "iconUrl is empty.");
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 0)) {
      bozr.a().O();
    }
  }
  
  private void r()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367136);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366837);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364134));
    if (((Long)abac.a().a("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout = ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364184));
    this.jdField_a_of_type_Boolean = ((String)abac.a().a("enable_click_take_picture", "1")).equals("1");
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("input_full_screen_mode", false);
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      if ((!born.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!born.i(this.jdField_a_of_type_AndroidAppActivity.getIntent()))) {
        break label205;
      }
      this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.setFunctionFlag(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("ability_flag", 2));
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.setMaxDuration(jdField_a_of_type_Int);
      return;
      label205:
      if (born.j(this.jdField_a_of_type_AndroidAppActivity.getIntent()))
      {
        this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.setFunctionFlag(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("ability_flag", 1));
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.setFunctionFlag(2);
      }
    }
    AEPituCameraCaptureButtonLayout localAEPituCameraCaptureButtonLayout = this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 3)
    {
      localAEPituCameraCaptureButtonLayout.setFunctionFlag(i);
      break;
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370344));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.3(this));
    if (c())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363962));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373117));
      if (!d()) {
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
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setPartManager(this.jdField_a_of_type_Bown);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setAECaptureController(this.jdField_a_of_type_Bofh.a());
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
      break;
      label181:
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131369028));
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
    }
    label209:
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView = ((CountDownView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362240)).inflate().findViewById(2131362241));
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.setCountDownListener(new bokg(this));
  }
  
  private void u()
  {
    this.jdField_a_of_type_Bosm = ((bosm)bofz.a(this.jdField_a_of_type_Bofh).get(bosm.class));
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class));
    this.jdField_a_of_type_Bowl = ((bowl)bofz.a(this.jdField_a_of_type_Bofh).get(bowl.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)bofz.a(this.jdField_a_of_type_Bofh).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_Bosm.b().observe(this.jdField_a_of_type_Bofh, new bokh(this));
    this.jdField_a_of_type_Bowk.a.observe(this.jdField_a_of_type_Bofh, new boki(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_Bofh, new bokj(this));
    if (this.d) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bofh, new bokl(this));
    }
    this.jdField_a_of_type_Bowl.a().observe(this.jdField_a_of_type_Bofh, new boka(this));
    this.jdField_a_of_type_Bowl.b().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_Bowl.c().postValue(Boolean.valueOf(false));
    ((bofy)bofz.a(this.jdField_a_of_type_Bofh).get(bofy.class)).a.observe(this.jdField_a_of_type_Bofh, new bokb(this));
    this.jdField_a_of_type_Bowl.b().observe(this.jdField_a_of_type_Bofh, new bokc(this));
    this.jdField_a_of_type_Bowl.c().observe(this.jdField_a_of_type_Bofh, new bokd(this));
  }
  
  private void v()
  {
    if (e()) {
      w();
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = new BubbleTextView(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(zps.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), zps.a(this.jdField_a_of_type_AndroidAppActivity, 11.0F), zps.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), zps.a(this.jdField_a_of_type_AndroidAppActivity, 11.0F));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(Color.parseColor("#03081A"));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = zps.a(this.jdField_a_of_type_AndroidAppActivity, 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131689683));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376769);
      if (localRelativeLayout != null)
      {
        ViewParent localViewParent = localRelativeLayout.getParent();
        if ((localViewParent instanceof RelativeLayout))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, 2131376769);
          localLayoutParams.bottomMargin = zps.a(this.jdField_a_of_type_AndroidAppActivity, -8.0F);
          ((RelativeLayout)localViewParent).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView, ((RelativeLayout)localViewParent).indexOfChild(localRelativeLayout), localLayoutParams);
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(new VideoStoryPiecesPart.14(this), 200L);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      y();
      bpam.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
      return;
    }
    Object localObject = (Boolean)this.jdField_a_of_type_Bowl.a().getValue();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      y();
      bpam.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
      return;
    }
    localObject = (boqw)this.jdField_a_of_type_Bosm.b().getValue();
    if ((localObject == null) || (((boqw)localObject).a == null))
    {
      y();
      bpam.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
      return;
    }
    localObject = (String)((boqw)localObject).a.additionalFields.get("gif_sponsor_name");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      y();
      bpam.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
      return;
    }
    a((String)localObject);
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void z()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.15(this), 64, null, true);
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296273);
  }
  
  protected void a()
  {
    this.d = born.j(this.jdField_a_of_type_AndroidAppActivity.getIntent());
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378107);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    r();
    s();
    u();
    e();
    h();
    f();
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
    label115:
    do
    {
      return;
      b();
      return;
      l();
      return;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label115;
        }
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(null, null, false);
        this.jdField_a_of_type_Bowl.b().postValue(Boolean.valueOf(true));
      }
      for (;;)
      {
        abbe.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
        return;
        if ((paramVarArgs[0] instanceof boqu))
        {
          paramVarArgs = (boqu)paramVarArgs[0];
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(paramVarArgs.jdField_b_of_type_JavaLangString, paramVarArgs.jdField_a_of_type_JavaLangString, true);
          this.jdField_a_of_type_Bowl.b().postValue(Boolean.valueOf(true));
        }
      }
      A();
      return;
      B();
      return;
    } while (this.jdField_a_of_type_Boom == null);
    this.jdField_a_of_type_Boom.h();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (!this.e)) {
      return;
    }
    if (paramBoolean)
    {
      b();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {
      i();
    }
    if (!this.e)
    {
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      bpam.a("VideoStoryPiecesPart", "hide camera content entry.");
      return;
    }
    if (born.h(this.jdField_c_of_type_Int))
    {
      p();
      return;
    }
    if (born.g(this.jdField_c_of_type_Int))
    {
      q();
      p();
      return;
    }
    if (a())
    {
      if ("h5".equals(bozz.a().a("camera_ad_type", "", 4)))
      {
        q();
        p();
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
  
  public void c()
  {
    super.c();
    z();
  }
  
  public void d()
  {
    super.d();
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
      bozr.a().Q();
      Object localObject2 = boqr.a();
      if (localObject2 != null)
      {
        Object localObject1 = new QQCircleFeedBase.StSimulateData();
        ((QQCircleFeedBase.StSimulateData)localObject1).material_id.set(((boqu)localObject2).jdField_a_of_type_JavaLangString);
        ((QQCircleFeedBase.StSimulateData)localObject1).simulate_name.set(((boqu)localObject2).i);
        ((QQCircleFeedBase.StSimulateData)localObject1).simulate_schema.set(brdx.a(((boqu)localObject2).jdField_a_of_type_JavaLangString, ""));
        localObject2 = new QCirclePolymerizationBean();
        ((QCirclePolymerizationBean)localObject2).setSimulateData((QQCircleFeedBase.StSimulateData)localObject1);
        ((QCirclePolymerizationBean)localObject2).setPolymerizationType(20);
        ((QCirclePolymerizationBean)localObject2).setExt1From(3);
        uyx.a(this.jdField_a_of_type_AndroidAppActivity, (QCirclePolymerizationBean)localObject2);
        continue;
        if (this.jdField_a_of_type_Bown != null)
        {
          this.jdField_a_of_type_Bown.a(786433, new Object[0]);
          continue;
          this.jdField_a_of_type_Bofh.u();
          abbe.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
          bozr.a().D();
          continue;
          if (this.d)
          {
            if (!bpak.a(paramView))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).setAction("ae_editor_bottom_tab_show_hide");
              ((Intent)localObject1).putExtra("is_show", false);
              this.jdField_a_of_type_Bofh.a().sendBroadcast((Intent)localObject1);
            }
          }
          else
          {
            if (this.jdField_a_of_type_Bown != null) {
              this.jdField_a_of_type_Bown.a(131076, new Object[0]);
            }
            abbe.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
            bozr.a().G();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojy
 * JD-Core Version:    0.7.0.1
 */