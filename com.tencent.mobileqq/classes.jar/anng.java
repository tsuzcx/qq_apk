import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1;
import java.util.List;

public abstract class anng
{
  public abstract int a();
  
  public abstract List<annd> a(boolean paramBoolean);
  
  public abstract void a();
  
  public void a(annh paramannh, annd paramannd, boolean paramBoolean)
  {
    ThreadManager.excute(new EmotionDataSource.1(this, paramBoolean, paramannh, paramannd), 64, null, true);
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anng
 * JD-Core Version:    0.7.0.1
 */