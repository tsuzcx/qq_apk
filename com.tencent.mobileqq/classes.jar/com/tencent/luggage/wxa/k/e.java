package com.tencent.luggage.wxa.k;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
public final class e
  implements d
{
  private final MediaCrypto a;
  private final boolean b;
  
  public MediaCrypto a()
  {
    return this.a;
  }
  
  public boolean a(String paramString)
  {
    return (!this.b) && (this.a.requiresSecureDecoderComponent(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.k.e
 * JD-Core Version:    0.7.0.1
 */