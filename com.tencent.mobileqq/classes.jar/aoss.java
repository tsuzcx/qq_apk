import android.os.Bundle;

public abstract class aoss
  implements aosh
{
  private final String a;
  
  public aoss(String paramString)
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
 * Qualified Name:     aoss
 * JD-Core Version:    0.7.0.1
 */