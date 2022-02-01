package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class FriendProfileImageActivity$15
  implements View.OnClickListener
{
  FriendProfileImageActivity$15(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131431689)
    {
      FriendProfileImageModel.ProfileImageInfo localProfileImageInfo = this.a.c.c();
      if ((!this.a.m) && (this.a.l) && (localProfileImageInfo != null))
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.a, null);
        localActionSheet.addButton(2131890801, 3);
        localActionSheet.addCancelButton(2131887648);
        localActionSheet.setOnButtonClickListener(new FriendProfileImageActivity.15.1(this, localProfileImageInfo, localActionSheet));
        localActionSheet.show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.15
 * JD-Core Version:    0.7.0.1
 */