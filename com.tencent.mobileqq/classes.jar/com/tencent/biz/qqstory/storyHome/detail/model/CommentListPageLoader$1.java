package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import spd;
import sqg;
import ucc;
import ucf;
import uiv;
import urk;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((spd)sqg.a(17)).a(ucc.a(this.this$0).jdField_a_of_type_JavaLangString, ucc.a(this.this$0).a());
    ucf localucf = new ucf(new ErrorMessage(), ucc.a(this.this$0).jdField_a_of_type_JavaLangString, ucc.a(this.this$0).jdField_a_of_type_Int);
    localucf.d = false;
    localucf.jdField_b_of_type_Boolean = true;
    localucf.jdField_a_of_type_JavaUtilList = ((List)???);
    localucf.jdField_b_of_type_Int = -1;
    localucf.jdField_a_of_type_Boolean = true;
    localucf.jdField_a_of_type_Int = ucc.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        ucc.a(this.this$0, localucf);
        urk.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localucf);
        return;
      }
      urk.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */