import com.tencent.mobileqq.app.BusinessObserver;

public class awzi
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, axam paramaxam) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, paramObject);
      return;
    case 2: 
      b(paramBoolean, paramObject);
      return;
    case 3: 
      a(paramBoolean);
      return;
    case 4: 
      a(paramBoolean, (axam)paramObject);
      return;
    }
    b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzi
 * JD-Core Version:    0.7.0.1
 */