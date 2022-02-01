package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FriendProfileMoreInfoActivity$9
  implements ActionSheet.OnButtonClickListener
{
  FriendProfileMoreInfoActivity$9(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.a;
    if (paramView != null) {
      paramView.dismiss();
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        FriendProfileMoreInfoActivity.b(this.b, 3);
        FriendProfileMoreInfoActivity.a(this.b, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
        return;
      }
      FriendProfileMoreInfoActivity.b(this.b, 2);
      FriendProfileMoreInfoActivity.a(this.b, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
      return;
    }
    FriendProfileMoreInfoActivity.b(this.b, 1);
    FriendProfileMoreInfoActivity.a(this.b, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.9
 * JD-Core Version:    0.7.0.1
 */