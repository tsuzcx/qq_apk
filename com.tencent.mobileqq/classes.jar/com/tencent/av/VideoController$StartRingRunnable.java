package com.tencent.av;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;

class VideoController$StartRingRunnable
  implements Runnable
{
  String a;
  long b = 0L;
  
  VideoController$StartRingRunnable(VideoController paramVideoController, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    if (this.this$0.k().W < 0)
    {
      VcSystemInfo.getCpuInfo();
      long l = VcSystemInfo.getMaxCpuFreq();
      int i = VcSystemInfo.getCpuArchitecture();
      int j = Build.VERSION.SDK_INT;
      if ((i < 4) || (l / 1000L < 800L) || (j < 9)) {
        this.this$0.k().W = 0;
      }
    }
    if ((this.this$0.k() != null) && (this.this$0.k().aq == 1L) && (!TextUtils.isEmpty(this.this$0.k().ar))) {
      this.this$0.e.a(new Object[] { Integer.valueOf(30), this.a, this.this$0.k().ar });
    } else {
      this.this$0.e.a(new Object[] { Integer.valueOf(30), this.a });
    }
    this.this$0.b(this.b);
    this.this$0.am = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.StartRingRunnable
 * JD-Core Version:    0.7.0.1
 */