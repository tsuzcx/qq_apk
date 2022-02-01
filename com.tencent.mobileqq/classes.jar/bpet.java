import java.util.HashMap;

public class bpet
{
  private HashMap<String, bpez> a = new HashMap();
  
  public bpez a(String paramString)
  {
    return (bpez)this.a.get(paramString);
  }
  
  public void a(String paramString, bpez parambpez)
  {
    this.a.put(paramString, parambpez);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpet
 * JD-Core Version:    0.7.0.1
 */