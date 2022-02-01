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
    int j = paramSparseIntArray.size() - 1;
    int i = 0;
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
    if (!this.mCacheSpanGroupIndices) {
      return getSpanGroupIndex(paramInt1, paramInt2);
    }
    int i = this.mSpanGroupIndexCache.get(paramInt1, -1);
    if (i != -1) {
      return i;
    }
    paramInt2 = getSpanGroupIndex(paramInt1, paramInt2);
    this.mSpanGroupIndexCache.put(paramInt1, paramInt2);
    return paramInt2;
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
    int n;
    int i1;
    if (this.mCacheSpanGroupIndices)
    {
      i = findFirstKeyLessThan(this.mSpanGroupIndexCache, paramInt1);
      if (i != -1)
      {
        n = this.mSpanGroupIndexCache.get(i);
        m = i + 1;
        j = getCachedSpanIndex(i, paramInt2);
        i1 = getSpanSize(i) + j;
        i = i1;
        j = n;
        k = m;
        if (i1 != paramInt2) {
          break label94;
        }
        j = n + 1;
        i = 0;
        k = m;
        break label94;
      }
    }
    int i = 0;
    int j = 0;
    int k = 0;
    label94:
    int i2 = getSpanSize(paramInt1);
    int m = k;
    while (m < paramInt1)
    {
      n = getSpanSize(m);
      i1 = i + n;
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
      j = k;
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
    if (this.mCacheSpanIndices)
    {
      k = findFirstKeyLessThan(this.mSpanIndexCache, paramInt1);
      if (k >= 0)
      {
        i = this.mSpanIndexCache.get(k) + getSpanSize(k);
        break label117;
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
      label117:
      j = k + 1;
    }
    if (i1 + i <= paramInt2) {
      return i;
    }
    return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
 * JD-Core Version:    0.7.0.1
 */