package com.tencent.mobileqq.activity.richmedia;

import akxm;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

class NewFlowCameraActivity$52
  implements Runnable
{
  NewFlowCameraActivity$52(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean, String paramString, int paramInt) {}
  
  public void run()
  {
    NewFlowCameraActivity.b(this.this$0, null);
    NewFlowCameraActivity.a(this.this$0, -1);
    if (this.jdField_a_of_type_Boolean) {
      if (this.this$0.jdField_a_of_type_AndroidViewView.isShown())
      {
        NewFlowCameraActivity.b(this.this$0, this.jdField_a_of_type_JavaLangString);
        NewFlowCameraActivity.a(this.this$0, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1) {}
      for (long l = 1500L;; l = 3000L)
      {
        if (this.jdField_a_of_type_Int == 3) {
          l = akxm.a();
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break;
        }
        this.this$0.c.setText(this.jdField_a_of_type_JavaLangString);
        this.this$0.c.setVisibility(0);
        if (this.this$0.jdField_a_of_type_AndroidOsHandler == null) {
          break;
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.removeCallbacks(NewFlowCameraActivity.a(this.this$0));
        if (l < 0L) {
          break;
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(NewFlowCameraActivity.a(this.this$0), l);
        return;
      }
      this.this$0.c.setText("");
      this.this$0.c.setVisibility(8);
    } while (this.this$0.jdField_a_of_type_AndroidOsHandler == null);
    this.this$0.jdField_a_of_type_AndroidOsHandler.removeCallbacks(NewFlowCameraActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.52
 * JD-Core Version:    0.7.0.1
 */