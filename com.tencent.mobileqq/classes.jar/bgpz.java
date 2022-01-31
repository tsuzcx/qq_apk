import java.util.Observable;
import java.util.Observer;

public abstract class bgpz
  implements Observer
{
  public abstract void a(bgpy parambgpy);
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof bgpy)) {
      a((bgpy)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpz
 * JD-Core Version:    0.7.0.1
 */