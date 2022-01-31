package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import zqf;
import zqk;
import zql;
import zqm;

public class CleanCache
  extends AsyncStep
{
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cleanZhituCache...");
    }
    long l1 = System.currentTimeMillis();
    if (ZhituManager.d()) {
      return;
    }
    ZhituManager.c(true);
    Object localObject1 = AppConstants.aJ + "zhitu";
    localObject1 = new File((String)localObject1 + "/" + "origin/");
    int n;
    int k;
    int j;
    label150:
    int i;
    int m;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        n = localObject1.length;
        if (n > 200)
        {
          Arrays.sort((Object[])localObject1, new zqm(this));
          int i1 = localObject1.length;
          k = 0;
          j = 0;
          i = j;
          m = n;
          if (k < i1)
          {
            Object localObject2 = localObject1[k];
            if (QLog.isColorLevel()) {
              QLog.d("QQInitHandler", 2, "cleanZhituCache ===> deleteCount=" + j + ", delete dir=" + localObject2.getAbsolutePath());
            }
            FileUtils.a(localObject2.getAbsolutePath());
            i = j + 1;
            if (i < n - 50) {
              break label319;
            }
            m = n;
          }
        }
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      ZhituManager.c(false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQInitHandler", 2, "delShortVideoCache(), totalCount=" + m + ", deleteCount= " + i + ", targetDeleteCount=" + (m - 50) + ", cost: " + (l2 - l1) + " ms");
      return;
      label319:
      k += 1;
      j = i;
      break label150;
      i = 0;
      m = n;
      continue;
      i = 0;
      m = 0;
    }
  }
  
  protected int a()
  {
    this.a.b.getApp().getSharedPreferences("HEAD", 0).edit().clear().commit();
    b();
    ThreadManager.post(new zqf(this), 2, null, false);
    return 7;
  }
  
  public String a()
  {
    if ((this.a.b.getAccount() != null) && (this.a.b.isLogin())) {
      return this.a.b.getAccount();
    }
    return "0";
  }
  
  void b()
  {
    CardHandler.d();
    File localFile = new File(AppConstants.aJ + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      FileManagerUtil.a();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void d()
  {
    int i = 10;
    try
    {
      Object localObject = new File("/data/data/com.tencent.mobileqq/files/crashinfo/");
      if ((localObject != null) && (((File)localObject).exists()))
      {
        localObject = ((File)localObject).listFiles(new zqk(this));
        if ((localObject != null) && (localObject.length > 10))
        {
          Arrays.sort((Object[])localObject, new zql(this));
          while (i < localObject.length)
          {
            localObject[i].delete();
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("QQInitHandler", 1, "", localThrowable);
    }
  }
  
  public void e()
  {
    Object localObject2 = this.a.b.getEntityManagerFactory().createEntityManager();
    List localList = ((EntityManager)localObject2).a(Setting.class, new Setting().getTableName(), false, null, null, null, null, null, null);
    int i;
    if (localList != null) {
      i = localList.size();
    }
    Object localObject3;
    int k;
    int j;
    for (;;)
    {
      localObject3 = new ArrayList();
      k = 3500;
      Object localObject4 = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1").split("\\|");
      j = k;
      if (localObject4.length > 1) {}
      try
      {
        j = Integer.parseInt(localObject4[1]);
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, new Object[] { "cleanSetingData", i + "," + j });
        }
        if ((localList != null) && (i > j))
        {
          localObject4 = localList.iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              localSetting3 = (Setting)((Iterator)localObject4).next();
              if ((localSetting3 != null) && (!TextUtils.isEmpty(localSetting3.uin)))
              {
                i = 200;
                if (localSetting3.bUsrType == 32)
                {
                  i = 202;
                  String str = this.a.b.a(localSetting3, i);
                  if ((TextUtils.isEmpty(str)) || (new File(str).exists())) {
                    continue;
                  }
                  ((List)localObject3).add(localSetting3);
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("QQInitHandler", 2, "cleanSetingData," + localSetting3.uin + "," + localSetting3.bUsrType + "," + this.a.b.a(localSetting3, i));
                  continue;
                  i = 0;
                }
              }
            }
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Setting localSetting3;
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.e("QQInitHandler", 2, "cleanSetingData,", localException2);
            j = k;
            continue;
            if (localSetting3.bUsrType == 16) {
              i = 16;
            }
          }
        }
        i = ((List)localObject3).size();
        if ((localObject3 == null) || (i <= 0) || (!((EntityManager)localObject2).a())) {}
      }
    }
    for (;;)
    {
      try
      {
        ((EntityManager)localObject2).a().a();
        localObject3 = ((List)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          Setting localSetting2 = (Setting)((Iterator)localObject3).next();
          if (localSetting2 == null) {
            continue;
          }
          ((EntityManager)localObject2).b(localSetting2);
          continue;
        }
        Setting localSetting1;
        k = i + 1;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQInitHandler", 2, "cleanSetingData,", localException1);
        }
        ((EntityManager)localObject2).a().b();
        if (localList == null) {
          break label738;
        }
        localObject2 = localList.iterator();
        j = 0;
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label648;
        }
        localSetting1 = (Setting)((Iterator)localObject2).next();
        if ((localSetting1 == null) || (TextUtils.isEmpty(localSetting1.uin))) {
          continue;
        }
        if (localSetting1 == null) {
          break label744;
        }
        if ((localSetting1.bSourceType == 1) || (localSetting1.bUsrType == 32))
        {
          k = j + 1;
          j = i;
          i = k;
          k = j;
          j = i;
          i = k;
          continue;
          ((EntityManager)localObject2).a().c();
          ((EntityManager)localObject2).a().b();
          continue;
        }
      }
      finally
      {
        ((EntityManager)localObject2).a().b();
      }
      i = j;
      j = k;
      continue;
      label648:
      localObject2 = new HashMap();
      if (localObject1 != null) {}
      for (k = localObject1.size();; k = 0)
      {
        ((HashMap)localObject2).put("dataSize", String.valueOf(k));
        ((HashMap)localObject2).put("highSize", String.valueOf(i));
        ((HashMap)localObject2).put("lowSize", String.valueOf(j));
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a.getCurrentAccountUin(), "qq_head_setting", false, 0L, 0L, (HashMap)localObject2, "");
        label738:
        return;
      }
      label744:
      k = i;
      i = j;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache
 * JD-Core Version:    0.7.0.1
 */