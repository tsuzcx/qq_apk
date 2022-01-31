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

public class aqvx
  implements bdlq
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, aqvy> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<aqvy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = armo.a().d();
  }
  
  public aqvx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private aqvy a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] is in map:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong)));
      aqvy localaqvy = (aqvy)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localaqvy;
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
  
  private void a(aqvy paramaqvy)
  {
    if (paramaqvy.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramaqvy.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(paramaqvy.jdField_d_of_type_JavaLangString) + "]");
      paramaqvy.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramaqvy.jdField_d_of_type_JavaLangString, true);
      bdlo localbdlo = new bdlo(paramaqvy.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (bdee.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localbdlo.a("Net-type", str);
      localbdlo.a("Range", "bytes=0-");
      localbdlo.b(5);
      localbdlo.a(true);
      localbdlo.jdField_b_of_type_Int = 0;
      localbdlo.jdField_c_of_type_Int = 0;
      localbdlo.jdField_a_of_type_JavaLangString = String.valueOf(paramaqvy.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramaqvy.jdField_a_of_type_Long + "] start runDownload... , url[" + paramaqvy.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localbdlo.jdField_c_of_type_Int) + "]");
      localbdlo.a("Accept-Encoding", "identity");
      if (paramaqvy.jdField_a_of_type_Aqvz != null) {
        paramaqvy.jdField_a_of_type_Aqvz.a(paramaqvy.jdField_a_of_type_Long, localbdlo);
      }
      if (!TextUtils.isEmpty(paramaqvy.jdField_b_of_type_JavaLangString)) {
        localbdlo.a("Cookie", paramaqvy.jdField_b_of_type_JavaLangString);
      }
      str = "";
      if (paramaqvy.jdField_a_of_type_JavaLangString != null) {
        str = paramaqvy.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      if ((paramaqvy.jdField_a_of_type_Boolean) && (str.startsWith("https")))
      {
        localbdlo.j = true;
        localbdlo.k = aqto.a(paramaqvy.jdField_a_of_type_JavaLangString);
        localbdlo.jdField_e_of_type_JavaLangString = paramaqvy.jdField_e_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramaqvy.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbdlo);
      paramaqvy.jdField_a_of_type_Bdlo = localbdlo;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(paramaqvy, true);
      if (paramaqvy.jdField_a_of_type_Aqvz != null) {
        paramaqvy.jdField_a_of_type_Aqvz.a(paramaqvy.jdField_a_of_type_Long, false, -2, null, paramaqvy);
      }
      a(paramaqvy.jdField_a_of_type_Long);
      b(paramaqvy.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void a(aqvy paramaqvy, boolean paramBoolean)
  {
    if (paramaqvy == null) {}
    for (;;)
    {
      return;
      paramaqvy.jdField_c_of_type_Long = 0L;
      try
      {
        if (paramaqvy.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramaqvy.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramaqvy.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream:");
        }
        for (;;)
        {
          if (paramaqvy.jdField_a_of_type_Bdlo != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(paramaqvy.jdField_a_of_type_Bdlo);
          }
          if (!paramBoolean) {
            break;
          }
          arof.c(paramaqvy.jdField_d_of_type_JavaLangString);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramaqvy.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    aqvy localaqvy = (aqvy)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localaqvy == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(localaqvy);
    b(localaqvy);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localaqvy.jdField_a_of_type_Long + "] downloadNext send cs get url. thumb task,");
    localaqvy.jdField_d_of_type_Long = System.currentTimeMillis();
    if (localaqvy.jdField_a_of_type_Aqvz != null) {
      bool = localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, localaqvy);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      a(localaqvy.jdField_a_of_type_Long);
      b(localaqvy.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void b(aqvy paramaqvy)
  {
    if (paramaqvy == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramaqvy.jdField_a_of_type_Long), paramaqvy);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramaqvy.jdField_a_of_type_Long + "] addDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
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
  
  public long a(String paramString, aqvz paramaqvz)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramString)) {
        return -1L;
      }
      this.b.add(paramString);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        aqvy localaqvy = new aqvy();
        localaqvy.jdField_c_of_type_JavaLangString = paramString;
        localaqvy.jdField_d_of_type_JavaLangString = (paramString + ".tmp");
        localaqvy.jdField_a_of_type_Aqvz = paramaqvz;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localaqvy.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localaqvy);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localaqvy.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
        l = localaqvy.jdField_a_of_type_Long;
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
    if ((aroo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(paramString6)))
    {
      QLog.i("ThumbHttpDownloader<FileAssistant><FileAssistant>", 1, "[Thumb Download] download thumb support IPv6. domain[" + paramString6 + "]");
      paramString4.add(0, paramString6 + ":" + paramInt);
    }
    paramString3.jdField_a_of_type_Aqto = new aqto(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
    if (paramBoolean2) {
      paramString3.jdField_a_of_type_Aqto.a(true);
    }
    paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_Aqto.a();
    paramString3.jdField_a_of_type_Boolean = paramBoolean2;
    paramString3.jdField_e_of_type_JavaLangString = paramString5;
    paramString3.jdField_a_of_type_Short = paramShort;
    ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
  }
  
  public final void a(bdlo arg1, bdlo parambdlo2)
  {
    long l1 = Long.parseLong(???.jdField_a_of_type_JavaLangString);
    int j = 0;
    aqvy localaqvy = a(l1);
    if (localaqvy == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != localaqvy.jdField_a_of_type_Bdlo)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    localaqvy.jdField_b_of_type_Bdlo = parambdlo2;
    if (parambdlo2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(localaqvy, true);
      if (localaqvy.jdField_a_of_type_Aqvz != null) {
        localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, false, -7, null, localaqvy);
      }
      a(localaqvy.jdField_a_of_type_Long);
      b(localaqvy.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localaqvy.jdField_a_of_type_ArrayOfInt)
    {
      if (parambdlo2.c() != 206)
      {
        i = j;
        if (parambdlo2.c() != 200) {}
      }
      else if (localaqvy.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localaqvy, true);
        if (localaqvy.jdField_a_of_type_Aqvz != null) {
          localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, false, -8, null, localaqvy);
        }
        a(localaqvy.jdField_a_of_type_Long);
        b(localaqvy.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localaqvy.jdField_a_of_type_JavaIoFileOutputStream.write(parambdlo2.a());
        if (localaqvy.jdField_b_of_type_Long == 0L)
        {
          long l2 = parambdlo2.a();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localaqvy.jdField_b_of_type_Long = l2;
        }
        localaqvy.jdField_e_of_type_Long = parambdlo2.a().length;
        localaqvy.jdField_c_of_type_Long += localaqvy.jdField_e_of_type_Long;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localaqvy.jdField_e_of_type_Long + "],total[" + String.valueOf(localaqvy.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localaqvy.jdField_b_of_type_Long) + "]");
        if (localaqvy.jdField_c_of_type_Long >= localaqvy.jdField_b_of_type_Long) {
          localaqvy.jdField_a_of_type_Bdlo = null;
        }
      }
      catch (Exception parambdlo2)
      {
        try
        {
          localaqvy.jdField_a_of_type_JavaIoFileOutputStream.flush();
          localaqvy.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(localaqvy, false);
          boolean bool = true;
          i = 0;
          if (!bdcs.b(new File(localaqvy.jdField_d_of_type_JavaLangString), new File(localaqvy.jdField_c_of_type_JavaLangString)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (localaqvy.jdField_a_of_type_Aqvz != null) {
            localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, bool, i, localaqvy.jdField_c_of_type_JavaLangString, localaqvy);
          }
          a(localaqvy.jdField_a_of_type_Long);
          b(localaqvy.jdField_d_of_type_JavaLangString);
          i = 1;
          if (i == 0) {
            break;
          }
          b();
          return;
        }
        catch (IOException parambdlo2)
        {
          parambdlo2.printStackTrace();
          a(localaqvy, true);
          if (localaqvy.jdField_a_of_type_Aqvz == null) {
            break label777;
          }
          localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, false, -8, null, localaqvy);
          a(localaqvy.jdField_a_of_type_Long);
          b(localaqvy.jdField_d_of_type_JavaLangString);
          b();
          return;
        }
        parambdlo2 = parambdlo2;
        parambdlo2.printStackTrace();
        a(localaqvy, true);
        if (localaqvy.jdField_a_of_type_Aqvz != null) {
          localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, false, -8, null, localaqvy);
        }
        a(localaqvy.jdField_a_of_type_Long);
        b(localaqvy.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
      label777:
      int k = (int)((float)localaqvy.jdField_c_of_type_Long / (float)localaqvy.jdField_b_of_type_Long * 10000.0F);
      i = j;
      if (localaqvy.jdField_a_of_type_Aqvz != null)
      {
        localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, k, localaqvy);
        i = j;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public final boolean a(bdlo parambdlo1, bdlo parambdlo2, int paramInt)
  {
    return true;
  }
  
  public final void b(bdlo parambdlo1, bdlo parambdlo2)
  {
    long l = -1L;
    if (parambdlo1 != null) {
      l = Long.parseLong(parambdlo1.jdField_a_of_type_JavaLangString);
    }
    aqvy localaqvy = a(l);
    if (localaqvy == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      b();
      return;
    }
    if (parambdlo2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(localaqvy, true);
      if (localaqvy.jdField_a_of_type_Aqvz != null) {
        localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, false, -1, null, localaqvy);
      }
      a(localaqvy.jdField_a_of_type_Long);
      b(localaqvy.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = parambdlo2.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localaqvy.jdField_b_of_type_Bdlo = parambdlo2;
    int i = parambdlo2.f;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!bdee.d(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localaqvy, true);
      if (localaqvy.jdField_a_of_type_Aqvz != null) {
        localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, false, -3, null, localaqvy);
      }
      a(localaqvy.jdField_a_of_type_Long);
      b(localaqvy.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (parambdlo1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(localaqvy, true);
      if (localaqvy.jdField_a_of_type_Aqvz != null) {
        localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, false, i, null, localaqvy);
      }
      a(localaqvy.jdField_a_of_type_Long);
      b(localaqvy.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (!parambdlo2.d())
      {
        i = -4;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
      }
      else
      {
        if (parambdlo2.jdField_a_of_type_JavaNetHttpURLConnection == null) {
          break;
        }
        parambdlo1 = parambdlo2.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderField("User-ReturnCode");
        if ((TextUtils.isEmpty(parambdlo1)) || ((!parambdlo1.equals("-441")) && (!parambdlo1.equals("-443")) && (!parambdlo1.equals("-447")) && (!parambdlo1.equals("-29224")) && (!parambdlo1.equals("-31717")))) {
          break;
        }
        i = -10;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] file over size and server can not create thumb. over");
      }
    }
    if (localaqvy.jdField_b_of_type_Int < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + localaqvy.jdField_b_of_type_Int + " eofRetry:" + localaqvy.jdField_d_of_type_Int);
      localaqvy.jdField_b_of_type_Int += 1;
      if ((i == 9056) && (localaqvy.jdField_d_of_type_Int < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + localaqvy.jdField_b_of_type_Int + " eofRetry:" + localaqvy.jdField_d_of_type_Int);
        localaqvy.jdField_b_of_type_Int -= 1;
      }
      for (localaqvy.jdField_d_of_type_Int += 1;; localaqvy.jdField_d_of_type_Int = 0)
      {
        a(localaqvy, true);
        if (localaqvy.jdField_a_of_type_Aqvz != null) {
          localaqvy.jdField_a_of_type_Aqvz.a(localaqvy.jdField_a_of_type_Long, localaqvy);
        }
        localaqvy.jdField_c_of_type_Int += 1;
        a(localaqvy);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (localaqvy.jdField_a_of_type_Aqto != null) {}
    for (parambdlo1 = localaqvy.jdField_a_of_type_Aqto.a();; parambdlo1 = null)
    {
      if (parambdlo1 != null)
      {
        localaqvy.jdField_b_of_type_Int = 0;
        localaqvy.jdField_d_of_type_Int = 0;
        localaqvy.jdField_a_of_type_JavaLangString = parambdlo1;
        a(localaqvy, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localaqvy.jdField_a_of_type_Bdlo);
        if (localaqvy.jdField_a_of_type_Aqvz != null) {
          localaqvy.jdField_a_of_type_Aqvz.b(localaqvy.jdField_a_of_type_Long, localaqvy);
        }
        localaqvy.jdField_c_of_type_Int += 1;
        a(localaqvy);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqvx
 * JD-Core Version:    0.7.0.1
 */