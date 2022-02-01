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

public class atgv
  implements bguz
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, atgw> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<atgw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = atut.a().d();
  }
  
  public atgv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private atgw a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      atgw localatgw = (atgw)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localatgw;
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
  
  private void a(atgw paramatgw)
  {
    if (paramatgw.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramatgw.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(paramatgw.jdField_d_of_type_JavaLangString) + "]");
      paramatgw.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramatgw.jdField_d_of_type_JavaLangString, true);
      bgux localbgux = new bgux(paramatgw.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (bgnt.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localbgux.a("Net-type", str);
      localbgux.a("Range", "bytes=0-");
      localbgux.b(5);
      localbgux.a(true);
      localbgux.jdField_b_of_type_Int = 0;
      localbgux.jdField_c_of_type_Int = 0;
      localbgux.jdField_a_of_type_JavaLangString = String.valueOf(paramatgw.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramatgw.jdField_a_of_type_Long + "] start runDownload... , url[" + paramatgw.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localbgux.jdField_c_of_type_Int) + "]");
      localbgux.a("Accept-Encoding", "identity");
      if (paramatgw.jdField_a_of_type_Atgx != null) {
        paramatgw.jdField_a_of_type_Atgx.a(paramatgw.jdField_a_of_type_Long, localbgux);
      }
      if (!TextUtils.isEmpty(paramatgw.jdField_b_of_type_JavaLangString)) {
        localbgux.a("Cookie", paramatgw.jdField_b_of_type_JavaLangString);
      }
      str = "";
      if (paramatgw.jdField_a_of_type_JavaLangString != null) {
        str = paramatgw.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      if ((paramatgw.jdField_a_of_type_Boolean) && (str.startsWith("https")))
      {
        localbgux.i = true;
        localbgux.j = atdx.a(paramatgw.jdField_a_of_type_JavaLangString);
        localbgux.jdField_e_of_type_JavaLangString = paramatgw.jdField_e_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramatgw.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbgux);
      paramatgw.jdField_a_of_type_Bgux = localbgux;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(paramatgw, true);
      if (paramatgw.jdField_a_of_type_Atgx != null) {
        paramatgw.jdField_a_of_type_Atgx.a(paramatgw.jdField_a_of_type_Long, false, -2, null, paramatgw);
      }
      a(paramatgw.jdField_a_of_type_Long);
      b(paramatgw.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void a(atgw paramatgw, boolean paramBoolean)
  {
    if (paramatgw == null) {}
    for (;;)
    {
      return;
      paramatgw.jdField_c_of_type_Long = 0L;
      try
      {
        if (paramatgw.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramatgw.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramatgw.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream:");
        }
        for (;;)
        {
          if (paramatgw.jdField_a_of_type_Bgux != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b(paramatgw.jdField_a_of_type_Bgux);
          }
          if (!paramBoolean) {
            break;
          }
          atwl.c(paramatgw.jdField_d_of_type_JavaLangString);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramatgw.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    atgw localatgw = (atgw)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localatgw == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(localatgw);
    b(localatgw);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localatgw.jdField_a_of_type_Long + "] downloadNext send cs get url. thumb task,");
    localatgw.jdField_d_of_type_Long = System.currentTimeMillis();
    if (localatgw.jdField_a_of_type_Atgx != null) {
      bool = localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, localatgw);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      a(localatgw.jdField_a_of_type_Long);
      b(localatgw.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void b(atgw paramatgw)
  {
    if (paramatgw == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramatgw.jdField_a_of_type_Long), paramatgw);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramatgw.jdField_a_of_type_Long + "] addDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
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
  
  public long a(String paramString, atgx paramatgx)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramString)) {
        return -1L;
      }
      this.b.add(paramString);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        atgw localatgw = new atgw();
        localatgw.jdField_c_of_type_JavaLangString = paramString;
        localatgw.jdField_d_of_type_JavaLangString = (paramString + ".tmp");
        localatgw.jdField_a_of_type_Atgx = paramatgx;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localatgw.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localatgw);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localatgw.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
        l = localatgw.jdField_a_of_type_Long;
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
      if (paramString3.jdField_a_of_type_Atgx != null)
      {
        paramString1 = paramString3.jdField_a_of_type_Atgx.a(paramLong, paramString6, paramInt, paramBoolean1, paramString1);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          if (atcq.a())
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
      paramString3.jdField_a_of_type_Atdx = new atdx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
      if (paramBoolean2) {
        paramString3.jdField_a_of_type_Atdx.a(true);
      }
      paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_Atdx.a();
      paramString3.jdField_a_of_type_Boolean = paramBoolean2;
      paramString3.jdField_e_of_type_JavaLangString = paramString5;
      paramString3.jdField_a_of_type_Short = paramShort;
      ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
      return;
    }
  }
  
  public final void a(bgux arg1, bgux parambgux2)
  {
    long l1 = Long.parseLong(???.jdField_a_of_type_JavaLangString);
    int j = 0;
    atgw localatgw = a(l1);
    if (localatgw == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != localatgw.jdField_a_of_type_Bgux)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    localatgw.jdField_b_of_type_Bgux = parambgux2;
    if (parambgux2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(localatgw, true);
      if (localatgw.jdField_a_of_type_Atgx != null) {
        localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, false, -7, null, localatgw);
      }
      a(localatgw.jdField_a_of_type_Long);
      b(localatgw.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localatgw.jdField_a_of_type_ArrayOfInt)
    {
      if (parambgux2.c() != 206)
      {
        i = j;
        if (parambgux2.c() != 200) {}
      }
      else if (localatgw.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localatgw, true);
        if (localatgw.jdField_a_of_type_Atgx != null) {
          localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, false, -8, null, localatgw);
        }
        a(localatgw.jdField_a_of_type_Long);
        b(localatgw.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localatgw.jdField_a_of_type_JavaIoFileOutputStream.write(parambgux2.a());
        if (localatgw.jdField_b_of_type_Long == 0L)
        {
          long l2 = parambgux2.a();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localatgw.jdField_b_of_type_Long = l2;
        }
        localatgw.jdField_e_of_type_Long = parambgux2.a().length;
        localatgw.jdField_c_of_type_Long += localatgw.jdField_e_of_type_Long;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localatgw.jdField_e_of_type_Long + "],total[" + String.valueOf(localatgw.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localatgw.jdField_b_of_type_Long) + "]");
        if (localatgw.jdField_c_of_type_Long >= localatgw.jdField_b_of_type_Long) {
          localatgw.jdField_a_of_type_Bgux = null;
        }
      }
      catch (Exception parambgux2)
      {
        try
        {
          localatgw.jdField_a_of_type_JavaIoFileOutputStream.flush();
          localatgw.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(localatgw, false);
          boolean bool = true;
          i = 0;
          if (!bgmg.b(new File(localatgw.jdField_d_of_type_JavaLangString), new File(localatgw.jdField_c_of_type_JavaLangString)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (localatgw.jdField_a_of_type_Atgx != null) {
            localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, bool, i, localatgw.jdField_c_of_type_JavaLangString, localatgw);
          }
          a(localatgw.jdField_a_of_type_Long);
          b(localatgw.jdField_d_of_type_JavaLangString);
          i = 1;
          if (i == 0) {
            break;
          }
          b();
          return;
        }
        catch (IOException parambgux2)
        {
          parambgux2.printStackTrace();
          a(localatgw, true);
          if (localatgw.jdField_a_of_type_Atgx == null) {
            break label777;
          }
          localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, false, -8, null, localatgw);
          a(localatgw.jdField_a_of_type_Long);
          b(localatgw.jdField_d_of_type_JavaLangString);
          b();
          return;
        }
        parambgux2 = parambgux2;
        parambgux2.printStackTrace();
        a(localatgw, true);
        if (localatgw.jdField_a_of_type_Atgx != null) {
          localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, false, -8, null, localatgw);
        }
        a(localatgw.jdField_a_of_type_Long);
        b(localatgw.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
      label777:
      int k = (int)((float)localatgw.jdField_c_of_type_Long / (float)localatgw.jdField_b_of_type_Long * 10000.0F);
      i = j;
      if (localatgw.jdField_a_of_type_Atgx != null)
      {
        localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, k, localatgw);
        i = j;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public final boolean a(bgux parambgux1, bgux parambgux2, int paramInt)
  {
    return true;
  }
  
  public final void b(bgux parambgux1, bgux parambgux2)
  {
    long l = -1L;
    if (parambgux1 != null) {
      l = Long.parseLong(parambgux1.jdField_a_of_type_JavaLangString);
    }
    atgw localatgw = a(l);
    if (localatgw == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      b();
      return;
    }
    if (parambgux2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(localatgw, true);
      if (localatgw.jdField_a_of_type_Atgx != null) {
        localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, false, -1, null, localatgw);
      }
      a(localatgw.jdField_a_of_type_Long);
      b(localatgw.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = parambgux2.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localatgw.jdField_b_of_type_Bgux = parambgux2;
    int i = parambgux2.f;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!bgnt.d(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localatgw, true);
      if (localatgw.jdField_a_of_type_Atgx != null) {
        localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, false, -3, null, localatgw);
      }
      a(localatgw.jdField_a_of_type_Long);
      b(localatgw.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (parambgux1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(localatgw, true);
      if (localatgw.jdField_a_of_type_Atgx != null) {
        localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, false, i, null, localatgw);
      }
      a(localatgw.jdField_a_of_type_Long);
      b(localatgw.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (!parambgux2.c())
      {
        i = -4;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
      }
      else
      {
        if ((parambgux2.jdField_a_of_type_JavaNetHttpURLConnection == null) || (!a(parambgux2.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderField("User-ReturnCode")))) {
          break;
        }
        i = -10;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] file over size and server can not create thumb. over");
      }
    }
    if (localatgw.jdField_b_of_type_Int < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + localatgw.jdField_b_of_type_Int + " eofRetry:" + localatgw.jdField_d_of_type_Int);
      localatgw.jdField_b_of_type_Int += 1;
      if ((i == 9056) && (localatgw.jdField_d_of_type_Int < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + localatgw.jdField_b_of_type_Int + " eofRetry:" + localatgw.jdField_d_of_type_Int);
        localatgw.jdField_b_of_type_Int -= 1;
      }
      for (localatgw.jdField_d_of_type_Int += 1;; localatgw.jdField_d_of_type_Int = 0)
      {
        a(localatgw, true);
        if (localatgw.jdField_a_of_type_Atgx != null) {
          localatgw.jdField_a_of_type_Atgx.a(localatgw.jdField_a_of_type_Long, localatgw);
        }
        localatgw.jdField_c_of_type_Int += 1;
        a(localatgw);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (localatgw.jdField_a_of_type_Atdx != null) {}
    for (parambgux1 = localatgw.jdField_a_of_type_Atdx.a();; parambgux1 = null)
    {
      if (parambgux1 != null)
      {
        localatgw.jdField_b_of_type_Int = 0;
        localatgw.jdField_d_of_type_Int = 0;
        localatgw.jdField_a_of_type_JavaLangString = parambgux1;
        a(localatgw, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b(localatgw.jdField_a_of_type_Bgux);
        if (localatgw.jdField_a_of_type_Atgx != null) {
          localatgw.jdField_a_of_type_Atgx.b(localatgw.jdField_a_of_type_Long, localatgw);
        }
        localatgw.jdField_c_of_type_Int += 1;
        a(localatgw);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atgv
 * JD-Core Version:    0.7.0.1
 */