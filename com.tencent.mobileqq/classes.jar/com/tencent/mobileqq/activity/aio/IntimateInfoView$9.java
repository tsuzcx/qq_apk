package com.tencent.mobileqq.activity.aio;

import acwl;
import com.tencent.image.URLDrawable;

public class IntimateInfoView$9
  implements Runnable
{
  public IntimateInfoView$9(acwl paramacwl) {}
  
  public void run()
  {
    if (acwl.a(this.this$0).getStatus() == 0)
    {
      acwl.a(this.this$0).downloadImediatly();
      return;
    }
    acwl.a(this.this$0).restartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.9
 * JD-Core Version:    0.7.0.1
 */