package com.tencent.hippy.qq.api.impl;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PatchBundleDataHandlerImpl$7
  extends DownloadListener
{
  PatchBundleDataHandlerImpl$7(PatchBundleDataHandlerImpl paramPatchBundleDataHandlerImpl, File paramFile, HippyEngineContext paramHippyEngineContext, int paramInt, Promise paramPromise, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.e()) {
      if (this.val$file.exists()) {
        PatchBundleDataHandlerImpl.access$400(this.this$0, this.val$context, this.val$instanceId, this.val$file, this.val$promise);
      } else {
        PatchBundleDataHandlerImpl.access$300(this.val$promise, -1, "下載失敗");
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("task.getStatus():");
      localStringBuilder.append(paramDownloadTask.e());
      localStringBuilder.append(" url:");
      localStringBuilder.append(this.val$url);
      QLog.i("PatchBundleDataHandlerImpl", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.PatchBundleDataHandlerImpl.7
 * JD-Core Version:    0.7.0.1
 */