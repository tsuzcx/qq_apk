import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.observer.QZoneObserver.1;
import com.tencent.mobileqq.observer.QZoneObserver.2;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class axkw
  implements BusinessObserver
{
  public static final int QZONE_GET_ALBUM_LIST_NUM = 1002;
  public static final int QZONE_GET_BIRTHDAY_DATA = 1009;
  public static final int QZONE_GET_FEEDLIST_INFO = 1003;
  public static final int QZONE_GET_GROUP_COUNT = 1006;
  public static final int QZONE_GET_NESTED_STORY_FEED = 1010;
  public static final int QZONE_GET_NEWEST_FEED = 1001;
  public static final int QZONE_GET_PUBLIC_MSG = 1004;
  public static final int QZONE_GET_PUBLIC_MSG_V2 = 1005;
  public static final int QZONE_GET_QBOSS_DATA = 1007;
  public static final int QZONE_GET_UNREAD = 1000;
  public static final int QZONE_REPORT_QBOSS = 1008;
  public static final String SQDYMAIC = "sqDyncFeedsJson";
  public static final String TAG = "UndealCount.QZoneObserver";
  
  protected void onGetBirthDayNoticeData(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetGroupEntrance(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetNewestStoryFeed(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetQZoneAlbumListNum(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetQZoneFeedCountFin(boolean paramBoolean1, boolean paramBoolean2, long paramLong) {}
  
  public void onGetQZoneNewestFeed(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onGetQbossData(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetQzoneFeedListInfo(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetQzonePublicMsg(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetQzonePublicMsgV2(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1000)
    {
      boolean bool = paramBundle.getBoolean("new");
      long l = paramBundle.getLong("notify_type", 0L);
      if (QLog.isColorLevel())
      {
        if ((l >>> 17 & 1L) != 0L) {
          QLog.d("ZebraAlbum.UndealCount.QZoneObserver", 2, "onReceive QZONE_GET_UNREAD hasNew: " + bool + "type:" + l + "and then call onGetQZoneFeedCountFin");
        }
        QLog.d("UndealCount.UndealCount.QZoneObserver", 2, "qzone redtypeinfo:onReceive QZONE_GET_UNREAD hasNew: " + bool + ",type:" + l + " and then call onGetQZoneFeedCountFin");
      }
      onGetQZoneFeedCountFin(paramBoolean, bool, l);
    }
    do
    {
      return;
      if (paramInt == 1001)
      {
        ThreadManagerV2.executeOnSubThread(new QZoneObserver.1(this, paramBoolean, paramBundle));
        return;
      }
      if (paramInt == 1002)
      {
        onGetQZoneAlbumListNum(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1003)
      {
        onGetQzoneFeedListInfo(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1004)
      {
        onGetQzonePublicMsg(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1005)
      {
        onGetQzonePublicMsgV2(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1006)
      {
        onGetGroupEntrance(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1007)
      {
        ThreadManagerV2.executeOnSubThread(new QZoneObserver.2(this, paramBoolean, paramBundle));
        return;
      }
      if (paramInt == 1008)
      {
        onReportQbossResponse(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1009)
      {
        onGetBirthDayNoticeData(paramBoolean, paramBundle);
        return;
      }
    } while (paramInt != 1010);
    onGetNewestStoryFeed(paramBoolean, paramBundle);
  }
  
  protected void onReportQbossResponse(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkw
 * JD-Core Version:    0.7.0.1
 */