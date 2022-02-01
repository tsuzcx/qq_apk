import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class avzp
  extends ayra
{
  avzp(BusinessObserver paramBusinessObserver, int paramInt) {}
  
  public void getAppConfigSuccess(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = avzo.a(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(17, false, null);
      QLog.e("FaceDetectForThirdPartyServlet", 1, "getAppConfigSuccess, but appconf is null");
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("app_id", this.jdField_a_of_type_Int);
      localBundle.putSerializable("FaceRecognition.AppConf", paramArrayOfByte);
      this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(17, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("FaceDetectForThirdPartyServlet", 2, new Object[] { "handleFaceDetectResponse succsss=", paramArrayOfByte });
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(paramInt, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzp
 * JD-Core Version:    0.7.0.1
 */