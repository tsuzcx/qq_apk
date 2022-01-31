import java.util.Observable;

public class bcge
  extends Observable
{
  private static bcge a;
  
  public static bcge a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bcge();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcge
 * JD-Core Version:    0.7.0.1
 */