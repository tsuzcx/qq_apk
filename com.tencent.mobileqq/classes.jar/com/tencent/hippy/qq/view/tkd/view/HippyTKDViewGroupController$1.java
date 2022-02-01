package com.tencent.hippy.qq.view.tkd.view;

import com.tencent.mtt.hippy.views.view.HippyViewGroup;

class HippyTKDViewGroupController$1
  implements Runnable
{
  HippyTKDViewGroupController$1(HippyTKDViewGroupController paramHippyTKDViewGroupController, HippyViewGroup paramHippyViewGroup, int paramInt) {}
  
  public void run()
  {
    if ((this.val$hippyViewGroup instanceof HippyTKDViewGroup)) {
      ((HippyTKDViewGroup)this.val$hippyViewGroup).setDisableExternalScroll(this.val$number);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroupController.1
 * JD-Core Version:    0.7.0.1
 */