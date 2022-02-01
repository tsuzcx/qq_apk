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
  private Context jdField_a_of_type_AndroidContentContext;
  private Map<String, BitmapDrawable[]> jdField_a_of_type_JavaUtilMap;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private Map<String, Integer> b;
  
  public FrameManager(Context paramContext, Map paramMap1, Map paramMap2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilMap = paramMap1;
    this.b = paramMap2;
  }
  
  @Nullable
  private Bitmap a(@NonNull Bitmap paramBitmap, double paramDouble)
  {
    double d = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    Double.isNaN(d);
    paramDouble = paramDouble * d / 2.75D;
    try
    {
      int i = paramBitmap.getWidth();
      d = i;
      Double.isNaN(d);
      i = (int)(d * paramDouble);
      int j = paramBitmap.getHeight();
      d = j;
      Double.isNaN(d);
      j = (int)(d * paramDouble);
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
  
  private void a(String paramString)
  {
    ThreadManager.excute(new FrameManager.1(this, paramString), 64, null, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.b.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void a(Set<String> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str))
      {
        FrameCache.CacheItem localCacheItem = FrameCache.a(str);
        if (localCacheItem != null)
        {
          this.jdField_a_of_type_JavaUtilMap.put(str, localCacheItem.a());
          this.b.put(str, Integer.valueOf(localCacheItem.a()));
          if (QLog.isColorLevel()) {
            QLog.d("StickerBubble_FrameDecode", 2, "get frames from cache");
          }
        }
        else if (!this.jdField_a_of_type_JavaUtilSet.contains(str))
        {
          this.jdField_a_of_type_JavaUtilSet.add(str);
          a(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameManager
 * JD-Core Version:    0.7.0.1
 */