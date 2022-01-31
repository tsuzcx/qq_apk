package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$SpanSizeLookup
{
  private boolean mCacheSpanIndices = false;
  final SparseIntArray mSpanIndexCache = new SparseIntArray();
  
  int findReferenceIndexFromCache(int paramInt)
  {
    int i = 0;
    int j = this.mSpanIndexCache.size() - 1;
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
    int n = getSpanSize(paramInt1);
    int k = 0;
    int i = 0;
    int j = 0;
    int m;
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
  }
  
  public int getSpanIndex(int paramInt1, int paramInt2)
  {
    int n = getSpanSize(paramInt1);
    if (n == paramInt2) {
      return 0;
    }
    int j;
    int i;
    if ((this.mCacheSpanIndices) && (this.mSpanIndexCache.size() > 0))
    {
      j = findReferenceIndexFromCache(paramInt1);
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