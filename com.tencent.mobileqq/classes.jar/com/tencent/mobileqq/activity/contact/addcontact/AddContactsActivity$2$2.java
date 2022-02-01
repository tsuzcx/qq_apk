package com.tencent.mobileqq.activity.contact.addcontact;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;

class AddContactsActivity$2$2
  implements Animator.AnimatorListener
{
  AddContactsActivity$2$2(AddContactsActivity.2 param2) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.a = true;
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsActivity", 2, "click search onAnimationEnd mCurrentView = " + AddContactsActivity.a(this.a.a));
    }
    if ((AddContactsActivity.a(this.a.a) instanceof AddContactsView)) {
      ActiveEntitySearchActivity.a(this.a.a, HardCodeUtil.a(2131713598), new long[] { 1001L, 1002L }, 99);
    }
    for (;;)
    {
      this.a.a.overridePendingTransition(0, 0);
      ThreadPriorityManager.a(false);
      return;
      paramAnimator = new Intent(this.a.a, SearchContactsActivity.class);
      paramAnimator.putExtra("from_key", this.a.a.a());
      paramAnimator.putExtra("fromType", 13);
      this.a.a.startActivity(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity.2.2
 * JD-Core Version:    0.7.0.1
 */