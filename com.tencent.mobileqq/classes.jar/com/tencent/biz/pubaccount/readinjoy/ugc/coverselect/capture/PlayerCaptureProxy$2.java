package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import alsn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.Iterator;
import java.util.Set;
import rxg;
import rxm;

public class PlayerCaptureProxy$2
  implements Runnable
{
  public PlayerCaptureProxy$2(rxm paramrxm) {}
  
  public void run()
  {
    if (rxm.a(this.this$0) == null)
    {
      QLog.e("PlayerCaptureProxy", 1, "onPreviewVideoPrepared error for player is null");
      return;
    }
    rxm.a(this.this$0, true);
    int k = rxm.a(this.this$0).getVideoWidth();
    int j = rxm.a(this.this$0).getVideoHeight();
    long l = rxm.a(this.this$0).getDurationMs();
    int m = rxm.a(this.this$0).getVideoRotation();
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
        Iterator localIterator = rxm.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          rxg localrxg = (rxg)localIterator.next();
          if (localrxg != null) {
            localrxg.a(k, j, l);
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