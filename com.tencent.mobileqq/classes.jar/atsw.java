import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class atsw
  extends unp
{
  public atsw(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    QQSettingMsgClearFragment.a(this.a, paramString1, paramString2);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QQSettingMsgClearFragment", 2, "qq onDownloadCancel info = " + paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingMsgClearFragment", 2, "qq onDownloadError errorCode = " + paramInt1 + "errorMsg = " + paramString + ", state = " + paramInt2 + ", info = " + paramDownloadInfo);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    QQSettingMsgClearFragment.a(paramDownloadInfo, "YYB");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingMsgClearFragment", 2, "qq onDownloadPause info = " + paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if ((QLog.isColorLevel()) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        QLog.w("QQSettingMsgClearFragment", 2, "qq onDownloadUpdate progress = " + localDownloadInfo.f + ", url = " + localDownloadInfo.d);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingMsgClearFragment", 2, "qq onDownloadWait info = " + paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingMsgClearFragment", 2, "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsw
 * JD-Core Version:    0.7.0.1
 */