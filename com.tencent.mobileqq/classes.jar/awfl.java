import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awfl
{
  public int a;
  public String a;
  public List<awfo> a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      awfo localawfo = (awfo)localIterator.next();
      if ((localawfo.a <= paramInt) && (localawfo.b > paramInt)) {
        return localawfo.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfl
 * JD-Core Version:    0.7.0.1
 */