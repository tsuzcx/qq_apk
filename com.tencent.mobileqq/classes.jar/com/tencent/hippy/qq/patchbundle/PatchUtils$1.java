package com.tencent.hippy.qq.patchbundle;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

final class PatchUtils$1
  extends DownloadListener
{
  PatchUtils$1(String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("task.getStatus():");
      localStringBuilder.append(paramDownloadTask.a());
      localStringBuilder.append(" url:");
      localStringBuilder.append(this.val$url);
      QLog.i("PatchUtils", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchUtils.1
 * JD-Core Version:    0.7.0.1
 */