package com.tencent.mobileqq.ar.ARRenderModel;

import alaw;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class Interactive3DRenderable$3
  implements Runnable
{
  public void run()
  {
    alaw.a(this.this$0).native_onTouchBegin(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float, this.b, 5, this.jdField_a_of_type_Long, alaw.a(this.this$0).mCurrentActiveId);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_POINTER_DOWN native_onTouchBegin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.3
 * JD-Core Version:    0.7.0.1
 */