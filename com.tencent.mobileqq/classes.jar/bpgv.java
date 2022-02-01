import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bpgv
{
  private List<bpgx> a = new LinkedList();
  
  public static bpgv a()
  {
    return bpgy.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bpgx)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bpgx)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull bpgx parambpgx)
  {
    return this.a.add(parambpgx);
  }
  
  public boolean b(@NonNull bpgx parambpgx)
  {
    return this.a.remove(parambpgx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgv
 * JD-Core Version:    0.7.0.1
 */