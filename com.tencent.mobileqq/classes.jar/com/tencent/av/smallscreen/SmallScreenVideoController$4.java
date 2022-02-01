package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import lff;
import lzi;
import lzu;

public class SmallScreenVideoController$4
  implements Runnable
{
  public SmallScreenVideoController$4(lzu paramlzu) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI instanceof lzi))
    {
      String str = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      int i = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().R;
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), str, Integer.valueOf(i) });
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.4
 * JD-Core Version:    0.7.0.1
 */