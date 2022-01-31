import android.os.Bundle;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.share.QZoneShareActivity;
import mqq.observer.BusinessObserver;

public class bjrp
  implements BusinessObserver
{
  public bjrp(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    synchronized (QZoneShareActivity.jdField_a_of_type_JavaLangObject)
    {
      this.a.h = false;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
          localGetAppinfoResponse.mergeFrom(paramBundle);
          this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = localGetAppinfoResponse;
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 2, "get appinfo time = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
          }
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 2, paramBundle.getMessage());
          }
        }
      }
      QZoneShareActivity.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrp
 * JD-Core Version:    0.7.0.1
 */