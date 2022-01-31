import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.1;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

public class apax
  implements aozz, apgw
{
  protected int a;
  public long a;
  private aowi jdField_a_of_type_Aowi = new apay(this);
  public apar a;
  private VFSFile jdField_a_of_type_ComTencentMmVfsVFSFile;
  public final QQAppInterface a;
  public final FileManagerEntity a;
  protected final String a;
  protected boolean a;
  protected byte[] a;
  private int b;
  protected long b;
  protected final String b;
  public boolean b;
  protected byte[] b;
  protected long c;
  private final String jdField_c_of_type_JavaLangString = "OfflineSendWorker<FileAssistant>";
  private boolean jdField_c_of_type_Boolean;
  protected byte[] c;
  protected long d;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  protected byte[] d;
  private long e;
  
  public apax(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "actFileUp";
    this.jdField_b_of_type_JavaLangString = "actFileUpDetail";
    this.jdField_a_of_type_Boolean = true;
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
    paramInt = apug.b(paramInt);
    if ((this.jdField_b_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
    } while (paramInt == 2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    a(paramLong, paramInt, paramString, null);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "start OfflineFileHitReq:" + awzy.a());
    }
    apus.a().execute(new OfflineSendWorker.2(this, paramString, paramLong, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte2, paramArrayOfByte1));
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong, aowi paramaowi, FileManagerEntity paramFileManagerEntity)
  {
    paramaowi = new aptb();
    paramaowi.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    paramaowi.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramaowi.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramaowi.jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    paramFileManagerEntity.strFileMd5 = apgt.a(paramArrayOfByte3);
    paramaowi.jdField_c_of_type_ArrayOfByte = paramArrayOfByte3;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte3;
    byte[] arrayOfByte = new byte[paramArrayOfByte3.length + 4];
    bbmx.a(arrayOfByte, 0, paramArrayOfByte3, paramArrayOfByte3.length);
    bbmx.a(arrayOfByte, paramArrayOfByte3.length, paramFileManagerEntity.fileSize);
    this.jdField_d_of_type_JavaLangString = com.qq.taf.jce.HexUtil.bytes2HexStr(arrayOfByte).toLowerCase(Locale.US);
    if (paramLong <= 104857600L)
    {
      paramaowi.jdField_a_of_type_Int = 1700;
      paramString = apug.a(new String(paramArrayOfByte1));
      if (paramString == null)
      {
        a(null, 0);
        return;
      }
      k();
      paramFileManagerEntity.strFileSHA = apgt.a(paramString);
      a(paramString);
      paramaowi.jdField_d_of_type_ArrayOfByte = paramString;
      a(false, paramaowi.jdField_d_of_type_ArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaowi, this.jdField_a_of_type_Aowi, paramFileManagerEntity);
      return;
      paramaowi.jdField_a_of_type_Int = 1600;
      arrayOfByte = apug.c(new String(paramArrayOfByte1));
      if (arrayOfByte == null)
      {
        a(null, 0);
        return;
      }
      paramFileManagerEntity.strFileSha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(arrayOfByte);
      paramFileManagerEntity.str10Md5 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramArrayOfByte3);
      paramaowi.e = arrayOfByte;
      this.jdField_d_of_type_ArrayOfByte = arrayOfByte;
      a(paramString, paramArrayOfByte1, paramArrayOfByte2, paramLong, paramArrayOfByte3, arrayOfByte);
    }
  }
  
  private void b(long paramLong, int paramInt, String paramString)
  {
    b(paramLong, paramInt, paramString, null);
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
    apug.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aowi);
    apuf localapuf = new apuf();
    localapuf.jdField_b_of_type_JavaLangString = "send_file_suc";
    localapuf.jdField_a_of_type_Int = 1;
    apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapuf);
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
  
  public apar a(aowf paramaowf, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
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
    if (paramLong - this.e >= 1000L)
    {
      this.e = paramLong;
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
      if (this.jdField_a_of_type_Apar != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Apar.a() > this.jdField_a_of_type_Apar.b()) {
          l1 = this.jdField_a_of_type_Apar.a() - this.jdField_a_of_type_Apar.b();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (d()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", b());
    if (this.jdField_a_of_type_Apar == null)
    {
      apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, null, paramString2, 0, paramString1, null, localBundle);
      return;
    }
    apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_a_of_type_Long, this.jdField_a_of_type_Apar.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Apar.a(), paramString2, this.jdField_a_of_type_Apar.b(), paramString1, null, localBundle);
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
      paramString1 = "[Http_RespValue_Null]" + apug.a();
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
  
  public void aw_()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
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
    if (this.jdField_a_of_type_Apar != null) {
      this.jdField_a_of_type_Apar.a();
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
      if (this.jdField_a_of_type_Apar != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Apar.a() > this.jdField_a_of_type_Apar.b()) {
          l1 = this.jdField_a_of_type_Apar.a() - this.jdField_a_of_type_Apar.b();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (d()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", b());
    if (this.jdField_a_of_type_Apar == null)
    {
      apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, null, null, 0, paramString2, null, localBundle);
      return;
    }
    apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_a_of_type_Long, this.jdField_a_of_type_Apar.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Apar.a(), paramString2, this.jdField_a_of_type_Apar.b(), paramString1, null, localBundle);
  }
  
  protected void b(String paramString)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Apar != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > this.jdField_a_of_type_Apar.b()) {
          l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize - this.jdField_a_of_type_Apar.b();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (d()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", b());
    if (this.jdField_a_of_type_Apar != null)
    {
      apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.jdField_a_of_type_Apar.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Apar.b(), paramString, localBundle);
      apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.jdField_a_of_type_Apar.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Apar.b(), paramString, localBundle);
      return;
    }
    apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 0, paramString, localBundle);
    apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 0, paramString, localBundle);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize <= 0L) {}
    while (this.jdField_a_of_type_Apar == null) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Apar.a() * 100L / this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
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
    String str = "Now[" + l + "]startTime[" + this.jdField_a_of_type_Long + "]notifyTime[" + this.e + "]";
    l = 0L;
    if (this.jdField_a_of_type_Apar != null) {
      l = this.jdField_a_of_type_Apar.a();
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
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Apar != null)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Apar.a();
    }
    o();
  }
  
  public void g()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [Upload Step]Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdate success, go [SetFileStatus Step]");
    j();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    c(System.currentTimeMillis());
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Apar != null)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Apar.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(1003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_Apar.a() }, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aowi);
    apuf localapuf = new apuf();
    localapuf.jdField_b_of_type_JavaLangString = "send_file_suc";
    localapuf.jdField_a_of_type_Int = 1;
    apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapuf);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void h()
  {
    if (this.jdField_c_of_type_Boolean)
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
    this.jdField_d_of_type_Boolean = true;
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
      b(0L, 9005, apug.a());
      a(0L, 9005, apug.a());
      n();
    }
    label357:
    label758:
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
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath != null)
      {
        bool2 = bool1;
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData != null)
        {
          i = 0;
          if (!apei.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label782;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath.startsWith("https")) {
            break label770;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain)) {
            break label758;
          }
          bool1 = true;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain;
          bool2 = bool1;
          localObject2 = localObject1;
          if (i != 0)
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
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath != null)
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], resend serverPath:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath + " isHttpsOnResend:" + bool2 + " httpsDomainOnResend:" + (String)localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData != null) {
          this.jdField_a_of_type_Apar = aozx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), new String(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath, bool2, (String)localObject2);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Apar != null)
          {
            this.jdField_c_of_type_Boolean = true;
            this.jdField_a_of_type_Apar.a(this);
            if (!this.jdField_a_of_type_Apar.a(0L))
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
              break label357;
              i = 1;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              break label357;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath.startsWith("https")) {
                break label357;
              }
              i = 1;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              break label357;
              this.jdField_a_of_type_Apar = aozx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath);
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes("utf-8");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath().getBytes("utf-8");
        arrayOfByte = apug.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
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
        b(0L, 9005, apug.a());
        a(0L, 9005, apug.a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (byte[])localObject2, localUnsupportedEncodingException, arrayOfByte, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Aowi, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    } while (!QLog.isColorLevel());
    label770:
    label782:
    QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apax
 * JD-Core Version:    0.7.0.1
 */