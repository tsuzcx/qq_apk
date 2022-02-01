package com.tencent.mobileqq.app.utils;

import android.os.Looper;
import android.text.TextUtils;
import antf;
import anud;
import anui;
import apds;
import bhmi;
import bigv;
import bleb;
import brgs;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PokeBigResHandler
  extends anud
{
  public static final String a;
  public static boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 57, 57, 67, 6, 0, 50, 20 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2, 10, 37, 55 };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  public static final String c;
  public static final String d;
  private static String e = "";
  private static String f = "";
  private static final String g = bigv.a(antf.ba + "bigPoke");
  private apds jdField_a_of_type_Apds = new apds();
  
  static
  {
    jdField_a_of_type_JavaLangString = bigv.a(antf.bI);
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "/poke_egg";
    c = jdField_a_of_type_JavaLangString + "/poke_normal";
    d = c + "/dazhao/dazhao_move.png";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "/666receive_motion", "/666send_motion", "/bixin_motion", "/chuo_motion", "/dazhao", "/xinsui_motion", "/zan_motion" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "/666_caidan", "/chuo_caidan", "/dazhao_caidan", "/xinsui_caidan" };
  }
  
  public PokeBigResHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BigResDown", 2, "start compress");
    }
    long l1 = System.currentTimeMillis();
    if (!new File(paramString).exists()) {}
    for (;;)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(bigv.a(g)))
        {
          bhmi.a(bigv.a(jdField_a_of_type_JavaLangString), false);
          brgs.a(g);
          bhmi.a(paramString, bigv.a(jdField_a_of_type_JavaLangString), false);
          brgs.a(jdField_a_of_type_JavaLangString);
        }
        bhmi.a(paramString, false);
        long l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BigResDown", 2, "end compress ,cost " + (l2 - l1));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static boolean a()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if ((localFile.exists()) && (localFile.list() != null))
    {
      int i = 0;
      while (i < 4)
      {
        if (!a(i, jdField_b_of_type_JavaLangString))
        {
          jdField_a_of_type_Boolean = false;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < 7)
      {
        if (!b(i, c))
        {
          jdField_a_of_type_Boolean = false;
          return false;
        }
        i += 1;
      }
      jdField_a_of_type_Boolean = true;
      return true;
    }
    jdField_a_of_type_Boolean = false;
    return false;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString + jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    paramInt = jdField_b_of_type_ArrayOfInt[paramInt];
    boolean bool1 = bool2;
    try
    {
      if (paramString.exists())
      {
        bool1 = bool2;
        if (paramString.isDirectory())
        {
          paramString = paramString.list();
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (paramString.length > 0)
            {
              int i = paramString.length;
              bool1 = bool2;
              if (i == paramInt) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("PokeBigResHandler", 2, paramString, new Object[0]);
    }
    return bool1;
    return false;
  }
  
  private static boolean b()
  {
    String str = jdField_a_of_type_JavaLangString;
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.list() != null))
    {
      brgs.a(str);
      return true;
    }
    return false;
  }
  
  public static boolean b(int paramInt, String paramString)
  {
    boolean bool = true;
    paramString = paramString + jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    int i = jdField_a_of_type_ArrayOfInt[paramInt];
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      if (paramString != null) {
        break label58;
      }
    }
    label58:
    label68:
    String[] arrayOfString1;
    do
    {
      return false;
      if (paramInt != 4) {
        break label174;
      }
      i = paramString.length;
      paramInt = 0;
      if (paramInt >= i) {
        break;
      }
      arrayOfString1 = paramString[paramInt];
    } while (arrayOfString1 == null);
    if (arrayOfString1.getName().contains("dazhao_move")) {}
    for (;;)
    {
      paramInt += 1;
      break label68;
      if (arrayOfString1.getName().contains("daozhao_motion"))
      {
        String[] arrayOfString2 = arrayOfString1.list();
        if (arrayOfString2 == null) {
          break;
        }
        if (arrayOfString2.length == 29) {
          continue;
        }
      }
      if (!arrayOfString1.getName().contains("dazhao2_motion")) {
        break;
      }
      arrayOfString1 = arrayOfString1.list();
      if ((arrayOfString1 == null) || (arrayOfString1.length != 23)) {
        break;
      }
    }
    return true;
    label174:
    if (paramString.length == i) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static boolean b(String paramString)
  {
    Object localObject = null;
    String str = e;
    File localFile = new File(paramString);
    if (localFile.exists()) {
      try
      {
        paramString = HexUtil.bytes2HexStr(MD5.getFileMd5(localFile.getAbsolutePath()));
        if ((paramString != null) && (str != null) && (paramString.toLowerCase().equals(str.toLowerCase())))
        {
          a(localFile.getAbsolutePath());
          return a();
        }
      }
      catch (UnsatisfiedLinkError paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("BigResDown", 2, new Object[] { "doOnServerResp, fStorage, UnsatisfiedLinkError, e.message=", paramString.getMessage() });
            paramString.printStackTrace();
          }
          try
          {
            paramString = bleb.a(localFile);
          }
          catch (Exception paramString)
          {
            paramString = localObject;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("BigResDown", 2, "verifyResource() get file md5 failed:" + localFile.getAbsolutePath());
            paramString = localObject;
          }
        }
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("BigResDown", 2, new Object[] { "doOnServerResp, fStorage, OutOfMemoryError, oom.message=", paramString.getMessage() });
            paramString.printStackTrace();
          }
          try
          {
            paramString = bleb.a(localFile);
          }
          catch (Exception paramString)
          {
            paramString = localObject;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("BigResDown", 2, "verifyResource() get file md5 failed:" + localFile.getAbsolutePath());
            paramString = localObject;
          }
        }
        localFile.delete();
      }
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = b();
        if (paramBoolean) {
          return;
        }
        if (!jdField_b_of_type_Boolean)
        {
          PokeBigResHandler.1 local1 = new PokeBigResHandler.1(this);
          if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManager.post(local1, 10, null, false);
          } else {
            localObject.run();
          }
        }
      }
      finally {}
    }
  }
  
  public Class<? extends anui> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler
 * JD-Core Version:    0.7.0.1
 */