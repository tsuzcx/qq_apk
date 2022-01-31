import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.1;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class apcz
  implements bbmw
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, apda> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<apda> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = aptm.a().d();
  }
  
  public apcz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private apda a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] is in map:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong)));
      apda localapda = (apda)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localapda;
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] removeDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      return;
    }
  }
  
  private void a(apda paramapda)
  {
    if (paramapda.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramapda.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(paramapda.jdField_d_of_type_JavaLangString) + "]");
      paramapda.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramapda.jdField_d_of_type_JavaLangString, true);
      bbmu localbbmu = new bbmu(paramapda.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (bbfj.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localbbmu.a("Net-type", str);
      localbbmu.a("Range", "bytes=0-");
      localbbmu.b(5);
      localbbmu.a(true);
      localbbmu.jdField_b_of_type_Int = 0;
      localbbmu.jdField_c_of_type_Int = 0;
      localbbmu.jdField_a_of_type_JavaLangString = String.valueOf(paramapda.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramapda.jdField_a_of_type_Long + "] start runDownload... , url[" + paramapda.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localbbmu.jdField_c_of_type_Int) + "]");
      localbbmu.a("Accept-Encoding", "identity");
      if (paramapda.jdField_a_of_type_Apdb != null) {
        paramapda.jdField_a_of_type_Apdb.a(paramapda.jdField_a_of_type_Long, localbbmu);
      }
      if (!TextUtils.isEmpty(paramapda.jdField_b_of_type_JavaLangString)) {
        localbbmu.a("Cookie", paramapda.jdField_b_of_type_JavaLangString);
      }
      str = "";
      if (paramapda.jdField_a_of_type_JavaLangString != null) {
        str = paramapda.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      if ((paramapda.jdField_a_of_type_Boolean) && (str.startsWith("https")))
      {
        localbbmu.j = true;
        localbbmu.k = apaq.a(paramapda.jdField_a_of_type_JavaLangString);
        localbbmu.jdField_e_of_type_JavaLangString = paramapda.jdField_e_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramapda.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbbmu);
      paramapda.jdField_a_of_type_Bbmu = localbbmu;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(paramapda, true);
      if (paramapda.jdField_a_of_type_Apdb != null) {
        paramapda.jdField_a_of_type_Apdb.a(paramapda.jdField_a_of_type_Long, false, -2, null, paramapda);
      }
      a(paramapda.jdField_a_of_type_Long);
      b(paramapda.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void a(apda paramapda, boolean paramBoolean)
  {
    if (paramapda == null) {}
    for (;;)
    {
      return;
      paramapda.jdField_c_of_type_Long = 0L;
      try
      {
        if (paramapda.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramapda.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramapda.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream:");
        }
        for (;;)
        {
          if (paramapda.jdField_a_of_type_Bbmu != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(paramapda.jdField_a_of_type_Bbmu);
          }
          if (!paramBoolean) {
            break;
          }
          apvd.c(paramapda.jdField_d_of_type_JavaLangString);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramapda.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream: exception");
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  private void b()
  {
    boolean bool = false;
    QLog.i("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,mWaitDowloadTask.size(" + String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) + ")");
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      if (i >= 8)
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,but is have" + i + " task downloading, waiting....");
        return;
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,no waiting task.");
          return;
        }
      }
    }
    apda localapda = (apda)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localapda == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(localapda);
    b(localapda);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localapda.jdField_a_of_type_Long + "] downloadNext send cs get url. thumb task,");
    localapda.jdField_d_of_type_Long = System.currentTimeMillis();
    if (localapda.jdField_a_of_type_Apdb != null) {
      bool = localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, localapda);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      a(localapda.jdField_a_of_type_Long);
      b(localapda.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void b(apda paramapda)
  {
    if (paramapda == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramapda.jdField_a_of_type_Long), paramapda);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramapda.jdField_a_of_type_Long + "] addDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      return;
    }
  }
  
  private void b(String paramString)
  {
    synchronized (this.b)
    {
      if (QLog.isDevelopLevel())
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] call removeDowloadingList [" + paramString + "] in mListDownloadTask:" + str);
        }
      }
    }
    this.b.remove(paramString);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + jdField_a_of_type_Long + "], Name[" + paramString + "] removeDowloadingList,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
  }
  
  public long a(String paramString, apdb paramapdb)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramString)) {
        return -1L;
      }
      this.b.add(paramString);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        apda localapda = new apda();
        localapda.jdField_c_of_type_JavaLangString = paramString;
        localapda.jdField_d_of_type_JavaLangString = (paramString + ".tmp");
        localapda.jdField_a_of_type_Apdb = paramapdb;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localapda.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localapda);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localapda.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
        l = localapda.jdField_a_of_type_Long;
        return l;
      }
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(long paramLong, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, short paramShort, String paramString6)
  {
    paramString3 = a(paramLong);
    if (paramString3 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetThumbInfo no this task");
      b();
      return;
    }
    if (!paramBoolean1)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrlCome failed");
      a(paramString3.jdField_a_of_type_Long);
      b(paramString3.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (paramBoolean2) {
      paramInt = paramShort;
    }
    paramString3.jdField_b_of_type_JavaLangString = paramString4;
    paramString1 = paramString1 + ":" + paramInt;
    paramString4 = new ArrayList(1);
    paramString4.add(paramString1);
    if ((apvm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(paramString6)))
    {
      QLog.i("ThumbHttpDownloader<FileAssistant><FileAssistant>", 1, "[Thumb Download] download thumb support IPv6. domain[" + paramString6 + "]");
      paramString4.add(0, paramString6 + ":" + paramInt);
    }
    paramString3.jdField_a_of_type_Apaq = new apaq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
    if (paramBoolean2) {
      paramString3.jdField_a_of_type_Apaq.a(true);
    }
    paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_Apaq.a();
    paramString3.jdField_a_of_type_Boolean = paramBoolean2;
    paramString3.jdField_e_of_type_JavaLangString = paramString5;
    paramString3.jdField_a_of_type_Short = paramShort;
    ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
  }
  
  public final void a(bbmu arg1, bbmu parambbmu2)
  {
    long l1 = Long.parseLong(???.jdField_a_of_type_JavaLangString);
    int j = 0;
    apda localapda = a(l1);
    if (localapda == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != localapda.jdField_a_of_type_Bbmu)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    localapda.jdField_b_of_type_Bbmu = parambbmu2;
    if (parambbmu2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(localapda, true);
      if (localapda.jdField_a_of_type_Apdb != null) {
        localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, false, -7, null, localapda);
      }
      a(localapda.jdField_a_of_type_Long);
      b(localapda.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localapda.jdField_a_of_type_ArrayOfInt)
    {
      if (parambbmu2.c() != 206)
      {
        i = j;
        if (parambbmu2.c() != 200) {}
      }
      else if (localapda.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localapda, true);
        if (localapda.jdField_a_of_type_Apdb != null) {
          localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, false, -8, null, localapda);
        }
        a(localapda.jdField_a_of_type_Long);
        b(localapda.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localapda.jdField_a_of_type_JavaIoFileOutputStream.write(parambbmu2.a());
        if (localapda.jdField_b_of_type_Long == 0L)
        {
          long l2 = parambbmu2.a();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localapda.jdField_b_of_type_Long = l2;
        }
        localapda.jdField_e_of_type_Long = parambbmu2.a().length;
        localapda.jdField_c_of_type_Long += localapda.jdField_e_of_type_Long;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localapda.jdField_e_of_type_Long + "],total[" + String.valueOf(localapda.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localapda.jdField_b_of_type_Long) + "]");
        if (localapda.jdField_c_of_type_Long >= localapda.jdField_b_of_type_Long) {
          localapda.jdField_a_of_type_Bbmu = null;
        }
      }
      catch (Exception parambbmu2)
      {
        try
        {
          localapda.jdField_a_of_type_JavaIoFileOutputStream.flush();
          localapda.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(localapda, false);
          boolean bool = true;
          i = 0;
          if (!bbdx.b(new File(localapda.jdField_d_of_type_JavaLangString), new File(localapda.jdField_c_of_type_JavaLangString)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (localapda.jdField_a_of_type_Apdb != null) {
            localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, bool, i, localapda.jdField_c_of_type_JavaLangString, localapda);
          }
          a(localapda.jdField_a_of_type_Long);
          b(localapda.jdField_d_of_type_JavaLangString);
          i = 1;
          if (i == 0) {
            break;
          }
          b();
          return;
        }
        catch (IOException parambbmu2)
        {
          parambbmu2.printStackTrace();
          a(localapda, true);
          if (localapda.jdField_a_of_type_Apdb == null) {
            break label777;
          }
          localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, false, -8, null, localapda);
          a(localapda.jdField_a_of_type_Long);
          b(localapda.jdField_d_of_type_JavaLangString);
          b();
          return;
        }
        parambbmu2 = parambbmu2;
        parambbmu2.printStackTrace();
        a(localapda, true);
        if (localapda.jdField_a_of_type_Apdb != null) {
          localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, false, -8, null, localapda);
        }
        a(localapda.jdField_a_of_type_Long);
        b(localapda.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
      label777:
      int k = (int)((float)localapda.jdField_c_of_type_Long / (float)localapda.jdField_b_of_type_Long * 10000.0F);
      i = j;
      if (localapda.jdField_a_of_type_Apdb != null)
      {
        localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, k, localapda);
        i = j;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public final boolean a(bbmu parambbmu1, bbmu parambbmu2, int paramInt)
  {
    return true;
  }
  
  public final void b(bbmu parambbmu1, bbmu parambbmu2)
  {
    long l = -1L;
    if (parambbmu1 != null) {
      l = Long.parseLong(parambbmu1.jdField_a_of_type_JavaLangString);
    }
    apda localapda = a(l);
    if (localapda == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      b();
      return;
    }
    if (parambbmu2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(localapda, true);
      if (localapda.jdField_a_of_type_Apdb != null) {
        localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, false, -1, null, localapda);
      }
      a(localapda.jdField_a_of_type_Long);
      b(localapda.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = parambbmu2.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localapda.jdField_b_of_type_Bbmu = parambbmu2;
    int i = parambbmu2.f;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!bbfj.d(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localapda, true);
      if (localapda.jdField_a_of_type_Apdb != null) {
        localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, false, -3, null, localapda);
      }
      a(localapda.jdField_a_of_type_Long);
      b(localapda.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (parambbmu1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(localapda, true);
      if (localapda.jdField_a_of_type_Apdb != null) {
        localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, false, i, null, localapda);
      }
      a(localapda.jdField_a_of_type_Long);
      b(localapda.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (!parambbmu2.d())
      {
        i = -4;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
      }
      else
      {
        if (parambbmu2.jdField_a_of_type_JavaNetHttpURLConnection == null) {
          break;
        }
        parambbmu1 = parambbmu2.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderField("User-ReturnCode");
        if ((TextUtils.isEmpty(parambbmu1)) || ((!parambbmu1.equals("-441")) && (!parambbmu1.equals("-443")) && (!parambbmu1.equals("-447")) && (!parambbmu1.equals("-29224")) && (!parambbmu1.equals("-31717")))) {
          break;
        }
        i = -10;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] file over size and server can not create thumb. over");
      }
    }
    if (localapda.jdField_b_of_type_Int < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + localapda.jdField_b_of_type_Int + " eofRetry:" + localapda.jdField_d_of_type_Int);
      localapda.jdField_b_of_type_Int += 1;
      if ((i == 9056) && (localapda.jdField_d_of_type_Int < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + localapda.jdField_b_of_type_Int + " eofRetry:" + localapda.jdField_d_of_type_Int);
        localapda.jdField_b_of_type_Int -= 1;
      }
      for (localapda.jdField_d_of_type_Int += 1;; localapda.jdField_d_of_type_Int = 0)
      {
        a(localapda, true);
        if (localapda.jdField_a_of_type_Apdb != null) {
          localapda.jdField_a_of_type_Apdb.a(localapda.jdField_a_of_type_Long, localapda);
        }
        localapda.jdField_c_of_type_Int += 1;
        a(localapda);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (localapda.jdField_a_of_type_Apaq != null) {}
    for (parambbmu1 = localapda.jdField_a_of_type_Apaq.a();; parambbmu1 = null)
    {
      if (parambbmu1 != null)
      {
        localapda.jdField_b_of_type_Int = 0;
        localapda.jdField_d_of_type_Int = 0;
        localapda.jdField_a_of_type_JavaLangString = parambbmu1;
        a(localapda, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localapda.jdField_a_of_type_Bbmu);
        if (localapda.jdField_a_of_type_Apdb != null) {
          localapda.jdField_a_of_type_Apdb.b(localapda.jdField_a_of_type_Long, localapda);
        }
        localapda.jdField_c_of_type_Int += 1;
        a(localapda);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apcz
 * JD-Core Version:    0.7.0.1
 */