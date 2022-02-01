package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$SpanSizeLookup
{
  private boolean mCacheSpanIndices = false;
  final SparseIntArray mSpanIndexCache = new SparseIntArray();
  
  int findReferenceIndexFromCache(int paramInt)
  {
    int j = this.mSpanIndexCache.size() - 1;
    int i = 0;
    while (i <= j)
    {
      int k = i + j >>> 1;
      if (this.mSpanIndexCache.keyAt(k) < paramInt) {
        i = k + 1;
      } else {
        j = k - 1;
      }
    }
    paramInt = i - 1;
    if ((paramInt >= 0) && (paramInt < this.mSpanIndexCache.size())) {
      return this.mSpanIndexCache.keyAt(paramInt);
    }
    return -1;
  }
  
  int getCachedSpanIndex(int paramInt1, int paramInt2)
  {
    if (!this.mCacheSpanIndices) {
      return getSpanIndex(paramInt1, paramInt2);
    }
    int i = this.mSpanIndexCache.get(paramInt1, -1);
    if (i != -1) {
      return i;
    }
    paramInt2 = getSpanIndex(paramInt1, paramInt2);
    this.mSpanIndexCache.put(paramInt1, paramInt2);
    return paramInt2;
  }
  
  public int getSpanGroupIndex(int paramInt1, int paramInt2)
  {
    int i2 = getSpanSize(paramInt1);
    int m = 0;
    int i = 0;
    int k;
    for (int j = 0; m < paramInt1; j = k)
    {
      int n = getSpanSize(m);
      int i1 = i + n;
      if (i1 == paramInt2)
      {
        k = j + 1;
        i = 0;
      }
      else
      {
        i = i1;
        k = j;
        if (i1 > paramInt2)
        {
          k = j + 1;
          i = n;
        }
      }
      m += 1;
    }
    paramInt1 = j;
    if (i + i2 > paramInt2) {
      paramInt1 = j + 1;
    }
    return paramInt1;
  }
  
  public int getSpanIndex(int paramInt1, int paramInt2)
  {
    int i1 = getSpanSize(paramInt1);
    if (i1 == paramInt2) {
      return 0;
    }
    int k;
    if ((this.mCacheSpanIndices) && (this.mSpanIndexCache.size() > 0))
    {
      k = findReferenceIndexFromCache(paramInt1);
      if (k >= 0)
      {
        i = this.mSpanIndexCache.get(k) + getSpanSize(k);
        break label124;
      }
    }
    int j = 0;
    int i = 0;
    while (j < paramInt1)
    {
      int m = getSpanSize(j);
      int n = i + m;
      if (n == paramInt2)
      {
        i = 0;
        k = j;
      }
      else
      {
        k = j;
        i = n;
        if (n > paramInt2)
        {
          i = m;
          k = j;
        }
      }
      label124:
      j = k + 1;
    }
    if (i1 + i <= paramInt2) {
      return i;
    }
    return 0;
  }
  
  public abstract int getSpanSize(int paramInt);
  
  public void invalidateSpanIndexCache()
  {
    this.mSpanIndexCache.clear();
  }
  
  public boolean isSpanIndexCacheEnabled()
  {
    return this.mCacheSpanIndices;
  }
  
  public void setSpanIndexCacheEnabled(boolean paramBoolean)
  {
    this.mCacheSpanIndices = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager.SpanSizeLookup
 * JD-Core Version:    0.7.0.1
 */