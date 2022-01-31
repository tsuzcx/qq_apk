import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.4;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.5;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.9;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;

public class aozi
  implements apgs, bbmi
{
  public int a;
  public long a;
  private aowe jdField_a_of_type_Aowe = new aozj(this);
  private apam jdField_a_of_type_Apam;
  apec jdField_a_of_type_Apec = null;
  apsv jdField_a_of_type_Apsv = null;
  apsy jdField_a_of_type_Apsy = null;
  apti jdField_a_of_type_Apti = null;
  bbmg jdField_a_of_type_Bbmg;
  bgam jdField_a_of_type_Bgam;
  VFSFile jdField_a_of_type_ComTencentMmVfsVFSFile = null;
  public QQAppInterface a;
  public FileManagerEntity a;
  InputStream jdField_a_of_type_JavaIoInputStream = null;
  public OutputStream a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  public byte[] a;
  int[] jdField_a_of_type_ArrayOfInt = new int[0];
  public int b;
  public long b;
  public String b;
  boolean b;
  public byte[] b;
  int jdField_c_of_type_Int = 0;
  public long c;
  String jdField_c_of_type_JavaLangString;
  public byte[] c;
  int d;
  public long d;
  public String d;
  private int jdField_e_of_type_Int;
  long jdField_e_of_type_Long;
  public String e;
  private int jdField_f_of_type_Int;
  long jdField_f_of_type_Long = 0L;
  public String f;
  private int g;
  public long g;
  public String g;
  private int jdField_h_of_type_Int;
  long jdField_h_of_type_Long = 0L;
  public String h;
  private int i;
  public long i;
  public String i;
  long j;
  public String j;
  long jdField_k_of_type_Long = 0L;
  String jdField_k_of_type_JavaLangString = null;
  long jdField_l_of_type_Long = 0L;
  private String jdField_l_of_type_JavaLangString = "";
  private long m;
  
  public aozi(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    if (paramFileManagerEntity == null)
    {
      try
      {
        throw new NullPointerException("entry = null,why?");
      }
      catch (NullPointerException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      label178:
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramFileManagerEntity.getFilePath();
    this.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    this.jdField_g_of_type_JavaLangString = paramFileManagerEntity.Uuid;
    this.jdField_b_of_type_Int = paramFileManagerEntity.nOpType;
    this.jdField_f_of_type_JavaLangString = paramFileManagerEntity.strServerPath;
    this.jdField_e_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    this.jdField_a_of_type_Apti = apti.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName == null)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
        }
        b();
        switch (this.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
          this.jdField_b_of_type_Long = paramFileManagerEntity.uniseq;
          this.jdField_c_of_type_Long = paramFileManagerEntity.nSessionId;
          paramFileManagerEntity.status = 0;
          paramQQAppInterface.a().c(paramFileManagerEntity);
          paramFileManagerEntity.fProgress = 0.0F;
          paramFileManagerEntity.status = 2;
          if (this.jdField_a_of_type_Bgam != null) {
            break label178;
          }
          this.jdField_a_of_type_Bgam = new bgam();
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + paramFileManagerEntity.nSessionId + "]filepath[" + this.jdField_b_of_type_JavaLangString + "]:size[" + String.valueOf(paramFileManagerEntity.fileSize) + "]");
      }
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_i_of_type_JavaLangString = "actFileUp";
        this.jdField_j_of_type_JavaLangString = "actFileUpDetail";
      }
      for (;;)
      {
        if ((paramFileManagerEntity.getFilePath() == null) || (paramFileManagerEntity.getFilePath().length() <= 0)) {
          break label587;
        }
        this.jdField_a_of_type_ComTencentMmVfsVFSFile = new VFSFile(paramFileManagerEntity.getFilePath());
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_i_of_type_JavaLangString = "actDiscussFileUp";
          this.jdField_j_of_type_JavaLangString = "actDiscussFileUpDetail";
        }
      }
      label587:
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath");
      }
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramFileManagerEntity.fileName);
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_i_of_type_JavaLangString = "actFileDown";
        this.jdField_j_of_type_JavaLangString = "actFileDownDetail";
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile) {
          break label732;
        }
        this.jdField_i_of_type_JavaLangString = "actFileUfGenDownload";
        this.jdField_j_of_type_JavaLangString = "actFileUfGenDownloadDetail";
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_i_of_type_JavaLangString = "actFileDiscDownLoad";
          this.jdField_j_of_type_JavaLangString = "actFileDiscDownLoadDetail";
        }
      }
      label732:
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "download insert, nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
      }
      this.jdField_i_of_type_JavaLangString = "actFileWyDown";
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "upload insert nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
      }
      this.jdField_i_of_type_JavaLangString = "actFileWyUp";
    }
  }
  
  private String a(String paramString)
  {
    return "/ftn_handler/" + paramString;
  }
  
  private String a(String paramString1, String paramString2, long paramLong)
  {
    return "/?ver=2&ukey=" + paramString1 + "&filekey=" + paramString2 + "&filesize=" + paramLong;
  }
  
  private void a(long paramLong, aozr paramaozr)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
    paramaozr = new ArrayList();
    paramaozr.add(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_Apti.a(paramLong, paramaozr, SplashActivity.sTopActivity, new aozm(this));
  }
  
  private void a(long paramLong, String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] receviveFile, pos[" + paramLong + "]");
    if (this.jdField_a_of_type_Boolean) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Recv]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is stoped!");
    }
    do
    {
      return;
      String str2 = "bytes=" + paramLong + "-";
      bbmg localbbmg = new bbmg(this.jdField_f_of_type_JavaLangString, null, this, true);
      localbbmg.b(false);
      String str1 = "gprs";
      if (bbev.b(BaseApplication.getContext()) == 1) {
        str1 = "wifi";
      }
      localbbmg.a("Net-type", str1);
      localbbmg.a("cache-control", "no-cache");
      localbbmg.a("Range", str2);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "set cookie:" + paramString);
      }
      if (paramString != null) {
        localbbmg.a("Cookie", paramString);
      }
      localbbmg.b(1);
      localbbmg.a(true);
      localbbmg.jdField_b_of_type_Int = 0;
      localbbmg.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      localbbmg.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_c_of_type_Long);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recv http data RANGE[" + String.valueOf(str2) + "], peerType[" + String.valueOf(this.jdField_a_of_type_Int) + "]");
      localbbmg.a("Accept-Encoding", "identity");
      paramString = "";
      if (this.jdField_f_of_type_JavaLangString != null) {
        paramString = this.jdField_f_of_type_JavaLangString.toLowerCase();
      }
      if ((this.jdField_b_of_type_Boolean) && (paramString.startsWith("https")))
      {
        localbbmg.j = true;
        localbbmg.k = apam.a(this.jdField_f_of_type_JavaLangString);
        localbbmg.jdField_e_of_type_JavaLangString = this.jdField_k_of_type_JavaLangString;
      }
      localbbmg.jdField_a_of_type_Ayug = apue.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbbmg);
      this.jdField_a_of_type_Bbmg = localbbmg;
    } while (paramLong != 0L);
    a(2001);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 10, null, 6, null);
  }
  
  private void a(aowb paramaowb)
  {
    if (paramaowb.jdField_d_of_type_Int == 2)
    {
      if (paramaowb.a == 0) {
        paramaowb.a = 80;
      }
      this.jdField_f_of_type_JavaLangString = (paramaowb.jdField_b_of_type_JavaLangString + ":" + paramaowb.a);
      return;
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Apam.a();
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    this.jdField_i_of_type_Long += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step] Id[" + this.jdField_c_of_type_Long + "]sendFilePakage transferData null");
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_e_of_type_Int, "get Stream null", null);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_h_of_type_Int, "get Stream null", null);
      b(null, null);
    }
    do
    {
      return;
      localObject = new bbmg(paramString + "&bmd5=" + MD5.toMD5((byte[])localObject) + "&range=" + String.valueOf(paramLong), (byte[])localObject, this);
      ((bbmg)localObject).b(false);
      ((bbmg)localObject).a("cache-control", "no-cache");
      paramString = "gprs";
      if (bbev.b(BaseApplication.getContext()) == 1) {
        paramString = "wifi";
      }
      ((bbmg)localObject).a("Net-type", paramString);
      ((bbmg)localObject).a("Range", "bytes=" + paramLong + "-");
      ((bbmg)localObject).b("POST");
      ((bbmg)localObject).b(1);
      ((bbmg)localObject).jdField_b_of_type_Int = 0;
      ((bbmg)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      ((bbmg)localObject).jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_c_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_c_of_type_Long + "]send http data size[" + paramInt + "], peerType[" + this.jdField_a_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a((bbmg)localObject);
      this.jdField_a_of_type_Bbmg = ((bbmg)localObject);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送一个数据包,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
  
  private void a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Apsy = new apsy();
    this.jdField_a_of_type_Apsy.a(com.qq.taf.jce.HexUtil.bytes2HexStr(paramArrayOfByte), com.qq.taf.jce.HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte), com.qq.taf.jce.HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_Aowe);
    this.jdField_a_of_type_Apsv = new apsv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Apsy);
    this.jdField_a_of_type_Apsv.b();
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, aowe paramaowe, FileManagerEntity paramFileManagerEntity)
  {
    paramString = new apsx();
    paramString.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    paramString.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramString.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramString.jdField_a_of_type_Long = this.jdField_d_of_type_Long;
    paramString.jdField_c_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramLong <= 104857600L)
    {
      paramString.jdField_a_of_type_Int = 1700;
      this.jdField_b_of_type_ArrayOfByte = apue.a(new String(paramArrayOfByte1));
      if (this.jdField_b_of_type_ArrayOfByte == null)
      {
        a(null, 0);
        return;
      }
      paramString.d = this.jdField_b_of_type_ArrayOfByte;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], filesize < 100 get sha1");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, this.jdField_a_of_type_Aowe, paramFileManagerEntity);
      return;
      paramString.jdField_a_of_type_Int = 1600;
      this.jdField_c_of_type_ArrayOfByte = apue.c(new String(paramArrayOfByte1));
      paramFileManagerEntity.strFileSha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte);
      paramFileManagerEntity.str10Md5 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      if (this.jdField_c_of_type_ArrayOfByte == null)
      {
        a(null, 0);
        return;
      }
      paramString.e = this.jdField_c_of_type_ArrayOfByte;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], filesize > 100 get sha3");
    }
  }
  
  private boolean a(bbmg parambbmg1, bbmg parambbmg2)
  {
    if (parambbmg1 == null) {}
    do
    {
      return false;
      if (parambbmg2 == null) {
        return true;
      }
    } while (!bbev.d(BaseApplication.getContext()));
    return true;
  }
  
  private static String c()
  {
    try
    {
      Thread.sleep(1L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void k()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Download]Id[" + this.jdField_c_of_type_Long + "] downLoad Success!");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apue.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = awzw.a();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Http Download]Id[" + this.jdField_c_of_type_Long + "] update successTime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    int n = this.jdField_b_of_type_JavaLangString.length() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250 - n)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 250 - n);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    if (bbdj.a(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = apue.b(this.jdField_b_of_type_JavaLangString);
    }
    try
    {
      if (!apue.a(new VFSFile(this.jdField_d_of_type_JavaLangString), new VFSFile(this.jdField_b_of_type_JavaLangString)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.jdField_d_of_type_JavaLangString + "],strFilePath[" + this.jdField_b_of_type_JavaLangString + "]");
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_e_of_type_Int, "rename error", null);
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_h_of_type_Int, "rename error", null);
        b(null, null);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      localObject = com.qq.taf.jce.HexUtil.bytes2HexStr(apue.d(this.jdField_b_of_type_JavaLangString));
      if (localObject != null) {
        break label1203;
      }
    }
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
    apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "mathMd5 is null", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_h_of_type_Int, "rename error", null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apue.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = apgp.a(apue.b(this.jdField_b_of_type_JavaLangString));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < 104857600L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = apgp.a(apue.a(this.jdField_b_of_type_JavaLangString));
      }
    }
    Object localObject = new VFSFile(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = ((VFSFile)localObject).lastModified();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(2003);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recive success, set TrafficData,size[" + String.valueOf(this.jdField_a_of_type_Long) + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_h_of_type_Int, null);
    apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_h_of_type_Int, null);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      apuw.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      apuw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (;;)
    {
      apue.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("FILE_TMP_SERVER_PATH", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath);
        ((Bundle)localObject).putLong("FILE_TMP_RELATED_ID", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId);
        ((Bundle)localObject).putString("FILE_TMP_DIR_PATH", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath);
        ((Bundle)localObject).putBoolean("FILE_TMP_IS_ZIPINNER_FILE", true);
        ((Bundle)localObject).putString("FILE_TMP_ZIP_FILEID", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipFileId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(null, -1, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long, 190, null, (Bundle)localObject);
      }
      localObject = new apud();
      ((apud)localObject).jdField_b_of_type_JavaLangString = "rece_file_suc";
      ((apud)localObject).jdField_a_of_type_Int = 1;
      apuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apud)localObject);
      return;
      label1203:
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "md5 is not equal", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_h_of_type_Int, "rename error", null);
        break;
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
        apue.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
  }
  
  private void l()
  {
    if (!bbev.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
      if (bbay.a()) {}
      for (long l1 = bbay.a() * 1024L; l1 < l2; l1 = bbay.b() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
        return;
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_Apec = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localFileManagerEntity, null, new aozp(this, localFileManagerEntity));
    } while (this.jdField_a_of_type_Apec == null);
    this.jdField_a_of_type_Apec.a(localFileManagerEntity.WeiYunFileId);
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "start Rsworker OfflineFileHitReq:" + awzw.a());
    }
    apuq.a().execute(new FileManagerRSWorker.9(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = this.jdField_a_of_type_Apti.b();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = c();
    }
    paramString1 = new File(str + paramString1);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
    return paramString1.getAbsoluteFile().toString();
  }
  
  public void a(int paramInt)
  {
    paramInt = apue.b(paramInt);
    if ((this.jdField_i_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_i_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
    } while (paramInt == 2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin = this.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (this.jdField_g_of_type_JavaLangString != null) {}
    for (String str = this.jdField_g_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)
    {
      localFileManagerEntity.Uuid = str;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
  }
  
  /* Error */
  public void a(bbmg parambbmg1, bbmg parambbmg2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	aozi:jdField_a_of_type_ArrayOfInt	[I
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: aload_0
    //   10: invokevirtual 915	aozi:a	()Z
    //   13: ifeq +55 -> 68
    //   16: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +45 -> 64
    //   22: ldc_w 550
    //   25: iconst_2
    //   26: new 217	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 917
    //   36: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   43: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   46: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 919
    //   55: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload 12
    //   66: monitorexit
    //   67: return
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   73: if_acmpeq +305 -> 378
    //   76: aload_1
    //   77: ifnull +92 -> 169
    //   80: aload_0
    //   81: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   84: ifnull +85 -> 169
    //   87: ldc 215
    //   89: iconst_1
    //   90: new 217	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 921
    //   100: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 56	aozi:jdField_c_of_type_Long	J
    //   107: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   110: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 923
    //   116: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 925	bbmg:a	()I
    //   123: invokestatic 431	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   126: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 927
    //   132: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   139: invokevirtual 925	bbmg:a	()I
    //   142: invokestatic 431	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 239
    //   150: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 12
    //   161: monitorexit
    //   162: return
    //   163: astore_1
    //   164: aload 12
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: aload_1
    //   170: ifnull +142 -> 312
    //   173: ldc 215
    //   175: iconst_1
    //   176: new 217	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 921
    //   186: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: getfield 56	aozi:jdField_c_of_type_Long	J
    //   193: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 923
    //   202: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 925	bbmg:a	()I
    //   209: invokestatic 431	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   212: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 239
    //   217: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto -67 -> 159
    //   229: astore 10
    //   231: aload 10
    //   233: invokevirtual 928	java/lang/Exception:printStackTrace	()V
    //   236: ldc 215
    //   238: iconst_1
    //   239: aload 10
    //   241: invokevirtual 929	java/lang/Exception:toString	()Ljava/lang/String;
    //   244: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: ldc 103
    //   249: astore 9
    //   251: aload 10
    //   253: invokevirtual 933	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   256: astore 10
    //   258: aload 10
    //   260: arraylength
    //   261: istore 4
    //   263: iconst_0
    //   264: istore_3
    //   265: iload_3
    //   266: iload 4
    //   268: if_icmpge +2061 -> 2329
    //   271: aload 10
    //   273: iload_3
    //   274: aaload
    //   275: astore 11
    //   277: new 217	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   284: aload 9
    //   286: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 11
    //   291: invokevirtual 936	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   294: ldc_w 938
    //   297: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore 9
    //   305: iload_3
    //   306: iconst_1
    //   307: iadd
    //   308: istore_3
    //   309: goto -44 -> 265
    //   312: aload_0
    //   313: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   316: ifnull -157 -> 159
    //   319: ldc 215
    //   321: iconst_1
    //   322: new 217	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 921
    //   332: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 56	aozi:jdField_c_of_type_Long	J
    //   339: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   342: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc_w 940
    //   348: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_0
    //   352: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   355: invokevirtual 925	bbmg:a	()I
    //   358: invokestatic 431	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   361: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc 239
    //   366: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto -216 -> 159
    //   378: aload_0
    //   379: getfield 144	aozi:jdField_b_of_type_Int	I
    //   382: ifne +1135 -> 1517
    //   385: aload_2
    //   386: invokevirtual 942	bbmg:c	()I
    //   389: sipush 200
    //   392: if_icmpne +885 -> 1277
    //   395: aload_0
    //   396: getfield 204	aozi:jdField_a_of_type_Bgam	Lbgam;
    //   399: invokevirtual 943	bgam:b	()V
    //   402: aload_2
    //   403: ldc_w 945
    //   406: invokevirtual 946	bbmg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   409: ifnull +2099 -> 2508
    //   412: aload_2
    //   413: ldc_w 945
    //   416: invokevirtual 946	bbmg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokestatic 950	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   422: lstore 5
    //   424: lload 5
    //   426: lconst_0
    //   427: lcmp
    //   428: ifeq +145 -> 573
    //   431: aload_0
    //   432: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   435: aload_0
    //   436: getfield 56	aozi:jdField_c_of_type_Long	J
    //   439: aload_0
    //   440: getfield 82	aozi:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   443: aload_0
    //   444: getfield 70	aozi:jdField_g_of_type_Long	J
    //   447: aload_0
    //   448: getfield 149	aozi:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   455: aload_0
    //   456: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   459: aload_0
    //   460: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   463: getfield 517	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   466: ldc2_w 951
    //   469: ldc 103
    //   471: aload_0
    //   472: getfield 97	aozi:jdField_i_of_type_Long	J
    //   475: aload_0
    //   476: getfield 50	aozi:jdField_a_of_type_Long	J
    //   479: aload_0
    //   480: getfield 58	aozi:jdField_d_of_type_Long	J
    //   483: aload_2
    //   484: invokevirtual 953	bbmg:b	()Ljava/lang/String;
    //   487: aload_2
    //   488: getfield 954	bbmg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   491: aload_0
    //   492: getfield 526	aozi:jdField_h_of_type_Int	I
    //   495: new 217	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 956
    //   505: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: lload 5
    //   510: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   513: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc 239
    //   518: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: aconst_null
    //   525: invokestatic 524	apue:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   528: ldc 215
    //   530: iconst_1
    //   531: new 217	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 958
    //   541: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: lload 5
    //   546: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   549: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc 239
    //   554: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aload_0
    //   564: aload_1
    //   565: aload_2
    //   566: invokevirtual 529	aozi:b	(Lbbmg;Lbbmg;)V
    //   569: aload 12
    //   571: monitorexit
    //   572: return
    //   573: aload_2
    //   574: ldc_w 409
    //   577: invokevirtual 946	bbmg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   580: astore 9
    //   582: aload 9
    //   584: ifnull +1918 -> 2502
    //   587: aload 9
    //   589: invokestatic 950	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   592: lstore 5
    //   594: lload 5
    //   596: aload_0
    //   597: getfield 50	aozi:jdField_a_of_type_Long	J
    //   600: lcmp
    //   601: ifgt +365 -> 966
    //   604: new 217	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 960
    //   614: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: lload 5
    //   619: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   622: ldc_w 962
    //   625: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: aload_0
    //   629: getfield 50	aozi:jdField_a_of_type_Long	J
    //   632: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   635: ldc_w 964
    //   638: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_0
    //   642: getfield 966	aozi:m	J
    //   645: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   648: ldc_w 968
    //   651: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload_0
    //   655: getfield 101	aozi:jdField_c_of_type_Int	I
    //   658: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: ldc 239
    //   663: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: astore 9
    //   671: lload 5
    //   673: aload_0
    //   674: getfield 966	aozi:m	J
    //   677: lcmp
    //   678: ifgt +176 -> 854
    //   681: aload_0
    //   682: getfield 101	aozi:jdField_c_of_type_Int	I
    //   685: iconst_1
    //   686: iadd
    //   687: istore_3
    //   688: aload_0
    //   689: iload_3
    //   690: putfield 101	aozi:jdField_c_of_type_Int	I
    //   693: iload_3
    //   694: iconst_3
    //   695: if_icmple +159 -> 854
    //   698: aload_0
    //   699: sipush 1005
    //   702: invokevirtual 248	aozi:a	(I)V
    //   705: aload_0
    //   706: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   709: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Laozc;
    //   712: aload_0
    //   713: getfield 54	aozi:jdField_b_of_type_Long	J
    //   716: aload_0
    //   717: getfield 56	aozi:jdField_c_of_type_Long	J
    //   720: aload_0
    //   721: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   724: aload_0
    //   725: getfield 134	aozi:jdField_a_of_type_Int	I
    //   728: bipush 15
    //   730: aconst_null
    //   731: iconst_5
    //   732: aconst_null
    //   733: invokevirtual 480	aozc:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   736: aload_0
    //   737: invokevirtual 969	aozi:b	()V
    //   740: aload_0
    //   741: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   744: aload_0
    //   745: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   748: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   751: aload_0
    //   752: getfield 80	aozi:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   755: aload_0
    //   756: getfield 70	aozi:jdField_g_of_type_Long	J
    //   759: aload_0
    //   760: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   763: aload_0
    //   764: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   767: aload_0
    //   768: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   771: aload_0
    //   772: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   775: getfield 517	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   778: ldc2_w 970
    //   781: ldc 103
    //   783: aload_0
    //   784: getfield 97	aozi:jdField_i_of_type_Long	J
    //   787: aload_0
    //   788: getfield 50	aozi:jdField_a_of_type_Long	J
    //   791: aload_0
    //   792: getfield 58	aozi:jdField_d_of_type_Long	J
    //   795: aload_0
    //   796: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   799: ldc 103
    //   801: aload_0
    //   802: getfield 309	aozi:jdField_e_of_type_Int	I
    //   805: aload 9
    //   807: aconst_null
    //   808: invokestatic 524	apue:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   811: ldc 215
    //   813: iconst_1
    //   814: new 217	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   821: ldc_w 973
    //   824: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: aload_0
    //   828: getfield 56	aozi:jdField_c_of_type_Long	J
    //   831: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   834: ldc 239
    //   836: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: aload 9
    //   841: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 976	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: aload 12
    //   852: monitorexit
    //   853: return
    //   854: aload_0
    //   855: lload 5
    //   857: putfield 966	aozi:m	J
    //   860: aload_0
    //   861: lload 5
    //   863: putfield 50	aozi:jdField_a_of_type_Long	J
    //   866: new 978	android/os/Handler
    //   869: dup
    //   870: invokespecial 979	android/os/Handler:<init>	()V
    //   873: new 981	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker$2
    //   876: dup
    //   877: aload_0
    //   878: lload 5
    //   880: invokespecial 984	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker$2:<init>	(Laozi;J)V
    //   883: ldc2_w 985
    //   886: invokevirtual 990	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   889: pop
    //   890: aload_0
    //   891: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   894: aload_0
    //   895: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   898: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   901: aload_0
    //   902: getfield 82	aozi:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   905: aload_0
    //   906: getfield 70	aozi:jdField_g_of_type_Long	J
    //   909: aload_0
    //   910: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   913: aload_0
    //   914: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   917: aload_0
    //   918: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   921: aload_0
    //   922: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   925: getfield 517	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   928: ldc2_w 970
    //   931: ldc 103
    //   933: aload_0
    //   934: getfield 97	aozi:jdField_i_of_type_Long	J
    //   937: aload_0
    //   938: getfield 50	aozi:jdField_a_of_type_Long	J
    //   941: aload_0
    //   942: getfield 58	aozi:jdField_d_of_type_Long	J
    //   945: aload_0
    //   946: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   949: aload_2
    //   950: getfield 954	bbmg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   953: aload_0
    //   954: getfield 526	aozi:jdField_h_of_type_Int	I
    //   957: aload 9
    //   959: aconst_null
    //   960: invokestatic 524	apue:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   963: goto -152 -> 811
    //   966: iconst_0
    //   967: istore 4
    //   969: iload 4
    //   971: istore_3
    //   972: aload_0
    //   973: getfield 50	aozi:jdField_a_of_type_Long	J
    //   976: lconst_0
    //   977: lcmp
    //   978: ifne +59 -> 1037
    //   981: iload 4
    //   983: istore_3
    //   984: lload 5
    //   986: aload_0
    //   987: getfield 58	aozi:jdField_d_of_type_Long	J
    //   990: lcmp
    //   991: ifne +46 -> 1037
    //   994: ldc 215
    //   996: iconst_1
    //   997: new 217	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1004: ldc_w 992
    //   1007: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: aload_0
    //   1011: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1014: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1017: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1020: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: ldc_w 994
    //   1026: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: iconst_1
    //   1036: istore_3
    //   1037: aload_0
    //   1038: lload 5
    //   1040: putfield 50	aozi:jdField_a_of_type_Long	J
    //   1043: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1046: ifeq +72 -> 1118
    //   1049: ldc 215
    //   1051: iconst_2
    //   1052: new 217	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1059: ldc 220
    //   1061: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload_0
    //   1065: getfield 56	aozi:jdField_c_of_type_Long	J
    //   1068: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1071: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: ldc_w 548
    //   1077: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: aload_0
    //   1081: getfield 50	aozi:jdField_a_of_type_Long	J
    //   1084: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1087: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: ldc_w 996
    //   1093: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: aload_0
    //   1097: getfield 58	aozi:jdField_d_of_type_Long	J
    //   1100: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1103: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: ldc_w 998
    //   1109: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1118: lload 5
    //   1120: aload_0
    //   1121: getfield 58	aozi:jdField_d_of_type_Long	J
    //   1124: lcmp
    //   1125: ifge +156 -> 1281
    //   1128: aload_0
    //   1129: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1132: aload_0
    //   1133: getfield 50	aozi:jdField_a_of_type_Long	J
    //   1136: l2f
    //   1137: aload_0
    //   1138: getfield 58	aozi:jdField_d_of_type_Long	J
    //   1141: l2f
    //   1142: fdiv
    //   1143: putfield 202	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1146: aload_0
    //   1147: sipush 1002
    //   1150: invokevirtual 248	aozi:a	(I)V
    //   1153: invokestatic 647	java/lang/System:currentTimeMillis	()J
    //   1156: lstore 5
    //   1158: lload 5
    //   1160: aload_0
    //   1161: getfield 66	aozi:jdField_f_of_type_Long	J
    //   1164: lsub
    //   1165: ldc2_w 999
    //   1168: lcmp
    //   1169: iflt +91 -> 1260
    //   1172: aload_0
    //   1173: lload 5
    //   1175: putfield 66	aozi:jdField_f_of_type_Long	J
    //   1178: aload_0
    //   1179: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1182: iconst_3
    //   1183: invokevirtual 747	com/tencent/mobileqq/filemanager/data/FileManagerEntity:setCloudType	(I)V
    //   1186: aload_0
    //   1187: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1190: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Laozc;
    //   1193: aload_0
    //   1194: getfield 54	aozi:jdField_b_of_type_Long	J
    //   1197: aload_0
    //   1198: getfield 56	aozi:jdField_c_of_type_Long	J
    //   1201: aload_0
    //   1202: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1205: aload_0
    //   1206: getfield 134	aozi:jdField_a_of_type_Int	I
    //   1209: bipush 16
    //   1211: aconst_null
    //   1212: iconst_0
    //   1213: aconst_null
    //   1214: invokevirtual 480	aozc:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   1217: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1220: ifeq +40 -> 1260
    //   1223: ldc 215
    //   1225: iconst_2
    //   1226: new 217	java/lang/StringBuilder
    //   1229: dup
    //   1230: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1233: ldc 220
    //   1235: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: aload_0
    //   1239: getfield 56	aozi:jdField_c_of_type_Long	J
    //   1242: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1245: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: ldc_w 1002
    //   1251: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1260: aload_0
    //   1261: iconst_0
    //   1262: putfield 309	aozi:jdField_e_of_type_Int	I
    //   1265: aload_0
    //   1266: aload_0
    //   1267: getfield 149	aozi:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1270: aload_0
    //   1271: getfield 50	aozi:jdField_a_of_type_Long	J
    //   1274: invokevirtual 1004	aozi:a	(Ljava/lang/String;J)V
    //   1277: aload 12
    //   1279: monitorexit
    //   1280: return
    //   1281: aload_0
    //   1282: invokestatic 647	java/lang/System:currentTimeMillis	()J
    //   1285: putfield 99	aozi:jdField_j_of_type_Long	J
    //   1288: aload_0
    //   1289: invokestatic 647	java/lang/System:currentTimeMillis	()J
    //   1292: putfield 72	aozi:jdField_h_of_type_Long	J
    //   1295: iload_3
    //   1296: ifne +108 -> 1404
    //   1299: aload_0
    //   1300: invokevirtual 1006	aozi:j	()V
    //   1303: ldc 215
    //   1305: iconst_1
    //   1306: new 217	java/lang/StringBuilder
    //   1309: dup
    //   1310: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1313: ldc_w 992
    //   1316: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: aload_0
    //   1320: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1323: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1326: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1329: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: ldc_w 1008
    //   1335: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1341: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1344: new 808	apud
    //   1347: dup
    //   1348: invokespecial 809	apud:<init>	()V
    //   1351: astore 9
    //   1353: aload 9
    //   1355: ldc_w 1010
    //   1358: putfield 812	apud:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1361: aload 9
    //   1363: iconst_1
    //   1364: putfield 813	apud:jdField_a_of_type_Int	I
    //   1367: aload_0
    //   1368: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1371: invokevirtual 816	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1374: aload 9
    //   1376: invokestatic 821	apuc:a	(Ljava/lang/String;Lapud;)V
    //   1379: aload_0
    //   1380: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1383: iconst_1
    //   1384: putfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   1387: aload_0
    //   1388: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1391: invokevirtual 193	com/tencent/mobileqq/app/QQAppInterface:a	()Laoza;
    //   1394: aload_0
    //   1395: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1398: invokevirtual 198	aoza:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   1401: goto -124 -> 1277
    //   1404: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1407: ifeq +45 -> 1452
    //   1410: ldc_w 550
    //   1413: iconst_2
    //   1414: new 217	java/lang/StringBuilder
    //   1417: dup
    //   1418: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1421: ldc_w 917
    //   1424: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: aload_0
    //   1428: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1431: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1434: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1437: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: ldc_w 1012
    //   1443: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1449: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1452: aload_0
    //   1453: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1456: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1459: invokestatic 1014	apue:b	(J)V
    //   1462: aload_0
    //   1463: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1466: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Laozc;
    //   1469: aload_0
    //   1470: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1473: iconst_5
    //   1474: aload_0
    //   1475: getfield 149	aozi:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1478: invokevirtual 1017	aozc:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;ILjava/lang/String;)V
    //   1481: aload_0
    //   1482: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1485: invokevirtual 607	com/tencent/mobileqq/app/QQAppInterface:a	()Laovy;
    //   1488: aload_0
    //   1489: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1492: aload_0
    //   1493: getfield 170	aozi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1496: aload_0
    //   1497: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1500: aload_0
    //   1501: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1504: getfield 137	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   1507: aload_0
    //   1508: getfield 95	aozi:jdField_a_of_type_Aowe	Laowe;
    //   1511: invokevirtual 1020	aovy:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laowe;)V
    //   1514: goto -211 -> 1303
    //   1517: aload_2
    //   1518: invokevirtual 942	bbmg:c	()I
    //   1521: sipush 206
    //   1524: if_icmpeq +15 -> 1539
    //   1527: aload_2
    //   1528: invokevirtual 942	bbmg:c	()I
    //   1531: istore_3
    //   1532: iload_3
    //   1533: sipush 200
    //   1536: if_icmpne -259 -> 1277
    //   1539: aload_0
    //   1540: getfield 62	aozi:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1543: aload_2
    //   1544: invokevirtual 1022	bbmg:a	()[B
    //   1547: invokevirtual 1027	java/io/OutputStream:write	([B)V
    //   1550: aload_0
    //   1551: iconst_0
    //   1552: putfield 309	aozi:jdField_e_of_type_Int	I
    //   1555: aload_2
    //   1556: invokevirtual 1022	bbmg:a	()[B
    //   1559: arraylength
    //   1560: i2l
    //   1561: lstore 5
    //   1563: aload_0
    //   1564: aload_0
    //   1565: getfield 97	aozi:jdField_i_of_type_Long	J
    //   1568: lload 5
    //   1570: ladd
    //   1571: putfield 97	aozi:jdField_i_of_type_Long	J
    //   1574: aload_0
    //   1575: lload 5
    //   1577: aload_0
    //   1578: getfield 50	aozi:jdField_a_of_type_Long	J
    //   1581: ladd
    //   1582: putfield 50	aozi:jdField_a_of_type_Long	J
    //   1585: aload_0
    //   1586: getfield 58	aozi:jdField_d_of_type_Long	J
    //   1589: lstore 5
    //   1591: aload_2
    //   1592: invokevirtual 1028	bbmg:a	()J
    //   1595: lstore 5
    //   1597: aload_0
    //   1598: getfield 50	aozi:jdField_a_of_type_Long	J
    //   1601: lload 5
    //   1603: lcmp
    //   1604: iflt +615 -> 2219
    //   1607: aload_0
    //   1608: getfield 134	aozi:jdField_a_of_type_Int	I
    //   1611: sipush 3000
    //   1614: if_icmpeq +70 -> 1684
    //   1617: aload_0
    //   1618: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1621: getfield 1031	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   1624: ifne +60 -> 1684
    //   1627: ldc 215
    //   1629: iconst_1
    //   1630: new 217	java/lang/StringBuilder
    //   1633: dup
    //   1634: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1637: ldc_w 1033
    //   1640: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: aload_0
    //   1644: getfield 56	aozi:jdField_c_of_type_Long	J
    //   1647: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1650: ldc_w 1035
    //   1653: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1659: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1662: aload_0
    //   1663: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1666: invokevirtual 607	com/tencent/mobileqq/app/QQAppInterface:a	()Laovy;
    //   1669: aload_0
    //   1670: getfield 170	aozi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1673: aload_0
    //   1674: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1677: aload_0
    //   1678: getfield 95	aozi:jdField_a_of_type_Aowe	Laowe;
    //   1681: invokevirtual 1038	aovy:a	(Ljava/lang/String;Ljava/lang/String;Laowe;)V
    //   1684: aload_0
    //   1685: aconst_null
    //   1686: putfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   1689: aload_0
    //   1690: getfield 62	aozi:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1693: invokevirtual 1041	java/io/OutputStream:close	()V
    //   1696: aload_0
    //   1697: aconst_null
    //   1698: putfield 62	aozi:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1701: aload_0
    //   1702: invokespecial 1043	aozi:k	()V
    //   1705: goto -428 -> 1277
    //   1708: astore 9
    //   1710: aload 9
    //   1712: invokevirtual 1046	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1715: ldc_w 1048
    //   1718: invokevirtual 1052	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1721: ifeq +125 -> 1846
    //   1724: aload_0
    //   1725: monitorenter
    //   1726: aload_0
    //   1727: iconst_1
    //   1728: putfield 68	aozi:jdField_a_of_type_Boolean	Z
    //   1731: aload_0
    //   1732: monitorexit
    //   1733: aload_0
    //   1734: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   1737: ifnull +82 -> 1819
    //   1740: ldc 215
    //   1742: iconst_2
    //   1743: new 217	java/lang/StringBuilder
    //   1746: dup
    //   1747: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1750: ldc_w 704
    //   1753: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: aload_0
    //   1757: getfield 56	aozi:jdField_c_of_type_Long	J
    //   1760: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1763: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: ldc_w 1054
    //   1769: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1772: aload_0
    //   1773: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   1776: invokevirtual 925	bbmg:a	()I
    //   1779: invokestatic 431	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1782: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1785: ldc_w 1056
    //   1788: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1791: aload 9
    //   1793: invokevirtual 1046	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1796: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1802: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1805: aload_0
    //   1806: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1809: invokevirtual 465	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   1812: aload_0
    //   1813: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   1816: invokevirtual 1059	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmg;)V
    //   1819: aload_0
    //   1820: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1823: invokevirtual 333	com/tencent/mobileqq/app/QQAppInterface:a	()Laoze;
    //   1826: iconst_0
    //   1827: invokevirtual 338	aoze:a	(Z)V
    //   1830: aload_0
    //   1831: aload_0
    //   1832: getfield 58	aozi:jdField_d_of_type_Long	J
    //   1835: new 1061	aozn
    //   1838: dup
    //   1839: aload_0
    //   1840: invokespecial 1062	aozn:<init>	(Laozi;)V
    //   1843: invokespecial 500	aozi:a	(JLaozr;)V
    //   1846: aload_0
    //   1847: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1850: aload_0
    //   1851: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1854: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1857: aload_0
    //   1858: getfield 80	aozi:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1861: aload_0
    //   1862: getfield 70	aozi:jdField_g_of_type_Long	J
    //   1865: aload_0
    //   1866: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1869: aload_0
    //   1870: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1873: aload_0
    //   1874: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1877: aload_0
    //   1878: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1881: getfield 517	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1884: ldc2_w 518
    //   1887: ldc 103
    //   1889: aload_0
    //   1890: getfield 97	aozi:jdField_i_of_type_Long	J
    //   1893: aload_0
    //   1894: getfield 50	aozi:jdField_a_of_type_Long	J
    //   1897: aload_0
    //   1898: getfield 58	aozi:jdField_d_of_type_Long	J
    //   1901: aload_0
    //   1902: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1905: ldc 103
    //   1907: aload_0
    //   1908: getfield 309	aozi:jdField_e_of_type_Int	I
    //   1911: ldc_w 1064
    //   1914: aconst_null
    //   1915: invokestatic 524	apue:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1918: aload_0
    //   1919: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1922: aload_0
    //   1923: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1926: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1929: aload_0
    //   1930: getfield 82	aozi:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1933: aload_0
    //   1934: getfield 70	aozi:jdField_g_of_type_Long	J
    //   1937: aload_0
    //   1938: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1941: aload_0
    //   1942: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1945: aload_0
    //   1946: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1949: aload_0
    //   1950: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1953: getfield 517	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1956: ldc2_w 518
    //   1959: ldc 103
    //   1961: aload_0
    //   1962: getfield 97	aozi:jdField_i_of_type_Long	J
    //   1965: aload_0
    //   1966: getfield 50	aozi:jdField_a_of_type_Long	J
    //   1969: aload_0
    //   1970: getfield 58	aozi:jdField_d_of_type_Long	J
    //   1973: aload_0
    //   1974: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1977: ldc 103
    //   1979: aload_0
    //   1980: getfield 526	aozi:jdField_h_of_type_Int	I
    //   1983: ldc_w 1064
    //   1986: aconst_null
    //   1987: invokestatic 524	apue:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1990: aload_0
    //   1991: aconst_null
    //   1992: aconst_null
    //   1993: invokevirtual 529	aozi:b	(Lbbmg;Lbbmg;)V
    //   1996: aload 12
    //   1998: monitorexit
    //   1999: return
    //   2000: astore 9
    //   2002: aload_0
    //   2003: monitorexit
    //   2004: aload 9
    //   2006: athrow
    //   2007: astore 9
    //   2009: aload_0
    //   2010: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2013: aload_0
    //   2014: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2017: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2020: aload_0
    //   2021: getfield 80	aozi:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   2024: aload_0
    //   2025: getfield 70	aozi:jdField_g_of_type_Long	J
    //   2028: aload_0
    //   2029: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2032: aload_0
    //   2033: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2036: aload_0
    //   2037: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2040: aload_0
    //   2041: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2044: getfield 517	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2047: ldc2_w 518
    //   2050: ldc 103
    //   2052: aload_0
    //   2053: getfield 97	aozi:jdField_i_of_type_Long	J
    //   2056: aload_0
    //   2057: getfield 50	aozi:jdField_a_of_type_Long	J
    //   2060: aload_0
    //   2061: getfield 58	aozi:jdField_d_of_type_Long	J
    //   2064: aload_0
    //   2065: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2068: ldc 103
    //   2070: aload_0
    //   2071: getfield 309	aozi:jdField_e_of_type_Int	I
    //   2074: ldc_w 1064
    //   2077: aconst_null
    //   2078: invokestatic 524	apue:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2081: aload_0
    //   2082: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2085: aload_0
    //   2086: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2089: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2092: aload_0
    //   2093: getfield 82	aozi:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   2096: aload_0
    //   2097: getfield 70	aozi:jdField_g_of_type_Long	J
    //   2100: aload_0
    //   2101: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2104: aload_0
    //   2105: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2108: aload_0
    //   2109: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2112: aload_0
    //   2113: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2116: getfield 517	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2119: ldc2_w 518
    //   2122: ldc 103
    //   2124: aload_0
    //   2125: getfield 97	aozi:jdField_i_of_type_Long	J
    //   2128: aload_0
    //   2129: getfield 50	aozi:jdField_a_of_type_Long	J
    //   2132: aload_0
    //   2133: getfield 58	aozi:jdField_d_of_type_Long	J
    //   2136: aload_0
    //   2137: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2140: ldc 103
    //   2142: aload_0
    //   2143: getfield 526	aozi:jdField_h_of_type_Int	I
    //   2146: ldc_w 1064
    //   2149: aconst_null
    //   2150: invokestatic 524	apue:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2153: aload_0
    //   2154: aconst_null
    //   2155: aconst_null
    //   2156: invokevirtual 529	aozi:b	(Lbbmg;Lbbmg;)V
    //   2159: aload 12
    //   2161: monitorexit
    //   2162: return
    //   2163: astore 9
    //   2165: ldc_w 1066
    //   2168: iconst_1
    //   2169: new 217	java/lang/StringBuilder
    //   2172: dup
    //   2173: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   2176: ldc 220
    //   2178: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2181: aload_0
    //   2182: getfield 56	aozi:jdField_c_of_type_Long	J
    //   2185: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2188: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2191: ldc_w 1068
    //   2194: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: aload 9
    //   2199: invokevirtual 1069	java/io/IOException:toString	()Ljava/lang/String;
    //   2202: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2208: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2211: aload 9
    //   2213: invokevirtual 1070	java/io/IOException:printStackTrace	()V
    //   2216: goto -520 -> 1696
    //   2219: aload_0
    //   2220: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2223: aload_0
    //   2224: getfield 50	aozi:jdField_a_of_type_Long	J
    //   2227: l2f
    //   2228: aload_0
    //   2229: getfield 58	aozi:jdField_d_of_type_Long	J
    //   2232: l2f
    //   2233: fdiv
    //   2234: putfield 202	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   2237: aload_0
    //   2238: sipush 2002
    //   2241: invokevirtual 248	aozi:a	(I)V
    //   2244: invokestatic 647	java/lang/System:currentTimeMillis	()J
    //   2247: lstore 5
    //   2249: aload_0
    //   2250: getfield 66	aozi:jdField_f_of_type_Long	J
    //   2253: lstore 7
    //   2255: lload 5
    //   2257: lload 7
    //   2259: lsub
    //   2260: ldc2_w 999
    //   2263: lcmp
    //   2264: ifge +7 -> 2271
    //   2267: aload 12
    //   2269: monitorexit
    //   2270: return
    //   2271: aload_0
    //   2272: lload 5
    //   2274: putfield 66	aozi:jdField_f_of_type_Long	J
    //   2277: aload_0
    //   2278: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2281: aload_0
    //   2282: getfield 50	aozi:jdField_a_of_type_Long	J
    //   2285: l2f
    //   2286: aload_0
    //   2287: getfield 58	aozi:jdField_d_of_type_Long	J
    //   2290: l2f
    //   2291: fdiv
    //   2292: putfield 202	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   2295: aload_0
    //   2296: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2299: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Laozc;
    //   2302: aload_0
    //   2303: getfield 54	aozi:jdField_b_of_type_Long	J
    //   2306: aload_0
    //   2307: getfield 56	aozi:jdField_c_of_type_Long	J
    //   2310: aload_0
    //   2311: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2314: aload_0
    //   2315: getfield 134	aozi:jdField_a_of_type_Int	I
    //   2318: bipush 16
    //   2320: aconst_null
    //   2321: iconst_0
    //   2322: aconst_null
    //   2323: invokevirtual 480	aozc:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   2326: goto -1049 -> 1277
    //   2329: ldc 103
    //   2331: astore 10
    //   2333: ldc 103
    //   2335: astore 11
    //   2337: aload_1
    //   2338: ifnull +9 -> 2347
    //   2341: aload_1
    //   2342: invokevirtual 953	bbmg:b	()Ljava/lang/String;
    //   2345: astore 10
    //   2347: aload 11
    //   2349: astore_1
    //   2350: aload_2
    //   2351: ifnull +8 -> 2359
    //   2354: aload_2
    //   2355: getfield 954	bbmg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2358: astore_1
    //   2359: aload_0
    //   2360: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2363: aload_0
    //   2364: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2367: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2370: aload_0
    //   2371: getfield 80	aozi:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   2374: aload_0
    //   2375: getfield 70	aozi:jdField_g_of_type_Long	J
    //   2378: aload_0
    //   2379: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2382: aload_0
    //   2383: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2386: aload_0
    //   2387: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2390: aload_0
    //   2391: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2394: getfield 517	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2397: ldc2_w 1071
    //   2400: aconst_null
    //   2401: aload_0
    //   2402: getfield 97	aozi:jdField_i_of_type_Long	J
    //   2405: aload_0
    //   2406: getfield 50	aozi:jdField_a_of_type_Long	J
    //   2409: aload_0
    //   2410: getfield 58	aozi:jdField_d_of_type_Long	J
    //   2413: aload 10
    //   2415: aload_1
    //   2416: aload_0
    //   2417: getfield 526	aozi:jdField_h_of_type_Int	I
    //   2420: aload 9
    //   2422: aconst_null
    //   2423: invokestatic 524	apue:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2426: aload_0
    //   2427: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2430: aload_0
    //   2431: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2434: getfield 187	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2437: aload_0
    //   2438: getfield 82	aozi:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   2441: aload_0
    //   2442: getfield 70	aozi:jdField_g_of_type_Long	J
    //   2445: aload_0
    //   2446: getfield 105	aozi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2449: aload_0
    //   2450: getfield 154	aozi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2453: aload_0
    //   2454: getfield 139	aozi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2457: aload_0
    //   2458: getfield 161	aozi:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2461: getfield 517	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2464: ldc2_w 1071
    //   2467: aconst_null
    //   2468: aload_0
    //   2469: getfield 97	aozi:jdField_i_of_type_Long	J
    //   2472: aload_0
    //   2473: getfield 50	aozi:jdField_a_of_type_Long	J
    //   2476: aload_0
    //   2477: getfield 58	aozi:jdField_d_of_type_Long	J
    //   2480: aload 10
    //   2482: aload_1
    //   2483: aload_0
    //   2484: getfield 526	aozi:jdField_h_of_type_Int	I
    //   2487: aload 9
    //   2489: aconst_null
    //   2490: invokestatic 524	apue:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2493: aload_0
    //   2494: aconst_null
    //   2495: aconst_null
    //   2496: invokevirtual 529	aozi:b	(Lbbmg;Lbbmg;)V
    //   2499: goto -1222 -> 1277
    //   2502: lconst_0
    //   2503: lstore 5
    //   2505: goto -1911 -> 594
    //   2508: lconst_0
    //   2509: lstore 5
    //   2511: goto -2087 -> 424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2514	0	this	aozi
    //   0	2514	1	parambbmg1	bbmg
    //   0	2514	2	parambbmg2	bbmg
    //   264	1273	3	n	int
    //   261	721	4	i1	int
    //   422	2088	5	l1	long
    //   2253	5	7	l2	long
    //   249	1126	9	localObject1	Object
    //   1708	84	9	localException1	Exception
    //   2000	5	9	localObject2	Object
    //   2007	1	9	localException2	Exception
    //   2163	325	9	localIOException	java.io.IOException
    //   229	23	10	localException3	Exception
    //   256	2225	10	localObject3	Object
    //   275	2073	11	localObject4	Object
    //   4	2264	12	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   9	64	163	finally
    //   64	67	163	finally
    //   68	76	163	finally
    //   80	159	163	finally
    //   159	162	163	finally
    //   164	167	163	finally
    //   173	226	163	finally
    //   231	247	163	finally
    //   251	263	163	finally
    //   277	305	163	finally
    //   312	375	163	finally
    //   378	424	163	finally
    //   431	569	163	finally
    //   569	572	163	finally
    //   573	582	163	finally
    //   587	594	163	finally
    //   594	693	163	finally
    //   698	811	163	finally
    //   811	850	163	finally
    //   850	853	163	finally
    //   854	963	163	finally
    //   972	981	163	finally
    //   984	1035	163	finally
    //   1037	1118	163	finally
    //   1118	1260	163	finally
    //   1260	1277	163	finally
    //   1277	1280	163	finally
    //   1281	1295	163	finally
    //   1299	1303	163	finally
    //   1303	1401	163	finally
    //   1404	1452	163	finally
    //   1452	1514	163	finally
    //   1517	1532	163	finally
    //   1539	1550	163	finally
    //   1550	1684	163	finally
    //   1684	1689	163	finally
    //   1689	1696	163	finally
    //   1696	1705	163	finally
    //   1710	1726	163	finally
    //   1733	1819	163	finally
    //   1819	1830	163	finally
    //   1830	1846	163	finally
    //   1846	1996	163	finally
    //   1996	1999	163	finally
    //   2004	2007	163	finally
    //   2009	2159	163	finally
    //   2159	2162	163	finally
    //   2165	2216	163	finally
    //   2219	2255	163	finally
    //   2267	2270	163	finally
    //   2271	2326	163	finally
    //   2341	2347	163	finally
    //   2354	2359	163	finally
    //   2359	2499	163	finally
    //   9	64	229	java/lang/Exception
    //   68	76	229	java/lang/Exception
    //   80	159	229	java/lang/Exception
    //   173	226	229	java/lang/Exception
    //   312	375	229	java/lang/Exception
    //   378	424	229	java/lang/Exception
    //   431	569	229	java/lang/Exception
    //   573	582	229	java/lang/Exception
    //   587	594	229	java/lang/Exception
    //   594	693	229	java/lang/Exception
    //   698	811	229	java/lang/Exception
    //   811	850	229	java/lang/Exception
    //   854	963	229	java/lang/Exception
    //   972	981	229	java/lang/Exception
    //   984	1035	229	java/lang/Exception
    //   1037	1118	229	java/lang/Exception
    //   1118	1260	229	java/lang/Exception
    //   1260	1277	229	java/lang/Exception
    //   1281	1295	229	java/lang/Exception
    //   1299	1303	229	java/lang/Exception
    //   1303	1401	229	java/lang/Exception
    //   1404	1452	229	java/lang/Exception
    //   1452	1514	229	java/lang/Exception
    //   1517	1532	229	java/lang/Exception
    //   1550	1684	229	java/lang/Exception
    //   1684	1689	229	java/lang/Exception
    //   1689	1696	229	java/lang/Exception
    //   1696	1705	229	java/lang/Exception
    //   1710	1726	229	java/lang/Exception
    //   1733	1819	229	java/lang/Exception
    //   1819	1830	229	java/lang/Exception
    //   1846	1996	229	java/lang/Exception
    //   2004	2007	229	java/lang/Exception
    //   2009	2159	229	java/lang/Exception
    //   2165	2216	229	java/lang/Exception
    //   2219	2255	229	java/lang/Exception
    //   2271	2326	229	java/lang/Exception
    //   1539	1550	1708	java/lang/Exception
    //   1726	1733	2000	finally
    //   2002	2004	2000	finally
    //   1830	1846	2007	java/lang/Exception
    //   1689	1696	2163	java/io/IOException
  }
  
  public void a(Object paramObject, int paramInt)
  {
    bbmg localbbmg = (bbmg)paramObject;
    int n;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
    case 0: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
          break;
        }
        n = 0;
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
      } while (localbbmg == null);
      paramObject = localbbmg.d();
      if ((paramInt == 0) && (paramObject == null))
      {
        paramObject = "[Http_RespValue_Null]" + apue.a();
        paramInt = 9001;
      }
      break;
    }
    for (;;)
    {
      Object localObject = paramObject;
      if (paramObject == null) {
        localObject = "errMsgString_NUll_retCode[" + paramInt + "]";
      }
      if (((String)localObject).indexOf("-6101") > 0) {
        paramInt = 9042;
      }
      if (((String)localObject).contains("HTTP_PROXY_AUTH")) {
        paramInt = 9004;
      }
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, String.valueOf(localbbmg.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, localbbmg.b(), localbbmg.jdField_d_of_type_JavaLangString, this.jdField_h_of_type_Int, (String)localObject, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      n = 16;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
        break;
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, new location:" + paramString);
    if (this.jdField_a_of_type_Bbmg == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, String.valueOf(this.jdField_a_of_type_Bbmg.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_Bbmg.b(), this.jdField_a_of_type_Bbmg.jdField_d_of_type_JavaLangString, this.jdField_h_of_type_Int, this.jdField_a_of_type_Bbmg.d() + "&UrlOver&handleRedirect", null);
    a(null, 0);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (a())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step], working stoped!");
      return;
    }
    if (paramLong == 0L) {
      this.jdField_a_of_type_Long = 0L;
    }
    int i1 = this.jdField_a_of_type_Bgam.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, 1048576);
    int i2 = bgap.a(BaseApplication.getContext());
    int n;
    if (i2 != 1)
    {
      n = i1;
      if (i2 != 2) {}
    }
    else
    {
      n = i1;
      if (i1 > 16384) {
        n = 16384;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "sendFilePakage transferedSize[" + paramLong + "], packetSize[" + n + "]");
    a(paramString, paramLong, n);
  }
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (a()) {
      return;
    }
    int n;
    if (paramLong == 0L)
    {
      n = this.jdField_a_of_type_Bgam.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, 1024);
      if (this.jdField_d_of_type_Long < n) {}
      for (l1 = this.jdField_d_of_type_Long;; l1 = 1024L)
      {
        n = (int)l1;
        this.jdField_a_of_type_Long = 0L;
        n = Math.min(n, 1048576);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong + "], size[" + n + "]");
        }
        a(paramString, paramLong, n, paramArrayOfByte);
        return;
      }
    }
    this.jdField_e_of_type_Long = this.jdField_a_of_type_Bgam.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, 131072);
    if (this.jdField_d_of_type_Long < this.jdField_e_of_type_Long + paramLong) {}
    for (long l1 = this.jdField_d_of_type_Long - paramLong;; l1 = this.jdField_e_of_type_Long)
    {
      int i1 = (int)l1;
      int i2 = bgap.a(BaseApplication.getContext());
      if (i2 != 1)
      {
        n = i1;
        if (i2 != 2) {
          break;
        }
      }
      n = i1;
      if (i1 <= 16384) {
        break;
      }
      n = 16384;
      break;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public boolean a(bbmg parambbmg1, bbmg parambbmg2, int paramInt)
  {
    if ((5 == paramInt) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=" + this.jdField_a_of_type_Long + " filesize=" + this.jdField_d_of_type_Long);
      }
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Long, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -9527L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambbmg2.b(), parambbmg2.jdField_d_of_type_JavaLangString, this.jdField_h_of_type_Int, "statusChanged mtransferedSize[" + String.valueOf(this.jdField_a_of_type_Long) + "]nFileSize[" + String.valueOf(this.jdField_d_of_type_Long) + "]", null);
      k();
    }
    return true;
  }
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 1137	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 129	aozi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 1138	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 111	aozi:jdField_k_of_type_Long	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 111	aozi:jdField_k_of_type_Long	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 1137	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 129	aozi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 1138	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 111	aozi:jdField_k_of_type_Long	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 111	aozi:jdField_k_of_type_Long	J
    //   67: iload_3
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 1144	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 111	aozi:jdField_k_of_type_Long	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 111	aozi:jdField_k_of_type_Long	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 1145	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 1145	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 111	aozi:jdField_k_of_type_Long	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 111	aozi:jdField_k_of_type_Long	J
    //   144: lsub
    //   145: invokevirtual 1149	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 1070	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 111	aozi:jdField_k_of_type_Long	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 1137	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 129	aozi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokespecial 1138	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 111	aozi:jdField_k_of_type_Long	J
    //   190: aload_0
    //   191: getfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 1149	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 1070	java/io/IOException:printStackTrace	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	aozi
    //   0	224	1	paramLong	long
    //   0	224	3	paramInt	int
    //   70	26	4	arrayOfByte	byte[]
    //   98	8	4	localFileNotFoundException1	FileNotFoundException
    //   112	8	4	localFileNotFoundException2	FileNotFoundException
    //   152	3	4	localIOException1	java.io.IOException
    //   202	8	4	localIOException2	java.io.IOException
    //   216	1	4	localException	Exception
    //   219	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	98	java/io/FileNotFoundException
    //   42	62	112	java/io/FileNotFoundException
    //   135	149	152	java/io/IOException
    //   170	199	202	java/io/IOException
    //   72	95	216	java/lang/Exception
  }
  
  public void aw_()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRunnable = new FileManagerRSWorker.5(this);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Run RSWorker" + awzw.a());
      }
      apuq.a().execute(this.jdField_a_of_type_JavaLangRunnable);
      if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 104857600L)) {
        m();
      }
      return;
    }
    finally {}
  }
  
  public int b()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public String b()
  {
    boolean bool2 = true;
    Object localObject = this.jdField_a_of_type_Apti.b();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath dir: " + (String)localObject);
    localObject = new VFSFile((String)localObject);
    if (!((VFSFile)localObject).exists()) {}
    for (boolean bool1 = ((VFSFile)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getRecvDir[" + bool1 + "]");
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Apti.c();
      localObject = new VFSFile(this.jdField_c_of_type_JavaLangString);
      bool1 = bool2;
      if (!((VFSFile)localObject).exists()) {
        bool1 = ((VFSFile)localObject).mkdirs();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getTmpDir[" + bool1 + "]");
      }
      return this.jdField_c_of_type_JavaLangString;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 68	aozi:jdField_a_of_type_Boolean	Z
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: getfield 1155	aozi:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 1155	aozi:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   20: bipush 64
    //   22: invokestatic 1183	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   25: pop
    //   26: aload_0
    //   27: getfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   30: invokevirtual 1184	java/io/InputStream:close	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 64	aozi:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   38: aload_0
    //   39: getfield 76	aozi:jdField_a_of_type_Apsv	Lapsv;
    //   42: ifnull +10 -> 52
    //   45: aload_0
    //   46: getfield 76	aozi:jdField_a_of_type_Apsv	Lapsv;
    //   49: invokevirtual 1185	apsv:a	()V
    //   52: aload_0
    //   53: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   56: ifnull +78 -> 134
    //   59: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +58 -> 120
    //   65: ldc 215
    //   67: iconst_2
    //   68: new 217	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   75: ldc 220
    //   77: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 56	aozi:jdField_c_of_type_Long	J
    //   84: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 1054
    //   93: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   100: invokevirtual 925	bbmg:a	()I
    //   103: invokestatic 431	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   106: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 239
    //   111: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: getfield 163	aozi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   124: invokevirtual 465	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   127: aload_0
    //   128: getfield 472	aozi:jdField_a_of_type_Bbmg	Lbbmg;
    //   131: invokevirtual 1059	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmg;)V
    //   134: aload_0
    //   135: getfield 109	aozi:jdField_a_of_type_Apec	Lapec;
    //   138: ifnull +53 -> 191
    //   141: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +40 -> 184
    //   147: ldc 215
    //   149: iconst_2
    //   150: new 217	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   157: ldc 220
    //   159: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 56	aozi:jdField_c_of_type_Long	J
    //   166: invokestatic 237	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   169: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 1187
    //   175: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_0
    //   185: getfield 109	aozi:jdField_a_of_type_Apec	Lapec;
    //   188: invokevirtual 1188	apec:a	()V
    //   191: return
    //   192: astore_1
    //   193: aload_0
    //   194: monitorexit
    //   195: aload_1
    //   196: athrow
    //   197: astore_1
    //   198: goto -160 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	aozi
    //   192	4	1	localObject	Object
    //   197	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	192	finally
    //   193	195	192	finally
    //   26	38	197	java/lang/Exception
  }
  
  public void b(bbmg parambbmg1, bbmg parambbmg2)
  {
    String str1 = null;
    if (parambbmg2 != null) {
      str1 = parambbmg2.d();
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "null";
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]transferedSize[" + this.jdField_a_of_type_Long + "]isStop[" + String.valueOf(a()) + "],  status[" + String.valueOf(this.jdField_i_of_type_Int) + "], strErrString[" + str2 + "], autoRetry[" + String.valueOf(this.jdField_e_of_type_Int) + "]");
    if ((a()) || (this.jdField_i_of_type_Int == 1003) || (this.jdField_i_of_type_Int == 2003)) {}
    do
    {
      return;
      if ((parambbmg1 == null) && (parambbmg2 == null))
      {
        b();
        a(null, 0);
        return;
      }
    } while ((!bbev.d(BaseApplication.getContext())) && ((a()) || (this.jdField_i_of_type_Int == 1003) || (this.jdField_i_of_type_Int == 2003)));
    int i1 = parambbmg2.jdField_f_of_type_Int;
    if (apgp.a(parambbmg2.jdField_f_of_type_Int))
    {
      this.jdField_h_of_type_Int += 1;
      if (this.jdField_a_of_type_Apam == null) {
        break label1517;
      }
    }
    label651:
    label782:
    label1497:
    label1505:
    label1517:
    for (str1 = this.jdField_a_of_type_Apam.a();; str1 = null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]get nextIp[" + str1 + "]errCode[" + i1 + "]");
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(parambbmg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambbmg2.b(), parambbmg2.jdField_d_of_type_JavaLangString, this.jdField_h_of_type_Int, parambbmg2.d() + "&goChangeUrl", null);
      long l1;
      int n;
      if ((str1 == null) || (str1.length() == 0))
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + i1 + "]");
        l1 = this.jdField_g_of_type_Long;
        if (!str2.contains("-29602")) {
          break label651;
        }
        n = -29602;
        parambbmg2.jdField_f_of_type_Int = -29602;
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -29602, String.valueOf(parambbmg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambbmg2.b(), parambbmg2.jdField_d_of_type_JavaLangString, this.jdField_h_of_type_Int, parambbmg2.d(), null);
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = 0;
        b();
        a(parambbmg2, n);
        return;
        b(str1);
        return;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]don't need chang Ip errCode[" + i1 + "]");
        break;
        n = i1;
        if (a(parambbmg1, parambbmg2))
        {
          if (!str2.contains("SSLPeerUnverifiedException")) {
            break label782;
          }
          apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(parambbmg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambbmg2.b(), parambbmg2.jdField_d_of_type_JavaLangString, this.jdField_h_of_type_Int, parambbmg2.d(), null);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          n = i1;
        }
      }
      if ((str2.contains("-29120")) || (str2.contains("-502")) || (str2.contains("HTTP_PROXY_AUTH")) || (str2.contains("-29150")) || (str2.contains("-21122")) || (str2.contains("-28123")) || (str2.contains("-25081")) || (str2.contains("-28126")))
      {
        i1 = 9042;
        if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
        {
          this.jdField_f_of_type_JavaLangString = "";
          n = i1;
        }
      }
      for (;;)
      {
        if ((str2.contains("-6101")) || (str2.contains("-7003")) || (str2.contains("-403")) || (str2.contains("-9006")) || (str2.contains("-9004")) || (str2.contains("-9017")) || (str2.contains("-28137")))
        {
          n = 9042;
          apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9042, String.valueOf(parambbmg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambbmg2.b(), parambbmg2.jdField_d_of_type_JavaLangString, this.jdField_h_of_type_Int, parambbmg2.d(), null);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          break;
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!!!uuid is null!!!!!!!");
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
          n = i1;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)) {
            continue;
          }
          this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          this.jdField_f_of_type_JavaLangString = "";
          n = i1;
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]handleError-----------retryTime:" + this.jdField_e_of_type_Int);
        }
        if (this.jdField_e_of_type_Int < 8)
        {
          this.jdField_e_of_type_Int += 1;
          this.jdField_h_of_type_Int += 1;
          if (n == 9056)
          {
            if (this.jdField_f_of_type_Int < 3)
            {
              this.jdField_f_of_type_Int += 1;
              this.jdField_e_of_type_Int -= 1;
            }
          }
          else
          {
            if (n == 9042)
            {
              if (this.jdField_g_of_type_Int >= 3) {
                break label1497;
              }
              this.jdField_g_of_type_Int += 1;
              this.jdField_e_of_type_Int -= 1;
            }
            i1 = 6000;
            if (n == 9056) {
              i1 = 0;
            }
            ThreadManager.getFileThreadHandler().postDelayed(new FileManagerRSWorker.4(this), i1);
            QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.jdField_c_of_type_Long + "] after [" + i1 + "] time retry!");
            if (9048 != n) {
              break label1505;
            }
            n = 11202;
          }
          for (;;)
          {
            apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, l1, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, n, String.valueOf(parambbmg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambbmg2.b(), parambbmg2.jdField_d_of_type_JavaLangString, this.jdField_h_of_type_Int, "delayTimes[" + i1 + "]" + parambbmg2.d(), null);
            return;
            this.jdField_f_of_type_Int = 0;
            break;
            this.jdField_g_of_type_Int = 0;
            break label1292;
          }
        }
        break;
        n = i1;
      }
    }
  }
  
  void b(String paramString)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (int n = 1; n != 0; n = 0)
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_d_of_type_Int += 1;
      a(this.jdField_f_of_type_JavaLangString, 0L);
      return;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    this.jdField_d_of_type_Int += 1;
    this.jdField_a_of_type_Long = apue.a(this.jdField_d_of_type_JavaLangString);
    a(this.jdField_a_of_type_Long, this.jdField_h_of_type_JavaLangString);
  }
  
  public boolean b()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step],send LocalFile");
    if (!bbev.d(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_e_of_type_Int, "NoNetWork", null);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_h_of_type_Int, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], no network!");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 13, null, 0, null);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, 1002);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], strFilePath is null");
      }
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_h_of_type_Int, apue.a(), null);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_h_of_type_Int, apue.a(), null);
      b(null, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], Filepath is null!");
      return false;
    }
    Object localObject;
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() != 0))
    {
      this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_Apam = new apam(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_Apam.a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_f_of_type_JavaLangString = ((String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = this.jdField_f_of_type_JavaLangString;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step], server Path is not empty, Goto [Upload Step]!");
        this.jdField_e_of_type_Long = 131072L;
        this.jdField_i_of_type_Long = 0L;
        a(this.jdField_f_of_type_JavaLangString, 0L);
        return true;
      }
    }
    this.jdField_a_of_type_ArrayOfByte = apue.a(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_e_of_type_Int, "getfile md5 error", null);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_h_of_type_Int, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject = apue.a(this.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      byte[] arrayOfByte = this.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      a(this.jdField_e_of_type_JavaLangString, arrayOfByte, (byte[])localObject, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Aowe, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], getFilePath failed");
      a(0);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_h_of_type_Int, apue.a(), null);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_h_of_type_Int, apue.a(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_d_of_type_Long <= 0L) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Long * 100L / this.jdField_d_of_type_Long);
  }
  
  public void c()
  {
    b();
  }
  
  public void d()
  {
    b();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is Successed, return!");
      }
    }
    for (;;)
    {
      return;
      if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
        a(1004);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]stop for pause!");
        }
        long l1 = System.currentTimeMillis();
        String str = "Now[" + String.valueOf(l1) + "]startTime[" + String.valueOf(this.jdField_g_of_type_Long) + "]notifyTime[" + String.valueOf(this.jdField_f_of_type_Long) + "]C2CTime[" + String.valueOf(this.jdField_j_of_type_Long) + "]";
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_e_of_type_Int, str, null);
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_h_of_type_Int, str, null);
        return;
        if ((1 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
          a(2004);
        } else if ((5 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Apec != null)) {
          this.jdField_a_of_type_Apec.a();
        } else if ((6 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Apec != null)) {
          this.jdField_a_of_type_Apec.a();
        } else if ((50 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Apec != null)) {
          this.jdField_a_of_type_Apec.a();
        }
      }
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
      label12:
      a(0);
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  public void f()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],call receive");
    if (!bbev.d(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_e_of_type_Int, "NoNetWork", null);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_h_of_type_Int, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.jdField_c_of_type_Long + "],no network!");
      return;
    }
    if (apvb.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.jdField_c_of_type_Long + "],file exists!!");
      k();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_k_of_type_JavaLangString = null;
    if ((this.jdField_g_of_type_JavaLangString == null) || (this.jdField_g_of_type_JavaLangString.length() == 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],uuid is null! : " + apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      g();
      return;
    }
    if (this.jdField_a_of_type_Int == 3000)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],Send getDiscFileInfo CS！");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aowe);
        return;
      }
      catch (Exception localException)
      {
        a(null, 0);
        return;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],Send getDownloadInfo CS！");
    boolean bool = false;
    if (apee.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, bool, this.jdField_a_of_type_Aowe);
  }
  
  public void g()
  {
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>!!!! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "],is oldMsg?");
    if (a())
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "],no network");
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath)) {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath;
    }
    if ((this.jdField_f_of_type_JavaLangString == null) || (this.jdField_f_of_type_JavaLangString.length() == 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get old offlinefile info is error! serverPath is empty");
      if (apvb.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], filee Exists");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
      int n;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) {
        n = 9080;
      }
      for (;;)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], errCode[" + n + "]");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -2) {
          n = 9081;
        } else {
          n = 9020;
        }
      }
    }
    if (-1L != this.jdField_b_of_type_Long) {}
    label1465:
    Object localObject2;
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_e_of_type_JavaLangString, 0, this.jdField_b_of_type_Long);; localObject2 = null)
    {
      aukn localaukn;
      if (localObject1 != null)
      {
        localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        TransFileInfo localTransFileInfo = (TransFileInfo)localaukn.a(TransFileInfo.class, new String[] { String.valueOf(((MessageRecord)localObject1).time), String.valueOf(((MessageRecord)localObject1).msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_e_of_type_JavaLangString });
        localaukn.a();
        if ((localTransFileInfo != null) && (2008 == localTransFileInfo.status)) {
          this.jdField_b_of_type_JavaLangString = apue.b(this.jdField_b_of_type_JavaLangString);
        }
      }
      if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1)) {
        this.jdField_b_of_type_JavaLangString = apue.b(this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + ".tmp");
      if (!bbev.d(BaseApplication.getContext()))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], no network");
        if (a()) {
          break;
        }
        a(2005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_e_of_type_Int, "NoNetWork", null);
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_h_of_type_Int, "NoNetWork", null);
        return;
      }
      this.jdField_a_of_type_Long = apue.a(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], id downloaded");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        a(2003);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apue.a(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apue.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
          this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        }
        if (bbdj.a(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = apue.b(this.jdField_b_of_type_JavaLangString);
        }
        apue.a(new VFSFile(this.jdField_d_of_type_JavaLangString), new VFSFile(this.jdField_b_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apue.a(this.jdField_b_of_type_JavaLangString);
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_e_of_type_Int, null);
        return;
      }
      if (this.jdField_d_of_type_Long > this.jdField_a_of_type_Long)
      {
        long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
        if (bbay.a()) {}
        for (long l1 = bbay.a() * 1024L; l1 < l2; l1 = bbay.b() * 1024L)
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod]Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]local sdcard space no enough!! [downsize:" + l2 + "mobile space:" + l1 + "]");
          a(2005);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 12, null);
          apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_e_of_type_Int, "sdcard full", null);
          apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_h_of_type_Int, "sdcard full", null);
          return;
        }
      }
      if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
      try
      {
        this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, 2002);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        localaukn = null;
        localObject1 = localaukn;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
        {
          localObject1 = localaukn;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId != null) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile) && (this.jdField_f_of_type_JavaLangString.toLowerCase().startsWith("https")))
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v>ReceiveOfflineForOldMsg Id[" + this.jdField_c_of_type_Long + "], mUseHttps:" + this.jdField_b_of_type_Boolean + " mHttpsDomain:" + this.jdField_k_of_type_JavaLangString);
        a(this.jdField_a_of_type_Long, (String)localObject1);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        break label1465;
      }
    }
  }
  
  public void h()
  {
    if (!bbev.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (bbay.a()) {}
    for (long l1 = bbay.a() * 1024L; l1 < l2; l1 = bbay.b() * 1024L)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_Apec = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localFileManagerEntity, null, new aozo(this));
    if (this.jdField_a_of_type_Apec == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + this.jdField_c_of_type_Long + "]fileid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize + "] modifytime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_Apec.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
  }
  
  public void i()
  {
    if (!bbev.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_Apec = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, new aozq(this));
    } while (this.jdField_a_of_type_Apec != null);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + this.jdField_c_of_type_Long + "] filePath[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
  }
  
  void j()
  {
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = awzw.a();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [Http upload]Id[" + this.jdField_c_of_type_Long + "] update successTime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    a(1003);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> [Http upload] SendFileSuccess, SessionId[" + this.jdField_c_of_type_Long + "], FileSize[" + this.jdField_d_of_type_Long + "], Uuid[" + this.jdField_g_of_type_JavaLangString + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 14, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Http upload] uuid is null Entity[" + apue.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    }
    this.jdField_j_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aowe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozi
 * JD-Core Version:    0.7.0.1
 */