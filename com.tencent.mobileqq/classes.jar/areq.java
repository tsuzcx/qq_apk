import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader.1;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import java.util.concurrent.Executor;

public abstract class areq
  implements ared, IExcitingTransferRecvListener
{
  protected long a;
  protected aref a;
  public arqx a;
  private ExcitingTransferDownloadReqInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo = new ExcitingTransferDownloadReqInfo();
  private boolean jdField_a_of_type_Boolean = true;
  
  public areq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Aref = a(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  protected abstract aref a(QQAppInterface paramQQAppInterface);
  
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
  
  public void aA_()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      arsd.a().execute(new BaseDownloader.1(this));
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
    this.jdField_a_of_type_Aref.a();
  }
  
  public void d()
  {
    b();
    this.jdField_a_of_type_Aref.b();
  }
  
  public void e()
  {
    b();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Long = ExcitingTransferEngine.getInstance().recvFileEx(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo, areh.a().b(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     areq
 * JD-Core Version:    0.7.0.1
 */