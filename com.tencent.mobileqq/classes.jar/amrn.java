public class amrn
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    amrq.a("DanmakuManager", "danmaku crash thread:" + paramThread.getName(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amrn
 * JD-Core Version:    0.7.0.1
 */