package com.tencent.mobileqq.ar.ARRenderModel;

import aobk;
import aobl;
import com.tencent.mobileqq.ar.ARNativeBridge;

public class ARTransferPromotionRenderable$2$1
  implements Runnable
{
  public ARTransferPromotionRenderable$2$1(aobl paramaobl, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    if ((6 == aobk.a(this.jdField_a_of_type_Aobl.a)) && (this.jdField_a_of_type_Aobl.a.b <= 4)) {
      aobk.a(this.jdField_a_of_type_Aobl.a).native_setARWorldCupQuaternion(this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_ArrayOfFloat[2], this.jdField_a_of_type_ArrayOfFloat[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.2.1
 * JD-Core Version:    0.7.0.1
 */