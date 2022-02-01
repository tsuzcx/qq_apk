import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class azmn
{
  public List<azmo> a = new ArrayList(1);
  
  public String a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      azmo localazmo = (azmo)localIterator.next();
      if ((paramString != null) && (paramString.equals(localazmo.a))) {
        return localazmo.b;
      }
    }
    return null;
  }
  
  public void a(bguh parambguh)
  {
    if (parambguh != null)
    {
      parambguh.a();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        parambguh.a(2131365147, ((azmo)localIterator.next()).a, 0);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.add(new azmo(paramString1, paramString2));
  }
  
  public String toString()
  {
    return Arrays.toString(this.a.toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmn
 * JD-Core Version:    0.7.0.1
 */