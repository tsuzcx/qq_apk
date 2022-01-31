package com.tencent.mobileqq.activity.qwallet.report;

import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import ajei;
import ajeu;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.pluginbridge.BridgeHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VACDReportReceiver
  extends BroadcastReceiver
{
  public void a(ReportItem paramReportItem)
  {
    Object localObject1;
    if ((paramReportItem != null) && (!TextUtils.isEmpty(paramReportItem.failReason)) && (paramReportItem.step != null) && (paramReportItem.step.equals("crash")) && ((paramReportItem.result == 668814) || (paramReportItem.result == 668815)))
    {
      localObject1 = ajeu.a();
      if (localObject1 != null) {
        break label60;
      }
    }
    for (;;)
    {
      return;
      label60:
      Object localObject2 = BridgeHelper.a(((QQAppInterface)localObject1).getApp(), ((QQAppInterface)localObject1).getCurrentAccountUin());
      if (localObject2 != null)
      {
        localObject1 = ((BridgeHelper)localObject2).a("crash_title");
        String str1 = ((BridgeHelper)localObject2).a("crash_content");
        String str2 = ((BridgeHelper)localObject2).a("crash_btn");
        String str3 = ((BridgeHelper)localObject2).a("crash_url");
        String str4 = ((BridgeHelper)localObject2).a("crash_modelRegex");
        localObject2 = ((BridgeHelper)localObject2).a("crash_crashRegex");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          try
          {
            if (!TextUtils.isEmpty(str4))
            {
              String str5 = Build.MODEL;
              if ((TextUtils.isEmpty(str5)) || (!Pattern.compile(str4).matcher(str5).matches())) {
                break;
              }
            }
            else
            {
              boolean bool = Pattern.compile((String)localObject2).matcher(paramReportItem.failReason).matches();
              if (bool)
              {
                paramReportItem = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
                paramReportItem.addFlags(268435456);
                paramReportItem.putExtra("title", (String)localObject1);
                paramReportItem.putExtra("content", str1);
                paramReportItem.putExtra("btn", str2);
                paramReportItem.putExtra("url", str3);
                paramReportItem.putExtra("pay_requestcode", 201);
                BaseApplication.getContext().startActivity(paramReportItem);
                return;
              }
            }
          }
          catch (Exception paramReportItem) {}
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("vacdReport_extra:step");
    long l = paramIntent.getLongExtra("vacdReport_extra:seqno", -1L);
    ReportItem localReportItem = (ReportItem)paramIntent.getSerializableExtra("vacdReport_extra:item");
    if (QLog.isColorLevel()) {
      QLog.i("VACDReport", 2, "onReceive: step=" + str + ", seqno=" + l + ", item=" + localReportItem);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (ajei)((QQAppInterface)localObject).getManager(148);
      if (localObject == null) {
        return;
      }
      if (!"vacdReport_step:start".equals(str)) {
        break label157;
      }
      ((ajei)localObject).a(paramIntent.getStringExtra("vacdReport_extra:sKey"), (ReportHeader)paramIntent.getSerializableExtra("vacdReport_extra:header"), localReportItem);
    }
    for (;;)
    {
      a(localReportItem);
      return;
      label157:
      if ("vacdReport_step:add".equals(str)) {
        ((ajei)localObject).a(l, paramIntent.getStringExtra("vacdReport_extra:sKey"), localReportItem);
      } else if ("vacdReport_step:end".equals(str)) {
        ((ajei)localObject).a(l, localReportItem);
      } else if ("vacdReport_step:single".equals(str)) {
        ((ajei)localObject).b(paramIntent.getStringExtra("vacdReport_extra:sKey"), (ReportHeader)paramIntent.getSerializableExtra("vacdReport_extra:header"), localReportItem);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (ajeu.a() == null);
      bool = paramBundle.getBoolean("isRealName", false);
    } while (!QLog.isColorLevel());
    QLog.i("VACDReport", 2, "onRealName isRealName:" + bool);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int i = paramIntent.getIntExtra("type", 0);
    paramContext = paramIntent.getBundleExtra("params");
    switch (i)
    {
    default: 
      a(paramIntent);
      return;
    }
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.report.VACDReportReceiver
 * JD-Core Version:    0.7.0.1
 */