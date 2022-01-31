package com.tencent.mobileqq.activity.aio.stickerrecommended;

import java.io.Serializable;

public class BloomFilter$SimpleHash
  implements Serializable
{
  private int cap;
  private int seed;
  
  public BloomFilter$SimpleHash(int paramInt1, int paramInt2)
  {
    this.cap = paramInt1;
    this.seed = paramInt2;
  }
  
  public int hash(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    int j = 0;
    while (i < k)
    {
      j = j * this.seed + paramString.charAt(i);
      i += 1;
    }
    return this.cap - 1 & j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter.SimpleHash
 * JD-Core Version:    0.7.0.1
 */