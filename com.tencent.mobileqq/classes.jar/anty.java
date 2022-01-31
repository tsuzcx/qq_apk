import dov.com.tencent.biz.qqstory.takevideo.EditVideoGuide;
import java.util.concurrent.atomic.AtomicBoolean;

public class anty
  implements Runnable
{
  private anty(EditVideoGuide paramEditVideoGuide) {}
  
  public void run()
  {
    if (this.a.a.compareAndSet(true, false))
    {
      this.a.a(false);
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anty
 * JD-Core Version:    0.7.0.1
 */