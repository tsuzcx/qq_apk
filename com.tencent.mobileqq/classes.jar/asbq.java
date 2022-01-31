import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class asbq
{
  private List<asbr> a = Collections.synchronizedList(new ArrayList());
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((asbr)localIterator.next()).a(paramLong);
    }
  }
  
  void b(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((asbr)localIterator.next()).b(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asbq
 * JD-Core Version:    0.7.0.1
 */