import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloaderImpl.1;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
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

public class ashx
  implements ashw, asif, ISPlayerDownloader.Listener
{
  private int jdField_a_of_type_Int = -1;
  private asid jdField_a_of_type_Asid;
  private asie jdField_a_of_type_Asie;
  private asrm jdField_a_of_type_Asrm;
  private ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  private SuperPlayerVideoInfo jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public ashx(asrm paramasrm)
  {
    this.jdField_a_of_type_JavaLangString = paramasrm.a();
    this.jdField_a_of_type_Asrm = paramasrm;
  }
  
  private void b(String paramString1, String paramString2)
  {
    String str = Md5Utils.getMD5(this.jdField_a_of_type_JavaLangString);
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "----build Videoinfo---- fileid:" + str);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Asrm.b();
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
    return this.jdField_a_of_type_Asrm.a();
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Asid != null) {
      this.jdField_a_of_type_Asid.a(paramInt, paramString);
    }
  }
  
  public void a(asid paramasid)
  {
    this.jdField_a_of_type_Asid = paramasid;
  }
  
  public void a(asie paramasie)
  {
    this.jdField_a_of_type_Asie = paramasie;
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
    } while (this.jdField_a_of_type_Asid == null);
    this.jdField_a_of_type_Asid.a(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_Asid = null;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo != null)
    {
      if (this.jdField_a_of_type_Asid != null) {
        this.jdField_a_of_type_Asid.a(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo);
      }
      if (this.jdField_a_of_type_Int > 0) {
        return true;
      }
    }
    this.jdField_a_of_type_Int = 0;
    long l = this.jdField_a_of_type_Asrm.a();
    String str = this.jdField_a_of_type_Asrm.b();
    if (l != aszt.a(str)) {
      FileUtils.deleteFile(str);
    }
    this.jdField_a_of_type_Asrm.a(this);
    return true;
  }
  
  public String b()
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "isPlaying[" + this.jdField_a_of_type_Boolean + "], downloadSucc[" + this.jdField_b_of_type_Boolean + "]");
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
      return null;
    }
    String str = aszt.b(asyy.a().b() + this.jdField_a_of_type_Asrm.c());
    if (!FileUtil.fileExistsAndNotEmpty(this.jdField_b_of_type_JavaLangString))
    {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "[" + this.jdField_a_of_type_Asrm.a() + "],File rename faild mybe renamed");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.jdField_a_of_type_Asrm.a() + "],File download over rename[" + str + "],src[" + this.jdField_b_of_type_JavaLangString + "]");
    }
    if (!FileUtils.renameFile(new File(this.jdField_b_of_type_JavaLangString), new File(str)))
    {
      this.jdField_a_of_type_Asrm.a(false);
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.jdField_a_of_type_Asrm.a() + "],File download over. rename success!");
    }
    this.jdField_a_of_type_Asrm.a(str);
    ashu.d(this.jdField_a_of_type_Asrm.a());
    ashu.b();
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
    onDownloadFinish(0);
  }
  
  public void onDownloadCdnUrlExpired(int paramInt, Map<String, String> paramMap) {}
  
  public void onDownloadCdnUrlInfoUpdate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadCdnUrlUpdate(int paramInt, String paramString) {}
  
  public void onDownloadError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadError(" + paramInt2 + "," + paramInt3 + "," + paramString + ")");
    this.jdField_a_of_type_Asrm.a(false);
    if (this.jdField_a_of_type_Asie == null) {
      return;
    }
    this.jdField_a_of_type_Asie.a(paramInt2, paramInt3, paramString);
  }
  
  public void onDownloadFinish(int paramInt)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "---------->   onDownloadFinish:" + this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = true;
    String str = b();
    if (this.jdField_a_of_type_Asie == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileVideoDownloaderImpl.1(this, str));
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, String.format("%s is downloaded!", new Object[] { this.jdField_a_of_type_Asrm.a() }));
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Asrm.a(paramLong1);
    } while (this.jdField_a_of_type_Asie == null);
    if (QLog.isDebugVersion()) {
      QLog.d("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProgressUpdate(playableDurationMS:" + paramInt2 + ", downloadSpeedKBs:" + paramInt3 + ", currentDownloadSizeByte: " + paramLong1 + ", totalFileSizeByte: " + paramLong2 + ",)");
    }
    this.jdField_a_of_type_Asie.a(paramInt2, paramInt3, paramLong1, paramLong2);
  }
  
  public void onDownloadProtocolUpdate(int paramInt, String paramString1, String paramString2)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProtocolUpdate(" + paramString1 + "," + paramString2 + ",)");
  }
  
  public void onDownloadStatusUpdate(int paramInt1, int paramInt2)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadStatusUpdate(" + paramInt2 + ",)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashx
 * JD-Core Version:    0.7.0.1
 */