package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.CollectionUtils.IPredicate;

class ReadInJoyLogicEngine$3
  implements CollectionUtils.IPredicate<TabChannelCoverInfo>
{
  ReadInJoyLogicEngine$3(ReadInJoyLogicEngine paramReadInJoyLogicEngine, int paramInt) {}
  
  public boolean a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    return paramTabChannelCoverInfo.mChannelCoverId == this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.3
 * JD-Core Version:    0.7.0.1
 */