package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

@RequiresApi(19)
final class SizeStrategy
  implements LruPoolStrategy
{
  private final SizeStrategy.KeyPool a = new SizeStrategy.KeyPool();
  private final GroupedLinkedMap<SizeStrategy.Key, Bitmap> b = new GroupedLinkedMap();
  private final NavigableMap<Integer, Integer> c = new PrettyPrintTreeMap();
  
  static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private void a(Integer paramInteger)
  {
    Integer localInteger = (Integer)this.c.get(paramInteger);
    if (localInteger.intValue() == 1)
    {
      this.c.remove(paramInteger);
      return;
    }
    this.c.put(paramInteger, Integer.valueOf(localInteger.intValue() - 1));
  }
  
  private static String d(Bitmap paramBitmap)
  {
    return a(Util.a(paramBitmap));
  }
  
  @Nullable
  public Bitmap a()
  {
    Bitmap localBitmap = (Bitmap)this.b.a();
    if (localBitmap != null) {
      a(Integer.valueOf(Util.a(localBitmap)));
    }
    return localBitmap;
  }
  
  @Nullable
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = Util.a(paramInt1, paramInt2, paramConfig);
    SizeStrategy.Key localKey = this.a.a(i);
    Integer localInteger = (Integer)this.c.ceilingKey(Integer.valueOf(i));
    Object localObject = localKey;
    if (localInteger != null)
    {
      localObject = localKey;
      if (localInteger.intValue() != i)
      {
        localObject = localKey;
        if (localInteger.intValue() <= i * 8)
        {
          this.a.a(localKey);
          localObject = this.a.a(localInteger.intValue());
        }
      }
    }
    localObject = (Bitmap)this.b.a((Poolable)localObject);
    if (localObject != null)
    {
      ((Bitmap)localObject).reconfigure(paramInt1, paramInt2, paramConfig);
      a(localInteger);
    }
    return localObject;
  }
  
  public void a(Bitmap paramBitmap)
  {
    int i = Util.a(paramBitmap);
    SizeStrategy.Key localKey = this.a.a(i);
    this.b.a(localKey, paramBitmap);
    paramBitmap = (Integer)this.c.get(Integer.valueOf(localKey.a));
    NavigableMap localNavigableMap = this.c;
    int j = localKey.a;
    i = 1;
    if (paramBitmap != null) {
      i = 1 + paramBitmap.intValue();
    }
    localNavigableMap.put(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return a(Util.a(paramInt1, paramInt2, paramConfig));
  }
  
  public String b(Bitmap paramBitmap)
  {
    return d(paramBitmap);
  }
  
  public int c(Bitmap paramBitmap)
  {
    return Util.a(paramBitmap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SizeStrategy:\n  ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n  SortedSizes");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy
 * JD-Core Version:    0.7.0.1
 */