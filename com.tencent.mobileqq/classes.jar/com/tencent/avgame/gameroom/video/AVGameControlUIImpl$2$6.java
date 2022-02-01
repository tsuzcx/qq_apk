package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import nfj;
import nfy;

public class AVGameControlUIImpl$2$6
  implements Runnable
{
  public AVGameControlUIImpl$2$6(nfj paramnfj, long paramLong, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Nfj.a.a()) {
      return;
    }
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Nfj.a.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getLongAccountUin() == this.jdField_a_of_type_Long) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_Nfj.a.jdField_a_of_type_Nfy.c(this.jdField_a_of_type_Boolean);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Nfj.a.c();
      this.jdField_a_of_type_Nfj.a.jdField_a_of_type_Nfy.a("onMemberShareInOrOut", l, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Nfj.a.jdField_a_of_type_Nfy.b("onMemberShareInOrOut", l, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.6
 * JD-Core Version:    0.7.0.1
 */