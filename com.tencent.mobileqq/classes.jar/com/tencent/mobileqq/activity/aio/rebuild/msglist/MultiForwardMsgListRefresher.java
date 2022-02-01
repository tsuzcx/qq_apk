package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;

public class MultiForwardMsgListRefresher
  extends MsgListRefresher
{
  public MultiForwardMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.MultiForwardMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */