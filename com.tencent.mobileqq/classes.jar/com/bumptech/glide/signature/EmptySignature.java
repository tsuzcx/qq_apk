package com.bumptech.glide.signature;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class EmptySignature
  implements Key
{
  private static final EmptySignature b = new EmptySignature();
  
  @NonNull
  public static EmptySignature a()
  {
    return b;
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest) {}
  
  public String toString()
  {
    return "EmptySignature";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.signature.EmptySignature
 * JD-Core Version:    0.7.0.1
 */