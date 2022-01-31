package com.tencent.mobileqq.ar.ARRenderModel;

import amrb;
import amrc;
import com.tencent.mobileqq.ar.ARNativeBridge;

public class ARTransferPromotionRenderable$1$1
  implements Runnable
{
  public ARTransferPromotionRenderable$1$1(amrc paramamrc, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    if ((6 == amrb.a(this.jdField_a_of_type_Amrc.a)) && (this.jdField_a_of_type_Amrc.a.b <= 4)) {
      amrb.a(this.jdField_a_of_type_Amrc.a).native_setARWorldCupQuaternion(this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_ArrayOfFloat[2], this.jdField_a_of_type_ArrayOfFloat[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.1.1
 * JD-Core Version:    0.7.0.1
 */