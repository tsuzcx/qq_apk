package com.tencent.biz.qqstory.settings;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

class QQStoryShieldActivity$1
  extends QQStoryObserver
{
  QQStoryShieldActivity$1(QQStoryShieldActivity paramQQStoryShieldActivity) {}
  
  public void a(boolean paramBoolean, QQStoryUserInfo paramQQStoryUserInfo)
  {
    QQStoryShieldActivity.a(this.a);
    if ((paramBoolean) && (paramQQStoryUserInfo != null))
    {
      this.a.e.setOnCheckedChangeListener(null);
      this.a.f.setOnCheckedChangeListener(null);
      Switch localSwitch = this.a.e;
      int i = paramQQStoryUserInfo.isAllowed;
      boolean bool = false;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localSwitch.setChecked(paramBoolean);
      localSwitch = this.a.f;
      paramBoolean = bool;
      if (paramQQStoryUserInfo.isInterested == 1) {
        paramBoolean = true;
      }
      localSwitch.setChecked(paramBoolean);
      this.a.e.setOnCheckedChangeListener(this.a);
      this.a.f.setOnCheckedChangeListener(this.a);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.i.b();
    if (paramBoolean1) {
      return;
    }
    QQToast.makeText(this.a, 2131892409, 0).show(this.a.getTitleBarHeight());
    if (paramBoolean3)
    {
      this.a.e.setChecked(this.a.e.isChecked() ^ true);
      return;
    }
    this.a.f.setChecked(this.a.f.isChecked() ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldActivity.1
 * JD-Core Version:    0.7.0.1
 */