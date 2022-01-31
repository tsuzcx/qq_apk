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

public class aoqe
  extends aojz
  implements aoqp
{
  final String jdField_c_of_type_JavaLangString = "ExcitingTransfer.OfflineSendWorker<FileAssistant>";
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  protected long e;
  protected long f;
  
  public aoqe(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_d_of_type_Boolean = true;
  }
  
  private aojt a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, aoqf paramaoqf)
  {
    Object localObject2 = this.jdField_c_of_type_ArrayOfByte;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramaoqf.jdField_b_of_type_ArrayOfByte != null)
      {
        localObject1 = localObject2;
        if (paramaoqf.jdField_b_of_type_ArrayOfByte.length > 0) {
          localObject1 = paramaoqf.jdField_b_of_type_ArrayOfByte;
        }
      }
    }
    localObject1 = new aoqk(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte, (byte[])localObject1, paramaoqf.jdField_d_of_type_ArrayOfByte, paramaoqf.jdField_a_of_type_ArrayOfByte);
    localObject2 = new ArrayList();
    if (paramaoqf.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = paramaoqf.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          ((List)localObject2).add(new ExcitingTransferHostInfo(str, paramaoqf.jdField_a_of_type_Int));
        }
      }
    }
    return aoqj.a(paramQQAppInterface, paramLong1, paramLong2, (aoqk)localObject1, new aoqo((List)localObject2, null, paramaoqf.jdField_a_of_type_Boolean, paramaoqf.jdField_a_of_type_JavaLangString, paramaoqf.jdField_c_of_type_ArrayOfByte));
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
    aoqd localaoqd = null;
    Object localObject = localaoqd;
    if (this.jdField_a_of_type_Aojt != null)
    {
      localObject = localaoqd;
      if ((this.jdField_a_of_type_Aojt instanceof aoqj)) {
        localObject = ((aoqj)this.jdField_a_of_type_Aojt).a();
      }
    }
    localaoqd = new aoqd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null) {
      if (((ExcitingTransferUploadResultRp)localObject).m_nResult == 0L)
      {
        localaoqd.a((ExcitingTransferUploadResultRp)localObject);
        label91:
        localaoqd.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        localObject = apck.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localaoqd.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        localaoqd.c(this.jdField_b_of_type_Boolean);
        long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
        if (l <= 0L) {
          break label273;
        }
        localaoqd.c(l);
        label184:
        l = this.f - this.e;
        if (l <= 0L) {
          break label282;
        }
        localaoqd.b(l);
      }
    }
    for (;;)
    {
      localaoqd.a(bool1);
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
            localaoqd.a(paramInt);
            break;
            bool1 = false;
            continue;
          }
          localaoqd.a(17);
          break;
        }
      }
      localaoqd.a(0);
      break label91;
      label273:
      localaoqd.c(0L);
      break label184;
      label282:
      localaoqd.b(0L);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] setCloseExtfAbility:" + this.jdField_c_of_type_Boolean + "->" + paramBoolean);
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private void n()
  {
    aoqd localaoqd = new aoqd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localaoqd.a(33);
    localaoqd.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    Object localObject = apck.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    localaoqd.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    localaoqd.c(this.jdField_b_of_type_Boolean);
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L)
    {
      localaoqd.c(l);
      l = this.f - this.e;
      if (l <= 0L) {
        break label168;
      }
      localaoqd.b(l);
    }
    for (;;)
    {
      localObject = new ExcitingTransferUploadResultRp();
      ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
      ((ExcitingTransferUploadResultRp)localObject).m_nResult = 33;
      localaoqd.a((ExcitingTransferUploadResultRp)localObject);
      localaoqd.a(false);
      return;
      localaoqd.c(0L);
      break;
      label168:
      localaoqd.b(0L);
    }
  }
  
  protected aojt a(aofh paramaofh, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
  {
    QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader. bIsHttps:" + paramBoolean + " strHttpsDomain:" + paramString + " strlanIp:" + paramaofh.e);
    paramList = new aoqf(this);
    if ((paramaofh.jdField_c_of_type_ArrayOfByte != null) && (paramaofh.jdField_c_of_type_ArrayOfByte.length > 0))
    {
      paramList.jdField_b_of_type_ArrayOfByte = paramaofh.jdField_c_of_type_ArrayOfByte;
      j();
      a(paramaofh.jdField_c_of_type_ArrayOfByte);
    }
    paramList.jdField_a_of_type_Boolean = paramBoolean;
    paramList.jdField_a_of_type_JavaLangString = paramString;
    paramList.jdField_a_of_type_ArrayOfByte = paramaofh.jdField_b_of_type_ArrayOfByte;
    paramList.jdField_a_of_type_Int = paramInt;
    paramList.jdField_c_of_type_ArrayOfByte = paramaofh.jdField_d_of_type_ArrayOfByte;
    paramList.jdField_d_of_type_ArrayOfByte = paramaofh.jdField_a_of_type_ArrayOfByte;
    paramaofh = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), paramList);
    if (paramaofh != null)
    {
      ((aoqj)paramaofh).a(this);
      return paramaofh;
    }
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader fail.");
    return paramaofh;
  }
  
  public void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      int i = aoqj.a(paramInt);
      b(this.jdField_a_of_type_Aojt.a(), i, "subsender_err", "");
    }
    if (paramExcitingTransferUploaderRp != null)
    {
      aoqg localaoqg = new aoqg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localaoqg.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      String str = apck.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      localaoqg.a(paramInt);
      localaoqg.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, str, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      localaoqg.a(paramExcitingTransferUploaderRp);
      if (paramInt == 0) {}
      for (;;)
      {
        localaoqg.a(bool);
        return;
        bool = false;
      }
    }
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onExtfSubUploaderResult datareport fail. no rp");
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
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
    if ((this.jdField_d_of_type_Boolean) && (paramBoolean) && (d()))
    {
      QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "*_* nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] exciting tansfer fail. ftnUploader try again");
      a(paramInt);
      a(true);
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
      long l2 = this.e;
      QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onFullShaCalcDone costTime:" + (l1 - l2) + " bigFile:" + paramBoolean + ". useExtfUploader:" + d());
    } while ((!paramBoolean) || (!d()) || (this.jdField_a_of_type_Aojt == null));
    this.jdField_a_of_type_Aojt.a(paramArrayOfByte);
  }
  
  public void aB_() {}
  
  public void az_()
  {
    super.az_();
  }
  
  protected void b(String paramString)
  {
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
    if ((d()) && (this.jdField_a_of_type_Aojt != null) && ((this.jdField_a_of_type_Aojt instanceof aoqj))) {
      aoqj localaoqj = (aoqj)this.jdField_a_of_type_Aojt;
    }
    super.d();
  }
  
  protected boolean d()
  {
    return !e();
  }
  
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void k()
  {
    super.k();
    this.e = System.currentTimeMillis();
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
 * Qualified Name:     aoqe
 * JD-Core Version:    0.7.0.1
 */