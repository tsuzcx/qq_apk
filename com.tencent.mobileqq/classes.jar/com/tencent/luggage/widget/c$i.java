package com.tencent.luggage.widget;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.luggage.widget.decoder.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

class c$i
  extends AsyncTask<Void, Void, Bitmap>
{
  private final WeakReference<c> a;
  private final WeakReference<d> b;
  private final WeakReference<c.h> c;
  private Exception d;
  
  c$i(c paramc, d paramd, c.h paramh)
  {
    this.a = new WeakReference(paramc);
    this.b = new WeakReference(paramd);
    this.c = new WeakReference(paramh);
    c.h.b(paramh, true);
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = (c)this.a.get();
      Object localObject1 = (d)this.b.get();
      c.h localh = (c.h)this.c.get();
      if ((localObject1 != null) && (localh != null) && (paramVarArgs != null) && (((d)localObject1).a()) && (c.h.b(localh)))
      {
        c.a(paramVarArgs, "TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", new Object[] { c.h.d(localh), Integer.valueOf(c.h.f(localh)) });
        c.m(paramVarArgs).readLock().lock();
        try
        {
          if (((d)localObject1).a())
          {
            c.a(paramVarArgs, c.h.d(localh), c.h.g(localh));
            if (c.k(paramVarArgs) != null) {
              c.h.g(localh).offset(c.k(paramVarArgs).left, c.k(paramVarArgs).top);
            }
            localObject1 = ((d)localObject1).a(c.h.g(localh), c.h.f(localh));
            return localObject1;
          }
          c.h.b(localh, false);
        }
        finally
        {
          c.m(paramVarArgs).readLock().unlock();
        }
      }
      else if (localh != null)
      {
        c.h.b(localh, false);
      }
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      Log.e(c.d(), "Failed to decode tile - OutOfMemoryError", paramVarArgs);
      this.d = new RuntimeException(paramVarArgs);
    }
    catch (Exception paramVarArgs)
    {
      Log.e(c.d(), "Failed to decode tile", paramVarArgs);
      this.d = paramVarArgs;
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    c localc = (c)this.a.get();
    c.h localh = (c.h)this.c.get();
    if ((localc != null) && (localh != null))
    {
      if (paramBitmap != null)
      {
        c.h.a(localh, paramBitmap);
        c.h.b(localh, false);
        c.n(localc);
        return;
      }
      if ((this.d != null) && (c.l(localc) != null)) {
        c.l(localc).c(this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.c.i
 * JD-Core Version:    0.7.0.1
 */