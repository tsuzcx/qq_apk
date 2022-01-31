import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class biih
{
  private List<biij> a = new LinkedList();
  
  public static biih a()
  {
    return biik.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((biij)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((biij)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull biij parambiij)
  {
    return this.a.add(parambiij);
  }
  
  public boolean b(@NonNull biij parambiij)
  {
    return this.a.remove(parambiij);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biih
 * JD-Core Version:    0.7.0.1
 */