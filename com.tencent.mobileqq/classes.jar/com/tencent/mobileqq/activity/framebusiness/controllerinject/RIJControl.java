package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.kandian.biz.xtab.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class RIJControl
  implements BaseTabControl
{
  public boolean a(String paramString)
  {
    Class localClass = ((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getTabFrame();
    if (localClass == null) {
      return false;
    }
    return localClass.getName().equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.RIJControl
 * JD-Core Version:    0.7.0.1
 */