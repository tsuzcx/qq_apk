import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.1;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.2;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.3;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.4;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aopp
  implements bdld
{
  public aopp(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ("1101070898".equals(paramString1))
    {
      paramString1 = UniformDownloadActivity.a(this.a);
      UniformDownloadActivity.a(this.a, paramString1);
      paramString1 = UniformDownloadActivity.a(this.a, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d(UniformDownloadActivity.a, 2, "tmastUrl=" + paramString1);
      }
      UniformDownloadActivity.a(this.a, paramString1);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "onDownloadCancel " + paramDownloadInfo.e);
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "onDownloadError " + paramDownloadInfo.e);
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "onDownloadFinish " + paramDownloadInfo.e);
    }
    axqy.b(null, "dc00898", "", "", "0X8008F88", "0X8008F88", 1, 0, "", "", "", "");
    this.a.runOnUiThread(new UniformDownloadActivity.10.4(this));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "onDownloadPause " + paramDownloadInfo.e);
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898"))) {
      this.a.runOnUiThread(new UniformDownloadActivity.10.3(this));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d(UniformDownloadActivity.a, 2, "onDownloadUpdate " + localDownloadInfo.e);
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.c.equals("1101070898"))) {
        this.a.runOnUiThread(new UniformDownloadActivity.10.2(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    this.a.runOnUiThread(new UniformDownloadActivity.10.1(this));
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aopp
 * JD-Core Version:    0.7.0.1
 */