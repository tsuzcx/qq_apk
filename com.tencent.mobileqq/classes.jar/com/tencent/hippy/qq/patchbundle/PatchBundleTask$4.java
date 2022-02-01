package com.tencent.hippy.qq.patchbundle;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class PatchBundleTask$4
  extends DownloadListener
{
  PatchBundleTask$4(PatchBundleTask paramPatchBundleTask, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject;
    if ((3 == paramDownloadTask.e()) && (PatchBundleTask.access$700(this.this$0) != null))
    {
      localObject = (PatchBundleConfig.BundleConfigItem)PatchBundleTask.access$700(this.this$0).mSubConfigs.get(this.val$url);
      int i = 0;
      while ((localObject != null) && (i < ((PatchBundleConfig.BundleConfigItem)localObject).mPreLoadList.size()))
      {
        PatchBundleTask.access$100(this.this$0, (String)((PatchBundleConfig.BundleConfigItem)localObject).mPreLoadList.get(i));
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("task.getStatus():");
      ((StringBuilder)localObject).append(paramDownloadTask.e());
      ((StringBuilder)localObject).append(" url:");
      ((StringBuilder)localObject).append(this.val$url);
      QLog.i("PatchBundleTask", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleTask.4
 * JD-Core Version:    0.7.0.1
 */