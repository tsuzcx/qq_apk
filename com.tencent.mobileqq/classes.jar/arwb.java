public class arwb
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    arwe.a("DanmakuManager", "danmaku crash thread:" + paramThread.getName(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwb
 * JD-Core Version:    0.7.0.1
 */