package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyEngineModule$4
  implements IFindRemovedEntity<ChannelInfo>
{
  ReadInJoyEngineModule$4(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, ChannelInfo paramChannelInfo)
  {
    paramEntityManager = null;
    if (this.a.a.tabbleIsExist(ChannelInfo.class.getSimpleName())) {
      paramEntityManager = this.a.a.find(ChannelInfo.class, "mChannelID = ?", new String[] { String.valueOf(paramChannelInfo.mChannelID) });
    }
    return paramEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.4
 * JD-Core Version:    0.7.0.1
 */