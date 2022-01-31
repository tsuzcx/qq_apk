import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bjpb
{
  private final HashMap<String, bjow> a = new HashMap();
  
  final bjow a(String paramString)
  {
    return (bjow)this.a.get(paramString);
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((bjow)localIterator.next()).b();
    }
    this.a.clear();
  }
  
  final void a(String paramString, bjow parambjow)
  {
    paramString = (bjow)this.a.put(paramString, parambjow);
    if (paramString != null) {
      paramString.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjpb
 * JD-Core Version:    0.7.0.1
 */