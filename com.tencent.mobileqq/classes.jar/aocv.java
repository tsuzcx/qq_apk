import android.os.Handler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import java.util.TimerTask;

public class aocv
  extends TimerTask
{
  private aocv(EditVideoMusic paramEditVideoMusic) {}
  
  public void run()
  {
    this.a.a.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aocv
 * JD-Core Version:    0.7.0.1
 */