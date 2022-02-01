package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.app.Activity;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;

class StoryListPresenter$4$1
  implements Runnable
{
  StoryListPresenter$4$1(StoryListPresenter.4 param4, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog = new GuideInfoDialog(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_AndroidAppActivity, 2131756270);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.a(this.jdField_a_of_type_JavaLangString).b(true).a(true).c(HardCodeUtil.a(2131714278)).d(HardCodeUtil.a(2131714242)).b(new StoryListPresenter.4.1.2(this)).e("立即拍摄").a(new StoryListPresenter.4.1.1(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.c(new StoryListPresenter.4.1.3(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.setOnDismissListener(new StoryListPresenter.4.1.4(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter$4.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.show();
    StoryReportor.a("home_page", "exp_up", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4.1
 * JD-Core Version:    0.7.0.1
 */