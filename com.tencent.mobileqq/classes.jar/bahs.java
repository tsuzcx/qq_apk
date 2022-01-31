import java.util.Observable;

public class bahs
  extends Observable
{
  private static bahs a;
  
  public static bahs a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bahs();
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
 * Qualified Name:     bahs
 * JD-Core Version:    0.7.0.1
 */