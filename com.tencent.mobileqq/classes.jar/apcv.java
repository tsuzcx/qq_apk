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

public class apcv
  implements bbmi
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, apcw> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<apcw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = apti.a().d();
  }
  
  public apcv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private apcw a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] is in map:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong)));
      apcw localapcw = (apcw)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localapcw;
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
  
  private void a(apcw paramapcw)
  {
    if (paramapcw.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramapcw.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(paramapcw.jdField_d_of_type_JavaLangString) + "]");
      paramapcw.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramapcw.jdField_d_of_type_JavaLangString, true);
      bbmg localbbmg = new bbmg(paramapcw.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (bbev.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localbbmg.a("Net-type", str);
      localbbmg.a("Range", "bytes=0-");
      localbbmg.b(5);
      localbbmg.a(true);
      localbbmg.jdField_b_of_type_Int = 0;
      localbbmg.jdField_c_of_type_Int = 0;
      localbbmg.jdField_a_of_type_JavaLangString = String.valueOf(paramapcw.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramapcw.jdField_a_of_type_Long + "] start runDownload... , url[" + paramapcw.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localbbmg.jdField_c_of_type_Int) + "]");
      localbbmg.a("Accept-Encoding", "identity");
      if (paramapcw.jdField_a_of_type_Apcx != null) {
        paramapcw.jdField_a_of_type_Apcx.a(paramapcw.jdField_a_of_type_Long, localbbmg);
      }
      if (!TextUtils.isEmpty(paramapcw.jdField_b_of_type_JavaLangString)) {
        localbbmg.a("Cookie", paramapcw.jdField_b_of_type_JavaLangString);
      }
      str = "";
      if (paramapcw.jdField_a_of_type_JavaLangString != null) {
        str = paramapcw.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      if ((paramapcw.jdField_a_of_type_Boolean) && (str.startsWith("https")))
      {
        localbbmg.j = true;
        localbbmg.k = apam.a(paramapcw.jdField_a_of_type_JavaLangString);
        localbbmg.jdField_e_of_type_JavaLangString = paramapcw.jdField_e_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramapcw.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbbmg);
      paramapcw.jdField_a_of_type_Bbmg = localbbmg;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(paramapcw, true);
      if (paramapcw.jdField_a_of_type_Apcx != null) {
        paramapcw.jdField_a_of_type_Apcx.a(paramapcw.jdField_a_of_type_Long, false, -2, null, paramapcw);
      }
      a(paramapcw.jdField_a_of_type_Long);
      b(paramapcw.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void a(apcw paramapcw, boolean paramBoolean)
  {
    if (paramapcw == null) {}
    for (;;)
    {
      return;
      paramapcw.jdField_c_of_type_Long = 0L;
      try
      {
        if (paramapcw.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramapcw.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramapcw.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream:");
        }
        for (;;)
        {
          if (paramapcw.jdField_a_of_type_Bbmg != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(paramapcw.jdField_a_of_type_Bbmg);
          }
          if (!paramBoolean) {
            break;
          }
          apvb.c(paramapcw.jdField_d_of_type_JavaLangString);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramapcw.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    apcw localapcw = (apcw)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localapcw == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(localapcw);
    b(localapcw);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localapcw.jdField_a_of_type_Long + "] downloadNext send cs get url. thumb task,");
    localapcw.jdField_d_of_type_Long = System.currentTimeMillis();
    if (localapcw.jdField_a_of_type_Apcx != null) {
      bool = localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, localapcw);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      a(localapcw.jdField_a_of_type_Long);
      b(localapcw.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void b(apcw paramapcw)
  {
    if (paramapcw == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramapcw.jdField_a_of_type_Long), paramapcw);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramapcw.jdField_a_of_type_Long + "] addDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
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
  
  public long a(String paramString, apcx paramapcx)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramString)) {
        return -1L;
      }
      this.b.add(paramString);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        apcw localapcw = new apcw();
        localapcw.jdField_c_of_type_JavaLangString = paramString;
        localapcw.jdField_d_of_type_JavaLangString = (paramString + ".tmp");
        localapcw.jdField_a_of_type_Apcx = paramapcx;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localapcw.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localapcw);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localapcw.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
        l = localapcw.jdField_a_of_type_Long;
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
    if ((apvk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(paramString6)))
    {
      QLog.i("ThumbHttpDownloader<FileAssistant><FileAssistant>", 1, "[Thumb Download] download thumb support IPv6. domain[" + paramString6 + "]");
      paramString4.add(0, paramString6 + ":" + paramInt);
    }
    paramString3.jdField_a_of_type_Apam = new apam(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
    if (paramBoolean2) {
      paramString3.jdField_a_of_type_Apam.a(true);
    }
    paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_Apam.a();
    paramString3.jdField_a_of_type_Boolean = paramBoolean2;
    paramString3.jdField_e_of_type_JavaLangString = paramString5;
    paramString3.jdField_a_of_type_Short = paramShort;
    ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
  }
  
  public final void a(bbmg arg1, bbmg parambbmg2)
  {
    long l1 = Long.parseLong(???.jdField_a_of_type_JavaLangString);
    int j = 0;
    apcw localapcw = a(l1);
    if (localapcw == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != localapcw.jdField_a_of_type_Bbmg)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    localapcw.jdField_b_of_type_Bbmg = parambbmg2;
    if (parambbmg2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(localapcw, true);
      if (localapcw.jdField_a_of_type_Apcx != null) {
        localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, false, -7, null, localapcw);
      }
      a(localapcw.jdField_a_of_type_Long);
      b(localapcw.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localapcw.jdField_a_of_type_ArrayOfInt)
    {
      if (parambbmg2.c() != 206)
      {
        i = j;
        if (parambbmg2.c() != 200) {}
      }
      else if (localapcw.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localapcw, true);
        if (localapcw.jdField_a_of_type_Apcx != null) {
          localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, false, -8, null, localapcw);
        }
        a(localapcw.jdField_a_of_type_Long);
        b(localapcw.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localapcw.jdField_a_of_type_JavaIoFileOutputStream.write(parambbmg2.a());
        if (localapcw.jdField_b_of_type_Long == 0L)
        {
          long l2 = parambbmg2.a();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localapcw.jdField_b_of_type_Long = l2;
        }
        localapcw.jdField_e_of_type_Long = parambbmg2.a().length;
        localapcw.jdField_c_of_type_Long += localapcw.jdField_e_of_type_Long;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localapcw.jdField_e_of_type_Long + "],total[" + String.valueOf(localapcw.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localapcw.jdField_b_of_type_Long) + "]");
        if (localapcw.jdField_c_of_type_Long >= localapcw.jdField_b_of_type_Long) {
          localapcw.jdField_a_of_type_Bbmg = null;
        }
      }
      catch (Exception parambbmg2)
      {
        try
        {
          localapcw.jdField_a_of_type_JavaIoFileOutputStream.flush();
          localapcw.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(localapcw, false);
          boolean bool = true;
          i = 0;
          if (!bbdj.b(new File(localapcw.jdField_d_of_type_JavaLangString), new File(localapcw.jdField_c_of_type_JavaLangString)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (localapcw.jdField_a_of_type_Apcx != null) {
            localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, bool, i, localapcw.jdField_c_of_type_JavaLangString, localapcw);
          }
          a(localapcw.jdField_a_of_type_Long);
          b(localapcw.jdField_d_of_type_JavaLangString);
          i = 1;
          if (i == 0) {
            break;
          }
          b();
          return;
        }
        catch (IOException parambbmg2)
        {
          parambbmg2.printStackTrace();
          a(localapcw, true);
          if (localapcw.jdField_a_of_type_Apcx == null) {
            break label777;
          }
          localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, false, -8, null, localapcw);
          a(localapcw.jdField_a_of_type_Long);
          b(localapcw.jdField_d_of_type_JavaLangString);
          b();
          return;
        }
        parambbmg2 = parambbmg2;
        parambbmg2.printStackTrace();
        a(localapcw, true);
        if (localapcw.jdField_a_of_type_Apcx != null) {
          localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, false, -8, null, localapcw);
        }
        a(localapcw.jdField_a_of_type_Long);
        b(localapcw.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
      label777:
      int k = (int)((float)localapcw.jdField_c_of_type_Long / (float)localapcw.jdField_b_of_type_Long * 10000.0F);
      i = j;
      if (localapcw.jdField_a_of_type_Apcx != null)
      {
        localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, k, localapcw);
        i = j;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public final boolean a(bbmg parambbmg1, bbmg parambbmg2, int paramInt)
  {
    return true;
  }
  
  public final void b(bbmg parambbmg1, bbmg parambbmg2)
  {
    long l = -1L;
    if (parambbmg1 != null) {
      l = Long.parseLong(parambbmg1.jdField_a_of_type_JavaLangString);
    }
    apcw localapcw = a(l);
    if (localapcw == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      b();
      return;
    }
    if (parambbmg2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(localapcw, true);
      if (localapcw.jdField_a_of_type_Apcx != null) {
        localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, false, -1, null, localapcw);
      }
      a(localapcw.jdField_a_of_type_Long);
      b(localapcw.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = parambbmg2.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localapcw.jdField_b_of_type_Bbmg = parambbmg2;
    int i = parambbmg2.f;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!bbev.d(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localapcw, true);
      if (localapcw.jdField_a_of_type_Apcx != null) {
        localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, false, -3, null, localapcw);
      }
      a(localapcw.jdField_a_of_type_Long);
      b(localapcw.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (parambbmg1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(localapcw, true);
      if (localapcw.jdField_a_of_type_Apcx != null) {
        localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, false, i, null, localapcw);
      }
      a(localapcw.jdField_a_of_type_Long);
      b(localapcw.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (!parambbmg2.d())
      {
        i = -4;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
      }
      else
      {
        if (parambbmg2.jdField_a_of_type_JavaNetHttpURLConnection == null) {
          break;
        }
        parambbmg1 = parambbmg2.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderField("User-ReturnCode");
        if ((TextUtils.isEmpty(parambbmg1)) || ((!parambbmg1.equals("-441")) && (!parambbmg1.equals("-443")) && (!parambbmg1.equals("-447")) && (!parambbmg1.equals("-29224")) && (!parambbmg1.equals("-31717")))) {
          break;
        }
        i = -10;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] file over size and server can not create thumb. over");
      }
    }
    if (localapcw.jdField_b_of_type_Int < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + localapcw.jdField_b_of_type_Int + " eofRetry:" + localapcw.jdField_d_of_type_Int);
      localapcw.jdField_b_of_type_Int += 1;
      if ((i == 9056) && (localapcw.jdField_d_of_type_Int < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + localapcw.jdField_b_of_type_Int + " eofRetry:" + localapcw.jdField_d_of_type_Int);
        localapcw.jdField_b_of_type_Int -= 1;
      }
      for (localapcw.jdField_d_of_type_Int += 1;; localapcw.jdField_d_of_type_Int = 0)
      {
        a(localapcw, true);
        if (localapcw.jdField_a_of_type_Apcx != null) {
          localapcw.jdField_a_of_type_Apcx.a(localapcw.jdField_a_of_type_Long, localapcw);
        }
        localapcw.jdField_c_of_type_Int += 1;
        a(localapcw);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (localapcw.jdField_a_of_type_Apam != null) {}
    for (parambbmg1 = localapcw.jdField_a_of_type_Apam.a();; parambbmg1 = null)
    {
      if (parambbmg1 != null)
      {
        localapcw.jdField_b_of_type_Int = 0;
        localapcw.jdField_d_of_type_Int = 0;
        localapcw.jdField_a_of_type_JavaLangString = parambbmg1;
        a(localapcw, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localapcw.jdField_a_of_type_Bbmg);
        if (localapcw.jdField_a_of_type_Apcx != null) {
          localapcw.jdField_a_of_type_Apcx.b(localapcw.jdField_a_of_type_Long, localapcw);
        }
        localapcw.jdField_c_of_type_Int += 1;
        a(localapcw);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apcv
 * JD-Core Version:    0.7.0.1
 */