package com.tencent.ark;

import android.annotation.TargetApi;
import android.os.Message;

final class ThreadMessageHandler$LollipopMr1MessageWrapperImpl
  implements ThreadMessageHandler.MessageWrapperImpl
{
  @TargetApi(22)
  public void setAsynchronous(Message paramMessage, boolean paramBoolean)
  {
    paramMessage.setAsynchronous(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ThreadMessageHandler.LollipopMr1MessageWrapperImpl
 * JD-Core Version:    0.7.0.1
 */