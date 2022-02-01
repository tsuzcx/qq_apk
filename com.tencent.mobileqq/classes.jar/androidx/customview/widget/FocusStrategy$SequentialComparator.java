package androidx.customview.widget;

import android.graphics.Rect;
import java.util.Comparator;

class FocusStrategy$SequentialComparator<T>
  implements Comparator<T>
{
  private final FocusStrategy.BoundsAdapter<T> mAdapter;
  private final boolean mIsLayoutRtl;
  private final Rect mTemp1 = new Rect();
  private final Rect mTemp2 = new Rect();
  
  FocusStrategy$SequentialComparator(boolean paramBoolean, FocusStrategy.BoundsAdapter<T> paramBoundsAdapter)
  {
    this.mIsLayoutRtl = paramBoolean;
    this.mAdapter = paramBoundsAdapter;
  }
  
  public int compare(T paramT1, T paramT2)
  {
    Rect localRect1 = this.mTemp1;
    Rect localRect2 = this.mTemp2;
    this.mAdapter.obtainBounds(paramT1, localRect1);
    this.mAdapter.obtainBounds(paramT2, localRect2);
    int j = localRect1.top;
    int k = localRect2.top;
    int i = -1;
    if (j < k) {
      return -1;
    }
    if (localRect1.top > localRect2.top) {
      return 1;
    }
    if (localRect1.left < localRect2.left)
    {
      if (this.mIsLayoutRtl) {
        i = 1;
      }
      return i;
    }
    if (localRect1.left > localRect2.left)
    {
      if (this.mIsLayoutRtl) {
        return -1;
      }
      return 1;
    }
    if (localRect1.bottom < localRect2.bottom) {
      return -1;
    }
    if (localRect1.bottom > localRect2.bottom) {
      return 1;
    }
    if (localRect1.right < localRect2.right)
    {
      if (this.mIsLayoutRtl) {
        i = 1;
      }
      return i;
    }
    if (localRect1.right > localRect2.right)
    {
      if (this.mIsLayoutRtl) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.customview.widget.FocusStrategy.SequentialComparator
 * JD-Core Version:    0.7.0.1
 */