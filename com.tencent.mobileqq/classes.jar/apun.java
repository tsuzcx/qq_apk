import android.os.Bundle;

final class apun
  extends apvv
{
  apun(String paramString, apvd paramapvd)
  {
    super(paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = null;
    if (paramBoolean) {
      str = paramBundle.getString("pskey", null);
    }
    if (this.a != null) {
      this.a.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apun
 * JD-Core Version:    0.7.0.1
 */