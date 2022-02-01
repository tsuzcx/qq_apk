package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class HotChatPie$16
  implements ActionSheet.OnButtonClickListener
{
  HotChatPie$16(HotChatPie paramHotChatPie, ActionSheet paramActionSheet, ChatMessage paramChatMessage, String paramString) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramView = this.d.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("del hot chat member onClick, uin=");
        localStringBuilder.append(this.b.senderuin);
        QLog.i(paramView, 2, localStringBuilder.toString());
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.makeText(this.d.aX(), this.d.aX().getString(2131892104), 0).show(this.d.aX().getTitleBarHeight());
        return;
      }
      if ((IHotChatHandler)this.d.d.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName()) != null)
      {
        paramView = DialogUtil.a(this.d.aX(), 230).setMessage(2131890718).setNegativeButton(2131887626, new HotChatPie.16.2(this)).setPositiveButton(2131887629, new HotChatPie.16.1(this));
        paramView.setTitle(2131890719);
        paramView.show();
      }
    }
    else
    {
      this.d.a(this.b.senderuin, this.c, false, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16
 * JD-Core Version:    0.7.0.1
 */