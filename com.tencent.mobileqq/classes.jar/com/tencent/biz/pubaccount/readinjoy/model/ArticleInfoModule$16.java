package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import java.util.List;
import ozo;

public class ArticleInfoModule$16
  implements Runnable
{
  public ArticleInfoModule$16(ozo paramozo, int paramInt1, List paramList, int paramInt2, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    ozo.a(this.this$0, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (List localList = ozo.a(this.this$0, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean); this.this$0.a == null; localList = this.jdField_a_of_type_JavaUtilList) {
      return;
    }
    this.this$0.a.post(new ArticleInfoModule.16.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.16
 * JD-Core Version:    0.7.0.1
 */