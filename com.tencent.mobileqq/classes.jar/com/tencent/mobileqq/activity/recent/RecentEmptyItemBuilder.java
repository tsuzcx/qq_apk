package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.widget.AbsListView.LayoutParams;

public class RecentEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private int a;
  private int b;
  private int c;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if (paramView != null)
    {
      paramRecentFaceDecoder = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2130968832))) {}
    }
    else
    {
      paramRecentFaceDecoder = View.inflate(paramContext, 2130968832, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131558588);
      this.a = paramContext.getResources().getDimensionPixelSize(2131558584);
      this.c = paramContext.getResources().getDimensionPixelSize(2131558590);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.c)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramRecentFaceDecoder.setLayoutParams(paramView);
      paramRecentFaceDecoder.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramRecentFaceDecoder.findViewById(2131364005);
      paramViewGroup = (Button)paramRecentFaceDecoder.findViewById(2131364006);
      if (!(paramObject instanceof Integer)) {
        break label382;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label263;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130839540, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131436148);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131494275));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    for (;;)
    {
      paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
      paramRecentFaceDecoder.setTag(2130968832, "R.layout.conversation_no_chat");
      return paramRecentFaceDecoder;
      i = this.c;
      break;
      label263:
      if (i == 0)
      {
        if ((paramContext instanceof MsgBoxListActivity))
        {
          if (((MsgBoxListActivity)paramContext).d)
          {
            paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            paramView.setVisibility(0);
            paramView.setText("");
          }
        }
        else
        {
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130839540, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131434696);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131494275));
          paramViewGroup.setVisibility(8);
          paramViewGroup.setOnClickListener(null);
        }
      }
      else
      {
        paramView.setVisibility(4);
        paramView.setText("");
        continue;
        label382:
        paramView.setVisibility(8);
        paramView.setText("");
        paramViewGroup.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */