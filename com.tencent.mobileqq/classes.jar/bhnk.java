import android.content.Context;
import com.tencent.wifisdk.TMSDKCustomConfig.IInstaller;

final class bhnk
  implements TMSDKCustomConfig.IInstaller
{
  public boolean installApp(Context paramContext, String paramString)
  {
    return biam.a(paramContext, paramString, "biz_src_wifi");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnk
 * JD-Core Version:    0.7.0.1
 */