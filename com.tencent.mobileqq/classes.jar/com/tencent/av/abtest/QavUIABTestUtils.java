package com.tencent.av.abtest;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class QavUIABTestUtils
{
  private static int a;
  private static Boolean b;
  private static Boolean c;
  private static Boolean d;
  
  private static void a()
  {
    if (d != null) {
      return;
    }
    int i = c();
    if (i >= 1)
    {
      if (i > 4) {
        return;
      }
      d = Boolean.valueOf(true);
      QavABTestUtils.b("exp_qq_qav_ui_icons_0518");
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
      QLog.d("QavUIABTestUtils", 1, paramString.toString());
    }
    a();
  }
  
  private static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exp_qq_qav_ui_icons_0518");
    localStringBuilder.append(paramString);
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
    a = paramInt;
  }
  
  private static boolean b()
  {
    int i = QAVConfigUtils.h();
    return (i >= 1) && (i <= 4);
  }
  
  public static boolean b(String paramString)
  {
    if (b != null)
    {
      a(paramString);
      return b.booleanValue();
    }
    int i = QAVConfigUtils.h();
    boolean bool3 = b();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if ((QAVConfigUtils.h() == 2) || (QAVConfigUtils.h() == 4)) {
        bool1 = true;
      }
      b = Boolean.valueOf(bool1);
      paramString = new StringBuilder();
      paramString.append("isEffectExp switchValue:=");
      paramString.append(i);
      QLog.d("QavUIABTestUtils", 1, paramString.toString());
      return b.booleanValue();
    }
    i = d(paramString);
    if (i != 2)
    {
      bool1 = bool2;
      if (i != 4) {}
    }
    else
    {
      bool1 = true;
    }
    b = Boolean.valueOf(bool1);
    if (b.booleanValue()) {
      QLog.d("QavUIABTestUtils", 1, "sCurrentEffectExp sp fit");
    }
    bool1 = QavABTestUtils.a("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_B");
    bool2 = QavABTestUtils.a("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_D");
    if ((bool1) || (bool2))
    {
      paramString = new StringBuilder();
      paramString.append("isEffectExp hasExpB:=");
      paramString.append(bool1);
      paramString.append(", hasExpD:=");
      paramString.append(bool2);
      QLog.d("QavUIABTestUtils", 1, paramString.toString());
      b = Boolean.valueOf(true);
    }
    a();
    paramString = new StringBuilder();
    paramString.append("isEffectExp sCurrentEffectExp:=");
    paramString.append(b);
    QLog.d("QavUIABTestUtils", 1, paramString.toString());
    return b.booleanValue();
  }
  
  private static int c()
  {
    if (QavABTestUtils.a("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_B")) {
      return 2;
    }
    if (QavABTestUtils.a("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_C")) {
      return 3;
    }
    if (QavABTestUtils.a("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_D")) {
      return 4;
    }
    if (QavABTestUtils.a("exp_qq_qav_ui_icons_0518")) {
      return 1;
    }
    return 0;
  }
  
  public static boolean c(String paramString)
  {
    if (c != null)
    {
      a(paramString);
      return c.booleanValue();
    }
    int i = QAVConfigUtils.h();
    boolean bool3 = b();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if ((QAVConfigUtils.h() == 3) || (QAVConfigUtils.h() == 4)) {
        bool1 = true;
      }
      c = Boolean.valueOf(bool1);
      paramString = new StringBuilder();
      paramString.append("isCameraExp switchValue:=");
      paramString.append(i);
      QLog.d("QavUIABTestUtils", 1, paramString.toString());
      return c.booleanValue();
    }
    i = d(paramString);
    if (i != 3)
    {
      bool1 = bool2;
      if (i != 4) {}
    }
    else
    {
      bool1 = true;
    }
    c = Boolean.valueOf(bool1);
    if (c.booleanValue()) {
      QLog.d("QavUIABTestUtils", 1, "isCameraExp sp fit");
    }
    bool1 = QavABTestUtils.a("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_C");
    bool2 = QavABTestUtils.a("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_D");
    if ((bool1) || (bool2))
    {
      paramString = new StringBuilder();
      paramString.append("isCameraExp hasExpC:=");
      paramString.append(bool1);
      paramString.append(", hasExpD:=");
      paramString.append(bool2);
      QLog.d("QavUIABTestUtils", 1, paramString.toString());
      c = Boolean.valueOf(true);
    }
    a();
    paramString = new StringBuilder();
    paramString.append("isCameraExp sCurrentCameraExp:=");
    paramString.append(c);
    QLog.d("QavUIABTestUtils", 1, paramString.toString());
    return c.booleanValue();
  }
  
  private static int d(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exp_qq_qav_ui_icons_0518");
    localStringBuilder.append(paramString);
    a = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    paramString = new StringBuilder();
    paramString.append("getABTestExpFromSP value:=");
    paramString.append(a);
    QLog.d("QavUIABTestUtils", 1, paramString.toString());
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.abtest.QavUIABTestUtils
 * JD-Core Version:    0.7.0.1
 */