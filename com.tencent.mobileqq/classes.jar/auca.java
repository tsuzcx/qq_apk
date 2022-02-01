import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.ExcitingSendInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadFileEntry;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferSendListener;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfBaseFileUploader.1;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfBaseFileUploader.2;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfBaseFileUploader.3;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class auca
  implements IExcitingTransferSendListener
{
  private static long e;
  private static long f;
  protected final int a;
  protected final long a;
  protected aucd a;
  protected aucg a;
  private auch a;
  protected final QQAppInterface a;
  protected final String a;
  public boolean a;
  protected byte[] a;
  protected int b;
  protected long b;
  protected int c;
  public long c;
  protected final long d;
  
  public auca(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, aucd paramaucd, aucg paramaucg)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramLong1;
    this.jdField_a_of_type_Aucd = paramaucd;
    this.jdField_a_of_type_Aucg = paramaucg;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    a();
  }
  
  private ExcitingTransferEngine.ExcitingSendInfo a()
  {
    int j = 0;
    ExcitingTransferEngine.ExcitingSendInfo localExcitingSendInfo = new ExcitingTransferEngine.ExcitingSendInfo();
    localExcitingSendInfo.mFileEntry = new ExcitingTransferUploadFileEntry();
    localExcitingSendInfo.mFileEntry.strLocalFilePath = this.jdField_a_of_type_Aucd.a();
    localExcitingSendInfo.mFileEntry.strFileName = this.jdField_a_of_type_Aucd.b();
    localExcitingSendInfo.mFileEntry.uFileSize = this.jdField_a_of_type_Aucd.a();
    localExcitingSendInfo.mFileEntry.buf10MMd5 = this.jdField_a_of_type_Aucd.b();
    localExcitingSendInfo.mFileEntry.bufMd5 = this.jdField_a_of_type_Aucd.a();
    localExcitingSendInfo.mFileEntry.bufSha = this.jdField_a_of_type_Aucd.d();
    localExcitingSendInfo.mFileEntry.bufSha3 = this.jdField_a_of_type_Aucd.c();
    a(localExcitingSendInfo.mFileEntry);
    localExcitingSendInfo.mBusInfo = new ExcitingTransferUploadBizInfo();
    localExcitingSendInfo.mBusInfo.commandId = c();
    localExcitingSendInfo.mBusInfo.chateType = d();
    localExcitingSendInfo.mBusInfo.businessType = e();
    localExcitingSendInfo.mBusInfo.bufSig = this.jdField_a_of_type_ArrayOfByte;
    localExcitingSendInfo.mBusInfo.senderUin = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
    localExcitingSendInfo.mBusInfo.receiverUin = this.jdField_a_of_type_Long;
    localExcitingSendInfo.mBusInfo.client_type = 2;
    localExcitingSendInfo.mBusInfo.client_ver = AppSetting.g();
    localExcitingSendInfo.mBusInfo.terminal_type = 2;
    localExcitingSendInfo.mBusInfo.terminal_ver = AppSetting.f();
    Object localObject = this.jdField_a_of_type_Aucg.a();
    int i;
    ExcitingTransferHostInfo localExcitingTransferHostInfo;
    if (localObject != null)
    {
      i = ((List)localObject).size();
      if (i > 0)
      {
        localExcitingSendInfo.mBusInfo.vecFtnLanIpV4AndPorts = new ExcitingTransferHostInfo[i];
        localObject = ((List)localObject).iterator();
        i = 0;
        while (((Iterator)localObject).hasNext())
        {
          localExcitingTransferHostInfo = (ExcitingTransferHostInfo)((Iterator)localObject).next();
          localExcitingSendInfo.mBusInfo.vecFtnLanIpV4AndPorts[i] = localExcitingTransferHostInfo;
          i += 1;
        }
      }
    }
    localObject = this.jdField_a_of_type_Aucg.b();
    if (localObject != null)
    {
      i = ((List)localObject).size();
      if (i > 0)
      {
        localExcitingSendInfo.mBusInfo.vecFtnLanIpV6AndPorts = new ExcitingTransferHostInfo[i];
        localObject = ((List)localObject).iterator();
        i = 0;
        while (((Iterator)localObject).hasNext())
        {
          localExcitingTransferHostInfo = (ExcitingTransferHostInfo)((Iterator)localObject).next();
          localExcitingSendInfo.mBusInfo.vecFtnLanIpV6AndPorts[i] = localExcitingTransferHostInfo;
          i += 1;
        }
      }
    }
    localExcitingSendInfo.mBusInfo.bufBusinessExt = this.jdField_a_of_type_Aucg.a();
    a(localExcitingSendInfo.mBusInfo);
    localExcitingSendInfo.mReqInfo = new ExcitingTransferUploadReqInfo();
    localObject = a();
    if (localObject != null)
    {
      if (((List)localObject).size() > 4) {}
      for (i = 4;; i = ((List)localObject).size())
      {
        localExcitingSendInfo.mReqInfo.vecSrvIpAndPorts = new ExcitingTransferHostInfo[i];
        while (j < i)
        {
          localExcitingTransferHostInfo = (ExcitingTransferHostInfo)((List)localObject).get(j);
          localExcitingSendInfo.mReqInfo.vecSrvIpAndPorts[j] = localExcitingTransferHostInfo;
          j += 1;
        }
      }
    }
    localExcitingSendInfo.mReqInfo.bSupportHttps = this.jdField_a_of_type_Aucg.b();
    localExcitingSendInfo.mReqInfo.strSSLCName = this.jdField_a_of_type_Aucg.a();
    a(localExcitingSendInfo.mReqInfo);
    localExcitingSendInfo.mConfig = a();
    return localExcitingSendInfo;
  }
  
  private void a()
  {
    try
    {
      SessionInfo localSessionInfo = SessionInfo.getInstance(this.jdField_a_of_type_JavaLangString);
      if (localSessionInfo.getHttpconn_sig_session() != null)
      {
        int i = localSessionInfo.getHttpconn_sig_session().length;
        this.jdField_a_of_type_ArrayOfByte = new byte[i];
        System.arraycopy(localSessionInfo.getHttpconn_sig_session(), 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
      }
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 0)) {
        QLog.e("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "!!!!!Id[" + this.d + "] ExtfFileUploader ERR: BigDataSig is null.!!!!!");
      }
      return;
    }
    finally {}
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while ((f >= 100L) || (l - e <= 6000L));
    e = l;
    f += 1L;
    QLog.w("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "!!!getBigDataSigFromHwSvr. count:" + f + " lastTime:" + e);
    HwServlet.getConfig(paramQQAppInterface, paramQQAppInterface.c());
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0);
  }
  
  protected abstract ExcitingTransferUploadChnConfigInfo a();
  
  protected List<ExcitingTransferHostInfo> a()
  {
    this.jdField_c_of_type_Int = 1;
    return aubf.a().a(false);
  }
  
  public void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_b_of_type_Long != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelSendFile(this.jdField_b_of_type_Long);
      this.jdField_b_of_type_Long = 0L;
    }
    ThreadManager.post(new ExtfBaseFileUploader.3(this, paramInt, paramExcitingTransferUploadResultRp), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Auch != null) {
      this.jdField_a_of_type_Auch.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void a(auch paramauch)
  {
    this.jdField_a_of_type_Auch = paramauch;
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo) {}
  
  protected void a(ExcitingTransferUploadFileEntry paramExcitingTransferUploadFileEntry) {}
  
  protected void a(ExcitingTransferUploadReqInfo paramExcitingTransferUploadReqInfo) {}
  
  public void a(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] ^_^ ^_^ onSuccess");
    if (this.jdField_a_of_type_Auch != null) {
      this.jdField_a_of_type_Auch.a(0, paramExcitingTransferUploadResultRp);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] stopSendFile^^^^");
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_b_of_type_Long == 0L);
    ExcitingTransferEngine.getInstance().cancelSendFile(this.jdField_b_of_type_Long);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void b(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    QLog.e("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] *_* *_* onFailure errcode:" + paramInt);
    if (this.jdField_a_of_type_Auch != null) {
      this.jdField_a_of_type_Auch.a(paramInt, paramExcitingTransferUploadResultRp);
    }
  }
  
  public boolean b()
  {
    c();
    if (!a())
    {
      a();
      if (!a()) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    ExcitingTransferEngine.ExcitingSendInfo localExcitingSendInfo = a();
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] startSendFile >>>>");
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] ReqInfo   = {" + localExcitingSendInfo.mReqInfo.toString() + "}");
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] FileEntry = {" + localExcitingSendInfo.mFileEntry.toString() + "}");
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] BusInfo   = {" + localExcitingSendInfo.mBusInfo.toString() + "}");
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] Config    = {" + localExcitingSendInfo.mConfig.toString() + "}");
    long l = ExcitingTransferEngine.getInstance().sendFile(localExcitingSendInfo, this);
    if (l == 0L)
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.e("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] startSendFile fail");
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = l;
    QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] startSendFile excitingId:" + this.jdField_b_of_type_Long);
    return true;
  }
  
  protected abstract int c();
  
  public long c()
  {
    return this.jdField_c_of_type_Long;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  protected abstract int d();
  
  protected abstract int e();
  
  public int f()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int g()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void onExcitingSendProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Long = paramLong1;
    ThreadManager.post(new ExtfBaseFileUploader.1(this, paramLong2, paramLong3), 5, null, false);
  }
  
  public void onExcitingSendResult(boolean paramBoolean, int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Id[").append(this.d).append("] onExcitingSendResult suc:").append(paramBoolean).append(" errcode:").append(paramInt).append(" RP:");
    String str;
    if (paramExcitingTransferUploadResultRp != null)
    {
      str = paramExcitingTransferUploadResultRp.toString();
      QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, str);
      if (paramBoolean) {
        this.jdField_c_of_type_Long = this.jdField_a_of_type_Aucd.a();
      }
      this.jdField_b_of_type_Long = 0L;
      if (paramExcitingTransferUploadResultRp != null)
      {
        if (!paramBoolean) {
          break label257;
        }
        if (this.jdField_a_of_type_Aucd.a() - paramExcitingTransferUploadResultRp.m_u64StartSize <= 0L) {
          break label312;
        }
      }
    }
    label257:
    label299:
    label306:
    label312:
    for (long l = this.jdField_a_of_type_Aucd.a() - paramExcitingTransferUploadResultRp.m_u64StartSize;; l = 0L)
    {
      paramExcitingTransferUploadResultRp.m_u64TransferSize = l;
      if ((l > 0L) && (paramExcitingTransferUploadResultRp.m_u64HttpTime > 0L))
      {
        float f1 = (float)paramExcitingTransferUploadResultRp.m_u64HttpTime / 1000.0F;
        paramExcitingTransferUploadResultRp.m_u64TransferSpeed = (((float)l / f1));
        label186:
        QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] SendResultRP:" + paramExcitingTransferUploadResultRp.toString());
        if (!paramBoolean) {
          break label299;
        }
        ThreadManager.post(new ExtfBaseFileUploader.2(this, paramExcitingTransferUploadResultRp), 5, null, false);
        return;
        str = "";
        break;
        if (this.jdField_c_of_type_Long - paramExcitingTransferUploadResultRp.m_u64StartSize <= 0L) {
          break label306;
        }
      }
      for (l = this.jdField_c_of_type_Long - paramExcitingTransferUploadResultRp.m_u64StartSize;; l = 0L)
      {
        paramExcitingTransferUploadResultRp.m_u64TransferSize = l;
        break;
        paramExcitingTransferUploadResultRp.m_u64TransferSpeed = 0L;
        break label186;
        a(paramInt, paramExcitingTransferUploadResultRp);
        return;
      }
    }
  }
  
  public void onExcitingSendStart()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, "Id[" + this.d + "] onExcitingSendStart.");
    } while (this.jdField_a_of_type_Auch == null);
    this.jdField_a_of_type_Auch.az_();
  }
  
  public void onExcitingSubSenderResult(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Id[").append(this.d).append("] ^_^ onExcitingSubSenderResult:").append(paramInt).append(" RP:");
    if (paramExcitingTransferUploaderRp != null) {}
    for (String str = paramExcitingTransferUploaderRp.toString();; str = "")
    {
      QLog.i("ExcitingTransfer.BaseUploader<FileAssistant>", 1, str);
      if (this.jdField_a_of_type_Auch != null) {
        this.jdField_a_of_type_Auch.a(paramInt, paramExcitingTransferUploaderRp);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auca
 * JD-Core Version:    0.7.0.1
 */