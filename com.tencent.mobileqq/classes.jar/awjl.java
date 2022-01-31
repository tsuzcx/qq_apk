import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;

public class awjl
  extends bavo
{
  baps jdField_a_of_type_Baps;
  PrecoverResource jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  
  public awjl(QQAppInterface paramQQAppInterface, PrecoverResource paramPrecoverResource, baps parambaps)
  {
    super(paramQQAppInterface, paramPrecoverResource.md5);
    this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource = paramPrecoverResource;
    this.jdField_a_of_type_Baps = parambaps;
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realCancel");
    }
    awjh localawjh = (awjh)this.app.getManager(179);
    if ((localawjh != null) && (localawjh.a() != null)) {
      localawjh.a().a(this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource.md5);
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "DownloadTask realStart");
    }
    awjh localawjh = (awjh)this.app.getManager(179);
    if ((localawjh != null) && (localawjh.a() != null)) {
      localawjh.a().a(this);
    }
  }
  
  public String toString()
  {
    return "[DownloadTask] req=" + this.jdField_a_of_type_Baps + ", res=" + this.jdField_a_of_type_ComTencentMobileqqDataPrecoverResource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjl
 * JD-Core Version:    0.7.0.1
 */