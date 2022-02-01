package com.tencent.mobileqq.activity.aio;

import afyw;
import com.tencent.image.URLDrawable;

public class IntimateInfoView$11
  implements Runnable
{
  public IntimateInfoView$11(afyw paramafyw) {}
  
  public void run()
  {
    if (afyw.a(this.this$0).getStatus() == 0)
    {
      afyw.a(this.this$0).downloadImediatly();
      return;
    }
    afyw.a(this.this$0).restartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.11
 * JD-Core Version:    0.7.0.1
 */