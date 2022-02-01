package com.tencent.biz.pubaccount.readinjoy.webarticle;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJWebResourceUtil$updateResourceOfflinePkg$runnable$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    RIJWebResourceUtil.updateResourceOfflinePkg.runnable.1.asyncBack.1 local1 = new RIJWebResourceUtil.updateResourceOfflinePkg.runnable.1.asyncBack.1();
    try
    {
      HtmlOffline.a();
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
          HtmlOffline.b("3948", localBaseApplicationImpl.getRuntime(), (AsyncBack)local1, true, 0, true);
          return;
        }
        catch (Throwable localThrowable1)
        {
          QLog.i("RIJWebResourceUtil", 1, "[updateResourceOfflinePkg], t = " + localThrowable1);
        }
        localThrowable2 = localThrowable2;
        QLog.e("RIJWebResourceUtil", 1, "[updateResourceOfflinePkg], t = " + localThrowable2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebResourceUtil.updateResourceOfflinePkg.runnable.1
 * JD-Core Version:    0.7.0.1
 */