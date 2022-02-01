package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class HotChatCenterDividerItemBuilder
  extends RecentDefaultItemBuilder
{
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramObject = new View(paramContext);
    paramObject.setBackgroundColor(Color.parseColor("#f2f2f2"));
    paramObject.setMinimumHeight(DisplayUtil.a(paramContext, 20.0F));
    paramObject.setMinimumWidth((int)DeviceInfoUtil.g());
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.HotChatCenterDividerItemBuilder
 * JD-Core Version:    0.7.0.1
 */