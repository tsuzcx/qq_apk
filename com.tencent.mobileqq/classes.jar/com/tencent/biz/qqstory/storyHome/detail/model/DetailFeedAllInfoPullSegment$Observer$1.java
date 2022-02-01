package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  DetailFeedAllInfoPullSegment$Observer$1(DetailFeedAllInfoPullSegment.Observer paramObserver, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.getFunctionResult(0);
      if (localObject != null) {
        DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).a()) {}
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
          localObject = (DetailFeedAllInfoPullSegment.LikeData)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.getFunctionResult(i);
          if (localObject != null)
          {
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).b(((DetailFeedAllInfoPullSegment.LikeData)localObject).jdField_a_of_type_JavaUtilList, true, ((DetailFeedAllInfoPullSegment.LikeData)localObject).jdField_a_of_type_Boolean);
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).b(((DetailFeedAllInfoPullSegment.LikeData)localObject).jdField_a_of_type_Boolean, ((DetailFeedAllInfoPullSegment.LikeData)localObject).jdField_a_of_type_Int);
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).a.mHadLike = ((DetailFeedAllInfoPullSegment.LikeData)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (DetailFeedAllInfoPullSegment.CommentData)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.getFunctionResult(m);
        if (localObject != null)
        {
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).a(((DetailFeedAllInfoPullSegment.CommentData)localObject).jdField_a_of_type_JavaUtilList, true, ((DetailFeedAllInfoPullSegment.CommentData)localObject).jdField_a_of_type_Boolean);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).a(((DetailFeedAllInfoPullSegment.CommentData)localObject).jdField_a_of_type_Boolean, ((DetailFeedAllInfoPullSegment.CommentData)localObject).jdField_a_of_type_Int);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).a(((DetailFeedAllInfoPullSegment.CommentData)localObject).jdField_a_of_type_Boolean, ((DetailFeedAllInfoPullSegment.CommentData)localObject).b);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a).a(((DetailFeedAllInfoPullSegment.CommentData)localObject).jdField_a_of_type_Boolean, ((DetailFeedAllInfoPullSegment.CommentData)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a, DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a));
      return;
    }
    DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPullSegment$Observer.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */