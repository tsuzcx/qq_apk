package com.tencent.mobileqq.ar.ARRenderModel;

import alav;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class Interactive3DRenderable$4
  implements Runnable
{
  public void run()
  {
    alav.a(this.this$0).native_onTouchBegin(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float, this.b, 0, this.jdField_a_of_type_Long, alav.a(this.this$0).mCurrentActiveId);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_DOWN native_onTouchBegin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.4
 * JD-Core Version:    0.7.0.1
 */