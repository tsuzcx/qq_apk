package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.qroute.QRoute;

public class LebaControl
  implements BaseTabControl
{
  public boolean a(String paramString)
  {
    if (QzoneFrame.class.getName().equals(paramString)) {
      return true;
    }
    Class localClass = ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass();
    if (localClass == null) {
      return false;
    }
    return localClass.getName().equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.LebaControl
 * JD-Core Version:    0.7.0.1
 */