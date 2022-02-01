package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public abstract interface Key
{
  public static final Charset a = Charset.forName("UTF-8");
  
  public abstract void a(@NonNull MessageDigest paramMessageDigest);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.Key
 * JD-Core Version:    0.7.0.1
 */