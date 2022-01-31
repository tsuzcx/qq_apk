package com.tencent.mobileqq.bubble;

import aekt;
import aelt;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import ansc;
import ansf;
import ansh;
import antb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class BubbleInterActiveAnim$2
  implements Runnable
{
  public BubbleInterActiveAnim$2(ansh paramansh, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = aekt.a(aekt.a(ansh.a(this.this$0), aekt.a(this.a, ansh.b(this.this$0).getAdapter())));
    if ((localObject1 != null) && ((localObject1 instanceof aelt))) {}
    for (localObject1 = (aelt)localObject1;; localObject1 = null)
    {
      Object localObject4 = aekt.a(aekt.a(ansh.c(this.this$0), aekt.a(this.b, ansh.d(this.this$0).getAdapter())));
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject2 = localObject3;
        if ((localObject4 instanceof aelt)) {
          localObject2 = (aelt)localObject4;
        }
      }
      if ((localObject1 == null) || (localObject2 == null) || (((aelt)localObject1).a == null) || (((aelt)localObject2).a == null)) {
        return;
      }
      int i;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aelt)localObject1).a.a, 8)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aelt)localObject2).a.a, 8))) {
        i = 1;
      }
      while (i != 0)
      {
        localObject3 = new Pair(Long.valueOf(this.a), Long.valueOf(this.b));
        localObject4 = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        ((Message)localObject4).obj = localObject3;
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
        localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aelt)localObject1).a.a, false);
        localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aelt)localObject2).a.a, false);
        localObject4 = ((ansc)localObject4).b.values().iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            this.this$0.a((antb)((Iterator)localObject4).next(), ((aelt)localObject1).a.a);
            continue;
            i = 0;
            break;
          }
        }
        this.this$0.a((antb)((ansc)localObject3).b.get("passive_animation"), ((aelt)localObject2).a.a);
        return;
      }
      QLog.e("BubbleInterActiveAnim", 1, "resource is not all ready, originalMsg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aelt)localObject1).a.a, 8) + ", target msg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aelt)localObject2).a.a, 8));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.2
 * JD-Core Version:    0.7.0.1
 */