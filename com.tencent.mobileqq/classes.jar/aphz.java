import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.qphone.base.util.QLog;

public class aphz
  extends aphv
  implements azuo
{
  protected azup a;
  protected ExcitingTransferUploadResultRp a;
  protected String b = "";
  
  private aphz(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, apia paramapia, apib paramapib)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, 1, paramapia, paramapib);
  }
  
  public static azuo a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, apia paramapia, apib paramapib)
  {
    if (paramapia == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (paramapib != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is null");
        return null;
        if (paramapia.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is err");
      return null;
      if (paramapib.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is err");
    return null;
    return new aphz(paramQQAppInterface, paramLong1, paramLong2, paramapia, paramapib);
  }
  
  private void b(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = paramExcitingTransferUploadResultRp;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null) {
      return (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uRetryCount;
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64StartSize;
    }
    return 0L;
  }
  
  protected ExcitingTransferUploadChnConfigInfo a()
  {
    return apha.a().b();
  }
  
  public ExcitingTransferUploadResultRp a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "Id[" + this.d + "] cancelTask");
    b();
    b(null);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    super.a(paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_Azup != null) {
      this.jdField_a_of_type_Azup.a(paramLong1);
    }
  }
  
  public void a(azup paramazup)
  {
    this.jdField_a_of_type_Azup = paramazup;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo)
  {
    super.a(paramExcitingTransferUploadBizInfo);
    if ((this.jdField_a_of_type_Aphy instanceof apia))
    {
      apia localapia = (apia)this.jdField_a_of_type_Aphy;
      paramExcitingTransferUploadBizInfo.groupCode = localapia.jdField_a_of_type_Long;
      paramExcitingTransferUploadBizInfo.bufUuid = localapia.jdField_a_of_type_ArrayOfByte;
      paramExcitingTransferUploadBizInfo.bufUploadKey = localapia.b;
      return;
    }
    QLog.w("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "Id[" + this.d + "] onGetOtherSendBusInfo. no other info");
  }
  
  protected void a(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    super.a(paramExcitingTransferUploadResultRp);
    if (paramExcitingTransferUploadResultRp != null) {}
    for (String str = paramExcitingTransferUploadResultRp.m_strFileUrl;; str = "")
    {
      this.b = str;
      b(paramExcitingTransferUploadResultRp);
      if (this.jdField_a_of_type_Azup != null) {
        this.jdField_a_of_type_Azup.g();
      }
      return;
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    b(null);
    return b();
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    return "";
  }
  
  protected void b(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    super.b(paramInt, paramExcitingTransferUploadResultRp);
    if (paramExcitingTransferUploadResultRp != null) {}
    for (String str = paramExcitingTransferUploadResultRp.m_strFileUrl;; str = "")
    {
      this.b = str;
      b(paramExcitingTransferUploadResultRp);
      if (this.jdField_a_of_type_Azup != null) {
        this.jdField_a_of_type_Azup.a(true, this.c, paramInt, "", "");
      }
      return;
    }
  }
  
  protected int c()
  {
    return 71;
  }
  
  public boolean c()
  {
    return false;
  }
  
  protected int d()
  {
    return 1;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Aphy != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64StartSize == this.jdField_a_of_type_Aphy.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected int e()
  {
    return 102;
  }
  
  public int g()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphz
 * JD-Core Version:    0.7.0.1
 */