package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class WSVideoPluginInstall$3
  implements Handler.Callback
{
  WSVideoPluginInstall$3(WSVideoPluginInstall paramWSVideoPluginInstall) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          WSVideoPluginInstall.a(this.a, false);
          WSVideoPluginInstall.a(this.a).removeMessages(0);
        } while (WSVideoPluginInstall.a(this.a) == null);
        WSVideoPluginInstall.a(this.a).a(true);
        return true;
        WSVideoPluginInstall.a(this.a, false);
        WSVideoPluginInstall.a(this.a).removeMessages(1);
      } while (WSVideoPluginInstall.a(this.a) == null);
      WSVideoPluginInstall.a(this.a).a(false);
      return true;
    }
    WSVideoPluginInstall.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.3
 * JD-Core Version:    0.7.0.1
 */