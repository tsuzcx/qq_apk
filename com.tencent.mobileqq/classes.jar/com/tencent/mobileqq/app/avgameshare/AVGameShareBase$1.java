package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQToast;

class AVGameShareBase$1
  implements Runnable
{
  AVGameShareBase$1(AVGameShareBase paramAVGameShareBase) {}
  
  public void run()
  {
    if ((this.this$0.a() != null) && (!this.this$0.a().isFinishing())) {
      QQToast.a(this.this$0.a(), 2, this.this$0.a().getString(2131690305), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareBase.1
 * JD-Core Version:    0.7.0.1
 */