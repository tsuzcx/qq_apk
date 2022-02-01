package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper
{
  private static final boolean DEBUG = false;
  private static final String TAG = "ChildrenHelper";
  final ChildHelper.Bucket mBucket;
  final ChildHelper.Callback mCallback;
  final List<View> mHiddenViews;
  
  ChildHelper(ChildHelper.Callback paramCallback)
  {
    this.mCallback = paramCallback;
    this.mBucket = new ChildHelper.Bucket();
    this.mHiddenViews = new ArrayList();
  }
  
  private int getOffset(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    int j = this.mCallback.getChildCount();
    int i = paramInt;
    while (i < j)
    {
      int k = paramInt - (i - this.mBucket.countOnesBefore(i));
      if (k == 0)
      {
        while (this.mBucket.get(i)) {
          i += 1;
        }
        return i;
      }
      i += k;
    }
    return -1;
  }
  
  private void hideViewInternal(View paramView)
  {
    this.mHiddenViews.add(paramView);
    this.mCallback.onEnteredHiddenState(paramView);
  }
  
  private boolean unhideViewInternal(View paramView)
  {
    if (this.mHiddenViews.remove(paramView))
    {
      this.mCallback.onLeftHiddenState(paramView);
      return true;
    }
    return false;
  }
  
  void addView(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {
      paramInt = this.mCallback.getChildCount();
    } else {
      paramInt = getOffset(paramInt);
    }
    this.mBucket.insert(paramInt, paramBoolean);
    if (paramBoolean) {
      hideViewInternal(paramView);
    }
    this.mCallback.addView(paramView, paramInt);
  }
  
  void addView(View paramView, boolean paramBoolean)
  {
    addView(paramView, -1, paramBoolean);
  }
  
  void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {
      paramInt = this.mCallback.getChildCount();
    } else {
      paramInt = getOffset(paramInt);
    }
    this.mBucket.insert(paramInt, paramBoolean);
    if (paramBoolean) {
      hideViewInternal(paramView);
    }
    this.mCallback.attachViewToParent(paramView, paramInt, paramLayoutParams);
  }
  
  void detachViewFromParent(int paramInt)
  {
    paramInt = getOffset(paramInt);
    this.mBucket.remove(paramInt);
    this.mCallback.detachViewFromParent(paramInt);
  }
  
  View findHiddenNonRemovedView(int paramInt)
  {
    int j = this.mHiddenViews.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.mHiddenViews.get(i);
      RecyclerView.ViewHolder localViewHolder = this.mCallback.getChildViewHolder(localView);
      if ((localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.isInvalid()) && (!localViewHolder.isRemoved())) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  View getChildAt(int paramInt)
  {
    paramInt = getOffset(paramInt);
    return this.mCallback.getChildAt(paramInt);
  }
  
  int getChildCount()
  {
    return this.mCallback.getChildCount() - this.mHiddenViews.size();
  }
  
  View getUnfilteredChildAt(int paramInt)
  {
    return this.mCallback.getChildAt(paramInt);
  }
  
  int getUnfilteredChildCount()
  {
    return this.mCallback.getChildCount();
  }
  
  void hide(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i >= 0)
    {
      this.mBucket.set(i);
      hideViewInternal(paramView);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("view is not a child, cannot hide ");
    localStringBuilder.append(paramView);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  int indexOfChild(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i == -1) {
      return -1;
    }
    if (this.mBucket.get(i)) {
      return -1;
    }
    return i - this.mBucket.countOnesBefore(i);
  }
  
  boolean isHidden(View paramView)
  {
    return this.mHiddenViews.contains(paramView);
  }
  
  void removeAllViewsUnfiltered()
  {
    this.mBucket.reset();
    int i = this.mHiddenViews.size() - 1;
    while (i >= 0)
    {
      this.mCallback.onLeftHiddenState((View)this.mHiddenViews.get(i));
      this.mHiddenViews.remove(i);
      i -= 1;
    }
    this.mCallback.removeAllViews();
  }
  
  void removeView(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i < 0) {
      return;
    }
    if (this.mBucket.remove(i)) {
      unhideViewInternal(paramView);
    }
    this.mCallback.removeViewAt(i);
  }
  
  void removeViewAt(int paramInt)
  {
    paramInt = getOffset(paramInt);
    View localView = this.mCallback.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.mBucket.remove(paramInt)) {
      unhideViewInternal(localView);
    }
    this.mCallback.removeViewAt(paramInt);
  }
  
  boolean removeViewIfHidden(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i == -1)
    {
      unhideViewInternal(paramView);
      return true;
    }
    if (this.mBucket.get(i))
    {
      this.mBucket.remove(i);
      unhideViewInternal(paramView);
      this.mCallback.removeViewAt(i);
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mBucket.toString());
    localStringBuilder.append(", hidden list:");
    localStringBuilder.append(this.mHiddenViews.size());
    return localStringBuilder.toString();
  }
  
  void unhide(View paramView)
  {
    int i = this.mCallback.indexOfChild(paramView);
    if (i >= 0)
    {
      if (this.mBucket.get(i))
      {
        this.mBucket.clear(i);
        unhideViewInternal(paramView);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("trying to unhide a view that was not hidden");
      localStringBuilder.append(paramView);
      throw new RuntimeException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("view is not a child, cannot hide ");
    localStringBuilder.append(paramView);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ChildHelper
 * JD-Core Version:    0.7.0.1
 */