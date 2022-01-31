import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bmwn
  implements bmwm
{
  private List<bmwi> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmwi)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmwi)localIterator.next()).b(paramInt);
    }
  }
  
  public void a(bmwi parambmwi)
  {
    if (parambmwi == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(parambmwi)) {
      throw new IllegalStateException("Observer " + parambmwi + " is already registered.");
    }
    this.a.add(parambmwi);
  }
  
  public void b(bmwi parambmwi)
  {
    if (parambmwi == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(parambmwi);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwn
 * JD-Core Version:    0.7.0.1
 */