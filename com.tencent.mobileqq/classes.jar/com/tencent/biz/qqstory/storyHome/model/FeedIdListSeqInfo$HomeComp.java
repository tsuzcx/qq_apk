package com.tencent.biz.qqstory.storyHome.model;

import java.util.Comparator;

public class FeedIdListSeqInfo$HomeComp
  implements Comparator<FeedIdListSeqInfo>
{
  public int a(FeedIdListSeqInfo paramFeedIdListSeqInfo1, FeedIdListSeqInfo paramFeedIdListSeqInfo2)
  {
    if (paramFeedIdListSeqInfo1.e == paramFeedIdListSeqInfo2.e)
    {
      if (paramFeedIdListSeqInfo1.g) {
        return -1;
      }
      if (paramFeedIdListSeqInfo2.g) {
        return 1;
      }
      return 0;
    }
    if (paramFeedIdListSeqInfo1.e > paramFeedIdListSeqInfo2.e) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo.HomeComp
 * JD-Core Version:    0.7.0.1
 */