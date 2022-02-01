package androidx.recyclerview.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$SpanSizeLookup
{
  private boolean mCacheSpanGroupIndices = false;
  private boolean mCacheSpanIndices = false;
  final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
  final SparseIntArray mSpanIndexCache = new SparseIntArray();
  
  static int findFirstKeyLessThan(SparseIntArray paramSparseIntArray, int paramInt)
  {
    int i = 0;
    int j = paramSparseIntArray.size() - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      if (paramSparseIntArray.keyAt(k) < paramInt) {
        i = k + 1;
      } else {
        j = k - 1;
      }
    }
    paramInt = i - 1;
    if ((paramInt >= 0) && (paramInt < paramSparseIntArray.size())) {
      return paramSparseIntArray.keyAt(paramInt);
    }
    return -1;
  }
  
  int getCachedSpanGroupIndex(int paramInt1, int paramInt2)
  {
    int i;
    if (!this.mCacheSpanGroupIndices) {
      i = getSpanGroupIndex(paramInt1, paramInt2);
    }
    int j;
    do
    {
      return i;
      j = this.mSpanGroupIndexCache.get(paramInt1, -1);
      i = j;
    } while (j != -1);
    paramInt2 = getSpanGroupIndex(paramInt1, paramInt2);
    this.mSpanGroupIndexCache.put(paramInt1, paramInt2);
    return paramInt2;
  }
  
  int getCachedSpanIndex(int paramInt1, int paramInt2)
  {
    int i;
    if (!this.mCacheSpanIndices) {
      i = getSpanIndex(paramInt1, paramInt2);
    }
    int j;
    do
    {
      return i;
      j = this.mSpanIndexCache.get(paramInt1, -1);
      i = j;
    } while (j != -1);
    paramInt2 = getSpanIndex(paramInt1, paramInt2);
    this.mSpanIndexCache.put(paramInt1, paramInt2);
    return paramInt2;
  }
  
  public int getSpanGroupIndex(int paramInt1, int paramInt2)
  {
    int i;
    int n;
    int m;
    int j;
    int k;
    if (this.mCacheSpanGroupIndices)
    {
      i = findFirstKeyLessThan(this.mSpanGroupIndexCache, paramInt1);
      if (i != -1)
      {
        n = this.mSpanGroupIndexCache.get(i);
        m = i + 1;
        j = getCachedSpanIndex(i, paramInt2);
        int i1 = getSpanSize(i) + j;
        k = m;
        j = n;
        i = i1;
        if (i1 == paramInt2)
        {
          j = n + 1;
          i = 0;
          k = m;
        }
      }
    }
    for (;;)
    {
      n = getSpanSize(paramInt1);
      m = j;
      j = i;
      i = m;
      if (k < paramInt1)
      {
        m = getSpanSize(k);
        j += m;
        if (j == paramInt2)
        {
          j = i + 1;
          i = 0;
        }
      }
      for (;;)
      {
        m = k + 1;
        k = i;
        i = j;
        j = k;
        k = m;
        break;
        if (j > paramInt2)
        {
          j = i + 1;
          i = m;
          continue;
          paramInt1 = i;
          if (j + n > paramInt2) {
            paramInt1 = i + 1;
          }
          return paramInt1;
        }
        else
        {
          m = j;
          j = i;
          i = m;
        }
      }
      k = 0;
      j = 0;
      i = 0;
    }
  }
  
  public int getSpanIndex(int paramInt1, int paramInt2)
  {
    int n = getSpanSize(paramInt1);
    if (n == paramInt2) {
      return 0;
    }
    int j;
    int i;
    if (this.mCacheSpanIndices)
    {
      j = findFirstKeyLessThan(this.mSpanIndexCache, paramInt1);
      if (j >= 0)
      {
        i = this.mSpanIndexCache.get(j) + getSpanSize(j);
        j += 1;
      }
    }
    for (;;)
    {
      if (j < paramInt1)
      {
        int k = getSpanSize(j);
        int m = i + k;
        if (m == paramInt2) {
          i = 0;
        }
        for (;;)
        {
          j += 1;
          break;
          i = k;
          if (m <= paramInt2) {
            i = m;
          }
        }
      }
      if (i + n > paramInt2) {
        break;
      }
      return i;
      j = 0;
      i = 0;
    }
  }
  
  public abstract int getSpanSize(int paramInt);
  
  public void invalidateSpanGroupIndexCache()
  {
    this.mSpanGroupIndexCache.clear();
  }
  
  public void invalidateSpanIndexCache()
  {
    this.mSpanIndexCache.clear();
  }
  
  public boolean isSpanGroupIndexCacheEnabled()
  {
    return this.mCacheSpanGroupIndices;
  }
  
  public boolean isSpanIndexCacheEnabled()
  {
    return this.mCacheSpanIndices;
  }
  
  public void setSpanGroupIndexCacheEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.mSpanGroupIndexCache.clear();
    }
    this.mCacheSpanGroupIndices = paramBoolean;
  }
  
  public void setSpanIndexCacheEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.mSpanGroupIndexCache.clear();
    }
    this.mCacheSpanIndices = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
 * JD-Core Version:    0.7.0.1
 */