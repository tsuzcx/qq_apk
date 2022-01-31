package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import upa;
import upb;
import upc;
import upd;
import upp;
import ved;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(upd paramupd, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (upa.a(this.jdField_a_of_type_Upd.a).isJobCancelled())
    {
      ved.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Upd.getFunctionResult(0);
      if (localObject != null) {
        upa.a(this.jdField_a_of_type_Upd.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (upa.a(this.jdField_a_of_type_Upd.a).a()) {}
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
          localObject = (upc)this.jdField_a_of_type_Upd.getFunctionResult(i);
          if (localObject != null)
          {
            upa.a(this.jdField_a_of_type_Upd.a).b(((upc)localObject).jdField_a_of_type_JavaUtilList, true, ((upc)localObject).jdField_a_of_type_Boolean);
            upa.a(this.jdField_a_of_type_Upd.a).b(((upc)localObject).jdField_a_of_type_Boolean, ((upc)localObject).jdField_a_of_type_Int);
            upa.a(this.jdField_a_of_type_Upd.a).a.mHadLike = ((upc)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (upb)this.jdField_a_of_type_Upd.getFunctionResult(m);
        if (localObject != null)
        {
          upa.a(this.jdField_a_of_type_Upd.a).a(((upb)localObject).jdField_a_of_type_JavaUtilList, true, ((upb)localObject).jdField_a_of_type_Boolean);
          upa.a(this.jdField_a_of_type_Upd.a).a(((upb)localObject).jdField_a_of_type_Boolean, ((upb)localObject).jdField_a_of_type_Int);
          upa.a(this.jdField_a_of_type_Upd.a).a(((upb)localObject).jdField_a_of_type_Boolean, ((upb)localObject).b);
          upa.a(this.jdField_a_of_type_Upd.a).a(((upb)localObject).jdField_a_of_type_Boolean, ((upb)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      upa.a(this.jdField_a_of_type_Upd.a, upa.a(this.jdField_a_of_type_Upd.a));
      return;
    }
    upa.a(this.jdField_a_of_type_Upd.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */