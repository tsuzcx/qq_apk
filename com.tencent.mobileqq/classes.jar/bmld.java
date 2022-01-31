import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bmld
{
  private List<bmlf> a = new LinkedList();
  
  public static bmld a()
  {
    return bmlg.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmlf)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmlf)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull bmlf parambmlf)
  {
    return this.a.add(parambmlf);
  }
  
  public boolean b(@NonNull bmlf parambmlf)
  {
    return this.a.remove(parambmlf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmld
 * JD-Core Version:    0.7.0.1
 */