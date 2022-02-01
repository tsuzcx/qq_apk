package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class GameMsgContext
  extends AIOContext
{
  public GameMsgContext(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, @NonNull SessionInfo paramSessionInfo, @NonNull BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramSessionInfo, paramBaseChatPie);
  }
  
  public void c()
  {
    ((GameMsgChatPie)this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgContext
 * JD-Core Version:    0.7.0.1
 */