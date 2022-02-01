package com.tencent.mobileqq.activity.qwallet.redpacket.specify;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class SpecifyRedPacketAnimMsg$1
  implements FrameSprite.OnFrameEndListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  SpecifyRedPacketAnimMsg$1(SpecifyRedPacketAnimMsg paramSpecifyRedPacketAnimMsg, FrameSprite.OnFrameEndListener paramOnFrameEndListener) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim onFrameEnd");
    }
    if ((this.jdField_a_of_type_Boolean) || (SpecifyRedPacketAnimMsg.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg))) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (SpecifyRedPacketAnimMsg.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg) != null) {
        ThreadManager.getUIHandler().removeCallbacks(SpecifyRedPacketAnimMsg.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg));
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener == null);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg.1
 * JD-Core Version:    0.7.0.1
 */