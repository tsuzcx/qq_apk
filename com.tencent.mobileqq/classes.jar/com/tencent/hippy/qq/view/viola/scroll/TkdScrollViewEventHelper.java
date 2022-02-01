package com.tencent.hippy.qq.view.viola.scroll;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;

public class TkdScrollViewEventHelper
  extends HippyScrollViewEventHelper
{
  public static final String EVENT_TYPE_END_REACHED = "onEndReached";
  public static final String EVENT_TYPE_START_REACHED = "onStartReached";
  
  public static void emitScrollEndReachedEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, "onEndReached");
  }
  
  public static void emitScrollStartReachedEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, "onStartReached");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.viola.scroll.TkdScrollViewEventHelper
 * JD-Core Version:    0.7.0.1
 */