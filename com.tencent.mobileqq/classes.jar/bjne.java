import android.os.Bundle;

class bjne
  implements bjmr
{
  bjne(bjna parambjna) {}
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    bjko.c("DownloadManager_", "receive get code finished pkgName|" + paramString1 + " versionCode|" + paramInt + " code|" + paramString2 + " extraData|" + paramBundle);
    paramBundle = new Bundle();
    paramBundle.putString("PackageName", paramString1);
    paramBundle.putString("Code", paramString2);
    paramBundle.putInt("VersionCode", paramInt);
    paramBundle.putBoolean("IsSuccess", paramBoolean);
    bjna.a(this.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjne
 * JD-Core Version:    0.7.0.1
 */