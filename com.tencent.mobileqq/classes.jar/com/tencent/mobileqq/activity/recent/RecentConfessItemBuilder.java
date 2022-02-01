package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.widget.SingleLineTextView;

public class RecentConfessItemBuilder
  extends RecentEfficientItemBuilder
{
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if (paramView != null) {
      boolean bool = paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder;
    }
    paramObject = super.a(paramInt, paramObject, paramRecentFaceDecoder, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramOnDragModeChangedListener);
    paramRecentFaceDecoder = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramObject.getTag();
    paramViewGroup = paramContext.getResources();
    paramView = paramViewGroup.getColorStateList(2131167138);
    paramViewGroup = paramViewGroup.getColorStateList(2131167056);
    paramRecentFaceDecoder.a.setTextColor(paramViewGroup);
    paramRecentFaceDecoder.b.setTextColor(paramView);
    paramRecentFaceDecoder.a.setExtendTextColor(paramView, 0);
    paramObject.findViewById(2131376384).setBackgroundResource(2130839390);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentConfessItemBuilder
 * JD-Core Version:    0.7.0.1
 */