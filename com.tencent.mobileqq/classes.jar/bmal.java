import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bmal
{
  private final HashMap<String, bmag> a = new HashMap();
  
  final bmag a(String paramString)
  {
    return (bmag)this.a.get(paramString);
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((bmag)localIterator.next()).b();
    }
    this.a.clear();
  }
  
  final void a(String paramString, bmag parambmag)
  {
    paramString = (bmag)this.a.put(paramString, parambmag);
    if (paramString != null) {
      paramString.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmal
 * JD-Core Version:    0.7.0.1
 */