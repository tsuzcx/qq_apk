import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class atxb
{
  private List<atxc> a = Collections.synchronizedList(new ArrayList());
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((atxc)localIterator.next()).a(paramLong);
    }
  }
  
  void b(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((atxc)localIterator.next()).b(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxb
 * JD-Core Version:    0.7.0.1
 */