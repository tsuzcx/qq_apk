import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bjzc
{
  private List<bjze> a = new LinkedList();
  
  public static bjzc a()
  {
    return bjzf.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bjze)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bjze)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull bjze parambjze)
  {
    return this.a.add(parambjze);
  }
  
  public boolean b(@NonNull bjze parambjze)
  {
    return this.a.remove(parambjze);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjzc
 * JD-Core Version:    0.7.0.1
 */