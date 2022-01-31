package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import upd;
import upe;
import upf;
import upg;
import ups;
import veg;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(upg paramupg, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (upd.a(this.jdField_a_of_type_Upg.a).isJobCancelled())
    {
      veg.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Upg.getFunctionResult(0);
      if (localObject != null) {
        upd.a(this.jdField_a_of_type_Upg.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (upd.a(this.jdField_a_of_type_Upg.a).a()) {}
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
          localObject = (upf)this.jdField_a_of_type_Upg.getFunctionResult(i);
          if (localObject != null)
          {
            upd.a(this.jdField_a_of_type_Upg.a).b(((upf)localObject).jdField_a_of_type_JavaUtilList, true, ((upf)localObject).jdField_a_of_type_Boolean);
            upd.a(this.jdField_a_of_type_Upg.a).b(((upf)localObject).jdField_a_of_type_Boolean, ((upf)localObject).jdField_a_of_type_Int);
            upd.a(this.jdField_a_of_type_Upg.a).a.mHadLike = ((upf)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (upe)this.jdField_a_of_type_Upg.getFunctionResult(m);
        if (localObject != null)
        {
          upd.a(this.jdField_a_of_type_Upg.a).a(((upe)localObject).jdField_a_of_type_JavaUtilList, true, ((upe)localObject).jdField_a_of_type_Boolean);
          upd.a(this.jdField_a_of_type_Upg.a).a(((upe)localObject).jdField_a_of_type_Boolean, ((upe)localObject).jdField_a_of_type_Int);
          upd.a(this.jdField_a_of_type_Upg.a).a(((upe)localObject).jdField_a_of_type_Boolean, ((upe)localObject).b);
          upd.a(this.jdField_a_of_type_Upg.a).a(((upe)localObject).jdField_a_of_type_Boolean, ((upe)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      upd.a(this.jdField_a_of_type_Upg.a, upd.a(this.jdField_a_of_type_Upg.a));
      return;
    }
    upd.a(this.jdField_a_of_type_Upg.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */