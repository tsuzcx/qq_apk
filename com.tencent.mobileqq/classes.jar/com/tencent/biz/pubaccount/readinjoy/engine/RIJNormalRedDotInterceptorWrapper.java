package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.data.MessageRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJNormalRedDotInterceptorWrapper;", "Lcom/tencent/biz/pubaccount/readinjoy/engine/IRIJNormalRedDotInterceptor;", "interceptor", "(Lcom/tencent/biz/pubaccount/readinjoy/engine/IRIJNormalRedDotInterceptor;)V", "onNotifyRedDotMsg", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "onReceiveRedDotMsg", "onSaveRedDotMsg", "", "shouldIntercept", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJNormalRedDotInterceptorWrapper
  implements IRIJNormalRedDotInterceptor
{
  private final IRIJNormalRedDotInterceptor a;
  
  public RIJNormalRedDotInterceptorWrapper(@Nullable IRIJNormalRedDotInterceptor paramIRIJNormalRedDotInterceptor)
  {
    this.a = paramIRIJNormalRedDotInterceptor;
  }
  
  public int a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    IRIJNormalRedDotInterceptor localIRIJNormalRedDotInterceptor = this.a;
    if (localIRIJNormalRedDotInterceptor != null) {
      return localIRIJNormalRedDotInterceptor.a(paramMessageRecord);
    }
    return 0;
  }
  
  public boolean a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    IRIJNormalRedDotInterceptor localIRIJNormalRedDotInterceptor = this.a;
    return (localIRIJNormalRedDotInterceptor != null) && (localIRIJNormalRedDotInterceptor.a(paramMessageRecord) == true);
  }
  
  public boolean b(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    IRIJNormalRedDotInterceptor localIRIJNormalRedDotInterceptor = this.a;
    return (localIRIJNormalRedDotInterceptor != null) && (localIRIJNormalRedDotInterceptor.b(paramMessageRecord) == true);
  }
  
  public boolean c(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    IRIJNormalRedDotInterceptor localIRIJNormalRedDotInterceptor = this.a;
    return (localIRIJNormalRedDotInterceptor != null) && (localIRIJNormalRedDotInterceptor.c(paramMessageRecord) == true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.RIJNormalRedDotInterceptorWrapper
 * JD-Core Version:    0.7.0.1
 */