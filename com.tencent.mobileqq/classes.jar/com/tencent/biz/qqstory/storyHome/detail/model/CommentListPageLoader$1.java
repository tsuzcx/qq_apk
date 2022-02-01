package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import woj;
import wpm;
import ybh;
import ybk;
import yia;
import yqp;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((woj)wpm.a(17)).a(ybh.a(this.this$0).jdField_a_of_type_JavaLangString, ybh.a(this.this$0).a());
    ybk localybk = new ybk(new ErrorMessage(), ybh.a(this.this$0).jdField_a_of_type_JavaLangString, ybh.a(this.this$0).jdField_a_of_type_Int);
    localybk.d = false;
    localybk.jdField_b_of_type_Boolean = true;
    localybk.jdField_a_of_type_JavaUtilList = ((List)???);
    localybk.jdField_b_of_type_Int = -1;
    localybk.jdField_a_of_type_Boolean = true;
    localybk.jdField_a_of_type_Int = ybh.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        ybh.a(this.this$0, localybk);
        yqp.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localybk);
        return;
      }
      yqp.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */