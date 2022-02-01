package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Message;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class DiscussionInfoCardActivity$9
  extends MqqHandler
{
  DiscussionInfoCardActivity$9(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 16711681)
      {
        if (i != 16)
        {
          if (i != 17) {
            return;
          }
          if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing()) && (!this.a.isFinishing())) {
            DiscussionInfoCardActivity.a(this.a).dismiss();
          }
        }
        else
        {
          if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing())) {
            DiscussionInfoCardActivity.a(this.a).dismiss();
          }
          paramMessage = new Intent();
          paramMessage.putExtra("isNeedFinish", true);
          this.a.setResult(-1, paramMessage);
          this.a.finish();
        }
      }
      else if (DiscussionInfoCardActivity.a(this.a) == 0)
      {
        paramMessage = (String)paramMessage.obj;
        if ((DiscussionInfoCardActivity.a(this.a) != null) && (paramMessage != null) && (DiscussionInfoCardActivity.a(this.a).equals(paramMessage))) {
          this.a.finish();
        }
      }
    }
    else
    {
      if (DiscussionInfoCardActivity.a(this.a) == 3000) {
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
        {
          localObject = this.a;
          DiscussionInfoCardActivity.a((DiscussionInfoCardActivity)localObject, DiscussionInfoCardActivity.b((DiscussionInfoCardActivity)localObject));
        }
        else
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setText(this.a.getString(2131694343));
          if (AppSetting.d)
          {
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131703512));
            localStringBuilder.append(this.a.getString(2131694343));
            localStringBuilder.append(HardCodeUtil.a(2131703504));
            ((FollowImageTextView)localObject).setContentDescription(localStringBuilder.toString());
          }
        }
      }
      paramMessage = (ArrayList)paramMessage.obj;
      i = paramMessage.size();
      Object localObject = DiscussionInfoCardActivity.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131703506));
      localStringBuilder.append(i);
      localStringBuilder.append(HardCodeUtil.a(2131703507));
      ((TextView)localObject).setText(localStringBuilder.toString());
      DiscussionInfoCardActivity.a(this.a).setPadding(DiscussionInfoCardActivity.b(this.a), DiscussionInfoCardActivity.c(this.a), DiscussionInfoCardActivity.d(this.a), DiscussionInfoCardActivity.e(this.a));
      DiscussionInfoCardActivity.a(this.a, paramMessage);
      if (DiscussionInfoCardActivity.a(this.a) == null)
      {
        paramMessage = this.a;
        DiscussionInfoCardActivity.a(paramMessage, new DiscussionInfoCardActivity.ListAdapter(paramMessage));
        DiscussionInfoCardActivity.a(this.a).setAdapter(DiscussionInfoCardActivity.a(this.a));
      }
      else
      {
        DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
      }
      removeMessages(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.9
 * JD-Core Version:    0.7.0.1
 */