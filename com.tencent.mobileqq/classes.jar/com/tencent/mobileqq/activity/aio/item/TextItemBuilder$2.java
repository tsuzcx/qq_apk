package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class TextItemBuilder$2
  implements View.OnClickListener
{
  TextItemBuilder$2(TextItemBuilder paramTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = AIOUtils.a(paramView);
    if (!(localObject1 instanceof MessageForText))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    else
    {
      MessageForText localMessageForText = (MessageForText)localObject1;
      if (localMessageForText.sb != null) {
        localObject1 = localMessageForText.sb.toString();
      } else {
        localObject1 = localMessageForText.msg;
      }
      ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
      if ((this.a.e instanceof BaseActivity))
      {
        localObject2 = ((BaseActivity)this.a.e).getChatFragment().k();
        if (localObject2 != null)
        {
          localObject2 = (QWalletAIOLifeCycleHelper)((BaseChatPie)localObject2).q(27);
          if (localObject2 != null) {
            ((QWalletAIOLifeCycleHelper)localObject2).a((String)localObject1, localSendMsgParams, 0);
          }
        }
      }
      Object localObject2 = MessageForText.getTroopMemberInfoFromExtrJson(localMessageForText.getExtInfoFromExtStr(MessageConstants.i));
      ChatActivityFacade.a(this.a.d, this.a.e, this.a.f, (String)localObject1, (ArrayList)localObject2, localSendMsgParams);
      if (this.a.f.a == 1)
      {
        localObject1 = (HotChatManager)this.a.d.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.a.f.b))) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ReportController.b(this.a.d, "dc00899", "Grp_msg", "", "grp_msg", "clk_like", 0, 0, localMessageForText.frienduin, "", (String)localObject1, "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */