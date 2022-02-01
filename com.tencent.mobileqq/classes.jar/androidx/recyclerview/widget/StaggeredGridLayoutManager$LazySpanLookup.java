package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StaggeredGridLayoutManager$LazySpanLookup
{
  private static final int MIN_SIZE = 10;
  int[] mData;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
  
  private int invalidateFullSpansAfter(int paramInt)
  {
    if (this.mFullSpanItems == null) {
      return -1;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = getFullSpanItem(paramInt);
    if (localFullSpanItem != null) {
      this.mFullSpanItems.remove(localFullSpanItem);
    }
    int j = this.mFullSpanItems.size();
    int i = 0;
    if (i < j) {
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i)).mPosition < paramInt) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
        this.mFullSpanItems.remove(i);
        return localFullSpanItem.mPosition;
        i += 1;
        break;
      }
      return -1;
      i = -1;
    }
  }
  
  private void offsetFullSpansForAddition(int paramInt1, int paramInt2)
  {
    if (this.mFullSpanItems == null) {
      return;
    }
    int i = this.mFullSpanItems.size() - 1;
    label20:
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    if (i >= 0)
    {
      localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      if (localFullSpanItem.mPosition >= paramInt1) {
        break label55;
      }
    }
    for (;;)
    {
      i -= 1;
      break label20;
      break;
      label55:
      localFullSpanItem.mPosition += paramInt2;
    }
  }
  
  private void offsetFullSpansForRemoval(int paramInt1, int paramInt2)
  {
    if (this.mFullSpanItems == null) {
      return;
    }
    int i = this.mFullSpanItems.size() - 1;
    label20:
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    if (i >= 0)
    {
      localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      if (localFullSpanItem.mPosition >= paramInt1) {
        break label55;
      }
    }
    for (;;)
    {
      i -= 1;
      break label20;
      break;
      label55:
      if (localFullSpanItem.mPosition < paramInt1 + paramInt2) {
        this.mFullSpanItems.remove(i);
      } else {
        localFullSpanItem.mPosition -= paramInt2;
      }
    }
  }
  
  public void addFullSpanItem(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem paramFullSpanItem)
  {
    if (this.mFullSpanItems == null) {
      this.mFullSpanItems = new ArrayList();
    }
    int j = this.mFullSpanItems.size();
    int i = 0;
    while (i < j)
    {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
        this.mFullSpanItems.remove(i);
      }
      if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
      {
        this.mFullSpanItems.add(i, paramFullSpanItem);
        return;
      }
      i += 1;
    }
    this.mFullSpanItems.add(paramFullSpanItem);
  }
  
  void clear()
  {
    if (this.mData != null) {
      Arrays.fill(this.mData, -1);
    }
    this.mFullSpanItems = null;
  }
  
  void ensureSize(int paramInt)
  {
    if (this.mData == null)
    {
      this.mData = new int[Math.max(paramInt, 10) + 1];
      Arrays.fill(this.mData, -1);
    }
    while (paramInt < this.mData.length) {
      return;
    }
    int[] arrayOfInt = this.mData;
    this.mData = new int[sizeForPosition(paramInt)];
    System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
    Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
  }
  
  int forceInvalidateAfter(int paramInt)
  {
    if (this.mFullSpanItems != null)
    {
      int i = this.mFullSpanItems.size() - 1;
      while (i >= 0)
      {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i)).mPosition >= paramInt) {
          this.mFullSpanItems.remove(i);
        }
        i -= 1;
      }
    }
    return invalidateAfter(paramInt);
  }
  
  public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem getFirstFullSpanItemInRange(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject;
    if (this.mFullSpanItems == null)
    {
      localObject = null;
      return localObject;
    }
    int j = this.mFullSpanItems.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label117;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      if (localFullSpanItem.mPosition >= paramInt2) {
        return null;
      }
      if (localFullSpanItem.mPosition >= paramInt1)
      {
        localObject = localFullSpanItem;
        if (paramInt3 == 0) {
          break;
        }
        localObject = localFullSpanItem;
        if (localFullSpanItem.mGapDir == paramInt3) {
          break;
        }
        if (paramBoolean)
        {
          localObject = localFullSpanItem;
          if (localFullSpanItem.mHasUnwantedGapAfter) {
            break;
          }
        }
      }
      i += 1;
    }
    label117:
    return null;
  }
  
  public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem getFullSpanItem(int paramInt)
  {
    Object localObject;
    if (this.mFullSpanItems == null)
    {
      localObject = null;
      return localObject;
    }
    int i = this.mFullSpanItems.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label61;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      localObject = localFullSpanItem;
      if (localFullSpanItem.mPosition == paramInt) {
        break;
      }
      i -= 1;
    }
    label61:
    return null;
  }
  
  int getSpan(int paramInt)
  {
    if ((this.mData == null) || (paramInt >= this.mData.length)) {
      return -1;
    }
    return this.mData[paramInt];
  }
  
  int invalidateAfter(int paramInt)
  {
    if (this.mData == null) {}
    while (paramInt >= this.mData.length) {
      return -1;
    }
    int i = invalidateFullSpansAfter(paramInt);
    if (i == -1)
    {
      Arrays.fill(this.mData, paramInt, this.mData.length, -1);
      return this.mData.length;
    }
    Arrays.fill(this.mData, paramInt, i + 1, -1);
    return i + 1;
  }
  
  void offsetForAddition(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
      return;
    }
    ensureSize(paramInt1 + paramInt2);
    System.arraycopy(this.mData, paramInt1, this.mData, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
    Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
    offsetFullSpansForAddition(paramInt1, paramInt2);
  }
  
  void offsetForRemoval(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
      return;
    }
    ensureSize(paramInt1 + paramInt2);
    System.arraycopy(this.mData, paramInt1 + paramInt2, this.mData, paramInt1, this.mData.length - paramInt1 - paramInt2);
    Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
    offsetFullSpansForRemoval(paramInt1, paramInt2);
  }
  
  void setSpan(int paramInt, StaggeredGridLayoutManager.Span paramSpan)
  {
    ensureSize(paramInt);
    this.mData[paramInt] = paramSpan.mIndex;
  }
  
  int sizeForPosition(int paramInt)
  {
    int i = this.mData.length;
    while (i <= paramInt) {
      i *= 2;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup
 * JD-Core Version:    0.7.0.1
 */