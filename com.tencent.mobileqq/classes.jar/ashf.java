import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter.GameNoticeInfoList;
import com.tencent.mobileqq.gamecenter.data.GameNoticeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ashf
  implements ajdh
{
  private ajdj jdField_a_of_type_Ajdj;
  private final GameNoticeInfo jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo;
  
  public ashf(GameNoticeCenter paramGameNoticeCenter, GameNoticeInfo paramGameNoticeInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo = paramGameNoticeInfo;
    QLog.d("GameNoticeCenter", 1, new Object[] { "hide banner at: ", GameNoticeCenter.a(paramGameNoticeCenter, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.endTime), ", mInfo=", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo });
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.bannerType == 1) {
      GameNoticeCenter.a(paramGameNoticeCenter).e("81706").b("205431").d("8").c(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId).h(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.apkChannel).a();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.bannerType != 2) {
      return;
    }
    GameNoticeCenter.a(paramGameNoticeCenter).e("81707").b("205433").d("8").c(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId).h(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.apkChannel).a();
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    QLog.d("GameNoticeCenter", 1, new Object[] { "onClose, ", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo });
    GameNoticeInfo localGameNoticeInfo = GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).getByAppId(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId);
    if (localGameNoticeInfo != null)
    {
      localGameNoticeInfo.shown = true;
      GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).updateDB(localGameNoticeInfo);
    }
    GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter, true);
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.bannerType == 1) {
      GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).e("81706").b("205435").d("20").c(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId).h(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.apkChannel).a();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.bannerType != 2) {
      return;
    }
    GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).e("81707").b("205436").d("20").c(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId).h(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.apkChannel).a();
  }
  
  public void onEnter()
  {
    QLog.d("GameNoticeCenter", 1, new Object[] { "onEnter, ", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo });
    GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.jumpUrl, BaseApplication.getContext());
    GameNoticeInfo localGameNoticeInfo = GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).getByAppId(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId);
    if (localGameNoticeInfo != null)
    {
      localGameNoticeInfo.shown = true;
      GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).updateDB(localGameNoticeInfo);
    }
    GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter, true);
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.bannerType == 1) {
      GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).e("81706").b("205432").d("20").c(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId).h(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.apkChannel).a();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.bannerType != 2) {
      return;
    }
    GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).e("81707").b("205434").d("20").c(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId).h(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.apkChannel).a();
  }
  
  public void onOverride()
  {
    QLog.d("GameNoticeCenter", 1, new Object[] { "onOverride, ", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo });
    if ((GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter) != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.equals(GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo)))
    {
      GameNoticeInfo localGameNoticeInfo = GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).getByAppId(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId);
      if (localGameNoticeInfo != null)
      {
        localGameNoticeInfo.shown = true;
        GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).updateDB(localGameNoticeInfo);
        GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter, false);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.bannerType == 1) {
      GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).e("81706").b("205584").c(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId).h(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.apkChannel).a();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.bannerType != 2) {
      return;
    }
    GameNoticeCenter.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).e("81707").b("205585").c(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.appId).h(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.apkChannel).a();
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeInfo.toString();
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashf
 * JD-Core Version:    0.7.0.1
 */