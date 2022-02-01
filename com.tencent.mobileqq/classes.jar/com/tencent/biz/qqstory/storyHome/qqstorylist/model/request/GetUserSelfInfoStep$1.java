package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import wta;
import wth;
import yoj;
import ypa;
import ypr;
import ypt;
import yuk;

public class GetUserSelfInfoStep$1
  implements Runnable
{
  public GetUserSelfInfoStep$1(ypr paramypr, ypt paramypt) {}
  
  public void run()
  {
    boolean bool = true;
    yuk.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self info: %s", this.a);
    Object localObject = ypr.a(this.this$0).a();
    if (this.a.jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      ((yoj)localObject).jdField_c_of_type_Boolean = bool;
      ypr.a(this.this$0).a().jdField_b_of_type_Int = this.a.jdField_c_of_type_Int;
      ypr.a(this.this$0).a().jdField_c_of_type_Int = this.a.jdField_d_of_type_Int;
      ypr.a(this.this$0).a().a = this.a.e;
      ypr.a(this.this$0).a().jdField_b_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
      ypr.a(this.this$0).a().jdField_c_of_type_JavaLangString = this.a.jdField_d_of_type_JavaLangString;
      ypr.a(this.this$0).a().jdField_d_of_type_JavaLangString = this.a.a;
      localObject = (wta)wth.a(10);
      ((wta)localObject).b("qqstory_my_fans_count", Integer.valueOf(this.a.jdField_c_of_type_Int));
      ((wta)localObject).b("qqstory_i_am_vip", Integer.valueOf(this.a.jdField_b_of_type_Int));
      ((wta)localObject).b("qqstory_my_vidoe_count", Integer.valueOf(this.a.jdField_d_of_type_Int));
      ((wta)localObject).b("qqstory_my_visiter_count", Integer.valueOf(this.a.e));
      ((wta)localObject).b("qqstory_my_newest_video_cover", this.a.jdField_c_of_type_JavaLangString);
      ((wta)localObject).b("qqstory_my_newest_video_vid", this.a.jdField_d_of_type_JavaLangString);
      QQStoryContext.a().a(this.a.a);
      this.this$0.d();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1
 * JD-Core Version:    0.7.0.1
 */