package com.tencent.mobileqq.activity.contact.addcontact;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;

class AddContactsActivity$2
  implements ContactBaseView.IAddContactContext
{
  AddContactsActivity$2(AddContactsActivity paramAddContactsActivity) {}
  
  public Activity a()
  {
    return this.a;
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    if (this.a.a) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -(this.a.getTitleBarHeight() + 0 + AddContactsActivity.a(this.a).a()) });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new AddContactsActivity.2.1(this));
    localValueAnimator.addListener(new AddContactsActivity.2.2(this));
    localValueAnimator.start();
    ThreadPriorityManager.a(true);
  }
  
  public void b()
  {
    this.a.findViewById(2131377297).setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -(this.a.getTitleBarHeight() + 0 + AddContactsActivity.a(this.a).a()), 0 });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new AddContactsActivity.2.3(this));
    localValueAnimator.addListener(new AddContactsActivity.2.4(this));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity.2
 * JD-Core Version:    0.7.0.1
 */