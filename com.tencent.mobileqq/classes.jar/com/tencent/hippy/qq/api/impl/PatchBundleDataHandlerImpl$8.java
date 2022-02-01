package com.tencent.hippy.qq.api.impl;

import android.util.SparseArray;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;

class PatchBundleDataHandlerImpl$8
  implements Runnable
{
  PatchBundleDataHandlerImpl$8(PatchBundleDataHandlerImpl paramPatchBundleDataHandlerImpl, HippyEngineContext paramHippyEngineContext, File paramFile, Promise paramPromise, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = (HashSet)PatchBundleDataHandlerImpl.access$500().get(this.val$context.hashCode());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashSet();
      PatchBundleDataHandlerImpl.access$500().put(this.val$context.hashCode(), localObject1);
    }
    if (((HashSet)localObject1).contains(this.val$file.getAbsolutePath()))
    {
      PatchBundleDataHandlerImpl.access$300(this.val$promise, 0, "loaded");
      return;
    }
    ((HashSet)localObject1).add(this.val$file.getAbsolutePath());
    localObject1 = new HippyFileBundleLoader(this.val$file.getAbsolutePath(), true, this.val$file.getName());
    localObject2 = this.val$context.getInstance(this.val$instanceId);
    PatchBundleDataHandlerImpl.8.1 local1 = new PatchBundleDataHandlerImpl.8.1(this);
    try
    {
      this.val$context.getBridgeManager().a(this.val$instanceId, (HippyBundleLoader)localObject1, local1, (HippyRootView)localObject2);
      return;
    }
    catch (Exception localException)
    {
      PatchBundleDataHandlerImpl.access$300(this.val$promise, -1, localException.getMessage());
      QLog.e("PatchBundleDataHandlerImpl", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.PatchBundleDataHandlerImpl.8
 * JD-Core Version:    0.7.0.1
 */