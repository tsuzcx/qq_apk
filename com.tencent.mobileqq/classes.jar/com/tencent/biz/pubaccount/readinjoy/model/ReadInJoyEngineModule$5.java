package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyEngineModule$5
  implements IFindRemovedEntity<TabChannelCoverInfo>
{
  ReadInJoyEngineModule$5(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    paramEntityManager = null;
    if (this.a.a.tabbleIsExist(TabChannelCoverInfo.class.getSimpleName())) {
      paramEntityManager = this.a.a.find(TabChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
    }
    return paramEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.5
 * JD-Core Version:    0.7.0.1
 */