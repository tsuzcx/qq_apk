package com.tencent.kingkong;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import rab;

public class ReportThread
  extends Thread
{
  public Looper a;
  public Object a;
  public rab a;
  
  public ReportThread()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder1;
    int i;
    label552:
    label579:
    label606:
    label633:
    try
    {
      localStringBuilder1 = Utils.a();
      localStringBuilder1.append(paramString);
    }
    finally {}
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
      i = Build.VERSION.SDK_INT;
      if (i != -1) {
        localStringBuilder1.append("&ps=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      paramString = DataReport.a();
      if (paramString != null) {
        localStringBuilder1.append("&av=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.b();
      if (paramString != null) {
        localStringBuilder1.append("&pn=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.c();
      if (paramString != null) {
        localStringBuilder1.append("&amn=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.d();
      if (paramString != null) {
        localStringBuilder1.append("&amv=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.e();
      if (paramString != null) {
        localStringBuilder1.append("&nm=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      i = DataReport.a();
      if (i != -1) {
        localStringBuilder1.append("&bl=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      i = DataReport.b();
      if (i != -1) {
        localStringBuilder1.append("&bt=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      i = DataReport.c();
      if (i != -1) {
        localStringBuilder1.append("&bv=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      }
      paramString = DataReport.f();
      if (paramString != null) {
        localStringBuilder1.append("&cr=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.g();
      if (paramString != null) {
        localStringBuilder1.append("&cl=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.h();
      if (paramString != null) {
        localStringBuilder1.append("&gn=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.i();
      if (paramString != null) {
        localStringBuilder1.append("&gv=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.j();
      if (paramString != null) {
        localStringBuilder1.append("&imsi=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.k();
      if (paramString != null) {
        localStringBuilder1.append("&ip_addr=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.l();
      if (paramString != null) {
        localStringBuilder1.append("&re=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.m();
      if (paramString != null) {
        localStringBuilder1.append("&rt=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      paramString = DataReport.n();
      if (paramString != null) {
        localStringBuilder1.append("&st=").append(URLEncoder.encode(paramString, "UTF-8"));
      }
      localStringBuilder2 = localStringBuilder1.append("&root=");
      if (!DataReport.a()) {
        break label1011;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ams=");
      if (!DataReport.b()) {
        break label1045;
      }
      paramString = "1";
    }
    catch (Exception paramString)
    {
      break label1001;
    }
    catch (NoClassDefFoundError paramString)
    {
      break label1001;
    }
    catch (NoSuchMethodError paramString)
    {
      break label1001;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label660:
      label687:
      label714:
      label741:
      label1001:
      label1011:
      break label1001;
      label768:
      label795:
      paramString = "0";
      break label552;
      paramString = "0";
      break label579;
      paramString = "0";
      break label606;
      paramString = "0";
      break label633;
      paramString = "0";
      break label660;
      paramString = "0";
      break label687;
      paramString = "0";
      break label714;
      paramString = "0";
      break label741;
      paramString = "0";
      break label768;
      paramString = "0";
      break label795;
    }
    localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
    StringBuilder localStringBuilder2 = localStringBuilder1.append("&btls=");
    if (DataReport.c())
    {
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&bts=");
      if (!DataReport.d()) {
        break label1057;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gls=");
      if (!DataReport.e()) {
        break label1063;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gs=");
      if (!DataReport.f()) {
        break label1069;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gss=");
      if (!DataReport.g()) {
        break label1075;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ns=");
      if (!DataReport.h()) {
        break label1081;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&pe=");
      if (!DataReport.i()) {
        break label1087;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ts=");
      if (!DataReport.j()) {
        break label1093;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&uas=");
      if (!DataReport.k()) {
        break label1099;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ws=");
      if (DataReport.l()) {}
      for (paramString = "1";; paramString = "0")
      {
        localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
        paramString = DataReport.o();
        if (paramString != null) {
          localStringBuilder1.append("&qu=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.p();
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
        paramString = DataReport.q();
        if (paramString != null) {
          localStringBuilder1.append("&mac=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.r();
        if (paramString != null) {
          localStringBuilder1.append("&device_id=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.s();
        if (paramString != null) {
          localStringBuilder1.append("&nt=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = localStringBuilder1.toString();
        return paramString;
        paramString = "0";
        break;
      }
    }
  }
  
  private static String c(String paramString)
  {
    try
    {
      String str2 = Utils.a(16);
      String str1 = EncryptUtilsForQQ.a(new String(str2));
      paramString = new String(EncryptUtilsForQQ.a(str2, paramString));
      paramString = "paramStr=" + URLEncoder.encode(paramString, "UTF-8") + "&key=" + URLEncoder.encode(str1, "UTF-8") + "&visibility=2";
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_a_of_type_Rab == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Rab != null)
      {
        Message localMessage = this.jdField_a_of_type_Rab.obtainMessage();
        Bundle localBundle = new Bundle();
        localBundle.putInt("KEY_TYPE", paramInt1);
        localBundle.putInt("KEY_INDEX", paramInt2);
        localBundle.putInt("KEY_SUBINDEX", paramInt3);
        localBundle.putString("KEY_EXTRAINFO", paramString);
        localMessage.setData(localBundle);
        this.jdField_a_of_type_Rab.sendMessage(localMessage);
      }
      return;
    }
  }
  
  public void run()
  {
    Looper.prepare();
    this.jdField_a_of_type_Rab = new rab();
    this.jdField_a_of_type_AndroidOsLooper = Looper.myLooper();
    Process.setThreadPriority(11);
    Common.Log.a("KingKongReportThread", "ReportThread " + Process.myTid() + " priority : " + Process.getThreadPriority(Process.myTid()));
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.kingkong.ReportThread
 * JD-Core Version:    0.7.0.1
 */