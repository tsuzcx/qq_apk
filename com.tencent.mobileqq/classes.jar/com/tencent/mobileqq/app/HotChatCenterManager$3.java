package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.HotChatItemData;
import java.util.Comparator;

class HotChatCenterManager$3
  implements Comparator<HotChatItemData>
{
  HotChatCenterManager$3(HotChatCenterManager paramHotChatCenterManager) {}
  
  public int a(HotChatItemData paramHotChatItemData1, HotChatItemData paramHotChatItemData2)
  {
    long l1 = paramHotChatItemData1.mMakeTopTime;
    long l2 = paramHotChatItemData2.mMakeTopTime;
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatCenterManager.3
 * JD-Core Version:    0.7.0.1
 */