import android.os.Bundle;

public class bbst
  extends bbss
{
  public bbst(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = this.a.getBundle(paramString1);
    if (paramString1 != null) {
      return paramString1.getString(paramString2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbst
 * JD-Core Version:    0.7.0.1
 */