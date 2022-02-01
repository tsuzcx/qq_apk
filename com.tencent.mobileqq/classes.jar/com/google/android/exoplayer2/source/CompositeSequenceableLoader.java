package com.google.android.exoplayer2.source;

public class CompositeSequenceableLoader
  implements SequenceableLoader
{
  protected final SequenceableLoader[] loaders;
  
  public CompositeSequenceableLoader(SequenceableLoader[] paramArrayOfSequenceableLoader)
  {
    this.loaders = paramArrayOfSequenceableLoader;
  }
  
  public boolean continueLoading(long paramLong)
  {
    boolean bool3 = false;
    boolean bool1;
    boolean bool4;
    do
    {
      long l1 = getNextLoadPositionUs();
      if (l1 == -9223372036854775808L) {
        return bool3;
      }
      SequenceableLoader[] arrayOfSequenceableLoader = this.loaders;
      int k = arrayOfSequenceableLoader.length;
      int i = 0;
      bool1 = false;
      if (i < k)
      {
        SequenceableLoader localSequenceableLoader = arrayOfSequenceableLoader[i];
        long l2 = localSequenceableLoader.getNextLoadPositionUs();
        if ((l2 != -9223372036854775808L) && (l2 <= paramLong)) {}
        for (int j = 1;; j = 0)
        {
          boolean bool2;
          if (l2 != l1)
          {
            bool2 = bool1;
            if (j == 0) {}
          }
          else
          {
            bool2 = bool1 | localSequenceableLoader.continueLoading(paramLong);
          }
          i += 1;
          bool1 = bool2;
          break;
        }
      }
      bool4 = bool3 | bool1;
      bool3 = bool4;
    } while (bool1);
    return bool4;
  }
  
  public final long getBufferedPositionUs()
  {
    SequenceableLoader[] arrayOfSequenceableLoader = this.loaders;
    int j = arrayOfSequenceableLoader.length;
    int i = 0;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfSequenceableLoader[i].getBufferedPositionUs();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -9223372036854775808L;
    }
    return l2;
  }
  
  public final long getNextLoadPositionUs()
  {
    SequenceableLoader[] arrayOfSequenceableLoader = this.loaders;
    int j = arrayOfSequenceableLoader.length;
    int i = 0;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfSequenceableLoader[i].getNextLoadPositionUs();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -9223372036854775808L;
    }
    return l2;
  }
  
  public final void reevaluateBuffer(long paramLong)
  {
    SequenceableLoader[] arrayOfSequenceableLoader = this.loaders;
    int j = arrayOfSequenceableLoader.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSequenceableLoader[i].reevaluateBuffer(paramLong);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.CompositeSequenceableLoader
 * JD-Core Version:    0.7.0.1
 */