package com.tencent.mobileqq.ar.ARPromotion;

import akye;
import alhk;
import alhm;
import alky;
import android.graphics.PointF;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ARTransferDoorLogicManager$1
  implements Runnable
{
  public ARTransferDoorLogicManager$1(akye paramakye, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    int i = 0;
    if (i < 2)
    {
      if (akye.a(this.this$0).a.g <= akye.a(this.this$0).a.e - 1) {
        break label106;
      }
      akye.a(this.this$0, true);
    }
    label106:
    while (akye.a(this.this$0) == true)
    {
      if ((!akye.a(this.this$0)) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((alky)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this, akye.a(this.this$0));
      }
      return;
    }
    Object localObject = akye.a(this.this$0).a.b[akye.a(this.this$0).a.g];
    localObject = ARLocalGestureCircleRecog.a(this.a, this.b, this.c, this.d, (PointF)localObject);
    int j = (int)((PointF)localObject).x;
    int k = (int)((PointF)localObject).y;
    int m = akye.a(this.this$0).a.a[akye.a(this.this$0).a.g];
    localObject = this.this$0;
    if (akye.a(this.this$0).a.g == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((akye)localObject).a(new int[] { j }, new int[] { k }, new int[] { m }, bool);
      localObject = akye.a(this.this$0).a;
      ((alhm)localObject).g += 1;
      QLog.i(akye.jdField_a_of_type_JavaLangString, 1, "DrawCircle. mDrawCirclePuase = " + akye.a(this.this$0) + ", genIdx = " + akye.a(this.this$0).a.g);
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1
 * JD-Core Version:    0.7.0.1
 */