package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.pool.FactoryPools.Factory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class SafeKeyGenerator$1
  implements FactoryPools.Factory<SafeKeyGenerator.PoolableDigestContainer>
{
  SafeKeyGenerator$1(SafeKeyGenerator paramSafeKeyGenerator) {}
  
  public SafeKeyGenerator.PoolableDigestContainer a()
  {
    try
    {
      SafeKeyGenerator.PoolableDigestContainer localPoolableDigestContainer = new SafeKeyGenerator.PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
      return localPoolableDigestContainer;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.SafeKeyGenerator.1
 * JD-Core Version:    0.7.0.1
 */