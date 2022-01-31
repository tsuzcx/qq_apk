import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfC2CFileUploader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class arau
  extends arat
  implements aqtp
{
  protected aqsx a;
  protected ExcitingTransferUploadResultRp a;
  protected Timer a;
  protected String b;
  protected boolean b;
  
  private arau(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, arav paramarav, araz paramaraz)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, 0, paramarav, paramaraz);
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static int a(int paramInt)
  {
    int i = 9004;
    switch (paramInt)
    {
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    default: 
      i = 9001;
    case 1: 
    case 2: 
      return i;
    case 0: 
      return 0;
    case 3: 
      return 9045;
    case 4: 
      return 9052;
    case 5: 
      return 9032;
    case 6: 
      return 9052;
    case 7: 
      return 9005;
    case 8: 
      return 9003;
    case 9: 
      return 4606;
    case 10: 
      return 4606;
    case 11: 
      return 9001;
    case 12: 
      return 9052;
    case 13: 
    case 16: 
      return 9009;
    case 14: 
    case 15: 
      return 9032;
    case 17: 
      return 9001;
    case 18: 
      return 9052;
    case 19: 
    case 20: 
      return 9001;
    case 30: 
      return 9043;
    case 31: 
      return 9006;
    case 32: 
      return 9042;
    }
    return 9037;
  }
  
  public static aqtp a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, arav paramarav, araz paramaraz)
  {
    if (paramarav == null) {
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
          if (paramaraz != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is null");
        return null;
        if (paramarav.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is err");
      return null;
      if (paramaraz.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.C2CFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is err");
    return null;
    return new arau(paramQQAppInterface, paramLong1, paramLong2, paramarav, paramaraz);
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
    return aqzy.a().a();
  }
  
  public ExcitingTransferUploadResultRp a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_Aqsx != null) {
      this.jdField_a_of_type_Aqsx.a(paramLong1);
    }
  }
  
  public void a(aqsx paramaqsx)
  {
    this.jdField_a_of_type_Aqsx = paramaqsx;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo)
  {
    super.a(paramExcitingTransferUploadBizInfo);
    if ((this.jdField_a_of_type_Araw instanceof arav))
    {
      arav localarav = (arav)this.jdField_a_of_type_Araw;
      paramExcitingTransferUploadBizInfo.bufUuid = localarav.a;
      paramExcitingTransferUploadBizInfo.bufUploadKey = localarav.b;
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
      if (this.jdField_a_of_type_Aqsx != null) {
        this.jdField_a_of_type_Aqsx.g();
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
    this.jdField_a_of_type_Araw.a(paramArrayOfByte);
    b();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Araw != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64StartSize == this.jdField_a_of_type_Araw.a()) {
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
    if ((this.jdField_a_of_type_Araw.d() == null) || (this.jdField_a_of_type_Araw.d().length == 0))
    {
      if (this.jdField_a_of_type_Aqsx != null)
      {
        Bundle localBundle = new Bundle();
        byte[] arrayOfByte = this.jdField_a_of_type_Aqsx.a(localBundle);
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
        this.jdField_a_of_type_Araw.a(arrayOfByte);
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
      if (this.jdField_a_of_type_Aqsx != null) {
        this.jdField_a_of_type_Aqsx.a(true, this.c, paramInt, "", "");
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
 * Qualified Name:     arau
 * JD-Core Version:    0.7.0.1
 */