import android.os.Bundle;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfC2CFileUploader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class asol
  extends asok
  implements asic
{
  private static SparseIntArray a;
  protected ashs a;
  protected ExcitingTransferUploadResultRp a;
  protected Timer a;
  protected String b;
  protected boolean b;
  
  private asol(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, asom paramasom, asoq paramasoq)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, 0, paramasom, paramasoq);
    this.jdField_b_of_type_JavaLangString = "";
    f();
  }
  
  public static int a(int paramInt)
  {
    return jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, 9001);
  }
  
  public static asic a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, asom paramasom, asoq paramasoq)
  {
    if (paramasom == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is null");
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
        QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is null");
        return null;
        if (paramasom.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is err");
      return null;
      if (paramasoq.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is err");
    return null;
    return new asol(paramQQAppInterface, paramLong1, paramLong2, paramasom, paramasoq);
  }
  
  private void b(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = paramExcitingTransferUploadResultRp;
  }
  
  private void d()
  {
    try
    {
      QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.d + "] need to wait sha calc done");
      e();
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new ExtfC2CFileUploader.1(this), 120000L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void e()
  {
    try
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.d + "] cancel wait sha calc");
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    if (jdField_a_of_type_AndroidUtilSparseIntArray == null) {
      jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    }
    jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 0);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 9004);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 9004);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 9045);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(4, 9052);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(5, 9032);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(6, 9052);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(7, 9005);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(8, 9003);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(9, 4606);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10, 4606);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(11, 9001);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(12, 9052);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(13, 9009);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(16, 9009);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(14, 9032);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(15, 9032);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(17, 9001);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(18, 9052);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(19, 9001);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(20, 9001);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(30, 9043);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(31, 9006);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(32, 9042);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(33, 9037);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null) {
      return (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uIpChangeCount;
    }
    return f();
  }
  
  public long a()
  {
    return c();
  }
  
  protected ExcitingTransferUploadChnConfigInfo a()
  {
    return asnp.a().a();
  }
  
  public ExcitingTransferUploadResultRp a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected List<ExcitingTransferHostInfo> a()
  {
    Object localObject;
    List localList;
    if (asgv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1))
    {
      QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "[IPv6-File] exciting offlinefile upload. is config enable IPv6.");
      localObject = asnp.a().a(false);
      localList = asgv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
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
        QLog.d("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "[IPv6-File] exciting offlinefile upload. debugIsDisableIPv4OnDoubleStack");
        ((List)localObject).clear();
      }
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((List)localObject).add(0, (ExcitingTransferHostInfo)localList.get(i));
        i -= 1;
      }
      this.jdField_c_of_type_Int = 2;
      QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "[IPv6-File] exciting offlinefile upload. use IPv6. iplist:" + localObject.toString());
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
    QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.d + "] cancelTask");
    e();
    b();
    b(null);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    super.a(paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_Ashs != null) {
      this.jdField_a_of_type_Ashs.a(paramLong1);
    }
  }
  
  public void a(ashs paramashs)
  {
    this.jdField_a_of_type_Ashs = paramashs;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo)
  {
    super.a(paramExcitingTransferUploadBizInfo);
    if ((this.jdField_a_of_type_Ason instanceof asom))
    {
      asom localasom = (asom)this.jdField_a_of_type_Ason;
      paramExcitingTransferUploadBizInfo.bufUuid = localasom.jdField_a_of_type_ArrayOfByte;
      paramExcitingTransferUploadBizInfo.bufUploadKey = localasom.b;
      paramExcitingTransferUploadBizInfo.bUseMediaPlatform = localasom.jdField_a_of_type_Boolean;
      return;
    }
    QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.d + "] onGetOtherSendBusInfo. no other info");
  }
  
  protected void a(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    super.a(paramExcitingTransferUploadResultRp);
    if (paramExcitingTransferUploadResultRp != null) {}
    for (String str = paramExcitingTransferUploadResultRp.m_strFileUrl;; str = "")
    {
      this.jdField_b_of_type_JavaLangString = str;
      b(paramExcitingTransferUploadResultRp);
      if (this.jdField_a_of_type_Ashs != null) {
        this.jdField_a_of_type_Ashs.g();
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.d + "] onFullShaCalcDone...");
    e();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      a(-2, null);
      return;
    }
    this.jdField_a_of_type_Ason.a(paramArrayOfByte);
    b();
  }
  
  public boolean a()
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
  
  public boolean a(long paramLong)
  {
    QLog.i("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.d + "] sendFile pos:" + paramLong);
    this.jdField_a_of_type_Boolean = false;
    c();
    e();
    b(null);
    if ((this.jdField_a_of_type_Ason.d() == null) || (this.jdField_a_of_type_Ason.d().length == 0))
    {
      if (this.jdField_a_of_type_Ashs != null)
      {
        Bundle localBundle = new Bundle();
        byte[] arrayOfByte = this.jdField_a_of_type_Ashs.a(localBundle);
        if ((arrayOfByte == null) || (arrayOfByte.length == 0))
        {
          int i = localBundle.getInt("_shaCalcProgress_", 0);
          if (i == 1)
          {
            d();
            return true;
          }
          this.jdField_a_of_type_Boolean = true;
          QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.d + "] sendFile fail. fullsha calc fail or none. " + i);
          return false;
        }
        this.jdField_a_of_type_Ason.a(arrayOfByte);
      }
    }
    else {
      return b();
    }
    this.jdField_a_of_type_Boolean = true;
    QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 1, "Id[" + this.d + "] sendFile fail. fullsha can not get");
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null) {
      return (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uRetryCount;
    }
    return 0;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64StartSize;
    }
    return 0L;
  }
  
  protected void b(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    super.b(paramInt, paramExcitingTransferUploadResultRp);
    if (paramExcitingTransferUploadResultRp != null) {}
    for (String str = paramExcitingTransferUploadResultRp.m_strFileUrl;; str = "")
    {
      this.jdField_b_of_type_JavaLangString = str;
      b(paramExcitingTransferUploadResultRp);
      paramInt = a(paramInt);
      if (this.jdField_a_of_type_Ashs != null) {
        this.jdField_a_of_type_Ashs.a(true, this.jdField_c_of_type_Long, paramInt, "", "");
      }
      return;
    }
  }
  
  protected int c()
  {
    return 69;
  }
  
  protected int d()
  {
    return 0;
  }
  
  protected int e()
  {
    return 3;
  }
  
  public void onExcitingSubSenderResult(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    if (paramExcitingTransferUploaderRp != null) {}
    for (String str = paramExcitingTransferUploaderRp.m_strFileUrl;; str = "")
    {
      this.jdField_b_of_type_JavaLangString = str;
      super.onExcitingSubSenderResult(paramInt, paramExcitingTransferUploaderRp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asol
 * JD-Core Version:    0.7.0.1
 */