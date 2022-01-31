import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class anvw
  implements bfoj
{
  anvw(RockDownloaderTask paramRockDownloaderTask, boolean paramBoolean) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "installSucceed: appid=", paramString1, " packageName=", paramString2 });
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo.e == null) || (!paramDownloadInfo.e.equals(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo().getPackageName()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadCancel: info=", paramDownloadInfo });
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getRockDownloadListener().onDownloadCancel(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo());
      this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getRockDownloadListener().onDownloadFinish(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo());
    }
    bfkr.a().b(this);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo.e == null) || (!paramDownloadInfo.e.equals(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo().getPackageName()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadError: info=", paramDownloadInfo, " errorMsg=", paramString, " state=", Integer.valueOf(paramInt2) });
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt1 != 6) {
        break label200;
      }
      this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getRockDownloadListener().onDownloadFail(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo(), alud.a(2131713886), 10010);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getRockDownloadListener().onDownloadFinish(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo());
      paramString = (DownloadInfo)bfkr.a().a().remove(paramDownloadInfo.b);
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "onDownloadError removedDownload=", paramString });
      }
      bfkp.a().a(paramDownloadInfo.b);
      anvu.a(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask, "0x800A1E6");
      bfkr.a().b(this);
      return;
      label200:
      this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getRockDownloadListener().onDownloadFail(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo(), paramString, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo.e == null) || (!paramDownloadInfo.e.equals(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo().getPackageName()))) {
      return;
    }
    anvu.a(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask, paramDownloadInfo, this.jdField_a_of_type_Boolean);
    bfkr.a().b(this);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo.e == null) || (!paramDownloadInfo.e.equals(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo().getPackageName()))) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RockDownloader", 2, new Object[] { "onDownloadPause: info=", paramDownloadInfo });
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localDownloadInfo = (DownloadInfo)paramList.next();
    } while ((localDownloadInfo.e == null) || (!localDownloadInfo.e.equals(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo().getPackageName())));
    this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getRockDownloadListener().onDownloadProceedOn(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo(), localDownloadInfo.f);
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo.e == null) || (!paramDownloadInfo.e.equals(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo().getPackageName()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "onDownloadWait: info=", paramDownloadInfo });
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getRockDownloadListener().onDownloadWait(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo());
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "packageReplaced: appid=", paramString1, " packageName=", paramString2 });
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "uninstallSucceed: appid=", paramString1, " packageName=", paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvw
 * JD-Core Version:    0.7.0.1
 */