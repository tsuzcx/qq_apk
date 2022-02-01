package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARNativeBridge;

class ARTransferPromotionRenderable$2$1
  implements Runnable
{
  ARTransferPromotionRenderable$2$1(ARTransferPromotionRenderable.2 param2, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    if ((6 == ARTransferPromotionRenderable.b(this.b.a)) && (this.b.a.b <= 4))
    {
      ARNativeBridge localARNativeBridge = ARTransferPromotionRenderable.c(this.b.a);
      float[] arrayOfFloat = this.a;
      localARNativeBridge.native_setARWorldCupQuaternion(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.2.1
 * JD-Core Version:    0.7.0.1
 */