package com.tencent.mobileqq.app.automator.step;

import akmg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import ayrv;
import ayry;
import ayrz;
import aysa;
import aysw;
import aysx;
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
  implements aysa
{
  protected static ayrz a;
  private long a;
  private final String b = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
  private final String c = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
  private int d = -1;
  
  static
  {
    jdField_a_of_type_Ayrz = new akmg();
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
        ayrv localayrv = new ayrv();
        localayrv.jdField_a_of_type_Aysa = this;
        localayrv.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
        localayrv.jdField_a_of_type_Int = 0;
        localayrv.c = str;
        localayrv.e = 0;
        localayrv.jdField_a_of_type_Ayrz = jdField_a_of_type_Ayrz;
        ((ayry)localObject).a(localayrv);
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
      ayrv localayrv = new ayrv();
      localayrv.jdField_a_of_type_Aysa = this;
      localayrv.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
      localayrv.jdField_a_of_type_Int = 0;
      localayrv.c = str;
      localayrv.e = 0;
      localayrv.jdField_a_of_type_Ayrz = jdField_a_of_type_Ayrz;
      ((ayry)localObject).a(localayrv);
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
  
  public void onResp(aysx paramaysx)
  {
    if (paramaysx.jdField_a_of_type_Int == 0) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = (ayrv)paramaysx.jdField_a_of_type_Aysw;
      File localFile = new File(((ayrv)localObject).c);
      if (i != 0)
      {
        if (((ayrv)localObject).jdField_a_of_type_JavaLangString.equals("http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MonitorSocketDownload", 2, "file exists " + localFile.exists());
          }
          try
          {
            paramaysx = new BufferedReader(new InputStreamReader(new FileInputStream(localFile)));
            localObject = paramaysx.readLine();
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
              paramaysx.close();
              return;
              label208:
              b();
              this.d = i;
            }
            if (!((ayrv)localObject).jdField_a_of_type_JavaLangString.equals("http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt")) {
              break label471;
            }
          }
          catch (Exception paramaysx)
          {
            QLog.d("MonitorSocketDownload", 1, "" + paramaysx);
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
          for (paramaysx = ((BufferedReader)localObject).readLine(); paramaysx != null; paramaysx = ((BufferedReader)localObject).readLine()) {
            QLog.d("MonitorSocketDownload", 2, "Banlist: " + paramaysx + ", used " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
          }
          ((BufferedReader)localObject).close();
          return;
        }
        catch (Exception paramaysx)
        {
          QLog.d("MonitorSocketDownload", 1, "" + paramaysx);
          return;
        }
      }
      QLog.d("MonitorSocketDownload", 1, "result: " + paramaysx.jdField_a_of_type_Int);
      label471:
      return;
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.MonitorSocketDownload
 * JD-Core Version:    0.7.0.1
 */