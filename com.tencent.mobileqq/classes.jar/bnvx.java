import java.util.HashMap;

public class bnvx
{
  private HashMap<String, bnwd> a = new HashMap();
  
  public bnwd a(String paramString)
  {
    return (bnwd)this.a.get(paramString);
  }
  
  public void a(String paramString, bnwd parambnwd)
  {
    this.a.put(paramString, parambnwd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvx
 * JD-Core Version:    0.7.0.1
 */