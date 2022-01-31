import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bmpp
{
  private List<bmpr> a = new LinkedList();
  
  public static bmpp a()
  {
    return bmps.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmpr)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmpr)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull bmpr parambmpr)
  {
    return this.a.add(parambmpr);
  }
  
  public boolean b(@NonNull bmpr parambmpr)
  {
    return this.a.remove(parambmpr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpp
 * JD-Core Version:    0.7.0.1
 */