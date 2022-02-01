package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.PointF;
import apce;
import aplf;
import aplh;
import apos;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ARTransferDoorLogicManager$1
  implements Runnable
{
  public ARTransferDoorLogicManager$1(apce paramapce, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    int i = 0;
    if (i < 2)
    {
      if (apce.a(this.this$0).a.g <= apce.a(this.this$0).a.e - 1) {
        break label106;
      }
      apce.a(this.this$0, true);
    }
    label106:
    while (apce.a(this.this$0) == true)
    {
      if ((!apce.a(this.this$0)) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((apos)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this, apce.a(this.this$0));
      }
      return;
    }
    Object localObject = apce.a(this.this$0).a.b[apce.a(this.this$0).a.g];
    localObject = ARLocalGestureCircleRecog.a(this.a, this.b, this.c, this.d, (PointF)localObject);
    int j = (int)((PointF)localObject).x;
    int k = (int)((PointF)localObject).y;
    int m = apce.a(this.this$0).a.a[apce.a(this.this$0).a.g];
    localObject = this.this$0;
    if (apce.a(this.this$0).a.g == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((apce)localObject).a(new int[] { j }, new int[] { k }, new int[] { m }, bool);
      localObject = apce.a(this.this$0).a;
      ((aplh)localObject).g += 1;
      QLog.i(apce.jdField_a_of_type_JavaLangString, 1, "DrawCircle. mDrawCirclePuase = " + apce.a(this.this$0) + ", genIdx = " + apce.a(this.this$0).a.g);
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1
 * JD-Core Version:    0.7.0.1
 */