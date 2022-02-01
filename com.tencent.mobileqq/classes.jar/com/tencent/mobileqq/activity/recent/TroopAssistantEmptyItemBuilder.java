package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.widget.AbsListView.LayoutParams;

public class TroopAssistantEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if (paramView == null) {
      paramRecentFaceDecoder = null;
    } else {
      paramRecentFaceDecoder = paramView.getTag();
    }
    if (!"TroopAssistantEmptyItemBuilder".equals(paramRecentFaceDecoder))
    {
      paramView = View.inflate(paramContext, 2131562946, null);
      paramView.setTag("TroopAssistantEmptyItemBuilder");
      paramRecentFaceDecoder = paramContext.getResources();
      this.b = paramRecentFaceDecoder.getDimensionPixelSize(2131298888);
      this.a = paramRecentFaceDecoder.getDimensionPixelSize(2131298893);
      this.c = paramRecentFaceDecoder.getDimensionPixelSize(2131298895);
      this.d = (paramRecentFaceDecoder.getDimensionPixelSize(2131299204) + paramRecentFaceDecoder.getDimensionPixelSize(2131299205));
    }
    int i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
    int j = this.c;
    if (i <= j) {
      i = j;
    }
    paramRecentFaceDecoder = new AbsListView.LayoutParams(-1, -1);
    paramRecentFaceDecoder.width = -1;
    paramRecentFaceDecoder.height = i;
    paramView.setLayoutParams(paramRecentFaceDecoder);
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      paramRecentFaceDecoder = (TextView)paramView.findViewById(2131379175);
      if (paramObject.intValue() == 4) {
        paramRecentFaceDecoder.setText(2131719792);
      } else {
        paramRecentFaceDecoder.setText(2131694879);
      }
    }
    paramView.setTag(-1, Integer.valueOf(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TroopAssistantEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */