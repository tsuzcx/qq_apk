package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;
import tex;

public class PublicAccountListActivity$SearchResultComparator
  implements Comparator
{
  public PublicAccountListActivity$SearchResultComparator(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(tex paramtex1, tex paramtex2)
  {
    long l = paramtex1.a.certifiedGrade;
    return (int)(paramtex2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.SearchResultComparator
 * JD-Core Version:    0.7.0.1
 */