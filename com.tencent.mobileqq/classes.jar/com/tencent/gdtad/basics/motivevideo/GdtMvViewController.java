package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsController;
import com.tencent.gdtad.basics.motivevideo.js.GdtMvWebJsActionHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtMvMiniAppReportHelper;
import com.tencent.gdtad.basics.motivevideo.title.GdtMvTitleHelper;
import com.tencent.gdtad.basics.motivevideo.title.GdtMvTitleHelper.MvTitleListener;
import com.tencent.gdtad.basics.motivevideo.web.bottomcrad.GdtMVWebBottomCardController;
import com.tencent.gdtad.basics.motivevideo.web.endcrad.GdtMVEndcardWebController;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtImpressionPolicy;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoReportListenerImp;
import com.tencent.gdtad.volume.VolumeChangeObserver;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.apollo.game.process.video.ICmGameVideoCallback;
import com.tencent.mobileqq.apollo.game.process.video.api.ICmGameVideoPlayer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
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
  private AdExposureChecker.ExposureCallback jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback;
  private AdExposureChecker jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker;
  private GdtMvViewController.SilentModeReceiver jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController$SilentModeReceiver;
  private IMotiveVideoView jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView;
  private GdtMotiveVideoModel jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel;
  private GdtMvElementsController jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController;
  public final GdtMvMiniAppReportHelper a;
  public final GdtMvTitleHelper a;
  private GdtMVWebBottomCardController jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController;
  private GdtMVEndcardWebController jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebEndcradGdtMVEndcardWebController;
  public GdtThirdProcessorProxy a;
  private final GdtImpressionReporter.GdtVideoReportInfo jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo;
  private GdtVideoReportListenerImp jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
  private VolumeChangeObserver jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver;
  private ICmGameVideoPlayer jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public GdtMvViewController(IMotiveVideoView paramIMotiveVideoView, GdtMotiveVideoModel paramGdtMotiveVideoModel, boolean paramBoolean)
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 15L;
    this.g = false;
    this.jdField_a_of_type_Int = 0;
    this.h = false;
    this.i = false;
    this.j = false;
    this.k = true;
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper = new GdtMvTitleHelper();
    this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper = new GdtMvMiniAppReportHelper();
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo = new GdtImpressionReporter.GdtVideoReportInfo();
    this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy = new GdtThirdProcessorProxy();
    this.m = true;
    this.jdField_c_of_type_Long = 0L;
    this.n = true;
    this.o = false;
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView = paramIMotiveVideoView;
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel = paramGdtMotiveVideoModel;
    this.l = paramBoolean;
    paramIMotiveVideoView = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    paramIMotiveVideoView.style = 0;
    paramBoolean = bool;
    if (paramIMotiveVideoView.screenOrientation == 1) {
      paramBoolean = true;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Long = GdtUtil.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel);
    this.jdField_a_of_type_JavaLangString = paramIMotiveVideoView.getRewardText();
    paramBoolean = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().exp_info.video_countdown_style.has();
    paramIMotiveVideoView = new StringBuilder();
    paramIMotiveVideoView.append("GdtMvViewController: video_countdown = ");
    paramIMotiveVideoView.append(this.jdField_b_of_type_Long);
    paramIMotiveVideoView.append(", video_countdown_style has = ");
    paramIMotiveVideoView.append(paramBoolean);
    paramIMotiveVideoView.append(", rewardText = ");
    paramIMotiveVideoView.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("GdtMvViewController", 1, paramIMotiveVideoView.toString());
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getVideoWidth();
      int i4 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getVideoHeight();
      int i1;
      if (this.jdField_b_of_type_Boolean) {
        i1 = GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext);
      } else {
        i1 = GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext);
      }
      int i2;
      if (this.jdField_b_of_type_Boolean) {
        i2 = GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext);
      } else {
        i2 = GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[VIDEO_PREPARED] mVideoSize ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(" vW-");
      localStringBuilder.append(i3);
      localStringBuilder.append(" vH-");
      localStringBuilder.append(i4);
      localStringBuilder.append(" sW-");
      localStringBuilder.append(i1);
      localStringBuilder.append(" sH-");
      localStringBuilder.append(i2);
      QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
      if ((this.jdField_b_of_type_Boolean) && (((GdtMotiveVideoPageData)localObject).vSize != 585))
      {
        i3 = (int)(i1 * 1.0F * i4 / i3);
        i2 = (int)(i2 * 150.0F / 1334.0F);
        localLayoutParams.height = i3;
        localLayoutParams.width = i1;
        localLayoutParams.topMargin = i2;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[VIDEO_PREPARED] newHeight ");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append(" newWidth-");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" newTop-");
        ((StringBuilder)localObject).append(i2);
        QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
      a(1020034L);
    }
  }
  
  private void B()
  {
    if (this.l)
    {
      f();
      h();
    }
  }
  
  private void C()
  {
    GdtMvElementsController localGdtMvElementsController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController;
    if (localGdtMvElementsController != null) {
      localGdtMvElementsController.c();
    }
  }
  
  private void D()
  {
    WeakReferenceHandler localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localWeakReferenceHandler != null) {
      localWeakReferenceHandler.post(new GdtMvViewController.10(this));
    }
  }
  
  private void E()
  {
    if (!this.o)
    {
      a(1020012L);
      this.o = true;
    }
  }
  
  private void a(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long < 800L) {
      return;
    }
    if ((paramInt != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController != null))
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController.a(paramInt);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVoiceIconState volume =");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" mVideoPlayer ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer);
    localStringBuilder.append(" isFromVolumeChanged = ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(", mIsMute = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", viewResumed = ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", mIsVideoPlayCompleted = ");
    localStringBuilder.append(this.f);
    QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer == null) {
        return;
      }
      u();
      if (!this.f) {
        d(this.jdField_a_of_type_Boolean ^ true);
      }
    }
  }
  
  private void a(long paramLong)
  {
    GdtADFlyingStreamingReportHelper.a().a(paramLong);
  }
  
  private void a(View paramView)
  {
    QLog.d("GdtMvViewController", 1, new Object[] { "initExpoReport isFirst=", Boolean.valueOf(this.n) });
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    if ((this.n) && (paramView != null))
    {
      this.n = false;
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker = new AdExposureChecker(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a(), new WeakReference(paramView));
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new GdtMvViewController.9(this);
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.startCheck();
      paramView = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper;
      ICmGameVideoPlayer localICmGameVideoPlayer = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      long l1;
      if (localICmGameVideoPlayer != null) {
        l1 = localICmGameVideoPlayer.getCurrentPosition();
      } else {
        l1 = 0L;
      }
      paramView.a(l1);
    }
  }
  
  private View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    try
    {
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
      if (this.jdField_b_of_type_Boolean)
      {
        if (localGdtMotiveVideoPageData.vSize == 585) {
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559189, paramViewGroup, false);
        } else {
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559188, paramViewGroup, false);
        }
      }
      else {
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559187, paramViewGroup, false);
      }
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return null;
      }
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController = new GdtMvElementsController(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel, this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy);
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper);
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController.a(this.jdField_b_of_type_Boolean);
      GdtUIUtils.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371886));
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController.a();
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362157));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380646));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      return this.jdField_a_of_type_AndroidViewView;
    }
    catch (Exception paramLayoutInflater)
    {
      QLog.e("GdtMvViewController", 1, " viewcontr initViews error", paramLayoutInflater);
    }
    return null;
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper.a(0);
    GdtMVWebBottomCardController localGdtMVWebBottomCardController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController;
    if (localGdtMVWebBottomCardController != null) {
      localGdtMVWebBottomCardController.a(paramBoolean);
    }
    GdtADFlyingStreamingReportHelper.a().a(1);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      if (paramBoolean)
      {
        QLog.i("GdtMvViewController", 1, "[requestSystemAudioFocus] gain is called!");
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
        return;
      }
      QLog.i("GdtMvViewController", 1, "[requestSystemAudioFocus] release is called!");
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    GdtMvElementsController localGdtMvElementsController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController;
    if ((localGdtMvElementsController != null) && (paramBoolean)) {
      localGdtMvElementsController.d();
    }
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel;
    if ((localObject != null) && (((GdtMotiveVideoModel)localObject).a() != null) && (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().isValid()))
    {
      localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.jdField_a_of_type_AndroidContentContext, (GdtAd)localObject);
      return;
    }
    QLog.e("GdtMvViewController", 1, "doAdPreload error");
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject != null)
    {
      boolean bool;
      if (((AudioManager)localObject).getRingerMode() != 2) {
        bool = true;
      } else {
        bool = false;
      }
      this.j = bool;
    }
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController$SilentModeReceiver = new GdtMvViewController.SilentModeReceiver(this, null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.media.RINGER_MODE_CHANGED");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController$SilentModeReceiver, (IntentFilter)localObject);
    this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver = new VolumeChangeObserver(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver.a();
    this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver.a(new GdtMvViewController.1(this));
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController != null)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp = new GdtVideoReportListenerImp(11);
      return;
    }
    QLog.i("GdtMvViewController", 1, " initReports error");
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebEndcradGdtMVEndcardWebController = new GdtMVEndcardWebController(this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy);
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebEndcradGdtMVEndcardWebController.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView.a(), this.jdField_b_of_type_Boolean);
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController = new GdtMVWebBottomCardController(new GdtMvViewController.2(this), this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler);
    boolean bool = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView.a(), this.jdField_b_of_type_Boolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("web bottom card result:");
    localStringBuilder.append(bool);
    QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
    if (bool)
    {
      q();
    }
    else
    {
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController.e();
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController = null;
      c(false);
    }
    GdtADFlyingStreamingReportHelper.a().a(1020030L);
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper.a(4);
    GdtMVWebBottomCardController localGdtMVWebBottomCardController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController;
    if (localGdtMVWebBottomCardController != null)
    {
      localGdtMVWebBottomCardController.a();
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController.f();
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, null, "", HardCodeUtil.a(2131705312), HardCodeUtil.a(2131705309), new GdtMvViewController.3(this), new GdtMvViewController.4(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new GdtMvViewController.5(this));
  }
  
  private void s()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    boolean bool2 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).exp_info.video_volume.has();
    int i1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).exp_info.video_volume.get();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initMute] videoVolume = ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(",isHasVideoVolume = ");
    ((StringBuilder)localObject).append(bool2);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool1 = true;
    QLog.i("GdtMvViewController", 1, (String)localObject);
    if ((!bool2) || (i1 != 0)) {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
  }
  
  private void t()
  {
    if (this.j)
    {
      QLog.i("GdtMvViewController", 1, "refreshVoiceIconDrawable isSilentMode is true");
      this.jdField_a_of_type_Boolean = true;
    }
    u();
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_Boolean);
  }
  
  private void v()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    localObject = this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy.b(this.jdField_a_of_type_AndroidContentContext, ((GdtMotiveVideoPageData)localObject).previewImgUrl);
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (localObject != null)) {
      localImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void w()
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "initVideoView");
    Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo.a(11);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer = ((ICmGameVideoPlayer)QRoute.api(ICmGameVideoPlayer.class));
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.initVideoPlayer(this.jdField_a_of_type_AndroidViewView.getContext(), ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.addPlayerCallback(this, 100L);
    View localView = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getVideoContainer();
    if ((localView != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.startPlay(((GdtMotiveVideoPageData)localObject).url, "sd", 0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setViewStatus], videoView is null.");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    QLog.i("VideoGdtGdtMvViewController", 1, ((StringBuilder)localObject).toString());
  }
  
  private void x()
  {
    if (QQVideoPlaySDKManager.a())
    {
      w();
      return;
    }
    y();
  }
  
  private void y()
  {
    try
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "installSDK");
      QQVideoPlaySDKManager.a(BaseApplication.getContext(), new GdtMvViewController.6(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoGdtGdtMvViewController", 1, "installSDK", localThrowable);
    }
  }
  
  private void z()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[doPauseAction] mIsVideoPlayCompleted:");
    ((StringBuilder)localObject1).append(this.f);
    QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    d(false);
    Object localObject2;
    if (!this.f)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      if (localObject2 != null)
      {
        this.h = false;
        if (((ICmGameVideoPlayer)localObject2).isPlaying())
        {
          localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
          if ((localObject2 != null) && (localObject1 != null)) {
            ((GdtVideoReportListenerImp)localObject2).b((GdtVideoData)localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getCurrentPosition(), this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.pause();
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebEndcradGdtMVEndcardWebController;
    if (localObject1 != null) {
      ((GdtMVEndcardWebController)localObject1).c();
    }
    localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      if (localObject2 != null) {
        ((GdtMVWebBottomCardController)localObject1).a(((ICmGameVideoPlayer)localObject2).getMuteValue(), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getVideoDuration(), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getCurrentPosition(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer));
      }
    }
  }
  
  public long a()
  {
    ICmGameVideoPlayer localICmGameVideoPlayer = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
    if (localICmGameVideoPlayer != null)
    {
      if (this.f) {
        return this.jdField_a_of_type_Long;
      }
      return localICmGameVideoPlayer.getCurrentPosition();
    }
    return 0L;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    s();
    paramLayoutInflater = b(paramLayoutInflater, paramViewGroup);
    if (paramLayoutInflater == null)
    {
      QLog.i("GdtMvViewController", 1, "GdtMvViewController init:rootView==null error");
      return null;
    }
    this.jdField_a_of_type_AndroidContentContext = paramLayoutInflater.getContext();
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("GdtMvViewController: init = ");
    paramViewGroup.append(this.l);
    paramViewGroup.append(", mContext = ");
    paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext);
    QLog.i("GdtMvViewController", 1, paramViewGroup.toString());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    paramViewGroup = this.jdField_a_of_type_AndroidContentContext;
    if (((paramViewGroup instanceof Activity)) && (!this.l)) {
      ((Activity)paramViewGroup).setVolumeControlStream(3);
    }
    l();
    GdtADFlyingStreamingReportHelper.a().a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel);
    m();
    t();
    a();
    v();
    x();
    C();
    r();
    n();
    o();
    p();
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel);
    a(1020033L);
    a(1020006L);
    if (this.m)
    {
      GdtOriginalExposureReporter.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a(), this.jdField_a_of_type_AndroidContentContext);
      this.m = false;
    }
    return paramLayoutInflater;
  }
  
  public IMotiveVideoView a()
  {
    return this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView;
  }
  
  public GdtImpressionReporter.GdtVideoReportInfo a()
  {
    return this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper.a(this.jdField_a_of_type_AndroidViewView, this, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper);
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView.a(), this.jdField_b_of_type_Boolean);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onVideoError], module:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",errorType:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",errorCode:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(",msg:");
    localStringBuilder.append(paramString);
    QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
    paramString = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp != null) && (paramString != null))
    {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo.a(paramInt2, paramInt3);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp.a(paramString, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getCurrentPosition(), this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
    }
    a(1020009L);
    a(1020007L);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new GdtMvViewController.8(this, paramLong1, paramLong2));
      return;
    }
    if (this.f) {
      return;
    }
    boolean bool;
    if (paramLong2 < this.jdField_b_of_type_Long * 1000L) {
      bool = true;
    } else {
      bool = false;
    }
    this.g = bool;
    long l4 = paramLong2 - paramLong1;
    long l1;
    if (this.g) {
      l1 = paramLong1;
    } else {
      l1 = this.jdField_b_of_type_Long * 1000L - l4;
    }
    long l2 = l1 / 1000L + 1L;
    long l3 = this.jdField_b_of_type_Long;
    if (l2 > l3) {
      l2 = l3;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper;
    if (localObject2 != null) {
      ((GdtMvTitleHelper)localObject2).a(paramLong2, this.jdField_b_of_type_Long * 1000L);
    }
    a(l1, l2, l4);
    paramLong2 = l4 / 1000L;
    a(paramLong2, this.f);
    if (l1 <= 0L)
    {
      this.jdField_c_of_type_Boolean = true;
      E();
    }
    if (paramLong2 == 2L) {
      e(true);
    }
    if (paramLong1 / 1000L == 3L) {
      e(false);
    }
    if (!this.h)
    {
      localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
      if (localObject2 != null)
      {
        ICmGameVideoPlayer localICmGameVideoPlayer = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
        if ((localICmGameVideoPlayer != null) && (localObject1 != null))
        {
          this.h = true;
          ((GdtVideoReportListenerImp)localObject2).a((GdtVideoData)localObject1, localICmGameVideoPlayer.getCurrentPosition());
        }
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebEndcradGdtMVEndcardWebController;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      if (localObject2 != null) {
        ((GdtMVEndcardWebController)localObject1).a(((ICmGameVideoPlayer)localObject2).getVideoDuration() - this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getCurrentPosition());
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      if (localObject2 != null) {
        ((GdtMVWebBottomCardController)localObject1).a(((ICmGameVideoPlayer)localObject2).getMuteValue(), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getVideoDuration(), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getCurrentPosition(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer));
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper.a(paramLong1, paramLong2, paramLong3);
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper.a(paramLong, paramBoolean);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    QLog.i("GdtMvViewController", 1, "GDT beforeFinish call stack:", new Throwable());
    Intent localIntent = new Intent();
    localIntent.putExtra("duration_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("profitable_flag", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("is_end", this.f);
    boolean bool = this.f;
    Object localObject2;
    if (bool)
    {
      localObject2 = this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy;
      long l1 = this.jdField_a_of_type_Long;
      ((GdtThirdProcessorProxy)localObject2).a((GdtMotiveVideoPageData)localObject1, l1, l1, bool);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("true[beforeFinish] ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append(" /");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      if (localObject2 != null)
      {
        localIntent.putExtra("elapsed_time", ((ICmGameVideoPlayer)localObject2).getCurrentPosition());
        this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy.a((GdtMotiveVideoPageData)localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getCurrentPosition(), this.jdField_a_of_type_Long, this.f);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Boolean);
        ((StringBuilder)localObject1).append("[beforeFinish] ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getCurrentPosition());
        ((StringBuilder)localObject1).append(" /");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
        QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
      }
    }
    this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy.a(localIntent, paramString);
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView.a(-1, localIntent);
    B();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer == null) {
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper.a(7, a());
    }
    paramBoolean = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getMuteValue();
    this.jdField_a_of_type_Boolean = (paramBoolean ^ true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioSwitch click is called isSilentMode = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", isMute = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.setMute(this.jdField_a_of_type_Boolean);
    a(this.jdField_a_of_type_Boolean ^ true, true, false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper.a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onBackEvent] mHasWatchAds ");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_Boolean);
    QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      try
      {
        if (this.jdField_c_of_type_Boolean) {
          return false;
        }
        b();
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showDialog mVideoDuration ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
          ((StringBuilder)localObject1).append(" mShotSeconds ");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_Long);
          ((StringBuilder)localObject1).append(" mRewardText ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
          localObject1 = new StringBuffer(HardCodeUtil.a(2131692865));
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            ((StringBuffer)localObject1).append(HardCodeUtil.a(2131692857));
          } else {
            ((StringBuffer)localObject1).append(this.jdField_a_of_type_JavaLangString);
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131705307));
            localStringBuilder.append(this.jdField_b_of_type_Long);
            localStringBuilder.append(((StringBuffer)localObject1).toString());
            localObject1 = localStringBuilder.toString();
          }
          else
          {
            localObject1 = HardCodeUtil.a(2131705308);
          }
          ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow();
          if (localObject1 != null) {
            ((Window)localObject1).getDecorView().setSystemUiVisibility(7942);
          }
          GdtADFlyingStreamingReportHelper.a().a(1020029L);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("show dialog err, errInfo->");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("GdtMvViewController", 1, ((StringBuilder)localObject2).toString());
      }
    }
    return false;
  }
  
  protected void b()
  {
    ICmGameVideoPlayer localICmGameVideoPlayer = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
    if ((localICmGameVideoPlayer != null) && (!localICmGameVideoPlayer.isPaused()))
    {
      this.d = true;
      z();
    }
    a(1020010L);
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.i("GdtMvViewController", 1, " onClick close_ads");
    if (GdtADFlyingStreamingReportHelper.a().a() == 2) {
      GdtADFlyingStreamingReportHelper.a().a(1020016L);
    } else {
      GdtADFlyingStreamingReportHelper.a().a(1020028L);
    }
    if (!a(true))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper.a(4, a());
      }
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView.a();
    }
  }
  
  public boolean b()
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
    else if (!this.d)
    {
      ICmGameVideoPlayer localICmGameVideoPlayer = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      if ((localICmGameVideoPlayer != null) && (!localICmGameVideoPlayer.isPlaying()))
      {
        QLog.i("GdtMvViewController", 1, "[onVideoPrepared] resume VideoPlayer again");
        d();
      }
    }
  }
  
  public boolean c()
  {
    GdtMVEndcardWebController localGdtMVEndcardWebController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebEndcradGdtMVEndcardWebController;
    if ((localGdtMVEndcardWebController != null) && (localGdtMVEndcardWebController.a())) {
      return true;
    }
    return a(false);
  }
  
  public void d()
  {
    if (this.i)
    {
      ICmGameVideoPlayer localICmGameVideoPlayer = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      if (localICmGameVideoPlayer != null)
      {
        localICmGameVideoPlayer.resume();
        d(this.jdField_a_of_type_Boolean ^ true);
        u();
      }
    }
  }
  
  public void e()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    this.e = false;
    this.f = true;
    this.jdField_c_of_type_Boolean = true;
    Object localObject2 = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject2 != null) {
      ((WeakReferenceHandler)localObject2).obtainMessage(2).sendToTarget();
    }
    localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp;
    if ((localObject2 != null) && (localObject1 != null)) {
      ((GdtVideoReportListenerImp)localObject2).a((GdtVideoData)localObject1, this.jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionReporter$GdtVideoReportInfo);
    }
    localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      if (localObject2 != null) {
        ((GdtMVWebBottomCardController)localObject1).a(((ICmGameVideoPlayer)localObject2).getMuteValue(), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getVideoDuration(), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getCurrentPosition(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer));
      }
      ThreadManager.getUIHandler().post(new GdtMvViewController.7(this));
    }
  }
  
  public void f()
  {
    this.i = false;
    z();
    Object localObject = this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker;
    if (localObject != null) {
      ((AdExposureChecker)localObject).onActivityPause();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController;
    if (localObject != null) {
      ((GdtMvElementsController)localObject).h();
    }
  }
  
  public void g()
  {
    this.i = true;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onResume]");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(" mIsVideoPlayCompleted ");
    ((StringBuilder)localObject).append(this.f);
    QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject).toString());
    if ((!this.d) && (!this.f) && (this.e)) {
      d();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController;
    if (localObject != null) {
      ((GdtMvElementsController)localObject).g();
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebEndcradGdtMVEndcardWebController;
    if (localObject != null) {
      ((GdtMVEndcardWebController)localObject).b();
    }
    GdtMvWebJsActionHelper.a(new GdtMvViewController.MvWebJsCallAction(this, null));
    localObject = this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker;
    if (localObject != null) {
      ((AdExposureChecker)localObject).onActivityResume();
    }
  }
  
  public void h()
  {
    QLog.i("GdtMvViewController", 1, "[onDestroy]");
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null) {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver;
    if (localObject != null) {
      ((VolumeChangeObserver)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
    if (localObject != null)
    {
      ((ICmGameVideoPlayer)localObject).removePlayerCallback(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.release();
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController;
    if (localObject != null)
    {
      ((GdtMvElementsController)localObject).f();
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController = null;
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebEndcradGdtMVEndcardWebController;
    if (localObject != null) {
      ((GdtMVEndcardWebController)localObject).b(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView.a(), this.l);
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradGdtMVWebBottomCardController;
    if (localObject != null) {
      ((GdtMVWebBottomCardController)localObject).e();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoReportListenerImp = null;
    }
    localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject != null)
    {
      GdtMvViewController.SilentModeReceiver localSilentModeReceiver = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController$SilentModeReceiver;
      if (localSilentModeReceiver != null) {
        ((Context)localObject).unregisterReceiver(localSilentModeReceiver);
      }
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    GdtImpressionPolicy.a().a();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 55);
    localObject = this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker;
    if (localObject != null)
    {
      ((AdExposureChecker)localObject).onActivityDestroy();
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.setCallback(null);
    }
    GdtMvWebJsActionHelper.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return false;
          }
          QLog.i("GdtMvViewController", 1, "[VIDEO_FAIL] handle message");
          a(0L, true);
          return false;
        }
        QLog.i("GdtMvViewController", 1, "[VIDEO_SDK_INSTALLED] initVideoView");
        w();
        return false;
      }
      QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
      if (paramMessage != null) {
        paramMessage.removePlayerCallback(this);
      }
      a(0L, 0L, 0L);
      a(0L, true);
      d(false);
      a(1020013L);
      j();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer == null) {
      return false;
    }
    A();
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer;
    if (paramMessage != null)
    {
      boolean bool;
      if ((!this.jdField_a_of_type_Boolean) && (!this.j)) {
        bool = false;
      } else {
        bool = true;
      }
      paramMessage.setMute(bool);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessVideoApiICmGameVideoPlayer.getVideoDuration();
      paramMessage = new StringBuilder();
      paramMessage.append("[mDuration]");
      paramMessage.append(this.jdField_a_of_type_Long);
      paramMessage.append(", mIsMute = ");
      paramMessage.append(this.jdField_a_of_type_Boolean);
      paramMessage.append(", isSilentMode = ");
      paramMessage.append(this.j);
      QLog.i("GdtMvViewController", 1, paramMessage.toString());
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().setDurationMillis(this.jdField_a_of_type_Long);
      d();
    }
    return false;
  }
  
  public void i()
  {
    QLog.i("GdtMvViewController", 1, "[onCreate]");
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 55);
  }
  
  protected void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsController;
    if (localObject != null) {
      ((GdtMvElementsController)localObject).b();
    }
    a(1);
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebEndcradGdtMVEndcardWebController;
    if (localObject != null) {
      ((GdtMVEndcardWebController)localObject).a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoIMotiveVideoView.a(), this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel, this.jdField_b_of_type_Boolean);
    }
    GdtADFlyingStreamingReportHelper.a().a(1020035L);
    GdtADFlyingStreamingReportHelper.a().a(2);
  }
  
  public void k()
  {
    a("");
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController
 * JD-Core Version:    0.7.0.1
 */