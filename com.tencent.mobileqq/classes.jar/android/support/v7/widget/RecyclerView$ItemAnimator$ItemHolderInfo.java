package android.support.v7.widget;

import android.view.View;

public class RecyclerView$ItemAnimator$ItemHolderInfo
{
  public int bottom;
  public int changeFlags;
  public int left;
  public int right;
  public int top;
  
  public ItemHolderInfo setFrom(RecyclerView.ViewHolder paramViewHolder)
  {
    return setFrom(paramViewHolder, 0);
  }
  
  public ItemHolderInfo setFrom(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = paramViewHolder.itemView;
    this.left = paramViewHolder.getLeft();
    this.top = paramViewHolder.getTop();
    this.right = paramViewHolder.getRight();
    this.bottom = paramViewHolder.getBottom();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo
 * JD-Core Version:    0.7.0.1
 */