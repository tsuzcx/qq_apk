package com.tencent.aelight.camera.ae.camera.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AECameraConfig;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit.ViewStubHoldersViewModel;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class VideoStoryPiecesPart
  extends VideoStoryBasePart
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 20000;
  private static int jdField_b_of_type_Int = 4000;
  private static String h = "pendent_pag";
  private static final String i;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private AECameraGLSurfaceView jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView;
  private AEARCakePanel jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel;
  private AEMaterialPanel jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
  private AEWaterMarkPanel jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel;
  private BeautyAndFilterPanelViewStubHolder jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AEVideoStoryGIFTplViewModel jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel;
  private AECaptureMode jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel;
  private AECompoundButton jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
  private CountDownView jdField_a_of_type_ComTencentAelightCameraAeViewCountDownView;
  private AbsAECaptureButton jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AECompoundButton jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = AEThemeUtil.a();
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = false;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.CAMERA.FILES.jdField_g_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("pendent.pag");
    i = localStringBuilder.toString();
  }
  
  public VideoStoryPiecesPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    if (AECameraEntryManager.g(paramActivity.getIntent())) {
      jdField_a_of_type_Int = 20000;
    }
    this.jdField_c_of_type_Int = AECameraEntryManager.a(this.mActivity.getIntent());
  }
  
  private void A()
  {
    AEQLog.a("VideoStoryPiecesPart", "watermark openWaterMarkPanel");
    AEWaterMarkPanel localAEWaterMarkPanel = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel;
    if (localAEWaterMarkPanel == null) {
      return;
    }
    localAEWaterMarkPanel.setVisibility(0);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel.a();
    if (this.jdField_d_of_type_Boolean) {
      AEReportUtils.a(8, null);
    }
  }
  
  private void B()
  {
    BeautyAndFilterPanelViewStubHolder localBeautyAndFilterPanelViewStubHolder = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
    if (localBeautyAndFilterPanelViewStubHolder != null)
    {
      localBeautyAndFilterPanelViewStubHolder.b();
      this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.c().postValue(Boolean.valueOf(true));
    }
  }
  
  private void C()
  {
    int j = UIUtils.a(this.mActivity, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel, "translationY", new float[] { 0.0F, j });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new VideoStoryPiecesPart.18(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  public static AECircleCaptureStyle a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
      return AECircleCaptureStyle.a;
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
    {
      int j = AEPreviewSizeUtil.a();
      if (j == 2) {
        return AECircleCaptureStyle.c;
      }
      if (j == 1) {
        return AECircleCaptureStyle.d;
      }
      return AECircleCaptureStyle.b;
    }
    return AECircleCaptureStyle.b;
  }
  
  private void a(@NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton;
    if (localObject != null) {
      ((AbsAECaptureButton)localObject).a(true, paramAECircleCaptureStyle);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
    if (localObject != null) {
      ((AECompoundButton)localObject).setForegroundAndBackgroundResource(paramAECircleCaptureStyle.r, paramAECircleCaptureStyle.q);
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[GifAuthor]---showGifAuthor: author=");
    localStringBuilder.append(paramString);
    AEQLog.a("VideoStoryPiecesPart", localStringBuilder.toString());
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewStub)this.mRootView.findViewById(2064122653)).inflate());
      this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getY() - UIUtils.a(this.mActivity, 24.0F));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.mActivity.getString(2064515204, new Object[] { paramString }));
  }
  
  private boolean a()
  {
    return (AECameraEntryManager.c(this.jdField_c_of_type_Int)) || (AECameraEntryManager.b(this.jdField_c_of_type_Int)) || (AECameraEntryManager.a(this.jdField_c_of_type_Int)) || (AECameraEntryManager.d(this.jdField_c_of_type_Int));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((d()) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(0);
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(8);
    }
    if (this.jdField_e_of_type_Boolean)
    {
      String str = AECameraPrefsUtil.a().a("key_ae_arcake_preview", "", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arcake  arstatus ");
      localStringBuilder.append(str);
      AEQLog.a("VideoStoryPiecesPart", localStringBuilder.toString());
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if ("1".equals(str)) {
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(8);
      }
    }
  }
  
  private boolean b()
  {
    return AECameraPrefsUtil.a().a(this.jdField_g_of_type_JavaLangString, true, 4);
  }
  
  private void c()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      String str = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("http"))) {
        try
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a(), QQBrowserActivity.class);
          localIntent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
          localIntent.putExtra("loc_play_show_material_id", str);
          localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.x.a());
          localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.L.a());
          this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().startActivityForResult(localIntent, 1025);
          this.mActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_f_of_type_Boolean))
    {
      if (!this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.b()) {
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
  }
  
  private boolean c()
  {
    return (this.mActivity != null) && (!AECameraEntryManager.l(this.mActivity.getIntent())) && (!AECameraEntryManager.e(this.mActivity.getIntent())) && (!AECameraEntryManager.f(this.mActivity.getIntent())) && (!AECameraEntryManager.g(this.mActivity.getIntent())) && (!AECameraEntryManager.i(this.mActivity.getIntent())) && (!AECameraEntryManager.j(this.mActivity.getIntent())) && (!AECameraEntryManager.k(this.mActivity.getIntent())) && (this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().b());
  }
  
  private void d()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      AEARCakePanel localAEARCakePanel = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel;
      if (localAEARCakePanel == null) {
        return;
      }
      localAEARCakePanel.setMaterialSelectId();
    }
  }
  
  private boolean d()
  {
    return (this.mActivity != null) && (!AECameraEntryManager.i(this.mActivity.getIntent())) && (!AECameraEntryManager.j(this.mActivity.getIntent())) && (!AECameraEntry.I.a(AECameraEntryManager.a(this.mActivity.getIntent()))) && (this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().e());
  }
  
  private void e()
  {
    if (this.mRootView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mRootView.findViewById(2064122738));
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setOnClickListener(this);
    }
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode != AECaptureMode.NORMAL) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().getValue();
    if ((localBoolean != null) && (!localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.b().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.c().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    int j = AECameraEntryManager.a(this.mActivity.getIntent());
    if ((!AECameraEntryManager.d(j)) && (!AECameraEntryManager.g(j)) && (!AECameraEntryManager.b(j)))
    {
      if (AECameraEntryManager.a(j)) {
        return false;
      }
      if (AECameraPrefsUtil.a().a("sp_key_ae_comics_gif_tips", false, 0))
      {
        AEQLog.b("VideoStoryPiecesPart", "[ComicsTips]--has shown");
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void f()
  {
    i();
    g();
  }
  
  private void g()
  {
    try
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.mRootView.findViewById(2064122274));
      if (this.jdField_f_of_type_Boolean)
      {
        h();
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
  
  private void h()
  {
    Object localObject = (ViewStub)this.mRootView.findViewById(2064122663);
    if (localObject != null) {
      ((ViewStub)localObject).setOnInflateListener(new VideoStoryPiecesPart.1(this));
    }
    localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localObject != null) {
      ((URLImageView)localObject).setOnClickListener(new VideoStoryPiecesPart.2(this));
    }
  }
  
  private void i()
  {
    j();
    if (this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = AECameraPrefsUtil.a().a("circle_camera_ad_icon_url", "", 4);
        this.jdField_c_of_type_JavaLangString = AECameraPrefsUtil.a().a("circle_camera_ad_schema", "", 4);
        return;
      }
      this.jdField_b_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_icon_url", "", 4);
      this.jdField_c_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_schema", "", 4);
    }
  }
  
  private void j()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = AECameraPrefsUtil.a().a("circle_camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = AECameraPrefsUtil.a().a("circle_camera_ad_type", "", 4);
    }
    else
    {
      this.jdField_f_of_type_Boolean = AECameraPrefsUtil.a().a("camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_type", "", 4);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isPresent: ");
    localStringBuilder.append(this.jdField_f_of_type_Boolean);
    localStringBuilder.append(" type: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    AEQLog.b("VideoStoryPiecesPart", localStringBuilder.toString());
    if ((!"h5".equals(this.jdField_a_of_type_JavaLangString)) && (!"widget".equals(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_f_of_type_Boolean = false;
      return;
    }
    if (a()) {
      this.jdField_f_of_type_Boolean = "h5".equals(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void k()
  {
    AEQLog.b("VideoStoryPiecesPart", "content entry present.");
    if ((this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable() != null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    Object localObject = this.jdField_b_of_type_JavaLangString;
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("in url drawable set：");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      AEQLog.b("VideoStoryPiecesPart", ((StringBuilder)localObject).toString());
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mActivity.getResources().getDrawable(2131167333);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mActivity.getResources().getDrawable(2131167333);
      localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception localException)
    {
      label143:
      break label143;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("url error url: ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    AEQLog.d("VideoStoryPiecesPart", ((StringBuilder)localObject).toString());
    return;
    AEQLog.b("VideoStoryPiecesPart", "iconUrl is empty.");
  }
  
  private void l()
  {
    URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    if ((localURLImageView != null) && (localURLImageView.getVisibility() != 0)) {
      AEBaseDataReporter.a().V();
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2064122228);
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2064122220);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2064122016));
    if (((Long)VSConfigManager.a().a("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton = ((AbsAECaptureButton)this.mRootView.findViewById(2064122025));
    this.jdField_a_of_type_Boolean = ((String)VSConfigManager.a().a("enable_click_take_picture", "1")).equals("1");
    this.jdField_b_of_type_Boolean = this.mActivity.getIntent().getBooleanExtra("input_full_screen_mode", false);
    b();
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.setMaxDuration(a(AECaptureMode.NORMAL));
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel = ((AEWaterMarkPanel)this.mRootView.findViewById(2064122520));
    AEWaterMarkPanel localAEWaterMarkPanel = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel;
    if (localAEWaterMarkPanel == null) {
      return;
    }
    localAEWaterMarkPanel.setCaptureController(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel.setPartManager(this.mPartManager);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.mRootView.findViewById(2064122376));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.3(this));
    if (c())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2064121999));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.mRootView.findViewById(2064122519));
    p();
    if (d())
    {
      if (this.jdField_e_of_type_Boolean)
      {
        localObject = AEGiftMaterialConfigParser.a();
        if ((localObject != null) && (((List)localObject).size() <= 1))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.a().setImageResource(2064056328);
        }
        else
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.a().setImageResource(2064056328);
          localObject = ((List)localObject).iterator();
          AEARCakeMaterial localAEARCakeMaterial;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAEARCakeMaterial = ((AEGiftMaterial)((Iterator)localObject).next()).a();
          } while ((localAEARCakeMaterial == null) || (localAEARCakeMaterial.jdField_e_of_type_Boolean));
          this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.a().setImageResource(2064056331);
        }
      }
      else if (!this.jdField_d_of_type_Boolean)
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.post(new VideoStoryPiecesPart.4(this, (String)localObject));
      }
      else
      {
        this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2064122281));
        this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton.setOnClickListener(this);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel = ((AEARCakePanel)this.mRootView.findViewById(2064122518));
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel;
      if (localObject != null)
      {
        ((AEARCakePanel)localObject).setCaptureController(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a());
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel.setPartManager(this.mPartManager);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel.setPartManager(this.mPartManager);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel.setCaptureController(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a());
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel.setVisibility(8);
  }
  
  private void p()
  {
    this.jdField_g_of_type_Boolean = AECameraPrefsUtil.a().a("camera_ad_pendent_show", false, 4);
    this.jdField_d_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_pendent_icon_url", "", 4);
    this.jdField_f_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_pendent_icon_type", "", 4);
    this.jdField_d_of_type_Int = AECameraPrefsUtil.a().a("camera_ad_pendent_categoryId", -1, 4);
    this.jdField_g_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_pendent_op_id", "", 4);
    this.jdField_e_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_pendent_schema", "", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("entry dynamics: icon type ");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append(" url:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" type :");
    localStringBuilder.append(this.jdField_g_of_type_Boolean);
    localStringBuilder.append(" category id: ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" OPID: ");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append(" scheme: ");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    AEQLog.a("VideoStoryPiecesPart", localStringBuilder.toString());
  }
  
  private void q()
  {
    if (FileUtils.fileExistsAndNotEmpty(i))
    {
      AEQLog.a("VideoStoryPiecesPart", "entry dynamics: not download ");
      r();
      return;
    }
    AEMaterialManager localAEMaterialManager = (AEMaterialManager)AEQIMManager.a(1);
    AEMaterialMetaData localAEMaterialMetaData = new AEMaterialMetaData();
    localAEMaterialMetaData.n = this.jdField_d_of_type_JavaLangString;
    localAEMaterialMetaData.p = "pendent.pag";
    localAEMaterialMetaData.k = h;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), AEPath.CAMERA.FILES.jdField_g_of_type_JavaLangString, localAEMaterialMetaData, new VideoStoryPiecesPart.5(this));
  }
  
  private void r()
  {
    if (!FeatureManager.Features.PAG.init())
    {
      AEQLog.d("VideoStoryPiecesPart", "entry dynamics: pag not init");
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.a().setImageResource(2064056405);
      return;
    }
    PAGFile localPAGFile = PAGFile.Load(i);
    this.jdField_a_of_type_OrgLibpagPAGView = new PAGView(BaseApplication.getContext());
    this.jdField_a_of_type_OrgLibpagPAGView.addPAGFlushListener(new VideoStoryPiecesPart.6(this));
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.addView(this.jdField_a_of_type_OrgLibpagPAGView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.a().setImageDrawable(this.mActivity.getResources().getDrawable(2131167333));
    localObject = this.jdField_a_of_type_OrgLibpagPAGView;
    if ((localObject != null) && (localPAGFile != null))
    {
      ((PAGView)localObject).setFile(localPAGFile);
      this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(0);
      if (!this.jdField_a_of_type_OrgLibpagPAGView.isPlaying())
      {
        AEQLog.d("VideoStoryPiecesPart", "entry dynamics: pag  play");
        this.jdField_a_of_type_OrgLibpagPAGView.play();
      }
    }
  }
  
  private void s()
  {
    if ("pag".equals(this.jdField_f_of_type_JavaLangString))
    {
      q();
    }
    else if ("static".equals(this.jdField_f_of_type_JavaLangString))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mActivity.getResources().getDrawable(2131167333);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mActivity.getResources().getDrawable(2131167333);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.getLayoutParams().height;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = true;
      localObject = URLDrawable.getDrawable(this.jdField_d_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.a().setImageDrawable((Drawable)localObject);
    }
    AEBaseDataReporter.a().h(this.jdField_e_of_type_JavaLangString);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeViewCountDownView = ((CountDownView)((ViewStub)this.mRootView.findViewById(2064121870)).inflate().findViewById(2064121872));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewCountDownView.setCountDownListener(new VideoStoryPiecesPart.7(this));
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel = ((AEVideoStoryGIFTplViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryGIFTplViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel.b().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryPiecesPart.8(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryPiecesPart.9(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryPiecesPart.10(this));
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryPiecesPart.11(this));
    }
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryPiecesPart.12(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.b().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.c().postValue(Boolean.valueOf(false));
    ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEPituCameraUnit.ViewStubHoldersViewModel.class)).a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryPiecesPart.13(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.b().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryPiecesPart.14(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.c().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryPiecesPart.15(this));
  }
  
  private void v()
  {
    if (e())
    {
      w();
      return;
    }
    BubbleTextView localBubbleTextView = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
    if (localBubbleTextView != null)
    {
      localBubbleTextView.clearAnimation();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = new BubbleTextView(this.mActivity);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F), UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(Color.parseColor("#03081A"));
      Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
      ((BubbleTextView)localObject1).jdField_a_of_type_Int = -1;
      ((BubbleTextView)localObject1).b = UIUtils.a(this.mActivity, 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(this.mActivity.getString(2064515103));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
      localObject1 = (RelativeLayout)this.mRootView.findViewById(2064122567);
      if (localObject1 != null)
      {
        Object localObject2 = ((RelativeLayout)localObject1).getParent();
        if ((localObject2 instanceof RelativeLayout))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, 2064122567);
          localLayoutParams.bottomMargin = UIUtils.a(this.mActivity, -8.0F);
          localObject2 = (RelativeLayout)localObject2;
          ((RelativeLayout)localObject2).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView, ((RelativeLayout)localObject2).indexOfChild((View)localObject1), localLayoutParams);
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(new VideoStoryPiecesPart.16(this), 200L);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode != AECaptureMode.GIF)
    {
      y();
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
      return;
    }
    Object localObject = (Boolean)this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().getValue();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      y();
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
      return;
    }
    localObject = (AEMaterialWrapper)this.jdField_a_of_type_ComTencentAelightCameraAeGifAEVideoStoryGIFTplViewModel.b().getValue();
    if ((localObject != null) && (((AEMaterialWrapper)localObject).a != null))
    {
      localObject = (String)((AEMaterialWrapper)localObject).a.additionalFields.get("gif_sponsor_name");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        y();
        AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
        return;
      }
      a((String)localObject);
      return;
    }
    y();
    AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
  }
  
  private void y()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void z()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.17(this), 64, null, true);
  }
  
  protected int a()
  {
    return this.mActivity.getResources().getDimensionPixelSize(2063990791);
  }
  
  protected int a(AECaptureMode paramAECaptureMode)
  {
    AEPituCameraUnit localAEPituCameraUnit = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
    if ((localAEPituCameraUnit != null) && (localAEPituCameraUnit.b().k() != -1)) {
      return this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().k();
    }
    if (paramAECaptureMode == AECaptureMode.GIF) {
      return jdField_b_of_type_Int;
    }
    return jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {
      g();
    }
    if (!this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      AEQLog.a("VideoStoryPiecesPart", "hide camera content entry.");
      return;
    }
    if (AECameraEntryManager.g(this.jdField_c_of_type_Int))
    {
      k();
      return;
    }
    if (AECameraEntryManager.f(this.jdField_c_of_type_Int))
    {
      l();
      k();
      return;
    }
    if (a())
    {
      if ("h5".equals(AECameraPrefsUtil.a().a("camera_ad_type", "", 4)))
      {
        l();
        k();
        return;
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      this.jdField_f_of_type_Boolean = false;
      return;
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localURLImageView != null)
    {
      if (!this.jdField_f_of_type_Boolean) {
        return;
      }
      if (paramBoolean)
      {
        a();
        return;
      }
      localURLImageView.setVisibility(8);
    }
  }
  
  protected void b()
  {
    if (this.mActivity != null) {
      if ((!AECameraEntryManager.i(this.mActivity.getIntent())) && (!AECameraEntryManager.j(this.mActivity.getIntent())))
      {
        boolean bool = AECameraEntryManager.k(this.mActivity.getIntent());
        int j = 1;
        if (bool)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 1));
        }
        else if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.setFunctionFlag(2);
        }
        else
        {
          AbsAECaptureButton localAbsAECaptureButton = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton;
          if (!this.jdField_a_of_type_Boolean) {
            j = 3;
          }
          localAbsAECaptureButton.setFunctionFlag(j);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 2));
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.setFunctionFlag(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().b());
  }
  
  protected void initView()
  {
    this.jdField_d_of_type_Boolean = AECameraEntryManager.k(this.mActivity.getIntent());
    this.jdField_e_of_type_Boolean = AECameraEntryManager.l(this.mActivity.getIntent());
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2064122646);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    m();
    o();
    n();
    u();
    c();
    f();
    e();
    d();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    CountDownView localCountDownView = this.jdField_a_of_type_ComTencentAelightCameraAeViewCountDownView;
    if (localCountDownView != null) {
      localCountDownView.a();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramInt1 == 10023) || (paramInt1 == 10006)) && (paramInt2 == -1))
    {
      AEMaterialPanel localAEMaterialPanel = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
      if (localAEMaterialPanel != null) {
        localAEMaterialPanel.a(paramInt1, paramInt2, paramIntent);
      } else if (QLog.isColorLevel()) {
        QLog.d("VideoStoryPiecesPart", 2, "onActivityResult() mPtvContainerView null!!!");
      }
      if (this.mActivity != null) {
        this.mActivity.finish();
      }
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    z();
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    AEMaterialMetaData localAEMaterialMetaData = null;
    Object localObject;
    switch (j)
    {
    default: 
    case 2064122738: 
      AEBaseDataReporter.a().X();
      localAEMaterialMetaData = AEMaterialManager.a();
      if (localAEMaterialMetaData != null)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("sourcetype", String.valueOf(20));
        ((HashMap)localObject).put("filterid", localAEMaterialMetaData.k);
        ((HashMap)localObject).put("filtername", localAEMaterialMetaData.s);
        ((HashMap)localObject).put("ext1from", "3");
        QCircleUtils.a().enterBySchemeAction(paramView.getContext(), "openpolymerize", (HashMap)localObject);
        return;
      }
      break;
    case 2064122376: 
      this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.U();
      VSReporter.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
      AEBaseDataReporter.a().K();
      return;
    case 2064122281: 
      if (this.mPartManager != null) {
        this.mPartManager.a(786433, new Object[0]);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        localObject = AEMaterialManager.a();
        paramView = localAEMaterialMetaData;
        if (localObject != null)
        {
          paramView = new HashMap();
          paramView.put("ext2", ((AEMaterialMetaData)localObject).k);
        }
        AEReportUtils.c(2, paramView);
        return;
      }
      break;
    case 2064121999: 
      if (this.jdField_d_of_type_Boolean)
      {
        if (AEFastClickThrottle.a(paramView)) {
          return;
        }
        paramView = new Intent();
        paramView.setAction("ae_editor_bottom_tab_show_hide");
        paramView.putExtra("is_show", false);
        this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().sendBroadcast(paramView);
        AEReportUtils.b(4, null);
      }
      if ((AECameraEntryManager.f(this.jdField_c_of_type_Int)) && (this.jdField_g_of_type_Boolean) && (b()))
      {
        AEQLog.a("VideoStoryPiecesPart", "entry dynamics: need jump from ad pendent");
        this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_JavaLangString);
        this.jdField_g_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.a().setImageResource(2064056405);
        paramView = this.jdField_a_of_type_OrgLibpagPAGView;
        if ((paramView != null) && (paramView.isPlaying()))
        {
          this.jdField_a_of_type_OrgLibpagPAGView.stop();
          this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.removeView(this.jdField_a_of_type_OrgLibpagPAGView);
        }
        AECameraPrefsUtil.a().a(this.jdField_g_of_type_JavaLangString, false, 4);
        if (FileUtils.fileExistsAndNotEmpty(i)) {
          FileUtils.deleteFile(i);
        }
        AEBaseDataReporter.a().i(this.jdField_e_of_type_JavaLangString);
      }
      else if (this.mPartManager != null)
      {
        this.mPartManager.a(131076, new Object[0]);
      }
      VSReporter.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
      if (this.jdField_e_of_type_Boolean) {
        AEBaseDataReporter.a().j();
      }
      AEBaseDataReporter.a().N();
      return;
    case 2064121991: 
      if (this.mPartManager != null) {
        this.mPartManager.a(786436, new Object[0]);
      }
      break;
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
      case 327699: 
        AEQLog.a("VideoStoryPiecesPart", "PIECES_SEND_ACTION_ARCAKE_RED_DOT_SHOW");
        if (paramVarArgs != null)
        {
          if (paramVarArgs.length == 0) {
            return;
          }
          if (!this.jdField_e_of_type_Boolean) {
            return;
          }
          boolean bool = ((Boolean)paramVarArgs[0]).booleanValue();
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("arcake : isShow");
          paramVarArgs.append(bool);
          AEQLog.a("VideoStoryPiecesPart", paramVarArgs.toString());
          if (bool)
          {
            this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.a().setImageResource(2064056331);
            return;
          }
          this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.a().setImageResource(2064056328);
          return;
        }
        return;
      case 327698: 
        AEQLog.b("VideoStoryPiecesPart", "PIECES_SEND_ACTION_ARCAKE_START_UP_ANIM");
        if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel != null)
        {
          AEQLog.a("VideoStoryPiecesPart", "doOpenProviderView");
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel.a();
          return;
        }
        break;
      case 327697: 
        A();
        return;
      }
      break;
    case 327688: 
      j();
      return;
    case 327687: 
      a();
      return;
    case 327686: 
      C();
      return;
    case 327685: 
      paramVarArgs = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
      if (paramVarArgs != null)
      {
        paramVarArgs.h();
        return;
      }
      break;
    case 327684: 
      B();
      return;
    case 327683: 
      AEMaterialPanel localAEMaterialPanel = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
      if (localAEMaterialPanel != null) {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0))
        {
          if ((paramVarArgs[0] instanceof AEMaterialMetaData))
          {
            paramVarArgs = (AEMaterialMetaData)paramVarArgs[0];
            localAEMaterialPanel.setVisibility(0);
            this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel.a(paramVarArgs.l, paramVarArgs.k, true);
            this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.b().postValue(Boolean.valueOf(true));
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel.setVisibility(0);
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel.a(null, null, false);
          this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.b().postValue(Boolean.valueOf(true));
        }
      }
      VSReporter.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart
 * JD-Core Version:    0.7.0.1
 */