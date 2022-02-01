import android.os.Bundle;

class bjwu
  implements bjwh
{
  bjwu(bjwq parambjwq) {}
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    bjtx.c("DownloadManager_", "receive get code finished pkgName|" + paramString1 + " versionCode|" + paramInt + " code|" + paramString2 + " extraData|" + paramBundle);
    paramBundle = new Bundle();
    paramBundle.putString("PackageName", paramString1);
    paramBundle.putString("Code", paramString2);
    paramBundle.putInt("VersionCode", paramInt);
    paramBundle.putBoolean("IsSuccess", paramBoolean);
    bjwq.a(this.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwu
 * JD-Core Version:    0.7.0.1
 */