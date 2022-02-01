package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJUtilsHelper$Companion;", "", "()V", "getLogicManager", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicManager;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJUtilsHelper$Companion
{
  @Nullable
  public final ReadInJoyLogicManager a()
  {
    ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)null;
    label71:
    do
    {
      try
      {
        Object localObject1 = ReadInJoyUtils.a();
        if (!(localObject1 instanceof QQAppInterface)) {
          break label71;
        }
        localObject1 = ((AppRuntime)localObject1).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        if (localObject1 == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager");
        }
      }
      catch (Exception localException)
      {
        QLog.d("RIJSocialBottomUtils", 1, "getLogicManager error! msg = " + localException);
        return localReadInJoyLogicManager;
      }
      return (ReadInJoyLogicManager)localException;
      localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
      }
      localObject2 = (AppInterface)localObject2;
    } while (!(localObject2 instanceof BrowserAppInterface));
    Object localObject2 = ((BrowserAppInterface)localObject2).a();
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJUtilsHelper.Companion
 * JD-Core Version:    0.7.0.1
 */