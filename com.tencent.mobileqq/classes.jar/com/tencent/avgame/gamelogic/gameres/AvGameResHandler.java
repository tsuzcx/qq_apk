package com.tencent.avgame.gamelogic.gameres;

import android.content.SharedPreferences;
import com.tencent.avgame.gamelogic.gameres.api.IResDownloadManager.DownloadParam;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class AvGameResHandler
  extends ResDownloadHandler.DefaultRDHandler
{
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("star/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b());
    ((StringBuilder)localObject).append("star/");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if ((localFile.exists()) && (localFile.listFiles() != null) && (localFile.listFiles().length >= 100))
    {
      FileUtils.deleteDirectory((String)localObject);
      QLog.d("AvGameResHandler", 1, "shouldClearStarEffectVideoFiles [delete star video effect files]");
    }
  }
  
  private static String b()
  {
    if (SystemUtil.a()) {
      localObject1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
    } else {
      localObject1 = MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath();
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith(File.separator))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(File.separator);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("avgame/res");
    ((StringBuilder)localObject1).append(File.separator);
    return ((StringBuilder)localObject1).toString();
  }
  
  public String a(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(paramDownloadParam.c);
    localStringBuilder.append(File.separator);
    paramDownloadParam = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUnzipDirPath dir = ");
      localStringBuilder.append(paramDownloadParam);
      QLog.d("AvGameResHandler", 2, localStringBuilder.toString());
    }
    return paramDownloadParam;
  }
  
  public boolean a(IResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    paramBoolean = paramDownloadParam.f;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramBoolean)
    {
      SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("av_game_sp", 4);
      String str = paramDownloadParam.c;
      long l1 = -1L;
      long l3 = localSharedPreferences.getLong(str, -1L);
      paramDownloadParam = new File(a(paramDownloadParam));
      paramBoolean = bool2;
      if (paramDownloadParam.exists())
      {
        long l2 = paramDownloadParam.lastModified();
        paramBoolean = bool2;
        l1 = l2;
        if (l3 > 0L)
        {
          paramBoolean = bool2;
          l1 = l2;
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
        paramDownloadParam = new StringBuilder();
        paramDownloadParam.append("verifyUnzipDir result = ");
        paramDownloadParam.append(paramBoolean);
        paramDownloadParam.append(",recordedModifyTime = ");
        paramDownloadParam.append(l3);
        paramDownloadParam.append(",realModifyTime = ");
        paramDownloadParam.append(l1);
        QLog.d("AvGameResHandler", 2, paramDownloadParam.toString());
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public String b(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    StringBuilder localStringBuilder;
    if (paramDownloadParam.f)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b());
      localStringBuilder.append(paramDownloadParam.c);
      localStringBuilder.append(".end");
      paramDownloadParam = localStringBuilder.toString();
    }
    else
    {
      paramDownloadParam = a(paramDownloadParam.c, paramDownloadParam.d);
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDownloadPath path[");
      localStringBuilder.append(paramDownloadParam);
      localStringBuilder.append("]");
      QLog.d("AvGameResHandler", 2, localStringBuilder.toString());
    }
    return paramDownloadParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameResHandler
 * JD-Core Version:    0.7.0.1
 */