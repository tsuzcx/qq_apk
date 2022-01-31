import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class atss
{
  private List<atst> a = Collections.synchronizedList(new ArrayList());
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((atst)localIterator.next()).a(paramLong);
    }
  }
  
  void b(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((atst)localIterator.next()).b(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atss
 * JD-Core Version:    0.7.0.1
 */