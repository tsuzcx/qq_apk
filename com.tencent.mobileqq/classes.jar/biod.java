import android.content.Context;
import java.util.Observable;

public class biod
  extends Observable
{
  public void a(Context paramContext)
  {
    setChanged();
    notifyObservers(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biod
 * JD-Core Version:    0.7.0.1
 */