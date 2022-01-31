package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import tbw;
import tcz;
import uov;
import uoy;
import uvo;
import ved;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((tbw)tcz.a(17)).a(uov.a(this.this$0).jdField_a_of_type_JavaLangString, uov.a(this.this$0).a());
    uoy localuoy = new uoy(new ErrorMessage(), uov.a(this.this$0).jdField_a_of_type_JavaLangString, uov.a(this.this$0).jdField_a_of_type_Int);
    localuoy.d = false;
    localuoy.jdField_b_of_type_Boolean = true;
    localuoy.jdField_a_of_type_JavaUtilList = ((List)???);
    localuoy.jdField_b_of_type_Int = -1;
    localuoy.jdField_a_of_type_Boolean = true;
    localuoy.jdField_a_of_type_Int = uov.a(this.this$0).jdField_b_of_type_Int;
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        uov.a(this.this$0, localuoy);
        ved.a("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localuoy);
        return;
      }
      ved.d("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */