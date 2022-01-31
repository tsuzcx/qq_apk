package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory
{
  private static final String TAG = "RoundedBitmapDrawableFactory";
  
  public static RoundedBitmapDrawable create(Resources paramResources, Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new RoundedBitmapDrawable21(paramResources, paramBitmap);
    }
    return new RoundedBitmapDrawableFactory.DefaultRoundedBitmapDrawable(paramResources, paramBitmap);
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, InputStream paramInputStream)
  {
    paramResources = create(paramResources, BitmapFactory.decodeStream(paramInputStream));
    if (paramResources.getBitmap() == null) {
      Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + paramInputStream);
    }
    return paramResources;
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, String paramString)
  {
    paramResources = create(paramResources, BitmapFactory.decodeFile(paramString));
    if (paramResources.getBitmap() == null) {
      Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + paramString);
    }
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
 * JD-Core Version:    0.7.0.1
 */