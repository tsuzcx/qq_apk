package com.bumptech.glide.request;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

public class RequestOptions
  implements Cloneable
{
  private int a;
  private float b = 1.0F;
  @NonNull
  private DiskCacheStrategy c = DiskCacheStrategy.e;
  @NonNull
  private Priority d = Priority.NORMAL;
  @Nullable
  private Drawable e;
  private int f;
  @Nullable
  private Drawable g;
  private int h;
  private boolean i = true;
  private int j = -1;
  private int k = -1;
  @NonNull
  private Key l = EmptySignature.a();
  private boolean m;
  private boolean n = true;
  @Nullable
  private Drawable o;
  private int p;
  @NonNull
  private Options q = new Options();
  @NonNull
  private Map<Class<?>, Transformation<?>> r = new CachedHashCodeArrayMap();
  @NonNull
  private Class<?> s = Object.class;
  private boolean t;
  @Nullable
  private Resources.Theme u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y = true;
  private boolean z;
  
  @NonNull
  private RequestOptions G()
  {
    if (!this.t) {
      return this;
    }
    throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
  }
  
  @CheckResult
  @NonNull
  public static RequestOptions a(@NonNull Key paramKey)
  {
    return new RequestOptions().b(paramKey);
  }
  
  @NonNull
  private RequestOptions a(@NonNull Transformation<Bitmap> paramTransformation, boolean paramBoolean)
  {
    if (this.v) {
      return a().a(paramTransformation, paramBoolean);
    }
    DrawableTransformation localDrawableTransformation = new DrawableTransformation(paramTransformation, paramBoolean);
    a(Bitmap.class, paramTransformation, paramBoolean);
    a(Drawable.class, localDrawableTransformation, paramBoolean);
    a(BitmapDrawable.class, localDrawableTransformation.a(), paramBoolean);
    a(GifDrawable.class, new GifDrawableTransformation(paramTransformation), paramBoolean);
    return G();
  }
  
  @CheckResult
  @NonNull
  public static RequestOptions a(@NonNull DiskCacheStrategy paramDiskCacheStrategy)
  {
    return new RequestOptions().b(paramDiskCacheStrategy);
  }
  
  @NonNull
  private RequestOptions a(@NonNull DownsampleStrategy paramDownsampleStrategy, @NonNull Transformation<Bitmap> paramTransformation, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramDownsampleStrategy = b(paramDownsampleStrategy, paramTransformation);
    } else {
      paramDownsampleStrategy = a(paramDownsampleStrategy, paramTransformation);
    }
    paramDownsampleStrategy.y = true;
    return paramDownsampleStrategy;
  }
  
  @CheckResult
  @NonNull
  public static RequestOptions a(@NonNull Class<?> paramClass)
  {
    return new RequestOptions().b(paramClass);
  }
  
  @NonNull
  private <T> RequestOptions a(@NonNull Class<T> paramClass, @NonNull Transformation<T> paramTransformation, boolean paramBoolean)
  {
    if (this.v) {
      return a().a(paramClass, paramTransformation, paramBoolean);
    }
    Preconditions.a(paramClass);
    Preconditions.a(paramTransformation);
    this.r.put(paramClass, paramTransformation);
    this.a |= 0x800;
    this.n = true;
    this.a |= 0x10000;
    this.y = false;
    if (paramBoolean)
    {
      this.a |= 0x20000;
      this.m = true;
    }
    return G();
  }
  
  private boolean a(int paramInt)
  {
    return b(this.a, paramInt);
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  @NonNull
  private RequestOptions c(@NonNull DownsampleStrategy paramDownsampleStrategy, @NonNull Transformation<Bitmap> paramTransformation)
  {
    return a(paramDownsampleStrategy, paramTransformation, false);
  }
  
  public final int A()
  {
    return this.j;
  }
  
  public final float B()
  {
    return this.b;
  }
  
  boolean C()
  {
    return this.y;
  }
  
  public final boolean D()
  {
    return this.w;
  }
  
  public final boolean E()
  {
    return this.z;
  }
  
  public final boolean F()
  {
    return this.x;
  }
  
  @CheckResult
  public RequestOptions a()
  {
    try
    {
      RequestOptions localRequestOptions = (RequestOptions)super.clone();
      localRequestOptions.q = new Options();
      localRequestOptions.q.a(this.q);
      localRequestOptions.r = new CachedHashCodeArrayMap();
      localRequestOptions.r.putAll(this.r);
      localRequestOptions.t = false;
      localRequestOptions.v = false;
      return localRequestOptions;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  @CheckResult
  @NonNull
  public RequestOptions a(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.v) {
      return a().a(paramFloat);
    }
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      this.b = paramFloat;
      this.a |= 0x2;
      return G();
    }
    throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
  }
  
  @CheckResult
  @NonNull
  public RequestOptions a(int paramInt1, int paramInt2)
  {
    if (this.v) {
      return a().a(paramInt1, paramInt2);
    }
    this.k = paramInt1;
    this.j = paramInt2;
    this.a |= 0x200;
    return G();
  }
  
  @CheckResult
  @NonNull
  public RequestOptions a(@NonNull Priority paramPriority)
  {
    if (this.v) {
      return a().a(paramPriority);
    }
    this.d = ((Priority)Preconditions.a(paramPriority));
    this.a |= 0x8;
    return G();
  }
  
  @CheckResult
  @NonNull
  public <T> RequestOptions a(@NonNull Option<T> paramOption, @NonNull T paramT)
  {
    if (this.v) {
      return a().a(paramOption, paramT);
    }
    Preconditions.a(paramOption);
    Preconditions.a(paramT);
    this.q.a(paramOption, paramT);
    return G();
  }
  
  @CheckResult
  @NonNull
  public RequestOptions a(@NonNull Transformation<Bitmap> paramTransformation)
  {
    return a(paramTransformation, true);
  }
  
  @CheckResult
  @NonNull
  public RequestOptions a(@NonNull DownsampleStrategy paramDownsampleStrategy)
  {
    return a(DownsampleStrategy.h, Preconditions.a(paramDownsampleStrategy));
  }
  
  @NonNull
  final RequestOptions a(@NonNull DownsampleStrategy paramDownsampleStrategy, @NonNull Transformation<Bitmap> paramTransformation)
  {
    if (this.v) {
      return a().a(paramDownsampleStrategy, paramTransformation);
    }
    a(paramDownsampleStrategy);
    return a(paramTransformation, false);
  }
  
  @CheckResult
  @NonNull
  public RequestOptions a(@NonNull RequestOptions paramRequestOptions)
  {
    if (this.v) {
      return a().a(paramRequestOptions);
    }
    if (b(paramRequestOptions.a, 2)) {
      this.b = paramRequestOptions.b;
    }
    if (b(paramRequestOptions.a, 262144)) {
      this.w = paramRequestOptions.w;
    }
    if (b(paramRequestOptions.a, 1048576)) {
      this.z = paramRequestOptions.z;
    }
    if (b(paramRequestOptions.a, 4)) {
      this.c = paramRequestOptions.c;
    }
    if (b(paramRequestOptions.a, 8)) {
      this.d = paramRequestOptions.d;
    }
    if (b(paramRequestOptions.a, 16)) {
      this.e = paramRequestOptions.e;
    }
    if (b(paramRequestOptions.a, 32)) {
      this.f = paramRequestOptions.f;
    }
    if (b(paramRequestOptions.a, 64)) {
      this.g = paramRequestOptions.g;
    }
    if (b(paramRequestOptions.a, 128)) {
      this.h = paramRequestOptions.h;
    }
    if (b(paramRequestOptions.a, 256)) {
      this.i = paramRequestOptions.i;
    }
    if (b(paramRequestOptions.a, 512))
    {
      this.k = paramRequestOptions.k;
      this.j = paramRequestOptions.j;
    }
    if (b(paramRequestOptions.a, 1024)) {
      this.l = paramRequestOptions.l;
    }
    if (b(paramRequestOptions.a, 4096)) {
      this.s = paramRequestOptions.s;
    }
    if (b(paramRequestOptions.a, 8192)) {
      this.o = paramRequestOptions.o;
    }
    if (b(paramRequestOptions.a, 16384)) {
      this.p = paramRequestOptions.p;
    }
    if (b(paramRequestOptions.a, 32768)) {
      this.u = paramRequestOptions.u;
    }
    if (b(paramRequestOptions.a, 65536)) {
      this.n = paramRequestOptions.n;
    }
    if (b(paramRequestOptions.a, 131072)) {
      this.m = paramRequestOptions.m;
    }
    if (b(paramRequestOptions.a, 2048))
    {
      this.r.putAll(paramRequestOptions.r);
      this.y = paramRequestOptions.y;
    }
    if (b(paramRequestOptions.a, 524288)) {
      this.x = paramRequestOptions.x;
    }
    if (!this.n)
    {
      this.r.clear();
      this.a &= 0xFFFFF7FF;
      this.m = false;
      this.a &= 0xFFFDFFFF;
      this.y = true;
    }
    this.a |= paramRequestOptions.a;
    this.q.a(paramRequestOptions.q);
    return G();
  }
  
  @CheckResult
  @NonNull
  public RequestOptions a(boolean paramBoolean)
  {
    if (this.v) {
      return a().a(paramBoolean);
    }
    this.z = paramBoolean;
    this.a |= 0x100000;
    return G();
  }
  
  @CheckResult
  @NonNull
  public RequestOptions b(@NonNull Key paramKey)
  {
    if (this.v) {
      return a().b(paramKey);
    }
    this.l = ((Key)Preconditions.a(paramKey));
    this.a |= 0x400;
    return G();
  }
  
  @CheckResult
  @NonNull
  public RequestOptions b(@NonNull DiskCacheStrategy paramDiskCacheStrategy)
  {
    if (this.v) {
      return a().b(paramDiskCacheStrategy);
    }
    this.c = ((DiskCacheStrategy)Preconditions.a(paramDiskCacheStrategy));
    this.a |= 0x4;
    return G();
  }
  
  @CheckResult
  @NonNull
  final RequestOptions b(@NonNull DownsampleStrategy paramDownsampleStrategy, @NonNull Transformation<Bitmap> paramTransformation)
  {
    if (this.v) {
      return a().b(paramDownsampleStrategy, paramTransformation);
    }
    a(paramDownsampleStrategy);
    return a(paramTransformation);
  }
  
  @CheckResult
  @NonNull
  public RequestOptions b(@NonNull Class<?> paramClass)
  {
    if (this.v) {
      return a().b(paramClass);
    }
    this.s = ((Class)Preconditions.a(paramClass));
    this.a |= 0x1000;
    return G();
  }
  
  @CheckResult
  @NonNull
  public RequestOptions b(boolean paramBoolean)
  {
    if (this.v) {
      return a().b(true);
    }
    this.i = (paramBoolean ^ true);
    this.a |= 0x100;
    return G();
  }
  
  public final boolean b()
  {
    return this.n;
  }
  
  public final boolean c()
  {
    return a(2048);
  }
  
  @CheckResult
  @NonNull
  public RequestOptions d()
  {
    return a(DownsampleStrategy.b, new CenterCrop());
  }
  
  @CheckResult
  @NonNull
  public RequestOptions e()
  {
    return c(DownsampleStrategy.a, new FitCenter());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof RequestOptions;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (RequestOptions)paramObject;
      bool1 = bool2;
      if (Float.compare(paramObject.b, this.b) == 0)
      {
        bool1 = bool2;
        if (this.f == paramObject.f)
        {
          bool1 = bool2;
          if (Util.a(this.e, paramObject.e))
          {
            bool1 = bool2;
            if (this.h == paramObject.h)
            {
              bool1 = bool2;
              if (Util.a(this.g, paramObject.g))
              {
                bool1 = bool2;
                if (this.p == paramObject.p)
                {
                  bool1 = bool2;
                  if (Util.a(this.o, paramObject.o))
                  {
                    bool1 = bool2;
                    if (this.i == paramObject.i)
                    {
                      bool1 = bool2;
                      if (this.j == paramObject.j)
                      {
                        bool1 = bool2;
                        if (this.k == paramObject.k)
                        {
                          bool1 = bool2;
                          if (this.m == paramObject.m)
                          {
                            bool1 = bool2;
                            if (this.n == paramObject.n)
                            {
                              bool1 = bool2;
                              if (this.w == paramObject.w)
                              {
                                bool1 = bool2;
                                if (this.x == paramObject.x)
                                {
                                  bool1 = bool2;
                                  if (this.c.equals(paramObject.c))
                                  {
                                    bool1 = bool2;
                                    if (this.d == paramObject.d)
                                    {
                                      bool1 = bool2;
                                      if (this.q.equals(paramObject.q))
                                      {
                                        bool1 = bool2;
                                        if (this.r.equals(paramObject.r))
                                        {
                                          bool1 = bool2;
                                          if (this.s.equals(paramObject.s))
                                          {
                                            bool1 = bool2;
                                            if (Util.a(this.l, paramObject.l))
                                            {
                                              bool1 = bool2;
                                              if (Util.a(this.u, paramObject.u)) {
                                                bool1 = true;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  @CheckResult
  @NonNull
  public RequestOptions f()
  {
    return c(DownsampleStrategy.e, new CenterInside());
  }
  
  @NonNull
  public RequestOptions g()
  {
    this.t = true;
    return this;
  }
  
  @NonNull
  public RequestOptions h()
  {
    if ((this.t) && (!this.v)) {
      throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }
    this.v = true;
    return g();
  }
  
  public int hashCode()
  {
    int i1 = Util.a(this.b);
    i1 = Util.b(this.f, i1);
    i1 = Util.a(this.e, i1);
    i1 = Util.b(this.h, i1);
    i1 = Util.a(this.g, i1);
    i1 = Util.b(this.p, i1);
    i1 = Util.a(this.o, i1);
    i1 = Util.a(this.i, i1);
    i1 = Util.b(this.j, i1);
    i1 = Util.b(this.k, i1);
    i1 = Util.a(this.m, i1);
    i1 = Util.a(this.n, i1);
    i1 = Util.a(this.w, i1);
    i1 = Util.a(this.x, i1);
    i1 = Util.a(this.c, i1);
    i1 = Util.a(this.d, i1);
    i1 = Util.a(this.q, i1);
    i1 = Util.a(this.r, i1);
    i1 = Util.a(this.s, i1);
    i1 = Util.a(this.l, i1);
    return Util.a(this.u, i1);
  }
  
  @NonNull
  public final Map<Class<?>, Transformation<?>> i()
  {
    return this.r;
  }
  
  public final boolean j()
  {
    return this.m;
  }
  
  @NonNull
  public final Options k()
  {
    return this.q;
  }
  
  @NonNull
  public final Class<?> l()
  {
    return this.s;
  }
  
  @NonNull
  public final DiskCacheStrategy m()
  {
    return this.c;
  }
  
  @Nullable
  public final Drawable n()
  {
    return this.e;
  }
  
  public final int o()
  {
    return this.f;
  }
  
  public final int p()
  {
    return this.h;
  }
  
  @Nullable
  public final Drawable q()
  {
    return this.g;
  }
  
  public final int r()
  {
    return this.p;
  }
  
  @Nullable
  public final Drawable s()
  {
    return this.o;
  }
  
  @Nullable
  public final Resources.Theme t()
  {
    return this.u;
  }
  
  public final boolean u()
  {
    return this.i;
  }
  
  @NonNull
  public final Key v()
  {
    return this.l;
  }
  
  public final boolean w()
  {
    return a(8);
  }
  
  @NonNull
  public final Priority x()
  {
    return this.d;
  }
  
  public final int y()
  {
    return this.k;
  }
  
  public final boolean z()
  {
    return Util.a(this.k, this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.RequestOptions
 * JD-Core Version:    0.7.0.1
 */