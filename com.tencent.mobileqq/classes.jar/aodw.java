import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1;
import java.util.List;

public abstract class aodw
{
  public abstract int a();
  
  public abstract List<aodt> a(boolean paramBoolean);
  
  public abstract void a();
  
  public void a(aodx paramaodx, aodt paramaodt, boolean paramBoolean)
  {
    ThreadManager.excute(new EmotionDataSource.1(this, paramBoolean, paramaodx, paramaodt), 64, null, true);
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aodw
 * JD-Core Version:    0.7.0.1
 */