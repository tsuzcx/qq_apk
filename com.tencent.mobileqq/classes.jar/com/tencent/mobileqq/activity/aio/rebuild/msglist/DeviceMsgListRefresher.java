package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import mqq.os.MqqHandler;

public class DeviceMsgListRefresher
  extends MsgListRefresher
{
  public DeviceMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.a().sendEmptyMessage(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.DeviceMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */