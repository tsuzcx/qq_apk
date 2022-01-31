package com.tencent.biz.qqstory.storyHome.model;

import java.util.Comparator;

public class FeedIdListSeqInfo$HomeComp
  implements Comparator
{
  public int a(FeedIdListSeqInfo paramFeedIdListSeqInfo1, FeedIdListSeqInfo paramFeedIdListSeqInfo2)
  {
    if (paramFeedIdListSeqInfo1.jdField_a_of_type_Long == paramFeedIdListSeqInfo2.jdField_a_of_type_Long) {
      if (!paramFeedIdListSeqInfo1.jdField_a_of_type_Boolean) {}
    }
    while (paramFeedIdListSeqInfo1.jdField_a_of_type_Long > paramFeedIdListSeqInfo2.jdField_a_of_type_Long)
    {
      return -1;
      if (paramFeedIdListSeqInfo2.jdField_a_of_type_Boolean) {
        return 1;
      }
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo.HomeComp
 * JD-Core Version:    0.7.0.1
 */