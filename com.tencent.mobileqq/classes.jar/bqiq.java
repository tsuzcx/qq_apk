import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bqiq
{
  private List<bqis> a = new LinkedList();
  
  public static bqiq a()
  {
    return bqit.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bqis)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bqis)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull bqis parambqis)
  {
    return this.a.add(parambqis);
  }
  
  public boolean b(@NonNull bqis parambqis)
  {
    return this.a.remove(parambqis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqiq
 * JD-Core Version:    0.7.0.1
 */