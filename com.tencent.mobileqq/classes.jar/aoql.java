import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aoql
{
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private final String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  private byte[] d;
  
  public aoql(String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_b_of_type_JavaLangString = paramString2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label84;
      }
    }
    label84:
    for (this.jdField_a_of_type_Long = new File(this.jdField_a_of_type_JavaLangString).length();; this.jdField_a_of_type_Long = 0L)
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
      this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
      this.c = paramArrayOfByte3;
      this.d = paramArrayOfByte4;
      return;
      this.jdField_b_of_type_JavaLangString = apck.a(paramString1);
      break;
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mFilePath is null");
      }
    }
    do
    {
      return false;
      if (0L != this.jdField_a_of_type_Long) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mFileSize is 0");
    return false;
    return true;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public byte[] c()
  {
    return this.c;
  }
  
  public byte[] d()
  {
    return this.d;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("mFilePath:").append(this.jdField_a_of_type_JavaLangString).append(" mFileName:").append(this.jdField_b_of_type_JavaLangString).append(" mFileSize:").append(this.jdField_a_of_type_Long).append(" mBufSha3:");
    if (this.c != null)
    {
      str = HexUtil.bytes2HexStr(this.c);
      localStringBuilder = localStringBuilder.append(str).append(" mBufSha:");
      if (this.d == null) {
        break label157;
      }
      str = HexUtil.bytes2HexStr(this.d);
      label90:
      localStringBuilder = localStringBuilder.append(str).append(" mBuf10MMdd5:");
      if (this.jdField_b_of_type_ArrayOfByte == null) {
        break label163;
      }
      str = HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte);
      label116:
      localStringBuilder = localStringBuilder.append(str).append(" mBufMdd5:");
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        break label169;
      }
    }
    label157:
    label163:
    label169:
    for (String str = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);; str = "")
    {
      return str;
      str = "";
      break;
      str = "";
      break label90;
      str = "";
      break label116;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoql
 * JD-Core Version:    0.7.0.1
 */