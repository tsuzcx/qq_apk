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
  private int h = 0;
  private int i = 0;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if (paramView == null) {
      paramRecentFaceDecoder = null;
    } else {
      paramRecentFaceDecoder = paramView.getTag();
    }
    if (!"TroopAssistantEmptyItemBuilder".equals(paramRecentFaceDecoder))
    {
      paramView = View.inflate(paramContext, 2131629554, null);
      paramView.setTag("TroopAssistantEmptyItemBuilder");
      paramRecentFaceDecoder = paramContext.getResources();
      this.b = paramRecentFaceDecoder.getDimensionPixelSize(2131299610);
      this.a = paramRecentFaceDecoder.getDimensionPixelSize(2131299615);
      this.h = paramRecentFaceDecoder.getDimensionPixelSize(2131299617);
      this.i = (paramRecentFaceDecoder.getDimensionPixelSize(2131299957) + paramRecentFaceDecoder.getDimensionPixelSize(2131299958));
    }
    int j = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.i;
    int k = this.h;
    if (j <= k) {
      j = k;
    }
    paramRecentFaceDecoder = new AbsListView.LayoutParams(-1, -1);
    paramRecentFaceDecoder.width = -1;
    paramRecentFaceDecoder.height = j;
    paramView.setLayoutParams(paramRecentFaceDecoder);
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      paramRecentFaceDecoder = (TextView)paramView.findViewById(2131447911);
      if (paramObject.intValue() == 4) {
        paramRecentFaceDecoder.setText(2131917396);
      } else {
        paramRecentFaceDecoder.setText(2131892582);
      }
    }
    paramView.setTag(-1, Integer.valueOf(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TroopAssistantEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */