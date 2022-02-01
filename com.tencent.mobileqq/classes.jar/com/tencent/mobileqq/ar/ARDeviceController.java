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
  private static ARDeviceController i = new ARDeviceController();
  private ArEffectConfig a;
  private String b = b(Build.MODEL);
  private String c;
  private int d = 5;
  private int e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private boolean n;
  private boolean o;
  
  private ARDeviceController()
  {
    boolean bool = true;
    this.e = 1;
    this.f = false;
    this.g = true;
    this.h = true;
    this.j = false;
    this.k = true;
    this.m = 0;
    this.n = true;
    this.o = false;
    Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4);
    this.c = ((SharedPreferences)localObject1).getString("gpu_renderer", null);
    if (!TextUtils.isEmpty(this.c)) {
      this.c = b(this.c);
    }
    this.l = ((SharedPreferences)localObject1).getInt("ar_incompatible_reason", 0);
    this.m = ((SharedPreferences)localObject1).getInt("ar_load_so_crash_time", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("ar_load_so_crash_version", "");
    if (!AppSetting.h().equals(localObject2))
    {
      localObject2 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject2).putInt("ar_load_so_crash_time", 0);
      SharedPreUtils.a((SharedPreferences.Editor)localObject2);
      this.m = 0;
    }
    int i1 = ((SharedPreferences)localObject1).getInt("ar_native_so_crash_version", 0);
    if (((SharedPreferences)localObject1).getInt("ar_native_so_version", 0) != i1)
    {
      ((SharedPreferences)localObject1).edit().putInt("ar_load_so_crash_time", 0).commit();
      this.m = 0;
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
          this.o = bool;
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
    return i;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if ((this.k) || (this.l != paramInt))
    {
      this.k = false;
      ThreadManager.post(new ARDeviceController.1(this, paramInt, paramBoolean), 5, null, true);
    }
    this.l = paramInt;
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < paramString.length())
    {
      char c1 = paramString.charAt(i1);
      if (((c1 >= '0') && (c1 <= '9')) || ((c1 >= 'a') && (c1 <= 'z'))) {
        localStringBuilder.append(c1);
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
    Object localObject = this.a;
    if (localObject != null)
    {
      this.d = -1;
      this.e = -1;
      localObject = ((ArEffectConfig)localObject).b.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (b((String)((Iterator)localObject).next()).equals(this.b))
        {
          this.d = 5;
          this.e = 1;
          i1 = 1;
          break label92;
        }
      }
      i1 = 0;
      label92:
      int i2 = i1;
      if (i1 == 0)
      {
        localObject = this.a.d.iterator();
        do
        {
          i3 = i1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!b((String)((Iterator)localObject).next()).equals(this.b));
        this.f = true;
        i3 = 1;
        i2 = i3;
        if (i3 == 0)
        {
          this.f = false;
          i2 = i3;
        }
      }
      int i3 = i2;
      ArDefaultSetting localArDefaultSetting;
      if (i2 == 0)
      {
        localObject = this.a.m.iterator();
        do
        {
          i3 = i2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArDefaultSetting = (ArDefaultSetting)((Iterator)localObject).next();
        } while ((localArDefaultSetting.b != 0) || (!b(localArDefaultSetting.a).equals(this.b)));
        this.d = localArDefaultSetting.d;
        this.e = localArDefaultSetting.c;
        i3 = 1;
      }
      i1 = i3;
      if (i3 == 0)
      {
        localObject = this.a.c.iterator();
        do
        {
          i1 = i3;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!b((String)((Iterator)localObject).next()).equals(this.c));
        this.d = 5;
        this.e = 1;
        i1 = 1;
      }
      i2 = i1;
      if (i1 == 0)
      {
        localObject = this.a.e.iterator();
        do
        {
          i3 = i1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!b((String)((Iterator)localObject).next()).equals(this.c));
        this.f = true;
        i3 = 1;
        i2 = i3;
        if (i3 == 0)
        {
          this.f = false;
          i2 = i3;
        }
      }
      i1 = i2;
      if (i2 == 0)
      {
        localObject = this.a.m.iterator();
        do
        {
          i1 = i2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArDefaultSetting = (ArDefaultSetting)((Iterator)localObject).next();
        } while ((localArDefaultSetting.b != 1) || (!b(localArDefaultSetting.a).equals(this.c)));
        this.d = localArDefaultSetting.d;
        this.e = localArDefaultSetting.c;
        i1 = 1;
      }
    }
    else
    {
      i1 = 0;
    }
    if (i1 != 0)
    {
      i1 = this.d;
      if ((i1 >= 1) && (i1 <= 5))
      {
        i1 = this.e;
        if ((i1 >= 0) && (i1 <= 1))
        {
          this.g = false;
          this.h = false;
          this.j = true;
          return;
        }
      }
    }
    this.d = localSharedPreferences.getInt("ar_adjust_track_quality", -1);
    int i1 = this.d;
    if ((i1 >= 1) && (i1 <= 5))
    {
      this.g = false;
    }
    else
    {
      this.g = true;
      this.d = 5;
    }
    this.e = localSharedPreferences.getInt("ar_adjust_render_quality", -1);
    i1 = this.e;
    if ((i1 >= 0) && (i1 <= 1))
    {
      this.h = false;
    }
    else
    {
      this.e = 1;
      this.h = true;
    }
    this.j = true;
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    this.a = paramArEffectConfig;
    if (!TextUtils.isEmpty(this.c)) {
      d();
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(this.c)) {
      return;
    }
    this.c = b(paramString);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
    localEditor.putString("gpu_renderer", paramString);
    SharedPreUtils.a(localEditor);
    a(paramString);
    if (this.a != null) {
      d();
    }
  }
  
  public boolean b()
  {
    for (;;)
    {
      try
      {
        if (this.m >= 5)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARDeviceController", 2, "isAREnable enable= false,failCode= 870888");
          }
          a(false, 870888);
          return false;
        }
        boolean bool2 = this.n;
        boolean bool1 = true;
        if (bool2)
        {
          this.n = false;
          this.m += 1;
          Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
          SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
          localEditor.putInt("ar_load_so_crash_time", this.m);
          localEditor.putString("ar_load_so_crash_version", AppSetting.h());
          localEditor.putInt("ar_native_so_crash_version", ((SharedPreferences)localObject1).getInt("ar_native_so_version", 0));
          SharedPreUtils.a(localEditor);
          i2 = 1;
          if (this.f)
          {
            bool1 = false;
            i1 = 870882;
          }
          else if (Build.VERSION.SDK_INT < 14)
          {
            bool1 = false;
            i1 = 870881;
          }
          else if (!this.o)
          {
            bool1 = false;
            i1 = 870883;
          }
          else if (VcSystemInfo.getCpuArchitecture() < 3)
          {
            bool1 = false;
            i1 = 870884;
          }
          else
          {
            if (OlympicUtil.a()) {
              break label345;
            }
            bool1 = false;
            i1 = 870886;
          }
          a(bool1, i1);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("isAREnable enable= ");
            ((StringBuilder)localObject1).append(bool1);
            ((StringBuilder)localObject1).append(",failCode= ");
            ((StringBuilder)localObject1).append(i1);
            QLog.d("ARDeviceController", 2, ((StringBuilder)localObject1).toString());
          }
          if (i2 != 0)
          {
            localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
            ((SharedPreferences.Editor)localObject1).putInt("ar_load_so_crash_time", 0);
            SharedPreUtils.a((SharedPreferences.Editor)localObject1);
            this.m = 0;
          }
          return bool1;
        }
      }
      finally {}
      int i2 = 0;
      continue;
      label345:
      int i1 = 0;
    }
  }
  
  public boolean c()
  {
    int i1 = this.m;
    boolean bool = false;
    if (i1 >= 5)
    {
      i1 = 870888;
    }
    else if (this.f)
    {
      i1 = 870882;
    }
    else if (Build.VERSION.SDK_INT < 14)
    {
      i1 = 870881;
    }
    else if (!this.o)
    {
      i1 = 870883;
    }
    else if (VcSystemInfo.getCpuArchitecture() < 3)
    {
      i1 = 870884;
    }
    else if (!OlympicUtil.a())
    {
      i1 = 870886;
    }
    else
    {
      i1 = 0;
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportAr enable= ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",errorCode= ");
      localStringBuilder.append(i1);
      QLog.d("ARDeviceController", 2, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARDeviceController
 * JD-Core Version:    0.7.0.1
 */