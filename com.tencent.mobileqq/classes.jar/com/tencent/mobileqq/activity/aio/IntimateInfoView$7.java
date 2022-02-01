package com.tencent.mobileqq.activity.aio;

import com.tencent.image.URLDrawable;

class IntimateInfoView$7
  implements Runnable
{
  IntimateInfoView$7(IntimateInfoView paramIntimateInfoView) {}
  
  public void run()
  {
    if (IntimateInfoView.i(this.this$0).getStatus() == 0)
    {
      IntimateInfoView.i(this.this$0).downloadImediatly();
      return;
    }
    IntimateInfoView.i(this.this$0).restartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.7
 * JD-Core Version:    0.7.0.1
 */