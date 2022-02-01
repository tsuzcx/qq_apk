package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.StrangerRecomInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgContext;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgAddFriDialogApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgAddFriendRulesApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class GameMsgAddFriendHelper
  extends AddFriendHelper
{
  public GameMsgAddFriendHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  private void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shieldOrCancelMsg], mStrangerRecomInfo:");
    ((StringBuilder)localObject).append(((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a());
    QLog.i("GameMsgAddFriendHelper", 1, ((StringBuilder)localObject).toString());
    if (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() == null) {
      return;
    }
    int i = 0;
    if (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().c == 0)
    {
      i = 2;
      localObject = "207868";
    }
    for (;;)
    {
      break;
      if (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().c == 1)
      {
        i = 4;
        localObject = "207869";
      }
      else
      {
        localObject = "";
      }
    }
    ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity);
    ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).addOrShieldFriend(i, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b(), "");
    if ((((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() != null) && (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() != null)) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().c, "1", "145", "920", "92015", (String)localObject, ((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "20", "");
    }
  }
  
  protected String a()
  {
    if (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() != null) {
      return ((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().a;
    }
    QLog.i("GameMsgAddFriendHelper", 1, "[getUin4AddAndShiledFriend], mStrangerRecomInfo is null.");
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
  }
  
  public void a(@StringRes int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(paramInt));
    }
  }
  
  protected void a(String paramString)
  {
    f();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.i("GameMsgAddFriendHelper", 1, "[updateShiledStatusAsync]");
    if (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() != null)
    {
      if (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().c == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
        return;
      }
      if (1 == ((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().c) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
      }
    }
  }
  
  protected void b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[addFriend], mStrangerRecomInfo:");
    ((StringBuilder)localObject1).append(((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a());
    QLog.i("GameMsgAddFriendHelper", 1, ((StringBuilder)localObject1).toString());
    if (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() == null) {
      return;
    }
    if (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().b == 1)
    {
      super.b();
      return;
    }
    if (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().b == 2)
    {
      if ((((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() != null) && (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() != null)) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().c, "1", "145", "920", "92015", "207877", ((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "20", "");
      }
      if (!((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().isAbleToAction())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), HardCodeUtil.a(2131692787), 1).a();
        if ((((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() != null) && (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() != null)) {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().c, "1", "145", "920", "92015", "207870", ((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
        }
        return;
      }
      Object localObject2 = ((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).b();
      if (localObject2 != null)
      {
        localObject1 = ((GameDetailInfo)localObject2).i;
        localObject2 = ((GameDetailInfo)localObject2).c;
      }
      else
      {
        localObject1 = "";
        localObject2 = localObject1;
      }
      ((IGameMsgAddFriDialogApi)QRoute.api(IGameMsgAddFriDialogApi.class)).showDialog(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), ((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(), (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(), (String)localObject2);
    }
  }
  
  public void b(@StringRes int paramInt)
  {
    if (this.b != null) {
      this.b.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(paramInt));
    }
  }
  
  protected void b(String paramString)
  {
    f();
  }
  
  protected boolean b()
  {
    return (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a() != null) && (((GameMsgContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().b != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */