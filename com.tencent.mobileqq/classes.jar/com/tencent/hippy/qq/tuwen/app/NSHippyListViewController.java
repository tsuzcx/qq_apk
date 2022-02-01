package com.tencent.hippy.qq.tuwen.app;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.tuwen.view.NSHippyListView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewController;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;

@HippyController(name="ListView")
public class NSHippyListViewController
  extends HippyTKDListViewController
{
  public View createViewImpl(Context paramContext)
  {
    return new NSHippyListView(paramContext);
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    return new NSHippyListView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.app.NSHippyListViewController
 * JD-Core Version:    0.7.0.1
 */