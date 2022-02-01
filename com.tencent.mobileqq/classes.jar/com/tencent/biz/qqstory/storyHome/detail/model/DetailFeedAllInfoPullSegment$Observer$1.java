package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import ybm;
import ybn;
import ybo;
import ybp;
import ycb;
import yqp;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(ybp paramybp, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (ybm.a(this.jdField_a_of_type_Ybp.a).isJobCancelled())
    {
      yqp.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Ybp.getFunctionResult(0);
      if (localObject != null) {
        ybm.a(this.jdField_a_of_type_Ybp.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (ybm.a(this.jdField_a_of_type_Ybp.a).a()) {}
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
          localObject = (ybo)this.jdField_a_of_type_Ybp.getFunctionResult(i);
          if (localObject != null)
          {
            ybm.a(this.jdField_a_of_type_Ybp.a).b(((ybo)localObject).jdField_a_of_type_JavaUtilList, true, ((ybo)localObject).jdField_a_of_type_Boolean);
            ybm.a(this.jdField_a_of_type_Ybp.a).b(((ybo)localObject).jdField_a_of_type_Boolean, ((ybo)localObject).jdField_a_of_type_Int);
            ybm.a(this.jdField_a_of_type_Ybp.a).a.mHadLike = ((ybo)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (ybn)this.jdField_a_of_type_Ybp.getFunctionResult(m);
        if (localObject != null)
        {
          ybm.a(this.jdField_a_of_type_Ybp.a).a(((ybn)localObject).jdField_a_of_type_JavaUtilList, true, ((ybn)localObject).jdField_a_of_type_Boolean);
          ybm.a(this.jdField_a_of_type_Ybp.a).a(((ybn)localObject).jdField_a_of_type_Boolean, ((ybn)localObject).jdField_a_of_type_Int);
          ybm.a(this.jdField_a_of_type_Ybp.a).a(((ybn)localObject).jdField_a_of_type_Boolean, ((ybn)localObject).b);
          ybm.a(this.jdField_a_of_type_Ybp.a).a(((ybn)localObject).jdField_a_of_type_Boolean, ((ybn)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      ybm.a(this.jdField_a_of_type_Ybp.a, ybm.a(this.jdField_a_of_type_Ybp.a));
      return;
    }
    ybm.a(this.jdField_a_of_type_Ybp.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */