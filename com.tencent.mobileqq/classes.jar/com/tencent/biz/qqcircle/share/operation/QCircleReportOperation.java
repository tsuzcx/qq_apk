package com.tencent.biz.qqcircle.share.operation;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.Builder;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.ContentIdBuilder;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder;
import com.tencent.biz.qqcircle.utils.QCircleEvilReportUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.event.QCircleTransActivityLifeEvent;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleReportOperation
  extends QCircleBaseShareOperation
{
  public QCircleReportOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private QCircleEvilReportInfo A()
  {
    String str1 = QCircleEvilReportUtils.a(f().b.poster.id.get());
    if (TextUtils.isEmpty(str1)) {
      return null;
    }
    String str2 = new QCircleEvilReportInfo.ContentIdBuilder().b(f().b.id.get()).e(String.valueOf(f().b.createTime.get())).g("1").a();
    return new QCircleEvilReportInfo.Builder().e(str1).d("25014").c("wezone_feed").g(str2).a();
  }
  
  private void u()
  {
    if (f().c != null) {
      localObject = f().c.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(23).setSubActionType(2);
    if ((f().c != null) && (f().c.mFeed != null)) {
      localObject = f().c.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    Object localObject = localDataBuilder.setToUin((String)localObject);
    int i;
    if (f().c != null) {
      i = f().c.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i).setPageId(g())));
  }
  
  private void v()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(f().b.poster.id.get()).setActionType(11).setSubActionType(8).setThrActionType(0).setExt9(k()).setFeedReportInfo(l()).setPageId(g()));
  }
  
  private void w()
  {
    a(23, 2, f().c, "");
    a("report", null);
  }
  
  private void x()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(f().b.share.poster.id.get()).setActionType(6).setSubActionType(5).setThrActionType(2).setExt6(f().f));
  }
  
  private QCircleEvilReportInfo y()
  {
    int i = f().d;
    if (i != 0)
    {
      if (i != 4) {
        return null;
      }
      return z();
    }
    return A();
  }
  
  private QCircleEvilReportInfo z()
  {
    String str = new QCircleEvilReportInfo.ContentIdBuilder().f(f().f).a();
    return new QCircleEvilReportInfo.Builder().e(f().h).f("1").d("25058").g(str).a("QZONE").b("2400001").c("wezone_topic").a();
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (i() != null))
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleTransActivityLifeEvent(0));
      QCircleEvilReportInfo localQCircleEvilReportInfo = y();
      if (localQCircleEvilReportInfo != null) {
        QCircleEvilReportUtils.a(localQCircleEvilReportInfo);
      }
      if (f().d == 4)
      {
        x();
        return;
      }
      if ((!a(57)) && (!QCircleConfigHelper.bg()))
      {
        if (a(32))
        {
          v();
          return;
        }
        u();
        return;
      }
      w();
      return;
    }
    a("QCircleReportShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleReportOperation
 * JD-Core Version:    0.7.0.1
 */