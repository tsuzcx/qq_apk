import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.provider.LocalPhotoGroupData;
import java.util.ArrayList;

final class bcsr
  implements bmfh
{
  bcsr(QQAppInterface paramQQAppInterface) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data")))
    {
      QLog.e("[PhotoAlbum]QZoneReport", 1, "onWebEvent data == null || !data.containsKey(\"data\")");
      return;
    }
    paramBundle = paramBundle.getBundle("data");
    if (paramBundle == null)
    {
      QLog.e("[PhotoAlbum]QZoneReport", 1, "onWebEvent getTravelGroup bundle is empty");
      return;
    }
    boolean bool;
    if ("cmd.getTravelGroup".equals(paramString))
    {
      QLog.i("[PhotoAlbum]QZoneReport", 1, "onWebEvent CMD_GET_TRAVEL_GROUP");
      paramString = (LocalPhotoGroupData)paramBundle.getSerializable("groupData");
      if ((paramString == null) || (paramString.pathList == null) || (paramString.pathList.size() == 0))
      {
        QLog.i("[PhotoAlbum]QZoneReport", 1, "onWebEvent localPhotoGroupData == null");
        bool = false;
      }
    }
    for (;;)
    {
      bcsq.a(this.a, bool);
      bmfd.a().b(this);
      return;
      QLog.i("[PhotoAlbum]QZoneReport", 1, "onWebEvent localPhotoGroupData:" + paramString.toString());
      LocalMultiProcConfig.putLong("SP_LAST_UPDATE_TIME", paramString.startTime);
      bool = true;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsr
 * JD-Core Version:    0.7.0.1
 */