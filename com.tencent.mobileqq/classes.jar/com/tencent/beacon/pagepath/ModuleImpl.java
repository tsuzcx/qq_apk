package com.tencent.beacon.pagepath;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.upload.UploadStrategy;
import java.util.Map;

public class ModuleImpl
  extends c
{
  private static ModuleImpl mInstance;
  private boolean enableModule = UploadStrategy.DEFAULT_PAGE_PATH_ENABLE;
  
  public ModuleImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  public static ModuleImpl getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new ModuleImpl(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void onModuleStarted()
  {
    super.onModuleStarted();
    if ((this.enableModule) && (Build.VERSION.SDK_INT >= 14)) {}
    for (boolean bool = true;; bool = false)
    {
      this.enableModule = bool;
      d.d("[module] pagePath module > %S", new Object[] { "" + this.enableModule });
      if (this.enableModule) {
        ((Application)this.mContext).registerActivityLifecycleCallbacks(new b());
      }
      return;
    }
  }
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap)
  {
    super.onModuleStrategyUpdated(paramInt, paramMap);
    if (paramInt == 1)
    {
      this.enableModule = com.tencent.beacon.core.e.b.a((String)paramMap.get("isPagePath"), this.enableModule);
      d.a("[module] get isPagePath: " + this.enableModule, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.pagepath.ModuleImpl
 * JD-Core Version:    0.7.0.1
 */