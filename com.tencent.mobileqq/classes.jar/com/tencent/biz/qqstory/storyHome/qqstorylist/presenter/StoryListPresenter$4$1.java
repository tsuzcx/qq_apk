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
    if ((this.b.this$0.a != null) && (this.b.this$0.a.isFinishing())) {
      return;
    }
    this.b.this$0.d.d("key_story_has_show_rename_guide", Boolean.valueOf(true));
    this.b.this$0.h = new GuideInfoDialog(this.b.this$0.a, 2131953428);
    this.b.this$0.h.a(this.a).b(true).a(true).c(HardCodeUtil.a(2131911801)).d(HardCodeUtil.a(2131911765)).b(new StoryListPresenter.4.1.2(this)).e("立即拍摄").a(new StoryListPresenter.4.1.1(this));
    this.b.this$0.h.c(new StoryListPresenter.4.1.3(this));
    this.b.this$0.h.setCanceledOnTouchOutside(false);
    this.b.this$0.h.setCancelable(false);
    this.b.this$0.h.setOnDismissListener(new StoryListPresenter.4.1.4(this));
    this.b.this$0.h.show();
    StoryReportor.a("home_page", "exp_up", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4.1
 * JD-Core Version:    0.7.0.1
 */