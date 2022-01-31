package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.Iterator;
import java.util.Set;
import qrv;
import qsb;

public class PlayerCaptureProxy$2
  implements Runnable
{
  public PlayerCaptureProxy$2(qsb paramqsb) {}
  
  public void run()
  {
    if (qsb.a(this.this$0) == null) {
      QLog.e("PlayerCaptureProxy", 1, "onPreviewVideoPrepared error for player is null");
    }
    for (;;)
    {
      return;
      qsb.a(this.this$0, true);
      int i = qsb.a(this.this$0).getVideoWidth();
      int j = qsb.a(this.this$0).getVideoHeight();
      long l = qsb.a(this.this$0).getDurationMs();
      Iterator localIterator = qsb.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        qrv localqrv = (qrv)localIterator.next();
        if (localqrv != null) {
          localqrv.a(i, j, l);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PlayerCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */