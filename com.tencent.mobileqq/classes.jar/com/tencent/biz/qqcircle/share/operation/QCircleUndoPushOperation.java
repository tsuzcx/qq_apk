package com.tencent.biz.qqcircle.share.operation;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashMap;
import java.util.Map;

public class QCircleUndoPushOperation
  extends QCircleBaseShareOperation
{
  public QCircleUndoPushOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private int u()
  {
    FeedCloudMeta.StPushList localStPushList = QCirclePushInfoManager.a().a(f().c.mFeed.id.get());
    if (localStPushList != null) {
      return localStPushList.hasClickCount.get();
    }
    return 0;
  }
  
  private void v()
  {
    Object localObject = f().c;
    QCircleLpReportDc05507.DataBuilder localDataBuilder = null;
    if (localObject != null) {
      localObject = f().c.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder1 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(122).setSubActionType(2).setPageId(g());
    localObject = f().c;
    String str = "";
    if ((localObject != null) && (f().c.mFeed != null)) {
      localObject = f().c.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(localDataBuilder1.setToUin((String)localObject)));
    localObject = localDataBuilder;
    if (f().c != null) {
      localObject = f().c.mFeed;
    }
    localDataBuilder = QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject).setActionType(122).setSubActionType(2).setPageId(g());
    localObject = str;
    if (f().c != null)
    {
      localObject = str;
      if (f().c.mFeed != null) {
        localObject = f().c.mFeed.poster.id.get();
      }
    }
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(localDataBuilder.setToUin((String)localObject)));
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (i() != null))
    {
      if (!QCirclePushInfoManager.a().d(f().b.id.get()))
      {
        QCircleToast.a(QCircleToast.d, 2131895938, 1);
        return;
      }
      QCirclePushInfoManager.a().a(f().b, null);
      e();
      v();
      a("share_panel_cancel", null);
      return;
    }
    a("QCircleUndoPushShare");
  }
  
  protected Map<String, Object> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("xsj_push_times", Integer.valueOf(u()));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleUndoPushOperation
 * JD-Core Version:    0.7.0.1
 */