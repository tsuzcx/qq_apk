package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;

class GetUserSelfInfoStep$1
  implements Runnable
{
  GetUserSelfInfoStep$1(GetUserSelfInfoStep paramGetUserSelfInfoStep, GetUserSelfInfoStep.Response paramResponse) {}
  
  public void run()
  {
    boolean bool = true;
    SLog.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self info: %s", this.a);
    Object localObject = GetUserSelfInfoStep.a(this.this$0).a();
    if (this.a.jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      ((MyStorys)localObject).jdField_c_of_type_Boolean = bool;
      GetUserSelfInfoStep.a(this.this$0).a().jdField_b_of_type_Int = this.a.jdField_c_of_type_Int;
      GetUserSelfInfoStep.a(this.this$0).a().jdField_c_of_type_Int = this.a.jdField_d_of_type_Int;
      GetUserSelfInfoStep.a(this.this$0).a().a = this.a.e;
      GetUserSelfInfoStep.a(this.this$0).a().jdField_b_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
      GetUserSelfInfoStep.a(this.this$0).a().jdField_c_of_type_JavaLangString = this.a.jdField_d_of_type_JavaLangString;
      GetUserSelfInfoStep.a(this.this$0).a().jdField_d_of_type_JavaLangString = this.a.a;
      localObject = (StoryConfigManager)SuperManager.a(10);
      ((StoryConfigManager)localObject).b("qqstory_my_fans_count", Integer.valueOf(this.a.jdField_c_of_type_Int));
      ((StoryConfigManager)localObject).b("qqstory_i_am_vip", Integer.valueOf(this.a.jdField_b_of_type_Int));
      ((StoryConfigManager)localObject).b("qqstory_my_vidoe_count", Integer.valueOf(this.a.jdField_d_of_type_Int));
      ((StoryConfigManager)localObject).b("qqstory_my_visiter_count", Integer.valueOf(this.a.e));
      ((StoryConfigManager)localObject).b("qqstory_my_newest_video_cover", this.a.jdField_c_of_type_JavaLangString);
      ((StoryConfigManager)localObject).b("qqstory_my_newest_video_vid", this.a.jdField_d_of_type_JavaLangString);
      QQStoryContext.a().a(this.a.a);
      this.this$0.d();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1
 * JD-Core Version:    0.7.0.1
 */