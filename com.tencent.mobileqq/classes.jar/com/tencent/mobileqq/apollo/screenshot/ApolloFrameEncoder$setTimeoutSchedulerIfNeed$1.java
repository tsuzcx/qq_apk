package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class ApolloFrameEncoder$setTimeoutSchedulerIfNeed$1
  extends Lambda
  implements Function0<Unit>
{
  ApolloFrameEncoder$setTimeoutSchedulerIfNeed$1(ApolloFrameEncoder paramApolloFrameEncoder, long paramLong)
  {
    super(0);
  }
  
  public final void invoke()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call evaluateStopRecordIfNeed on timeout:");
    localStringBuilder.append(this.$delayTime);
    localStringBuilder.append(" ms, tempFilePath:");
    localStringBuilder.append(ApolloFrameEncoder.a(this.this$0));
    QLog.w("[cmshow][MemePlayer][ApolloScrshot]_ApolloFrameEncoder", 1, localStringBuilder.toString());
    ApolloFrameEncoder.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloFrameEncoder.setTimeoutSchedulerIfNeed.1
 * JD-Core Version:    0.7.0.1
 */