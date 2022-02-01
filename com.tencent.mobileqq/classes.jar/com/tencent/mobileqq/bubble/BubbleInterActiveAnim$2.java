package com.tencent.mobileqq.bubble;

import aezf;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import apeb;
import apee;
import apeg;
import apfa;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class BubbleInterActiveAnim$2
  implements Runnable
{
  public BubbleInterActiveAnim$2(apeg paramapeg, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = AIOUtils.getHolder(AIOUtils.getViewByPostion(apeg.a(this.this$0), AIOUtils.findMessagePosition(this.a, apeg.b(this.this$0).getAdapter())));
    if ((localObject1 != null) && ((localObject1 instanceof aezf))) {}
    for (localObject1 = (aezf)localObject1;; localObject1 = null)
    {
      Object localObject4 = AIOUtils.getHolder(AIOUtils.getViewByPostion(apeg.c(this.this$0), AIOUtils.findMessagePosition(this.b, apeg.d(this.this$0).getAdapter())));
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject2 = localObject3;
        if ((localObject4 instanceof aezf)) {
          localObject2 = (aezf)localObject4;
        }
      }
      if ((localObject1 == null) || (localObject2 == null) || (((aezf)localObject1).a == null) || (((aezf)localObject2).a == null)) {
        return;
      }
      int i;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aezf)localObject1).a.a, 8)) && (this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aezf)localObject2).a.a, 8))) {
        i = 1;
      }
      while (i != 0)
      {
        localObject3 = new Pair(Long.valueOf(this.a), Long.valueOf(this.b));
        localObject4 = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        ((Message)localObject4).obj = localObject3;
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
        localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aezf)localObject1).a.a, false);
        localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aezf)localObject2).a.a, false);
        localObject4 = ((apeb)localObject4).b.values().iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            this.this$0.a((apfa)((Iterator)localObject4).next(), ((aezf)localObject1).a.a);
            continue;
            i = 0;
            break;
          }
        }
        this.this$0.a((apfa)((apeb)localObject3).b.get("passive_animation"), ((aezf)localObject2).a.a);
        return;
      }
      QLog.e("BubbleInterActiveAnim", 1, "resource is not all ready, originalMsg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aezf)localObject1).a.a, 8) + ", target msg: " + this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((aezf)localObject2).a.a, 8));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.2
 * JD-Core Version:    0.7.0.1
 */