import java.util.Observable;
import java.util.Observer;

public abstract class beqe
  implements Observer
{
  public abstract void a(beqd parambeqd);
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof beqd)) {
      a((beqd)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqe
 * JD-Core Version:    0.7.0.1
 */