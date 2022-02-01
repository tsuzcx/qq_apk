package com.tencent.av.abtest;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QavEffectUIABTestUtils
{
  private static int a;
  private static Boolean b;
  private static Boolean c;
  
  private static void a()
  {
    if (c != null) {
      return;
    }
    int i = c();
    if (i >= 1)
    {
      if (i > 2) {
        return;
      }
      c = Boolean.valueOf(true);
      QavABTestUtils.b("qq_av_pendant");
    }
  }
  
  public static void a(String paramString)
  {
    if (b()) {
      return;
    }
    int i = c();
    if (i != a)
    {
      a(paramString, i);
      paramString = new StringBuilder();
      paramString.append("updateABTestLocalSpValue expValue:=");
      paramString.append(i);
      QLog.d("QavEffectUIABTestUtils", 1, paramString.toString());
    }
    a();
  }
  
  private static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq_av_pendant");
    localStringBuilder.append(paramString);
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
    a = paramInt;
  }
  
  private static boolean b()
  {
    int i = QAVConfigUtils.i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isEffectExp switchValue:=");
    localStringBuilder.append(i);
    QLog.d("QavEffectUIABTestUtils", 1, localStringBuilder.toString());
    return (i >= 1) && (i <= 2);
  }
  
  public static boolean b(String paramString)
  {
    if (b != null)
    {
      a(paramString);
      return b.booleanValue();
    }
    boolean bool3 = b();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if (QAVConfigUtils.i() == 2) {
        bool1 = true;
      }
      b = Boolean.valueOf(bool1);
      return b.booleanValue();
    }
    bool1 = bool2;
    if (c(paramString) == 2) {
      bool1 = true;
    }
    b = Boolean.valueOf(bool1);
    if (b.booleanValue()) {
      QLog.d("QavEffectUIABTestUtils", 1, "sCurrentEffectExp sp fit");
    }
    bool1 = QavABTestUtils.a("qq_av_pendant", "qq_av_pendant_B");
    if (bool1)
    {
      paramString = new StringBuilder();
      paramString.append("isEffectExp hasExpB:=");
      paramString.append(bool1);
      QLog.d("QavEffectUIABTestUtils", 1, paramString.toString());
      b = Boolean.valueOf(true);
    }
    a();
    paramString = new StringBuilder();
    paramString.append("isEffectExp sCurrentEffectExp:=");
    paramString.append(b);
    QLog.d("QavEffectUIABTestUtils", 1, paramString.toString());
    return b.booleanValue();
  }
  
  private static int c()
  {
    if (QavABTestUtils.a("qq_av_pendant", "qq_av_pendant_B")) {
      return 2;
    }
    if (QavABTestUtils.a("qq_av_pendant", "qq_av_pendant_A")) {
      return 1;
    }
    return 0;
  }
  
  private static int c(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq_av_pendant");
    localStringBuilder.append(paramString);
    a = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    paramString = new StringBuilder();
    paramString.append("getABTestExpFromSP value:=");
    paramString.append(a);
    QLog.d("QavEffectUIABTestUtils", 1, paramString.toString());
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.abtest.QavEffectUIABTestUtils
 * JD-Core Version:    0.7.0.1
 */