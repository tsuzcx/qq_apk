import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bmex
{
  private final HashMap<String, bmes> a = new HashMap();
  
  final bmes a(String paramString)
  {
    return (bmes)this.a.get(paramString);
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((bmes)localIterator.next()).b();
    }
    this.a.clear();
  }
  
  final void a(String paramString, bmes parambmes)
  {
    paramString = (bmes)this.a.put(paramString, parambmes);
    if (paramString != null) {
      paramString.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmex
 * JD-Core Version:    0.7.0.1
 */