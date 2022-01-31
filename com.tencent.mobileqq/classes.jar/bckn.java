import java.util.Observable;

public class bckn
  extends Observable
{
  private static bckn a;
  
  public static bckn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bckn();
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
 * Qualified Name:     bckn
 * JD-Core Version:    0.7.0.1
 */