package com.tencent.biz.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.widget.ListView;

public class ListViewForListview
  extends ListView
{
  public ListViewForListview(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListViewForListview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ListViewForListview
 * JD-Core Version:    0.7.0.1
 */