package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import uux;
import uwa;
import whw;
import whz;
import wop;
import wxe;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((uux)uwa.a(17)).a(whw.a(this.this$0).jdField_a_of_type_JavaLangString, whw.a(this.this$0).a());
    whz localwhz = new whz(new ErrorMessage(), whw.a(this.this$0).jdField_a_of_type_JavaLangString, whw.a(this.this$0).jdField_a_of_type_Int);
    localwhz.d = false;
    localwhz.jdField_b_of_type_Boolean = true;
    localwhz.jdField_a_of_type_JavaUtilList = ((List)???);
    localwhz.jdField_b_of_type_Int = -1;
    localwhz.jdField_a_of_type_Boolean = true;
    localwhz.jdField_a_of_type_Int = whw.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        whw.a(this.this$0, localwhz);
        wxe.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localwhz);
        return;
      }
      wxe.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */