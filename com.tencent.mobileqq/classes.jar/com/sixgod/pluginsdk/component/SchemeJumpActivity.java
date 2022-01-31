package com.sixgod.pluginsdk.component;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.apkmanager.a;
import com.sixgod.pluginsdk.e;
import com.sixgod.pluginsdk.exception.SixGodException;
import com.sixgod.pluginsdk.log.SGLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SchemeJumpActivity
  extends Activity
{
  e a = null;
  
  public PluginLoadParams getLoadParams(String paramString)
  {
    return null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = getPackageManager().getActivityInfo(getComponentName(), 128);
      if ((paramBundle == null) || (paramBundle.metaData == null)) {
        throw new SixGodException("No meta-data");
      }
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        paramBundle = null;
      }
      Object localObject2 = paramBundle.metaData.getString("pluginPkg");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        throw new SixGodException("No pluginPkg in meta-data");
      }
      this.a = SixGodHelper.getPluginLoader((String)localObject2);
      if (this.a == null)
      {
        paramBundle = getLoadParams((String)localObject2);
        if (paramBundle == null) {
          throw new SixGodException("Plugin not Loaded,and no PluginLoaePrams returned! Try to override getLoadParams()。");
        }
        SixGodHelper.loadPlugin(getApplicationContext(), paramBundle);
        this.a = SixGodHelper.getPluginLoader((String)localObject2);
        if (this.a == null) {
          throw new SixGodException("plugin not loaded! and load failed.");
        }
      }
      paramBundle = getIntent();
      if (paramBundle == null) {
        paramBundle = null;
      }
      while (paramBundle == null)
      {
        throw new SixGodException("No ActivityInfo found to match, have you declared your Activity in AndroidManifest!");
        SixGodHelper.getPluginLoader(paramBundle.getPackage());
        paramBundle.getAction();
        paramBundle.getScheme();
        paramBundle.getCategories();
        paramBundle.getDataString();
        localObject1 = new ArrayList();
        localObject2 = SixGodHelper.getPluginLoader((String)localObject2);
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).c();
          paramBundle.getCategories();
          HashMap localHashMap = ((a)localObject2).f;
          if (localHashMap != null)
          {
            Iterator localIterator = localHashMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              ComponentName localComponentName = (ComponentName)localIterator.next();
              Object localObject3 = (List)localHashMap.get(localComponentName);
              if (localObject3 != null)
              {
                localObject3 = ((List)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  Object localObject4 = (IntentFilter)((Iterator)localObject3).next();
                  if ((((IntentFilter)localObject4).matchAction(paramBundle.getAction())) && (((IntentFilter)localObject4).matchCategories(paramBundle.getCategories()) == null))
                  {
                    String str = paramBundle.getScheme();
                    if ((str == null) || ((((IntentFilter)localObject4).hasDataScheme(str)) && (((IntentFilter)localObject4).matchDataAuthority(paramBundle.getData()) == 4194304)))
                    {
                      localObject4 = new ResolveInfo();
                      ((ResolveInfo)localObject4).activityInfo = ((a)localObject2).a(localComponentName);
                      ((List)localObject1).add(localObject4);
                    }
                  }
                }
              }
            }
          }
        }
        if (((List)localObject1).size() != 1) {
          paramBundle = null;
        } else {
          paramBundle = ((ResolveInfo)((List)localObject1).get(0)).activityInfo;
        }
      }
      Object localObject1 = new Intent(getIntent());
      ((Intent)localObject1).setComponent(new ComponentName(paramBundle.packageName, paramBundle.name));
      paramBundle = f.a(this, (Intent)localObject1);
      if (paramBundle == null)
      {
        SGLog.b("startActivity from child but intent got null");
        return;
      }
      startActivity(paramBundle);
      new Handler().postDelayed(new g(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.component.SchemeJumpActivity
 * JD-Core Version:    0.7.0.1
 */