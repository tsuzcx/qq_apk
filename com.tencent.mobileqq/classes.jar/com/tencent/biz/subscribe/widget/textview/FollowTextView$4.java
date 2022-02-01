package com.tencent.biz.subscribe.widget.textview;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FollowTextView$4
  implements ActionSheet.OnButtonClickListener
{
  FollowTextView$4(FollowTextView paramFollowTextView, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!FollowTextView.d(this.b)) {
      return;
    }
    FollowTextView.a(this.b, false);
    if (paramInt == 0) {
      this.b.a(false);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.FollowTextView.4
 * JD-Core Version:    0.7.0.1
 */