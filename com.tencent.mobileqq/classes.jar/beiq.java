import java.util.Hashtable;

public class beiq
  extends behq
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beiq
 * JD-Core Version:    0.7.0.1
 */