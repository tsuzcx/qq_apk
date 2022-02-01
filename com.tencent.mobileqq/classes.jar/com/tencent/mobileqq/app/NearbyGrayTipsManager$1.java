package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class NearbyGrayTipsManager$1
  implements Comparator<MessageRecord>
{
  NearbyGrayTipsManager$1(NearbyGrayTipsManager paramNearbyGrayTipsManager) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.time < paramMessageRecord2.time) {
      return 1;
    }
    if (paramMessageRecord1.time > paramMessageRecord2.time) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.1
 * JD-Core Version:    0.7.0.1
 */