import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;

class bmwl
  implements bnjy
{
  bmwl(bmwk parambmwk, UploadConfiguration.NetworkStateObserver paramNetworkStateObserver) {}
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "upload2: onNetworkConnect registerNetworkStateObserver|onNetworkConnect：" + paramBoolean);
    }
    bmwk.a(this.jdField_a_of_type_Bmwk, paramBoolean);
    this.jdField_a_of_type_ComTencentUploadCommonUploadConfiguration$NetworkStateObserver.onStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwl
 * JD-Core Version:    0.7.0.1
 */