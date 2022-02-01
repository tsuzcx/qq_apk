package com.tencent.mobileqq.ar;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ARDeviceController
{
  private static ARDeviceController jdField_a_of_type_ComTencentMobileqqArARDeviceController = new ARDeviceController();
  private int jdField_a_of_type_Int = 5;
  private ArEffectConfig jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
  private String jdField_a_of_type_JavaLangString = a(Build.MODEL);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  
  private ARDeviceController()
  {
    boolean bool = true;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.e = true;
    this.jdField_d_of_type_Int = 0;
    this.f = true;
    this.g = false;
    Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4);
    this.jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("gpu_renderer", null);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = a(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_c_of_type_Int = ((SharedPreferences)localObject1).getInt("ar_incompatible_reason", 0);
    this.jdField_d_of_type_Int = ((SharedPreferences)localObject1).getInt("ar_load_so_crash_time", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("ar_load_so_crash_version", "");
    if (!AppSetting.f().equals(localObject2))
    {
      localObject2 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject2).putInt("ar_load_so_crash_time", 0);
      SharedPreUtils.a((SharedPreferences.Editor)localObject2);
      this.jdField_d_of_type_Int = 0;
    }
    int i = ((SharedPreferences)localObject1).getInt("ar_native_so_crash_version", 0);
    if (((SharedPreferences)localObject1).getInt("ar_native_so_version", 0) != i)
    {
      ((SharedPreferences)localObject1).edit().putInt("ar_load_so_crash_time", 0).commit();
      this.jdField_d_of_type_Int = 0;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getDeviceConfigurationInfo();
        if (localObject1 != null)
        {
          if (((ConfigurationInfo)localObject1).reqGlEsVersion < 131072) {
            break label279;
          }
          this.g = bool;
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label279:
      bool = false;
    }
  }
  
  public static ARDeviceController a()
  {
    return jdField_a_of_type_ComTencentMobileqqArARDeviceController;
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      if (((c1 >= '0') && (c1 <= '9')) || ((c1 >= 'a') && (c1 <= 'z'))) {
        localStringBuilder.append(c1);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      localObject = ((ArEffectConfig)localObject).a.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a((String)((Iterator)localObject).next()).equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Int = 5;
          this.jdField_b_of_type_Int = 1;
          i = 1;
          break label92;
        }
      }
      i = 0;
      label92:
      int j = i;
      if (i == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.c.iterator();
        do
        {
          k = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!a((String)((Iterator)localObject).next()).equals(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_Boolean = true;
        k = 1;
        j = k;
        if (k == 0)
        {
          this.jdField_a_of_type_Boolean = false;
          j = k;
        }
      }
      int k = j;
      ArDefaultSetting localArDefaultSetting;
      if (j == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.e.iterator();
        do
        {
          k = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArDefaultSetting = (ArDefaultSetting)((Iterator)localObject).next();
        } while ((localArDefaultSetting.jdField_a_of_type_Int != 0) || (!a(localArDefaultSetting.jdField_a_of_type_JavaLangString).equals(this.jdField_a_of_type_JavaLangString)));
        this.jdField_a_of_type_Int = localArDefaultSetting.jdField_c_of_type_Int;
        this.jdField_b_of_type_Int = localArDefaultSetting.jdField_b_of_type_Int;
        k = 1;
      }
      i = k;
      if (k == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.b.iterator();
        do
        {
          i = k;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!a((String)((Iterator)localObject).next()).equals(this.jdField_b_of_type_JavaLangString));
        this.jdField_a_of_type_Int = 5;
        this.jdField_b_of_type_Int = 1;
        i = 1;
      }
      j = i;
      if (i == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.d.iterator();
        do
        {
          k = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!a((String)((Iterator)localObject).next()).equals(this.jdField_b_of_type_JavaLangString));
        this.jdField_a_of_type_Boolean = true;
        k = 1;
        j = k;
        if (k == 0)
        {
          this.jdField_a_of_type_Boolean = false;
          j = k;
        }
      }
      i = j;
      if (j == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.e.iterator();
        do
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArDefaultSetting = (ArDefaultSetting)((Iterator)localObject).next();
        } while ((localArDefaultSetting.jdField_a_of_type_Int != 1) || (!a(localArDefaultSetting.jdField_a_of_type_JavaLangString).equals(this.jdField_b_of_type_JavaLangString)));
        this.jdField_a_of_type_Int = localArDefaultSetting.jdField_c_of_type_Int;
        this.jdField_b_of_type_Int = localArDefaultSetting.jdField_b_of_type_Int;
        i = 1;
      }
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      i = this.jdField_a_of_type_Int;
      if ((i >= 1) && (i <= 5))
      {
        i = this.jdField_b_of_type_Int;
        if ((i >= 0) && (i <= 1))
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_c_of_type_Boolean = false;
          this.jdField_d_of_type_Boolean = true;
          return;
        }
      }
    }
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("ar_adjust_track_quality", -1);
    int i = this.jdField_a_of_type_Int;
    if ((i >= 1) && (i <= 5))
    {
      this.jdField_b_of_type_Boolean = false;
    }
    else
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 5;
    }
    this.jdField_b_of_type_Int = localSharedPreferences.getInt("ar_adjust_render_quality", -1);
    i = this.jdField_b_of_type_Int;
    if ((i >= 0) && (i <= 1))
    {
      this.jdField_c_of_type_Boolean = false;
    }
    else
    {
      this.jdField_b_of_type_Int = 1;
      this.jdField_c_of_type_Boolean = true;
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if ((this.e) || (this.jdField_c_of_type_Int != paramInt))
    {
      this.e = false;
      ThreadManager.post(new ARDeviceController.1(this, paramInt, paramBoolean), 5, null, true);
    }
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = paramArEffectConfig;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      a();
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = a(paramString);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
    localEditor.putString("gpu_renderer", paramString);
    SharedPreUtils.a(localEditor);
    a(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) {
      a();
    }
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_d_of_type_Int >= 5)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARDeviceController", 2, "isAREnable enable= false,failCode= 870888");
          }
          a(false, 870888);
          return false;
        }
        boolean bool2 = this.f;
        boolean bool1 = true;
        if (bool2)
        {
          this.f = false;
          this.jdField_d_of_type_Int += 1;
          Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
          SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
          localEditor.putInt("ar_load_so_crash_time", this.jdField_d_of_type_Int);
          localEditor.putString("ar_load_so_crash_version", AppSetting.f());
          localEditor.putInt("ar_native_so_crash_version", ((SharedPreferences)localObject1).getInt("ar_native_so_version", 0));
          SharedPreUtils.a(localEditor);
          j = 1;
          if (this.jdField_a_of_type_Boolean)
          {
            bool1 = false;
            i = 870882;
          }
          else if (Build.VERSION.SDK_INT < 14)
          {
            bool1 = false;
            i = 870881;
          }
          else if (!this.g)
          {
            bool1 = false;
            i = 870883;
          }
          else if (VcSystemInfo.getCpuArchitecture() < 3)
          {
            bool1 = false;
            i = 870884;
          }
          else
          {
            if (OlympicUtil.a()) {
              break label341;
            }
            bool1 = false;
            i = 870886;
          }
          a(bool1, i);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("isAREnable enable= ");
            ((StringBuilder)localObject1).append(bool1);
            ((StringBuilder)localObject1).append(",failCode= ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("ARDeviceController", 2, ((StringBuilder)localObject1).toString());
          }
          if (j != 0)
          {
            localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
            ((SharedPreferences.Editor)localObject1).putInt("ar_load_so_crash_time", 0);
            SharedPreUtils.a((SharedPreferences.Editor)localObject1);
            this.jdField_d_of_type_Int = 0;
          }
          return bool1;
        }
      }
      finally {}
      int j = 0;
      continue;
      label341:
      int i = 0;
    }
  }
  
  public boolean b()
  {
    int i = this.jdField_d_of_type_Int;
    boolean bool = false;
    if (i >= 5)
    {
      i = 870888;
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      i = 870882;
    }
    else if (Build.VERSION.SDK_INT < 14)
    {
      i = 870881;
    }
    else if (!this.g)
    {
      i = 870883;
    }
    else if (VcSystemInfo.getCpuArchitecture() < 3)
    {
      i = 870884;
    }
    else if (!OlympicUtil.a())
    {
      i = 870886;
    }
    else
    {
      i = 0;
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportAr enable= ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",errorCode= ");
      localStringBuilder.append(i);
      QLog.d("ARDeviceController", 2, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARDeviceController
 * JD-Core Version:    0.7.0.1
 */