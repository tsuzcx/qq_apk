package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class PublicAccountListActivity$SearchResultComparator
  implements Comparator<PublicAccountListActivity.InnerPAInfo>
{
  public PublicAccountListActivity$SearchResultComparator(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(PublicAccountListActivity.InnerPAInfo paramInnerPAInfo1, PublicAccountListActivity.InnerPAInfo paramInnerPAInfo2)
  {
    long l = paramInnerPAInfo1.a.certifiedGrade;
    return (int)(paramInnerPAInfo2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.SearchResultComparator
 * JD-Core Version:    0.7.0.1
 */