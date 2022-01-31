package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class BitmapCompat
{
  static final BitmapCompat.BitmapCompatBaseImpl IMPL = new BitmapCompat.BitmapCompatBaseImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new BitmapCompat.BitmapCompatApi19Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new BitmapCompat.BitmapCompatApi18Impl();
      return;
    }
  }
  
  public static int getAllocationByteCount(Bitmap paramBitmap)
  {
    return IMPL.getAllocationByteCount(paramBitmap);
  }
  
  public static boolean hasMipMap(Bitmap paramBitmap)
  {
    return IMPL.hasMipMap(paramBitmap);
  }
  
  public static void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean)
  {
    IMPL.setHasMipMap(paramBitmap, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v4.graphics.BitmapCompat
 * JD-Core Version:    0.7.0.1
 */