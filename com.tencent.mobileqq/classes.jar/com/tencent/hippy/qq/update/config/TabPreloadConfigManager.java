package com.tencent.hippy.qq.update.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.api.TabPreloadItem.PreloadType;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.hippy.qq.update.HippyPredownloadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class TabPreloadConfigManager
{
  public static final int DEFAULT_REQ_INTERVAL_IN_SECONDS = 3600;
  public static final String KEY_PRELOAD_MAX_COUNT = "key_preload_max_count";
  public static final String KEY_TAB_PRELOAD_CONFIG = "key_tab_preload_config";
  public static final String KEY_TAB_PRELOAD_REQ_GAP = "key_tab_preload_req_gap";
  public static final int MIN_PRELOAD_COUNT = 1;
  public static final String TAG = "TabPreloadConfigManager";
  private String mCurrentUin;
  private boolean mIsInitData = false;
  private int mPreloadMaxCount = 1;
  private int mRequestGap = 3600;
  private HashMap<String, ArrayList<TabPreloadItem>> mTabPreloadDatas;
  
  public TabPreloadConfigManager(String paramString)
  {
    this.mCurrentUin = paramString;
  }
  
  public List<TabPreloadItem> getItemsOfTab(String paramString1, String paramString2, TabPreloadItem.PreloadType paramPreloadType)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPreloadType);
    return getItemsOfTab(paramString1, paramString2, localArrayList);
  }
  
  public List<TabPreloadItem> getItemsOfTab(String paramString1, String paramString2, List<TabPreloadItem.PreloadType> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject = this.mTabPreloadDatas;
      if (localObject != null)
      {
        if (paramList == null) {
          return localArrayList;
        }
        paramString1 = (ArrayList)((HashMap)localObject).get(paramString1);
        if (paramString1 == null) {
          return localArrayList;
        }
        int i = 0;
        while (i < paramString1.size())
        {
          localObject = (TabPreloadItem)paramString1.get(i);
          if ((paramList.contains(((TabPreloadItem)localObject).preloadType)) && ((TextUtils.isEmpty(paramString2)) || (paramString2.equals(((TabPreloadItem)localObject).preloadProcess))) && ((((TabPreloadItem)localObject).isPreUpdate()) || (TabPreloadManager.getInstance().isCanPreload(((TabPreloadItem)localObject).bundleName)))) {
            if (TabPreloadManager.getInstance().hasNewMessage(((TabPreloadItem)localObject).bundleName)) {
              localArrayList.add(0, paramString1.get(i));
            } else {
              localArrayList.add(paramString1.get(i));
            }
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public int getPreloadMaxCount()
  {
    return this.mPreloadMaxCount;
  }
  
  public Map<String, ArrayList<TabPreloadItem>> getTabPreloadConfig()
  {
    return this.mTabPreloadDatas;
  }
  
  public void handleTabPreloadResponse(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 1)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      try
      {
        Object localObject = new JSONObject(paramString1);
        this.mPreloadMaxCount = ((JSONObject)localObject).optInt("maxPreloadCount", 1);
        this.mRequestGap = ((JSONObject)localObject).optInt("reqGap", 3600);
        this.mTabPreloadDatas = parseTabPreloadList(paramString2, ((JSONObject)localObject).optJSONArray("tabBarConfigList"));
        if (this.mPreloadMaxCount < 1) {
          this.mPreloadMaxCount = 1;
        }
        localObject = HippyPredownloadManager.getSharedPreferences().edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("key_tab_preload_req_gap");
        localObject = ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), this.mRequestGap);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("key_preload_max_count");
        localObject = ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), this.mPreloadMaxCount);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("key_tab_preload_config");
        ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString1).commit();
        return;
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("handleTabPreloadResponse e:");
        paramString2.append(paramString1);
        QLog.e("TabPreloadConfigManager", 1, paramString2.toString());
      }
    }
  }
  
  public void initData()
  {
    if (this.mIsInitData) {
      return;
    }
    this.mIsInitData = true;
    Object localObject = HippyPredownloadManager.getSharedPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mCurrentUin);
    localStringBuilder.append("key_tab_preload_config");
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
    if (localObject != null) {
      try
      {
        localObject = new JSONObject((String)localObject);
        this.mRequestGap = ((JSONObject)localObject).optInt("reqGap", 3600);
        this.mTabPreloadDatas = parseTabPreloadList(this.mCurrentUin, ((JSONObject)localObject).optJSONArray("tabBarConfigList"));
        return;
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initData e:");
        localStringBuilder.append(localThrowable);
        QLog.e("TabPreloadConfigManager", 1, localStringBuilder.toString());
      }
    }
  }
  
  public HashMap<String, ArrayList<TabPreloadItem>> parseTabPreloadList(String paramString, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    for (;;)
    {
      int j;
      try
      {
        paramString = new HashMap();
        int i = 0;
        if (i < paramJSONArray.length())
        {
          Object localObject = paramJSONArray.getJSONObject(i);
          if (localObject != null)
          {
            String str = ((JSONObject)localObject).optString("name");
            localObject = ((JSONObject)localObject).optJSONArray("bundleConfigList");
            if ((!TextUtils.isEmpty(str)) && (localObject != null))
            {
              ArrayList localArrayList = new ArrayList();
              j = 0;
              if (j < ((JSONArray)localObject).length())
              {
                TabPreloadItem localTabPreloadItem = TabPreloadItem.fromJson(((JSONArray)localObject).getJSONObject(j));
                if (localTabPreloadItem == null) {
                  break label175;
                }
                localArrayList.add(localTabPreloadItem);
                break label175;
              }
              paramString.put(str, localArrayList);
            }
          }
          i += 1;
        }
        else
        {
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        paramJSONArray = new StringBuilder();
        paramJSONArray.append("parseTabPreloadList e:");
        paramJSONArray.append(paramString);
        QLog.e("TabPreloadConfigManager", 1, paramJSONArray.toString());
        return null;
      }
      label175:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.config.TabPreloadConfigManager
 * JD-Core Version:    0.7.0.1
 */