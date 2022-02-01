package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.aio.rebuild.msglist.GameBuddyMsgListRefresher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GameBuddyChatPie
  extends StrangerChatPie
{
  public GameBuddyChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  public AIOContext a()
  {
    return new GameBuddyContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new GameBuddyMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  void a()
  {
    b(true);
    if ((this.f != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      String str = GameMsgUtil.d;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        str = ((GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a();
      }
      this.f.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698544) + str);
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i = ((Integer)paramObject).intValue();
    paramObject = "";
    if (i == 2) {
      paramObject = "206997";
    }
    for (;;)
    {
      GameMsgUtil.a("0", "1", "176", "969", "96902", paramObject, "", "0", "20", "0");
      return;
      if (i == 3) {
        paramObject = "206996";
      } else if (i == 24) {
        paramObject = "207004";
      } else if (i == 4) {
        paramObject = "207000";
      } else if (i == 5) {
        paramObject = "207005";
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10009) {
          break;
        }
        localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
        paramString = "2";
        if ((localObject instanceof MessageForText))
        {
          paramString = "2";
          break label138;
          GameMsgUtil.a("0", "1", "176", "969", "96902", "206999", paramString, "0", "20", (String)localObject);
        }
        else if ((localObject instanceof MessageForPic))
        {
          paramString = "0";
        }
        else if ((localObject instanceof MessageForPtt))
        {
          paramString = "1";
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("GameBuddyChatPie", 1, paramString, new Object[0]);
        return;
      }
      Object localObject = "1";
      continue;
      label138:
      if (paramBoolean) {
        localObject = "0";
      }
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void m(int paramInt)
  {
    super.m(paramInt);
    GameMsgUtil.a("0", "1", "176", "969", "96901", "206994", "", "0", "7", "0");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      GameMsgUtil.a("0", "1", "176", "969", "96902", "206998", "", "0", "20", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameBuddyChatPie
 * JD-Core Version:    0.7.0.1
 */