import java.util.Observable;

public class bggy
  extends Observable
{
  private static bggy a;
  
  public static bggy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bggy();
      }
      return a;
    }
    finally {}
  }
  
  public void setChanged()
  {
    super.setChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggy
 * JD-Core Version:    0.7.0.1
 */