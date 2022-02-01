package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

class RecyclerView$5
  implements ChildHelper.Callback
{
  RecyclerView$5(RecyclerView paramRecyclerView) {}
  
  public void addView(View paramView, int paramInt)
  {
    this.this$0.addView(paramView, paramInt);
    this.this$0.dispatchChildAttached(paramView);
  }
  
  public void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      if ((!localViewHolder.isTmpDetached()) && (!localViewHolder.shouldIgnore())) {
        throw new IllegalArgumentException("Called attach on a child which is not detached: " + localViewHolder + this.this$0.exceptionLabel());
      }
      localViewHolder.clearTmpDetachFlag();
    }
    RecyclerView.access$000(this.this$0, paramView, paramInt, paramLayoutParams);
  }
  
  public void detachViewFromParent(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if (localObject != null)
    {
      localObject = RecyclerView.getChildViewHolderInt((View)localObject);
      if (localObject != null)
      {
        if ((((RecyclerView.ViewHolder)localObject).isTmpDetached()) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore())) {
          throw new IllegalArgumentException("called detach on an already detached child " + localObject + this.this$0.exceptionLabel());
        }
        ((RecyclerView.ViewHolder)localObject).addFlags(256);
      }
    }
    RecyclerView.access$100(this.this$0, paramInt);
  }
  
  public View getChildAt(int paramInt)
  {
    return this.this$0.getChildAt(paramInt);
  }
  
  public int getChildCount()
  {
    return this.this$0.getChildCount();
  }
  
  public RecyclerView.ViewHolder getChildViewHolder(View paramView)
  {
    return RecyclerView.getChildViewHolderInt(paramView);
  }
  
  public int indexOfChild(View paramView)
  {
    return this.this$0.indexOfChild(paramView);
  }
  
  public void onEnteredHiddenState(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView != null) {
      paramView.onEnteredHiddenState(this.this$0);
    }
  }
  
  public void onLeftHiddenState(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView != null) {
      paramView.onLeftHiddenState(this.this$0);
    }
  }
  
  public void removeAllViews()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      this.this$0.dispatchChildDetached(localView);
      localView.clearAnimation();
      i += 1;
    }
    this.this$0.removeAllViews();
  }
  
  public void removeViewAt(int paramInt)
  {
    View localView = this.this$0.getChildAt(paramInt);
    if (localView != null)
    {
      this.this$0.dispatchChildDetached(localView);
      localView.clearAnimation();
    }
    this.this$0.removeViewAt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.5
 * JD-Core Version:    0.7.0.1
 */