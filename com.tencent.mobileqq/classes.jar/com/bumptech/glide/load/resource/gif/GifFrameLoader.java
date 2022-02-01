package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader
{
  final RequestManager a;
  private final GifDecoder b;
  private final Handler c;
  private final List<GifFrameLoader.FrameCallback> d = new ArrayList();
  private final BitmapPool e;
  private boolean f;
  private boolean g;
  private boolean h;
  private RequestBuilder<Bitmap> i;
  private GifFrameLoader.DelayTarget j;
  private boolean k;
  private GifFrameLoader.DelayTarget l;
  private Bitmap m;
  private Transformation<Bitmap> n;
  private GifFrameLoader.DelayTarget o;
  @Nullable
  private GifFrameLoader.OnEveryFrameListener p;
  
  GifFrameLoader(Glide paramGlide, GifDecoder paramGifDecoder, int paramInt1, int paramInt2, Transformation<Bitmap> paramTransformation, Bitmap paramBitmap)
  {
    this(paramGlide.a(), Glide.b(paramGlide.c()), paramGifDecoder, null, a(Glide.b(paramGlide.c()), paramInt1, paramInt2), paramTransformation, paramBitmap);
  }
  
  GifFrameLoader(BitmapPool paramBitmapPool, RequestManager paramRequestManager, GifDecoder paramGifDecoder, Handler paramHandler, RequestBuilder<Bitmap> paramRequestBuilder, Transformation<Bitmap> paramTransformation, Bitmap paramBitmap)
  {
    this.a = paramRequestManager;
    paramRequestManager = paramHandler;
    if (paramHandler == null) {
      paramRequestManager = new Handler(Looper.getMainLooper(), new GifFrameLoader.FrameLoaderCallback(this));
    }
    this.e = paramBitmapPool;
    this.c = paramRequestManager;
    this.i = paramRequestBuilder;
    this.b = paramGifDecoder;
    a(paramTransformation, paramBitmap);
  }
  
  private static RequestBuilder<Bitmap> a(RequestManager paramRequestManager, int paramInt1, int paramInt2)
  {
    return paramRequestManager.f().a(RequestOptions.a(DiskCacheStrategy.b).a(true).b(true).a(paramInt1, paramInt2));
  }
  
  private int j()
  {
    return Util.a(i().getWidth(), i().getHeight(), i().getConfig());
  }
  
  private void k()
  {
    if (this.f) {
      return;
    }
    this.f = true;
    this.k = false;
    m();
  }
  
  private void l()
  {
    this.f = false;
  }
  
  private void m()
  {
    if (this.f)
    {
      if (this.g) {
        return;
      }
      if (this.h)
      {
        boolean bool;
        if (this.o == null) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.a(bool, "Pending target must be null when starting from the first frame");
        this.b.f();
        this.h = false;
      }
      GifFrameLoader.DelayTarget localDelayTarget = this.o;
      if (localDelayTarget != null)
      {
        this.o = null;
        a(localDelayTarget);
        return;
      }
      this.g = true;
      int i1 = this.b.c();
      long l1 = SystemClock.uptimeMillis();
      long l2 = i1;
      this.b.b();
      this.l = new GifFrameLoader.DelayTarget(this.c, this.b.e(), l1 + l2);
      this.i.a(RequestOptions.a(o())).a(this.b).a(this.l);
    }
  }
  
  private void n()
  {
    Bitmap localBitmap = this.m;
    if (localBitmap != null)
    {
      this.e.a(localBitmap);
      this.m = null;
    }
  }
  
  private static Key o()
  {
    return new ObjectKey(Double.valueOf(Math.random()));
  }
  
  Bitmap a()
  {
    return this.m;
  }
  
  void a(Transformation<Bitmap> paramTransformation, Bitmap paramBitmap)
  {
    this.n = ((Transformation)Preconditions.a(paramTransformation));
    this.m = ((Bitmap)Preconditions.a(paramBitmap));
    this.i = this.i.a(new RequestOptions().a(paramTransformation));
  }
  
  @VisibleForTesting
  void a(GifFrameLoader.DelayTarget paramDelayTarget)
  {
    Object localObject = this.p;
    if (localObject != null) {
      ((GifFrameLoader.OnEveryFrameListener)localObject).a();
    }
    this.g = false;
    if (this.k)
    {
      this.c.obtainMessage(2, paramDelayTarget).sendToTarget();
      return;
    }
    if (!this.f)
    {
      this.o = paramDelayTarget;
      return;
    }
    if (paramDelayTarget.F_() != null)
    {
      n();
      localObject = this.j;
      this.j = paramDelayTarget;
      int i1 = this.d.size() - 1;
      while (i1 >= 0)
      {
        ((GifFrameLoader.FrameCallback)this.d.get(i1)).f();
        i1 -= 1;
      }
      if (localObject != null) {
        this.c.obtainMessage(2, localObject).sendToTarget();
      }
    }
    m();
  }
  
  void a(GifFrameLoader.FrameCallback paramFrameCallback)
  {
    if (!this.k)
    {
      if (!this.d.contains(paramFrameCallback))
      {
        boolean bool = this.d.isEmpty();
        this.d.add(paramFrameCallback);
        if (bool) {
          k();
        }
        return;
      }
      throw new IllegalStateException("Cannot subscribe twice in a row");
    }
    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
  }
  
  int b()
  {
    return i().getWidth();
  }
  
  void b(GifFrameLoader.FrameCallback paramFrameCallback)
  {
    this.d.remove(paramFrameCallback);
    if (this.d.isEmpty()) {
      l();
    }
  }
  
  int c()
  {
    return i().getHeight();
  }
  
  int d()
  {
    return this.b.g() + j();
  }
  
  int e()
  {
    GifFrameLoader.DelayTarget localDelayTarget = this.j;
    if (localDelayTarget != null) {
      return localDelayTarget.a;
    }
    return -1;
  }
  
  ByteBuffer f()
  {
    return this.b.a().asReadOnlyBuffer();
  }
  
  int g()
  {
    return this.b.d();
  }
  
  void h()
  {
    this.d.clear();
    n();
    l();
    GifFrameLoader.DelayTarget localDelayTarget = this.j;
    if (localDelayTarget != null)
    {
      this.a.a(localDelayTarget);
      this.j = null;
    }
    localDelayTarget = this.l;
    if (localDelayTarget != null)
    {
      this.a.a(localDelayTarget);
      this.l = null;
    }
    localDelayTarget = this.o;
    if (localDelayTarget != null)
    {
      this.a.a(localDelayTarget);
      this.o = null;
    }
    this.b.i();
    this.k = true;
  }
  
  Bitmap i()
  {
    GifFrameLoader.DelayTarget localDelayTarget = this.j;
    if (localDelayTarget != null) {
      return localDelayTarget.F_();
    }
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifFrameLoader
 * JD-Core Version:    0.7.0.1
 */