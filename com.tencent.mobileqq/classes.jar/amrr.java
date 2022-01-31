import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;

public final class amrr
  implements Runnable
{
  public amrr(long paramLong) {}
  
  public void run()
  {
    try
    {
      QLog.i("QZoneHelper", 2, "QQ清空缓存数据时的回调 onQQClearLocalCache,uin=" + this.a);
      LocalMultiProcConfig.putBool("qzone_force_refresh", true);
      LocalMultiProcConfig.putBool("qzone_first_in", true);
      QzoneOfflineCacheHelper.updataSmallGameLastCacheFinishTime(this.a, 0L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneHelper", 1, "QQ清空缓存数据时的回调 error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrr
 * JD-Core Version:    0.7.0.1
 */