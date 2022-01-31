package com.tencent.mobileqq.ar.ARPromotion;

import amtj;
import ancj;
import ancl;
import android.graphics.PointF;
import anfx;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ARTransferDoorLogicManager$1
  implements Runnable
{
  public ARTransferDoorLogicManager$1(amtj paramamtj, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    int i = 0;
    if (i < 2)
    {
      if (amtj.a(this.this$0).a.g <= amtj.a(this.this$0).a.e - 1) {
        break label106;
      }
      amtj.a(this.this$0, true);
    }
    label106:
    while (amtj.a(this.this$0) == true)
    {
      if ((!amtj.a(this.this$0)) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((anfx)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this, amtj.a(this.this$0));
      }
      return;
    }
    Object localObject = amtj.a(this.this$0).a.b[amtj.a(this.this$0).a.g];
    localObject = ARLocalGestureCircleRecog.a(this.a, this.b, this.c, this.d, (PointF)localObject);
    int j = (int)((PointF)localObject).x;
    int k = (int)((PointF)localObject).y;
    int m = amtj.a(this.this$0).a.a[amtj.a(this.this$0).a.g];
    localObject = this.this$0;
    if (amtj.a(this.this$0).a.g == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((amtj)localObject).a(new int[] { j }, new int[] { k }, new int[] { m }, bool);
      localObject = amtj.a(this.this$0).a;
      ((ancl)localObject).g += 1;
      QLog.i(amtj.jdField_a_of_type_JavaLangString, 1, "DrawCircle. mDrawCirclePuase = " + amtj.a(this.this$0) + ", genIdx = " + amtj.a(this.this$0).a.g);
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1
 * JD-Core Version:    0.7.0.1
 */