import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader.1;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import java.util.concurrent.Executor;

public abstract class aphj
  implements apgw, IExcitingTransferRecvListener
{
  protected long a;
  protected apgy a;
  public aptm a;
  private ExcitingTransferDownloadReqInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo = new ExcitingTransferDownloadReqInfo();
  private boolean jdField_a_of_type_Boolean = true;
  
  public aphj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Apgy = a(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  protected abstract apgy a(QQAppInterface paramQQAppInterface);
  
  public abstract void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo);
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public void aw_()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      apus.a().execute(new BaseDownloader.1(this));
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.jdField_a_of_type_Long);
      return;
    }
    finally {}
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_Apgy.a();
  }
  
  public void d()
  {
    b();
    this.jdField_a_of_type_Apgy.b();
  }
  
  public void e()
  {
    b();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Long = ExcitingTransferEngine.getInstance().recvFileEx(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo, apha.a().b(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphj
 * JD-Core Version:    0.7.0.1
 */