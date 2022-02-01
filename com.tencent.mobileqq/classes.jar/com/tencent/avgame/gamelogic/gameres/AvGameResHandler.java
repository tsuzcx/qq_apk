package com.tencent.avgame.gamelogic.gameres;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.armap.ResDownloadHandler.DefaultRDHandler;
import com.tencent.mobileqq.armap.ResDownloadManager.DownloadParam;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AvGameResHandler
  extends ResDownloadHandler.DefaultRDHandler
{
  private static String a()
  {
    if (SystemUtil.a()) {}
    for (String str1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
    {
      String str2 = str1;
      if (str1 != null)
      {
        str2 = str1;
        if (!str1.endsWith(File.separator)) {
          str2 = str1 + File.separator;
        }
      }
      return str2 + "avgame/res" + File.separator;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a() + "star/" + paramString1 + paramString2;
  }
  
  public static void a()
  {
    String str = a() + "star/";
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.listFiles() != null) && (localFile.listFiles().length >= 100))
    {
      FileUtils.a(str);
      QLog.d("AvGameResHandler", 1, "shouldClearStarEffectVideoFiles [delete star video effect files]");
    }
  }
  
  public String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    paramDownloadParam = a() + paramDownloadParam.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResHandler", 2, "getUnzipDirPath dir = " + paramDownloadParam);
    }
    return paramDownloadParam;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramDownloadParam.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getLong(paramDownloadParam.b, -1L);
      paramDownloadParam = new File(a(paramDownloadParam));
      paramBoolean = bool2;
      if (paramDownloadParam.exists())
      {
        long l2 = paramDownloadParam.lastModified();
        l1 = l2;
        paramBoolean = bool2;
        if (l3 > 0L)
        {
          l1 = l2;
          paramBoolean = bool2;
          if (l3 != l2)
          {
            paramBoolean = false;
            l1 = l2;
          }
        }
      }
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("AvGameResHandler", 2, "verifyUnzipDir result = " + paramBoolean + ",recordedModifyTime = " + l3 + ",realModifyTime = " + l1);
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public String b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (paramDownloadParam.a) {}
    for (paramDownloadParam = a() + paramDownloadParam.b + ".end";; paramDownloadParam = a(paramDownloadParam.b, paramDownloadParam.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResHandler", 2, "getDownloadPath path[" + paramDownloadParam + "]");
      }
      return paramDownloadParam;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameResHandler
 * JD-Core Version:    0.7.0.1
 */