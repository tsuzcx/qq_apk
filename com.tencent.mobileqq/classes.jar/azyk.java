import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class azyk
{
  public List<azyl> a = new ArrayList(1);
  
  public String a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      azyl localazyl = (azyl)localIterator.next();
      if ((paramString != null) && (paramString.equals(localazyl.a))) {
        return localazyl.b;
      }
    }
    return null;
  }
  
  public void a(bhjq parambhjq)
  {
    if (parambhjq != null)
    {
      parambhjq.a();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        parambhjq.a(2131365307, ((azyl)localIterator.next()).a, 0);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.add(new azyl(paramString1, paramString2));
  }
  
  public String toString()
  {
    return Arrays.toString(this.a.toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyk
 * JD-Core Version:    0.7.0.1
 */