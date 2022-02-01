package com.tencent.mm.graphics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import java.io.InputStream;

public class MMBitmapFactory
{
  @Nullable
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    return MMBitmapFactoryImpl.getInstance().decodeResource(paramResources, paramInt);
  }
  
  @Nullable
  public static Bitmap a(InputStream paramInputStream, @Nullable Rect paramRect, @Nullable BitmapFactory.Options paramOptions)
  {
    return MMBitmapFactoryImpl.getInstance().decodeStream(paramInputStream, paramRect, paramOptions);
  }
  
  @Nullable
  public static Bitmap a(String paramString)
  {
    return MMBitmapFactoryImpl.getInstance().decodeFile(paramString);
  }
  
  public static void a(@Nullable MMBitmapFactory.a parama)
  {
    MMBitmapFactoryImpl.setNativeLibraryLoader(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.graphics.MMBitmapFactory
 * JD-Core Version:    0.7.0.1
 */