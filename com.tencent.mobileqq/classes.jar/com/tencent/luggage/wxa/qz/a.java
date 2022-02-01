package com.tencent.luggage.wxa.qz;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class a
{
  private static final WeakHashMap<Bitmap, a.a> a = new WeakHashMap();
  private static final Handler b;
  private static boolean c;
  
  static
  {
    if (b())
    {
      b = null;
      localHandlerThread = new HandlerThread("BitmapBriefTracer");
      localHandlerThread.start();
      new v(localHandlerThread.getLooper(), new a.1(), true).a(120000L);
      return;
    }
    HandlerThread localHandlerThread = new HandlerThread("BitmapTracer");
    localHandlerThread.start();
    b = new Handler(localHandlerThread.getLooper(), new a.2());
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    return a(paramBitmap, null, null);
  }
  
  public static Bitmap a(Bitmap paramBitmap, String arg1, BitmapFactory.Options paramOptions)
  {
    if (paramBitmap == null) {
      return null;
    }
    if ((paramBitmap.getAllocationByteCount() < 1048576) && (!b())) {
      return paramBitmap;
    }
    paramOptions = new a.a(???, paramOptions);
    synchronized (a)
    {
      a.put(paramBitmap, paramOptions);
      if ((b != null) && (!c))
      {
        b.sendEmptyMessageDelayed(0, 5000L);
        c = true;
      }
      return paramBitmap;
    }
  }
  
  public static void a()
  {
    a(2097152L, 3);
  }
  
  private static void a(long paramLong, int paramInt)
  {
    b(new PrintWriter(new a.3(), false), paramLong, paramInt);
  }
  
  private static void a(PrintWriter paramPrintWriter, Bitmap paramBitmap, a.a parama, long paramLong)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    String str = b(paramBitmap.getAllocationByteCount());
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (localConfig == null) {
      paramBitmap = "UNKNOWN";
    } else {
      paramBitmap = localConfig.name();
    }
    paramPrintWriter.format("\nSize: %s (%d x %d, %s)\n", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), paramBitmap });
    paramPrintWriter.append("Source: ").println(parama.b);
    paramPrintWriter.format("Acquired: %d seconds ago\n", new Object[] { Long.valueOf((paramLong - parama.d) / 1000L) });
    paramPrintWriter.print("Stack:\n");
    a(parama.a, paramPrintWriter);
    paramPrintWriter.print("=======================================================\n");
    paramPrintWriter.flush();
  }
  
  private static void a(StackTraceElement[] paramArrayOfStackTraceElement, PrintWriter paramPrintWriter)
  {
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      paramPrintWriter.append("  at ").println(localStackTraceElement.toString());
      i += 1;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  private static String b(long paramLong)
  {
    double d;
    if (paramLong >= 1073741824L)
    {
      d = paramLong;
      Double.isNaN(d);
      return String.format("%.2f GB", new Object[] { Double.valueOf(d / 1073741824.0D) });
    }
    if (paramLong >= 1048576L)
    {
      d = paramLong;
      Double.isNaN(d);
      return String.format("%.2f MB", new Object[] { Double.valueOf(d / 1048576.0D) });
    }
    if (paramLong >= 1024L)
    {
      d = paramLong;
      Double.isNaN(d);
      return String.format("%.2f kB", new Object[] { Double.valueOf(d / 1024.0D) });
    }
    return String.format("%d bytes", new Object[] { Long.valueOf(paramLong) });
  }
  
  private static void b(PrintWriter paramPrintWriter, long paramLong, int paramInt)
  {
    if (paramLong > 0L)
    {
      double d = paramLong;
      Double.isNaN(d);
      paramPrintWriter.format("Statistics for all Bitmaps larger than %.2f MB:\n", new Object[] { Double.valueOf(d / 1048576.0D) });
    }
    else
    {
      paramPrintWriter.print("Statistics for all Bitmaps alive:\n");
    }
    paramPrintWriter.flush();
    long l4 = System.currentTimeMillis();
    synchronized (a)
    {
      Object localObject1 = new ArrayList();
      try
      {
        ((List)localObject1).addAll(a.entrySet());
        localIterator = ((List)localObject1).iterator();
        localObject1 = null;
        l2 = 0L;
        l1 = l2;
        localObject2 = null;
        j = 0;
        i = 0;
      }
      catch (ConcurrentModificationException localConcurrentModificationException)
      {
        for (;;)
        {
          Iterator localIterator;
          long l1;
          int j;
          int i;
          Bitmap localBitmap;
          a.a locala;
          long l5;
          long l3;
          continue;
          continue;
          Object localObject3 = localBitmap;
          Object localObject2 = locala;
          long l2 = l1;
          if (l5 >= paramLong) {
            if (paramInt != -1)
            {
              l2 = l1;
              if (l1 >= paramInt) {}
            }
          }
        }
      }
      if (localIterator.hasNext())
      {
        localObject3 = (Map.Entry)localIterator.next();
        localBitmap = (Bitmap)((Map.Entry)localObject3).getKey();
        locala = (a.a)((Map.Entry)localObject3).getValue();
        if (localBitmap != null) {
          if (localBitmap.isRecycled())
          {
            i += 1;
          }
          else
          {
            l5 = localBitmap.getAllocationByteCount();
            l3 = l2 + l5;
            j += 1;
            if (localObject1 == null) {
              break label393;
            }
            localObject3 = localObject1;
            if (l5 <= ((Bitmap)localObject1).getAllocationByteCount()) {
              break label401;
            }
            break label393;
            l2 = l1 + 1L;
            paramPrintWriter.append('#').println(j);
            a(paramPrintWriter, localBitmap, locala, l4);
            l1 = l2;
            l2 = l3;
            localObject1 = localObject3;
          }
        }
      }
      else
      {
        if ((localObject1 != null) && (localObject2 != null))
        {
          paramPrintWriter.append("# Biggest Bitmap");
          a(paramPrintWriter, (Bitmap)localObject1, (a.a)localObject2, l4);
        }
        paramPrintWriter.format("\n\nLiving Bitmaps: %d, %s\n", new Object[] { Integer.valueOf(j), b(l2) });
        paramPrintWriter.append("Recycled Bitmaps: ").println(i);
        paramPrintWriter.flush();
        paramPrintWriter.close();
        return;
        paramPrintWriter.print("ConcurrentModificationException occur.");
        paramPrintWriter.flush();
        paramPrintWriter.close();
        return;
      }
    }
  }
  
  private static boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.a
 * JD-Core Version:    0.7.0.1
 */