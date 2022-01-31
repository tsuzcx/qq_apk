import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;

public class aurz
  extends ayxp
{
  ayrx jdField_a_of_type_Ayrx;
  PrecoverResource jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  
  public aurz(QQAppInterface paramQQAppInterface, PrecoverResource paramPrecoverResource, ayrx paramayrx)
  {
    super(paramQQAppInterface, paramPrecoverResource.md5);
    this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource = paramPrecoverResource;
    this.jdField_a_of_type_Ayrx = paramayrx;
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realCancel");
    }
    aurv localaurv = (aurv)this.app.getManager(179);
    if ((localaurv != null) && (localaurv.a() != null)) {
      localaurv.a().a(this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource.md5);
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realStart");
    }
    aurv localaurv = (aurv)this.app.getManager(179);
    if ((localaurv != null) && (localaurv.a() != null)) {
      localaurv.a().a(this);
    }
  }
  
  public String toString()
  {
    return "[DownloadTask] req=" + this.jdField_a_of_type_Ayrx + ", res=" + this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aurz
 * JD-Core Version:    0.7.0.1
 */