package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import java.util.Timer;
import java.util.TimerTask;
import lid;
import mbw;
import mcb;

public class SmallScreenVideoController$1
  extends TimerTask
{
  public SmallScreenVideoController$1(mbw parammbw) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) || (this.this$0.jdField_a_of_type_Mcb == null)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        lid locallid;
        do
        {
          return;
          locallid = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
        } while (locallid == null);
        if (locallid.R > 0) {
          break;
        }
      } while (this.this$0.jdField_a_of_type_JavaUtilTimer == null);
      this.this$0.jdField_a_of_type_JavaUtilTimer.cancel();
      this.this$0.jdField_a_of_type_JavaUtilTimer = null;
      return;
      l1 = this.this$0.jdField_a_of_type_Mcb.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d);
      l2 = System.currentTimeMillis();
    } while ((l1 == 0L) || (l2 - l1 <= this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().R * 1000));
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.runOnUiThread(new SmallScreenVideoController.1.1(this, l2, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1
 * JD-Core Version:    0.7.0.1
 */