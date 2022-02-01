package com.tencent.biz.qqcircle.richframework.preload.coldboot;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.requests.QCircleTabPreloadFeedRequest;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;

public class QCircleColdBootPreloadTask
  implements IPreloadTask
{
  private static final long a = ;
  private final int b;
  private final IPreloadResultCallback c;
  private volatile long d = 0L;
  private FeedCloudMeta.StFeed e;
  private String f;
  private FeedCloudRead.StGetFeedListRsp g;
  private volatile boolean h;
  
  public QCircleColdBootPreloadTask(int paramInt, IPreloadResultCallback paramIPreloadResultCallback)
  {
    this.b = paramInt;
    this.c = paramIPreloadResultCallback;
  }
  
  private void a(QCircleColdBootPreloadTask.InitListener paramInitListener)
  {
    RFThreadManager.getSerialThreadHandler().post(new QCircleColdBootPreloadTask.2(this, paramInitListener));
  }
  
  private void a(@NonNull FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    this.f = paramStGetFeedListRsp.feedAttchInfo.get();
    this.g = paramStGetFeedListRsp;
    b(paramStGetFeedListRsp);
    paramStGetFeedListRsp = paramStGetFeedListRsp.vecFeed.get();
    if (paramStGetFeedListRsp.size() > 0)
    {
      this.e = ((FeedCloudMeta.StFeed)paramStGetFeedListRsp.get(0));
      this.c.doPreloadImage(this.e);
      this.c.doPreloadVideo(this.e);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resolvePreloadRsp success feed size:");
      localStringBuilder.append(paramStGetFeedListRsp.size());
      localStringBuilder.append(" | Cover:");
      localStringBuilder.append(this.e.cover.picUrl.get());
      localStringBuilder.append(" | Video:");
      localStringBuilder.append(this.e.video.playUrl.get());
      QLog.d("QCircleColdBootPreloadTask", 1, localStringBuilder.toString());
      return;
    }
    this.e = null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resolvePreloadRsp failed!feed size:");
    localStringBuilder.append(paramStGetFeedListRsp.size());
    QLog.e("QCircleColdBootPreloadTask", 1, localStringBuilder.toString());
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedListRsp != null))
    {
      a(paramStGetFeedListRsp);
      paramString = new StringBuilder();
      paramString.append("handlePreloadFeedResponse onReceive: expire time stamp:");
      paramString.append(this.d);
      paramString.append(" | source:");
      paramString.append(this.b);
      QLog.d("QCircleColdBootPreloadTask", 1, paramString.toString());
      a(paramStGetFeedListRsp.toByteArray());
      return;
    }
    QLog.e("QCircleColdBootPreloadTask", 1, new Object[] { "handlePreloadFeedResponse isSuc:", Boolean.valueOf(paramBoolean), ",retCode:", Long.valueOf(paramLong), ",errMsg:", paramString, ",source:", Integer.valueOf(this.b) });
    d();
    this.d = (System.currentTimeMillis() + a * 1000L);
  }
  
  private void b(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    RFThreadManager.execute(new QCircleColdBootPreloadTask.4(this, paramStGetFeedListRsp));
  }
  
  private boolean c()
  {
    return System.currentTimeMillis() > this.d;
  }
  
  private void d()
  {
    this.e = null;
    this.f = null;
    this.d = 0L;
    this.g = null;
  }
  
  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cold_boot_data");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  void a()
  {
    if (!c())
    {
      QLog.e("QCircleColdBootPreloadTask", 1, new Object[] { "last preload rsp remains,source: ", Integer.valueOf(this.b) });
      return;
    }
    QLog.d("QCircleColdBootPreloadTask", 1, new Object[] { "preloadFeed,source: ", Integer.valueOf(this.b), ", attachInfo:", this.f });
    VSNetworkHelper.getInstance().sendRequest(new QCircleTabPreloadFeedRequest(this.b, this.f), new QCircleColdBootPreloadTask.3(this));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    String str = e();
    QLog.d("QCircleColdBootPreloadTask", 1, new Object[] { "savePreloadData, key: ", str });
    SharedPreferences localSharedPreferences = QCirclePluginConfig.c();
    if (localSharedPreferences != null)
    {
      paramArrayOfByte = new String(Base64.encode(paramArrayOfByte, 0));
      localSharedPreferences.edit().putString(str, paramArrayOfByte).apply();
      QLog.d("QCircleColdBootPreloadTask", 1, new Object[] { "savePreloadData success, key: ", str });
    }
  }
  
  public FeedCloudRead.StGetFeedListRsp b()
  {
    String str = e();
    QLog.d("QCircleColdBootPreloadTask", 1, new Object[] { "getPreloadData, key: ", str });
    Object localObject = QCirclePluginConfig.c();
    if (localObject != null) {}
    try
    {
      localObject = ((SharedPreferences)localObject).getString(str, "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = new FeedCloudRead.StGetFeedListRsp();
        localStGetFeedListRsp.mergeFrom((byte[])localObject);
        QLog.d("QCircleColdBootPreloadTask", 1, new Object[] { "getPreloadData success, key: ", str });
        return localStGetFeedListRsp;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String getAttachInfo()
  {
    return this.f;
  }
  
  public byte[] getPreloadRspData()
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = this.g;
    if (localStGetFeedListRsp != null) {
      return localStGetFeedListRsp.toByteArray();
    }
    return null;
  }
  
  public boolean hasPreloadData()
  {
    FeedCloudMeta.StFeed localStFeed = this.e;
    return (localStFeed != null) && (localStFeed.has());
  }
  
  public void preloadFeed()
  {
    if (!this.h)
    {
      a(new QCircleColdBootPreloadTask.1(this));
      return;
    }
    a();
  }
  
  public void removePreloadData()
  {
    String str = e();
    QLog.d("QCircleColdBootPreloadTask", 1, new Object[] { "removePreloadData, key: ", str });
    SharedPreferences localSharedPreferences = QCirclePluginConfig.c();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().remove(str).apply();
      QLog.d("QCircleColdBootPreloadTask", 1, new Object[] { "removePreloadData success, key: ", str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadTask
 * JD-Core Version:    0.7.0.1
 */