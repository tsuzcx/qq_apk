package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgContext;

public class GameMsgListRefresher
  extends MsgListRefresher
{
  public GameMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a()
  {
    super.a();
    ((GameMsgContext)this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.GameMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */