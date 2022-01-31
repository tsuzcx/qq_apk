import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bjok
{
  private final HashMap<String, bjof> a = new HashMap();
  
  final bjof a(String paramString)
  {
    return (bjof)this.a.get(paramString);
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((bjof)localIterator.next()).b();
    }
    this.a.clear();
  }
  
  final void a(String paramString, bjof parambjof)
  {
    paramString = (bjof)this.a.put(paramString, parambjof);
    if (paramString != null) {
      paramString.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjok
 * JD-Core Version:    0.7.0.1
 */