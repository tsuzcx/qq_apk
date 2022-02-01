package com.tencent.luggage.scanner.qbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.qbar.QBar.QBarResult;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class LuggageFileDecodeQueue$a
  implements Runnable
{
  private String b;
  private QbarNative.QbarAiModelParam c;
  private int[] d = { 1, 2, 4, 5 };
  
  public LuggageFileDecodeQueue$a(LuggageFileDecodeQueue paramLuggageFileDecodeQueue, String paramString, QbarNative.QbarAiModelParam paramQbarAiModelParam, int[] paramArrayOfInt)
  {
    this.b = paramString;
    this.c = paramQbarAiModelParam;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      this.d = paramArrayOfInt;
    }
  }
  
  public void run()
  {
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject8;
    try
    {
      Object localObject6 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject6).inJustDecodeBounds = true;
      com.tencent.luggage.wxa.qz.b.a(this.b, (BitmapFactory.Options)localObject6);
      localObject8 = new BitmapFactory.Options();
      if (((BitmapFactory.Options)localObject6).outWidth * ((BitmapFactory.Options)localObject6).outHeight * 3 > 10485760)
      {
        o.d("LuggageFileDecodeQueue", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject6).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject6).outHeight) });
        ((BitmapFactory.Options)localObject8).inSampleSize = 2;
      }
      localObject6 = com.tencent.luggage.wxa.qz.b.a(this.b, (BitmapFactory.Options)localObject8);
    }
    catch (Exception localException)
    {
      localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append("decode file to bitmap error! ");
      ((StringBuilder)localObject8).append(localException.getMessage());
      o.b("LuggageFileDecodeQueue", ((StringBuilder)localObject8).toString());
      ??? = null;
    }
    Object localObject4;
    synchronized (LuggageFileDecodeQueue.a(this.a))
    {
      System.currentTimeMillis();
      if (!LuggageFileDecodeQueue.a(this.a).a()) {
        LuggageFileDecodeQueue.a(this.a).a(1, this.c);
      }
      if (LuggageFileDecodeQueue.a(this.a).a()) {
        LuggageFileDecodeQueue.a(this.a).a(this.d);
      }
      if (??? != null)
      {
        if ((b.a.contains(r.b())) && (???.getWidth() * ???.getHeight() * 4 > 104857600))
        {
          o.b("LuggageFileDecodeQueue", "bitmap data over malloc limit, width: %d, height: %d, return", new Object[] { Integer.valueOf(???.getWidth()), Integer.valueOf(???.getHeight()) });
          localObject5 = null;
        }
        else
        {
          o.d("LuggageFileDecodeQueue", "width: %d, height: %d", new Object[] { Integer.valueOf(???.getWidth()), Integer.valueOf(???.getHeight()) });
          localObject1 = new int[???.getWidth() * ???.getHeight()];
          ???.getPixels((int[])localObject1, 0, ???.getWidth(), 0, 0, ???.getWidth(), ???.getHeight());
          localObject8 = new ArrayList();
          List localList = LuggageFileDecodeQueue.a(this.a).a((int[])localObject1, new Point(???.getWidth(), ???.getHeight()), (List)localObject8);
          int i;
          if (localList == null) {
            i = 0;
          } else {
            i = localList.size();
          }
          o.d("LuggageFileDecodeQueue", "get %d decode results", new Object[] { Integer.valueOf(i) });
          System.currentTimeMillis();
          localObject1 = localList;
          localObject5 = localObject8;
          if (localList != null)
          {
            localObject1 = localList;
            localObject5 = localObject8;
            if (!localList.isEmpty())
            {
              Iterator localIterator = localList.iterator();
              for (;;)
              {
                localObject1 = localList;
                localObject5 = localObject8;
                if (!localIterator.hasNext()) {
                  break;
                }
                localObject1 = (QBar.QBarResult)localIterator.next();
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("result ");
                ((StringBuilder)localObject5).append(((QBar.QBarResult)localObject1).typeName);
                ((StringBuilder)localObject5).append(",");
                ((StringBuilder)localObject5).append(((QBar.QBarResult)localObject1).data);
                o.d("LuggageFileDecodeQueue", ((StringBuilder)localObject5).toString());
              }
            }
          }
        }
        ???.recycle();
        synchronized (LuggageFileDecodeQueue.b(this.a))
        {
          if (LuggageFileDecodeQueue.c(this.a).containsKey(this.b))
          {
            localObject8 = ((List)LuggageFileDecodeQueue.c(this.a).get(this.b)).iterator();
            while (((Iterator)localObject8).hasNext())
            {
              long l = ((Long)((Iterator)localObject8).next()).longValue();
              if (LuggageFileDecodeQueue.d(this.a).containsKey(Long.valueOf(l)))
              {
                ((LuggageFileDecodeQueue.FileDecodeCallBack)LuggageFileDecodeQueue.d(this.a).get(Long.valueOf(l))).afterDecode(l, (List)localObject1, (List)localObject5);
                LuggageFileDecodeQueue.d(this.a).remove(Long.valueOf(l));
              }
              LuggageFileDecodeQueue.e(this.a).remove(Long.valueOf(l));
            }
            LuggageFileDecodeQueue.c(this.a).remove(this.b);
          }
          if (LuggageFileDecodeQueue.c(this.a).isEmpty())
          {
            o.d("LuggageFileDecodeQueue", "release QBar");
            LuggageFileDecodeQueue.a(this.a).c();
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.LuggageFileDecodeQueue.a
 * JD-Core Version:    0.7.0.1
 */