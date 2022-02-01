import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;

public class atep
{
  private final blgh jdField_a_of_type_Blgh;
  private final UploadManager.IUploadStatusListener jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadManager$IUploadStatusListener;
  private final Object jdField_a_of_type_JavaLangObject;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private String b;
  
  public atep(String paramString, Object paramObject, boolean paramBoolean, UploadManager.IUploadStatusListener paramIUploadStatusListener, blgh paramblgh)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadManager$IUploadStatusListener = paramIUploadStatusListener;
    this.jdField_a_of_type_Blgh = paramblgh;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      WeiyunTransmissionGlobal.getInstance().getUploadManager().removeJob(this.jdField_a_of_type_JavaLangString);
      return;
    }
    blfu.a().a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atep
 * JD-Core Version:    0.7.0.1
 */