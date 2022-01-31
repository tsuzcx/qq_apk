import android.support.annotation.NonNull;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class araz
{
  private final String jdField_a_of_type_JavaLangString;
  private final List<ExcitingTransferHostInfo> jdField_a_of_type_JavaUtilList;
  private final boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final List<ExcitingTransferHostInfo> b;
  
  public araz(List<ExcitingTransferHostInfo> paramList1, List<ExcitingTransferHostInfo> paramList2, boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<ExcitingTransferHostInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ExcitingTransfer.SvrInfo<FileAssistant>", 2, "support https but mstrSSLName is null");
      }
      return false;
    }
    return true;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public List<ExcitingTransferHostInfo> b()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NonNull
  public String toString()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    ExcitingTransferHostInfo localExcitingTransferHostInfo;
    for (Object localObject = "IPV4:"; localIterator.hasNext(); localObject = (String)localObject + "[" + localExcitingTransferHostInfo.mstrIp + ":" + localExcitingTransferHostInfo.mport + "] ") {
      localExcitingTransferHostInfo = (ExcitingTransferHostInfo)localIterator.next();
    }
    localObject = (String)localObject + " -- IPV6:";
    localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      localExcitingTransferHostInfo = (ExcitingTransferHostInfo)localIterator.next();
      localObject = (String)localObject + "[" + localExcitingTransferHostInfo.mstrIp + ":" + localExcitingTransferHostInfo.mport + "] ";
    }
    localObject = new StringBuilder().append((String)localObject).append(" strSSLCName:").append(this.jdField_a_of_type_JavaLangString).append(" bSupportHttps:").append(this.jdField_a_of_type_Boolean).append(" busniEx len:");
    if (this.jdField_a_of_type_ArrayOfByte != null) {}
    for (int i = this.jdField_a_of_type_ArrayOfByte.length;; i = 0) {
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     araz
 * JD-Core Version:    0.7.0.1
 */