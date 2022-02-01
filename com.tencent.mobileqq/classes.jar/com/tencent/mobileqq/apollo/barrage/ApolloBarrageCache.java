package com.tencent.mobileqq.apollo.barrage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ApolloBarrageCache
  extends AbsBarrageCache
{
  public void a(Barrage paramBarrage, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramBarrage != null))
    {
      if (TextUtils.isEmpty(paramBarrage.a)) {
        return;
      }
      Object localObject2 = paramBarrage.c;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramBarrage.a);
      paramBarrage = ((StringBuilder)localObject2).toString();
      this.a.put(paramBarrage, new WeakReference(paramBitmap));
    }
  }
  
  public Bitmap c(Barrage paramBarrage)
  {
    if (paramBarrage != null)
    {
      if (TextUtils.isEmpty(paramBarrage.a)) {
        return null;
      }
      Object localObject2 = paramBarrage.c;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramBarrage.a);
      paramBarrage = ((StringBuilder)localObject2).toString();
      paramBarrage = (WeakReference)this.a.get(paramBarrage);
      if (paramBarrage != null) {
        return (Bitmap)paramBarrage.get();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.ApolloBarrageCache
 * JD-Core Version:    0.7.0.1
 */