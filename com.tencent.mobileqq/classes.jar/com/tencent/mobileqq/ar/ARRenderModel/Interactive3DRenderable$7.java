package com.tencent.mobileqq.ar.ARRenderModel;

import amwa;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class Interactive3DRenderable$7
  implements Runnable
{
  public void run()
  {
    amwa.a(this.this$0).native_onTouchEnd(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float, this.b, 1, this.jdField_a_of_type_Long, amwa.a(this.this$0).mCurrentActiveId);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_UP native_onTouchEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.7
 * JD-Core Version:    0.7.0.1
 */