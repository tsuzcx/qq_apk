import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class atsb
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private List<ExcitingTransferHostInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b;
  private String c;
  private String d;
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<ExcitingTransferHostInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<ExcitingTransferHostInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "mFilePath is null");
      return false;
    }
    if (0L == this.jdField_a_of_type_Long)
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "mFileSize is 0");
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "hostList is null");
      return false;
    }
    if (TextUtils.isEmpty(this.b))
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "serverPath is null");
      return false;
    }
    if (TextUtils.isEmpty(this.c))
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "strCookie is null");
      return false;
    }
    return true;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsb
 * JD-Core Version:    0.7.0.1
 */