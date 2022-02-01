package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import aoeb;
import bdla;
import bisl;
import bkzi;
import bkzq;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class BaseChatPie$10
  implements bkzq
{
  BaseChatPie$10(BaseChatPie paramBaseChatPie, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      do
      {
        for (;;)
        {
          return;
          bdla.b(this.this$0.app, "CliOper", "", this.this$0.sessionInfo.curFriendUin, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
          bdla.b(null, "dc00898", "", "", "0X800ACA3", "0X800ACA3", 0, 0, "", "0", "0", "");
          paramView = (aoeb)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.STRANGER_HANDLER);
          ArrayList localArrayList = new ArrayList();
          try
          {
            localArrayList.add(Long.valueOf(Long.parseLong(this.this$0.sessionInfo.curFriendUin)));
            paramView.a(localArrayList);
            if (this.this$0.mProgressDialog == null) {
              this.this$0.mProgressDialog = new bisl(this.this$0.mContext, 0);
            }
            this.this$0.mProgressDialog.show();
          }
          catch (NumberFormatException paramView) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.this$0.tag, 2, "delete Stranger parseLong() error", paramView);
      return;
      paramView = new Intent(this.this$0.mActivity, QQBrowserActivity.class);
      paramView.putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=" + this.this$0.sessionInfo.curFriendUin);
      this.this$0.mActivity.startActivity(paramView);
      bdla.b(null, "dc00898", "", "", "0X800ACA4", "0X800ACA4", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.10
 * JD-Core Version:    0.7.0.1
 */