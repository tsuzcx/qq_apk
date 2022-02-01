package com.tencent.liteav.beauty;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;

public class a
{
  private static boolean A = false;
  private static boolean B = false;
  private static boolean C = false;
  private static boolean D = false;
  private static boolean E = false;
  private static a a;
  private static Context b;
  private static boolean c = false;
  private static boolean d = false;
  private static boolean e = false;
  private static boolean f = false;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static boolean l = false;
  private static boolean m = false;
  private static boolean n = false;
  private static boolean o = false;
  private static boolean p = false;
  private static boolean q = false;
  private static boolean r = false;
  private static boolean s = false;
  private static boolean t = false;
  private static boolean u = false;
  private static boolean v = false;
  private static boolean w = false;
  private static boolean x = false;
  private static boolean y = false;
  private static boolean z = false;
  private String F = "ReportDuaManage";
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  private void h()
  {
    TXCLog.i(this.F, "resetReportState");
    c = false;
    d = false;
    e = false;
    f = false;
    g = false;
    h = false;
    i = false;
    j = false;
    k = false;
    l = false;
    m = false;
    n = false;
    C = false;
    o = false;
    p = false;
    q = false;
    r = false;
    s = false;
    t = false;
    u = false;
    v = false;
    w = false;
    x = false;
    y = false;
    z = false;
    A = false;
    B = false;
    D = false;
    E = false;
  }
  
  public void a(Context paramContext)
  {
    h();
    b = paramContext.getApplicationContext();
    if (!c)
    {
      TXCLog.i(this.F, "reportSDKInit");
      TXCDRApi.txReportDAU(b, 1201, 0, "reportSDKInit!");
    }
    c = true;
  }
  
  public void b()
  {
    if (!d)
    {
      TXCLog.i(this.F, "reportBeautyDua");
      TXCDRApi.txReportDAU(b, 1202, 0, "reportBeautyDua");
    }
    d = true;
  }
  
  public void c()
  {
    if (!e)
    {
      TXCLog.i(this.F, "reportWhiteDua");
      TXCDRApi.txReportDAU(b, 1203, 0, "reportWhiteDua");
    }
    e = true;
  }
  
  public void d()
  {
    if (!f)
    {
      TXCLog.i(this.F, "reportRuddyDua");
      TXCDRApi.txReportDAU(b, 1204, 0, "reportRuddyDua");
    }
    f = true;
  }
  
  public void e()
  {
    if (!j)
    {
      TXCLog.i(this.F, "reportFilterImageDua");
      TXCDRApi.txReportDAU(b, 1208, 0, "reportFilterImageDua");
    }
    j = true;
  }
  
  public void f()
  {
    if (!l)
    {
      TXCLog.i(this.F, "reportSharpDua");
      TXCDRApi.txReportDAU(b, 1210, 0, "reportSharpDua");
    }
    l = true;
  }
  
  public void g()
  {
    if (!n)
    {
      TXCLog.i(this.F, "reportWarterMarkDua");
      TXCDRApi.txReportDAU(b, 1212, 0, "reportWarterMarkDua");
    }
    n = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.a
 * JD-Core Version:    0.7.0.1
 */