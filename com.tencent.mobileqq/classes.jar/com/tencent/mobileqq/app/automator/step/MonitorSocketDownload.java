package com.tencent.mobileqq.app.automator.step;

import amdv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import baps;
import bapv;
import bapw;
import bapx;
import baqv;
import baqw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MonitorSocketDownload
  extends AsyncStep
  implements bapx
{
  protected static bapw a;
  private long a;
  private final String b = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
  private final String c = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
  private int d = -1;
  
  static
  {
    jdField_a_of_type_Bapw = new amdv();
  }
  
  private int b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      try
      {
        if (QLog.isColorLevel())
        {
          int i = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_socket_config", 0).getInt("version", -1);
          QLog.d("MonitorSocketDownload", 2, "checkVersion currentVersion: " + i);
        }
        String str = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + "/com.tencent.mobileqq_checkurl";
        localObject = ((QQAppInterface)localObject).getNetEngine(0);
        baps localbaps = new baps();
        localbaps.jdField_a_of_type_Bapx = this;
        localbaps.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
        localbaps.jdField_a_of_type_Int = 0;
        localbaps.c = str;
        localbaps.e = 0;
        localbaps.jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
        ((bapv)localObject).a(localbaps);
        if (QLog.isColorLevel()) {
          QLog.d("MonitorSocketDownload", 2, "send request to check version and decide whether to download MS config");
        }
        return 7;
      }
      catch (Exception localException)
      {
        QLog.d("MonitorSocketDownload", 1, "" + localException);
        return 6;
      }
    }
    return 7;
  }
  
  private void b()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    try
    {
      String str = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + "/monitor_config.properties";
      localObject = ((QQAppInterface)localObject).getNetEngine(0);
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Bapx = this;
      localbaps.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
      localbaps.jdField_a_of_type_Int = 0;
      localbaps.c = str;
      localbaps.e = 0;
      localbaps.jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
      ((bapv)localObject).a(localbaps);
      if (QLog.isColorLevel()) {
        QLog.d("MonitorSocketDownload", 2, "download MS config");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MonitorSocketDownload", 1, "" + localException);
    }
  }
  
  public int a()
  {
    return b();
  }
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 0) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = (baps)parambaqw.jdField_a_of_type_Baqv;
      File localFile = new File(((baps)localObject).c);
      if (i != 0)
      {
        if (((baps)localObject).jdField_a_of_type_JavaLangString.equals("http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MonitorSocketDownload", 2, "file exists " + localFile.exists());
          }
          try
          {
            parambaqw = new BufferedReader(new InputStreamReader(new FileInputStream(localFile)));
            localObject = parambaqw.readLine();
            if (localObject != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MonitorSocketDownload", 2, (String)localObject);
              }
              i = Integer.parseInt(localObject.split("\\=")[1]);
              if (BaseApplicationImpl.getApplication().getSharedPreferences("monitor_socket_config", 0).getInt("version", -1) != i) {
                break label208;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MonitorSocketDownload", 2, "config version does not change, no need to download config file, used " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
              }
            }
            for (;;)
            {
              parambaqw.close();
              return;
              label208:
              b();
              this.d = i;
            }
            if (!((baps)localObject).jdField_a_of_type_JavaLangString.equals("http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt")) {
              break label471;
            }
          }
          catch (Exception parambaqw)
          {
            QLog.d("MonitorSocketDownload", 1, "" + parambaqw);
            return;
          }
        }
        BaseApplicationImpl.getApplication().getSharedPreferences("monitor_socket_config", 0).edit().putInt("version", this.d).commit();
        if (!QLog.isColorLevel()) {
          break label471;
        }
        QLog.d("MonitorSocketDownload", 2, "monitorconfig download succ, version: " + this.d);
        try
        {
          localObject = new BufferedReader(new InputStreamReader(new FileInputStream(localFile)));
          for (parambaqw = ((BufferedReader)localObject).readLine(); parambaqw != null; parambaqw = ((BufferedReader)localObject).readLine()) {
            QLog.d("MonitorSocketDownload", 2, "Banlist: " + parambaqw + ", used " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
          }
          ((BufferedReader)localObject).close();
          return;
        }
        catch (Exception parambaqw)
        {
          QLog.d("MonitorSocketDownload", 1, "" + parambaqw);
          return;
        }
      }
      QLog.d("MonitorSocketDownload", 1, "result: " + parambaqw.jdField_a_of_type_Int);
      label471:
      return;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.MonitorSocketDownload
 * JD-Core Version:    0.7.0.1
 */