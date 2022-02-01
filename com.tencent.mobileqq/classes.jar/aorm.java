import android.os.Bundle;

final class aorm
  extends aoss
{
  aorm(String paramString, aosb paramaosb)
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
 * Qualified Name:     aorm
 * JD-Core Version:    0.7.0.1
 */