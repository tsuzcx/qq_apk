package androidx.recyclerview.widget;

class DefaultItemAnimator$ChangeInfo
{
  public int fromX;
  public int fromY;
  public RecyclerView.ViewHolder newHolder;
  public RecyclerView.ViewHolder oldHolder;
  public int toX;
  public int toY;
  
  private DefaultItemAnimator$ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    this.oldHolder = paramViewHolder1;
    this.newHolder = paramViewHolder2;
  }
  
  DefaultItemAnimator$ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramViewHolder1, paramViewHolder2);
    this.fromX = paramInt1;
    this.fromY = paramInt2;
    this.toX = paramInt3;
    this.toY = paramInt4;
  }
  
  public String toString()
  {
    return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.DefaultItemAnimator.ChangeInfo
 * JD-Core Version:    0.7.0.1
 */