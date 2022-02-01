package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController.EventListener;
import com.tencent.biz.pubaccount.readinjoy.video.player.PlayerStatusListener;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity.Builder;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class VVideoDelegate
  implements VideoVolumeController.EventListener, PlayerStatusListener, VVideoView.OnVideoViewControlListener
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  protected Activity a;
  ReadInjoyPlayer jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer;
  protected VVideoView a;
  @Nullable
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  public VVideoDelegate(Activity paramActivity, VVideoView paramVVideoView, int paramInt, ViolaInstance paramViolaInstance, String paramString, boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer = new ReadInjoyPlayer(paramInt, paramString, paramBoolean);
    this.f = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = paramVVideoView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    VideoVolumeController.a().a(paramActivity);
    VideoVolumeController.a().a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(paramVVideoView);
    if ((paramViolaInstance != null) && (paramViolaInstance.isPageVisiable())) {
      VideoVolumeController.a().a(true, "viola video");
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.d = paramBoolean;
      return;
    }
  }
  
  private int a()
  {
    switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a())
    {
    case 6: 
    default: 
      return 6;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    case 5: 
      return 4;
    }
    return 5;
  }
  
  public static final int a(long paramLong)
  {
    int i = 0;
    if (paramLong >= 500L) {
      i = (int)(paramLong / 1000L + 0.5D);
    }
    return i;
  }
  
  private void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  private void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramInt);
      if (paramString != null) {
        localJSONObject.put("message", paramString);
      }
      paramString = new JSONObject();
      paramString.put("width", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.b());
      paramString.put("height", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.c());
      localJSONObject.put("videoSize", paramString);
      localJSONObject.put("errorData", paramJSONObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("stateChange", localJSONObject);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VVideoControlListenerImpl", 2, "callJsStateChange,error = " + paramString.getMessage());
        }
      }
    }
    if (paramInt == 2) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a();
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(paramString1, paramString2);
    boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.e();
    if ((bool) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.i()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.d()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VVideoControlListenerImpl", 2, "seamlessPlay VIDEO_STATE_BUFFERING");
      }
      a(3, null);
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.j();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.h())
      {
        a(2, null);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.g())
      {
        a(4, null);
        return;
      }
      QLog.e("VVideoControlListenerImpl", 2, "seamlessPlay error state: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a());
      this.e = true;
      this.f = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.f();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_Int);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_Boolean) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("hasUI", 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("didEnterFullScreen", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("VVideoControlListenerImpl", 2, "initChangeFullScreenAnim onAnimationEnd error = : " + localException.getMessage());
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("didExitFullScreen", null);
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(paramFloat);
  }
  
  public void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal enterFullScreen: ");
    }
    this.jdField_b_of_type_Boolean = true;
    Activity localActivity;
    if (!paramBoolean)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      }
    }
    else
    {
      paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
      localActivity = this.jdField_a_of_type_AndroidAppActivity;
      Window localWindow = localActivity.getWindow();
      this.jdField_b_of_type_Int = localWindow.getDecorView().getSystemUiVisibility();
      if (!paramBoolean) {
        break label203;
      }
      localWindow.setFlags(1024, 1024);
      if (!CommonSuspensionGestureLayout.c()) {
        break label195;
      }
      VideoFeedsHelper.c(this.jdField_a_of_type_AndroidAppActivity);
    }
    for (;;)
    {
      if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && ((paramVVideoView.a().getInstance().getFragment() instanceof ViolaLazyFragment)))
      {
        paramVVideoView = (ViolaLazyFragment)paramVVideoView.a().getInstance().getFragment();
        if (paramVVideoView != null)
        {
          paramVVideoView.hideTitleBar();
          paramVVideoView.hideStatusBar();
        }
      }
      k();
      try
      {
        paramVVideoView = new JSONObject();
        paramVVideoView.put("hasUI", false);
        paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
        return;
      }
      catch (Exception paramVVideoView)
      {
        QLog.e("VVideoControlListenerImpl", 2, "enterFullScreen error = : " + paramVVideoView.getMessage());
      }
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(8);
      break;
      label195:
      VideoFeedsHelper.b(localActivity);
      continue;
      label203:
      VideoFeedsHelper.b(localActivity);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a.a(paramVideoPreDownloadMgr);
  }
  
  public void a(VVideoView paramVVideoView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.b(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_Int);
    }
  }
  
  public void a(VVideoView paramVVideoView, int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.b(paramInt);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    if (paramString.equals("contain")) {
      this.jdField_c_of_type_Int = 0;
    }
    for (;;)
    {
      if (this.f) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_c_of_type_Int);
      }
      return;
      if (paramString.equals("cover")) {
        this.jdField_c_of_type_Int = 2;
      }
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", a());
      paramVVideoView.put("currentTime", a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.b()));
      paramVVideoView.put("totalTime", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.b());
      localJSONObject.put("height", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.c());
      paramVVideoView.put("videoSize", localJSONObject);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
    }
  }
  
  public void a(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "open: " + paramJSONObject);
    }
    try
    {
      boolean bool1 = paramJSONObject.optBoolean("autoplay", true);
      bool2 = paramJSONObject.optBoolean("autoPreplay", false);
      a(paramVVideoView, paramJSONObject.optString("resize"));
      c(paramVVideoView, paramJSONObject.optInt("timeupdateRate"));
      c_(paramJSONObject.optBoolean("endWithLastFrame"));
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("cover_frame", false);
      this.jdField_a_of_type_Long = (paramJSONObject.optLong("start_position", 0L) * 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo = new VideoInfo(paramJSONObject.getJSONObject("video_info"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.e(paramJSONObject.optBoolean("muted", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(Float.valueOf(paramJSONObject.optString("rate", "1.0")).floatValue());
      if (paramJSONObject.optBoolean("debugInfoEnable", ReadInJoyHelper.j(ReadInJoyUtils.a())))
      {
        paramVVideoView = paramJSONObject.optString("debugInfo");
        ReadInJoyHelper.i(ReadInJoyUtils.a(), true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.b(paramVVideoView);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_e_of_type_Int == 1)
      {
        this.jdField_c_of_type_Int = VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_c_of_type_Int);
      }
      if (this.d)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString);
        return;
      }
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_Int);
        return;
      }
    }
    catch (JSONException paramVVideoView)
    {
      boolean bool2;
      paramVVideoView.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.e("VVideoControlListenerImpl", 2, "open: ", paramVVideoView);
        return;
        if (bool2) {
          a(null);
        }
      }
    }
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.e(paramBoolean);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    paramOnVideoViewMethodListener.OnMethodSuccess(paramString, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a()));
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b() {}
  
  public void b(VVideoView paramVVideoView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "play: status=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a() + ", isPreload=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a() + ", videoinfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo + ", mStartPosition:" + this.jdField_a_of_type_Long);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_Int);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.b())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.c();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_Int);
  }
  
  public void b(VVideoView paramVVideoView, int paramInt) {}
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal exitFullScreen: ");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
    Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    localWindow.getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    localWindow.clearFlags(1024);
    if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && ((paramVVideoView.a().getInstance().getFragment() instanceof ViolaLazyFragment)))
    {
      paramVVideoView = (ViolaFragment)paramVVideoView.a().getInstance().getFragment();
      if (paramVVideoView != null)
      {
        paramVVideoView.showTitleBar();
        paramVVideoView.recoverStatusBar();
      }
    }
    k();
    if ((TextUtils.isEmpty(paramString)) && (paramOnVideoViewMethodListener != null)) {}
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("hasUI", false);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (Exception paramVVideoView)
    {
      QLog.e("VVideoControlListenerImpl", 2, "exitFullScreen error = : " + paramVVideoView.getMessage());
    }
  }
  
  public void b(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "resetSrc: " + paramJSONObject);
    }
    this.d = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.f();
    a(paramVVideoView, paramJSONObject);
  }
  
  public void b(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void b_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.d(paramBoolean);
  }
  
  public void beforeVideoStart()
  {
    boolean bool = true;
    int i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_e_of_type_JavaLangString);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_Boolean) {
        break label117;
      }
      i = 1;
      localObject = new VideoEntity.Builder().setContentId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_e_of_type_JavaLangString).setPage(this.jdField_a_of_type_AndroidAppActivity);
      if (i != 1) {
        break label122;
      }
    }
    for (;;)
    {
      localObject = ((VideoEntity.Builder)localObject).ignoreReport(bool).setContentType(i).setVideoDuration(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_d_of_type_Int).addCustomParams(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_a_of_type_JavaUtilMap).setIdentifier(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.jdField_e_of_type_JavaLangString).build();
      VideoReport.bindVideoPlayerInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer, (VideoEntity)localObject);
      return;
      label117:
      i = 2;
      break;
      label122:
      bool = false;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.l();
    VideoVolumeController.a().a(true, "viola video");
    if (this.jdField_b_of_type_Boolean) {
      VideoFeedsHelper.b(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void c(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.d();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.c(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("videoToken", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a());
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
    }
  }
  
  public void c(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.c(paramBoolean);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.k();
    VideoVolumeController.a().a(false, "viola video");
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.f();
  }
  
  public void e() {}
  
  public void e(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.m();
    VideoVolumeController.a().b(this.jdField_a_of_type_AndroidAppActivity);
    VideoVolumeController.a().b(this);
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.g();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.i();
  }
  
  public void g(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.h();
  }
  
  public void g_(int paramInt)
  {
    this.jdField_a_of_type_Long = (paramInt * 1000);
  }
  
  public void h()
  {
    if (!this.e)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_c_of_type_Int);
      this.f = true;
    }
  }
  
  public void i()
  {
    if (!this.e)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_c_of_type_Int);
      this.f = true;
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new VVideoDelegate.1(this), 0L);
      g();
    }
  }
  
  public void j()
  {
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new VVideoDelegate.2(this), 0L);
  }
  
  public void onBufferEnd()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.h()) {
      a(2, null);
    }
    while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.g()) {
      return;
    }
    a(4, null);
  }
  
  public void onBufferStart()
  {
    a(3, null);
  }
  
  public void onCompletion()
  {
    a(5, null);
  }
  
  public void onFirstFrameRendered()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("firstFrameReady", null);
    if (this.h) {
      a(2, null);
    }
    this.g = true;
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.e(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.e(true);
  }
  
  public void onPhoneCome()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.d();
  }
  
  public void onProgressChanged(long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentTime", a(paramLong));
      localJSONObject.put("totalTime", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a() / 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.e(true);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.jdField_a_of_type_Int == -1) {
          this.jdField_a_of_type_Int = VideoVolumeController.a().a(3);
        }
        localJSONObject.put("value", paramInt / this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("volumeChange", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.e(false);
    }
  }
  
  public void onVideoEnd(int paramInt)
  {
    a(5, null);
  }
  
  public void onVideoError(int paramInt1, int paramInt2, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramInt1 == 202) && (paramInt2 == 108)) {}
    try
    {
      localJSONObject.put("code", "2");
      for (;;)
      {
        a(6, paramString, localJSONObject);
        return;
        localJSONObject.put("code", paramInt1 + "-" + paramInt2);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void onVideoOpen()
  {
    this.g = false;
    this.h = false;
  }
  
  public void onVideoPause()
  {
    a(4, null);
  }
  
  public void onVideoPrepared()
  {
    a(1, null);
  }
  
  public void onVideoRestart()
  {
    a(2, null);
  }
  
  public void onVideoStart()
  {
    if (this.g) {
      a(2, null);
    }
    this.h = true;
  }
  
  public void onVideoStop()
  {
    a(7, null);
    this.h = false;
    this.g = false;
    VideoReport.unbindVideoPlayerInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoDelegate
 * JD-Core Version:    0.7.0.1
 */