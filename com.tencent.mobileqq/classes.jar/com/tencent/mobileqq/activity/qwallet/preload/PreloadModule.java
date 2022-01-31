package com.tencent.mobileqq.activity.qwallet.preload;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.vip.DownloadListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import xfy;

public class PreloadModule
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean isForbidAutoDownload;
  public boolean mBackControl;
  public String mBaseUrl;
  private CopyOnWriteArrayList mPreloadResources = new CopyOnWriteArrayList();
  public String mid;
  public String name;
  public int option;
  
  public PreloadModule() {}
  
  public PreloadModule(PreloadModule paramPreloadModule)
  {
    this();
    this.mid = paramPreloadModule.mid;
    this.mBackControl = paramPreloadModule.mBackControl;
    this.name = paramPreloadModule.name;
    this.option = paramPreloadModule.option;
    this.isForbidAutoDownload = paramPreloadModule.isForbidAutoDownload;
    this.mBaseUrl = paramPreloadModule.mBaseUrl;
    paramPreloadModule = paramPreloadModule.mPreloadResources.iterator();
    while (paramPreloadModule.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)paramPreloadModule.next();
      this.mPreloadResources.add(new PreloadResource(localPreloadResource));
    }
  }
  
  private void a(String paramString, AppRuntime paramAppRuntime)
  {
    Object localObject = null;
    try
    {
      Uri localUri = Uri.parse(paramString);
      paramString = localObject;
      if (localUri != null)
      {
        paramString = localObject;
        if (localUri.isHierarchical()) {
          paramString = localUri.getQueryParameter("_bid");
        }
      }
      if (!a(paramString)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    HtmlOffline.b(paramString, paramAppRuntime, true, new xfy(this));
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  public static PreloadModule parsePreloadModule(JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    int i = 0;
    PreloadModule localPreloadModule = new PreloadModule();
    for (;;)
    {
      try
      {
        if (paramJSONObject.optInt("back_control") != 1) {
          break label195;
        }
        bool1 = true;
        localPreloadModule.mBackControl = bool1;
        if (paramBoolean) {
          localPreloadModule.mBackControl = false;
        }
        localPreloadModule.name = paramJSONObject.optString("module_name");
        Object localObject = paramJSONObject.optString("module_id");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localPreloadModule.mid = localPreloadModule.name;
          localPreloadModule.option = paramJSONObject.optInt("option");
          if (paramJSONObject.optInt("forbid_download") != 1) {
            break label189;
          }
          bool1 = bool2;
          localPreloadModule.isForbidAutoDownload = bool1;
          localPreloadModule.mBaseUrl = paramJSONObject.optString("url_base");
          paramJSONObject = paramJSONObject.optJSONArray("resources");
          if (i < paramJSONObject.length())
          {
            localObject = PreloadResource.parsePreloadResource(paramJSONObject.getJSONObject(i), localPreloadModule, paramBoolean, paramInt);
            localPreloadModule.mPreloadResources.add(localObject);
            i += 1;
            continue;
          }
        }
        else
        {
          localPreloadModule.mid = ((String)localObject);
          continue;
        }
        return localPreloadModule;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      label189:
      boolean bool1 = false;
      continue;
      label195:
      bool1 = false;
    }
  }
  
  public void deleteResFromServer(PreloadManager paramPreloadManager, int paramInt)
  {
    paramPreloadManager = this.mPreloadResources.iterator();
    while (paramPreloadManager.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)paramPreloadManager.next();
      if ((localPreloadResource.mIsFromLocal) || (localPreloadResource.mFromType == paramInt)) {
        this.mPreloadResources.remove(localPreloadResource);
      }
    }
  }
  
  public void downloadModule(boolean paramBoolean1, DownloadListener paramDownloadListener, PreloadManager paramPreloadManager, boolean paramBoolean2)
  {
    if (this.name.equals("wallet_offline")) {
      handleHtmlOffline(paramPreloadManager.a);
    }
    for (;;)
    {
      return;
      if ((paramBoolean1) || (!this.isForbidAutoDownload))
      {
        Iterator localIterator = this.mPreloadResources.iterator();
        while (localIterator.hasNext())
        {
          PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
          if (!localPreloadResource.isInValidTime())
          {
            localPreloadResource.deleteResFile(this, paramPreloadManager, 6);
            this.mPreloadResources.remove(localPreloadResource);
          }
          else if (localPreloadResource.isTimeToDownload(paramPreloadManager, this))
          {
            localPreloadResource.startDownload(paramPreloadManager, this, paramDownloadListener, paramBoolean2);
          }
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PreloadModule)))
    {
      paramObject = (PreloadModule)paramObject;
      if ((this.mid != null) && (this.mid.equals(paramObject.mid))) {
        return true;
      }
    }
    return false;
  }
  
  public void filterInvalidRes(PreloadManager paramPreloadManager)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
      if (!localPreloadResource.isInValidTime())
      {
        localPreloadResource.deleteResFile(this, paramPreloadManager, 6);
        this.mPreloadResources.remove(localPreloadResource);
      }
      else if (localPreloadResource.isNeedForceDeleteConfig(this))
      {
        this.mPreloadResources.remove(localPreloadResource);
      }
    }
  }
  
  public int getModuleResSize()
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((PreloadResource)localIterator.next()).size + i) {}
    return i;
  }
  
  public List getResList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((PreloadResource)localIterator.next());
    }
    return localArrayList;
  }
  
  public int getResNum()
  {
    return this.mPreloadResources.size();
  }
  
  public PreloadResource getResourceByResId(String paramString)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
      if (QWalletTools.c(localPreloadResource.mResId, paramString)) {
        return localPreloadResource;
      }
    }
    return null;
  }
  
  public PreloadResource getResourceByType(int paramInt)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
      if (localPreloadResource.type == paramInt) {
        return localPreloadResource;
      }
    }
    return null;
  }
  
  public void handleHtmlOffline(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext()) {
      a(((PreloadResource)localIterator.next()).url, paramAppRuntime);
    }
  }
  
  public boolean isModuleChange(PreloadModule paramPreloadModule)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!QWalletTools.c(this.mid, paramPreloadModule.mid))
    {
      bool1 = true;
      return bool1;
    }
    if (this.mBackControl != paramPreloadModule.mBackControl) {
      return true;
    }
    if (!QWalletTools.c(this.name, paramPreloadModule.name)) {
      return true;
    }
    if (this.option != paramPreloadModule.option) {
      return true;
    }
    if (this.isForbidAutoDownload != paramPreloadModule.isForbidAutoDownload) {
      return true;
    }
    if (!QWalletTools.c(this.mBaseUrl, paramPreloadModule.mBaseUrl)) {
      return true;
    }
    List localList = getResList();
    if (localList.size() != paramPreloadModule.mPreloadResources.size()) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= localList.size()) {
        break;
      }
      if (((PreloadResource)localList.get(i)).isResChange((PreloadResource)paramPreloadModule.mPreloadResources.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  public boolean isModuleFinish(PreloadManager paramPreloadManager)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext()) {
      if (!((PreloadResource)localIterator.next()).isResFileExist(this, paramPreloadManager)) {
        return false;
      }
    }
    return true;
  }
  
  public void removeResource(PreloadResource paramPreloadResource)
  {
    if (paramPreloadResource == null) {
      return;
    }
    this.mPreloadResources.remove(paramPreloadResource);
  }
  
  public String toString()
  {
    return "Module [mid=" + this.mid + ", mBC=" + this.mBackControl + ", mRes=" + this.mPreloadResources + "]";
  }
  
  public void updateNewModuleWhenReplace(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager, int paramInt)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext())
    {
      PreloadResource localPreloadResource1 = (PreloadResource)localIterator.next();
      PreloadResource localPreloadResource2 = paramPreloadModule.getResourceByResId(localPreloadResource1.mResId);
      if (localPreloadResource2 == null)
      {
        if ((!localPreloadResource1.mIsFromLocal) && (paramInt != localPreloadResource1.mFromType)) {
          paramPreloadModule.mPreloadResources.add(localPreloadResource1);
        }
      }
      else if (localPreloadResource1.isNeedDeleteOldFileWhenUpdate(this, localPreloadResource2, paramPreloadManager)) {
        localPreloadResource1.deleteResFile(this, paramPreloadManager, 3);
      }
    }
  }
  
  public void updatePreloadModule(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    this.mid = paramPreloadModule.mid;
    this.mBackControl = paramPreloadModule.mBackControl;
    this.name = paramPreloadModule.name;
    this.option = paramPreloadModule.option;
    this.isForbidAutoDownload = paramPreloadModule.isForbidAutoDownload;
    this.mBaseUrl = paramPreloadModule.mBaseUrl;
    paramPreloadModule = paramPreloadModule.mPreloadResources.iterator();
    while (paramPreloadModule.hasNext())
    {
      PreloadResource localPreloadResource1 = (PreloadResource)paramPreloadModule.next();
      PreloadResource localPreloadResource2 = getResourceByResId(localPreloadResource1.mResId);
      if (localPreloadResource2 == null)
      {
        this.mPreloadResources.add(localPreloadResource1);
      }
      else
      {
        if (localPreloadResource2.isNeedDeleteOldFileWhenUpdate(this, localPreloadResource1, paramPreloadManager))
        {
          localPreloadResource2.deleteResFile(this, paramPreloadManager, 4);
          localPreloadResource2.mHasUnzip = false;
        }
        localPreloadResource2.mDownloadTime = localPreloadResource1.mDownloadTime;
        localPreloadResource2.mInvalidTime = localPreloadResource1.mInvalidTime;
        localPreloadResource2.md5 = localPreloadResource1.md5;
        localPreloadResource2.type = localPreloadResource1.type;
        localPreloadResource2.size = localPreloadResource1.size;
        localPreloadResource2.urlPath = localPreloadResource1.urlPath;
        localPreloadResource2.url = localPreloadResource1.url;
        localPreloadResource2.mResId = localPreloadResource1.mResId;
        localPreloadResource2.mFlowControl = localPreloadResource1.mFlowControl;
        localPreloadResource2.mIsFromLocal = localPreloadResource1.mIsFromLocal;
        localPreloadResource2.mIsTemp = localPreloadResource1.mIsTemp;
        localPreloadResource2.mIsNeedUnzip = localPreloadResource1.mIsNeedUnzip;
        localPreloadResource2.mIsUnzipInside = localPreloadResource1.mIsUnzipInside;
        localPreloadResource2.mUnzipPrefix = localPreloadResource1.mUnzipPrefix;
        localPreloadResource2.mFromType = localPreloadResource1.mFromType;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadModule
 * JD-Core Version:    0.7.0.1
 */