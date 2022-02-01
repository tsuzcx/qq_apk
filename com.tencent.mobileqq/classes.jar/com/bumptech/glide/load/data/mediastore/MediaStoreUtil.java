package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import java.util.List;

public final class MediaStoreUtil
{
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != -2147483648) && (paramInt2 != -2147483648) && (paramInt1 <= 512) && (paramInt2 <= 384);
  }
  
  public static boolean a(Uri paramUri)
  {
    return (paramUri != null) && ("content".equals(paramUri.getScheme())) && ("media".equals(paramUri.getAuthority()));
  }
  
  public static boolean b(Uri paramUri)
  {
    return (a(paramUri)) && (d(paramUri));
  }
  
  public static boolean c(Uri paramUri)
  {
    return (a(paramUri)) && (!d(paramUri));
  }
  
  private static boolean d(Uri paramUri)
  {
    return paramUri.getPathSegments().contains("video");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.mediastore.MediaStoreUtil
 * JD-Core Version:    0.7.0.1
 */