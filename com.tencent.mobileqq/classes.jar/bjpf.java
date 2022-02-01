import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.1;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.2;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.3;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.4;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.5;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.6;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.7;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.8;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bjpf
  implements DownloadListener
{
  public bjpf(ApkFileDownloadButton paramApkFileDownloadButton) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    bjko.b("ApkFileDownloadButton_", "[installSucceed] packageName=" + paramString2 + ",mApkInfo=" + this.a.a);
    if ((this.a.a != null) && (TextUtils.equals(paramString2, this.a.a.f))) {
      ThreadManager.excute(new ApkFileDownloadButton.1.8(this, paramString2), 16, null, true);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (this.a.a(paramDownloadInfo, this.a.a))
    {
      bjko.b("ApkFileDownloadButton_", "onDownloadCancel info.progress=" + paramDownloadInfo.f);
      this.a.a.b = 1;
      this.a.a.jdField_a_of_type_Int = paramDownloadInfo.f;
      if (this.a.a.jdField_a_of_type_Long == 0L) {
        this.a.a.jdField_a_of_type_Long = paramDownloadInfo.c;
      }
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.5(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (this.a.a(paramDownloadInfo, this.a.a))
    {
      bjko.b("ApkFileDownloadButton_", "onDownloadError errorCode=" + paramInt1);
      if ((paramInt1 == 6) && (ApkFileDownloadButton.a(this.a) > 0))
      {
        ApkFileDownloadButton.a(this.a, paramDownloadInfo);
        ApkFileDownloadButton.a(this.a, ApkFileDownloadButton.a(this.a) - 1);
      }
    }
    else
    {
      return;
    }
    this.a.a.b = 30;
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.7(this));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (this.a.a(paramDownloadInfo, this.a.a))
    {
      bjko.b("ApkFileDownloadButton_", "onDownloadFinish info.progress=" + paramDownloadInfo.f);
      this.a.a.b = 4;
      this.a.a.jdField_a_of_type_Int = paramDownloadInfo.f;
      if (this.a.a.jdField_a_of_type_Long == 0L) {
        this.a.a.jdField_a_of_type_Long = paramDownloadInfo.c;
      }
      ThreadManager.excute(new ApkFileDownloadButton.1.3(this), 16, null, true);
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.4(this));
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (this.a.a(paramDownloadInfo, this.a.a))
    {
      bjko.b("ApkFileDownloadButton_", "onDownloadPause info.progress=" + paramDownloadInfo.f);
      this.a.a.b = 3;
      this.a.a.jdField_a_of_type_Int = paramDownloadInfo.f;
      if (this.a.a.jdField_a_of_type_Long == 0L) {
        this.a.a.jdField_a_of_type_Long = paramDownloadInfo.c;
      }
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.1(this));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localDownloadInfo = (DownloadInfo)paramList.next();
    } while (!this.a.a(localDownloadInfo, this.a.a));
    ApkFileDownloadButton.a(this.a, 1);
    bjko.b("ApkFileDownloadButton_", "onDownloadUpdate info.progress=" + localDownloadInfo.f);
    this.a.a.b = 2;
    this.a.a.jdField_a_of_type_Int = localDownloadInfo.f;
    if (this.a.a.jdField_a_of_type_Long == 0L) {
      this.a.a.jdField_a_of_type_Long = localDownloadInfo.c;
    }
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.6(this));
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (this.a.a(paramDownloadInfo, this.a.a))
    {
      bjko.b("ApkFileDownloadButton_", "onDownloadWait info.progress=" + paramDownloadInfo.f);
      this.a.a.b = 20;
      if (this.a.a.jdField_a_of_type_Long == 0L) {
        this.a.a.jdField_a_of_type_Long = paramDownloadInfo.c;
      }
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.2(this));
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpf
 * JD-Core Version:    0.7.0.1
 */