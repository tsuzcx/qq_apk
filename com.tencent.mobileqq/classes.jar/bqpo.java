import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bqpo
  implements bqpn
{
  private List<bqpj> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bqpj)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bqpj)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(bqpj parambqpj)
  {
    if (parambqpj == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(parambqpj)) {
      throw new IllegalStateException("Observer " + parambqpj + " is already registered.");
    }
    this.a.add(parambqpj);
  }
  
  public void b(bqpj parambqpj)
  {
    if (parambqpj == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(parambqpj);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqpo
 * JD-Core Version:    0.7.0.1
 */