import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class awqo
{
  private List<awqp> a = Collections.synchronizedList(new ArrayList());
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((awqp)localIterator.next()).a(paramLong);
    }
  }
  
  void b(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((awqp)localIterator.next()).b(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqo
 * JD-Core Version:    0.7.0.1
 */