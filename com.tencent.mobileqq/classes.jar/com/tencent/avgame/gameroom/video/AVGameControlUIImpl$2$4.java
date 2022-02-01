package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;

class AVGameControlUIImpl$2$4
  implements Runnable
{
  AVGameControlUIImpl$2$4(AVGameControlUIImpl.2 param2, long paramLong, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.a()) {
      return;
    }
    long l1 = QQAudioHelper.b();
    long l2 = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getLongAccountUin();
    long l3 = this.jdField_a_of_type_Long;
    boolean bool = false;
    int i;
    if (l2 == l3) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_Long == this.jdField_a_of_type_Long))
    {
      Object localObject = AVGameBusinessCtrl.b().a();
      if (localObject != null) {
        bool = ((AVGameSession)localObject).a(this.jdField_a_of_type_Long, true);
      }
      if (bool) {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_Long = 0L;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onMemberVideoInOrOut, ret[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("], uin[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append("]");
        QLog.i("AVGameControlUIImpl", 4, ((StringBuilder)localObject).toString());
      }
    }
    if (i != 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a("onMemberVideoInOrOut", l1);
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.b("onMemberVideoInOrOut", l1);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.c();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a("onMemberVideoInOrOut", l1, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.b("onMemberVideoInOrOut", l1, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.4
 * JD-Core Version:    0.7.0.1
 */