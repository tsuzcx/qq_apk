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
  public static long a = -1L;
  public static final SparseIntArray a;
  public static String a = "";
  public static boolean a = false;
  public static String b = "";
  public static boolean b = false;
  public static String c = "";
  public static boolean c = false;
  public static String d = "";
  public static String e = "";
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10000, 1);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10004, 2);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10001, 3);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10002, 4);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10007, 5);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10003, 6);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10012, 7);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10013, 8);
  }
  
  public static CaptureMsgReportItem a()
  {
    CaptureMsgReportItem localCaptureMsgReportItem = new CaptureMsgReportItem();
    localCaptureMsgReportItem.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localCaptureMsgReportItem.b = "";
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "";
    localCaptureMsgReportItem.d = "";
    localCaptureMsgReportItem.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(-1, -1);
    localCaptureMsgReportItem.e = "${count_unknown}";
    localCaptureMsgReportItem.f = "";
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
    return localCaptureMsgReportItem;
  }
  
  public static void a() {}
  
  public static void a(int paramInt)
  {
    if (!jdField_c_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localCaptureMsgReportItem.f = localStringBuilder.toString();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842B";
    localCaptureMsgReportItem.d = "0X800842B";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void a(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14))
    {
      int i;
      if (!paramEditVideoPartManager.c()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
    }
  }
  
  public static void a(EditVideoPartManager paramEditVideoPartManager, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramSendPanelItemInfo == null) {
      return;
    }
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14))
    {
      int i;
      if (paramSendPanelItemInfo.jdField_a_of_type_Boolean) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
    }
  }
  
  public static void a(SendPanelItemInfo paramSendPanelItemInfo)
  {
    c(null, paramSendPanelItemInfo);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_c_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842E";
    localCaptureMsgReportItem.d = "0X800842E";
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.h = b;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    localCaptureMsgReportItem.j = d;
    localCaptureMsgReportItem.k = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localCaptureMsgReportItem.l = localStringBuilder.toString();
    CaptureReportController.a(null, localCaptureMsgReportItem);
    if (jdField_a_of_type_Boolean)
    {
      localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083B0";
      localCaptureMsgReportItem.d = "0X80083B0";
      CaptureReportController.a(null, localCaptureMsgReportItem);
    }
  }
  
  public static void b(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14))
    {
      int i;
      if (!paramEditVideoPartManager.c()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
    }
  }
  
  public static void b(EditVideoPartManager paramEditVideoPartManager, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramSendPanelItemInfo == null) {
      return;
    }
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14))
    {
      int i;
      if (paramSendPanelItemInfo.jdField_a_of_type_Boolean) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
    }
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_c_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008431";
    localCaptureMsgReportItem.d = "0X8008431";
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.h = b;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    localCaptureMsgReportItem.j = d;
    localCaptureMsgReportItem.k = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localCaptureMsgReportItem.l = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_Long);
    localStringBuilder.append("");
    localCaptureMsgReportItem.o = localStringBuilder.toString();
    CaptureReportController.a(null, localCaptureMsgReportItem);
    if (jdField_a_of_type_Boolean)
    {
      localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083AF";
      localCaptureMsgReportItem.d = "0X80083AF";
      CaptureReportController.a(null, localCaptureMsgReportItem);
    }
  }
  
  public static void c(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(EditVideoPartManager paramEditVideoPartManager, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramSendPanelItemInfo == null) {
      return;
    }
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (paramSendPanelItemInfo.jdField_a_of_type_Int == 1) {
      paramEditVideoPartManager = "2";
    }
    for (;;)
    {
      break;
      if (paramSendPanelItemInfo.jdField_a_of_type_Int == 0) {
        paramEditVideoPartManager = "1";
      } else {
        paramEditVideoPartManager = "3";
      }
    }
    int i;
    if (paramSendPanelItemInfo.jdField_a_of_type_Boolean) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, paramEditVideoPartManager, "", "", "");
  }
  
  public static void d(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14))
    {
      int i;
      if (!paramEditVideoPartManager.c()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
    }
  }
  
  public static void e(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.CaptureReportUtil
 * JD-Core Version:    0.7.0.1
 */