package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class NowLiveBridgeInvokeHandler$preload$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((AppRuntime)localObject).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager");
      }
      ((DynamicNowManager)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.NowLiveBridgeInvokeHandler.preload.1
 * JD-Core Version:    0.7.0.1
 */