package com.tencent.hippy.qq.patchbundle;

import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadStatus;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class PatchBundleTask$7
  implements HippyEngine.ModuleListener
{
  PatchBundleTask$7(PatchBundleTask paramPatchBundleTask, File paramFile, PatchBundleTask.LoadTaskItem paramLoadTaskItem, PatchBundleTask.OnLoadPatchBundleListener paramOnLoadPatchBundleListener) {}
  
  public boolean onJsException(HippyJsException paramHippyJsException)
  {
    QLog.e("PatchBundleTask", 1, "loadJsBundle onJsException", paramHippyJsException);
    return false;
  }
  
  public void onLoadCompleted(HippyEngine.ModuleLoadStatus paramModuleLoadStatus, String paramString, HippyRootView paramHippyRootView)
  {
    paramHippyRootView = new StringBuilder();
    paramHippyRootView.append("loadJsBundle i:");
    paramHippyRootView.append(paramModuleLoadStatus);
    paramHippyRootView.append(" s:");
    paramHippyRootView.append(paramString);
    paramHippyRootView.append(" file:");
    paramHippyRootView.append(this.val$file.getAbsolutePath());
    paramHippyRootView.append(" ");
    paramHippyRootView.append(this.val$loadTaskItem.mUrl);
    QLog.d("PatchBundleTask", 1, paramHippyRootView.toString());
    paramHippyRootView = (PatchBundleTask.OnLoadPatchBundleListener)PatchBundleTask.access$1100(this.this$0).get(this.val$loadTaskItem.mUrl);
    if (paramHippyRootView != null)
    {
      paramHippyRootView.onLoad(this.val$loadTaskItem.mUrl, paramModuleLoadStatus.value(), paramString);
      PatchBundleTask.access$1100(this.this$0).remove(this.val$loadTaskItem.mUrl);
    }
    if (paramModuleLoadStatus != HippyEngine.ModuleLoadStatus.STATUS_OK) {
      QLog.e("PatchBundleTask", 1, "loadPatch onInitialized error");
    }
    paramHippyRootView = this.val$listener;
    if (paramHippyRootView != null) {
      paramHippyRootView.onLoad(this.val$loadTaskItem.mUrl, paramModuleLoadStatus.value(), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleTask.7
 * JD-Core Version:    0.7.0.1
 */