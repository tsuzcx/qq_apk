import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;

public class aurx
  extends ayxn
{
  ayrv jdField_a_of_type_Ayrv;
  PrecoverResource jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  
  public aurx(QQAppInterface paramQQAppInterface, PrecoverResource paramPrecoverResource, ayrv paramayrv)
  {
    super(paramQQAppInterface, paramPrecoverResource.md5);
    this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource = paramPrecoverResource;
    this.jdField_a_of_type_Ayrv = paramayrv;
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realCancel");
    }
    aurt localaurt = (aurt)this.app.getManager(179);
    if ((localaurt != null) && (localaurt.a() != null)) {
      localaurt.a().a(this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource.md5);
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realStart");
    }
    aurt localaurt = (aurt)this.app.getManager(179);
    if ((localaurt != null) && (localaurt.a() != null)) {
      localaurt.a().a(this);
    }
  }
  
  public String toString()
  {
    return "[DownloadTask] req=" + this.jdField_a_of_type_Ayrv + ", res=" + this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aurx
 * JD-Core Version:    0.7.0.1
 */