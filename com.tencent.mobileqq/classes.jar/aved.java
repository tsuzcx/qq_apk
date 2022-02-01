import com.tencent.mobileqq.app.BusinessObserver;

public class aved
  implements BusinessObserver
{
  protected void a(Object paramObject) {}
  
  protected void b(Object paramObject) {}
  
  protected void c(Object paramObject) {}
  
  protected void d(Object paramObject) {}
  
  protected void e(Object paramObject) {}
  
  protected void f(Object paramObject) {}
  
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
      e(paramObject);
      return;
    case 8227: 
      a(paramObject);
      return;
    case 8226: 
      c(paramObject);
      return;
    case 8228: 
      f(paramObject);
      return;
    }
    d(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aved
 * JD-Core Version:    0.7.0.1
 */