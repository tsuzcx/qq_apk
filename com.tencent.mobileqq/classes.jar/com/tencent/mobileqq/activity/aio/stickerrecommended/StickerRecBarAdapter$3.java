package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aihw;
import aiin;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

public class StickerRecBarAdapter$3
  implements Runnable
{
  public StickerRecBarAdapter$3(aihw paramaihw, List paramList1, List paramList2) {}
  
  public void run()
  {
    aiin localaiin = aiin.a(aihw.a(this.this$0));
    if (aihw.a(this.this$0) == null) {
      localaiin.a(this.a, false, 0, null);
    }
    for (;;)
    {
      localaiin.b(this.a);
      aihw.a(this.this$0).a(this.b);
      return;
      localaiin.a(this.a, true, aihw.a(this.this$0).curType, aihw.a(this.this$0).curFriendUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */