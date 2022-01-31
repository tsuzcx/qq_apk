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

public class arag
  implements bdpz
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, arah> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<arah> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = arqx.a().d();
  }
  
  public arag(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private arah a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] is in map:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong)));
      arah localarah = (arah)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localarah;
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
  
  private void a(arah paramarah)
  {
    if (paramarah.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramarah.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(paramarah.jdField_d_of_type_JavaLangString) + "]");
      paramarah.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramarah.jdField_d_of_type_JavaLangString, true);
      bdpx localbdpx = new bdpx(paramarah.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (bdin.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localbdpx.a("Net-type", str);
      localbdpx.a("Range", "bytes=0-");
      localbdpx.b(5);
      localbdpx.a(true);
      localbdpx.jdField_b_of_type_Int = 0;
      localbdpx.jdField_c_of_type_Int = 0;
      localbdpx.jdField_a_of_type_JavaLangString = String.valueOf(paramarah.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramarah.jdField_a_of_type_Long + "] start runDownload... , url[" + paramarah.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localbdpx.jdField_c_of_type_Int) + "]");
      localbdpx.a("Accept-Encoding", "identity");
      if (paramarah.jdField_a_of_type_Arai != null) {
        paramarah.jdField_a_of_type_Arai.a(paramarah.jdField_a_of_type_Long, localbdpx);
      }
      if (!TextUtils.isEmpty(paramarah.jdField_b_of_type_JavaLangString)) {
        localbdpx.a("Cookie", paramarah.jdField_b_of_type_JavaLangString);
      }
      str = "";
      if (paramarah.jdField_a_of_type_JavaLangString != null) {
        str = paramarah.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      if ((paramarah.jdField_a_of_type_Boolean) && (str.startsWith("https")))
      {
        localbdpx.j = true;
        localbdpx.k = aqxx.a(paramarah.jdField_a_of_type_JavaLangString);
        localbdpx.jdField_e_of_type_JavaLangString = paramarah.jdField_e_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramarah.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbdpx);
      paramarah.jdField_a_of_type_Bdpx = localbdpx;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(paramarah, true);
      if (paramarah.jdField_a_of_type_Arai != null) {
        paramarah.jdField_a_of_type_Arai.a(paramarah.jdField_a_of_type_Long, false, -2, null, paramarah);
      }
      a(paramarah.jdField_a_of_type_Long);
      b(paramarah.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void a(arah paramarah, boolean paramBoolean)
  {
    if (paramarah == null) {}
    for (;;)
    {
      return;
      paramarah.jdField_c_of_type_Long = 0L;
      try
      {
        if (paramarah.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramarah.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramarah.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream:");
        }
        for (;;)
        {
          if (paramarah.jdField_a_of_type_Bdpx != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(paramarah.jdField_a_of_type_Bdpx);
          }
          if (!paramBoolean) {
            break;
          }
          arso.c(paramarah.jdField_d_of_type_JavaLangString);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramarah.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    arah localarah = (arah)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localarah == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(localarah);
    b(localarah);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localarah.jdField_a_of_type_Long + "] downloadNext send cs get url. thumb task,");
    localarah.jdField_d_of_type_Long = System.currentTimeMillis();
    if (localarah.jdField_a_of_type_Arai != null) {
      bool = localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, localarah);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      a(localarah.jdField_a_of_type_Long);
      b(localarah.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void b(arah paramarah)
  {
    if (paramarah == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramarah.jdField_a_of_type_Long), paramarah);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramarah.jdField_a_of_type_Long + "] addDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
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
  
  public long a(String paramString, arai paramarai)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramString)) {
        return -1L;
      }
      this.b.add(paramString);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        arah localarah = new arah();
        localarah.jdField_c_of_type_JavaLangString = paramString;
        localarah.jdField_d_of_type_JavaLangString = (paramString + ".tmp");
        localarah.jdField_a_of_type_Arai = paramarai;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localarah.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localarah);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localarah.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
        l = localarah.jdField_a_of_type_Long;
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
    if ((arsx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(paramString6)))
    {
      QLog.i("ThumbHttpDownloader<FileAssistant><FileAssistant>", 1, "[Thumb Download] download thumb support IPv6. domain[" + paramString6 + "]");
      paramString4.add(0, paramString6 + ":" + paramInt);
    }
    paramString3.jdField_a_of_type_Aqxx = new aqxx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
    if (paramBoolean2) {
      paramString3.jdField_a_of_type_Aqxx.a(true);
    }
    paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_Aqxx.a();
    paramString3.jdField_a_of_type_Boolean = paramBoolean2;
    paramString3.jdField_e_of_type_JavaLangString = paramString5;
    paramString3.jdField_a_of_type_Short = paramShort;
    ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
  }
  
  public final void a(bdpx arg1, bdpx parambdpx2)
  {
    long l1 = Long.parseLong(???.jdField_a_of_type_JavaLangString);
    int j = 0;
    arah localarah = a(l1);
    if (localarah == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != localarah.jdField_a_of_type_Bdpx)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    localarah.jdField_b_of_type_Bdpx = parambdpx2;
    if (parambdpx2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(localarah, true);
      if (localarah.jdField_a_of_type_Arai != null) {
        localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, false, -7, null, localarah);
      }
      a(localarah.jdField_a_of_type_Long);
      b(localarah.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localarah.jdField_a_of_type_ArrayOfInt)
    {
      if (parambdpx2.c() != 206)
      {
        i = j;
        if (parambdpx2.c() != 200) {}
      }
      else if (localarah.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localarah, true);
        if (localarah.jdField_a_of_type_Arai != null) {
          localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, false, -8, null, localarah);
        }
        a(localarah.jdField_a_of_type_Long);
        b(localarah.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localarah.jdField_a_of_type_JavaIoFileOutputStream.write(parambdpx2.a());
        if (localarah.jdField_b_of_type_Long == 0L)
        {
          long l2 = parambdpx2.a();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localarah.jdField_b_of_type_Long = l2;
        }
        localarah.jdField_e_of_type_Long = parambdpx2.a().length;
        localarah.jdField_c_of_type_Long += localarah.jdField_e_of_type_Long;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localarah.jdField_e_of_type_Long + "],total[" + String.valueOf(localarah.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localarah.jdField_b_of_type_Long) + "]");
        if (localarah.jdField_c_of_type_Long >= localarah.jdField_b_of_type_Long) {
          localarah.jdField_a_of_type_Bdpx = null;
        }
      }
      catch (Exception parambdpx2)
      {
        try
        {
          localarah.jdField_a_of_type_JavaIoFileOutputStream.flush();
          localarah.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(localarah, false);
          boolean bool = true;
          i = 0;
          if (!bdhb.b(new File(localarah.jdField_d_of_type_JavaLangString), new File(localarah.jdField_c_of_type_JavaLangString)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (localarah.jdField_a_of_type_Arai != null) {
            localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, bool, i, localarah.jdField_c_of_type_JavaLangString, localarah);
          }
          a(localarah.jdField_a_of_type_Long);
          b(localarah.jdField_d_of_type_JavaLangString);
          i = 1;
          if (i == 0) {
            break;
          }
          b();
          return;
        }
        catch (IOException parambdpx2)
        {
          parambdpx2.printStackTrace();
          a(localarah, true);
          if (localarah.jdField_a_of_type_Arai == null) {
            break label777;
          }
          localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, false, -8, null, localarah);
          a(localarah.jdField_a_of_type_Long);
          b(localarah.jdField_d_of_type_JavaLangString);
          b();
          return;
        }
        parambdpx2 = parambdpx2;
        parambdpx2.printStackTrace();
        a(localarah, true);
        if (localarah.jdField_a_of_type_Arai != null) {
          localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, false, -8, null, localarah);
        }
        a(localarah.jdField_a_of_type_Long);
        b(localarah.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
      label777:
      int k = (int)((float)localarah.jdField_c_of_type_Long / (float)localarah.jdField_b_of_type_Long * 10000.0F);
      i = j;
      if (localarah.jdField_a_of_type_Arai != null)
      {
        localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, k, localarah);
        i = j;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public final boolean a(bdpx parambdpx1, bdpx parambdpx2, int paramInt)
  {
    return true;
  }
  
  public final void b(bdpx parambdpx1, bdpx parambdpx2)
  {
    long l = -1L;
    if (parambdpx1 != null) {
      l = Long.parseLong(parambdpx1.jdField_a_of_type_JavaLangString);
    }
    arah localarah = a(l);
    if (localarah == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      b();
      return;
    }
    if (parambdpx2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(localarah, true);
      if (localarah.jdField_a_of_type_Arai != null) {
        localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, false, -1, null, localarah);
      }
      a(localarah.jdField_a_of_type_Long);
      b(localarah.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = parambdpx2.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localarah.jdField_b_of_type_Bdpx = parambdpx2;
    int i = parambdpx2.f;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!bdin.d(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localarah, true);
      if (localarah.jdField_a_of_type_Arai != null) {
        localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, false, -3, null, localarah);
      }
      a(localarah.jdField_a_of_type_Long);
      b(localarah.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (parambdpx1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(localarah, true);
      if (localarah.jdField_a_of_type_Arai != null) {
        localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, false, i, null, localarah);
      }
      a(localarah.jdField_a_of_type_Long);
      b(localarah.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (!parambdpx2.d())
      {
        i = -4;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
      }
      else
      {
        if (parambdpx2.jdField_a_of_type_JavaNetHttpURLConnection == null) {
          break;
        }
        parambdpx1 = parambdpx2.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderField("User-ReturnCode");
        if ((TextUtils.isEmpty(parambdpx1)) || ((!parambdpx1.equals("-441")) && (!parambdpx1.equals("-443")) && (!parambdpx1.equals("-447")) && (!parambdpx1.equals("-29224")) && (!parambdpx1.equals("-31717")))) {
          break;
        }
        i = -10;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] file over size and server can not create thumb. over");
      }
    }
    if (localarah.jdField_b_of_type_Int < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + localarah.jdField_b_of_type_Int + " eofRetry:" + localarah.jdField_d_of_type_Int);
      localarah.jdField_b_of_type_Int += 1;
      if ((i == 9056) && (localarah.jdField_d_of_type_Int < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + localarah.jdField_b_of_type_Int + " eofRetry:" + localarah.jdField_d_of_type_Int);
        localarah.jdField_b_of_type_Int -= 1;
      }
      for (localarah.jdField_d_of_type_Int += 1;; localarah.jdField_d_of_type_Int = 0)
      {
        a(localarah, true);
        if (localarah.jdField_a_of_type_Arai != null) {
          localarah.jdField_a_of_type_Arai.a(localarah.jdField_a_of_type_Long, localarah);
        }
        localarah.jdField_c_of_type_Int += 1;
        a(localarah);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (localarah.jdField_a_of_type_Aqxx != null) {}
    for (parambdpx1 = localarah.jdField_a_of_type_Aqxx.a();; parambdpx1 = null)
    {
      if (parambdpx1 != null)
      {
        localarah.jdField_b_of_type_Int = 0;
        localarah.jdField_d_of_type_Int = 0;
        localarah.jdField_a_of_type_JavaLangString = parambdpx1;
        a(localarah, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localarah.jdField_a_of_type_Bdpx);
        if (localarah.jdField_a_of_type_Arai != null) {
          localarah.jdField_a_of_type_Arai.b(localarah.jdField_a_of_type_Long, localarah);
        }
        localarah.jdField_c_of_type_Int += 1;
        a(localarah);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arag
 * JD-Core Version:    0.7.0.1
 */