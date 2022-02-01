package com.tencent.biz.qqstory.storyHome.model;

import java.util.Comparator;

public class FeedIdListSeqInfo$HomeComp
  implements Comparator<FeedIdListSeqInfo>
{
  public int a(FeedIdListSeqInfo paramFeedIdListSeqInfo1, FeedIdListSeqInfo paramFeedIdListSeqInfo2)
  {
    if (paramFeedIdListSeqInfo1.a == paramFeedIdListSeqInfo2.a) {
      if (!paramFeedIdListSeqInfo1.b) {}
    }
    while (paramFeedIdListSeqInfo1.a > paramFeedIdListSeqInfo2.a)
    {
      return -1;
      if (paramFeedIdListSeqInfo2.b) {
        return 1;
      }
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo.HomeComp
 * JD-Core Version:    0.7.0.1
 */