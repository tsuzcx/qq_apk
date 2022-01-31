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

public class arap
  extends aqtv
  implements arba
{
  final String jdField_c_of_type_JavaLangString = "ExcitingTransfer.OfflineSendWorker<FileAssistant>";
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  protected long e;
  protected long f;
  
  public arap(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_d_of_type_Boolean = true;
  }
  
  private aqtp a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, araq paramaraq)
  {
    Object localObject2 = this.jdField_c_of_type_ArrayOfByte;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramaraq.jdField_b_of_type_ArrayOfByte != null)
      {
        localObject1 = localObject2;
        if (paramaraq.jdField_b_of_type_ArrayOfByte.length > 0) {
          localObject1 = paramaraq.jdField_b_of_type_ArrayOfByte;
        }
      }
    }
    localObject1 = new arav(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte, (byte[])localObject1, paramaraq.jdField_d_of_type_ArrayOfByte, paramaraq.jdField_a_of_type_ArrayOfByte);
    localObject2 = new ArrayList();
    if (paramaraq.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = paramaraq.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          ((List)localObject2).add(new ExcitingTransferHostInfo(str, paramaraq.jdField_a_of_type_Int));
        }
      }
    }
    return arau.a(paramQQAppInterface, paramLong1, paramLong2, (arav)localObject1, new araz((List)localObject2, null, paramaraq.jdField_a_of_type_Boolean, paramaraq.jdField_a_of_type_JavaLangString, paramaraq.jdField_c_of_type_ArrayOfByte));
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
    arao localarao = null;
    Object localObject = localarao;
    if (this.jdField_a_of_type_Aqtp != null)
    {
      localObject = localarao;
      if ((this.jdField_a_of_type_Aqtp instanceof arau)) {
        localObject = ((arau)this.jdField_a_of_type_Aqtp).a();
      }
    }
    localarao = new arao(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null) {
      if (((ExcitingTransferUploadResultRp)localObject).m_nResult == 0L)
      {
        localarao.a((ExcitingTransferUploadResultRp)localObject);
        label91:
        localarao.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        localObject = arni.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localarao.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        localarao.c(this.jdField_b_of_type_Boolean);
        long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
        if (l <= 0L) {
          break label273;
        }
        localarao.c(l);
        label184:
        l = this.f - this.e;
        if (l <= 0L) {
          break label282;
        }
        localarao.b(l);
      }
    }
    for (;;)
    {
      localarao.a(bool1);
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
            localarao.a(paramInt);
            break;
            bool1 = false;
            continue;
          }
          localarao.a(17);
          break;
        }
      }
      localarao.a(0);
      break label91;
      label273:
      localarao.c(0L);
      break label184;
      label282:
      localarao.b(0L);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] setCloseExtfAbility:" + this.jdField_c_of_type_Boolean + "->" + paramBoolean);
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private void n()
  {
    arao localarao = new arao(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localarao.a(33);
    localarao.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    Object localObject = arni.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    localarao.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    localarao.c(this.jdField_b_of_type_Boolean);
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L)
    {
      localarao.c(l);
      l = this.f - this.e;
      if (l <= 0L) {
        break label168;
      }
      localarao.b(l);
    }
    for (;;)
    {
      localObject = new ExcitingTransferUploadResultRp();
      ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
      ((ExcitingTransferUploadResultRp)localObject).m_nResult = 33;
      localarao.a((ExcitingTransferUploadResultRp)localObject);
      localarao.a(false);
      return;
      localarao.c(0L);
      break;
      label168:
      localarao.b(0L);
    }
  }
  
  protected aqtp a(aqpd paramaqpd, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
  {
    QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader. bIsHttps:" + paramBoolean + " strHttpsDomain:" + paramString + " strlanIp:" + paramaqpd.e);
    paramList = new araq(this);
    if ((paramaqpd.jdField_c_of_type_ArrayOfByte != null) && (paramaqpd.jdField_c_of_type_ArrayOfByte.length > 0))
    {
      paramList.jdField_b_of_type_ArrayOfByte = paramaqpd.jdField_c_of_type_ArrayOfByte;
      j();
      a(paramaqpd.jdField_c_of_type_ArrayOfByte);
    }
    paramList.jdField_a_of_type_Boolean = paramBoolean;
    paramList.jdField_a_of_type_JavaLangString = paramString;
    paramList.jdField_a_of_type_ArrayOfByte = paramaqpd.jdField_b_of_type_ArrayOfByte;
    paramList.jdField_a_of_type_Int = paramInt;
    paramList.jdField_c_of_type_ArrayOfByte = paramaqpd.jdField_d_of_type_ArrayOfByte;
    paramList.jdField_d_of_type_ArrayOfByte = paramaqpd.jdField_a_of_type_ArrayOfByte;
    paramaqpd = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), paramList);
    if (paramaqpd != null)
    {
      ((arau)paramaqpd).a(this);
      return paramaqpd;
    }
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader fail.");
    return paramaqpd;
  }
  
  public void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      int i = arau.a(paramInt);
      b(this.jdField_a_of_type_Aqtp.a(), i, "subsender_err", "");
    }
    if (paramExcitingTransferUploaderRp != null)
    {
      arar localarar = new arar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localarar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      String str = arni.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      localarar.a(paramInt);
      localarar.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, str, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      localarar.a(paramExcitingTransferUploaderRp);
      if (paramInt == 0) {}
      for (;;)
      {
        localarar.a(bool);
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
    } while ((!paramBoolean) || (!d()) || (this.jdField_a_of_type_Aqtp == null));
    this.jdField_a_of_type_Aqtp.a(paramArrayOfByte);
  }
  
  public void aD_()
  {
    super.aD_();
  }
  
  public void aF_() {}
  
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
    if ((d()) && (this.jdField_a_of_type_Aqtp != null) && ((this.jdField_a_of_type_Aqtp instanceof arau))) {
      arau localarau = (arau)this.jdField_a_of_type_Aqtp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arap
 * JD-Core Version:    0.7.0.1
 */