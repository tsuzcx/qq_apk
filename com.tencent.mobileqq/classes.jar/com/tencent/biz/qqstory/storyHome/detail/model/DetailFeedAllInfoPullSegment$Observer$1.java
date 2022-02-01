package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import yfh;
import yfi;
import yfj;
import yfk;
import yfw;
import yuk;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(yfk paramyfk, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (yfh.a(this.jdField_a_of_type_Yfk.a).isJobCancelled())
    {
      yuk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Yfk.getFunctionResult(0);
      if (localObject != null) {
        yfh.a(this.jdField_a_of_type_Yfk.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (yfh.a(this.jdField_a_of_type_Yfk.a).a()) {}
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
          localObject = (yfj)this.jdField_a_of_type_Yfk.getFunctionResult(i);
          if (localObject != null)
          {
            yfh.a(this.jdField_a_of_type_Yfk.a).b(((yfj)localObject).jdField_a_of_type_JavaUtilList, true, ((yfj)localObject).jdField_a_of_type_Boolean);
            yfh.a(this.jdField_a_of_type_Yfk.a).b(((yfj)localObject).jdField_a_of_type_Boolean, ((yfj)localObject).jdField_a_of_type_Int);
            yfh.a(this.jdField_a_of_type_Yfk.a).a.mHadLike = ((yfj)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (yfi)this.jdField_a_of_type_Yfk.getFunctionResult(m);
        if (localObject != null)
        {
          yfh.a(this.jdField_a_of_type_Yfk.a).a(((yfi)localObject).jdField_a_of_type_JavaUtilList, true, ((yfi)localObject).jdField_a_of_type_Boolean);
          yfh.a(this.jdField_a_of_type_Yfk.a).a(((yfi)localObject).jdField_a_of_type_Boolean, ((yfi)localObject).jdField_a_of_type_Int);
          yfh.a(this.jdField_a_of_type_Yfk.a).a(((yfi)localObject).jdField_a_of_type_Boolean, ((yfi)localObject).b);
          yfh.a(this.jdField_a_of_type_Yfk.a).a(((yfi)localObject).jdField_a_of_type_Boolean, ((yfi)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      yfh.a(this.jdField_a_of_type_Yfk.a, yfh.a(this.jdField_a_of_type_Yfk.a));
      return;
    }
    yfh.a(this.jdField_a_of_type_Yfk.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */