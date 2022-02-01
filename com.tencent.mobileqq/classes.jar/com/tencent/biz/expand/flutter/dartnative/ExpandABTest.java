package com.tencent.biz.expand.flutter.dartnative;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.utils.ExpandSharePreUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/flutter/dartnative/ExpandABTest;", "Lcom/tencent/biz/expand/flutter/dartnative/DartNativeBase;", "()V", "mABTestInfo", "", "asyncGetABTestInfo", "", "callback", "Lcom/tencent/biz/expand/flutter/dartnative/ABTestCallback;", "getABTestInfo", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandABTest
  extends DartNativeBase
{
  public static final ExpandABTest.Companion Companion = new ExpandABTest.Companion(null);
  @NotNull
  public static final String TAG = "ExpandABTest";
  private String mABTestInfo = "";
  
  public final void asyncGetABTestInfo(@NotNull ABTestCallback paramABTestCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramABTestCallback, "callback");
    paramABTestCallback.asyncGetABTestInfoWithCallback("{\"reqTimestamp\":1608645788.122689,\"grayPolicyInfoList\":[{\"paramsInfoList\":[],\"sGroupKey\":\"exp_QQ_kuolie_new_homepage_singletab\",\"sStrategyType\":\"treatment\",\"expKey\":\"exp_QQ_kuolie_new_homepage_singletab_B\",\"grayPolicyId\":\"311852\"}]}");
  }
  
  @NotNull
  public final String getABTestInfo()
  {
    if (TextUtils.isEmpty((CharSequence)this.mABTestInfo))
    {
      Object localObject = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
      localObject = ExpandSharePreUtils.b(((AppRuntime)localObject).getAccount());
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ExpandSharePreUtils.getA…cation().runtime.account)");
      this.mABTestInfo = ((String)localObject);
    }
    QLog.d("ExpandABTest", 4, "ABTestInfo " + this.mABTestInfo);
    return this.mABTestInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.dartnative.ExpandABTest
 * JD-Core Version:    0.7.0.1
 */