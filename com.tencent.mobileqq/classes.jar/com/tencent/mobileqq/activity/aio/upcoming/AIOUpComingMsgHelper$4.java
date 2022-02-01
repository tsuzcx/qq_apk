package com.tencent.mobileqq.activity.aio.upcoming;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

class AIOUpComingMsgHelper$4
  implements UpcomingTimeSelector.IOnTimeSelected
{
  AIOUpComingMsgHelper$4(AIOUpComingMsgHelper paramAIOUpComingMsgHelper, List paramList1, List paramList2) {}
  
  public void a(long paramLong)
  {
    AIOUpComingMsgHelper.a(this.c, this.a, paramLong, 2);
    AIOUpComingMsgHelper.d(this.c).a(false, (ChatMessage)this.b.get(0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.4
 * JD-Core Version:    0.7.0.1
 */