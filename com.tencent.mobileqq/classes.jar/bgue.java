import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Observable;

public class bgue
  extends Observable
{
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    QMLog.d("minisdk-start_AppStateManager", "notifyChange msg=" + paramObject);
    setChanged();
    if (paramObject != null)
    {
      notifyObservers(paramObject);
      return;
    }
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgue
 * JD-Core Version:    0.7.0.1
 */