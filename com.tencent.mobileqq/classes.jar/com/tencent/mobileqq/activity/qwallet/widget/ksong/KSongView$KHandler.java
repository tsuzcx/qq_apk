package com.tencent.mobileqq.activity.qwallet.widget.ksong;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class KSongView$KHandler
  extends Handler
{
  WeakReference<KSongView> mKSongView;
  
  public KSongView$KHandler(KSongView paramKSongView)
  {
    this.mKSongView = new WeakReference(paramKSongView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      paramMessage = (KSongView)this.mKSongView.get();
      if ((paramMessage != null) && (1 == paramMessage.getState())) {
        break label31;
      }
    }
    label31:
    do
    {
      return;
      long l = System.currentTimeMillis() - KSongView.access$000(paramMessage) - paramMessage.startTime;
      KSHelper.Config localConfig = paramMessage.getConfig();
      paramMessage.updateProsBar(l);
      if (l >= localConfig.pretime) {
        KSongView.access$100(paramMessage, l);
      }
      QLog.i("KSongView", 2, "real_duration = " + l);
      if (l < localConfig.total)
      {
        sendEmptyMessageDelayed(0, 50L);
        return;
      }
      KSongView.access$202(paramMessage, 3);
    } while (KSongView.access$300(paramMessage) == null);
    KSongView.access$300(paramMessage).complete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.ksong.KSongView.KHandler
 * JD-Core Version:    0.7.0.1
 */