package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HippyQQLibraryManager
{
  private static HippyQQLibraryManager INSTANCE;
  public static final int STATE_LOADED = 2;
  public static final int STATE_LOADING = 1;
  public static final int STATE_UNLOAD = 0;
  private final String[] SO_NAME = { "mtt_shared", "mttv8", "hippybridge", "flexbox" };
  private String mCommonPackagePath;
  private List<LibraryLoadListener> mLibraryLoadListeners = new ArrayList();
  private HashMap<String, String> mLibraryVerions = new HashMap();
  private Object mListenerLock = new Object();
  private int mLoadState = 0;
  
  private void addLibraryLoadListener(LibraryLoadListener paramLibraryLoadListener)
  {
    Object localObject = this.mListenerLock;
    if (paramLibraryLoadListener != null) {}
    try
    {
      if (!this.mLibraryLoadListeners.contains(paramLibraryLoadListener)) {
        this.mLibraryLoadListeners.add(paramLibraryLoadListener);
      }
      return;
    }
    finally {}
  }
  
  public static HippyQQLibraryManager getInstance()
  {
    if (INSTANCE == null) {
      try
      {
        if (INSTANCE == null) {
          INSTANCE = new HippyQQLibraryManager();
        }
      }
      finally {}
    }
    return INSTANCE;
  }
  
  private void onDownloadFail(int paramInt)
  {
    this.mLoadState = 0;
    synchronized (this.mListenerLock)
    {
      Iterator localIterator = this.mLibraryLoadListeners.iterator();
      while (localIterator.hasNext())
      {
        LibraryLoadListener localLibraryLoadListener = (LibraryLoadListener)localIterator.next();
        if (localLibraryLoadListener != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("SoLoadManager load failed, resCode=");
          localStringBuilder.append(paramInt);
          localLibraryLoadListener.onLoadFail(-8, localStringBuilder.toString());
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void onDownloadSuccess()
  {
    this.mLoadState = 2;
    synchronized (this.mListenerLock)
    {
      Iterator localIterator = this.mLibraryLoadListeners.iterator();
      while (localIterator.hasNext())
      {
        LibraryLoadListener localLibraryLoadListener = (LibraryLoadListener)localIterator.next();
        if (localLibraryLoadListener != null) {
          localLibraryLoadListener.onLoadSuccess();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void removeLibraryLoadListener(LibraryLoadListener paramLibraryLoadListener)
  {
    Object localObject = this.mListenerLock;
    if (paramLibraryLoadListener != null) {}
    try
    {
      if (this.mLibraryLoadListeners.contains(paramLibraryLoadListener)) {
        this.mLibraryLoadListeners.remove(paramLibraryLoadListener);
      }
      return;
    }
    finally {}
  }
  
  public String getCoreJsFilePath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (TextUtils.isEmpty(this.mCommonPackagePath)) {
        return null;
      }
      File localFile = new File(this.mCommonPackagePath);
      if (!localFile.exists()) {
        return null;
      }
      paramString = new File(localFile, paramString);
      if (paramString.exists()) {
        return paramString.getAbsolutePath();
      }
    }
    return null;
  }
  
  public int getHippyLibrayId()
  {
    String str1 = "";
    int i = 0;
    while (i < this.SO_NAME.length)
    {
      String str2 = SoLoadManager.getInstance().getSoVer(this.SO_NAME[i]);
      if (TextUtils.isEmpty(str2)) {
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      str1 = localStringBuilder.toString();
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
      if (TextUtils.isEmpty(SoLoadManager.getInstance().getSoVer(this.SO_NAME[i]))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void loadLibraryIfNeed(LibraryLoadListener paramLibraryLoadListener)
  {
    int i = this.mLoadState;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        if (paramLibraryLoadListener != null) {
          paramLibraryLoadListener.onLoadSuccess();
        }
      }
      else
      {
        addLibraryLoadListener(paramLibraryLoadListener);
      }
    }
    else
    {
      this.mLoadState = 1;
      addLibraryLoadListener(paramLibraryLoadListener);
      SoLoadManager.getInstance().loadSequentially(this.SO_NAME, new HippyQQLibraryManager.2(this));
    }
  }
  
  public void preDownload()
  {
    SoLoadManager.getInstance().download(this.SO_NAME, new HippyQQLibraryManager.1(this));
  }
  
  protected void updateSoVersions(LoadExtResult paramLoadExtResult)
  {
    if (paramLoadExtResult == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      Object localObject = this.SO_NAME;
      if (i >= localObject.length) {
        break;
      }
      localObject = paramLoadExtResult.getVer(localObject[i]);
      this.mLibraryVerions.put(this.SO_NAME[i], localObject);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager
 * JD-Core Version:    0.7.0.1
 */