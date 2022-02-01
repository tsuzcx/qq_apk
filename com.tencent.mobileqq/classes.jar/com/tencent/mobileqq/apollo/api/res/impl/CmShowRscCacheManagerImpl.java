package com.tencent.mobileqq.apollo.api.res.impl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.api.res.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
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
    ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject1).jdField_a_of_type_Int = 100;
    ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject1).jdField_a_of_type_Long = 1L;
    ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject1).jdField_a_of_type_JavaLangString = "all_room3D";
    localObject1 = ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject1).b() + "all_room3D.json";
    Object localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists()) {
      try
      {
        localObject2 = new JSONObject(FileUtils.b((File)localObject2)).optJSONObject("data");
        if (localObject2 != null)
        {
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
                  localIdolRscItem.c = "all_room3D.json";
                  localIdolRscItem.jdField_b_of_type_JavaLangString = ((String)localObject1);
                  localIdolRscItem.jdField_b_of_type_Int = i;
                  localIdolRscItem.jdField_a_of_type_Int = 8;
                  localIdolRscItem.jdField_a_of_type_JavaLangString = ((String)localObject3);
                  this.mRoomRscMap.put(i, localIdolRscItem);
                }
              }
            }
          }
        }
        ApolloUtilImpl.showDebugTipsToast("小窝json不存在");
      }
      catch (Exception localException)
      {
        QLog.e("rscContent_ApolloRscCacheManager", 1, "initRoomJson e:", localException);
        if (QLog.isColorLevel()) {
          QLog.d("rscContent_ApolloRscCacheManager", 2, "initRoomJson mRoomRscMap:" + this.mRoomRscMap);
        }
        return;
      }
    }
    QLog.e("rscContent_ApolloRscCacheManager", 1, "initRoomJson file is no exsit path:" + localException);
  }
  
  public CmShowRscCacheManagerImpl.IdolRscItem getRscItem(int paramInt1, int paramInt2)
  {
    CmShowRscCacheManagerImpl.IdolRscItem localIdolRscItem = null;
    if (paramInt1 == 8) {
      localIdolRscItem = (CmShowRscCacheManagerImpl.IdolRscItem)this.mRoomRscMap.get(paramInt2);
    }
    if (localIdolRscItem == null) {
      ApolloUtilImpl.showDebugTipsToast("未获取资源getRscItem type:" + paramInt1 + " id:" + paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.CmShowRscCacheManagerImpl
 * JD-Core Version:    0.7.0.1
 */