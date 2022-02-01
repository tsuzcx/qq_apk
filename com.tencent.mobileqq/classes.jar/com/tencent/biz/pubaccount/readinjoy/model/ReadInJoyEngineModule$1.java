package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyEngineModule$1
  implements IFindRemovedEntity<AdvertisementInfo>
{
  ReadInJoyEngineModule$1(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, AdvertisementInfo paramAdvertisementInfo)
  {
    Object localObject = null;
    paramEntityManager = localObject;
    if (this.a.a.tabbleIsExist(AdvertisementInfo.class.getSimpleName()))
    {
      paramEntityManager = localObject;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdTraceId)) {
        paramEntityManager = this.a.a.find(AdvertisementInfo.class, "mAdTraceId = ?", new String[] { paramAdvertisementInfo.mAdTraceId });
      }
    }
    return paramEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.1
 * JD-Core Version:    0.7.0.1
 */