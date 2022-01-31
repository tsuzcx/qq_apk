import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;

class bhbp
  implements bhot
{
  bhbp(bhbo parambhbo, UploadConfiguration.NetworkStateObserver paramNetworkStateObserver) {}
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "upload2: onNetworkConnect registerNetworkStateObserver|onNetworkConnect：" + paramBoolean);
    }
    bhbo.a(this.jdField_a_of_type_Bhbo, paramBoolean);
    this.jdField_a_of_type_ComTencentUploadCommonUploadConfiguration$NetworkStateObserver.onStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhbp
 * JD-Core Version:    0.7.0.1
 */