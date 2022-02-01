package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.GameBuddyHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.GameBuddyMsgListRefresher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GameBuddyChatPie
  extends StrangerChatPie
{
  public GameBuddyChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  protected AIOContext a()
  {
    return new GameBuddyContext();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new GameBuddyMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected HelperProvider a()
  {
    return new GameBuddyHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  void a()
  {
    a(true);
    if ((this.f != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      String str;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        str = ((IGameMsgManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getGameBuddyAppName();
      } else {
        str = "\"玩伴\"小程序";
      }
      TextView localTextView = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131698610));
      localStringBuilder.append(str);
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    String str;
    if (paramInt == 2) {
      str = "206997";
    }
    for (;;)
    {
      break;
      if (paramInt == 3) {
        str = "206996";
      } else if (paramInt == 24) {
        str = "207004";
      } else if (paramInt == 4) {
        str = "207000";
      } else if (paramInt == 5) {
        str = "207005";
      } else {
        str = "";
      }
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("0", "1", "176", "969", "96902", str, "", "0", "20", "0");
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10009)
        {
          paramString = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
          boolean bool = paramString instanceof MessageForText;
          if (bool)
          {
            paramString = "2";
          }
          else if ((paramString instanceof MessageForPic))
          {
            paramString = "0";
          }
          else
          {
            if (!(paramString instanceof MessageForPtt)) {
              continue;
            }
            paramString = "1";
          }
          IGameMsgHelperApi localIGameMsgHelperApi = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
          if (!paramBoolean) {
            break label150;
          }
          str = "0";
          localIGameMsgHelperApi.reportForGameMsg("0", "1", "176", "969", "96902", "206999", paramString, "0", "20", str);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("GameBuddyChatPie", 1, paramString, new Object[0]);
      }
      return;
      label150:
      String str = "1";
    }
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("0", "1", "176", "969", "96901", "206994", "", "0", "7", "0");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368874) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("0", "1", "176", "969", "96902", "206998", "", "0", "20", "0");
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameBuddyChatPie
 * JD-Core Version:    0.7.0.1
 */