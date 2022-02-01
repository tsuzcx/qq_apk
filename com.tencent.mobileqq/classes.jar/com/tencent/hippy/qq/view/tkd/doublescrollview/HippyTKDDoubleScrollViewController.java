package com.tencent.hippy.qq.view.tkd.doublescrollview;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;
import com.tencent.mtt.hippy.utils.PixelUtil;

@HippyController(name="TKDDoubleScrollView")
public class HippyTKDDoubleScrollViewController
  extends HippyGroupController<HippyTKDDoubleScrollView>
{
  public static final String CLASS_NAME = "TKDDoubleScrollView";
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyTKDDoubleScrollView(paramContext);
  }
  
  public void dispatchFunction(HippyTKDDoubleScrollView paramHippyTKDDoubleScrollView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyTKDDoubleScrollView, paramString, paramHippyArray);
    if (("scrollTo".equals(paramString)) && (paramHippyArray != null))
    {
      int i = Math.round(PixelUtil.dp2px(paramHippyArray.getDouble(0)));
      int j = Math.round(PixelUtil.dp2px(paramHippyArray.getDouble(1)));
      paramHippyArray.getBoolean(2);
      paramHippyTKDDoubleScrollView.scrollTo(i, j);
      paramHippyTKDDoubleScrollView.setHidden(false);
    }
  }
  
  @HippyControllerProps(name="enableDoubleScroll")
  public void enableDoubleScroll(HippyTKDDoubleScrollView paramHippyTKDDoubleScrollView, boolean paramBoolean)
  {
    paramHippyTKDDoubleScrollView.setEnableDoubleScroll(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.doublescrollview.HippyTKDDoubleScrollViewController
 * JD-Core Version:    0.7.0.1
 */