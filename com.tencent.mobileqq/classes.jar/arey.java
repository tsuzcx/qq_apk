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

public class arey
  extends aqye
  implements arfj
{
  final String jdField_c_of_type_JavaLangString = "ExcitingTransfer.OfflineSendWorker<FileAssistant>";
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  protected long e;
  protected long f;
  
  public arey(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_d_of_type_Boolean = true;
  }
  
  private aqxy a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, arez paramarez)
  {
    Object localObject2 = this.jdField_c_of_type_ArrayOfByte;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramarez.jdField_b_of_type_ArrayOfByte != null)
      {
        localObject1 = localObject2;
        if (paramarez.jdField_b_of_type_ArrayOfByte.length > 0) {
          localObject1 = paramarez.jdField_b_of_type_ArrayOfByte;
        }
      }
    }
    localObject1 = new arfe(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte, (byte[])localObject1, paramarez.jdField_d_of_type_ArrayOfByte, paramarez.jdField_a_of_type_ArrayOfByte);
    localObject2 = new ArrayList();
    if (paramarez.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = paramarez.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          ((List)localObject2).add(new ExcitingTransferHostInfo(str, paramarez.jdField_a_of_type_Int));
        }
      }
    }
    return arfd.a(paramQQAppInterface, paramLong1, paramLong2, (arfe)localObject1, new arfi((List)localObject2, null, paramarez.jdField_a_of_type_Boolean, paramarez.jdField_a_of_type_JavaLangString, paramarez.jdField_c_of_type_ArrayOfByte));
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
    arex localarex = null;
    Object localObject = localarex;
    if (this.jdField_a_of_type_Aqxy != null)
    {
      localObject = localarex;
      if ((this.jdField_a_of_type_Aqxy instanceof arfd)) {
        localObject = ((arfd)this.jdField_a_of_type_Aqxy).a();
      }
    }
    localarex = new arex(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null) {
      if (((ExcitingTransferUploadResultRp)localObject).m_nResult == 0L)
      {
        localarex.a((ExcitingTransferUploadResultRp)localObject);
        label91:
        localarex.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        localObject = arrr.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localarex.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        localarex.c(this.jdField_b_of_type_Boolean);
        long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
        if (l <= 0L) {
          break label273;
        }
        localarex.c(l);
        label184:
        l = this.f - this.e;
        if (l <= 0L) {
          break label282;
        }
        localarex.b(l);
      }
    }
    for (;;)
    {
      localarex.a(bool1);
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
            localarex.a(paramInt);
            break;
            bool1 = false;
            continue;
          }
          localarex.a(17);
          break;
        }
      }
      localarex.a(0);
      break label91;
      label273:
      localarex.c(0L);
      break label184;
      label282:
      localarex.b(0L);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] setCloseExtfAbility:" + this.jdField_c_of_type_Boolean + "->" + paramBoolean);
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private void n()
  {
    arex localarex = new arex(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localarex.a(33);
    localarex.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    Object localObject = arrr.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    localarex.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    localarex.c(this.jdField_b_of_type_Boolean);
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L)
    {
      localarex.c(l);
      l = this.f - this.e;
      if (l <= 0L) {
        break label168;
      }
      localarex.b(l);
    }
    for (;;)
    {
      localObject = new ExcitingTransferUploadResultRp();
      ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
      ((ExcitingTransferUploadResultRp)localObject).m_nResult = 33;
      localarex.a((ExcitingTransferUploadResultRp)localObject);
      localarex.a(false);
      return;
      localarex.c(0L);
      break;
      label168:
      localarex.b(0L);
    }
  }
  
  protected aqxy a(aqtm paramaqtm, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
  {
    QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader. bIsHttps:" + paramBoolean + " strHttpsDomain:" + paramString + " strlanIp:" + paramaqtm.e);
    paramList = new arez(this);
    if ((paramaqtm.jdField_c_of_type_ArrayOfByte != null) && (paramaqtm.jdField_c_of_type_ArrayOfByte.length > 0))
    {
      paramList.jdField_b_of_type_ArrayOfByte = paramaqtm.jdField_c_of_type_ArrayOfByte;
      j();
      a(paramaqtm.jdField_c_of_type_ArrayOfByte);
    }
    paramList.jdField_a_of_type_Boolean = paramBoolean;
    paramList.jdField_a_of_type_JavaLangString = paramString;
    paramList.jdField_a_of_type_ArrayOfByte = paramaqtm.jdField_b_of_type_ArrayOfByte;
    paramList.jdField_a_of_type_Int = paramInt;
    paramList.jdField_c_of_type_ArrayOfByte = paramaqtm.jdField_d_of_type_ArrayOfByte;
    paramList.jdField_d_of_type_ArrayOfByte = paramaqtm.jdField_a_of_type_ArrayOfByte;
    paramaqtm = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), paramList);
    if (paramaqtm != null)
    {
      ((arfd)paramaqtm).a(this);
      return paramaqtm;
    }
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader fail.");
    return paramaqtm;
  }
  
  public void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      int i = arfd.a(paramInt);
      b(this.jdField_a_of_type_Aqxy.a(), i, "subsender_err", "");
    }
    if (paramExcitingTransferUploaderRp != null)
    {
      arfa localarfa = new arfa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localarfa.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      String str = arrr.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      localarfa.a(paramInt);
      localarfa.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, str, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      localarfa.a(paramExcitingTransferUploaderRp);
      if (paramInt == 0) {}
      for (;;)
      {
        localarfa.a(bool);
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
    } while ((!paramBoolean) || (!d()) || (this.jdField_a_of_type_Aqxy == null));
    this.jdField_a_of_type_Aqxy.a(paramArrayOfByte);
  }
  
  public void aA_()
  {
    super.aA_();
  }
  
  public void aC_() {}
  
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
    if ((d()) && (this.jdField_a_of_type_Aqxy != null) && ((this.jdField_a_of_type_Aqxy instanceof arfd))) {
      arfd localarfd = (arfd)this.jdField_a_of_type_Aqxy;
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
 * Qualified Name:     arey
 * JD-Core Version:    0.7.0.1
 */