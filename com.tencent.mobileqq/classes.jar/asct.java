import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class asct
{
  public int a;
  public String a;
  public List<ascw> a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ascw localascw = (ascw)localIterator.next();
      if ((localascw.a <= paramInt) && (localascw.b > paramInt)) {
        return localascw.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asct
 * JD-Core Version:    0.7.0.1
 */