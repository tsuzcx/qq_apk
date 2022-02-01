import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.12;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.4;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.7;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.8;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ashf
  implements asnm, IHttpCommunicatorListener
{
  public int a;
  public long a;
  private asdv jdField_a_of_type_Asdv = new ashl(this);
  private asib jdField_a_of_type_Asib;
  asym jdField_a_of_type_Asym = null;
  asyp jdField_a_of_type_Asyp = null;
  asyy jdField_a_of_type_Asyy = null;
  atep jdField_a_of_type_Atep = null;
  bjyw jdField_a_of_type_Bjyw;
  public QQAppInterface a;
  public FileManagerEntity a;
  HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
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
  final int d;
  public long d;
  public String d;
  int jdField_e_of_type_Int = 0;
  long jdField_e_of_type_Long;
  public String e;
  int jdField_f_of_type_Int = 0;
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
  private int jdField_k_of_type_Int;
  long jdField_k_of_type_Long = 0L;
  public String k;
  long jdField_l_of_type_Long = 0L;
  String jdField_l_of_type_JavaLangString = null;
  private String m = "";
  
  public ashf(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
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
    this.jdField_d_of_type_Int = 1000;
    this.jdField_i_of_type_Long = 0L;
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
      label190:
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
    this.jdField_a_of_type_Asyy = asyy.a();
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
          paramQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
          paramFileManagerEntity.fProgress = 0.0F;
          paramFileManagerEntity.status = 2;
          if (this.jdField_a_of_type_Bjyw != null) {
            break label190;
          }
          this.jdField_a_of_type_Bjyw = new bjyw();
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
          break label617;
        }
        this.jdField_a_of_type_JavaIoFile = new File(paramFileManagerEntity.getFilePath());
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_j_of_type_JavaLangString = "actDiscussFileUp";
          this.jdField_k_of_type_JavaLangString = "actDiscussFileUpDetail";
        }
      }
      label617:
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
          break label762;
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
      label762:
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
    if (asld.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
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
        if (asld.jdField_b_of_type_Boolean)
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
        this.jdField_a_of_type_Asib = new asib(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, paramString2);
        if (!this.jdField_c_of_type_Boolean) {
          break label182;
        }
        this.jdField_a_of_type_Asib.a(true);
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Asib.a();
      return localObject1;
      label182:
      this.jdField_a_of_type_Asib.a(false);
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
        if ((!TextUtils.isEmpty(paramString3)) && (asgv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5)))
        {
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. is config enable IPv6. domain[" + paramString3 + "]");
          paramString3 = new asgw(paramString3, paramInt);
          paramString3 = asgv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, 5);
          if ((paramString3 == null) || (paramString3.a())) {
            break label265;
          }
          if (asgv.a())
          {
            QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download.debugIsDisableIPv4OnDoubleStack");
            paramString2.clear();
          }
          asgv.a(paramString3.jdField_a_of_type_JavaUtilList, paramString2, false, false);
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv6. hostlist:" + paramString2.toString());
        }
        this.jdField_a_of_type_Asib = new asib(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
        if (!this.jdField_c_of_type_Boolean) {
          break label277;
        }
        this.jdField_a_of_type_Asib.a(true);
      }
    }
    for (;;)
    {
      str = this.jdField_a_of_type_Asib.a();
      return str;
      label265:
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv4");
      break;
      label277:
      this.jdField_a_of_type_Asib.a(false);
    }
  }
  
  private short a(short paramShort, Bundle paramBundle)
  {
    short s1 = paramShort;
    short s2;
    if (asld.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
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
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = (paramFloat1 / paramFloat2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_f_of_type_Long >= 1000L)
    {
      this.jdField_f_of_type_Long = l1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 4, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]Notify UI Progress! and send continue!");
      }
    }
  }
  
  private void a(long paramLong, asho paramasho)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(false);
    paramasho = new ArrayList();
    paramasho.add(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_Asyy.a(paramLong, paramasho, SplashActivity.sTopActivity, new ashi(this));
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
      HttpMsg localHttpMsg = new HttpMsg(this.jdField_f_of_type_JavaLangString, null, this, true);
      localHttpMsg.setInstanceFollowRedirects(false);
      String str1 = "gprs";
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
        str1 = "wifi";
      }
      localHttpMsg.setRequestProperty("Net-type", str1);
      localHttpMsg.setRequestProperty("cache-control", "no-cache");
      localHttpMsg.setRequestProperty("Range", str2);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "set cookie:" + paramString);
      }
      if (paramString != null) {
        localHttpMsg.setRequestProperty("Cookie", paramString);
      }
      localHttpMsg.setPriority(1);
      localHttpMsg.setDataSlice(true);
      localHttpMsg.fileType = 0;
      localHttpMsg.busiType = this.jdField_a_of_type_Int;
      localHttpMsg.msgId = String.valueOf(this.jdField_c_of_type_Long);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recv http data RANGE[" + String.valueOf(str2) + "], peerType[" + String.valueOf(this.jdField_a_of_type_Int) + "]");
      localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
      paramString = "";
      if (this.jdField_f_of_type_JavaLangString != null) {
        paramString = this.jdField_f_of_type_JavaLangString.toLowerCase();
      }
      if ((this.jdField_c_of_type_Boolean) && (paramString.startsWith("https")))
      {
        localHttpMsg.mIsHttps = true;
        localHttpMsg.mIsHostIP = asib.a(this.jdField_f_of_type_JavaLangString);
        localHttpMsg.mReqHost = this.jdField_l_of_type_JavaLangString;
      }
      localHttpMsg.timeoutParam = aszt.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().sendMsg(localHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    } while (paramLong != 0L);
    a(2001);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 10, null, 6, null);
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(2003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = aszt.b(this.jdField_b_of_type_JavaLangString);
    }
    aszt.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.a(this.jdField_b_of_type_JavaLangString);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is exist, and filesize is right!");
    aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null, paramBundle);
  }
  
  private void a(asdr paramasdr)
  {
    if ((paramasdr.jdField_a_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Asym != null) {
        this.jdField_a_of_type_Asym.a();
      }
      b();
      if ((paramasdr.jdField_a_of_type_ArrayOfByte == null) || (paramasdr.jdField_a_of_type_ArrayOfByte.length <= 0)) {
        break label203;
      }
      this.jdField_g_of_type_JavaLangString = new String(paramasdr.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      aszt.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Asdv);
      paramasdr = new aszs();
      paramasdr.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramasdr.jdField_a_of_type_Int = 1;
      aszr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramasdr);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      label203:
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
  }
  
  private void a(HttpMsg paramHttpMsg, Bundle paramBundle, int paramInt, long paramLong)
  {
    this.jdField_g_of_type_Int += 1;
    this.jdField_j_of_type_Int += 1;
    if (paramInt == 9056)
    {
      if (this.jdField_h_of_type_Int < 3)
      {
        this.jdField_h_of_type_Int += 1;
        this.jdField_g_of_type_Int -= 1;
      }
    }
    else if (paramInt == 9042)
    {
      if (this.jdField_i_of_type_Int >= 3) {
        break label301;
      }
      this.jdField_i_of_type_Int += 1;
      this.jdField_g_of_type_Int -= 1;
    }
    for (;;)
    {
      int n = 6000;
      if (paramInt == 9056) {
        n = 0;
      }
      ThreadManager.getFileThreadHandler().postDelayed(new FileManagerRSWorker.7(this), n);
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.jdField_c_of_type_Long + "] after [" + n + "] time retry!");
      int i1 = paramInt;
      if (9048 == paramInt) {
        i1 = 11202;
      }
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, paramLong, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(paramHttpMsg.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg.getRealUrl(), paramHttpMsg.rawRespHeader, this.jdField_j_of_type_Int, "delayTimes[" + n + "]" + paramHttpMsg.getErrorString(), null, paramBundle);
      return;
      this.jdField_h_of_type_Int = 0;
      break;
      label301:
      this.jdField_i_of_type_Int = 0;
    }
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    this.jdField_i_of_type_Long += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step] Id[" + this.jdField_c_of_type_Long + "]sendFilePakage transferData null");
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "get Stream null", null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "get Stream null", null);
      handleError(null, null);
    }
    do
    {
      return;
      localObject = new HttpMsg(paramString + "&bmd5=" + MD5.toMD5((byte[])localObject) + "&range=" + String.valueOf(paramLong), (byte[])localObject, this);
      ((HttpMsg)localObject).setInstanceFollowRedirects(false);
      ((HttpMsg)localObject).setRequestProperty("cache-control", "no-cache");
      paramString = "gprs";
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
        paramString = "wifi";
      }
      ((HttpMsg)localObject).setRequestProperty("Net-type", paramString);
      ((HttpMsg)localObject).setRequestProperty("Range", "bytes=" + paramLong + "-");
      ((HttpMsg)localObject).setRequestMethod("POST");
      ((HttpMsg)localObject).setPriority(1);
      ((HttpMsg)localObject).fileType = 0;
      ((HttpMsg)localObject).busiType = this.jdField_a_of_type_Int;
      ((HttpMsg)localObject).msgId = String.valueOf(this.jdField_c_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_c_of_type_Long + "]send http data size[" + paramInt + "], peerType[" + this.jdField_a_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().sendMsg((HttpMsg)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = ((HttpMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送一个数据包,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, asdv paramasdv, FileManagerEntity paramFileManagerEntity)
  {
    paramString = new asyo();
    paramString.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    paramString.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramString.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramString.jdField_a_of_type_Long = this.jdField_d_of_type_Long;
    paramString.jdField_c_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramLong <= 104857600L)
    {
      paramString.jdField_a_of_type_Int = 1700;
      this.jdField_b_of_type_ArrayOfByte = aszt.a(new String(paramArrayOfByte1));
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramString, this.jdField_a_of_type_Asdv, paramFileManagerEntity);
      return;
      paramString.jdField_a_of_type_Int = 1600;
      this.jdField_c_of_type_ArrayOfByte = aszt.d(new String(paramArrayOfByte1));
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
    if ((paramList1 == null) || (!asgv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)))
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    if ((paramBoolean) && (paramList2 != null) && (paramList2.size() > 0))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download. is config enable IPv6. v6ipsize[" + paramList2.size() + "]");
      paramString = asgv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramList2);
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (asgv.a())
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
      paramString = new asgw(paramString, paramInt);
      paramString = asgv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
      if ((paramString != null) && (!paramString.a()))
      {
        if (asgv.a())
        {
          QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. debugIsDisableIPv4OnDoubleStack");
          paramList1.clear();
        }
        asgv.a(paramString.jdField_a_of_type_JavaUtilList, paramList1, false, false);
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
  
  private void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (a())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay], SessionId[" + this.jdField_c_of_type_Long + "], working stop!");
      return;
    }
    if (paramBoolean2) {}
    for (String str1 = paramString4 + "&isthumb=0";; str1 = paramString4)
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString6;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform = paramBoolean2;
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      if (a(paramBoolean1, paramLong1, paramString1, paramInt, "=_= ^! [CS Replay]id[", "server ret error")) {
        break;
      }
      this.jdField_i_of_type_JavaLangString = paramString2;
      if (paramString5 != null) {
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramString5);
      }
      short s = a(paramShort, paramBundle);
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str2 = (String)paramList.next();
          localArrayList.add(str2 + ":" + s);
        }
      }
      str1 = a(paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramBundle, str1, s, localArrayList);
      paramList = new Bundle();
      paramList.putInt("param_V6SelectType", this.jdField_c_of_type_Int);
      paramList.putInt("param_ipAddrType", d());
      if (this.jdField_c_of_type_Boolean) {}
      for (int n = 1;; n = 0)
      {
        paramList.putInt("param_ishttps", n);
        if (a(paramLong1, paramString1, paramInt, str1, paramList)) {
          break;
        }
        this.jdField_f_of_type_JavaLangString = str1;
        this.m = this.jdField_f_of_type_JavaLangString;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "] mUseHttps:" + this.jdField_c_of_type_Boolean + " mHttpsDomain:" + this.jdField_l_of_type_JavaLangString + " downloadPort:" + s);
        if ((paramLong1 != 0L) && (paramString1 != null) && (paramString1.length() > 0))
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
        }
        if (-1L != this.jdField_b_of_type_Long) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(this.jdField_e_of_type_JavaLangString, 0, this.jdField_b_of_type_Long);
        }
        str1 = MD5.toMD5(this.jdField_g_of_type_JavaLangString);
        this.jdField_d_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + str1);
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
          break label913;
        }
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] no network! return!");
        a(2005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_g_of_type_Int, "net", null, paramList);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, "net", null, paramList);
        return;
      }
      label913:
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_d_of_type_JavaLangString + "]");
      }
      this.jdField_a_of_type_Long = aszt.a(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
      {
        a(paramList);
        return;
      }
      if ((this.jdField_d_of_type_Long > this.jdField_a_of_type_Long) && (a(paramBoolean1, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, paramInt, paramString5, paramString6, paramString7, paramLong2, paramBundle, localArrayList))) {
        break;
      }
      k();
      return;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (a()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay] id[" + this.jdField_c_of_type_Long + "]OnDiscDownloadInfo, network error");
    }
    int n;
    String str;
    do
    {
      do
      {
        return;
      } while (a(paramBoolean, paramLong1, paramString1, paramInt2, "=_= v! [Disc Download Replay]id[", "ret error"));
      n = a(paramInt1, paramBundle);
      str = "";
      if (paramBundle != null) {
        str = paramBundle.getString("IPv6Dns", "");
      }
      str = a(paramString3, paramString4, n, str, null);
    } while (a(paramLong1, paramString1, paramInt2, str));
    this.jdField_f_of_type_JavaLangString = str;
    this.m = this.jdField_f_of_type_JavaLangString;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Disc Download Replay]nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "]downLoadUrl[" + String.valueOf(this.jdField_f_of_type_JavaLangString) + "] mUseHttps:" + this.jdField_c_of_type_Boolean + " mHttpsDomain:" + this.jdField_l_of_type_JavaLangString + " downloadPort:" + n);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSeseeId[" + String.valueOf(this.jdField_c_of_type_Long) + "]renamed[" + String.valueOf(paramString2) + "]");
      }
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1) {
      this.jdField_b_of_type_JavaLangString = aszt.b(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_d_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + "dsc-" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.replace("/", "")));
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "], NetWork Error, notify UI!");
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_g_of_type_Int, "net", null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, "net", null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_c_of_type_Long, this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_d_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_Long = aszt.a(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      a(2003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = aszt.b(this.jdField_b_of_type_JavaLangString);
      }
      aszt.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.a(this.jdField_b_of_type_JavaLangString);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "], fileExisted, notify UI!");
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null);
      return;
    }
    if (this.jdField_d_of_type_Long > this.jdField_a_of_type_Long)
    {
      long l1 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Asyy.a() < l1)
      {
        a(l1, new ashk(this, paramBoolean, paramLong1, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2, paramBundle));
        return;
      }
    }
    atae.a().execute(new FileManagerRSWorker.4(this, paramString5));
  }
  
  private void a(boolean paramBoolean, asdr paramasdr)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] id[" + this.jdField_c_of_type_Long + "]onDownloadFileSuc");
    if ((paramBoolean) && ((paramasdr.jdField_c_of_type_Int == 2) || (paramasdr.jdField_c_of_type_Int == 0)) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramasdr.jdField_a_of_type_Int + "],retMsg[" + paramasdr.jdField_a_of_type_JavaLangString + "],retStat[" + paramasdr.jdField_c_of_type_Int + "]. need to send file receipt");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramasdr.jdField_a_of_type_Int + "],retMsg[" + paramasdr.jdField_a_of_type_JavaLangString + "],retStat[" + paramasdr.jdField_c_of_type_Int + "]. don't need to send file receipt");
  }
  
  private boolean a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get DiscdownLoad info Url is null");
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      if (paramLong == 0L) {
        paramLong = 9048L;
      }
      for (;;)
      {
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_g_of_type_Int, "ip url error", null);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, "ip url error", null);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(long paramLong, String paramString1, int paramInt, String paramString2, Bundle paramBundle)
  {
    if (paramString2 == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get offlinefile info Url is null, IP is null too");
      a(2005);
      if ((paramLong == -6101L) || (paramLong == -7003L)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      if (paramLong == 0L) {
        paramLong = 9048L;
      }
      for (;;)
      {
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_g_of_type_Int, "ip url error", null, paramBundle);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, "ip url error", null, paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(HttpMsg paramHttpMsg)
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]已经结束,返回");
      }
    }
    do
    {
      return true;
      if (paramHttpMsg == this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
        break;
      }
      if ((paramHttpMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg.getSerial()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
        return true;
      }
      if (paramHttpMsg != null)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg.getSerial()) + "]");
        return true;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
    return true;
    return false;
  }
  
  /* Error */
  private boolean a(HttpMsg paramHttpMsg, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 1142	com/tencent/mobileqq/utils/httputils/HttpMsg:getResponseCode	()I
    //   4: sipush 206
    //   7: if_icmpeq +13 -> 20
    //   10: aload_1
    //   11: invokevirtual 1142	com/tencent/mobileqq/utils/httputils/HttpMsg:getResponseCode	()I
    //   14: sipush 200
    //   17: if_icmpne +171 -> 188
    //   20: aload_0
    //   21: getfield 62	ashf:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   24: aload_1
    //   25: invokevirtual 1145	com/tencent/mobileqq/utils/httputils/HttpMsg:getRecvData	()[B
    //   28: invokevirtual 1150	java/io/OutputStream:write	([B)V
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 350	ashf:jdField_g_of_type_Int	I
    //   36: aload_1
    //   37: invokevirtual 1145	com/tencent/mobileqq/utils/httputils/HttpMsg:getRecvData	()[B
    //   40: arraylength
    //   41: i2l
    //   42: lstore_3
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 101	ashf:jdField_i_of_type_Long	J
    //   48: lload_3
    //   49: ladd
    //   50: putfield 101	ashf:jdField_i_of_type_Long	J
    //   53: aload_0
    //   54: lload_3
    //   55: aload_0
    //   56: getfield 50	ashf:jdField_a_of_type_Long	J
    //   59: ladd
    //   60: putfield 50	ashf:jdField_a_of_type_Long	J
    //   63: aload_0
    //   64: getfield 58	ashf:jdField_d_of_type_Long	J
    //   67: lstore_3
    //   68: aload_1
    //   69: invokevirtual 1153	com/tencent/mobileqq/utils/httputils/HttpMsg:getTotalLen	()J
    //   72: lstore_3
    //   73: aload_0
    //   74: getfield 50	ashf:jdField_a_of_type_Long	J
    //   77: lload_3
    //   78: lcmp
    //   79: iflt +613 -> 692
    //   82: aload_0
    //   83: getfield 138	ashf:jdField_a_of_type_Int	I
    //   86: sipush 3000
    //   89: if_icmpeq +78 -> 167
    //   92: aload_0
    //   93: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   96: getfield 1097	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   99: ifne +68 -> 167
    //   102: ldc 230
    //   104: iconst_1
    //   105: new 232	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 1155
    //   115: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: getfield 56	ashf:jdField_c_of_type_Long	J
    //   122: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: ldc_w 1157
    //   128: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_0
    //   138: getfield 177	ashf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 695	com/tencent/mobileqq/app/QQAppInterface:getFileTransferHandler	()Lasdm;
    //   144: aload_0
    //   145: getfield 184	ashf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   148: aload_0
    //   149: getfield 143	ashf:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 153	ashf:jdField_a_of_type_Boolean	Z
    //   156: aload_0
    //   157: getfield 148	ashf:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   160: aload_0
    //   161: getfield 99	ashf:jdField_a_of_type_Asdv	Lasdv;
    //   164: invokevirtual 1160	asdm:a	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lasdv;)V
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 630	ashf:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   172: aload_0
    //   173: getfield 62	ashf:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   176: invokevirtual 1163	java/io/OutputStream:close	()V
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 62	ashf:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   184: aload_0
    //   185: invokespecial 1165	ashf:l	()V
    //   188: iconst_0
    //   189: ireturn
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 1168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   195: ldc_w 1170
    //   198: invokevirtual 1173	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   201: ifeq +124 -> 325
    //   204: aload_0
    //   205: monitorenter
    //   206: aload_0
    //   207: iconst_1
    //   208: putfield 68	ashf:jdField_b_of_type_Boolean	Z
    //   211: aload_0
    //   212: monitorexit
    //   213: aload_0
    //   214: getfield 630	ashf:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   217: ifnull +81 -> 298
    //   220: ldc 230
    //   222: iconst_2
    //   223: new 232	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 1175
    //   233: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: getfield 56	ashf:jdField_c_of_type_Long	J
    //   240: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   243: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc_w 1177
    //   249: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_0
    //   253: getfield 630	ashf:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   256: invokevirtual 772	com/tencent/mobileqq/utils/httputils/HttpMsg:getSerial	()I
    //   259: invokestatic 585	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   262: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 896
    //   268: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_1
    //   272: invokevirtual 1168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   275: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_0
    //   285: getfield 177	ashf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   288: invokevirtual 622	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   291: aload_0
    //   292: getfield 630	ashf:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   295: invokevirtual 1181	com/tencent/mobileqq/utils/httputils/HttpCommunicator:cancelMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   298: aload_0
    //   299: getfield 177	ashf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 483	com/tencent/mobileqq/app/QQAppInterface:getFileManagerRSCenter	()Lashd;
    //   305: iconst_0
    //   306: invokevirtual 486	ashd:a	(Z)V
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 58	ashf:jdField_d_of_type_Long	J
    //   314: new 1183	ashm
    //   317: dup
    //   318: aload_0
    //   319: invokespecial 1184	ashm:<init>	(Lashf;)V
    //   322: invokespecial 1073	ashf:a	(JLasho;)V
    //   325: aload_0
    //   326: getfield 177	ashf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   329: aload_0
    //   330: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   333: getfield 201	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   336: aload_0
    //   337: getfield 82	ashf:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   340: aload_0
    //   341: getfield 70	ashf:jdField_g_of_type_Long	J
    //   344: aload_0
    //   345: getfield 109	ashf:m	Ljava/lang/String;
    //   348: aload_0
    //   349: getfield 168	ashf:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   352: aload_0
    //   353: getfield 143	ashf:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   356: aload_0
    //   357: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   360: getfield 665	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   363: ldc2_w 795
    //   366: ldc 107
    //   368: aload_0
    //   369: getfield 101	ashf:jdField_i_of_type_Long	J
    //   372: aload_0
    //   373: getfield 50	ashf:jdField_a_of_type_Long	J
    //   376: aload_0
    //   377: getfield 58	ashf:jdField_d_of_type_Long	J
    //   380: aload_0
    //   381: getfield 109	ashf:m	Ljava/lang/String;
    //   384: ldc 107
    //   386: aload_0
    //   387: getfield 350	ashf:jdField_g_of_type_Int	I
    //   390: ldc_w 1186
    //   393: aconst_null
    //   394: aload_2
    //   395: invokestatic 786	aszt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   398: aload_0
    //   399: getfield 177	ashf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: aload_0
    //   403: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   406: getfield 201	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   409: aload_0
    //   410: getfield 84	ashf:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   413: aload_0
    //   414: getfield 70	ashf:jdField_g_of_type_Long	J
    //   417: aload_0
    //   418: getfield 109	ashf:m	Ljava/lang/String;
    //   421: aload_0
    //   422: getfield 168	ashf:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   425: aload_0
    //   426: getfield 143	ashf:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   429: aload_0
    //   430: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   433: getfield 665	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   436: ldc2_w 795
    //   439: ldc 107
    //   441: aload_0
    //   442: getfield 101	ashf:jdField_i_of_type_Long	J
    //   445: aload_0
    //   446: getfield 50	ashf:jdField_a_of_type_Long	J
    //   449: aload_0
    //   450: getfield 58	ashf:jdField_d_of_type_Long	J
    //   453: aload_0
    //   454: getfield 109	ashf:m	Ljava/lang/String;
    //   457: ldc 107
    //   459: aload_0
    //   460: getfield 667	ashf:jdField_j_of_type_Int	I
    //   463: ldc_w 1186
    //   466: aconst_null
    //   467: aload_2
    //   468: invokestatic 786	aszt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   471: aload_0
    //   472: aconst_null
    //   473: aconst_null
    //   474: invokevirtual 805	ashf:handleError	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   477: iconst_1
    //   478: ireturn
    //   479: astore_1
    //   480: aload_0
    //   481: monitorexit
    //   482: aload_1
    //   483: athrow
    //   484: astore_1
    //   485: aload_0
    //   486: getfield 177	ashf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   489: aload_0
    //   490: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   493: getfield 201	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   496: aload_0
    //   497: getfield 82	ashf:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   500: aload_0
    //   501: getfield 70	ashf:jdField_g_of_type_Long	J
    //   504: aload_0
    //   505: getfield 109	ashf:m	Ljava/lang/String;
    //   508: aload_0
    //   509: getfield 168	ashf:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   512: aload_0
    //   513: getfield 143	ashf:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   516: aload_0
    //   517: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   520: getfield 665	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   523: ldc2_w 795
    //   526: ldc 107
    //   528: aload_0
    //   529: getfield 101	ashf:jdField_i_of_type_Long	J
    //   532: aload_0
    //   533: getfield 50	ashf:jdField_a_of_type_Long	J
    //   536: aload_0
    //   537: getfield 58	ashf:jdField_d_of_type_Long	J
    //   540: aload_0
    //   541: getfield 109	ashf:m	Ljava/lang/String;
    //   544: ldc 107
    //   546: aload_0
    //   547: getfield 350	ashf:jdField_g_of_type_Int	I
    //   550: ldc_w 1186
    //   553: aconst_null
    //   554: aload_2
    //   555: invokestatic 786	aszt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   558: aload_0
    //   559: getfield 177	ashf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   562: aload_0
    //   563: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   566: getfield 201	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   569: aload_0
    //   570: getfield 84	ashf:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   573: aload_0
    //   574: getfield 70	ashf:jdField_g_of_type_Long	J
    //   577: aload_0
    //   578: getfield 109	ashf:m	Ljava/lang/String;
    //   581: aload_0
    //   582: getfield 168	ashf:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   585: aload_0
    //   586: getfield 143	ashf:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   589: aload_0
    //   590: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   593: getfield 665	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   596: ldc2_w 795
    //   599: ldc 107
    //   601: aload_0
    //   602: getfield 101	ashf:jdField_i_of_type_Long	J
    //   605: aload_0
    //   606: getfield 50	ashf:jdField_a_of_type_Long	J
    //   609: aload_0
    //   610: getfield 58	ashf:jdField_d_of_type_Long	J
    //   613: aload_0
    //   614: getfield 109	ashf:m	Ljava/lang/String;
    //   617: ldc 107
    //   619: aload_0
    //   620: getfield 667	ashf:jdField_j_of_type_Int	I
    //   623: ldc_w 1186
    //   626: aconst_null
    //   627: aload_2
    //   628: invokestatic 786	aszt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   631: aload_0
    //   632: aconst_null
    //   633: aconst_null
    //   634: invokevirtual 805	ashf:handleError	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   637: iconst_1
    //   638: ireturn
    //   639: astore_1
    //   640: ldc_w 1188
    //   643: iconst_1
    //   644: new 232	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   651: ldc 235
    //   653: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload_0
    //   657: getfield 56	ashf:jdField_c_of_type_Long	J
    //   660: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   663: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: ldc_w 1190
    //   669: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload_1
    //   673: invokevirtual 1191	java/io/IOException:toString	()Ljava/lang/String;
    //   676: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   685: aload_1
    //   686: invokevirtual 1192	java/io/IOException:printStackTrace	()V
    //   689: goto -510 -> 179
    //   692: aload_0
    //   693: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   696: aload_0
    //   697: getfield 50	ashf:jdField_a_of_type_Long	J
    //   700: l2f
    //   701: aload_0
    //   702: getfield 58	ashf:jdField_d_of_type_Long	J
    //   705: l2f
    //   706: fdiv
    //   707: putfield 217	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   710: aload_0
    //   711: sipush 2002
    //   714: invokevirtual 263	ashf:a	(I)V
    //   717: invokestatic 459	java/lang/System:currentTimeMillis	()J
    //   720: lstore_3
    //   721: lload_3
    //   722: aload_0
    //   723: getfield 66	ashf:jdField_f_of_type_Long	J
    //   726: lsub
    //   727: ldc2_w 460
    //   730: lcmp
    //   731: ifge +5 -> 736
    //   734: iconst_1
    //   735: ireturn
    //   736: aload_0
    //   737: lload_3
    //   738: putfield 66	ashf:jdField_f_of_type_Long	J
    //   741: aload_0
    //   742: getfield 175	ashf:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   745: aload_0
    //   746: getfield 50	ashf:jdField_a_of_type_Long	J
    //   749: l2f
    //   750: aload_0
    //   751: getfield 58	ashf:jdField_d_of_type_Long	J
    //   754: l2f
    //   755: fdiv
    //   756: putfield 217	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   759: aload_0
    //   760: getfield 177	ashf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   763: invokevirtual 468	com/tencent/mobileqq/app/QQAppInterface:getFileManagerNotifyCenter	()Lashb;
    //   766: aload_0
    //   767: getfield 54	ashf:jdField_b_of_type_Long	J
    //   770: aload_0
    //   771: getfield 56	ashf:jdField_c_of_type_Long	J
    //   774: aload_0
    //   775: getfield 168	ashf:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   778: aload_0
    //   779: getfield 138	ashf:jdField_a_of_type_Int	I
    //   782: bipush 16
    //   784: aconst_null
    //   785: iconst_0
    //   786: aconst_null
    //   787: invokevirtual 473	ashb:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   790: goto -602 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	793	0	this	ashf
    //   0	793	1	paramHttpMsg	HttpMsg
    //   0	793	2	paramBundle	Bundle
    //   42	696	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   20	31	190	java/lang/Exception
    //   206	213	479	finally
    //   480	482	479	finally
    //   309	325	484	java/lang/Exception
    //   172	179	639	java/io/IOException
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if ((a()) || (this.jdField_k_of_type_Int == 1003) || (this.jdField_k_of_type_Int == 2003)) {
      return true;
    }
    if ((paramHttpMsg1 == null) && (paramHttpMsg2 == null))
    {
      b();
      a(null, 0);
      return true;
    }
    return false;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      if (paramLong == -100001L) {}
      for (long l1 = 9043L;; l1 = 9045L)
      {
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_g_of_type_Int, paramString3, null);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, paramString3, null);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    long l1 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Asyy.a() < l1)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] not enought space! ProcessNewPath");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramArrayList);
      a(l1, new ashj(this, paramBoolean1, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, localArrayList, paramInt, paramString5, paramString6, paramString7, paramLong2, paramBundle));
      return true;
    }
    return false;
  }
  
  private boolean b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {}
    do
    {
      return false;
      if (paramHttpMsg2 == null) {
        return true;
      }
    } while (!NetworkUtil.isNetSupport(BaseApplication.getContext()));
    return true;
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
    return ataw.c(this.jdField_f_of_type_JavaLangString);
  }
  
  private void k()
  {
    atae.a().execute(new FileManagerRSWorker.1(this));
  }
  
  private void l()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Download]Id[" + this.jdField_c_of_type_Long + "] downLoad Success!");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = bbko.a();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Http Download]Id[" + this.jdField_c_of_type_Long + "] update successTime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    int n = this.jdField_b_of_type_JavaLangString.length() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250 - n)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 250 - n);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("param_V6SelectType", this.jdField_c_of_type_Int);
    ((Bundle)localObject1).putInt("param_ipAddrType", d());
    if (this.jdField_c_of_type_Boolean) {}
    for (n = 1;; n = 0)
    {
      ((Bundle)localObject1).putInt("param_ishttps", n);
      if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = aszt.b(this.jdField_b_of_type_JavaLangString);
      }
      try
      {
        boolean bool2 = aszt.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
        boolean bool1 = bool2;
        if (!bool2)
        {
          bool1 = aszt.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "rename with vfs error, normalResult[" + bool1 + "]");
        }
        if (bool1) {
          break;
        }
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.jdField_d_of_type_JavaLangString + "],strFilePath[" + this.jdField_b_of_type_JavaLangString + "]");
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_g_of_type_Int, "rename error", null, (Bundle)localObject1);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, "rename error", null, (Bundle)localObject1);
        handleError(null, null);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
        localObject2 = com.qq.taf.jce.HexUtil.bytes2HexStr(aszt.e(this.jdField_b_of_type_JavaLangString));
        if (localObject2 != null) {
          break label1350;
        }
      }
    }
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
    aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "mathMd5 is null", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, "rename error", null, (Bundle)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = aszt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = asnl.a(aszt.c(this.jdField_b_of_type_JavaLangString));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < 104857600L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = asnl.a(aszt.a(this.jdField_b_of_type_JavaLangString));
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null, (Bundle)localObject1);
    aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null, (Bundle)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      atal.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      atal.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (;;)
    {
      aszt.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("FILE_TMP_SERVER_PATH", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath);
        ((Bundle)localObject1).putLong("FILE_TMP_RELATED_ID", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId);
        ((Bundle)localObject1).putString("FILE_TMP_DIR_PATH", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath);
        ((Bundle)localObject1).putBoolean("FILE_TMP_IS_ZIPINNER_FILE", true);
        ((Bundle)localObject1).putString("FILE_TMP_ZIP_FILEID", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipFileId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(null, -1, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long, 190, null, (Bundle)localObject1);
      }
      localObject1 = new aszs();
      ((aszs)localObject1).jdField_b_of_type_JavaLangString = "rece_file_suc";
      ((aszs)localObject1).jdField_a_of_type_Int = 1;
      aszr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (aszs)localObject1);
      return;
      label1350:
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject2).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "md5 is not equal", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, "rename error", null, (Bundle)localObject1);
        break;
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
        aszt.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      } else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
  }
  
  private void m()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
      if (SystemUtil.isExistSDCard()) {}
      for (long l1 = SystemUtil.getSDCardAvailableSize() * 1024L; l1 < l2; l1 = SystemUtil.getSystemAvailableSize() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
        return;
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_Atep = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(localFileManagerEntity, null, new ashg(this, localFileManagerEntity));
    } while (this.jdField_a_of_type_Atep == null);
    this.jdField_a_of_type_Atep.a(localFileManagerEntity.WeiYunFileId);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "start Rsworker OfflineFileHitReq:" + bbko.a());
    }
    atae.a().execute(new FileManagerRSWorker.12(this));
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
    String str = this.jdField_a_of_type_Asyy.b();
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
    paramInt = aszt.b(paramInt);
    if ((this.jdField_k_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_k_of_type_Int = paramInt;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    HttpMsg localHttpMsg = (HttpMsg)paramObject;
    int n;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
    case 0: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
      } while (localHttpMsg == null);
      paramObject = localHttpMsg.getErrorString();
      if ((paramInt == 0) && (paramObject == null))
      {
        paramObject = "[Http_RespValue_Null]" + aszt.a();
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
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, String.valueOf(localHttpMsg.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, localHttpMsg.getRealUrl(), localHttpMsg.rawRespHeader, this.jdField_j_of_type_Int, (String)localObject, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      n = 16;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
        break;
      }
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (int n = 1; n != 0; n = 0)
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      this.m = this.jdField_f_of_type_JavaLangString;
      this.jdField_f_of_type_Int += 1;
      a(this.jdField_f_of_type_JavaLangString, 0L);
      return;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    this.m = this.jdField_f_of_type_JavaLangString;
    this.jdField_f_of_type_Int += 1;
    this.jdField_a_of_type_Long = aszt.a(this.jdField_d_of_type_JavaLangString);
    a(this.jdField_a_of_type_Long, this.jdField_i_of_type_JavaLangString);
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
    int i1 = this.jdField_a_of_type_Bjyw.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, 1048576);
    int i2 = bjyz.a(BaseApplication.getContext());
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
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 1505	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 133	ashf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 1506	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 115	ashf:jdField_k_of_type_Long	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 115	ashf:jdField_k_of_type_Long	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 1505	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 133	ashf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 1506	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 115	ashf:jdField_k_of_type_Long	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 115	ashf:jdField_k_of_type_Long	J
    //   67: iload_3
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 1512	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 115	ashf:jdField_k_of_type_Long	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 115	ashf:jdField_k_of_type_Long	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 1513	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 1513	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 115	ashf:jdField_k_of_type_Long	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 115	ashf:jdField_k_of_type_Long	J
    //   144: lsub
    //   145: invokevirtual 1517	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 1192	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 115	ashf:jdField_k_of_type_Long	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 1505	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 133	ashf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokespecial 1506	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 115	ashf:jdField_k_of_type_Long	J
    //   190: aload_0
    //   191: getfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 1517	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 1192	java/io/IOException:printStackTrace	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	ashf
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
  
  public void at_()
  {
    try
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRunnable = new FileManagerRSWorker.8(this);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Run RSWorker" + bbko.a());
      }
      atae.a().execute(this.jdField_a_of_type_JavaLangRunnable);
      if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 104857600L)) {
        n();
      }
      return;
    }
    finally {}
  }
  
  public int b()
  {
    return this.jdField_k_of_type_Int;
  }
  
  public String b()
  {
    boolean bool2 = true;
    Object localObject = this.jdField_a_of_type_Asyy.b();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath dir: " + (String)localObject);
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    for (boolean bool1 = ((File)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getRecvDir[" + bool1 + "]");
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Asyy.c();
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
    //   4: putfield 68	ashf:jdField_b_of_type_Boolean	Z
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: getfield 1523	ashf:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 1523	ashf:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   20: bipush 64
    //   22: invokestatic 1544	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   25: pop
    //   26: aload_0
    //   27: getfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   30: invokevirtual 1545	java/io/InputStream:close	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 64	ashf:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   38: aload_0
    //   39: getfield 76	ashf:jdField_a_of_type_Asym	Lasym;
    //   42: ifnull +10 -> 52
    //   45: aload_0
    //   46: getfield 76	ashf:jdField_a_of_type_Asym	Lasym;
    //   49: invokevirtual 678	asym:a	()V
    //   52: aload_0
    //   53: getfield 630	ashf:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   56: ifnull +78 -> 134
    //   59: invokestatic 228	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +58 -> 120
    //   65: ldc 230
    //   67: iconst_2
    //   68: new 232	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   75: ldc 235
    //   77: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 56	ashf:jdField_c_of_type_Long	J
    //   84: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 1177
    //   93: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 630	ashf:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   100: invokevirtual 772	com/tencent/mobileqq/utils/httputils/HttpMsg:getSerial	()I
    //   103: invokestatic 585	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   106: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 254
    //   111: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: getfield 177	ashf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   124: invokevirtual 622	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   127: aload_0
    //   128: getfield 630	ashf:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   131: invokevirtual 1181	com/tencent/mobileqq/utils/httputils/HttpCommunicator:cancelMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   134: aload_0
    //   135: getfield 113	ashf:jdField_a_of_type_Atep	Latep;
    //   138: ifnull +53 -> 191
    //   141: invokestatic 228	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +40 -> 184
    //   147: ldc 230
    //   149: iconst_2
    //   150: new 232	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   157: ldc 235
    //   159: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 56	ashf:jdField_c_of_type_Long	J
    //   166: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   169: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 1547
    //   175: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_0
    //   185: getfield 113	ashf:jdField_a_of_type_Atep	Latep;
    //   188: invokevirtual 1548	atep:a	()V
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
    //   0	201	0	this	ashf
    //   192	4	1	localObject	Object
    //   197	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	192	finally
    //   193	195	192	finally
    //   26	38	197	java/lang/Exception
  }
  
  public boolean b()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step],send LocalFile");
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], no network!");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 13, null, 0, null);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_c_of_type_Long, 1002);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], strFilePath is null");
      }
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, aszt.a(), null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, aszt.a(), null);
      handleError(null, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], Filepath is null!");
      return false;
    }
    Object localObject;
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() != 0))
    {
      this.m = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_Asib = new asib(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_Asib.a();
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
    this.jdField_a_of_type_ArrayOfByte = aszt.a(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_g_of_type_Int, "getfile md5 error", null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject = aszt.a(this.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      byte[] arrayOfByte = this.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      a(this.jdField_e_of_type_JavaLangString, arrayOfByte, (byte[])localObject, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Asdv, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], getFilePath failed");
      a(0);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, aszt.a(), null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, aszt.a(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]stop for pause!");
        }
        long l1 = System.currentTimeMillis();
        String str = "Now[" + String.valueOf(l1) + "]startTime[" + String.valueOf(this.jdField_g_of_type_Long) + "]notifyTime[" + String.valueOf(this.jdField_f_of_type_Long) + "]C2CTime[" + String.valueOf(this.jdField_j_of_type_Long) + "]";
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_g_of_type_Int, str, null);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, str, null);
        return;
        if ((1 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
          a(2004);
        } else if ((5 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Atep != null)) {
          this.jdField_a_of_type_Atep.a();
        } else if ((6 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Atep != null)) {
          this.jdField_a_of_type_Atep.a();
        } else if ((50 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Atep != null)) {
          this.jdField_a_of_type_Atep.a();
        }
      }
    }
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    label53:
    do
    {
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        localBundle = new Bundle();
        try
        {
          bool = a(paramHttpMsg1);
          if (bool) {
            return;
          }
          n = this.jdField_b_of_type_Int;
          if (n != 0) {
            break label53;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            boolean bool;
            localException.printStackTrace();
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, localException.toString());
            String str = "";
            Object localObject1 = localException.getStackTrace();
            int i1 = localObject1.length;
            int n = 0;
            while (n < i1)
            {
              localObject2 = localObject1[n];
              str = str + localObject2 + "&";
              n += 1;
            }
            localObject1 = "";
            Object localObject2 = "";
            if (paramHttpMsg1 != null) {
              localObject1 = paramHttpMsg1.getRealUrl();
            }
            paramHttpMsg1 = (HttpMsg)localObject2;
            if (paramHttpMsg2 != null) {
              paramHttpMsg1 = paramHttpMsg2.rawRespHeader;
            }
            aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, (String)localObject1, paramHttpMsg1, this.jdField_j_of_type_Int, str, null, localBundle);
            aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, (String)localObject1, paramHttpMsg1, this.jdField_j_of_type_Int, str, null, localBundle);
            handleError(null, null);
            continue;
            n = 0;
          }
        }
        return;
      }
      localBundle.putInt("param_V6SelectType", this.jdField_c_of_type_Int);
      localBundle.putInt("param_ipAddrType", d());
      if (!this.jdField_c_of_type_Boolean) {
        break label373;
      }
      n = 1;
      localBundle.putInt("param_ishttps", n);
      bool = a(paramHttpMsg2, localBundle);
    } while (!bool);
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
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.jdField_c_of_type_Long + "],no network!");
      return;
    }
    if (FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.jdField_c_of_type_Long + "],file exists!!");
      l();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_l_of_type_JavaLangString = null;
    if ((this.jdField_g_of_type_JavaLangString == null) || (this.jdField_g_of_type_JavaLangString.length() == 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],uuid is null! : " + aszt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      g();
      return;
    }
    if (this.jdField_a_of_type_Int == 3000)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],Send getDiscFileInfo CS！");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Asdv);
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
    if (asld.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, bool, this.jdField_a_of_type_Asdv);
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
      if (FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], filee Exists");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
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
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], no network");
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "NoNetWork", null);
      return;
    }
    this.jdField_a_of_type_Long = aszt.a(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], id downloaded");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      a(2003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = aszt.b(this.jdField_b_of_type_JavaLangString);
      }
      aszt.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = aszt.a(this.jdField_b_of_type_JavaLangString);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_g_of_type_Int, null);
      return;
    }
    if (this.jdField_d_of_type_Long > this.jdField_a_of_type_Long)
    {
      long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
      if (SystemUtil.isExistSDCard()) {}
      for (long l1 = SystemUtil.getSDCardAvailableSize() * 1024L; l1 < l2; l1 = SystemUtil.getSystemAvailableSize() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod]Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]local sdcard space no enough!! [downsize:" + l2 + "mobile space:" + l1 + "]");
        a(2005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 12, null);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_g_of_type_Int, "sdcard full", null);
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.m, "", this.jdField_j_of_type_Int, "sdcard full", null);
        return;
      }
    }
    if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
      label1284:
      if (this.jdField_b_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_c_of_type_Long, 2002);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (SystemUtil.isExistSDCard()) {}
    for (long l1 = SystemUtil.getSDCardAvailableSize() * 1024L; l1 < l2; l1 = SystemUtil.getSystemAvailableSize() * 1024L)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_Atep = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(localFileManagerEntity, null, new ashn(this));
    if (this.jdField_a_of_type_Atep == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + this.jdField_c_of_type_Long + "]fileid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize + "] modifytime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_Atep.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    String str1 = null;
    if (paramHttpMsg2 != null) {
      str1 = paramHttpMsg2.getErrorString();
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "null";
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]transferedSize[" + this.jdField_a_of_type_Long + "]isStop[" + String.valueOf(a()) + "],  status[" + String.valueOf(this.jdField_k_of_type_Int) + "], strErrString[" + str2 + "], autoRetry[" + String.valueOf(this.jdField_g_of_type_Int) + "]");
    if (a(paramHttpMsg1, paramHttpMsg2)) {}
    while ((!NetworkUtil.isNetSupport(BaseApplication.getContext())) && ((a()) || (this.jdField_k_of_type_Int == 1003) || (this.jdField_k_of_type_Int == 2003))) {
      return;
    }
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
      i1 = paramHttpMsg2.errCode;
      if (!asnl.a(paramHttpMsg2.errCode)) {
        break label634;
      }
      this.jdField_j_of_type_Int += 1;
      if (this.jdField_a_of_type_Asib == null) {
        break label1109;
      }
    }
    label681:
    label814:
    label1109:
    for (str1 = this.jdField_a_of_type_Asib.a();; str1 = null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]get nextIp[" + str1 + "]errCode[" + i1 + "]");
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, paramHttpMsg2.getErrorString() + "&goChangeUrl", null, localBundle);
      label495:
      long l1;
      if ((str1 == null) || (str1.length() == 0))
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + i1 + "]");
        l1 = this.jdField_g_of_type_Long;
        if (!str2.contains("-29602")) {
          break label681;
        }
        n = -29602;
        paramHttpMsg2.errCode = -29602;
        aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -29602, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, paramHttpMsg2.getErrorString(), null, localBundle);
      }
      for (;;)
      {
        this.jdField_g_of_type_Int = 0;
        b();
        a(paramHttpMsg2, n);
        return;
        n = 0;
        break;
        a(str1);
        return;
        label634:
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]don't need chang Ip errCode[" + i1 + "]");
        break label495;
        n = i1;
        if (b(paramHttpMsg1, paramHttpMsg2))
        {
          if (!str2.contains("SSLPeerUnverifiedException")) {
            break label814;
          }
          aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, paramHttpMsg2.getErrorString(), null, localBundle);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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
          aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9042, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, paramHttpMsg2.getErrorString(), null, localBundle);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          break;
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!!!uuid is null!!!!!!!");
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, aszt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
          n = i1;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)) {
            continue;
          }
          this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          this.jdField_f_of_type_JavaLangString = "";
          n = i1;
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]handleError-----------retryTime:" + this.jdField_g_of_type_Int);
        }
        if (this.jdField_g_of_type_Int < 8)
        {
          a(paramHttpMsg2, localBundle, n, l1);
          return;
        }
        break;
        n = i1;
      }
    }
  }
  
  public void handleRedirect(String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, new location:" + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.m, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getRealUrl(), this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.rawRespHeader, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getErrorString() + "&UrlOver&handleRedirect", null);
    a(null, 0);
  }
  
  public void i()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_Atep = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, new ashh(this));
    } while (this.jdField_a_of_type_Atep != null);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + this.jdField_c_of_type_Long + "] filePath[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
  }
  
  void j()
  {
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = bbko.a();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [Http upload]Id[" + this.jdField_c_of_type_Long + "] update successTime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    a(1003);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> [Http upload] SendFileSuccess, SessionId[" + this.jdField_c_of_type_Long + "], FileSize[" + this.jdField_d_of_type_Long + "], Uuid[" + this.jdField_g_of_type_JavaLangString + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 14, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Http upload] uuid is null Entity[" + aszt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    }
    this.jdField_j_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Asdv);
  }
  
  public void onFlowEvent(HttpMsg paramHttpMsg)
  {
    int n;
    int i1;
    int i2;
    if (paramHttpMsg != null)
    {
      n = paramHttpMsg.fileType;
      i1 = paramHttpMsg.busiType;
      i2 = paramHttpMsg.netType;
      if (((n == -1) || (i1 == -1)) && (QLog.isColorLevel())) {
        QLog.e("flowstat", 2, "fileType:" + n + ",busiType:" + i1);
      }
      if (!"POST".equals(paramHttpMsg.getRequestMethod())) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool, i2, n, i1, paramHttpMsg.flow);
      return;
    }
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((5 == paramInt) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=" + this.jdField_a_of_type_Long + " filesize=" + this.jdField_d_of_type_Long);
      }
      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Long, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -9527L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, "statusChanged mtransferedSize[" + String.valueOf(this.jdField_a_of_type_Long) + "]nFileSize[" + String.valueOf(this.jdField_d_of_type_Long) + "]", null);
      l();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashf
 * JD-Core Version:    0.7.0.1
 */