import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;

public class azux
  extends bezs
{
  beum jdField_a_of_type_Beum;
  PrecoverResource jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  
  public azux(QQAppInterface paramQQAppInterface, PrecoverResource paramPrecoverResource, beum parambeum)
  {
    super(paramQQAppInterface, paramPrecoverResource.md5);
    this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource = paramPrecoverResource;
    this.jdField_a_of_type_Beum = parambeum;
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realCancel");
    }
    azut localazut = (azut)this.app.getManager(179);
    if ((localazut != null) && (localazut.a() != null)) {
      localazut.a().a(this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource.md5);
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realStart");
    }
    azut localazut = (azut)this.app.getManager(179);
    if ((localazut != null) && (localazut.a() != null)) {
      localazut.a().a(this);
    }
  }
  
  public String toString()
  {
    return "[DownloadTask] req=" + this.jdField_a_of_type_Beum + ", res=" + this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azux
 * JD-Core Version:    0.7.0.1
 */