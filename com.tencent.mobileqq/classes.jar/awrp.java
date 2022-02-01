import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awrp
{
  public int a;
  public String a;
  public List<awrs> a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      awrs localawrs = (awrs)localIterator.next();
      if ((localawrs.a <= paramInt) && (localawrs.b > paramInt)) {
        return localawrs.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrp
 * JD-Core Version:    0.7.0.1
 */