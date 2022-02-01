package com.tencent.mobileqq.bubble;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class BubbleManager$1
  extends DownloadListener
{
  BubbleManager$1(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.b().getString("name");
    BubbleManager.a(this.a, str, "bubbleDownloadListener onCancel pkgName = ");
    this.a.a("Bubble_download_cancel", paramDownloadTask.g(), str, 0L);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    long l = paramDownloadTask.B - paramDownloadTask.A;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bubbleDownloadListener onDone downloadTime = ");
      localStringBuilder.append(l);
      QLog.i("BubbleManager", 2, localStringBuilder.toString());
    }
    this.a.a("Bubble_download_succ", paramDownloadTask.g(), "pkgName", l);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.b().getString("name");
    BubbleManager.a(this.a, str, "bubbleDownloadListener onStart pkgName = ");
    this.a.a("Bubble_download", paramDownloadTask.g(), str, 0L);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.1
 * JD-Core Version:    0.7.0.1
 */