package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;

class AVRedBagMgr$2
  implements SendRedBag.SendRedBagListener
{
  AVRedBagMgr$2(AVRedBagMgr paramAVRedBagMgr) {}
  
  public void a(SendRedBag paramSendRedBag)
  {
    AVRedBagMgr localAVRedBagMgr = this.a;
    if (paramSendRedBag.b == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localAVRedBagMgr.a(bool, paramSendRedBag.g, paramSendRedBag.c);
      this.a.a = null;
      AVRedBagMgr.b(this.a).a(new Object[] { Integer.valueOf(8003), Integer.valueOf(7) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr.2
 * JD-Core Version:    0.7.0.1
 */