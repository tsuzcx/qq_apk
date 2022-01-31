import java.util.Observable;
import java.util.Observer;

public abstract class bepn
  implements Observer
{
  public abstract void a(bepm parambepm);
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof bepm)) {
      a((bepm)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepn
 * JD-Core Version:    0.7.0.1
 */