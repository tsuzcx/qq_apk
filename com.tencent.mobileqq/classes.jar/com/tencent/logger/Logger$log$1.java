package com.tencent.logger;

import com.tencent.logger.log.ILog;
import com.tencent.logger.log.LogLevel;
import com.tencent.logger.log.writer.WriteTask;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/logger/Logger$log$1", "Lcom/tencent/logger/log/writer/WriteTask;", "run", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Logger$log$1
  extends WriteTask
{
  Logger$log$1(LogLevel paramLogLevel, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramString3, paramString4, paramString5);
  }
  
  public void run()
  {
    ILog localILog = Logger.a(Logger.a);
    if (localILog != null) {
      localILog.a(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.Logger.log.1
 * JD-Core Version:    0.7.0.1
 */