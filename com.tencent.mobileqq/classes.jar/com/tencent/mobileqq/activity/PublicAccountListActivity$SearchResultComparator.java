package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;
import thx;

public class PublicAccountListActivity$SearchResultComparator
  implements Comparator
{
  public PublicAccountListActivity$SearchResultComparator(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(thx paramthx1, thx paramthx2)
  {
    long l = paramthx1.a.certifiedGrade;
    return (int)(paramthx2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.SearchResultComparator
 * JD-Core Version:    0.7.0.1
 */