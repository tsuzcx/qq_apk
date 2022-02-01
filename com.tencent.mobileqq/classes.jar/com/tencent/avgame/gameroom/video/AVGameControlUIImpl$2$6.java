package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;

class AVGameControlUIImpl$2$6
  implements Runnable
{
  AVGameControlUIImpl$2$6(AVGameControlUIImpl.2 param2, long paramLong, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.a()) {
      return;
    }
    long l1 = QQAudioHelper.b();
    long l2 = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getLongAccountUin();
    long l3 = this.jdField_a_of_type_Long;
    int i;
    if ((l2 != l3) && (l3 != -1L)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.c(this.jdField_a_of_type_Boolean);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.c();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a("onMemberShareInOrOut", l1, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$2.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.b("onMemberShareInOrOut", l1, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.6
 * JD-Core Version:    0.7.0.1
 */