package com.tencent.mobileqq.activity.richmedia;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicInteger;

class FlowCameraActivity2$RefreshUITimer
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  final int[] jdField_a_of_type_ArrayOfInt = { 255, 191, 127, 63, 0, 63, 127, 191 };
  
  FlowCameraActivity2$RefreshUITimer(FlowCameraActivity2 paramFlowCameraActivity2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramFlowCameraActivity2.a.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int %= 32;
  }
  
  public void run()
  {
    Drawable[] arrayOfDrawable = this.this$0.b.getCompoundDrawables();
    if (this.jdField_a_of_type_Boolean) {
      this.this$0.s();
    }
    if (arrayOfDrawable[0] != null) {
      arrayOfDrawable[0].setAlpha(this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_Int / 4)]);
    }
    if ((this.this$0.a.b.get() == 2) && (arrayOfDrawable[0] != null))
    {
      arrayOfDrawable[0].setAlpha(255);
      this.this$0.a(arrayOfDrawable[0], -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.RefreshUITimer
 * JD-Core Version:    0.7.0.1
 */