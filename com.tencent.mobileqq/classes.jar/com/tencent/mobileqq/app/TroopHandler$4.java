package com.tencent.mobileqq.app;

import aoep;
import bfft;
import bfge;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;

public class TroopHandler$4
  implements Runnable
{
  public TroopHandler$4(aoep paramaoep, oidb_0x496.AioKeyword paramAioKeyword) {}
  
  public void run()
  {
    ((bfge)this.this$0.app.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER)).a(bfft.a(this.a), bfft.b(this.a));
    bfft.a(this.this$0.app, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.4
 * JD-Core Version:    0.7.0.1
 */