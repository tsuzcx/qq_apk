package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public class TroopAIOContext
  extends AIOContext
{
  public TroopAIOContext(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, @NonNull SessionInfo paramSessionInfo, @NonNull BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramSessionInfo, paramBaseChatPie);
  }
  
  public List<ChatMessage> a(List<ChatMessage> paramList)
  {
    return ((TroopChatPie)this.a).a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopAIOContext
 * JD-Core Version:    0.7.0.1
 */