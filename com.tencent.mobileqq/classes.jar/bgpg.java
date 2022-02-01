import java.util.Observable;

public class bgpg
  extends Observable
{
  private static bgpg a;
  
  public static bgpg a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bgpg();
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
 * Qualified Name:     bgpg
 * JD-Core Version:    0.7.0.1
 */