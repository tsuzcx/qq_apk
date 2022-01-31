import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class attt
{
  public int a;
  public String a;
  public List<attw> a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      attw localattw = (attw)localIterator.next();
      if ((localattw.a <= paramInt) && (localattw.b > paramInt)) {
        return localattw.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attt
 * JD-Core Version:    0.7.0.1
 */