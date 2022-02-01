package com.tencent.mobileqq.activity.pendant;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class AvatarPendantActivity$14
  implements ActionSheet.OnButtonClickListener
{
  AvatarPendantActivity$14(AvatarPendantActivity paramAvatarPendantActivity, ArrayList paramArrayList, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    switch (((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue())
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      boolean bool = VideoEnvironment.isShortVideoSoLibLoaded();
      if ((AudioPlayerHelper.a()) || (Build.MODEL.contains("Redmi 3")) || (Build.MODEL.contains("M3S")))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, HardCodeUtil.a(2131700949), 0).a();
      }
      else
      {
        label182:
        int i;
        if (bool)
        {
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.CAMERA") != 0)
            {
              paramInt = 1;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
                break label267;
              }
              i = 1;
              label196:
              if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                break label272;
              }
            }
            label267:
            label272:
            for (int j = 1;; j = 0)
            {
              if ((paramInt == 0) && (i == 0) && (j == 0)) {
                break label278;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.requestPermissions(new AvatarPendantActivity.14.1(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE" });
              break;
              paramInt = 0;
              break label182;
              i = 0;
              break label196;
            }
            label278:
            DynamicAvatarRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 1, 1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
          }
          else
          {
            DynamicAvatarRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 1, 1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e)
          {
            ThreadManager.postImmediately(new AvatarPendantActivity.14.2(this), null, true);
            this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e = true;
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, HardCodeUtil.a(2131700953), 0).a();
          continue;
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.g();
          AvatarPendantActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.g();
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.CAMERA") != 0)
            {
              paramInt = 1;
              label459:
              if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                break label519;
              }
            }
            label519:
            for (i = 1;; i = 0)
            {
              if ((paramInt == 0) && (i == 0)) {
                break label524;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.requestPermissions(new AvatarPendantActivity.14.3(this), 2, new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE" });
              break;
              paramInt = 0;
              break label459;
            }
            label524:
            this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 5);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 5);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
            continue;
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, QQBrowserActivity.class);
            paramView.putExtra("url", "https://ti.qq.com/avatarlist/public/index.html?_wv=3&_wwv=4");
            this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007C10", "0X8007C10", 0, 0, "", "", "", "");
            continue;
            ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, 0, 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.14
 * JD-Core Version:    0.7.0.1
 */