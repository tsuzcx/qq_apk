import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bipf
  implements bipe
{
  private List<bipa> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bipa)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bipa)localIterator.next()).b(paramInt);
    }
  }
  
  public void a(bipa parambipa)
  {
    if (parambipa == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(parambipa)) {
      throw new IllegalStateException("Observer " + parambipa + " is already registered.");
    }
    this.a.add(parambipa);
  }
  
  public void b(bipa parambipa)
  {
    if (parambipa == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(parambipa);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipf
 * JD-Core Version:    0.7.0.1
 */