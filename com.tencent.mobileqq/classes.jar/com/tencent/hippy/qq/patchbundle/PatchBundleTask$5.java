package com.tencent.hippy.qq.patchbundle;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;

class PatchBundleTask$5
  extends DownloadListener
{
  PatchBundleTask$5(PatchBundleTask paramPatchBundleTask, File paramFile, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.e())
    {
      if (this.val$file.exists()) {
        synchronized (PatchBundleTask.access$800(this.this$0))
        {
          PatchBundleTask.access$800(this.this$0).add(new PatchBundleTask.LoadTaskItem(this.val$url));
          PatchBundleTask.access$200(this.this$0);
        }
      }
      if (PatchBundleTask.access$700(this.this$0) != null)
      {
        ??? = (PatchBundleConfig.BundleConfigItem)PatchBundleTask.access$700(this.this$0).mSubConfigs.get(this.val$url);
        int i = 0;
        while ((??? != null) && (i < ((PatchBundleConfig.BundleConfigItem)???).mPreLoadList.size()))
        {
          PatchBundleTask.access$000(this.this$0, (String)((PatchBundleConfig.BundleConfigItem)???).mPreLoadList.get(i));
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("task.getStatus():");
      ((StringBuilder)???).append(paramDownloadTask.e());
      ((StringBuilder)???).append(" url:");
      ((StringBuilder)???).append(this.val$url);
      QLog.i("PatchBundleTask", 1, ((StringBuilder)???).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleTask.5
 * JD-Core Version:    0.7.0.1
 */