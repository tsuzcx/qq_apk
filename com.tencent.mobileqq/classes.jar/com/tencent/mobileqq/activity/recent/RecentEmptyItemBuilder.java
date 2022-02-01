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
  private int a = 0;
  private int b = 0;
  private int c = 0;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if (paramView != null)
    {
      paramRecentFaceDecoder = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2131559048))) {}
    }
    else
    {
      paramRecentFaceDecoder = View.inflate(paramContext, 2131559048, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131298884);
      this.a = paramContext.getResources().getDimensionPixelSize(2131298887);
      this.c = paramContext.getResources().getDimensionPixelSize(2131298891);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.c)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramRecentFaceDecoder.setLayoutParams(paramView);
      paramRecentFaceDecoder.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramRecentFaceDecoder.findViewById(2131372312);
      paramViewGroup = (Button)paramRecentFaceDecoder.findViewById(2131363912);
      if (!(paramObject instanceof Integer)) {
        break label382;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label263;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841563, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131694890);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131167119));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    for (;;)
    {
      paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
      paramRecentFaceDecoder.setTag(2131559048, "R.layout.conversation_no_chat");
      return paramRecentFaceDecoder;
      i = this.c;
      break;
      label263:
      if (i == 0)
      {
        if ((paramContext instanceof MsgBoxListActivity))
        {
          if (((MsgBoxListActivity)paramContext).f)
          {
            paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            paramView.setVisibility(0);
            paramView.setText("");
          }
        }
        else
        {
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841563, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131694500);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131167119));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */