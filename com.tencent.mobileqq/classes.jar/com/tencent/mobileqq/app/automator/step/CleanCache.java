package com.tencent.mobileqq.app.automator.step;

import agwq;
import aljq;
import alkv;
import amdd;
import amde;
import amdf;
import amdg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import arni;
import awbw;
import awbx;
import awby;
import axte;
import azmz;
import bdcs;
import bduw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CleanCache
  extends AsyncStep
{
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { aljq.bl };
  }
  
  public static final void a(String paramString)
  {
    paramString = new File(paramString + ".nomedia");
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "create nomedia file:" + paramString.getAbsolutePath());
      }
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cleanZhituCache...");
    }
    long l1 = System.currentTimeMillis();
    if (agwq.f()) {
      return;
    }
    agwq.d(true);
    Object localObject1 = aljq.aX + "zhitu";
    localObject1 = new File(bduw.a((String)localObject1 + "/" + "origin/"));
    int n;
    int k;
    int j;
    label153:
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
          Arrays.sort((Object[])localObject1, new amdf(this));
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
            bdcs.a(localObject2.getAbsolutePath());
            i = j + 1;
            if (i < n - 50) {
              break label322;
            }
            m = n;
          }
        }
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      agwq.d(false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQInitHandler", 2, "delShortVideoCache(), totalCount=" + m + ", deleteCount= " + i + ", targetDeleteCount=" + (m - 50) + ", cost: " + (l2 - l1) + " ms");
      return;
      label322:
      k += 1;
      j = i;
      break label153;
      i = 0;
      m = n;
      continue;
      i = 0;
      m = 0;
    }
  }
  
  private void g()
  {
    int i = 0;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cleanLightVideoCache...");
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = new File(axte.a);
    int n;
    int k;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        n = localObject1.length;
        m = n;
        if (n > 25)
        {
          Arrays.sort((Object[])localObject1, new amdg(this));
          int i1 = localObject1.length;
          k = 0;
          i = j;
          m = n;
          if (k < i1)
          {
            Object localObject2 = localObject1[k];
            if (QLog.isColorLevel()) {
              QLog.d("QQInitHandler", 2, "cleanLightVideoCache ===> deleteCount=" + j + ", delete dir=" + localObject2.getAbsolutePath());
            }
            bdcs.a(localObject2.getAbsolutePath());
            i = j + 1;
            if (i < n - 10) {
              break label264;
            }
          }
        }
      }
    }
    for (int m = n;; m = 0)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "cleanLightVideoCache(), totalCount=" + m + ", deleteCount= " + i + ", targetDeleteCount=" + (m - 10) + ", cost: " + (l2 - l1) + " ms");
      }
      return;
      label264:
      k += 1;
      j = i;
      break;
    }
  }
  
  public int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp().getSharedPreferences("HEAD", 0).edit().clear().commit();
    b();
    ThreadManager.post(new CleanCache.1(this), 2, null, false);
    return 7;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "initNoMediaFile");
    }
    alkv.c();
    arni.a();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (bdcs.a(str)) {
        a(str);
      }
      i += 1;
    }
  }
  
  void c()
  {
    int i = 10;
    try
    {
      Object localObject = new File("/data/data/com.tencent.mobileqq/files/crashinfo/");
      if ((localObject != null) && (((File)localObject).exists()))
      {
        localObject = ((File)localObject).listFiles(new amdd(this));
        if ((localObject != null) && (localObject.length > 10))
        {
          Arrays.sort((Object[])localObject, new amde(this));
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
  
  void e()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getEntityManagerFactory().createEntityManager();
    List localList = ((awbw)localObject2).a(Setting.class, new Setting().getTableName(), false, null, null, null, null, null, null);
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
      Object localObject4 = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1|0").split("\\|");
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
                  String str = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(localSetting3, i);
                  if ((TextUtils.isEmpty(str)) || (new File(str).exists())) {
                    continue;
                  }
                  ((List)localObject3).add(localSetting3);
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("QQInitHandler", 2, "cleanSetingData," + localSetting3.uin + "," + localSetting3.bUsrType + "," + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(localSetting3, i));
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
        if ((localObject3 == null) || (i <= 0) || (!((awbw)localObject2).a())) {}
      }
    }
    for (;;)
    {
      try
      {
        ((awbw)localObject2).a().a();
        localObject3 = ((List)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          Setting localSetting2 = (Setting)((Iterator)localObject3).next();
          if (localSetting2 == null) {
            continue;
          }
          ((awbw)localObject2).b(localSetting2);
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
        ((awbw)localObject2).a().b();
        if (localList == null) {
          break label739;
        }
        localObject2 = localList.iterator();
        j = 0;
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label649;
        }
        localSetting1 = (Setting)((Iterator)localObject2).next();
        if ((localSetting1 == null) || (TextUtils.isEmpty(localSetting1.uin))) {
          continue;
        }
        if (localSetting1 == null) {
          break label745;
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
          ((awbw)localObject2).a().c();
          ((awbw)localObject2).a().b();
          continue;
        }
      }
      finally
      {
        ((awbw)localObject2).a().b();
      }
      i = j;
      j = k;
      continue;
      label649:
      localObject2 = new HashMap();
      if (localObject1 != null) {}
      for (k = localObject1.size();; k = 0)
      {
        ((HashMap)localObject2).put("dataSize", String.valueOf(k));
        ((HashMap)localObject2).put("highSize", String.valueOf(i));
        ((HashMap)localObject2).put("lowSize", String.valueOf(j));
        azmz.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.mApp.getCurrentAccountUin(), "qq_head_setting", false, 0L, 0L, (HashMap)localObject2, "");
        label739:
        return;
      }
      label745:
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