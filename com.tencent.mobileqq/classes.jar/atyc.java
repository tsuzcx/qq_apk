import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atyc
{
  public int a;
  public String a;
  public List<atyf> a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      atyf localatyf = (atyf)localIterator.next();
      if ((localatyf.a <= paramInt) && (localatyf.b > paramInt)) {
        return localatyf.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atyc
 * JD-Core Version:    0.7.0.1
 */