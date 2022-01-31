import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

class avhk
  implements bfka
{
  avhk(avgk paramavgk) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    this.a.jdField_a_of_type_Int = 4;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    if (avgk.a(this.a) != null) {
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "install_done", 0, 0, avgk.a(this.a).uin, "", "yes", "android");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    this.a.jdField_a_of_type_Int = 2;
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    this.a.jdField_a_of_type_Int = 3;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if (this.a.jdField_a_of_type_Avlm != null) {
      this.a.jdField_a_of_type_Avlm.a(5);
    }
    if (avgk.a(this.a) != null) {
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_done", 0, 0, avgk.a(this.a).uin, "", "yes", "android");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    this.a.jdField_a_of_type_Int = 2;
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.a.jdField_a_of_type_Int = 1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (DownloadInfo)paramList.get(0);
      Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 2;
      localMessage.arg1 = paramList.f;
      localMessage.sendToTarget();
      if ((paramList.f == 0) && (avgk.a(this.a) != null)) {
        azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_begin", 0, 0, avgk.a(this.a).uin, "", "yes", "android");
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    this.a.jdField_a_of_type_Int = 2;
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhk
 * JD-Core Version:    0.7.0.1
 */