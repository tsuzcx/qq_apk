package com.tencent.av.gaudio;

import android.widget.TextView;

class GaInviteLockActivity$MainThreadRunnableTask
  implements Runnable
{
  private String a;
  private String b;
  
  public GaInviteLockActivity$MainThreadRunnableTask(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.setText(this.b);
    }
    if (this.this$0.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Object localObject = this.this$0;
      localObject = ((GaInviteLockActivity)localObject).a(((GaInviteLockActivity)localObject).jdField_b_of_type_Int, this.this$0.jdField_a_of_type_Long, this.a, true, false);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(GaInviteLockActivity.a(this.this$0, (String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.MainThreadRunnableTask
 * JD-Core Version:    0.7.0.1
 */