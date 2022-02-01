import android.os.Bundle;

public final class asev
{
  public static Bundle a(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putString("callbackid", paramString2);
    localBundle.putInt("respkey", paramInt);
    localBundle.putBundle("request", paramBundle);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asev
 * JD-Core Version:    0.7.0.1
 */