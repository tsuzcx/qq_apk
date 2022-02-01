package com.tencent.biz.qqcircle.richframework.helper;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._SceneID;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.helpers.QCircleVideoExchangeHelper;
import com.tencent.biz.qqcircle.richframework.video.QCircleVideoUtils;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPreloadHelper
  implements ISPlayerPreDownloader.Listener
{
  private static final long d = QCircleConfigHelper.a("qqcircle", "qqcircle_video_preload_duration", Integer.valueOf(5000)).intValue();
  private static boolean e = true;
  protected final int a;
  private final ISPlayerPreDownloader b;
  private final ConcurrentHashMap<Integer, String> c = new ConcurrentHashMap();
  
  public VideoPreloadHelper(int paramInt)
  {
    this.a = paramInt;
    this.b = SuperPlayerFactory.createPreDownloader(RFApplication.getApplication(), QCircleHostConstants._SceneID.QZONE_VIDEO());
    this.b.setOnPreDownloadListener(this);
  }
  
  private int a(String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!e) {
      return -2;
    }
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = QCircleVideoUtils.a(paramString1, paramString2);
    if ((this.b != null) && (localSuperPlayerVideoInfo != null))
    {
      SuperPlayerDownOption localSuperPlayerDownOption = SuperPlayerDownOption.obtain();
      if (paramBoolean) {
        i = 2;
      } else {
        i = 0;
      }
      localSuperPlayerDownOption.quicEnableMode = i;
      int i = this.b.startPreDownload(localSuperPlayerVideoInfo, paramLong1, paramLong2, localSuperPlayerDownOption);
      QLog.d("VideoPreloadHelper", 1, String.format("startPreload:%s, vid:%s, url:%s, videoDuration:%d", new Object[] { Integer.valueOf(i), paramString1, paramString2, Long.valueOf(paramLong1) }));
      if ((this.c != null) && (localSuperPlayerVideoInfo.getFileId() != null)) {
        this.c.put(Integer.valueOf(i), localSuperPlayerVideoInfo.getFileId());
      }
      return i;
    }
    QLog.d("VideoPreloadHelper", 1, "invalid params");
    return -2;
  }
  
  protected int a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramLong, d, paramBoolean);
  }
  
  public void a()
  {
    if (this.b == null) {
      return;
    }
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.b.stopPreDownload(i);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    FeedCloudMeta.StVideo localStVideo = (FeedCloudMeta.StVideo)paramStFeed.video.get();
    boolean bool = QCirclePluginUtil.a(paramStFeed);
    QCircleVideoExchangeHelper.a().a(this.a, localStVideo, new VideoPreloadHelper.1(this, bool, localStVideo));
  }
  
  public void b()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.b;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.destory();
    }
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject) {}
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString) {}
  
  public void onPrepareError(int paramInt)
  {
    this.c.remove(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPrepareError:");
    localStringBuilder.append(paramInt);
    QLog.d("VideoPreloadHelper", 1, localStringBuilder.toString());
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    this.c.remove(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPrepareSuccess:");
    localStringBuilder.append(paramInt);
    QLog.d("VideoPreloadHelper", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.helper.VideoPreloadHelper
 * JD-Core Version:    0.7.0.1
 */