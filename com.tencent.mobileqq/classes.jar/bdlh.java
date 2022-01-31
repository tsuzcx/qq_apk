import java.util.Observable;
import java.util.Observer;

public abstract class bdlh
  implements Observer
{
  public abstract void a(bdlg parambdlg);
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof bdlg)) {
      a((bdlg)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdlh
 * JD-Core Version:    0.7.0.1
 */