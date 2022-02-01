import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil.1;

public class bptq
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
      } while (!ShortVideoUtils.checkShortVideoSoReadyToLoad(paramAppInterface));
      ThreadManager.excute(new ShortVideoGuideUtil.1(paramAppInterface), 64, null, false);
    } while ((bnky.a(bnkt.b) == 2) || (!bczy.a().a()) || (bdee.a() == 2));
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
 * Qualified Name:     bptq
 * JD-Core Version:    0.7.0.1
 */