package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mdz;
import meb;

public class AVRedBagConfig$2$1
  implements Runnable
{
  public AVRedBagConfig$2$1(meb parammeb) {}
  
  public void run()
  {
    if (!this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.a.jdField_a_of_type_Lls))
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