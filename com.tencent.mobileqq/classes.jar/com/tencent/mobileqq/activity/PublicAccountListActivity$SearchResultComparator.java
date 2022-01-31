package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;
import tmr;

public class PublicAccountListActivity$SearchResultComparator
  implements Comparator
{
  public PublicAccountListActivity$SearchResultComparator(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(tmr paramtmr1, tmr paramtmr2)
  {
    long l = paramtmr1.a.certifiedGrade;
    return (int)(paramtmr2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.SearchResultComparator
 * JD-Core Version:    0.7.0.1
 */