package com.tencent.mobileqq.activity.qwallet.preload;

import Wallet.ResInfo;
import aksg;
import akww;
import android.text.TextUtils;
import aqlk;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadConfig
  implements Serializable
{
  private static final long serialVersionUID = 2L;
  public transient List<PreloadModule> mLastModules;
  private CopyOnWriteArrayList<PreloadModule> mPreloadModules = new CopyOnWriteArrayList();
  public transient byte[] mSaveLock;
  public transient String mSavePath;
  public long moggyConfigVersion;
  
  public static ArrayList<ResInfo> modulesToResInfos(List<PreloadModule> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PreloadModule localPreloadModule = (PreloadModule)paramList.next();
      try
      {
        ResInfo localResInfo = new ResInfo();
        localResInfo.sResId = localPreloadModule.mid;
        localResInfo.iSize = localPreloadModule.getModuleResSize();
        localArrayList.add(localResInfo);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public static List<PreloadModule> parseConfig(JSONArray paramJSONArray, boolean paramBoolean, int paramInt)
  {
    localArrayList = new ArrayList();
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        localArrayList.add(PreloadModule.parsePreloadModule(paramJSONArray.getJSONObject(i), paramBoolean, paramInt));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public static PreloadConfig readConfig(String paramString, AppRuntime paramAppRuntime)
  {
    paramAppRuntime = aksg.a(paramAppRuntime, paramString);
    try
    {
      paramString = (PreloadConfig)akww.a(paramAppRuntime);
      if (paramString == null)
      {
        paramString = new PreloadConfig();
        paramString.mSavePath = paramAppRuntime;
        paramString.mSaveLock = new byte[0];
        paramString.mLastModules = paramString.getCloneModules();
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "readPreloadConfig:" + paramString);
        }
        return paramString;
      }
    }
    catch (InvalidClassException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "preload config update should delete local config");
        }
        aqlk.a().a(68, 0);
        paramString = null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("PreloadManager", 2, "readPreloadConfig exception:" + paramAppRuntime + "|" + paramString.toString());
        }
        paramString = null;
        continue;
        paramString.checkModules();
      }
    }
  }
  
  public static void splitModulesByBackControl(List<PreloadModule> paramList1, List<PreloadModule> paramList2, List<PreloadModule> paramList3)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      PreloadModule localPreloadModule = (PreloadModule)paramList1.next();
      if (localPreloadModule.mBackControl) {
        paramList2.add(localPreloadModule);
      } else {
        paramList3.add(localPreloadModule);
      }
    }
  }
  
  public static void splitModulesBySize(int paramInt, List<PreloadModule> paramList1, List<PreloadModule> paramList2, List<PreloadModule> paramList3)
  {
    if ((paramList1 == null) || (paramList2 == null) || (paramList3 == null)) {}
    for (;;)
    {
      return;
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        PreloadModule localPreloadModule = (PreloadModule)paramList1.next();
        if (localPreloadModule.getModuleResSize() <= paramInt) {
          paramList2.add(localPreloadModule);
        } else {
          paramList3.add(localPreloadModule);
        }
      }
    }
  }
  
  public void addOrMerge(JSONObject paramJSONObject, PreloadManager paramPreloadManager)
  {
    paramJSONObject = PreloadModule.parsePreloadModule(paramJSONObject, true, 0);
    PreloadModule localPreloadModule = getModuleByID(paramJSONObject.mid);
    if (localPreloadModule != null)
    {
      localPreloadModule.updatePreloadModule(paramJSONObject, paramPreloadManager);
      return;
    }
    this.mPreloadModules.add(paramJSONObject);
  }
  
  public void checkModules()
  {
    if (this.mPreloadModules == null) {
      this.mPreloadModules = new CopyOnWriteArrayList();
    }
    Iterator localIterator1 = this.mPreloadModules.iterator();
    while (localIterator1.hasNext())
    {
      PreloadModule localPreloadModule = (PreloadModule)localIterator1.next();
      localPreloadModule.check();
      Iterator localIterator2 = localPreloadModule.getResList().iterator();
      while (localIterator2.hasNext())
      {
        PreloadResource localPreloadResource = (PreloadResource)localIterator2.next();
        if (TextUtils.isEmpty(localPreloadResource.mResId)) {
          localPreloadResource.mResId = localPreloadResource.getResDownloadUrl(localPreloadModule);
        }
      }
    }
  }
  
  public void filterInvalidModules(PreloadManager paramPreloadManager)
  {
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext())
    {
      PreloadModule localPreloadModule = (PreloadModule)localIterator.next();
      localPreloadModule.filterInvalidRes(paramPreloadManager);
      if (localPreloadModule.getResNum() <= 0) {
        this.mPreloadModules.remove(localPreloadModule);
      }
    }
  }
  
  public List<PreloadModule> getCloneModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new PreloadModule((PreloadModule)localIterator.next()));
    }
    return localArrayList;
  }
  
  public PreloadModule getModuleByID(String paramString)
  {
    if (paramString != null)
    {
      Iterator localIterator = this.mPreloadModules.iterator();
      while (localIterator.hasNext())
      {
        PreloadModule localPreloadModule = (PreloadModule)localIterator.next();
        if (localPreloadModule.mid.equals(paramString)) {
          return localPreloadModule;
        }
      }
    }
    return null;
  }
  
  public PreloadModule getModuleByName(String paramString)
  {
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext())
    {
      PreloadModule localPreloadModule = (PreloadModule)localIterator.next();
      if (localPreloadModule.name.equals(paramString)) {
        return localPreloadModule;
      }
    }
    return null;
  }
  
  public int getModuleNum()
  {
    return this.mPreloadModules.size();
  }
  
  public List<PreloadModule> getModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((PreloadModule)localIterator.next());
    }
    return localArrayList;
  }
  
  public ResourceInfo getResInfoByResId(String paramString)
  {
    PreloadModule localPreloadModule;
    PreloadResource localPreloadResource;
    do
    {
      Iterator localIterator1 = this.mPreloadModules.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localPreloadModule = (PreloadModule)localIterator1.next();
        localIterator2 = localPreloadModule.getResList().iterator();
      }
      localPreloadResource = (PreloadResource)localIterator2.next();
    } while (!akww.c(localPreloadResource.mResId, paramString));
    return localPreloadResource.getResInfo(localPreloadModule);
    return null;
  }
  
  public void innerReplaceConfig(JSONArray paramJSONArray, PreloadManager paramPreloadManager, int paramInt)
  {
    paramJSONArray = parseConfig(paramJSONArray, false, paramInt);
    Iterator localIterator = this.mPreloadModules.iterator();
    while (localIterator.hasNext())
    {
      PreloadModule localPreloadModule = (PreloadModule)localIterator.next();
      int i = paramJSONArray.indexOf(localPreloadModule);
      if (i != -1)
      {
        localPreloadModule.updateNewModuleWhenReplace((PreloadModule)paramJSONArray.get(i), paramPreloadManager, paramInt);
      }
      else
      {
        localPreloadModule.deleteResFromServer(paramPreloadManager, paramInt);
        if (localPreloadModule.getResNum() > 0) {
          paramJSONArray.add(localPreloadModule);
        }
      }
    }
    this.mPreloadModules = new CopyOnWriteArrayList(paramJSONArray);
  }
  
  public boolean isModulesChange(List<PreloadModule> paramList)
  {
    boolean bool2 = false;
    List localList = getModules();
    boolean bool1;
    if (localList.size() != paramList.size())
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= localList.size()) {
        break;
      }
      if (((PreloadModule)localList.get(i)).isModuleChange((PreloadModule)paramList.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  public boolean isResInConfig(PreloadResource paramPreloadResource)
  {
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.mPreloadModules.iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((PreloadModule)localIterator1.next()).getResList().iterator();
      }
    } while (!akww.c(((PreloadResource)localIterator2.next()).mResId, paramPreloadResource.mResId));
    return true;
    return false;
  }
  
  public boolean isUrlInConfig(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    PreloadModule localPreloadModule;
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.mPreloadModules.iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localPreloadModule = (PreloadModule)localIterator1.next();
        localIterator2 = localPreloadModule.getResList().iterator();
      }
    } while (!paramString.equals(((PreloadResource)localIterator2.next()).getResDownloadUrl(localPreloadModule)));
    return true;
    return false;
  }
  
  public void mergeConfig(String paramString, PreloadManager paramPreloadManager)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("module_config");
      int i = 0;
      while (i < paramString.length())
      {
        addOrMerge(paramString.getJSONObject(i), paramPreloadManager);
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void removeModule(PreloadModule paramPreloadModule)
  {
    this.mPreloadModules.remove(paramPreloadModule);
  }
  
  public List<PreloadModule> resInfosToModules(ArrayList<ResInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList == null) {
      return localArrayList;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      PreloadModule localPreloadModule = getModuleByID(((ResInfo)paramArrayList.next()).sResId);
      if (localPreloadModule != null) {
        localArrayList.add(localPreloadModule);
      }
    }
    return localArrayList;
  }
  
  public void savePreloadConfig()
  {
    ThreadManager.getFileThreadHandler().post(new PreloadConfig.1(this));
  }
  
  public String toString()
  {
    return "Config [mModules=" + this.mPreloadModules + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadConfig
 * JD-Core Version:    0.7.0.1
 */