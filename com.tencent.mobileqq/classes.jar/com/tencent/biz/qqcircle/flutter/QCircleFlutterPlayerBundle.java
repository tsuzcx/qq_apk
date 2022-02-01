package com.tencent.biz.qqcircle.flutter;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.helpers.QCircleVideoExchangeHelper;
import com.tencent.biz.qqcircle.report.QCircleVideoReporter;
import com.tencent.biz.qqcircle.richframework.video.QCirclePlayer;
import com.tencent.biz.qqcircle.richframework.video.QCirclePlayerCallback;
import com.tencent.biz.qqcircle.utils.StringUtil;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.Collections;
import java.util.List;

final class QCircleFlutterPlayerBundle
  implements QCirclePlayerCallback
{
  QCirclePlayer a;
  Surface b;
  TextureRegistry.SurfaceTextureEntry c;
  FeedCloudMeta.StFeed d;
  FeedCloudMeta.StFeed e;
  
  public QCircleFlutterPlayerBundle(TextureRegistry paramTextureRegistry, int paramInt1, int paramInt2)
  {
    a(paramTextureRegistry, paramInt1, paramInt2);
  }
  
  private void a(TextureRegistry paramTextureRegistry, int paramInt1, int paramInt2)
  {
    this.c = paramTextureRegistry.createSurfaceTexture();
    paramTextureRegistry = this.c.surfaceTexture();
    paramTextureRegistry.setDefaultBufferSize(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[init] width=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height=");
    localStringBuilder.append(paramInt2);
    QLog.i("QCircleVideoFlutterBundle", 1, localStringBuilder.toString());
    this.b = new Surface(paramTextureRegistry);
    this.a = new QCirclePlayer();
    this.a.a(this, this.b);
  }
  
  public String a()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((FeedCloudMeta.StFeed)localObject).video != null)) {
      return QCirclePluginUtil.c(this.e.video.playUrl.get());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getPlayUrlKey] invalid feed, feed=");
    ((StringBuilder)localObject).append(this.e);
    QLog.w("QCircleVideoFlutterBundle", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if ((this.e != null) && (paramInt1 != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onVideoPassivePause] what=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("module=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", playTime=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", soloTime=");
      localStringBuilder.append(paramLong2);
      QLog.w("QCircleVideoFlutterBundle", 1, localStringBuilder.toString());
      RFThreadManager.getUIHandler().post(new QCircleFlutterPlayerBundle.4(this));
    }
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    long l1 = paramISuperPlayer.getDurationMs();
    long l2 = paramISuperPlayer.getVideoWidth();
    long l3 = paramISuperPlayer.getVideoHeight();
    RFThreadManager.getUIHandler().post(new QCircleFlutterPlayerBundle.3(this, l1, l2, l3));
  }
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    QLog.i("QCircleVideoFlutterBundle", 1, "triggerDowngradeVideoUrl start");
    Object localObject = this.e;
    if (localObject != null) {
      localObject = ((FeedCloudMeta.StFeed)localObject).video;
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = ((FeedCloudMeta.StVideo)localObject).vecVideoUrl.get();
    } else {
      localObject = null;
    }
    localObject = QCircleVideoExchangeHelper.a((List)localObject);
    if ((localObject != null) && (!StringUtil.a(((FeedCloudMeta.StVideoUrl)localObject).playUrl.get())))
    {
      if ((paramSuperPlayerVideoInfo != null) && (!paramSuperPlayerVideoInfo.getPlayUrl().equals(((FeedCloudMeta.StVideoUrl)localObject).playUrl.get())))
      {
        try
        {
          if (this.a != null)
          {
            QLog.i("QCircleVideoFlutterBundle", 1, String.format("triggerDowngradeVideoUrl:url: %s, startoffset:%d, levelType:%d", new Object[] { ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get(), Integer.valueOf((int)this.a.e()), Integer.valueOf(((FeedCloudMeta.StVideoUrl)localObject).levelType.get()) }));
            this.a.a(null, ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get(), (int)this.a.e());
            QCircleVideoReporter.a().a(this.a.p(), "video_play_downgrade_url", this.e, Collections.singletonList(QCircleReportHelper.newEntry("video_url", ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get())));
            return;
          }
        }
        catch (Exception paramSuperPlayerVideoInfo)
        {
          QLog.e("QCircleVideoFlutterBundle", 1, "[onDowngradeVideoUrl]", paramSuperPlayerVideoInfo);
        }
        return;
      }
      QLog.i("QCircleVideoFlutterBundle", 1, String.format("triggerDowngradeVideoUrl:return url is targetLevelType: %s, levelType:%d", new Object[] { ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get(), Integer.valueOf(((FeedCloudMeta.StVideoUrl)localObject).levelType.get()) }));
      return;
    }
    QLog.i("QCircleVideoFlutterBundle", 1, "triggerPlayLowResVideoUrl: url is null");
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, long paramLong)
  {
    QCirclePlayer localQCirclePlayer = this.a;
    if ((localQCirclePlayer != null) && (localQCirclePlayer.h()))
    {
      this.d = null;
      this.e = paramStFeed;
      QCircleVideoExchangeHelper.a().a(-1, paramStFeed.video, new QCircleFlutterPlayerBundle.1(this, paramLong, paramStFeed));
      return;
    }
    QLog.w("QCircleVideoFlutterBundle", 1, "[setVideoPath] invalid player");
    this.d = paramStFeed;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[dispose] thread=");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      QLog.d("QCircleVideoFlutterBundle", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((QCirclePlayer)localObject).f();
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((TextureRegistry.SurfaceTextureEntry)localObject).release();
      this.c = null;
    }
    this.d = null;
  }
  
  public void b(ISuperPlayer paramISuperPlayer)
  {
    RFThreadManager.getUIHandler().post(new QCircleFlutterPlayerBundle.5(this));
  }
  
  public void c()
  {
    if (this.d != null)
    {
      QLog.w("QCircleVideoFlutterBundle", 1, "[onInitSuccess] has pending feed");
      a(this.d, 0L);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleVideoFlutterBundle", 2, "[onFirstFrameRendered]");
    }
    RFThreadManager.getUIHandler().post(new QCircleFlutterPlayerBundle.2(this));
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public Object getReportData()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleFlutterPlayerBundle
 * JD-Core Version:    0.7.0.1
 */