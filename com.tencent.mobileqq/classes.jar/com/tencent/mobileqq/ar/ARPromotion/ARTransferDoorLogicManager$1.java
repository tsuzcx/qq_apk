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
      if (ARTransferDoorLogicManager.a(this.this$0).c.k > ARTransferDoorLogicManager.a(this.this$0).c.i - 1)
      {
        ARTransferDoorLogicManager.a(this.this$0, true);
        break;
      }
      if (ARTransferDoorLogicManager.b(this.this$0) == true) {
        break;
      }
      Object localObject = ARTransferDoorLogicManager.a(this.this$0).c.g[ARTransferDoorLogicManager.a(this.this$0).c.k];
      localObject = ARLocalGestureCircleRecog.a(this.a, this.b, this.c, this.d, (PointF)localObject);
      int j = (int)((PointF)localObject).x;
      int k = (int)((PointF)localObject).y;
      int m = ARTransferDoorLogicManager.a(this.this$0).c.h[ARTransferDoorLogicManager.a(this.this$0).c.k];
      localObject = this.this$0;
      boolean bool;
      if (ARTransferDoorLogicManager.a((ARTransferDoorLogicManager)localObject).c.k == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((ARTransferDoorLogicManager)localObject).a(new int[] { j }, new int[] { k }, new int[] { m }, bool);
      localObject = ARTransferDoorLogicManager.a(this.this$0).c;
      ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject).k += 1;
      localObject = ARTransferDoorLogicManager.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DrawCircle. mDrawCirclePuase = ");
      localStringBuilder.append(ARTransferDoorLogicManager.b(this.this$0));
      localStringBuilder.append(", genIdx = ");
      localStringBuilder.append(ARTransferDoorLogicManager.a(this.this$0).c.k);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      i += 1;
    }
    if ((!ARTransferDoorLogicManager.b(this.this$0)) && (this.this$0.j != null) && (this.this$0.j.get() != null)) {
      ((QQARSession)this.this$0.j.get()).b(this, ARTransferDoorLogicManager.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1
 * JD-Core Version:    0.7.0.1
 */