import java.util.Observable;
import java.util.Observer;

public abstract class bgug
  implements Observer
{
  public abstract void a(bguf parambguf);
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof bguf)) {
      a((bguf)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgug
 * JD-Core Version:    0.7.0.1
 */