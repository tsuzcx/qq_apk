import android.os.Bundle;

class bfgj
  implements bfjr
{
  bfgj(bfgi parambfgi) {}
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    bfhg.b("DownloadManagerV2", "receive get code finished pkgName|" + paramString1 + " versionCode|" + paramInt + " code|" + paramString2 + " extraData|" + paramBundle);
    Bundle localBundle = new Bundle();
    localBundle.putString("PackageName", paramString1);
    localBundle.putString("Code", paramString2);
    localBundle.putInt("VersionCode", paramInt);
    localBundle.putBoolean("IsSuccess", paramBoolean);
    localBundle.putAll(paramBundle);
    bfgi.a(this.a, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfgj
 * JD-Core Version:    0.7.0.1
 */