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
          if ((DiscussionInfoCardActivity.i(this.a) != null) && (DiscussionInfoCardActivity.i(this.a).isShowing()) && (!this.a.isFinishing())) {
            DiscussionInfoCardActivity.i(this.a).dismiss();
          }
        }
        else
        {
          if ((DiscussionInfoCardActivity.i(this.a) != null) && (DiscussionInfoCardActivity.i(this.a).isShowing())) {
            DiscussionInfoCardActivity.i(this.a).dismiss();
          }
          paramMessage = new Intent();
          paramMessage.putExtra("isNeedFinish", true);
          this.a.setResult(-1, paramMessage);
          this.a.finish();
        }
      }
      else if (DiscussionInfoCardActivity.j(this.a) == 0)
      {
        paramMessage = (String)paramMessage.obj;
        if ((DiscussionInfoCardActivity.c(this.a) != null) && (paramMessage != null) && (DiscussionInfoCardActivity.c(this.a).equals(paramMessage))) {
          this.a.finish();
        }
      }
    }
    else
    {
      if (DiscussionInfoCardActivity.j(this.a) == 3000) {
        if (this.a.h != null)
        {
          localObject = this.a;
          DiscussionInfoCardActivity.a((DiscussionInfoCardActivity)localObject, DiscussionInfoCardActivity.k((DiscussionInfoCardActivity)localObject));
        }
        else
        {
          this.a.a.setText(this.a.getString(2131892016));
          if (AppSetting.e)
          {
            localObject = this.a.a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131901464));
            localStringBuilder.append(this.a.getString(2131892016));
            localStringBuilder.append(HardCodeUtil.a(2131901456));
            ((FollowImageTextView)localObject).setContentDescription(localStringBuilder.toString());
          }
        }
      }
      paramMessage = (ArrayList)paramMessage.obj;
      i = paramMessage.size();
      Object localObject = DiscussionInfoCardActivity.l(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131901458));
      localStringBuilder.append(i);
      localStringBuilder.append(HardCodeUtil.a(2131901459));
      ((TextView)localObject).setText(localStringBuilder.toString());
      DiscussionInfoCardActivity.q(this.a).setPadding(DiscussionInfoCardActivity.m(this.a), DiscussionInfoCardActivity.n(this.a), DiscussionInfoCardActivity.o(this.a), DiscussionInfoCardActivity.p(this.a));
      DiscussionInfoCardActivity.a(this.a, paramMessage);
      if (DiscussionInfoCardActivity.r(this.a) == null)
      {
        paramMessage = this.a;
        DiscussionInfoCardActivity.a(paramMessage, new DiscussionInfoCardActivity.ListAdapter(paramMessage));
        DiscussionInfoCardActivity.q(this.a).setAdapter(DiscussionInfoCardActivity.r(this.a));
      }
      else
      {
        DiscussionInfoCardActivity.r(this.a).notifyDataSetChanged();
      }
      removeMessages(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.9
 * JD-Core Version:    0.7.0.1
 */