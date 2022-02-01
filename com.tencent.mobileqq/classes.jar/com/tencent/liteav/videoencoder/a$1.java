package com.tencent.liteav.videoencoder;

import android.os.Process;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.c;

class a$1
  implements Runnable
{
  a$1(a parama, c paramc) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setThreadPriority: priority:");
    localStringBuilder.append(this.a);
    TXCLog.i("TXCHWVideoEncoder", localStringBuilder.toString());
    Process.setThreadPriority(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a.1
 * JD-Core Version:    0.7.0.1
 */