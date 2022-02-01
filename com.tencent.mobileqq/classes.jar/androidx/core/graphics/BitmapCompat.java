package androidx.core.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class BitmapCompat
{
  public static int getAllocationByteCount(@NonNull Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramBitmap.getAllocationByteCount();
    }
    return paramBitmap.getByteCount();
  }
  
  public static boolean hasMipMap(@NonNull Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramBitmap.hasMipMap();
    }
    return false;
  }
  
  public static void setHasMipMap(@NonNull Bitmap paramBitmap, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramBitmap.setHasMipMap(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.BitmapCompat
 * JD-Core Version:    0.7.0.1
 */