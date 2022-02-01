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
    int i = paramMessage.what;
    boolean bool = true;
    if (i != 1) {
      return;
    }
    RegionBitmapDecoder.access$000(this.this$0);
    Object localObject1 = RegionBitmapDecoder.access$100(this.this$0);
    int j = 0;
    i = 0;
    if ((localObject1 != null) && (RegionBitmapDecoder.access$200(this.this$0) != 0) && (RegionBitmapDecoder.access$300(this.this$0) != 0))
    {
      if (!RegionDrawableData.class.isInstance(paramMessage.obj)) {
        return;
      }
      paramMessage = (RegionDrawableData)paramMessage.obj;
      int i1 = paramMessage.calcSample();
      if (i1 == 0) {
        return;
      }
      RegionBitmapDecoder.access$400(this.this$0, paramMessage);
      if (RegionBitmapDecoder.access$500(this.this$0) == null)
      {
        localObject1 = this.this$0;
        RegionBitmapDecoder.access$502((RegionBitmapDecoder)localObject1, new RegionBitmapBlockHelper(new Rect(0, 0, RegionBitmapDecoder.access$200((RegionBitmapDecoder)localObject1), RegionBitmapDecoder.access$300(this.this$0))));
      }
      long l1 = SystemClock.uptimeMillis();
      localObject1 = new Rect(paramMessage.mShowArea);
      ??? = RegionBitmapDecoder.access$500(this.this$0).getDrawDatas((Rect)localObject1, i1);
      localObject1 = new HashMap();
      if (??? == null) {
        return;
      }
      ??? = ((LinkedList)???).iterator();
      int m = 0;
      int k = 0;
      while (((Iterator)???).hasNext())
      {
        RegionBitmapDecoder.DrawData localDrawData1 = (RegionBitmapDecoder.DrawData)((Iterator)???).next();
        RegionBitmapDecoder.DrawData localDrawData2 = (RegionBitmapDecoder.DrawData)RegionBitmapDecoder.access$600(this.this$0).get(localDrawData1.mShowRect);
        if (localDrawData2 == null)
        {
          localDrawData1.mOrgRect = RegionBitmapDecoder.access$700(this.this$0, new Rect(localDrawData1.mShowRect));
          ((HashMap)localObject1).put(localDrawData1.mShowRect, localDrawData1);
          k += 1;
        }
        else
        {
          ((HashMap)localObject1).put(localDrawData2.mShowRect, localDrawData2);
          m += 1;
        }
      }
      long l2 = SystemClock.uptimeMillis();
      synchronized (RegionBitmapDecoder.access$800(this.this$0))
      {
        RegionBitmapDecoder.access$602(this.this$0, (HashMap)localObject1);
        long l3 = SystemClock.uptimeMillis();
        try
        {
          localObject1 = RegionBitmapDecoder.access$600(this.this$0).entrySet().iterator();
          int n;
          for (;;)
          {
            j = i;
            n = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            j = i;
            ??? = (RegionBitmapDecoder.DrawData)((Map.Entry)((Iterator)localObject1).next()).getValue();
            j = i;
            if (i1 == ((RegionBitmapDecoder.DrawData)???).mDecodeSample)
            {
              j = i;
              if (((RegionBitmapDecoder.DrawData)???).mBitmap != null)
              {
                j = i;
                if (((RegionBitmapDecoder.DrawData)???).mOrgRect != null)
                {
                  j = i;
                  if (!((RegionBitmapDecoder.DrawData)???).mOrgRect.isEmpty()) {
                    continue;
                  }
                }
              }
            }
            j = i;
            if (RegionBitmapDecoder.access$900(this.this$0) != paramMessage.mTaskTime)
            {
              j = i;
              ImageManagerLog.i("RegionBitmapDecoder", "stop decode ");
              n = i;
              break;
            }
            j = i;
            RegionBitmapDecoder.access$1000(this.this$0, (RegionBitmapDecoder.DrawData)???, i1);
            i += 1;
          }
          paramMessage = finally;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          n = j;
          if (SystemClock.uptimeMillis() - l3 != 0L)
          {
            paramMessage = new StringBuilder();
            paramMessage.append("选取有效块:cost ");
            paramMessage.append(l2 - l1);
            ImageManagerLog.i("RegionBitmapDecoder", paramMessage.toString());
            paramMessage = new StringBuilder();
            paramMessage.append("解析有效块:cost ");
            paramMessage.append(SystemClock.uptimeMillis() - l3);
            ImageManagerLog.i("RegionBitmapDecoder", paramMessage.toString());
            paramMessage = new StringBuilder();
            paramMessage.append("分块：");
            paramMessage.append(RegionBitmapDecoder.access$600(this.this$0).size());
            ImageManagerLog.i("RegionBitmapDecoder", paramMessage.toString());
            paramMessage = new StringBuilder();
            paramMessage.append("invalidSize：");
            paramMessage.append(k);
            paramMessage.append(" reUseSize :");
            paramMessage.append(m);
            paramMessage.append(" refreshDecodeSize: ");
            paramMessage.append(n);
            ImageManagerLog.i("RegionBitmapDecoder", paramMessage.toString());
          }
          return;
        }
      }
    }
    paramMessage = new StringBuilder();
    paramMessage.append(" initRegionDecoder:  mRegionDecoder = null ? :  ");
    if (RegionBitmapDecoder.access$100(this.this$0) != null) {
      bool = false;
    }
    paramMessage.append(bool);
    paramMessage.append(" mOrgImageWidth = ");
    paramMessage.append(RegionBitmapDecoder.access$200(this.this$0));
    paramMessage.append(" orgImageHeight = ");
    paramMessage.append(RegionBitmapDecoder.access$300(this.this$0));
    ImageManagerLog.i("RegionBitmapDecoder", paramMessage.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionBitmapDecoder.WorkHandler
 * JD-Core Version:    0.7.0.1
 */