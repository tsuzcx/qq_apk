package com.tencent.mobileqq.activity.springfestival.config;

import android.content.Context;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.springfestival.Utils;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.activity.springfestival.entry.model.HtmlOfflineCheckConfig;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class SpringFestivalRedpacketConfigManager
  implements Manager
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private SpringFestivalRedpacketConfProcessor jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor;
  
  public SpringFestivalRedpacketConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApplication().getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor = new SpringFestivalRedpacketConfProcessor(paramQQAppInterface);
  }
  
  private void a(HtmlOfflineCheckConfig paramHtmlOfflineCheckConfig, int paramInt1, int paramInt2)
  {
    if (paramHtmlOfflineCheckConfig == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, "htmlOfflineCheckConfig is empty, not process!!!");
        }
        return;
      }
      finally {}
      Object localObject = paramHtmlOfflineCheckConfig.bids;
      if (StringUtil.a((String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, "bids is empty, not process!!!");
        }
      }
      else
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          paramInt2 = localObject.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            String str = localObject[paramInt1];
            if (!a(str))
            {
              if (QLog.isColorLevel()) {
                QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, "should not check offline package!!!");
              }
            }
            else
            {
              int i = Utils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), str);
              if (i >= paramHtmlOfflineCheckConfig.total_cnt)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, "already bigger than total cnt!!!");
                }
              }
              else
              {
                long l = Utils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), str);
                if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - l) < paramHtmlOfflineCheckConfig.time_interval * 3600000L)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, "time interval not bigger than time interval in config!!!");
                  }
                }
                else if (!Utils.a(this.jdField_a_of_type_AndroidContentContext, paramHtmlOfflineCheckConfig.net_type))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, "current network is not allow download!!!");
                  }
                }
                else {
                  HtmlOffline.b(str, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new SpringFestivalRedpacketConfigManager.2(this, str, i), true, 0, true);
                }
              }
            }
            paramInt1 += 1;
          }
        }
      }
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor.a();
    }
    return i;
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor != null) {
      l = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor.a();
    }
    return l;
  }
  
  public EntryConfigBean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, "getSpringFestivalRedpacketConfBean mEntryConfigProcessor is empty!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean)
  {
    try
    {
      QLog.d("shua2021_SpringFestivalRedpacketConfigManager", 1, String.format("getSpringFestivalConfig fromStart=%b ver=%d peakVer=%d offset=%s taskId=%d adcode=%d reqOccation=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong), Integer.valueOf(paramInt1) }));
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidContentContext, SpringFestivalRedpacketConfigServlet.class);
      localNewIntent.putExtra("k_cmd", 1);
      localNewIntent.putExtra("k_req_occasion", paramInt1);
      localNewIntent.putExtra("k_offset", paramInt4);
      localNewIntent.putExtra("k_id", paramInt5);
      localNewIntent.putExtra("k_version", paramInt2);
      localNewIntent.putExtra("k_peak_version", paramInt3);
      localNewIntent.putExtra("key_req_adcode", paramLong);
      localNewIntent.putExtra("k_cookie", paramArrayOfByte1);
      localNewIntent.putExtra("k_buff", paramArrayOfByte2);
      if (paramInt4 != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localNewIntent.putExtra("k_new_page", paramBoolean);
        localNewIntent.putExtra("k_retry", 0);
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
        return;
      }
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfigManager", 1, "getEntryConfig fail." + paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  public void a(int paramInt, SpringFestivalRedpacketPopBannerConfBean paramSpringFestivalRedpacketPopBannerConfBean)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor.a(paramInt, paramSpringFestivalRedpacketPopBannerConfBean);
      }
      return;
    }
    catch (Throwable paramSpringFestivalRedpacketPopBannerConfBean)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfigManager", 1, paramSpringFestivalRedpacketPopBannerConfBean.getMessage(), paramSpringFestivalRedpacketPopBannerConfBean);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfigByPush app=%s pushVersion=%s", new Object[] { paramQQAppInterface, Integer.valueOf(paramInt) }));
    }
    if ((paramQQAppInterface != null) && (paramInt >= 0)) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor != null)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor.a();
          if (QLog.isColorLevel()) {
            QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfigByPush app=%s localVersion=%s", new Object[] { paramQQAppInterface, Integer.valueOf(i) }));
          }
          if (i != paramInt)
          {
            b(paramQQAppInterface, 2);
            return;
          }
          QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 1, "getEntryConfigByPush push version is same as local.");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        SpringHbMonitorReporter.a(312, paramQQAppInterface, new String[] { paramInt + "" });
        QLog.e("shua2021_SpringFestivalRedpacketConfigManager", 1, "getEntryConfigByPush fail." + paramQQAppInterface.getMessage(), paramQQAppInterface);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = true;
    if (StringUtil.a(paramString)) {
      return false;
    }
    boolean bool2 = Utils.a(paramString);
    int i;
    if (bool2)
    {
      i = 0;
      SpringHbMonitorReporter.a(paramString, i, 0);
      if (bool2) {
        break label42;
      }
    }
    for (;;)
    {
      return bool1;
      i = 1;
      break;
      label42:
      bool1 = false;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString, List<Integer> paramList, int paramInt4, boolean paramBoolean3, long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor != null)
      {
        paramBoolean1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor.a(paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramInt3, paramString, paramList, paramInt4, paramBoolean3, paramLong);
        return paramBoolean1;
      }
    }
    catch (Throwable paramString)
    {
      SpringHbMonitorReporter.a(302, paramString, new String[0]);
      QLog.e("shua2021_SpringFestivalRedpacketConfigManager", 1, paramString.getMessage(), paramString);
    }
    return true;
  }
  
  public int b()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor.c();
    }
    return i;
  }
  
  public EntryConfigBean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, "getSpringFestivalRedpacketConfBeanFromCache mEntryConfigProcessor is empty!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor.b();
  }
  
  public void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfig app=%s reqOccasion=%s", new Object[] { paramQQAppInterface, Integer.valueOf(paramInt) }));
    if (paramQQAppInterface != null)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInt == 1) {}
      for (;;)
      {
        long l1;
        int j;
        int i;
        long l2;
        try
        {
          l1 = NetConnInfoCenter.getServerTimeMillis();
          if (Math.abs(l1 - this.jdField_a_of_type_Long) <= 3600000L)
          {
            bool1 = false;
            QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfig needReq=%s", new Object[] { Boolean.valueOf(bool1) }));
            if (!bool1) {
              break;
            }
            j = a();
            i = c();
            l2 = a();
            paramQQAppInterface = LocationUtils.a();
            if (paramQQAppInterface == null)
            {
              l1 = 0L;
              break label271;
              if (l2 == l1) {
                break label265;
              }
              bool1 = true;
              QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfig localVersion=%s localPeakVersion=%s adCodeChanged=%b useDebugAdcode=%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(false) }));
              a(paramInt, j, i, 0, 0, null, null, l1, true);
            }
          }
          else
          {
            this.jdField_a_of_type_Long = l1;
            bool1 = bool2;
            continue;
          }
          l1 = paramQQAppInterface.longValue();
        }
        catch (Exception paramQQAppInterface)
        {
          SpringHbMonitorReporter.a(301, paramQQAppInterface, new String[0]);
          QLog.e("shua2021_SpringFestivalRedpacketConfigManager", 1, "getEntryConfig fail." + paramQQAppInterface.getMessage(), paramQQAppInterface);
          return;
        }
        break label271;
        label265:
        bool1 = false;
        continue;
        label271:
        if (l2 != l1) {
          i = 0;
        }
        if (paramInt == 3) {
          j = 0;
        }
      }
    }
  }
  
  public int c()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketConfProcessor.b();
    }
    return i;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager
 * JD-Core Version:    0.7.0.1
 */