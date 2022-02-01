package com.tencent.kingkong;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ReportUtil
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ThreadManager.excute(new ReportUtil.ReportRunnable(paramInt1, paramInt2, paramInt3, paramString), 128, null, true);
  }
  
  private static String c(String paramString)
  {
    try
    {
      Object localObject = Utils.a(16);
      String str = EncryptUtilsForQQ.a(new String((String)localObject));
      paramString = new String(EncryptUtilsForQQ.a((String)localObject, paramString));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("paramStr=");
      ((StringBuilder)localObject).append(URLEncoder.encode(paramString, "UTF-8"));
      ((StringBuilder)localObject).append("&key=");
      ((StringBuilder)localObject).append(URLEncoder.encode(str, "UTF-8"));
      ((StringBuilder)localObject).append("&visibility=2");
      paramString = ((StringBuilder)localObject).toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static String d(String paramString)
  {
    StringBuilder localStringBuilder = Utils.a();
    localStringBuilder.append(paramString);
    try
    {
      paramString = Build.HARDWARE;
      if (paramString != null)
      {
        localStringBuilder.append("&hardware=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = Build.BRAND;
      if (paramString != null)
      {
        localStringBuilder.append("&pb=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      int i = Build.VERSION.SDK_INT;
      if (i != -1)
      {
        localStringBuilder.append("&ps=");
        localStringBuilder.append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      paramString = DataReport.a();
      if (paramString != null)
      {
        localStringBuilder.append("&av=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.b();
      if (paramString != null)
      {
        localStringBuilder.append("&pn=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.c();
      if (paramString != null)
      {
        localStringBuilder.append("&amn=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.d();
      if (paramString != null)
      {
        localStringBuilder.append("&amv=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.e();
      if (paramString != null)
      {
        localStringBuilder.append("&nm=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      i = DataReport.a();
      if (i != -1)
      {
        localStringBuilder.append("&bl=");
        localStringBuilder.append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      i = DataReport.b();
      if (i != -1)
      {
        localStringBuilder.append("&bt=");
        localStringBuilder.append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      i = DataReport.c();
      if (i != -1)
      {
        localStringBuilder.append("&bv=");
        localStringBuilder.append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      paramString = DataReport.f();
      if (paramString != null)
      {
        localStringBuilder.append("&cr=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.g();
      if (paramString != null)
      {
        localStringBuilder.append("&cl=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.h();
      if (paramString != null)
      {
        localStringBuilder.append("&gn=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.i();
      if (paramString != null)
      {
        localStringBuilder.append("&gv=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.j();
      if (paramString != null)
      {
        localStringBuilder.append("&imsi=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.k();
      if (paramString != null)
      {
        localStringBuilder.append("&ip_addr=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.l();
      if (paramString != null)
      {
        localStringBuilder.append("&re=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.m();
      if (paramString != null)
      {
        localStringBuilder.append("&rt=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.n();
      if (paramString != null)
      {
        localStringBuilder.append("&st=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      localStringBuilder.append("&root=");
      boolean bool = DataReport.a();
      str = "1";
      if (bool) {
        paramString = "1";
      } else {
        paramString = "0";
      }
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&ams=");
      if (!DataReport.b()) {
        break label1190;
      }
      paramString = "1";
    }
    catch (UnsupportedEncodingException|NoSuchMethodError|NoClassDefFoundError|Exception paramString)
    {
      for (;;)
      {
        String str;
        continue;
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        paramString = "0";
      }
    }
    localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
    localStringBuilder.append("&btls=");
    if (DataReport.c())
    {
      paramString = "1";
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&bts=");
      if (!DataReport.d()) {
        break label1202;
      }
      paramString = "1";
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&gls=");
      if (!DataReport.e()) {
        break label1208;
      }
      paramString = "1";
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&gs=");
      if (!DataReport.f()) {
        break label1214;
      }
      paramString = "1";
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&gss=");
      if (!DataReport.g()) {
        break label1220;
      }
      paramString = "1";
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&ns=");
      if (!DataReport.h()) {
        break label1226;
      }
      paramString = "1";
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&pe=");
      if (!DataReport.i()) {
        break label1232;
      }
      paramString = "1";
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&ts=");
      if (!DataReport.j()) {
        break label1238;
      }
      paramString = "1";
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&uas=");
      if (!DataReport.k()) {
        break label1244;
      }
      paramString = "1";
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder.append("&ws=");
      if (!DataReport.l()) {
        break label1250;
      }
      paramString = str;
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      paramString = DataReport.o();
      if (paramString != null)
      {
        localStringBuilder.append("&qu=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.p();
      if (paramString != null)
      {
        localStringBuilder.append("&android_id=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = Build.MODEL;
      if (paramString != null)
      {
        localStringBuilder.append("&pm=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = Build.VERSION.RELEASE;
      if (paramString != null)
      {
        localStringBuilder.append("&pr=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.q();
      if (paramString != null)
      {
        localStringBuilder.append("&mac=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.r();
      if (paramString != null)
      {
        localStringBuilder.append("&device_id=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.s();
      if (paramString != null)
      {
        localStringBuilder.append("&nt=");
        localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.ReportUtil
 * JD-Core Version:    0.7.0.1
 */