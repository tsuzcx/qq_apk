import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class apwb
  implements DownloadListener
{
  apwb(RockDownloaderTask paramRockDownloaderTask, boolean paramBoolean) {}
  
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
    apvz.a(paramDownloadInfo, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask);
    bisa.a().b(this);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo.e == null) || (!paramDownloadInfo.e.equals(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo().getPackageName()))) {
      return;
    }
    apvz.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask);
    bisa.a().b(this);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo.e == null) || (!paramDownloadInfo.e.equals(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask.getDownloadInfo().getPackageName()))) {
      return;
    }
    apvz.a(this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask, paramDownloadInfo, this.jdField_a_of_type_Boolean);
    bisa.a().b(this);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    apvz.a(paramDownloadInfo, this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    apvz.a(paramList, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask);
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    apvz.a(paramDownloadInfo, this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloaderTask, this.jdField_a_of_type_Boolean);
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
 * Qualified Name:     apwb
 * JD-Core Version:    0.7.0.1
 */