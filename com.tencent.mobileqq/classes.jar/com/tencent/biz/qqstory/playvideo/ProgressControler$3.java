package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;
import vng;

public class ProgressControler$3
  extends TimerTask
{
  public ProgressControler$3(vng paramvng) {}
  
  public void run()
  {
    vng localvng = this.this$0;
    localvng.c += 50L;
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
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler.3
 * JD-Core Version:    0.7.0.1
 */