package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public final class ow
{
  private static final ow.j<Object> a = new ow.1();
  
  @NonNull
  public static <T extends ow.g> ow.f<T> a(int paramInt, @NonNull ow.d<T> paramd)
  {
    return a(new ow.i.b(paramInt), paramd);
  }
  
  public static ow.f<ow.h<Bitmap>> a(@NonNull ow.a parama)
  {
    return a(10, new ow.2(parama));
  }
  
  @NonNull
  private static <T extends ow.g> ow.f<T> a(@NonNull ow.f<T> paramf, @NonNull ow.d<T> paramd)
  {
    return a(paramf, paramd, a);
  }
  
  @NonNull
  private static <T> ow.f<T> a(@NonNull ow.f<T> paramf, @NonNull ow.d<T> paramd, @NonNull ow.j<T> paramj)
  {
    return new ow.e(paramf, paramd, paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ow
 * JD-Core Version:    0.7.0.1
 */