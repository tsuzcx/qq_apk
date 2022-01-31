import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bkga
  implements bkfz
{
  private List<bkfv> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bkfv)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bkfv)localIterator.next()).b(paramInt);
    }
  }
  
  public void a(bkfv parambkfv)
  {
    if (parambkfv == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(parambkfv)) {
      throw new IllegalStateException("Observer " + parambkfv + " is already registered.");
    }
    this.a.add(parambkfv);
  }
  
  public void b(bkfv parambkfv)
  {
    if (parambkfv == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(parambkfv);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkga
 * JD-Core Version:    0.7.0.1
 */