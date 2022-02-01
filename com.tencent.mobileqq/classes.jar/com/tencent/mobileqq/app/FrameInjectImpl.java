package com.tencent.mobileqq.app;

import com.tencent.mobileqq.statistics.UEC;

public class FrameInjectImpl
  implements IFrameInjectInterface
{
  public void a(Frame paramFrame)
  {
    paramFrame = FrameHelperActivity.a((BaseActivity)paramFrame.P());
    if (paramFrame != null) {
      paramFrame.J();
    }
  }
  
  public void a(Frame paramFrame, boolean paramBoolean)
  {
    UEC localUEC = UEC.a;
    if (localUEC != null) {
      localUEC.a(paramFrame.getClass().getSimpleName(), paramFrame.P(), paramBoolean, paramFrame);
    }
  }
  
  public boolean a()
  {
    if (FrameHelperActivity.G())
    {
      FrameHelperActivity.H();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameInjectImpl
 * JD-Core Version:    0.7.0.1
 */