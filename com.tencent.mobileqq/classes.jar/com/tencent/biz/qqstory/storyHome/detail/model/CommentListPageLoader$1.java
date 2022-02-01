package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import vtu;
import vux;
import xgn;
import xgq;
import xng;
import xvv;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((vtu)vux.a(17)).a(xgn.a(this.this$0).jdField_a_of_type_JavaLangString, xgn.a(this.this$0).a());
    xgq localxgq = new xgq(new ErrorMessage(), xgn.a(this.this$0).jdField_a_of_type_JavaLangString, xgn.a(this.this$0).jdField_a_of_type_Int);
    localxgq.d = false;
    localxgq.jdField_b_of_type_Boolean = true;
    localxgq.jdField_a_of_type_JavaUtilList = ((List)???);
    localxgq.jdField_b_of_type_Int = -1;
    localxgq.jdField_a_of_type_Boolean = true;
    localxgq.jdField_a_of_type_Int = xgn.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        xgn.a(this.this$0, localxgq);
        xvv.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localxgq);
        return;
      }
      xvv.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */