package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.text.SimpleDateFormat;
import java.util.List;

class ChatActivityFacade$18$1
  implements ActionSheet.OnButtonClickListener
{
  ChatActivityFacade$18$1(ChatActivityFacade.18 param18) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if ((ChatActivityFacade.e != null) && (ChatActivityFacade.e.isShowing())) {
        ChatActivityFacade.e.dismiss();
      }
    }
    else
    {
      if ((ChatActivityFacade.e != null) && (ChatActivityFacade.e.isShowing())) {
        ChatActivityFacade.e.dismiss();
      }
      paramInt = 0;
      Object localObject;
      while (paramInt < ChatActivityFacade.f.size())
      {
        paramView = (ChatMessage)ChatActivityFacade.f.get(paramInt);
        if (paramView.msgtype == -2005)
        {
          localObject = FileManagerUtil.a(this.a.c, (MessageForFile)paramView);
          this.a.c.getFileManagerEngine().c(((FileManagerEntity)localObject).nSessionId);
        }
        localObject = paramView.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isDebugVersion())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("del garyTips id[");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("],targetId[");
          localStringBuilder.append(paramView.msgUid);
          localStringBuilder.append("], hashCode:");
          localStringBuilder.append(paramView.hashCode());
          QLog.i("AIOMessageSpreadManager", 1, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            long l = Long.parseLong((String)localObject);
            this.a.c.getMessageFacade().b(paramView.frienduin, paramView.istroop, l, true);
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            QLog.e("ChatActivityFacade", 1, paramView.toString());
          }
        }
        paramInt += 1;
      }
      if (BaseChatItemLayout.ad)
      {
        paramView = ((BaseActivity)this.a.a).getChatFragment().k();
        paramView.a(false, null, true);
        if (paramView.ah.a == 1008)
        {
          localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
          ReportController.b(this.a.c, "dc00899", "Pb_account_lifeservice", paramView.ah.b, "0X80064FA", "0X80064FA", 0, 0, (String)localObject, "", "", "");
        }
      }
      if (((!(this.a.a instanceof SplashActivity)) && (!(this.a.a instanceof ChatActivity))) || (((BaseActivity)this.a.a).getChatFragment() == null) || (((BaseActivity)this.a.a).getChatFragment().k() == null)) {
        break label544;
      }
      if (ChatActivityFacade.f.size() == 1) {
        ((BaseActivity)this.a.a).getChatFragment().k().a((ChatMessage)ChatActivityFacade.f.get(0));
      } else {
        ((BaseActivity)this.a.a).getChatFragment().k().a(ChatActivityFacade.f);
      }
      QQGamePubAIOHelper.a(((BaseActivity)this.a.a).getChatFragment().k(), ChatActivityFacade.f, new ChatMessage[0]);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.c, "del_multi_msg");
    }
    return;
    label544:
    paramInt = 0;
    while (paramInt < ChatActivityFacade.f.size())
    {
      ChatActivityFacade.b(this.a.c, (ChatMessage)ChatActivityFacade.f.get(paramInt));
      paramInt += 1;
    }
    this.a.c.getMessageFacade().a(ChatActivityFacade.f, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.18.1
 * JD-Core Version:    0.7.0.1
 */