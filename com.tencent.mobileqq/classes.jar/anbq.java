import com.tencent.mobileqq.app.BusinessObserver;

public class anbq
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, bcqu parambcqu) {}
  
  protected void b(boolean paramBoolean, bcqu parambcqu) {}
  
  protected void c(boolean paramBoolean, bcqu parambcqu) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramBoolean, (bcqu)paramObject);
      return;
    case 1: 
      c(paramBoolean, (bcqu)paramObject);
      return;
    }
    a(paramBoolean, (bcqu)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbq
 * JD-Core Version:    0.7.0.1
 */