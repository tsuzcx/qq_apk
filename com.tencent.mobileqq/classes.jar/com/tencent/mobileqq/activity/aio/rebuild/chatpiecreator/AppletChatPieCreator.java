package com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator;

import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.AppletsChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class AppletChatPieCreator
  implements IChatPieCreator
{
  public BaseChatPie a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TopGestureLayout paramTopGestureLayout, Intent paramIntent)
  {
    return new AppletsChatPie(paramQQAppInterface, paramTopGestureLayout, paramBaseActivity, paramBaseActivity);
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return paramBaseActivity instanceof SplashActivity;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    return paramBaseChatPie instanceof AppletsChatPie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.AppletChatPieCreator
 * JD-Core Version:    0.7.0.1
 */