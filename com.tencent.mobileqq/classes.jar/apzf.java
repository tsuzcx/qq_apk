import android.os.Bundle;

public abstract class apzf
  implements apyu
{
  private final String a;
  
  public apzf(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("domain", this.a);
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.GetPSKeyAsync";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzf
 * JD-Core Version:    0.7.0.1
 */