package com.tencent.mobileqq.app.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;

public class PokeBigResHandler
  extends BusinessHandler
{
  public static final String a;
  public static boolean a = false;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 57, 57, 67, 6, 0, 50, 20 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean = false;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2, 10, 37, 55 };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  public static final String c;
  public static final String d;
  private static String e = "";
  private static String f = "";
  private static final String g;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PokeBigResHandler.NetEngine jdField_a_of_type_ComTencentMobileqqAppUtilsPokeBigResHandler$NetEngine = new PokeBigResHandler.NetEngine();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("bigPoke");
    g = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_NEW_POKE);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/poke_egg");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/poke_normal");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("/dazhao/dazhao_move.png");
    d = localStringBuilder.toString();
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "/666receive_motion", "/666send_motion", "/bixin_motion", "/chuo_motion", "/dazhao", "/xinsui_motion", "/zan_motion" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "/666_caidan", "/chuo_caidan", "/dazhao_caidan", "/xinsui_caidan" };
  }
  
  public PokeBigResHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BigResDown", 2, "start compress");
    }
    long l1 = System.currentTimeMillis();
    if (!new File(paramString).exists()) {
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(VFSAssistantUtils.getSDKPrivatePath(g)))
      {
        FileUtils.delete(VFSAssistantUtils.getSDKPrivatePath(jdField_a_of_type_JavaLangString), false);
        QQAlbumUtils.a(g);
        FileUtils.uncompressZip(paramString, VFSAssistantUtils.getSDKPrivatePath(jdField_a_of_type_JavaLangString), false);
        QQAlbumUtils.a(jdField_a_of_type_JavaLangString);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    FileUtils.delete(paramString, false);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("end compress ,cost ");
      paramString.append(l2 - l1);
      QLog.d("BigResDown", 2, paramString.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    paramString = new File(localStringBuilder.toString());
    paramInt = jdField_b_of_type_ArrayOfInt[paramInt];
    try
    {
      if ((paramString.exists()) && (paramString.isDirectory()))
      {
        paramString = paramString.list();
        if ((paramString != null) && (paramString.length > 0))
        {
          int i = paramString.length;
          if (i == paramInt) {
            return true;
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeBigResHandler", 2, paramString, new Object[0]);
      }
    }
    return false;
  }
  
  private static boolean b()
  {
    String str = jdField_a_of_type_JavaLangString;
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.list() != null))
    {
      QQAlbumUtils.a(str);
      return true;
    }
    return false;
  }
  
  public static boolean b(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
    paramString = ((StringBuilder)localObject).toString();
    int i = jdField_a_of_type_ArrayOfInt[paramInt];
    paramString = new File(paramString);
    boolean bool3 = paramString.exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString = paramString.listFiles();
      if (paramString == null) {
        return false;
      }
      if (paramInt == 4)
      {
        i = paramString.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = paramString[paramInt];
          if (localObject != null)
          {
            if (!((File)localObject).getName().contains("dazhao_move")) {
              if (((File)localObject).getName().contains("daozhao_motion"))
              {
                String[] arrayOfString = ((File)localObject).list();
                if (arrayOfString == null) {
                  return false;
                }
                if (arrayOfString.length == 29) {}
              }
              else
              {
                if (!((File)localObject).getName().contains("dazhao2_motion")) {
                  break label197;
                }
                localObject = ((File)localObject).list();
                if (localObject == null) {
                  return false;
                }
                if (localObject.length != 23) {
                  break label197;
                }
              }
            }
            paramInt += 1;
            continue;
          }
          label197:
          return false;
        }
        return true;
      }
      bool1 = bool2;
      if (paramString.length == i) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean b(String paramString)
  {
    String str = e;
    File localFile = new File(paramString);
    Object localObject;
    if (localFile.exists())
    {
      localObject = null;
      try
      {
        paramString = HexUtil.bytes2HexStr(MD5.getFileMd5(localFile.getAbsolutePath()));
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("BigResDown", 2, new Object[] { "doOnServerResp, fStorage, OutOfMemoryError, oom.message=", paramString.getMessage() });
          paramString.printStackTrace();
        }
        try
        {
          paramString = MD5FileUtil.a(localFile);
        }
        catch (Exception paramString)
        {
          break label77;
        }
        paramString = localObject;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("verifyResource() get file md5 failed:");
          paramString.append(localFile.getAbsolutePath());
          QLog.e("BigResDown", 2, paramString.toString());
          paramString = localObject;
        }
      }
      catch (UnsatisfiedLinkError paramString)
      {
        label77:
        if (QLog.isColorLevel())
        {
          QLog.d("BigResDown", 2, new Object[] { "doOnServerResp, fStorage, UnsatisfiedLinkError, e.message=", paramString.getMessage() });
          paramString.printStackTrace();
        }
      }
    }
    try
    {
      paramString = MD5FileUtil.a(localFile);
    }
    catch (Exception paramString)
    {
      label166:
      break label166;
    }
    paramString = localObject;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("verifyResource() get file md5 failed:");
      paramString.append(localFile.getAbsolutePath());
      QLog.e("BigResDown", 2, paramString.toString());
      paramString = localObject;
    }
    if ((paramString != null) && (str != null) && (paramString.toLowerCase().equals(str.toLowerCase())))
    {
      a(localFile.getAbsolutePath());
      return a();
    }
    localFile.delete();
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      paramBoolean = b();
      if (paramBoolean) {
        return;
      }
      paramBoolean = jdField_b_of_type_Boolean;
      if (paramBoolean) {
        return;
      }
      PokeBigResHandler.1 local1 = new PokeBigResHandler.1(this);
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        ThreadManager.post(local1, 10, null, false);
      } else {
        local1.run();
      }
      return;
    }
    finally {}
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler
 * JD-Core Version:    0.7.0.1
 */