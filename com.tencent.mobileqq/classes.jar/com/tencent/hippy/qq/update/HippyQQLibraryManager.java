package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import bdgh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soload.LoadExtResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class HippyQQLibraryManager
{
  private static HippyQQLibraryManager INSTANCE;
  public static final int STATE_LOADED = 2;
  public static final int STATE_LOADING = 1;
  public static final int STATE_UNLOAD = 0;
  private static long mLastUpdateTime;
  private final String[] SO_LIST = { "libmtt_shared.so", "libmttv8.so", "libhippybridge.so", "libflexbox.so" };
  private final String[] SO_NAME = { "mtt_shared", "mttv8", "hippybridge", "flexbox" };
  private String mCDNPath;
  private String mCommonPackagePath;
  private List<HippyQQLibraryManager.LibraryLoadListener> mLibraryLoadListeners = new ArrayList();
  private HashMap<String, String> mLibraryVerions = new HashMap();
  private int mLoadState = 0;
  private String mOfflinePath;
  
  private void addLibraryLoadListener(HippyQQLibraryManager.LibraryLoadListener paramLibraryLoadListener)
  {
    if ((paramLibraryLoadListener != null) && (!this.mLibraryLoadListeners.contains(paramLibraryLoadListener))) {
      this.mLibraryLoadListeners.add(paramLibraryLoadListener);
    }
  }
  
  private boolean checkAndLoadLibrary()
  {
    String str = getOfflineLibraryPath();
    if ((isLibraryExists(str)) && (loadLibrary(str))) {}
    do
    {
      return true;
      if (UpdateSetting.getInstance().getCDNUpdateFlag()) {
        return false;
      }
      str = getCDNLibraryPath();
    } while ((isLibraryExists(str)) && (loadLibrary(str)));
    return false;
  }
  
  private void checkOfflineUpdate()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      l2 = l1 - mLastUpdateTime;
    } while ((mLastUpdateTime > 0L) && (l2 > 0L) && (l2 < 3600000L));
    mLastUpdateTime = l1;
    ThreadManager.post(new HippyQQLibraryManager.3(this, localQQAppInterface), 8, null, true);
  }
  
  private AppRuntime getAppRuntime()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  private String getCDNLibraryPath()
  {
    if (TextUtils.isEmpty(this.mCDNPath))
    {
      File localFile = HippyQQFileUtil.getCDNDownloadFile();
      if (localFile != null) {
        this.mCDNPath = (localFile.getAbsolutePath() + "/" + "armeabi");
      }
    }
    return this.mCDNPath;
  }
  
  public static HippyQQLibraryManager getInstance()
  {
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new HippyQQLibraryManager();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  private String getOfflineLibraryPath()
  {
    if (TextUtils.isEmpty(this.mOfflinePath))
    {
      File localFile = HippyQQFileUtil.getOfflineDownloadFile();
      if (localFile != null) {
        this.mOfflinePath = (localFile.getAbsolutePath() + "/" + "armeabi");
      }
    }
    return this.mOfflinePath;
  }
  
  private boolean isLibraryExists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.SO_LIST.length) {
        break label60;
      }
      File localFile = new File(paramString, this.SO_LIST[i]);
      if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile())) {
        break;
      }
      i += 1;
    }
    label60:
    return true;
  }
  
  private boolean loadLibrary(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    try
    {
      while (i < this.SO_LIST.length)
      {
        System.load(new File(paramString, this.SO_LIST[i]).getAbsolutePath());
        i += 1;
      }
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void onDownloadFail(int paramInt)
  {
    this.mLoadState = 0;
    if (this.mLibraryLoadListeners != null)
    {
      Iterator localIterator = this.mLibraryLoadListeners.iterator();
      while (localIterator.hasNext()) {
        ((HippyQQLibraryManager.LibraryLoadListener)localIterator.next()).onLoadFail(-8, "SoLoadManager load failed, resCode=" + paramInt);
      }
    }
  }
  
  private void onDownloadSuccess()
  {
    this.mLoadState = 2;
    if (this.mLibraryLoadListeners != null)
    {
      Iterator localIterator = this.mLibraryLoadListeners.iterator();
      while (localIterator.hasNext()) {
        ((HippyQQLibraryManager.LibraryLoadListener)localIterator.next()).onLoadSuccess();
      }
    }
  }
  
  private void removeLibraryLoadListener(HippyQQLibraryManager.LibraryLoadListener paramLibraryLoadListener)
  {
    if ((paramLibraryLoadListener != null) && (this.mLibraryLoadListeners.contains(paramLibraryLoadListener))) {
      this.mLibraryLoadListeners.remove(paramLibraryLoadListener);
    }
  }
  
  public String getCoreJsFilePath(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.mCommonPackagePath))) {}
    do
    {
      File localFile;
      do
      {
        return null;
        localFile = new File(this.mCommonPackagePath);
      } while ((localFile == null) || (!localFile.exists()));
      paramString = new File(localFile, paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return paramString.getAbsolutePath();
  }
  
  public int getHippyLibrayId()
  {
    String str1 = "";
    int i = 0;
    while (i < this.SO_NAME.length)
    {
      String str2 = bdgh.a().a(this.SO_NAME[i]);
      if (TextUtils.isEmpty(str2)) {
        return 0;
      }
      str1 = str1 + str2;
      i += 1;
    }
    return str1.hashCode();
  }
  
  public HashMap<String, String> getLibraryVersions()
  {
    return this.mLibraryVerions;
  }
  
  public boolean isLibraryLoaded()
  {
    return this.mLoadState == 2;
  }
  
  public boolean isLibrayExists()
  {
    int i = 0;
    while (i < this.SO_NAME.length)
    {
      if (TextUtils.isEmpty(bdgh.a().a(this.SO_NAME[i]))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void loadLibraryIfNeed(HippyQQLibraryManager.LibraryLoadListener paramLibraryLoadListener)
  {
    switch (this.mLoadState)
    {
    }
    do
    {
      return;
      this.mLoadState = 1;
      addLibraryLoadListener(paramLibraryLoadListener);
      bdgh.a().a(this.SO_NAME, new HippyQQLibraryManager.2(this));
      return;
      addLibraryLoadListener(paramLibraryLoadListener);
      return;
    } while (paramLibraryLoadListener == null);
    paramLibraryLoadListener.onLoadSuccess();
  }
  
  public void preDownload()
  {
    bdgh.a().b(this.SO_NAME, new HippyQQLibraryManager.1(this));
  }
  
  protected void updateSoVersions(LoadExtResult paramLoadExtResult)
  {
    if (paramLoadExtResult == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.SO_NAME.length)
      {
        String str = paramLoadExtResult.getVer(this.SO_NAME[i]);
        this.mLibraryVerions.put(this.SO_NAME[i], str);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager
 * JD-Core Version:    0.7.0.1
 */