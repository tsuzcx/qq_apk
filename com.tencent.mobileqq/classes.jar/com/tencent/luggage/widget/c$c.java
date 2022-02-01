package com.tencent.luggage.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.luggage.widget.decoder.b;
import java.lang.ref.WeakReference;

class c$c
  extends AsyncTask<Void, Void, Integer>
{
  private final WeakReference<c> a;
  private final WeakReference<Context> b;
  private final WeakReference<b<? extends com.tencent.luggage.widget.decoder.c>> c;
  private final Uri d;
  private final boolean e;
  private Bitmap f;
  private Exception g;
  
  c$c(c paramc, Context paramContext, b<? extends com.tencent.luggage.widget.decoder.c> paramb, Uri paramUri, boolean paramBoolean)
  {
    this.a = new WeakReference(paramc);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramb);
    this.d = paramUri;
    this.e = paramBoolean;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.d.toString();
      Context localContext = (Context)this.b.get();
      b localb = (b)this.c.get();
      c localc = (c)this.a.get();
      if ((localContext != null) && (localb != null) && (localc != null))
      {
        c.a(localc, "BitmapLoadTask.doInBackground", new Object[0]);
        this.f = ((com.tencent.luggage.widget.decoder.c)localb.a()).a(localContext, this.d);
        int i = c.a(localc, localContext, paramVarArgs);
        return Integer.valueOf(i);
      }
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      Log.e(c.d(), "Failed to load bitmap - OutOfMemoryError", paramVarArgs);
      this.g = new RuntimeException(paramVarArgs);
    }
    catch (Exception paramVarArgs)
    {
      Log.e(c.d(), "Failed to load bitmap", paramVarArgs);
      this.g = paramVarArgs;
    }
    return null;
  }
  
  protected void a(Integer paramInteger)
  {
    c localc = (c)this.a.get();
    if (localc != null)
    {
      Bitmap localBitmap = this.f;
      if ((localBitmap != null) && (paramInteger != null))
      {
        if (this.e)
        {
          c.a(localc, localBitmap);
          return;
        }
        c.a(localc, localBitmap, paramInteger.intValue(), false);
        return;
      }
      if ((this.g != null) && (c.l(localc) != null))
      {
        if (this.e)
        {
          c.l(localc).a(this.g);
          return;
        }
        c.l(localc).b(this.g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.c.c
 * JD-Core Version:    0.7.0.1
 */