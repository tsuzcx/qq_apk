package com.tencent.mobileqq.apollo.res.api.impl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import org.json.JSONObject;

public class CmShowRscCacheManagerImpl
  implements ICmShowRscCacheManager
{
  private final SparseArray<CmShowRscCacheManagerImpl.IdolRscItem> mRoomRscMap = new SparseArray();
  
  public CmShowRscCacheManagerImpl()
  {
    onRoomZipUpdated();
  }
  
  private void initRoomJson()
  {
    Object localObject1 = new CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult();
    ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject1).a = 100;
    ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject1).b = 1L;
    ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject1).c = "all_room3D";
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject1).b());
    ((StringBuilder)localObject2).append("all_room3D.json");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists())
    {
      ApolloUtilImpl.showDebugTipsToast("小窝json不存在");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initRoomJson file is no exsit path:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("rscContent_ApolloRscCacheManager", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    try
    {
      localObject2 = new JSONObject(FileUtils.readFileToString((File)localObject2)).optJSONObject("data");
      if (localObject2 == null) {
        return;
      }
      localObject1 = ((JSONObject)localObject2).optString("downloadUrl");
      localObject2 = ((JSONObject)localObject2).optJSONObject("list");
      Iterator localIterator = ((JSONObject)localObject2).keys();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        int i = ApolloUtilImpl.parseToInt((String)localObject3);
        if (i > -2147483648)
        {
          localObject3 = ((JSONObject)localObject2).optJSONObject((String)localObject3);
          if (localObject3 != null)
          {
            localObject3 = ((JSONObject)localObject3).optString("source_qq");
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              CmShowRscCacheManagerImpl.IdolRscItem localIdolRscItem = new CmShowRscCacheManagerImpl.IdolRscItem();
              localIdolRscItem.e = "all_room3D.json";
              localIdolRscItem.d = ((String)localObject1);
              localIdolRscItem.c = i;
              localIdolRscItem.a = 8;
              localIdolRscItem.b = ((String)localObject3);
              this.mRoomRscMap.put(i, localIdolRscItem);
            }
          }
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("rscContent_ApolloRscCacheManager", 1, "initRoomJson e:", localException);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initRoomJson mRoomRscMap:");
        localStringBuilder.append(this.mRoomRscMap);
        QLog.d("rscContent_ApolloRscCacheManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public CmShowRscCacheManagerImpl.IdolRscItem getRscItem(int paramInt1, int paramInt2)
  {
    CmShowRscCacheManagerImpl.IdolRscItem localIdolRscItem;
    if (paramInt1 == 8) {
      localIdolRscItem = (CmShowRscCacheManagerImpl.IdolRscItem)this.mRoomRscMap.get(paramInt2);
    } else {
      localIdolRscItem = null;
    }
    if (localIdolRscItem == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("未获取资源getRscItem type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" id:");
      localStringBuilder.append(paramInt2);
      ApolloUtilImpl.showDebugTipsToast(localStringBuilder.toString());
    }
    return localIdolRscItem;
  }
  
  public void onRoomZipUpdated()
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_ApolloRscCacheManager", 2, "onRoomZipUpdated");
    }
    this.mRoomRscMap.clear();
    ThreadManager.executeOnSubThread(new CmShowRscCacheManagerImpl.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl
 * JD-Core Version:    0.7.0.1
 */