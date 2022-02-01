package com.tencent.logger.log.writer;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/log/writer/WriteTask;", "Ljava/lang/Runnable;", "tag", "", "msg", "threadInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getTag", "getThreadInfo", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract class WriteTask
  implements Runnable
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  
  public WriteTask(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.writer.WriteTask
 * JD-Core Version:    0.7.0.1
 */