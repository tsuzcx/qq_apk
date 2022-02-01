import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class baez
{
  public List<bafa> a = new ArrayList(1);
  
  public String a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bafa localbafa = (bafa)localIterator.next();
      if ((paramString != null) && (paramString.equals(localbafa.a))) {
        return localbafa.b;
      }
    }
    return null;
  }
  
  public void a(bhuk parambhuk)
  {
    if (parambhuk != null)
    {
      parambhuk.a();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        parambhuk.a(2131365191, ((bafa)localIterator.next()).a, 0);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.add(new bafa(paramString1, paramString2));
  }
  
  public String toString()
  {
    return Arrays.toString(this.a.toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baez
 * JD-Core Version:    0.7.0.1
 */