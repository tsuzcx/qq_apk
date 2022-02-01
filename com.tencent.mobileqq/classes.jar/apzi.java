import android.os.Bundle;

public abstract class apzi
  implements apyu
{
  private final String a;
  
  public apzi(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.a);
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.GetUserInformation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzi
 * JD-Core Version:    0.7.0.1
 */