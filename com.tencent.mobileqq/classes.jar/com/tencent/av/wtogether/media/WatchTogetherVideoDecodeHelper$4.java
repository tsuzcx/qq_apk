package com.tencent.av.wtogether.media;

import com.tencent.qphone.base.util.QLog;
import myi;
import mzm;

public class WatchTogetherVideoDecodeHelper$4
  implements Runnable
{
  public WatchTogetherVideoDecodeHelper$4(mzm parammzm, myi parammyi) {}
  
  public void run()
  {
    if (mzm.a(this.this$0) != null) {
      QLog.d("WatchTogetherVideoDecodeHelper", 1, "should release lastest videoSink");
    }
    mzm.a(this.this$0, this.a);
    mzm.b(this.this$0, true);
    mzm.a(this.this$0, true);
    this.a.a();
    mzm.a(this.this$0, "startVideoSinkListener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.4
 * JD-Core Version:    0.7.0.1
 */