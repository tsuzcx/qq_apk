package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;

class QQStoryMemoriesPresenter$1
  extends QQStoryObserver
{
  QQStoryMemoriesPresenter$1(QQStoryMemoriesPresenter paramQQStoryMemoriesPresenter) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramInt = 1;
    if ((this.a.a == null) || (!TextUtils.equals(paramString, this.a.a.uid))) {
      return;
    }
    if (paramBoolean1)
    {
      paramString = this.a.a;
      if (paramBoolean2)
      {
        paramString.isSubscribe = paramInt;
        paramString = (QQStoryManager)PlayModeUtils.a().getManager(QQManagerFactory.QQSTORY_MANAGER);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        QQToast.a(PlayModeUtils.a(), 2, HardCodeUtil.a(2131710914), 0).a();
      }
      for (;;)
      {
        QQStoryMemoriesPresenter.a(this.a).e();
        QQStoryMemoriesPresenter.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        QQToast.a(PlayModeUtils.a(), 2, HardCodeUtil.a(2131710910), 0).a();
      }
    }
    QQToast.a(PlayModeUtils.a(), 1, HardCodeUtil.a(2131710919), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter.1
 * JD-Core Version:    0.7.0.1
 */