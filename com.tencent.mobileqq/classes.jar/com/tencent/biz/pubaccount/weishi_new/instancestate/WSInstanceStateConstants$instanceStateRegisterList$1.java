package com.tencent.biz.pubaccount.weishi_new.instancestate;

import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/instancestate/WSInstanceStateConstants$instanceStateRegisterList$1", "Lcom/tencent/biz/pubaccount/weishi_new/instancestate/IWSInstanceStateOperation;", "getKey", "", "getValue", "setValue", "", "value", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSInstanceStateConstants$instanceStateRegisterList$1
  implements IWSInstanceStateOperation
{
  @NotNull
  public String a()
  {
    return "key_enter_public_acc_from";
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    WSPublicAccReport.getInstance().setEnterPublicAccFrom(paramString);
  }
  
  @NotNull
  public String b()
  {
    Object localObject = WSPublicAccReport.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WSPublicAccReport.getInstance()");
    localObject = ((WSPublicAccReport)localObject).getEnterPublicAccFrom();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WSPublicAccReport.getInstance().enterPublicAccFrom");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.instancestate.WSInstanceStateConstants.instanceStateRegisterList.1
 * JD-Core Version:    0.7.0.1
 */