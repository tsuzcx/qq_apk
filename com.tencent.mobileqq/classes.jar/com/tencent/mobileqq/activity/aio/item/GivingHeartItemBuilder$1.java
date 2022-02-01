package com.tencent.mobileqq.activity.aio.item;

import android.util.LruCache;
import com.tencent.mobileqq.data.MessageForPoke;

class GivingHeartItemBuilder$1
  extends LruCache<Long, MessageForPoke>
{
  GivingHeartItemBuilder$1(GivingHeartItemBuilder paramGivingHeartItemBuilder, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Long paramLong, MessageForPoke paramMessageForPoke1, MessageForPoke paramMessageForPoke2)
  {
    if ((paramMessageForPoke1 != null) && (!paramMessageForPoke1.isPlayed))
    {
      paramMessageForPoke1.setPlayed(this.a.w);
      paramMessageForPoke1.mFrameState.d = false;
      paramMessageForPoke1.mFrameState.h = true;
      paramMessageForPoke1.mUnlimitedState.d = false;
      paramMessageForPoke1.mUnlimitedState.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */