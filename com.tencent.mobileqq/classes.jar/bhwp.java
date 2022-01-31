import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bhwp
{
  private final HashMap<String, bhwk> a = new HashMap();
  
  final bhwk a(String paramString)
  {
    return (bhwk)this.a.get(paramString);
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((bhwk)localIterator.next()).b();
    }
    this.a.clear();
  }
  
  final void a(String paramString, bhwk parambhwk)
  {
    paramString = (bhwk)this.a.put(paramString, parambhwk);
    if (paramString != null) {
      paramString.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhwp
 * JD-Core Version:    0.7.0.1
 */