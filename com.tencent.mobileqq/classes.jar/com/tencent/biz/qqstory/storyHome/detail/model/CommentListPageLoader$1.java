package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import wse;
import wth;
import yfc;
import yff;
import ylv;
import yuk;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((wse)wth.a(17)).a(yfc.a(this.this$0).jdField_a_of_type_JavaLangString, yfc.a(this.this$0).a());
    yff localyff = new yff(new ErrorMessage(), yfc.a(this.this$0).jdField_a_of_type_JavaLangString, yfc.a(this.this$0).jdField_a_of_type_Int);
    localyff.d = false;
    localyff.jdField_b_of_type_Boolean = true;
    localyff.jdField_a_of_type_JavaUtilList = ((List)???);
    localyff.jdField_b_of_type_Int = -1;
    localyff.jdField_a_of_type_Boolean = true;
    localyff.jdField_a_of_type_Int = yfc.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        yfc.a(this.this$0, localyff);
        yuk.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localyff);
        return;
      }
      yuk.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */