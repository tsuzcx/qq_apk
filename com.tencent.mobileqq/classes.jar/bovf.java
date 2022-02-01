import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bovf
{
  private List<bovh> a = new LinkedList();
  
  public static bovf a()
  {
    return bovi.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bovh)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bovh)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull bovh parambovh)
  {
    return this.a.add(parambovh);
  }
  
  public boolean b(@NonNull bovh parambovh)
  {
    return this.a.remove(parambovh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bovf
 * JD-Core Version:    0.7.0.1
 */