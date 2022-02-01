package com.tencent.av.wtogether.gles;

import android.os.Build.VERSION;
import mzf;
import mzi;

public class WatchTogetherVideoRenderHelper$2
  implements Runnable
{
  public WatchTogetherVideoRenderHelper$2(mzi parammzi) {}
  
  public void run()
  {
    if ((mzi.a(this.this$0) != null) && (Build.VERSION.SDK_INT >= 16)) {}
    synchronized (mzi.a(this.this$0))
    {
      if (mzi.b(this.this$0))
      {
        mzi.a(this.this$0).c();
        mzi.a(this.this$0, false);
      }
      mzi.a(this.this$0).e();
      mzi.a(this.this$0, -1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.gles.WatchTogetherVideoRenderHelper.2
 * JD-Core Version:    0.7.0.1
 */