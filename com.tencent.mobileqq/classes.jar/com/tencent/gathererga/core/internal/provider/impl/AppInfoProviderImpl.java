package com.tencent.gathererga.core.internal.provider.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.gathererga.core.AppInfoProvider;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.provider.ProviderResultImpl;

public class AppInfoProviderImpl
  implements AppInfoProvider
{
  private Context a;
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @InfoID(id=502)
  public ProviderResult getAppVersionName(ProviderMethodPriority paramProviderMethodPriority)
  {
    try
    {
      paramProviderMethodPriority = new ProviderResultImpl(0L, this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionName);
      return paramProviderMethodPriority;
    }
    catch (Throwable paramProviderMethodPriority)
    {
      label32:
      break label32;
    }
    return new ProviderResultImpl(-500L, null);
  }
  
  @InfoID(id=501)
  public ProviderResult getPackageName(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, this.a.getPackageName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.impl.AppInfoProviderImpl
 * JD-Core Version:    0.7.0.1
 */