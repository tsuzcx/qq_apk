package com.tencent.mobileqq.ark.core;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import java.lang.ref.WeakReference;

public class ArkPredownloader$Task
{
  String a;
  String b;
  BaseQQAppInterface c;
  WeakReference<IPreDownloadController> d;
  
  public void a(Runnable paramRunnable)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      paramRunnable.run();
      return;
    }
    localObject = (IPreDownloadController)((WeakReference)localObject).get();
    if (localObject == null)
    {
      paramRunnable.run();
      return;
    }
    paramRunnable = new RunnableTask(this.c, this.b, paramRunnable, 10000L);
    ((IPreDownloadController)localObject).requestPreDownload(10022, "prd", this.b, 0, this.a, "", 1, 0, false, paramRunnable);
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = (IPreDownloadController)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((IPreDownloadController)localObject).preDownloadSuccess(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkPredownloader.Task
 * JD-Core Version:    0.7.0.1
 */