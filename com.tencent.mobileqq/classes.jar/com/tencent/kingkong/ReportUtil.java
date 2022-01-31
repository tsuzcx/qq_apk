package com.tencent.kingkong;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import zyy;
import zyz;
import zzj;

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
      String str2 = zzj.a(16);
      String str1 = zyz.a(new String(str2));
      paramString = new String(zyz.a(str2, paramString));
      paramString = "paramStr=" + URLEncoder.encode(paramString, "UTF-8") + "&key=" + URLEncoder.encode(str1, "UTF-8") + "&visibility=2";
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
    StringBuilder localStringBuilder1 = zzj.a();
    localStringBuilder1.append(paramString);
    try
    {
      paramString = Build.HARDWARE;
      if (paramString != null) {
        localStringBuilder1.append("&hardware=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = Build.BRAND;
      if (paramString != null) {
        localStringBuilder1.append("&pb=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      int i = Build.VERSION.SDK_INT;
      if (i != -1) {
        localStringBuilder1.append("&ps=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      paramString = zyy.a();
      if (paramString != null) {
        localStringBuilder1.append("&av=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.b();
      if (paramString != null) {
        localStringBuilder1.append("&pn=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.c();
      if (paramString != null) {
        localStringBuilder1.append("&amn=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.d();
      if (paramString != null) {
        localStringBuilder1.append("&amv=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.e();
      if (paramString != null) {
        localStringBuilder1.append("&nm=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      i = zyy.a();
      if (i != -1) {
        localStringBuilder1.append("&bl=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      i = zyy.b();
      if (i != -1) {
        localStringBuilder1.append("&bt=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      i = zyy.c();
      if (i != -1) {
        localStringBuilder1.append("&bv=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      paramString = zyy.f();
      if (paramString != null) {
        localStringBuilder1.append("&cr=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.g();
      if (paramString != null) {
        localStringBuilder1.append("&cl=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.h();
      if (paramString != null) {
        localStringBuilder1.append("&gn=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.i();
      if (paramString != null) {
        localStringBuilder1.append("&gv=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.j();
      if (paramString != null) {
        localStringBuilder1.append("&imsi=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.k();
      if (paramString != null) {
        localStringBuilder1.append("&ip_addr=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.l();
      if (paramString != null) {
        localStringBuilder1.append("&re=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.m();
      if (paramString != null) {
        localStringBuilder1.append("&rt=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = zyy.n();
      if (paramString != null) {
        localStringBuilder1.append("&st=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      localStringBuilder2 = localStringBuilder1.append("&root=");
      if (!zyy.a()) {
        break label1008;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ams=");
      if (!zyy.b()) {
        break label1038;
      }
      paramString = "1";
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder2;
      break label1003;
    }
    catch (NoClassDefFoundError paramString)
    {
      break label1003;
    }
    catch (NoSuchMethodError paramString)
    {
      break label1003;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        label1003:
        label1008:
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
    localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
    localStringBuilder2 = localStringBuilder1.append("&btls=");
    if (zyy.c())
    {
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&bts=");
      if (!zyy.d()) {
        break label1052;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gls=");
      if (!zyy.e()) {
        break label1059;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gs=");
      if (!zyy.f()) {
        break label1066;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gss=");
      if (!zyy.g()) {
        break label1073;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ns=");
      if (!zyy.h()) {
        break label1080;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&pe=");
      if (!zyy.i()) {
        break label1087;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ts=");
      if (!zyy.j()) {
        break label1094;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&uas=");
      if (!zyy.k()) {
        break label1101;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ws=");
      if (zyy.l()) {}
      for (paramString = "1";; paramString = "0")
      {
        localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
        paramString = zyy.o();
        if (paramString != null) {
          localStringBuilder1.append("&qu=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = zyy.p();
        if (paramString != null) {
          localStringBuilder1.append("&android_id=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = Build.MODEL;
        if (paramString != null) {
          localStringBuilder1.append("&pm=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = Build.VERSION.RELEASE;
        if (paramString != null) {
          localStringBuilder1.append("&pr=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = zyy.q();
        if (paramString != null) {
          localStringBuilder1.append("&mac=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = zyy.r();
        if (paramString != null) {
          localStringBuilder1.append("&device_id=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = zyy.s();
        if (paramString != null) {
          localStringBuilder1.append("&nt=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        return localStringBuilder1.toString();
        paramString = "0";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.kingkong.ReportUtil
 * JD-Core Version:    0.7.0.1
 */