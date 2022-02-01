import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.1;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.2;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

public class atet
  implements atdo, atji
{
  protected int a;
  public long a;
  private aszq jdField_a_of_type_Aszq = new ateu(this);
  public atdy a;
  private VFSFile jdField_a_of_type_ComTencentMmVfsVFSFile;
  public final QQAppInterface a;
  public final FileManagerEntity a;
  protected final String a;
  protected boolean a;
  protected byte[] a;
  protected int b;
  protected long b;
  protected final String b;
  public boolean b;
  protected byte[] b;
  private int jdField_c_of_type_Int = -1;
  protected long c;
  private final String jdField_c_of_type_JavaLangString = "OfflineSendWorker<FileAssistant>";
  protected boolean c;
  protected byte[] c;
  protected long d;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  protected byte[] d;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  
  public atet(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_JavaLangString = "actFileUp";
    this.jdField_b_of_type_JavaLangString = "actFileUpDetail";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMmVfsVFSFile = new VFSFile(paramFileManagerEntity.getFilePath());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    paramQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
  }
  
  private void a(int paramInt)
  {
    paramInt = atvo.b(paramInt);
    if ((this.jdField_c_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
    } while (paramInt == 2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    a(paramLong, paramInt, paramString, null);
  }
  
  private void a(aszn paramaszn, boolean paramBoolean1, String paramString, short paramShort, List<String> paramList1, List<String> paramList2, boolean paramBoolean2)
  {
    ThreadManager.post(new OfflineSendWorker.4(this, paramaszn, paramBoolean1, paramString, paramList1, paramList2, paramShort, paramBoolean2), 5, null, false);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "start OfflineFileHitReq:" + bbyp.a());
    }
    atvy.a().execute(new OfflineSendWorker.2(this, paramString, paramLong, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte2, paramArrayOfByte1));
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong, aszq paramaszq, FileManagerEntity paramFileManagerEntity)
  {
    paramaszq = new atuj();
    paramaszq.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    paramaszq.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramaszq.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramaszq.jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    paramFileManagerEntity.strFileMd5 = atjh.a(paramArrayOfByte3);
    paramaszq.jdField_c_of_type_ArrayOfByte = paramArrayOfByte3;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte3;
    byte[] arrayOfByte = new byte[paramArrayOfByte3.length + 4];
    bgva.a(arrayOfByte, 0, paramArrayOfByte3, paramArrayOfByte3.length);
    bgva.a(arrayOfByte, paramArrayOfByte3.length, paramFileManagerEntity.fileSize);
    this.jdField_d_of_type_JavaLangString = com.qq.taf.jce.HexUtil.bytes2HexStr(arrayOfByte).toLowerCase(Locale.US);
    int i;
    if (((atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).h()) {
      if (d())
      {
        i = 1;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform enabled");
      }
    }
    while (i != 0)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "多媒体平台, 不管大小统一使用v3 协议，采用小文件策略");
      paramaszq.jdField_a_of_type_Boolean = true;
      paramaszq.jdField_a_of_type_Int = 1700;
      paramString = atvo.a(new String(paramArrayOfByte1));
      if (paramString == null)
      {
        a(null, 0);
        return;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform enabled, but is retry or not use Exciting Send");
        i = 0;
        continue;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform not enabled");
        i = 0;
      }
      else
      {
        k();
        paramFileManagerEntity.strFileSHA = atjh.a(paramString);
        a(paramString);
        paramaszq.e = paramString;
        a(false, paramaszq.e);
        paramaszq.jdField_d_of_type_ArrayOfByte = atvo.b(new String(paramArrayOfByte1));
        paramaszq.f = atvo.d(new String(paramArrayOfByte1));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaszq, this.jdField_a_of_type_Aszq, paramFileManagerEntity);
      return;
      if (paramLong <= 104857600L)
      {
        paramaszq.jdField_a_of_type_Int = 1700;
        paramString = atvo.a(new String(paramArrayOfByte1));
        if (paramString == null)
        {
          a(null, 0);
          return;
        }
        k();
        paramFileManagerEntity.strFileSHA = atjh.a(paramString);
        a(paramString);
        paramaszq.e = paramString;
        a(false, paramaszq.e);
      }
      else
      {
        paramaszq.jdField_a_of_type_Int = 1600;
        arrayOfByte = atvo.d(new String(paramArrayOfByte1));
        if (arrayOfByte == null)
        {
          a(null, 0);
          return;
        }
        paramFileManagerEntity.strFileSha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(arrayOfByte);
        paramFileManagerEntity.str10Md5 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramArrayOfByte3);
        paramaszq.f = arrayOfByte;
        this.jdField_d_of_type_ArrayOfByte = arrayOfByte;
        a(paramString, paramArrayOfByte1, paramArrayOfByte2, paramLong, paramArrayOfByte3, arrayOfByte);
      }
    }
  }
  
  private boolean a(aszn paramaszn)
  {
    return (!paramaszn.jdField_b_of_type_Boolean) && ((paramaszn.jdField_b_of_type_JavaLangString == null) || (paramaszn.jdField_b_of_type_JavaLangString.length() == 0));
  }
  
  private void b(long paramLong, int paramInt, String paramString)
  {
    b(paramLong, paramInt, paramString, null);
  }
  
  private boolean b(aszn paramaszn)
  {
    return (!TextUtils.isEmpty(paramaszn.jdField_d_of_type_JavaLangString)) && (atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1));
  }
  
  private void n()
  {
    b();
    a(null, 0);
  }
  
  private void o()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [MiaoChuan] Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] is exist, Go [SetFileStatus Step]");
    j();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    atvo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_Aszq);
    atvn localatvn = new atvn();
    localatvn.jdField_b_of_type_JavaLangString = "send_file_suc";
    localatvn.jdField_a_of_type_Int = 1;
    atvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localatvn);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public atdy a(aszn paramaszn, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
  {
    return null;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    a(1002);
    paramLong = System.currentTimeMillis();
    if (paramLong - this.jdField_e_of_type_Long >= 1000L)
    {
      this.jdField_e_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Atdy != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Atdy.a() > this.jdField_a_of_type_Atdy.b()) {
          l1 = this.jdField_a_of_type_Atdy.a() - this.jdField_a_of_type_Atdy.b();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (d()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", b());
    localBundle.putInt("param_V6SelectType", this.jdField_b_of_type_Int);
    localBundle.putInt("param_ipAddrType", d());
    if (this.jdField_c_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("param_ishttps", i);
      if (this.jdField_a_of_type_Atdy != null) {
        break;
      }
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, null, paramString2, 0, paramString1, null, localBundle);
      return;
    }
    atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_a_of_type_Long, this.jdField_a_of_type_Atdy.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atdy.a(), paramString2, this.jdField_a_of_type_Atdy.b(), paramString1, null, localBundle);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    paramInt = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
    for (;;)
    {
      paramObject.status = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      return;
      paramInt = 16;
    }
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == 0)
    {
      paramInt = 9001;
      paramString1 = "[Http_RespValue_Null]" + atvo.a();
    }
    for (;;)
    {
      String str = paramString1;
      if (paramString1 == null) {
        str = "errMsgString_NUll_retCode[" + paramInt + "]";
      }
      if (!paramBoolean)
      {
        b(paramLong, paramInt, str, paramString2);
        return;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = null;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = "";
      }
      c(System.currentTimeMillis());
      b(paramLong, paramInt, str, paramString2);
      n();
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean)
    {
      b(paramLong, 9009, paramString1, paramString2);
      return;
    }
    a(1005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
    b();
    a(paramLong, 9009, paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte;
      this.jdField_a_of_type_Int = 2;
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "setSha err sha=null. sessionid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a(Bundle paramBundle)
  {
    if (((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length == 0)) && (paramBundle != null)) {
      paramBundle.putInt("_shaCalcProgress_", this.jdField_a_of_type_Int);
    }
    return this.jdField_c_of_type_ArrayOfByte;
  }
  
  public void aE_()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    ThreadManager.post(new Thread(new OfflineSendWorker.1(this)), 5, null, true);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
  }
  
  protected long b()
  {
    if ((this.jdField_c_of_type_Long == 0L) || (this.jdField_d_of_type_Long == 0L)) {}
    while (this.jdField_d_of_type_Long <= this.jdField_c_of_type_Long) {
      return 0L;
    }
    return this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Atdy != null) {
      this.jdField_a_of_type_Atdy.a();
    }
    if (this.jdField_c_of_type_Long > 0L) {
      c(System.currentTimeMillis());
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  protected void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Atdy != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Atdy.a() > this.jdField_a_of_type_Atdy.b()) {
          l1 = this.jdField_a_of_type_Atdy.a() - this.jdField_a_of_type_Atdy.b();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (d()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", b());
    localBundle.putInt("param_V6SelectType", this.jdField_b_of_type_Int);
    localBundle.putInt("param_ipAddrType", d());
    if (this.jdField_c_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("param_ishttps", i);
      if (this.jdField_a_of_type_Atdy != null) {
        break;
      }
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, null, null, 0, paramString2, null, localBundle);
      return;
    }
    atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_a_of_type_Long, this.jdField_a_of_type_Atdy.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atdy.a(), paramString2, this.jdField_a_of_type_Atdy.b(), paramString1, null, localBundle);
  }
  
  protected void b(String paramString)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Atdy != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > this.jdField_a_of_type_Atdy.b()) {
          l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize - this.jdField_a_of_type_Atdy.b();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (d()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", b());
    localBundle.putInt("param_V6SelectType", this.jdField_b_of_type_Int);
    localBundle.putInt("param_ipAddrType", d());
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      i = 1;
      localBundle.putInt("param_ishttps", i);
      if (this.jdField_a_of_type_Atdy == null) {
        break label327;
      }
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.jdField_a_of_type_Atdy.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atdy.b(), paramString, localBundle);
      if (!d()) {
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.jdField_a_of_type_Atdy.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atdy.b(), paramString, localBundle);
      }
    }
    label327:
    do
    {
      return;
      i = 0;
      break;
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 0, paramString, localBundle);
    } while (d());
    atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 0, paramString, localBundle);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize <= 0L) {}
    while (this.jdField_a_of_type_Atdy == null) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Atdy.a() * 100L / this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
  }
  
  public void c()
  {
    b();
  }
  
  protected void c(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected int d()
  {
    if (this.jdField_a_of_type_Atdy == null) {
      return 0;
    }
    return atwt.c(this.jdField_a_of_type_Atdy.a());
  }
  
  public void d()
  {
    b();
    if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] is Successed, return!");
      }
      return;
    }
    a(3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    long l = System.currentTimeMillis();
    String str = "Now[" + l + "]startTime[" + this.jdField_a_of_type_Long + "]notifyTime[" + this.jdField_e_of_type_Long + "]";
    l = 0L;
    if (this.jdField_a_of_type_Atdy != null) {
      l = this.jdField_a_of_type_Atdy.a();
    }
    a(l, 9037, str);
    b(l, 9037, str);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    c(System.currentTimeMillis());
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Atdy != null)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Atdy.a();
    }
    o();
  }
  
  public void g()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [Upload Step]Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdate success, go [SetFileStatus Step]");
    j();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    c(System.currentTimeMillis());
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Atdy != null)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Atdy.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(1003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_Atdy.a() }, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_Aszq);
    atvn localatvn = new atvn();
    localatvn.jdField_b_of_type_JavaLangString = "send_file_suc";
    localatvn.jdField_a_of_type_Int = 1;
    atvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localatvn);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void h()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = "";
      m();
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]onOutDate, but not use last server path");
  }
  
  public void i() {}
  
  public void j()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "cancelShaReq. sessionid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]");
  }
  
  public void k() {}
  
  protected void l() {}
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 13, null, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, 1002);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    b(0L);
    c(0L);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], strFilePath is null");
      }
      b(0L, 9005, atvo.a());
      a(0L, 9005, atvo.a());
      n();
    }
    label359:
    label878:
    do
    {
      return;
      l();
      if ((d()) && (c()) && (b()))
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "re sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], custom uploader handled");
        return;
      }
      boolean bool1 = false;
      boolean bool3 = false;
      Object localObject1 = null;
      byte[] arrayOfByte = null;
      boolean bool2 = bool1;
      Object localObject2 = localObject1;
      int i;
      int j;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath != null)
      {
        bool2 = bool1;
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData != null)
        {
          i = 0;
          if (!atgz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label843;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath.startsWith("https")) {
            break label831;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain)) {
            break label819;
          }
          bool1 = true;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain;
          j = i;
          if (i == 0)
          {
            localObject2 = atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 1);
            if ((localObject2 == null) || (!((atcu)localObject2).jdField_a_of_type_Boolean)) {
              break label899;
            }
            if (((atcu)localObject2).jdField_a_of_type_Int != 1) {
              break label878;
            }
            this.jdField_b_of_type_Int = 1;
            j = i;
          }
          bool2 = bool1;
          localObject2 = localObject1;
          if (j != 0)
          {
            QLog.w("OfflineSendWorker<FileAssistant>", 1, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], resend. but reReqCsSend");
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = null;
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = "";
            localObject2 = localObject1;
            bool2 = bool1;
          }
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath))
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], resend serverPath:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath + " isHttpsOnResend:" + bool2 + " httpsDomainOnResend:" + (String)localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData != null) {
          this.jdField_a_of_type_Atdy = atdm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), new String(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath, bool2, (String)localObject2);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Atdy != null)
          {
            this.jdField_d_of_type_Boolean = true;
            this.jdField_a_of_type_Atdy.a(this);
            if (!this.jdField_a_of_type_Atdy.a(0L))
            {
              a(1005);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 0, "");
              b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "sendFile error");
              a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "sendFile error");
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("OfflineSendWorker<FileAssistant>", 2, "nSessionID[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],sendFile return false");
              return;
              i = 1;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              break label359;
              i = 1;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              break label359;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath.startsWith("https")) {
                break label359;
              }
              i = 1;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              break label359;
              j = i;
              if (((atcu)localObject2).jdField_a_of_type_Int != 2) {
                break label411;
              }
              this.jdField_b_of_type_Int = 2;
              j = i;
              break label411;
              j = 1;
              break label411;
              this.jdField_a_of_type_Atdy = atdm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath);
              continue;
            }
            b(System.currentTimeMillis());
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes("utf-8");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath().getBytes("utf-8");
        arrayOfByte = atvo.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
        if (arrayOfByte == null)
        {
          a(0);
          b(0L, 9042, "get md5 failed");
          a(0L, 9042, "get md5 failed");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], getMd5 failed");
        }
        a(0);
        b(0L, 9005, atvo.a());
        a(0L, 9005, atvo.a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (byte[])localObject2, localUnsupportedEncodingException, arrayOfByte, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Aszq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    } while (!QLog.isColorLevel());
    label411:
    label819:
    label831:
    label843:
    QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
    label899:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atet
 * JD-Core Version:    0.7.0.1
 */