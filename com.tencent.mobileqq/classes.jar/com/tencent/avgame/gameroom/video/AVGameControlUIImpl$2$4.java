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
    if (this.d.a.d()) {
      return;
    }
    long l1 = QQAudioHelper.d();
    long l2 = this.d.a.g.getLongAccountUin();
    long l3 = this.a;
    boolean bool = false;
    int i;
    if (l2 == l3) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.b) && (this.d.a.p == this.a))
    {
      Object localObject = AVGameBusinessCtrl.b().j();
      if (localObject != null) {
        bool = ((AVGameSession)localObject).a(this.a, true);
      }
      if (bool) {
        this.d.a.p = 0L;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onMemberVideoInOrOut, ret[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("], uin[");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("]");
        QLog.i("AVGameControlUIImpl", 4, ((StringBuilder)localObject).toString());
      }
    }
    if (i != 0)
    {
      if (this.b)
      {
        this.d.a.h.a("onMemberVideoInOrOut", l1);
        return;
      }
      this.d.a.h.b("onMemberVideoInOrOut", l1);
      return;
    }
    if (this.b)
    {
      this.d.a.e();
      this.d.a.h.a("onMemberVideoInOrOut", l1, Long.toString(this.a), this.c);
      return;
    }
    this.d.a.h.b("onMemberVideoInOrOut", l1, Long.toString(this.a), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.4
 * JD-Core Version:    0.7.0.1
 */