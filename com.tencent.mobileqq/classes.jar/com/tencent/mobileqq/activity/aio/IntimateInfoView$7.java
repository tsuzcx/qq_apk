package com.tencent.mobileqq.activity.aio;

import afsv;
import com.tencent.image.URLDrawable;

public class IntimateInfoView$7
  implements Runnable
{
  public IntimateInfoView$7(afsv paramafsv) {}
  
  public void run()
  {
    if (afsv.a(this.this$0).getStatus() == 0)
    {
      afsv.a(this.this$0).downloadImediatly();
      return;
    }
    afsv.a(this.this$0).restartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.7
 * JD-Core Version:    0.7.0.1
 */