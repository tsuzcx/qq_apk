package com.tencent.mobileqq.activity.aio;

import agiq;
import com.tencent.image.URLDrawable;

public class IntimateInfoView$11
  implements Runnable
{
  public IntimateInfoView$11(agiq paramagiq) {}
  
  public void run()
  {
    if (agiq.a(this.this$0).getStatus() == 0)
    {
      agiq.a(this.this$0).downloadImediatly();
      return;
    }
    agiq.a(this.this$0).restartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.11
 * JD-Core Version:    0.7.0.1
 */