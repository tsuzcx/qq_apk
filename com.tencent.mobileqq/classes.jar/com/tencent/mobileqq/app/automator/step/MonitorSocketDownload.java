package com.tencent.mobileqq.app.automator.step;

import akmf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import ayrx;
import aysa;
import aysb;
import aysc;
import aysy;
import aysz;
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
  implements aysc
{
  protected static aysb a;
  private long a;
  private final String b = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
  private final String c = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
  private int d = -1;
  
  static
  {
    jdField_a_of_type_Aysb = new akmf();
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
        ayrx localayrx = new ayrx();
        localayrx.jdField_a_of_type_Aysc = this;
        localayrx.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
        localayrx.jdField_a_of_type_Int = 0;
        localayrx.c = str;
        localayrx.e = 0;
        localayrx.jdField_a_of_type_Aysb = jdField_a_of_type_Aysb;
        ((aysa)localObject).a(localayrx);
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
      ayrx localayrx = new ayrx();
      localayrx.jdField_a_of_type_Aysc = this;
      localayrx.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
      localayrx.jdField_a_of_type_Int = 0;
      localayrx.c = str;
      localayrx.e = 0;
      localayrx.jdField_a_of_type_Aysb = jdField_a_of_type_Aysb;
      ((aysa)localObject).a(localayrx);
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
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_a_of_type_Int == 0) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = (ayrx)paramaysz.jdField_a_of_type_Aysy;
      File localFile = new File(((ayrx)localObject).c);
      if (i != 0)
      {
        if (((ayrx)localObject).jdField_a_of_type_JavaLangString.equals("http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MonitorSocketDownload", 2, "file exists " + localFile.exists());
          }
          try
          {
            paramaysz = new BufferedReader(new InputStreamReader(new FileInputStream(localFile)));
            localObject = paramaysz.readLine();
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
              paramaysz.close();
              return;
              label208:
              b();
              this.d = i;
            }
            if (!((ayrx)localObject).jdField_a_of_type_JavaLangString.equals("http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt")) {
              break label471;
            }
          }
          catch (Exception paramaysz)
          {
            QLog.d("MonitorSocketDownload", 1, "" + paramaysz);
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
          for (paramaysz = ((BufferedReader)localObject).readLine(); paramaysz != null; paramaysz = ((BufferedReader)localObject).readLine()) {
            QLog.d("MonitorSocketDownload", 2, "Banlist: " + paramaysz + ", used " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
          }
          ((BufferedReader)localObject).close();
          return;
        }
        catch (Exception paramaysz)
        {
          QLog.d("MonitorSocketDownload", 1, "" + paramaysz);
          return;
        }
      }
      QLog.d("MonitorSocketDownload", 1, "result: " + paramaysz.jdField_a_of_type_Int);
      label471:
      return;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.MonitorSocketDownload
 * JD-Core Version:    0.7.0.1
 */