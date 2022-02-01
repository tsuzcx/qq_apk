import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bnfn
{
  private List<bnfp> a = new LinkedList();
  
  public static bnfn a()
  {
    return bnfq.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bnfp)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bnfp)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull bnfp parambnfp)
  {
    return this.a.add(parambnfp);
  }
  
  public boolean b(@NonNull bnfp parambnfp)
  {
    return this.a.remove(parambnfp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfn
 * JD-Core Version:    0.7.0.1
 */