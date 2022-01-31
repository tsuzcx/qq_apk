import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.provider.LocalPhotoGroupData;

final class awqv
  implements bgcc
{
  awqv(QQAppInterface paramQQAppInterface) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data")))
    {
      QLog.e("QZoneReport", 1, "onWebEvent data == null || !data.containsKey(\"data\")");
      return;
    }
    paramBundle = paramBundle.getBundle("data");
    if (paramBundle == null)
    {
      QLog.e("QZoneReport", 1, "onWebEvent getTravelGroup bundle is empty");
      return;
    }
    boolean bool;
    if ("cmd.getTravelGroup".equals(paramString))
    {
      QLog.i("QZoneReport", 1, "onWebEvent CMD_GET_TRAVEL_GROUP");
      paramString = (LocalPhotoGroupData)paramBundle.getSerializable("groupData");
      if (paramString == null)
      {
        QLog.i("QZoneReport", 1, "onWebEvent localPhotoGroupData == null");
        bool = false;
      }
    }
    for (;;)
    {
      awqu.a(this.a, bool);
      bgbz.a().b(this);
      return;
      QLog.i("QZoneReport", 1, "onWebEvent localPhotoGroupData:" + paramString.toString());
      bool = true;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awqv
 * JD-Core Version:    0.7.0.1
 */