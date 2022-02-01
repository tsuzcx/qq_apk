package com.tencent.ilive.litepages.room.bizmodule;

import androidx.annotation.Nullable;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.domain.factory.BaseObserver;

class LiteRoomWebModule$2
  extends BaseObserver<Long>
{
  LiteRoomWebModule$2(LiteRoomWebModule paramLiteRoomWebModule) {}
  
  public void onChanged(@Nullable Long paramLong)
  {
    this.this$0.getLog().i("CustomWebModule", "this=" + this.this$0.hashCode() + ";time position = " + paramLong, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteRoomWebModule.2
 * JD-Core Version:    0.7.0.1
 */