package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import java.security.MessageDigest;

public abstract interface Option$CacheKeyUpdater<T>
{
  public abstract void a(@NonNull byte[] paramArrayOfByte, @NonNull T paramT, @NonNull MessageDigest paramMessageDigest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.Option.CacheKeyUpdater
 * JD-Core Version:    0.7.0.1
 */