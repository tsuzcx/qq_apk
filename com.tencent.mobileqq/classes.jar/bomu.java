import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class bomu
  implements BusinessObserver
{
  public void a() {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b();
      return;
    case 2: 
      c();
      return;
    case 3: 
      a();
      return;
    case 4: 
      d();
      return;
    case 5: 
      e();
      return;
    case 6: 
      f();
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomu
 * JD-Core Version:    0.7.0.1
 */