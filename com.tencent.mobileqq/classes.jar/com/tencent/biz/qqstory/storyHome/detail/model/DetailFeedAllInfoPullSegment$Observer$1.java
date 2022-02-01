package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import xvn;
import xvo;
import xvp;
import xvq;
import xwc;
import ykq;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(xvq paramxvq, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (xvn.a(this.jdField_a_of_type_Xvq.a).isJobCancelled())
    {
      ykq.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Xvq.getFunctionResult(0);
      if (localObject != null) {
        xvn.a(this.jdField_a_of_type_Xvq.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (xvn.a(this.jdField_a_of_type_Xvq.a).a()) {}
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
          localObject = (xvp)this.jdField_a_of_type_Xvq.getFunctionResult(i);
          if (localObject != null)
          {
            xvn.a(this.jdField_a_of_type_Xvq.a).b(((xvp)localObject).jdField_a_of_type_JavaUtilList, true, ((xvp)localObject).jdField_a_of_type_Boolean);
            xvn.a(this.jdField_a_of_type_Xvq.a).b(((xvp)localObject).jdField_a_of_type_Boolean, ((xvp)localObject).jdField_a_of_type_Int);
            xvn.a(this.jdField_a_of_type_Xvq.a).a.mHadLike = ((xvp)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (xvo)this.jdField_a_of_type_Xvq.getFunctionResult(m);
        if (localObject != null)
        {
          xvn.a(this.jdField_a_of_type_Xvq.a).a(((xvo)localObject).jdField_a_of_type_JavaUtilList, true, ((xvo)localObject).jdField_a_of_type_Boolean);
          xvn.a(this.jdField_a_of_type_Xvq.a).a(((xvo)localObject).jdField_a_of_type_Boolean, ((xvo)localObject).jdField_a_of_type_Int);
          xvn.a(this.jdField_a_of_type_Xvq.a).a(((xvo)localObject).jdField_a_of_type_Boolean, ((xvo)localObject).b);
          xvn.a(this.jdField_a_of_type_Xvq.a).a(((xvo)localObject).jdField_a_of_type_Boolean, ((xvo)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      xvn.a(this.jdField_a_of_type_Xvq.a, xvn.a(this.jdField_a_of_type_Xvq.a));
      return;
    }
    xvn.a(this.jdField_a_of_type_Xvq.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */