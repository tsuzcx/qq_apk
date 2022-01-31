package com.tencent.av.utils;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QQDingdongSoundHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class DingdongSoundUtil
{
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DingdongSoundUtil", 2, "[sound_early] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/dingdong/sound_early/";
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DingdongSoundUtil", 2, "[sound_early] trigger early download");
    }
    if (!new File(a(), "dingdong_schedule_notify.mp3").exists())
    {
      paramQQAppInterface = (EarlyDownloadManager)paramQQAppInterface.getManager(76);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (QQDingdongSoundHandler)paramQQAppInterface.a("qq.android.dingdong.ring");
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(false);
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(a(), paramString).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.DingdongSoundUtil
 * JD-Core Version:    0.7.0.1
 */