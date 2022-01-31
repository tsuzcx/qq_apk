import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;

public class attz
  extends axxg
{
  axro jdField_a_of_type_Axro;
  PrecoverResource jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  
  public attz(QQAppInterface paramQQAppInterface, PrecoverResource paramPrecoverResource, axro paramaxro)
  {
    super(paramQQAppInterface, paramPrecoverResource.md5);
    this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource = paramPrecoverResource;
    this.jdField_a_of_type_Axro = paramaxro;
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realCancel");
    }
    attv localattv = (attv)this.app.getManager(179);
    if ((localattv != null) && (localattv.a() != null)) {
      localattv.a().a(this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource.md5);
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realStart");
    }
    attv localattv = (attv)this.app.getManager(179);
    if ((localattv != null) && (localattv.a() != null)) {
      localattv.a().a(this);
    }
  }
  
  public String toString()
  {
    return "[DownloadTask] req=" + this.jdField_a_of_type_Axro + ", res=" + this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     attz
 * JD-Core Version:    0.7.0.1
 */