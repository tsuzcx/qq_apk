package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import wib;
import wic;
import wid;
import wie;
import wiq;
import wxe;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(wie paramwie, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (wib.a(this.jdField_a_of_type_Wie.a).isJobCancelled())
    {
      wxe.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Wie.getFunctionResult(0);
      if (localObject != null) {
        wib.a(this.jdField_a_of_type_Wie.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (wib.a(this.jdField_a_of_type_Wie.a).a()) {}
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
          localObject = (wid)this.jdField_a_of_type_Wie.getFunctionResult(i);
          if (localObject != null)
          {
            wib.a(this.jdField_a_of_type_Wie.a).b(((wid)localObject).jdField_a_of_type_JavaUtilList, true, ((wid)localObject).jdField_a_of_type_Boolean);
            wib.a(this.jdField_a_of_type_Wie.a).b(((wid)localObject).jdField_a_of_type_Boolean, ((wid)localObject).jdField_a_of_type_Int);
            wib.a(this.jdField_a_of_type_Wie.a).a.mHadLike = ((wid)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (wic)this.jdField_a_of_type_Wie.getFunctionResult(m);
        if (localObject != null)
        {
          wib.a(this.jdField_a_of_type_Wie.a).a(((wic)localObject).jdField_a_of_type_JavaUtilList, true, ((wic)localObject).jdField_a_of_type_Boolean);
          wib.a(this.jdField_a_of_type_Wie.a).a(((wic)localObject).jdField_a_of_type_Boolean, ((wic)localObject).jdField_a_of_type_Int);
          wib.a(this.jdField_a_of_type_Wie.a).a(((wic)localObject).jdField_a_of_type_Boolean, ((wic)localObject).b);
          wib.a(this.jdField_a_of_type_Wie.a).a(((wic)localObject).jdField_a_of_type_Boolean, ((wic)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      wib.a(this.jdField_a_of_type_Wie.a, wib.a(this.jdField_a_of_type_Wie.a));
      return;
    }
    wib.a(this.jdField_a_of_type_Wie.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */