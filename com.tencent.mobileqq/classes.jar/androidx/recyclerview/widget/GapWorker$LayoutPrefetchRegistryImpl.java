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
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Layout positions must be non-negative");
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Pixel distance must be non-negative");
    }
    int i = this.mCount * 2;
    if (this.mPrefetchArray == null)
    {
      this.mPrefetchArray = new int[4];
      Arrays.fill(this.mPrefetchArray, -1);
    }
    for (;;)
    {
      this.mPrefetchArray[i] = paramInt1;
      this.mPrefetchArray[(i + 1)] = paramInt2;
      this.mCount += 1;
      return;
      if (i >= this.mPrefetchArray.length)
      {
        int[] arrayOfInt = this.mPrefetchArray;
        this.mPrefetchArray = new int[i * 2];
        System.arraycopy(arrayOfInt, 0, this.mPrefetchArray, 0, arrayOfInt.length);
      }
    }
  }
  
  void clearPrefetchPositions()
  {
    if (this.mPrefetchArray != null) {
      Arrays.fill(this.mPrefetchArray, -1);
    }
    this.mCount = 0;
  }
  
  void collectPrefetchPositionsFromView(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    this.mCount = 0;
    if (this.mPrefetchArray != null) {
      Arrays.fill(this.mPrefetchArray, -1);
    }
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.mLayout;
    if ((paramRecyclerView.mAdapter != null) && (localLayoutManager != null) && (localLayoutManager.isItemPrefetchEnabled()))
    {
      if (!paramBoolean) {
        break label101;
      }
      if (!paramRecyclerView.mAdapterHelper.hasPendingUpdates()) {
        localLayoutManager.collectInitialPrefetchPositions(paramRecyclerView.mAdapter.getItemCount(), this);
      }
    }
    for (;;)
    {
      if (this.mCount > localLayoutManager.mPrefetchMaxCountObserved)
      {
        localLayoutManager.mPrefetchMaxCountObserved = this.mCount;
        localLayoutManager.mPrefetchMaxObservedInInitialPrefetch = paramBoolean;
        paramRecyclerView.mRecycler.updateViewCacheSize();
      }
      return;
      label101:
      if (!paramRecyclerView.hasPendingAdapterUpdates()) {
        localLayoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, paramRecyclerView.mState, this);
      }
    }
  }
  
  boolean lastPrefetchIncludedPosition(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.mPrefetchArray != null)
    {
      j = this.mCount;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j * 2)
      {
        if (this.mPrefetchArray[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 2;
    }
  }
  
  void setPrefetchVector(int paramInt1, int paramInt2)
  {
    this.mPrefetchDx = paramInt1;
    this.mPrefetchDy = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.GapWorker.LayoutPrefetchRegistryImpl
 * JD-Core Version:    0.7.0.1
 */