import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bnlv
  implements bnlu
{
  private List<bnlq> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bnlq)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bnlq)localIterator.next()).c(paramInt);
    }
  }
  
  public void a(bnlq parambnlq)
  {
    if (parambnlq == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(parambnlq)) {
      throw new IllegalStateException("Observer " + parambnlq + " is already registered.");
    }
    this.a.add(parambnlq);
  }
  
  public void b(bnlq parambnlq)
  {
    if (parambnlq == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(parambnlq);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlv
 * JD-Core Version:    0.7.0.1
 */