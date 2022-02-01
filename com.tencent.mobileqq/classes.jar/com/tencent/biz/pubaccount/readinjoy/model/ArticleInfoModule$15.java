package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import java.util.List;
import pmh;
import pwb;
import qof;

public class ArticleInfoModule$15
  implements Runnable
{
  public ArticleInfoModule$15(pwb parampwb, int paramInt1, List paramList, int paramInt2, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    pwb.a(this.this$0, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (List localList = pwb.a(this.this$0, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);; localList = this.jdField_a_of_type_JavaUtilList)
    {
      qof.a(pmh.a().a(Integer.valueOf(this.jdField_a_of_type_Int), localList));
      if (this.this$0.a != null) {
        break;
      }
      return;
    }
    this.this$0.a.post(new ArticleInfoModule.15.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.15
 * JD-Core Version:    0.7.0.1
 */