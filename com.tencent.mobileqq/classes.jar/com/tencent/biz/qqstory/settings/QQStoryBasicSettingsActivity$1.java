package com.tencent.biz.qqstory.settings;

import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;

class QQStoryBasicSettingsActivity$1
  extends QQStoryObserver
{
  QQStoryBasicSettingsActivity$1(QQStoryBasicSettingsActivity paramQQStoryBasicSettingsActivity) {}
  
  public void b(int paramInt)
  {
    QQStoryBasicSettingsActivity.a(this.a);
    if (paramInt != -1)
    {
      if ((paramInt != 1001) && (paramInt != 1))
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          this.a.c(2);
          return;
        }
        this.a.c(1);
        return;
      }
      this.a.c(0);
      return;
    }
    QQToast.makeText(this.a, HardCodeUtil.a(2131908438), 0).show(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.h != null) {
      this.a.h.b();
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.a.c;
      QQStoryBasicSettingsActivity localQQStoryBasicSettingsActivity = this.a;
      ((QQStoryManager)localObject).a(localQQStoryBasicSettingsActivity.b(localQQStoryBasicSettingsActivity.a));
      localObject = this.a.c;
      localQQStoryBasicSettingsActivity = this.a;
      ((QQStoryManager)localObject).b(localQQStoryBasicSettingsActivity.b(localQQStoryBasicSettingsActivity.a));
      if (this.a.a == 2)
      {
        StoryReportor.a("browse_friend_settings", "close", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      if (this.a.a == 0)
      {
        StoryReportor.a("browse_friend_settings", "choose_all", 0, 0, new String[] { "", "", "", "" });
        return;
      }
      if (this.a.a == 1) {
        StoryReportor.a("browse_friend_settings", "choose_wifi", 0, 0, new String[] { "", "", "", "" });
      }
    }
    else
    {
      QQToast.makeText(this.a, 2131892409, 0).show(this.a.getTitleBarHeight());
      localObject = this.a;
      ((QQStoryBasicSettingsActivity)localObject).c(((QQStoryBasicSettingsActivity)localObject).b);
      this.a.d.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity.1
 * JD-Core Version:    0.7.0.1
 */