import android.os.Bundle;

public class azie
  implements anui
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void c(boolean paramBoolean, Bundle paramBundle) {}
  
  public void d(boolean paramBoolean, Bundle paramBundle) {}
  
  public void e(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, (Bundle)paramObject);
      return;
    case 2: 
      c(paramBoolean, (Bundle)paramObject);
      return;
    case 3: 
      d(paramBoolean, (Bundle)paramObject);
      return;
    case 4: 
      e(paramBoolean, (Bundle)paramObject);
      return;
    case 5: 
      a(paramBoolean);
      return;
    case 6: 
      b(paramBoolean);
      return;
    }
    b(paramBoolean, (Bundle)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azie
 * JD-Core Version:    0.7.0.1
 */