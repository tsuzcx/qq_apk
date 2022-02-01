import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aubw
  extends atwn
  implements auch
{
  private boolean d;
  protected long e;
  private boolean e;
  protected long f;
  
  public aubw(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_e_of_type_Boolean = true;
  }
  
  private atvs a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, aubx paramaubx)
  {
    Object localObject2 = this.jdField_c_of_type_ArrayOfByte;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramaubx.jdField_b_of_type_ArrayOfByte != null)
      {
        localObject1 = localObject2;
        if (paramaubx.jdField_b_of_type_ArrayOfByte.length > 0) {
          localObject1 = paramaubx.jdField_b_of_type_ArrayOfByte;
        }
      }
    }
    localObject1 = new aucc(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte, (byte[])localObject1, paramaubx.jdField_d_of_type_ArrayOfByte, paramaubx.jdField_a_of_type_ArrayOfByte, paramaubx.jdField_b_of_type_Boolean);
    localObject2 = new ArrayList();
    if (paramaubx.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = paramaubx.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          ((List)localObject2).add(new ExcitingTransferHostInfo(str, paramaubx.jdField_a_of_type_Int));
        }
      }
    }
    return aucb.a(paramQQAppInterface, paramLong1, paramLong2, (aucc)localObject1, new aucg((List)localObject2, null, paramaubx.jdField_a_of_type_Boolean, paramaubx.jdField_a_of_type_JavaLangString, paramaubx.jdField_c_of_type_ArrayOfByte));
  }
  
  private void a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 9037)
    {
      n();
      return;
    }
    int i = e();
    aubv localaubv = null;
    Object localObject = localaubv;
    if (this.jdField_a_of_type_Atvs != null)
    {
      localObject = localaubv;
      if ((this.jdField_a_of_type_Atvs instanceof aucb)) {
        localObject = ((aucb)this.jdField_a_of_type_Atvs).a();
      }
    }
    localaubv = new aubv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null)
    {
      paramInt = auoo.b(((ExcitingTransferUploadResultRp)localObject).m_strServerIp);
      if (((ExcitingTransferUploadResultRp)localObject).m_nResult == 0L)
      {
        localaubv.a((ExcitingTransferUploadResultRp)localObject);
        label106:
        localaubv.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        localObject = aunj.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localaubv.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        localaubv.c(this.jdField_b_of_type_Boolean);
        long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
        if (l <= 0L) {
          break label316;
        }
        localaubv.c(l);
        label199:
        l = this.f - this.jdField_e_of_type_Long;
        if (l <= 0L) {
          break label325;
        }
        localaubv.b(l);
      }
    }
    for (;;)
    {
      localaubv.b(i);
      localaubv.c(paramInt);
      localaubv.d(this.jdField_c_of_type_Boolean);
      localaubv.a(bool1);
      return;
      bool1 = false;
      break;
      if (paramInt == 0) {
        bool1 = bool2;
      }
      for (;;)
      {
        if (!bool1)
        {
          if (this.jdField_c_of_type_Long == 0L)
          {
            localaubv.a(paramInt);
            paramInt = 0;
            break;
            bool1 = false;
            continue;
          }
          localaubv.a(17);
          paramInt = 0;
          break;
        }
      }
      localaubv.a(0);
      paramInt = 0;
      break label106;
      label316:
      localaubv.c(0L);
      break label199;
      label325:
      localaubv.b(0L);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] setCloseExtfAbility:" + this.jdField_d_of_type_Boolean + "->" + paramBoolean);
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  private int e()
  {
    if ((this.jdField_a_of_type_Atvs != null) && ((this.jdField_a_of_type_Atvs instanceof aucb))) {
      return ((aucb)this.jdField_a_of_type_Atvs).g();
    }
    return 0;
  }
  
  private void n()
  {
    aubv localaubv = new aubv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localaubv.a(33);
    localaubv.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    Object localObject = aunj.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    localaubv.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    localaubv.c(this.jdField_b_of_type_Boolean);
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L)
    {
      localaubv.c(l);
      l = this.f - this.jdField_e_of_type_Long;
      if (l <= 0L) {
        break label184;
      }
      localaubv.b(l);
    }
    for (;;)
    {
      localObject = new ExcitingTransferUploadResultRp();
      ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
      ((ExcitingTransferUploadResultRp)localObject).m_nResult = 33;
      localaubv.a((ExcitingTransferUploadResultRp)localObject);
      localaubv.b(e());
      localaubv.d(this.jdField_c_of_type_Boolean);
      localaubv.a(false);
      return;
      localaubv.c(0L);
      break;
      label184:
      localaubv.b(0L);
    }
  }
  
  protected atvs a(atri paramatri, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
  {
    QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader. bIsHttps:" + paramBoolean + " strHttpsDomain:" + paramString + " strlanIp:" + paramatri.jdField_e_of_type_JavaLangString);
    paramList = new aubx(this);
    if ((paramatri.jdField_c_of_type_ArrayOfByte != null) && (paramatri.jdField_c_of_type_ArrayOfByte.length > 0))
    {
      paramList.jdField_b_of_type_ArrayOfByte = paramatri.jdField_c_of_type_ArrayOfByte;
      j();
      a(paramatri.jdField_c_of_type_ArrayOfByte);
    }
    paramList.jdField_a_of_type_Boolean = paramBoolean;
    paramList.jdField_a_of_type_JavaLangString = paramString;
    paramList.jdField_b_of_type_Boolean = paramatri.jdField_b_of_type_Boolean;
    if (paramatri.jdField_b_of_type_Boolean) {}
    for (paramList.jdField_a_of_type_ArrayOfByte = paramatri.jdField_e_of_type_ArrayOfByte;; paramList.jdField_a_of_type_ArrayOfByte = paramatri.jdField_b_of_type_ArrayOfByte)
    {
      paramList.jdField_a_of_type_Int = paramInt;
      paramList.jdField_c_of_type_ArrayOfByte = paramatri.jdField_d_of_type_ArrayOfByte;
      paramList.jdField_d_of_type_ArrayOfByte = paramatri.jdField_a_of_type_ArrayOfByte;
      paramatri = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), paramList);
      if (paramatri == null) {
        break;
      }
      ((aucb)paramatri).a(this);
      return paramatri;
    }
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader fail.");
    return paramatri;
  }
  
  public void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    this.jdField_b_of_type_Int = e();
    int i;
    Object localObject;
    if (paramInt != 0)
    {
      i = aucb.a(paramInt);
      b(this.jdField_a_of_type_Atvs.a(), i, "subsender_err", "");
      if (paramExcitingTransferUploaderRp == null) {
        break label340;
      }
      localObject = new auby(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((auby)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      String str = aunj.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      ((auby)localObject).a(paramInt);
      ((auby)localObject).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, str, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      ((auby)localObject).a(paramExcitingTransferUploaderRp);
      ((auby)localObject).b(e());
      ((auby)localObject).c(auoo.b(paramExcitingTransferUploaderRp.m_strServerIp));
      ((auby)localObject).c(this.jdField_c_of_type_Boolean);
      if (paramInt != 0) {
        break label334;
      }
    }
    label334:
    for (boolean bool = true;; bool = false)
    {
      ((auby)localObject).a(bool);
      return;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_fromType", 1);
      long l = b();
      ((Bundle)localObject).putLong("param_transferTime", l);
      ((Bundle)localObject).putInt("param_V6SelectType", this.jdField_b_of_type_Int);
      ((Bundle)localObject).putInt("param_ipAddrType", d());
      if (this.jdField_c_of_type_Boolean) {}
      for (i = 1;; i = 0)
      {
        ((Bundle)localObject).putInt("param_ishttps", i);
        aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", l, this.jdField_a_of_type_Atvs.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 1L, this.jdField_a_of_type_Atvs.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atvs.b(), "", (Bundle)localObject);
        break;
      }
    }
    label340:
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onExtfSubUploaderResult datareport fail. no rp");
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (d()) {
      this.jdField_b_of_type_Int = e();
    }
    super.a(paramLong, paramInt, paramString1, paramString2);
    if (d()) {
      a(paramInt);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    float f1;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (paramLong3 <= 1048576L) {
        break label82;
      }
      f1 = (float)paramLong3 / 1048576.0F;
      str = new DecimalFormat("0.00").format(f1);
      str = "加速上传 " + str + "MB/s";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mExcitingSpeed = str;
      return;
      label82:
      if (paramLong3 > 1024L)
      {
        f1 = (float)paramLong3 / 1024.0F;
        str = new DecimalFormat("0.00").format(f1);
        str = "加速上传 " + str + "KB/s";
      }
      else
      {
        str = "加速上传 " + paramLong3 + "KB/s";
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (paramBoolean) && (d()))
    {
      QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "*_* nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] exciting tansfer fail. ftnUploader try again");
      a(paramInt);
      a(true);
      this.jdField_c_of_type_Boolean = false;
      m();
      return;
    }
    super.a(paramBoolean, paramLong, paramInt, paramString1, paramString2);
  }
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.f = System.currentTimeMillis();
      long l1 = this.f;
      long l2 = this.jdField_e_of_type_Long;
      QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onFullShaCalcDone costTime:" + (l1 - l2) + " bigFile:" + paramBoolean + ". useExtfUploader:" + d());
    } while ((!paramBoolean) || (!d()) || (this.jdField_a_of_type_Atvs == null));
    this.jdField_a_of_type_Atvs.a(paramArrayOfByte);
  }
  
  public void aE_()
  {
    super.aE_();
  }
  
  public void az_() {}
  
  protected void b(String paramString)
  {
    if (d()) {
      this.jdField_b_of_type_Int = e();
    }
    super.b(paramString);
    if (d()) {
      a(0);
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public void d()
  {
    if ((d()) && (this.jdField_a_of_type_Atvs != null) && ((this.jdField_a_of_type_Atvs instanceof aucb))) {
      aucb localaucb = (aucb)this.jdField_a_of_type_Atvs;
    }
    super.d();
  }
  
  protected boolean d()
  {
    return !e();
  }
  
  public boolean e()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Atvs instanceof aucb))
    {
      ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = ((aucb)this.jdField_a_of_type_Atvs).a();
      if (localExcitingTransferUploadResultRp == null) {
        break label41;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc = localExcitingTransferUploadResultRp.m_strFileIdCrc;
    }
    for (;;)
    {
      super.g();
      return;
      label41:
      QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onSendSuccess: UploadResultRp is null");
    }
  }
  
  protected void k()
  {
    super.k();
    this.jdField_e_of_type_Long = System.currentTimeMillis();
  }
  
  protected void l()
  {
    super.l();
    if (d())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubw
 * JD-Core Version:    0.7.0.1
 */