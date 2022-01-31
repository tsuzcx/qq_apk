public class aozg
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    aozj.a("DanmakuManager", "danmaku crash thread:" + paramThread.getName(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozg
 * JD-Core Version:    0.7.0.1
 */