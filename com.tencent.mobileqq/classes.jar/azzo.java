import com.tencent.mobileqq.app.BusinessObserver;

public class azzo
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      b(paramBoolean);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        a(paramBoolean);
        return;
      }
    } while (paramInt != 3);
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzo
 * JD-Core Version:    0.7.0.1
 */