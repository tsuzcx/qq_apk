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
  public String a = "VideoViewTVKImpl";
  final IVideoViewBase b;
  TVK_IMediaPlayer c;
  final Context d;
  String e;
  String f;
  String g;
  long h;
  int i;
  int j = 0;
  int k = 5;
  IVideoView.OnCompletionListener l;
  IVideoView.OnErrorListener m;
  IVideoView.OnInfoListener n;
  IVideoView.OnPreparedListener o;
  IVideoView.OnDownloadListener p;
  TVK_IMediaPlayer.OnSeekCompleteListener q;
  private boolean r = false;
  private boolean s = false;
  private StoryPlayerTVKWrapper.ReportData t = new StoryPlayerTVKWrapper.ReportData();
  private String u = "bus_type_qqstory";
  private long v;
  
  public VideoViewTVKImpl(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(paramString);
    this.a = localStringBuilder.toString();
    this.d = paramContext.getApplicationContext();
    this.b = TVK_SDKMgr.getProxyFactory().createVideoView_Scroll(this.d);
    SLog.d(this.a, "TVK info, sdk:%s", new Object[] { TVK_SDKMgr.getSdkVersion() });
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
  
  private void m()
  {
    this.c = TVK_SDKMgr.getProxyFactory().createMediaPlayer(this.d, this.b);
    this.c.setLoopback(this.r);
    this.c.setOutputMute(this.s);
    this.c.setXYaxis(2);
    this.c.setOnCompletionListener(new VideoViewTVKImpl.2(this));
    this.c.setOnErrorListener(new VideoViewTVKImpl.3(this));
    this.c.setOnInfoListener(new VideoViewTVKImpl.4(this));
    this.c.setOnVideoPreparedListener(new VideoViewTVKImpl.5(this));
    this.c.setOnDownloadCallback(new VideoViewTVKImpl.6(this));
    this.c.setOnVideoOutputFrameListener(new VideoViewTVKImpl.7(this));
    this.c.setOnSeekCompleteListener(new VideoViewTVKImpl.8(this));
  }
  
  public View a()
  {
    return (View)this.b;
  }
  
  public void a(int paramInt)
  {
    a().setVisibility(paramInt);
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    this.l = paramOnCompletionListener;
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener)
  {
    this.p = paramOnDownloadListener;
  }
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    this.m = paramOnErrorListener;
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    this.n = paramOnInfoListener;
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    this.o = paramOnPreparedListener;
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
    if (i()) {
      this.c.stop();
    }
    if (this.t.b != null) {
      SLog.a(this.a, "%s", this.t);
    }
    this.t.a();
    Object localObject1 = this.t;
    ((StoryPlayerTVKWrapper.ReportData)localObject1).b = paramString1;
    boolean bool;
    if (paramString3 == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StoryPlayerTVKWrapper.ReportData)localObject1).c = bool;
    if ((paramString2 != null) && (paramString3 != null))
    {
      this.k = TVKPreloader.b(new TVKPreloader.PreloadItem(paramString1, paramString3, paramString2, "TVKsetVideoPath"));
      SLog.d(this.a, "setVideoPath, vid=%s, cache=%d", new Object[] { paramString1, Integer.valueOf(this.k) });
    }
    localObject1 = (DownloadUrlManager)SuperManager.a(28);
    this.e = paramString1;
    Object localObject2 = DownloadTask.b(paramString1, 0);
    this.f = paramString2;
    this.g = paramString3;
    if (this.c == null) {
      m();
    }
    paramString3 = PlayModeUtils.a(paramInt2);
    paramString2 = a((String)localObject2, this.f, this.u);
    paramString2.setConfigMap("keep_last_frame", "true");
    this.v = System.currentTimeMillis();
    if (!TextUtils.isEmpty(this.f))
    {
      localObject2 = new File(this.f);
      if (FileCacheUtils.a((File)localObject2))
      {
        paramString3.g = SystemClock.uptimeMillis();
        paramString3.a = 1;
        SLog.d(this.a, "TVK_IMediaPlayer.openMediaPlayerByUrl, 4, vid=%s", new Object[] { paramString1 });
        this.c.openMediaPlayerByUrl(this.d, this.f, 0L, 0L, null, paramString2);
        this.j = 0;
        return;
      }
      if (((File)localObject2).exists()) {
        paramString3.a = 2;
      } else {
        paramString3.a = 3;
      }
    }
    else
    {
      paramString3.a = 4;
    }
    if (TextUtils.isEmpty(this.g))
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
        this.c.openMediaPlayer(this.d, paramString3, paramString2, paramString4, 0L, 0L);
        this.j = 1;
        QLog.i(this.a, 1, "play by vid");
        return;
      }
      QLog.w(this.a, 1, "params is invalid");
      return;
    }
    if (!this.g.contains("authkey"))
    {
      paramString4 = (VideoServerInfoManager)SuperManager.a(4);
      localObject2 = paramString4.f();
      if (localObject2 != null)
      {
        this.g = URLUtil.a(this.g, "authkey", (String)localObject2);
        paramString3.g = SystemClock.uptimeMillis();
        paramString3 = ((DownloadUrlManager)localObject1).b(this.g.replace("https://", "http://"));
        SLog.d(this.a, "TVK_IMediaPlayer.openMediaPlayerByUrl, 3, vid=%s, urls=%s", new Object[] { paramString1, Arrays.toString(paramString3) });
        this.c.openMediaPlayerByUrl(this.d, paramString3, 0L, 0L, paramString2, null);
        this.j = 1;
        return;
      }
      Bosses.get().postJob(new VideoViewTVKImpl.1(this, this.a, paramString4, paramString3, (DownloadUrlManager)localObject1, paramString1, paramString2));
      return;
    }
    paramString3.g = SystemClock.uptimeMillis();
    TVKPreloader.a();
    paramString3 = ((DownloadUrlManager)localObject1).b(this.g.replace("https://", "http://"));
    SLog.d(this.a, "TVK_IMediaPlayer.openMediaPlayerByUrl, 2, vid=%s, urls=%s", new Object[] { paramString1, Arrays.toString(paramString3) });
    this.c.openMediaPlayerByUrl(this.d, paramString3, 0L, 0L, paramString2, null);
    this.j = 1;
  }
  
  public StoryPlayerTVKWrapper.ReportData b()
  {
    return this.t;
  }
  
  public void c()
  {
    SLog.d(this.a, "stopPlayback, %s", new Object[] { this.c });
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.c;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.c.release();
      this.c = null;
    }
  }
  
  public void d()
  {
    SLog.d(this.a, "start, %s", new Object[] { this.c });
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.c;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.start();
    }
  }
  
  public long e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.c;
    if (localTVK_IMediaPlayer != null) {
      return (int)localTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public void f()
  {
    SLog.d(this.a, "pause, %s", new Object[] { this.c });
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.c;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
  }
  
  public void g()
  {
    SLog.d(this.a, "restart, %s", new Object[] { this.c });
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.c;
    if (localTVK_IMediaPlayer != null)
    {
      if (localTVK_IMediaPlayer.isPlaying()) {
        this.c.stop();
      }
      a(this.e, this.f, this.g, this.h, this.i, 0);
    }
  }
  
  public long h()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.c;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public boolean i()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.c;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public int j()
  {
    return this.j;
  }
  
  public int k()
  {
    return this.k;
  }
  
  public void l()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ThreadManager.executeOnSubThread(new VideoViewTVKImpl.9(this, (TVK_IMediaPlayer)localObject));
    }
    localObject = this.b;
    if ((localObject != null) && (((View)localObject).getParent() != null))
    {
      localObject = ((View)this.b).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView((View)this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl
 * JD-Core Version:    0.7.0.1
 */