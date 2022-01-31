package com.tencent.biz.pubaccount.readinjoy.view.fastweb.video;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient.Observer;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.OnVideoPluginInstallListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import mns;
import mnu;
import mnv;
import mny;
import mnz;
import moa;
import moc;
import moe;
import mof;
import mog;
import moh;
import moi;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebVideoFeedsPlayManager
  implements VideoFeedsIPCClient.Observer, VideoPluginInstall.OnVideoPluginInstallListener, TVK_IMediaPlayer.OnDownloadCallbackListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new mnz(this, Looper.getMainLooper());
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private VideoFeedsIPCClient jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient;
  private VideoPlayerWrapper.MediaPlayListenerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter = new mns(this);
  private VideoPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  private FastWebVideoFeedsPlayActivity.PhoneCallStateListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayActivity$PhoneCallStateListener;
  private FastWebVideoFeedsPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new mny(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  FastWebVideoFeedsPlayManager(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsIPCClient paramVideoFeedsIPCClient, Handler paramHandler, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient = paramVideoFeedsIPCClient;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall(paramActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    FastWebVideoVolumeControl.a().a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = VideoAutoPlayController.a(this.jdField_a_of_type_AndroidContentContext);
    if (VideoAutoPlayController.a(this.jdField_a_of_type_AndroidContentContext)) {
      f(true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent().hasExtra("param_needAlertInXg"))
      {
        paramContext = new Bundle();
        paramContext.putBoolean("VALUE_IS_CONFIRM_IN_XG", this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("param_needAlertInXg", true));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_COMFIRM_VIDEO_PLAY_NEED_ALERT_IN_XG", paramContext);
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "updateVideoPlayInXgHasComfirm() hasconfirm=" + this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("param_needAlertInXg", true));
        }
      }
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      return;
      f(false);
    }
  }
  
  private VideoPlayerWrapper a(FastWebVideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam = this.jdField_a_of_type_AndroidAppActivity;
    if (paramVideoPlayParam == null) {
      return null;
    }
    VideoPlayerWrapper localVideoPlayerWrapper = new VideoPlayerWrapper(paramVideoPlayParam.getApplicationContext());
    localVideoPlayerWrapper.a().setOutputMute(FastWebVideoVolumeControl.a().a());
    localVideoPlayerWrapper.a(paramVideoPlayParam);
    localVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter);
    return localVideoPlayerWrapper;
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      return;
    }
    VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentImageURLImageView, paramInt, 500);
  }
  
  private boolean d()
  {
    boolean bool = false;
    Bundle localBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_IS_VIDEO_PLAY_NEED_ALERT_IN_XG", null);
    if (localBundle != null) {
      bool = localBundle.getBoolean("VALUE_VIDEO_NEED_ALERT", false);
    }
    return bool;
  }
  
  private void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "handleConnetNetWorkChange");
    }
    f(paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a()) {
      if (b()) {
        f();
      }
    }
    while (paramBoolean) {
      return;
    }
    c();
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("VALUE_NETWORK_CHANGE_IS_WIFI", paramBoolean);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_NETWORK_CHANGE", localBundle);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b(paramBoolean);
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setKeepScreenOn(true);
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
    if (localView == null)
    {
      a(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam = null;
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView = localView;
    localView.setId(2131362193);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a((IVideoViewBase)localView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    ThreadManager.post(new moc(this), 5, null, true);
    k();
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new mog(this));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new moi(this));
  }
  
  private void m()
  {
    if ((this.f) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null))
    {
      this.f = false;
      if (e()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = false;
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam, true);
      return;
    }
    if (e()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = false;
    }
    d();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "showMobileNetHint()");
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new mnu(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "isWifiConnected false");
      }
    }
    while (!d()) {
      return;
    }
    if (c())
    {
      this.f = false;
      c();
    }
    for (;;)
    {
      a(0);
      this.jdField_a_of_type_AndroidOsHandler.post(new mnv(this));
      return;
      this.f = true;
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "handleNotNetWorkChange");
    }
    f(false);
  }
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          return;
        }
        int i = new JSONObject(paramString).getInt("callBackType");
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "OnDownloadCallback callBackType=" + i + ", msg.videoFileStatus=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
        }
        if ((i == 7) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus != 2003))
        {
          paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          paramString.videoFileStatus = 2003;
          paramString.videoFileProgress = 100;
          paramString.transferedSize = 0;
          paramString.lastModified = new File(ShortVideoUtils.a(paramString, "mp4")).lastModified();
          paramString.serial();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient != null)
          {
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("VALUE_SHORTVIDEO_MSG", paramString);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_SHORTVIDEO_UPDATE_MSG_BY_UNISEQ", localBundle);
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
    }
    return 0L;
  }
  
  public FastWebVideoInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "handlePlayButtonClick() status()=" + i);
      }
      switch (i)
      {
      default: 
        return;
      case 0: 
        if (e()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = false;
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam, false);
        return;
      case 6: 
        if (e()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = false;
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam, true);
        return;
      case 3: 
      case 4: 
        c();
        return;
      case 5: 
        if (d())
        {
          n();
          return;
        }
        if (e()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = false;
        }
        d();
        return;
      case 1: 
        c();
        return;
      }
      if (d())
      {
        n();
        return;
      }
      if (e()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = false;
      }
      b();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "innerChangePlayButton() what = " + paramInt);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.post(new moh(this, paramInt));
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(FastWebVideoFeedsPlayActivity.PhoneCallStateListener paramPhoneCallStateListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayActivity$PhoneCallStateListener = paramPhoneCallStateListener;
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayActivity$PhoneCallStateListener != null)) {
      ((TelephonyManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("phone")).listen(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayActivity$PhoneCallStateListener, 32);
    }
  }
  
  public void a(FastWebVideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.c = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam = paramVideoPlayParam;
    a(0);
  }
  
  public void a(FastWebVideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "playVideo() vid=" + paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_JavaLangString);
    }
    this.c = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam = paramVideoPlayParam;
    if (d())
    {
      a(0);
      n();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    ThreadManager.post(new moa(this, paramBoolean, paramVideoPlayParam), 10, null, true);
  }
  
  public void a(FastWebVideoFeedsPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramVideoStatusListener);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    String str1;
    int i;
    if ("CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD".equals(paramString))
    {
      str1 = paramBundle.getString("VALUE_SHORTVIDEO_RESP_FILE_DOMAIN");
      paramString = paramBundle.getStringArray("VALUE_SHORTVIDEO_RESP_FILE_URLS");
      i = paramBundle.getInt("VALUE_SHORTVIDEO_RESP_FILE_STATUS");
      l = paramBundle.getLong("VALUE_SHORTVIDEO_RESP_FILE_UNISEQ");
      paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam;
      if ((paramBundle != null) && (paramBundle.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo != null) && (paramBundle.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int == 0) && (paramBundle.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
        break label81;
      }
    }
    label81:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (l != paramBundle.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          switch (i)
          {
          case 1002: 
          case 1003: 
          default: 
            return;
          case 2002: 
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "handleMessage STATUS_RECV_PROCESS: get url finished");
            }
            break;
          }
        } while (paramString == null);
        i = 0;
        while (i < 1)
        {
          if (!StringUtil.a(str1)) {
            paramString[i] = (paramString[i] + "&txhost=" + str1);
          }
          i += 1;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "handleMessage STATUS_RECV_FINISHED");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_RECV_ERROR");
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437350, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      a(2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_UNSAFE");
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437351, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      a(2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_EXPIRED");
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437352, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      a(2);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_RECV_CANCEL");
    return;
    if (this.jdField_a_of_type_Long > 0L) {}
    for (long l = this.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_a_of_type_Long = 0L;
      str1 = ShortVideoUtils.a(paramBundle.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      String str2 = paramBundle.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString, str1, paramBundle.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, str2, l, this);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new moe(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c() == 3) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c() == 4)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
      if (!paramBoolean) {
        a(0);
      }
    }
    else
    {
      return;
    }
    a(6);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c() == 5);
  }
  
  public void c()
  {
    boolean bool = false;
    b(false);
    if (e()) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d() != 0L) {
        break label171;
      }
    }
    label171:
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e;; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d() / 1000))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b(this.c) / 1000);
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d == 0) {
        bool = true;
      }
      ((ReadinjoyAdVideoReportData)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.c = this.c;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      localObject = VideoReporter.a(((ReadinjoyAdVideoReportData)localObject).jdField_a_of_type_Boolean, ((ReadinjoyAdVideoReportData)localObject).d, ((ReadinjoyAdVideoReportData)localObject).e, ((ReadinjoyAdVideoReportData)localObject).jdField_b_of_type_Boolean, ((ReadinjoyAdVideoReportData)localObject).c, ((ReadinjoyAdVideoReportData)localObject).f);
      VideoReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, (Bundle)localObject);
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam, true);
      }
      return;
    }
    a(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam = null;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c() == 3);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new mof(this));
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a().setOutputMute(paramBoolean);
    }
  }
  
  public void e()
  {
    c(0);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      if (e())
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d() != 0L) {
          break label230;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b(this.c) / 1000);
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d != 0) {
          break label255;
        }
      }
    }
    label230:
    label255:
    for (boolean bool = true;; bool = false)
    {
      ((ReadinjoyAdVideoReportData)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.c = this.c;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      localObject = VideoReporter.a(((ReadinjoyAdVideoReportData)localObject).jdField_a_of_type_Boolean, ((ReadinjoyAdVideoReportData)localObject).d, ((ReadinjoyAdVideoReportData)localObject).e, ((ReadinjoyAdVideoReportData)localObject).jdField_b_of_type_Boolean, ((ReadinjoyAdVideoReportData)localObject).c, ((ReadinjoyAdVideoReportData)localObject).f);
      VideoReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, (Bundle)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.h();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setKeepScreenOn(false);
      }
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d() / 1000);
      break;
    }
  }
  
  public void f()
  {
    Bundle localBundle;
    if (this.d)
    {
      localBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_IS_VIDEO_CHATTING", null);
      if (localBundle == null) {
        break label51;
      }
    }
    label51:
    for (boolean bool = localBundle.getBoolean("VALUE_IS_VIDEO_CHATTING", false);; bool = false)
    {
      if (!bool)
      {
        this.e = true;
        d();
      }
      this.d = false;
      return;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "doOnPause() isPlaying()=" + c());
    }
    if (c())
    {
      this.d = true;
      c();
    }
    c(0);
  }
  
  public void h()
  {
    e();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentImageURLImageView = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      ((TelephonyManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("phone")).listen(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayActivity$PhoneCallStateListener, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayActivity$PhoneCallStateListener = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_SHORTVIDEO_REQUEST_CLEAR", null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient = null;
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  void i()
  {
    if ((a() != 5) || (!a())) {
      return;
    }
    a(false);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */