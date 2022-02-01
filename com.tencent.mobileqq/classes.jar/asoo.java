import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class asoo
  extends asok
  implements begw
{
  protected begx a;
  protected ExcitingTransferUploadResultRp a;
  protected String b = "";
  
  private asoo(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, asop paramasop, asoq paramasoq)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, 1, paramasop, paramasoq);
  }
  
  public static begw a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, asop paramasop, asoq paramasoq)
  {
    if (paramasop == null) {
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
          if (paramasoq != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is null");
        return null;
        if (paramasop.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is err");
      return null;
      if (paramasoq.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is err");
    return null;
    return new asoo(paramQQAppInterface, paramLong1, paramLong2, paramasop, paramasoq);
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
    return asnp.a().b();
  }
  
  public ExcitingTransferUploadResultRp a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
  }
  
  public String a()
  {
    return this.b;
  }
  
  protected List<ExcitingTransferHostInfo> a()
  {
    Object localObject;
    List localList;
    if (asgv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3))
    {
      QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. is config enable IPv6.");
      localObject = asnp.a().a(false);
      localList = asgv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
      if (localList != null)
      {
        if (localObject != null) {
          break label162;
        }
        localObject = new ArrayList();
      }
    }
    label162:
    for (;;)
    {
      if (asgv.a())
      {
        QLog.d("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. debugIsDisableIPv4OnDoubleStack");
        ((List)localObject).clear();
      }
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((List)localObject).add(0, (ExcitingTransferHostInfo)localList.get(i));
        i -= 1;
      }
      this.jdField_c_of_type_Int = 2;
      QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. use IPv6. hostlist:" + localObject.toString());
      return localObject;
      this.jdField_c_of_type_Int = 1;
      return localObject;
      return super.a();
    }
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
    if (this.jdField_a_of_type_Begx != null) {
      this.jdField_a_of_type_Begx.a(paramLong1);
    }
  }
  
  public void a(begx parambegx)
  {
    this.jdField_a_of_type_Begx = parambegx;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo)
  {
    super.a(paramExcitingTransferUploadBizInfo);
    if ((this.jdField_a_of_type_Ason instanceof asop))
    {
      asop localasop = (asop)this.jdField_a_of_type_Ason;
      paramExcitingTransferUploadBizInfo.groupCode = localasop.jdField_a_of_type_Long;
      paramExcitingTransferUploadBizInfo.bufUuid = localasop.jdField_a_of_type_ArrayOfByte;
      paramExcitingTransferUploadBizInfo.bufUploadKey = localasop.b;
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
      if (this.jdField_a_of_type_Begx != null) {
        this.jdField_a_of_type_Begx.g();
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
      if (this.jdField_a_of_type_Begx != null) {
        this.jdField_a_of_type_Begx.a(true, this.jdField_c_of_type_Long, paramInt, "", "");
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
      if (this.jdField_a_of_type_Ason != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64StartSize == this.jdField_a_of_type_Ason.a()) {
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
  
  public int h()
  {
    return 0;
  }
  
  public void onExcitingSubSenderResult(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    if (paramExcitingTransferUploaderRp != null) {}
    for (String str = paramExcitingTransferUploaderRp.m_strFileUrl;; str = "")
    {
      this.b = str;
      super.onExcitingSubSenderResult(paramInt, paramExcitingTransferUploaderRp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoo
 * JD-Core Version:    0.7.0.1
 */