package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class GridLayoutManager$LayoutParams
  extends RecyclerView.LayoutParams
{
  public static final int INVALID_SPAN_ID = -1;
  int mSpanIndex = -1;
  int mSpanSize = 0;
  
  public GridLayoutManager$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public GridLayoutManager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GridLayoutManager$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public GridLayoutManager$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public GridLayoutManager$LayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public int getSpanIndex()
  {
    return this.mSpanIndex;
  }
  
  public int getSpanSize()
  {
    return this.mSpanSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */