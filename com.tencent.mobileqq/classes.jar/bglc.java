import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;

public class bglc
{
  public static Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString = BaseApplicationImpl.sImageCache.get(paramString);
      if ((paramString != null) && ((paramString instanceof Bitmap))) {
        return (Bitmap)paramString;
      }
    }
    return null;
  }
  
  public static Sizeable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString = BaseApplicationImpl.sImageCache.get(paramString);
      if ((paramString != null) && ((paramString instanceof Sizeable))) {
        return (Sizeable)paramString;
      }
    }
    return null;
  }
  
  public static tds a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString = BaseApplicationImpl.sImageCache.get(paramString);
      if ((paramString instanceof tds)) {
        return (tds)paramString;
      }
    }
    return null;
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    while (BaseApplicationImpl.sImageCache == null) {
      return;
    }
    BaseApplicationImpl.sImageCache.put(paramString, paramBitmap);
  }
  
  public static void a(String paramString, Sizeable paramSizeable)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramSizeable == null)) {}
    while (BaseApplicationImpl.sImageCache == null) {
      return;
    }
    BaseApplicationImpl.sImageCache.put(paramString, paramSizeable);
  }
  
  public static void a(String paramString, tds paramtds)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramtds == null)) {}
    while (BaseApplicationImpl.sImageCache == null) {
      return;
    }
    BaseApplicationImpl.sImageCache.put(paramString, paramtds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglc
 * JD-Core Version:    0.7.0.1
 */