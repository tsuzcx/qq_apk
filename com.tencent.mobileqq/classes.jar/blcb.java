import java.util.Observable;

public class blcb
  extends Observable
{
  public void a()
  {
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcb
 * JD-Core Version:    0.7.0.1
 */