package com.tencent.av.gameplay;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QavGamePlayUtil
{
  public static int a(QAVGamePlaySoConfigInfo paramQAVGamePlaySoConfigInfo)
  {
    if (paramQAVGamePlaySoConfigInfo == null) {}
    do
    {
      do
      {
        return 11;
        if (!TextUtils.isEmpty(paramQAVGamePlaySoConfigInfo.c)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QavGPDownloadManager", 4, String.format("getEnableFlag, %s", new Object[] { paramQAVGamePlaySoConfigInfo }));
      return 11;
      if (!paramQAVGamePlaySoConfigInfo.a) {
        break;
      }
    } while (!a(paramQAVGamePlaySoConfigInfo));
    return 1;
    return 2;
  }
  
  static SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.qavgameplay", 4);
  }
  
  public static String a()
  {
    return UpdateAvSo.a();
  }
  
  public static boolean a(QAVGamePlaySoConfigInfo paramQAVGamePlaySoConfigInfo)
  {
    String str1 = paramQAVGamePlaySoConfigInfo.b;
    paramQAVGamePlaySoConfigInfo = a() + paramQAVGamePlaySoConfigInfo.d + ".so";
    String str2 = a().getString("so_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (FileUtils.a(paramQAVGamePlaySoConfigInfo)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramQAVGamePlaySoConfigInfo }));
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.gameplay.QavGamePlayUtil
 * JD-Core Version:    0.7.0.1
 */