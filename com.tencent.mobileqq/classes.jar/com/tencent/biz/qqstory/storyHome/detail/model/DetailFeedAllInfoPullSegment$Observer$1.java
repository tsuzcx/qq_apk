package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import xgs;
import xgt;
import xgu;
import xgv;
import xhh;
import xvv;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(xgv paramxgv, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (xgs.a(this.jdField_a_of_type_Xgv.a).isJobCancelled())
    {
      xvv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Xgv.getFunctionResult(0);
      if (localObject != null) {
        xgs.a(this.jdField_a_of_type_Xgv.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (xgs.a(this.jdField_a_of_type_Xgv.a).a()) {}
      int m;
      int n;
      for (int j = 2;; j = 1)
      {
        int k = 0;
        int i = 1;
        for (;;)
        {
          m = i;
          n = i1;
          if (k >= j) {
            break;
          }
          localObject = (xgu)this.jdField_a_of_type_Xgv.getFunctionResult(i);
          if (localObject != null)
          {
            xgs.a(this.jdField_a_of_type_Xgv.a).b(((xgu)localObject).jdField_a_of_type_JavaUtilList, true, ((xgu)localObject).jdField_a_of_type_Boolean);
            xgs.a(this.jdField_a_of_type_Xgv.a).b(((xgu)localObject).jdField_a_of_type_Boolean, ((xgu)localObject).jdField_a_of_type_Int);
            xgs.a(this.jdField_a_of_type_Xgv.a).a.mHadLike = ((xgu)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (xgt)this.jdField_a_of_type_Xgv.getFunctionResult(m);
        if (localObject != null)
        {
          xgs.a(this.jdField_a_of_type_Xgv.a).a(((xgt)localObject).jdField_a_of_type_JavaUtilList, true, ((xgt)localObject).jdField_a_of_type_Boolean);
          xgs.a(this.jdField_a_of_type_Xgv.a).a(((xgt)localObject).jdField_a_of_type_Boolean, ((xgt)localObject).jdField_a_of_type_Int);
          xgs.a(this.jdField_a_of_type_Xgv.a).a(((xgt)localObject).jdField_a_of_type_Boolean, ((xgt)localObject).b);
          xgs.a(this.jdField_a_of_type_Xgv.a).a(((xgt)localObject).jdField_a_of_type_Boolean, ((xgt)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      xgs.a(this.jdField_a_of_type_Xgv.a, xgs.a(this.jdField_a_of_type_Xgv.a));
      return;
    }
    xgs.a(this.jdField_a_of_type_Xgv.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */