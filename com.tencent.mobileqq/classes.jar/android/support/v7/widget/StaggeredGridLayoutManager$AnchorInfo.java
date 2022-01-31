package android.support.v7.widget;

class StaggeredGridLayoutManager$AnchorInfo
{
  boolean mInvalidateOffsets;
  boolean mLayoutFromEnd;
  int mOffset;
  int mPosition;
  
  private StaggeredGridLayoutManager$AnchorInfo(StaggeredGridLayoutManager paramStaggeredGridLayoutManager) {}
  
  void assignCoordinateFromPadding()
  {
    if (this.mLayoutFromEnd) {}
    for (int i = this.this$0.mPrimaryOrientation.getEndAfterPadding();; i = this.this$0.mPrimaryOrientation.getStartAfterPadding())
    {
      this.mOffset = i;
      return;
    }
  }
  
  void assignCoordinateFromPadding(int paramInt)
  {
    if (this.mLayoutFromEnd)
    {
      this.mOffset = (this.this$0.mPrimaryOrientation.getEndAfterPadding() - paramInt);
      return;
    }
    this.mOffset = (this.this$0.mPrimaryOrientation.getStartAfterPadding() + paramInt);
  }
  
  void reset()
  {
    this.mPosition = -1;
    this.mOffset = -2147483648;
    this.mLayoutFromEnd = false;
    this.mInvalidateOffsets = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */