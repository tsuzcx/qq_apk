package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class RecyclerView$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  final Rect mDecorInsets = new Rect();
  boolean mInsetsDirty = true;
  boolean mPendingInvalidate = false;
  RecyclerView.ViewHolder mViewHolder;
  
  public RecyclerView$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public RecyclerView$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerView$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public RecyclerView$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public RecyclerView$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public int getViewAdapterPosition()
  {
    return this.mViewHolder.getAdapterPosition();
  }
  
  public int getViewLayoutPosition()
  {
    return this.mViewHolder.getLayoutPosition();
  }
  
  @Deprecated
  public int getViewPosition()
  {
    return this.mViewHolder.getPosition();
  }
  
  public boolean isItemChanged()
  {
    return this.mViewHolder.isUpdated();
  }
  
  public boolean isItemRemoved()
  {
    return this.mViewHolder.isRemoved();
  }
  
  public boolean isViewInvalid()
  {
    return this.mViewHolder.isInvalid();
  }
  
  public boolean viewNeedsUpdate()
  {
    return this.mViewHolder.needsUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.LayoutParams
 * JD-Core Version:    0.7.0.1
 */