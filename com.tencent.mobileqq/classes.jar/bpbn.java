import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bpbn
  implements bpbm
{
  private List<bpbi> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bpbi)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bpbi)localIterator.next()).c(paramInt);
    }
  }
  
  public void a(bpbi parambpbi)
  {
    if (parambpbi == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(parambpbi)) {
      throw new IllegalStateException("Observer " + parambpbi + " is already registered.");
    }
    this.a.add(parambpbi);
  }
  
  public void b(bpbi parambpbi)
  {
    if (parambpbi == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(parambpbi);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbn
 * JD-Core Version:    0.7.0.1
 */