package com.etrump.mixlayout;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;

final class ETDIYUtil$2
  extends DownloadListener
{
  ETDIYUtil$2(File paramFile, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.c == 0) {
      ETDIYUtil.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETDIYUtil.2
 * JD-Core Version:    0.7.0.1
 */