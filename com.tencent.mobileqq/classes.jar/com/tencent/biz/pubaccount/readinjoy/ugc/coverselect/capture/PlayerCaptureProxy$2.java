package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.Iterator;
import java.util.Set;

class PlayerCaptureProxy$2
  implements Runnable
{
  PlayerCaptureProxy$2(PlayerCaptureProxy paramPlayerCaptureProxy) {}
  
  public void run()
  {
    if (PlayerCaptureProxy.a(this.this$0) == null)
    {
      QLog.e("PlayerCaptureProxy", 1, "onPreviewVideoPrepared error for player is null");
      return;
    }
    PlayerCaptureProxy.a(this.this$0, true);
    int k = PlayerCaptureProxy.a(this.this$0).getVideoWidth();
    int j = PlayerCaptureProxy.a(this.this$0).getVideoHeight();
    long l = PlayerCaptureProxy.a(this.this$0).getDurationMs();
    int m = PlayerCaptureProxy.a(this.this$0).getVideoRotation();
    int i = DisplayUtil.a(BaseApplicationImpl.getContext()).a();
    if (k > i)
    {
      float f = k / i;
      j = (int)(j / f);
    }
    for (;;)
    {
      if ((m == 90) || (m == 270))
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        Iterator localIterator = PlayerCaptureProxy.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          CapturePreparedListener localCapturePreparedListener = (CapturePreparedListener)localIterator.next();
          if (localCapturePreparedListener != null) {
            localCapturePreparedListener.a(k, j, l);
          }
        }
        break;
        k = i;
      }
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PlayerCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */