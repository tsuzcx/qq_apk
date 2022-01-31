import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;

public class arbn
{
  private final bklf jdField_a_of_type_Bklf;
  private final UploadManager.IUploadStatusListener jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadManager$IUploadStatusListener;
  private final Object jdField_a_of_type_JavaLangObject;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private String b;
  
  public arbn(String paramString, Object paramObject, boolean paramBoolean, UploadManager.IUploadStatusListener paramIUploadStatusListener, bklf parambklf)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadManager$IUploadStatusListener = paramIUploadStatusListener;
    this.jdField_a_of_type_Bklf = parambklf;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      WeiyunTransmissionGlobal.getInstance().getUploadManager().removeJob(this.jdField_a_of_type_JavaLangString);
      return;
    }
    bkks.a().a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbn
 * JD-Core Version:    0.7.0.1
 */