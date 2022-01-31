package com.tencent.biz.qqstory.playvideo.player;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.URLUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.HashMap;
import npm;
import npn;
import npp;
import npr;
import npt;
import npv;
import npw;
import npx;

public class VideoViewTVKImpl
  implements IVideoView
{
  public static final SparseArray a;
  public int a;
  public final Context a;
  public IVideoView.OnCompletionListener a;
  public IVideoView.OnDownloadListener a;
  public IVideoView.OnErrorListener a;
  public IVideoView.OnInfoListener a;
  public IVideoView.OnPreparedListener a;
  public TVK_IMediaPlayer a;
  final IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  String jdField_a_of_type_JavaLangString;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new npm();
  }
  
  public VideoViewTVKImpl(Context paramContext)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = TVK_SDKMgr.getProxyFactory().createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    SLog.d("VideoViewTVKImpl", "TVK info, sdk:%s", new Object[] { TVK_SDKMgr.getSdkVersion() });
  }
  
  public static TVK_PlayerVideoInfo a(String paramString1, String paramString2)
  {
    SLog.d("VideoViewTVKImpl", "createPlayerVideoInfo, %s, %s", new Object[] { paramString1, paramString2 });
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20161223));
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_qqstory");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    if (!TextUtils.isEmpty(paramString2))
    {
      localTVK_PlayerVideoInfo.setConfigMap("file_dir", paramString2);
      paramString2 = paramString2.substring(0, paramString2.lastIndexOf(File.separator));
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = new File(paramString2);
        if ((paramString2 != null) && (!paramString2.exists())) {
          paramString2.mkdirs();
        }
      }
    }
    localTVK_PlayerVideoInfo.setConfigMap("RawVideoPlay", "true");
    localTVK_PlayerVideoInfo.setVid(paramString1);
    return localTVK_PlayerVideoInfo;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return (int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.removeAllListener();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void a(int paramInt)
  {
    a().setVisibility(paramInt);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)paramLong);
    }
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
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    DownloadUrlManager localDownloadUrlManager;
    Object localObject;
    for (;;)
    {
      return;
      if ((paramString2 != null) && (paramString3 != null)) {
        SLog.a("VideoViewTVKImpl", "setVideoPath, vid=%s, cache=%d", paramString1, Integer.valueOf(TVKPreloader.a(new TVKPreloader.PreloadItem(paramString1, paramString3, paramString2, "TVKsetVideoPath"))));
      }
      localDownloadUrlManager = (DownloadUrlManager)SuperManager.a(28);
      this.jdField_a_of_type_JavaLangString = paramString1;
      localObject = DownloadTask.a(paramString1, 0);
      this.b = paramString2;
      this.c = paramString3;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = TVK_SDKMgr.getProxyFactory().createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(1);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new npn(this));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new npp(this));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new npr(this));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new npt(this));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(new npv(this, paramString1));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoOutputFrameListener(new npw(this));
      }
      paramString2 = PlayModeUtils.a(paramInt);
      paramString3 = a((String)localObject, this.b);
      paramString3.setConfigMap("keep_last_frame", "true");
      if (!TextUtils.isEmpty(this.b))
      {
        localObject = new File(this.b);
        if (FileCacheUtils.a((File)localObject))
        {
          paramString2.f = SystemClock.uptimeMillis();
          paramString2.jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, this.b, 0L, 0L, null, paramString3);
          this.jdField_a_of_type_Int = 0;
          return;
        }
        if (((File)localObject).exists()) {
          paramString2.jdField_a_of_type_Int = 2;
        }
      }
      while (!TextUtils.isEmpty(this.c))
      {
        if (this.c.contains("authkey")) {
          break label487;
        }
        localObject = (VideoServerInfoManager)SuperManager.a(4);
        String str = ((VideoServerInfoManager)localObject).b();
        if (str == null) {
          break label462;
        }
        this.c = URLUtil.a(this.c, "authkey", str);
        paramString2.f = SystemClock.uptimeMillis();
        SLog.d("VideoViewTVKImpl", "TVK_IMediaPlayer.openMediaPlayerByUrl, 3, vid=%s", new Object[] { paramString1 });
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, localDownloadUrlManager.a(this.c.replace("https://", "http://")), 0L, 0L, paramString3, null);
        this.jdField_a_of_type_Int = 1;
        return;
        paramString2.jdField_a_of_type_Int = 3;
        continue;
        paramString2.jdField_a_of_type_Int = 4;
      }
    }
    label462:
    Bosses.get().postJob(new npx(this, (VideoServerInfoManager)localObject, paramString2, paramString1, localDownloadUrlManager, paramString3));
    return;
    label487:
    paramString2.f = SystemClock.uptimeMillis();
    SLog.d("VideoViewTVKImpl", "TVK_IMediaPlayer.openMediaPlayerByUrl, 2, vid=%s", new Object[] { paramString1 });
    TVKPreloader.a();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, localDownloadUrlManager.a(this.c.replace("https://", "http://")), 0L, 0L, paramString3, null);
    this.jdField_a_of_type_Int = 1;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      a(this.jdField_a_of_type_JavaLangString, this.b, this.c, 0);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl
 * JD-Core Version:    0.7.0.1
 */