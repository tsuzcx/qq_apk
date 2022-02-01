package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class HotChatContext
  extends AIOContext
{
  public HotChatContext(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, @NonNull SessionInfo paramSessionInfo, @NonNull BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramSessionInfo, paramBaseChatPie);
  }
  
  public int d()
  {
    return ((HotChatPie)this.a).k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatContext
 * JD-Core Version:    0.7.0.1
 */