import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARDeviceController.1;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class apbb
{
  private static apbb jdField_a_of_type_Apbb = new apbb();
  private int jdField_a_of_type_Int = 5;
  private ArEffectConfig jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
  private String jdField_a_of_type_JavaLangString = a(Build.MODEL);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  private boolean f = true;
  private boolean g;
  private boolean h;
  
  private apbb()
  {
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
      bhhr.a((SharedPreferences.Editor)localObject2);
      this.jdField_d_of_type_Int = 0;
    }
    int i = ((SharedPreferences)localObject1).getInt("ar_native_so_crash_version", 0);
    if (((SharedPreferences)localObject1).getInt("ar_native_so_version", 0) != i)
    {
      ((SharedPreferences)localObject1).edit().putInt("ar_load_so_crash_time", 0).commit();
      this.jdField_d_of_type_Int = 0;
    }
    try
    {
      localObject1 = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getDeviceConfigurationInfo();
      if (localObject1 == null) {
        break label249;
      }
      if (((ConfigurationInfo)localObject1).reqGlEsVersion < 131072) {
        break label290;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      try
      {
        if ((!"000000000000000".equalsIgnoreCase(((TelephonyManager)BaseApplicationImpl.getApplication().getSystemService("phone")).getDeviceId())) || (!Build.FINGERPRINT.startsWith("generic"))) {
          break label303;
        }
        for (boolean bool = true;; bool = false)
        {
          this.g = bool;
          return;
          bool = false;
          break;
          localException = localException;
          localException.printStackTrace();
          break label249;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    this.h = bool;
  }
  
  public static apbb a()
  {
    return jdField_a_of_type_Apbb;
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
    int i;
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null)
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.a.iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (a((String)localIterator.next()).equals(this.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_Int = 5;
            this.jdField_b_of_type_Int = 1;
            i = 1;
            int j = i;
            if (i == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.c.iterator();
              do
              {
                k = i;
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!a((String)localIterator.next()).equals(this.jdField_a_of_type_JavaLangString));
              this.jdField_a_of_type_Boolean = true;
              k = 1;
              j = k;
              if (k == 0)
              {
                this.jdField_a_of_type_Boolean = false;
                j = k;
              }
            }
            k = j;
            ArDefaultSetting localArDefaultSetting;
            if (j == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.e.iterator();
              do
              {
                k = j;
                if (!localIterator.hasNext()) {
                  break;
                }
                localArDefaultSetting = (ArDefaultSetting)localIterator.next();
              } while ((localArDefaultSetting.jdField_a_of_type_Int != 0) || (!a(localArDefaultSetting.jdField_a_of_type_JavaLangString).equals(this.jdField_a_of_type_JavaLangString)));
              this.jdField_a_of_type_Int = localArDefaultSetting.jdField_c_of_type_Int;
              this.jdField_b_of_type_Int = localArDefaultSetting.jdField_b_of_type_Int;
              k = 1;
            }
            i = k;
            if (k == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.b.iterator();
              do
              {
                i = k;
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!a((String)localIterator.next()).equals(this.jdField_b_of_type_JavaLangString));
              this.jdField_a_of_type_Int = 5;
              this.jdField_b_of_type_Int = 1;
              i = 1;
            }
            k = i;
            if (i == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.d.iterator();
              do
              {
                j = i;
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!a((String)localIterator.next()).equals(this.jdField_b_of_type_JavaLangString));
              this.jdField_a_of_type_Boolean = true;
              j = 1;
              k = j;
              if (j == 0)
              {
                this.jdField_a_of_type_Boolean = false;
                k = j;
              }
            }
            if (k == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.e.iterator();
              while (localIterator.hasNext())
              {
                localArDefaultSetting = (ArDefaultSetting)localIterator.next();
                if ((localArDefaultSetting.jdField_a_of_type_Int == 1) && (a(localArDefaultSetting.jdField_a_of_type_JavaLangString).equals(this.jdField_b_of_type_JavaLangString)))
                {
                  this.jdField_a_of_type_Int = localArDefaultSetting.jdField_c_of_type_Int;
                  this.jdField_b_of_type_Int = localArDefaultSetting.jdField_b_of_type_Int;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_Int >= 1) && (this.jdField_a_of_type_Int <= 5) && (this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int <= 1))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      this.jdField_a_of_type_Int = localSharedPreferences.getInt("ar_adjust_track_quality", -1);
      if ((this.jdField_a_of_type_Int >= 1) && (this.jdField_a_of_type_Int <= 5))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_Int = localSharedPreferences.getInt("ar_adjust_render_quality", -1);
        if ((this.jdField_b_of_type_Int < 0) || (this.jdField_b_of_type_Int > 1)) {
          break label608;
        }
      }
      for (this.jdField_c_of_type_Boolean = false;; this.jdField_c_of_type_Boolean = true)
      {
        this.jdField_d_of_type_Boolean = true;
        return;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 5;
        break;
        label608:
        this.jdField_b_of_type_Int = 1;
      }
      i = k;
      continue;
      i = 0;
      break;
      i = 0;
    }
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
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    do
    {
      return;
      this.jdField_b_of_type_JavaLangString = a(paramString);
      SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
      localEditor.putString("gpu_renderer", paramString);
      bhhr.a(localEditor);
      a(paramString);
    } while (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null);
    a();
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    for (;;)
    {
      int j;
      try
      {
        if (this.jdField_d_of_type_Int >= 5)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARDeviceController", 2, "isAREnable enable= false,failCode= 870888");
          }
          a(false, 870888);
          return bool2;
        }
        if (!this.f) {
          break label338;
        }
        this.f = false;
        this.jdField_d_of_type_Int += 1;
        Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        localEditor.putInt("ar_load_so_crash_time", this.jdField_d_of_type_Int);
        localEditor.putString("ar_load_so_crash_version", AppSetting.f());
        localEditor.putInt("ar_native_so_crash_version", ((SharedPreferences)localObject1).getInt("ar_native_so_version", 0));
        bhhr.a(localEditor);
        j = 1;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 870882;
          a(bool1, i);
          if (QLog.isColorLevel()) {
            QLog.d("ARDeviceController", 2, "isAREnable enable= " + bool1 + ",failCode= " + i);
          }
          bool2 = bool1;
          if (j == 0) {
            continue;
          }
          localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
          ((SharedPreferences.Editor)localObject1).putInt("ar_load_so_crash_time", 0);
          bhhr.a((SharedPreferences.Editor)localObject1);
          this.jdField_d_of_type_Int = 0;
          bool2 = bool1;
          continue;
        }
        if (Build.VERSION.SDK_INT >= 14) {
          break label272;
        }
      }
      finally {}
      int i = 870881;
      continue;
      label272:
      if (!this.h)
      {
        i = 870883;
      }
      else if (this.g)
      {
        i = 870887;
      }
      else if (llq.f() < 3)
      {
        i = 870884;
      }
      else
      {
        bool2 = ayym.a();
        if (!bool2)
        {
          i = 870886;
        }
        else
        {
          bool1 = true;
          i = 0;
          continue;
          label338:
          j = 0;
        }
      }
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    int i;
    if (this.jdField_d_of_type_Int >= 5) {
      i = 870888;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARDeviceController", 2, "isSupportAr enable= " + bool + ",errorCode= " + i);
      }
      return bool;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 870882;
      }
      else if (Build.VERSION.SDK_INT < 14)
      {
        i = 870881;
      }
      else if (!this.h)
      {
        i = 870883;
      }
      else if (this.g)
      {
        i = 870887;
      }
      else if (llq.f() < 3)
      {
        i = 870884;
      }
      else if (!ayym.a())
      {
        i = 870886;
      }
      else
      {
        i = 0;
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbb
 * JD-Core Version:    0.7.0.1
 */