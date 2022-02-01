package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;

class RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable
  extends RoundedBitmapDrawable
{
  RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  void gravityCompatApply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    GravityCompat.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
  }
  
  public boolean hasMipMap()
  {
    return (this.mBitmap != null) && (BitmapCompat.hasMipMap(this.mBitmap));
  }
  
  public void setMipMap(boolean paramBoolean)
  {
    if (this.mBitmap != null)
    {
      BitmapCompat.setHasMipMap(this.mBitmap, paramBoolean);
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.drawable.RoundedBitmapDrawableFactory.DefaultRoundedBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */