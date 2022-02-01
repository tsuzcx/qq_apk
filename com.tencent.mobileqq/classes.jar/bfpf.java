import java.util.Observable;

public class bfpf
  extends Observable
{
  private static bfpf a;
  
  public static bfpf a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bfpf();
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
 * Qualified Name:     bfpf
 * JD-Core Version:    0.7.0.1
 */