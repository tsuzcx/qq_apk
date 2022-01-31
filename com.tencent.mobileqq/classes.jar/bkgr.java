import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bkgr
  implements bkgq
{
  private List<bkgm> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bkgm)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bkgm)localIterator.next()).b(paramInt);
    }
  }
  
  public void a(bkgm parambkgm)
  {
    if (parambkgm == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(parambkgm)) {
      throw new IllegalStateException("Observer " + parambkgm + " is already registered.");
    }
    this.a.add(parambkgm);
  }
  
  public void b(bkgm parambkgm)
  {
    if (parambkgm == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(parambkgm);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkgr
 * JD-Core Version:    0.7.0.1
 */