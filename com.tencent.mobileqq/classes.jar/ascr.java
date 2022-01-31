import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ascr
{
  public int a;
  public String a;
  public List<ascu> a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ascu localascu = (ascu)localIterator.next();
      if ((localascu.a <= paramInt) && (localascu.b > paramInt)) {
        return localascu.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ascr
 * JD-Core Version:    0.7.0.1
 */