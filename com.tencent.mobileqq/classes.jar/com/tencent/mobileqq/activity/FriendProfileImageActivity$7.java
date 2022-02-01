package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FriendProfileImageActivity$7
  implements ActionSheet.OnButtonClickListener
{
  FriendProfileImageActivity$7(FriendProfileImageActivity paramFriendProfileImageActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    QQAppInterface localQQAppInterface;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if ((paramInt == 4) && (!this.d.m) && (this.d.l)) {
              this.d.b(this.a);
            }
          }
          else
          {
            ProfileCardUtil.b(this.a.c, this.d.app, this.d);
            localQQAppInterface = this.d.app;
            if (this.b) {
              paramView = "1";
            } else {
              paramView = "2";
            }
            ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A8CD", "0X800A8CD", 0, 0, paramView, "", "", "");
          }
        }
        else
        {
          FriendProfileImageActivity.a(this.d, this.a.c);
          localQQAppInterface = this.d.app;
          if (this.b) {
            paramView = "1";
          } else {
            paramView = "2";
          }
          ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A8CC", "0X800A8CC", 0, 0, paramView, "", "", "");
        }
      }
      else
      {
        ProfileCardUtil.a(this.a.c, this.d.app, this.d);
        localQQAppInterface = this.d.app;
        if (this.b) {
          paramView = "1";
        } else {
          paramView = "2";
        }
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A8CB", "0X800A8CB", 0, 0, paramView, "", "", "");
      }
    }
    else
    {
      ProfileCardUtil.a(this.a.c, this.d);
      localQQAppInterface = this.d.app;
      if (this.b) {
        paramView = "1";
      } else {
        paramView = "2";
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A8CA", "0X800A8CA", 0, 0, paramView, "", "", "");
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.7
 * JD-Core Version:    0.7.0.1
 */