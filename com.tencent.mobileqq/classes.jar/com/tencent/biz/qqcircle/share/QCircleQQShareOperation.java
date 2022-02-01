package com.tencent.biz.qqcircle.share;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._ChatActivityConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.flutter.QQCircleMethodMine;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.report.QCircleRecentlyChatReportHelper;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleQQShareOperation
  extends QCircleBaseShareOperation
{
  private HostForwardUtils a;
  
  public QCircleQQShareOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    if (this.a == null) {
      this.a = new HostForwardUtils();
    }
    if (f() == null)
    {
      QLog.d("QCircleQQShare", 1, "[createHostForwardApi] share info should not be null.");
      return;
    }
    QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo localQCircleForwardExtraTypeInfo = QCircleRecentlyChatReportHelper.a(f().c);
    this.a.registerForwardReportParam(paramIntent, g(), h(), localQCircleForwardExtraTypeInfo);
    this.a.registerForwardResultReceiver(paramIntent);
    this.a.addForwardType(paramIntent, paramString);
  }
  
  private void u()
  {
    if ((!a(57)) && (!QCircleConfigHelper.bg()))
    {
      if (a(32))
      {
        y();
        return;
      }
      if (a(31))
      {
        x();
        return;
      }
      if (c())
      {
        w();
        return;
      }
      v();
      return;
    }
    z();
  }
  
  private void v()
  {
    if (f().c != null) {
      localObject = f().c.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(25).setSubActionType(2);
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
  
  private void w()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(d()).setSubActionType(3).setThrActionType(1).setExt6(String.valueOf(f().f)).setPageId(g()));
  }
  
  private void x()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(f().b.poster.id.get()).setActionType(6).setSubActionType(4).setThrActionType(1).setPageId(g()));
  }
  
  private void y()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(f().b.poster.id.get()).setActionType(11).setSubActionType(9).setThrActionType(1).setExt9(k()).setFeedReportInfo(l()).setPageId(g()));
  }
  
  private void z()
  {
    a(25, 2, f().c, "");
    a("share", "qq_aio");
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (f().b.share != null) && (i() != null))
    {
      Intent localIntent = a(i(), f().b);
      if (localIntent == null)
      {
        QCircleToast.a(HardCodeUtil.a(2131911951), 0);
        return;
      }
      a(true);
      QQCircleMethodMine.putFeedInfo(f().b);
      a(localIntent, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
      i().startActivityForResult(localIntent, QCircleHostConstants._ChatActivityConstants.FORWARD_REQUEST());
      QLog.d("QCircleQQShare", 1, "shareToQQ  success");
      u();
      QCircleRecentlyChatReportHelper.a(g(), h()).c(f().c);
      SharePreferenceUtils.a(i(), "share_lately_type_key", "share_type_qq");
      return;
    }
    a("QCircleQQShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleQQShareOperation
 * JD-Core Version:    0.7.0.1
 */