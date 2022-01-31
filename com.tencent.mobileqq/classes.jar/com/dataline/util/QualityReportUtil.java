package com.dataline.util;

import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QualityReportUtil
{
  public static int a = 19;
  public static int b = 1;
  public static int c = 21;
  public static int d = 9;
  
  public static short a()
  {
    if (NetworkUtil.h(BaseApplication.getContext())) {
      return 18;
    }
    if (NetworkUtil.c(BaseApplication.getContext())) {
      return 19;
    }
    if (NetworkUtil.g(BaseApplication.getContext())) {
      return 20;
    }
    return 17;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ReportItem paramReportItem, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str;
    boolean bool;
    label62:
    long l2;
    long l3;
    long l4;
    long l1;
    label129:
    HashMap localHashMap;
    if (paramReportItem.bSend)
    {
      str = "actFAFileUp";
      if ((paramReportItem.emResult != 2) && (paramReportItem.emResult != 26) && (paramReportItem.emResult != 30) && (paramReportItem.emResult != 31) && (paramReportItem.emResult != 34)) {
        break label663;
      }
      bool = true;
      l2 = paramReportItem.uDuration;
      l3 = paramReportItem.uFileSize;
      l4 = paramReportItem.uStartPos;
      l1 = paramInt;
      if ((paramQQAppInterface != null) && (paramInt == b)) {
        ((RegisterProxySvcPackHandler)paramQQAppInterface.a(10)).a();
      }
      l1 = 1L;
      if ((paramReportItem.uDevType != 0) && (paramReportItem.uDevType != 1)) {
        break label668;
      }
      l1 = 1L;
      if (!paramReportItem.bSend) {
        paramReportItem.uSessionID &= 0xFFFFFFFF;
      }
      localHashMap = new HashMap();
      localHashMap.put("sessionid", String.valueOf(paramReportItem.uSessionID));
      localHashMap.put("mobileterm", String.valueOf(a));
      localHashMap.put("otherterm", String.valueOf(l1));
      localHashMap.put("channeltype", String.valueOf(paramReportItem.uChannelType));
      localHashMap.put("networktype", String.valueOf(a()));
      localHashMap.put("filesize", String.valueOf(paramReportItem.uFileSize));
      if (!paramReportItem.bFileExist) {
        break label684;
      }
      paramInt = 1;
      label252:
      localHashMap.put("fileexist", String.valueOf(paramInt));
      localHashMap.put("startpos", String.valueOf(paramReportItem.uStartPos));
      localHashMap.put("duration", String.valueOf(paramReportItem.uDuration));
      localHashMap.put("suffix", paramReportItem.sSuffix);
      localHashMap.put("result", String.valueOf(paramReportItem.emResult));
      localHashMap.put("failcode", String.valueOf(paramReportItem.nFailCode));
      localHashMap.put("usercode", String.valueOf(paramReportItem.nUserCode));
      localHashMap.put("filetye", String.valueOf(paramReportItem.uFileType));
      if (!paramQQAppInterface.e) {
        break label689;
      }
      paramInt = 2;
      label375:
      localHashMap.put("qqstate", String.valueOf(paramInt));
      if (paramReportItem.dwClientIP < 0) {
        break label694;
      }
      l1 = paramReportItem.dwClientIP;
      label401:
      localHashMap.put("clientip", String.valueOf(l1));
      if (paramReportItem.dwServerIP < 0) {
        break label708;
      }
      l1 = paramReportItem.dwServerIP;
      label428:
      localHashMap.put("serverip", String.valueOf(l1));
      if (paramReportItem.wServerPort < 0) {
        break label722;
      }
      paramInt = paramReportItem.wServerPort;
      label453:
      localHashMap.put("serverport", String.valueOf(paramInt));
      localHashMap.put("taskstart", String.valueOf(paramReportItem.uTaskStart / 1000L));
      localHashMap.put("taskend", String.valueOf(paramReportItem.uTaskEnd / 1000L));
      localHashMap.put("notifytime", String.valueOf(paramReportItem.uNotifyTime / 1000L));
      if (!paramReportItem.bUserRetry) {
        break label733;
      }
    }
    label663:
    label668:
    label684:
    label689:
    label694:
    label708:
    label722:
    label733:
    for (paramInt = 1;; paramInt = 0)
    {
      localHashMap.put("userretry", String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("StatisticCollector", 2, "dataline event report: " + str + "session id = " + (String)localHashMap.get("sessionid") + " FILEASSISTANT_MOBILETERM = " + (String)localHashMap.get("mobileterm") + "  Report FILEASSISTANT_OTHERTERM  =  " + (String)localHashMap.get("otherterm"));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), str, bool, l2, l3 - l4, localHashMap, null);
      return;
      str = "actFAFileDown";
      break;
      bool = false;
      break label62;
      if (paramReportItem.uDevType != 3) {
        break label129;
      }
      l1 = 21L;
      break label129;
      paramInt = 0;
      break label252;
      paramInt = 1;
      break label375;
      l1 = paramReportItem.dwClientIP + 4294967295L;
      break label401;
      l1 = paramReportItem.dwServerIP + 4294967295L;
      break label428;
      paramInt = paramReportItem.wServerPort + 65535;
      break label453;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.util.QualityReportUtil
 * JD-Core Version:    0.7.0.1
 */