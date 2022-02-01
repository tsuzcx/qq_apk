package com.tencent.mobileqq.activity.contact.addcontact;

import android.animation.Animator;
import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;

class AddContactsActivity$2$2
  extends D8SafeAnimatorListener
{
  AddContactsActivity$2$2(AddContactsActivity.2 param2) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.a = true;
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("click search onAnimationEnd mCurrentView = ");
      paramAnimator.append(AddContactsActivity.a(this.a.a));
      QLog.d("AddContactsActivity", 2, paramAnimator.toString());
    }
    if ((AddContactsActivity.a(this.a.a) instanceof AddContactsView))
    {
      ActiveEntitySearchActivity.a(this.a.a, HardCodeUtil.a(2131713565), new long[] { 1001L, 1002L }, 99);
    }
    else
    {
      paramAnimator = new Intent(this.a.a, SearchContactsActivity.class);
      paramAnimator.putExtra("from_key", this.a.a.a());
      paramAnimator.putExtra("fromType", 13);
      this.a.a.startActivity(paramAnimator);
    }
    this.a.a.overridePendingTransition(0, 0);
    ThreadPriorityManager.a(false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity.2.2
 * JD-Core Version:    0.7.0.1
 */