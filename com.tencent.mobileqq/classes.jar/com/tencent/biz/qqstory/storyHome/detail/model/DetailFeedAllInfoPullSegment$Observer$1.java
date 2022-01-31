package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import wds;
import wdt;
import wdu;
import wdv;
import weh;
import wsv;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(wdv paramwdv, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (wds.a(this.jdField_a_of_type_Wdv.a).isJobCancelled())
    {
      wsv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Wdv.getFunctionResult(0);
      if (localObject != null) {
        wds.a(this.jdField_a_of_type_Wdv.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (wds.a(this.jdField_a_of_type_Wdv.a).a()) {}
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
          localObject = (wdu)this.jdField_a_of_type_Wdv.getFunctionResult(i);
          if (localObject != null)
          {
            wds.a(this.jdField_a_of_type_Wdv.a).b(((wdu)localObject).jdField_a_of_type_JavaUtilList, true, ((wdu)localObject).jdField_a_of_type_Boolean);
            wds.a(this.jdField_a_of_type_Wdv.a).b(((wdu)localObject).jdField_a_of_type_Boolean, ((wdu)localObject).jdField_a_of_type_Int);
            wds.a(this.jdField_a_of_type_Wdv.a).a.mHadLike = ((wdu)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (wdt)this.jdField_a_of_type_Wdv.getFunctionResult(m);
        if (localObject != null)
        {
          wds.a(this.jdField_a_of_type_Wdv.a).a(((wdt)localObject).jdField_a_of_type_JavaUtilList, true, ((wdt)localObject).jdField_a_of_type_Boolean);
          wds.a(this.jdField_a_of_type_Wdv.a).a(((wdt)localObject).jdField_a_of_type_Boolean, ((wdt)localObject).jdField_a_of_type_Int);
          wds.a(this.jdField_a_of_type_Wdv.a).a(((wdt)localObject).jdField_a_of_type_Boolean, ((wdt)localObject).b);
          wds.a(this.jdField_a_of_type_Wdv.a).a(((wdt)localObject).jdField_a_of_type_Boolean, ((wdt)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      wds.a(this.jdField_a_of_type_Wdv.a, wds.a(this.jdField_a_of_type_Wdv.a));
      return;
    }
    wds.a(this.jdField_a_of_type_Wdv.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */