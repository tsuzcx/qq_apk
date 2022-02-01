import android.os.Bundle;
import android.text.TextUtils;

public abstract class apvu
  implements apvj
{
  private final String a;
  
  public apvu(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.a)) {
      localBundle.putString("Domain", this.a);
    }
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.GetPSKey";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvu
 * JD-Core Version:    0.7.0.1
 */