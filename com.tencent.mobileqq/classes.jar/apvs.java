import android.os.Bundle;
import android.text.TextUtils;

public abstract class apvs
  implements apvj
{
  private final String a;
  
  public apvs(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.a)) {
      localBundle.putString("Uin", this.a);
    }
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.GetNickname";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvs
 * JD-Core Version:    0.7.0.1
 */