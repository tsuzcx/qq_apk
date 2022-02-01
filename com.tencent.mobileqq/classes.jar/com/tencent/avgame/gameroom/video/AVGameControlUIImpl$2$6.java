package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;

class AVGameControlUIImpl$2$6
  implements Runnable
{
  AVGameControlUIImpl$2$6(AVGameControlUIImpl.2 param2, long paramLong, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (this.d.a.d()) {
      return;
    }
    long l1 = QQAudioHelper.d();
    long l2 = this.d.a.g.getLongAccountUin();
    long l3 = this.a;
    int i;
    if ((l2 != l3) && (l3 != -1L)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      this.d.a.h.c(this.b);
      return;
    }
    if (this.b)
    {
      this.d.a.e();
      this.d.a.h.a("onMemberShareInOrOut", l1, Long.toString(this.a), this.c);
      return;
    }
    this.d.a.h.b("onMemberShareInOrOut", l1, Long.toString(this.a), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.6
 * JD-Core Version:    0.7.0.1
 */