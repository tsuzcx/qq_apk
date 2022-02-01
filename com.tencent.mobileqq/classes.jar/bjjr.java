import android.os.Bundle;

class bjjr
  implements bjmr
{
  bjjr(bjjq parambjjq) {}
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    bjko.b("DownloadManagerV2", "receive get code finished pkgName|" + paramString1 + " versionCode|" + paramInt + " code|" + paramString2 + " extraData|" + paramBundle);
    Bundle localBundle = new Bundle();
    localBundle.putString("PackageName", paramString1);
    localBundle.putString("Code", paramString2);
    localBundle.putInt("VersionCode", paramInt);
    localBundle.putBoolean("IsSuccess", paramBoolean);
    localBundle.putAll(paramBundle);
    bjjq.a(this.a, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjjr
 * JD-Core Version:    0.7.0.1
 */