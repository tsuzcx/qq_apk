package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AsyncListUtil<T>
{
  static final boolean DEBUG = false;
  static final String TAG = "AsyncListUtil";
  boolean mAllowScrollHints;
  private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback = new AsyncListUtil.2(this);
  final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
  final AsyncListUtil.DataCallback<T> mDataCallback;
  int mDisplayedGeneration = 0;
  int mItemCount = 0;
  private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback = new AsyncListUtil.1(this);
  final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
  final SparseIntArray mMissingPositions = new SparseIntArray();
  final int[] mPrevRange = new int[2];
  int mRequestedGeneration = this.mDisplayedGeneration;
  private int mScrollHint = 0;
  final Class<T> mTClass;
  final TileList<T> mTileList;
  final int mTileSize;
  final int[] mTmpRange = new int[2];
  final int[] mTmpRangeExtended = new int[2];
  final AsyncListUtil.ViewCallback mViewCallback;
  
  public AsyncListUtil(@NonNull Class<T> paramClass, int paramInt, @NonNull AsyncListUtil.DataCallback<T> paramDataCallback, @NonNull AsyncListUtil.ViewCallback paramViewCallback)
  {
    this.mTClass = paramClass;
    this.mTileSize = paramInt;
    this.mDataCallback = paramDataCallback;
    this.mViewCallback = paramViewCallback;
    this.mTileList = new TileList(this.mTileSize);
    paramClass = new MessageThreadUtil();
    this.mMainThreadProxy = paramClass.getMainThreadProxy(this.mMainThreadCallback);
    this.mBackgroundProxy = paramClass.getBackgroundProxy(this.mBackgroundCallback);
    refresh();
  }
  
  private boolean isRefreshPending()
  {
    return this.mRequestedGeneration != this.mDisplayedGeneration;
  }
  
  @Nullable
  public T getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mItemCount))
    {
      localObject = this.mTileList.getItemAt(paramInt);
      if ((localObject == null) && (!isRefreshPending())) {
        this.mMissingPositions.put(paramInt, 0);
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" is not within 0 and ");
    ((StringBuilder)localObject).append(this.mItemCount);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public int getItemCount()
  {
    return this.mItemCount;
  }
  
  void log(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MAIN] ");
    localStringBuilder.append(String.format(paramString, paramVarArgs));
    Log.d("AsyncListUtil", localStringBuilder.toString());
  }
  
  public void onRangeChanged()
  {
    if (isRefreshPending()) {
      return;
    }
    updateRange();
    this.mAllowScrollHints = true;
  }
  
  public void refresh()
  {
    this.mMissingPositions.clear();
    ThreadUtil.BackgroundCallback localBackgroundCallback = this.mBackgroundProxy;
    int i = this.mRequestedGeneration + 1;
    this.mRequestedGeneration = i;
    localBackgroundCallback.refresh(i);
  }
  
  void updateRange()
  {
    this.mViewCallback.getItemRangeInto(this.mTmpRange);
    Object localObject = this.mTmpRange;
    if (localObject[0] <= localObject[1])
    {
      if (localObject[0] < 0) {
        return;
      }
      if (localObject[1] >= this.mItemCount) {
        return;
      }
      if (!this.mAllowScrollHints)
      {
        this.mScrollHint = 0;
      }
      else
      {
        i = localObject[0];
        arrayOfInt = this.mPrevRange;
        if ((i <= arrayOfInt[1]) && (arrayOfInt[0] <= localObject[1]))
        {
          if (localObject[0] < arrayOfInt[0]) {
            this.mScrollHint = 1;
          } else if (localObject[0] > arrayOfInt[0]) {
            this.mScrollHint = 2;
          }
        }
        else {
          this.mScrollHint = 0;
        }
      }
      localObject = this.mPrevRange;
      int[] arrayOfInt = this.mTmpRange;
      localObject[0] = arrayOfInt[0];
      localObject[1] = arrayOfInt[1];
      this.mViewCallback.extendRangeInto(arrayOfInt, this.mTmpRangeExtended, this.mScrollHint);
      localObject = this.mTmpRangeExtended;
      localObject[0] = Math.min(this.mTmpRange[0], Math.max(localObject[0], 0));
      localObject = this.mTmpRangeExtended;
      localObject[1] = Math.max(this.mTmpRange[1], Math.min(localObject[1], this.mItemCount - 1));
      localObject = this.mBackgroundProxy;
      arrayOfInt = this.mTmpRange;
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      arrayOfInt = this.mTmpRangeExtended;
      ((ThreadUtil.BackgroundCallback)localObject).updateRange(i, j, arrayOfInt[0], arrayOfInt[1], this.mScrollHint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListUtil
 * JD-Core Version:    0.7.0.1
 */