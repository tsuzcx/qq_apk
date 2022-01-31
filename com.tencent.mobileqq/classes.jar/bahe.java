import java.util.Observable;

public class bahe
  extends Observable
{
  private static bahe a;
  
  public static bahe a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bahe();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bahe
 * JD-Core Version:    0.7.0.1
 */