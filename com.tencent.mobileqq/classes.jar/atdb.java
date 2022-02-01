import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.3;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.4;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.8;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
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
import org.jetbrains.annotations.Nullable;

public class atdb
  implements atji, bguz
{
  public int a;
  public long a;
  private aszq jdField_a_of_type_Aszq = new atdc(this);
  private atdx jdField_a_of_type_Atdx;
  atuh jdField_a_of_type_Atuh = null;
  atuk jdField_a_of_type_Atuk = null;
  atut jdField_a_of_type_Atut = null;
  auam jdField_a_of_type_Auam = null;
  bgux jdField_a_of_type_Bgux;
  bktt jdField_a_of_type_Bktt;
  public QQAppInterface a;
  public FileManagerEntity a;
  File jdField_a_of_type_JavaIoFile = null;
  InputStream jdField_a_of_type_JavaIoInputStream = null;
  public OutputStream a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
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
  boolean jdField_c_of_type_Boolean = false;
  public byte[] c;
  int d;
  public long d;
  public String d;
  int jdField_e_of_type_Int = 0;
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
  String jdField_h_of_type_JavaLangString;
  private int i;
  public long i;
  public String i;
  private int jdField_j_of_type_Int;
  long jdField_j_of_type_Long = 0L;
  public String j;
  long k;
  public String k;
  long jdField_l_of_type_Long = 0L;
  String jdField_l_of_type_JavaLangString = null;
  private String m = "";
  
  public atdb(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_k_of_type_Long = 0L;
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
      label183:
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramFileManagerEntity.getFilePath();
    this.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    this.jdField_g_of_type_JavaLangString = paramFileManagerEntity.Uuid;
    this.jdField_h_of_type_JavaLangString = paramFileManagerEntity.fileIdCrc;
    this.jdField_a_of_type_Boolean = paramFileManagerEntity.bUseMediaPlatform;
    this.jdField_b_of_type_Int = paramFileManagerEntity.nOpType;
    this.jdField_f_of_type_JavaLangString = paramFileManagerEntity.strServerPath;
    this.jdField_e_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    this.jdField_a_of_type_Atut = atut.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Boolean = true;
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
          if (this.jdField_a_of_type_Bktt != null) {
            break label183;
          }
          this.jdField_a_of_type_Bktt = new bktt();
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
        this.jdField_j_of_type_JavaLangString = "actFileUp";
        this.jdField_k_of_type_JavaLangString = "actFileUpDetail";
      }
      for (;;)
      {
        if ((paramFileManagerEntity.getFilePath() == null) || (paramFileManagerEntity.getFilePath().length() <= 0)) {
          break label609;
        }
        this.jdField_a_of_type_JavaIoFile = new File(paramFileManagerEntity.getFilePath());
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_j_of_type_JavaLangString = "actDiscussFileUp";
          this.jdField_k_of_type_JavaLangString = "actDiscussFileUpDetail";
        }
      }
      label609:
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath");
      }
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramFileManagerEntity.fileName);
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_j_of_type_JavaLangString = "actFileDown";
        this.jdField_k_of_type_JavaLangString = "actFileDownDetail";
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile) {
          break label754;
        }
        this.jdField_j_of_type_JavaLangString = "actFileUfGenDownload";
        this.jdField_k_of_type_JavaLangString = "actFileUfGenDownloadDetail";
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_j_of_type_JavaLangString = "actFileDiscDownLoad";
          this.jdField_k_of_type_JavaLangString = "actFileDiscDownLoadDetail";
        }
      }
      label754:
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "download insert, nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
      }
      this.jdField_j_of_type_JavaLangString = "actFileWyDown";
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "upload insert nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
      }
      this.jdField_j_of_type_JavaLangString = "actFileWyUp";
    }
  }
  
  private int a(int paramInt, Bundle paramBundle)
  {
    int n = paramInt;
    int i1;
    if (atgz.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      n = paramInt;
      if (paramBundle != null)
      {
        String str = paramBundle.getString("strHttpsDomain");
        i1 = paramBundle.getShort("httpsPort", (short)0);
        n = paramInt;
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_l_of_type_JavaLangString = str;
          if (i1 != 0) {
            break label69;
          }
          n = 443;
        }
      }
    }
    return n;
    label69:
    return i1;
  }
  
  @Nullable
  private String a(ByteStringMicro paramByteStringMicro, boolean paramBoolean, String paramString1, short paramShort1, Bundle paramBundle, String paramString2, short paramShort2, ArrayList<String> paramArrayList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramString1 != null)
    {
      localObject1 = localObject3;
      if (paramByteStringMicro != null)
      {
        paramString1 = paramString1 + ":" + paramShort2;
        paramByteStringMicro = paramString1;
        if (atgz.jdField_b_of_type_Boolean)
        {
          paramByteStringMicro = paramString1;
          if (!this.jdField_c_of_type_Boolean) {
            paramByteStringMicro = "113.108.29.146:" + paramShort1;
          }
        }
        paramArrayList.add(0, paramByteStringMicro);
        paramByteStringMicro = "";
        paramString1 = localObject2;
        if (paramBundle != null)
        {
          paramByteStringMicro = paramBundle.getString("IPv6Dns", "");
          paramString1 = paramBundle.getStringArrayList("ipv6list");
        }
        a(paramArrayList, paramByteStringMicro, paramShort2, paramString1, paramBoolean);
        this.jdField_a_of_type_Atdx = new atdx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, paramString2);
        if (!this.jdField_c_of_type_Boolean) {
          break label182;
        }
        this.jdField_a_of_type_Atdx.a(true);
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Atdx.a();
      return localObject1;
      label182:
      this.jdField_a_of_type_Atdx.a(false);
    }
  }
  
  private String a(String paramString)
  {
    return "/ftn_handler/" + paramString;
  }
  
  private String a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    String str = paramString4;
    if (paramString1 != null)
    {
      str = paramString4;
      if (paramString2 != null)
      {
        paramString4 = paramString1 + ":" + paramInt;
        paramString1 = a(paramString2);
        paramString2 = new ArrayList(1);
        paramString2.add(paramString4);
        if ((!TextUtils.isEmpty(paramString3)) && (atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5)))
        {
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. is config enable IPv6. domain[" + paramString3 + "]");
          paramString3 = new atcr(paramString3, paramInt);
          paramString3 = atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, 5);
          if ((paramString3 == null) || (paramString3.a())) {
            break label265;
          }
          if (atcq.a())
          {
            QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download.debugIsDisableIPv4OnDoubleStack");
            paramString2.clear();
          }
          atcq.a(paramString3.jdField_a_of_type_JavaUtilList, paramString2, false, false);
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv6. hostlist:" + paramString2.toString());
        }
        this.jdField_a_of_type_Atdx = new atdx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
        if (!this.jdField_c_of_type_Boolean) {
          break label277;
        }
        this.jdField_a_of_type_Atdx.a(true);
      }
    }
    for (;;)
    {
      str = this.jdField_a_of_type_Atdx.a();
      return str;
      label265:
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv4");
      break;
      label277:
      this.jdField_a_of_type_Atdx.a(false);
    }
  }
  
  private short a(short paramShort, Bundle paramBundle)
  {
    short s1 = paramShort;
    short s2;
    if (atgz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      s1 = paramShort;
      if (paramBundle != null)
      {
        String str = paramBundle.getString("strHttpsDomain");
        s2 = paramBundle.getShort("httpsPort", (short)0);
        s1 = paramShort;
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_l_of_type_JavaLangString = str;
          if (s2 != 0) {
            break label69;
          }
          s1 = 443;
        }
      }
    }
    return s1;
    label69:
    return s2;
  }
  
  private void a(long paramLong, atdk paramatdk)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
    paramatdk = new ArrayList();
    paramatdk.add(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_Atut.a(paramLong, paramatdk, SplashActivity.sTopActivity, new atdj(this));
  }
  
  private void a(long paramLong, String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] receviveFile, pos[" + paramLong + "] url:" + this.jdField_f_of_type_JavaLangString);
    if (this.jdField_b_of_type_Boolean) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Recv]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is stoped!");
    }
    do
    {
      return;
      String str2 = "bytes=" + paramLong + "-";
      bgux localbgux = new bgux(this.jdField_f_of_type_JavaLangString, null, this, true);
      localbgux.b(false);
      String str1 = "gprs";
      if (bgnt.b(BaseApplication.getContext()) == 1) {
        str1 = "wifi";
      }
      localbgux.a("Net-type", str1);
      localbgux.a("cache-control", "no-cache");
      localbgux.a("Range", str2);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "set cookie:" + paramString);
      }
      if (paramString != null) {
        localbgux.a("Cookie", paramString);
      }
      localbgux.b(1);
      localbgux.a(true);
      localbgux.jdField_b_of_type_Int = 0;
      localbgux.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      localbgux.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_c_of_type_Long);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recv http data RANGE[" + String.valueOf(str2) + "], peerType[" + String.valueOf(this.jdField_a_of_type_Int) + "]");
      localbgux.a("Accept-Encoding", "identity");
      paramString = "";
      if (this.jdField_f_of_type_JavaLangString != null) {
        paramString = this.jdField_f_of_type_JavaLangString.toLowerCase();
      }
      if ((this.jdField_c_of_type_Boolean) && (paramString.startsWith("https")))
      {
        localbgux.i = true;
        localbgux.j = atdx.a(this.jdField_f_of_type_JavaLangString);
        localbgux.jdField_e_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
      }
      localbgux.jdField_a_of_type_Bdxx = atvo.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbgux);
      this.jdField_a_of_type_Bgux = localbgux;
    } while (paramLong != 0L);
    a(2001);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 10, null, 6, null);
  }
  
  private void a(bgux parambgux, Bundle paramBundle, int paramInt, long paramLong)
  {
    this.jdField_f_of_type_Int += 1;
    this.jdField_i_of_type_Int += 1;
    if (paramInt == 9056)
    {
      if (this.jdField_g_of_type_Int < 3)
      {
        this.jdField_g_of_type_Int += 1;
        this.jdField_f_of_type_Int -= 1;
      }
    }
    else if (paramInt == 9042)
    {
      if (this.jdField_h_of_type_Int >= 3) {
        break label301;
      }
      this.jdField_h_of_type_Int += 1;
      this.jdField_f_of_type_Int -= 1;
    }
    for (;;)
    {
      int n = 6000;
      if (paramInt == 9056) {
        n = 0;
      }
      ThreadManager.getFileThreadHandler().postDelayed(new FileManagerRSWorker.3(this), n);
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.jdField_c_of_type_Long + "] after [" + n + "] time retry!");
      int i1 = paramInt;
      if (9048 == paramInt) {
        i1 = 11202;
      }
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, paramLong, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(parambgux.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambgux.b(), parambgux.jdField_d_of_type_JavaLangString, this.jdField_i_of_type_Int, "delayTimes[" + n + "]" + parambgux.d(), null, paramBundle);
      return;
      this.jdField_g_of_type_Int = 0;
      break;
      label301:
      this.jdField_h_of_type_Int = 0;
    }
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    this.jdField_i_of_type_Long += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step] Id[" + this.jdField_c_of_type_Long + "]sendFilePakage transferData null");
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_f_of_type_Int, "get Stream null", null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "get Stream null", null);
      b(null, null);
    }
    do
    {
      return;
      localObject = new bgux(paramString + "&bmd5=" + MD5.toMD5((byte[])localObject) + "&range=" + String.valueOf(paramLong), (byte[])localObject, this);
      ((bgux)localObject).b(false);
      ((bgux)localObject).a("cache-control", "no-cache");
      paramString = "gprs";
      if (bgnt.b(BaseApplication.getContext()) == 1) {
        paramString = "wifi";
      }
      ((bgux)localObject).a("Net-type", paramString);
      ((bgux)localObject).a("Range", "bytes=" + paramLong + "-");
      ((bgux)localObject).b("POST");
      ((bgux)localObject).b(1);
      ((bgux)localObject).jdField_b_of_type_Int = 0;
      ((bgux)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      ((bgux)localObject).jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_c_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_c_of_type_Long + "]send http data size[" + paramInt + "], peerType[" + this.jdField_a_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a((bgux)localObject);
      this.jdField_a_of_type_Bgux = ((bgux)localObject);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送一个数据包,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, aszq paramaszq, FileManagerEntity paramFileManagerEntity)
  {
    paramString = new atuj();
    paramString.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    paramString.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramString.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramString.jdField_a_of_type_Long = this.jdField_d_of_type_Long;
    paramString.jdField_c_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramLong <= 104857600L)
    {
      paramString.jdField_a_of_type_Int = 1700;
      this.jdField_b_of_type_ArrayOfByte = atvo.a(new String(paramArrayOfByte1));
      if (this.jdField_b_of_type_ArrayOfByte == null)
      {
        a(null, 0);
        return;
      }
      paramString.e = this.jdField_b_of_type_ArrayOfByte;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], filesize < 100 get sha1");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, this.jdField_a_of_type_Aszq, paramFileManagerEntity);
      return;
      paramString.jdField_a_of_type_Int = 1600;
      this.jdField_c_of_type_ArrayOfByte = atvo.d(new String(paramArrayOfByte1));
      paramFileManagerEntity.strFileSha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte);
      paramFileManagerEntity.str10Md5 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      if (this.jdField_c_of_type_ArrayOfByte == null)
      {
        a(null, 0);
        return;
      }
      paramString.f = this.jdField_c_of_type_ArrayOfByte;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], filesize > 100 get sha3");
    }
  }
  
  private void a(List<String> paramList1, String paramString, int paramInt, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1 == null) || (!atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)))
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    if ((paramBoolean) && (paramList2 != null) && (paramList2.size() > 0))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download. is config enable IPv6. v6ipsize[" + paramList2.size() + "]");
      paramString = atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramList2);
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (atcq.a())
        {
          QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download. debugIsDisableIPv4OnDoubleStack");
          paramList1.clear();
        }
        int n = paramString.size() - 1;
        while (n >= 0)
        {
          paramList2 = (String)paramString.get(n);
          if (!TextUtils.isEmpty(paramList2)) {
            paramList1.add(0, "[" + paramList2 + "]:" + paramInt);
          }
          n -= 1;
        }
        this.jdField_c_of_type_Int = 2;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download use IPv6. iplist:" + paramList1.toString());
        return;
      }
      this.jdField_c_of_type_Int = 1;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download use IPv4");
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. is config enable IPv6. domain[" + paramString + "]");
      paramString = new atcr(paramString, paramInt);
      paramString = atcq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
      if ((paramString != null) && (!paramString.a()))
      {
        if (atcq.a())
        {
          QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. debugIsDisableIPv4OnDoubleStack");
          paramList1.clear();
        }
        atcq.a(paramString.jdField_a_of_type_JavaUtilList, paramList1, false, false);
        this.jdField_c_of_type_Int = 2;
        if (paramString.jdField_a_of_type_Int == 1) {
          this.jdField_c_of_type_Int = 3;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv6. iplist:" + paramList1.toString());
        return;
      }
      this.jdField_c_of_type_Int = 1;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv4");
      return;
    }
    this.jdField_c_of_type_Int = 1;
  }
  
  private boolean a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get DiscdownLoad info Url is null");
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      if (paramLong == 0L) {
        paramLong = 9048L;
      }
      for (;;)
      {
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_f_of_type_Int, "ip url error", null);
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_i_of_type_Int, "ip url error", null);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(bgux parambgux1, bgux parambgux2)
  {
    if (parambgux1 == null) {}
    do
    {
      return false;
      if (parambgux2 == null) {
        return true;
      }
    } while (!bgnt.d(BaseApplication.getContext()));
    return true;
  }
  
  private boolean a(String paramString)
  {
    return (paramString.contains("-6101")) || (paramString.contains("-7003")) || (paramString.contains("-403")) || (paramString.contains("-9006")) || (paramString.contains("-9004")) || (paramString.contains("-9017")) || (paramString.contains("-28137"));
  }
  
  private boolean a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (!paramBoolean)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, paramString2 + String.valueOf(this.jdField_c_of_type_Long) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong) + "], retMsg:" + paramInt);
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      if (paramLong == -100001L) {}
      for (long l1 = 9043L;; l1 = 9045L)
      {
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_f_of_type_Int, paramString3, null);
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_i_of_type_Int, paramString3, null);
        return true;
      }
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    return (paramString.contains("-29120")) || (paramString.contains("-502")) || (paramString.contains("HTTP_PROXY_AUTH")) || (paramString.contains("-29150")) || (paramString.contains("-21122")) || (paramString.contains("-28123")) || (paramString.contains("-25081")) || (paramString.contains("-28126"));
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
  
  private int d()
  {
    return atwt.c(this.jdField_f_of_type_JavaLangString);
  }
  
  private void k()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Download]Id[" + this.jdField_c_of_type_Long + "] downLoad Success!");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = bbyp.a();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Http Download]Id[" + this.jdField_c_of_type_Long + "] update successTime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    int n = this.jdField_b_of_type_JavaLangString.length() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250 - n)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 250 - n);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("param_V6SelectType", this.jdField_c_of_type_Int);
    ((Bundle)localObject1).putInt("param_ipAddrType", d());
    if (this.jdField_c_of_type_Boolean) {}
    for (n = 1;; n = 0)
    {
      ((Bundle)localObject1).putInt("param_ishttps", n);
      if (bgmg.a(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = atvo.b(this.jdField_b_of_type_JavaLangString);
      }
      try
      {
        boolean bool2 = atvo.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
        boolean bool1 = bool2;
        if (!bool2)
        {
          bool1 = atvo.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "rename with vfs error, normalResult[" + bool1 + "]");
        }
        if (bool1) {
          break;
        }
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.jdField_d_of_type_JavaLangString + "],strFilePath[" + this.jdField_b_of_type_JavaLangString + "]");
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_f_of_type_Int, "rename error", null, (Bundle)localObject1);
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_i_of_type_Int, "rename error", null, (Bundle)localObject1);
        b(null, null);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
        localObject2 = com.qq.taf.jce.HexUtil.bytes2HexStr(atvo.e(this.jdField_b_of_type_JavaLangString));
        if (localObject2 != null) {
          break label1350;
        }
      }
    }
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
    atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "mathMd5 is null", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_i_of_type_Int, "rename error", null, (Bundle)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = atvo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = atjh.a(atvo.c(this.jdField_b_of_type_JavaLangString));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < 104857600L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = atjh.a(atvo.a(this.jdField_b_of_type_JavaLangString));
      }
    }
    Object localObject2 = new File(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = ((File)localObject2).lastModified();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(2003);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recive success, set TrafficData,size[" + String.valueOf(this.jdField_a_of_type_Long) + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null, (Bundle)localObject1);
    atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null, (Bundle)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      atwg.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      atwg.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (;;)
    {
      atvo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("FILE_TMP_SERVER_PATH", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath);
        ((Bundle)localObject1).putLong("FILE_TMP_RELATED_ID", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId);
        ((Bundle)localObject1).putString("FILE_TMP_DIR_PATH", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath);
        ((Bundle)localObject1).putBoolean("FILE_TMP_IS_ZIPINNER_FILE", true);
        ((Bundle)localObject1).putString("FILE_TMP_ZIP_FILEID", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipFileId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(null, -1, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long, 190, null, (Bundle)localObject1);
      }
      localObject1 = new atvn();
      ((atvn)localObject1).jdField_b_of_type_JavaLangString = "rece_file_suc";
      ((atvn)localObject1).jdField_a_of_type_Int = 1;
      atvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (atvn)localObject1);
      return;
      label1350:
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject2).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "md5 is not equal", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_i_of_type_Int, "rename error", null, (Bundle)localObject1);
        break;
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
        atvo.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      } else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
  }
  
  private void l()
  {
    if (!bgnt.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
      if (bgjq.a()) {}
      for (long l1 = bgjq.a() * 1024L; l1 < l2; l1 = bgjq.b() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
        return;
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_Auam = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localFileManagerEntity, null, new atdh(this, localFileManagerEntity));
    } while (this.jdField_a_of_type_Auam == null);
    this.jdField_a_of_type_Auam.a(localFileManagerEntity.WeiYunFileId);
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "start Rsworker OfflineFileHitReq:" + bbyp.a());
    }
    atvy.a().execute(new FileManagerRSWorker.8(this));
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
    String str = this.jdField_a_of_type_Atut.b();
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
    paramInt = atvo.b(paramInt);
    if ((this.jdField_j_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_j_of_type_Int = paramInt;
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
  public void a(bgux parambgux1, bgux parambgux2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	atdb:jdField_a_of_type_ArrayOfInt	[I
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: new 328	android/os/Bundle
    //   12: dup
    //   13: invokespecial 922	android/os/Bundle:<init>	()V
    //   16: astore 13
    //   18: aload_0
    //   19: invokevirtual 1158	atdb:a	()Z
    //   22: ifeq +55 -> 77
    //   25: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +45 -> 73
    //   31: ldc_w 697
    //   34: iconst_2
    //   35: new 229	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 1160
    //   45: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   52: getfield 199	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   55: invokestatic 249	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   58: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1162
    //   64: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload 12
    //   75: monitorexit
    //   76: return
    //   77: aload_1
    //   78: aload_0
    //   79: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   82: if_acmpeq +305 -> 387
    //   85: aload_1
    //   86: ifnull +92 -> 178
    //   89: aload_0
    //   90: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   93: ifnull +85 -> 178
    //   96: ldc 227
    //   98: iconst_1
    //   99: new 229	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 1164
    //   109: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 56	atdb:jdField_c_of_type_Long	J
    //   116: invokestatic 249	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   119: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 1166
    //   125: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: invokevirtual 649	bgux:a	()I
    //   132: invokestatic 556	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   135: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 1168
    //   141: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   148: invokevirtual 649	bgux:a	()I
    //   151: invokestatic 556	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   154: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 251
    //   159: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload 12
    //   170: monitorexit
    //   171: return
    //   172: astore_1
    //   173: aload 12
    //   175: monitorexit
    //   176: aload_1
    //   177: athrow
    //   178: aload_1
    //   179: ifnull +142 -> 321
    //   182: ldc 227
    //   184: iconst_1
    //   185: new 229	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 1164
    //   195: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: getfield 56	atdb:jdField_c_of_type_Long	J
    //   202: invokestatic 249	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   205: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 1166
    //   211: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 649	bgux:a	()I
    //   218: invokestatic 556	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   221: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc 251
    //   226: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: goto -67 -> 168
    //   238: astore 10
    //   240: aload 10
    //   242: invokevirtual 1169	java/lang/Exception:printStackTrace	()V
    //   245: ldc 227
    //   247: iconst_1
    //   248: aload 10
    //   250: invokevirtual 1170	java/lang/Exception:toString	()Ljava/lang/String;
    //   253: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: ldc 105
    //   258: astore 9
    //   260: aload 10
    //   262: invokevirtual 1174	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   265: astore 10
    //   267: aload 10
    //   269: arraylength
    //   270: istore 4
    //   272: iconst_0
    //   273: istore_3
    //   274: iload_3
    //   275: iload 4
    //   277: if_icmpge +993 -> 1270
    //   280: aload 10
    //   282: iload_3
    //   283: aaload
    //   284: astore 11
    //   286: new 229	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   293: aload 9
    //   295: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 11
    //   300: invokevirtual 1177	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: ldc_w 837
    //   306: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: astore 9
    //   314: iload_3
    //   315: iconst_1
    //   316: iadd
    //   317: istore_3
    //   318: goto -44 -> 274
    //   321: aload_0
    //   322: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   325: ifnull -157 -> 168
    //   328: ldc 227
    //   330: iconst_1
    //   331: new 229	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 1164
    //   341: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_0
    //   345: getfield 56	atdb:jdField_c_of_type_Long	J
    //   348: invokestatic 249	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   351: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc_w 1179
    //   357: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_0
    //   361: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   364: invokevirtual 649	bgux:a	()I
    //   367: invokestatic 556	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   370: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc 251
    //   375: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: goto -216 -> 168
    //   387: aload_0
    //   388: getfield 156	atdb:jdField_b_of_type_Int	I
    //   391: istore_3
    //   392: iload_3
    //   393: ifne +7 -> 400
    //   396: aload 12
    //   398: monitorexit
    //   399: return
    //   400: aload 13
    //   402: ldc_w 924
    //   405: aload_0
    //   406: getfield 80	atdb:jdField_c_of_type_Int	I
    //   409: invokevirtual 927	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   412: aload 13
    //   414: ldc_w 929
    //   417: aload_0
    //   418: invokespecial 347	atdb:d	()I
    //   421: invokevirtual 927	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   424: aload_0
    //   425: getfield 88	atdb:jdField_c_of_type_Boolean	Z
    //   428: ifeq +1019 -> 1447
    //   431: iconst_1
    //   432: istore_3
    //   433: aload 13
    //   435: ldc_w 931
    //   438: iload_3
    //   439: invokevirtual 927	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   442: aload_2
    //   443: invokevirtual 1181	bgux:c	()I
    //   446: sipush 206
    //   449: if_icmpeq +15 -> 464
    //   452: aload_2
    //   453: invokevirtual 1181	bgux:c	()I
    //   456: istore_3
    //   457: iload_3
    //   458: sipush 200
    //   461: if_icmpne -65 -> 396
    //   464: aload_0
    //   465: getfield 62	atdb:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   468: aload_2
    //   469: invokevirtual 1183	bgux:a	()[B
    //   472: invokevirtual 1188	java/io/OutputStream:write	([B)V
    //   475: aload_0
    //   476: iconst_0
    //   477: putfield 614	atdb:jdField_f_of_type_Int	I
    //   480: aload_2
    //   481: invokevirtual 1183	bgux:a	()[B
    //   484: arraylength
    //   485: i2l
    //   486: lstore 5
    //   488: aload_0
    //   489: aload_0
    //   490: getfield 99	atdb:jdField_i_of_type_Long	J
    //   493: lload 5
    //   495: ladd
    //   496: putfield 99	atdb:jdField_i_of_type_Long	J
    //   499: aload_0
    //   500: lload 5
    //   502: aload_0
    //   503: getfield 50	atdb:jdField_a_of_type_Long	J
    //   506: ladd
    //   507: putfield 50	atdb:jdField_a_of_type_Long	J
    //   510: aload_0
    //   511: getfield 58	atdb:jdField_d_of_type_Long	J
    //   514: lstore 5
    //   516: aload_2
    //   517: invokevirtual 1189	bgux:a	()J
    //   520: lstore 5
    //   522: aload_0
    //   523: getfield 50	atdb:jdField_a_of_type_Long	J
    //   526: lload 5
    //   528: lcmp
    //   529: iflt +631 -> 1160
    //   532: aload_0
    //   533: getfield 136	atdb:jdField_a_of_type_Int	I
    //   536: sipush 3000
    //   539: if_icmpeq +78 -> 617
    //   542: aload_0
    //   543: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   546: getfield 1192	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   549: ifne +68 -> 617
    //   552: ldc 227
    //   554: iconst_1
    //   555: new 229	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 1194
    //   565: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_0
    //   569: getfield 56	atdb:jdField_c_of_type_Long	J
    //   572: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   575: ldc_w 1196
    //   578: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   587: aload_0
    //   588: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   591: invokevirtual 734	com/tencent/mobileqq/app/QQAppInterface:a	()Laszj;
    //   594: aload_0
    //   595: getfield 182	atdb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   598: aload_0
    //   599: getfield 141	atdb:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   602: aload_0
    //   603: getfield 151	atdb:jdField_a_of_type_Boolean	Z
    //   606: aload_0
    //   607: getfield 146	atdb:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   610: aload_0
    //   611: getfield 97	atdb:jdField_a_of_type_Aszq	Laszq;
    //   614: invokevirtual 1199	aszj:a	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Laszq;)V
    //   617: aload_0
    //   618: aconst_null
    //   619: putfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   622: aload_0
    //   623: getfield 62	atdb:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   626: invokevirtual 1202	java/io/OutputStream:close	()V
    //   629: aload_0
    //   630: aconst_null
    //   631: putfield 62	atdb:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   634: aload_0
    //   635: invokespecial 1204	atdb:k	()V
    //   638: goto -242 -> 396
    //   641: astore 9
    //   643: aload 9
    //   645: invokevirtual 1207	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   648: ldc_w 1209
    //   651: invokevirtual 815	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   654: ifeq +125 -> 779
    //   657: aload_0
    //   658: monitorenter
    //   659: aload_0
    //   660: iconst_1
    //   661: putfield 68	atdb:jdField_b_of_type_Boolean	Z
    //   664: aload_0
    //   665: monitorexit
    //   666: aload_0
    //   667: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   670: ifnull +82 -> 752
    //   673: ldc 227
    //   675: iconst_2
    //   676: new 229	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   683: ldc_w 946
    //   686: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_0
    //   690: getfield 56	atdb:jdField_c_of_type_Long	J
    //   693: invokestatic 249	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   696: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: ldc_w 1211
    //   702: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload_0
    //   706: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   709: invokevirtual 649	bgux:a	()I
    //   712: invokestatic 556	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   715: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: ldc_w 775
    //   721: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 9
    //   726: invokevirtual 1207	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   729: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload_0
    //   739: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   742: invokevirtual 588	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lbgut;
    //   745: aload_0
    //   746: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   749: invokevirtual 1214	bgut:b	(Lbgux;)V
    //   752: aload_0
    //   753: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   756: invokevirtual 466	com/tencent/mobileqq/app/QQAppInterface:a	()Latcz;
    //   759: iconst_0
    //   760: invokevirtual 469	atcz:a	(Z)V
    //   763: aload_0
    //   764: aload_0
    //   765: getfield 58	atdb:jdField_d_of_type_Long	J
    //   768: new 1216	atdf
    //   771: dup
    //   772: aload_0
    //   773: invokespecial 1217	atdf:<init>	(Latdb;)V
    //   776: invokespecial 608	atdb:a	(JLatdk;)V
    //   779: aload_0
    //   780: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   783: aload_0
    //   784: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   787: getfield 199	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   790: aload_0
    //   791: getfield 82	atdb:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   794: aload_0
    //   795: getfield 70	atdb:jdField_g_of_type_Long	J
    //   798: aload_0
    //   799: getfield 107	atdb:m	Ljava/lang/String;
    //   802: aload_0
    //   803: getfield 166	atdb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   806: aload_0
    //   807: getfield 141	atdb:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   810: aload_0
    //   811: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   814: getfield 647	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   817: ldc2_w 667
    //   820: ldc 105
    //   822: aload_0
    //   823: getfield 99	atdb:jdField_i_of_type_Long	J
    //   826: aload_0
    //   827: getfield 50	atdb:jdField_a_of_type_Long	J
    //   830: aload_0
    //   831: getfield 58	atdb:jdField_d_of_type_Long	J
    //   834: aload_0
    //   835: getfield 107	atdb:m	Ljava/lang/String;
    //   838: ldc 105
    //   840: aload_0
    //   841: getfield 614	atdb:jdField_f_of_type_Int	I
    //   844: ldc_w 1219
    //   847: aconst_null
    //   848: aload 13
    //   850: invokestatic 658	atvo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   853: aload_0
    //   854: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   857: aload_0
    //   858: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   861: getfield 199	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   864: aload_0
    //   865: getfield 84	atdb:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   868: aload_0
    //   869: getfield 70	atdb:jdField_g_of_type_Long	J
    //   872: aload_0
    //   873: getfield 107	atdb:m	Ljava/lang/String;
    //   876: aload_0
    //   877: getfield 166	atdb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   880: aload_0
    //   881: getfield 141	atdb:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   884: aload_0
    //   885: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   888: getfield 647	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   891: ldc2_w 667
    //   894: ldc 105
    //   896: aload_0
    //   897: getfield 99	atdb:jdField_i_of_type_Long	J
    //   900: aload_0
    //   901: getfield 50	atdb:jdField_a_of_type_Long	J
    //   904: aload_0
    //   905: getfield 58	atdb:jdField_d_of_type_Long	J
    //   908: aload_0
    //   909: getfield 107	atdb:m	Ljava/lang/String;
    //   912: ldc 105
    //   914: aload_0
    //   915: getfield 616	atdb:jdField_i_of_type_Int	I
    //   918: ldc_w 1219
    //   921: aconst_null
    //   922: aload 13
    //   924: invokestatic 658	atvo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   927: aload_0
    //   928: aconst_null
    //   929: aconst_null
    //   930: invokevirtual 676	atdb:b	(Lbgux;Lbgux;)V
    //   933: aload 12
    //   935: monitorexit
    //   936: return
    //   937: astore 9
    //   939: aload_0
    //   940: monitorexit
    //   941: aload 9
    //   943: athrow
    //   944: astore 9
    //   946: aload_0
    //   947: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   950: aload_0
    //   951: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   954: getfield 199	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   957: aload_0
    //   958: getfield 82	atdb:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   961: aload_0
    //   962: getfield 70	atdb:jdField_g_of_type_Long	J
    //   965: aload_0
    //   966: getfield 107	atdb:m	Ljava/lang/String;
    //   969: aload_0
    //   970: getfield 166	atdb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   973: aload_0
    //   974: getfield 141	atdb:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   977: aload_0
    //   978: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   981: getfield 647	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   984: ldc2_w 667
    //   987: ldc 105
    //   989: aload_0
    //   990: getfield 99	atdb:jdField_i_of_type_Long	J
    //   993: aload_0
    //   994: getfield 50	atdb:jdField_a_of_type_Long	J
    //   997: aload_0
    //   998: getfield 58	atdb:jdField_d_of_type_Long	J
    //   1001: aload_0
    //   1002: getfield 107	atdb:m	Ljava/lang/String;
    //   1005: ldc 105
    //   1007: aload_0
    //   1008: getfield 614	atdb:jdField_f_of_type_Int	I
    //   1011: ldc_w 1219
    //   1014: aconst_null
    //   1015: aload 13
    //   1017: invokestatic 658	atvo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   1020: aload_0
    //   1021: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1024: aload_0
    //   1025: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1028: getfield 199	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1031: aload_0
    //   1032: getfield 84	atdb:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1035: aload_0
    //   1036: getfield 70	atdb:jdField_g_of_type_Long	J
    //   1039: aload_0
    //   1040: getfield 107	atdb:m	Ljava/lang/String;
    //   1043: aload_0
    //   1044: getfield 166	atdb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1047: aload_0
    //   1048: getfield 141	atdb:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1051: aload_0
    //   1052: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1055: getfield 647	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1058: ldc2_w 667
    //   1061: ldc 105
    //   1063: aload_0
    //   1064: getfield 99	atdb:jdField_i_of_type_Long	J
    //   1067: aload_0
    //   1068: getfield 50	atdb:jdField_a_of_type_Long	J
    //   1071: aload_0
    //   1072: getfield 58	atdb:jdField_d_of_type_Long	J
    //   1075: aload_0
    //   1076: getfield 107	atdb:m	Ljava/lang/String;
    //   1079: ldc 105
    //   1081: aload_0
    //   1082: getfield 616	atdb:jdField_i_of_type_Int	I
    //   1085: ldc_w 1219
    //   1088: aconst_null
    //   1089: aload 13
    //   1091: invokestatic 658	atvo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   1094: aload_0
    //   1095: aconst_null
    //   1096: aconst_null
    //   1097: invokevirtual 676	atdb:b	(Lbgux;Lbgux;)V
    //   1100: aload 12
    //   1102: monitorexit
    //   1103: return
    //   1104: astore 9
    //   1106: ldc_w 1221
    //   1109: iconst_1
    //   1110: new 229	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   1117: ldc 232
    //   1119: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: aload_0
    //   1123: getfield 56	atdb:jdField_c_of_type_Long	J
    //   1126: invokestatic 249	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1129: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: ldc_w 1223
    //   1135: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: aload 9
    //   1140: invokevirtual 1224	java/io/IOException:toString	()Ljava/lang/String;
    //   1143: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1152: aload 9
    //   1154: invokevirtual 1225	java/io/IOException:printStackTrace	()V
    //   1157: goto -528 -> 629
    //   1160: aload_0
    //   1161: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1164: aload_0
    //   1165: getfield 50	atdb:jdField_a_of_type_Long	J
    //   1168: l2f
    //   1169: aload_0
    //   1170: getfield 58	atdb:jdField_d_of_type_Long	J
    //   1173: l2f
    //   1174: fdiv
    //   1175: putfield 214	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1178: aload_0
    //   1179: sipush 2002
    //   1182: invokevirtual 260	atdb:a	(I)V
    //   1185: invokestatic 869	java/lang/System:currentTimeMillis	()J
    //   1188: lstore 5
    //   1190: aload_0
    //   1191: getfield 66	atdb:jdField_f_of_type_Long	J
    //   1194: lstore 7
    //   1196: lload 5
    //   1198: lload 7
    //   1200: lsub
    //   1201: ldc2_w 1226
    //   1204: lcmp
    //   1205: ifge +7 -> 1212
    //   1208: aload 12
    //   1210: monitorexit
    //   1211: return
    //   1212: aload_0
    //   1213: lload 5
    //   1215: putfield 66	atdb:jdField_f_of_type_Long	J
    //   1218: aload_0
    //   1219: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1222: aload_0
    //   1223: getfield 50	atdb:jdField_a_of_type_Long	J
    //   1226: l2f
    //   1227: aload_0
    //   1228: getfield 58	atdb:jdField_d_of_type_Long	J
    //   1231: l2f
    //   1232: fdiv
    //   1233: putfield 214	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1236: aload_0
    //   1237: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1240: invokevirtual 598	com/tencent/mobileqq/app/QQAppInterface:a	()Latcx;
    //   1243: aload_0
    //   1244: getfield 54	atdb:jdField_b_of_type_Long	J
    //   1247: aload_0
    //   1248: getfield 56	atdb:jdField_c_of_type_Long	J
    //   1251: aload_0
    //   1252: getfield 166	atdb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1255: aload_0
    //   1256: getfield 136	atdb:jdField_a_of_type_Int	I
    //   1259: bipush 16
    //   1261: aconst_null
    //   1262: iconst_0
    //   1263: aconst_null
    //   1264: invokevirtual 603	atcx:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   1267: goto -871 -> 396
    //   1270: ldc 105
    //   1272: astore 10
    //   1274: ldc 105
    //   1276: astore 11
    //   1278: aload_1
    //   1279: ifnull +9 -> 1288
    //   1282: aload_1
    //   1283: invokevirtual 650	bgux:b	()Ljava/lang/String;
    //   1286: astore 10
    //   1288: aload 11
    //   1290: astore_1
    //   1291: aload_2
    //   1292: ifnull +8 -> 1300
    //   1295: aload_2
    //   1296: getfield 651	bgux:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1299: astore_1
    //   1300: aload_0
    //   1301: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1304: aload_0
    //   1305: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1308: getfield 199	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1311: aload_0
    //   1312: getfield 82	atdb:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1315: aload_0
    //   1316: getfield 70	atdb:jdField_g_of_type_Long	J
    //   1319: aload_0
    //   1320: getfield 107	atdb:m	Ljava/lang/String;
    //   1323: aload_0
    //   1324: getfield 166	atdb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1327: aload_0
    //   1328: getfield 141	atdb:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1331: aload_0
    //   1332: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1335: getfield 647	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1338: ldc2_w 1228
    //   1341: aconst_null
    //   1342: aload_0
    //   1343: getfield 99	atdb:jdField_i_of_type_Long	J
    //   1346: aload_0
    //   1347: getfield 50	atdb:jdField_a_of_type_Long	J
    //   1350: aload_0
    //   1351: getfield 58	atdb:jdField_d_of_type_Long	J
    //   1354: aload 10
    //   1356: aload_1
    //   1357: aload_0
    //   1358: getfield 616	atdb:jdField_i_of_type_Int	I
    //   1361: aload 9
    //   1363: aconst_null
    //   1364: aload 13
    //   1366: invokestatic 658	atvo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   1369: aload_0
    //   1370: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1373: aload_0
    //   1374: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1377: getfield 199	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1380: aload_0
    //   1381: getfield 84	atdb:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1384: aload_0
    //   1385: getfield 70	atdb:jdField_g_of_type_Long	J
    //   1388: aload_0
    //   1389: getfield 107	atdb:m	Ljava/lang/String;
    //   1392: aload_0
    //   1393: getfield 166	atdb:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1396: aload_0
    //   1397: getfield 141	atdb:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1400: aload_0
    //   1401: getfield 173	atdb:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1404: getfield 647	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1407: ldc2_w 1228
    //   1410: aconst_null
    //   1411: aload_0
    //   1412: getfield 99	atdb:jdField_i_of_type_Long	J
    //   1415: aload_0
    //   1416: getfield 50	atdb:jdField_a_of_type_Long	J
    //   1419: aload_0
    //   1420: getfield 58	atdb:jdField_d_of_type_Long	J
    //   1423: aload 10
    //   1425: aload_1
    //   1426: aload_0
    //   1427: getfield 616	atdb:jdField_i_of_type_Int	I
    //   1430: aload 9
    //   1432: aconst_null
    //   1433: aload 13
    //   1435: invokestatic 658	atvo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   1438: aload_0
    //   1439: aconst_null
    //   1440: aconst_null
    //   1441: invokevirtual 676	atdb:b	(Lbgux;Lbgux;)V
    //   1444: goto -1048 -> 396
    //   1447: iconst_0
    //   1448: istore_3
    //   1449: goto -1016 -> 433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1452	0	this	atdb
    //   0	1452	1	parambgux1	bgux
    //   0	1452	2	parambgux2	bgux
    //   273	1176	3	n	int
    //   270	8	4	i1	int
    //   486	728	5	l1	long
    //   1194	5	7	l2	long
    //   258	55	9	str	String
    //   641	84	9	localException1	Exception
    //   937	5	9	localObject1	Object
    //   944	1	9	localException2	Exception
    //   1104	327	9	localIOException	java.io.IOException
    //   238	23	10	localException3	Exception
    //   265	1159	10	localObject2	Object
    //   284	1005	11	localObject3	Object
    //   4	1205	12	arrayOfInt	int[]
    //   16	1418	13	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   9	18	172	finally
    //   18	73	172	finally
    //   73	76	172	finally
    //   77	85	172	finally
    //   89	168	172	finally
    //   168	171	172	finally
    //   173	176	172	finally
    //   182	235	172	finally
    //   240	256	172	finally
    //   260	272	172	finally
    //   286	314	172	finally
    //   321	384	172	finally
    //   387	392	172	finally
    //   396	399	172	finally
    //   400	431	172	finally
    //   433	457	172	finally
    //   464	475	172	finally
    //   475	617	172	finally
    //   617	622	172	finally
    //   622	629	172	finally
    //   629	638	172	finally
    //   643	659	172	finally
    //   666	752	172	finally
    //   752	763	172	finally
    //   763	779	172	finally
    //   779	933	172	finally
    //   933	936	172	finally
    //   941	944	172	finally
    //   946	1100	172	finally
    //   1100	1103	172	finally
    //   1106	1157	172	finally
    //   1160	1196	172	finally
    //   1208	1211	172	finally
    //   1212	1267	172	finally
    //   1282	1288	172	finally
    //   1295	1300	172	finally
    //   1300	1444	172	finally
    //   18	73	238	java/lang/Exception
    //   77	85	238	java/lang/Exception
    //   89	168	238	java/lang/Exception
    //   182	235	238	java/lang/Exception
    //   321	384	238	java/lang/Exception
    //   387	392	238	java/lang/Exception
    //   400	431	238	java/lang/Exception
    //   433	457	238	java/lang/Exception
    //   475	617	238	java/lang/Exception
    //   617	622	238	java/lang/Exception
    //   622	629	238	java/lang/Exception
    //   629	638	238	java/lang/Exception
    //   643	659	238	java/lang/Exception
    //   666	752	238	java/lang/Exception
    //   752	763	238	java/lang/Exception
    //   779	933	238	java/lang/Exception
    //   941	944	238	java/lang/Exception
    //   946	1100	238	java/lang/Exception
    //   1106	1157	238	java/lang/Exception
    //   1160	1196	238	java/lang/Exception
    //   1212	1267	238	java/lang/Exception
    //   464	475	641	java/lang/Exception
    //   659	666	937	finally
    //   939	941	937	finally
    //   763	779	944	java/lang/Exception
    //   622	629	1104	java/io/IOException
  }
  
  public void a(Object paramObject, int paramInt)
  {
    bgux localbgux = (bgux)paramObject;
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
      } while (localbgux == null);
      paramObject = localbgux.d();
      if ((paramInt == 0) && (paramObject == null))
      {
        paramObject = "[Http_RespValue_Null]" + atvo.a();
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
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, String.valueOf(localbgux.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, localbgux.b(), localbgux.jdField_d_of_type_JavaLangString, this.jdField_i_of_type_Int, (String)localObject, null);
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
    if (this.jdField_a_of_type_Bgux == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, String.valueOf(this.jdField_a_of_type_Bgux.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_Bgux.b(), this.jdField_a_of_type_Bgux.jdField_d_of_type_JavaLangString, this.jdField_i_of_type_Int, this.jdField_a_of_type_Bgux.d() + "&UrlOver&handleRedirect", null);
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
    int i1 = this.jdField_a_of_type_Bktt.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, 1048576);
    int i2 = bktw.a(BaseApplication.getContext());
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
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public boolean a(bgux parambgux1, bgux parambgux2, int paramInt)
  {
    if ((5 == paramInt) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=" + this.jdField_a_of_type_Long + " filesize=" + this.jdField_d_of_type_Long);
      }
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Long, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -9527L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambgux2.b(), parambgux2.jdField_d_of_type_JavaLangString, this.jdField_i_of_type_Int, "statusChanged mtransferedSize[" + String.valueOf(this.jdField_a_of_type_Long) + "]nFileSize[" + String.valueOf(this.jdField_d_of_type_Long) + "]", null);
      k();
    }
    return true;
  }
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 1276	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 131	atdb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 1277	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 113	atdb:jdField_k_of_type_Long	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 113	atdb:jdField_k_of_type_Long	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 1276	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 131	atdb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 1277	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 113	atdb:jdField_k_of_type_Long	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 113	atdb:jdField_k_of_type_Long	J
    //   67: iload_3
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 1283	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 113	atdb:jdField_k_of_type_Long	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 113	atdb:jdField_k_of_type_Long	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 1284	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 1284	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 113	atdb:jdField_k_of_type_Long	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 113	atdb:jdField_k_of_type_Long	J
    //   144: lsub
    //   145: invokevirtual 1288	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 1225	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 113	atdb:jdField_k_of_type_Long	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 1276	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 131	atdb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokespecial 1277	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 113	atdb:jdField_k_of_type_Long	J
    //   190: aload_0
    //   191: getfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 1288	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 1225	java/io/IOException:printStackTrace	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	atdb
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
  
  public void aE_()
  {
    try
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRunnable = new FileManagerRSWorker.4(this);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Run RSWorker" + bbyp.a());
      }
      atvy.a().execute(this.jdField_a_of_type_JavaLangRunnable);
      if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 104857600L)) {
        m();
      }
      return;
    }
    finally {}
  }
  
  public int b()
  {
    return this.jdField_j_of_type_Int;
  }
  
  public String b()
  {
    boolean bool2 = true;
    Object localObject = this.jdField_a_of_type_Atut.b();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath dir: " + (String)localObject);
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    for (boolean bool1 = ((File)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getRecvDir[" + bool1 + "]");
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Atut.c();
      localObject = new File(this.jdField_c_of_type_JavaLangString);
      bool1 = bool2;
      if (!((File)localObject).exists()) {
        bool1 = ((File)localObject).mkdirs();
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
    //   4: putfield 68	atdb:jdField_b_of_type_Boolean	Z
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: getfield 1294	atdb:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 1294	atdb:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   20: bipush 64
    //   22: invokestatic 1317	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   25: pop
    //   26: aload_0
    //   27: getfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   30: invokevirtual 1318	java/io/InputStream:close	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 64	atdb:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   38: aload_0
    //   39: getfield 76	atdb:jdField_a_of_type_Atuh	Latuh;
    //   42: ifnull +10 -> 52
    //   45: aload_0
    //   46: getfield 76	atdb:jdField_a_of_type_Atuh	Latuh;
    //   49: invokevirtual 1321	atuh:a	()V
    //   52: aload_0
    //   53: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   56: ifnull +78 -> 134
    //   59: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +58 -> 120
    //   65: ldc 227
    //   67: iconst_2
    //   68: new 229	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   75: ldc 232
    //   77: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 56	atdb:jdField_c_of_type_Long	J
    //   84: invokestatic 249	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 1211
    //   93: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   100: invokevirtual 649	bgux:a	()I
    //   103: invokestatic 556	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   106: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 251
    //   111: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: getfield 175	atdb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   124: invokevirtual 588	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lbgut;
    //   127: aload_0
    //   128: getfield 595	atdb:jdField_a_of_type_Bgux	Lbgux;
    //   131: invokevirtual 1214	bgut:b	(Lbgux;)V
    //   134: aload_0
    //   135: getfield 111	atdb:jdField_a_of_type_Auam	Lauam;
    //   138: ifnull +53 -> 191
    //   141: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +40 -> 184
    //   147: ldc 227
    //   149: iconst_2
    //   150: new 229	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   157: ldc 232
    //   159: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 56	atdb:jdField_c_of_type_Long	J
    //   166: invokestatic 249	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   169: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 1323
    //   175: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_0
    //   185: getfield 111	atdb:jdField_a_of_type_Auam	Lauam;
    //   188: invokevirtual 1324	auam:a	()V
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
    //   0	201	0	this	atdb
    //   192	4	1	localObject	Object
    //   197	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	192	finally
    //   193	195	192	finally
    //   26	38	197	java/lang/Exception
  }
  
  public void b(bgux parambgux1, bgux parambgux2)
  {
    String str1 = null;
    if (parambgux2 != null) {
      str1 = parambgux2.d();
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "null";
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]transferedSize[" + this.jdField_a_of_type_Long + "]isStop[" + String.valueOf(a()) + "],  status[" + String.valueOf(this.jdField_j_of_type_Int) + "], strErrString[" + str2 + "], autoRetry[" + String.valueOf(this.jdField_f_of_type_Int) + "]");
    if ((a()) || (this.jdField_j_of_type_Int == 1003) || (this.jdField_j_of_type_Int == 2003)) {}
    do
    {
      return;
      if ((parambgux1 == null) && (parambgux2 == null))
      {
        b();
        a(null, 0);
        return;
      }
    } while ((!bgnt.d(BaseApplication.getContext())) && ((a()) || (this.jdField_j_of_type_Int == 1003) || (this.jdField_j_of_type_Int == 2003)));
    Bundle localBundle = new Bundle();
    int n;
    int i1;
    if (this.jdField_b_of_type_Int != 0)
    {
      localBundle.putInt("param_V6SelectType", this.jdField_c_of_type_Int);
      localBundle.putInt("param_ipAddrType", d());
      if (this.jdField_c_of_type_Boolean)
      {
        n = 1;
        localBundle.putInt("param_ishttps", n);
      }
    }
    else
    {
      i1 = parambgux2.jdField_f_of_type_Int;
      if (!atjh.a(parambgux2.jdField_f_of_type_Int)) {
        break label671;
      }
      this.jdField_i_of_type_Int += 1;
      if (this.jdField_a_of_type_Atdx == null) {
        break label1146;
      }
    }
    label532:
    label671:
    label718:
    label851:
    label1146:
    for (str1 = this.jdField_a_of_type_Atdx.a();; str1 = null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]get nextIp[" + str1 + "]errCode[" + i1 + "]");
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(parambgux2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambgux2.b(), parambgux2.jdField_d_of_type_JavaLangString, this.jdField_i_of_type_Int, parambgux2.d() + "&goChangeUrl", null, localBundle);
      long l1;
      if ((str1 == null) || (str1.length() == 0))
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + i1 + "]");
        l1 = this.jdField_g_of_type_Long;
        if (!str2.contains("-29602")) {
          break label718;
        }
        n = -29602;
        parambgux2.jdField_f_of_type_Int = -29602;
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -29602, String.valueOf(parambgux2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambgux2.b(), parambgux2.jdField_d_of_type_JavaLangString, this.jdField_i_of_type_Int, parambgux2.d(), null, localBundle);
      }
      for (;;)
      {
        this.jdField_f_of_type_Int = 0;
        b();
        a(parambgux2, n);
        return;
        n = 0;
        break;
        b(str1);
        return;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]don't need chang Ip errCode[" + i1 + "]");
        break label532;
        n = i1;
        if (a(parambgux1, parambgux2))
        {
          if (!str2.contains("SSLPeerUnverifiedException")) {
            break label851;
          }
          atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(parambgux2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambgux2.b(), parambgux2.jdField_d_of_type_JavaLangString, this.jdField_i_of_type_Int, parambgux2.d(), null, localBundle);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          n = i1;
        }
      }
      if (b(str2))
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
        if (a(str2))
        {
          n = 9042;
          atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9042, String.valueOf(parambgux2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, parambgux2.b(), parambgux2.jdField_d_of_type_JavaLangString, this.jdField_i_of_type_Int, parambgux2.d(), null, localBundle);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          break;
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!!!uuid is null!!!!!!!");
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, atvo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
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
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]handleError-----------retryTime:" + this.jdField_f_of_type_Int);
        }
        if (this.jdField_f_of_type_Int < 8)
        {
          a(parambgux2, localBundle, n, l1);
          return;
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
      this.m = this.jdField_f_of_type_JavaLangString;
      this.jdField_e_of_type_Int += 1;
      a(this.jdField_f_of_type_JavaLangString, 0L);
      return;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    this.m = this.jdField_f_of_type_JavaLangString;
    this.jdField_e_of_type_Int += 1;
    this.jdField_a_of_type_Long = atvo.a(this.jdField_d_of_type_JavaLangString);
    a(this.jdField_a_of_type_Long, this.jdField_i_of_type_JavaLangString);
  }
  
  public boolean b()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step],send LocalFile");
    if (!bgnt.d(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_f_of_type_Int, "NoNetWork", null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
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
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, atvo.a(), null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, atvo.a(), null);
      b(null, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], Filepath is null!");
      return false;
    }
    Object localObject;
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() != 0))
    {
      this.m = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_Atdx = new atdx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_Atdx.a();
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
    this.jdField_a_of_type_ArrayOfByte = atvo.a(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_f_of_type_Int, "getfile md5 error", null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_i_of_type_Int, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject = atvo.a(this.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      byte[] arrayOfByte = this.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      a(this.jdField_e_of_type_JavaLangString, arrayOfByte, (byte[])localObject, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Aszq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], getFilePath failed");
      a(0);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, atvo.a(), null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, atvo.a(), null);
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
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_f_of_type_Int, str, null);
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_i_of_type_Int, str, null);
        return;
        if ((1 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
          a(2004);
        } else if ((5 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Auam != null)) {
          this.jdField_a_of_type_Auam.a();
        } else if ((6 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Auam != null)) {
          this.jdField_a_of_type_Auam.a();
        } else if ((50 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Auam != null)) {
          this.jdField_a_of_type_Auam.a();
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
    if (!bgnt.d(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_f_of_type_Int, "NoNetWork", null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.jdField_c_of_type_Long + "],no network!");
      return;
    }
    if (atwl.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.jdField_c_of_type_Long + "],file exists!!");
      k();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_l_of_type_JavaLangString = null;
    if ((this.jdField_g_of_type_JavaLangString == null) || (this.jdField_g_of_type_JavaLangString.length() == 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],uuid is null! : " + atvo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      g();
      return;
    }
    if (this.jdField_a_of_type_Int == 3000)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],Send getDiscFileInfo CS！");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aszq);
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
    if (atgz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, bool, this.jdField_a_of_type_Aszq);
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
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get old offlinefile info is error! serverPath is empty");
      if (atwl.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
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
      int n = 9020;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) {
        n = 9080;
      }
      for (;;)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], errCode[" + n + "]");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -2) {
          n = 9081;
        }
      }
    }
    this.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + ".tmp");
    if (!bgnt.d(BaseApplication.getContext()))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], no network");
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_f_of_type_Int, "NoNetWork", null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
      return;
    }
    this.jdField_a_of_type_Long = atvo.a(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], id downloaded");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      a(2003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (bgmg.a(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = atvo.b(this.jdField_b_of_type_JavaLangString);
      }
      atvo.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.a(this.jdField_b_of_type_JavaLangString);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_f_of_type_Int, null);
      return;
    }
    if (this.jdField_d_of_type_Long > this.jdField_a_of_type_Long)
    {
      long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
      if (bgjq.a()) {}
      for (long l1 = bgjq.a() * 1024L; l1 < l2; l1 = bgjq.b() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod]Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]local sdcard space no enough!! [downsize:" + l2 + "mobile space:" + l1 + "]");
        a(2005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 12, null);
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_f_of_type_Int, "sdcard full", null);
        atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_i_of_type_Int, "sdcard full", null);
        return;
      }
    }
    if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
      label1284:
      if (this.jdField_b_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, 2002);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile) && (this.jdField_f_of_type_JavaLangString.toLowerCase().startsWith("https")))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain;
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v>ReceiveOfflineForOldMsg Id[" + this.jdField_c_of_type_Long + "], mUseHttps:" + this.jdField_c_of_type_Boolean + " mHttpsDomain:" + this.jdField_l_of_type_JavaLangString);
      a(this.jdField_a_of_type_Long, (String)localObject1);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label1284;
    }
  }
  
  public void h()
  {
    if (!bgnt.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (bgjq.a()) {}
    for (long l1 = bgjq.a() * 1024L; l1 < l2; l1 = bgjq.b() * 1024L)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_Auam = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localFileManagerEntity, null, new atdg(this));
    if (this.jdField_a_of_type_Auam == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + this.jdField_c_of_type_Long + "]fileid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize + "] modifytime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_Auam.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
  }
  
  public void i()
  {
    if (!bgnt.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_Auam = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, new atdi(this));
    } while (this.jdField_a_of_type_Auam != null);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + this.jdField_c_of_type_Long + "] filePath[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
  }
  
  void j()
  {
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = bbyp.a();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [Http upload]Id[" + this.jdField_c_of_type_Long + "] update successTime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    a(1003);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> [Http upload] SendFileSuccess, SessionId[" + this.jdField_c_of_type_Long + "], FileSize[" + this.jdField_d_of_type_Long + "], Uuid[" + this.jdField_g_of_type_JavaLangString + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 14, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Http upload] uuid is null Entity[" + atvo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    }
    this.jdField_j_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aszq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdb
 * JD-Core Version:    0.7.0.1
 */