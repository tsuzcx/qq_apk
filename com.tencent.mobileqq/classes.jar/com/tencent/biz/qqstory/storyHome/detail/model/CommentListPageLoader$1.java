package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import tbz;
import tdc;
import uoy;
import upb;
import uvr;
import veg;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((tbz)tdc.a(17)).a(uoy.a(this.this$0).jdField_a_of_type_JavaLangString, uoy.a(this.this$0).a());
    upb localupb = new upb(new ErrorMessage(), uoy.a(this.this$0).jdField_a_of_type_JavaLangString, uoy.a(this.this$0).jdField_a_of_type_Int);
    localupb.d = false;
    localupb.jdField_b_of_type_Boolean = true;
    localupb.jdField_a_of_type_JavaUtilList = ((List)???);
    localupb.jdField_b_of_type_Int = -1;
    localupb.jdField_a_of_type_Boolean = true;
    localupb.jdField_a_of_type_Int = uoy.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        uoy.a(this.this$0, localupb);
        veg.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localupb);
        return;
      }
      veg.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */