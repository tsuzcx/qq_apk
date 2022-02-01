package com.tencent.mobileqq.activity.pendant;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
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
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramInt = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue();
      int i;
      if (paramInt != 13)
      {
        if (paramInt != 27)
        {
          switch (paramInt)
          {
          default: 
            break;
          case 24: 
            this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.g();
            AvatarPendantActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity);
            break;
          case 23: 
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app;
            AvatarPendantActivity localAvatarPendantActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity;
            ProfileCardUtil.a(paramView, localAvatarPendantActivity, localAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, 0, 0);
            break;
          case 22: 
            boolean bool = VideoEnvironment.isShortVideoSoLibLoaded();
            if ((!AudioPlayerHelper.a()) && (!Build.MODEL.contains("Redmi 3")) && (!Build.MODEL.contains("M3S")))
            {
              if (bool)
              {
                if (Build.VERSION.SDK_INT >= 23)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
                    paramInt = 1;
                  } else {
                    paramInt = 0;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                  int j;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    j = 1;
                  } else {
                    j = 0;
                  }
                  if ((paramInt == 0) && (i == 0) && (j == 0))
                  {
                    DynamicAvatarRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 1, 1);
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
                  }
                  else
                  {
                    this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.requestPermissions(new AvatarPendantActivity.14.1(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE" });
                  }
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
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, HardCodeUtil.a(2131701096), 0).a();
              }
            }
            else {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, HardCodeUtil.a(2131701092), 0).a();
            }
            break;
          }
        }
        else
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, QQBrowserActivity.class);
          paramView.putExtra("url", "https://ti.qq.com/avatarlist/public/index.html?_wv=3&_wwv=4");
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.startActivity(paramView);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007C10", "0X8007C10", 0, 0, "", "", "", "");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.g();
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            i = 1;
          } else {
            i = 0;
          }
          if ((paramInt == 0) && (i == 0))
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity;
            paramView.jdField_a_of_type_AndroidNetUri = ProfileCardUtils.enterSnapshot(paramView, 5);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.profileEntryType, 0, "", "", "", "");
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.requestPermissions(new AvatarPendantActivity.14.3(this), 2, new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE" });
          }
        }
        else
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity;
          paramView.jdField_a_of_type_AndroidNetUri = ProfileCardUtils.enterSnapshot(paramView, 5);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.profileEntryType, 0, "", "", "", "");
        }
      }
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
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.14
 * JD-Core Version:    0.7.0.1
 */