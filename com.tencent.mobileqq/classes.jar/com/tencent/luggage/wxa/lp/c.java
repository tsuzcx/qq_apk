package com.tencent.luggage.wxa.lp;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hv.i;

public final class c
{
  @Nullable
  public static b.a a(i parami)
  {
    parami = parami.optString("pictureInPictureMode", null);
    if (parami == null) {
      return null;
    }
    return b.a.a(parami);
  }
  
  @Nullable
  public static Boolean b(i parami)
  {
    if (parami.has("pictureInPictureShowProgress")) {
      return Boolean.valueOf(parami.optBoolean("pictureInPictureShowProgress", false));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lp.c
 * JD-Core Version:    0.7.0.1
 */