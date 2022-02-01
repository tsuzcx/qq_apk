package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Set;

class MarketFaceItemBuilder$8$1
  implements Runnable
{
  MarketFaceItemBuilder$8$1(MarketFaceItemBuilder.8 param8, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.b.this$0.F.isEmpty())
    {
      this.b.this$0.F.remove(Long.valueOf(this.b.b.uniseq));
      MarketFaceItemBuilder.a(this.b.this$0, this.b.a, this.b.b.uniseq);
      if (!this.a) {
        QQToast.makeText(this.b.this$0.A, 1, 2131886505, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.8.1
 * JD-Core Version:    0.7.0.1
 */