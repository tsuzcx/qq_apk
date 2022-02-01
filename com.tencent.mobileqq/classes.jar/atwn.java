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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

public class atwn
  implements atvi, aubc
{
  protected int a;
  public long a;
  private atrl jdField_a_of_type_Atrl = new atwo(this);
  public atvs a;
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
  private String jdField_c_of_type_JavaLangString;
  protected boolean c;
  protected byte[] c;
  protected long d;
  private boolean d;
  protected byte[] d;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  
  public atwn(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
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
    paramInt = aunj.b(paramInt);
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
  
  private void a(atri paramatri)
  {
    a(1005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramatri.jdField_a_of_type_Int, paramatri.jdField_a_of_type_JavaLangString);
    QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]ResultCodeNoServerAddr ip = 0");
    int i = paramatri.jdField_a_of_type_Int;
    String str = paramatri.jdField_a_of_type_JavaLangString;
    if (paramatri.jdField_a_of_type_Int == 0)
    {
      i = 9048;
      str = "onUpSend ip url error";
    }
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, str);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, str);
  }
  
  private void a(atri paramatri, List<String> paramList)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    String str1 = null;
    short s = paramatri.jdField_a_of_type_Short;
    boolean bool1;
    if ((atyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramatri.jdField_d_of_type_Int == 2) && (!TextUtils.isEmpty(paramatri.jdField_c_of_type_JavaLangString)))
    {
      str1 = paramatri.jdField_c_of_type_JavaLangString;
      s = paramatri.jdField_b_of_type_Short;
      if (s == 0)
      {
        s = 443;
        bool1 = true;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          localArrayList.add(str2 + ":" + s);
        }
      }
      localArrayList.add(0, paramatri.jdField_b_of_type_JavaLangString + ":" + s);
      Object localObject = new ArrayList();
      if (paramList != null) {
        ((List)localObject).addAll(paramList);
      }
      ((List)localObject).add(0, paramatri.jdField_b_of_type_JavaLangString);
      if (!d()) {
        this.jdField_c_of_type_Boolean = bool1;
      }
      if (b(paramatri))
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload. is config enable IPv6. domain[" + paramatri.jdField_d_of_type_JavaLangString + "]");
        paramList = new atum(paramatri.jdField_d_of_type_JavaLangString, s);
        paramList = atul.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, 1);
        if ((paramList != null) && (!paramList.a()))
        {
          if (atul.a())
          {
            QLog.d("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload. debugIsDisableIPv4OnDoubleStack");
            localArrayList.clear();
            ((List)localObject).clear();
          }
          atul.a(paramList.jdField_a_of_type_JavaUtilList, localArrayList, false, false);
          atul.a(paramList.jdField_a_of_type_JavaUtilList, (List)localObject, true, false);
          this.jdField_b_of_type_Int = 2;
          if (paramList.jdField_a_of_type_Int == 1) {
            this.jdField_b_of_type_Int = 3;
          }
          QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload use IPv6. iplist:" + localArrayList.toString());
          bool2 = bool3;
        }
      }
      for (;;)
      {
        a(paramatri, bool1, str1, s, localArrayList, (List)localObject, bool2);
        return;
        this.jdField_b_of_type_Int = 1;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload use IPv4");
        bool2 = false;
        continue;
        this.jdField_b_of_type_Int = 1;
      }
      bool1 = true;
      continue;
      bool1 = false;
    }
  }
  
  private void a(atri paramatri, boolean paramBoolean1, String paramString, short paramShort, List<String> paramList1, List<String> paramList2, boolean paramBoolean2)
  {
    ThreadManager.post(new OfflineSendWorker.4(this, paramatri, paramBoolean1, paramString, paramList1, paramList2, paramShort, paramBoolean2), 5, null, false);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "start OfflineFileHitReq:" + bcrg.a());
    }
    aunu.a().execute(new OfflineSendWorker.2(this, paramString, paramLong, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte2, paramArrayOfByte1));
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong, atrl paramatrl, FileManagerEntity paramFileManagerEntity)
  {
    paramatrl = new aume();
    paramatrl.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    paramatrl.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramatrl.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramatrl.jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    paramFileManagerEntity.strFileMd5 = aubb.a(paramArrayOfByte3);
    paramatrl.jdField_c_of_type_ArrayOfByte = paramArrayOfByte3;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte3;
    byte[] arrayOfByte = new byte[paramArrayOfByte3.length + 4];
    bhvd.a(arrayOfByte, 0, paramArrayOfByte3, paramArrayOfByte3.length);
    bhvd.a(arrayOfByte, paramArrayOfByte3.length, paramFileManagerEntity.fileSize);
    this.jdField_c_of_type_JavaLangString = com.qq.taf.jce.HexUtil.bytes2HexStr(arrayOfByte).toLowerCase(Locale.US);
    int i;
    if (((atsh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).h()) {
      if (d())
      {
        i = 1;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform enabled");
      }
    }
    while (i != 0)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "多媒体平台, 不管大小统一使用v3 协议，采用小文件策略");
      paramatrl.jdField_a_of_type_Boolean = true;
      paramatrl.jdField_a_of_type_Int = 1700;
      paramString = aunj.a(new String(paramArrayOfByte1));
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
        paramFileManagerEntity.strFileSHA = aubb.a(paramString);
        a(paramString);
        paramatrl.e = paramString;
        a(false, paramatrl.e);
        paramatrl.jdField_d_of_type_ArrayOfByte = aunj.b(new String(paramArrayOfByte1));
        paramatrl.f = aunj.d(new String(paramArrayOfByte1));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramatrl, this.jdField_a_of_type_Atrl, paramFileManagerEntity);
      return;
      if (paramLong <= 104857600L)
      {
        paramatrl.jdField_a_of_type_Int = 1700;
        paramString = aunj.a(new String(paramArrayOfByte1));
        if (paramString == null)
        {
          a(null, 0);
          return;
        }
        k();
        paramFileManagerEntity.strFileSHA = aubb.a(paramString);
        a(paramString);
        paramatrl.e = paramString;
        a(false, paramatrl.e);
      }
      else
      {
        paramatrl.jdField_a_of_type_Int = 1600;
        arrayOfByte = aunj.d(new String(paramArrayOfByte1));
        if (arrayOfByte == null)
        {
          a(null, 0);
          return;
        }
        paramFileManagerEntity.strFileSha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(arrayOfByte);
        paramFileManagerEntity.str10Md5 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramArrayOfByte3);
        paramatrl.f = arrayOfByte;
        this.jdField_d_of_type_ArrayOfByte = arrayOfByte;
        a(paramString, paramArrayOfByte1, paramArrayOfByte2, paramLong, paramArrayOfByte3, arrayOfByte);
      }
    }
  }
  
  private boolean a(atri paramatri)
  {
    return (!paramatri.jdField_b_of_type_Boolean) && ((paramatri.jdField_b_of_type_JavaLangString == null) || (paramatri.jdField_b_of_type_JavaLangString.length() == 0));
  }
  
  private void b(long paramLong, int paramInt, String paramString)
  {
    b(paramLong, paramInt, paramString, null);
  }
  
  private void b(atri paramatri)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSendOfflineFile-->failed");
    a(1005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramatri.jdField_a_of_type_Int, paramatri.jdField_a_of_type_JavaLangString);
    int i = paramatri.jdField_a_of_type_Int;
    if (-100001 == paramatri.jdField_a_of_type_Int) {
      i = 9043;
    }
    String str = "server retError";
    if (paramatri.jdField_a_of_type_JavaLangString != null) {
      str = paramatri.jdField_a_of_type_JavaLangString;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, str);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, str);
  }
  
  private boolean b(atri paramatri)
  {
    return (!TextUtils.isEmpty(paramatri.jdField_d_of_type_JavaLangString)) && (atul.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1));
  }
  
  private boolean e()
  {
    if ((d()) && (c()) && (b()))
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "re sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], custom uploader handled");
      return true;
    }
    return false;
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
    aunj.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_Atrl);
    auni localauni = new auni();
    localauni.jdField_b_of_type_JavaLangString = "send_file_suc";
    localauni.jdField_a_of_type_Int = 1;
    aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localauni);
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
  
  public atvs a(atri paramatri, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
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
      if (this.jdField_a_of_type_Atvs != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Atvs.a() > this.jdField_a_of_type_Atvs.b()) {
          l1 = this.jdField_a_of_type_Atvs.a() - this.jdField_a_of_type_Atvs.b();
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
      if (this.jdField_a_of_type_Atvs != null) {
        break;
      }
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, null, paramString2, 0, paramString1, null, localBundle);
      return;
    }
    aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_a_of_type_Long, this.jdField_a_of_type_Atvs.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atvs.a(), paramString2, this.jdField_a_of_type_Atvs.b(), paramString1, null, localBundle);
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
      paramString1 = "[Http_RespValue_Null]" + aunj.a();
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
    if (this.jdField_a_of_type_Atvs != null) {
      this.jdField_a_of_type_Atvs.a();
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
      if (this.jdField_a_of_type_Atvs != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Atvs.a() > this.jdField_a_of_type_Atvs.b()) {
          l1 = this.jdField_a_of_type_Atvs.a() - this.jdField_a_of_type_Atvs.b();
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
      if (this.jdField_a_of_type_Atvs != null) {
        break;
      }
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, null, null, 0, paramString2, null, localBundle);
      return;
    }
    aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_a_of_type_Long, this.jdField_a_of_type_Atvs.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atvs.a(), paramString2, this.jdField_a_of_type_Atvs.b(), paramString1, null, localBundle);
  }
  
  protected void b(String paramString)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Atvs != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > this.jdField_a_of_type_Atvs.b()) {
          l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize - this.jdField_a_of_type_Atvs.b();
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
      if (this.jdField_a_of_type_Atvs == null) {
        break label327;
      }
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.jdField_a_of_type_Atvs.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atvs.b(), paramString, localBundle);
      if (!d()) {
        aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.jdField_a_of_type_Atvs.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atvs.b(), paramString, localBundle);
      }
    }
    label327:
    do
    {
      return;
      i = 0;
      break;
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 0, paramString, localBundle);
    } while (d());
    aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 0, paramString, localBundle);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize <= 0L) {}
    while (this.jdField_a_of_type_Atvs == null) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Atvs.a() * 100L / this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
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
    if (this.jdField_a_of_type_Atvs == null) {
      return 0;
    }
    return auoo.c(this.jdField_a_of_type_Atvs.a());
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
    if (this.jdField_a_of_type_Atvs != null) {
      l = this.jdField_a_of_type_Atvs.a();
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
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Atvs != null)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Atvs.a();
    }
    o();
  }
  
  public void g()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [Upload Step]Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdate success, go [SetFileStatus Step]");
    j();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    c(System.currentTimeMillis());
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Atvs != null)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Atvs.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(1003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_Atvs.a() }, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_Atrl);
    auni localauni = new auni();
    localauni.jdField_b_of_type_JavaLangString = "send_file_suc";
    localauni.jdField_a_of_type_Int = 1;
    aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localauni);
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
      b(0L, 9005, aunj.a());
      a(0L, 9005, aunj.a());
      n();
    }
    do
    {
      do
      {
        return;
        l();
      } while (e());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = "";
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      byte[] arrayOfByte2;
      byte[] arrayOfByte3;
      try
      {
        byte[] arrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes("utf-8");
        arrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath().getBytes("utf-8");
        arrayOfByte3 = aunj.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
        if (arrayOfByte3 == null)
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
        b(0L, 9005, aunj.a());
        a(0L, 9005, aunj.a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, arrayOfByte2, localUnsupportedEncodingException, arrayOfByte3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Atrl, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwn
 * JD-Core Version:    0.7.0.1
 */