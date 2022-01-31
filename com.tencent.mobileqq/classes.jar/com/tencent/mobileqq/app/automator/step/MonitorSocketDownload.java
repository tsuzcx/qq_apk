package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import zxq;

public class MonitorSocketDownload
  extends AsyncStep
  implements INetEngine.INetEngineListener
{
  protected static INetEngine.IBreakDownFix a;
  private long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
  private final String c = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
  private int d = -1;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new zxq();
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
        HttpNetReq localHttpNetReq = new HttpNetReq();
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
        localHttpNetReq.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
        localHttpNetReq.jdField_a_of_type_Int = 0;
        localHttpNetReq.c = str;
        localHttpNetReq.e = 0;
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
        ((INetEngine)localObject).a(localHttpNetReq);
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
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
      localHttpNetReq.jdField_a_of_type_Int = 0;
      localHttpNetReq.c = str;
      localHttpNetReq.e = 0;
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
      ((INetEngine)localObject).a(localHttpNetReq);
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
  
  protected int a()
  {
    return b();
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 0) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      File localFile = new File(((HttpNetReq)localObject).c);
      if (i != 0)
      {
        if (((HttpNetReq)localObject).jdField_a_of_type_JavaLangString.equals("http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MonitorSocketDownload", 2, "file exists " + localFile.exists());
          }
          try
          {
            paramNetResp = new BufferedReader(new InputStreamReader(new FileInputStream(localFile)));
            localObject = paramNetResp.readLine();
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
              paramNetResp.close();
              return;
              label208:
              b();
              this.d = i;
            }
            if (!((HttpNetReq)localObject).jdField_a_of_type_JavaLangString.equals("http://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt")) {
              break label471;
            }
          }
          catch (Exception paramNetResp)
          {
            QLog.d("MonitorSocketDownload", 1, "" + paramNetResp);
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
          for (paramNetResp = ((BufferedReader)localObject).readLine(); paramNetResp != null; paramNetResp = ((BufferedReader)localObject).readLine()) {
            QLog.d("MonitorSocketDownload", 2, "Banlist: " + paramNetResp + ", used " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
          }
          ((BufferedReader)localObject).close();
          return;
        }
        catch (Exception paramNetResp)
        {
          QLog.d("MonitorSocketDownload", 1, "" + paramNetResp);
          return;
        }
      }
      QLog.d("MonitorSocketDownload", 1, "result: " + paramNetResp.jdField_a_of_type_Int);
      label471:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.MonitorSocketDownload
 * JD-Core Version:    0.7.0.1
 */