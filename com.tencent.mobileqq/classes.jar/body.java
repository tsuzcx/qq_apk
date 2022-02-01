import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;

public class body
{
  public static String a = "ShortVideoGuideUtil";
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.getShortVideoSoLibName() == null) {}
    do
    {
      do
      {
        return false;
        if (ShortVideoUtils.isVideoSoLibLoaded()) {
          break;
        }
        ShortVideoUtils.loadShortVideoSo(paramAppInterface);
      } while (!ShortVideoUtils.isVideoSoLibLoaded());
    } while ((AEResUtil.getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE) == 2) || (!bbtd.a().a()) || (bbxj.a() == 2));
    return true;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.getShortVideoSoLibName() == null) {}
    do
    {
      return false;
      if (ShortVideoUtils.isVideoSoLibLoaded()) {
        break;
      }
      ShortVideoUtils.loadShortVideoSo(paramAppInterface);
    } while (!ShortVideoUtils.isVideoSoLibLoaded());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     body
 * JD-Core Version:    0.7.0.1
 */