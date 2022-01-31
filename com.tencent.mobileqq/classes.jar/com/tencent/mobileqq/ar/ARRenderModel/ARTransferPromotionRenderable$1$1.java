package com.tencent.mobileqq.ar.ARRenderModel;

import amvq;
import amvr;
import com.tencent.mobileqq.ar.ARNativeBridge;

public class ARTransferPromotionRenderable$1$1
  implements Runnable
{
  public ARTransferPromotionRenderable$1$1(amvr paramamvr, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    if ((6 == amvq.a(this.jdField_a_of_type_Amvr.a)) && (this.jdField_a_of_type_Amvr.a.b <= 4)) {
      amvq.a(this.jdField_a_of_type_Amvr.a).native_setARWorldCupQuaternion(this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_ArrayOfFloat[2], this.jdField_a_of_type_ArrayOfFloat[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.1.1
 * JD-Core Version:    0.7.0.1
 */