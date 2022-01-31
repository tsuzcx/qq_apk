import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;

public class bdfz
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
  
  public static sfc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString = BaseApplicationImpl.sImageCache.get(paramString);
      if ((paramString instanceof sfc)) {
        return (sfc)paramString;
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
  
  public static void a(String paramString, sfc paramsfc)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramsfc == null)) {}
    while (BaseApplicationImpl.sImageCache == null) {
      return;
    }
    BaseApplicationImpl.sImageCache.put(paramString, paramsfc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfz
 * JD-Core Version:    0.7.0.1
 */