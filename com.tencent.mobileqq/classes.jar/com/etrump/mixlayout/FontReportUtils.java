package com.etrump.mixlayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

public class FontReportUtils
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  public static AtomicInteger b = new AtomicInteger(1);
  public static int c;
  private static ConcurrentHashMap<String, AtomicInteger> d = new ConcurrentHashMap();
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if (!a.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FontManagerConstants.Report", 2, "report not enable");
      }
      return;
    }
    AtomicInteger localAtomicInteger2 = (AtomicInteger)d.get(paramString);
    AtomicInteger localAtomicInteger1 = localAtomicInteger2;
    if (localAtomicInteger2 == null)
    {
      localAtomicInteger1 = new AtomicInteger();
      d.put(paramString, localAtomicInteger1);
    }
    long l1 = MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences("font_report_sp", 0).getLong(paramString, 0L);
    long l2 = b.get() * 60 * 60 * 1000;
    long l3 = System.currentTimeMillis();
    if (l3 - l1 > l2)
    {
      int i = localAtomicInteger1.incrementAndGet();
      if (i == c)
      {
        VasWebviewUtil.a(paramString, paramInt1, paramInt2, paramInt3, paramDouble, i);
        MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences("font_report_sp", 0).edit().putLong(paramString, l3).commit();
      }
    }
    else
    {
      localAtomicInteger1.set(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontReportUtils
 * JD-Core Version:    0.7.0.1
 */