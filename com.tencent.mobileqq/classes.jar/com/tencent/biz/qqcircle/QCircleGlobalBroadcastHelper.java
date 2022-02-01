package com.tencent.biz.qqcircle;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qflutter.superchannel.SuperChannelPlugin;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._InvitationWebViewPlugin;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils;
import com.tencent.biz.qqcircle.report.QCircleRecentlyChatReportHelper;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QCircleGlobalBroadcastHelper
{
  private static final String a;
  private static volatile QCircleGlobalBroadcastHelper b;
  private final QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver c = new QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RHF-");
    localStringBuilder.append(QCircleGlobalBroadcastHelper.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public static QCircleGlobalBroadcastHelper a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QCircleGlobalBroadcastHelper();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(@NonNull Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras();
    if (localObject == null)
    {
      QLog.d(a, 1, "[handleReportShareQQToForwardResult] bundle should be not null.");
      return;
    }
    QLog.d(a, 1, "[handleReportShareQQToForwardResult] forward result.");
    paramIntent = ((Bundle)localObject).getString(HostForwardUtils.HOST_FORWARD_TYPE_KEY());
    localObject = ((Bundle)localObject).getSerializable(HostForwardUtils.KEY_FORWARD_REPORT_BEAN());
    if ((localObject instanceof QCircleForwardInfoReportBean)) {
      QCircleRecentlyChatReportHelper.a(paramIntent, (QCircleForwardInfoReportBean)localObject);
    }
  }
  
  private void b(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras();
    if (localObject == null)
    {
      QLog.d(a, 1, "[handleReportShareQQToForwardResult] bundle should be not null.");
      return;
    }
    QLog.d(a, 1, "[handleReportShareQQToForwardResult] forward click.");
    paramIntent = ((Bundle)localObject).getString(HostForwardUtils.HOST_FORWARD_TYPE_KEY());
    localObject = ((Bundle)localObject).getSerializable(HostForwardUtils.KEY_FORWARD_REPORT_BEAN());
    if ((localObject instanceof QCircleForwardInfoReportBean)) {
      QCircleRecentlyChatReportHelper.b(paramIntent, (QCircleForwardInfoReportBean)localObject);
    }
  }
  
  private void c(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("schoolName");
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select schoolName school:");
    localStringBuilder.append(paramIntent);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    localObject = new HashMap();
    ((Map)localObject).put("school", paramIntent);
    SuperChannelPlugin.sendEvent("tencent_qqcircle/selectSchool", (Map)localObject);
  }
  
  private void d(Intent paramIntent)
  {
    int j = 0;
    if (paramIntent.getIntExtra("select_location_broadcast_callback", 0) != 2222) {
      return;
    }
    String[] arrayOfString2 = paramIntent.getStringArrayExtra("code");
    String[] arrayOfString1 = paramIntent.getStringArrayExtra("location");
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i;
    if (arrayOfString2 != null)
    {
      i = 0;
      while (i < arrayOfString2.length)
      {
        paramIntent = new StringBuilder();
        paramIntent.append(HostRouteUtils.encodeLocCode(arrayOfString2[i]));
        paramIntent.append("");
        arrayOfString2[i] = paramIntent.toString();
        if (i != 0) {
          paramIntent = "-";
        } else {
          paramIntent = "";
        }
        localStringBuilder1.append(paramIntent);
        localStringBuilder1.append(arrayOfString2[i]);
        i += 1;
      }
    }
    if (arrayOfString1 != null)
    {
      i = j;
      while (i < arrayOfString1.length)
      {
        if (!TextUtils.isEmpty(arrayOfString1[i]))
        {
          if (i != 0) {
            paramIntent = "-";
          } else {
            paramIntent = "";
          }
          localStringBuilder2.append(paramIntent);
          localStringBuilder2.append(arrayOfString1[i]);
        }
        i += 1;
      }
    }
    paramIntent = new HashMap();
    paramIntent.put("location", localStringBuilder2.toString());
    paramIntent.put("location_code", localStringBuilder1.toString());
    SuperChannelPlugin.sendEvent("tencent_qqcircle/selectLocation", paramIntent);
  }
  
  public void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_clear_message_red_poiont");
      localIntentFilter.addAction("action_update_native_user_follow_state");
      localIntentFilter.addAction("action_update_native_tag_follow_state");
      localIntentFilter.addAction("action_receive_message_push");
      localIntentFilter.addAction("action_refresh_feed_list");
      localIntentFilter.addAction("action_refresh_hippy_page");
      localIntentFilter.addAction("action_update_native_balance");
      localIntentFilter.addAction("action_receive_js_request");
      localIntentFilter.addAction(QCircleHostConstants._InvitationWebViewPlugin.AUTHORITY_ACTION());
      localIntentFilter.addAction("action_confirm_school_name");
      localIntentFilter.addAction("action_get_lbs_location");
      localIntentFilter.addAction("report_share_qq_to_forward_result");
      localIntentFilter.addAction("report_share_qq_to_recently_click");
      QCircleApplication.APP.registerReceiver(this.c, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    try
    {
      QCircleApplication.APP.unregisterReceiver(this.c);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    b = null;
  }
  
  public void d()
  {
    QCircleHostRedPointHelper.setNumRedPointReaded("circle_entrance");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    QCircleHostRedPointHelper.setOuterEntranceRedPointReaded("circle_entrance", localArrayList);
    RFThreadManager.getSerialThreadHandler().postDelayed(new QCircleGlobalBroadcastHelper.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper
 * JD-Core Version:    0.7.0.1
 */