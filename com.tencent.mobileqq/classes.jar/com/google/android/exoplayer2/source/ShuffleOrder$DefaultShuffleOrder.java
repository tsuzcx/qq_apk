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
    int j;
    for (int i = 0; i < paramInt; i = j)
    {
      j = i + 1;
      int k = paramRandom.nextInt(j);
      arrayOfInt[i] = arrayOfInt[k];
      arrayOfInt[k] = i;
    }
    return arrayOfInt;
  }
  
  public ShuffleOrder cloneAndClear()
  {
    return new DefaultShuffleOrder(0, new Random(this.random.nextLong()));
  }
  
  public ShuffleOrder cloneAndInsert(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt1 = new int[paramInt2];
    int[] arrayOfInt2 = new int[paramInt2];
    int m = 0;
    for (int i = 0; i < paramInt2; i = j)
    {
      arrayOfInt1[i] = this.random.nextInt(this.shuffled.length + 1);
      localObject = this.random;
      j = i + 1;
      k = ((Random)localObject).nextInt(j);
      arrayOfInt2[i] = arrayOfInt2[k];
      arrayOfInt2[k] = (i + paramInt1);
    }
    Arrays.sort(arrayOfInt1);
    Object localObject = new int[this.shuffled.length + paramInt2];
    int k = 0;
    int j = 0;
    i = m;
    while (i < this.shuffled.length + paramInt2)
    {
      if ((k < paramInt2) && (j == arrayOfInt1[k]))
      {
        localObject[i] = arrayOfInt2[k];
        k += 1;
      }
      else
      {
        localObject[i] = this.shuffled[j];
        if (localObject[i] >= paramInt1) {
          localObject[i] += paramInt2;
        }
        j += 1;
      }
      i += 1;
    }
    return new DefaultShuffleOrder((int[])localObject, new Random(this.random.nextLong()));
  }
  
  public ShuffleOrder cloneAndRemove(int paramInt)
  {
    int[] arrayOfInt1 = new int[this.shuffled.length - 1];
    int i = 0;
    int j = 0;
    for (;;)
    {
      int[] arrayOfInt2 = this.shuffled;
      if (i >= arrayOfInt2.length) {
        break;
      }
      if (arrayOfInt2[i] == paramInt)
      {
        j = 1;
      }
      else
      {
        int k;
        if (j != 0) {
          k = i - 1;
        } else {
          k = i;
        }
        arrayOfInt2 = this.shuffled;
        int m;
        if (arrayOfInt2[i] > paramInt) {
          m = arrayOfInt2[i] - 1;
        } else {
          m = arrayOfInt2[i];
        }
        arrayOfInt1[k] = m;
      }
      i += 1;
    }
    return new DefaultShuffleOrder(arrayOfInt1, new Random(this.random.nextLong()));
  }
  
  public int getFirstIndex()
  {
    int[] arrayOfInt = this.shuffled;
    if (arrayOfInt.length > 0) {
      return arrayOfInt[0];
    }
    return -1;
  }
  
  public int getLastIndex()
  {
    int[] arrayOfInt = this.shuffled;
    if (arrayOfInt.length > 0) {
      return arrayOfInt[(arrayOfInt.length - 1)];
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
    int[] arrayOfInt = this.shuffled;
    if (paramInt < arrayOfInt.length) {
      return arrayOfInt[paramInt];
    }
    return -1;
  }
  
  public int getPreviousIndex(int paramInt)
  {
    int i = this.indexInShuffled[paramInt];
    paramInt = -1;
    i -= 1;
    if (i >= 0) {
      paramInt = this.shuffled[i];
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ShuffleOrder.DefaultShuffleOrder
 * JD-Core Version:    0.7.0.1
 */