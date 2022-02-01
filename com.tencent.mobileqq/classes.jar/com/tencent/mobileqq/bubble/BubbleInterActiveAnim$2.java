package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.widget.ListView;

class BubbleInterActiveAnim$2
  implements Runnable
{
  BubbleInterActiveAnim$2(BubbleInterActiveAnim paramBubbleInterActiveAnim, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject1 = AIOUtils.b(AIOUtils.a(BubbleInterActiveAnim.a(this.this$0), AIOUtils.a(this.a, BubbleInterActiveAnim.b(this.this$0).getAdapter())));
    Object localObject3 = null;
    if ((localObject1 != null) && ((localObject1 instanceof BaseBubbleBuilder.ViewHolder))) {
      localObject1 = (BaseBubbleBuilder.ViewHolder)localObject1;
    } else {
      localObject1 = null;
    }
    Object localObject4 = AIOUtils.b(AIOUtils.a(BubbleInterActiveAnim.c(this.this$0), AIOUtils.a(this.b, BubbleInterActiveAnim.d(this.this$0).getAdapter())));
    Object localObject2 = localObject3;
    if (localObject4 != null)
    {
      localObject2 = localObject3;
      if ((localObject4 instanceof BaseBubbleBuilder.ViewHolder)) {
        localObject2 = (BaseBubbleBuilder.ViewHolder)localObject4;
      }
    }
    if (BubbleInterActiveAnim.a(this.this$0, (BaseBubbleBuilder.ViewHolder)localObject1, (BaseBubbleBuilder.ViewHolder)localObject2)) {
      return;
    }
    BubbleInterActiveAnim.a(this.this$0, (BaseBubbleBuilder.ViewHolder)localObject1, (BaseBubbleBuilder.ViewHolder)localObject2, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.2
 * JD-Core Version:    0.7.0.1
 */