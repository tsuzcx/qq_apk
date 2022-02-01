package androidx.recyclerview.widget;

import java.util.Arrays;

class StaggeredGridLayoutManager$AnchorInfo
{
  boolean mInvalidateOffsets;
  boolean mLayoutFromEnd;
  int mOffset;
  int mPosition;
  int[] mSpanReferenceLines;
  boolean mValid;
  
  StaggeredGridLayoutManager$AnchorInfo(StaggeredGridLayoutManager paramStaggeredGridLayoutManager)
  {
    reset();
  }
  
  void assignCoordinateFromPadding()
  {
    int i;
    if (this.mLayoutFromEnd) {
      i = this.this$0.mPrimaryOrientation.getEndAfterPadding();
    } else {
      i = this.this$0.mPrimaryOrientation.getStartAfterPadding();
    }
    this.mOffset = i;
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
    this.mValid = false;
    int[] arrayOfInt = this.mSpanReferenceLines;
    if (arrayOfInt != null) {
      Arrays.fill(arrayOfInt, -1);
    }
  }
  
  void saveSpanReferenceLines(StaggeredGridLayoutManager.Span[] paramArrayOfSpan)
  {
    int j = paramArrayOfSpan.length;
    int[] arrayOfInt = this.mSpanReferenceLines;
    if ((arrayOfInt == null) || (arrayOfInt.length < j)) {
      this.mSpanReferenceLines = new int[this.this$0.mSpans.length];
    }
    int i = 0;
    while (i < j)
    {
      this.mSpanReferenceLines[i] = paramArrayOfSpan[i].getStartLine(-2147483648);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */