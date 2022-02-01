package com.tencent.biz.qqcircle.share;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._ForwardRecentActivity;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils.ForwardInfoEntity;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.report.QCircleRecentlyChatReportHelper;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleSpecifiedFriendShareOperation
  extends QCircleBaseShareOperation
{
  private HostForwardUtils a;
  
  public QCircleSpecifiedFriendShareOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private void a(@NonNull Intent paramIntent)
  {
    a(paramIntent, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
    HostUIHelper.openHostEnvironment(new QCircleSpecifiedFriendShareOperation.1(this, paramIntent));
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    if (this.a == null) {
      this.a = new HostForwardUtils();
    }
    if (f() == null)
    {
      QLog.d("QCircleSpecifiedFriendShare", 1, "[createHostForwardApi] share info should not be null.");
      return;
    }
    QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo localQCircleForwardExtraTypeInfo = QCircleRecentlyChatReportHelper.a(f().c);
    this.a.registerForwardReportParam(paramIntent, g(), h(), localQCircleForwardExtraTypeInfo);
    this.a.registerForwardResultReceiver(paramIntent);
    this.a.addForwardType(paramIntent, paramString);
  }
  
  private Bundle u()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_REQ(), QCircleHostConstants._ForwardRecentActivity.REQ_DIRECT_SHOW_DIALOG());
    localBundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN_TYPE(), n());
    localBundle.putString(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN(), m());
    return localBundle;
  }
  
  private void v()
  {
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = f().c;
    HostForwardUtils.ForwardInfoEntity localForwardInfoEntity = new HostForwardUtils.ForwardInfoEntity();
    localForwardInfoEntity.setForwardUin(m());
    localForwardInfoEntity.setForwardUinType(n());
    QCircleRecentlyChatReportHelper.a(g(), h()).a(localQCircleExtraTypeInfo, localForwardInfoEntity);
    QLog.d("QCircleSpecifiedFriendShare", 1, "[shareToSpecifiedFriend] handler success.");
    a("share", "qq_aio");
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (f().b.share != null) && (i() != null))
    {
      Intent localIntent = a(i(), f().b);
      if (localIntent == null)
      {
        QLog.d("QCircleSpecifiedFriendShare", 1, "[shareToSpecifiedFriend] intent == null, not handler.");
        return;
      }
      SharePreferenceUtils.a(i(), "share_lately_type_key", "share_type_qq");
      localIntent.putExtras(u());
      a(localIntent);
      v();
      return;
    }
    a("QCircleSpecifiedFriendShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleSpecifiedFriendShareOperation
 * JD-Core Version:    0.7.0.1
 */