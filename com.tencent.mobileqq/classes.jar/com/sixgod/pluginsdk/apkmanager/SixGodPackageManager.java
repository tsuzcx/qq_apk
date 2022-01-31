package com.sixgod.pluginsdk.apkmanager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.e;
import com.sixgod.pluginsdk.exception.SixGodException;
import com.sixgod.pluginsdk.log.SGLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SixGodPackageManager
  extends PackageManager
{
  Map compoentEnabledSettingMap = new HashMap();
  private PackageManager mBase;
  Context mHostContext;
  String mPackage;
  
  public SixGodPackageManager(PackageManager paramPackageManager, String paramString, Context paramContext)
  {
    this.mBase = paramPackageManager;
    this.mPackage = paramString;
    this.mHostContext = paramContext;
  }
  
  public void addPackageToPreferred(String paramString)
  {
    this.mBase.addPackageToPreferred(paramString);
  }
  
  public boolean addPermission(PermissionInfo paramPermissionInfo)
  {
    return this.mBase.addPermission(paramPermissionInfo);
  }
  
  public boolean addPermissionAsync(PermissionInfo paramPermissionInfo)
  {
    return this.mBase.addPermissionAsync(paramPermissionInfo);
  }
  
  public void addPreferredActivity(IntentFilter paramIntentFilter, int paramInt, ComponentName[] paramArrayOfComponentName, ComponentName paramComponentName)
  {
    this.mBase.addPreferredActivity(paramIntentFilter, paramInt, paramArrayOfComponentName, paramComponentName);
  }
  
  public String[] canonicalToCurrentPackageNames(String[] paramArrayOfString)
  {
    return this.mBase.canonicalToCurrentPackageNames(paramArrayOfString);
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    return this.mBase.checkPermission(paramString1, paramString2);
  }
  
  public int checkSignatures(int paramInt1, int paramInt2)
  {
    return this.mBase.checkSignatures(paramInt1, paramInt2);
  }
  
  public int checkSignatures(String paramString1, String paramString2)
  {
    return this.mBase.checkSignatures(paramString1, paramString2);
  }
  
  public void clearPackagePreferredActivities(String paramString)
  {
    this.mBase.clearPackagePreferredActivities(paramString);
  }
  
  public String[] currentToCanonicalPackageNames(String[] paramArrayOfString)
  {
    return this.mBase.currentToCanonicalPackageNames(paramArrayOfString);
  }
  
  public void extendVerificationTimeout(int paramInt1, int paramInt2, long paramLong)
  {
    this.mBase.extendVerificationTimeout(paramInt1, paramInt2, paramLong);
  }
  
  public Drawable getActivityBanner(ComponentName paramComponentName)
  {
    return this.mBase.getActivityBanner(paramComponentName);
  }
  
  public Drawable getActivityBanner(Intent paramIntent)
  {
    return this.mBase.getActivityBanner(paramIntent);
  }
  
  public Drawable getActivityIcon(ComponentName paramComponentName)
  {
    try
    {
      Drawable localDrawable = this.mBase.getActivityIcon(paramComponentName);
      return localDrawable;
    }
    catch (Exception localException) {}
    return getActivityInfo(paramComponentName, 0).loadIcon(this);
  }
  
  public Drawable getActivityIcon(Intent paramIntent)
  {
    return this.mBase.getActivityIcon(paramIntent);
  }
  
  public ActivityInfo getActivityInfo(ComponentName paramComponentName, int paramInt)
  {
    try
    {
      ActivityInfo localActivityInfo = this.mBase.getActivityInfo(paramComponentName, paramInt);
      return localActivityInfo;
    }
    catch (Exception localException) {}
    return (ActivityInfo)SixGodHelper.getPluginLoader(paramComponentName.getPackageName()).c().c.get(paramComponentName);
  }
  
  public Drawable getActivityLogo(ComponentName paramComponentName)
  {
    try
    {
      Drawable localDrawable = this.mBase.getActivityLogo(paramComponentName);
      return localDrawable;
    }
    catch (Exception localException) {}
    return getApplicationLogo(getApplicationInfo(paramComponentName.getPackageName(), 0));
  }
  
  public Drawable getActivityLogo(Intent paramIntent)
  {
    return this.mBase.getActivityLogo(paramIntent);
  }
  
  public List getAllPermissionGroups(int paramInt)
  {
    return this.mBase.getAllPermissionGroups(paramInt);
  }
  
  public Drawable getApplicationBanner(ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getApplicationBanner(paramApplicationInfo);
  }
  
  public Drawable getApplicationBanner(String paramString)
  {
    return this.mBase.getApplicationBanner(paramString);
  }
  
  public int getApplicationEnabledSetting(String paramString)
  {
    try
    {
      int i = this.mBase.getApplicationEnabledSetting(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      throw new SixGodException("getApplicationEnabledSetting, not support!");
    }
  }
  
  public Drawable getApplicationIcon(ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getApplicationIcon(paramApplicationInfo);
  }
  
  public Drawable getApplicationIcon(String paramString)
  {
    try
    {
      Drawable localDrawable = this.mBase.getApplicationIcon(paramString);
      return localDrawable;
    }
    catch (Exception localException) {}
    return getApplicationInfo(paramString, 0).loadLogo(this);
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
  {
    a locala = SixGodHelper.getPluginLoader(paramString).c();
    ApplicationInfo localApplicationInfo2 = ((c)locala.e.get(paramString)).c;
    ApplicationInfo localApplicationInfo1 = localApplicationInfo2;
    if (localApplicationInfo2 == null) {}
    try
    {
      localApplicationInfo1 = this.mBase.getApplicationInfo(paramString, paramInt);
      paramString = ((c)locala.e.get(paramString)).c;
      localApplicationInfo1.publicSourceDir = paramString.sourceDir;
      localApplicationInfo1.sourceDir = paramString.sourceDir;
      return localApplicationInfo1;
    }
    catch (Exception paramString)
    {
      throw new SixGodException("get ApplicationInfo failed!", paramString);
    }
  }
  
  public CharSequence getApplicationLabel(ApplicationInfo paramApplicationInfo)
  {
    SGLog.a("getApplicationLabel info = " + paramApplicationInfo.sourceDir + "label = " + this.mBase.getApplicationLabel(paramApplicationInfo));
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = 0;
    while (i < arrayOfStackTraceElement.length)
    {
      if ((arrayOfStackTraceElement[i] != null) && (arrayOfStackTraceElement[i].getClassName().contains("com.tencent.connect.share.QQShare"))) {
        return this.mHostContext.getPackageManager().getApplicationLabel(this.mHostContext.getApplicationInfo());
      }
      i += 1;
    }
    return this.mBase.getApplicationLabel(paramApplicationInfo);
  }
  
  public Drawable getApplicationLogo(ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getApplicationLogo(paramApplicationInfo);
  }
  
  public Drawable getApplicationLogo(String paramString)
  {
    return this.mBase.getApplicationLogo(paramString);
  }
  
  public int getComponentEnabledSetting(ComponentName paramComponentName)
  {
    try
    {
      int i = this.mBase.getComponentEnabledSetting(paramComponentName);
      return i;
    }
    catch (Exception localException)
    {
      if (this.compoentEnabledSettingMap.containsKey(paramComponentName)) {
        return ((Integer)this.compoentEnabledSettingMap.get(paramComponentName)).intValue();
      }
    }
    return 0;
  }
  
  public Drawable getDefaultActivityIcon()
  {
    return this.mBase.getDefaultActivityIcon();
  }
  
  public Drawable getDrawable(String paramString, int paramInt, ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getDrawable(paramString, paramInt, paramApplicationInfo);
  }
  
  public List getInstalledApplications(int paramInt)
  {
    return this.mBase.getInstalledApplications(paramInt);
  }
  
  public List getInstalledPackages(int paramInt)
  {
    return this.mBase.getInstalledPackages(paramInt);
  }
  
  public String getInstallerPackageName(String paramString)
  {
    return this.mBase.getInstallerPackageName(paramString);
  }
  
  public InstrumentationInfo getInstrumentationInfo(ComponentName paramComponentName, int paramInt)
  {
    return this.mBase.getInstrumentationInfo(paramComponentName, paramInt);
  }
  
  public Intent getLaunchIntentForPackage(String paramString)
  {
    return this.mBase.getLaunchIntentForPackage(paramString);
  }
  
  public Intent getLeanbackLaunchIntentForPackage(String paramString)
  {
    return this.mBase.getLeanbackLaunchIntentForPackage(paramString);
  }
  
  public String getNameForUid(int paramInt)
  {
    return this.mBase.getNameForUid(paramInt);
  }
  
  public int[] getPackageGids(String paramString)
  {
    return this.mBase.getPackageGids(paramString);
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
  {
    Object localObject = null;
    e locale = SixGodHelper.getPluginLoader(paramString);
    if (locale != null) {
      localObject = (c)locale.c().e.get(paramString);
    }
    if (localObject != null) {
      if (((c)localObject).j != null) {
        localObject = ((c)localObject).j;
      }
    }
    while (localObject == null)
    {
      throw new PackageManager.NameNotFoundException("packageInfo not found! packageName = " + paramString + " flag  = " + paramInt);
      localObject = this.mBase.getPackageArchiveInfo(((c)localObject).i, paramInt);
      continue;
      localObject = this.mBase.getPackageInfo(paramString, paramInt);
    }
    return localObject;
  }
  
  public PackageInstaller getPackageInstaller()
  {
    return this.mBase.getPackageInstaller();
  }
  
  public String[] getPackagesForUid(int paramInt)
  {
    return this.mBase.getPackagesForUid(paramInt);
  }
  
  public List getPackagesHoldingPermissions(String[] paramArrayOfString, int paramInt)
  {
    return null;
  }
  
  public PermissionGroupInfo getPermissionGroupInfo(String paramString, int paramInt)
  {
    return this.mBase.getPermissionGroupInfo(paramString, paramInt);
  }
  
  public PermissionInfo getPermissionInfo(String paramString, int paramInt)
  {
    return this.mBase.getPermissionInfo(paramString, paramInt);
  }
  
  public int getPreferredActivities(List paramList1, List paramList2, String paramString)
  {
    return this.mBase.getPreferredActivities(paramList1, paramList2, paramString);
  }
  
  public List getPreferredPackages(int paramInt)
  {
    return this.mBase.getPreferredPackages(paramInt);
  }
  
  public ProviderInfo getProviderInfo(ComponentName paramComponentName, int paramInt)
  {
    return this.mBase.getProviderInfo(paramComponentName, paramInt);
  }
  
  public ActivityInfo getReceiverInfo(ComponentName paramComponentName, int paramInt)
  {
    return this.mBase.getReceiverInfo(paramComponentName, paramInt);
  }
  
  public Resources getResourcesForActivity(ComponentName paramComponentName)
  {
    return this.mBase.getResourcesForActivity(paramComponentName);
  }
  
  public Resources getResourcesForApplication(ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getResourcesForApplication(paramApplicationInfo);
  }
  
  public Resources getResourcesForApplication(String paramString)
  {
    return this.mBase.getResourcesForApplication(paramString);
  }
  
  public ServiceInfo getServiceInfo(ComponentName paramComponentName, int paramInt)
  {
    return this.mBase.getServiceInfo(paramComponentName, paramInt);
  }
  
  public FeatureInfo[] getSystemAvailableFeatures()
  {
    return this.mBase.getSystemAvailableFeatures();
  }
  
  public String[] getSystemSharedLibraryNames()
  {
    return this.mBase.getSystemSharedLibraryNames();
  }
  
  public CharSequence getText(String paramString, int paramInt, ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getText(paramString, paramInt, paramApplicationInfo);
  }
  
  public Drawable getUserBadgeForDensity(UserHandle paramUserHandle, int paramInt)
  {
    return null;
  }
  
  public Drawable getUserBadgedDrawableForDensity(Drawable paramDrawable, UserHandle paramUserHandle, Rect paramRect, int paramInt)
  {
    return this.mBase.getUserBadgedDrawableForDensity(paramDrawable, paramUserHandle, paramRect, paramInt);
  }
  
  public Drawable getUserBadgedIcon(Drawable paramDrawable, UserHandle paramUserHandle)
  {
    return this.mBase.getUserBadgedIcon(paramDrawable, paramUserHandle);
  }
  
  public CharSequence getUserBadgedLabel(CharSequence paramCharSequence, UserHandle paramUserHandle)
  {
    return this.mBase.getUserBadgedLabel(paramCharSequence, paramUserHandle);
  }
  
  public XmlResourceParser getXml(String paramString, int paramInt, ApplicationInfo paramApplicationInfo)
  {
    return this.mBase.getXml(paramString, paramInt, paramApplicationInfo);
  }
  
  public boolean hasSystemFeature(String paramString)
  {
    return this.mBase.hasSystemFeature(paramString);
  }
  
  public boolean isPermissionRevokedByPolicy(String paramString1, String paramString2)
  {
    return this.mBase.isPermissionRevokedByPolicy(paramString1, paramString2);
  }
  
  public boolean isSafeMode()
  {
    return this.mBase.isSafeMode();
  }
  
  public List queryBroadcastReceivers(Intent paramIntent, int paramInt)
  {
    return this.mBase.queryBroadcastReceivers(paramIntent, paramInt);
  }
  
  public List queryContentProviders(String paramString, int paramInt1, int paramInt2)
  {
    return this.mBase.queryContentProviders(paramString, paramInt1, paramInt2);
  }
  
  public List queryInstrumentation(String paramString, int paramInt)
  {
    return this.mBase.queryInstrumentation(paramString, paramInt);
  }
  
  public List queryIntentActivities(Intent paramIntent, int paramInt)
  {
    Object localObject1 = this.mBase.queryIntentActivities(paramIntent, paramInt);
    if (localObject1 == null) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      Object localObject2 = SixGodHelper.getPluginLoader(this.mPackage);
      Set localSet;
      label88:
      ComponentName localComponentName;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((e)localObject2).c();
        localSet = paramIntent.getCategories();
        if (localSet == null)
        {
          paramInt = 0;
          paramIntent = paramIntent.getAction();
          HashMap localHashMap = ((a)localObject2).f;
          if (localHashMap == null) {
            break label319;
          }
          Iterator localIterator = localHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            localComponentName = (ComponentName)localIterator.next();
            localObject3 = (List)localHashMap.get(localComponentName);
            if (localObject3 != null) {
              localObject3 = ((List)localObject3).iterator();
            }
          }
        }
      }
      label136:
      label319:
      label325:
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (IntentFilter)((Iterator)localObject3).next();
          localObject5 = ((IntentFilter)localObject4).actionsIterator();
          do
          {
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
          } while (!((String)((Iterator)localObject5).next()).equals(paramIntent));
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label325;
          }
          localObject4 = ((IntentFilter)localObject4).categoriesIterator();
          if ((localObject4 == null) && (paramInt != 0)) {
            break label136;
          }
          if (localSet != null)
          {
            localObject5 = new ArrayList();
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                ((List)localObject5).add(((Iterator)localObject4).next());
                continue;
                paramInt = localSet.size();
                break;
              }
            }
            if (!((List)localObject5).containsAll(localSet)) {
              break label136;
            }
          }
          localObject4 = new ResolveInfo();
          ((ResolveInfo)localObject4).activityInfo = ((ActivityInfo)((a)localObject2).c.get(localComponentName));
          ((List)localObject1).add(localObject4);
          break label136;
          break label88;
          return localObject1;
        }
      }
    }
  }
  
  public List queryIntentActivityOptions(ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt)
  {
    return this.mBase.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
  }
  
  public List queryIntentContentProviders(Intent paramIntent, int paramInt)
  {
    return this.mBase.queryIntentContentProviders(paramIntent, paramInt);
  }
  
  public List queryIntentServices(Intent paramIntent, int paramInt)
  {
    return this.mBase.queryIntentActivities(paramIntent, paramInt);
  }
  
  public List queryPermissionsByGroup(String paramString, int paramInt)
  {
    return this.mBase.queryPermissionsByGroup(paramString, paramInt);
  }
  
  public void removePackageFromPreferred(String paramString)
  {
    this.mBase.removePackageFromPreferred(paramString);
  }
  
  public void removePermission(String paramString)
  {
    this.mBase.removePermission(paramString);
  }
  
  public ResolveInfo resolveActivity(Intent paramIntent, int paramInt)
  {
    return this.mBase.resolveActivity(paramIntent, paramInt);
  }
  
  public ProviderInfo resolveContentProvider(String paramString, int paramInt)
  {
    return this.mBase.resolveContentProvider(paramString, paramInt);
  }
  
  public ResolveInfo resolveService(Intent paramIntent, int paramInt)
  {
    return this.mBase.resolveService(paramIntent, paramInt);
  }
  
  public void setApplicationEnabledSetting(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      this.mBase.setApplicationEnabledSetting(paramString, paramInt1, paramInt2);
      return;
    }
    catch (Exception paramString)
    {
      throw new SixGodException("setApplicationEnabledSetting, not support!");
    }
  }
  
  public void setComponentEnabledSetting(ComponentName paramComponentName, int paramInt1, int paramInt2)
  {
    try
    {
      this.mBase.setComponentEnabledSetting(paramComponentName, paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      this.compoentEnabledSettingMap.put(paramComponentName, Integer.valueOf(paramInt1));
    }
  }
  
  public void setInstallerPackageName(String paramString1, String paramString2)
  {
    this.mBase.setInstallerPackageName(paramString1, paramString2);
  }
  
  public void verifyPendingInstall(int paramInt1, int paramInt2)
  {
    this.mBase.verifyPendingInstall(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.apkmanager.SixGodPackageManager
 * JD-Core Version:    0.7.0.1
 */