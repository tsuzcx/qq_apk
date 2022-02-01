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
  
  public void onClick(View paramView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size()))
    {
      paramInt = ((Integer)this.a.get(paramInt)).intValue();
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
            this.c.k();
            AvatarPendantActivity.b(this.c);
            break;
          case 23: 
            paramView = this.c.app;
            AvatarPendantActivity localAvatarPendantActivity = this.c;
            ProfileCardUtil.a(paramView, localAvatarPendantActivity, localAvatarPendantActivity.E, this.c.L.uin, 0, 0);
            break;
          case 22: 
            boolean bool = VideoEnvironment.isShortVideoSoLibLoaded();
            if ((!AudioPlayerHelper.e()) && (!Build.MODEL.contains("Redmi 3")) && (!Build.MODEL.contains("M3S")))
            {
              if (bool)
              {
                if (Build.VERSION.SDK_INT >= 23)
                {
                  if (this.c.checkSelfPermission("android.permission.CAMERA") != 0) {
                    paramInt = 1;
                  } else {
                    paramInt = 0;
                  }
                  if (this.c.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                  int j;
                  if (this.c.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    j = 1;
                  } else {
                    j = 0;
                  }
                  if ((paramInt == 0) && (i == 0) && (j == 0))
                  {
                    DynamicAvatarRecordActivity.a(this.c, 1, 1);
                    ReportController.b(this.c.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
                  }
                  else
                  {
                    this.c.requestPermissions(new AvatarPendantActivity.14.1(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE" });
                  }
                }
                else
                {
                  DynamicAvatarRecordActivity.a(this.c, 1, 1);
                  ReportController.b(this.c.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
                }
              }
              else
              {
                if (!this.c.ae)
                {
                  ThreadManager.postImmediately(new AvatarPendantActivity.14.2(this), null, true);
                  this.c.ae = true;
                }
                QQToast.makeText(this.c, HardCodeUtil.a(2131899114), 0).show();
              }
            }
            else {
              QQToast.makeText(this.c, HardCodeUtil.a(2131899110), 0).show();
            }
            break;
          }
        }
        else
        {
          paramView = new Intent(this.c, QQBrowserActivity.class);
          paramView.putExtra("url", "https://ti.qq.com/avatarlist/public/index.html?_wv=3&_wwv=4");
          this.c.startActivity(paramView);
          ReportController.b(this.c.app, "dc00898", "", "", "0X8007C10", "0X8007C10", 0, 0, "", "", "", "");
        }
      }
      else
      {
        this.c.k();
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.c.checkSelfPermission("android.permission.CAMERA") != 0) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          if (this.c.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            i = 1;
          } else {
            i = 0;
          }
          if ((paramInt == 0) && (i == 0))
          {
            paramView = this.c;
            paramView.K = ProfileCardUtils.enterSnapshot(paramView, 5);
            ReportController.b(this.c.app, "CliOper", "", "", "0X8004176", "0X8004176", this.c.L.profileEntryType, 0, "", "", "", "");
          }
          else
          {
            this.c.requestPermissions(new AvatarPendantActivity.14.3(this), 2, new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE" });
          }
        }
        else
        {
          paramView = this.c;
          paramView.K = ProfileCardUtils.enterSnapshot(paramView, 5);
          ReportController.b(this.c.app, "CliOper", "", "", "0X8004176", "0X8004176", this.c.L.profileEntryType, 0, "", "", "", "");
        }
      }
      try
      {
        this.b.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.14
 * JD-Core Version:    0.7.0.1
 */