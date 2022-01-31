package com.tencent.mobileqq.bubble;

import aepi;
import aeqi;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import anwl;
import anwo;
import anwq;
import anxk;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class BubbleInterActiveAnim$2
  implements Runnable
{
  public BubbleInterActiveAnim$2(anwq paramanwq, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = aepi.a(aepi.a(anwq.a(this.this$0), aepi.a(this.a, anwq.b(this.this$0).getAdapter())));
    if ((localObject1 != null) && ((localObject1 instanceof aeqi))) {}
    for (localObject1 = (aeqi)localObject1;; localObject1 = null)
    {
      Object localObject4 = aepi.a(aepi.a(anwq.c(this.this$0), aepi.a(this.b, anwq.d(this.this$0).getAdapter())));
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject2 = localObject3;
        if ((localObject4 instanceof aeqi)) {
          localObject2 = (aeqi)localObject4;
        }
      }
      if ((localObject1 == null) || (localObject2 == null) || (((aeqi)localObject1).a == null) || (((aeqi)localObject2).a == null)) {
        return;
      }
      int i;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aeqi)localObject1).a.a, 8)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aeqi)localObject2).a.a, 8))) {
        i = 1;
      }
      while (i != 0)
      {
        localObject3 = new Pair(Long.valueOf(this.a), Long.valueOf(this.b));
        localObject4 = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        ((Message)localObject4).obj = localObject3;
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
        localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aeqi)localObject1).a.a, false);
        localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aeqi)localObject2).a.a, false);
        localObject4 = ((anwl)localObject4).b.values().iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            this.this$0.a((anxk)((Iterator)localObject4).next(), ((aeqi)localObject1).a.a);
            continue;
            i = 0;
            break;
          }
        }
        this.this$0.a((anxk)((anwl)localObject3).b.get("passive_animation"), ((aeqi)localObject2).a.a);
        return;
      }
      QLog.e("BubbleInterActiveAnim", 1, "resource is not all ready, originalMsg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aeqi)localObject1).a.a, 8) + ", target msg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aeqi)localObject2).a.a, 8));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.2
 * JD-Core Version:    0.7.0.1
 */