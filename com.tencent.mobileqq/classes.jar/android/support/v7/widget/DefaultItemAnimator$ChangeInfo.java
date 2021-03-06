package android.support.v7.widget;

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
  
  private DefaultItemAnimator$ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramViewHolder1, paramViewHolder2);
    this.fromX = paramInt1;
    this.fromY = paramInt2;
    this.toX = paramInt3;
    this.toY = paramInt4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChangeInfo{oldHolder=");
    localStringBuilder.append(this.oldHolder);
    localStringBuilder.append(", newHolder=");
    localStringBuilder.append(this.newHolder);
    localStringBuilder.append(", fromX=");
    localStringBuilder.append(this.fromX);
    localStringBuilder.append(", fromY=");
    localStringBuilder.append(this.fromY);
    localStringBuilder.append(", toX=");
    localStringBuilder.append(this.toX);
    localStringBuilder.append(", toY=");
    localStringBuilder.append(this.toY);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.ChangeInfo
 * JD-Core Version:    0.7.0.1
 */