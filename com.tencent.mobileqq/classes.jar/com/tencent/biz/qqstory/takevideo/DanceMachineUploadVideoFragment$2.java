package com.tencent.biz.qqstory.takevideo;

import android.os.SystemClock;
import bkfv;
import com.tencent.mobileqq.app.BaseActivity;

class DanceMachineUploadVideoFragment$2
  implements Runnable
{
  DanceMachineUploadVideoFragment$2(DanceMachineUploadVideoFragment paramDanceMachineUploadVideoFragment) {}
  
  public void run()
  {
    try
    {
      i = DanceMachineUploadVideoFragment.a(this.this$0, DanceMachineUploadVideoFragment.a(this.this$0));
      if (i != 0)
      {
        DanceMachineUploadVideoFragment.a(this.this$0, -1L);
        this.this$0.a.setResult(2);
        this.this$0.a.finish();
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = -1;
        }
        DanceMachineUploadVideoFragment.a(this.this$0, SystemClock.elapsedRealtime());
      } while (DanceMachineUploadVideoFragment.a() == null);
      DanceMachineUploadVideoFragment.a().sendEmptyMessage(-2);
      DanceMachineUploadVideoFragment.a().sendEmptyMessageDelayed(-1, 120000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment.2
 * JD-Core Version:    0.7.0.1
 */