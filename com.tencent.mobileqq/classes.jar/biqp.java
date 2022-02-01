import java.util.Hashtable;

public class biqp
  extends bipp
{
  Hashtable<String, Boolean> a = new Hashtable();
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    paramString = (Boolean)this.a.get(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return paramString.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqp
 * JD-Core Version:    0.7.0.1
 */