package com.tencent.biz.qqcircle.share.operation;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.DownLoadParams;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StImageUrl;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.util.Iterator;
import java.util.List;

public class QCircleSaveOperation
  extends QCircleBaseShareOperation
{
  public QCircleSaveOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private void b(String paramString)
  {
    if ((!a(57)) && (!QCircleConfigHelper.bg()))
    {
      if ((f().c != null) && (f().c.mFeed != null)) {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(f().c.mFeed).setActionType(105).setSubActionType(2).setToUin(f().c.mFeed.poster.id.get()).setIndex(f().c.mDataPosition).setExt1(paramString).setPageId(h())));
      }
    }
    else {
      a(105, 2, f().c, paramString);
    }
    a("save", null);
  }
  
  private QCircleRichMediaDownLoadManager.DownLoadParams u()
  {
    QCircleRichMediaDownLoadManager.DownLoadParams localDownLoadParams = new QCircleRichMediaDownLoadManager.DownLoadParams();
    int i = f().b.type.get();
    if (i != 2)
    {
      if (i != 3) {
        return localDownLoadParams;
      }
      localDownLoadParams.a(v(), 0, f().b.id.get());
      return localDownLoadParams;
    }
    localDownLoadParams.a(w(), 1, f().b.id.get());
    return localDownLoadParams;
  }
  
  private String v()
  {
    Object localObject1 = f().b.video.vecVideoUrl.get();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        if (((FeedCloudMeta.StVideoUrl)((List)localObject1).get(i)).levelType.get() == 20)
        {
          localObject1 = ((FeedCloudMeta.StVideoUrl)((List)localObject1).get(i)).playUrl.get();
          QLog.d("QCircleSaveShare", 1, "get video downLoad url success");
          break label101;
        }
        i += 1;
      }
    }
    localObject1 = "";
    label101:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = f().b.video.playUrl.get();
      QLog.d("QCircleSaveShare", 1, "get origin video downLoad url success");
    }
    return localObject2;
  }
  
  private String w()
  {
    Object localObject1 = (FeedCloudMeta.StImage)f().b.images.get(f().e);
    if ((localObject1 != null) && (((FeedCloudMeta.StImage)localObject1).vecImageUrl.size() > 0))
    {
      localObject1 = ((FeedCloudMeta.StImage)localObject1).vecImageUrl.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FeedCloudMeta.StImageUrl)((Iterator)localObject1).next();
        if (((FeedCloudMeta.StImageUrl)localObject2).levelType.get() == 4)
        {
          localObject1 = ((FeedCloudMeta.StImageUrl)localObject2).url.get();
          QLog.d("QCircleSaveShare", 1, "get pic downLoad url success");
          break label103;
        }
      }
    }
    localObject1 = "";
    label103:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = ((FeedCloudMeta.StImage)f().b.images.get(f().e)).picUrl.get();
      QLog.d("QCircleSaveShare", 1, "get origin pic downLoad url success");
    }
    return localObject2;
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (i() != null))
    {
      if (!HostNetworkUtils.isNetworkAvailable())
      {
        QCircleToast.a(HardCodeUtil.a(2131911960), 0);
        QLog.d("QCircleSaveShare", 4, "network not available");
        return;
      }
      Object localObject = u();
      ((QCircleRichMediaDownLoadManager.DownLoadParams)localObject).a(p());
      QCircleRichMediaDownLoadManager.a().a((QCircleRichMediaDownLoadManager.DownLoadParams)localObject);
      if (((QCircleRichMediaDownLoadManager.DownLoadParams)localObject).d() == 0) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      b((String)localObject);
      return;
    }
    a("QCircleSaveShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleSaveOperation
 * JD-Core Version:    0.7.0.1
 */