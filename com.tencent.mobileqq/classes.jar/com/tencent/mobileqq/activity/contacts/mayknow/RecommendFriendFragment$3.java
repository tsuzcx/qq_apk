package com.tencent.mobileqq.activity.contacts.mayknow;

import agej;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

class RecommendFriendFragment$3
  implements Runnable
{
  RecommendFriendFragment$3(RecommendFriendFragment paramRecommendFriendFragment) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.this$0.c != null) && (this.this$0.jdField_a_of_type_AndroidViewView != null) && (this.this$0.c.getVisibility() == 0) && (this.this$0.c.getMeasuredHeight() > 0) && (this.this$0.jdField_a_of_type_AndroidViewView.getMeasuredHeight() > 0))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.c.getLayoutParams();
      if (this.this$0.b <= 0) {
        break label252;
      }
    }
    label252:
    for (int i = (this.this$0.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - Math.max(this.this$0.b - this.this$0.jdField_a_of_type_Int, 0) - this.this$0.c.getMeasuredHeight()) / 2;; i = agej.a(68.0F, this.this$0.getResources()))
    {
      if (i != localLayoutParams.topMargin)
      {
        localLayoutParams.topMargin = i;
        this.this$0.c.setLayoutParams(localLayoutParams);
      }
      if (QLog.isColorLevel()) {
        QLog.i("RecommendFriendFragment", 2, "onHeadViewScrollChanged topMargin:" + localLayoutParams.topMargin + " mLastHeadViewCurrentY:" + this.this$0.jdField_a_of_type_Int + " mLastHeadViewMaxY:" + this.this$0.b + " rheight:" + this.this$0.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + "  eheight:" + this.this$0.c.getMeasuredHeight());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment.3
 * JD-Core Version:    0.7.0.1
 */