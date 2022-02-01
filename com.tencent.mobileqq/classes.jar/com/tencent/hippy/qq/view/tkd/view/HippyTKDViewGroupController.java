package com.tencent.hippy.qq.view.tkd.view;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;

@HippyController(name="View")
public class HippyTKDViewGroupController
  extends HippyViewGroupController
{
  private static final String PROP_NAME_DISABLE_EXTERNAL_SCROLL = "disableExternalScroll";
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyTKDViewGroup(paramContext);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="disableExternalScroll")
  public void disableExternalScroll(HippyViewGroup paramHippyViewGroup, int paramInt)
  {
    paramHippyViewGroup.post(new HippyTKDViewGroupController.1(this, paramHippyViewGroup, paramInt));
  }
  
  @HippyControllerProps(name="customProp")
  public void setCustomProp(HippyViewGroup paramHippyViewGroup, String paramString, Object paramObject)
  {
    if ((paramHippyViewGroup instanceof HippyTKDCommonBorderHandler.HippyQBCommonBorder)) {
      HippyTKDCommonBorderHandler.handleCommonBorderColor((HippyTKDCommonBorderHandler.HippyQBCommonBorder)paramHippyViewGroup, paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroupController
 * JD-Core Version:    0.7.0.1
 */