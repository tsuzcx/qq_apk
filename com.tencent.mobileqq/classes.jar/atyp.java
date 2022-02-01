import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class atyp
  implements bhvc
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, atyq> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<atyq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = aumo.a().d();
  }
  
  public atyp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private atyq a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      atyq localatyq = (atyq)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localatyq;
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
  
  private void a(atyq paramatyq)
  {
    if (paramatyq.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramatyq.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(paramatyq.jdField_d_of_type_JavaLangString) + "]");
      paramatyq.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramatyq.jdField_d_of_type_JavaLangString, true);
      bhva localbhva = new bhva(paramatyq.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (bhnv.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localbhva.a("Net-type", str);
      localbhva.a("Range", "bytes=0-");
      localbhva.b(5);
      localbhva.a(true);
      localbhva.jdField_b_of_type_Int = 0;
      localbhva.jdField_c_of_type_Int = 0;
      localbhva.jdField_a_of_type_JavaLangString = String.valueOf(paramatyq.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramatyq.jdField_a_of_type_Long + "] start runDownload... , url[" + paramatyq.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localbhva.jdField_c_of_type_Int) + "]");
      localbhva.a("Accept-Encoding", "identity");
      if (paramatyq.jdField_a_of_type_Atyr != null) {
        paramatyq.jdField_a_of_type_Atyr.a(paramatyq.jdField_a_of_type_Long, localbhva);
      }
      if (!TextUtils.isEmpty(paramatyq.jdField_b_of_type_JavaLangString)) {
        localbhva.a("Cookie", paramatyq.jdField_b_of_type_JavaLangString);
      }
      str = "";
      if (paramatyq.jdField_a_of_type_JavaLangString != null) {
        str = paramatyq.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      if ((paramatyq.jdField_a_of_type_Boolean) && (str.startsWith("https")))
      {
        localbhva.i = true;
        localbhva.j = atvr.a(paramatyq.jdField_a_of_type_JavaLangString);
        localbhva.jdField_e_of_type_JavaLangString = paramatyq.jdField_e_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramatyq.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbhva);
      paramatyq.jdField_a_of_type_Bhva = localbhva;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(paramatyq, true);
      if (paramatyq.jdField_a_of_type_Atyr != null) {
        paramatyq.jdField_a_of_type_Atyr.a(paramatyq.jdField_a_of_type_Long, false, -2, null, paramatyq);
      }
      a(paramatyq.jdField_a_of_type_Long);
      b(paramatyq.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void a(atyq paramatyq, boolean paramBoolean)
  {
    if (paramatyq == null) {}
    for (;;)
    {
      return;
      paramatyq.jdField_c_of_type_Long = 0L;
      try
      {
        if (paramatyq.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramatyq.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramatyq.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream:");
        }
        for (;;)
        {
          if (paramatyq.jdField_a_of_type_Bhva != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b(paramatyq.jdField_a_of_type_Bhva);
          }
          if (!paramBoolean) {
            break;
          }
          auog.c(paramatyq.jdField_d_of_type_JavaLangString);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramatyq.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream: exception");
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("-441")) && (!paramString.equals("-443")) && (!paramString.equals("-447")) && (!paramString.equals("-29224")) && (!paramString.equals("-31717"))) {
      return false;
    }
    return true;
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
    atyq localatyq = (atyq)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localatyq == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(localatyq);
    b(localatyq);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localatyq.jdField_a_of_type_Long + "] downloadNext send cs get url. thumb task,");
    localatyq.jdField_d_of_type_Long = System.currentTimeMillis();
    if (localatyq.jdField_a_of_type_Atyr != null) {
      bool = localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, localatyq);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      a(localatyq.jdField_a_of_type_Long);
      b(localatyq.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void b(atyq paramatyq)
  {
    if (paramatyq == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramatyq.jdField_a_of_type_Long), paramatyq);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramatyq.jdField_a_of_type_Long + "] addDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      return;
    }
  }
  
  private void b(String paramString)
  {
    synchronized (this.b)
    {
      this.b.remove(paramString);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + jdField_a_of_type_Long + "], Name[" + paramString + "] removeDowloadingList,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      return;
    }
  }
  
  public long a(String paramString, atyr paramatyr)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramString)) {
        return -1L;
      }
      this.b.add(paramString);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        atyq localatyq = new atyq();
        localatyq.jdField_c_of_type_JavaLangString = paramString;
        localatyq.jdField_d_of_type_JavaLangString = (paramString + ".tmp");
        localatyq.jdField_a_of_type_Atyr = paramatyr;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localatyq.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localatyq);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localatyq.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
        l = localatyq.jdField_a_of_type_Long;
        return l;
      }
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(long paramLong, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, short paramShort, String paramString6, Bundle paramBundle)
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
    for (;;)
    {
      paramString3.jdField_b_of_type_JavaLangString = paramString4;
      paramString1 = paramString1 + ":" + paramInt;
      paramString4 = new ArrayList(1);
      paramString4.add(paramString1);
      paramBoolean1 = false;
      paramString1 = null;
      if (paramBundle != null)
      {
        paramBoolean1 = paramBundle.getBoolean("usemediaplatform", false);
        paramString1 = paramBundle.getStringArrayList("ipv6list");
      }
      if (paramString3.jdField_a_of_type_Atyr != null)
      {
        paramString1 = paramString3.jdField_a_of_type_Atyr.a(paramLong, paramString6, paramInt, paramBoolean1, paramString1);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          if (atul.a())
          {
            QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] debugIsDisableIPv4OnDoubleStack");
            paramString4.clear();
          }
          paramInt = paramString1.size() - 1;
          while (paramInt >= 0)
          {
            paramString4.add(0, (String)paramString1.get(paramInt));
            paramInt -= 1;
          }
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] runDownload use IPv6");
        }
      }
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] runDownload use IPList:" + paramString4.toString());
      paramString3.jdField_a_of_type_Atvr = new atvr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
      if (paramBoolean2) {
        paramString3.jdField_a_of_type_Atvr.a(true);
      }
      paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_Atvr.a();
      paramString3.jdField_a_of_type_Boolean = paramBoolean2;
      paramString3.jdField_e_of_type_JavaLangString = paramString5;
      paramString3.jdField_a_of_type_Short = paramShort;
      ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
      return;
    }
  }
  
  public final void a(bhva arg1, bhva parambhva2)
  {
    long l1 = Long.parseLong(???.jdField_a_of_type_JavaLangString);
    int j = 0;
    atyq localatyq = a(l1);
    if (localatyq == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != localatyq.jdField_a_of_type_Bhva)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    localatyq.jdField_b_of_type_Bhva = parambhva2;
    if (parambhva2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(localatyq, true);
      if (localatyq.jdField_a_of_type_Atyr != null) {
        localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, false, -7, null, localatyq);
      }
      a(localatyq.jdField_a_of_type_Long);
      b(localatyq.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localatyq.jdField_a_of_type_ArrayOfInt)
    {
      if (parambhva2.c() != 206)
      {
        i = j;
        if (parambhva2.c() != 200) {}
      }
      else if (localatyq.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localatyq, true);
        if (localatyq.jdField_a_of_type_Atyr != null) {
          localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, false, -8, null, localatyq);
        }
        a(localatyq.jdField_a_of_type_Long);
        b(localatyq.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localatyq.jdField_a_of_type_JavaIoFileOutputStream.write(parambhva2.a());
        if (localatyq.jdField_b_of_type_Long == 0L)
        {
          long l2 = parambhva2.a();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localatyq.jdField_b_of_type_Long = l2;
        }
        localatyq.jdField_e_of_type_Long = parambhva2.a().length;
        localatyq.jdField_c_of_type_Long += localatyq.jdField_e_of_type_Long;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localatyq.jdField_e_of_type_Long + "],total[" + String.valueOf(localatyq.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localatyq.jdField_b_of_type_Long) + "]");
        if (localatyq.jdField_c_of_type_Long >= localatyq.jdField_b_of_type_Long) {
          localatyq.jdField_a_of_type_Bhva = null;
        }
      }
      catch (Exception parambhva2)
      {
        try
        {
          localatyq.jdField_a_of_type_JavaIoFileOutputStream.flush();
          localatyq.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(localatyq, false);
          boolean bool = true;
          i = 0;
          if (!bhmi.b(new File(localatyq.jdField_d_of_type_JavaLangString), new File(localatyq.jdField_c_of_type_JavaLangString)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (localatyq.jdField_a_of_type_Atyr != null) {
            localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, bool, i, localatyq.jdField_c_of_type_JavaLangString, localatyq);
          }
          a(localatyq.jdField_a_of_type_Long);
          b(localatyq.jdField_d_of_type_JavaLangString);
          i = 1;
          if (i == 0) {
            break;
          }
          b();
          return;
        }
        catch (IOException parambhva2)
        {
          parambhva2.printStackTrace();
          a(localatyq, true);
          if (localatyq.jdField_a_of_type_Atyr == null) {
            break label777;
          }
          localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, false, -8, null, localatyq);
          a(localatyq.jdField_a_of_type_Long);
          b(localatyq.jdField_d_of_type_JavaLangString);
          b();
          return;
        }
        parambhva2 = parambhva2;
        parambhva2.printStackTrace();
        a(localatyq, true);
        if (localatyq.jdField_a_of_type_Atyr != null) {
          localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, false, -8, null, localatyq);
        }
        a(localatyq.jdField_a_of_type_Long);
        b(localatyq.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
      label777:
      int k = (int)((float)localatyq.jdField_c_of_type_Long / (float)localatyq.jdField_b_of_type_Long * 10000.0F);
      i = j;
      if (localatyq.jdField_a_of_type_Atyr != null)
      {
        localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, k, localatyq);
        i = j;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public final boolean a(bhva parambhva1, bhva parambhva2, int paramInt)
  {
    return true;
  }
  
  public final void b(bhva parambhva1, bhva parambhva2)
  {
    long l = -1L;
    if (parambhva1 != null) {
      l = Long.parseLong(parambhva1.jdField_a_of_type_JavaLangString);
    }
    atyq localatyq = a(l);
    if (localatyq == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      b();
      return;
    }
    if (parambhva2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(localatyq, true);
      if (localatyq.jdField_a_of_type_Atyr != null) {
        localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, false, -1, null, localatyq);
      }
      a(localatyq.jdField_a_of_type_Long);
      b(localatyq.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = parambhva2.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localatyq.jdField_b_of_type_Bhva = parambhva2;
    int i = parambhva2.f;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!bhnv.d(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localatyq, true);
      if (localatyq.jdField_a_of_type_Atyr != null) {
        localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, false, -3, null, localatyq);
      }
      a(localatyq.jdField_a_of_type_Long);
      b(localatyq.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (parambhva1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(localatyq, true);
      if (localatyq.jdField_a_of_type_Atyr != null) {
        localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, false, i, null, localatyq);
      }
      a(localatyq.jdField_a_of_type_Long);
      b(localatyq.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (!parambhva2.c())
      {
        i = -4;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
      }
      else
      {
        if ((parambhva2.jdField_a_of_type_JavaNetHttpURLConnection == null) || (!a(parambhva2.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderField("User-ReturnCode")))) {
          break;
        }
        i = -10;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] file over size and server can not create thumb. over");
      }
    }
    if (localatyq.jdField_b_of_type_Int < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + localatyq.jdField_b_of_type_Int + " eofRetry:" + localatyq.jdField_d_of_type_Int);
      localatyq.jdField_b_of_type_Int += 1;
      if ((i == 9056) && (localatyq.jdField_d_of_type_Int < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + localatyq.jdField_b_of_type_Int + " eofRetry:" + localatyq.jdField_d_of_type_Int);
        localatyq.jdField_b_of_type_Int -= 1;
      }
      for (localatyq.jdField_d_of_type_Int += 1;; localatyq.jdField_d_of_type_Int = 0)
      {
        a(localatyq, true);
        if (localatyq.jdField_a_of_type_Atyr != null) {
          localatyq.jdField_a_of_type_Atyr.a(localatyq.jdField_a_of_type_Long, localatyq);
        }
        localatyq.jdField_c_of_type_Int += 1;
        a(localatyq);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (localatyq.jdField_a_of_type_Atvr != null) {}
    for (parambhva1 = localatyq.jdField_a_of_type_Atvr.a();; parambhva1 = null)
    {
      if (parambhva1 != null)
      {
        localatyq.jdField_b_of_type_Int = 0;
        localatyq.jdField_d_of_type_Int = 0;
        localatyq.jdField_a_of_type_JavaLangString = parambhva1;
        a(localatyq, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b(localatyq.jdField_a_of_type_Bhva);
        if (localatyq.jdField_a_of_type_Atyr != null) {
          localatyq.jdField_a_of_type_Atyr.b(localatyq.jdField_a_of_type_Long, localatyq);
        }
        localatyq.jdField_c_of_type_Int += 1;
        a(localatyq);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atyp
 * JD-Core Version:    0.7.0.1
 */