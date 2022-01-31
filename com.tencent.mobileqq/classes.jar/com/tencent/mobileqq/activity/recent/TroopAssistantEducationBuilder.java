package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;

@Deprecated
public class TroopAssistantEducationBuilder
  extends RecentItemBaseBuilder
{
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2130971688, null);
    }
    paramRecentFaceDecoder = paramObject.findViewById(2131375335);
    paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
    paramRecentFaceDecoder.setOnClickListener(paramOnClickListener);
    paramRecentFaceDecoder = paramObject.findViewById(2131375345);
    paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
    paramRecentFaceDecoder.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TroopAssistantEducationBuilder
 * JD-Core Version:    0.7.0.1
 */