package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

class RecyclerView$5
  implements ChildHelper.Callback
{
  RecyclerView$5(RecyclerView paramRecyclerView) {}
  
  public void addView(View paramView, int paramInt)
  {
    this.this$0.addView(paramView, paramInt);
    RecyclerView.access$1100(this.this$0, paramView);
  }
  
  public void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      if ((!localViewHolder.isTmpDetached()) && (!localViewHolder.shouldIgnore()))
      {
        paramView = new StringBuilder();
        paramView.append("Called attach on a child which is not detached: ");
        paramView.append(localViewHolder);
        throw new IllegalArgumentException(paramView.toString());
      }
      localViewHolder.clearTmpDetachFlag();
    }
    RecyclerView.access$1300(this.this$0, paramView, paramInt, paramLayoutParams);
  }
  
  public void detachViewFromParent(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if (localObject != null)
    {
      localObject = RecyclerView.getChildViewHolderInt((View)localObject);
      if (localObject != null)
      {
        if ((((RecyclerView.ViewHolder)localObject).isTmpDetached()) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("called detach on an already detached child ");
          localStringBuilder.append(localObject);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        ((RecyclerView.ViewHolder)localObject).addFlags(256);
      }
    }
    RecyclerView.access$1400(this.this$0, paramInt);
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
      RecyclerView.ViewHolder.access$1500(paramView);
    }
  }
  
  public void onLeftHiddenState(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView != null) {
      RecyclerView.ViewHolder.access$1600(paramView);
    }
  }
  
  public void removeAllViews()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.access$1200(this.this$0, getChildAt(i));
      i += 1;
    }
    this.this$0.removeAllViews();
  }
  
  public void removeViewAt(int paramInt)
  {
    View localView = this.this$0.getChildAt(paramInt);
    if (localView != null) {
      RecyclerView.access$1200(this.this$0, localView);
    }
    this.this$0.removeViewAt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.5
 * JD-Core Version:    0.7.0.1
 */