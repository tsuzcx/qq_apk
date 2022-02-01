package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.PointF;
import apfq;
import apoq;
import apos;
import apse;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ARTransferDoorLogicManager$1
  implements Runnable
{
  public ARTransferDoorLogicManager$1(apfq paramapfq, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    int i = 0;
    if (i < 2)
    {
      if (apfq.a(this.this$0).a.g <= apfq.a(this.this$0).a.e - 1) {
        break label106;
      }
      apfq.a(this.this$0, true);
    }
    label106:
    while (apfq.a(this.this$0) == true)
    {
      if ((!apfq.a(this.this$0)) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((apse)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this, apfq.a(this.this$0));
      }
      return;
    }
    Object localObject = apfq.a(this.this$0).a.b[apfq.a(this.this$0).a.g];
    localObject = ARLocalGestureCircleRecog.a(this.a, this.b, this.c, this.d, (PointF)localObject);
    int j = (int)((PointF)localObject).x;
    int k = (int)((PointF)localObject).y;
    int m = apfq.a(this.this$0).a.a[apfq.a(this.this$0).a.g];
    localObject = this.this$0;
    if (apfq.a(this.this$0).a.g == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((apfq)localObject).a(new int[] { j }, new int[] { k }, new int[] { m }, bool);
      localObject = apfq.a(this.this$0).a;
      ((apos)localObject).g += 1;
      QLog.i(apfq.jdField_a_of_type_JavaLangString, 1, "DrawCircle. mDrawCirclePuase = " + apfq.a(this.this$0) + ", genIdx = " + apfq.a(this.this$0).a.g);
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1
 * JD-Core Version:    0.7.0.1
 */