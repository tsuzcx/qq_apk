package com.tencent.avgame.gameres;

import android.content.SharedPreferences;
import com.tencent.avgame.gamelogic.gameres.IAvGameResPreloadManager;
import com.tencent.avgame.gamelogic.gameres.IAvGameResPreloadManager.ConfInfo;
import com.tencent.avgame.gamelogic.gameres.IAvGameResPreloadManager.PathInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class AvGameResPreloadManager
  implements IAvGameResPreloadManager
{
  public static IAvGameResPreloadManager.ConfInfo a()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("av_game_sp", 4);
    IAvGameResPreloadManager.ConfInfo localConfInfo = new IAvGameResPreloadManager.ConfInfo();
    localConfInfo.d = localSharedPreferences.getString("preloadVoiceRecogSoMD5", "");
    localConfInfo.e = localSharedPreferences.getString("preloadVoiceRecogSoFileMD5", "");
    localConfInfo.g = localSharedPreferences.getString("preloadVoiceRecogModelMD5", "");
    localConfInfo.h = localSharedPreferences.getString("preloadVoiceRecogModelFileMD5", "");
    localConfInfo.j = localSharedPreferences.getString("preloadVoiceRecogAILabSoMD5", "");
    localConfInfo.k = localSharedPreferences.getString("preloadVoiceRecogAILabSoFileMD5", "");
    localConfInfo.m = localSharedPreferences.getString("preloadVoiceRecogAILabModelMD5", "");
    localConfInfo.n = localSharedPreferences.getString("preloadVoiceRecogAILabModelFileMD5", "");
    return localConfInfo;
  }
  
  public static IAvGameResPreloadManager.PathInfo a()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("av_game_sp", 4);
    IAvGameResPreloadManager.PathInfo localPathInfo = new IAvGameResPreloadManager.PathInfo();
    localPathInfo.b = localSharedPreferences.getString("preloadVoiceRecogSoPath", "");
    localPathInfo.c = localSharedPreferences.getString("preloadVoiceRecogModelPath", "");
    localPathInfo.d = localSharedPreferences.getString("preloadVoiceRecogAILabSoPath", "");
    localPathInfo.e = localSharedPreferences.getString("preloadVoiceRecogAILabModelPath", "");
    return localPathInfo;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString1.substring(0, paramString1.lastIndexOf(File.separator));
    Object localObject1 = paramString1.substring(paramString1.lastIndexOf(File.separator) + 1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString4);
    ((StringBuilder)localObject2).append(paramString2);
    paramString2 = ((StringBuilder)localObject2).toString();
    paramString4 = new StringBuilder();
    paramString4.append(paramString2);
    paramString4.append(File.separator);
    paramString4.append((String)localObject1);
    paramString4 = paramString4.toString();
    localObject2 = FileUtils.calcMd5(paramString1);
    if ((localObject2 != null) && (((String)localObject2).equalsIgnoreCase(paramString3)))
    {
      if (FileUtils.fileExists(paramString4))
      {
        paramString1 = new StringBuilder();
        paramString1.append("copyPreload. file already exists: ");
        paramString1.append(paramString4);
        QLog.d("AvGameResPreloadManager", 1, paramString1.toString());
        bool = a(str, paramString2);
        paramString1 = FileUtils.calcMd5(paramString4);
        if ((!bool) && (paramString1 != null) && (paramString1.equalsIgnoreCase(paramString3)))
        {
          QLog.d("AvGameResPreloadManager", 1, "copyPreload. file already exists and everything ok");
          return paramString4;
        }
        paramString1 = new StringBuilder();
        paramString1.append("copyResFile. file already exists but root filesDiff or md5 not equals, so delete: ");
        paramString1.append(paramString4);
        paramString1.append(", filesDiff:");
        paramString1.append(bool);
        QLog.w("AvGameResPreloadManager", 1, paramString1.toString());
      }
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("_temp");
      paramString1 = paramString1.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).toString();
      FileUtils.deleteDirectory(paramString2);
      FileUtils.deleteDirectory(paramString1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("copyResFile. copy from ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" to ");
      ((StringBuilder)localObject1).append(paramString1);
      QLog.d("AvGameResPreloadManager", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(File.separator);
      if (FileUtils.copyDirectory(str, ((StringBuilder)localObject1).toString(), false) != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("copyResFile. FileUtils.copyDirectory fails from ");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(" to ");
        ((StringBuilder)localObject1).append(paramString1);
        QLog.e("AvGameResPreloadManager", 1, ((StringBuilder)localObject1).toString());
      }
      if (!FileUtils.rename(paramString1, paramString2))
      {
        paramString3 = new StringBuilder();
        paramString3.append("copyResFile. fails to rename: ");
        paramString3.append(paramString1);
        paramString3.append(" to ");
        paramString3.append(paramString2);
        QLog.e("AvGameResPreloadManager", 1, paramString3.toString());
        return "";
      }
      boolean bool = a(str, paramString2);
      paramString1 = FileUtils.calcMd5(paramString4);
      if ((!bool) && (paramString1 != null) && (paramString1.equalsIgnoreCase(paramString3))) {
        return paramString4;
      }
      paramString1 = new StringBuilder();
      paramString1.append("copyResFile. fails to check final copied dstResFilePath md5 as not equals or filesDiff: ");
      paramString1.append(paramString4);
      paramString1.append(", filesDiff:");
      paramString1.append(bool);
      QLog.w("AvGameResPreloadManager", 1, paramString1.toString());
      return "";
    }
    paramString2 = new StringBuilder();
    paramString2.append("copyResFile. fails to check srcResPath:");
    paramString2.append(paramString1);
    paramString2.append(", md5:");
    paramString2.append(paramString3);
    paramString2.append(", as not equals calculated: ");
    paramString2.append((String)localObject2);
    QLog.w("AvGameResPreloadManager", 1, paramString2.toString());
    return "";
  }
  
  private static ArrayList<String> a(String paramString)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramString.add(localObject[i].getName());
      i += 1;
    }
    return paramString;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dirCompare. srcFiles: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", dstFiles:");
    localStringBuilder.append(paramString2);
    QLog.d("AvGameResPreloadManager", 1, localStringBuilder.toString());
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext()) {
      if (!paramString2.contains((String)paramString1.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameres.AvGameResPreloadManager
 * JD-Core Version:    0.7.0.1
 */