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
  public static final String b;
  public static final String c;
  public static final String d;
  public static boolean e = false;
  private static boolean g = false;
  private static String h = "";
  private static String i = "";
  private static final String j;
  private static final String[] k = { "/666receive_motion", "/666send_motion", "/bixin_motion", "/chuo_motion", "/dazhao", "/xinsui_motion", "/zan_motion" };
  private static final String[] l = { "/666_caidan", "/chuo_caidan", "/dazhao_caidan", "/xinsui_caidan" };
  private static final int[] m = { 57, 57, 67, 6, 0, 50, 20 };
  private static final int[] n = { 2, 10, 37, 55 };
  private PokeBigResHandler.NetEngine f = new PokeBigResHandler.NetEngine();
  private QQAppInterface o;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("bigPoke");
    j = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    a = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_NEW_POKE);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("/poke_egg");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("/poke_normal");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("/dazhao/dazhao_move.png");
    d = localStringBuilder.toString();
  }
  
  public PokeBigResHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.o = paramQQAppInterface;
  }
  
  public static boolean a()
  {
    File localFile = new File(a);
    if ((localFile.exists()) && (localFile.list() != null))
    {
      int i1 = 0;
      while (i1 < 4)
      {
        if (!a(i1, b))
        {
          e = false;
          return false;
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < 7)
      {
        if (!b(i1, c))
        {
          e = false;
          return false;
        }
        i1 += 1;
      }
      e = true;
      return true;
    }
    e = false;
    return false;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(l[paramInt]);
    paramString = new File(localStringBuilder.toString());
    paramInt = n[paramInt];
    try
    {
      if ((paramString.exists()) && (paramString.isDirectory()))
      {
        paramString = paramString.list();
        if ((paramString != null) && (paramString.length > 0))
        {
          int i1 = paramString.length;
          if (i1 == paramInt) {
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
  
  public static boolean b(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(k[paramInt]);
    paramString = ((StringBuilder)localObject).toString();
    int i1 = m[paramInt];
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
        i1 = paramString.length;
        paramInt = 0;
        while (paramInt < i1)
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
      if (paramString.length == i1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean d()
  {
    String str = a;
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.list() != null))
    {
      QQAlbumUtils.a(str);
      return true;
    }
    return false;
  }
  
  private static boolean d(String paramString)
  {
    String str = h;
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
      label165:
      break label165;
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
      e(localFile.getAbsolutePath());
      return a();
    }
    localFile.delete();
    return false;
  }
  
  private static void e(String paramString)
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
      if (!TextUtils.isEmpty(VFSAssistantUtils.getSDKPrivatePath(j)))
      {
        FileUtils.delete(VFSAssistantUtils.getSDKPrivatePath(a), false);
        QQAlbumUtils.a(j);
        FileUtils.uncompressZip(paramString, VFSAssistantUtils.getSDKPrivatePath(a), false);
        QQAlbumUtils.a(a);
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
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      paramBoolean = d();
      if (paramBoolean) {
        return;
      }
      paramBoolean = g;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PokeBigResHandler
 * JD-Core Version:    0.7.0.1
 */