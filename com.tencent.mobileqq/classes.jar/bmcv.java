import android.content.Context;
import java.util.Observable;

public class bmcv
  extends Observable
{
  public void a(Context paramContext)
  {
    setChanged();
    notifyObservers(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcv
 * JD-Core Version:    0.7.0.1
 */