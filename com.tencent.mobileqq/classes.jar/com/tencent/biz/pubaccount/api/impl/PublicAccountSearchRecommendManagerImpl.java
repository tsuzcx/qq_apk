package com.tencent.biz.pubaccount.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.GetRecommendListListener;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.ac.ArticleComment.GetRecommendPubAccountRequest;

public class PublicAccountSearchRecommendManagerImpl
  implements IPublicAccountSearchRecommendManager
{
  public static final String SSO_COMMAND_GET_RECOMMEND_PUBACCOUNT = "PubAccountArticleCenter.GetRecommendPubAccount";
  private final long HISTORY_CACHE_TIME_OUT = 2592000000L;
  private final String KEY_RECOMMEND_CACHE_TIME = "recommend_cache_time";
  private final String KEY_RECOMMEND_CONTENT_LIST = "recommend_content_list";
  private final String KEY_RECOMMEND_FETCH_TIME = "recommend_fetch_time";
  private final String KEY_RECOMMEND_IS_FORBIDDEN = "recommend_is_forbidden";
  private final String KEY_RECOMMEND_TITLE = "recommend_title";
  private final String KEY_SEARCH_HISTORY_LIST = "search_history_list";
  private final int MAX_RECOMMEND_COUNT = 8;
  private final long RECOMMEND_CACHE_TIME_OUT = 86400000L;
  private final long RECOMMEND_FETCH_TIME_OUT = 3600000L;
  private final String TAG = PublicAccountSearchRecommendManagerImpl.class.getSimpleName();
  private boolean mInited = false;
  private ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem> mPublicAccountSearchHistoryList = new ArrayList();
  private HashMap<String, IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem> mPublicAccountSearchHistoryMap = new HashMap();
  private ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem> mPublicAccountSearchRecommendList = new ArrayList();
  private long mRecommendCacheTime;
  private long mRecommendFetchTime;
  private boolean mRecommendIsForbidden = false;
  private String mRecommendTitle;
  
  private boolean checkRecommendCacheValid(AppInterface paramAppInterface)
  {
    if (!this.mInited) {
      initFromLocalData(paramAppInterface);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = this.mPublicAccountSearchRecommendList.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (l - this.mRecommendCacheTime < 86400000L)
    {
      bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkRecommendCacheValid->now:");
      localStringBuilder.append(l);
      localStringBuilder.append(", cacheTime:");
      localStringBuilder.append(this.mRecommendCacheTime);
      localStringBuilder.append(", size:");
      localStringBuilder.append(i);
      localStringBuilder.append(", result:");
      localStringBuilder.append(bool1);
      QLog.d(paramAppInterface, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  private boolean checkShouldFetchData(AppInterface paramAppInterface)
  {
    if (!this.mInited) {
      initFromLocalData(paramAppInterface);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = false;
    if (l - this.mRecommendFetchTime > 3600000L) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShouldFetchData->now:");
      localStringBuilder.append(l);
      localStringBuilder.append(", fetchTime:");
      localStringBuilder.append(this.mRecommendFetchTime);
      localStringBuilder.append(", result:");
      localStringBuilder.append(bool);
      QLog.d(paramAppInterface, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem> getListFromHistory(AppInterface paramAppInterface)
  {
    paramAppInterface = new ArrayList();
    Iterator localIterator = this.mPublicAccountSearchHistoryList.iterator();
    while (localIterator.hasNext())
    {
      IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem localPublicAccountSearchHistoryItem = (IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem)localIterator.next();
      paramAppInterface.add(new IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem(localPublicAccountSearchHistoryItem.a, localPublicAccountSearchHistoryItem.b, localPublicAccountSearchHistoryItem.c));
    }
    return paramAppInterface;
  }
  
  private ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem> getListFromRecommend()
  {
    if (this.mPublicAccountSearchRecommendList.size() <= 8) {
      return (ArrayList)this.mPublicAccountSearchRecommendList.clone();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      localArrayList.add(this.mPublicAccountSearchRecommendList.get(i));
      i += 1;
    }
    return (ArrayList)localArrayList.clone();
  }
  
  private void getRecommendListFromLocal(AppInterface paramAppInterface, IPublicAccountSearchRecommendManager.GetRecommendListListener paramGetRecommendListListener)
  {
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRecommendListFromLocal->mRecommendIsForbidden:");
      localStringBuilder.append(this.mRecommendIsForbidden);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.mRecommendIsForbidden)
    {
      paramGetRecommendListListener.a(new ArrayList(), null, true);
      return;
    }
    if (checkRecommendCacheValid(paramAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "getRecommendListFromLocal->使用推荐内容缓存!");
      }
      paramGetRecommendListListener.a(getListFromRecommend(), this.mRecommendTitle, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getRecommendListFromLocal->使用搜索历史!");
    }
    paramGetRecommendListListener.a(getListFromHistory(paramAppInterface), null, false);
  }
  
  private void loadHistoryListFromLocal(AppInterface paramAppInterface)
  {
    Object localObject = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = localStringBuilder.toString();
    int i = 0;
    paramAppInterface = ((MobileQQ)localObject).getSharedPreferences(paramAppInterface, 0);
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.getString("public_account_search_history", null);
      if (QLog.isColorLevel())
      {
        localObject = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadHistoryListFromLocal->json:");
        localStringBuilder.append(paramAppInterface);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramAppInterface)) {
        try
        {
          paramAppInterface = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramAppInterface);
          if (paramAppInterface != null)
          {
            paramAppInterface = paramAppInterface.getJSONArray("search_history_list");
            this.mPublicAccountSearchHistoryList.clear();
            this.mPublicAccountSearchHistoryMap.clear();
            while (i < paramAppInterface.length())
            {
              localObject = (JSONObject)paramAppInterface.get(i);
              localObject = new IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem(((JSONObject)localObject).optString("uin"), ((JSONObject)localObject).optString("name"), ((JSONObject)localObject).optLong("time"), ((JSONObject)localObject).optBoolean("isPA", true));
              this.mPublicAccountSearchHistoryList.add(localObject);
              this.mPublicAccountSearchHistoryMap.put(((IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem)localObject).a, localObject);
              i += 1;
            }
          }
          return;
        }
        catch (JSONException paramAppInterface)
        {
          if (QLog.isColorLevel())
          {
            localObject = this.TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("loadHistoryListFromLocal->error:");
            localStringBuilder.append(paramAppInterface);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  private void loadRecommendListFromLocal(AppInterface paramAppInterface)
  {
    Object localObject = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = localStringBuilder.toString();
    int i = 0;
    paramAppInterface = ((MobileQQ)localObject).getSharedPreferences(paramAppInterface, 0);
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.getString("public_account_search_recommend", null);
      if (QLog.isColorLevel())
      {
        localObject = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadRecommendListFromLocal->json:");
        localStringBuilder.append(paramAppInterface);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramAppInterface)) {
        try
        {
          paramAppInterface = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramAppInterface);
          if (paramAppInterface != null)
          {
            this.mRecommendTitle = paramAppInterface.getString("recommend_title");
            this.mRecommendCacheTime = paramAppInterface.getLong("recommend_cache_time");
            this.mRecommendFetchTime = paramAppInterface.getLong("recommend_fetch_time");
            this.mRecommendIsForbidden = paramAppInterface.getBoolean("recommend_is_forbidden");
            paramAppInterface = paramAppInterface.getJSONArray("recommend_content_list");
            this.mPublicAccountSearchRecommendList.clear();
            while (i < paramAppInterface.length())
            {
              localObject = (JSONObject)paramAppInterface.get(i);
              localObject = new IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem(((JSONObject)localObject).optString("uin"), ((JSONObject)localObject).optString("name"), ((JSONObject)localObject).optBoolean("isPA", true));
              this.mPublicAccountSearchRecommendList.add(localObject);
              i += 1;
            }
          }
          return;
        }
        catch (JSONException paramAppInterface)
        {
          if (QLog.isColorLevel())
          {
            localObject = this.TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("loadRecommendListFromLocal->error:");
            localStringBuilder.append(paramAppInterface);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  private void saveHistoryListToLocal(AppInterface paramAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountSearchRecommendManagerImpl.2(this, paramAppInterface));
  }
  
  private void saveRecommendListToLocal(AppInterface paramAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountSearchRecommendManagerImpl.1(this, paramAppInterface));
  }
  
  private void sendGetPublicAccountSearchRecommendRequest(AppInterface paramAppInterface, IPublicAccountSearchRecommendManager.GetRecommendListListener paramGetRecommendListListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendGetPublicAccountSearchRecommendRequest->begin!");
    }
    NewIntent localNewIntent = new NewIntent(paramAppInterface.getApplication().getApplicationContext(), PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "PubAccountArticleCenter.GetRecommendPubAccount");
    ArticleComment.GetRecommendPubAccountRequest localGetRecommendPubAccountRequest = new ArticleComment.GetRecommendPubAccountRequest();
    localGetRecommendPubAccountRequest.version.set(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getVersionInfo());
    localGetRecommendPubAccountRequest.cuin.set(Long.parseLong(paramAppInterface.getCurrentAccountUin()));
    localGetRecommendPubAccountRequest.count.set(8);
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendGetPublicAccountSearchRecommendRequset->versionInfo:");
      localStringBuilder.append(localGetRecommendPubAccountRequest.version.get());
      localStringBuilder.append(", cuin:");
      localStringBuilder.append(localGetRecommendPubAccountRequest.cuin.get());
      localStringBuilder.append(", count:");
      localStringBuilder.append(localGetRecommendPubAccountRequest.count.get());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    localNewIntent.putExtra("data", localGetRecommendPubAccountRequest.toByteArray());
    localNewIntent.setObserver(new PublicAccountSearchRecommendManagerImpl.3(this, localNewIntent, paramAppInterface, paramGetRecommendListListener));
    this.mRecommendFetchTime = NetConnInfoCenter.getServerTimeMillis();
    paramAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel())
    {
      paramAppInterface = this.TAG;
      paramGetRecommendListListener = new StringBuilder();
      paramGetRecommendListListener.append("sendGetPublicAccountSearchRecommendRequest->send request, time:");
      paramGetRecommendListListener.append(this.mRecommendFetchTime);
      QLog.d(paramAppInterface, 2, paramGetRecommendListListener.toString());
    }
  }
  
  public void getRecommendList(AppInterface paramAppInterface, boolean paramBoolean, IPublicAccountSearchRecommendManager.GetRecommendListListener paramGetRecommendListListener)
  {
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRecommendList->isFromCreate:");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!paramBoolean)
    {
      paramGetRecommendListListener.a(getListFromHistory(paramAppInterface), null, false);
      return;
    }
    if (checkShouldFetchData(paramAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "getRecommendList->sendGetPublicAccountSearchRecommendRequest!");
      }
      sendGetPublicAccountSearchRecommendRequest(paramAppInterface, paramGetRecommendListListener);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getRecommendList->getRecommendListFromLocal!");
    }
    getRecommendListFromLocal(paramAppInterface, paramGetRecommendListListener);
  }
  
  public void initFromLocalData(AppInterface paramAppInterface)
  {
    if ((!this.mInited) && (paramAppInterface != null))
    {
      loadRecommendListFromLocal(paramAppInterface);
      loadHistoryListFromLocal(paramAppInterface);
      this.mInited = true;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "initFromLocalData!");
      }
    }
  }
  
  public void reset()
  {
    this.mInited = false;
    this.mRecommendTitle = "";
    this.mRecommendCacheTime = 0L;
    this.mRecommendFetchTime = 0L;
    this.mPublicAccountSearchRecommendList.clear();
    this.mPublicAccountSearchHistoryList.clear();
    this.mPublicAccountSearchHistoryMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "resetManager!");
    }
  }
  
  public void updatePublicAccountSearchHistoryItem(AppInterface paramAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePublicAccountSearchHistoryItem->uin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", name:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", isPublicAccount:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", time:");
      localStringBuilder.append(l);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.mPublicAccountSearchHistoryMap.containsKey(paramString1))
    {
      paramString1 = (IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem)this.mPublicAccountSearchHistoryMap.get(paramString1);
      this.mPublicAccountSearchHistoryList.remove(paramString1);
      this.mPublicAccountSearchHistoryList.add(0, paramString1);
      paramString1.d = l;
      paramString1.c = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem update!");
      }
    }
    else
    {
      paramString2 = new IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem(paramString1, paramString2, l, paramBoolean);
      this.mPublicAccountSearchHistoryList.add(0, paramString2);
      this.mPublicAccountSearchHistoryMap.put(paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem insert!");
      }
      int i = this.mPublicAccountSearchHistoryList.size();
      if (i > 8)
      {
        paramString1 = (IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem)this.mPublicAccountSearchHistoryList.get(i - 1);
        this.mPublicAccountSearchHistoryList.remove(paramString1);
        this.mPublicAccountSearchHistoryMap.remove(paramString1.a);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem remove lastItem!");
        }
      }
    }
    saveHistoryListToLocal(paramAppInterface);
    if (QLog.isColorLevel())
    {
      paramAppInterface = this.mPublicAccountSearchHistoryList.iterator();
      while (paramAppInterface.hasNext())
      {
        paramString1 = (IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem)paramAppInterface.next();
        QLog.d(this.TAG, 2, paramString1.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountSearchRecommendManagerImpl
 * JD-Core Version:    0.7.0.1
 */