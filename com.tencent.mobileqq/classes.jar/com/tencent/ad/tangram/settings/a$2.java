package com.tencent.ad.tangram.settings;

import com.tencent.ad.tangram.protocol.gdt_settings.Settings;

class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public void run()
  {
    gdt_settings.Settings localSettings = a.access$400(this.this$0).getCacheByIPC();
    a.access$000(this.this$0, localSettings);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.a.2
 * JD-Core Version:    0.7.0.1
 */