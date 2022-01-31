import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;

class bjhd
  implements bjul
{
  bjhd(bjhc parambjhc, UploadConfiguration.NetworkStateObserver paramNetworkStateObserver) {}
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "upload2: onNetworkConnect registerNetworkStateObserver|onNetworkConnect：" + paramBoolean);
    }
    bjhc.a(this.jdField_a_of_type_Bjhc, paramBoolean);
    this.jdField_a_of_type_ComTencentUploadCommonUploadConfiguration$NetworkStateObserver.onStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjhd
 * JD-Core Version:    0.7.0.1
 */