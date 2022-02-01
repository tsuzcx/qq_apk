package com.tencent.avgame.util;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import mqq.app.MobileQQ;

public class ResUtil
{
  public static String a = "";
  public static String b = "";
  public static String c = new File(b, "preload_map").getAbsolutePath();
  
  static
  {
    try
    {
      bool = "mounted".equals(Environment.getExternalStorageState());
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      label12:
      File localFile;
      break label12;
    }
    bool = false;
    if (bool) {
      localFile = new File(AppConstants.SDCARD_PATH);
    } else {
      localFile = MobileQQ.sMobileQQ.getCacheDir();
    }
    b = new File(localFile, "AR_MAP").getAbsolutePath();
    a = new File(localFile, "res_precover").getAbsolutePath();
  }
  
  public static String a()
  {
    return b;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.startsWith("http://hb.url.cn/")) {
      return paramString.substring(17);
    }
    String str = paramString;
    if (paramString.startsWith("http://")) {
      str = paramString.substring(7);
    }
    return str;
  }
  
  public static String b(String paramString)
  {
    Object localObject3 = null;
    Object localObject2;
    try
    {
      localObject4 = MD5.getPartfileMd5(paramString, 0L);
      Object localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = MD5FileUtil.b((byte[])localObject4);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("error ........ error getFileMD5String filePath: ");
      ((StringBuilder)localObject4).append(paramString);
      ((StringBuilder)localObject4).append(", error=");
      ((StringBuilder)localObject4).append(localException.getMessage());
      QLog.e("ARResUtil", 2, ((StringBuilder)localObject4).toString());
      localObject2 = localObject3;
    }
    if (QLog.isDebugVersion())
    {
      paramString = new StringBuilder();
      paramString.append("getFileMD5String md5: ");
      paramString.append(localObject2);
      QLog.e("ARResUtil", 2, paramString.toString());
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.ResUtil
 * JD-Core Version:    0.7.0.1
 */