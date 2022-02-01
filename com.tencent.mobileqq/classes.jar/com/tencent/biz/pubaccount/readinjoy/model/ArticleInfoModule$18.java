package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import java.util.List;
import pwb;

public class ArticleInfoModule$18
  implements Runnable
{
  public ArticleInfoModule$18(pwb parampwb, int paramInt1, List paramList, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2) {}
  
  public void run()
  {
    pwb.a(this.this$0, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (List localList = pwb.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean); this.this$0.a == null; localList = this.jdField_a_of_type_JavaUtilList) {
      return;
    }
    this.this$0.a.post(new ArticleInfoModule.18.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.18
 * JD-Core Version:    0.7.0.1
 */