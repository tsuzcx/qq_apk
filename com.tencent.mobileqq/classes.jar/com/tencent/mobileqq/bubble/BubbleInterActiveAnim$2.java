package com.tencent.mobileqq.bubble;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class BubbleInterActiveAnim$2
  implements Runnable
{
  BubbleInterActiveAnim$2(BubbleInterActiveAnim paramBubbleInterActiveAnim, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = AIOUtils.a(AIOUtils.a(BubbleInterActiveAnim.a(this.this$0), AIOUtils.a(this.a, BubbleInterActiveAnim.b(this.this$0).getAdapter())));
    if ((localObject1 != null) && ((localObject1 instanceof BaseBubbleBuilder.ViewHolder))) {}
    for (localObject1 = (BaseBubbleBuilder.ViewHolder)localObject1;; localObject1 = null)
    {
      Object localObject4 = AIOUtils.a(AIOUtils.a(BubbleInterActiveAnim.c(this.this$0), AIOUtils.a(this.b, BubbleInterActiveAnim.d(this.this$0).getAdapter())));
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject2 = localObject3;
        if ((localObject4 instanceof BaseBubbleBuilder.ViewHolder)) {
          localObject2 = (BaseBubbleBuilder.ViewHolder)localObject4;
        }
      }
      if ((localObject1 == null) || (localObject2 == null) || (((BaseBubbleBuilder.ViewHolder)localObject1).a == null) || (((BaseBubbleBuilder.ViewHolder)localObject2).a == null)) {
        return;
      }
      int i;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject1).a.a, 8)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject2).a.a, 8))) {
        i = 1;
      }
      while (i != 0)
      {
        localObject3 = new Pair(Long.valueOf(this.a), Long.valueOf(this.b));
        localObject4 = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        ((Message)localObject4).obj = localObject3;
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
        localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject1).a.a, false);
        localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject2).a.a, false);
        localObject4 = ((BubbleConfig)localObject4).b.values().iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            this.this$0.a((BubbleNewAnimConf)((Iterator)localObject4).next(), ((BaseBubbleBuilder.ViewHolder)localObject1).a.a);
            continue;
            i = 0;
            break;
          }
        }
        this.this$0.a((BubbleNewAnimConf)((BubbleConfig)localObject3).b.get("passive_animation"), ((BaseBubbleBuilder.ViewHolder)localObject2).a.a);
        return;
      }
      QLog.e("BubbleInterActiveAnim", 1, "resource is not all ready, originalMsg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject1).a.a, 8) + ", target msg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject2).a.a, 8));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.2
 * JD-Core Version:    0.7.0.1
 */