package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.PointF;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircleResult;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ARTransferDoorLogicManager$1
  implements Runnable
{
  ARTransferDoorLogicManager$1(ARTransferDoorLogicManager paramARTransferDoorLogicManager, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    int i = 0;
    while (i < 2)
    {
      if (ARTransferDoorLogicManager.a(this.this$0).a.g > ARTransferDoorLogicManager.a(this.this$0).a.e - 1)
      {
        ARTransferDoorLogicManager.a(this.this$0, true);
        break;
      }
      if (ARTransferDoorLogicManager.a(this.this$0) == true) {
        break;
      }
      Object localObject = ARTransferDoorLogicManager.a(this.this$0).a.b[ARTransferDoorLogicManager.a(this.this$0).a.g];
      localObject = ARLocalGestureCircleRecog.a(this.a, this.b, this.c, this.d, (PointF)localObject);
      int j = (int)((PointF)localObject).x;
      int k = (int)((PointF)localObject).y;
      int m = ARTransferDoorLogicManager.a(this.this$0).a.a[ARTransferDoorLogicManager.a(this.this$0).a.g];
      localObject = this.this$0;
      boolean bool;
      if (ARTransferDoorLogicManager.a((ARTransferDoorLogicManager)localObject).a.g == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((ARTransferDoorLogicManager)localObject).a(new int[] { j }, new int[] { k }, new int[] { m }, bool);
      localObject = ARTransferDoorLogicManager.a(this.this$0).a;
      ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject).g += 1;
      localObject = ARTransferDoorLogicManager.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DrawCircle. mDrawCirclePuase = ");
      localStringBuilder.append(ARTransferDoorLogicManager.a(this.this$0));
      localStringBuilder.append(", genIdx = ");
      localStringBuilder.append(ARTransferDoorLogicManager.a(this.this$0).a.g);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      i += 1;
    }
    if ((!ARTransferDoorLogicManager.a(this.this$0)) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((QQARSession)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this, ARTransferDoorLogicManager.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1
 * JD-Core Version:    0.7.0.1
 */