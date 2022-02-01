package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyEngineModule$6
  implements IFindRemovedEntity<ChannelCoverInfo>
{
  ReadInJoyEngineModule$6(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, ChannelCoverInfo paramChannelCoverInfo)
  {
    paramEntityManager = null;
    if (this.a.a.tabbleIsExist(ChannelCoverInfo.class.getSimpleName())) {
      paramEntityManager = this.a.a.find(ChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramChannelCoverInfo.mChannelCoverId) });
    }
    return paramEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.6
 * JD-Core Version:    0.7.0.1
 */