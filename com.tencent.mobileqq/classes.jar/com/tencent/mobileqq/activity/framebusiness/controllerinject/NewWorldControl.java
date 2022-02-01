package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.activity.qcircle.QCircleFrame;

public class NewWorldControl
  implements BaseTabControl
{
  public boolean a(String paramString)
  {
    return QCircleFrame.class.getName().equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.NewWorldControl
 * JD-Core Version:    0.7.0.1
 */