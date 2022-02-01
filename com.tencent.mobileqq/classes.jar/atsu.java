import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class atsu
  extends atsq
  implements bfnz
{
  protected bfoa a;
  protected ExcitingTransferUploadResultRp a;
  protected String b = "";
  
  private atsu(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, atsv paramatsv, atsw paramatsw)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, 1, paramatsv, paramatsw);
  }
  
  public static bfnz a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, atsv paramatsv, atsw paramatsw)
  {
    if (paramatsv == null) {
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
          if (paramatsw != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is null");
        return null;
        if (paramatsv.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is err");
      return null;
      if (paramatsw.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is err");
    return null;
    return new atsu(paramQQAppInterface, paramLong1, paramLong2, paramatsv, paramatsw);
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
    return atrv.a().b();
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
    if (atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3))
    {
      QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. is config enable IPv6.");
      localObject = atrv.a().a(false);
      localList = atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
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
      if (atlb.a())
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
    if (this.jdField_a_of_type_Bfoa != null) {
      this.jdField_a_of_type_Bfoa.a(paramLong1);
    }
  }
  
  public void a(bfoa parambfoa)
  {
    this.jdField_a_of_type_Bfoa = parambfoa;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo)
  {
    super.a(paramExcitingTransferUploadBizInfo);
    if ((this.jdField_a_of_type_Atst instanceof atsv))
    {
      atsv localatsv = (atsv)this.jdField_a_of_type_Atst;
      paramExcitingTransferUploadBizInfo.groupCode = localatsv.jdField_a_of_type_Long;
      paramExcitingTransferUploadBizInfo.bufUuid = localatsv.jdField_a_of_type_ArrayOfByte;
      paramExcitingTransferUploadBizInfo.bufUploadKey = localatsv.b;
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
      if (this.jdField_a_of_type_Bfoa != null) {
        this.jdField_a_of_type_Bfoa.g();
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
      if (this.jdField_a_of_type_Bfoa != null) {
        this.jdField_a_of_type_Bfoa.a(true, this.jdField_c_of_type_Long, paramInt, "", "");
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
      if (this.jdField_a_of_type_Atst != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64StartSize == this.jdField_a_of_type_Atst.a()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsu
 * JD-Core Version:    0.7.0.1
 */