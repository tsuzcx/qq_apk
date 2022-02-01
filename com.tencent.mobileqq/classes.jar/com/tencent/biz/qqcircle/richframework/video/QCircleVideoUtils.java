package com.tencent.biz.qqcircle.richframework.video;

import android.content.Context;
import android.net.Uri;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.helpers.QCircleVideoExchangeHelper;
import com.tencent.biz.qqcircle.utils.StringUtil;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QCircleVideoUtils
{
  private static final String a;
  private static final boolean b;
  private static final long c = QCircleConfigHelper.a("qqcircle", "qqcircle_video_trigger_downgrade_speed", Integer.valueOf(500)).intValue();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(RFApplication.getApplication().getExternalCacheDir());
    localStringBuilder.append("/superplayer/170303102");
    a = localStringBuilder.toString();
    boolean bool = true;
    if (QCircleConfigHelper.a("qqcircle", "qqcircle_video_enable_rate_bit_pre_select", Integer.valueOf(1)).intValue() <= 0) {
      bool = false;
    }
    b = bool;
  }
  
  public static SuperPlayerVideoInfo a(String paramString1, String paramString2)
  {
    if ((!StringUtil.a(paramString1)) && (paramString2 == null)) {
      return SuperPlayerFactory.createVideoInfoForTVideo(30301, paramString1);
    }
    if (!StringUtil.a(paramString2))
    {
      Object localObject = c(paramString2, paramString1);
      QLog.i("QCircleVideoUtils", 1, String.format("createSuperVideoInfo fileId:%s, url:%s", new Object[] { localObject, paramString2 }));
      paramString1 = QCirclePluginUtil.b(paramString2);
      paramString2 = SuperPlayerFactory.createVideoInfoForUrl(QCirclePluginUtil.a("PhotoSvrList", "DownloadVideoHttps", paramString2, paramString1), 101, (String)localObject, "");
      if (paramString1 != null)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramString1);
        paramString2.setUrlHostList((ArrayList)localObject);
      }
      return paramString2;
    }
    return null;
  }
  
  public static String a(FeedCloudMeta.StVideo paramStVideo)
  {
    if (!b)
    {
      QLog.i("QCircleVideoUtils", 1, "selectUrlByDownloadSpeed not enable");
      return paramStVideo.playUrl.get();
    }
    if (b(paramStVideo.playUrl.get(), paramStVideo.fileId.get()))
    {
      QLog.i("QCircleVideoUtils", 1, "stop selectUrlByDownloadSpeed because of hit cache");
      return paramStVideo.playUrl.get();
    }
    long l = QCircleBaseFragment.b.getCurrentPrediction();
    QLog.i("QCircleVideoUtils", 1, String.format("selectUrlByDownloadSpeed start, predictDownloadSpeed:%d", new Object[] { Long.valueOf(l) }));
    if (l < c)
    {
      FeedCloudMeta.StVideoUrl localStVideoUrl = QCircleVideoExchangeHelper.a(paramStVideo.vecVideoUrl.get());
      if ((localStVideoUrl != null) && (!StringUtil.a(localStVideoUrl.playUrl.get())))
      {
        paramStVideo = new StringBuilder();
        paramStVideo.append("selectUrlByDownloadSpeed hit, url:");
        paramStVideo.append(localStVideoUrl.playUrl.get());
        QLog.i("QCircleVideoUtils", 1, paramStVideo.toString());
        return localStVideoUrl.playUrl.get();
      }
      QLog.i("QCircleVideoUtils", 1, "selectUrlByDownloadSpeed target url is null or empty");
    }
    QLog.i("QCircleVideoUtils", 1, "selectUrlByDownloadSpeed use original video url");
    return paramStVideo.playUrl.get();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(String.format("/%s.mp4", new Object[] { c(paramString1, paramString2) }));
    return new File(localStringBuilder.toString()).exists();
  }
  
  private static String c(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Uri.parse(paramString1).getPathSegments().get(0);
      if (paramString1.contains(".mp4"))
      {
        paramString1 = paramString1.substring(0, paramString1.indexOf(".mp4"));
        return paramString1;
      }
      return paramString2;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.video.QCircleVideoUtils
 * JD-Core Version:    0.7.0.1
 */