package com.tencent.av.compat;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import mqq.app.BaseActivity;

public class AVCallCompactJob
{
  private Runnable a = null;
  
  public void a(VideoAppInterface paramVideoAppInterface, VideoController paramVideoController)
  {
    if ((paramVideoAppInterface == null) || (paramVideoController == null)) {}
    do
    {
      return;
      paramVideoController = paramVideoController.a();
    } while ((this.a == null) || (paramVideoController == null));
    paramVideoController.a(this.a, paramVideoAppInterface);
    this.a = null;
  }
  
  public void a(BaseActivity paramBaseActivity, VideoAppInterface paramVideoAppInterface, VideoController paramVideoController)
  {
    if ((paramBaseActivity == null) || (paramVideoAppInterface == null) || (paramVideoController == null)) {}
    do
    {
      return;
      paramVideoController = paramVideoController.a();
    } while (paramVideoController == null);
    this.a = paramVideoController.a(paramBaseActivity, paramVideoAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.compat.AVCallCompactJob
 * JD-Core Version:    0.7.0.1
 */