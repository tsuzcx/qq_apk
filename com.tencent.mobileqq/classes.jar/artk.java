public class artk
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    artm.a("DanmakuManager", "danmaku crash thread:" + paramThread.getName(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artk
 * JD-Core Version:    0.7.0.1
 */