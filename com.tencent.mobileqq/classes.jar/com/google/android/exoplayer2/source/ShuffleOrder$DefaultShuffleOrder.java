package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

public class ShuffleOrder$DefaultShuffleOrder
  implements ShuffleOrder
{
  private final int[] indexInShuffled;
  private final Random random;
  private final int[] shuffled;
  
  public ShuffleOrder$DefaultShuffleOrder(int paramInt)
  {
    this(paramInt, new Random());
  }
  
  public ShuffleOrder$DefaultShuffleOrder(int paramInt, long paramLong)
  {
    this(paramInt, new Random(paramLong));
  }
  
  private ShuffleOrder$DefaultShuffleOrder(int paramInt, Random paramRandom)
  {
    this(createShuffledList(paramInt, paramRandom), paramRandom);
  }
  
  private ShuffleOrder$DefaultShuffleOrder(int[] paramArrayOfInt, Random paramRandom)
  {
    this.shuffled = paramArrayOfInt;
    this.random = paramRandom;
    this.indexInShuffled = new int[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      this.indexInShuffled[paramArrayOfInt[i]] = i;
      i += 1;
    }
  }
  
  private static int[] createShuffledList(int paramInt, Random paramRandom)
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramRandom.nextInt(i + 1);
      arrayOfInt[i] = arrayOfInt[j];
      arrayOfInt[j] = i;
      i += 1;
    }
    return arrayOfInt;
  }
  
  public ShuffleOrder cloneAndClear()
  {
    return new DefaultShuffleOrder(0, new Random(this.random.nextLong()));
  }
  
  public ShuffleOrder cloneAndInsert(int paramInt1, int paramInt2)
  {
    int m = 0;
    int[] arrayOfInt1 = new int[paramInt2];
    int[] arrayOfInt2 = new int[paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      arrayOfInt1[i] = this.random.nextInt(this.shuffled.length + 1);
      j = this.random.nextInt(i + 1);
      arrayOfInt2[i] = arrayOfInt2[j];
      arrayOfInt2[j] = (i + paramInt1);
      i += 1;
    }
    Arrays.sort(arrayOfInt1);
    int[] arrayOfInt3 = new int[this.shuffled.length + paramInt2];
    int j = 0;
    int k = 0;
    i = m;
    if (i < this.shuffled.length + paramInt2)
    {
      if ((j < paramInt2) && (k == arrayOfInt1[j]))
      {
        arrayOfInt3[i] = arrayOfInt2[j];
        j += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfInt3[i] = this.shuffled[k];
        if (arrayOfInt3[i] >= paramInt1) {
          arrayOfInt3[i] += paramInt2;
        }
        k += 1;
      }
    }
    return new DefaultShuffleOrder(arrayOfInt3, new Random(this.random.nextLong()));
  }
  
  public ShuffleOrder cloneAndRemove(int paramInt)
  {
    int i = 0;
    int[] arrayOfInt = new int[this.shuffled.length - 1];
    int j = 0;
    while (i < this.shuffled.length) {
      if (this.shuffled[i] == paramInt)
      {
        j = 1;
        i += 1;
      }
      else
      {
        int k;
        if (j != 0)
        {
          k = i - 1;
          label52:
          if (this.shuffled[i] <= paramInt) {
            break label88;
          }
        }
        label88:
        for (int m = this.shuffled[i] - 1;; m = this.shuffled[i])
        {
          arrayOfInt[k] = m;
          break;
          k = i;
          break label52;
        }
      }
    }
    return new DefaultShuffleOrder(arrayOfInt, new Random(this.random.nextLong()));
  }
  
  public int getFirstIndex()
  {
    if (this.shuffled.length > 0) {
      return this.shuffled[0];
    }
    return -1;
  }
  
  public int getLastIndex()
  {
    if (this.shuffled.length > 0) {
      return this.shuffled[(this.shuffled.length - 1)];
    }
    return -1;
  }
  
  public int getLength()
  {
    return this.shuffled.length;
  }
  
  public int getNextIndex(int paramInt)
  {
    paramInt = this.indexInShuffled[paramInt] + 1;
    if (paramInt < this.shuffled.length) {
      return this.shuffled[paramInt];
    }
    return -1;
  }
  
  public int getPreviousIndex(int paramInt)
  {
    paramInt = this.indexInShuffled[paramInt] - 1;
    if (paramInt >= 0) {
      return this.shuffled[paramInt];
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ShuffleOrder.DefaultShuffleOrder
 * JD-Core Version:    0.7.0.1
 */