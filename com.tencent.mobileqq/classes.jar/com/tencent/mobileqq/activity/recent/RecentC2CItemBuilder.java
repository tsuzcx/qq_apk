package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.robotchat.RobotChatUtil;

public class RecentC2CItemBuilder
  extends RecentEfficientItemBuilder
{
  public RecentC2CItemBuilder()
  {
    this.jdField_a_of_type_Int = 2131562729;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)) {
      paramView = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.a != null))
    {
      if (paramRecentBaseData == null) {
        return;
      }
      RobotChatUtil.a(paramContext, paramView.a, paramRecentBaseData.getRecentUserUin());
    }
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    return super.a(paramInt, paramObject, paramRecentFaceDecoder, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramOnDragModeChangedListener);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentC2CItemBuilder
 * JD-Core Version:    0.7.0.1
 */