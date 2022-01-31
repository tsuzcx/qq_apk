import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class argp
{
  public int a;
  public String a;
  public List<args> a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      args localargs = (args)localIterator.next();
      if ((localargs.a <= paramInt) && (localargs.b > paramInt)) {
        return localargs.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     argp
 * JD-Core Version:    0.7.0.1
 */