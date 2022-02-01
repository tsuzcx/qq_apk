import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;

public class bhdb
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
  
  public static tls a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString = BaseApplicationImpl.sImageCache.get(paramString);
      if ((paramString instanceof tls)) {
        return (tls)paramString;
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
  
  public static void a(String paramString, tls paramtls)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramtls == null)) {}
    while (BaseApplicationImpl.sImageCache == null) {
      return;
    }
    BaseApplicationImpl.sImageCache.put(paramString, paramtls);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdb
 * JD-Core Version:    0.7.0.1
 */