package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;

@RequiresApi(18)
class BitmapCompat$BitmapCompatApi18Impl
  extends BitmapCompat.BitmapCompatBaseImpl
{
  public boolean hasMipMap(Bitmap paramBitmap)
  {
    return paramBitmap.hasMipMap();
  }
  
  public void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean)
  {
    paramBitmap.setHasMipMap(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.graphics.BitmapCompat.BitmapCompatApi18Impl
 * JD-Core Version:    0.7.0.1
 */