package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyEngineModule$7
  implements IFindRemovedEntity<ReadInJoyUserInfo>
{
  ReadInJoyEngineModule$7(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    paramEntityManager = null;
    if (this.a.a.tabbleIsExist(ReadInJoyUserInfo.class.getSimpleName())) {
      paramEntityManager = this.a.a.find(ReadInJoyUserInfo.class, "uin = ?", new String[] { paramReadInJoyUserInfo.uin });
    }
    return paramEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.7
 * JD-Core Version:    0.7.0.1
 */