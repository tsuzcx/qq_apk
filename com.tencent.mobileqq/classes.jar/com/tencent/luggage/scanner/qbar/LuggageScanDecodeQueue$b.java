package com.tencent.luggage.scanner.qbar;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qbar.QBar;
import com.tencent.qbar.QBar.QBarResult;
import com.tencent.qbar.QbarNative.QBarZoomInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class LuggageScanDecodeQueue$b
  implements Runnable
{
  private long b;
  private byte[] c;
  private Point d;
  
  LuggageScanDecodeQueue$b(LuggageScanDecodeQueue paramLuggageScanDecodeQueue, long paramLong)
  {
    this.b = paramLong;
  }
  
  public void run()
  {
    int i;
    label990:
    synchronized (LuggageScanDecodeQueue.b(this.a))
    {
      if (this.b == LuggageScanDecodeQueue.c(this.a))
      {
        LuggageScanDecodeQueue.b(this.a, true);
        if (!LuggageScanDecodeQueue.d(this.a).isEmpty())
        {
          localObject4 = (byte[])LuggageScanDecodeQueue.d(this.a).get("param_gray_data");
          this.c = Arrays.copyOf((byte[])localObject4, localObject4.length);
          this.d = new Point((Point)LuggageScanDecodeQueue.d(this.a).get("param_out_size"));
          LuggageScanDecodeQueue.d(this.a).clear();
        }
        long l = System.currentTimeMillis();
        ??? = new ArrayList();
        Object localObject4 = new ArrayList();
        if ((this.c != null) && (this.d != null)) {
          synchronized (LuggageScanDecodeQueue.a(this.a))
          {
            if (LuggageScanDecodeQueue.a(this.a).a())
            {
              LuggageScanDecodeQueue.i(this.a);
              if (LuggageScanDecodeQueue.j(this.a))
              {
                LuggageScanDecodeQueue.k(this.a);
                o.d("Luggage.WxScanDecodeQueue", "alvinluo decodeGrayData isZooming and reset, currentFrameNumWhenZooming: %d", new Object[] { Integer.valueOf(LuggageScanDecodeQueue.l(this.a)) });
              }
              List localList = LuggageScanDecodeQueue.a(this.a).a(this.c, this.d.x, this.d.y, (List)localObject4, (List)???);
              Object localObject7 = LuggageScanDecodeQueue.a(this.a).b();
              this.c = null;
              this.d = null;
              int k = (int)(System.currentTimeMillis() - l);
              synchronized (LuggageScanDecodeQueue.b(this.a))
              {
                if (this.b == LuggageScanDecodeQueue.c(this.a))
                {
                  Object localObject8 = QBar.getVersion();
                  if (localList == null) {
                    i = 0;
                  } else {
                    i = localList.size();
                  }
                  o.d("Luggage.WxScanDecodeQueue", "qbar version %s, get %d decode results", new Object[] { localObject8, Integer.valueOf(i) });
                  if (localList != null)
                  {
                    localObject8 = localList.iterator();
                    while (((Iterator)localObject8).hasNext())
                    {
                      QBar.QBarResult localQBarResult = (QBar.QBarResult)((Iterator)localObject8).next();
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("result ");
                      localStringBuilder.append(localQBarResult.typeName);
                      localStringBuilder.append(",");
                      localStringBuilder.append(localQBarResult.data);
                      o.d("Luggage.WxScanDecodeQueue", localStringBuilder.toString());
                    }
                  }
                  localObject8 = new Bundle();
                  if (localObject7 == null) {
                    break label990;
                  }
                  o.d("Luggage.WxScanDecodeQueue", "isZoom %b, zoomFactor %f", new Object[] { Boolean.valueOf(((QbarNative.QBarZoomInfo)localObject7).isZoom), Float.valueOf(((QbarNative.QBarZoomInfo)localObject7).zoomFactor) });
                  if ((localList != null) && ((!localList.isEmpty()) || (!((QbarNative.QBarZoomInfo)localObject7).isZoom))) {
                    break label990;
                  }
                  ((Bundle)localObject8).putFloat("param_zoom_ratio", ((QbarNative.QBarZoomInfo)localObject7).zoomFactor);
                  i = 1;
                  boolean bool1 = LuggageScanDecodeQueue.a(this.a, localList);
                  boolean bool2 = LuggageScanDecodeQueue.j(this.a);
                  int j;
                  if (localList == null) {
                    j = 0;
                  } else {
                    j = localList.size();
                  }
                  o.d("Luggage.WxScanDecodeQueue", "alvinluo decodeGrayData ignoreResult: %b, isZooming: %b, result size: %d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j) });
                  if (!((Bundle)localObject8).isEmpty()) {
                    LuggageScanDecodeQueue.g(this.a).notifyEvent(this.b, (Bundle)localObject8);
                  }
                  if ((localList != null) && (!localList.isEmpty()) && (!bool1))
                  {
                    localObject7 = new Bundle();
                    o.f("Luggage.WxScanDecodeQueue", "alvinluo decodeSuccess result size: %d, isZooming: %b, timeCost", new Object[] { Integer.valueOf(localList.size()), Boolean.valueOf(LuggageScanDecodeQueue.j(this.a)), Integer.valueOf(k) });
                    if ((localList.size() > 1) && (LuggageScanDecodeQueue.j(this.a))) {
                      ((Bundle)localObject7).putParcelable("decode_success_frame_data", LuggageScanDecodeQueue.m(this.a));
                    }
                    ((Bundle)localObject7).putString("decode_debug_string", "");
                    ((Bundle)localObject7).putLong("decode_success_cost_time", System.currentTimeMillis() - LuggageScanDecodeQueue.n(this.a));
                    LuggageScanDecodeQueue.g(this.a).onDecodeSuccess(LuggageScanDecodeQueue.c(this.a), localList, (List)localObject4, (List)???, (Bundle)localObject7);
                  }
                  else
                  {
                    if ((i != 0) && (LuggageScanDecodeQueue.o(this.a)))
                    {
                      LuggageScanDecodeQueue.p(this.a);
                      LuggageScanDecodeQueue.q(this.a);
                    }
                    LuggageScanDecodeQueue.h(this.a);
                  }
                  LuggageScanDecodeQueue.b(this.a, false);
                }
                else
                {
                  LuggageScanDecodeQueue.b(this.a, false);
                  LuggageScanDecodeQueue.h(this.a);
                }
                return;
              }
            }
            this.c = null;
            this.d = null;
            LuggageScanDecodeQueue.b(this.a, false);
            LuggageScanDecodeQueue.h(this.a);
            return;
          }
        }
        LuggageScanDecodeQueue.b(this.a, false);
        LuggageScanDecodeQueue.h(this.a);
        return;
      }
      LuggageScanDecodeQueue.b(this.a, false);
      LuggageScanDecodeQueue.h(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.b
 * JD-Core Version:    0.7.0.1
 */