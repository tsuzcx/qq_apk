package com.tencent.mobileqq.app;

import java.util.Comparator;

class HotchatSCMng$1
  implements Comparator<HotchatSCMng.HotchatNote>
{
  HotchatSCMng$1(HotchatSCMng paramHotchatSCMng) {}
  
  public int a(HotchatSCMng.HotchatNote paramHotchatNote1, HotchatSCMng.HotchatNote paramHotchatNote2)
  {
    if ((paramHotchatNote1 == null) || (paramHotchatNote2 == null)) {}
    do
    {
      return 0;
      if (paramHotchatNote1.a > paramHotchatNote2.a) {
        return 1;
      }
    } while (paramHotchatNote1.a >= paramHotchatNote2.a);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotchatSCMng.1
 * JD-Core Version:    0.7.0.1
 */