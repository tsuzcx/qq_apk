import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bjzt
{
  private List<bjzv> a = new LinkedList();
  
  public static bjzt a()
  {
    return bjzw.a;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bjzv)localIterator.next()).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bjzv)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(@NonNull bjzv parambjzv)
  {
    return this.a.add(parambjzv);
  }
  
  public boolean b(@NonNull bjzv parambjzv)
  {
    return this.a.remove(parambjzv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjzt
 * JD-Core Version:    0.7.0.1
 */