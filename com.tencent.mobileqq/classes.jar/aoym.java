import dov.com.tencent.mobileqq.shortvideo.mediadevice.DispatchThread;

public class aoym
  implements Runnable
{
  public aoym(DispatchThread paramDispatchThread) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      this.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoym
 * JD-Core Version:    0.7.0.1
 */