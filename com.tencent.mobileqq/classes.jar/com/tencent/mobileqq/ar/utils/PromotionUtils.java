package com.tencent.mobileqq.ar.utils;

import android.os.Bundle;

public final class PromotionUtils
{
  public static Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new PromotionUtils.PromotionDataBuilder(localBundle);
    paramBundle.a(10L);
    paramBundle.b(true);
    paramBundle.a(true);
    paramBundle.b(4096L);
    return paramBundle.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.PromotionUtils
 * JD-Core Version:    0.7.0.1
 */