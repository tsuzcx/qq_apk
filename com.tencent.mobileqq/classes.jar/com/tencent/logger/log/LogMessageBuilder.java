package com.tencent.logger.log;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/log/LogMessageBuilder;", "", "()V", "mNext", "mStringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "append", "obj", "clearForRecycle", "", "recycle", "toString", "", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LogMessageBuilder
{
  public static final LogMessageBuilder.Companion a = new LogMessageBuilder.Companion(null);
  private static final Object c = new Object();
  private final StringBuilder b = new StringBuilder(128);
  
  @NotNull
  public String toString()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((StringBuilder)localObject).toString();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.LogMessageBuilder
 * JD-Core Version:    0.7.0.1
 */