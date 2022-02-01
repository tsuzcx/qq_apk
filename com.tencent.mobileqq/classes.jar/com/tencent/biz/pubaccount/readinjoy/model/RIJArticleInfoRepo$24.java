package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import java.util.List;
import pvj;
import qga;
import qyx;

public class RIJArticleInfoRepo$24
  implements Runnable
{
  public RIJArticleInfoRepo$24(qga paramqga, int paramInt1, List paramList, int paramInt2, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    qga.a(this.this$0, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (List localList = this.this$0.a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);; localList = this.jdField_a_of_type_JavaUtilList)
    {
      qyx.a(pvj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), localList));
      if (qga.a(this.this$0) != null) {
        break;
      }
      return;
    }
    qga.a(this.this$0).post(new RIJArticleInfoRepo.24.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.24
 * JD-Core Version:    0.7.0.1
 */