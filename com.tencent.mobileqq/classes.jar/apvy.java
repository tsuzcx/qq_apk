import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1;
import java.util.List;

public abstract class apvy
{
  public abstract int a();
  
  public abstract List<apvv> a(boolean paramBoolean);
  
  public abstract void a();
  
  public void a(apvz paramapvz, apvv paramapvv, boolean paramBoolean)
  {
    ThreadManager.excute(new EmotionDataSource.1(this, paramBoolean, paramapvz, paramapvv), 64, null, true);
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvy
 * JD-Core Version:    0.7.0.1
 */