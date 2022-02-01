import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloaderImpl.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class atdt
  implements atds, ateb, ISPlayerDownloader.Listener
{
  private int jdField_a_of_type_Int = -1;
  private atdz jdField_a_of_type_Atdz;
  private atea jdField_a_of_type_Atea;
  private atnh jdField_a_of_type_Atnh;
  private ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  private SuperPlayerVideoInfo jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public atdt(atnh paramatnh)
  {
    this.jdField_a_of_type_JavaLangString = paramatnh.a();
    this.jdField_a_of_type_Atnh = paramatnh;
  }
  
  private void b(String paramString1, String paramString2)
  {
    String str = Md5Utils.getMD5(this.jdField_a_of_type_JavaLangString);
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "----build Videoinfo---- fileid:" + str);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atnh.b();
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(paramString1, 104, str, this.jdField_b_of_type_JavaLangString);
    if (paramString2 != null)
    {
      paramString1 = new ArrayList();
      paramString1.add(paramString2);
      this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.setCookies(paramString1);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.setFormat(104);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Atnh.a();
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Atdz != null) {
      this.jdField_a_of_type_Atdz.a(paramInt, paramString);
    }
  }
  
  public void a(atdz paramatdz)
  {
    this.jdField_a_of_type_Atdz = paramatdz;
  }
  
  public void a(atea paramatea)
  {
    this.jdField_a_of_type_Atea = paramatea;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader != null) && (this.jdField_a_of_type_Int > 0)) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "downloader exsited:" + this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      b(paramString1, paramString2);
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 109);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo, this);
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "start download task:" + this.jdField_a_of_type_Int);
    } while (this.jdField_a_of_type_Atdz == null);
    this.jdField_a_of_type_Atdz.a(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_Atdz = null;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo != null)
    {
      if (this.jdField_a_of_type_Atdz != null) {
        this.jdField_a_of_type_Atdz.a(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo);
      }
      if (this.jdField_a_of_type_Int > 0) {
        return true;
      }
    }
    this.jdField_a_of_type_Int = 0;
    long l = this.jdField_a_of_type_Atnh.a();
    String str = this.jdField_a_of_type_Atnh.b();
    if (l != atvo.a(str)) {
      bgmg.d(str);
    }
    this.jdField_a_of_type_Atnh.a(this);
    return true;
  }
  
  public String b()
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "isPlaying[" + this.jdField_a_of_type_Boolean + "], downloadSucc[" + this.jdField_b_of_type_Boolean + "]");
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
      return null;
    }
    String str = atvo.b(atut.a().b() + this.jdField_a_of_type_Atnh.c());
    if (!atwl.b(this.jdField_b_of_type_JavaLangString))
    {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "[" + this.jdField_a_of_type_Atnh.a() + "],File rename faild mybe renamed");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.jdField_a_of_type_Atnh.a() + "],File download over rename[" + str + "],src[" + this.jdField_b_of_type_JavaLangString + "]");
    }
    if (!bgmg.b(new File(this.jdField_b_of_type_JavaLangString), new File(str)))
    {
      this.jdField_a_of_type_Atnh.a(false);
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.jdField_a_of_type_Atnh.a() + "],File download over. rename success!");
    }
    this.jdField_a_of_type_Atnh.a(str);
    atdq.d(this.jdField_a_of_type_Atnh.a());
    atdq.b();
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "stop download:" + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != -1;
  }
  
  public void c()
  {
    b();
    onDownloadFinish();
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap) {}
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadCdnUrlUpdate(String paramString) {}
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadError(" + paramInt1 + "," + paramInt2 + "," + paramString + ")");
    this.jdField_a_of_type_Atnh.a(false);
    if (this.jdField_a_of_type_Atea == null) {
      return;
    }
    this.jdField_a_of_type_Atea.a(paramInt1, paramInt2, paramString);
  }
  
  public void onDownloadFinish()
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "---------->   onDownloadFinish:" + this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = true;
    String str = b();
    if (this.jdField_a_of_type_Atea == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileVideoDownloaderImpl.1(this, str));
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, String.format("%s is downloaded!", new Object[] { this.jdField_a_of_type_Atnh.a() }));
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Atnh.a(paramLong1);
    } while (this.jdField_a_of_type_Atea == null);
    if (QLog.isDebugVersion()) {
      QLog.d("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProgressUpdate(playableDurationMS:" + paramInt1 + ", downloadSpeedKBs:" + paramInt2 + ", currentDownloadSizeByte: " + paramLong1 + ", totalFileSizeByte: " + paramLong2 + ",)");
    }
    this.jdField_a_of_type_Atea.a(paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProtocolUpdate(" + paramString1 + "," + paramString2 + ",)");
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadStatusUpdate(" + paramInt + ",)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdt
 * JD-Core Version:    0.7.0.1
 */