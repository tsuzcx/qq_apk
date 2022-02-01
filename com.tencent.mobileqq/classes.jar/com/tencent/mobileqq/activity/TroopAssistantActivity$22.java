package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAssistantActivity$22
  implements ActionSheet.OnButtonClickListener
{
  TroopAssistantActivity$22(TroopAssistantActivity paramTroopAssistantActivity, int paramInt, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.d.K == null)
      {
        paramView = this.d;
        paramView.K = new QQProgressNotifier(paramView);
      }
      this.d.K.b(2, 2131892104, 1500);
    }
    else
    {
      int i = -1;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              paramInt = i;
            } else {
              paramInt = 3;
            }
          }
          else {
            paramInt = 2;
          }
        }
        else {
          paramInt = 4;
        }
      }
      else {
        paramInt = 1;
      }
      if (paramInt != this.a) {
        this.d.app.setTroopMsgFilterToServer(this.b, Integer.valueOf(paramInt));
      }
    }
    try
    {
      if (this.c != null)
      {
        this.c.dismiss();
        return;
      }
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAssistantActivity", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.22
 * JD-Core Version:    0.7.0.1
 */