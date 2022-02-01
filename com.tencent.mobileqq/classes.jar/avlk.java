import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class avlk
{
  public int a;
  public String a;
  public List<avln> a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      avln localavln = (avln)localIterator.next();
      if ((localavln.a <= paramInt) && (localavln.b > paramInt)) {
        return localavln.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlk
 * JD-Core Version:    0.7.0.1
 */