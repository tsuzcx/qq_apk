import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awyd
{
  public int a;
  public String a;
  public List<awyg> a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      awyg localawyg = (awyg)localIterator.next();
      if ((localawyg.a <= paramInt) && (localawyg.b > paramInt)) {
        return localawyg.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyd
 * JD-Core Version:    0.7.0.1
 */