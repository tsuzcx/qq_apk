package com.tencent.biz.pubaccount.readinjoy.feedsinsert;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import pwt;
import szd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJFeedsInsertController$insertArticleInfo$1
  implements Runnable
{
  public RIJFeedsInsertController$insertArticleInfo$1(szd paramszd, List paramList) {}
  
  public final void run()
  {
    List localList = pwt.a.a(this.jdField_a_of_type_Szd, this.jdField_a_of_type_JavaUtilList);
    if (localList.size() != this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_Szd.a(localList);
      this.jdField_a_of_type_Szd.notifyDataSetChanged();
      return;
    }
    QLog.i("RIJFeedsInsertController", 1, "[insertArticleInfo] no need to insert.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController.insertArticleInfo.1
 * JD-Core Version:    0.7.0.1
 */