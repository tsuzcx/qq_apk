package com.tencent.mobileqq.activity.contacts.mayknow;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

class RecommendFriendFragment$3
  implements Runnable
{
  RecommendFriendFragment$3(RecommendFriendFragment paramRecommendFriendFragment) {}
  
  public void run()
  {
    if ((this.this$0.c != null) && (this.this$0.a != null) && (this.this$0.c.getVisibility() == 0) && (this.this$0.c.getMeasuredHeight() > 0) && (this.this$0.a.getMeasuredHeight() > 0))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.c.getLayoutParams();
      int i;
      if (this.this$0.f > 0) {
        i = (this.this$0.a.getMeasuredHeight() - Math.max(this.this$0.f - this.this$0.e, 0) - this.this$0.c.getMeasuredHeight()) / 2;
      } else {
        i = AIOUtils.b(68.0F, this.this$0.getResources());
      }
      if (i != localLayoutParams.topMargin)
      {
        localLayoutParams.topMargin = i;
        this.this$0.c.setLayoutParams(localLayoutParams);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onHeadViewScrollChanged topMargin:");
        localStringBuilder.append(localLayoutParams.topMargin);
        localStringBuilder.append(" mLastHeadViewCurrentY:");
        localStringBuilder.append(this.this$0.e);
        localStringBuilder.append(" mLastHeadViewMaxY:");
        localStringBuilder.append(this.this$0.f);
        localStringBuilder.append(" rheight:");
        localStringBuilder.append(this.this$0.a.getMeasuredHeight());
        localStringBuilder.append("  eheight:");
        localStringBuilder.append(this.this$0.c.getMeasuredHeight());
        QLog.i("RecommendFriendFragment", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment.3
 * JD-Core Version:    0.7.0.1
 */