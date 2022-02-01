package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import java.util.Timer;
import java.util.TimerTask;
import lff;
import lzu;
import lzz;

public class SmallScreenVideoController$1
  extends TimerTask
{
  public SmallScreenVideoController$1(lzu paramlzu) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) || (this.this$0.jdField_a_of_type_Lzz == null)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        lff locallff;
        do
        {
          return;
          locallff = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
        } while (locallff == null);
        if (locallff.S > 0) {
          break;
        }
      } while (this.this$0.jdField_a_of_type_JavaUtilTimer == null);
      this.this$0.jdField_a_of_type_JavaUtilTimer.cancel();
      this.this$0.jdField_a_of_type_JavaUtilTimer = null;
      return;
      l1 = this.this$0.jdField_a_of_type_Lzz.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d);
      l2 = System.currentTimeMillis();
    } while ((l1 == 0L) || (l2 - l1 <= this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().S * 1000));
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.runOnUiThread(new SmallScreenVideoController.1.1(this, l2, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1
 * JD-Core Version:    0.7.0.1
 */