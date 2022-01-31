import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.HttpThumbDownloader.1;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class apao
  implements bbmw
{
  private final int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = -1L;
  private apap jdField_a_of_type_Apap;
  private bbmu jdField_a_of_type_Bbmu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private long e;
  
  public apao(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(this.jdField_d_of_type_JavaLangString) + "]");
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
      bbmu localbbmu = new bbmu(this.jdField_a_of_type_JavaLangString, null, this, true);
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
      localbbmu.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
      QLog.d("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.jdField_a_of_type_Long + "] start runDownload... , url[" + this.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localbbmu.jdField_c_of_type_Int) + "]");
      localbbmu.a("Accept-Encoding", "identity");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localbbmu.a("Cookie", this.jdField_b_of_type_JavaLangString);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ZipThumbDownloader", 1, "cookie:" + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbbmu);
      this.jdField_a_of_type_Bbmu = localbbmu;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      do
      {
        a(true);
      } while (this.jdField_a_of_type_Apap == null);
      this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, false, -2, null, this.jdField_a_of_type_Long);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Long = 0L;
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        QLog.i("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.jdField_a_of_type_Long + " closeFileStream");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Bbmu != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bbmu);
        }
        if (paramBoolean) {
          apvd.c(this.jdField_d_of_type_JavaLangString);
        }
        return;
        QLog.w("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.jdField_a_of_type_Long + " closeFileStream had closed: stream = null");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        QLog.e("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.jdField_a_of_type_Long + " closeFileStream");
        localIOException.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, apap paramapap)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = (paramString1 + ".tmp");
    this.jdField_a_of_type_Apap = paramapap;
    QLog.i("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    ThreadManager.post(new HttpThumbDownloader.1(this), 8, null, false);
  }
  
  public void a(bbmu parambbmu1, bbmu parambbmu2)
  {
    boolean bool = false;
    long l1 = -1L;
    if (parambbmu2 != null) {
      l1 = Long.parseLong(parambbmu2.jdField_a_of_type_JavaLangString);
    }
    if (l1 != this.jdField_a_of_type_Long) {
      QLog.e("ZipThumbDownloader", 1, "decode : [thumbId] = " + l1 + " but [currentTaskId] = " + this.jdField_a_of_type_Long);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (parambbmu2 != null) {
            break;
          }
          QLog.e("ZipThumbDownloader", 1, "decode : [thumbId] = " + l1 + "] decode resp = null ");
          a(true);
        } while (this.jdField_a_of_type_Apap == null);
        this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, false, -7, null, this.jdField_a_of_type_Long);
        return;
      } while ((parambbmu2.c() != 206) && (parambbmu2.c() != 200));
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
        break;
      }
      a(true);
    } while (this.jdField_a_of_type_Apap == null);
    this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, false, -8, null, this.jdField_a_of_type_Long);
    return;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.write(parambbmu2.a());
        if (0L == this.jdField_b_of_type_Long)
        {
          long l2 = parambbmu2.a();
          QLog.i("ZipThumbDownloader", 1, "decode : [thumbId] = " + l1 + "]  [thumb Size] = " + String.valueOf(l2));
          this.jdField_b_of_type_Long = l2;
        }
        this.e = parambbmu2.a().length;
        this.jdField_c_of_type_Long += this.e;
        QLog.d("ZipThumbDownloader", 4, "decode : recv packeg[" + this.e + "],total[" + String.valueOf(this.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(this.jdField_b_of_type_Long) + "]");
        if (this.jdField_c_of_type_Long < this.jdField_b_of_type_Long) {
          break label576;
        }
        this.jdField_a_of_type_Bbmu = null;
      }
      catch (Exception parambbmu1)
      {
        try
        {
          this.jdField_a_of_type_JavaIoFileOutputStream.flush();
          this.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(false);
          if (bbdx.b(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_c_of_type_JavaLangString))) {
            break label615;
          }
          i = -9;
          QLog.e("ZipThumbDownloader", 1, "decode : [downloadThumb] = " + this.jdField_a_of_type_Long + " renameFile failed");
          if (this.jdField_a_of_type_Apap == null) {
            break;
          }
          this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, bool, i, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Long);
          return;
        }
        catch (IOException parambbmu1)
        {
          parambbmu1.printStackTrace();
          a(true);
        }
        parambbmu1 = parambbmu1;
        parambbmu1.printStackTrace();
        a(true);
      }
      if (this.jdField_a_of_type_Apap == null) {
        break;
      }
      this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, false, -8, null, this.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_Apap == null) {
        break;
      }
      this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, false, -8, null, this.jdField_a_of_type_Long);
      return;
      label576:
      int i = (int)((float)this.jdField_c_of_type_Long / (float)this.jdField_b_of_type_Long * 10000.0F);
      if (this.jdField_a_of_type_Apap == null) {
        break;
      }
      this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, i);
      return;
      label615:
      i = 0;
      bool = true;
    }
  }
  
  public void a(String paramString) {}
  
  public boolean a(bbmu parambbmu1, bbmu parambbmu2, int paramInt)
  {
    return true;
  }
  
  public void b(bbmu parambbmu1, bbmu parambbmu2)
  {
    int i = -1;
    long l = -1L;
    if (parambbmu1 != null) {
      l = Long.parseLong(parambbmu1.jdField_a_of_type_JavaLangString);
    }
    if (l != this.jdField_a_of_type_Long) {
      QLog.e("ZipThumbDownloader", 1, "handleError : [thumbId] = " + l + " but [currentTaskId] = " + this.jdField_a_of_type_Long);
    }
    int j;
    do
    {
      do
      {
        return;
        if (parambbmu2 != null) {
          break;
        }
        QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " response is null");
        a(true);
      } while (this.jdField_a_of_type_Apap == null);
      this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, false, -1, null, this.jdField_a_of_type_Long);
      return;
      String str2 = parambbmu2.d();
      String str1 = str2;
      if (str2 == null) {
        str1 = "null";
      }
      j = parambbmu2.f;
      QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " handleError retCode [errCode] = " + j + ", [retMsg] = " + str1);
      if (bbfj.d(BaseApplication.getContext())) {
        break;
      }
      QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " net is broken");
      a(true);
    } while (this.jdField_a_of_type_Apap == null);
    this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, false, -3, null, this.jdField_a_of_type_Long);
    return;
    if (parambbmu1 == null)
    {
      i = -6;
      QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " request = null. over");
    }
    for (;;)
    {
      a(true);
      if (this.jdField_a_of_type_Apap == null) {
        break;
      }
      this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString, false, i, null, this.jdField_a_of_type_Long);
      return;
      if (!parambbmu2.d())
      {
        i = -4;
        QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " response.permitRetry = false. over");
      }
      else
      {
        if (this.jdField_b_of_type_Int < 3)
        {
          QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " try it. [retryTimes] = " + this.jdField_b_of_type_Int + " [eofRetry] = " + this.jdField_d_of_type_Int);
          this.jdField_b_of_type_Int += 1;
          if ((j == 9056) && (this.jdField_d_of_type_Int < 3))
          {
            QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " [Error_Exp_Eof retryTimes] = " + this.jdField_b_of_type_Int + " [eofRetry] = " + this.jdField_d_of_type_Int);
            this.jdField_b_of_type_Int -= 1;
          }
          for (this.jdField_d_of_type_Int += 1;; this.jdField_d_of_type_Int = 0)
          {
            a(true);
            if (this.jdField_a_of_type_Apap != null) {
              this.jdField_a_of_type_Apap.a(this.jdField_a_of_type_JavaLangString);
            }
            this.jdField_c_of_type_Int += 1;
            a();
            return;
          }
        }
        QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " try it. retryTimes > " + 3 + " download over....");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apao
 * JD-Core Version:    0.7.0.1
 */