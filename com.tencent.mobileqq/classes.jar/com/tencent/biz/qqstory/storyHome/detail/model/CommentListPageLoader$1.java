package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import wip;
import wjs;
import xvi;
import xvl;
import ycb;
import ykq;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((wip)wjs.a(17)).a(xvi.a(this.this$0).jdField_a_of_type_JavaLangString, xvi.a(this.this$0).a());
    xvl localxvl = new xvl(new ErrorMessage(), xvi.a(this.this$0).jdField_a_of_type_JavaLangString, xvi.a(this.this$0).jdField_a_of_type_Int);
    localxvl.d = false;
    localxvl.jdField_b_of_type_Boolean = true;
    localxvl.jdField_a_of_type_JavaUtilList = ((List)???);
    localxvl.jdField_b_of_type_Int = -1;
    localxvl.jdField_a_of_type_Boolean = true;
    localxvl.jdField_a_of_type_Int = xvi.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        xvi.a(this.this$0, localxvl);
        ykq.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localxvl);
        return;
      }
      ykq.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */