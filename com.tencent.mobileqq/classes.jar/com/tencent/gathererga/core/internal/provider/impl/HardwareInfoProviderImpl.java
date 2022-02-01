package com.tencent.gathererga.core.internal.provider.impl;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.provider.ProviderResultImpl;
import com.tencent.gathererga.core.internal.util.GLog;
import com.tencent.gathererga.core.internal.util.PermissionUtil;
import java.io.File;
import java.lang.reflect.Method;

public class HardwareInfoProviderImpl
  implements HardwareInfoProvider
{
  private Context a = null;
  
  private static TelephonyManager a(Context paramContext)
  {
    if (paramContext != null) {
      if (!PermissionUtil.a(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        GLog.d("getTelephonyManager checkPermission failed");
      }
      else
      {
        paramContext = paramContext.getApplicationContext();
        if (paramContext == null) {
          GLog.d("getTelephonyManager getApplicationContext null");
        }
      }
    }
    try
    {
      paramContext = paramContext.getSystemService("phone");
      if (!(paramContext instanceof TelephonyManager)) {
        break label75;
      }
      paramContext = (TelephonyManager)TelephonyManager.class.cast(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label70:
      label75:
      break label70;
    }
    GLog.d("getTelephonyManager getSystemService failed");
    return null;
  }
  
  private ProviderResult a(int paramInt)
  {
    int j = Build.VERSION.SDK_INT;
    int i = -102;
    String str = null;
    if (j >= 29)
    {
      paramInt = i;
    }
    else if (Build.VERSION.SDK_INT < 26)
    {
      paramInt = i;
    }
    else
    {
      TelephonyManager localTelephonyManager = a(this.a);
      if (localTelephonyManager == null)
      {
        paramInt = -101;
        GLog.d("getImei failed. get TELEPHONY_SERVICE null");
      }
      else
      {
        if (paramInt == -1) {
          str = localTelephonyManager.getImei();
        } else {
          str = localTelephonyManager.getImei(paramInt);
        }
        GLog.b("getImei success");
        paramInt = 0;
      }
    }
    return new ProviderResultImpl(paramInt, str);
  }
  
  private ProviderResult a(String paramString, int paramInt)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    Class localClass = localTelephonyManager.getClass();
    try
    {
      paramString = localClass.getDeclaredMethod(paramString, new Class[] { Integer.TYPE });
      paramString.setAccessible(true);
      paramString = new ProviderResultImpl(0L, (String)paramString.invoke(localTelephonyManager, new Object[] { Integer.valueOf(paramInt) }));
      return paramString;
    }
    catch (Exception paramString)
    {
      GLog.b("getIdByReflect", paramString);
    }
    return new ProviderResultImpl(-100L, null);
  }
  
  private ProviderResult b(int paramInt)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    if (Build.VERSION.SDK_INT >= 26) {
      return new ProviderResultImpl(0L, localTelephonyManager.getMeid(paramInt));
    }
    return new ProviderResultImpl(-102L, null);
  }
  
  private ProviderResult c(int paramInt)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return new ProviderResultImpl(0L, localTelephonyManager.getDeviceId(paramInt));
      }
      return a("getDeviceId", 1);
    }
    return new ProviderResultImpl(-102L, null);
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @InfoID(id=115)
  public ProviderResult getAndroidId(ProviderMethodPriority paramProviderMethodPriority)
  {
    int i;
    try
    {
      paramProviderMethodPriority = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
      i = 0;
    }
    catch (Throwable paramProviderMethodPriority)
    {
      i = -100;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AndroidID reader exception:");
      localStringBuilder.append(paramProviderMethodPriority.getMessage());
      GLog.b(localStringBuilder.toString());
      paramProviderMethodPriority = null;
    }
    return new ProviderResultImpl(i, paramProviderMethodPriority);
  }
  
  @InfoID(id=118)
  public ProviderResult getBrand(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Build.BRAND);
  }
  
  @InfoID(id=119)
  public ProviderResult getDeviceHeightAndWidth(ProviderMethodPriority paramProviderMethodPriority)
  {
    paramProviderMethodPriority = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      paramProviderMethodPriority.getRealMetrics(localDisplayMetrics);
    } else {
      paramProviderMethodPriority.getMetrics(localDisplayMetrics);
    }
    return new ProviderResultImpl(0L, new Pair(Integer.valueOf(localDisplayMetrics.heightPixels), Integer.valueOf(localDisplayMetrics.widthPixels)));
  }
  
  @InfoID(id=110, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getDeviceId(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, ((TelephonyManager)this.a.getSystemService("phone")).getDeviceId());
  }
  
  @InfoID(id=111, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getDeviceId0(ProviderMethodPriority paramProviderMethodPriority)
  {
    return c(0);
  }
  
  @InfoID(id=112, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getDeviceId1(ProviderMethodPriority paramProviderMethodPriority)
  {
    return c(1);
  }
  
  @InfoID(id=122)
  public ProviderResult getDpi(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Float.valueOf(this.a.getResources().getDisplayMetrics().density));
  }
  
  @InfoID(id=101, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getImei(ProviderMethodPriority paramProviderMethodPriority)
  {
    return a(-1);
  }
  
  @InfoID(id=102, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getImei0(ProviderMethodPriority paramProviderMethodPriority)
  {
    return a(0);
  }
  
  @InfoID(id=103, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getImei1(ProviderMethodPriority paramProviderMethodPriority)
  {
    return a(1);
  }
  
  @InfoID(id=104, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getImsi(ProviderMethodPriority paramProviderMethodPriority)
  {
    paramProviderMethodPriority = (TelephonyManager)this.a.getSystemService("phone");
    if (paramProviderMethodPriority == null)
    {
      GLog.d("getImsi TelephonyManager is null");
      return new ProviderResultImpl(-101L, null);
    }
    return new ProviderResultImpl(0L, paramProviderMethodPriority.getSubscriberId());
  }
  
  @InfoID(id=105, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getImsi0(ProviderMethodPriority paramProviderMethodPriority)
  {
    return a("getSubscriberId", 0);
  }
  
  @InfoID(id=106, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getImsi1(ProviderMethodPriority paramProviderMethodPriority)
  {
    return a("getSubscriberId", 1);
  }
  
  @InfoID(id=116)
  public ProviderResult getManufacturer(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Build.MANUFACTURER);
  }
  
  @InfoID(id=107, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getMeid(ProviderMethodPriority paramProviderMethodPriority)
  {
    paramProviderMethodPriority = (TelephonyManager)this.a.getSystemService("phone");
    if (Build.VERSION.SDK_INT >= 26) {
      return new ProviderResultImpl(0L, paramProviderMethodPriority.getMeid());
    }
    return new ProviderResultImpl(-102L, null);
  }
  
  @InfoID(id=108, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getMeid0(ProviderMethodPriority paramProviderMethodPriority)
  {
    return b(0);
  }
  
  @InfoID(id=109, permissions={"android.permission.READ_PHONE_STATE"})
  public ProviderResult getMeid1(ProviderMethodPriority paramProviderMethodPriority)
  {
    return b(1);
  }
  
  @InfoID(id=117)
  public ProviderResult getModel(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Build.MODEL);
  }
  
  @InfoID(id=121)
  public ProviderResult getRamSize(ProviderMethodPriority paramProviderMethodPriority)
  {
    paramProviderMethodPriority = this.a;
    int i;
    if (paramProviderMethodPriority != null)
    {
      paramProviderMethodPriority = (ActivityManager)paramProviderMethodPriority.getSystemService("activity");
      if (paramProviderMethodPriority != null)
      {
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        paramProviderMethodPriority.getMemoryInfo(localMemoryInfo);
        return new ProviderResultImpl(0, Long.valueOf(localMemoryInfo.totalMem));
      }
      i = -104;
    }
    else
    {
      i = -103;
    }
    return new ProviderResultImpl(i, Integer.valueOf(-1));
  }
  
  @InfoID(id=120)
  public ProviderResult getRomSize(ProviderMethodPriority paramProviderMethodPriority)
  {
    paramProviderMethodPriority = new StatFs(Environment.getDataDirectory().getPath());
    if (Build.VERSION.SDK_INT >= 18) {
      return new ProviderResultImpl(0L, Long.valueOf(paramProviderMethodPriority.getBlockSizeLong() * paramProviderMethodPriority.getBlockCountLong()));
    }
    return new ProviderResultImpl(0L, Long.valueOf(paramProviderMethodPriority.getBlockSize() * paramProviderMethodPriority.getBlockCount()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.impl.HardwareInfoProviderImpl
 * JD-Core Version:    0.7.0.1
 */