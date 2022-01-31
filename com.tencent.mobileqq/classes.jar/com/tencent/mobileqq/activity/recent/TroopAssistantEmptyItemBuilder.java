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
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    int i;
    if (paramView == null)
    {
      paramRecentFaceDecoder = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramRecentFaceDecoder))
      {
        paramView = View.inflate(paramContext, 2130971657, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramRecentFaceDecoder = paramContext.getResources();
        this.b = paramRecentFaceDecoder.getDimensionPixelSize(2131558588);
        this.a = paramRecentFaceDecoder.getDimensionPixelSize(2131558589);
        this.c = paramRecentFaceDecoder.getDimensionPixelSize(2131558590);
        i = paramRecentFaceDecoder.getDimensionPixelSize(2131558747);
        this.d = (paramRecentFaceDecoder.getDimensionPixelSize(2131558748) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramRecentFaceDecoder = new AbsListView.LayoutParams(-1, -1);
      paramRecentFaceDecoder.width = -1;
      paramRecentFaceDecoder.height = i;
      paramView.setLayoutParams(paramRecentFaceDecoder);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramRecentFaceDecoder = (TextView)paramView.findViewById(2131375279);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramRecentFaceDecoder.setText(2131435701);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramRecentFaceDecoder = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramRecentFaceDecoder.setText(2131436130);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TroopAssistantEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */