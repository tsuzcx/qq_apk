import java.util.HashMap;

public class bmgf
{
  private HashMap<String, bmgl> a = new HashMap();
  
  public bmgl a(String paramString)
  {
    return (bmgl)this.a.get(paramString);
  }
  
  public void a(String paramString, bmgl parambmgl)
  {
    this.a.put(paramString, parambmgl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgf
 * JD-Core Version:    0.7.0.1
 */