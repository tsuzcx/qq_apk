package android.support.v7.widget;

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
    while (i < j)
    {
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i)).mPosition >= paramInt) {
        break label82;
      }
      i += 1;
    }
    i = -1;
    label82:
    if (i != -1)
    {
      localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      this.mFullSpanItems.remove(i);
      return localFullSpanItem.mPosition;
    }
    return -1;
  }
  
  private void offsetFullSpansForAddition(int paramInt1, int paramInt2)
  {
    Object localObject = this.mFullSpanItems;
    if (localObject == null) {
      return;
    }
    int i = ((List)localObject).size() - 1;
    while (i >= 0)
    {
      localObject = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition >= paramInt1) {
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition += paramInt2;
      }
      i -= 1;
    }
  }
  
  private void offsetFullSpansForRemoval(int paramInt1, int paramInt2)
  {
    Object localObject = this.mFullSpanItems;
    if (localObject == null) {
      return;
    }
    int i = ((List)localObject).size() - 1;
    while (i >= 0)
    {
      localObject = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition >= paramInt1) {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition < paramInt1 + paramInt2) {
          this.mFullSpanItems.remove(i);
        } else {
          ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition -= paramInt2;
        }
      }
      i -= 1;
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
    int[] arrayOfInt = this.mData;
    if (arrayOfInt != null) {
      Arrays.fill(arrayOfInt, -1);
    }
    this.mFullSpanItems = null;
  }
  
  void ensureSize(int paramInt)
  {
    int[] arrayOfInt1 = this.mData;
    if (arrayOfInt1 == null)
    {
      this.mData = new int[Math.max(paramInt, 10) + 1];
      Arrays.fill(this.mData, -1);
      return;
    }
    if (paramInt >= arrayOfInt1.length)
    {
      this.mData = new int[sizeForPosition(paramInt)];
      System.arraycopy(arrayOfInt1, 0, this.mData, 0, arrayOfInt1.length);
      int[] arrayOfInt2 = this.mData;
      Arrays.fill(arrayOfInt2, arrayOfInt1.length, arrayOfInt2.length, -1);
    }
  }
  
  int forceInvalidateAfter(int paramInt)
  {
    List localList = this.mFullSpanItems;
    if (localList != null)
    {
      int i = localList.size() - 1;
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
    Object localObject = this.mFullSpanItems;
    if (localObject == null) {
      return null;
    }
    int j = ((List)localObject).size();
    int i = 0;
    while (i < j)
    {
      localObject = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition >= paramInt2) {
        return null;
      }
      if ((((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition >= paramInt1) && ((paramInt3 == 0) || (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mGapDir == paramInt3) || ((paramBoolean) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mHasUnwantedGapAfter)))) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem getFullSpanItem(int paramInt)
  {
    Object localObject = this.mFullSpanItems;
    if (localObject == null) {
      return null;
    }
    int i = ((List)localObject).size() - 1;
    while (i >= 0)
    {
      localObject = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.mFullSpanItems.get(i);
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition == paramInt) {
        return localObject;
      }
      i -= 1;
    }
    return null;
  }
  
  int getSpan(int paramInt)
  {
    int[] arrayOfInt = this.mData;
    if ((arrayOfInt != null) && (paramInt < arrayOfInt.length)) {
      return arrayOfInt[paramInt];
    }
    return -1;
  }
  
  int invalidateAfter(int paramInt)
  {
    int[] arrayOfInt = this.mData;
    if (arrayOfInt == null) {
      return -1;
    }
    if (paramInt >= arrayOfInt.length) {
      return -1;
    }
    int i = invalidateFullSpansAfter(paramInt);
    if (i == -1)
    {
      arrayOfInt = this.mData;
      Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
      return this.mData.length;
    }
    arrayOfInt = this.mData;
    i += 1;
    Arrays.fill(arrayOfInt, paramInt, i, -1);
    return i;
  }
  
  void offsetForAddition(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.mData;
    if (arrayOfInt != null)
    {
      if (paramInt1 >= arrayOfInt.length) {
        return;
      }
      int i = paramInt1 + paramInt2;
      ensureSize(i);
      arrayOfInt = this.mData;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, i, arrayOfInt.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, paramInt1, i, -1);
      offsetFullSpansForAddition(paramInt1, paramInt2);
    }
  }
  
  void offsetForRemoval(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.mData;
    if (arrayOfInt != null)
    {
      if (paramInt1 >= arrayOfInt.length) {
        return;
      }
      int i = paramInt1 + paramInt2;
      ensureSize(i);
      arrayOfInt = this.mData;
      System.arraycopy(arrayOfInt, i, arrayOfInt, paramInt1, arrayOfInt.length - paramInt1 - paramInt2);
      arrayOfInt = this.mData;
      Arrays.fill(arrayOfInt, arrayOfInt.length - paramInt2, arrayOfInt.length, -1);
      offsetFullSpansForRemoval(paramInt1, paramInt2);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup
 * JD-Core Version:    0.7.0.1
 */