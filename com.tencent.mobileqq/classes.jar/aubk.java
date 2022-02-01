import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.1;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.2;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.3;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.4;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class aubk
  implements IExcitingTransferRecvListener
{
  protected final int a;
  protected long a;
  protected final aubl a;
  private aubn a;
  protected final QQAppInterface a;
  protected ExcitingTransferDownloadCompletedInfo a;
  protected String a;
  public boolean a;
  protected int b;
  public long b;
  protected final long c;
  protected final long d;
  
  public aubk(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, aubl paramaubl)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 201;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramLong1;
    this.jdField_a_of_type_Aubl = paramaubl;
    this.c = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Long != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = 0L;
    }
    ThreadManager.post(new ExtfBaseFileDownloader.3(this, paramInt, paramExcitingTransferDownloadCompletedInfo), 5, null, false);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public ExcitingTransferDownloadCompletedInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo;
  }
  
  protected abstract ExcitingTransferDownloadConfig a();
  
  protected ExcitingTransferDownloadReqInfo a()
  {
    ExcitingTransferDownloadReqInfo localExcitingTransferDownloadReqInfo = new ExcitingTransferDownloadReqInfo();
    if (this.jdField_a_of_type_Aubl != null)
    {
      localExcitingTransferDownloadReqInfo.fileSize = this.jdField_a_of_type_Aubl.a();
      localExcitingTransferDownloadReqInfo.md5 = this.jdField_a_of_type_Aubl.a();
      localExcitingTransferDownloadReqInfo.isSupportHttps = this.jdField_a_of_type_Aubl.b();
      localExcitingTransferDownloadReqInfo.sslCName = this.jdField_a_of_type_Aubl.d();
      localExcitingTransferDownloadReqInfo.strFileName = this.jdField_a_of_type_Aubl.a();
      if (this.jdField_a_of_type_Aubl.a() != null) {
        localExcitingTransferDownloadReqInfo.mHosts = ((ExcitingTransferHostInfo[])this.jdField_a_of_type_Aubl.a().toArray(new ExcitingTransferHostInfo[this.jdField_a_of_type_Aubl.a().size()]));
      }
      localExcitingTransferDownloadReqInfo.strFileName = this.jdField_a_of_type_Aubl.a();
      localExcitingTransferDownloadReqInfo.serverPath = this.jdField_a_of_type_Aubl.b();
    }
    for (;;)
    {
      localExcitingTransferDownloadReqInfo.strCookie = c();
      localExcitingTransferDownloadReqInfo.strTempFilePath = b();
      localExcitingTransferDownloadReqInfo.strSaveFileDir = a();
      a(localExcitingTransferDownloadReqInfo);
      return localExcitingTransferDownloadReqInfo;
      QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.d + "] getDownloadInfo mFileInfo = null ^^^^");
    }
  }
  
  protected String a()
  {
    return aumo.a().b();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.d + "] stopDownloadFile ^^^^");
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Long == 0L);
    ExcitingTransferEngine.getInstance().cancelRecvFile(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.d + "] *_* *_* onFailure errcode:" + paramInt);
    if (this.jdField_a_of_type_Aubn != null) {
      this.jdField_a_of_type_Aubn.a(paramInt, paramExcitingTransferDownloadCompletedInfo);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Aubn != null) {
      this.jdField_a_of_type_Aubn.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void a(aubn paramaubn)
  {
    this.jdField_a_of_type_Aubn = paramaubn;
  }
  
  public void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.d + "] ^_^ ^_^ onSuccess");
    if (this.jdField_a_of_type_Aubn != null) {
      this.jdField_a_of_type_Aubn.a(0, paramExcitingTransferDownloadCompletedInfo);
    }
  }
  
  protected void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo) {}
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 201;
    ExcitingTransferDownloadReqInfo localExcitingTransferDownloadReqInfo = a();
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.d + "] startDownloadFile >>>>");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.d + "] reqInfo   = {" + localExcitingTransferDownloadReqInfo.toString() + "}");
    long l = ExcitingTransferEngine.getInstance().recvFileEx(localExcitingTransferDownloadReqInfo, a(), this);
    if (l == -1L)
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.d + "] startDownloadFile fail");
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = l;
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.d + "] startDownloadFile excitingId:" + this.jdField_a_of_type_Long);
    return true;
  }
  
  protected abstract String b();
  
  protected String c()
  {
    if (this.jdField_a_of_type_Aubl != null) {
      return "Cookie:t=0;v=" + AppSetting.a() + ";" + this.jdField_a_of_type_Aubl.c() + ";\r\n";
    }
    return "";
  }
  
  public void onOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Id[").append(this.d).append("] ^_^ OnOneSlotComplete:").append(paramInt).append(" RP:");
    if (paramExcitingTransferOneSlotComplete != null)
    {
      str = paramExcitingTransferOneSlotComplete.toString();
      label52:
      QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, str);
      if (paramExcitingTransferOneSlotComplete == null) {
        break label106;
      }
    }
    label106:
    for (String str = paramExcitingTransferOneSlotComplete.m_strIp;; str = "")
    {
      this.jdField_a_of_type_JavaLangString = str;
      if (this.jdField_a_of_type_Aubn == null) {
        break;
      }
      this.jdField_a_of_type_Aubn.a(paramInt, paramExcitingTransferOneSlotComplete);
      return;
      str = "";
      break label52;
    }
  }
  
  public void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      StringBuilder localStringBuilder = new StringBuilder().append("Id[").append(this.d).append("] onExcitingDownloadResult suc:").append(bool).append(" errcode:").append(paramInt).append(" RP:");
      if (paramExcitingTransferDownloadCompletedInfo == null) {
        break label163;
      }
      str = paramExcitingTransferDownloadCompletedInfo.toString();
      label69:
      QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, str);
      if ((bool) && (this.jdField_a_of_type_Aubl != null)) {
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Aubl.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo;
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Long = 0L;
      if (paramExcitingTransferDownloadCompletedInfo == null) {
        break label170;
      }
    }
    label163:
    label170:
    for (String str = paramExcitingTransferDownloadCompletedInfo.m_strLastServerHost;; str = "")
    {
      this.jdField_a_of_type_JavaLangString = str;
      if (!bool) {
        break label177;
      }
      ThreadManager.post(new ExtfBaseFileDownloader.2(this, paramExcitingTransferDownloadCompletedInfo), 5, null, false);
      return;
      bool = false;
      break;
      str = "";
      break label69;
    }
    label177:
    b(paramInt, paramExcitingTransferDownloadCompletedInfo);
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Long = paramLong2;
    ThreadManager.post(new ExtfBaseFileDownloader.1(this, paramLong1, paramLong3), 5, null, false);
  }
  
  public void onRecvStart()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, "Id[" + this.d + "] onExcitingSendStart.");
    } while (this.jdField_a_of_type_Aubn == null);
    this.jdField_a_of_type_Aubn.a();
  }
  
  public void onSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.post(new ExtfBaseFileDownloader.4(this, paramExcitingTransferDownloadSpeedInfo), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubk
 * JD-Core Version:    0.7.0.1
 */