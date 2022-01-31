import com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager;

public class beph
  implements besr
{
  public beph(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void a(int paramInt)
  {
    besl.c("minisdk-start_AppBrandLaunchManager", "updateBaseLib ret=" + paramInt);
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1)
    {
      besl.c("minisdk-start_AppBrandLaunchManager", "基础库无更新.");
      return;
    }
    String str = "基础库更新失败.";
    if (paramInt == 1100) {
      str = "础库更新请求失败.";
    }
    for (;;)
    {
      besl.c("minisdk-start_AppBrandLaunchManager", str);
      return;
      if (paramInt == 1101) {
        str = "基础库下载失败.";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beph
 * JD-Core Version:    0.7.0.1
 */