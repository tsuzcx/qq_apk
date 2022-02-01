import android.os.Bundle;

public abstract class apvz
  implements apvj
{
  private final String a;
  
  public apvz(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", this.a);
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.LaunchMiniappHandler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvz
 * JD-Core Version:    0.7.0.1
 */