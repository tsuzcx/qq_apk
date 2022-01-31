package com.tencent.av.gameplay;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jju;
import mqq.os.MqqHandler;

public class GPNativeSoLoader
{
  public static boolean a;
  private static boolean b;
  
  public static byte a(String paramString)
  {
    byte b1 = 0;
    if (paramString == null) {
      b1 = -1;
    }
    do
    {
      for (;;)
      {
        return b1;
        Object localObject = QAVGamePlaySoConfigInfo.a();
        if (localObject != null) {
          new StringBuilder().append(((QAVGamePlaySoConfigInfo)localObject).b).append("/").toString();
        }
        paramString = QavGamePlayUtil.a() + "lib" + paramString + ".so";
        if (QLog.isColorLevel()) {
          QLog.i("Qav_GamePlayNativeSoLoader", 2, "start arNativeSo: " + paramString);
        }
        localObject = new File(paramString);
        if ((!a) && (((File)localObject).exists())) {
          try
          {
            System.load(paramString);
            b = true;
            if (QLog.isColorLevel())
            {
              QLog.i("Qav_GamePlayNativeSoLoader", 2, "load " + paramString + " success!");
              return 0;
            }
          }
          catch (UnsatisfiedLinkError paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Qav_GamePlayNativeSoLoader", 2, "load from ar dir failed.", paramString);
            }
            return -3;
          }
        }
      }
      b1 = -2;
    } while (!QLog.isColorLevel());
    QLog.i("Qav_GamePlayNativeSoLoader", 2, "no ar so in ar dir");
    return -2;
  }
  
  public static boolean a()
  {
    if (b) {}
    do
    {
      return true;
      if (!QavGPDownloadManager.a().a()) {
        break;
      }
    } while (a("qavgameplayengine") == 0);
    return false;
    ThreadManager.getUIHandler().post(new jju());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.gameplay.GPNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */