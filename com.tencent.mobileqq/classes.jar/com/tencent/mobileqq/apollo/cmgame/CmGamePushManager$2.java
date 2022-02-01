package com.tencent.mobileqq.apollo.cmgame;

import com.tencent.mobileqq.apollo.api.model.CmGamePushItem;
import java.util.Comparator;

class CmGamePushManager$2
  implements Comparator<CmGamePushItem>
{
  CmGamePushManager$2(CmGamePushManager paramCmGamePushManager) {}
  
  public int a(CmGamePushItem paramCmGamePushItem1, CmGamePushItem paramCmGamePushItem2)
  {
    if (paramCmGamePushItem1.start_ts == paramCmGamePushItem2.start_ts) {
      return paramCmGamePushItem2.send_time - paramCmGamePushItem1.send_time;
    }
    return paramCmGamePushItem2.start_ts - paramCmGamePushItem1.start_ts;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGamePushManager.2
 * JD-Core Version:    0.7.0.1
 */