import java.util.Observable;

public class beyu
  extends Observable
{
  private static beyu a;
  
  public static beyu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new beyu();
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
 * Qualified Name:     beyu
 * JD-Core Version:    0.7.0.1
 */