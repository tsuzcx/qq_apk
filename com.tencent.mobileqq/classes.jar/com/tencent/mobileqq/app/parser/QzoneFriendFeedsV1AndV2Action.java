package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;

public class QzoneFriendFeedsV1AndV2Action
  extends JumpAction
{
  public QzoneFriendFeedsV1AndV2Action(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = bY_();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QzoneFriendFeedsV1AndV2Action", 1, localStringBuilder.toString());
      h_("QzoneFriendFeedsV1AndV2Action");
    }
    return false;
  }
  
  public boolean bY_()
  {
    Object localObject = this.a;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = (QZoneManagerImp)this.a.getManager(QQManagerFactory.QZONE_MANAGER);
    boolean bool1 = bool2;
    if (localObject != null) {
      if (((QZoneManagerImp)localObject).d(2) <= 0)
      {
        bool1 = bool2;
        if (((QZoneManagerImp)localObject).d(1) <= 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("newflag", bool1);
    ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    ((Intent)localObject).addFlags(805306368);
    String str = Uri.parse(this.c).getQueryParameter("push_trans_channel");
    QZoneHelper.forwardToFriendFeed((Activity)this.b, this.a.getCurrentAccountUin(), (Intent)localObject, str, -1);
    LpReportInfo_dc02880.report(this.c);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzoneFriendFeedsV1AndV2Action
 * JD-Core Version:    0.7.0.1
 */