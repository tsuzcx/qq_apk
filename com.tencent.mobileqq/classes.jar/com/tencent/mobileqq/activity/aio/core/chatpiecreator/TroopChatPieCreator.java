package com.tencent.mobileqq.activity.aio.core.chatpiecreator;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class TroopChatPieCreator
  implements IChatPieCreator
{
  public boolean canReuse(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    boolean bool1 = true;
    String str = paramIntent.getStringExtra("uin");
    boolean bool2 = paramQQAppInterface.getHotChatMng(true).b(str);
    boolean bool3 = paramIntent.getBooleanExtra("isGameRoom", false);
    if ((bool2) || (bool3)) {
      bool1 = false;
    }
    while ((paramBaseChatPie != null) && (paramBaseChatPie.getClass().equals(TroopChatPie.class))) {
      return bool1;
    }
    return false;
  }
  
  public boolean clearLastWhenReuse(FragmentActivity paramFragmentActivity)
  {
    return ((paramFragmentActivity instanceof SplashActivity)) || ((paramFragmentActivity instanceof ChatActivity));
  }
  
  public BaseChatPie create(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, TopGestureLayout paramTopGestureLayout, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    HotChatManager localHotChatManager = paramQQAppInterface.getHotChatMng(true);
    boolean bool1 = localHotChatManager.b(str);
    boolean bool2 = paramIntent.getBooleanExtra("isGameRoom", false);
    if ((bool1) || (bool2))
    {
      paramIntent = localHotChatManager.a(str);
      if (((paramIntent != null) && (paramIntent.isGameRoom)) || (bool2)) {
        return new GameRoomChatPie(paramQQAppInterface, paramTopGestureLayout, paramFragmentActivity, paramFragmentActivity);
      }
      return new HotChatPie(paramQQAppInterface, paramTopGestureLayout, paramFragmentActivity, paramFragmentActivity);
    }
    return new TroopChatPie(paramQQAppInterface, paramTopGestureLayout, paramFragmentActivity, paramFragmentActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.chatpiecreator.TroopChatPieCreator
 * JD-Core Version:    0.7.0.1
 */