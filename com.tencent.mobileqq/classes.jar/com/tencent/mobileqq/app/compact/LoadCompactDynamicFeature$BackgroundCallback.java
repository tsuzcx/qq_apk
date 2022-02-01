package com.tencent.mobileqq.app.compact;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.qphone.base.util.QLog;

class LoadCompactDynamicFeature$BackgroundCallback
  implements IGuardInterface
{
  private LoadCompactDynamicFeature$BackgroundCallback(LoadCompactDynamicFeature paramLoadCompactDynamicFeature) {}
  
  public void G_() {}
  
  public void H_() {}
  
  public void a(long paramLong)
  {
    if ((paramLong == 5L) && (!this.a.a()))
    {
      QLog.i("plugin_tag", 1, "trigger start oat service！");
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      localBaseApplicationImpl.startService(new Intent(localBaseApplicationImpl, DFPluginOatService.class));
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature.BackgroundCallback
 * JD-Core Version:    0.7.0.1
 */