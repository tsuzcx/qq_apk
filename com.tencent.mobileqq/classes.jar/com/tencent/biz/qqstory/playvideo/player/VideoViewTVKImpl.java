package com.tencent.biz.qqstory.playvideo.player;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.URLUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.Arrays;

public class VideoViewTVKImpl
  implements IVideoView
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  final Context jdField_a_of_type_AndroidContentContext;
  IVideoView.OnCompletionListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnCompletionListener;
  IVideoView.OnDownloadListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener;
  IVideoView.OnErrorListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnErrorListener;
  IVideoView.OnInfoListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnInfoListener;
  IVideoView.OnPreparedListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnPreparedListener;
  private StoryPlayerTVKWrapper.ReportData jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData = new StoryPlayerTVKWrapper.ReportData();
  TVK_IMediaPlayer.OnSeekCompleteListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnSeekCompleteListener;
  TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  final IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 5;
  String jdField_c_of_type_JavaLangString;
  String d;
  private String e = "bus_type_qqstory";
  
  public VideoViewTVKImpl(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "VideoViewTVKImpl";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramString);
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = TVK_SDKMgr.getProxyFactory().createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    SLog.d(this.jdField_a_of_type_JavaLangString, "TVK info, sdk:%s", new Object[] { TVK_SDKMgr.getSdkVersion() });
  }
  
  public static TVK_PlayerVideoInfo a(String paramString1, String paramString2, String paramString3)
  {
    return StoryPlayerTVKWrapper.a(paramString1, paramString2, paramString3);
  }
  
  private void a(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (paramTVK_PlayerVideoInfo != null)
    {
      paramTVK_PlayerVideoInfo.setConfigMap("ff_probesize", String.valueOf(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getFFProbesize()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_ff_probelist_switch", String.valueOf(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isFFProbelistSwitch()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_download_async_io", String.valueOf(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isDownloadAsyncIo()));
      paramTVK_PlayerVideoInfo.setConfigMap("httpbuffertime_for_playpreload", String.valueOf(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getPreplayTimeLimit()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_switch", String.valueOf(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getDynamicBufferSwitch()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_config_json", String.valueOf(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getDynamicBufferConfig()));
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = TVK_SDKMgr.getProxyFactory().createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new VideoViewTVKImpl.2(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new VideoViewTVKImpl.3(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new VideoViewTVKImpl.4(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new VideoViewTVKImpl.5(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(new VideoViewTVKImpl.6(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoOutputFrameListener(new VideoViewTVKImpl.7(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new VideoViewTVKImpl.8(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return (int)localTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  }
  
  public StoryPlayerTVKWrapper.ReportData a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData;
  }
  
  public void a()
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "stopPlayback, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void a(int paramInt)
  {
    a().setVisibility(paramInt);
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnCompletionListener = paramOnCompletionListener;
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener = paramOnDownloadListener;
  }
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnErrorListener = paramOnErrorListener;
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnInfoListener = paramOnInfoListener;
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnPreparedListener = paramOnPreparedListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramString3, "auto", paramLong, paramInt1, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData.jdField_a_of_type_JavaLangString != null) {
      SLog.a(this.jdField_a_of_type_JavaLangString, "%s", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData;
    ((StoryPlayerTVKWrapper.ReportData)localObject1).jdField_a_of_type_JavaLangString = paramString1;
    boolean bool;
    if (paramString3 == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StoryPlayerTVKWrapper.ReportData)localObject1).jdField_a_of_type_Boolean = bool;
    if ((paramString2 != null) && (paramString3 != null))
    {
      this.jdField_c_of_type_Int = TVKPreloader.a(new TVKPreloader.PreloadItem(paramString1, paramString3, paramString2, "TVKsetVideoPath"));
      SLog.d(this.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d", new Object[] { paramString1, Integer.valueOf(this.jdField_c_of_type_Int) });
    }
    localObject1 = (DownloadUrlManager)SuperManager.a(28);
    this.jdField_b_of_type_JavaLangString = paramString1;
    Object localObject2 = DownloadTask.a(paramString1, 0);
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramString3;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      f();
    }
    paramString3 = PlayModeUtils.a(paramInt2);
    paramString2 = a((String)localObject2, this.jdField_c_of_type_JavaLangString, this.e);
    paramString2.setConfigMap("keep_last_frame", "true");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      localObject2 = new File(this.jdField_c_of_type_JavaLangString);
      if (FileCacheUtils.a((File)localObject2))
      {
        paramString3.f = SystemClock.uptimeMillis();
        paramString3.jdField_a_of_type_Int = 1;
        SLog.d(this.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 4, vid=%s", new Object[] { paramString1 });
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, 0L, 0L, null, paramString2);
        this.jdField_b_of_type_Int = 0;
        return;
      }
      if (((File)localObject2).exists()) {
        paramString3.jdField_a_of_type_Int = 2;
      } else {
        paramString3.jdField_a_of_type_Int = 3;
      }
    }
    else
    {
      paramString3.jdField_a_of_type_Int = 4;
    }
    if (TextUtils.isEmpty(this.d))
    {
      if (paramString1.trim().length() > 0)
      {
        paramString3 = new TVK_UserInfo("", "");
        paramString2.setPlayType(2);
        paramString2.setConfigMap("enable_cover_frame", "true");
        paramString2.setCid(paramString1);
        paramString2.setVid(paramString1);
        paramString2.setNeedCharge(false);
        a(paramString2);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, paramString3, paramString2, paramString4, 0L, 0L);
        this.jdField_b_of_type_Int = 1;
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "play by vid");
        return;
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "params is invalid");
      return;
    }
    if (!this.d.contains("authkey"))
    {
      paramString4 = (VideoServerInfoManager)SuperManager.a(4);
      localObject2 = paramString4.b();
      if (localObject2 != null)
      {
        this.d = URLUtil.a(this.d, "authkey", (String)localObject2);
        paramString3.f = SystemClock.uptimeMillis();
        paramString3 = ((DownloadUrlManager)localObject1).a(this.d.replace("https://", "http://"));
        SLog.d(this.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 3, vid=%s, urls=%s", new Object[] { paramString1, Arrays.toString(paramString3) });
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString3, 0L, 0L, paramString2, null);
        this.jdField_b_of_type_Int = 1;
        return;
      }
      Bosses.get().postJob(new VideoViewTVKImpl.1(this, this.jdField_a_of_type_JavaLangString, paramString4, paramString3, (DownloadUrlManager)localObject1, paramString1, paramString2));
      return;
    }
    paramString3.f = SystemClock.uptimeMillis();
    TVKPreloader.a();
    paramString3 = ((DownloadUrlManager)localObject1).a(this.d.replace("https://", "http://"));
    SLog.d(this.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 2, vid=%s, urls=%s", new Object[] { paramString1, Arrays.toString(paramString3) });
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString3, 0L, 0L, paramString2, null);
    this.jdField_b_of_type_Int = 1;
  }
  
  public boolean a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public void b()
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "start, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.start();
    }
  }
  
  public void c()
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "pause, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
  }
  
  public void d()
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "restart, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      if (localTVK_IMediaPlayer.isPlaying()) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, 0);
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localObject != null) {
      ThreadManager.executeOnSubThread(new VideoViewTVKImpl.9(this, (TVK_IMediaPlayer)localObject));
    }
    localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
    if ((localObject != null) && (((View)localObject).getParent() != null))
    {
      localObject = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl
 * JD-Core Version:    0.7.0.1
 */