package com.tencent.mobileqq.ar.ARRenderModel;

import akmk;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class Interactive3DRenderable$5
  implements Runnable
{
  public void run()
  {
    akmk.a(this.this$0).native_onTouchMove(this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, this.b, this.jdField_a_of_type_Long, akmk.a(this.this$0).mCurrentActiveId);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_MOVE native_onTouchMove");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.5
 * JD-Core Version:    0.7.0.1
 */