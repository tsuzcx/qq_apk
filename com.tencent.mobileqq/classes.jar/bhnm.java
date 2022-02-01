import java.util.Collection;

public class bhnm
{
  public static int a(Collection paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
  
  public static boolean a(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnm
 * JD-Core Version:    0.7.0.1
 */