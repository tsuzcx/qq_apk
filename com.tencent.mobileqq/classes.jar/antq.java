import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class antq
  implements Runnable
{
  public antq(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "mStartHidingRunnable run");
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     antq
 * JD-Core Version:    0.7.0.1
 */