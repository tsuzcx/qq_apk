package com.tencent.mobileqq.activity.aio.stickerrecommended;

import ahnc;
import ahns;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

public class StickerRecBarAdapter$3
  implements Runnable
{
  public StickerRecBarAdapter$3(ahnc paramahnc, List paramList1, List paramList2) {}
  
  public void run()
  {
    ahns localahns = ahns.a(ahnc.a(this.this$0));
    if (ahnc.a(this.this$0) == null) {
      localahns.a(this.a, false, 0, null);
    }
    for (;;)
    {
      localahns.b(this.a);
      ahnc.a(this.this$0).a(this.b);
      return;
      localahns.a(this.a, true, ahnc.a(this.this$0).curType, ahnc.a(this.this$0).curFriendUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */