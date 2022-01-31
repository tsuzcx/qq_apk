import java.util.HashMap;

public class blgv
{
  private HashMap<String, blhb> a = new HashMap();
  
  public blhb a(String paramString)
  {
    return (blhb)this.a.get(paramString);
  }
  
  public void a(String paramString, blhb paramblhb)
  {
    this.a.put(paramString, paramblhb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgv
 * JD-Core Version:    0.7.0.1
 */