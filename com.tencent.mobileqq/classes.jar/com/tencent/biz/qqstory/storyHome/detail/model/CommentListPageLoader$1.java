package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import uqo;
import urr;
import wdn;
import wdq;
import wkg;
import wsv;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((uqo)urr.a(17)).a(wdn.a(this.this$0).jdField_a_of_type_JavaLangString, wdn.a(this.this$0).a());
    wdq localwdq = new wdq(new ErrorMessage(), wdn.a(this.this$0).jdField_a_of_type_JavaLangString, wdn.a(this.this$0).jdField_a_of_type_Int);
    localwdq.d = false;
    localwdq.jdField_b_of_type_Boolean = true;
    localwdq.jdField_a_of_type_JavaUtilList = ((List)???);
    localwdq.jdField_b_of_type_Int = -1;
    localwdq.jdField_a_of_type_Boolean = true;
    localwdq.jdField_a_of_type_Int = wdn.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        wdn.a(this.this$0, localwdq);
        wsv.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localwdq);
        return;
      }
      wsv.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */