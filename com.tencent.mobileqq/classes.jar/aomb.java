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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class aomb
  implements baky
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, aomc> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<aomc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = apbo.a().d();
  }
  
  public aomb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private aomc a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] is in map:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong)));
      aomc localaomc = (aomc)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localaomc;
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
  
  private void a(aomc paramaomc)
  {
    if (paramaomc.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramaomc.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(paramaomc.jdField_d_of_type_JavaLangString) + "]");
      paramaomc.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramaomc.jdField_d_of_type_JavaLangString, true);
      bakw localbakw = new bakw(paramaomc.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (badq.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localbakw.a("Net-type", str);
      localbakw.a("Range", "bytes=0-");
      localbakw.b(5);
      localbakw.a(true);
      localbakw.jdField_b_of_type_Int = 0;
      localbakw.jdField_c_of_type_Int = 0;
      localbakw.jdField_a_of_type_JavaLangString = String.valueOf(paramaomc.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramaomc.jdField_a_of_type_Long + "] start runDownload... , url[" + paramaomc.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localbakw.jdField_c_of_type_Int) + "]");
      localbakw.a("Accept-Encoding", "identity");
      if (paramaomc.jdField_a_of_type_Aomd != null) {
        paramaomc.jdField_a_of_type_Aomd.a(paramaomc.jdField_a_of_type_Long, localbakw);
      }
      if (!TextUtils.isEmpty(paramaomc.jdField_b_of_type_JavaLangString)) {
        localbakw.a("Cookie", paramaomc.jdField_b_of_type_JavaLangString);
      }
      str = "";
      if (paramaomc.jdField_a_of_type_JavaLangString != null) {
        str = paramaomc.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      if ((paramaomc.jdField_a_of_type_Boolean) && (str.startsWith("https")))
      {
        localbakw.j = true;
        localbakw.k = aojs.a(paramaomc.jdField_a_of_type_JavaLangString);
        localbakw.jdField_e_of_type_JavaLangString = paramaomc.jdField_e_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramaomc.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbakw);
      paramaomc.jdField_a_of_type_Bakw = localbakw;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(paramaomc, true);
      if (paramaomc.jdField_a_of_type_Aomd != null) {
        paramaomc.jdField_a_of_type_Aomd.a(paramaomc.jdField_a_of_type_Long, false, -2, null, paramaomc);
      }
      a(paramaomc.jdField_a_of_type_Long);
      b(paramaomc.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void a(aomc paramaomc, boolean paramBoolean)
  {
    if (paramaomc == null) {}
    for (;;)
    {
      return;
      paramaomc.jdField_c_of_type_Long = 0L;
      try
      {
        if (paramaomc.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramaomc.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramaomc.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream:");
        }
        for (;;)
        {
          if (paramaomc.jdField_a_of_type_Bakw != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(paramaomc.jdField_a_of_type_Bakw);
          }
          if (!paramBoolean) {
            break;
          }
          apdh.c(paramaomc.jdField_d_of_type_JavaLangString);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramaomc.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    aomc localaomc = (aomc)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localaomc == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(localaomc);
    b(localaomc);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localaomc.jdField_a_of_type_Long + "] downloadNext send cs get url. thumb task,");
    localaomc.jdField_d_of_type_Long = System.currentTimeMillis();
    if (localaomc.jdField_a_of_type_Aomd != null) {
      bool = localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, localaomc);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      a(localaomc.jdField_a_of_type_Long);
      b(localaomc.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void b(aomc paramaomc)
  {
    if (paramaomc == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramaomc.jdField_a_of_type_Long), paramaomc);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramaomc.jdField_a_of_type_Long + "] addDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
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
  
  public long a(String paramString, aomd paramaomd)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramString)) {
        return -1L;
      }
      this.b.add(paramString);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        aomc localaomc = new aomc();
        localaomc.jdField_c_of_type_JavaLangString = paramString;
        localaomc.jdField_d_of_type_JavaLangString = (paramString + ".tmp");
        localaomc.jdField_a_of_type_Aomd = paramaomd;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localaomc.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localaomc);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localaomc.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
        l = localaomc.jdField_a_of_type_Long;
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
    if ((apdq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(paramString6)))
    {
      QLog.i("ThumbHttpDownloader<FileAssistant><FileAssistant>", 1, "[Thumb Download] download thumb support IPv6. domain[" + paramString6 + "]");
      paramString4.add(0, paramString6 + ":" + paramInt);
    }
    paramString3.jdField_a_of_type_Aojs = new aojs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
    if (paramBoolean2) {
      paramString3.jdField_a_of_type_Aojs.a(true);
    }
    paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_Aojs.a();
    paramString3.jdField_a_of_type_Boolean = paramBoolean2;
    paramString3.jdField_e_of_type_JavaLangString = paramString5;
    paramString3.jdField_a_of_type_Short = paramShort;
    ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
  }
  
  public final void a(bakw arg1, bakw parambakw2)
  {
    long l1 = Long.parseLong(???.jdField_a_of_type_JavaLangString);
    int j = 0;
    aomc localaomc = a(l1);
    if (localaomc == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != localaomc.jdField_a_of_type_Bakw)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    localaomc.jdField_b_of_type_Bakw = parambakw2;
    if (parambakw2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(localaomc, true);
      if (localaomc.jdField_a_of_type_Aomd != null) {
        localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, false, -7, null, localaomc);
      }
      a(localaomc.jdField_a_of_type_Long);
      b(localaomc.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localaomc.jdField_a_of_type_ArrayOfInt)
    {
      if (parambakw2.c() != 206)
      {
        i = j;
        if (parambakw2.c() != 200) {}
      }
      else if (localaomc.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localaomc, true);
        if (localaomc.jdField_a_of_type_Aomd != null) {
          localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, false, -8, null, localaomc);
        }
        a(localaomc.jdField_a_of_type_Long);
        b(localaomc.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localaomc.jdField_a_of_type_JavaIoFileOutputStream.write(parambakw2.a());
        if (localaomc.jdField_b_of_type_Long == 0L)
        {
          long l2 = parambakw2.a();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localaomc.jdField_b_of_type_Long = l2;
        }
        localaomc.jdField_e_of_type_Long = parambakw2.a().length;
        localaomc.jdField_c_of_type_Long += localaomc.jdField_e_of_type_Long;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localaomc.jdField_e_of_type_Long + "],total[" + String.valueOf(localaomc.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localaomc.jdField_b_of_type_Long) + "]");
        if (localaomc.jdField_c_of_type_Long >= localaomc.jdField_b_of_type_Long) {
          localaomc.jdField_a_of_type_Bakw = null;
        }
      }
      catch (Exception parambakw2)
      {
        try
        {
          localaomc.jdField_a_of_type_JavaIoFileOutputStream.flush();
          localaomc.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(localaomc, false);
          boolean bool = true;
          i = 0;
          if (!bace.b(new File(localaomc.jdField_d_of_type_JavaLangString), new File(localaomc.jdField_c_of_type_JavaLangString)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (localaomc.jdField_a_of_type_Aomd != null) {
            localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, bool, i, localaomc.jdField_c_of_type_JavaLangString, localaomc);
          }
          a(localaomc.jdField_a_of_type_Long);
          b(localaomc.jdField_d_of_type_JavaLangString);
          i = 1;
          if (i == 0) {
            break;
          }
          b();
          return;
        }
        catch (IOException parambakw2)
        {
          parambakw2.printStackTrace();
          a(localaomc, true);
          if (localaomc.jdField_a_of_type_Aomd == null) {
            break label777;
          }
          localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, false, -8, null, localaomc);
          a(localaomc.jdField_a_of_type_Long);
          b(localaomc.jdField_d_of_type_JavaLangString);
          b();
          return;
        }
        parambakw2 = parambakw2;
        parambakw2.printStackTrace();
        a(localaomc, true);
        if (localaomc.jdField_a_of_type_Aomd != null) {
          localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, false, -8, null, localaomc);
        }
        a(localaomc.jdField_a_of_type_Long);
        b(localaomc.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
      label777:
      int k = (int)((float)localaomc.jdField_c_of_type_Long / (float)localaomc.jdField_b_of_type_Long * 10000.0F);
      i = j;
      if (localaomc.jdField_a_of_type_Aomd != null)
      {
        localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, k, localaomc);
        i = j;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public final boolean a(bakw parambakw1, bakw parambakw2, int paramInt)
  {
    return true;
  }
  
  public final void b(bakw parambakw1, bakw parambakw2)
  {
    long l = -1L;
    if (parambakw1 != null) {
      l = Long.parseLong(parambakw1.jdField_a_of_type_JavaLangString);
    }
    aomc localaomc = a(l);
    if (localaomc == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      b();
      return;
    }
    if (parambakw2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(localaomc, true);
      if (localaomc.jdField_a_of_type_Aomd != null) {
        localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, false, -1, null, localaomc);
      }
      a(localaomc.jdField_a_of_type_Long);
      b(localaomc.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = parambakw2.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localaomc.jdField_b_of_type_Bakw = parambakw2;
    int i = parambakw2.f;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!badq.d(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localaomc, true);
      if (localaomc.jdField_a_of_type_Aomd != null) {
        localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, false, -3, null, localaomc);
      }
      a(localaomc.jdField_a_of_type_Long);
      b(localaomc.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (parambakw1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(localaomc, true);
      if (localaomc.jdField_a_of_type_Aomd != null) {
        localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, false, i, null, localaomc);
      }
      a(localaomc.jdField_a_of_type_Long);
      b(localaomc.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (parambakw2.d()) {
        break;
      }
      i = -4;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
    }
    if (localaomc.jdField_b_of_type_Int < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + localaomc.jdField_b_of_type_Int + " eofRetry:" + localaomc.jdField_d_of_type_Int);
      localaomc.jdField_b_of_type_Int += 1;
      if ((i == 9056) && (localaomc.jdField_d_of_type_Int < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + localaomc.jdField_b_of_type_Int + " eofRetry:" + localaomc.jdField_d_of_type_Int);
        localaomc.jdField_b_of_type_Int -= 1;
      }
      for (localaomc.jdField_d_of_type_Int += 1;; localaomc.jdField_d_of_type_Int = 0)
      {
        a(localaomc, true);
        if (localaomc.jdField_a_of_type_Aomd != null) {
          localaomc.jdField_a_of_type_Aomd.a(localaomc.jdField_a_of_type_Long, localaomc);
        }
        localaomc.jdField_c_of_type_Int += 1;
        a(localaomc);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (localaomc.jdField_a_of_type_Aojs != null) {}
    for (parambakw1 = localaomc.jdField_a_of_type_Aojs.a();; parambakw1 = null)
    {
      if (parambakw1 != null)
      {
        localaomc.jdField_b_of_type_Int = 0;
        localaomc.jdField_d_of_type_Int = 0;
        localaomc.jdField_a_of_type_JavaLangString = parambakw1;
        a(localaomc, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localaomc.jdField_a_of_type_Bakw);
        if (localaomc.jdField_a_of_type_Aomd != null) {
          localaomc.jdField_a_of_type_Aomd.b(localaomc.jdField_a_of_type_Long, localaomc);
        }
        localaomc.jdField_c_of_type_Int += 1;
        a(localaomc);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomb
 * JD-Core Version:    0.7.0.1
 */