package com.bumptech.glide.load.engine.cache;

import android.support.annotation.NonNull;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;

final class SafeKeyGenerator$PoolableDigestContainer
  implements FactoryPools.Poolable
{
  final MessageDigest a;
  private final StateVerifier b = StateVerifier.a();
  
  SafeKeyGenerator$PoolableDigestContainer(MessageDigest paramMessageDigest)
  {
    this.a = paramMessageDigest;
  }
  
  @NonNull
  public StateVerifier E_()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.SafeKeyGenerator.PoolableDigestContainer
 * JD-Core Version:    0.7.0.1
 */