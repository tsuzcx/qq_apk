package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.widget.BubbleImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopGiftMsgItemBuilder$4
  implements Runnable
{
  TroopGiftMsgItemBuilder$4(TroopGiftMsgItemBuilder paramTroopGiftMsgItemBuilder, String paramString1, BubbleImageView paramBubbleImageView, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject = (List)this.this$0.B.get(this.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
    }
    this.this$0.B.remove(this.a);
    TroopGiftMsgItemBuilder.a(this.this$0, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */