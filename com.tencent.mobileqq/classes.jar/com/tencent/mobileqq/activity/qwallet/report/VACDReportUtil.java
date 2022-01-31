package com.tencent.mobileqq.activity.qwallet.report;

import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import aizt;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bdcb;
import bdee;
import bfin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VACDReportUtil
{
  public static long a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    return a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, long paramLong)
  {
    paramString3 = a(paramString2, paramString3);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2 = new ReportItem();
      paramString2.step = paramString4;
      paramString2.params = paramString5;
      paramString2.result = paramInt;
      paramString2.failReason = paramString6;
      paramString2.createTime = paramLong;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramString4 = new StringBuilder(128);
        paramString4.append("startReport header=" + paramString3.toString());
        if (paramString2 != null) {
          paramString4.append(" ,item=" + paramString2.toString());
        }
        paramString4.append(" ,createTime=").append(paramString3.startTime);
        QLog.d("VACDReport", 2, paramString4.toString());
      }
      paramString4 = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString4 instanceof QQAppInterface))
      {
        paramString4 = (aizt)((QQAppInterface)paramString4).getManager(148);
        if (paramString4 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VACDReport", 2, "mgr is null");
          }
          return 0L;
        }
        paramString4.a(paramString1, paramString3, paramString2);
      }
      for (;;)
      {
        return paramString3.seqno;
        paramString4 = new Intent(BaseApplicationImpl.getApplication(), VACDReportReceiver.class);
        paramString4.putExtra("vacdReport_extra:header", paramString3);
        paramString4.putExtra("vacdReport_extra:seqno", paramString3.seqno);
        paramString4.putExtra("vacdReport_extra:sKey", paramString1);
        paramString4.putExtra("vacdReport_extra:step", "vacdReport_step:start");
        if (paramString2 != null) {
          paramString4.putExtra("vacdReport_extra:item", paramString2);
        }
        BaseApplicationImpl.getApplication().sendBroadcast(paramString4);
      }
      paramString2 = null;
    }
  }
  
  private static ReportHeader a(String paramString1, String paramString2)
  {
    ReportHeader localReportHeader = new ReportHeader();
    StringBuilder localStringBuilder = new StringBuilder("Android|");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("|").append(Build.MODEL);
    localReportHeader.platform = localStringBuilder.toString();
    localReportHeader.sModule = paramString1;
    localReportHeader.sAction = paramString2;
    localReportHeader.version = bdcb.a(BaseApplicationImpl.getContext());
    localReportHeader.imei = bfin.c();
    localReportHeader.guid = SecUtil.toHexString(NetConnInfoCenter.GUID);
    long l = NetConnInfoCenter.getServerTimeMillis();
    localReportHeader.seqno = l;
    try
    {
      localReportHeader.uin = Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      localReportHeader.iNetType = bdee.a(BaseApplicationImpl.getApplication());
      localReportHeader.result = 0;
      localReportHeader.createTime = NetConnInfoCenter.getServerTimeMillis();
      localReportHeader.startTime = l;
      return localReportHeader;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        localReportHeader.uin = 10000L;
      }
    }
  }
  
  public static void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    ReportItem localReportItem = new ReportItem();
    localReportItem.step = paramString2;
    localReportItem.params = paramString3;
    localReportItem.result = paramInt;
    localReportItem.failReason = paramString4;
    localReportItem.createTime = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder(128);
      paramString2.append("addReportItem seqno=").append(paramLong);
      if (localReportItem != null) {
        paramString2.append(" ,item=").append(localReportItem.toString());
      }
      paramString2.append(" ,createTime=").append(NetConnInfoCenter.getServerTimeMillis());
      QLog.d("VACDReport", 2, paramString2.toString());
    }
    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString2 instanceof QQAppInterface))
    {
      paramString2 = (aizt)((QQAppInterface)paramString2).getManager(148);
      if (paramString2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VACDReport", 2, "mgr is null");
        }
        return;
      }
      paramString2.a(paramLong, paramString1, localReportItem);
      return;
    }
    paramString2 = new Intent(BaseApplicationImpl.getApplication(), VACDReportReceiver.class);
    paramString2.putExtra("vacdReport_extra:step", "vacdReport_step:add");
    paramString2.putExtra("vacdReport_extra:seqno", paramLong);
    paramString2.putExtra("vacdReport_extra:sKey", paramString1);
    paramString2.putExtra("vacdReport_extra:item", localReportItem);
    BaseApplicationImpl.getApplication().sendBroadcast(paramString2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    paramString2 = a(paramString2, paramString3);
    paramString3 = new ReportItem();
    paramString3.step = paramString4;
    paramString3.params = paramString5;
    paramString3.result = paramInt;
    paramString3.failReason = paramString6;
    paramString3.createTime = paramString2.createTime;
    if (QLog.isColorLevel())
    {
      paramString4 = new StringBuilder(128);
      paramString4.append("singleReport header=" + paramString2.toString());
      if (paramString3 != null) {
        paramString4.append(" ,item=" + paramString3.toString());
      }
      paramString4.append(" ,createTime=").append(paramString2.startTime);
      QLog.d("VACDReport", 2, paramString4.toString());
    }
    paramString4 = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString4 instanceof QQAppInterface))
    {
      paramString4 = (aizt)((QQAppInterface)paramString4).getManager(148);
      if (paramString4 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VACDReport", 2, "mgr is null");
        }
        return;
      }
      paramString4.b(paramString1, paramString2, paramString3);
      return;
    }
    paramString4 = new Intent(BaseApplicationImpl.getApplication(), VACDReportReceiver.class);
    paramString4.putExtra("vacdReport_extra:header", paramString2);
    paramString4.putExtra("vacdReport_extra:seqno", paramString2.seqno);
    paramString4.putExtra("vacdReport_extra:sKey", paramString1);
    paramString4.putExtra("vacdReport_extra:step", "vacdReport_step:single");
    paramString4.putExtra("vacdReport_extra:item", paramString3);
    BaseApplicationImpl.getApplication().sendBroadcast(paramString4);
  }
  
  public static void endReport(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ReportItem localReportItem;
    if (!TextUtils.isEmpty(paramString1))
    {
      localReportItem = new ReportItem();
      localReportItem.step = paramString1;
      localReportItem.params = paramString2;
      localReportItem.result = paramInt;
      localReportItem.failReason = paramString3;
      localReportItem.createTime = NetConnInfoCenter.getServerTimeMillis();
    }
    for (paramString1 = localReportItem;; paramString1 = null)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder(128);
        paramString2.append("endReport seqno=").append(paramLong);
        if (paramString1 != null) {
          paramString2.append(" ,item=").append(paramString1.toString());
        }
        paramString2.append(" ,createTime=").append(NetConnInfoCenter.getServerTimeMillis());
        QLog.d("VACDReport", 2, paramString2.toString());
      }
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString2 instanceof QQAppInterface))
      {
        paramString2 = (aizt)((QQAppInterface)paramString2).getManager(148);
        if (paramString2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VACDReport", 2, "mgr is null");
          }
          return;
        }
        paramString2.a(paramLong, paramString1);
        return;
      }
      paramString2 = new Intent(BaseApplicationImpl.getApplication(), VACDReportReceiver.class);
      paramString2.putExtra("vacdReport_extra:step", "vacdReport_step:end");
      paramString2.putExtra("vacdReport_extra:seqno", paramLong);
      if (paramString1 != null) {
        paramString2.putExtra("vacdReport_extra:item", paramString1);
      }
      BaseApplicationImpl.getApplication().sendBroadcast(paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil
 * JD-Core Version:    0.7.0.1
 */