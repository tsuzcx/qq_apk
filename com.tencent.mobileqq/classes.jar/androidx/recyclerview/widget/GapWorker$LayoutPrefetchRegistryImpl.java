package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import java.util.Arrays;

@SuppressLint({"VisibleForTests"})
class GapWorker$LayoutPrefetchRegistryImpl
  implements RecyclerView.LayoutManager.LayoutPrefetchRegistry
{
  int mCount;
  int[] mPrefetchArray;
  int mPrefetchDx;
  int mPrefetchDy;
  
  public void addPosition(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= 0)
      {
        int i = this.mCount * 2;
        int[] arrayOfInt = this.mPrefetchArray;
        if (arrayOfInt == null)
        {
          this.mPrefetchArray = new int[4];
          Arrays.fill(this.mPrefetchArray, -1);
        }
        else if (i >= arrayOfInt.length)
        {
          this.mPrefetchArray = new int[i * 2];
          System.arraycopy(arrayOfInt, 0, this.mPrefetchArray, 0, arrayOfInt.length);
        }
        arrayOfInt = this.mPrefetchArray;
        arrayOfInt[i] = paramInt1;
        arrayOfInt[(i + 1)] = paramInt2;
        this.mCount += 1;
        return;
      }
      throw new IllegalArgumentException("Pixel distance must be non-negative");
    }
    throw new IllegalArgumentException("Layout positions must be non-negative");
  }
  
  void clearPrefetchPositions()
  {
    int[] arrayOfInt = this.mPrefetchArray;
    if (arrayOfInt != null) {
      Arrays.fill(arrayOfInt, -1);
    }
    this.mCount = 0;
  }
  
  void collectPrefetchPositionsFromView(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    this.mCount = 0;
    Object localObject = this.mPrefetchArray;
    if (localObject != null) {
      Arrays.fill((int[])localObject, -1);
    }
    localObject = paramRecyclerView.mLayout;
    if ((paramRecyclerView.mAdapter != null) && (localObject != null) && (((RecyclerView.LayoutManager)localObject).isItemPrefetchEnabled()))
    {
      if (paramBoolean)
      {
        if (!paramRecyclerView.mAdapterHelper.hasPendingUpdates()) {
          ((RecyclerView.LayoutManager)localObject).collectInitialPrefetchPositions(paramRecyclerView.mAdapter.getItemCount(), this);
        }
      }
      else if (!paramRecyclerView.hasPendingAdapterUpdates()) {
        ((RecyclerView.LayoutManager)localObject).collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, paramRecyclerView.mState, this);
      }
      if (this.mCount > ((RecyclerView.LayoutManager)localObject).mPrefetchMaxCountObserved)
      {
        ((RecyclerView.LayoutManager)localObject).mPrefetchMaxCountObserved = this.mCount;
        ((RecyclerView.LayoutManager)localObject).mPrefetchMaxObservedInInitialPrefetch = paramBoolean;
        paramRecyclerView.mRecycler.updateViewCacheSize();
      }
    }
  }
  
  boolean lastPrefetchIncludedPosition(int paramInt)
  {
    if (this.mPrefetchArray != null)
    {
      int j = this.mCount;
      int i = 0;
      while (i < j * 2)
      {
        if (this.mPrefetchArray[i] == paramInt) {
          return true;
        }
        i += 2;
      }
    }
    return false;
  }
  
  void setPrefetchVector(int paramInt1, int paramInt2)
  {
    this.mPrefetchDx = paramInt1;
    this.mPrefetchDy = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.GapWorker.LayoutPrefetchRegistryImpl
 * JD-Core Version:    0.7.0.1
 */