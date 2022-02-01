import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.1;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
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

public class atpf
  implements IHttpCommunicatorListener
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  private final int jdField_a_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<Long, atpg> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<atpg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = audf.a().d();
  }
  
  public atpf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private atpg a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      atpg localatpg = (atpg)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localatpg;
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
  
  private void a(atpg paramatpg)
  {
    if (paramatpg.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramatpg.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(paramatpg.jdField_d_of_type_JavaLangString) + "]");
      paramatpg.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramatpg.jdField_d_of_type_JavaLangString, true);
      HttpMsg localHttpMsg = new HttpMsg(paramatpg.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localHttpMsg.setRequestProperty("Net-type", str);
      localHttpMsg.setRequestProperty("Range", "bytes=0-");
      localHttpMsg.setPriority(5);
      localHttpMsg.setDataSlice(true);
      localHttpMsg.fileType = 0;
      localHttpMsg.busiType = 0;
      localHttpMsg.msgId = String.valueOf(paramatpg.jdField_a_of_type_Long);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramatpg.jdField_a_of_type_Long + "] start runDownload... , url[" + paramatpg.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localHttpMsg.busiType) + "]");
      localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
      if (paramatpg.jdField_a_of_type_Atph != null) {
        paramatpg.jdField_a_of_type_Atph.a(paramatpg.jdField_a_of_type_Long, localHttpMsg);
      }
      if (!TextUtils.isEmpty(paramatpg.jdField_b_of_type_JavaLangString)) {
        localHttpMsg.setRequestProperty("Cookie", paramatpg.jdField_b_of_type_JavaLangString);
      }
      str = "";
      if (paramatpg.jdField_a_of_type_JavaLangString != null) {
        str = paramatpg.jdField_a_of_type_JavaLangString.toLowerCase();
      }
      if ((paramatpg.jdField_a_of_type_Boolean) && (str.startsWith("https")))
      {
        localHttpMsg.mIsHttps = true;
        localHttpMsg.mIsHostIP = atmh.a(paramatpg.jdField_a_of_type_JavaLangString);
        localHttpMsg.mReqHost = paramatpg.jdField_e_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + paramatpg.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().sendMsg(localHttpMsg);
      paramatpg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(paramatpg, true);
      if (paramatpg.jdField_a_of_type_Atph != null) {
        paramatpg.jdField_a_of_type_Atph.a(paramatpg.jdField_a_of_type_Long, false, -2, null, paramatpg);
      }
      a(paramatpg.jdField_a_of_type_Long);
      a(paramatpg.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void a(atpg paramatpg, boolean paramBoolean)
  {
    if (paramatpg == null) {}
    for (;;)
    {
      return;
      paramatpg.jdField_c_of_type_Long = 0L;
      try
      {
        if (paramatpg.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramatpg.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramatpg.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream:");
        }
        for (;;)
        {
          if (paramatpg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().cancelMsg(paramatpg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
          }
          if (!paramBoolean) {
            break;
          }
          FileUtil.deleteFile(paramatpg.jdField_d_of_type_JavaLangString);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramatpg.jdField_a_of_type_JavaIoFileOutputStream = null;
          QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + jdField_a_of_type_Long + "]. closeFileStream: exception");
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.b)
    {
      this.b.remove(paramString);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + jdField_a_of_type_Long + "], Name[" + paramString + "] removeDowloadingList,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      return;
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
    atpg localatpg = (atpg)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localatpg == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(localatpg);
    b(localatpg);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localatpg.jdField_a_of_type_Long + "] downloadNext send cs get url. thumb task,");
    localatpg.jdField_d_of_type_Long = System.currentTimeMillis();
    if (localatpg.jdField_a_of_type_Atph != null) {
      bool = localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, localatpg);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      a(localatpg.jdField_a_of_type_Long);
      a(localatpg.jdField_d_of_type_JavaLangString);
      b();
    }
  }
  
  private void b(atpg paramatpg)
  {
    if (paramatpg == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramatpg.jdField_a_of_type_Long), paramatpg);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramatpg.jdField_a_of_type_Long + "] addDowloadingTask,size:" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      return;
    }
  }
  
  public long a(String paramString, atph paramatph)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramString)) {
        return -1L;
      }
      this.b.add(paramString);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        atpg localatpg = new atpg();
        localatpg.jdField_c_of_type_JavaLangString = paramString;
        localatpg.jdField_d_of_type_JavaLangString = (paramString + ".tmp");
        localatpg.jdField_a_of_type_Atph = paramatph;
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        localatpg.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilList.add(localatpg);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + localatpg.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
        l = localatpg.jdField_a_of_type_Long;
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
      a(paramString3.jdField_d_of_type_JavaLangString);
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
      if (paramString3.jdField_a_of_type_Atph != null)
      {
        paramString1 = paramString3.jdField_a_of_type_Atph.a(paramLong, paramString6, paramInt, paramBoolean1, paramString1);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          if (atlb.a())
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
      paramString3.jdField_a_of_type_Atmh = new atmh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramString2);
      if (paramBoolean2) {
        paramString3.jdField_a_of_type_Atmh.a(true);
      }
      paramString3.jdField_a_of_type_JavaLangString = paramString3.jdField_a_of_type_Atmh.a();
      paramString3.jdField_a_of_type_Boolean = paramBoolean2;
      paramString3.jdField_e_of_type_JavaLangString = paramString5;
      paramString3.jdField_a_of_type_Short = paramShort;
      ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
      return;
    }
  }
  
  public final void decode(HttpMsg arg1, HttpMsg paramHttpMsg2)
  {
    long l1 = Long.parseLong(???.msgId);
    int j = 0;
    atpg localatpg = a(l1);
    if (localatpg == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != localatpg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    localatpg.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg2;
    if (paramHttpMsg2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(localatpg, true);
      if (localatpg.jdField_a_of_type_Atph != null) {
        localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, false, -7, null, localatpg);
      }
      a(localatpg.jdField_a_of_type_Long);
      a(localatpg.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    int i;
    synchronized (localatpg.jdField_a_of_type_ArrayOfInt)
    {
      if (paramHttpMsg2.getResponseCode() != 206)
      {
        i = j;
        if (paramHttpMsg2.getResponseCode() != 200) {}
      }
      else if (localatpg.jdField_a_of_type_JavaIoFileOutputStream == null)
      {
        a(localatpg, true);
        if (localatpg.jdField_a_of_type_Atph != null) {
          localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, false, -8, null, localatpg);
        }
        a(localatpg.jdField_a_of_type_Long);
        a(localatpg.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
    }
    for (;;)
    {
      try
      {
        localatpg.jdField_a_of_type_JavaIoFileOutputStream.write(paramHttpMsg2.getRecvData());
        if (localatpg.jdField_b_of_type_Long == 0L)
        {
          long l2 = paramHttpMsg2.getTotalLen();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          localatpg.jdField_b_of_type_Long = l2;
        }
        localatpg.jdField_e_of_type_Long = paramHttpMsg2.getRecvData().length;
        localatpg.jdField_c_of_type_Long += localatpg.jdField_e_of_type_Long;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + localatpg.jdField_e_of_type_Long + "],total[" + String.valueOf(localatpg.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(localatpg.jdField_b_of_type_Long) + "]");
        if (localatpg.jdField_c_of_type_Long >= localatpg.jdField_b_of_type_Long) {
          localatpg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
        }
      }
      catch (Exception paramHttpMsg2)
      {
        try
        {
          localatpg.jdField_a_of_type_JavaIoFileOutputStream.flush();
          localatpg.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(localatpg, false);
          boolean bool = true;
          i = 0;
          if (!FileUtils.renameFile(new File(localatpg.jdField_d_of_type_JavaLangString), new File(localatpg.jdField_c_of_type_JavaLangString)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (localatpg.jdField_a_of_type_Atph != null) {
            localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, bool, i, localatpg.jdField_c_of_type_JavaLangString, localatpg);
          }
          a(localatpg.jdField_a_of_type_Long);
          a(localatpg.jdField_d_of_type_JavaLangString);
          i = 1;
          if (i == 0) {
            break;
          }
          b();
          return;
        }
        catch (IOException paramHttpMsg2)
        {
          paramHttpMsg2.printStackTrace();
          a(localatpg, true);
          if (localatpg.jdField_a_of_type_Atph == null) {
            break label777;
          }
          localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, false, -8, null, localatpg);
          a(localatpg.jdField_a_of_type_Long);
          a(localatpg.jdField_d_of_type_JavaLangString);
          b();
          return;
        }
        paramHttpMsg2 = paramHttpMsg2;
        paramHttpMsg2.printStackTrace();
        a(localatpg, true);
        if (localatpg.jdField_a_of_type_Atph != null) {
          localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, false, -8, null, localatpg);
        }
        a(localatpg.jdField_a_of_type_Long);
        a(localatpg.jdField_d_of_type_JavaLangString);
        b();
        return;
      }
      label777:
      int k = (int)((float)localatpg.jdField_c_of_type_Long / (float)localatpg.jdField_b_of_type_Long * 10000.0F);
      i = j;
      if (localatpg.jdField_a_of_type_Atph != null)
      {
        localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, k, localatpg);
        i = j;
      }
    }
  }
  
  public final void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    long l = -1L;
    if (paramHttpMsg1 != null) {
      l = Long.parseLong(paramHttpMsg1.msgId);
    }
    atpg localatpg = a(l);
    if (localatpg == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      b();
      return;
    }
    if (paramHttpMsg2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(localatpg, true);
      if (localatpg.jdField_a_of_type_Atph != null) {
        localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, false, -1, null, localatpg);
      }
      a(localatpg.jdField_a_of_type_Long);
      a(localatpg.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    String str2 = paramHttpMsg2.getErrorString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localatpg.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg2;
    int i = paramHttpMsg2.errCode;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(localatpg, true);
      if (localatpg.jdField_a_of_type_Atph != null) {
        localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, false, -3, null, localatpg);
      }
      a(localatpg.jdField_a_of_type_Long);
      a(localatpg.jdField_d_of_type_JavaLangString);
      b();
      return;
    }
    if (paramHttpMsg1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(localatpg, true);
      if (localatpg.jdField_a_of_type_Atph != null) {
        localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, false, i, null, localatpg);
      }
      a(localatpg.jdField_a_of_type_Long);
      a(localatpg.jdField_d_of_type_JavaLangString);
      b();
      return;
      if (!paramHttpMsg2.permitRetry())
      {
        i = -4;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
      }
      else
      {
        if ((paramHttpMsg2.mConn == null) || (!a(paramHttpMsg2.mConn.getHeaderField("User-ReturnCode")))) {
          break;
        }
        i = -10;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] file over size and server can not create thumb. over");
      }
    }
    if (localatpg.jdField_b_of_type_Int < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + localatpg.jdField_b_of_type_Int + " eofRetry:" + localatpg.jdField_d_of_type_Int);
      localatpg.jdField_b_of_type_Int += 1;
      if ((i == 9056) && (localatpg.jdField_d_of_type_Int < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + localatpg.jdField_b_of_type_Int + " eofRetry:" + localatpg.jdField_d_of_type_Int);
        localatpg.jdField_b_of_type_Int -= 1;
      }
      for (localatpg.jdField_d_of_type_Int += 1;; localatpg.jdField_d_of_type_Int = 0)
      {
        a(localatpg, true);
        if (localatpg.jdField_a_of_type_Atph != null) {
          localatpg.jdField_a_of_type_Atph.a(localatpg.jdField_a_of_type_Long, localatpg);
        }
        localatpg.jdField_c_of_type_Int += 1;
        a(localatpg);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (localatpg.jdField_a_of_type_Atmh != null) {}
    for (paramHttpMsg1 = localatpg.jdField_a_of_type_Atmh.a();; paramHttpMsg1 = null)
    {
      if (paramHttpMsg1 != null)
      {
        localatpg.jdField_b_of_type_Int = 0;
        localatpg.jdField_d_of_type_Int = 0;
        localatpg.jdField_a_of_type_JavaLangString = paramHttpMsg1;
        a(localatpg, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().cancelMsg(localatpg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
        if (localatpg.jdField_a_of_type_Atph != null) {
          localatpg.jdField_a_of_type_Atph.b(localatpg.jdField_a_of_type_Long, localatpg);
        }
        localatpg.jdField_c_of_type_Int += 1;
        a(localatpg);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
  
  public void handleRedirect(String paramString) {}
  
  public void onFlowEvent(HttpMsg paramHttpMsg) {}
  
  public final boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atpf
 * JD-Core Version:    0.7.0.1
 */