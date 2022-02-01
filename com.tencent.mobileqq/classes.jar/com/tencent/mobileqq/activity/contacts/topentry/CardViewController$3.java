package com.tencent.mobileqq.activity.contacts.topentry;

import com.tencent.mobileqq.data.MayKnowRecommend;
import java.util.Comparator;

class CardViewController$3
  implements Comparator<MayKnowRecommend>
{
  CardViewController$3(CardViewController paramCardViewController) {}
  
  public int a(MayKnowRecommend paramMayKnowRecommend1, MayKnowRecommend paramMayKnowRecommend2)
  {
    long l1 = paramMayKnowRecommend1.cardDisplayTimestamp;
    long l2 = paramMayKnowRecommend2.cardDisplayTimestamp;
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CardViewController.3
 * JD-Core Version:    0.7.0.1
 */