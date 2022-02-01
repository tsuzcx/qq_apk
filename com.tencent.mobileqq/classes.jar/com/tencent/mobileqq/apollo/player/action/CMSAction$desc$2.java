package com.tencent.mobileqq.apollo.player.action;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSAction$desc$2
  extends Lambda
  implements Function0<String>
{
  CMSAction$desc$2(CMSAction paramCMSAction)
  {
    super(0);
  }
  
  @NotNull
  public final String invoke()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id:");
    localStringBuilder.append(this.this$0.a());
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.this$0.b());
    localStringBuilder.append(" key:");
    localStringBuilder.append(this.this$0.c());
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSAction.desc.2
 * JD-Core Version:    0.7.0.1
 */