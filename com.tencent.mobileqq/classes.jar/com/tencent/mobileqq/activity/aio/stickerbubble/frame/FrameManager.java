package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FrameManager
{
  private Context a;
  private Map<String, BitmapDrawable[]> b;
  private Map<String, Integer> c;
  private Set<String> d = new HashSet();
  
  public FrameManager(Context paramContext, Map paramMap1, Map paramMap2)
  {
    this.a = paramContext;
    this.b = paramMap1;
    this.c = paramMap2;
  }
  
  @Nullable
  private Bitmap a(@NonNull Bitmap paramBitmap, double paramDouble)
  {
    double d1 = this.a.getResources().getDisplayMetrics().density;
    Double.isNaN(d1);
    paramDouble = paramDouble * d1 / 2.75D;
    try
    {
      int i = paramBitmap.getWidth();
      d1 = i;
      Double.isNaN(d1);
      i = (int)(d1 * paramDouble);
      int j = paramBitmap.getHeight();
      d1 = j;
      Double.isNaN(d1);
      j = (int)(d1 * paramDouble);
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      label91:
      break label91;
    }
    QLog.e("StickerBubble_FrameDecode", 1, "oom when scale bitmap");
    return null;
  }
  
  private IFrameDecode a(String paramString)
  {
    try
    {
      if (paramString.startsWith("id_")) {
        return new StaticFrameDecode(Integer.valueOf(paramString.substring(3)).intValue());
      }
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("gifFile ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" is not exist");
        QLog.e("StickerBubble_FrameDecode", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      paramString = ((File)localObject).getName().split("\\.");
      if (paramString[(paramString.length - 1)].equals("gif")) {
        return new GifFrameDecode((File)localObject, false);
      }
      if (ApngDrawable.isApngFile((File)localObject))
      {
        paramString = new ApngFrameDecode((File)localObject);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("StickerBubble_FrameDecode", 1, "init frameDecoder failed ", paramString);
    }
    return null;
  }
  
  private void a(IFrameDecode paramIFrameDecode, BitmapDrawable[] paramArrayOfBitmapDrawable, String paramString, int paramInt)
  {
    ThreadManager.excute(new FrameManager.2(this, paramArrayOfBitmapDrawable, paramIFrameDecode, paramString, paramInt), 64, null, true);
  }
  
  private void b(String paramString)
  {
    ThreadManager.excute(new FrameManager.1(this, paramString), 64, null, true);
  }
  
  public void a()
  {
    this.b.clear();
    this.c.clear();
    this.d.clear();
  }
  
  public void a(Set<String> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!this.b.containsKey(str))
      {
        FrameCache.CacheItem localCacheItem = FrameCache.a(str);
        if (localCacheItem != null)
        {
          this.b.put(str, localCacheItem.a());
          this.c.put(str, Integer.valueOf(localCacheItem.b()));
          if (QLog.isColorLevel()) {
            QLog.d("StickerBubble_FrameDecode", 2, "get frames from cache");
          }
        }
        else if (!this.d.contains(str))
        {
          this.d.add(str);
          b(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameManager
 * JD-Core Version:    0.7.0.1
 */