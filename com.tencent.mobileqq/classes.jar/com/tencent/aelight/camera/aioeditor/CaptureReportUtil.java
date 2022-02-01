package com.tencent.aelight.camera.aioeditor;

import android.util.SparseIntArray;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.statistics.CaptureReportController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.reportitem.CaptureMsgReportItem;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureReportUtil
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  public static boolean f = false;
  public static long g = -1L;
  public static boolean h = false;
  public static boolean i = false;
  public static final SparseIntArray j = new SparseIntArray();
  
  static
  {
    j.put(10000, 1);
    j.put(10004, 2);
    j.put(10001, 3);
    j.put(10002, 4);
    j.put(10007, 5);
    j.put(10003, 6);
    j.put(10012, 7);
    j.put(10013, 8);
  }
  
  public static CaptureMsgReportItem a()
  {
    CaptureMsgReportItem localCaptureMsgReportItem = new CaptureMsgReportItem();
    localCaptureMsgReportItem.a = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localCaptureMsgReportItem.b = "";
    localCaptureMsgReportItem.c = "";
    localCaptureMsgReportItem.d = "";
    localCaptureMsgReportItem.e = j.get(-1, -1);
    localCaptureMsgReportItem.f = "${count_unknown}";
    localCaptureMsgReportItem.g = "";
    localCaptureMsgReportItem.h = "";
    localCaptureMsgReportItem.i = "";
    localCaptureMsgReportItem.j = "";
    localCaptureMsgReportItem.k = "";
    localCaptureMsgReportItem.l = "";
    localCaptureMsgReportItem.m = "";
    localCaptureMsgReportItem.n = "";
    localCaptureMsgReportItem.o = "";
    localCaptureMsgReportItem.p = "";
    localCaptureMsgReportItem.q = "";
    localCaptureMsgReportItem.r = "";
    localCaptureMsgReportItem.s = "";
    localCaptureMsgReportItem.t = "";
    localCaptureMsgReportItem.u = "";
    localCaptureMsgReportItem.v = "";
    return localCaptureMsgReportItem;
  }
  
  public static void a(int paramInt)
  {
    if (!i) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localCaptureMsgReportItem.g = localStringBuilder.toString();
    localCaptureMsgReportItem.c = "0X800842B";
    localCaptureMsgReportItem.d = "0X800842B";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void a(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14))
    {
      int k;
      if (!paramEditVideoPartManager.j()) {
        k = 1;
      } else {
        k = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", k, 0, "", "", "", "");
    }
  }
  
  public static void a(EditVideoPartManager paramEditVideoPartManager, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramSendPanelItemInfo == null) {
      return;
    }
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14))
    {
      int k;
      if (paramSendPanelItemInfo.i) {
        k = 1;
      } else {
        k = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", k, 0, "", "", "", "");
    }
  }
  
  public static void a(SendPanelItemInfo paramSendPanelItemInfo)
  {
    c(null, paramSendPanelItemInfo);
  }
  
  public static void b() {}
  
  public static void b(int paramInt)
  {
    if (!i) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.c = "0X800842E";
    localCaptureMsgReportItem.d = "0X800842E";
    if (localCaptureMsgReportItem.e == 5) {
      localCaptureMsgReportItem.h = a;
    }
    localCaptureMsgReportItem.i = b;
    localCaptureMsgReportItem.j = c;
    localCaptureMsgReportItem.k = d;
    localCaptureMsgReportItem.l = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localCaptureMsgReportItem.m = localStringBuilder.toString();
    CaptureReportController.a(null, localCaptureMsgReportItem);
    if (f)
    {
      localCaptureMsgReportItem.c = "0X80083B0";
      localCaptureMsgReportItem.d = "0X80083B0";
      CaptureReportController.a(null, localCaptureMsgReportItem);
    }
  }
  
  public static void b(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14))
    {
      int k;
      if (!paramEditVideoPartManager.j()) {
        k = 1;
      } else {
        k = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", k, 0, "", "", "", "");
    }
  }
  
  public static void b(EditVideoPartManager paramEditVideoPartManager, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramSendPanelItemInfo == null) {
      return;
    }
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14))
    {
      int k;
      if (paramSendPanelItemInfo.i) {
        k = 1;
      } else {
        k = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", k, 0, "", "", "", "");
    }
  }
  
  public static void c(int paramInt)
  {
    if (!i) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.c = "0X8008431";
    localCaptureMsgReportItem.d = "0X8008431";
    if (localCaptureMsgReportItem.e == 5) {
      localCaptureMsgReportItem.h = a;
    }
    localCaptureMsgReportItem.i = b;
    localCaptureMsgReportItem.j = c;
    localCaptureMsgReportItem.k = d;
    localCaptureMsgReportItem.l = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localCaptureMsgReportItem.m = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(g);
    localStringBuilder.append("");
    localCaptureMsgReportItem.p = localStringBuilder.toString();
    CaptureReportController.a(null, localCaptureMsgReportItem);
    if (f)
    {
      localCaptureMsgReportItem.c = "0X80083AF";
      localCaptureMsgReportItem.d = "0X80083AF";
      CaptureReportController.a(null, localCaptureMsgReportItem);
    }
  }
  
  public static void c(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(EditVideoPartManager paramEditVideoPartManager, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramSendPanelItemInfo == null) {
      return;
    }
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a != 14)) {
      return;
    }
    if (paramSendPanelItemInfo.d == 1) {
      paramEditVideoPartManager = "2";
    }
    for (;;)
    {
      break;
      if (paramSendPanelItemInfo.d == 0) {
        paramEditVideoPartManager = "1";
      } else {
        paramEditVideoPartManager = "3";
      }
    }
    int k;
    if (paramSendPanelItemInfo.i) {
      k = 1;
    } else {
      k = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", k, 0, paramEditVideoPartManager, "", "", "");
  }
  
  public static void d(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14))
    {
      int k;
      if (!paramEditVideoPartManager.j()) {
        k = 1;
      } else {
        k = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A559", "0X800A559", k, 0, "", "", "", "");
    }
  }
  
  public static void e(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.I != null) && (paramEditVideoPartManager.I.a == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.CaptureReportUtil
 * JD-Core Version:    0.7.0.1
 */