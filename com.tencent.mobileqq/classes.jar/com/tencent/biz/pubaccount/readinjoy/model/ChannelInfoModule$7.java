package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import java.util.Comparator;

class ChannelInfoModule$7
  implements Comparator<ChannelInfo>
{
  ChannelInfoModule$7(ChannelInfoModule paramChannelInfoModule) {}
  
  public int a(ChannelInfo paramChannelInfo1, ChannelInfo paramChannelInfo2)
  {
    if (paramChannelInfo1.mSortOrder == paramChannelInfo2.mSortOrder) {
      return 0;
    }
    if (paramChannelInfo1.mSortOrder < paramChannelInfo2.mSortOrder) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.7
 * JD-Core Version:    0.7.0.1
 */