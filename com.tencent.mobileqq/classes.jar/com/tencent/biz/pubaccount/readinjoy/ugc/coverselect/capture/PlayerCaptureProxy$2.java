package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import akur;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.Iterator;
import java.util.Set;
import rkt;
import rkz;

public class PlayerCaptureProxy$2
  implements Runnable
{
  public PlayerCaptureProxy$2(rkz paramrkz) {}
  
  public void run()
  {
    if (rkz.a(this.this$0) == null)
    {
      QLog.e("PlayerCaptureProxy", 1, "onPreviewVideoPrepared error for player is null");
      return;
    }
    rkz.a(this.this$0, true);
    int k = rkz.a(this.this$0).getVideoWidth();
    int j = rkz.a(this.this$0).getVideoHeight();
    long l = rkz.a(this.this$0).getDurationMs();
    int m = rkz.a(this.this$0).getVideoRotation();
    int i = DisplayUtil.getScreenSize(BaseApplicationImpl.getContext()).a();
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
        Iterator localIterator = rkz.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          rkt localrkt = (rkt)localIterator.next();
          if (localrkt != null) {
            localrkt.a(k, j, l);
          }
        }
        break;
        k = i;
      }
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PlayerCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */