import java.util.Observable;

public class beqc
  extends Observable
{
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    betc.a("minisdk-start_AppStateManager", "notifyChange msg=" + paramObject);
    setChanged();
    if (paramObject != null)
    {
      notifyObservers(paramObject);
      return;
    }
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqc
 * JD-Core Version:    0.7.0.1
 */