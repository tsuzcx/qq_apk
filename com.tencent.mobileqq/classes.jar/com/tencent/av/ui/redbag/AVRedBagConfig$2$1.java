package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mov;
import mox;

public class AVRedBagConfig$2$1
  implements Runnable
{
  public AVRedBagConfig$2$1(mox parammox) {}
  
  public void run()
  {
    if (!this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.a.jdField_a_of_type_Lwf))
    {
      QLog.w(this.a.a.i, 1, "getAVRedPacketConfig失败" + Thread.currentThread().getId() + "]");
      this.a.a.a(null);
      this.a.a.b(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagConfig.2.1
 * JD-Core Version:    0.7.0.1
 */