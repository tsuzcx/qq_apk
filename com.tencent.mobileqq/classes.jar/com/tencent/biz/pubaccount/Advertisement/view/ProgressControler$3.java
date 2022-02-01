package com.tencent.biz.pubaccount.Advertisement.view;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;
import nxc;

public class ProgressControler$3
  extends TimerTask
{
  public ProgressControler$3(nxc paramnxc) {}
  
  public void run()
  {
    nxc localnxc = this.this$0;
    localnxc.c += 50L;
    if (this.this$0.c >= this.this$0.b)
    {
      this.this$0.c = this.this$0.b;
      if (this.this$0.jdField_a_of_type_JavaUtilTimer != null) {
        this.this$0.jdField_a_of_type_JavaUtilTimer.cancel();
      }
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.3
 * JD-Core Version:    0.7.0.1
 */