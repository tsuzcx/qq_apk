import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.qphone.base.util.QLog;

public class arfg
  extends arfc
  implements bbxg
{
  protected bbxh a;
  protected ExcitingTransferUploadResultRp a;
  protected String b = "";
  
  private arfg(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, arfh paramarfh, arfi paramarfi)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, 1, paramarfh, paramarfi);
  }
  
  public static bbxg a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, arfh paramarfh, arfi paramarfi)
  {
    if (paramarfh == null) {
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
          if (paramarfi != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is null");
        return null;
        if (paramarfh.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is err");
      return null;
      if (paramarfi.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is err");
    return null;
    return new arfg(paramQQAppInterface, paramLong1, paramLong2, paramarfh, paramarfi);
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
    return areh.a().b();
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
    if (this.jdField_a_of_type_Bbxh != null) {
      this.jdField_a_of_type_Bbxh.a(paramLong1);
    }
  }
  
  public void a(bbxh parambbxh)
  {
    this.jdField_a_of_type_Bbxh = parambbxh;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo)
  {
    super.a(paramExcitingTransferUploadBizInfo);
    if ((this.jdField_a_of_type_Arff instanceof arfh))
    {
      arfh localarfh = (arfh)this.jdField_a_of_type_Arff;
      paramExcitingTransferUploadBizInfo.groupCode = localarfh.jdField_a_of_type_Long;
      paramExcitingTransferUploadBizInfo.bufUuid = localarfh.jdField_a_of_type_ArrayOfByte;
      paramExcitingTransferUploadBizInfo.bufUploadKey = localarfh.b;
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
      if (this.jdField_a_of_type_Bbxh != null) {
        this.jdField_a_of_type_Bbxh.g();
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
      if (this.jdField_a_of_type_Bbxh != null) {
        this.jdField_a_of_type_Bbxh.a(true, this.c, paramInt, "", "");
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
      if (this.jdField_a_of_type_Arff != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64StartSize == this.jdField_a_of_type_Arff.a()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfg
 * JD-Core Version:    0.7.0.1
 */