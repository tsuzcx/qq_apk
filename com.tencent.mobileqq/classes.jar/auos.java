import java.util.LinkedList;
import java.util.List;

public class auos<T>
{
  private List<T> a = new LinkedList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public T a()
  {
    if (this.a.size() == 0) {
      return null;
    }
    return this.a.remove(0);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(T paramT)
  {
    if (!this.a.contains(paramT)) {
      this.a.add(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auos
 * JD-Core Version:    0.7.0.1
 */