package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> a = new HashMap(3);
  private SparseArray<Map<BitmapType, com.github.henryye.nativeiv.bitmap.b>> b = new SparseArray();
  
  public b()
  {
    this.a.put(BitmapType.Native, new b.1(this));
    this.a.put(BitmapType.Legacy, new b.2(this));
    this.a.put(BitmapType.Undefined, new b.3(this));
  }
  
  private IBitmap a(InputStream paramInputStream, Bitmap.Config paramConfig, c paramc, @NonNull Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> paramMap)
  {
    if (((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Native)).a(paramInputStream, paramConfig, paramc)) {
      return ((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Native)).a();
    }
    if (((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Legacy)).a(paramInputStream, paramConfig, paramc)) {
      return ((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Legacy)).a();
    }
    return ((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Undefined)).a();
  }
  
  private void a(Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext()) {
      ((com.github.henryye.nativeiv.bitmap.b)paramMap.next()).b();
    }
  }
  
  IBitmap a(int paramInt, BitmapType paramBitmapType)
  {
    Map localMap = (Map)this.b.get(paramInt);
    if ((localMap != null) && (localMap.get(paramBitmapType) != null)) {
      return ((com.github.henryye.nativeiv.bitmap.b)localMap.get(paramBitmapType)).a();
    }
    if (this.a.get(paramBitmapType) != null) {
      return ((com.github.henryye.nativeiv.bitmap.b)this.a.get(paramBitmapType)).a();
    }
    return null;
  }
  
  IBitmap a(int paramInt, InputStream paramInputStream, Bitmap.Config paramConfig, c paramc)
  {
    Object localObject1 = (Map)this.b.get(paramInt);
    if (localObject1 != null) {
      localObject1 = a(paramInputStream, paramConfig, paramc, (Map)localObject1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = a(paramInputStream, paramConfig, paramc, this.a);
    }
    return localObject2;
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.b.size())
    {
      int j = this.b.keyAt(i);
      a((Map)this.b.get(j));
      i += 1;
    }
    a(this.a);
  }
  
  void a(int paramInt, BitmapType paramBitmapType, com.github.henryye.nativeiv.bitmap.b paramb)
  {
    Map localMap = (Map)this.b.get(paramInt);
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap(2);
    }
    ((Map)localObject).put(paramBitmapType, paramb);
    this.b.append(paramInt, localObject);
  }
  
  public void a(BitmapType paramBitmapType, com.github.henryye.nativeiv.bitmap.b paramb)
  {
    this.a.put(paramBitmapType, paramb);
  }
  
  IBitmap<Bitmap> b()
  {
    return ((com.github.henryye.nativeiv.bitmap.b)this.a.get(BitmapType.Legacy)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.b
 * JD-Core Version:    0.7.0.1
 */