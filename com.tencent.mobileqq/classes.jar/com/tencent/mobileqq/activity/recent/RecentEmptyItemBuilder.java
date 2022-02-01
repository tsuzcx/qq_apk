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
  private int h = 0;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if (paramView != null)
    {
      paramRecentFaceDecoder = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2131624573))) {}
    }
    else
    {
      paramRecentFaceDecoder = View.inflate(paramContext, 2131624573, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131299610);
      this.a = paramContext.getResources().getDimensionPixelSize(2131299613);
      this.h = paramContext.getResources().getDimensionPixelSize(2131299617);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    int j = this.h;
    if (i <= j) {
      i = j;
    }
    paramView = new AbsListView.LayoutParams(-1, -1);
    paramView.width = -1;
    paramView.height = i;
    paramRecentFaceDecoder.setLayoutParams(paramView);
    paramRecentFaceDecoder.setTag(Boolean.valueOf(true));
    paramView = (TextView)paramRecentFaceDecoder.findViewById(2131439341);
    paramViewGroup = (Button)paramRecentFaceDecoder.findViewById(2131429786);
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      if (i == 1)
      {
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130842288, 0, 0);
        paramView.setVisibility(0);
        paramView.setText(2131892582);
        paramView.setTextColor(paramContext.getResources().getColorStateList(2131168125));
        paramViewGroup.setVisibility(8);
        paramViewGroup.setOnClickListener(null);
      }
      else if (i == 0)
      {
        if ((paramContext instanceof MsgBoxListActivity))
        {
          if (((MsgBoxListActivity)paramContext).isHideNoChatImg)
          {
            paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            paramView.setVisibility(0);
            paramView.setText("");
          }
        }
        else
        {
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130842288, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131892146);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131168125));
          paramViewGroup.setVisibility(8);
          paramViewGroup.setOnClickListener(null);
        }
      }
      else
      {
        paramView.setVisibility(4);
        paramView.setText("");
      }
    }
    else
    {
      paramView.setVisibility(8);
      paramView.setText("");
      paramViewGroup.setVisibility(8);
    }
    paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
    paramRecentFaceDecoder.setTag(2131624573, "R.layout.conversation_no_chat");
    return paramRecentFaceDecoder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */