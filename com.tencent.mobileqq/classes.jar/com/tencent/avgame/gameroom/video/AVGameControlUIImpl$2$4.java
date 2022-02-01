package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import ncp;
import ncz;
import ndt;

public class AVGameControlUIImpl$2$4
  implements Runnable
{
  public AVGameControlUIImpl$2$4(ncp paramncp, long paramLong, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ncp.a.a()) {
      return;
    }
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Ncp.a.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getLongAccountUin() == this.jdField_a_of_type_Long) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ncp.a.jdField_a_of_type_Long == this.jdField_a_of_type_Long))
      {
        AVGameSession localAVGameSession = ndt.b().a();
        if (localAVGameSession != null) {
          bool = localAVGameSession.a(this.jdField_a_of_type_Long, true);
        }
        if (bool) {
          this.jdField_a_of_type_Ncp.a.jdField_a_of_type_Long = 0L;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameControlUIImpl", 4, "onMemberVideoInOrOut, ret[" + bool + "], uin[" + this.jdField_a_of_type_Long + "]");
        }
      }
      if (i == 0) {
        break label205;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Ncp.a.jdField_a_of_type_Ncz.a("onMemberVideoInOrOut", l);
      return;
    }
    this.jdField_a_of_type_Ncp.a.jdField_a_of_type_Ncz.b("onMemberVideoInOrOut", l);
    return;
    label205:
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ncp.a.c();
      this.jdField_a_of_type_Ncp.a.jdField_a_of_type_Ncz.a("onMemberVideoInOrOut", l, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Ncp.a.jdField_a_of_type_Ncz.b("onMemberVideoInOrOut", l, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.4
 * JD-Core Version:    0.7.0.1
 */