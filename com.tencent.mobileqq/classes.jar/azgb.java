import java.util.Observable;

public class azgb
  extends Observable
{
  private static azgb a;
  
  public static azgb a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new azgb();
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
 * Qualified Name:     azgb
 * JD-Core Version:    0.7.0.1
 */