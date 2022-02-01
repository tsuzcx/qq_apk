import com.tencent.mobileqq.app.BusinessObserver;

public class aoef
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, bdxt parambdxt) {}
  
  protected void b(boolean paramBoolean, bdxt parambdxt) {}
  
  protected void c(boolean paramBoolean, bdxt parambdxt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramBoolean, (bdxt)paramObject);
      return;
    case 1: 
      c(paramBoolean, (bdxt)paramObject);
      return;
    }
    a(paramBoolean, (bdxt)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoef
 * JD-Core Version:    0.7.0.1
 */