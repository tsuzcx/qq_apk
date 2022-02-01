import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bpnt
  implements bpns
{
  private List<bpno> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bpno)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bpno)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(bpno parambpno)
  {
    if (parambpno == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(parambpno)) {
      throw new IllegalStateException("Observer " + parambpno + " is already registered.");
    }
    this.a.add(parambpno);
  }
  
  public void b(bpno parambpno)
  {
    if (parambpno == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(parambpno);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpnt
 * JD-Core Version:    0.7.0.1
 */