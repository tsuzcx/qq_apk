import android.os.Bundle;

class bjta
  implements bjwh
{
  bjta(bjsz parambjsz) {}
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    bjtx.b("DownloadManagerV2", "receive get code finished pkgName|" + paramString1 + " versionCode|" + paramInt + " code|" + paramString2 + " extraData|" + paramBundle);
    Bundle localBundle = new Bundle();
    localBundle.putString("PackageName", paramString1);
    localBundle.putString("Code", paramString2);
    localBundle.putInt("VersionCode", paramInt);
    localBundle.putBoolean("IsSuccess", paramBoolean);
    localBundle.putAll(paramBundle);
    bjsz.a(this.a, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjta
 * JD-Core Version:    0.7.0.1
 */