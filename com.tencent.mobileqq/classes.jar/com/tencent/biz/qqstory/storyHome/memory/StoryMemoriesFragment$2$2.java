package com.tencent.biz.qqstory.storyHome.memory;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class StoryMemoriesFragment$2$2
  extends OnSimpleShareListener
{
  StoryMemoriesFragment$2$2(StoryMemoriesFragment.2 param2) {}
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    boolean bool1 = QQStoryContext.a().b(StoryMemoriesFragment.a(this.a.a).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq);
    boolean bool2 = StoryMemoriesFragment.a(this.a.a).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip;
    int i = StoryMemoriesFragment.a(StoryMemoriesFragment.a(this.a.a).jdField_a_of_type_Int);
    String str2 = "1";
    String str1;
    if (bool1) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    if (bool2 != true) {
      str2 = "2";
    }
    StoryReportor.a("memory", "share_suc", i, paramInt, new String[] { str1, str2, "", "" });
  }
  
  public void d()
  {
    super.d();
    StoryMemoriesFragment.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment.2.2
 * JD-Core Version:    0.7.0.1
 */