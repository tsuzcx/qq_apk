package com.tencent.mobileqq.bubble;

import aciy;
import acju;
import almq;
import almt;
import almv;
import alnp;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class BubbleInterActiveAnim$2
  implements Runnable
{
  public BubbleInterActiveAnim$2(almv paramalmv, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = aciy.a(aciy.a(almv.a(this.this$0), aciy.a(this.a, almv.b(this.this$0).getAdapter())));
    if ((localObject1 != null) && ((localObject1 instanceof acju))) {}
    for (localObject1 = (acju)localObject1;; localObject1 = null)
    {
      Object localObject4 = aciy.a(aciy.a(almv.c(this.this$0), aciy.a(this.b, almv.d(this.this$0).getAdapter())));
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject2 = localObject3;
        if ((localObject4 instanceof acju)) {
          localObject2 = (acju)localObject4;
        }
      }
      if ((localObject1 == null) || (localObject2 == null) || (((acju)localObject1).a == null) || (((acju)localObject2).a == null)) {
        return;
      }
      int i;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((acju)localObject1).a.a, 8)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((acju)localObject2).a.a, 8))) {
        i = 1;
      }
      while (i != 0)
      {
        localObject3 = new Pair(Long.valueOf(this.a), Long.valueOf(this.b));
        localObject4 = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        ((Message)localObject4).obj = localObject3;
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
        localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((acju)localObject1).a.a, false);
        localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((acju)localObject2).a.a, false);
        localObject4 = ((almq)localObject4).b.values().iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            this.this$0.a((alnp)((Iterator)localObject4).next(), ((acju)localObject1).a.a);
            continue;
            i = 0;
            break;
          }
        }
        this.this$0.a((alnp)((almq)localObject3).b.get("passive_animation"), ((acju)localObject2).a.a);
        return;
      }
      QLog.e("BubbleInterActiveAnim", 1, "resource is not all ready, originalMsg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((acju)localObject1).a.a, 8) + ", target msg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((acju)localObject2).a.a, 8));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.2
 * JD-Core Version:    0.7.0.1
 */