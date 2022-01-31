import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1;
import java.util.List;

public abstract class aodr
{
  public abstract int a();
  
  public abstract List<aodo> a(boolean paramBoolean);
  
  public abstract void a();
  
  public void a(aods paramaods, aodo paramaodo, boolean paramBoolean)
  {
    ThreadManager.excute(new EmotionDataSource.1(this, paramBoolean, paramaods, paramaodo), 64, null, true);
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aodr
 * JD-Core Version:    0.7.0.1
 */