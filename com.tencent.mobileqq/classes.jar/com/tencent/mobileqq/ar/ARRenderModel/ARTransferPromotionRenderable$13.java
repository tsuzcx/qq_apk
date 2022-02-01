package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$13
  implements Runnable
{
  ARTransferPromotionRenderable$13(ARTransferPromotionRenderable paramARTransferPromotionRenderable, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("switchGameStatus run status ");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("ARTransferPromotionRenderable", 2, ((StringBuilder)localObject).toString());
    int i = this.a;
    if ((i != 1) && (i != 2))
    {
      if (i == 3) {
        break label243;
      }
      if (i != 4)
      {
        if ((i != 6) && (i != 8)) {
          break label243;
        }
      }
      else
      {
        if (this.this$0.b == 3)
        {
          if (ARTransferPromotionRenderable.c(this.this$0) == null) {
            break label243;
          }
          ARTransferPromotionRenderable.c(this.this$0).native_switchGameStatusWithNoParams(this.a);
          break label243;
        }
        localObject = this.this$0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ARTransferPromotionRenderable.e(this.this$0).o);
        localStringBuilder.append("360Video.mp4");
        ARTransferPromotionRenderable.a((ARTransferPromotionRenderable)localObject, 4, localStringBuilder.toString(), false, ARTransferPromotionRenderable.e(this.this$0).k, false);
        break label243;
      }
    }
    if ((this.a == 1) && (ARTransferPromotionRenderable.d(this.this$0) != null) && (ARTransferPromotionRenderable.e(this.this$0).i.booleanValue())) {
      ARTransferPromotionRenderable.d(this.this$0).b(0, 1);
    }
    if (ARTransferPromotionRenderable.c(this.this$0) != null) {
      ARTransferPromotionRenderable.c(this.this$0).native_switchGameStatusWithNoParams(this.a);
    }
    label243:
    ARTransferPromotionRenderable.w(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.13
 * JD-Core Version:    0.7.0.1
 */