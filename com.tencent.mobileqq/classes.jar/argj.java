import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1;
import java.util.List;

public abstract class argj
{
  public abstract int a();
  
  public abstract List<argg> a(boolean paramBoolean);
  
  public abstract void a();
  
  public void a(argk paramargk, argg paramargg, boolean paramBoolean)
  {
    ThreadManager.excute(new EmotionDataSource.1(this, paramBoolean, paramargk, paramargg), 64, null, true);
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argj
 * JD-Core Version:    0.7.0.1
 */