package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

@RequiresApi(19)
public class SizeConfigStrategy
  implements LruPoolStrategy
{
  private static final Bitmap.Config[] a;
  private static final Bitmap.Config[] b = a;
  private static final Bitmap.Config[] c = { Bitmap.Config.RGB_565 };
  private static final Bitmap.Config[] d = { Bitmap.Config.ARGB_4444 };
  private static final Bitmap.Config[] e = { Bitmap.Config.ALPHA_8 };
  private final SizeConfigStrategy.KeyPool f = new SizeConfigStrategy.KeyPool();
  private final GroupedLinkedMap<SizeConfigStrategy.Key, Bitmap> g = new GroupedLinkedMap();
  private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> h = new HashMap();
  
  static
  {
    Bitmap.Config[] arrayOfConfig2 = new Bitmap.Config[2];
    arrayOfConfig2[0] = Bitmap.Config.ARGB_8888;
    arrayOfConfig2[1] = null;
    Bitmap.Config[] arrayOfConfig1 = arrayOfConfig2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      arrayOfConfig1 = (Bitmap.Config[])Arrays.copyOf(arrayOfConfig2, arrayOfConfig2.length + 1);
      arrayOfConfig1[(arrayOfConfig1.length - 1)] = Bitmap.Config.RGBA_F16;
    }
    a = arrayOfConfig1;
  }
  
  static String a(int paramInt, Bitmap.Config paramConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("](");
    localStringBuilder.append(paramConfig);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private NavigableMap<Integer, Integer> a(Bitmap.Config paramConfig)
  {
    NavigableMap localNavigableMap = (NavigableMap)this.h.get(paramConfig);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.h.put(paramConfig, localObject);
    }
    return localObject;
  }
  
  private void a(Integer paramInteger, Bitmap paramBitmap)
  {
    Object localObject = a(paramBitmap.getConfig());
    Integer localInteger = (Integer)((NavigableMap)localObject).get(paramInteger);
    if (localInteger != null)
    {
      if (localInteger.intValue() == 1)
      {
        ((NavigableMap)localObject).remove(paramInteger);
        return;
      }
      ((NavigableMap)localObject).put(paramInteger, Integer.valueOf(localInteger.intValue() - 1));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Tried to decrement empty size, size: ");
    ((StringBuilder)localObject).append(paramInteger);
    ((StringBuilder)localObject).append(", removed: ");
    ((StringBuilder)localObject).append(b(paramBitmap));
    ((StringBuilder)localObject).append(", this: ");
    ((StringBuilder)localObject).append(this);
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  private SizeConfigStrategy.Key b(int paramInt, Bitmap.Config paramConfig)
  {
    SizeConfigStrategy.Key localKey = this.f.a(paramInt, paramConfig);
    Bitmap.Config[] arrayOfConfig = b(paramConfig);
    int j = arrayOfConfig.length;
    int i = 0;
    while (i < j)
    {
      Bitmap.Config localConfig = arrayOfConfig[i];
      Integer localInteger = (Integer)a(localConfig).ceilingKey(Integer.valueOf(paramInt));
      if ((localInteger != null) && (localInteger.intValue() <= paramInt * 8))
      {
        if ((localInteger.intValue() == paramInt) && (localConfig == null ? paramConfig == null : localConfig.equals(paramConfig))) {
          break;
        }
        this.f.a(localKey);
        return this.f.a(localInteger.intValue(), localConfig);
      }
      i += 1;
    }
    return localKey;
  }
  
  private static Bitmap.Config[] b(Bitmap.Config paramConfig)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.RGBA_F16.equals(paramConfig))) {
      return b;
    }
    int i = SizeConfigStrategy.1.a[paramConfig.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return new Bitmap.Config[] { paramConfig };
          }
          return e;
        }
        return d;
      }
      return c;
    }
    return a;
  }
  
  @Nullable
  public Bitmap a()
  {
    Bitmap localBitmap = (Bitmap)this.g.a();
    if (localBitmap != null) {
      a(Integer.valueOf(Util.a(localBitmap)), localBitmap);
    }
    return localBitmap;
  }
  
  @Nullable
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    paramConfig = b(Util.a(paramInt1, paramInt2, paramConfig), paramConfig);
    Bitmap localBitmap = (Bitmap)this.g.a(paramConfig);
    if (localBitmap != null)
    {
      a(Integer.valueOf(paramConfig.a), localBitmap);
      if (localBitmap.getConfig() != null) {
        paramConfig = localBitmap.getConfig();
      } else {
        paramConfig = Bitmap.Config.ARGB_8888;
      }
      localBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
    }
    return localBitmap;
  }
  
  public void a(Bitmap paramBitmap)
  {
    int i = Util.a(paramBitmap);
    SizeConfigStrategy.Key localKey = this.f.a(i, paramBitmap.getConfig());
    this.g.a(localKey, paramBitmap);
    paramBitmap = a(paramBitmap.getConfig());
    Integer localInteger = (Integer)paramBitmap.get(Integer.valueOf(localKey.a));
    int j = localKey.a;
    i = 1;
    if (localInteger != null) {
      i = 1 + localInteger.intValue();
    }
    paramBitmap.put(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return a(Util.a(paramInt1, paramInt2, paramConfig), paramConfig);
  }
  
  public String b(Bitmap paramBitmap)
  {
    return a(Util.a(paramBitmap), paramBitmap.getConfig());
  }
  
  public int c(Bitmap paramBitmap)
  {
    return Util.a(paramBitmap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SizeConfigStrategy{groupedMap=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", sortedSizes=(");
    Iterator localIterator = this.h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry.getKey());
      localStringBuilder.append('[');
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append("], ");
    }
    if (!this.h.isEmpty()) {
      localStringBuilder.replace(localStringBuilder.length() - 2, localStringBuilder.length(), "");
    }
    localStringBuilder.append(")}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy
 * JD-Core Version:    0.7.0.1
 */