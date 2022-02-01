package com.tencent.av.abtest;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QavAvatar2dEntranceABTestUtils
{
  private static int a;
  private static Boolean b;
  private static Boolean c;
  
  private static void a()
  {
    if (c != null) {
      return;
    }
    int i = b();
    if (i >= 1)
    {
      if (i > 2) {
        return;
      }
      c = Boolean.valueOf(true);
      QavABTestUtils.b("exp_qq_qav_virtual");
    }
  }
  
  private static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exp_qq_qav_virtual");
    localStringBuilder.append(paramString);
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
    a = paramInt;
  }
  
  public static boolean a(String paramString)
  {
    if (b != null)
    {
      b(paramString);
      return b.booleanValue();
    }
    boolean bool3 = c();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if (QAVConfigUtils.j() == 2) {
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
      QLog.d("QavAvatar2dEntranceABTestUtils", 1, "sCurrentAvatar2dEntranceExp sp fit");
    }
    bool1 = QavABTestUtils.a("exp_qq_qav_virtual", "exp_qq_qav_virtual_B");
    if (bool1)
    {
      paramString = new StringBuilder();
      paramString.append("isAvatar2dEntranceExp hasExpB:=");
      paramString.append(bool1);
      QLog.d("QavAvatar2dEntranceABTestUtils", 1, paramString.toString());
      b = Boolean.valueOf(true);
    }
    a();
    paramString = new StringBuilder();
    paramString.append("isAvatar2dEntranceExp sCurrentAvatar2dEntranceExp:=");
    paramString.append(b);
    QLog.d("QavAvatar2dEntranceABTestUtils", 1, paramString.toString());
    return b.booleanValue();
  }
  
  private static int b()
  {
    if (QavABTestUtils.a("exp_qq_qav_virtual", "exp_qq_qav_virtual_B")) {
      return 2;
    }
    if (QavABTestUtils.a("exp_qq_qav_virtual", "exp_qq_qav_virtual_A")) {
      return 1;
    }
    return 0;
  }
  
  public static void b(String paramString)
  {
    if (c()) {
      return;
    }
    int i = b();
    if (i != a)
    {
      a(paramString, i);
      paramString = new StringBuilder();
      paramString.append("updateABTestLocalSpValue expValue:=");
      paramString.append(i);
      QLog.d("QavAvatar2dEntranceABTestUtils", 1, paramString.toString());
    }
    a();
  }
  
  private static int c(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exp_qq_qav_virtual");
    localStringBuilder.append(paramString);
    a = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    paramString = new StringBuilder();
    paramString.append("getABTestExpFromSP value:=");
    paramString.append(a);
    QLog.d("QavAvatar2dEntranceABTestUtils", 1, paramString.toString());
    return a;
  }
  
  private static boolean c()
  {
    int i = QAVConfigUtils.j();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAvatar2dEntranceExp switchValue:=");
    localStringBuilder.append(i);
    QLog.d("QavAvatar2dEntranceABTestUtils", 1, localStringBuilder.toString());
    return (i >= 1) && (i <= 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.abtest.QavAvatar2dEntranceABTestUtils
 * JD-Core Version:    0.7.0.1
 */