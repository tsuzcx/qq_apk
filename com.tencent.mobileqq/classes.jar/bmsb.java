import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bmsb
  implements bmsa
{
  private List<bmrw> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmrw)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmrw)localIterator.next()).b(paramInt);
    }
  }
  
  public void a(bmrw parambmrw)
  {
    if (parambmrw == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(parambmrw)) {
      throw new IllegalStateException("Observer " + parambmrw + " is already registered.");
    }
    this.a.add(parambmrw);
  }
  
  public void b(bmrw parambmrw)
  {
    if (parambmrw == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(parambmrw);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsb
 * JD-Core Version:    0.7.0.1
 */