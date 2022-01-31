package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import uvt;
import uwa;
import wrd;
import wru;
import wsl;
import wsn;
import wxe;

public class GetUserSelfInfoStep$1
  implements Runnable
{
  public GetUserSelfInfoStep$1(wsl paramwsl, wsn paramwsn) {}
  
  public void run()
  {
    boolean bool = true;
    wxe.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self info: %s", this.a);
    Object localObject = wsl.a(this.this$0).a();
    if (this.a.jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      ((wrd)localObject).jdField_c_of_type_Boolean = bool;
      wsl.a(this.this$0).a().jdField_b_of_type_Int = this.a.jdField_c_of_type_Int;
      wsl.a(this.this$0).a().jdField_c_of_type_Int = this.a.jdField_d_of_type_Int;
      wsl.a(this.this$0).a().a = this.a.e;
      wsl.a(this.this$0).a().jdField_b_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
      wsl.a(this.this$0).a().jdField_c_of_type_JavaLangString = this.a.jdField_d_of_type_JavaLangString;
      wsl.a(this.this$0).a().jdField_d_of_type_JavaLangString = this.a.a;
      localObject = (uvt)uwa.a(10);
      ((uvt)localObject).b("qqstory_my_fans_count", Integer.valueOf(this.a.jdField_c_of_type_Int));
      ((uvt)localObject).b("qqstory_i_am_vip", Integer.valueOf(this.a.jdField_b_of_type_Int));
      ((uvt)localObject).b("qqstory_my_vidoe_count", Integer.valueOf(this.a.jdField_d_of_type_Int));
      ((uvt)localObject).b("qqstory_my_visiter_count", Integer.valueOf(this.a.e));
      ((uvt)localObject).b("qqstory_my_newest_video_cover", this.a.jdField_c_of_type_JavaLangString);
      ((uvt)localObject).b("qqstory_my_newest_video_vid", this.a.jdField_d_of_type_JavaLangString);
      QQStoryContext.a().a(this.a.a);
      this.this$0.d();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1
 * JD-Core Version:    0.7.0.1
 */