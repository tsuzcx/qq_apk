import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class arpt
  extends arpx
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public arpt(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Long = paramFileManagerEntity.nSessionId;
    this.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    this.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.e("OfflineFileControlReq<QFile>", 1, "key params is null");
      return "";
    }
    return a(this.jdField_a_of_type_Int + "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpt
 * JD-Core Version:    0.7.0.1
 */