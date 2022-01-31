package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import uch;
import uci;
import ucj;
import uck;
import ucw;
import urk;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(uck paramuck, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (uch.a(this.jdField_a_of_type_Uck.a).isJobCancelled())
    {
      urk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Uck.getFunctionResult(0);
      if (localObject != null) {
        uch.a(this.jdField_a_of_type_Uck.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (uch.a(this.jdField_a_of_type_Uck.a).a()) {}
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
          localObject = (ucj)this.jdField_a_of_type_Uck.getFunctionResult(i);
          if (localObject != null)
          {
            uch.a(this.jdField_a_of_type_Uck.a).b(((ucj)localObject).jdField_a_of_type_JavaUtilList, true, ((ucj)localObject).jdField_a_of_type_Boolean);
            uch.a(this.jdField_a_of_type_Uck.a).b(((ucj)localObject).jdField_a_of_type_Boolean, ((ucj)localObject).jdField_a_of_type_Int);
            uch.a(this.jdField_a_of_type_Uck.a).a.mHadLike = ((ucj)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (uci)this.jdField_a_of_type_Uck.getFunctionResult(m);
        if (localObject != null)
        {
          uch.a(this.jdField_a_of_type_Uck.a).a(((uci)localObject).jdField_a_of_type_JavaUtilList, true, ((uci)localObject).jdField_a_of_type_Boolean);
          uch.a(this.jdField_a_of_type_Uck.a).a(((uci)localObject).jdField_a_of_type_Boolean, ((uci)localObject).jdField_a_of_type_Int);
          uch.a(this.jdField_a_of_type_Uck.a).a(((uci)localObject).jdField_a_of_type_Boolean, ((uci)localObject).b);
          uch.a(this.jdField_a_of_type_Uck.a).a(((uci)localObject).jdField_a_of_type_Boolean, ((uci)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      uch.a(this.jdField_a_of_type_Uck.a, uch.a(this.jdField_a_of_type_Uck.a));
      return;
    }
    uch.a(this.jdField_a_of_type_Uck.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */