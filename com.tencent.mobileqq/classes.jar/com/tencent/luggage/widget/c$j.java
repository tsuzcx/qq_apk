package com.tencent.luggage.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.luggage.widget.decoder.b;
import com.tencent.luggage.widget.decoder.d;
import java.lang.ref.WeakReference;

class c$j
  extends AsyncTask<Void, Void, int[]>
{
  private final WeakReference<c> a;
  private final WeakReference<Context> b;
  private final WeakReference<b<? extends d>> c;
  private final Uri d;
  private d e;
  private Exception f;
  
  c$j(c paramc, Context paramContext, b<? extends d> paramb, Uri paramUri)
  {
    this.a = new WeakReference(paramc);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramb);
    this.d = paramUri;
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    c localc = (c)this.a.get();
    if (localc != null)
    {
      d locald = this.e;
      if ((locald != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 3))
      {
        c.a(localc, locald, paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
        return;
      }
      if ((this.f != null) && (c.l(localc) != null)) {
        c.l(localc).b(this.f);
      }
    }
  }
  
  protected int[] a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.d.toString();
      Context localContext = (Context)this.b.get();
      Object localObject = (b)this.c.get();
      c localc = (c)this.a.get();
      if ((localContext != null) && (localObject != null) && (localc != null))
      {
        c.a(localc, "TilesInitTask.doInBackground", new Object[0]);
        this.e = ((d)((b)localObject).a());
        localObject = this.e.a(localContext, this.d);
        int k = ((Point)localObject).x;
        int m = ((Point)localObject).y;
        int n = c.a(localc, localContext, paramVarArgs);
        int j = m;
        int i = k;
        if (c.k(localc) != null)
        {
          c.k(localc).left = Math.max(0, c.k(localc).left);
          c.k(localc).top = Math.max(0, c.k(localc).top);
          c.k(localc).right = Math.min(k, c.k(localc).right);
          c.k(localc).bottom = Math.min(m, c.k(localc).bottom);
          i = c.k(localc).width();
          j = c.k(localc).height();
        }
        return new int[] { i, j, n };
      }
    }
    catch (Exception paramVarArgs)
    {
      Log.e(c.d(), "Failed to initialise bitmap decoder", paramVarArgs);
      this.f = paramVarArgs;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.c.j
 * JD-Core Version:    0.7.0.1
 */