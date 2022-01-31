import android.content.Context;
import com.tencent.wifisdk.TMSDKCustomConfig.IInstaller;

final class bevm
  implements TMSDKCustomConfig.IInstaller
{
  public boolean installApp(Context paramContext, String paramString)
  {
    return bfij.a(paramContext, paramString, "biz_src_wifi");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevm
 * JD-Core Version:    0.7.0.1
 */