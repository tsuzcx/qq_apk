package com.tencent.component.media.image.region;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.component.media.utils.ImageManagerLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

final class RegionBitmapDecoder$WorkHandler
  extends Handler
{
  public RegionBitmapDecoder$WorkHandler(RegionBitmapDecoder paramRegionBitmapDecoder, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int n;
    long l1;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          RegionBitmapDecoder.access$000(this.this$0);
          if ((RegionBitmapDecoder.access$100(this.this$0) == null) || (RegionBitmapDecoder.access$200(this.this$0) == 0) || (RegionBitmapDecoder.access$300(this.this$0) == 0))
          {
            paramMessage = new StringBuilder().append(" initRegionDecoder:  mRegionDecoder = null ? :  ");
            if (RegionBitmapDecoder.access$100(this.this$0) == null) {}
            for (boolean bool = true;; bool = false)
            {
              ImageManagerLog.i("RegionBitmapDecoder", bool + " mOrgImageWidth = " + RegionBitmapDecoder.access$200(this.this$0) + " orgImageHeight = " + RegionBitmapDecoder.access$300(this.this$0));
              return;
            }
          }
        } while (!RegionDrawableData.class.isInstance(paramMessage.obj));
        paramMessage = (RegionDrawableData)paramMessage.obj;
        n = paramMessage.calcSample();
      } while (n == 0);
      RegionBitmapDecoder.access$400(this.this$0, paramMessage);
      if (RegionBitmapDecoder.access$500(this.this$0) == null) {
        RegionBitmapDecoder.access$502(this.this$0, new RegionBitmapBlockHelper(new Rect(0, 0, RegionBitmapDecoder.access$200(this.this$0), RegionBitmapDecoder.access$300(this.this$0))));
      }
      l1 = SystemClock.uptimeMillis();
      localObject1 = new Rect(paramMessage.mShowArea);
      ??? = RegionBitmapDecoder.access$500(this.this$0).getDrawDatas((Rect)localObject1, n);
      localObject1 = new HashMap();
    } while (??? == null);
    ??? = ((LinkedList)???).iterator();
    int j = 0;
    int k = 0;
    if (((Iterator)???).hasNext())
    {
      RegionBitmapDecoder.DrawData localDrawData1 = (RegionBitmapDecoder.DrawData)((Iterator)???).next();
      RegionBitmapDecoder.DrawData localDrawData2 = (RegionBitmapDecoder.DrawData)RegionBitmapDecoder.access$600(this.this$0).get(localDrawData1.mShowRect);
      if (localDrawData2 == null)
      {
        localDrawData1.mOrgRect = RegionBitmapDecoder.access$700(this.this$0, new Rect(localDrawData1.mShowRect));
        ((HashMap)localObject1).put(localDrawData1.mShowRect, localDrawData1);
      }
      for (i = k + 1;; i = k)
      {
        k = i;
        break;
        ((HashMap)localObject1).put(localDrawData2.mShowRect, localDrawData2);
        j += 1;
      }
    }
    long l2 = SystemClock.uptimeMillis();
    for (;;)
    {
      synchronized (RegionBitmapDecoder.access$800(this.this$0))
      {
        RegionBitmapDecoder.access$602(this.this$0, (HashMap)localObject1);
        long l3 = SystemClock.uptimeMillis();
        m = 0;
        i = 0;
        try
        {
          localObject1 = RegionBitmapDecoder.access$600(this.this$0).entrySet().iterator();
          m = i;
          if (((Iterator)localObject1).hasNext())
          {
            m = i;
            ??? = (RegionBitmapDecoder.DrawData)((Map.Entry)((Iterator)localObject1).next()).getValue();
            m = i;
            if (n == ((RegionBitmapDecoder.DrawData)???).mDecodeSample)
            {
              m = i;
              if (((RegionBitmapDecoder.DrawData)???).mBitmap != null)
              {
                m = i;
                if (((RegionBitmapDecoder.DrawData)???).mOrgRect != null)
                {
                  m = i;
                  if (!((RegionBitmapDecoder.DrawData)???).mOrgRect.isEmpty()) {
                    continue;
                  }
                }
              }
            }
            m = i;
            if (RegionBitmapDecoder.access$900(this.this$0) == paramMessage.mTaskTime) {
              break label725;
            }
            m = i;
            ImageManagerLog.i("RegionBitmapDecoder", "stop decode ");
          }
        }
        catch (Exception paramMessage)
        {
          i = m;
          paramMessage.printStackTrace();
          continue;
        }
        if (SystemClock.uptimeMillis() - l3 == 0L) {
          break;
        }
        ImageManagerLog.i("RegionBitmapDecoder", "选取有效块:cost " + (l2 - l1));
        ImageManagerLog.i("RegionBitmapDecoder", "解析有效块:cost " + (SystemClock.uptimeMillis() - l3));
        ImageManagerLog.i("RegionBitmapDecoder", "分块：" + RegionBitmapDecoder.access$600(this.this$0).size());
        ImageManagerLog.i("RegionBitmapDecoder", "invalidSize：" + k + " reUseSize :" + j + " refreshDecodeSize: " + i);
        return;
      }
      label725:
      m = i;
      RegionBitmapDecoder.access$1000(this.this$0, (RegionBitmapDecoder.DrawData)???, n);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionBitmapDecoder.WorkHandler
 * JD-Core Version:    0.7.0.1
 */