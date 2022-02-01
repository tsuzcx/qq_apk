import com.tencent.mobileqq.app.BusinessObserver;

public class ayus
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayus
 * JD-Core Version:    0.7.0.1
 */