package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.api.motivevideo.webbottomcard.GdtMVWebBottomCardController;
import com.tencent.gdtad.jsbridge.GdtAdPluginFactory;
import com.tencent.gdtad.jsbridge.GdtMvWebJsCallHandler;
import com.tencent.gdtad.jsbridge.GdtOpenMvPageHandler;
import com.tencent.gdtad.statistics.GdtImpressionPolicy;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam.ReportCallback;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoReportListenerImp;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.video.CmGameGdtVideoPlayer;
import com.tencent.mobileqq.apollo.process.video.ICmGameVideoCallback;
import com.tencent.mobileqq.apollo.process.video.ICmGameVideoPlayer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class GdtMvViewController
  implements Handler.Callback, View.OnClickListener, GdtMvTitleHelper.MvTitleListener, ICmGameVideoCallback
{
  public int a;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AdExposureChecker.ExposureCallback jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
  private AdExposureChecker jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker;
  private GdtMVCellingStyleController jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController;
  private GdtMVEndcardWebController jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController;
  private GdtMotiveVideoModel jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel;
  private GdtMvElementsController jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController;
  public final GdtMvMiniAppReportHelper a;
  public final GdtMvTitleHelper a;
  private GdtMvViewController.SilentModeReceiver jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController$SilentModeReceiver;
  private IMotiveVideoView jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView;
  private VolumeChangeObserver jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver;
  private GdtMVWebBottomCardController jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController;
  private final GdtImpressionReporter.GdtVideoReportInfo jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo = new GdtImpressionReporter.GdtVideoReportInfo();
  private GdtVideoReportListenerImp jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
  private ICmGameVideoPlayer jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 15L;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = true;
  private boolean l;
  private boolean m = true;
  private boolean n = true;
  
  public GdtMvViewController(IMotiveVideoView paramIMotiveVideoView, GdtMotiveVideoModel paramGdtMotiveVideoModel, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper = new GdtMvTitleHelper();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper = new GdtMvMiniAppReportHelper();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView = paramIMotiveVideoView;
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel = paramGdtMotiveVideoModel;
    this.l = paramBoolean;
    paramIMotiveVideoView = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    paramIMotiveVideoView.style = 0;
    paramBoolean = bool;
    if (paramIMotiveVideoView.screenOrientation == 1) {
      paramBoolean = true;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    int i1 = paramIMotiveVideoView.getVideoCountDown();
    this.jdField_b_of_type_Long = i1;
    this.jdField_a_of_type_JavaLangString = paramIMotiveVideoView.getRewardText();
    paramBoolean = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().exp_info.video_countdown_style.has();
    QLog.i("GdtMvViewController", 1, "GdtMvViewController: video_countdown = " + i1 + ", video_countdown_style has = " + paramBoolean + ", rewardText = " + this.jdField_a_of_type_JavaLangString);
  }
  
  private void A()
  {
    if (QQVideoPlaySDKManager.a())
    {
      z();
      return;
    }
    B();
  }
  
  private void B()
  {
    try
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "installSDK");
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getApplication(), new GdtMvViewController.6(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoGdtGdtMvViewController", 1, "installSDK", localThrowable);
    }
  }
  
  private void C()
  {
    QLog.i("GdtMvViewController", 1, "[doPauseAction] mIsVideoPlayCompleted:" + this.f);
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    c(false);
    if ((!this.f) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null))
    {
      this.h = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b();
      if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp != null) && (localGdtVideoData != null)) {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp.b(localGdtVideoData, this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b(), this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
      }
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController.c();
    }
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null)) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer));
    }
  }
  
  private void D()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a();
    int i4 = this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b();
    int i1;
    if (this.jdField_b_of_type_Boolean)
    {
      i1 = GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext);
      label88:
      if (!this.jdField_b_of_type_Boolean) {
        break label321;
      }
    }
    label321:
    for (int i2 = GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext);; i2 = GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] mVideoSize " + this.jdField_b_of_type_Boolean + " vW-" + i3 + " vH-" + i4 + " sW-" + i1 + " sH-" + i2);
      if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController != null) {
        break;
      }
      if ((this.jdField_b_of_type_Boolean) && (localGdtMotiveVideoPageData.vSize != 585))
      {
        i3 = (int)(1.0F * i1 * i4 / i3);
        i2 = (int)(i2 * 150.0F / 1334.0F);
        localLayoutParams.height = i3;
        localLayoutParams.width = i1;
        localLayoutParams.topMargin = i2;
        QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] newHeight " + i3 + " newWidth-" + i1 + " newTop-" + i2);
      }
      a(1020034L);
      a(1020008L, new GdtMvViewController.9(this));
      return;
      i1 = GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext);
      break label88;
    }
  }
  
  private void E()
  {
    if (this.l)
    {
      h();
      j();
    }
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController.b();
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new GdtMvViewController.11(this));
    }
  }
  
  private void a(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long < 800L) {}
    while ((paramInt == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController.a(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    QLog.i("GdtMvViewController", 1, "setVoiceIconState volume =" + paramInt + " mVideoPlayer " + this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer + " isFromVolumeChanged = " + paramBoolean2 + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", viewResumed = " + paramBoolean1 + ", mIsVideoPlayCompleted = " + this.f);
    if ((!paramBoolean1) || (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer == null)) {}
    do
    {
      return;
      x();
    } while (this.f);
    if (!this.jdField_a_of_type_Boolean) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      c(paramBoolean1);
      return;
    }
  }
  
  private void a(long paramLong)
  {
    GdtADFlyingStreamingReportHelper.a().a(paramLong);
  }
  
  private void a(long paramLong, GdtReportForAntiSpam.ReportCallback paramReportCallback)
  {
    GdtADFlyingStreamingReportHelper.a().a(paramLong, paramReportCallback);
  }
  
  private void a(View paramView)
  {
    QLog.d("GdtMvViewController", 1, new Object[] { "initExpoReport isFirst=", Boolean.valueOf(this.n) });
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    if ((this.n) && (paramView != null))
    {
      this.n = false;
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker = new AdExposureChecker(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a(), new WeakReference(paramView));
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new GdtMvViewController.10(this);
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.startCheck();
      paramView = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer == null) {
        break label141;
      }
    }
    label141:
    for (long l1 = this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b();; l1 = 0L)
    {
      paramView.a(l1);
      return;
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    GdtOpenMvPageHandler localGdtOpenMvPageHandler = (GdtOpenMvPageHandler)GdtAdPluginFactory.a().a(16);
    if (localGdtOpenMvPageHandler != null) {
      localGdtOpenMvPageHandler.a(paramGdtMotiveVideoPageData, paramString1, paramString2, paramString3);
    }
  }
  
  private View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
        if (d()) {
          return c(paramLayoutInflater, paramViewGroup);
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (localGdtMotiveVideoPageData.vSize == 585)
          {
            this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559312, paramViewGroup, false);
            if (this.jdField_a_of_type_AndroidViewView != null) {
              break;
            }
            return null;
          }
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559311, paramViewGroup, false);
          continue;
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559310, paramViewGroup, false);
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.e("GdtMvViewController", 1, " viewcontr initViews error", paramLayoutInflater);
        return null;
      }
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController = new GdtMvElementsController(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController.a(this.jdField_b_of_type_Boolean);
    GdtUIUtils.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131372298));
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362127));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381389));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  private View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559314, paramViewGroup, false);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return null;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController = new GdtMVCellingStyleController(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView.a(), this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.a(this.jdField_b_of_type_Boolean);
    GdtUIUtils.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131372298));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362127));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381389));
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      if (paramBoolean)
      {
        QLog.i("GdtMvViewController", 1, "[requestSystemAudioFocus] gain is called!");
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
      }
    }
    else {
      return;
    }
    QLog.i("GdtMvViewController", 1, "[requestSystemAudioFocus] release is called!");
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController != null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController.c();
    }
  }
  
  private boolean d()
  {
    for (;;)
    {
      int i1;
      boolean bool1;
      try
      {
        if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() == null))
        {
          QLog.i("GdtMvViewController", 1, "isCellingStyle null");
          return false;
        }
        bool2 = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().isMvCellingStyle();
        bool3 = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().isXiJinDestType();
        i2 = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().vSize;
        if (i2 == 585) {
          break label201;
        }
        if (i2 != 185) {
          break label191;
        }
      }
      catch (Exception localException)
      {
        boolean bool2;
        boolean bool3;
        int i2;
        QLog.i("GdtMvViewController", 1, "isCellingStyle", localException);
        return false;
      }
      if ((this.jdField_b_of_type_Boolean) && (bool2) && (bool3) && (i1 != 0))
      {
        bool1 = true;
        QLog.i("GdtMvViewController", 1, "isCellingStyle" + " result=" + bool1 + ",isMvCellingStyle=" + bool2 + ",isXiJinDestType=" + bool3 + ",vSize=" + i2);
        return bool1;
        label191:
        i1 = 0;
      }
      else
      {
        bool1 = false;
        continue;
        label201:
        i1 = 1;
      }
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a() == null) || (!this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().isValid()))
    {
      QLog.e("GdtMvViewController", 1, "doAdPreload error");
      return;
    }
    GdtAd localGdtAd = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    GdtPreLoader.a().a(localGdtAd);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      if (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 2) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      this.j = bool;
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController$SilentModeReceiver = new GdtMvViewController.SilentModeReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController$SilentModeReceiver, localIntentFilter);
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver = new VolumeChangeObserver(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver.a();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver.a(new GdtMvViewController.1(this));
      return;
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController != null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController != null))
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp = new GdtVideoReportListenerImp(11);
      return;
    }
    QLog.i("GdtMvViewController", 1, " initReports error");
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController = new GdtMVEndcardWebController();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView.a(), this.jdField_b_of_type_Boolean);
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController = new GdtMVWebBottomCardController(new GdtMvViewController.2(this), this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler);
    boolean bool = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView.a(), this.jdField_b_of_type_Boolean);
    QLog.i("GdtMvViewController", 1, "web bottom card result:" + bool);
    if (bool)
    {
      t();
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.f();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController = null;
    s();
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper.a(0);
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.a();
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper.a(4);
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.b();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.g();
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, null, "", HardCodeUtil.a(2131705235), HardCodeUtil.a(2131705232), new GdtMvViewController.3(this), new GdtMvViewController.4(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new GdtMvViewController.5(this));
  }
  
  private void v()
  {
    boolean bool1 = true;
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    boolean bool2 = localAdInfo.exp_info.video_volume.has();
    int i1 = localAdInfo.exp_info.video_volume.get();
    QLog.i("GdtMvViewController", 1, "[initMute] videoVolume = " + i1 + ",isHasVideoVolume = " + bool2);
    if ((bool2) && (i1 == 0)) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      return;
      bool1 = false;
    }
  }
  
  private void w()
  {
    if (this.j)
    {
      QLog.i("GdtMvViewController", 1, "refreshVoiceIconDrawable isSilentMode is true");
      this.jdField_a_of_type_Boolean = true;
    }
    x();
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_Boolean);
  }
  
  private void y()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130851162);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130851162);
    localObject = URLDrawable.getDrawable(((GdtMotiveVideoPageData)localObject).previewImgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.n);
    ((URLDrawable)localObject).setTag(new int[] { 50 });
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void z()
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "initVideoView");
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo.a(11);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer = new CmGameGdtVideoPlayer();
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(this.jdField_a_of_type_AndroidViewView.getContext(), CmGameUtil.a());
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(this, 100L);
    View localView = this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a();
    if ((localView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "[setViewStatus], videoView is null." + this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(localGdtMotiveVideoPageData.url, "sd", 0);
  }
  
  long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null)
    {
      if (this.f) {
        return this.jdField_a_of_type_Long;
      }
      return this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b();
    }
    return 0L;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    v();
    paramLayoutInflater = b(paramLayoutInflater, paramViewGroup);
    if (paramLayoutInflater == null)
    {
      QLog.i("GdtMvViewController", 1, "GdtMvViewController init:rootView==null error");
      return null;
    }
    this.jdField_a_of_type_AndroidContentContext = paramLayoutInflater.getContext();
    QLog.i("GdtMvViewController", 1, "GdtMvViewController: init = " + this.l + ", mContext = " + this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!this.l)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
    }
    n();
    o();
    w();
    a();
    y();
    A();
    F();
    u();
    p();
    q();
    r();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel);
    GdtADFlyingStreamingReportHelper.a().a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel);
    a(1020033L);
    a(1020006L);
    if (this.m)
    {
      GdtOriginalExposureReporter.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a(), this.jdField_a_of_type_AndroidContentContext);
      this.m = false;
    }
    return paramLayoutInflater;
  }
  
  public IMotiveVideoView a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView;
  }
  
  public GdtImpressionReporter.GdtVideoReportInfo a()
  {
    return this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper.a(this.jdField_a_of_type_AndroidViewView, this, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper);
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView.a(), this.jdField_b_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView.a(), this.jdField_b_of_type_Boolean);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.i("GdtMvViewController", 1, "[onVideoError], module:" + paramInt1 + ",errorType:" + paramInt2 + ",errorCode:" + paramInt3 + ",msg:" + paramString);
    paramString = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp != null) && (paramString != null))
    {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo.a(paramInt2, paramInt3);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp.a(paramString, this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b(), this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
    }
    a(1020009L);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new GdtMvViewController.8(this, paramLong1, paramLong2));
    }
    while (this.f) {
      return;
    }
    boolean bool;
    label60:
    long l3;
    if (paramLong2 < this.jdField_b_of_type_Long * 1000L)
    {
      bool = true;
      this.g = bool;
      l3 = paramLong2 - paramLong1;
      if (!this.g) {
        break label335;
      }
    }
    label335:
    for (paramLong2 = paramLong1;; paramLong2 = this.jdField_b_of_type_Long * 1000L - l3)
    {
      long l2 = paramLong2 / 1000L + 1L;
      long l1 = l2;
      if (l2 > this.jdField_b_of_type_Long) {
        l1 = this.jdField_b_of_type_Long;
      }
      b(paramLong2, l1);
      a(l3 / 1000L, this.f);
      if (paramLong2 <= 0L) {
        this.jdField_c_of_type_Boolean = true;
      }
      if (l3 / 1000L == 2L) {
        d(true);
      }
      if (paramLong1 / 1000L == 3L) {
        d(false);
      }
      if ((!this.h) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null) && (localGdtVideoData != null))
      {
        this.h = true;
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp.a(localGdtVideoData, this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b());
      }
      if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null)) {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a() - this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b());
      }
      if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer));
      return;
      bool = false;
      break label60;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper.a(paramLong, paramBoolean);
  }
  
  public void a(String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    QLog.i("GdtMvViewController", 1, "GDT beforeFinish call stack:", new Throwable());
    Intent localIntent = new Intent();
    localIntent.putExtra("duration_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("profitable_flag", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("is_end", this.f);
    if (this.f)
    {
      a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
      QLog.i("GdtMvViewController", 1, "true[beforeFinish] " + this.jdField_a_of_type_Long + " /" + this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("arg_callback", paramString);
      }
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView.a(-1, localIntent);
      E();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null)
      {
        localIntent.putExtra("elapsed_time", this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b());
        a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
        QLog.i("GdtMvViewController", 1, this.jdField_c_of_type_Boolean + "[beforeFinish] " + this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b() + " /" + this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("GdtMvViewController", 1, " onClick close_ads");
    if (!a(true))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper.a(4, a());
      }
      if (GdtADFlyingStreamingReportHelper.a().a() == 2) {
        GdtADFlyingStreamingReportHelper.a().a(1020016L);
      }
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView.a();
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper.a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    QLog.i("GdtMvViewController", 1, "[onBackEvent] mHasWatchAds " + this.jdField_c_of_type_Boolean);
    if (!paramBoolean)
    {
      paramBoolean = bool;
      return paramBoolean;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_c_of_type_Boolean)
        {
          paramBoolean = false;
          break;
        }
        b();
        paramBoolean = bool;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          break;
        }
        paramBoolean = bool;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
          break;
        }
        QLog.i("GdtMvViewController", 1, "showDialog mVideoDuration " + this.jdField_a_of_type_Long + " mShotSeconds " + this.jdField_b_of_type_Long + " mRewardText " + this.jdField_a_of_type_JavaLangString);
        Object localObject = new StringBuffer(HardCodeUtil.a(2131692905));
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          ((StringBuffer)localObject).append(HardCodeUtil.a(2131692901));
          QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long * 1000L) {
            break label309;
          }
          localObject = HardCodeUtil.a(2131705230) + this.jdField_b_of_type_Long + ((StringBuffer)localObject).toString();
          localQQCustomDialog.setMessage((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow();
          paramBoolean = bool;
          if (localObject == null) {
            break;
          }
          ((Window)localObject).getDecorView().setSystemUiVisibility(7942);
          paramBoolean = bool;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GdtMvViewController", 1, "show dialog err, errInfo->" + localThrowable.getMessage());
        return false;
      }
      localThrowable.append(this.jdField_a_of_type_JavaLangString);
      continue;
      label309:
      String str = HardCodeUtil.a(2131705231);
    }
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.d()))
    {
      this.d = true;
      C();
    }
    a(1020010L);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper.a(paramLong1, paramLong2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer == null) {
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper.a(7, a());
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a();
    if (!bool)
    {
      paramBoolean = true;
      this.jdField_a_of_type_Boolean = paramBoolean;
      QLog.i("GdtMvViewController", 1, "audioSwitch click is called isSilentMode = " + this.j + ", isMute = " + bool);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean) {
        break label120;
      }
    }
    label120:
    for (int i1 = 0;; i1 = 1)
    {
      a(i1, true, false);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  boolean b()
  {
    return this.f;
  }
  
  public void c()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoPrepared]");
    if (!this.e)
    {
      this.e = true;
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        QLog.i("GdtMvViewController", 1, "[onVideoPrepared] send PREPARED msg");
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1).sendToTarget();
      }
    }
    while ((this.d) || (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.c())) {
      return;
    }
    QLog.i("GdtMvViewController", 1, "[onVideoPrepared] resume VideoPlayer again");
    d();
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.a())) {}
    while ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController.a())) {
      return true;
    }
    return a(false);
  }
  
  public void d()
  {
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a();
      if (this.jdField_a_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      x();
      return;
    }
  }
  
  public void e()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    this.e = false;
    this.f = true;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(2).sendToTarget();
    }
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp != null) && (localGdtVideoData != null)) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp.a(localGdtVideoData, this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null) {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer));
      }
      ThreadManager.getUIHandler().post(new GdtMvViewController.7(this));
    }
  }
  
  public void f()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoBufferStart]");
  }
  
  public void g()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoBufferEnd]");
  }
  
  public void h()
  {
    this.i = false;
    C();
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker != null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.onActivityPause();
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController.h();
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.h();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        do
        {
          return false;
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer == null);
        D();
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer == null);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer;
      if ((this.jdField_a_of_type_Boolean) || (this.j)) {}
      for (boolean bool = true;; bool = false)
      {
        paramMessage.a(bool);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.a();
        QLog.i("GdtMvViewController", 1, "[mDuration]" + this.jdField_a_of_type_Long + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", isSilentMode = " + this.j);
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().setDurationMillis(this.jdField_a_of_type_Long);
        d();
        return false;
      }
    case 2: 
      QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b(this);
      }
      b(0L, 0L);
      a(0L, true);
      c(false);
      a(1020013L);
      a(1020012L);
      l();
      return false;
    case 3: 
      QLog.i("GdtMvViewController", 1, "[VIDEO_SDK_INSTALLED] initVideoView");
      z();
      return false;
    }
    QLog.i("GdtMvViewController", 1, "[VIDEO_FAIL] handle message");
    a(0L, true);
    return false;
  }
  
  public void i()
  {
    this.i = true;
    QLog.i("GdtMvViewController", 1, "[onResume]" + this.d + " mIsVideoPlayCompleted " + this.f);
    if ((!this.d) && (!this.f) && (this.e)) {
      d();
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController.g();
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController.b();
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.g();
    }
    GdtMvWebJsCallHandler.a(new GdtMvViewController.MvWebJsCallAction(this, null));
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker != null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.onActivityResume();
    }
  }
  
  public void j()
  {
    QLog.i("GdtMvViewController", 1, "[onDestroy]");
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessVideoICmGameVideoPlayer = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController.e();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvElementsController = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView.a(), this.l);
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoWebbottomcardGdtMVWebBottomCardController.f();
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.i();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp = null;
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController$SilentModeReceiver != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController$SilentModeReceiver);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    GdtImpressionPolicy.a().a();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getApplication().getApplicationContext(), true, 55);
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker != null)
    {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.onActivityDestroy();
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.setCallback(null);
    }
    GdtMvWebJsCallHandler.c();
  }
  
  public void k()
  {
    QLog.i("GdtMvViewController", 1, "[onCreate]");
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getApplication().getApplicationContext(), false, 55);
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.b();
    }
    do
    {
      return;
      a(1);
    } while (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController == null);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVEndcardWebController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoIMotiveVideoView.a(), this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel, this.jdField_b_of_type_Boolean);
  }
  
  public void m()
  {
    a("");
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController
 * JD-Core Version:    0.7.0.1
 */