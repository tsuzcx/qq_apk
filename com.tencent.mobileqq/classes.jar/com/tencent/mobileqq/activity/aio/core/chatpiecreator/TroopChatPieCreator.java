package com.tencent.mobileqq.activity.aio.core.chatpiecreator;

import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class TroopChatPieCreator
  implements IChatPieCreator
{
  public BaseChatPie a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TopGestureLayout paramTopGestureLayout, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    HotChatManager localHotChatManager = paramQQAppInterface.getHotChatMng(true);
    boolean bool1 = localHotChatManager.b(str);
    boolean bool2 = paramIntent.getBooleanExtra("isGameRoom", false);
    if ((!bool1) && (!bool2)) {
      return new TroopChatPie(paramQQAppInterface, paramTopGestureLayout, paramBaseActivity, paramBaseActivity);
    }
    paramIntent = localHotChatManager.a(str);
    if (((paramIntent != null) && (paramIntent.isGameRoom)) || (bool2)) {
      return new GameRoomChatPie(paramQQAppInterface, paramTopGestureLayout, paramBaseActivity, paramBaseActivity);
    }
    return new HotChatPie(paramQQAppInterface, paramTopGestureLayout, paramBaseActivity, paramBaseActivity);
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return ((paramBaseActivity instanceof SplashActivity)) || ((paramBaseActivity instanceof ChatActivity));
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    boolean bool1 = paramQQAppInterface.getHotChatMng(true).b(str);
    boolean bool2 = paramIntent.getBooleanExtra("isGameRoom", false);
    if (!bool1)
    {
      if (bool2) {
        return false;
      }
      if ((paramBaseChatPie != null) && (paramBaseChatPie.getClass().equals(TroopChatPie.class))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.chatpiecreator.TroopChatPieCreator
 * JD-Core Version:    0.7.0.1
 */