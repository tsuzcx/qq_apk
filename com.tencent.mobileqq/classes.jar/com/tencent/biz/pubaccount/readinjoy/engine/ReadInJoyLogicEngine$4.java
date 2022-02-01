package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.CollectionUtils.IPredicate;

class ReadInJoyLogicEngine$4
  implements CollectionUtils.IPredicate<TabChannelCoverInfo>
{
  ReadInJoyLogicEngine$4(ReadInJoyLogicEngine paramReadInJoyLogicEngine) {}
  
  public boolean a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    return (paramTabChannelCoverInfo != null) && (paramTabChannelCoverInfo.reason != 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.4
 * JD-Core Version:    0.7.0.1
 */