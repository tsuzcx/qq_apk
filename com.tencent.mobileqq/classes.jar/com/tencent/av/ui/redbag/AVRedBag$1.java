package com.tencent.av.ui.redbag;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.redpacket.AVRedPacketManager;

class AVRedBag$1
  extends CameraObserver
{
  AVRedBag$1(AVRedBag paramAVRedBag) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    c();
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    c();
  }
  
  void c()
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if ((localAVRedBagMgr != null) && (localAVRedBagMgr.a())) {
      ((AVRedPacketManager)this.a.a.a(6)).c(this.a.a.a().a().j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.1
 * JD-Core Version:    0.7.0.1
 */