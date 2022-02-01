import com.tencent.mobileqq.app.BusinessObserver;

public class aocc
  implements BusinessObserver
{
  public void a(Object paramObject) {}
  
  public void b(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      a(paramObject);
      return;
    }
    b(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocc
 * JD-Core Version:    0.7.0.1
 */