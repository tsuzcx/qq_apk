package com.tencent.mobileqq.activity.aio;

import aesk;
import com.tencent.image.URLDrawable;

public class IntimateInfoView$11
  implements Runnable
{
  public IntimateInfoView$11(aesk paramaesk) {}
  
  public void run()
  {
    if (aesk.a(this.this$0).getStatus() == 0)
    {
      aesk.a(this.this$0).downloadImediatly();
      return;
    }
    aesk.a(this.this$0).restartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.11
 * JD-Core Version:    0.7.0.1
 */