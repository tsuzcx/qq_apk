package com.tencent.av.ui.redbag;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;

class AVRedBag$2
  extends VideoObserver
{
  AVRedBag$2(AVRedBag paramAVRedBag) {}
  
  public void a(long paramLong)
  {
    int i = this.a.a.a().a().d;
    if ((i == 2) || (i == 1))
    {
      RedBagReport.a(this.a.a.a().c());
      RedBagReport.g();
      d(3);
      return;
    }
    RedBagReport.a(0L);
  }
  
  public void b(long paramLong)
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr != null) {
      localAVRedBagMgr.b("onResumeVideo");
    }
  }
  
  public void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.c(paramBoolean);
    }
    RedBagReport.h();
  }
  
  public void c()
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr != null) {
      localAVRedBagMgr.b("onPauseVideo");
    }
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = this.a.a.a().a().d;
      } while ((i != 2) && (i != 1));
      if (paramBoolean)
      {
        if (paramString.a != null) {
          paramString.a.a("onPeerSwitchTerminal");
        }
        paramString.b("onPeerSwitchTerminal");
        return;
      }
      paramString.a("onPeerSwitchTerminal");
    } while (paramString.a == null);
    paramString.a(paramString.a.b);
  }
  
  void d(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr != null)
    {
      localAVRedBagMgr.a("onConnected:" + paramInt);
      if (localAVRedBagMgr.a != null) {
        localAVRedBagMgr.a(localAVRedBagMgr.a.b);
      }
    }
    this.a.a.a().postDelayed(new AVRedBag.2.1(this, paramInt), 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.2
 * JD-Core Version:    0.7.0.1
 */