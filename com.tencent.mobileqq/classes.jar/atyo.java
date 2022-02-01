import com.tencent.mobileqq.app.BusinessObserver;

public class atyo
  implements BusinessObserver
{
  protected void a(Object paramObject) {}
  
  protected void b(Object paramObject) {}
  
  protected void c(Object paramObject) {}
  
  protected void d(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8224: 
      b(paramObject);
      return;
    case 8225: 
      d(paramObject);
      return;
    case 8227: 
      a(paramObject);
      return;
    }
    c(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyo
 * JD-Core Version:    0.7.0.1
 */