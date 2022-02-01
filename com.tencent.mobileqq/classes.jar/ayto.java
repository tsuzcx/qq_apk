import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ayto
{
  public List<aytp> a = new ArrayList(1);
  
  public String a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      aytp localaytp = (aytp)localIterator.next();
      if ((paramString != null) && (paramString.equals(localaytp.a))) {
        return localaytp.b;
      }
    }
    return null;
  }
  
  public void a(bgaz parambgaz)
  {
    if (parambgaz != null)
    {
      parambgaz.a();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        parambgaz.a(2131365216, ((aytp)localIterator.next()).a, 0);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.add(new aytp(paramString1, paramString2));
  }
  
  public String toString()
  {
    return Arrays.toString(this.a.toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayto
 * JD-Core Version:    0.7.0.1
 */