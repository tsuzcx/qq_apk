package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class LitePlayer$UiHandler
  extends Handler
{
  private WeakReference<LitePlayer> a;
  
  public LitePlayer$UiHandler(LitePlayer paramLitePlayer)
  {
    this.a = new WeakReference(paramLitePlayer);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.a.get() == null);
      LitePlayer.a((LitePlayer)this.a.get());
      LitePlayer.a((LitePlayer)this.a.get()).sendEmptyMessageDelayed(0, LitePlayer.a((LitePlayer)this.a.get()));
      return;
    } while (this.a.get() == null);
    if (QLog.isColorLevel()) {
      QLog.d(LitePlayer.a((LitePlayer)this.a.get()), 2, "prePlay timeout, try rePlay");
    }
    if ((((LitePlayer)this.a.get()).f()) && (((LitePlayer)this.a.get()).a.a() == LitePlayer.a((LitePlayer)this.a.get())))
    {
      LitePlayer.b((LitePlayer)this.a.get());
      return;
    }
    LitePlayer.a((LitePlayer)this.a.get(), false);
    ((LitePlayer)this.a.get()).a(((LitePlayer)this.a.get()).a);
    LitePlayer.a((LitePlayer)this.a.get(), LitePlayer.a((LitePlayer)this.a.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.UiHandler
 * JD-Core Version:    0.7.0.1
 */