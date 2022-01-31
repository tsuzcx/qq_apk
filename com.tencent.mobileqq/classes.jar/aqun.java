import java.util.Observable;
import java.util.Observer;

public class aqun
  implements Observer
{
  protected void a() {}
  
  protected void b() {}
  
  protected void c() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqun
 * JD-Core Version:    0.7.0.1
 */