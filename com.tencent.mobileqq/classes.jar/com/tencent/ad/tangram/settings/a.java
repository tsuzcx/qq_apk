package com.tencent.ad.tangram.settings;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.file.AdFile;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.io.File;
import java.lang.ref.WeakReference;

public final class a
  implements AdSettingsManager.a
{
  private static final String DIRECTORY_NAME = "settings";
  private static final String FILENAME_NAME = "settings";
  private static final String TAG = "AdSettingsManagerAdapterForQQ";
  private static final String URL = "https://i.gtimg.cn/ams-web/public/tangram-report/settings-android-qq-8-8-17.json";
  private static final String URL_NEW = "https://public.gdtimg.com/ams-web/public/tangram-report/settings-android-qq-8-8-17.json";
  private volatile WeakReference<Context> appContext;
  private volatile gdt_settings.Settings currentSettings;
  private volatile Object currentSettingsLock = new Object();
  private volatile a.a ipcHandler;
  private volatile long lastUpdateTimeMillis = -2147483648L;
  private volatile WeakReference<AdSettingsManager.Listener> listener;
  
  public a(WeakReference<Context> paramWeakReference)
  {
    if (paramWeakReference == null) {
      return;
    }
    if (paramWeakReference.get() == null) {
      return;
    }
    if (((Context)paramWeakReference.get()).getApplicationContext() == null) {
      return;
    }
    this.appContext = new WeakReference(((Context)paramWeakReference.get()).getApplicationContext());
    this.ipcHandler = new a.a(this.appContext);
  }
  
  private boolean canUpdate()
  {
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    boolean bool = false;
    if (localBoolean == null)
    {
      AdLog.e("AdSettingsManagerAdapterForQQ", "canUpdate isOnMainProcess == null");
      return false;
    }
    long l;
    if (localBoolean.booleanValue())
    {
      if (this.currentSettings != null) {
        l = this.currentSettings.intervalMillis;
      } else {
        l = 1800000L;
      }
    }
    else {
      l = 60000L;
    }
    if ((this.lastUpdateTimeMillis == -2147483648L) || (System.currentTimeMillis() - this.lastUpdateTimeMillis >= l)) {
      bool = true;
    }
    return bool;
  }
  
  private Context getContext()
  {
    if (this.appContext != null) {
      return (Context)this.appContext.get();
    }
    return null;
  }
  
  private static AdFile getFile(Context paramContext, boolean paramBoolean)
  {
    return new AdFile(new File(com.tencent.ad.tangram.util.b.getParentDirectory(paramContext), "settings").getAbsolutePath(), "settings", "UTF-8", paramBoolean);
  }
  
  private static gdt_settings.Settings load(Context paramContext)
  {
    AdFile localAdFile = getFile(paramContext, false);
    if ((localAdFile != null) && (localAdFile.open()))
    {
      paramContext = b.toObject(localAdFile.readFully());
      localAdFile.close();
    }
    else
    {
      paramContext = null;
    }
    AdLog.i("AdSettingsManagerAdapterForQQ", String.format("load %s", new Object[] { b.toString(paramContext) }));
    return paramContext;
  }
  
  private void notifyUpdated()
  {
    AdLog.i("AdSettingsManagerAdapterForQQ", String.format("notifyUpdated %s", new Object[] { b.toString(this.currentSettings) }));
    AdThreadManager.INSTANCE.post(new a.3(this), 0);
  }
  
  private static boolean save(Context paramContext, gdt_settings.Settings paramSettings)
  {
    if (paramSettings != null)
    {
      String str = b.toString(paramSettings);
      if (!TextUtils.isEmpty(str))
      {
        paramContext = getFile(paramContext, true);
        if ((paramContext != null) && (paramContext.open()))
        {
          paramContext.writeFully(str);
          paramContext.close();
          bool = true;
          break label59;
        }
      }
    }
    boolean bool = false;
    label59:
    AdLog.i("AdSettingsManagerAdapterForQQ", String.format("save:%b %s", new Object[] { Boolean.valueOf(bool), b.toString(paramSettings) }));
    return bool;
  }
  
  private void update()
  {
    if (!canUpdate()) {
      return;
    }
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    if (localBoolean == null)
    {
      AdLog.e("AdSettingsManagerAdapterForQQ", "update isOnMainProcess == null");
      return;
    }
    this.lastUpdateTimeMillis = System.currentTimeMillis();
    if (localBoolean.booleanValue())
    {
      AdThreadManager.INSTANCE.post(new a.1(this), 4);
      return;
    }
    AdThreadManager.INSTANCE.post(new a.2(this), 3);
  }
  
  private boolean updateCurrentSettings(gdt_settings.Settings paramSettings)
  {
    boolean bool2 = b.isValid(paramSettings);
    boolean bool1 = true;
    if ((!bool2) || ((b.isValid(this.currentSettings)) && (TextUtils.equals(this.currentSettings.urlForSettings, paramSettings.urlForSettings)) && (this.currentSettings.version >= paramSettings.version))) {
      bool1 = false;
    }
    if (bool1) {
      synchronized (this.currentSettingsLock)
      {
        this.currentSettings = paramSettings;
        notifyUpdated();
        return bool1;
      }
    }
    return bool1;
  }
  
  public gdt_settings.Settings getCache()
  {
    update();
    if (b.isValid(this.currentSettings)) {
      return this.currentSettings;
    }
    return null;
  }
  
  public gdt_settings.Settings getCacheByFile()
  {
    gdt_settings.Settings localSettings = getCache();
    if (localSettings != null) {
      return localSettings;
    }
    updateCurrentSettings(load(getContext()));
    if (b.isValid(this.currentSettings)) {
      return this.currentSettings;
    }
    return null;
  }
  
  public void setListener(WeakReference<AdSettingsManager.Listener> paramWeakReference)
  {
    this.listener = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.a
 * JD-Core Version:    0.7.0.1
 */